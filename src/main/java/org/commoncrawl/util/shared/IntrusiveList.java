package org.commoncrawl.util.shared;

/*
 *    Copyright 2010 - CommonCrawl Foundation
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import java.util.Iterator;

/**
 * Inheritance based Linked List class
 * 
 * 
 * @author rana
 * 
 */
public class IntrusiveList<ClassType extends IntrusiveList.IntrusiveListElement<ClassType>> implements
		Iterable<ClassType> {

	private ClassType _head = null;
	private ClassType _tail = null;
	private int _itemCount = 0;

	public IntrusiveList() {

	}

	public ClassType getHead() {
		return (ClassType) _head;
	}

	public ClassType getTail() {
		return (ClassType) _tail;
	}

	public int size() {
		return _itemCount;
	}

	public void addHead(ClassType element) {

		element._prev = null;
		element._next = _head;

		if (_head != null) {
			_head.setPrev(element);
		}
		_head = element;
		if (_tail == null)
			_tail = _head;

		++_itemCount;
	}

	public void addTail(ClassType element) {

		element._next = null;
		element.setPrev(_tail);

		if (_tail != null) {
			_tail.setNext(element);
		}

		_tail = element;

		if (_head == null) {
			_head = _tail;
		}
		++_itemCount;
	}

	public void insertAfter(ClassType elementToInsertAfter, ClassType elementToInsert) {
		if (elementToInsertAfter == _tail) {
			_tail = elementToInsert;
			elementToInsert.setNext(null);
		} else {
			elementToInsert.setNext(elementToInsertAfter.getNext());
			elementToInsert.getNext().setPrev(elementToInsert);
		}
		elementToInsertAfter.setNext(elementToInsert);
		elementToInsert.setPrev(elementToInsertAfter);

		++_itemCount;
	}

	public ClassType removeHead() {
		ClassType elementRemoved = _head;
		removeElement(elementRemoved);
		return elementRemoved;
	}

	public ClassType removeTail() {
		ClassType elementRemoved = _tail;
		removeElement(elementRemoved);
		return elementRemoved;
	}

	public void removeElement(ClassType element) {

		if (element == _head) {
			_head = _head.getNext();
			if (_head != null) {
				_head.setPrev(null);
			}
			if (_tail == element) {
				_tail = _head;
			}
		} else if (element == _tail) {
			_tail = _tail.getPrev();
			_tail.setNext(null);
		} else {
			element.getPrev().setNext(element.getNext());
			element.getNext().setPrev(element.getPrev());
		}

		--_itemCount;

		element._next = null;
		element._prev = null;

	}

	public void removeAll() {

		ClassType element = _head;

		while (element != null) {
			ClassType next = element._next;
			element._prev = null;
			element._next = null;
			element = next;
		}
		_head = null;
		_tail = null;
		_itemCount = 0;
	}

	/** remove all elements starting at target element to a new list **/
	public IntrusiveList<ClassType> detach(ClassType targetElement) {

		IntrusiveList<ClassType> newList = new IntrusiveList<ClassType>();

		// set NEW lists' head tail pointers...
		newList._head = targetElement;
		newList._tail = this._tail;

		// adjust THIS list's head / tail pointers ...
		if (targetElement._prev != null) {
			this._tail = targetElement._prev;
			targetElement._prev = null;
			this._tail._next = null;
		} else {
			this._head = null;
			this._tail = null;
		}

		// calculate number of elements in new list...
		int newListItemCount = 0;
		ClassType element = targetElement;
		while (element != null) {
			++newListItemCount;
			element = element._next;
		}
		// set NEW list item count ...
		newList._itemCount = newListItemCount;
		// and adjust THIS list's item cont
		this._itemCount -= newListItemCount;

		return newList;
	}

	/** append all elements from passed in list to THIS list **/
	public void attach(IntrusiveList<ClassType> listToAppendFrom) {

		if (listToAppendFrom.size() != 0) {
			if (this._tail != null) {
				this._tail._next = listToAppendFrom._head;
				listToAppendFrom._head._prev = this._tail;
			} else {
				this._head = listToAppendFrom._head;
			}
			this._tail = listToAppendFrom._tail;
			this._itemCount += listToAppendFrom._itemCount;
		}
		listToAppendFrom._head = null;
		listToAppendFrom._tail = null;
		listToAppendFrom._itemCount = 0;
	}

	public static class IntrusiveListElement<ClassType> {

		ClassType _prev = null;
		ClassType _next = null;

		public IntrusiveListElement() {

		}

		public ClassType getPrev() {
			return _prev;
		}

		public ClassType getNext() {
			return _next;
		}

		public void setPrev(ClassType prev) {
			_prev = prev;
		}

		public void setNext(ClassType next) {
			_next = next;
		}

		ClassType getObject() {
			return (ClassType) this;
		}
	}

	private class IntrusiveListIterator<ClassType extends IntrusiveList.IntrusiveListElement<ClassType>> implements
			Iterator<ClassType> {

		private IntrusiveList<ClassType> _list = null;
		private ClassType _current = null;
		private ClassType _next = null;

		public IntrusiveListIterator() {
			_current = null;
			_next = (ClassType) _head;
		}

		public boolean hasNext() {
			return _next != null;
		}

		public ClassType next() {

			_current = _next;

			if (_next != null) {
				_next = _next.getNext();
			}
			return _current;
		}

		public void remove() {
			_list.removeElement(_current);
			_current = null;
		}

	}

	public Iterator<ClassType> iterator() {
		return new IntrusiveListIterator<ClassType>();
	}
}

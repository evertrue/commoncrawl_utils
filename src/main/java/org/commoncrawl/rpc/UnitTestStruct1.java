// File generated by rpc compiler. Do not edit.

package org.commoncrawl.rpc;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.BitSet;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.record.Buffer;
import org.commoncrawl.util.shared.FlexBuffer;
import org.commoncrawl.util.shared.TextBytes;
import org.commoncrawl.util.shared.MurmurHash;
import org.commoncrawl.util.shared.ImmutableBuffer;
import org.commoncrawl.rpc.BinaryProtocol;
import org.apache.hadoop.util.ReflectionUtils;
import org.apache.hadoop.conf.Configuration;

// Generated File: UnitTestStruct1
public class UnitTestStruct1 extends org.commoncrawl.rpc.RPCStructWithId<UnitTestStruct1> implements Writable {

	// optimized constructor helper 
	public static UnitTestStruct1 newInstance(Configuration conf) {
		return ReflectionUtils.newInstance(UnitTestStruct1.class, conf);
	}

	// Writable Implementation
	public void write(DataOutput out) throws IOException {
		this.serialize(out, new BinaryProtocol());
	}

	public void readFields(DataInput in) throws IOException {
		this.deserialize(in, new BinaryProtocol());
	}

	// Field Constants
	public static final int Field_INTTYPE = 1;
	public static final int Field_LONGTYPE = 2;
	public static final int Field_STRINGTYPE = 3;
	public static final int Field_VECTOROFSTRINGS = 4;
	static final int FieldID_MAX = Field_VECTOROFSTRINGS;

	// Enumerations

	// Enum:EnumeratedValue
	public static final class EnumeratedValue {
		public static final int ONE = 1;
		public static final int TWO = 2;

		public static String toString(int enumValue) {
			switch (enumValue) {
			case 1:
				return "ONE";
			case 2:
				return "TWO";
			default:
				return "";
			}
		}
	}

	// Field Declarations
	private BitSet __validFields = new BitSet(FieldID_MAX + 1);

	private int intType;
	private long longType;
	private TextBytes stringType = new TextBytes();
	private java.util.ArrayList<TextBytes> vectorOfStrings = new java.util.ArrayList<TextBytes>();

	// Default Constructor
	public UnitTestStruct1() {
	}

	// Accessors

	public final boolean isFieldDirty(int fieldId) {
		return __validFields.get(fieldId);
	}

	public final UnitTestStruct1 setFieldDirty(int fieldId) {
		__validFields.set(fieldId);
		return this;
	}

	public final UnitTestStruct1 setFieldClean(int fieldId) {
		__validFields.clear(fieldId);
		return this;
	}

	public int getIntType() {
		return intType;
	}

	public UnitTestStruct1 setIntType(int intType) {
		__validFields.set(Field_INTTYPE);
		this.intType = intType;
		return this;
	}

	public long getLongType() {
		return longType;
	}

	public UnitTestStruct1 setLongType(long longType) {
		__validFields.set(Field_LONGTYPE);
		this.longType = longType;
		return this;
	}

	public TextBytes getStringTypeAsTextBytes() {
		return stringType;
	}

	public String getStringType() {
		return stringType.toString();
	}

	public UnitTestStruct1 setStringType(String stringType) {
		__validFields.set(Field_STRINGTYPE);
		this.stringType.set(stringType);
		return this;
	}

	public java.util.ArrayList<TextBytes> getVectorOfStrings() {
		return vectorOfStrings;
	}

	public UnitTestStruct1 setVectorOfStrings(java.util.ArrayList<TextBytes> vectorOfStrings) {
		__validFields.set(Field_VECTOROFSTRINGS);
		this.vectorOfStrings = vectorOfStrings;
		return this;
	}

	// Object Dirty support 

	public final boolean isObjectDirty() {
		boolean isDirty = !__validFields.isEmpty();
		if (!isDirty) {
			if (!isDirty) {
				isDirty = vectorOfStrings.size() != 0;
			}
		}
		return isDirty;
	}

	// serialize implementation 
	public final void serialize(DataOutput output, BinaryProtocol encoder) throws java.io.IOException {
		encoder.beginFields(output);
		// serialize field:intType
		if (__validFields.get(Field_INTTYPE)) {
			encoder.beginField(output, "intType", Field_INTTYPE);
			encoder.writeInt(output, intType);
		}
		// serialize field:longType
		if (__validFields.get(Field_LONGTYPE)) {
			encoder.beginField(output, "longType", Field_LONGTYPE);
			encoder.writeLong(output, longType);
		}
		// serialize field:stringType
		if (__validFields.get(Field_STRINGTYPE)) {
			encoder.beginField(output, "stringType", Field_STRINGTYPE);
			encoder.writeTextBytes(output, stringType);
		}
		// serialize field:vectorOfStrings
		if (vectorOfStrings.size() != 0) {
			__validFields.set(Field_VECTOROFSTRINGS);
			encoder.beginField(output, "vectorOfStrings", Field_VECTOROFSTRINGS);
			{
				int len1 = vectorOfStrings.size();
				encoder.writeInt(output, len1);
				for (int vidx1 = 0; vidx1 < len1; vidx1++) {
					TextBytes e1 = vectorOfStrings.get(vidx1);
					encoder.writeTextBytes(output, e1);
				}
			}
		} else {
			__validFields.clear(Field_VECTOROFSTRINGS);
		}
		encoder.endFields(output);
	}

	// deserialize implementation 
	public final void deserialize(DataInput input, BinaryProtocol decoder) throws java.io.IOException {
		// clear existing data first  
		clear();

		// reset protocol object to unknown field id enconding mode (for compatibility)
		decoder.pushFieldIdEncodingMode(BinaryProtocol.FIELD_ID_ENCODING_MODE_UNKNOWN);
		// keep reading fields until terminator (-1) is located 
		int fieldId;
		while ((fieldId = decoder.readFieldId(input)) != -1) {
			switch (fieldId) {
			case Field_INTTYPE: {
				__validFields.set(Field_INTTYPE);
				intType = decoder.readInt(input);
			}
				break;
			case Field_LONGTYPE: {
				__validFields.set(Field_LONGTYPE);
				longType = decoder.readLong(input);
			}
				break;
			case Field_STRINGTYPE: {
				__validFields.set(Field_STRINGTYPE);
				decoder.readTextBytes(input, stringType);
			}
				break;
			case Field_VECTOROFSTRINGS: {
				__validFields.set(Field_VECTOROFSTRINGS);
				{
					int itemCount1 = decoder.readInt(input);
					vectorOfStrings = new java.util.ArrayList<TextBytes>();
					for (int i1 = 0; i1 < itemCount1; ++i1) {
						TextBytes e1 = new TextBytes();
						decoder.readTextBytes(input, e1);
						vectorOfStrings.add(e1);
					}
				}
			}
				break;
			}
		}
		// pop extra encoding mode off of stack 
		decoder.popFieldIdEncodingMode();
	}

	// clear implementation 
	public final void clear() {
		super.clear();
		__validFields.clear();
		intType = 0;
		longType = 0;
		stringType.clear();
		vectorOfStrings.clear();
	}

	// equals implementation 
	public final boolean equals(final Object peer_) {
		if (!(peer_ instanceof UnitTestStruct1)) {
			return false;
		}
		if (peer_ == this) {
			return true;
		}
		UnitTestStruct1 peer = (UnitTestStruct1) peer_;
		boolean ret = __validFields.equals(peer.__validFields);
		if (!ret)
			return ret;
		if (__validFields.get(Field_INTTYPE)) {
			ret = (intType == peer.intType);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_LONGTYPE)) {
			ret = (longType == peer.longType);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_STRINGTYPE)) {
			ret = stringType.equals(peer.stringType);
			if (!ret)
				return ret;
		}
		if (vectorOfStrings.size() != 0) {
			ret = vectorOfStrings.equals(peer.vectorOfStrings);
			if (!ret)
				return ret;
		}
		return ret;
	}

	// clone implementation 
	@SuppressWarnings("unchecked")
	public final Object clone() throws CloneNotSupportedException {
		UnitTestStruct1 other = new UnitTestStruct1();
		other.__validFields.or(this.__validFields);
		if (__validFields.get(Field_INTTYPE)) {
			other.intType = this.intType;
		}
		if (__validFields.get(Field_LONGTYPE)) {
			other.longType = this.longType;
		}
		if (__validFields.get(Field_STRINGTYPE)) {
			other.stringType = (TextBytes) this.stringType.clone();
		}
		{
			//Deep Copy Vector
			other.vectorOfStrings = new java.util.ArrayList<TextBytes>();
			int len0 = this.vectorOfStrings.size();
			for (int vidx0 = 0; vidx0 < len0; vidx0++) {
				TextBytes src0 = this.vectorOfStrings.get(vidx0);
				TextBytes tgt0;
				tgt0 = (TextBytes) src0.clone();
				other.vectorOfStrings.add(tgt0);
			}
		}
		return other;
	}

	// merge implementation 
	@SuppressWarnings("unchecked")
	public final void merge(UnitTestStruct1 peer) throws CloneNotSupportedException {
		__validFields.or(peer.__validFields);
		if (peer.__validFields.get(Field_INTTYPE)) {
			this.intType = peer.intType;
		}
		if (peer.__validFields.get(Field_LONGTYPE)) {
			this.longType = peer.longType;
		}
		if (peer.__validFields.get(Field_STRINGTYPE)) {
			this.stringType = (TextBytes) peer.stringType.clone();
		}
		{
			//Deep Copy Vector
			int len0 = peer.vectorOfStrings.size();
			for (int vidx0 = 0; vidx0 < len0; vidx0++) {
				TextBytes src0 = peer.vectorOfStrings.get(vidx0);
				TextBytes tgt0;
				tgt0 = (TextBytes) src0.clone();
				this.vectorOfStrings.add(tgt0);
			}
		}
	}

	// hashCode implementation 
	public final int hashCode() {
		int result = 1;
		result = MurmurHash.hashInt((int) intType, result);
		result = MurmurHash.hashLong(longType, result);
		result = MurmurHash.hash(stringType.getBytes(), stringType.getOffset(), stringType.getLength(), result);
		result = MurmurHash.hashInt(vectorOfStrings.hashCode(), result);
		return result;
	}
}

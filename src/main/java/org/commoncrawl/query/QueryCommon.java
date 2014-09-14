// File generated by rpc compiler. Do not edit.

package org.commoncrawl.query;

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

// Generated File: QueryCommon
public class QueryCommon extends org.commoncrawl.rpc.RPCStruct<QueryCommon> implements Writable {

	// optimized constructor helper 
	public static QueryCommon newInstance(Configuration conf) {
		return ReflectionUtils.newInstance(QueryCommon.class, conf);
	}

	// Writable Implementation
	public void write(DataOutput out) throws IOException {
		this.serialize(out, new BinaryProtocol());
	}

	public void readFields(DataInput in) throws IOException {
		this.deserialize(in, new BinaryProtocol());
	}

	// Field Constants
	public static final int Field_QUERYID = 1;
	public static final int Field_QUERYRESULTPATH = 2;
	public static final int Field_QUERYTEMPPATH = 3;
	public static final int Field_RELEVANTSPLITS = 5;
	static final int FieldID_MAX = Field_RELEVANTSPLITS;

	// Field Declarations
	private BitSet __validFields = new BitSet(FieldID_MAX + 1);

	private long queryId;
	private TextBytes queryResultPath = new TextBytes();
	private TextBytes queryTempPath = new TextBytes();
	private java.util.ArrayList<org.commoncrawl.query.QueryInputSplit> relevantSplits = new java.util.ArrayList<org.commoncrawl.query.QueryInputSplit>();

	// Default Constructor
	public QueryCommon() {
	}

	// Accessors

	public final boolean isFieldDirty(int fieldId) {
		return __validFields.get(fieldId);
	}

	public final QueryCommon setFieldDirty(int fieldId) {
		__validFields.set(fieldId);
		return this;
	}

	public final QueryCommon setFieldClean(int fieldId) {
		__validFields.clear(fieldId);
		return this;
	}

	public long getQueryId() {
		return queryId;
	}

	public QueryCommon setQueryId(long queryId) {
		__validFields.set(Field_QUERYID);
		this.queryId = queryId;
		return this;
	}

	public TextBytes getQueryResultPathAsTextBytes() {
		return queryResultPath;
	}

	public String getQueryResultPath() {
		return queryResultPath.toString();
	}

	public QueryCommon setQueryResultPath(String queryResultPath) {
		__validFields.set(Field_QUERYRESULTPATH);
		this.queryResultPath.set(queryResultPath);
		return this;
	}

	public TextBytes getQueryTempPathAsTextBytes() {
		return queryTempPath;
	}

	public String getQueryTempPath() {
		return queryTempPath.toString();
	}

	public QueryCommon setQueryTempPath(String queryTempPath) {
		__validFields.set(Field_QUERYTEMPPATH);
		this.queryTempPath.set(queryTempPath);
		return this;
	}

	public java.util.ArrayList<org.commoncrawl.query.QueryInputSplit> getRelevantSplits() {
		return relevantSplits;
	}

	public QueryCommon setRelevantSplits(java.util.ArrayList<org.commoncrawl.query.QueryInputSplit> relevantSplits) {
		__validFields.set(Field_RELEVANTSPLITS);
		this.relevantSplits = relevantSplits;
		return this;
	}

	// Object Dirty support 

	public final boolean isObjectDirty() {
		boolean isDirty = !__validFields.isEmpty();
		if (!isDirty) {
			if (!isDirty) {
				isDirty = relevantSplits.size() != 0;
			}
		}
		return isDirty;
	}

	// serialize implementation 
	public final void serialize(DataOutput output, BinaryProtocol encoder) throws java.io.IOException {
		encoder.beginFields(output);
		// serialize field:queryId
		if (__validFields.get(Field_QUERYID)) {
			encoder.beginField(output, "queryId", Field_QUERYID);
			encoder.writeLong(output, queryId);
		}
		// serialize field:queryResultPath
		if (__validFields.get(Field_QUERYRESULTPATH)) {
			encoder.beginField(output, "queryResultPath", Field_QUERYRESULTPATH);
			encoder.writeTextBytes(output, queryResultPath);
		}
		// serialize field:queryTempPath
		if (__validFields.get(Field_QUERYTEMPPATH)) {
			encoder.beginField(output, "queryTempPath", Field_QUERYTEMPPATH);
			encoder.writeTextBytes(output, queryTempPath);
		}
		// serialize field:relevantSplits
		if (relevantSplits.size() != 0) {
			__validFields.set(Field_RELEVANTSPLITS);
			encoder.beginField(output, "relevantSplits", Field_RELEVANTSPLITS);
			{
				int len1 = relevantSplits.size();
				encoder.writeInt(output, len1);
				for (int vidx1 = 0; vidx1 < len1; vidx1++) {
					org.commoncrawl.query.QueryInputSplit e1 = relevantSplits.get(vidx1);
					e1.serialize(output, encoder);
				}
			}
		} else {
			__validFields.clear(Field_RELEVANTSPLITS);
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
			case Field_QUERYID: {
				__validFields.set(Field_QUERYID);
				queryId = decoder.readLong(input);
			}
				break;
			case Field_QUERYRESULTPATH: {
				__validFields.set(Field_QUERYRESULTPATH);
				decoder.readTextBytes(input, queryResultPath);
			}
				break;
			case Field_QUERYTEMPPATH: {
				__validFields.set(Field_QUERYTEMPPATH);
				decoder.readTextBytes(input, queryTempPath);
			}
				break;
			case Field_RELEVANTSPLITS: {
				__validFields.set(Field_RELEVANTSPLITS);
				{
					int itemCount1 = decoder.readInt(input);
					relevantSplits = new java.util.ArrayList<org.commoncrawl.query.QueryInputSplit>();
					for (int i1 = 0; i1 < itemCount1; ++i1) {
						org.commoncrawl.query.QueryInputSplit e1;
						e1 = new org.commoncrawl.query.QueryInputSplit();
						e1.deserialize(input, decoder);
						relevantSplits.add(e1);
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
		__validFields.clear();
		queryId = 0;
		queryResultPath.clear();
		queryTempPath.clear();
		relevantSplits.clear();
	}

	// equals implementation 
	public final boolean equals(final Object peer_) {
		if (!(peer_ instanceof QueryCommon)) {
			return false;
		}
		if (peer_ == this) {
			return true;
		}
		QueryCommon peer = (QueryCommon) peer_;
		boolean ret = __validFields.equals(peer.__validFields);
		if (!ret)
			return ret;
		if (__validFields.get(Field_QUERYID)) {
			ret = (queryId == peer.queryId);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_QUERYRESULTPATH)) {
			ret = queryResultPath.equals(peer.queryResultPath);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_QUERYTEMPPATH)) {
			ret = queryTempPath.equals(peer.queryTempPath);
			if (!ret)
				return ret;
		}
		if (relevantSplits.size() != 0) {
			ret = relevantSplits.equals(peer.relevantSplits);
			if (!ret)
				return ret;
		}
		return ret;
	}

	// clone implementation 
	@SuppressWarnings("unchecked")
	public final Object clone() throws CloneNotSupportedException {
		QueryCommon other = new QueryCommon();
		other.__validFields.or(this.__validFields);
		if (__validFields.get(Field_QUERYID)) {
			other.queryId = this.queryId;
		}
		if (__validFields.get(Field_QUERYRESULTPATH)) {
			other.queryResultPath = (TextBytes) this.queryResultPath.clone();
		}
		if (__validFields.get(Field_QUERYTEMPPATH)) {
			other.queryTempPath = (TextBytes) this.queryTempPath.clone();
		}
		{
			//Deep Copy Vector
			other.relevantSplits = new java.util.ArrayList<org.commoncrawl.query.QueryInputSplit>();
			int len0 = this.relevantSplits.size();
			for (int vidx0 = 0; vidx0 < len0; vidx0++) {
				org.commoncrawl.query.QueryInputSplit src0 = this.relevantSplits.get(vidx0);
				org.commoncrawl.query.QueryInputSplit tgt0;
				tgt0 = (org.commoncrawl.query.QueryInputSplit) src0.clone();
				other.relevantSplits.add(tgt0);
			}
		}
		return other;
	}

	// merge implementation 
	@SuppressWarnings("unchecked")
	public final void merge(QueryCommon peer) throws CloneNotSupportedException {
		__validFields.or(peer.__validFields);
		if (peer.__validFields.get(Field_QUERYID)) {
			this.queryId = peer.queryId;
		}
		if (peer.__validFields.get(Field_QUERYRESULTPATH)) {
			this.queryResultPath = (TextBytes) peer.queryResultPath.clone();
		}
		if (peer.__validFields.get(Field_QUERYTEMPPATH)) {
			this.queryTempPath = (TextBytes) peer.queryTempPath.clone();
		}
		{
			//Deep Copy Vector
			int len0 = peer.relevantSplits.size();
			for (int vidx0 = 0; vidx0 < len0; vidx0++) {
				org.commoncrawl.query.QueryInputSplit src0 = peer.relevantSplits.get(vidx0);
				org.commoncrawl.query.QueryInputSplit tgt0;
				tgt0 = (org.commoncrawl.query.QueryInputSplit) src0.clone();
				this.relevantSplits.add(tgt0);
			}
		}
	}

	// hashCode implementation 
	public final int hashCode() {
		int result = 1;
		result = MurmurHash.hashLong(queryId, result);
		result = MurmurHash.hash(queryResultPath.getBytes(), queryResultPath.getOffset(), queryResultPath.getLength(),
				result);
		result = MurmurHash
				.hash(queryTempPath.getBytes(), queryTempPath.getOffset(), queryTempPath.getLength(), result);
		result = MurmurHash.hashInt(relevantSplits.hashCode(), result);
		return result;
	}
}

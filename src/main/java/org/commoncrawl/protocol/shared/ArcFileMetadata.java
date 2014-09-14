// File generated by rpc compiler. Do not edit.

package org.commoncrawl.protocol.shared;

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

// Generated File: ArcFileMetadata
public class ArcFileMetadata extends org.commoncrawl.rpc.RPCStruct<ArcFileMetadata> implements Writable {

	// optimized constructor helper 
	public static ArcFileMetadata newInstance(Configuration conf) {
		return ReflectionUtils.newInstance(ArcFileMetadata.class, conf);
	}

	// Writable Implementation
	public void write(DataOutput out) throws IOException {
		this.serialize(out, new BinaryProtocol());
	}

	public void readFields(DataInput in) throws IOException {
		this.deserialize(in, new BinaryProtocol());
	}

	// Field Constants
	public static final int Field_ARCFILENAME = 1;
	public static final int Field_DOCURL = 2;
	public static final int Field_ARCFILEOFFSET = 3;
	public static final int Field_ARCFILELENGTH = 4;
	public static final int Field_SOURCEIPADDRESS = 5;
	public static final int Field_CONTENTTYPE = 6;
	public static final int Field_CONTENTLENGTH = 7;
	public static final int Field_CHARSET = 8;
	public static final int Field_SIGNATURE = 9;
	public static final int Field_TEXTSIMHASHVALUE = 10;
	public static final int Field_FLAGS = 12;
	public static final int Field_HTTPRESPONSEFLAGS = 13;
	public static final int Field_HTTPRESULTCODE = 14;
	public static final int Field_DETECTEDCHARSET = 15;
	public static final int Field_JAVACHARSET = 16;
	public static final int Field_METATAGS = 17;
	public static final int Field_TITLETEXT = 18;
	public static final int Field_BASEURL = 20;
	public static final int Field_ANCHORTAGS = 21;
	public static final int Field_HTTPDATE = 22;
	public static final int Field_LASTMODIFIEDTIME = 23;
	public static final int Field_ETAG = 24;
	public static final int Field_MAXAGE = 25;
	public static final int Field_EXPIRES = 26;
	public static final int Field_AGE = 27;
	public static final int Field_CACHECONTROLFLAGS = 28;
	static final int FieldID_MAX = Field_CACHECONTROLFLAGS;

	// Enumerations

	// Enum:Flags
	public static final class Flags {
		public static final int IS_ValidTextType = 1;

		public static String toString(int enumValue) {
			switch (enumValue) {
			case 1:
				return "IS_ValidTextType";
			default:
				return "";
			}
		}
	}

	// Enum:HTTPResponseFlags
	public static final class HTTPResponseFlags {
		public static final int HEADER_MISSING = 1;
		public static final int VERSION_MISSING = 2;
		public static final int VERSION_0_9 = 4;
		public static final int VERSION_1_0 = 8;
		public static final int VERSION_1_1 = 16;
		public static final int ENCODED_IS_GZIP = 32;

		public static String toString(int enumValue) {
			switch (enumValue) {
			case 1:
				return "HEADER_MISSING";
			case 2:
				return "VERSION_MISSING";
			case 4:
				return "VERSION_0_9";
			case 8:
				return "VERSION_1_0";
			case 16:
				return "VERSION_1_1";
			case 32:
				return "ENCODED_IS_GZIP";
			default:
				return "";
			}
		}
	}

	// Enum:CacheControlFlags
	public static final class CacheControlFlags {
		public static final int NO_CACHE = 1;
		public static final int NO_STORE = 2;
		public static final int VARY = 4;
		public static final int MUST_REVALIDATE = 8;
		public static final int PRIVATE = 16;

		public static String toString(int enumValue) {
			switch (enumValue) {
			case 1:
				return "NO_CACHE";
			case 2:
				return "NO_STORE";
			case 4:
				return "VARY";
			case 8:
				return "MUST_REVALIDATE";
			case 16:
				return "PRIVATE";
			default:
				return "";
			}
		}
	}

	// Field Declarations
	private BitSet __validFields = new BitSet(FieldID_MAX + 1);

	private TextBytes arcFileName = new TextBytes();
	private TextBytes docURL = new TextBytes();
	private int arcFileOffset;
	private int arcFileLength;
	private int sourceIPAddress;
	private TextBytes contentType = new TextBytes();
	private int contentLength;
	private TextBytes charset = new TextBytes();
	private FlexBuffer signature = new FlexBuffer();
	private long textSimHashValue;
	private byte flags;
	private byte httpResponseFlags;
	private int httpResultCode;
	private TextBytes detectedCharset = new TextBytes();
	private TextBytes javaCharset = new TextBytes();
	private org.commoncrawl.protocol.shared.HTMLMetaTags metaTags = new org.commoncrawl.protocol.shared.HTMLMetaTags();
	private TextBytes titleText = new TextBytes();
	private TextBytes baseURL = new TextBytes();
	private TextBytes anchorTags = new TextBytes();
	private long httpDate;
	private long lastModifiedTime;
	private TextBytes eTag = new TextBytes();
	private long maxAge;
	private long expires;
	private long age;
	private byte cacheControlFlags;

	// Default Constructor
	public ArcFileMetadata() {
	}

	// Accessors

	public final boolean isFieldDirty(int fieldId) {
		return __validFields.get(fieldId);
	}

	public final ArcFileMetadata setFieldDirty(int fieldId) {
		__validFields.set(fieldId);
		return this;
	}

	public final ArcFileMetadata setFieldClean(int fieldId) {
		__validFields.clear(fieldId);
		return this;
	}

	public TextBytes getArcFileNameAsTextBytes() {
		return arcFileName;
	}

	public String getArcFileName() {
		return arcFileName.toString();
	}

	public ArcFileMetadata setArcFileName(String arcFileName) {
		__validFields.set(Field_ARCFILENAME);
		this.arcFileName.set(arcFileName);
		return this;
	}

	public TextBytes getDocURLAsTextBytes() {
		return docURL;
	}

	public String getDocURL() {
		return docURL.toString();
	}

	public ArcFileMetadata setDocURL(String docURL) {
		__validFields.set(Field_DOCURL);
		this.docURL.set(docURL);
		return this;
	}

	public int getArcFileOffset() {
		return arcFileOffset;
	}

	public ArcFileMetadata setArcFileOffset(int arcFileOffset) {
		__validFields.set(Field_ARCFILEOFFSET);
		this.arcFileOffset = arcFileOffset;
		return this;
	}

	public int getArcFileLength() {
		return arcFileLength;
	}

	public ArcFileMetadata setArcFileLength(int arcFileLength) {
		__validFields.set(Field_ARCFILELENGTH);
		this.arcFileLength = arcFileLength;
		return this;
	}

	public int getSourceIPAddress() {
		return sourceIPAddress;
	}

	public ArcFileMetadata setSourceIPAddress(int sourceIPAddress) {
		__validFields.set(Field_SOURCEIPADDRESS);
		this.sourceIPAddress = sourceIPAddress;
		return this;
	}

	public TextBytes getContentTypeAsTextBytes() {
		return contentType;
	}

	public String getContentType() {
		return contentType.toString();
	}

	public ArcFileMetadata setContentType(String contentType) {
		__validFields.set(Field_CONTENTTYPE);
		this.contentType.set(contentType);
		return this;
	}

	public int getContentLength() {
		return contentLength;
	}

	public ArcFileMetadata setContentLength(int contentLength) {
		__validFields.set(Field_CONTENTLENGTH);
		this.contentLength = contentLength;
		return this;
	}

	public TextBytes getCharsetAsTextBytes() {
		return charset;
	}

	public String getCharset() {
		return charset.toString();
	}

	public ArcFileMetadata setCharset(String charset) {
		__validFields.set(Field_CHARSET);
		this.charset.set(charset);
		return this;
	}

	public ImmutableBuffer getSignature() {
		return new ImmutableBuffer(signature);
	}

	public ArcFileMetadata setSignature(FlexBuffer signature) {
		__validFields.set(Field_SIGNATURE);
		this.signature = signature;
		return this;
	}

	public ArcFileMetadata setSignature(Buffer signature, boolean shared) {
		__validFields.set(Field_SIGNATURE);
		this.signature = new FlexBuffer(signature.get(), 0, signature.getCount(), shared);
		return this;
	}

	public long getTextSimHashValue() {
		return textSimHashValue;
	}

	public ArcFileMetadata setTextSimHashValue(long textSimHashValue) {
		__validFields.set(Field_TEXTSIMHASHVALUE);
		this.textSimHashValue = textSimHashValue;
		return this;
	}

	public byte getFlags() {
		return flags;
	}

	public ArcFileMetadata setFlags(byte flags) {
		__validFields.set(Field_FLAGS);
		this.flags = flags;
		return this;
	}

	public byte getHttpResponseFlags() {
		return httpResponseFlags;
	}

	public ArcFileMetadata setHttpResponseFlags(byte httpResponseFlags) {
		__validFields.set(Field_HTTPRESPONSEFLAGS);
		this.httpResponseFlags = httpResponseFlags;
		return this;
	}

	public int getHttpResultCode() {
		return httpResultCode;
	}

	public ArcFileMetadata setHttpResultCode(int httpResultCode) {
		__validFields.set(Field_HTTPRESULTCODE);
		this.httpResultCode = httpResultCode;
		return this;
	}

	public TextBytes getDetectedCharsetAsTextBytes() {
		return detectedCharset;
	}

	public String getDetectedCharset() {
		return detectedCharset.toString();
	}

	public ArcFileMetadata setDetectedCharset(String detectedCharset) {
		__validFields.set(Field_DETECTEDCHARSET);
		this.detectedCharset.set(detectedCharset);
		return this;
	}

	public TextBytes getJavaCharsetAsTextBytes() {
		return javaCharset;
	}

	public String getJavaCharset() {
		return javaCharset.toString();
	}

	public ArcFileMetadata setJavaCharset(String javaCharset) {
		__validFields.set(Field_JAVACHARSET);
		this.javaCharset.set(javaCharset);
		return this;
	}

	public org.commoncrawl.protocol.shared.HTMLMetaTags getMetaTags() {
		return metaTags;
	}

	public ArcFileMetadata setMetaTags(org.commoncrawl.protocol.shared.HTMLMetaTags metaTags) {
		__validFields.set(Field_METATAGS);
		this.metaTags = metaTags;
		return this;
	}

	public TextBytes getTitleTextAsTextBytes() {
		return titleText;
	}

	public String getTitleText() {
		return titleText.toString();
	}

	public ArcFileMetadata setTitleText(String titleText) {
		__validFields.set(Field_TITLETEXT);
		this.titleText.set(titleText);
		return this;
	}

	public TextBytes getBaseURLAsTextBytes() {
		return baseURL;
	}

	public String getBaseURL() {
		return baseURL.toString();
	}

	public ArcFileMetadata setBaseURL(String baseURL) {
		__validFields.set(Field_BASEURL);
		this.baseURL.set(baseURL);
		return this;
	}

	public TextBytes getAnchorTagsAsTextBytes() {
		return anchorTags;
	}

	public String getAnchorTags() {
		return anchorTags.toString();
	}

	public ArcFileMetadata setAnchorTags(String anchorTags) {
		__validFields.set(Field_ANCHORTAGS);
		this.anchorTags.set(anchorTags);
		return this;
	}

	public long getHttpDate() {
		return httpDate;
	}

	public ArcFileMetadata setHttpDate(long httpDate) {
		__validFields.set(Field_HTTPDATE);
		this.httpDate = httpDate;
		return this;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public ArcFileMetadata setLastModifiedTime(long lastModifiedTime) {
		__validFields.set(Field_LASTMODIFIEDTIME);
		this.lastModifiedTime = lastModifiedTime;
		return this;
	}

	public TextBytes getETagAsTextBytes() {
		return eTag;
	}

	public String getETag() {
		return eTag.toString();
	}

	public ArcFileMetadata setETag(String eTag) {
		__validFields.set(Field_ETAG);
		this.eTag.set(eTag);
		return this;
	}

	public long getMaxAge() {
		return maxAge;
	}

	public ArcFileMetadata setMaxAge(long maxAge) {
		__validFields.set(Field_MAXAGE);
		this.maxAge = maxAge;
		return this;
	}

	public long getExpires() {
		return expires;
	}

	public ArcFileMetadata setExpires(long expires) {
		__validFields.set(Field_EXPIRES);
		this.expires = expires;
		return this;
	}

	public long getAge() {
		return age;
	}

	public ArcFileMetadata setAge(long age) {
		__validFields.set(Field_AGE);
		this.age = age;
		return this;
	}

	public byte getCacheControlFlags() {
		return cacheControlFlags;
	}

	public ArcFileMetadata setCacheControlFlags(byte cacheControlFlags) {
		__validFields.set(Field_CACHECONTROLFLAGS);
		this.cacheControlFlags = cacheControlFlags;
		return this;
	}

	// Object Dirty support 

	public final boolean isObjectDirty() {
		boolean isDirty = !__validFields.isEmpty();
		if (!isDirty) {
			if (!isDirty) {
				isDirty = metaTags.isObjectDirty();
			}
		}
		return isDirty;
	}

	// serialize implementation 
	public final void serialize(DataOutput output, BinaryProtocol encoder) throws java.io.IOException {
		encoder.beginFields(output);
		// serialize field:arcFileName
		if (__validFields.get(Field_ARCFILENAME)) {
			encoder.beginField(output, "arcFileName", Field_ARCFILENAME);
			encoder.writeTextBytes(output, arcFileName);
		}
		// serialize field:docURL
		if (__validFields.get(Field_DOCURL)) {
			encoder.beginField(output, "docURL", Field_DOCURL);
			encoder.writeTextBytes(output, docURL);
		}
		// serialize field:arcFileOffset
		if (__validFields.get(Field_ARCFILEOFFSET)) {
			encoder.beginField(output, "arcFileOffset", Field_ARCFILEOFFSET);
			encoder.writeVInt(output, arcFileOffset);
		}
		// serialize field:arcFileLength
		if (__validFields.get(Field_ARCFILELENGTH)) {
			encoder.beginField(output, "arcFileLength", Field_ARCFILELENGTH);
			encoder.writeVInt(output, arcFileLength);
		}
		// serialize field:sourceIPAddress
		if (__validFields.get(Field_SOURCEIPADDRESS)) {
			encoder.beginField(output, "sourceIPAddress", Field_SOURCEIPADDRESS);
			encoder.writeInt(output, sourceIPAddress);
		}
		// serialize field:contentType
		if (__validFields.get(Field_CONTENTTYPE)) {
			encoder.beginField(output, "contentType", Field_CONTENTTYPE);
			encoder.writeTextBytes(output, contentType);
		}
		// serialize field:contentLength
		if (__validFields.get(Field_CONTENTLENGTH)) {
			encoder.beginField(output, "contentLength", Field_CONTENTLENGTH);
			encoder.writeVInt(output, contentLength);
		}
		// serialize field:charset
		if (__validFields.get(Field_CHARSET)) {
			encoder.beginField(output, "charset", Field_CHARSET);
			encoder.writeTextBytes(output, charset);
		}
		// serialize field:signature
		if (__validFields.get(Field_SIGNATURE)) {
			encoder.beginField(output, "signature", Field_SIGNATURE);
			encoder.writeFlexBuffer(output, signature);
		}
		// serialize field:textSimHashValue
		if (__validFields.get(Field_TEXTSIMHASHVALUE)) {
			encoder.beginField(output, "textSimHashValue", Field_TEXTSIMHASHVALUE);
			encoder.writeLong(output, textSimHashValue);
		}
		// serialize field:flags
		if (__validFields.get(Field_FLAGS)) {
			encoder.beginField(output, "flags", Field_FLAGS);
			encoder.writeByte(output, flags);
		}
		// serialize field:httpResponseFlags
		if (__validFields.get(Field_HTTPRESPONSEFLAGS)) {
			encoder.beginField(output, "httpResponseFlags", Field_HTTPRESPONSEFLAGS);
			encoder.writeByte(output, httpResponseFlags);
		}
		// serialize field:httpResultCode
		if (__validFields.get(Field_HTTPRESULTCODE)) {
			encoder.beginField(output, "httpResultCode", Field_HTTPRESULTCODE);
			encoder.writeVInt(output, httpResultCode);
		}
		// serialize field:detectedCharset
		if (__validFields.get(Field_DETECTEDCHARSET)) {
			encoder.beginField(output, "detectedCharset", Field_DETECTEDCHARSET);
			encoder.writeTextBytes(output, detectedCharset);
		}
		// serialize field:javaCharset
		if (__validFields.get(Field_JAVACHARSET)) {
			encoder.beginField(output, "javaCharset", Field_JAVACHARSET);
			encoder.writeTextBytes(output, javaCharset);
		}
		// serialize field:metaTags
		if (metaTags.isObjectDirty()) {
			__validFields.set(Field_METATAGS);
			encoder.beginField(output, "metaTags", Field_METATAGS);
			metaTags.serialize(output, encoder);
		} else {
			__validFields.clear(Field_METATAGS);
		}
		// serialize field:titleText
		if (__validFields.get(Field_TITLETEXT)) {
			encoder.beginField(output, "titleText", Field_TITLETEXT);
			encoder.writeTextBytes(output, titleText);
		}
		// serialize field:baseURL
		if (__validFields.get(Field_BASEURL)) {
			encoder.beginField(output, "baseURL", Field_BASEURL);
			encoder.writeTextBytes(output, baseURL);
		}
		// serialize field:anchorTags
		if (__validFields.get(Field_ANCHORTAGS)) {
			encoder.beginField(output, "anchorTags", Field_ANCHORTAGS);
			encoder.writeTextBytes(output, anchorTags);
		}
		// serialize field:httpDate
		if (__validFields.get(Field_HTTPDATE)) {
			encoder.beginField(output, "httpDate", Field_HTTPDATE);
			encoder.writeVLong(output, httpDate);
		}
		// serialize field:lastModifiedTime
		if (__validFields.get(Field_LASTMODIFIEDTIME)) {
			encoder.beginField(output, "lastModifiedTime", Field_LASTMODIFIEDTIME);
			encoder.writeVLong(output, lastModifiedTime);
		}
		// serialize field:eTag
		if (__validFields.get(Field_ETAG)) {
			encoder.beginField(output, "eTag", Field_ETAG);
			encoder.writeTextBytes(output, eTag);
		}
		// serialize field:maxAge
		if (__validFields.get(Field_MAXAGE)) {
			encoder.beginField(output, "maxAge", Field_MAXAGE);
			encoder.writeVLong(output, maxAge);
		}
		// serialize field:expires
		if (__validFields.get(Field_EXPIRES)) {
			encoder.beginField(output, "expires", Field_EXPIRES);
			encoder.writeVLong(output, expires);
		}
		// serialize field:age
		if (__validFields.get(Field_AGE)) {
			encoder.beginField(output, "age", Field_AGE);
			encoder.writeVLong(output, age);
		}
		// serialize field:cacheControlFlags
		if (__validFields.get(Field_CACHECONTROLFLAGS)) {
			encoder.beginField(output, "cacheControlFlags", Field_CACHECONTROLFLAGS);
			encoder.writeByte(output, cacheControlFlags);
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
			case Field_ARCFILENAME: {
				__validFields.set(Field_ARCFILENAME);
				decoder.readTextBytes(input, arcFileName);
			}
				break;
			case Field_DOCURL: {
				__validFields.set(Field_DOCURL);
				decoder.readTextBytes(input, docURL);
			}
				break;
			case Field_ARCFILEOFFSET: {
				__validFields.set(Field_ARCFILEOFFSET);
				arcFileOffset = decoder.readVInt(input);
			}
				break;
			case Field_ARCFILELENGTH: {
				__validFields.set(Field_ARCFILELENGTH);
				arcFileLength = decoder.readVInt(input);
			}
				break;
			case Field_SOURCEIPADDRESS: {
				__validFields.set(Field_SOURCEIPADDRESS);
				sourceIPAddress = decoder.readInt(input);
			}
				break;
			case Field_CONTENTTYPE: {
				__validFields.set(Field_CONTENTTYPE);
				decoder.readTextBytes(input, contentType);
			}
				break;
			case Field_CONTENTLENGTH: {
				__validFields.set(Field_CONTENTLENGTH);
				contentLength = decoder.readVInt(input);
			}
				break;
			case Field_CHARSET: {
				__validFields.set(Field_CHARSET);
				decoder.readTextBytes(input, charset);
			}
				break;
			case Field_SIGNATURE: {
				__validFields.set(Field_SIGNATURE);
				decoder.readFlexBuffer(input, signature);
			}
				break;
			case Field_TEXTSIMHASHVALUE: {
				__validFields.set(Field_TEXTSIMHASHVALUE);
				textSimHashValue = decoder.readLong(input);
			}
				break;
			case Field_FLAGS: {
				__validFields.set(Field_FLAGS);
				flags = decoder.readByte(input);
			}
				break;
			case Field_HTTPRESPONSEFLAGS: {
				__validFields.set(Field_HTTPRESPONSEFLAGS);
				httpResponseFlags = decoder.readByte(input);
			}
				break;
			case Field_HTTPRESULTCODE: {
				__validFields.set(Field_HTTPRESULTCODE);
				httpResultCode = decoder.readVInt(input);
			}
				break;
			case Field_DETECTEDCHARSET: {
				__validFields.set(Field_DETECTEDCHARSET);
				decoder.readTextBytes(input, detectedCharset);
			}
				break;
			case Field_JAVACHARSET: {
				__validFields.set(Field_JAVACHARSET);
				decoder.readTextBytes(input, javaCharset);
			}
				break;
			case Field_METATAGS: {
				__validFields.set(Field_METATAGS);
				metaTags = new org.commoncrawl.protocol.shared.HTMLMetaTags();
				metaTags.deserialize(input, decoder);
			}
				break;
			case Field_TITLETEXT: {
				__validFields.set(Field_TITLETEXT);
				decoder.readTextBytes(input, titleText);
			}
				break;
			case Field_BASEURL: {
				__validFields.set(Field_BASEURL);
				decoder.readTextBytes(input, baseURL);
			}
				break;
			case Field_ANCHORTAGS: {
				__validFields.set(Field_ANCHORTAGS);
				decoder.readTextBytes(input, anchorTags);
			}
				break;
			case Field_HTTPDATE: {
				__validFields.set(Field_HTTPDATE);
				httpDate = decoder.readVLong(input);
			}
				break;
			case Field_LASTMODIFIEDTIME: {
				__validFields.set(Field_LASTMODIFIEDTIME);
				lastModifiedTime = decoder.readVLong(input);
			}
				break;
			case Field_ETAG: {
				__validFields.set(Field_ETAG);
				decoder.readTextBytes(input, eTag);
			}
				break;
			case Field_MAXAGE: {
				__validFields.set(Field_MAXAGE);
				maxAge = decoder.readVLong(input);
			}
				break;
			case Field_EXPIRES: {
				__validFields.set(Field_EXPIRES);
				expires = decoder.readVLong(input);
			}
				break;
			case Field_AGE: {
				__validFields.set(Field_AGE);
				age = decoder.readVLong(input);
			}
				break;
			case Field_CACHECONTROLFLAGS: {
				__validFields.set(Field_CACHECONTROLFLAGS);
				cacheControlFlags = decoder.readByte(input);
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
		arcFileName.clear();
		docURL.clear();
		arcFileOffset = 0;
		arcFileLength = 0;
		sourceIPAddress = 0;
		contentType.clear();
		contentLength = 0;
		charset.clear();
		signature.reset();
		textSimHashValue = 0;
		flags = 0;
		httpResponseFlags = 0;
		httpResultCode = 0;
		detectedCharset.clear();
		javaCharset.clear();
		metaTags.clear();
		titleText.clear();
		baseURL.clear();
		anchorTags.clear();
		httpDate = 0;
		lastModifiedTime = 0;
		eTag.clear();
		maxAge = 0;
		expires = 0;
		age = 0;
		cacheControlFlags = 0;
	}

	// equals implementation 
	public final boolean equals(final Object peer_) {
		if (!(peer_ instanceof ArcFileMetadata)) {
			return false;
		}
		if (peer_ == this) {
			return true;
		}
		ArcFileMetadata peer = (ArcFileMetadata) peer_;
		boolean ret = __validFields.equals(peer.__validFields);
		if (!ret)
			return ret;
		if (__validFields.get(Field_ARCFILENAME)) {
			ret = arcFileName.equals(peer.arcFileName);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_DOCURL)) {
			ret = docURL.equals(peer.docURL);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_ARCFILEOFFSET)) {
			ret = (arcFileOffset == peer.arcFileOffset);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_ARCFILELENGTH)) {
			ret = (arcFileLength == peer.arcFileLength);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_SOURCEIPADDRESS)) {
			ret = (sourceIPAddress == peer.sourceIPAddress);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_CONTENTTYPE)) {
			ret = contentType.equals(peer.contentType);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_CONTENTLENGTH)) {
			ret = (contentLength == peer.contentLength);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_CHARSET)) {
			ret = charset.equals(peer.charset);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_SIGNATURE)) {
			ret = signature.equals(peer.signature);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_TEXTSIMHASHVALUE)) {
			ret = (textSimHashValue == peer.textSimHashValue);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_FLAGS)) {
			ret = (flags == peer.flags);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_HTTPRESPONSEFLAGS)) {
			ret = (httpResponseFlags == peer.httpResponseFlags);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_HTTPRESULTCODE)) {
			ret = (httpResultCode == peer.httpResultCode);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_DETECTEDCHARSET)) {
			ret = detectedCharset.equals(peer.detectedCharset);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_JAVACHARSET)) {
			ret = javaCharset.equals(peer.javaCharset);
			if (!ret)
				return ret;
		}
		if (metaTags.isObjectDirty()) {
			ret = metaTags.equals(peer.metaTags);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_TITLETEXT)) {
			ret = titleText.equals(peer.titleText);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_BASEURL)) {
			ret = baseURL.equals(peer.baseURL);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_ANCHORTAGS)) {
			ret = anchorTags.equals(peer.anchorTags);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_HTTPDATE)) {
			ret = (httpDate == peer.httpDate);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_LASTMODIFIEDTIME)) {
			ret = (lastModifiedTime == peer.lastModifiedTime);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_ETAG)) {
			ret = eTag.equals(peer.eTag);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_MAXAGE)) {
			ret = (maxAge == peer.maxAge);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_EXPIRES)) {
			ret = (expires == peer.expires);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_AGE)) {
			ret = (age == peer.age);
			if (!ret)
				return ret;
		}
		if (__validFields.get(Field_CACHECONTROLFLAGS)) {
			ret = (cacheControlFlags == peer.cacheControlFlags);
			if (!ret)
				return ret;
		}
		return ret;
	}

	// clone implementation 
	@SuppressWarnings("unchecked")
	public final Object clone() throws CloneNotSupportedException {
		ArcFileMetadata other = new ArcFileMetadata();
		other.__validFields.or(this.__validFields);
		if (__validFields.get(Field_ARCFILENAME)) {
			other.arcFileName = (TextBytes) this.arcFileName.clone();
		}
		if (__validFields.get(Field_DOCURL)) {
			other.docURL = (TextBytes) this.docURL.clone();
		}
		if (__validFields.get(Field_ARCFILEOFFSET)) {
			other.arcFileOffset = this.arcFileOffset;
		}
		if (__validFields.get(Field_ARCFILELENGTH)) {
			other.arcFileLength = this.arcFileLength;
		}
		if (__validFields.get(Field_SOURCEIPADDRESS)) {
			other.sourceIPAddress = this.sourceIPAddress;
		}
		if (__validFields.get(Field_CONTENTTYPE)) {
			other.contentType = (TextBytes) this.contentType.clone();
		}
		if (__validFields.get(Field_CONTENTLENGTH)) {
			other.contentLength = this.contentLength;
		}
		if (__validFields.get(Field_CHARSET)) {
			other.charset = (TextBytes) this.charset.clone();
		}
		if (__validFields.get(Field_SIGNATURE)) {
			other.signature = (FlexBuffer) this.signature.clone();
		}
		if (__validFields.get(Field_TEXTSIMHASHVALUE)) {
			other.textSimHashValue = this.textSimHashValue;
		}
		if (__validFields.get(Field_FLAGS)) {
			other.flags = this.flags;
		}
		if (__validFields.get(Field_HTTPRESPONSEFLAGS)) {
			other.httpResponseFlags = this.httpResponseFlags;
		}
		if (__validFields.get(Field_HTTPRESULTCODE)) {
			other.httpResultCode = this.httpResultCode;
		}
		if (__validFields.get(Field_DETECTEDCHARSET)) {
			other.detectedCharset = (TextBytes) this.detectedCharset.clone();
		}
		if (__validFields.get(Field_JAVACHARSET)) {
			other.javaCharset = (TextBytes) this.javaCharset.clone();
		}
		{
			other.metaTags = (org.commoncrawl.protocol.shared.HTMLMetaTags) this.metaTags.clone();
		}
		if (__validFields.get(Field_TITLETEXT)) {
			other.titleText = (TextBytes) this.titleText.clone();
		}
		if (__validFields.get(Field_BASEURL)) {
			other.baseURL = (TextBytes) this.baseURL.clone();
		}
		if (__validFields.get(Field_ANCHORTAGS)) {
			other.anchorTags = (TextBytes) this.anchorTags.clone();
		}
		if (__validFields.get(Field_HTTPDATE)) {
			other.httpDate = this.httpDate;
		}
		if (__validFields.get(Field_LASTMODIFIEDTIME)) {
			other.lastModifiedTime = this.lastModifiedTime;
		}
		if (__validFields.get(Field_ETAG)) {
			other.eTag = (TextBytes) this.eTag.clone();
		}
		if (__validFields.get(Field_MAXAGE)) {
			other.maxAge = this.maxAge;
		}
		if (__validFields.get(Field_EXPIRES)) {
			other.expires = this.expires;
		}
		if (__validFields.get(Field_AGE)) {
			other.age = this.age;
		}
		if (__validFields.get(Field_CACHECONTROLFLAGS)) {
			other.cacheControlFlags = this.cacheControlFlags;
		}
		return other;
	}

	// merge implementation 
	@SuppressWarnings("unchecked")
	public final void merge(ArcFileMetadata peer) throws CloneNotSupportedException {
		__validFields.or(peer.__validFields);
		if (peer.__validFields.get(Field_ARCFILENAME)) {
			this.arcFileName = (TextBytes) peer.arcFileName.clone();
		}
		if (peer.__validFields.get(Field_DOCURL)) {
			this.docURL = (TextBytes) peer.docURL.clone();
		}
		if (peer.__validFields.get(Field_ARCFILEOFFSET)) {
			this.arcFileOffset = peer.arcFileOffset;
		}
		if (peer.__validFields.get(Field_ARCFILELENGTH)) {
			this.arcFileLength = peer.arcFileLength;
		}
		if (peer.__validFields.get(Field_SOURCEIPADDRESS)) {
			this.sourceIPAddress = peer.sourceIPAddress;
		}
		if (peer.__validFields.get(Field_CONTENTTYPE)) {
			this.contentType = (TextBytes) peer.contentType.clone();
		}
		if (peer.__validFields.get(Field_CONTENTLENGTH)) {
			this.contentLength = peer.contentLength;
		}
		if (peer.__validFields.get(Field_CHARSET)) {
			this.charset = (TextBytes) peer.charset.clone();
		}
		if (peer.__validFields.get(Field_SIGNATURE)) {
			this.signature = (FlexBuffer) peer.signature.clone();
		}
		if (peer.__validFields.get(Field_TEXTSIMHASHVALUE)) {
			this.textSimHashValue = peer.textSimHashValue;
		}
		if (peer.__validFields.get(Field_FLAGS)) {
			this.flags = peer.flags;
		}
		if (peer.__validFields.get(Field_HTTPRESPONSEFLAGS)) {
			this.httpResponseFlags = peer.httpResponseFlags;
		}
		if (peer.__validFields.get(Field_HTTPRESULTCODE)) {
			this.httpResultCode = peer.httpResultCode;
		}
		if (peer.__validFields.get(Field_DETECTEDCHARSET)) {
			this.detectedCharset = (TextBytes) peer.detectedCharset.clone();
		}
		if (peer.__validFields.get(Field_JAVACHARSET)) {
			this.javaCharset = (TextBytes) peer.javaCharset.clone();
		}
		{
			this.metaTags.merge(peer.metaTags);
		}
		if (peer.__validFields.get(Field_TITLETEXT)) {
			this.titleText = (TextBytes) peer.titleText.clone();
		}
		if (peer.__validFields.get(Field_BASEURL)) {
			this.baseURL = (TextBytes) peer.baseURL.clone();
		}
		if (peer.__validFields.get(Field_ANCHORTAGS)) {
			this.anchorTags = (TextBytes) peer.anchorTags.clone();
		}
		if (peer.__validFields.get(Field_HTTPDATE)) {
			this.httpDate = peer.httpDate;
		}
		if (peer.__validFields.get(Field_LASTMODIFIEDTIME)) {
			this.lastModifiedTime = peer.lastModifiedTime;
		}
		if (peer.__validFields.get(Field_ETAG)) {
			this.eTag = (TextBytes) peer.eTag.clone();
		}
		if (peer.__validFields.get(Field_MAXAGE)) {
			this.maxAge = peer.maxAge;
		}
		if (peer.__validFields.get(Field_EXPIRES)) {
			this.expires = peer.expires;
		}
		if (peer.__validFields.get(Field_AGE)) {
			this.age = peer.age;
		}
		if (peer.__validFields.get(Field_CACHECONTROLFLAGS)) {
			this.cacheControlFlags = peer.cacheControlFlags;
		}
	}

	// hashCode implementation 
	public final int hashCode() {
		int result = 1;
		result = MurmurHash.hash(arcFileName.getBytes(), arcFileName.getOffset(), arcFileName.getLength(), result);
		result = MurmurHash.hash(docURL.getBytes(), docURL.getOffset(), docURL.getLength(), result);
		result = MurmurHash.hashInt((int) arcFileOffset, result);
		result = MurmurHash.hashInt((int) arcFileLength, result);
		result = MurmurHash.hashInt((int) sourceIPAddress, result);
		result = MurmurHash.hash(contentType.getBytes(), contentType.getOffset(), contentType.getLength(), result);
		result = MurmurHash.hashInt((int) contentLength, result);
		result = MurmurHash.hash(charset.getBytes(), charset.getOffset(), charset.getLength(), result);
		result = MurmurHash.hash(signature.get(), signature.getOffset(), signature.getCount(), result);
		result = MurmurHash.hashLong(textSimHashValue, result);
		result = MurmurHash.hashInt((int) flags, result);
		result = MurmurHash.hashInt((int) httpResponseFlags, result);
		result = MurmurHash.hashInt((int) httpResultCode, result);
		result = MurmurHash.hash(detectedCharset.getBytes(), detectedCharset.getOffset(), detectedCharset.getLength(),
				result);
		result = MurmurHash.hash(javaCharset.getBytes(), javaCharset.getOffset(), javaCharset.getLength(), result);
		result = MurmurHash.hashInt(metaTags.hashCode(), result);
		result = MurmurHash.hash(titleText.getBytes(), titleText.getOffset(), titleText.getLength(), result);
		result = MurmurHash.hash(baseURL.getBytes(), baseURL.getOffset(), baseURL.getLength(), result);
		result = MurmurHash.hash(anchorTags.getBytes(), anchorTags.getOffset(), anchorTags.getLength(), result);
		result = MurmurHash.hashLong(httpDate, result);
		result = MurmurHash.hashLong(lastModifiedTime, result);
		result = MurmurHash.hash(eTag.getBytes(), eTag.getOffset(), eTag.getLength(), result);
		result = MurmurHash.hashLong(maxAge, result);
		result = MurmurHash.hashLong(expires, result);
		result = MurmurHash.hashLong(age, result);
		result = MurmurHash.hashInt((int) cacheControlFlags, result);
		return result;
	}
}

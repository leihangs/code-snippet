/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.code.rpc.api.sync;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** applicationId:应用ID;originHost:发送方的hostname或者ip地址;requestId:请求Id */
@org.apache.avro.specific.AvroGenerated
public class Header extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7656303590214248073L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Header\",\"namespace\":\"com.code.rpc.api.sync\",\"doc\":\"applicationId:应用ID;originHost:发送方的hostname或者ip地址;requestId:请求Id\",\"fields\":[{\"name\":\"applicationId\",\"type\":\"string\"},{\"name\":\"originHost\",\"type\":\"string\"},{\"name\":\"requestId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence applicationId;
  @Deprecated public java.lang.CharSequence originHost;
  @Deprecated public java.lang.CharSequence requestId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Header() {}

  /**
   * All-args constructor.
   * @param applicationId The new value for applicationId
   * @param originHost The new value for originHost
   * @param requestId The new value for requestId
   */
  public Header(java.lang.CharSequence applicationId, java.lang.CharSequence originHost, java.lang.CharSequence requestId) {
    this.applicationId = applicationId;
    this.originHost = originHost;
    this.requestId = requestId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return applicationId;
    case 1: return originHost;
    case 2: return requestId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: applicationId = (java.lang.CharSequence)value$; break;
    case 1: originHost = (java.lang.CharSequence)value$; break;
    case 2: requestId = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'applicationId' field.
   * @return The value of the 'applicationId' field.
   */
  public java.lang.CharSequence getApplicationId() {
    return applicationId;
  }

  /**
   * Sets the value of the 'applicationId' field.
   * @param value the value to set.
   */
  public void setApplicationId(java.lang.CharSequence value) {
    this.applicationId = value;
  }

  /**
   * Gets the value of the 'originHost' field.
   * @return The value of the 'originHost' field.
   */
  public java.lang.CharSequence getOriginHost() {
    return originHost;
  }

  /**
   * Sets the value of the 'originHost' field.
   * @param value the value to set.
   */
  public void setOriginHost(java.lang.CharSequence value) {
    this.originHost = value;
  }

  /**
   * Gets the value of the 'requestId' field.
   * @return The value of the 'requestId' field.
   */
  public java.lang.CharSequence getRequestId() {
    return requestId;
  }

  /**
   * Sets the value of the 'requestId' field.
   * @param value the value to set.
   */
  public void setRequestId(java.lang.CharSequence value) {
    this.requestId = value;
  }

  /**
   * Creates a new Header RecordBuilder.
   * @return A new Header RecordBuilder
   */
  public static com.code.rpc.api.sync.Header.Builder newBuilder() {
    return new com.code.rpc.api.sync.Header.Builder();
  }

  /**
   * Creates a new Header RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Header RecordBuilder
   */
  public static com.code.rpc.api.sync.Header.Builder newBuilder(com.code.rpc.api.sync.Header.Builder other) {
    return new com.code.rpc.api.sync.Header.Builder(other);
  }

  /**
   * Creates a new Header RecordBuilder by copying an existing Header instance.
   * @param other The existing instance to copy.
   * @return A new Header RecordBuilder
   */
  public static com.code.rpc.api.sync.Header.Builder newBuilder(com.code.rpc.api.sync.Header other) {
    return new com.code.rpc.api.sync.Header.Builder(other);
  }

  /**
   * RecordBuilder for Header instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Header>
    implements org.apache.avro.data.RecordBuilder<Header> {

    private java.lang.CharSequence applicationId;
    private java.lang.CharSequence originHost;
    private java.lang.CharSequence requestId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.code.rpc.api.sync.Header.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.applicationId)) {
        this.applicationId = data().deepCopy(fields()[0].schema(), other.applicationId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.originHost)) {
        this.originHost = data().deepCopy(fields()[1].schema(), other.originHost);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.requestId)) {
        this.requestId = data().deepCopy(fields()[2].schema(), other.requestId);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Header instance
     * @param other The existing instance to copy.
     */
    private Builder(com.code.rpc.api.sync.Header other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.applicationId)) {
        this.applicationId = data().deepCopy(fields()[0].schema(), other.applicationId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.originHost)) {
        this.originHost = data().deepCopy(fields()[1].schema(), other.originHost);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.requestId)) {
        this.requestId = data().deepCopy(fields()[2].schema(), other.requestId);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'applicationId' field.
      * @return The value.
      */
    public java.lang.CharSequence getApplicationId() {
      return applicationId;
    }

    /**
      * Sets the value of the 'applicationId' field.
      * @param value The value of 'applicationId'.
      * @return This builder.
      */
    public com.code.rpc.api.sync.Header.Builder setApplicationId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.applicationId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'applicationId' field has been set.
      * @return True if the 'applicationId' field has been set, false otherwise.
      */
    public boolean hasApplicationId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'applicationId' field.
      * @return This builder.
      */
    public com.code.rpc.api.sync.Header.Builder clearApplicationId() {
      applicationId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'originHost' field.
      * @return The value.
      */
    public java.lang.CharSequence getOriginHost() {
      return originHost;
    }

    /**
      * Sets the value of the 'originHost' field.
      * @param value The value of 'originHost'.
      * @return This builder.
      */
    public com.code.rpc.api.sync.Header.Builder setOriginHost(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.originHost = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'originHost' field has been set.
      * @return True if the 'originHost' field has been set, false otherwise.
      */
    public boolean hasOriginHost() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'originHost' field.
      * @return This builder.
      */
    public com.code.rpc.api.sync.Header.Builder clearOriginHost() {
      originHost = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'requestId' field.
      * @return The value.
      */
    public java.lang.CharSequence getRequestId() {
      return requestId;
    }

    /**
      * Sets the value of the 'requestId' field.
      * @param value The value of 'requestId'.
      * @return This builder.
      */
    public com.code.rpc.api.sync.Header.Builder setRequestId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.requestId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'requestId' field has been set.
      * @return True if the 'requestId' field has been set, false otherwise.
      */
    public boolean hasRequestId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'requestId' field.
      * @return This builder.
      */
    public com.code.rpc.api.sync.Header.Builder clearRequestId() {
      requestId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Header build() {
      try {
        Header record = new Header();
        record.applicationId = fieldSetFlags()[0] ? this.applicationId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.originHost = fieldSetFlags()[1] ? this.originHost : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.requestId = fieldSetFlags()[2] ? this.requestId : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
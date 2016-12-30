/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.code.rpc.api.sync;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** 查询余量信息应答-属性-账户信息 */
@org.apache.avro.specific.AvroGenerated
public class AccountInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7035217607697159637L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AccountInfo\",\"namespace\":\"com.code.rpc.api.sync\",\"doc\":\"查询余量信息应答-属性-账户信息\",\"fields\":[{\"name\":\"accountStatus\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence accountStatus;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AccountInfo() {}

  /**
   * All-args constructor.
   * @param accountStatus The new value for accountStatus
   */
  public AccountInfo(java.lang.CharSequence accountStatus) {
    this.accountStatus = accountStatus;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return accountStatus;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: accountStatus = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'accountStatus' field.
   * @return The value of the 'accountStatus' field.
   */
  public java.lang.CharSequence getAccountStatus() {
    return accountStatus;
  }

  /**
   * Sets the value of the 'accountStatus' field.
   * @param value the value to set.
   */
  public void setAccountStatus(java.lang.CharSequence value) {
    this.accountStatus = value;
  }

  /**
   * Creates a new AccountInfo RecordBuilder.
   * @return A new AccountInfo RecordBuilder
   */
  public static com.code.rpc.api.sync.AccountInfo.Builder newBuilder() {
    return new com.code.rpc.api.sync.AccountInfo.Builder();
  }

  /**
   * Creates a new AccountInfo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AccountInfo RecordBuilder
   */
  public static com.code.rpc.api.sync.AccountInfo.Builder newBuilder(com.code.rpc.api.sync.AccountInfo.Builder other) {
    return new com.code.rpc.api.sync.AccountInfo.Builder(other);
  }

  /**
   * Creates a new AccountInfo RecordBuilder by copying an existing AccountInfo instance.
   * @param other The existing instance to copy.
   * @return A new AccountInfo RecordBuilder
   */
  public static com.code.rpc.api.sync.AccountInfo.Builder newBuilder(com.code.rpc.api.sync.AccountInfo other) {
    return new com.code.rpc.api.sync.AccountInfo.Builder(other);
  }

  /**
   * RecordBuilder for AccountInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AccountInfo>
    implements org.apache.avro.data.RecordBuilder<AccountInfo> {

    private java.lang.CharSequence accountStatus;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.code.rpc.api.sync.AccountInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.accountStatus)) {
        this.accountStatus = data().deepCopy(fields()[0].schema(), other.accountStatus);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AccountInfo instance
     * @param other The existing instance to copy.
     */
    private Builder(com.code.rpc.api.sync.AccountInfo other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.accountStatus)) {
        this.accountStatus = data().deepCopy(fields()[0].schema(), other.accountStatus);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'accountStatus' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountStatus() {
      return accountStatus;
    }

    /**
      * Sets the value of the 'accountStatus' field.
      * @param value The value of 'accountStatus'.
      * @return This builder.
      */
    public com.code.rpc.api.sync.AccountInfo.Builder setAccountStatus(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.accountStatus = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'accountStatus' field has been set.
      * @return True if the 'accountStatus' field has been set, false otherwise.
      */
    public boolean hasAccountStatus() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'accountStatus' field.
      * @return This builder.
      */
    public com.code.rpc.api.sync.AccountInfo.Builder clearAccountStatus() {
      accountStatus = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public AccountInfo build() {
      try {
        AccountInfo record = new AccountInfo();
        record.accountStatus = fieldSetFlags()[0] ? this.accountStatus : (java.lang.CharSequence) defaultValue(fields()[0]);
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

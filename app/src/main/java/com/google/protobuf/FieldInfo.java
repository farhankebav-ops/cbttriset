package com.google.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldInfo implements Comparable {
    private final java.lang.reflect.Field cachedSizeField;
    private final boolean enforceUtf8;
    private final Internal.EnumVerifier enumVerifier;
    private final java.lang.reflect.Field field;
    private final int fieldNumber;
    private final Object mapDefaultEntry;
    private final Class<?> messageClass;
    private final u1 oneof;
    private final Class<?> oneofStoredType;
    private final java.lang.reflect.Field presenceField;
    private final int presenceMask;
    private final boolean required;
    private final FieldType type;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private java.lang.reflect.Field cachedSizeField;
        private boolean enforceUtf8;
        private Internal.EnumVerifier enumVerifier;
        private java.lang.reflect.Field field;
        private int fieldNumber;
        private Object mapDefaultEntry;
        private u1 oneof;
        private Class<?> oneofStoredType;
        private java.lang.reflect.Field presenceField;
        private int presenceMask;
        private boolean required;
        private FieldType type;

        public /* synthetic */ Builder(f0 f0Var) {
            this();
        }

        public FieldInfo build() {
            u1 u1Var = this.oneof;
            if (u1Var != null) {
                return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, u1Var, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
            }
            Object obj = this.mapDefaultEntry;
            if (obj != null) {
                return FieldInfo.forMapField(this.field, this.fieldNumber, obj, this.enumVerifier);
            }
            java.lang.reflect.Field field = this.presenceField;
            if (field != null) {
                return this.required ? FieldInfo.forLegacyRequiredField(this.field, this.fieldNumber, this.type, field, this.presenceMask, this.enforceUtf8, this.enumVerifier) : FieldInfo.forExplicitPresenceField(this.field, this.fieldNumber, this.type, field, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            }
            Internal.EnumVerifier enumVerifier = this.enumVerifier;
            if (enumVerifier != null) {
                java.lang.reflect.Field field2 = this.cachedSizeField;
                return field2 == null ? FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier) : FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier, field2);
            }
            java.lang.reflect.Field field3 = this.cachedSizeField;
            return field3 == null ? FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8) : FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, field3);
        }

        public Builder withCachedSizeField(java.lang.reflect.Field field) {
            this.cachedSizeField = field;
            return this;
        }

        public Builder withEnforceUtf8(boolean z2) {
            this.enforceUtf8 = z2;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier enumVerifier) {
            this.enumVerifier = enumVerifier;
            return this;
        }

        public Builder withField(java.lang.reflect.Field field) {
            if (this.oneof != null) {
                throw new IllegalStateException("Cannot set field when building a oneof.");
            }
            this.field = field;
            return this;
        }

        public Builder withFieldNumber(int i2) {
            this.fieldNumber = i2;
            return this;
        }

        public Builder withMapDefaultEntry(Object obj) {
            this.mapDefaultEntry = obj;
            return this;
        }

        public Builder withOneof(u1 u1Var, Class<?> cls) {
            if (this.field != null || this.presenceField != null) {
                throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
            }
            this.oneof = u1Var;
            this.oneofStoredType = cls;
            return this;
        }

        public Builder withPresence(java.lang.reflect.Field field, int i2) {
            this.presenceField = (java.lang.reflect.Field) Internal.checkNotNull(field, "presenceField");
            this.presenceMask = i2;
            return this;
        }

        public Builder withRequired(boolean z2) {
            this.required = z2;
            return this;
        }

        public Builder withType(FieldType fieldType) {
            this.type = fieldType;
            return this;
        }

        private Builder() {
        }
    }

    private FieldInfo(java.lang.reflect.Field field, int i2, FieldType fieldType, Class<?> cls, java.lang.reflect.Field field2, int i8, boolean z2, boolean z7, u1 u1Var, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier, java.lang.reflect.Field field3) {
        this.field = field;
        this.type = fieldType;
        this.messageClass = cls;
        this.fieldNumber = i2;
        this.presenceField = field2;
        this.presenceMask = i8;
        this.required = z2;
        this.enforceUtf8 = z7;
        this.oneof = u1Var;
        this.oneofStoredType = cls2;
        this.mapDefaultEntry = obj;
        this.enumVerifier = enumVerifier;
        this.cachedSizeField = field3;
    }

    private static void checkFieldNumber(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(a1.a.g(i2, "fieldNumber must be positive: "));
        }
    }

    public static FieldInfo forExplicitPresenceField(java.lang.reflect.Field field, int i2, FieldType fieldType, java.lang.reflect.Field field2, int i8, boolean z2, Internal.EnumVerifier enumVerifier) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(field2, "presenceField");
        if (field2 == null || isExactlyOneBitSet(i8)) {
            return new FieldInfo(field, i2, fieldType, null, field2, i8, false, z2, null, null, null, enumVerifier, null);
        }
        throw new IllegalArgumentException(a1.a.g(i8, "presenceMask must have exactly one bit set: "));
    }

    public static FieldInfo forField(java.lang.reflect.Field field, int i2, FieldType fieldType, boolean z2) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        if (fieldType == FieldType.MESSAGE_LIST || fieldType == FieldType.GROUP_LIST) {
            throw new IllegalStateException("Shouldn't be called for repeated message fields.");
        }
        return new FieldInfo(field, i2, fieldType, null, null, 0, false, z2, null, null, null, null, null);
    }

    public static FieldInfo forFieldWithEnumVerifier(java.lang.reflect.Field field, int i2, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        return new FieldInfo(field, i2, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, null);
    }

    public static FieldInfo forLegacyRequiredField(java.lang.reflect.Field field, int i2, FieldType fieldType, java.lang.reflect.Field field2, int i8, boolean z2, Internal.EnumVerifier enumVerifier) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(field2, "presenceField");
        if (field2 == null || isExactlyOneBitSet(i8)) {
            return new FieldInfo(field, i2, fieldType, null, field2, i8, true, z2, null, null, null, enumVerifier, null);
        }
        throw new IllegalArgumentException(a1.a.g(i8, "presenceMask must have exactly one bit set: "));
    }

    public static FieldInfo forMapField(java.lang.reflect.Field field, int i2, Object obj, Internal.EnumVerifier enumVerifier) {
        Internal.checkNotNull(obj, "mapDefaultEntry");
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        return new FieldInfo(field, i2, FieldType.MAP, null, null, 0, false, true, null, null, obj, enumVerifier, null);
    }

    public static FieldInfo forOneofMemberField(int i2, FieldType fieldType, u1 u1Var, Class<?> cls, boolean z2, Internal.EnumVerifier enumVerifier) {
        checkFieldNumber(i2);
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(u1Var, "oneof");
        Internal.checkNotNull(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo(null, i2, fieldType, null, null, 0, false, z2, u1Var, cls, null, enumVerifier, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i2 + " is of type " + fieldType);
    }

    public static FieldInfo forPackedField(java.lang.reflect.Field field, int i2, FieldType fieldType, java.lang.reflect.Field field2) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        if (fieldType == FieldType.MESSAGE_LIST || fieldType == FieldType.GROUP_LIST) {
            throw new IllegalStateException("Shouldn't be called for repeated message fields.");
        }
        return new FieldInfo(field, i2, fieldType, null, null, 0, false, false, null, null, null, null, field2);
    }

    public static FieldInfo forPackedFieldWithEnumVerifier(java.lang.reflect.Field field, int i2, FieldType fieldType, Internal.EnumVerifier enumVerifier, java.lang.reflect.Field field2) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        return new FieldInfo(field, i2, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, field2);
    }

    public static FieldInfo forRepeatedMessageField(java.lang.reflect.Field field, int i2, FieldType fieldType, Class<?> cls) {
        checkFieldNumber(i2);
        Internal.checkNotNull(field, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(cls, "messageClass");
        return new FieldInfo(field, i2, fieldType, cls, null, 0, false, false, null, null, null, null, null);
    }

    private static boolean isExactlyOneBitSet(int i2) {
        return i2 != 0 && (i2 & (i2 + (-1))) == 0;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public java.lang.reflect.Field getCachedSizeField() {
        return this.cachedSizeField;
    }

    public Internal.EnumVerifier getEnumVerifier() {
        return this.enumVerifier;
    }

    public java.lang.reflect.Field getField() {
        return this.field;
    }

    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public Class<?> getListElementType() {
        return this.messageClass;
    }

    public Object getMapDefaultEntry() {
        return this.mapDefaultEntry;
    }

    public Class<?> getMessageFieldClass() {
        int i2 = f0.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (i2 == 1 || i2 == 2) {
            java.lang.reflect.Field field = this.field;
            return field != null ? field.getType() : this.oneofStoredType;
        }
        if (i2 == 3 || i2 == 4) {
            return this.messageClass;
        }
        return null;
    }

    public u1 getOneof() {
        return this.oneof;
    }

    public Class<?> getOneofStoredType() {
        return this.oneofStoredType;
    }

    public java.lang.reflect.Field getPresenceField() {
        return this.presenceField;
    }

    public int getPresenceMask() {
        return this.presenceMask;
    }

    public FieldType getType() {
        return this.type;
    }

    public boolean isEnforceUtf8() {
        return this.enforceUtf8;
    }

    public boolean isRequired() {
        return this.required;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        return this.fieldNumber - fieldInfo.fieldNumber;
    }
}

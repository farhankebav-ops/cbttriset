package com.google.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    public static final int NULL_VALUE_VALUE = 0;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = new Internal.EnumLiteMap() { // from class: com.google.protobuf.NullValue.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public NullValue findValueByNumber(int i2) {
            return NullValue.forNumber(i2);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new b();

        private b() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i2) {
            return NullValue.forNumber(i2) != null;
        }
    }

    NullValue(int i2) {
        this.value = i2;
    }

    public static NullValue forNumber(int i2) {
        if (i2 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return b.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int i2) {
        return forNumber(i2);
    }
}

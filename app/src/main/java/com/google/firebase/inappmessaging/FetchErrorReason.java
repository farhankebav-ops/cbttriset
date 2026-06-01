package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum FetchErrorReason implements Internal.EnumLite {
    UNSPECIFIED_FETCH_ERROR(0),
    SERVER_ERROR(1),
    CLIENT_ERROR(2),
    NETWORK_ERROR(3);

    public static final int CLIENT_ERROR_VALUE = 2;
    public static final int NETWORK_ERROR_VALUE = 3;
    public static final int SERVER_ERROR_VALUE = 1;
    public static final int UNSPECIFIED_FETCH_ERROR_VALUE = 0;
    private static final Internal.EnumLiteMap<FetchErrorReason> internalValueMap = new Internal.EnumLiteMap<FetchErrorReason>() { // from class: com.google.firebase.inappmessaging.FetchErrorReason.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public FetchErrorReason findValueByNumber(int i2) {
            return FetchErrorReason.forNumber(i2);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class FetchErrorReasonVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new FetchErrorReasonVerifier();

        private FetchErrorReasonVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i2) {
            return FetchErrorReason.forNumber(i2) != null;
        }
    }

    FetchErrorReason(int i2) {
        this.value = i2;
    }

    public static FetchErrorReason forNumber(int i2) {
        if (i2 == 0) {
            return UNSPECIFIED_FETCH_ERROR;
        }
        if (i2 == 1) {
            return SERVER_ERROR;
        }
        if (i2 == 2) {
            return CLIENT_ERROR;
        }
        if (i2 != 3) {
            return null;
        }
        return NETWORK_ERROR;
    }

    public static Internal.EnumLiteMap<FetchErrorReason> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FetchErrorReasonVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static FetchErrorReason valueOf(int i2) {
        return forNumber(i2);
    }
}

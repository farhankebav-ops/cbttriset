package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum DismissType implements Internal.EnumLite {
    UNKNOWN_DISMISS_TYPE(0),
    AUTO(1),
    CLICK(2),
    SWIPE(3);

    public static final int AUTO_VALUE = 1;
    public static final int CLICK_VALUE = 2;
    public static final int SWIPE_VALUE = 3;
    public static final int UNKNOWN_DISMISS_TYPE_VALUE = 0;
    private static final Internal.EnumLiteMap<DismissType> internalValueMap = new Internal.EnumLiteMap<DismissType>() { // from class: com.google.firebase.inappmessaging.DismissType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DismissType findValueByNumber(int i2) {
            return DismissType.forNumber(i2);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DismissTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DismissTypeVerifier();

        private DismissTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i2) {
            return DismissType.forNumber(i2) != null;
        }
    }

    DismissType(int i2) {
        this.value = i2;
    }

    public static DismissType forNumber(int i2) {
        if (i2 == 0) {
            return UNKNOWN_DISMISS_TYPE;
        }
        if (i2 == 1) {
            return AUTO;
        }
        if (i2 == 2) {
            return CLICK;
        }
        if (i2 != 3) {
            return null;
        }
        return SWIPE;
    }

    public static Internal.EnumLiteMap<DismissType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DismissTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DismissType valueOf(int i2) {
        return forNumber(i2);
    }
}

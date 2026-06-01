package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum RenderErrorReason implements Internal.EnumLite {
    UNSPECIFIED_RENDER_ERROR(0),
    IMAGE_FETCH_ERROR(1),
    IMAGE_DISPLAY_ERROR(2),
    IMAGE_UNSUPPORTED_FORMAT(3);

    public static final int IMAGE_DISPLAY_ERROR_VALUE = 2;
    public static final int IMAGE_FETCH_ERROR_VALUE = 1;
    public static final int IMAGE_UNSUPPORTED_FORMAT_VALUE = 3;
    public static final int UNSPECIFIED_RENDER_ERROR_VALUE = 0;
    private static final Internal.EnumLiteMap<RenderErrorReason> internalValueMap = new Internal.EnumLiteMap<RenderErrorReason>() { // from class: com.google.firebase.inappmessaging.RenderErrorReason.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public RenderErrorReason findValueByNumber(int i2) {
            return RenderErrorReason.forNumber(i2);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class RenderErrorReasonVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new RenderErrorReasonVerifier();

        private RenderErrorReasonVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i2) {
            return RenderErrorReason.forNumber(i2) != null;
        }
    }

    RenderErrorReason(int i2) {
        this.value = i2;
    }

    public static RenderErrorReason forNumber(int i2) {
        if (i2 == 0) {
            return UNSPECIFIED_RENDER_ERROR;
        }
        if (i2 == 1) {
            return IMAGE_FETCH_ERROR;
        }
        if (i2 == 2) {
            return IMAGE_DISPLAY_ERROR;
        }
        if (i2 != 3) {
            return null;
        }
        return IMAGE_UNSUPPORTED_FORMAT;
    }

    public static Internal.EnumLiteMap<RenderErrorReason> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return RenderErrorReasonVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static RenderErrorReason valueOf(int i2) {
        return forNumber(i2);
    }
}

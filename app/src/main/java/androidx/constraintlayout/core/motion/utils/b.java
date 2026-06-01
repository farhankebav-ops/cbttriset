package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "dimension":
                return TypedValues.Custom.TYPE_DIMENSION;
            case "reference":
                return TypedValues.Custom.TYPE_REFERENCE;
            case "string":
                return TypedValues.Custom.TYPE_STRING;
            case "boolean":
                return TypedValues.Custom.TYPE_BOOLEAN;
            case "color":
                return TypedValues.Custom.TYPE_COLOR;
            case "float":
                return TypedValues.Custom.TYPE_FLOAT;
            case "integer":
                return 900;
            default:
                return -1;
        }
    }
}

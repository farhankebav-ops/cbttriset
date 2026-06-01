package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class s1 {
    private static final q1 FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final q1 LITE_SCHEMA = new r1();

    public static q1 full() {
        return FULL_SCHEMA;
    }

    public static q1 lite() {
        return LITE_SCHEMA;
    }

    private static q1 loadSchemaForFullRuntime() {
        try {
            return (q1) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

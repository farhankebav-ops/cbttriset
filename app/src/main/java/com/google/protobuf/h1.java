package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 {
    private static final f1 FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final f1 LITE_SCHEMA = new g1();

    public static f1 full() {
        return FULL_SCHEMA;
    }

    public static f1 lite() {
        return LITE_SCHEMA;
    }

    private static f1 loadSchemaForFullRuntime() {
        try {
            return (f1) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

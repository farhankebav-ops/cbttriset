package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {
    private static final a0 LITE_SCHEMA = new c0();
    private static final a0 FULL_SCHEMA = loadSchemaForFullRuntime();

    public static a0 full() {
        a0 a0Var = FULL_SCHEMA;
        if (a0Var != null) {
            return a0Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static a0 lite() {
        return LITE_SCHEMA;
    }

    private static a0 loadSchemaForFullRuntime() {
        try {
            return (a0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class x1 {
    private static final x1 INSTANCE = new x1();
    private final ConcurrentMap<Class<?>, c2> schemaCache = new ConcurrentHashMap();
    private final d2 schemaFactory = new c1();

    private x1() {
    }

    public static x1 getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int schemaSize = 0;
        for (c2 c2Var : this.schemaCache.values()) {
            if (c2Var instanceof m1) {
                schemaSize = ((m1) c2Var).getSchemaSize() + schemaSize;
            }
        }
        return schemaSize;
    }

    public <T> boolean isInitialized(T t3) {
        return schemaFor(t3).isInitialized(t3);
    }

    public <T> void makeImmutable(T t3) {
        schemaFor(t3).makeImmutable(t3);
    }

    public <T> void mergeFrom(T t3, a2 a2Var) throws IOException {
        mergeFrom(t3, a2Var, ExtensionRegistryLite.getEmptyRegistry());
    }

    public c2 registerSchema(Class<?> cls, c2 c2Var) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(c2Var, "schema");
        return this.schemaCache.putIfAbsent(cls, c2Var);
    }

    public c2 registerSchemaOverride(Class<?> cls, c2 c2Var) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(c2Var, "schema");
        return this.schemaCache.put(cls, c2Var);
    }

    public <T> c2 schemaFor(Class<T> cls) {
        c2 c2VarRegisterSchema;
        Internal.checkNotNull(cls, "messageType");
        c2 c2VarCreateSchema = this.schemaCache.get(cls);
        return (c2VarCreateSchema != null || (c2VarRegisterSchema = registerSchema(cls, (c2VarCreateSchema = this.schemaFactory.createSchema(cls)))) == null) ? c2VarCreateSchema : c2VarRegisterSchema;
    }

    public <T> void writeTo(T t3, v2 v2Var) throws IOException {
        schemaFor(t3).writeTo(t3, v2Var);
    }

    public <T> void mergeFrom(T t3, a2 a2Var, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor(t3).mergeFrom(t3, a2Var, extensionRegistryLite);
    }

    public <T> c2 schemaFor(T t3) {
        return schemaFor((Class) t3.getClass());
    }
}

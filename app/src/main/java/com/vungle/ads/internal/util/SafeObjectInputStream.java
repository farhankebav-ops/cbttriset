package com.vungle.ads.internal.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SafeObjectInputStream extends ObjectInputStream {
    private final List<Class<?>> allowed;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeObjectInputStream(InputStream inputStream, List<? extends Class<?>> list) {
        super(inputStream);
        this.allowed = list;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass desc) throws ClassNotFoundException, IOException {
        k.e(desc, "desc");
        Class<?> c7 = super.resolveClass(desc);
        if (this.allowed == null || Number.class.isAssignableFrom(c7) || String.class.equals(c7) || Boolean.class.equals(c7) || c7.isArray() || this.allowed.contains(c7)) {
            k.d(c7, "c");
            return c7;
        }
        throw new IOException("Deserialization is not allowed for " + desc.getName());
    }
}

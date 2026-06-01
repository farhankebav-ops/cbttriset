package com.unity3d.ads.core.configuration;

import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class MetadataReader<T> {
    private final JsonStorage jsonStorage;
    private final String key;

    public MetadataReader(JsonStorage jsonStorage, String key) {
        k.e(jsonStorage, "jsonStorage");
        k.e(key, "key");
        this.jsonStorage = jsonStorage;
        this.key = key;
    }

    public static Object read$default(MetadataReader metadataReader, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
        }
        if ((i2 & 1) != 0) {
            obj = null;
        }
        if (metadataReader.getJsonStorage().get(metadataReader.getKey()) == null) {
            return obj;
        }
        k.k();
        throw null;
    }

    public static Object readAndDelete$default(MetadataReader metadataReader, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAndDelete");
        }
        if ((i2 & 1) != 0) {
            obj = null;
        }
        if (metadataReader.getJsonStorage().get(metadataReader.getKey()) != null) {
            k.k();
            throw null;
        }
        if (metadataReader.getJsonStorage().get(metadataReader.getKey()) != null) {
            metadataReader.getJsonStorage().delete(metadataReader.getKey());
        }
        return obj;
    }

    public final JsonStorage getJsonStorage() {
        return this.jsonStorage;
    }

    public final String getKey() {
        return this.key;
    }

    public final <T> T read(T t3) {
        if (getJsonStorage().get(getKey()) == null) {
            return t3;
        }
        k.k();
        throw null;
    }

    public final <T> T readAndDelete(T t3) {
        if (getJsonStorage().get(getKey()) != null) {
            k.k();
            throw null;
        }
        if (getJsonStorage().get(getKey()) != null) {
            getJsonStorage().delete(getKey());
        }
        return t3;
    }
}

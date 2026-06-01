package com.google.protobuf;

import com.google.protobuf.f;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface c2 {
    boolean equals(Object obj, Object obj2);

    int getSerializedSize(Object obj);

    int hashCode(Object obj);

    boolean isInitialized(Object obj);

    void makeImmutable(Object obj);

    void mergeFrom(Object obj, a2 a2Var, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(Object obj, Object obj2);

    void mergeFrom(Object obj, byte[] bArr, int i2, int i8, f.a aVar) throws IOException;

    Object newInstance();

    void writeTo(Object obj, v2 v2Var) throws IOException;
}

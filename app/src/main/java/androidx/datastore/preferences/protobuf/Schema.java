package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T t3, T t7);

    int getSerializedSize(T t3);

    int hashCode(T t3);

    boolean isInitialized(T t3);

    void makeImmutable(T t3);

    void mergeFrom(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t3, T t7);

    void mergeFrom(T t3, byte[] bArr, int i2, int i8, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t3, Writer writer) throws IOException;
}

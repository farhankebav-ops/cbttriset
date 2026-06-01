package androidx.datastore.core;

import java.io.InputStream;
import java.io.OutputStream;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, c<? super T> cVar);

    Object writeTo(T t3, OutputStream outputStream, c<? super x> cVar);
}

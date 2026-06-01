package androidx.datastore.core;

import e6.p;
import e6.q;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(q qVar, c<? super R> cVar);

    Object writeScope(p pVar, c<? super x> cVar);
}

package androidx.datastore.core.okio;

import l7.k;
import l7.l;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface OkioSerializer<T> {
    T getDefaultValue();

    Object readFrom(l lVar, c<? super T> cVar);

    Object writeTo(T t3, k kVar, c<? super x> cVar);
}

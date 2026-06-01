package androidx.datastore;

import androidx.datastore.core.Serializer;
import androidx.datastore.core.okio.OkioSerializer;
import kotlin.jvm.internal.k;
import l7.l;
import q5.x;
import v5.c;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioSerializerWrapper<T> implements OkioSerializer<T> {
    private final Serializer<T> delegate;

    public OkioSerializerWrapper(Serializer<T> delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public T getDefaultValue() {
        return this.delegate.getDefaultValue();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object readFrom(l lVar, c<? super T> cVar) {
        return this.delegate.readFrom(lVar.V(), cVar);
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object writeTo(T t3, l7.k kVar, c<? super x> cVar) {
        Object objWriteTo = this.delegate.writeTo(t3, kVar.T(), cVar);
        return objWriteTo == a.f17774a ? objWriteTo : x.f13520a;
    }
}

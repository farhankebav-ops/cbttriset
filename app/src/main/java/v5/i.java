package v5;

import e6.p;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements h, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f17610a = new i();

    @Override // v5.h
    public final f get(g key) {
        k.e(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // v5.h
    public final h minusKey(g key) {
        k.e(key, "key");
        return this;
    }

    @Override // v5.h
    public final h plus(h context) {
        k.e(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // v5.h
    public final Object fold(Object obj, p pVar) {
        return obj;
    }
}

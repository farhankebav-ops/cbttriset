package r6;

import android.os.Handler;
import android.os.Looper;
import com.unity3d.scar.adapter.common.i;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import q6.e1;
import q6.f1;
import q6.h0;
import q6.l;
import q6.m0;
import q6.o0;
import q6.r1;
import q6.w;
import v5.h;
import v6.n;
import v6.o;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends w implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f13646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f13648c;

    public c(Handler handler, boolean z2) {
        this.f13646a = handler;
        this.f13647b = z2;
        this.f13648c = z2 ? this : new c(handler, true);
    }

    @Override // q6.w
    public final void dispatch(h hVar, Runnable runnable) {
        if (this.f13646a.post(runnable)) {
            return;
        }
        o(hVar, runnable);
    }

    @Override // q6.h0
    public final o0 e(long j, Runnable runnable, h hVar) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.f13646a.postDelayed(runnable, j)) {
            return new androidx.datastore.core.a(1, this, runnable);
        }
        o(hVar, runnable);
        return r1.f13582a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f13646a == this.f13646a && cVar.f13647b == this.f13647b;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f13646a) ^ (this.f13647b ? 1231 : 1237);
    }

    @Override // q6.w
    public final boolean isDispatchNeeded(h hVar) {
        return (this.f13647b && k.a(Looper.myLooper(), this.f13646a.getLooper())) ? false : true;
    }

    @Override // q6.h0
    public final void l(long j, l lVar) {
        i iVar = new i(4, lVar, this, false);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.f13646a.postDelayed(iVar, j)) {
            lVar.t(new okhttp3.internal.cache.a(1, this, iVar));
        } else {
            o(lVar.e, iVar);
        }
    }

    @Override // q6.w
    public w limitedParallelism(int i2, String str) {
        v6.a.a(i2);
        return str != null ? new o(this, str) : this;
    }

    public final void o(h hVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        f1 f1Var = (f1) hVar.get(e1.f13546a);
        if (f1Var != null) {
            f1Var.a(cancellationException);
        }
        e eVar = m0.f13566a;
        x6.d.f17810a.dispatch(hVar, runnable);
    }

    @Override // q6.w
    public final String toString() {
        c cVar;
        String str;
        e eVar = m0.f13566a;
        c cVar2 = n.f17641a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f13648c;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f13646a.toString();
        return this.f13647b ? a1.a.C(string, ".immediate") : string;
    }
}

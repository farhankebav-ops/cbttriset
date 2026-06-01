package v5;

import com.ironsource.C2300e4;
import e6.p;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements h, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f17607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f17608b;

    public b(f element, h left) {
        k.e(left, "left");
        k.e(element, "element");
        this.f17607a = left;
        this.f17608b = element;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i2 = 2;
            b bVar2 = bVar;
            int i8 = 2;
            while (true) {
                h hVar = bVar2.f17607a;
                bVar2 = hVar instanceof b ? (b) hVar : null;
                if (bVar2 == null) {
                    break;
                }
                i8++;
            }
            b bVar3 = this;
            while (true) {
                h hVar2 = bVar3.f17607a;
                bVar3 = hVar2 instanceof b ? (b) hVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i2++;
            }
            if (i8 == i2) {
                b bVar4 = this;
                while (true) {
                    f fVar = bVar4.f17608b;
                    if (!k.a(bVar.get(fVar.getKey()), fVar)) {
                        zA = false;
                        break;
                    }
                    h hVar3 = bVar4.f17607a;
                    if (!(hVar3 instanceof b)) {
                        k.c(hVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        f fVar2 = (f) hVar3;
                        zA = k.a(bVar.get(fVar2.getKey()), fVar2);
                        break;
                    }
                    bVar4 = (b) hVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // v5.h
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(this.f17607a.fold(obj, pVar), this.f17608b);
    }

    @Override // v5.h
    public final f get(g key) {
        k.e(key, "key");
        b bVar = this;
        while (true) {
            f fVar = bVar.f17608b.get(key);
            if (fVar != null) {
                return fVar;
            }
            h hVar = bVar.f17607a;
            if (!(hVar instanceof b)) {
                return hVar.get(key);
            }
            bVar = (b) hVar;
        }
    }

    public final int hashCode() {
        return this.f17608b.hashCode() + this.f17607a.hashCode();
    }

    @Override // v5.h
    public final h minusKey(g key) {
        k.e(key, "key");
        f fVar = this.f17608b;
        f fVar2 = fVar.get(key);
        h hVar = this.f17607a;
        if (fVar2 != null) {
            return hVar;
        }
        h hVarMinusKey = hVar.minusKey(key);
        return hVarMinusKey == hVar ? this : hVarMinusKey == i.f17610a ? fVar : new b(fVar, hVarMinusKey);
    }

    @Override // v5.h
    public final h plus(h context) {
        k.e(context, "context");
        return context == i.f17610a ? this : (h) context.fold(this, new androidx.camera.camera2.internal.compat.workaround.a(8));
    }

    public final String toString() {
        return a1.a.e(']', (String) fold("", new androidx.camera.camera2.internal.compat.workaround.a(7)), new StringBuilder(C2300e4.i.f8403d));
    }
}

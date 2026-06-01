package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.core.impl.Quirks;
import e6.p;
import i7.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import q6.w1;
import r2.q;
import v5.e;
import v5.f;
import v5.i;
import v6.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3414a;

    public /* synthetic */ a(int i2) {
        this.f3414a = i2;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        v5.b bVar;
        switch (this.f3414a) {
            case 0:
                return EncoderProfilesProviderFallback._init_$lambda$0((String) obj, (Quirks) obj2);
            case 1:
                l6.c clazz = (l6.c) obj;
                List types = (List) obj2;
                k.e(clazz, "clazz");
                k.e(types, "types");
                ArrayList arrayListS0 = q.s0(h.f12046a, types, true);
                k.b(arrayListS0);
                return q.k0(clazz, arrayListS0, new b7.k(types, 0));
            case 2:
                l6.c clazz2 = (l6.c) obj;
                List types2 = (List) obj2;
                k.e(clazz2, "clazz");
                k.e(types2, "types");
                ArrayList arrayListS02 = q.s0(h.f12046a, types2, true);
                k.b(arrayListS02);
                b7.c cVarK0 = q.k0(clazz2, arrayListS02, new b7.k(types2, 1));
                if (cVarK0 != null) {
                    return q.Y(cVarK0);
                }
                return null;
            case 3:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 4:
                return ((v5.h) obj).plus((f) obj2);
            case 5:
                return ((v5.h) obj).plus((f) obj2);
            case 6:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 7:
                String acc = (String) obj;
                f element = (f) obj2;
                k.e(acc, "acc");
                k.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 8:
                v5.h acc2 = (v5.h) obj;
                f element2 = (f) obj2;
                k.e(acc2, "acc");
                k.e(element2, "element");
                v5.h hVarMinusKey = acc2.minusKey(element2.getKey());
                i iVar = i.f17610a;
                if (hVarMinusKey == iVar) {
                    return element2;
                }
                v5.d dVar = v5.d.f17609a;
                e eVar = (e) hVarMinusKey.get(dVar);
                if (eVar == null) {
                    bVar = new v5.b(element2, hVarMinusKey);
                } else {
                    v5.h hVarMinusKey2 = hVarMinusKey.minusKey(dVar);
                    if (hVarMinusKey2 == iVar) {
                        return new v5.b(eVar, element2);
                    }
                    bVar = new v5.b(eVar, new v5.b(element2, hVarMinusKey2));
                }
                return bVar;
            case 9:
                f fVar = (f) obj2;
                if (!(fVar instanceof w1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? fVar : Integer.valueOf(iIntValue + 1);
            case 10:
                w1 w1Var = (w1) obj;
                f fVar2 = (f) obj2;
                if (w1Var != null) {
                    return w1Var;
                }
                if (fVar2 instanceof w1) {
                    return (w1) fVar2;
                }
                return null;
            default:
                return (w) obj;
        }
    }
}

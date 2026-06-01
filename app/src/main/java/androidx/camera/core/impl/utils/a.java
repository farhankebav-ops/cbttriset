package androidx.camera.core.impl.utils;

import androidx.camera.core.CameraX;
import androidx.camera.lifecycle.LifecycleCameraProvider;
import androidx.camera.lifecycle.LifecycleCameraProviderImpl;
import androidx.webkit.ProxyConfig;
import b7.f;
import com.ironsource.C8;
import com.ironsource.sdk.controller.v;
import d7.g;
import d7.h;
import e2.s;
import e6.l;
import f7.a1;
import f7.e1;
import f7.q1;
import f7.r1;
import g7.m;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.k;
import l6.t;
import l6.u;
import l7.g0;
import okhttp3.internal.cache.DiskLruCache;
import q5.x;
import r2.q;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3631b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f3630a = i2;
        this.f3631b = obj;
    }

    @Override // e6.l
    public final Object invoke(Object it) {
        String strA;
        switch (this.f3630a) {
            case 0:
                return MappingRedirectableLiveData.redirectTo$lambda$2$lambda$0((MappingRedirectableLiveData) this.f3631b, it);
            case 1:
                return LifecycleCameraProvider.Companion.createInstanceAsync$lambda$0((LifecycleCameraProviderImpl) this.f3631b, (Void) it);
            case 2:
                return LifecycleCameraProviderImpl.initAsync$lambda$3$lambda$1((CameraX) this.f3631b, (Void) it);
            case 3:
                f fVar = (f) this.f3631b;
                d7.a buildSerialDescriptor = (d7.a) it;
                k.e(buildSerialDescriptor, "$this$buildSerialDescriptor");
                d7.a.a(buildSerialDescriptor, "type", q1.f11502b);
                d7.a.a(buildSerialDescriptor, "value", q.s("kotlinx.serialization.Polymorphic<" + ((e) fVar.f4152a).f() + '>', d7.k.f11199b, new g[0]));
                buildSerialDescriptor.f11174b = r.f13638a;
                return x.f13520a;
            case 4:
                ArrayList arrayList = (ArrayList) this.f3631b;
                String it2 = (String) it;
                k.e(it2, "it");
                arrayList.add(it2);
                return x.f13520a;
            case 5:
                return ((v) this.f3631b).c((C8) it);
            case 6:
                h hVar = (h) this.f3631b;
                int iIntValue = ((Integer) it).intValue();
                return hVar.f11192f[iIntValue] + ": " + hVar.g[iIntValue].h();
            case 7:
                a1 a1Var = (a1) this.f3631b;
                d7.a buildSerialDescriptor2 = (d7.a) it;
                k.e(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                a1Var.getClass();
                buildSerialDescriptor2.f11174b = r.f13638a;
                return x.f13520a;
            case 8:
                e1 e1Var = (e1) this.f3631b;
                int iIntValue2 = ((Integer) it).intValue();
                return e1Var.e[iIntValue2] + ": " + e1Var.g(iIntValue2).h();
            case 9:
                r1 r1Var = (r1) this.f3631b;
                d7.a buildClassSerialDescriptor = (d7.a) it;
                k.e(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                d7.a.a(buildClassSerialDescriptor, "first", r1Var.f11507a.getDescriptor());
                d7.a.a(buildClassSerialDescriptor, "second", r1Var.f11508b.getDescriptor());
                d7.a.a(buildClassSerialDescriptor, "third", r1Var.f11509c.getDescriptor());
                return x.f13520a;
            case 10:
                h7.r rVar = (h7.r) this.f3631b;
                m node = (m) it;
                k.e(node, "node");
                rVar.j(node, (String) r5.l.d1(rVar.f11769a));
                return x.f13520a;
            case 11:
                a0 a0Var = (a0) this.f3631b;
                m it3 = (m) it;
                k.e(it3, "it");
                a0Var.f12717a = it3;
                return x.f13520a;
            case 12:
                f0 f0Var = (f0) this.f3631b;
                t it4 = (t) it;
                k.e(it4, "it");
                f0Var.getClass();
                u uVar = it4.f12829a;
                l6.r rVar2 = it4.f12830b;
                if (uVar == null) {
                    return ProxyConfig.MATCH_ALL_SCHEMES;
                }
                f0 f0Var2 = rVar2 instanceof f0 ? (f0) rVar2 : null;
                String strValueOf = (f0Var2 == null || (strA = f0Var2.a(true)) == null) ? String.valueOf(rVar2) : strA;
                int i2 = e0.f12722a[uVar.ordinal()];
                if (i2 == 1) {
                    return strValueOf;
                }
                if (i2 == 2) {
                    return "in ".concat(strValueOf);
                }
                if (i2 == 3) {
                    return "out ".concat(strValueOf);
                }
                throw new s(3);
            case 13:
                l7.u uVar2 = (l7.u) this.f3631b;
                g0 it5 = (g0) it;
                k.e(it5, "it");
                return uVar2.onPathResult(it5, "listRecursively");
            case 14:
                e6.a aVar = (e6.a) this.f3631b;
                k.e(it, "it");
                return aVar.invoke();
            case 15:
                return ((n6.k) this.f3631b).a(((Integer) it).intValue());
            case 16:
                return DiskLruCache.newJournalWriter$lambda$3((DiskLruCache) this.f3631b, (IOException) it);
            case 17:
                return it == ((r5.a) this.f3631b) ? "(this Collection)" : String.valueOf(it);
            default:
                ((z6.c) this.f3631b).f(null);
                return x.f13520a;
        }
    }

    public /* synthetic */ a(z6.c cVar, z6.b bVar) {
        this.f3630a = 18;
        this.f3631b = cVar;
    }
}

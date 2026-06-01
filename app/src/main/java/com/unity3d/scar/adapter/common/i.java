package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import j2.o;
import j2.q;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;
import q5.x;
import q6.c0;
import q6.l;
import q6.w;
import q6.y0;
import s4.k;
import z.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10979c;

    public /* synthetic */ i(int i2, Object obj, Object obj2) {
        this.f10977a = i2;
        this.f10979c = obj;
        this.f10978b = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10977a) {
            case 0:
                ((a4.d) this.f10979c).f3225c.show((Activity) this.f10978b);
                break;
            case 1:
                ((s4.h) ((k) this.f10979c)).b((e5.i) this.f10978b);
                break;
            case 2:
                o oVar = (o) this.f10979c;
                q qVar = (q) this.f10978b;
                if (qVar instanceof k2.a) {
                }
                try {
                    oVar.onSuccess(n7.b.u(qVar));
                } catch (ExecutionException e) {
                    oVar.onFailure(e.getCause());
                    return;
                } catch (Throwable th) {
                    oVar.onFailure(th);
                    return;
                }
                break;
            case 3:
                ((l) this.f10979c).B((y0) this.f10978b);
                break;
            case 4:
                ((l) this.f10978b).B((r6.c) this.f10979c);
                break;
            case 5:
                v3.a aVar = (v3.a) this.f10978b;
                android.support.v4.media.g gVar = (android.support.v4.media.g) this.f10979c;
                HashMap map = (HashMap) gVar.f3263b;
                if (map.size() <= 0) {
                    String str = (String) gVar.f3264c;
                    if (str != null) {
                        aVar.onSignalsCollectionFailed(str);
                    } else {
                        aVar.onSignalsCollected("");
                    }
                } else {
                    aVar.onSignalsCollected(new JSONObject(map).toString());
                }
                break;
            case 6:
                v6.g gVar2 = (v6.g) this.f10979c;
                w wVar = gVar2.f17626b;
                int i2 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f10978b).run();
                    } catch (Throwable th2) {
                        c0.r(v5.i.f17610a, th2);
                    }
                    Runnable runnableO = gVar2.o();
                    if (runnableO == null) {
                        break;
                    } else {
                        this.f10978b = runnableO;
                        i2++;
                        if (i2 >= 16 && wVar.isDispatchNeeded(gVar2)) {
                            wVar.dispatch(gVar2, this);
                            break;
                        }
                    }
                    break;
                }
                break;
            case 7:
                ((y6.e) ((y6.f) this.f10978b)).g((y6.b) this.f10979c, x.f13520a);
                break;
            case 8:
                n nVar = (n) this.f10979c;
                n.NV(nVar);
                if (nVar.zPa != null) {
                    nVar.zPa.obtainMessage(111, (SurfaceTexture) this.f10978b).sendToTarget();
                }
                break;
            case 9:
                n nVar2 = (n) this.f10979c;
                n.NV(nVar2);
                if (nVar2.zPa != null) {
                    nVar2.zPa.obtainMessage(110, (SurfaceHolder) this.f10978b).sendToTarget();
                }
                break;
            default:
                n nVar3 = (n) this.f10979c;
                n.NV(nVar3);
                if (nVar3.zPa != null) {
                    nVar3.zPa.obtainMessage(107, (com.bykv.vk.openvk.IlO.IlO.IlO.EO.a) this.f10978b).sendToTarget();
                }
                break;
        }
    }

    public String toString() {
        switch (this.f10977a) {
            case 2:
                e2.i iVarY = a.a.Y(this);
                o oVar = (o) this.f10979c;
                e2.h hVar = new e2.h();
                ((e2.h) iVarY.e).f11233c = hVar;
                iVarY.e = hVar;
                hVar.f11232b = oVar;
                return iVarY.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ i(int i2, Object obj, Object obj2, boolean z2) {
        this.f10977a = i2;
        this.f10978b = obj;
        this.f10979c = obj2;
    }
}

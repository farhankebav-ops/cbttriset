package z;

import com.bytedance.sdk.component.lEW.IlO.IlO;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f17885b;

    public /* synthetic */ k(n nVar, int i2) {
        this.f17884a = i2;
        this.f17885b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17884a) {
            case 0:
                n nVar = this.f17885b;
                if (nVar.NV == null) {
                    try {
                        nVar.NV = new j();
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                    if (nVar.NV != null) {
                        h unused = nVar.NV;
                        nVar.tl = "0";
                        ((j) nVar.NV).f17877a = nVar;
                        ((j) nVar.NV).f17878b = nVar;
                        ((j) nVar.NV).f17881f = nVar;
                        ((j) nVar.NV).f17879c = nVar;
                        ((j) nVar.NV).f17880d = nVar;
                        ((j) nVar.NV).g = nVar;
                        ((j) nVar.NV).e = nVar;
                        try {
                            ((j) nVar.NV).f17882i.setLooping(false);
                            break;
                        } catch (Throwable unused2) {
                        }
                        nVar.EV = false;
                        break;
                    }
                }
                break;
            case 1:
                n nVar2 = this.f17885b;
                if (nVar2.Bc() && nVar2.NV != null) {
                    try {
                        ((j) nVar2.NV).f17882i.start();
                        for (WeakReference weakReference : nVar2.EO) {
                            if (weakReference != null && weakReference.get() != null) {
                                ((r.b) weakReference.get()).Cc(nVar2);
                            }
                        }
                        nVar2.bWL = 206;
                    } catch (Throwable th2) {
                        th2.getMessage();
                        return;
                    }
                    break;
                }
                break;
            case 2:
                n nVar3 = this.f17885b;
                if (nVar3.zPa != null) {
                    nVar3.zPa.sendEmptyMessage(101);
                }
                break;
            case 3:
                n nVar4 = this.f17885b;
                if (nVar4.zPa != null) {
                    nVar4.zPa.sendEmptyMessage(101);
                }
                break;
            case 4:
                n nVar5 = this.f17885b;
                if (nVar5.zPa != null) {
                    nVar5.zPa.sendEmptyMessage(104);
                }
                break;
            case 5:
                n nVar6 = this.f17885b;
                if (nVar6.zPa != null && nVar6.zPa.getLooper() != null) {
                    try {
                        IlO.IlO().IlO(nVar6.zPa);
                        nVar6.zPa = null;
                    } catch (Throwable unused3) {
                        return;
                    }
                    break;
                }
                break;
            default:
                n nVar7 = this.f17885b;
                try {
                    ((j) nVar7.NV).f17882i.pause();
                    nVar7.bWL = 207;
                    nVar7.YA = false;
                } catch (Throwable unused4) {
                    return;
                }
                break;
        }
    }
}

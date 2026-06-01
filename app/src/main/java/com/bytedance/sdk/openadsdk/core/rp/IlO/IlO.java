package com.bytedance.sdk.openadsdk.core.rp.IlO;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.cl.tV;
import com.bytedance.sdk.openadsdk.core.EV.vCE;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.Cc;
import com.bytedance.sdk.openadsdk.core.rp.tV.EO;
import com.bytedance.sdk.openadsdk.core.widget.es;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import com.bytedance.sdk.openadsdk.utils.zLG;
import e0.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import w.b;
import w.c;
import w.d;
import w.e;
import w.g;
import x.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO implements e, vSq.IlO, com.bytedance.sdk.openadsdk.core.rp.MY.IlO {
    protected Cc Bc;
    protected SurfaceTexture Cc;

    @NonNull
    protected final Context EV;
    protected WeakReference<c> OOq;
    private long YA;
    protected MY kBB;

    @NonNull
    protected final oeT lEW;
    protected long lMM;
    protected vCE oc;
    protected boolean oeT;
    protected boolean pP;
    protected SurfaceHolder tV;
    protected final ViewGroup tl;
    protected EO vCE;
    protected long vSq;
    protected b wPn;
    protected boolean zPa;
    protected String IlO = "TTAD.VideoController";
    protected final int MY = 100;
    protected final vSq EO = new vSq(Looper.getMainLooper(), this);
    protected long DmF = 0;
    protected long NV = 0;
    protected final List<Runnable> rp = new ArrayList();
    protected boolean hp = false;
    protected boolean bWL = false;
    protected boolean ea = true;
    protected boolean cl = false;
    protected boolean cL = false;
    protected boolean es = false;
    protected AtomicBoolean xF = new AtomicBoolean(false);
    protected AtomicBoolean AXM = new AtomicBoolean(false);
    protected boolean vAh = true;
    protected boolean dY = false;
    protected Runnable nvX = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.IlO.IlO.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z2 = IlO.this.hp;
            IlO.this.es();
        }
    };
    private long mmj = 0;
    private boolean DM = true;
    private int zLG = 1;
    private final AtomicBoolean BS = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rp.IlO.IlO$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[es.IlO.values().length];
            IlO = iArr;
            try {
                iArr[es.IlO.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[es.IlO.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[es.IlO.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public IlO(Context context, @NonNull oeT oet, ViewGroup viewGroup) {
        this.lEW = oet;
        this.EV = context;
        this.tl = viewGroup;
        this.IlO += hashCode();
    }

    private void YA() {
        Cc cc = this.Bc;
        if (cc != null) {
            cc.tV(0);
            this.Bc.IlO(false, false);
            this.Bc.EO(false);
            this.Bc.Cc();
            this.Bc.Bc();
        }
    }

    private boolean ea() {
        Cc cc = this.Bc;
        if (cc != null) {
            return cc.hp() instanceof f;
        }
        return false;
    }

    public boolean AXM() {
        return this.ea;
    }

    @Override // w.e
    public final int Bc() {
        EO eo = this.vCE;
        if (eo == null) {
            return 0;
        }
        return eo.ea();
    }

    @Override // w.e
    public long Cc() {
        return this.DmF;
    }

    @Override // w.e
    public final int DmF() {
        return a.a(this.NV, this.lMM);
    }

    @Override // w.e
    public abstract /* synthetic */ void EO();

    public void EO(long j) {
        this.mmj = j;
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public abstract /* synthetic */ void IlO(g gVar, View view);

    public abstract /* synthetic */ void IlO(boolean z2, int i2);

    @Override // w.e
    public abstract /* synthetic */ void MY();

    public void MY(long j) {
        this.DmF = j;
        this.NV = Math.max(this.NV, j);
    }

    @Override // w.e
    public r.c NV() {
        return this.vCE;
    }

    public final void OOq() {
        if (oeT.vCE(this.lEW) && this.AXM.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.cl.EO.MY(new tV() { // from class: com.bytedance.sdk.openadsdk.core.rp.IlO.IlO.5
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    com.bytedance.sdk.openadsdk.cl.MY.IlO ilO = new com.bytedance.sdk.openadsdk.cl.MY.IlO();
                    try {
                        ilO.MY("video_player");
                        ilO.tV(zLG.IlO(IlO.this.lEW));
                        ilO.IlO(BuildConfig.VERSION_NAME);
                    } catch (Throwable unused) {
                    }
                    return ilO;
                }
            });
        }
    }

    @Override // w.e
    public boolean bWL() {
        return true;
    }

    public void cL() {
        if (this.rp.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.rp);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Runnable) obj).run();
        }
        this.rp.clear();
    }

    public void cl() {
        if (this.vCE == null) {
            return;
        }
        if (ea()) {
            SurfaceTexture surfaceTexture = this.Cc;
            if (surfaceTexture == null || surfaceTexture == this.vCE.es()) {
                return;
            }
            this.vCE.IlO(this.Cc);
            return;
        }
        SurfaceHolder surfaceHolder = this.tV;
        if (surfaceHolder == null || surfaceHolder == this.vCE.cL()) {
            return;
        }
        this.vCE.IlO(this.tV);
    }

    public int dY() {
        return this.zLG;
    }

    public void es() {
        this.EO.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.IlO.IlO.3
            @Override // java.lang.Runnable
            public void run() {
                IlO ilO = IlO.this;
                if (ilO.vCE != null) {
                    boolean z2 = ilO.hp;
                    IlO.this.vCE.NV();
                }
            }
        });
    }

    @Override // w.e
    public final boolean hp() {
        return this.pP;
    }

    public boolean kBB() {
        return this.DM;
    }

    @Override // w.e
    public final long lEW() {
        EO eo = this.vCE;
        if (eo == null) {
            return 0L;
        }
        return eo.zPa();
    }

    public final long lMM() {
        return vCE() + Cc();
    }

    public final void nvX() {
        com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.kBB.IlO.IlO(this.lEW.BO(), true, this.lEW), 5, this.lEW.ED());
    }

    public final void oc() {
        this.dY = true;
        ea.IlO ilO = new ea.IlO();
        ilO.MY(Cc());
        ilO.tV(lEW() / ((long) dY()));
        ilO.EO(vCE());
        ilO.IlO(zPa());
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(this.Bc, ilO);
    }

    public boolean oeT() {
        return this.cl;
    }

    public final boolean pP() {
        EO eo = this.vCE;
        return eo == null || eo.MY();
    }

    @Override // w.e
    public boolean rp() {
        return this.bWL;
    }

    @Override // w.e
    public abstract /* synthetic */ void tV();

    public void tV(long j) {
        this.lMM = j;
    }

    public final boolean tl() {
        EO eo = this.vCE;
        return eo != null && eo.vCE();
    }

    public boolean vAh() {
        return this.zPa;
    }

    @Override // w.e
    public final long vCE() {
        EO eo = this.vCE;
        if (eo == null) {
            return 0L;
        }
        return eo.bWL();
    }

    public final void vSq() {
        this.dY = true;
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(this.lEW, this.Bc, this.kBB);
    }

    public final void wPn() {
        this.dY = true;
        ea.IlO ilO = new ea.IlO();
        ilO.MY(Cc());
        ilO.tV(lEW() / ((long) dY()));
        ilO.EO(vCE());
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.MY(EV(), ilO);
    }

    @Override // w.e
    /* JADX INFO: renamed from: xF, reason: merged with bridge method [inline-methods] */
    public final Cc EV() {
        return this.Bc;
    }

    public long zPa() {
        return this.vSq;
    }

    public void Cc(boolean z2) {
        this.vAh = z2;
    }

    public void EO(boolean z2) {
        this.es = z2;
    }

    @Override // w.e
    public boolean IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        if (!oeT.vCE(this.lEW)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.cl.EO.IlO(new tV() { // from class: com.bytedance.sdk.openadsdk.core.rp.IlO.IlO.2
            @Override // com.bytedance.sdk.openadsdk.cl.tV
            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                com.bytedance.sdk.openadsdk.cl.MY.IlO ilO = new com.bytedance.sdk.openadsdk.cl.MY.IlO();
                try {
                    ilO.MY("video_player");
                    ilO.tV(zLG.IlO(IlO.this.lEW));
                    ilO.IlO(BuildConfig.VERSION_NAME);
                } catch (Throwable unused) {
                }
                return ilO;
            }
        });
        return false;
    }

    public final void tV(boolean z2) {
        this.DM = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO, w.f
    public final void Cc(g gVar, View view) {
        IlO(gVar, view, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void EO(g gVar, View view) {
        Cc cc = this.Bc;
        if (cc != null) {
            cc.DmF();
        }
        IlO(true, 3);
    }

    public void MY(Runnable runnable) {
        this.rp.add(runnable);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void tV(g gVar, View view) {
        if (this.es) {
            EO(false);
            Cc cc = this.Bc;
            if (cc != null) {
                cc.MY(this.tl);
            }
            IlO(1);
            return;
        }
        IlO(true, 3);
    }

    public final void Cc(long j) {
        this.DmF = j;
        this.NV = Math.max(this.NV, j);
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO();
        }
        EO eo = this.vCE;
        if (eo != null) {
            eo.IlO(true, this.DmF, this.zPa);
        }
    }

    public void IlO(Runnable runnable) {
        if (this.Bc.oeT() && this.hp) {
            runnable.run();
        } else {
            MY(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public void MY(g gVar, SurfaceHolder surfaceHolder) {
        this.hp = false;
        this.tV = null;
        EO eo = this.vCE;
        if (eo != null) {
            eo.IlO(false);
        }
    }

    private boolean EO(int i2) {
        return this.Bc.MY(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public void IlO(g gVar, SurfaceHolder surfaceHolder) {
        this.hp = true;
        this.tV = surfaceHolder;
        EO eo = this.vCE;
        if (eo == null) {
            return;
        }
        eo.IlO(surfaceHolder);
        cL();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public void MY(g gVar, SurfaceTexture surfaceTexture) {
        this.hp = false;
        EO eo = this.vCE;
        if (eo != null) {
            eo.IlO(false);
        }
        this.Cc = null;
        cL();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public void IlO(g gVar, SurfaceTexture surfaceTexture) {
        this.hp = true;
        this.Cc = surfaceTexture;
        EO eo = this.vCE;
        if (eo != null) {
            eo.IlO(surfaceTexture);
            this.vCE.IlO(this.hp);
        }
        cL();
    }

    public final void MY(boolean z2) {
        this.bWL = z2;
    }

    public void MY(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        MY my = (MY) aVar;
        this.kBB = my;
        this.zPa = my.EV();
        aVar.tV(String.valueOf(this.lEW.hFV()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void MY(g gVar, View view) {
        MY(gVar, view, false, false);
    }

    public void IlO(boolean z2) {
        this.ea = z2;
        Cc cc = this.Bc;
        if (cc != null) {
            cc.tV(z2);
        }
    }

    public final void MY(g gVar, View view, boolean z2, boolean z7) {
        EO(!this.es);
        Context context = this.EV;
        if (context != null && (context instanceof Activity)) {
            if (this.es) {
                IlO(z2 ? 8 : 0);
                Cc cc = this.Bc;
                if (cc != null) {
                    cc.IlO(this.tl);
                    this.Bc.EO(false);
                }
            } else {
                IlO(1);
                Cc cc2 = this.Bc;
                if (cc2 != null) {
                    cc2.MY(this.tl);
                    this.Bc.EO(false);
                }
            }
            WeakReference<c> weakReference = this.OOq;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar != null) {
                cVar.IlO(this.es);
            }
        }
    }

    @Override // w.e
    public final void IlO(final boolean z2, String str) {
        this.zPa = z2;
        EO eo = this.vCE;
        if (eo != null) {
            eo.MY(z2);
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(this.Bc, z2, str);
        }
        if (this.oc != null) {
            if (n7.b.b()) {
                this.oc.IlO(z2);
            } else {
                this.EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.IlO.IlO.4
                    @Override // java.lang.Runnable
                    public void run() {
                        IlO.this.oc.IlO(z2);
                    }
                });
            }
        }
    }

    public final void IlO(c cVar) {
        this.OOq = new WeakReference<>(cVar);
    }

    public void IlO(g gVar, View view, boolean z2) {
    }

    public final void IlO(int i2) {
        Context context = this.EV;
        if (context == null) {
            return;
        }
        boolean z2 = i2 == 0 || i2 == 8;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                activity.setRequestedOrientation(i2);
            } catch (Throwable unused) {
            }
            if (!z2) {
                activity.getWindow().setFlags(1024, 1024);
            } else {
                activity.getWindow().clearFlags(1024);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void MY(g gVar, int i2) {
        Cc cc = this.Bc;
        if (cc != null) {
            cc.vCE();
        }
    }

    public final void MY(Bc bc) {
        this.dY = true;
        ea.IlO ilO = new ea.IlO();
        ilO.MY(Cc());
        ilO.tV(lEW() / ((long) dY()));
        ilO.EO(vCE());
        ilO.tV(Bc());
        ilO.IlO(zPa());
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.MY(this.Bc, ilO, bc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void IlO(g gVar, View view, boolean z2, boolean z7) {
        if (this.ea) {
            IlO();
        }
        if (z2 && !this.ea && !pP()) {
            this.Bc.MY(!tl(), false);
            this.Bc.IlO(z7, true, false);
        }
        EO eo = this.vCE;
        if (eo != null && eo.vCE()) {
            this.Bc.vCE();
            this.Bc.Cc();
        } else {
            this.Bc.vCE();
        }
    }

    public void MY(int i2) {
        this.zLG = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void IlO(g gVar, int i2, boolean z2) {
        if (this.EV == null) {
            return;
        }
        long j = (long) (((((long) i2) * r0) * 1.0f) / 100.0f);
        if (this.lMM > 0) {
            this.YA = (int) j;
        } else {
            this.YA = 0L;
        }
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO(this.YA);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void IlO(g gVar, int i2) {
        if (this.vCE == null) {
            return;
        }
        IlO(this.YA, EO(i2));
    }

    private void IlO(long j, boolean z2) {
        if (this.vCE == null) {
            return;
        }
        if (z2) {
            YA();
        }
        this.vCE.IlO(j);
    }

    public final void IlO(Bc bc) {
        if (this.xF.compareAndSet(false, true)) {
            this.dY = true;
            vCE vce = this.oc;
            if (vce != null) {
                vce.IlO(lEW(), vAh());
            }
            ea.IlO ilO = new ea.IlO();
            ilO.IlO(kBB());
            ilO.tV(lEW());
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(cl.IlO(), this.Bc, ilO, bc);
        }
    }

    public final void IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar) {
        this.dY = true;
        ea.IlO ilO = new ea.IlO();
        ilO.EO(vCE());
        ilO.tV(lEW() / ((long) dY()));
        ilO.MY(Cc());
        ilO.IlO(bVar);
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.EO(EV(), ilO);
    }

    @Override // w.e
    public final void IlO(b bVar) {
        this.wPn = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public final void IlO(es.IlO ilO, String str) {
        int i2 = AnonymousClass6.IlO[ilO.ordinal()];
        if (i2 == 1) {
            IlO();
            return;
        }
        if (i2 == 2) {
            EO();
        } else {
            if (i2 != 3) {
                return;
            }
            MY();
            this.cl = false;
            this.cL = true;
        }
    }

    public void IlO(d dVar) {
    }

    @Override // w.e
    public final void IlO() {
        EO eo = this.vCE;
        if (eo != null) {
            eo.EV();
        }
        if (this.oeT || !this.xF.get()) {
            return;
        }
        oc();
    }

    @Override // w.e
    public void IlO(long j) {
        this.vSq = j;
    }

    @Override // w.e
    public boolean IlO(float f4) {
        EO eo = this.vCE;
        if (eo != null) {
            return eo.IlO(f4);
        }
        return false;
    }

    public void IlO(long j, long j3) {
        if (!this.BS.get() && com.bytedance.sdk.openadsdk.vCE.IlO.IlO().EO() && (j * 1.0d) / j3 > 0.3d) {
            this.BS.set(true);
            if (this.lEW != null) {
                com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("videoPercent30", this.lEW);
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.core.rp.MY;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.component.utils.DmF;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.bWL.bWL;
import com.bytedance.sdk.openadsdk.bWL.hp;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.kBB;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import e0.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import r.b;
import r.c;
import w.d;
import w.g;
import x.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.sdk.openadsdk.core.rp.IlO.IlO {
    private WeakReference<IlO> AK;
    private final boolean BS;
    private final boolean DM;
    private int Dxv;
    private MY Ea;
    private WeakReference<d> HSR;
    private final Runnable Jz;
    private Bc KC;
    private long YA;
    private final b fdM;
    private boolean gQ;
    private int hL;
    private boolean ii;
    private long mmj;
    private int nm;
    private int quf;
    private final boolean ssS;
    private int uvo;
    private final wPn.IlO wD;
    private final String zLG;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(int i2);

        void vCE();
    }

    public EO(Context context, ViewGroup viewGroup, oeT oet, String str, boolean z2, boolean z7, boolean z8, Bc bc) {
        super(context, oet, viewGroup);
        this.YA = 0L;
        this.mmj = 0L;
        this.gQ = true;
        this.quf = 0;
        this.uvo = 0;
        this.fdM = new b() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1
            @Override // r.b
            public void Cc(c cVar) {
                com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW.QfH();
                if (ilOQfH != null && ilOQfH.IlO() != null) {
                    ilOQfH.IlO().EO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).DmF);
                }
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.IlO(1);
                }
            }

            @Override // r.b
            public void IlO(c cVar) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 5);
                            com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 5);
                            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.IlO(9);
                            }
                        } catch (Exception unused) {
                        }
                        EO.this.BS();
                    }
                });
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW.QfH() == null || ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW.QfH().IlO() == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW.QfH().IlO().tV(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).DmF);
            }

            @Override // r.b
            public void MY(c cVar) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.removeCallbacks(EO.this.Jz);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (EO.this.HSR != null && EO.this.HSR.get() != null) {
                            EO.this.HSR.get();
                        }
                        if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc != null) {
                            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.MY();
                        }
                    }
                });
                if (EO.this.DM) {
                    return;
                }
                EO eo = EO.this;
                eo.IlO(eo.KC);
            }

            @Override // r.b
            public void tV(c cVar) {
                com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW.QfH();
                if (ilOQfH != null && ilOQfH.IlO() != null) {
                    ilOQfH.IlO().MY(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).DmF);
                }
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 3);
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.IlO(0);
                }
            }

            @Override // r.b
            public void IlO(c cVar, long j) {
                if (!((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).AXM.get()) {
                    EO.this.OOq();
                }
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).pP = false;
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.removeCallbacks(EO.this.Jz);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc != null) {
                            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.MY();
                        }
                        if (!((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).ea || EO.this.AK == null || EO.this.AK.get() == null) {
                            return;
                        }
                        ((IlO) EO.this.AK.get()).vCE();
                    }
                });
                EO.this.nvX();
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 0);
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.EO();
                }
                EO eo = EO.this;
                eo.IlO(eo.KC);
            }

            @Override // r.b
            public void MY(c cVar, int i2) {
            }

            @Override // r.b
            public void IlO(c cVar, final com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar) {
                if (oeT.vCE(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW)) {
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.5
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            com.bytedance.sdk.openadsdk.cl.MY.IlO ilO = new com.bytedance.sdk.openadsdk.cl.MY.IlO();
                            try {
                                ilO.MY("video_player");
                                ilO.tV(zLG.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW));
                                ilO.IlO(BuildConfig.VERSION_NAME);
                            } catch (Throwable unused) {
                            }
                            return ilO;
                        }
                    });
                }
                String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).IlO;
                int i2 = bVar.f4682a;
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar2 = bVar;
                        int i8 = bVar2.f4682a;
                        int i9 = bVar2.f4683b;
                        if (!EO.this.tl() || i9 == -1004) {
                            if (EO.this.tV(i8, i9)) {
                                String unused2 = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).IlO;
                                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, (WeakReference<Context>) null, false);
                                EO.this.MY(true);
                                EO.this.tV();
                            }
                            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc != null) {
                                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.MY();
                            }
                            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).wPn != null) {
                                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).wPn.MY(EO.this.mmj, a.a(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).DmF, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lMM));
                            }
                            if (EO.this.HSR == null || EO.this.HSR.get() == null || EO.this.tl()) {
                                return;
                            }
                            ((d) EO.this.HSR.get()).IlO(i8, i9);
                        }
                    }
                });
                EO.this.IlO(bVar);
                com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW.QfH();
                if (ilOQfH != null && ilOQfH.IlO() != null) {
                    ilOQfH.IlO().IlO(com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.GENERAL_LINEAR_AD_ERROR);
                }
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 6);
                com.bytedance.sdk.openadsdk.kBB.IlO.EO.MY(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW);
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.IlO(14);
                }
            }

            @Override // r.b
            public void IlO(c cVar, boolean z9) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc != null) {
                            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.MY();
                        }
                    }
                });
            }

            @Override // r.b
            public void EO(c cVar) {
            }

            @Override // r.b
            public void IlO(c cVar, int i2, int i8) {
                DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        EO.this.gQ();
                    }
                });
            }

            @Override // r.b
            public void IlO(c cVar, int i2, int i8, int i9) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).pP = true;
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc != null) {
                            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.cl();
                            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.postDelayed(EO.this.Jz, 8000L);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 2);
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.IlO(4);
                }
            }

            @Override // r.b
            public void IlO(c cVar, int i2) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).pP = false;
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.removeCallbacks(EO.this.Jz);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.10
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.MY();
                    }
                });
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, 0);
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).oc.IlO(5);
                }
            }

            @Override // r.b
            public void IlO(c cVar, final long j, final long j3) {
                if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).DmF) < 50) {
                    return;
                }
                if (!((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).AXM.get()) {
                    EO.this.OOq();
                }
                EO eo = EO.this;
                eo.IlO(eo.KC);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EO.this.IlO(j, j3);
                        EO.this.MY(j, j3);
                    }
                });
            }
        };
        this.hL = 0;
        this.Jz = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.4
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc != null) {
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).lEW, (WeakReference<Context>) null, false);
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.MY();
                    EO.this.MY(true);
                    String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).IlO;
                }
            }
        };
        this.wD = new wPn.IlO() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.6
            @Override // com.bytedance.sdk.component.utils.wPn.IlO
            @WorkerThread
            public void IlO(Context context2, Intent intent, boolean z9, final int i2) {
                mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EO.this.vCE(i2);
                    }
                });
            }
        };
        this.ii = false;
        this.nm = xF.EO(context);
        IlO(z2);
        this.zLG = str;
        try {
            this.quf = viewGroup.getWidth();
            this.uvo = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        IlO(context);
        this.DM = true;
        this.BS = z7;
        this.ssS = z8;
        if (bc != null) {
            this.KC = bc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tV(int i2, int i8) {
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i8 == 1 || i8 == 700 || i8 == 800) {
            return true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        this.hL++;
        Cc cc = this.Bc;
        if (cc == null) {
            return;
        }
        cc.MY();
        w.b bVar = this.wPn;
        if (bVar != null) {
            bVar.IlO(this.mmj, a.a(this.DmF, this.lMM));
        }
        this.mmj = System.currentTimeMillis() - this.YA;
        if (this.gQ) {
            this.Bc.IlO(this.lEW, (WeakReference<Context>) null, true);
        }
        if (!this.oeT) {
            this.oeT = true;
            long j = this.lMM;
            MY(j, j);
            long j3 = this.lMM;
            this.DmF = j3;
            this.NV = j3;
            MY(this.KC);
        }
        if (!this.ea && this.es) {
            Cc(this.Bc, null);
        }
        this.bWL = true;
    }

    private void Cc(int i2) {
        if (this.nm == i2) {
            return;
        }
        this.nm = i2;
        if (i2 != 4 && i2 != 0) {
            this.cL = false;
        }
        if (!this.cL && !rp() && this.BS) {
            EO(2, i2);
        }
        WeakReference<IlO> weakReference = this.AK;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.AK.get().IlO(this.nm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e HSR() {
        Cc cc;
        if (this.EV.getResources().getConfiguration().orientation != 1 || (cc = this.Bc) == null) {
            return null;
        }
        return cc.hp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gQ() {
        com.bytedance.sdk.openadsdk.core.rp.tV.EO eo;
        int i2;
        int i8;
        try {
            if (HSR() != null && (eo = this.vCE) != null && this.tl != null) {
                int iTV = eo.tV();
                int iCc = this.vCE.Cc();
                final int width = this.tl.getWidth();
                final int height = this.tl.getHeight();
                if (width > 0 && height > 0 && iCc > 0 && iTV > 0) {
                    if (iTV == iCc) {
                        i8 = width > height ? height : width;
                        i2 = i8;
                    } else if (iTV > iCc) {
                        i8 = (int) ((((double) width) * 1.0d) / ((double) ((iTV * 1.0f) / iCc)));
                        i2 = width;
                    } else {
                        i2 = (int) ((((double) height) * 1.0d) / ((double) ((iCc * 1.0f) / iTV)));
                        i8 = height;
                    }
                    if (i8 <= height && i8 > 0) {
                        height = i8;
                    }
                    if (i2 <= width && i2 > 0) {
                        width = i2;
                    }
                    this.EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                                layoutParams.addRule(13);
                                if (EO.this.HSR() instanceof TextureView) {
                                    ((TextureView) EO.this.HSR()).setLayoutParams(layoutParams);
                                    String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).IlO;
                                } else if (EO.this.HSR() instanceof SurfaceView) {
                                    ((SurfaceView) EO.this.HSR()).setLayoutParams(layoutParams);
                                    String unused2 = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).IlO;
                                }
                            } catch (Throwable unused3) {
                                String unused4 = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).IlO;
                            }
                        }
                    });
                    return;
                }
                return;
            }
            Objects.toString(this.EV);
            Objects.toString(HSR());
        } catch (Throwable th) {
            th.toString();
        }
    }

    private void ssS() {
        com.bytedance.sdk.openadsdk.core.rp.tV.EO eo = this.vCE;
        if (eo != null) {
            if (!eo.Bc()) {
                this.vCE.IlO(false, this.DmF, this.zPa);
            } else if (this.hp) {
                es();
            } else {
                MY(this.nvX);
            }
        }
        if (this.xF.get()) {
            wPn();
        }
    }

    public void Bc(boolean z2) {
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO();
        }
        Cc cc2 = this.Bc;
        if (cc2 != null && z2) {
            cc2.cL();
        }
        ssS();
    }

    public void DM() {
        if (this.vCE != null) {
            MY(false);
            vSq();
            this.xF.set(false);
            this.oeT = false;
            IlO(this.KC);
            this.vCE.DmF();
        }
    }

    public void YA() {
        if (this.ii && this.vAh) {
            this.ii = false;
            wPn.IlO(this.wD);
        }
    }

    public void ea() {
        if (this.ii || !this.vAh) {
            return;
        }
        Context applicationContext = cl.IlO().getApplicationContext();
        this.ii = true;
        wPn.IlO(this.wD, applicationContext);
    }

    public void mmj() {
        com.bytedance.sdk.openadsdk.core.EV.vCE vce = this.oc;
        if (vce != null) {
            vce.IlO(13);
        }
    }

    public void vCE(boolean z2) {
        this.gQ = z2;
    }

    public int zLG() {
        return this.Dxv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vCE(int i2) {
        Cc(i2);
        if (i2 == 4) {
            this.cl = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public void tV() {
        com.bytedance.sdk.openadsdk.core.rp.tV.EO eo = this.vCE;
        if (eo != null) {
            eo.rp();
            this.vCE = null;
        }
        if (this.gQ) {
            if (!"embeded_ad".equals(this.zLG)) {
                this.Bc.IlO(this.lEW, (WeakReference<Context>) null, true);
            } else {
                this.Bc.xF();
            }
            this.EO.removeCallbacksAndMessages(null);
            this.rp.clear();
            if (this.ea) {
                YA();
            }
        }
    }

    private void EO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        aVar.tV(0);
        this.vCE.IlO(aVar);
        this.YA = System.currentTimeMillis();
        this.Bc.EO(8);
        this.Bc.EO(0);
        IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).vCE == null) {
                    return;
                }
                EO.this.YA = System.currentTimeMillis();
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).Bc.tV(0);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).vCE.IlO(true, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).DmF, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) EO.this).zPa);
            }
        });
        if (this.ea) {
            ea();
        }
    }

    public void MY(int i2, int i8) {
        IlO(i2, i8);
        Cc cc = this.Bc;
        if (cc == null || i2 <= 0 || i8 <= 0) {
            return;
        }
        cc.EO(i2, i8);
        this.Bc.IlO(i2, i8);
        gQ();
    }

    public void IlO(final vCE.IlO ilO) {
        Cc cc;
        if (!this.ea || (cc = this.Bc) == null) {
            return;
        }
        cc.IlO(new vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.EO.2
            @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE.IlO
            public void IlO(View view, int i2) {
                vCE.IlO ilO2 = ilO;
                if (ilO2 != null) {
                    ilO2.IlO(view, i2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public void MY() {
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO();
        }
        Cc cc2 = this.Bc;
        if (cc2 != null) {
            cc2.cL();
        }
        ssS();
    }

    public void IlO(PAGNativeAd pAGNativeAd) {
        Cc cc;
        if (!this.ea || (cc = this.Bc) == null) {
            return;
        }
        cc.IlO(pAGNativeAd);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public void EO() {
        IlO(true, 3);
    }

    private boolean EO(int i2, int i8) {
        if (i8 == 0) {
            IlO();
            this.cl = true;
            Cc cc = this.Bc;
            if (cc != null) {
                cc.IlO(this.lEW, (WeakReference<Context>) null, false);
            }
        }
        if (i8 != 4 && i8 != 0) {
            Cc cc2 = this.Bc;
            if (cc2 != null) {
                cc2.IlO();
            }
            IlO();
            this.cl = true;
            this.cL = false;
            Cc cc3 = this.Bc;
            if (cc3 != null) {
                return cc3.IlO(i2, this.lEW.fdM(), this.ssS);
            }
        } else if (i8 == 4) {
            this.cl = false;
            Cc cc4 = this.Bc;
            if (cc4 != null) {
                cc4.ea();
            }
        }
        return true;
    }

    public void IlO(int i2, int i8) {
        if (i2 == 0 || i8 == 0) {
            return;
        }
        this.quf = i2;
        this.uvo = i8;
    }

    public void tV(int i2) {
        this.Dxv = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(long j, long j3) {
        this.lEW.EO(j);
        this.DmF = j;
        this.lMM = j3;
        this.Bc.IlO(j, j3);
        this.Bc.IlO(a.a(j, j3));
        try {
            w.b bVar = this.wPn;
            if (bVar != null) {
                bVar.IlO(j, j3);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO(this.IlO, "onProgressUpdate error: ", th);
        }
        com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = this.lEW.QfH();
        if (ilOQfH == null || ilOQfH.IlO() == null) {
            return;
        }
        ilOQfH.IlO().IlO(j, j3, this.oc);
    }

    public void IlO(MY my) {
        this.Ea = my;
    }

    private void IlO(Context context) {
        ViewGroup hpVar;
        EO eo;
        if (this.ea) {
            hpVar = new bWL(context);
        } else {
            hpVar = new hp(context);
        }
        ViewGroup viewGroup = hpVar;
        if (this.ea) {
            eo = this;
            eo.Bc = new Cc(context, viewGroup, true, 17, this.lEW, eo, AXM());
        } else {
            eo = this;
            eo.Bc = new tV(context, viewGroup, true, 17, eo.lEW, eo, false);
        }
        eo.Bc.IlO(this);
    }

    public com.bytedance.sdk.openadsdk.core.EV.vCE IlO(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.lEW.xJ()) {
            return null;
        }
        if (this.oc == null) {
            this.oc = com.bytedance.sdk.openadsdk.core.EV.vCE.IlO();
        }
        this.oc.IlO(view, this.lEW.QfH().bWL());
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    Object obj = pair.second;
                    this.oc.IlO((View) pair.first, obj == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) obj);
                }
            }
        }
        return this.oc;
    }

    public void EO(int i2) {
        Cc(i2);
        if (i2 == 4) {
            this.cl = false;
            MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO
    public void IlO(d dVar) {
        this.HSR = new WeakReference<>(dVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public boolean IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        super.IlO(aVar);
        if (this.vCE != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(aVar.zPa())) {
            return false;
        }
        MY(false);
        aVar.zPa();
        aVar.MY(com.bytedance.sdk.openadsdk.AXM.IlO.IlO("player_force_raw_url", 0) == 1);
        int i2 = this.Dxv + 1;
        this.Dxv = i2;
        aVar.Cc = i2;
        MY(aVar);
        vSq();
        com.bytedance.sdk.openadsdk.core.EV.vCE vce = this.oc;
        if (vce != null) {
            vce.IlO(false, 0.0f);
        }
        if (!kBB.MY(this.zLG) || this.DmF <= 0) {
            this.DmF = aVar.NV();
        }
        if (kBB.MY(this.zLG) && this.DmF == this.lMM) {
            this.DmF = 0L;
        }
        if (aVar.NV() <= 0) {
            this.oeT = false;
            this.xF.set(false);
        } else {
            long jNV = aVar.NV();
            this.DmF = jNV;
            this.NV = Math.max(this.NV, jNV);
        }
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO();
            if (this.hL == 0) {
                this.Bc.Bc();
            }
            this.Bc.EO(aVar.lEW(), aVar.DmF());
            this.Bc.EO(this.tl);
            this.Bc.IlO(aVar.lEW(), aVar.DmF());
        }
        if (this.vCE == null) {
            com.bytedance.sdk.openadsdk.core.rp.tV.EO eo = new com.bytedance.sdk.openadsdk.core.rp.tV.EO();
            this.vCE = eo;
            eo.IlO(this.fdM);
        }
        cl();
        this.mmj = 0L;
        try {
            EO(aVar);
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar = new com.bykv.vk.openvk.IlO.IlO.IlO.EO.b();
            bVar.f4682a = -10;
            bVar.f4683b = 0;
            bVar.f4684c = message;
            IlO(bVar);
            com.bytedance.sdk.component.utils.oeT.EO(this.IlO, "[video] invoke NativeVideoController#playVideo cause exception :".concat(String.valueOf(e)));
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO
    public void IlO(boolean z2, int i2) {
        if (!this.oeT && this.xF.get()) {
            if (z2) {
                IlO(i2, false);
                this.oeT = false;
            } else {
                oc();
            }
        }
        tV();
        com.bytedance.sdk.openadsdk.core.EV.vCE vce = this.oc;
        if (vce != null) {
            vce.tV();
        }
    }

    public final void IlO(int i2, boolean z2) {
        if (z2 || this.dY) {
            if (z2) {
                this.dY = false;
            }
            if (this.oeT || !this.xF.get()) {
                return;
            }
            ea.IlO ilO = new ea.IlO();
            ilO.MY(Cc());
            ilO.tV(lEW());
            ilO.EO(vCE());
            ilO.EO(i2);
            ilO.tV(Bc());
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(this.Bc, ilO, this.KC);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public void IlO(g gVar, View view) {
        com.bytedance.sdk.openadsdk.core.rp.tV.EO eo = this.vCE;
        if (eo == null) {
            return;
        }
        if (eo.vCE()) {
            IlO();
            this.Bc.MY(true, false);
            this.Bc.vCE();
            return;
        }
        if (!this.vCE.Bc()) {
            Cc cc = this.Bc;
            if (cc != null) {
                cc.EO(this.tl);
            }
            Cc(this.DmF);
            Cc cc2 = this.Bc;
            if (cc2 != null) {
                cc2.MY(false, false);
                return;
            }
            return;
        }
        Bc(false);
        Cc cc3 = this.Bc;
        if (cc3 != null) {
            cc3.MY(false, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO
    public void IlO(g gVar, View view, boolean z2) {
        EO(!this.es);
        if (this.EV instanceof Activity) {
            Cc cc = this.Bc;
            if (cc != null) {
                cc.MY(this.tl);
                this.Bc.EO(false);
            }
            IlO(1);
            WeakReference<w.c> weakReference = this.OOq;
            w.c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar != null) {
                cVar.IlO(this.es);
            }
        }
    }

    public void IlO(IlO ilO) {
        this.AK = new WeakReference<>(ilO);
    }
}

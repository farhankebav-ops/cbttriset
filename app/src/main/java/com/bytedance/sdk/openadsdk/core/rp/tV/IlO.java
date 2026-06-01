package com.bytedance.sdk.openadsdk.core.rp.tV;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.utils.DmF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.bWL.bWL;
import com.bytedance.sdk.openadsdk.core.EV.vCE;
import com.bytedance.sdk.openadsdk.core.NV.tV;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.Cc;
import com.bytedance.sdk.openadsdk.core.rp.tV.EO;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import e0.a;
import java.util.Objects;
import r.c;
import w.b;
import w.g;
import x.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.openadsdk.core.rp.IlO.IlO {
    private final Runnable AK;
    private long BS;
    final EO.MY DM;
    private final int HSR;
    protected long YA;
    private boolean gQ;
    protected boolean mmj;
    private InterfaceC0108IlO quf;
    private long ssS;
    private final Bc zLG;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rp.tV.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0108IlO {
        void IlO(int i2);
    }

    public IlO(Context context, ViewGroup viewGroup, oeT oet, Bc bc) {
        super(context, oet, viewGroup);
        this.BS = 0L;
        this.ssS = 0L;
        this.gQ = false;
        this.YA = 0L;
        this.mmj = false;
        this.DM = new AnonymousClass1();
        this.AK = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).wPn != null) {
                    IlO.this.ea();
                    ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).wPn.IlO();
                }
            }
        };
        this.zLG = bc;
        this.HSR = oet.hFV();
        if (oet.xJ() && oet.QfH() != null && this.tl != null) {
            if (this.oc == null) {
                this.oc = vCE.IlO();
            }
            this.oc.IlO(this.tl, oet.QfH().bWL());
        }
        Cc cc = new Cc(context.getApplicationContext(), new bWL(context), true, 17, this.lEW, this);
        this.Bc = cc;
        cc.IlO(this);
    }

    public void ea() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO
    public boolean kBB() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AK() {
        return this.lEW.La() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HSR() {
        if (this.Bc == null) {
            return;
        }
        this.EO.removeCallbacks(this.AK);
        this.Bc.MY();
        this.ssS = System.currentTimeMillis() - this.BS;
        if (!this.gQ) {
            this.gQ = true;
            long j = this.lMM;
            MY(j, j);
            long j3 = this.lMM;
            this.DmF = j3;
            this.NV = j3;
            MY(this.zLG);
        }
        b bVar = this.wPn;
        if (bVar != null) {
            bVar.IlO(this.ssS, a.a(this.DmF, this.lMM));
        }
        this.bWL = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gQ() {
        int i2 = this.kBB.vCE;
        int iZLG = (i2 == 2 || i2 == 1) ? cl.tV().zLG() * 1000 : i2 == 4 ? cl.tV().lEW(String.valueOf(this.HSR)) : 5000;
        this.EO.removeCallbacks(this.AK);
        this.EO.postDelayed(this.AK, iZLG);
    }

    private boolean quf() {
        return DM() == null || this.vCE == null || (!tV.IlO(this.lEW.nvX()) ? this.lEW.uvo() != null : this.lEW.Ea() != null) || this.lEW.zLG() == 1;
    }

    private void ssS() {
        this.vCE.EO(dY());
        this.vCE.IlO(this.kBB);
        this.BS = System.currentTimeMillis();
        this.Bc.EO(8);
        this.Bc.EO(0);
        IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.2
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).vCE == null) {
                    return;
                }
                IlO.this.BS = System.currentTimeMillis();
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.tV(0);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).vCE.IlO(true, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).DmF, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).zPa);
            }
        });
    }

    public void BS() {
        vCE vce = this.oc;
        if (vce != null) {
            vce.IlO(13);
        }
    }

    public e DM() {
        Cc cc = this.Bc;
        if (cc != null) {
            return cc.hp();
        }
        return null;
    }

    public void YA() {
        this.DM.IlO((c) null, 0, 0);
    }

    public void mmj() {
        if (this.gQ || !this.xF.get()) {
            return;
        }
        wPn();
        com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = this.lEW.QfH();
        if (ilOQfH == null || ilOQfH.IlO() == null) {
            return;
        }
        ilOQfH.IlO().EO(Cc());
    }

    public void zLG() {
        vCE vce = this.oc;
        if (vce != null) {
            vce.IlO(2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rp.tV.IlO$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 implements EO.MY {
        private boolean MY = true;

        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void Cc(c cVar) {
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 0);
            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.IlO(1);
            }
            if (IlO.this.quf != null) {
                IlO.this.quf.IlO(1);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void EO(c cVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                        try {
                            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.IlO(9);
                        } catch (Exception unused2) {
                        }
                    }
                    IlO.this.HSR();
                }
            });
            com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW.QfH();
            if (ilOQfH != null && ilOQfH.IlO() != null) {
                long jCc = IlO.this.Cc();
                ilOQfH.IlO().tV(jCc);
                ilOQfH.IlO().Cc(jCc);
            }
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 5);
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 5);
            if (IlO.this.quf != null) {
                IlO.this.quf.IlO(3);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void MY(c cVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.removeCallbacks(IlO.this.AK);
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.MY();
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void tV(c cVar) {
            com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW.QfH();
            if (ilOQfH != null && ilOQfH.IlO() != null) {
                ilOQfH.IlO().MY(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).DmF);
            }
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 3);
            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.IlO(0);
            }
            if (IlO.this.quf != null) {
                IlO.this.quf.IlO(2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void MY(c cVar, int i2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, long j) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            if (!((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).xF.get()) {
                IlO.this.OOq();
            }
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).pP = false;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.removeCallbacks(IlO.this.AK);
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.MY();
                    }
                }
            });
            if (!((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).xF.get()) {
                IlO ilO = IlO.this;
                ilO.YA = j;
                ilO.IlO(ilO.zLG);
                IlO.this.nvX();
            }
            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.EO();
            }
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            int i2 = bVar.f4682a;
            if (oeT.vCE(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW)) {
                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.5
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        com.bytedance.sdk.openadsdk.cl.MY.IlO ilO = new com.bytedance.sdk.openadsdk.cl.MY.IlO();
                        try {
                            ilO.MY("video_player");
                            ilO.tV(zLG.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW));
                            ilO.IlO(BuildConfig.VERSION_NAME);
                        } catch (Throwable unused2) {
                        }
                        return ilO;
                    }
                });
            }
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.removeCallbacks(IlO.this.AK);
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.6
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.MY();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).wPn != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).wPn.MY(IlO.this.ssS, a.a(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).DmF, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lMM));
                    }
                }
            });
            IlO.this.IlO(bVar);
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 6);
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.MY(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW);
            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.IlO(14);
            }
            if (IlO.this.quf != null) {
                IlO.this.quf.IlO(4);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, boolean z2) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.removeCallbacks(IlO.this.AK);
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.MY();
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, int i2, int i8) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).vCE == null) {
                        return;
                    }
                    try {
                        final float fTV = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).vCE.tV();
                        final float fCc = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).vCE.Cc();
                        if (fTV == 0.0f || fCc == 0.0f) {
                            return;
                        }
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!IlO.this.AK()) {
                                    IlO.this.IlO(fTV, fCc);
                                    return;
                                }
                                if (es.MY(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW) || ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).kBB.vCE == 4) {
                                    IlO.this.IlO(true, fTV, fCc);
                                    return;
                                }
                                if (es.EO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW)) {
                                    IlO.this.IlO(true, fTV, fCc);
                                    return;
                                }
                                if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW.DM() == 3) {
                                    IlO.this.IlO(true, fTV, fCc);
                                } else if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW.DM() == 0) {
                                    IlO.this.EO(fTV, fCc);
                                } else {
                                    IlO.this.MY(fTV, fCc);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.EO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO, th.getMessage());
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, int i2, int i8, int i9) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).pP = true;
            IlO.this.gQ();
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.cl();
                    }
                }
            });
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 3);
            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.IlO(4);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, int i2) {
            String unused = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).pP = false;
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.removeCallbacks(IlO.this.AK);
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.10
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.MY();
                    }
                }
            });
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW, 0);
            if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc != null) {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc.IlO(5);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY, r.b
        public void IlO(c cVar, long j, long j3) {
            long j8;
            long j9;
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).DmF) < 50) {
                return;
            }
            if (!((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).xF.get()) {
                IlO.this.OOq();
            }
            IlO ilO = IlO.this;
            ilO.IlO(ilO.zLG);
            IlO.this.IlO(j, j3);
            IlO.this.MY(j, j3);
            com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW.QfH();
            if (ilOQfH == null || ilOQfH.IlO() == null) {
                j8 = j;
                j9 = j3;
            } else {
                j8 = j;
                j9 = j3;
                ilOQfH.IlO().IlO(j8, j9, ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).oc);
            }
            if (!this.MY || j9 - j8 >= 500) {
                return;
            }
            this.MY = false;
            IlO(cVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.rp.tV.EO.MY
        public void IlO(int i2, int i8) {
            IlO ilO = IlO.this;
            ilO.MY(ilO.zLG);
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).kBB.Cc = ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).vCE.xF();
            if (oeT.vCE(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW)) {
                com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.1.2
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        com.bytedance.sdk.openadsdk.cl.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.cl.MY.IlO();
                        try {
                            ilO2.MY("video_player");
                            ilO2.tV(zLG.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).lEW));
                            ilO2.IlO(BuildConfig.VERSION_NAME);
                        } catch (Throwable unused) {
                        }
                        return ilO2;
                    }
                });
            }
            IlO.this.vSq();
            ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).xF.set(false);
            IlO ilO2 = IlO.this;
            ilO2.IlO(ilO2.zLG);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public void tV() {
        EO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public void EO() {
        EO eo = this.vCE;
        if (eo == null) {
            return;
        }
        eo.rp();
        this.vCE = null;
        Cc cc = this.Bc;
        if (cc != null) {
            cc.DmF();
        }
        this.EO.removeCallbacks(this.AK);
        this.EO.removeCallbacksAndMessages(null);
        vCE vce = this.oc;
        if (vce != null) {
            vce.tV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public void MY() {
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO();
            this.Bc.ea();
            this.Bc.cL();
        }
        EO eo = this.vCE;
        if (eo != null) {
            if (eo.Bc()) {
                if (this.hp) {
                    if (com.bytedance.sdk.openadsdk.core.DmF.kBB()) {
                        this.vCE.MY(3);
                        EO eo2 = this.vCE;
                        eo2.IlO(false, eo2.cl(), this.zPa);
                    } else {
                        es();
                    }
                } else {
                    MY(this.nvX);
                }
            } else {
                this.vCE.IlO(false, this.DmF, this.zPa);
            }
        }
        if (this.gQ || !this.xF.get()) {
            return;
        }
        wPn();
        com.bytedance.sdk.openadsdk.core.EV.IlO ilOQfH = this.lEW.QfH();
        if (ilOQfH == null || ilOQfH.IlO() == null) {
            return;
        }
        ilOQfH.IlO().EO(Cc());
    }

    public void IlO(boolean z2, float f4, float f8) {
        try {
            Objects.toString(this.lEW.ssS());
            if (!quf() || z2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f4, (int) f8);
                layoutParams.addRule(13);
                if (DM() != null) {
                    if (DM() instanceof TextureView) {
                        ((TextureView) DM()).setLayoutParams(layoutParams);
                    } else if (DM() instanceof SurfaceView) {
                        ((SurfaceView) DM()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.tl.getLayoutParams();
                    if (this.tl.getHeight() > 0) {
                        float fMin = Math.min(this.tl.getWidth() / f4, this.tl.getHeight() / f8);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (f4 * fMin);
                            layoutParams.height = (int) (f8 * fMin);
                            if (DM() instanceof TextureView) {
                                ((TextureView) DM()).setLayoutParams(layoutParams);
                            } else if (DM() instanceof SurfaceView) {
                                ((SurfaceView) DM()).setLayoutParams(layoutParams);
                            }
                            if (this.kBB.vCE == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.tl.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO(this.IlO, "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(float f4, float f8) {
        try {
            if (DM() != null && this.vCE != null) {
                boolean z2 = this.lEW.BES() == 1;
                int[] iArrMY = BS.MY(cl.IlO());
                IlO(iArrMY[0], iArrMY[1], f4, f8, z2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void MY(float r12, float r13) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.MY(float, float):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, w.e
    public boolean IlO(@NonNull com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        int iIlO;
        View view;
        super.IlO(aVar);
        if (this.vCE != null) {
            return false;
        }
        aVar.zPa();
        if (TextUtils.isEmpty(aVar.zPa())) {
            return false;
        }
        aVar.MY(com.bytedance.sdk.openadsdk.AXM.IlO.IlO("player_force_raw_url", 0) == 1);
        MY(aVar);
        aVar.tV(1);
        this.mmj = !aVar.zPa().startsWith(ProxyConfig.MATCH_HTTP);
        if (this.oc != null) {
            if (this.kBB.vCE == 1) {
                iIlO = this.lEW.MY();
            } else {
                iIlO = this.lEW.IlO();
            }
            ViewGroup viewGroup = this.tl;
            if (viewGroup != null && (view = (View) viewGroup.getParent()) != null) {
                try {
                    View viewFindViewById = view.findViewById(zPa.rp);
                    View viewFindViewById2 = view.findViewById(zPa.Ei);
                    vCE vce = this.oc;
                    FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                    vce.IlO(viewFindViewById2, friendlyObstructionPurpose);
                    this.oc.IlO(viewFindViewById, friendlyObstructionPurpose);
                } catch (Throwable unused) {
                }
            }
            this.oc.IlO(iIlO > 0, iIlO / 1000.0f);
        }
        vSq();
        if (aVar.NV() > 0) {
            long jNV = aVar.NV();
            this.DmF = jNV;
            this.NV = Math.max(this.NV, jNV);
        }
        Cc cc = this.Bc;
        if (cc != null) {
            cc.IlO();
            this.Bc.Bc();
            this.Bc.EO(aVar.lEW(), aVar.DmF());
            this.Bc.EO(this.tl);
        }
        EO eo = new EO();
        this.vCE = eo;
        eo.IlO(this.DM);
        cl();
        this.ssS = 0L;
        ssS();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(final long j, final long j3) {
        this.lEW.EO(j);
        this.DmF = j;
        this.lMM = j3;
        final int iA = a.a(j, j3);
        this.EO.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.tV.IlO.4
            @Override // java.lang.Runnable
            public void run() {
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.IlO(j, j3);
                ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).Bc.IlO(iA);
                try {
                    if (((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).wPn != null) {
                        ((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).wPn.IlO(j, j3);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO(((com.bytedance.sdk.openadsdk.core.rp.IlO.IlO) IlO.this).IlO, "onProgressUpdate error: ", th);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO
    public void IlO(boolean z2, int i2) {
        EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(float f4, float f8) {
        ViewGroup viewGroup;
        try {
            if (DM() != null && this.vCE != null && (viewGroup = this.tl) != null) {
                float width = viewGroup.getWidth();
                float f9 = f4 / (width * 1.0f);
                float height = this.tl.getHeight();
                if (f9 <= f8 / (1.0f * height)) {
                    width = (height / f8) * f4;
                } else {
                    height = (width / f4) * f8;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                if (DM() instanceof TextureView) {
                    ((TextureView) DM()).setLayoutParams(layoutParams);
                } else if (DM() instanceof SurfaceView) {
                    ((SurfaceView) DM()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO(this.IlO, "changeVideoSizeSupportInteraction error", th);
        }
    }

    private void IlO(float f4, float f8, float f9, float f10, boolean z2) {
        RelativeLayout.LayoutParams layoutParams;
        if (f9 <= 0.0f || f10 <= 0.0f) {
            try {
                f9 = this.lEW.fdM().f4686b;
                f10 = this.lEW.fdM().f4685a;
            } catch (Throwable unused) {
                return;
            }
        }
        if (f10 > 0.0f && f9 > 0.0f) {
            if (z2) {
                if (f9 < f10) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f4, (int) ((f10 * f4) / f9));
            } else if (f9 > f10) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f9 * f8) / f10), (int) f8);
            }
            layoutParams.addRule(13);
            if (DM() != null) {
                if (DM() instanceof TextureView) {
                    ((TextureView) DM()).setLayoutParams(layoutParams);
                } else if (DM() instanceof SurfaceView) {
                    ((SurfaceView) DM()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.tl.getLayoutParams();
                if (!com.bytedance.sdk.component.adexpress.tV.MY.IlO(cl.IlO()) || this.tl.getHeight() <= 0 || layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.tl.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.IlO.IlO, com.bytedance.sdk.openadsdk.core.rp.MY.IlO
    public void IlO(g gVar, View view) {
        EO eo = this.vCE;
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
        MY();
        Cc cc3 = this.Bc;
        if (cc3 != null) {
            cc3.MY(false, false);
        }
    }

    public void IlO(InterfaceC0108IlO interfaceC0108IlO) {
        this.quf = interfaceC0108IlO;
    }
}

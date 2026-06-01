package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b0.b;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.a;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.pP;
import com.bytedance.sdk.openadsdk.core.rp.EO.IlO;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.DM;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import t.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static volatile Cc IlO;
    private com.bytedance.sdk.component.lEW.lEW Cc;
    private final Context MY;
    private final AtomicBoolean EO = new AtomicBoolean(false);
    private final List<EO> tV = Collections.synchronizedList(new ArrayList());
    private final wPn.IlO vCE = new wPn.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.6
        @Override // com.bytedance.sdk.component.utils.wPn.IlO
        public void IlO(Context context, Intent intent, boolean z2, int i2) {
            if (z2) {
                if (Cc.this.Cc == null) {
                    Cc cc = Cc.this;
                    cc.Cc = new com.bytedance.sdk.openadsdk.component.reward.MY("fsv net connect task", cc.tV);
                }
                com.bytedance.sdk.component.utils.DmF.IlO().post(Cc.this.Cc);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO extends com.bytedance.sdk.component.lEW.lEW {
        final com.bytedance.sdk.openadsdk.core.model.IlO EO;
        final oeT IlO;
        final AdSlot MY;

        public EO(oeT oet, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
            super("Fullscreen Task");
            this.IlO = oet;
            this.MY = adSlot;
            this.EO = ilO;
        }

        @Override // java.lang.Runnable
        public void run() {
            oeT oet = this.IlO;
            if (oet == null || oet.fdM() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b) CacheDirFactory.getICacheDir(this.IlO.hHv())).c(), this.IlO);
            myIlO.IlO("material_meta", this.IlO);
            myIlO.IlO("ad_slot", this.MY);
            com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.EO.1
                @Override // t.a
                public void IlO(a aVar, int i2, String str) {
                }

                @Override // t.a
                public void IlO(a aVar, int i2) {
                    tV tVVarIlO = tV.IlO(cl.IlO());
                    EO eo = EO.this;
                    tVVarIlO.IlO(eo.MY, eo.EO);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements PAGInterstitialAdLoadListener {
        private final boolean Cc;
        private final com.bytedance.sdk.openadsdk.core.model.IlO EO;
        private final Context IlO;
        private final AdSlot MY;
        private final PAGInterstitialAdLoadListener tV;

        public IlO(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, boolean z2) {
            this.IlO = context;
            this.MY = adSlot;
            this.EO = ilO;
            this.tV = pAGInterstitialAdLoadListener;
            this.Cc = z2;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            Cc.IlO(this.IlO).IlO(this.MY, this.EO, this.tV, pAGInterstitialAd, this.Cc);
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
        public void onError(int i2, String str) {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = this.tV;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onError(i2, str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements PAGInterstitialAdLoadListener {
        private final AtomicInteger EO;
        private final PAGInterstitialAdLoadListener IlO;
        private final AtomicBoolean MY;
        private final com.bytedance.sdk.openadsdk.core.model.IlO tV;

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
        public void onError(int i2, String str) {
            if (this.EO.decrementAndGet() > 0 || !this.MY.compareAndSet(false, true)) {
                return;
            }
            this.IlO.onError(i2, str);
            com.bytedance.sdk.openadsdk.ea.EO.IlO("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.MY.1
                @Override // com.bytedance.sdk.openadsdk.ea.MY
                @Nullable
                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", MY.this.tV.MY());
                    return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("choose_ad_load_error").MY(jSONObject.toString());
                }
            });
        }

        private MY(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
            this.MY = new AtomicBoolean(false);
            this.IlO = pAGInterstitialAdLoadListener;
            this.tV = ilO;
            this.EO = new AtomicInteger(IlO());
        }

        private int IlO() {
            if (!this.tV.Cc()) {
                return 0;
            }
            int i2 = 0;
            for (int i8 = 0; i8 < this.tV.tV().size(); i8++) {
                oeT oet = this.tV.tV().get(i8);
                if (oet != null && !OOq.EO(oet) && oet.fdM() != null) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.EO.decrementAndGet();
            if (this.IlO == null || !this.MY.compareAndSet(false, true)) {
                return;
            }
            this.IlO.onAdLoaded(pAGInterstitialAd);
        }
    }

    private Cc(Context context) {
        this.MY = context == null ? cl.IlO() : context.getApplicationContext();
        EO();
    }

    private void tV() {
        if (this.EO.get()) {
            this.EO.set(false);
            try {
                wPn.IlO(this.vCE);
            } catch (Exception unused) {
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.Cc != null) {
            try {
                com.bytedance.sdk.component.utils.DmF.IlO().removeCallbacks(this.Cc);
            } catch (Exception unused) {
            }
            this.Cc = null;
        }
        tV();
    }

    private void EO() {
        if (this.EO.get()) {
            return;
        }
        this.EO.set(true);
        wPn.IlO(this.vCE, this.MY);
    }

    private void MY(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.IlO IlO2;
        com.bytedance.sdk.openadsdk.core.model.IlO ilO;
        com.bytedance.sdk.openadsdk.core.model.IlO ilO2;
        DM dmMY = DM.MY();
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) || (IlO2 = tV.IlO(this.MY).IlO(adSlot.getCodeId(), true)) == null || !IlO2.Cc()) {
            IlO(adSlot, false, dmMY, pAGInterstitialAdLoadListener);
            return;
        }
        oeT oetVCE = IlO2.vCE();
        for (oeT oet : IlO2.tV()) {
            if (oet.ssS() == null) {
                oet.IlO(adSlot);
            }
        }
        bWL bwl = new bWL(this.MY, IlO2);
        if (!IlO2.Bc() && !OOq.EO(oetVCE)) {
            bwl.MY();
        }
        if (pAGInterstitialAdLoadListener != null) {
            if (IlO2.Bc() || cl.tV().cL() != 0) {
                ilO2 = IlO2;
            } else {
                ilO2 = IlO2;
                IlO(adSlot, ilO2, pAGInterstitialAdLoadListener, bwl.IlO(), true);
            }
            com.bytedance.sdk.openadsdk.core.model.IlO ilO3 = ilO2;
            ilO = ilO3;
            MY my = new MY(new IlO(this.MY, adSlot, ilO3, pAGInterstitialAdLoadListener, true), ilO);
            int i2 = 0;
            while (i2 < ilO.tV().size()) {
                DM dm = dmMY;
                bWL bwl2 = bwl;
                MY my2 = my;
                IlO(ilO.tV().get(i2), adSlot, my2, dm, bwl2, ilO.Bc());
                if (ilO.hp()) {
                    break;
                }
                i2++;
                my = my2;
                dmMY = dm;
                bwl = bwl2;
            }
        } else {
            ilO = IlO2;
        }
        for (int i8 = 0; i8 < ilO.tV().size(); i8++) {
            com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(ilO.tV().get(i8), new IlO.InterfaceC0104IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.1
            });
        }
    }

    public static Cc IlO(Context context) {
        if (IlO == null) {
            synchronized (Cc.class) {
                try {
                    if (IlO == null) {
                        IlO = new Cc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public void IlO() {
        try {
            tV.IlO(this.MY).IlO();
        } catch (Throwable unused) {
        }
    }

    public void IlO(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm()) || tV.IlO(this.MY).IlO(adSlot.getCodeId(), false) != null) {
            return;
        }
        IlO(adSlot, true, DM.MY(), null);
    }

    public void IlO(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        MY(adSlot, pAGInterstitialAdLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, PAGInterstitialAd pAGInterstitialAd, boolean z2) {
        if (pAGInterstitialAdLoadListener != null) {
            pAGInterstitialAdLoadListener.onAdLoaded(pAGInterstitialAd);
        }
        int iMY = MY();
        if (!z2) {
            if (iMY == 2) {
                tV.IlO(this.MY).IlO(adSlot, ilO);
                MY(adSlot);
                return;
            }
            return;
        }
        if (iMY == 2) {
            MY(adSlot);
        } else if (iMY == 1) {
            tV.IlO(this.MY).IlO(adSlot.getCodeId(), (oeT) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(com.bytedance.sdk.openadsdk.core.model.oeT r3, com.bytedance.sdk.openadsdk.AdSlot r4, final com.bytedance.sdk.openadsdk.component.reward.Cc.MY r5, com.bytedance.sdk.openadsdk.utils.DM r6, final com.bytedance.sdk.openadsdk.component.reward.bWL r7, final boolean r8) {
        /*
            r2 = this;
            r6 = 0
            if (r5 == 0) goto L11
            r0 = 1
            if (r8 != 0) goto L12
            com.bytedance.sdk.openadsdk.core.settings.vCE r1 = com.bytedance.sdk.openadsdk.core.cl.tV()
            int r1 = r1.cL()
            if (r1 != r0) goto L11
            goto L12
        L11:
            r0 = r6
        L12:
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.OOq.EO(r3)
            if (r1 != 0) goto L43
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.oeT.Cc(r3)
            if (r1 == 0) goto L43
            int r0 = r3.hHv()
            u.b r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            b0.b r0 = (b0.b) r0
            java.lang.String r0 = r0.c()
            com.bytedance.sdk.openadsdk.core.rp.IlO.MY r0 = com.bytedance.sdk.openadsdk.core.model.oeT.IlO(r0, r3)
            java.lang.String r1 = "material_meta"
            r0.IlO(r1, r3)
            java.lang.String r3 = "ad_slot"
            r0.IlO(r3, r4)
            com.bytedance.sdk.openadsdk.component.reward.Cc$2 r3 = new com.bytedance.sdk.openadsdk.component.reward.Cc$2
            r3.<init>()
            com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(r0, r3)
            goto L44
        L43:
            r6 = r0
        L44:
            if (r6 == 0) goto L4d
            com.bytedance.sdk.openadsdk.component.reward.vCE r3 = r7.IlO()
            r5.onAdLoaded(r3)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Cc.IlO(com.bytedance.sdk.openadsdk.core.model.oeT, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.component.reward.Cc$MY, com.bytedance.sdk.openadsdk.utils.DM, com.bytedance.sdk.openadsdk.component.reward.bWL, boolean):void");
    }

    private void MY(AdSlot adSlot) {
        if (MY() != 2) {
            return;
        }
        tV.IlO(this.MY).IlO(adSlot.getCodeId());
    }

    public static int MY() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("ivrv_load_ad_cache_strategy", 0);
    }

    private void IlO(final AdSlot adSlot, final boolean z2, final DM dm, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pP pPVar = new pP();
        pPVar.EO = z2 ? 2 : 1;
        if (cl.tV().EV(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            pPVar.lEW = 2;
        }
        cl.EO().IlO(adSlot, pPVar, 8, new xF.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.3
            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(int i2, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
                if (z2 || (pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener) == null) {
                    return;
                }
                pAGInterstitialAdLoadListener2.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
                if (ilO.tV() != null && !ilO.tV().isEmpty()) {
                    bWL bwl = new bWL(Cc.this.MY, ilO);
                    if (!z2) {
                        if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                            com.bytedance.sdk.openadsdk.xF.IlO.tV.IlO().IlO(ilO.tV().isEmpty() ? null : ilO.tV().get(0));
                            com.bytedance.sdk.openadsdk.ea.EO.IlO(ilO.vCE(), System.currentTimeMillis() - jCurrentTimeMillis);
                        }
                        if (!ilO.Bc() && pAGInterstitialAdLoadListener != null && cl.tV().cL() == 0) {
                            Cc.this.IlO(adSlot, ilO, pAGInterstitialAdLoadListener, bwl.IlO(), false);
                        }
                    }
                    com.bytedance.sdk.openadsdk.hp.IlO.IlO().IlO(ilO.vCE());
                    int i2 = 0;
                    MY my = new MY(new IlO(Cc.this.MY, adSlot, ilO, pAGInterstitialAdLoadListener, false), ilO);
                    while (i2 < ilO.tV().size()) {
                        bWL bwl2 = bwl;
                        Cc.this.IlO(ilO, ilO.tV().get(i2), bwl2, adSlot, z2, dm, my, ilO.Bc());
                        if (ilO.hp()) {
                            return;
                        }
                        i2++;
                        bwl = bwl2;
                    }
                    return;
                }
                if (z2 || (pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener) == null) {
                    return;
                }
                pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.lEW.IlO(-3));
                eo.IlO(-3);
                com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final com.bytedance.sdk.openadsdk.core.model.IlO ilO, oeT oet, final bWL bwl, final AdSlot adSlot, final boolean z2, DM dm, MY my, final boolean z7) {
        final MY my2;
        com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(oet, new IlO.InterfaceC0104IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.4
        });
        boolean z8 = true;
        if (z2 && !OOq.EO(oet) && oeT.Cc(oet) && cl.tV().tl(adSlot.getCodeId()).tV == 1 && !com.bytedance.sdk.component.utils.xF.tV(this.MY)) {
            IlO(new EO(oet, adSlot, ilO));
            return;
        }
        boolean z9 = false;
        if (my == null || (!z7 && cl.tV().cL() != 1)) {
            z8 = false;
        }
        if (OOq.EO(oet)) {
            my2 = my;
            if (z2) {
                tV.IlO(this.MY).IlO(adSlot, ilO);
            }
        } else if (oeT.Cc(oet)) {
            if (oet.fdM() != null) {
                com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b) CacheDirFactory.getICacheDir(oet.hHv())).c(), oet);
                myIlO.IlO("material_meta", oet);
                myIlO.IlO("ad_slot", adSlot);
                my2 = my;
                com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.Cc.5
                    @Override // t.a
                    public void IlO(a aVar, int i2) {
                        bwl.MY();
                        if (z2) {
                            tV.IlO(Cc.this.MY).IlO(adSlot, ilO);
                        } else if (my2 != null) {
                            if (z7 || cl.tV().cL() == 1) {
                                my2.onAdLoaded(bwl.IlO());
                            }
                        }
                    }

                    @Override // t.a
                    public void IlO(a aVar, int i2, String str) {
                        if (my2 != null) {
                            if (z7 || cl.tV().cL() == 1) {
                                my2.onError(i2, str);
                            }
                        }
                    }
                });
            } else {
                my2 = my;
                z9 = z8;
            }
            z8 = z9;
        } else {
            my2 = my;
            if (z2) {
                tV.IlO(this.MY).IlO(adSlot, ilO);
            }
        }
        if (z8) {
            my2.onAdLoaded(bwl.IlO());
        }
    }

    private void IlO(EO eo) {
        if (eo == null) {
            return;
        }
        if (this.tV.size() > 0) {
            this.tV.remove(0);
        }
        this.tV.add(eo);
    }

    public void IlO(String str, oeT oet) {
        tV.IlO(this.MY).IlO(str, oet);
    }
}

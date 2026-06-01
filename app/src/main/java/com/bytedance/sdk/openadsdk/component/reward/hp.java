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
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.pP;
import com.bytedance.sdk.openadsdk.core.rp.EO.IlO;
import com.bytedance.sdk.openadsdk.core.xF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import t.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp {
    private static volatile hp IlO;
    private com.bytedance.sdk.component.lEW.lEW Cc;
    private final Context MY;
    private final AtomicBoolean EO = new AtomicBoolean(false);
    private final List<MY> tV = Collections.synchronizedList(new ArrayList());
    private final wPn.IlO vCE = new wPn.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.6
        @Override // com.bytedance.sdk.component.utils.wPn.IlO
        public void IlO(Context context, Intent intent, boolean z2, int i2) {
            if (z2) {
                if (hp.this.Cc == null) {
                    hp hpVar = hp.this;
                    hpVar.Cc = new com.bytedance.sdk.openadsdk.component.reward.MY("net connect task", hpVar.tV);
                }
                com.bytedance.sdk.component.utils.DmF.IlO().post(hp.this.Cc);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO implements PAGRewardedAdLoadListener {
        private final AtomicInteger EO;
        private final PAGRewardedAdLoadListener IlO;
        private final AtomicBoolean MY;
        private final com.bytedance.sdk.openadsdk.core.model.IlO tV;

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
        public void onError(int i2, String str) {
            if (this.EO.decrementAndGet() > 0 || this.IlO == null || !this.MY.compareAndSet(false, true)) {
                return;
            }
            this.IlO.onError(i2, str);
            com.bytedance.sdk.openadsdk.ea.EO.IlO("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.EO.1
                @Override // com.bytedance.sdk.openadsdk.ea.MY
                @Nullable
                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", EO.this.tV.MY());
                    return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("choose_ad_load_error").MY(jSONObject.toString());
                }
            });
        }

        private EO(PAGRewardedAdLoadListener pAGRewardedAdLoadListener, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
            this.MY = new AtomicBoolean(false);
            this.IlO = pAGRewardedAdLoadListener;
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
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            this.EO.decrementAndGet();
            if (this.IlO == null || !this.MY.compareAndSet(false, true)) {
                return;
            }
            this.IlO.onAdLoaded(pAGRewardedAd);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements PAGRewardedAdLoadListener {
        private final boolean Cc;
        private final com.bytedance.sdk.openadsdk.core.model.IlO EO;
        private final Context IlO;
        private final AdSlot MY;
        private final PAGRewardedAdLoadListener tV;

        public IlO(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, boolean z2) {
            this.IlO = context;
            this.MY = adSlot;
            this.EO = ilO;
            this.tV = pAGRewardedAdLoadListener;
            this.Cc = z2;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            hp.IlO(this.IlO).IlO(this.MY, this.EO, this.tV, pAGRewardedAd, this.Cc);
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
        public void onError(int i2, String str) {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = this.tV;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onError(i2, str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY extends com.bytedance.sdk.component.lEW.lEW {
        final com.bytedance.sdk.openadsdk.core.model.IlO EO;
        final oeT IlO;
        final AdSlot MY;

        public MY(oeT oet, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
            super("Reward Task");
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
            com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.MY.1
                @Override // t.a
                public void IlO(a aVar, int i2, String str) {
                }

                @Override // t.a
                public void IlO(a aVar, int i2) {
                    rp rpVarIlO = rp.IlO(cl.IlO());
                    MY my = MY.this;
                    rpVarIlO.IlO(my.MY, my.EO);
                }
            });
        }
    }

    private hp(Context context) {
        this.MY = context == null ? cl.IlO() : context.getApplicationContext();
        MY();
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
        EO();
    }

    private void EO() {
        if (this.EO.get()) {
            this.EO.set(false);
            try {
                wPn.IlO(this.vCE);
            } catch (Exception unused) {
            }
        }
    }

    private void MY(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.IlO IlO2;
        AdSlot adSlot2;
        PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
        hp hpVar;
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) || (IlO2 = rp.IlO(this.MY).IlO(adSlot.getCodeId(), true)) == null || !IlO2.Cc()) {
            IlO(adSlot, false, pAGRewardedAdLoadListener);
            return;
        }
        oeT oetVCE = IlO2.vCE();
        for (oeT oet : IlO2.tV()) {
            if (oet.ssS() == null) {
                oet.IlO(adSlot);
            }
        }
        ea eaVar = new ea(this.MY, IlO2, adSlot);
        if (!IlO2.Bc() && !OOq.EO(oetVCE)) {
            eaVar.MY();
        }
        if (pAGRewardedAdLoadListener != null) {
            if (IlO2.Bc() || cl.tV().cL() != 0) {
                adSlot2 = adSlot;
                pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                hpVar = this;
            } else {
                adSlot2 = adSlot;
                pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                IlO(adSlot2, IlO2, pAGRewardedAdLoadListener2, (PAGRewardedAd) eaVar.IlO(), true);
                hpVar = this;
            }
            AdSlot adSlot3 = adSlot2;
            IlO ilO = new IlO(hpVar.MY, adSlot3, IlO2, pAGRewardedAdLoadListener2, true);
            IlO2 = IlO2;
            EO eo = new EO(ilO, IlO2);
            for (int i2 = 0; i2 < IlO2.tV().size(); i2++) {
                hpVar.IlO(IlO2.tV().get(i2), adSlot3, eo, eaVar, IlO2.Bc());
                if (IlO2.hp()) {
                    break;
                }
            }
        }
        for (int i8 = 0; i8 < IlO2.tV().size(); i8++) {
            com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(IlO2.tV().get(i8), new IlO.InterfaceC0104IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.1
            });
        }
    }

    public static hp IlO(Context context) {
        if (IlO == null) {
            synchronized (hp.class) {
                try {
                    if (IlO == null) {
                        IlO = new hp(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public void IlO(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm()) || rp.IlO(this.MY).IlO(adSlot.getCodeId(), false) != null) {
            return;
        }
        IlO(adSlot, true, null);
    }

    public void IlO(String str, oeT oet) {
        rp.IlO(this.MY).IlO(str, oet);
    }

    public void IlO() {
        try {
            rp.IlO(this.MY).IlO();
        } catch (Throwable unused) {
        }
    }

    public void IlO(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        MY(adSlot, pAGRewardedAdLoadListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(com.bytedance.sdk.openadsdk.core.model.oeT r4, com.bytedance.sdk.openadsdk.AdSlot r5, final com.bytedance.sdk.openadsdk.component.reward.hp.EO r6, final com.bytedance.sdk.openadsdk.component.reward.ea r7, final boolean r8) {
        /*
            r3 = this;
            r0 = 0
            if (r6 == 0) goto L11
            r1 = 1
            if (r8 != 0) goto L12
            com.bytedance.sdk.openadsdk.core.settings.vCE r2 = com.bytedance.sdk.openadsdk.core.cl.tV()
            int r2 = r2.cL()
            if (r2 != r1) goto L11
            goto L12
        L11:
            r1 = r0
        L12:
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.OOq.EO(r4)
            if (r2 != 0) goto L3d
            int r1 = r4.hHv()
            u.b r1 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r1)
            b0.b r1 = (b0.b) r1
            java.lang.String r1 = r1.c()
            com.bytedance.sdk.openadsdk.core.rp.IlO.MY r1 = com.bytedance.sdk.openadsdk.core.model.oeT.IlO(r1, r4)
            java.lang.String r2 = "material_meta"
            r1.IlO(r2, r4)
            java.lang.String r4 = "ad_slot"
            r1.IlO(r4, r5)
            com.bytedance.sdk.openadsdk.component.reward.hp$2 r4 = new com.bytedance.sdk.openadsdk.component.reward.hp$2
            r4.<init>()
            com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(r1, r4)
            goto L3e
        L3d:
            r0 = r1
        L3e:
            if (r0 == 0) goto L47
            com.bytedance.sdk.openadsdk.component.reward.lEW r4 = r7.IlO()
            r6.onAdLoaded(r4)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.hp.IlO(com.bytedance.sdk.openadsdk.core.model.oeT, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.component.reward.hp$EO, com.bytedance.sdk.openadsdk.component.reward.ea, boolean):void");
    }

    private void IlO(final AdSlot adSlot, final boolean z2, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.ea.tV()) {
            s.a.a(adSlot.getBidAdm());
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pP pPVar = new pP();
        pPVar.MY = z2 ? 2 : 1;
        if (cl.tV().EV(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            pPVar.lEW = 2;
        }
        cl.EO().IlO(adSlot, pPVar, 7, new xF.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.3
            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(int i2, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
                if (z2 || (pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener) == null) {
                    return;
                }
                pAGRewardedAdLoadListener2.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
                if (ilO.tV() != null && !ilO.tV().isEmpty()) {
                    ea eaVar = new ea(hp.this.MY, ilO, adSlot);
                    if (!z2) {
                        if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                            com.bytedance.sdk.openadsdk.xF.IlO.tV.IlO().IlO(ilO.tV().isEmpty() ? null : ilO.tV().get(0));
                            com.bytedance.sdk.openadsdk.ea.EO.IlO(ilO.vCE(), System.currentTimeMillis() - jCurrentTimeMillis);
                        }
                        if (!ilO.Bc() && pAGRewardedAdLoadListener != null && cl.tV().cL() == 0) {
                            hp.this.IlO(adSlot, ilO, pAGRewardedAdLoadListener, (PAGRewardedAd) eaVar.IlO(), false);
                        }
                    }
                    com.bytedance.sdk.openadsdk.hp.IlO.IlO().IlO(ilO.vCE());
                    ea eaVar2 = eaVar;
                    EO eo2 = new EO(new IlO(hp.this.MY, adSlot, ilO, pAGRewardedAdLoadListener, false), ilO);
                    int i2 = 0;
                    while (i2 < ilO.tV().size()) {
                        ea eaVar3 = eaVar2;
                        hp.this.IlO(ilO, ilO.tV().get(i2), eaVar3, adSlot, z2, eo2, ilO.Bc());
                        if (ilO.hp()) {
                            return;
                        }
                        i2++;
                        eaVar2 = eaVar3;
                    }
                    return;
                }
                if (z2 || (pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener) == null) {
                    return;
                }
                pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.lEW.IlO(-3));
                eo.IlO(-3);
                com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
            }
        });
    }

    private void MY(AdSlot adSlot) {
        if (Cc.MY() != 2) {
            return;
        }
        rp.IlO(this.MY).IlO(adSlot.getCodeId());
    }

    private void MY() {
        if (this.EO.get()) {
            return;
        }
        this.EO.set(true);
        wPn.IlO(this.vCE, this.MY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final com.bytedance.sdk.openadsdk.core.model.IlO ilO, oeT oet, final ea eaVar, final AdSlot adSlot, final boolean z2, EO eo, final boolean z7) {
        final EO eo2;
        com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(oet, new IlO.InterfaceC0104IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.4
        });
        boolean z8 = true;
        if (z2 && !OOq.EO(oet) && cl.tV().tl(adSlot.getCodeId()).tV == 1 && !com.bytedance.sdk.component.utils.xF.tV(this.MY)) {
            IlO(new MY(oet, adSlot, ilO));
            return;
        }
        boolean z9 = false;
        if (eo == null || (!z7 && cl.tV().cL() != 1)) {
            z8 = false;
        }
        if (OOq.EO(oet)) {
            eo2 = eo;
            if (z2) {
                rp.IlO(this.MY).IlO(adSlot, ilO);
            }
        } else {
            if (oet.fdM() != null) {
                com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b) CacheDirFactory.getICacheDir(oet.hHv())).c(), oet);
                myIlO.IlO("material_meta", oet);
                myIlO.IlO("ad_slot", adSlot);
                eo2 = eo;
                com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.hp.5
                    @Override // t.a
                    public void IlO(a aVar, int i2) {
                        eaVar.MY();
                        if (z2) {
                            rp.IlO(hp.this.MY).IlO(adSlot, ilO);
                        } else if (eo2 != null) {
                            if (z7 || cl.tV().cL() == 1) {
                                eo2.onAdLoaded(eaVar.IlO());
                            }
                        }
                    }

                    @Override // t.a
                    public void IlO(a aVar, int i2, String str) {
                        if (eo2 != null) {
                            if (z7 || cl.tV().cL() == 1) {
                                eo2.onError(i2, str);
                            }
                        }
                    }
                });
            } else {
                eo2 = eo;
                z9 = z8;
            }
            z8 = z9;
        }
        if (z8) {
            eo2.onAdLoaded(eaVar.IlO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, PAGRewardedAd pAGRewardedAd, boolean z2) {
        if (pAGRewardedAdLoadListener != null) {
            pAGRewardedAdLoadListener.onAdLoaded(pAGRewardedAd);
        }
        int iMY = Cc.MY();
        if (!z2) {
            if (iMY == 2) {
                rp.IlO(this.MY).IlO(adSlot, ilO);
                MY(adSlot);
                return;
            }
            return;
        }
        if (iMY == 2) {
            MY(adSlot);
        } else if (iMY == 1) {
            rp.IlO(this.MY).IlO(adSlot.getCodeId(), (oeT) null);
        }
    }

    private void IlO(MY my) {
        if (my == null) {
            return;
        }
        if (this.tV.size() > 0) {
            this.tV.remove(0);
        }
        this.tV.add(my);
    }
}

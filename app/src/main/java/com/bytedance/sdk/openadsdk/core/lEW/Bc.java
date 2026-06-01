package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import b0.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.core.model.pP;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private final Context EO;
    private AdSlot IlO;
    private com.bytedance.sdk.openadsdk.core.model.vAh lEW;
    private PAGBannerAdLoadListener tV;
    private final AtomicBoolean Cc = new AtomicBoolean(false);
    private int vCE = 5;
    private final DM Bc = DM.EO();
    private final com.bytedance.sdk.openadsdk.core.xF MY = com.bytedance.sdk.openadsdk.core.cl.EO();

    private Bc(Context context) {
        if (context != null) {
            this.EO = context.getApplicationContext();
        } else {
            this.EO = com.bytedance.sdk.openadsdk.core.cl.IlO();
        }
    }

    public static Bc IlO(Context context) {
        return new Bc(context);
    }

    public void IlO(AdSlot adSlot, int i2, @Nullable com.bytedance.sdk.openadsdk.common.vCE vce) {
        this.Bc.Cc();
        if (this.Cc.get()) {
            return;
        }
        this.vCE = i2;
        this.Cc.set(true);
        this.IlO = adSlot;
        if (vce instanceof PAGBannerAdLoadListener) {
            this.tV = (PAGBannerAdLoadListener) vce;
        }
        IlO(adSlot, vce);
    }

    private void IlO(final AdSlot adSlot, com.bytedance.sdk.openadsdk.common.vCE vce) {
        if (adSlot == null) {
            return;
        }
        pP pPVar = new pP();
        pPVar.lEW = 2;
        this.MY.IlO(adSlot, pPVar, this.vCE, new xF.IlO() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Bc.1
            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(int i2, String str) {
                Bc.this.IlO(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
                if (ilO.tV() == null || ilO.tV().isEmpty()) {
                    Bc.this.IlO(-3, com.bytedance.sdk.openadsdk.core.lEW.IlO(-3));
                    eo.IlO(-3);
                    com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                    return;
                }
                Bc.this.lEW = new com.bytedance.sdk.openadsdk.core.model.vAh(ilO);
                Bc bc = Bc.this;
                bc.IlO(bc.lEW, adSlot);
                if (com.bytedance.sdk.component.utils.ea.tV()) {
                    Log.e("ExpressAdLoadManager", "onAdLoad: net work response duration = " + Bc.this.Bc.tV() + "run in  " + Thread.currentThread().getName());
                }
                if (Bc.this.Cc.getAndSet(false)) {
                    mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Bc.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            if (Bc.this.lEW != null) {
                                Bc bc2 = Bc.this;
                                bc2.IlO(bc2.lEW, jElapsedRealtime);
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.openadsdk.core.model.vAh vah, AdSlot adSlot) {
        for (com.bytedance.sdk.openadsdk.core.model.oeT oet : vah.Klw()) {
            if (com.bytedance.sdk.openadsdk.core.model.oeT.Cc(oet) && oet.fdM() != null && oet.fdM().g != null) {
                if (com.bytedance.sdk.openadsdk.core.cl.tV().tV(String.valueOf(oet.hFV())) && com.bytedance.sdk.openadsdk.core.cl.tV().Ea()) {
                    com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = com.bytedance.sdk.openadsdk.core.model.oeT.IlO(((b) CacheDirFactory.getICacheDir(oet.hHv())).b(), oet);
                    myIlO.IlO("material_meta", oet);
                    myIlO.IlO("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, null);
                }
            }
        }
    }

    private PAGBannerAd IlO(com.bytedance.sdk.openadsdk.core.model.vAh vah) {
        int width;
        int height;
        PAGBannerSize pAGBannerSizeBq = vah.Bq();
        float fMin = Math.min(this.IlO.getExpressViewAcceptedHeight(), 250.0f);
        if (pAGBannerSizeBq != null) {
            width = pAGBannerSizeBq.getWidth();
            height = pAGBannerSizeBq.getHeight();
        } else {
            width = 0;
            height = 0;
        }
        float expressViewAcceptedWidth = width > 0 ? width : this.IlO.getExpressViewAcceptedWidth();
        if (height > 0) {
            fMin = height;
        }
        this.IlO.setExpressViewAccepted(expressViewAcceptedWidth, fMin);
        return new com.bytedance.sdk.openadsdk.core.EO.Bc(this.EO, vah, this.IlO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.openadsdk.core.model.vAh vah, long j) {
        if (this.tV != null) {
            PAGBannerAd pAGBannerAdIlO = IlO(vah);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jTV = this.Bc.tV();
            if (!TextUtils.isEmpty(this.IlO.getBidAdm())) {
                com.bytedance.sdk.openadsdk.ea.EO.IlO(vah, jTV);
            }
            this.tV.onAdLoaded(pAGBannerAdIlO);
            IlO(vah, jTV, j, jElapsedRealtime);
        }
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.model.vAh vah, final long j, final long j3, final long j8) {
        try {
            if (!com.bytedance.sdk.openadsdk.core.cl.tV().KC() || !com.bytedance.sdk.openadsdk.AXM.IlO.tV() || this.vCE != 1 || vah == null || vah.Klw() == null || vah.Klw().isEmpty() || vah.iuH().IlO() == null) {
                return;
            }
            final JSONObject jSONObjectIlO = vah.iuH().IlO();
            com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), vah, jSONObjectIlO.optString("tag", ""), "load_ad_time", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Bc.2
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        long jOptLong = jSONObjectIlO.optLong("callback_start", 0L);
                        long j9 = j3;
                        long j10 = j9 - jOptLong;
                        long j11 = j8 - j9;
                        long jOptLong2 = jSONObjectIlO.optLong("duration", 0L);
                        JSONObject jSONObjectOptJSONObject = jSONObjectIlO.optJSONObject("extra_data");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        jSONObjectOptJSONObject.put("thread_dispatch_duration", j10);
                        jSONObjectOptJSONObject.put("build_banner_ad_duration", j11);
                        jSONObjectOptJSONObject.put("ad_load_duration_full", j);
                        jSONObject.put("duration", jOptLong2);
                        jSONObject.put("ad_extra_data", jSONObjectOptJSONObject.toString());
                        if (com.bytedance.sdk.component.utils.ea.tV()) {
                            jSONObject.toString();
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2, String str) {
        PAGBannerAdLoadListener pAGBannerAdLoadListener;
        if (!this.Cc.getAndSet(false) || (pAGBannerAdLoadListener = this.tV) == null) {
            return;
        }
        pAGBannerAdLoadListener.onError(i2, str);
    }
}

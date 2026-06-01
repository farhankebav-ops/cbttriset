package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.vSq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends PAGBannerAd {
    private boolean Bc;
    private boolean Cc;
    private int DmF;
    protected AdSlot EO;
    private List<com.bytedance.sdk.openadsdk.core.EO.IlO> EV;
    protected Context IlO;
    protected vAh MY;
    private final AtomicBoolean NV = new AtomicBoolean(false);
    private int lEW;
    private boolean tV;
    private Cc vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();
    }

    public Bc(Context context, vAh vah, AdSlot adSlot) {
        this.lEW = 0;
        this.DmF = 0;
        this.IlO = context;
        this.MY = vah;
        this.EO = adSlot;
        this.lEW = (int) adSlot.getExpressViewAcceptedWidth();
        this.DmF = (int) this.EO.getExpressViewAcceptedHeight();
        IlO(this.MY);
        MY(vah);
    }

    private void MY(vAh vah) {
        com.bytedance.sdk.openadsdk.core.model.IlO ilOIuH;
        if (vah == null || (ilOIuH = vah.iuH()) == null) {
            return;
        }
        this.EV = new ArrayList();
        int size = ilOIuH.tV().size();
        if (!this.Bc) {
            this.EV.add(new com.bytedance.sdk.openadsdk.core.EO.IlO(this.IlO, vah, this.EO, this, false));
            return;
        }
        this.vCE = new Cc(ilOIuH.NV(), this.IlO, this.lEW, this.DmF);
        for (int i2 = 0; i2 < size; i2++) {
            this.EO.setExpressViewAccepted(((this.lEW - BS.EO(this.IlO, ilOIuH.NV().Cc())) - BS.EO(this.IlO, ilOIuH.NV().vCE())) - (BS.EO(this.IlO, ilOIuH.NV().Bc()) * 2), this.DmF);
            oeT oet = ilOIuH.tV().get(i2);
            if (i2 != 0) {
                IlO(i2, oet);
            }
            com.bytedance.sdk.openadsdk.core.EO.IlO ilO = new com.bytedance.sdk.openadsdk.core.EO.IlO(this.IlO, oet, this.EO, this, true);
            ilO.IlO(i2);
            this.EV.add(ilO);
        }
        this.vCE.IlO(this.EV);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void destroy() {
        try {
            List<com.bytedance.sdk.openadsdk.core.EO.IlO> list = this.EV;
            if (list == null || list.isEmpty()) {
                return;
            }
            if (this.Bc) {
                this.vCE.IlO();
            } else {
                this.EV.get(0).Bc();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public PAGBannerSize getBannerSize() {
        return this.EO != null ? new PAGBannerSize(this.lEW, this.DmF) : new PAGBannerSize(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public View getBannerView() {
        try {
            List<com.bytedance.sdk.openadsdk.core.EO.IlO> list = this.EV;
            if (list != null && !list.isEmpty()) {
                return this.Bc ? this.vCE.MY() : this.EV.get(0).IlO();
            }
        } catch (Throwable unused) {
        }
        return new View(this.IlO);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        vAh vah = this.MY;
        if (vah == null || vah.tN() == null) {
            return null;
        }
        try {
            return this.MY.tN().get(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("PAGBannerAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        vAh vah = this.MY;
        if (vah != null) {
            return vah.tN();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d8, String str, String str2) {
        if (this.Cc) {
            return;
        }
        vSq.IlO(this.MY, d8, str, str2);
        this.Cc = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionCallback(final PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        List<com.bytedance.sdk.openadsdk.core.EO.IlO> list = this.EV;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.EV.size(); i2++) {
            this.EV.get(i2).IlO(new PAGBannerAdInteractionCallback() { // from class: com.bytedance.sdk.openadsdk.core.EO.Bc.1
                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdDismissed();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback
                public void onAdShowFailed(@NonNull PAGErrorModel pAGErrorModel) {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdShowFailed(pAGErrorModel);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2;
                    if (!Bc.this.NV.compareAndSet(false, true) || (pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback) == null) {
                        return;
                    }
                    pAGBannerAdInteractionCallback2.onAdShowed();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionListener(final PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        List<com.bytedance.sdk.openadsdk.core.EO.IlO> list = this.EV;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.EV.size(); i2++) {
            this.EV.get(i2).IlO(new PAGBannerAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.Bc.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener;
                    if (pAGBannerAdInteractionListener2 != null) {
                        pAGBannerAdInteractionListener2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener;
                    if (pAGBannerAdInteractionListener2 != null) {
                        pAGBannerAdInteractionListener2.onAdDismissed();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2;
                    if (!Bc.this.NV.compareAndSet(false, true) || (pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener) == null) {
                        return;
                    }
                    pAGBannerAdInteractionListener2.onAdShowed();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d8) {
        if (this.tV) {
            return;
        }
        vSq.IlO(this.MY, d8);
        this.tV = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(com.bytedance.sdk.openadsdk.core.model.vAh r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1d
            com.bytedance.sdk.openadsdk.core.model.IlO r2 = r2.iuH()
            if (r2 == 0) goto L1d
            boolean r0 = r2.hp()
            if (r0 == 0) goto L1a
            java.util.List r2 = r2.tV()
            int r2 = r2.size()
            r0 = 1
            if (r2 <= r0) goto L1a
            goto L1b
        L1a:
            r0 = 0
        L1b:
            r1.Bc = r0
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.EO.Bc.IlO(com.bytedance.sdk.openadsdk.core.model.vAh):void");
    }

    public boolean IlO() {
        return this.Bc;
    }

    private void IlO(int i2, oeT oet) {
        if (i2 != 0) {
            if (!TextUtils.isEmpty(oet.mmj())) {
                oet.DmF("0");
            }
            Map<String, Object> mapTN = oet.tN();
            if (mapTN == null || !mapTN.containsKey("price")) {
                return;
            }
            mapTN.put("price", "0");
        }
    }
}

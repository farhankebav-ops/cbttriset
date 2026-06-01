package com.bytedance.sdk.openadsdk.IlO.MY;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.zPa;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.vSq;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends PAGNativeAd {
    protected String Bc;
    protected int Cc;
    private boolean DmF;
    protected final Context EO;
    protected zPa IlO;
    protected final oeT MY;
    private boolean lEW;
    protected IlO tV;
    protected int vCE;

    public lEW(@NonNull Context context, @NonNull oeT oet, int i2, boolean z2) {
        this.MY = oet;
        this.EO = context;
        this.Cc = i2;
        this.vCE = oet.hFV();
        String strEO = zLG.EO(i2);
        this.Bc = strEO;
        if (z2) {
            this.tV = new IlO(context, oet, strEO);
            this.IlO = new zPa(context, this, oet, IlO(i2), this.tV);
        }
    }

    private List<View> IlO(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                linkedList.add(list2.get(i8));
            }
        }
        return linkedList;
    }

    public boolean Bc() {
        oeT oet = this.MY;
        return (oet == null || oet.Jz() == 5 || cl.tV().EO(this.vCE) != 1) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        oeT oet = this.MY;
        if (oet == null || oet.tN() == null) {
            return null;
        }
        try {
            return this.MY.tN().get(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTNativeAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        oeT oet = this.MY;
        if (oet != null) {
            return oet.tN();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public PAGNativeAdData getNativeAdData() {
        return new tV(lEW());
    }

    public IlO lEW() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d8, String str, String str2) {
        if (this.DmF) {
            return;
        }
        vSq.IlO(this.MY, d8, str, str2);
        this.DmF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null || list == null || list.size() <= 0) {
            return;
        }
        IlO(viewGroup, null, list, list2, view, new Bc(pAGNativeAdInteractionListener));
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d8) {
        if (this.lEW) {
            return;
        }
        vSq.IlO(this.MY, d8);
        this.lEW = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }

    private String IlO(int i2) {
        if (i2 == 1) {
            return "banner_ad";
        }
        if (i2 != 2) {
            return "embeded_ad";
        }
        return "interaction";
    }

    public void IlO(String str) {
        this.Bc = str;
    }

    public void IlO(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, final vCE vce) {
        if (viewGroup == null || list2 == null || list2.size() <= 0) {
            return;
        }
        if (Bc()) {
            list3 = IlO(list2, list3);
        }
        List<View> list4 = list3;
        if (view != null && vce != null && vce.MY()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.lEW.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final String strIlO = pP.IlO();
                    TTDelegateActivity.IlO(lEW.this.MY, strIlO, new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.lEW.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.EO.Bc.IlO
                        public void IlO() {
                            vce.IlO();
                            DmF.MY().vCE(strIlO);
                            PAGMediaView pAGMediaViewIlO = lEW.this.lEW().IlO();
                            if (pAGMediaViewIlO != null) {
                                pAGMediaViewIlO.close();
                            }
                        }
                    });
                }
            });
        }
        this.IlO.IlO(viewGroup, list, list2, list4, view, vce);
        oeT oet = this.MY;
        com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(viewGroup, this.MY, (oet == null || oet.oc() != 2) ? null : new Cc.IlO(this.MY.nvX()));
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
    }
}

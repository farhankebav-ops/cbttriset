package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.ea;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;
import org.json.JSONObject;
import s.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AdSlot {
    public static final int ANCHORED_BANNER = 2;
    public static final int FIX_BANNER = 1;
    public static final int INLINE_BANNER = 3;
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_OPEN_AD = 3;
    public static final int TYPE_REWARD_VIDEO = 7;
    private int AXM;
    private boolean Bc;
    private float Cc;
    private int DmF;
    private int EO;
    private String EV;
    private String IlO;
    private int MY;
    private String NV;
    private boolean bWL;
    private String cL;
    private String cl;
    private String ea;
    private String es;
    private boolean hp;
    private int kBB;
    private String lEW;
    private int oeT;
    private boolean pP;
    private int rp;
    private float tV;
    private Map<String, Object> tl;
    private int vAh;
    private int vCE;
    private int xF;
    private String zPa;

    public static int getPosition(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
        }
        return 4;
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(iOptInt, iOptInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(dOptDouble).floatValue(), Double.valueOf(dOptDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
            builder.setAdId(jSONObject.optString("mAdId"));
            builder.setCreativeId(jSONObject.optString("mCreativeId"));
            builder.setExt(jSONObject.optString("mExt"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra"));
            builder.setBannerType(jSONObject.optInt("mBannerType"));
        } catch (Exception unused) {
        }
        AdSlot adSlotBuild = builder.build();
        adSlotBuild.setDurationSlotType(jSONObject.optInt("mDurationSlotType"));
        return adSlotBuild;
    }

    public int getAdCount() {
        return this.vCE;
    }

    public String getAdId() {
        return this.zPa;
    }

    public int getBannerType() {
        return this.kBB;
    }

    public String getBidAdm() {
        return this.ea;
    }

    public String getCodeId() {
        return this.IlO;
    }

    public String getCreativeId() {
        return this.cl;
    }

    public int getDurationSlotType() {
        return this.vAh;
    }

    public float getExpressViewAcceptedHeight() {
        return this.Cc;
    }

    public float getExpressViewAcceptedWidth() {
        return this.tV;
    }

    public String getExt() {
        return this.cL;
    }

    public int getImgAcceptedHeight() {
        return this.EO;
    }

    public int getImgAcceptedWidth() {
        return this.MY;
    }

    public int getIsRotateBanner() {
        return this.xF;
    }

    public String getMediaExtra() {
        return this.NV;
    }

    public int getNativeAdType() {
        return this.rp;
    }

    @Nullable
    public Map<String, Object> getRequestExtraMap() {
        return this.tl;
    }

    @Deprecated
    public int getRewardAmount() {
        return this.DmF;
    }

    @Deprecated
    public String getRewardName() {
        return this.lEW;
    }

    public int getRotateOrder() {
        return this.oeT;
    }

    public int getRotateTime() {
        return this.AXM;
    }

    public String getUserData() {
        return this.es;
    }

    public String getUserID() {
        return this.EV;
    }

    public boolean isAutoPlay() {
        return this.hp;
    }

    public boolean isExpressAd() {
        return this.bWL;
    }

    public boolean isPreload() {
        return this.pP;
    }

    public boolean isSupportDeepLink() {
        return this.Bc;
    }

    public void setAdCount(int i2) {
        this.vCE = i2;
    }

    public void setDurationSlotType(int i2) {
        this.vAh = i2;
    }

    public void setExpressViewAccepted(float f4, float f8) {
        this.tV = f4;
        this.Cc = f8;
    }

    public void setIsRotateBanner(int i2) {
        this.xF = i2;
    }

    public void setNativeAdType(int i2) {
        this.rp = i2;
    }

    public void setPreload(boolean z2) {
        this.pP = z2;
    }

    public void setRotateOrder(int i2) {
        this.oeT = i2;
    }

    public void setRotateTime(int i2) {
        this.AXM = i2;
    }

    public void setUserData(String str) {
        this.es = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.IlO);
            jSONObject.put("mAdCount", this.vCE);
            jSONObject.put("mIsAutoPlay", this.hp);
            jSONObject.put("mImgAcceptedWidth", this.MY);
            jSONObject.put("mImgAcceptedHeight", this.EO);
            jSONObject.put("mExpressViewAcceptedWidth", this.tV);
            jSONObject.put("mExpressViewAcceptedHeight", this.Cc);
            jSONObject.put("mSupportDeepLink", this.Bc);
            jSONObject.put("mRewardName", this.lEW);
            jSONObject.put("mRewardAmount", this.DmF);
            jSONObject.put("mMediaExtra", this.NV);
            jSONObject.put("mUserID", this.EV);
            jSONObject.put("mNativeAdType", this.rp);
            jSONObject.put("mIsExpressAd", this.bWL);
            jSONObject.put("mAdId", this.zPa);
            jSONObject.put("mCreativeId", this.cl);
            jSONObject.put("mExt", this.cL);
            jSONObject.put("mBidAdm", this.ea);
            jSONObject.put("mUserData", this.es);
            jSONObject.put("mDurationSlotType", this.vAh);
            jSONObject.put("mBannerType", this.kBB);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }

    private AdSlot() {
        this.hp = true;
        this.bWL = false;
        this.xF = 0;
        this.AXM = 0;
        this.oeT = 0;
        this.kBB = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private int AXM;
        private float EV;
        private String IlO;
        private int NV;
        private String bWL;
        private String cL;
        private String cl;
        private String ea;
        private boolean hp;
        private String lEW;
        private float rp;
        private String zPa;
        private int MY = 640;
        private int EO = Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
        private final boolean tV = true;
        private int Cc = 1;
        private final String vCE = "";
        private final int Bc = 0;
        private String DmF = "defaultUser";
        private boolean es = true;
        private Map<String, Object> xF = null;
        private int oeT = 1;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.IlO = this.IlO;
            adSlot.vCE = this.Cc;
            adSlot.Bc = true;
            adSlot.MY = this.MY;
            adSlot.EO = this.EO;
            float f4 = this.EV;
            if (f4 <= 0.0f) {
                adSlot.tV = this.MY;
                adSlot.Cc = this.EO;
            } else {
                adSlot.tV = f4;
                adSlot.Cc = this.rp;
            }
            adSlot.lEW = "";
            adSlot.DmF = 0;
            adSlot.NV = this.lEW;
            adSlot.EV = this.DmF;
            adSlot.rp = this.NV;
            adSlot.hp = this.es;
            adSlot.bWL = this.hp;
            adSlot.ea = this.bWL;
            adSlot.zPa = this.ea;
            adSlot.cl = this.zPa;
            adSlot.cL = this.cl;
            adSlot.es = this.cL;
            adSlot.tl = this.xF;
            adSlot.vAh = this.AXM;
            adSlot.kBB = this.oeT;
            return adSlot;
        }

        public Builder isExpressAd(boolean z2) {
            this.hp = z2;
            return this;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
            }
            if (i2 > 20) {
                i2 = 20;
            }
            this.Cc = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.ea = str;
            return this;
        }

        public Builder setBannerType(int i2) {
            this.oeT = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.IlO = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.zPa = str;
            return this;
        }

        public Builder setDurationSlotType(int i2) {
            this.AXM = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f4, float f8) {
            this.EV = f4;
            this.rp = f8;
            return this;
        }

        public Builder setExt(String str) {
            this.cl = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i8) {
            this.MY = i2;
            this.EO = i8;
            return this;
        }

        public Builder setIsAutoPlay(boolean z2) {
            this.es = z2;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.lEW = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.NV = i2;
            return this;
        }

        public Builder setRequestExtraMap(Map<String, Object> map) {
            this.xF = map;
            return this;
        }

        public Builder setUserData(String str) {
            this.cL = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.DmF = str;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (ea.tV()) {
                a.a(str);
            }
            this.bWL = str;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i2) {
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z2) {
            return this;
        }
    }
}

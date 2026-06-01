package com.bytedance.sdk.openadsdk.api.init;

import android.text.TextUtils;
import com.bytedance.sdk.component.Bc.EO.EO;
import com.bytedance.sdk.component.utils.ea;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.api.PAGConstant;
import com.bytedance.sdk.openadsdk.core.wPn;
import com.bytedance.sdk.openadsdk.utils.zLG;
import r.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PAGConfig implements InitConfig {
    private static String NV;
    private boolean Bc;
    private String DmF;
    private int EO;
    private String EV;
    private String IlO;
    private boolean MY;
    private String lEW;
    private int tV = -1;
    private int Cc = -1;
    private int vCE = 0;

    public static void debugLog(boolean z2) {
        if (wPn.IlO() != null) {
            if (z2) {
                wPn.IlO().EO(1);
                wPn.IlO().IlO();
            } else {
                wPn.IlO().EO(0);
                EO.IlO(EO.IlO.OFF);
                ea.EO();
                oeT.MY();
            }
        }
    }

    public static int getGDPRConsent() {
        if (!zLG.DmF("getGdpr")) {
            return -1;
        }
        int iMY = wPn.IlO().MY();
        if (iMY == 1) {
            return 0;
        }
        if (iMY == 0) {
            return 1;
        }
        return iMY;
    }

    public static int getPAConsent() {
        if (zLG.DmF("getPAConsent")) {
            return wPn.IlO().Cc();
        }
        return -1;
    }

    public static void setAppIconId(int i2) {
        if (wPn.IlO() != null) {
            wPn.IlO().tV(i2);
        }
    }

    public static void setGDPRConsent(@PAGConstant.PAGGDPRConsentType int i2) {
        zLG.DmF("setGdpr");
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        wPn.IlO().MY(i2);
    }

    public static void setPAConsent(@PAGConstant.PAGPAConsentType int i2) {
        if (zLG.DmF("setPAConsent")) {
            if (i2 == 1 || i2 == 0) {
                wPn.IlO().Cc(i2);
            } else {
                wPn.IlO().Cc(-2);
            }
        }
    }

    public static void setPackageName(String str) {
        NV = str;
    }

    public static void setUserData(String str) {
        if (wPn.IlO() != null) {
            wPn.IlO().MY(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAdxId() {
        return this.EV;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getAppIconId() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAppId() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getData() {
        return this.DmF;
    }

    public boolean getDebugLog() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getGdpr() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getPA() {
        return this.Cc;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getPackageName() {
        return TextUtils.isEmpty(this.lEW) ? NV : this.lEW;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getTitleBarTheme() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isSupportMultiProcess() {
        return this.Bc;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isUseTextureView() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(int i2) {
        this.Cc = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void tV(int i2) {
        this.vCE = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(String str) {
        this.lEW = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str) {
        this.DmF = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(String str) {
        this.IlO = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(String str) {
        this.EV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2) {
        this.MY = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.tV = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2) {
        this.EO = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(boolean z2) {
        this.Bc = z2;
        a.f13610c = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private String DmF;
        private int EO;
        private String IlO;
        private boolean MY;
        private String NV;
        private String[] lEW;
        private int tV = -1;
        private int Cc = -1;
        private int vCE = 0;
        private boolean Bc = false;
        private String EV = "";

        public Builder appIcon(int i2) {
            this.EO = i2;
            return this;
        }

        public Builder appId(String str) {
            this.IlO = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.MY(this.IlO);
            pAGConfig.IlO(this.EO);
            pAGConfig.tV(this.vCE);
            pAGConfig.MY(this.Bc);
            pAGConfig.MY(this.tV);
            pAGConfig.EO(this.Cc);
            pAGConfig.IlO(this.MY);
            pAGConfig.EO(this.DmF);
            pAGConfig.IlO(this.NV);
            pAGConfig.tV(this.EV);
            return pAGConfig;
        }

        public Builder debugLog(boolean z2) {
            this.MY = z2;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.lEW = strArr;
            return this;
        }

        public Builder setAdxId(String str) {
            this.EV = str;
            return this;
        }

        public Builder setGDPRConsent(@PAGConstant.PAGGDPRConsentType int i2) {
            this.tV = i2;
            return this;
        }

        public Builder setPAConsent(@PAGConstant.PAGPAConsentType int i2) {
            if (i2 == 0 || i2 == 1) {
                this.Cc = i2;
                return this;
            }
            this.Cc = -2;
            return this;
        }

        public Builder setPackageName(String str) {
            this.DmF = str;
            return this;
        }

        public Builder setUserData(String str) {
            this.NV = str;
            return this;
        }

        public Builder supportMultiProcess(boolean z2) {
            this.Bc = z2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.vCE = i2;
            return this;
        }

        public Builder useTextureView(boolean z2) {
            return this;
        }
    }
}

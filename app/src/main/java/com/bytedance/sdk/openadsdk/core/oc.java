package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.ironsource.Q6;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class oc implements OOq {
    private static final Map<Integer, String> Cc = new HashMap<Integer, String>(12) { // from class: com.bytedance.sdk.openadsdk.core.oc.1
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, Q6.U0);
            put(4, "apk-sign");
            put(5, "app_set_id_scope");
            put(6, "app_set_id");
            put(7, "installed_source");
            put(8, "app_running_time");
            put(9, "vendor");
            put(10, Q6.B);
            put(11, "user_agent_device");
            put(12, "user_agent_webview");
            put(13, "sys_compiling_time");
            put(14, "sec_did");
            put(15, "url");
            put(16, "X-Argus");
            put(17, "X-Ladon");
            put(18, "X-Khronos");
            put(19, "X-Gorgon");
            put(20, "pangle_m");
            put(21, "screen_height");
            put(22, "screen_width");
            put(23, "rom_version");
            put(24, "carrier_name");
            put(25, "os_version");
            put(26, "conn_type");
            put(27, "boot");
            put(28, "feature_data");
            put(29, "t_ver");
            put(30, "aab");
            put(31, "w_ver");
            put(32, "is_fold");
            put(33, "abi");
            put(34, "is_multi");
        }
    };
    boolean IlO = false;
    boolean MY = false;
    String EO = "com.union_test.internationad";
    String tV = "8025677";
    private int vCE = 0;

    public static void Bc() {
        try {
            com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.oc.3
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return a.d("bidding_token");
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAdManagerImpl", th.getMessage());
        }
    }

    private boolean DmF() {
        return "TX".equals(com.bytedance.sdk.openadsdk.core.settings.hp.aP().mmj()) || TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.hp.aP().mmj());
    }

    public static void lEW() {
        try {
            com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.oc.4
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return a.d("bidding_token");
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAdManagerImpl", th.getMessage());
        }
    }

    public static void vCE() {
        try {
            com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.oc.2
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return a.d("bidding_token");
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAdManagerImpl", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    /* JADX INFO: renamed from: Cc, reason: merged with bridge method [inline-methods] */
    public oc MY(String str) {
        DmF.MY().EO(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public String EO() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public oc IlO(String str) {
        DmF.MY().IlO(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq Cc(int i2) {
        DmF.MY().Cc(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq EO(int i2) {
        this.vCE = i2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq IlO(int i2) {
        DmF.MY().vCE(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq MY(int i2) {
        DmF.MY().tV(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public int tV() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public int Cc() {
        return DmF.MY().EV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq EO(String str) {
        DmF.MY().lEW(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq IlO() {
        com.bytedance.sdk.component.utils.ea.IlO("PangleSDK-7206");
        com.bytedance.sdk.component.utils.oeT.IlO("PangleSDK-7206");
        com.bytedance.sdk.component.utils.ea.MY();
        com.bytedance.sdk.component.Bc.IlO.IlO();
        com.bytedance.sdk.component.utils.oeT.IlO();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public int MY() {
        return DmF.MY().NV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public OOq tV(int i2) {
        DmF.MY().EO(i2);
        return this;
    }

    private JSONObject MY(PAGBiddingRequest pAGBiddingRequest) {
        try {
            PAGBannerSize bannerSize = pAGBiddingRequest.getBannerSize();
            if (bannerSize != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", bannerSize.getWidth());
                if (bannerSize.getType() == 3) {
                    jSONObject.put("height", bannerSize.getMaxHeight());
                } else {
                    jSONObject.put("height", bannerSize.getHeight());
                }
                jSONObject.put("type", bannerSize.getType());
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.cl.tV().oc(r4) == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[Catch: all -> 0x02ab, TryCatch #0 {all -> 0x02ab, blocks: (B:3:0x0008, B:5:0x0015, B:7:0x001b, B:9:0x0021, B:11:0x002f, B:18:0x004a, B:20:0x004e, B:22:0x0058, B:24:0x005c, B:27:0x007e, B:28:0x0092, B:30:0x00ad, B:34:0x00cc, B:33:0x00bb, B:35:0x00d3, B:37:0x00eb, B:41:0x0102, B:43:0x011f, B:45:0x012c, B:46:0x0135, B:48:0x01f7, B:49:0x0207, B:52:0x0223, B:54:0x022e, B:55:0x0240, B:57:0x024d, B:61:0x025c, B:63:0x0262, B:65:0x026f, B:66:0x0285, B:68:0x028b, B:69:0x028e, B:71:0x0294, B:72:0x02a0, B:38:0x00f1, B:40:0x00fd, B:14:0x003a, B:16:0x0040), top: B:76:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[Catch: all -> 0x02ab, TryCatch #0 {all -> 0x02ab, blocks: (B:3:0x0008, B:5:0x0015, B:7:0x001b, B:9:0x0021, B:11:0x002f, B:18:0x004a, B:20:0x004e, B:22:0x0058, B:24:0x005c, B:27:0x007e, B:28:0x0092, B:30:0x00ad, B:34:0x00cc, B:33:0x00bb, B:35:0x00d3, B:37:0x00eb, B:41:0x0102, B:43:0x011f, B:45:0x012c, B:46:0x0135, B:48:0x01f7, B:49:0x0207, B:52:0x0223, B:54:0x022e, B:55:0x0240, B:57:0x024d, B:61:0x025c, B:63:0x0262, B:65:0x026f, B:66:0x0285, B:68:0x028b, B:69:0x028e, B:71:0x0294, B:72:0x02a0, B:38:0x00f1, B:40:0x00fd, B:14:0x003a, B:16:0x0040), top: B:76:0x0008 }] */
    @Override // com.bytedance.sdk.openadsdk.core.OOq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String IlO(com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest r15) {
        /*
            Method dump skipped, instruction units count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.oc.IlO(com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest):java.lang.String");
    }

    private JSONObject IlO(JSONObject jSONObject, boolean z2) {
        JSONObject jSONObjectIlO;
        if (z2) {
            jSONObjectIlO = PangleEncryptManager.encryptType4(jSONObject, new oeT(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN));
            vAh.IlO(jSONObjectIlO);
        } else {
            jSONObjectIlO = com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
        }
        return jSONObjectIlO != null ? jSONObjectIlO : new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.OOq
    public boolean IlO(String str, int i2, String str2, String str3, String str4) {
        if (!this.EO.equals(cl.IlO().getPackageName()) || !this.tV.equals(DmF.MY().tV()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method methodIlO = com.bytedance.sdk.component.utils.oc.IlO("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (methodIlO != null) {
                methodIlO.invoke(null, str, Integer.valueOf(i2), str2, str3, str4);
            }
        } catch (Throwable unused) {
        }
        return true;
    }
}

package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.tV.IlO;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.C2318f4;
import com.ironsource.C2461n2;
import com.ironsource.C2605va;
import com.ironsource.sdk.controller.f;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vSq implements com.bytedance.sdk.component.adexpress.Cc.MY, vSq.IlO, com.bytedance.sdk.openadsdk.NV.MY {
    private static final Map<String, Boolean> lEW;
    private com.bytedance.sdk.openadsdk.rp.Bc AK;
    private JSONObject AXM;
    private String BS;
    private com.bytedance.sdk.openadsdk.core.widget.Cc Bc;
    private com.bytedance.sdk.component.IlO.cl DM;
    private com.bytedance.sdk.openadsdk.NV.EO DmF;
    private IlO Dxv;
    private WeakReference<View> EV;
    private com.bytedance.sdk.openadsdk.core.rp.tV.MY Ea;
    private com.bytedance.sdk.openadsdk.rp.lEW HSR;
    protected Map<String, Object> IlO;
    private Context KC;
    boolean MY;
    private String NV;
    private com.bytedance.sdk.openadsdk.core.MY.tV OOq;
    private String bWL;
    private JSONObject cL;
    private com.bytedance.sdk.openadsdk.core.model.oeT cl;
    private List<com.bytedance.sdk.openadsdk.core.model.oeT> dY;
    private int ea;
    private com.bytedance.sdk.component.adexpress.MY.EV es;
    private EO fdM;
    private com.bytedance.sdk.openadsdk.core.widget.IlO.IlO gQ;
    private int hp;
    private com.bytedance.sdk.openadsdk.rp.vCE kBB;
    private HashMap<String, NV> lMM;
    private com.bytedance.sdk.openadsdk.tV.tV.Cc mmj;
    private com.bytedance.sdk.openadsdk.rp.EV oc;
    private com.bytedance.sdk.openadsdk.NV.tV oeT;
    private com.bytedance.sdk.openadsdk.rp.Cc pP;
    private boolean quf;
    private String rp;
    private WeakReference<com.bytedance.sdk.component.DmF.vCE> tV;
    private JSONObject tl;
    private boolean uvo;
    private com.bytedance.sdk.openadsdk.rp.IlO vAh;
    private String vCE;
    private com.bytedance.sdk.openadsdk.rp.EO wPn;
    private com.bytedance.sdk.openadsdk.core.lEW.bWL xF;
    private com.bytedance.sdk.openadsdk.rp.MY zLG;
    private boolean zPa = true;
    private boolean vSq = true;
    private boolean nvX = false;
    private boolean YA = false;
    boolean EO = false;
    private boolean ssS = false;
    private final com.bytedance.sdk.component.utils.vSq Cc = new com.bytedance.sdk.component.utils.vSq(Looper.getMainLooper(), this);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO implements Runnable {
        private final com.bytedance.sdk.openadsdk.core.lEW.bWL IlO;
        private final JSONObject MY;

        public EO(com.bytedance.sdk.openadsdk.core.lEW.bWL bwl, JSONObject jSONObject) {
            this.IlO = bwl;
            this.MY = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            vSq.MY(this.IlO, this.MY);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        public int Cc;
        public String EO;
        public String IlO;
        public String MY;
        public JSONObject tV;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        lEW = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
    }

    public vSq(Context context) {
        this.KC = context;
    }

    private void AXM() {
        if (this.KC == null || TextUtils.isEmpty(cl.tV().lMM())) {
            return;
        }
        TTWebsiteActivity.IlO(this.KC, this.cl, this.BS);
    }

    private void EV(JSONObject jSONObject) throws Exception {
        if (this.quf) {
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
            if ((oet instanceof com.bytedance.sdk.openadsdk.core.model.vAh) && ((com.bytedance.sdk.openadsdk.core.model.vAh) oet).dvD()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("adInfos", jSONArray);
                for (com.bytedance.sdk.openadsdk.core.model.oeT oet2 : ((com.bytedance.sdk.openadsdk.core.model.vAh) this.cl).Klw()) {
                    JSONObject jSONObject2 = new JSONObject();
                    IlO(jSONObject2, oet2);
                    jSONArray.put(jSONObject2);
                }
                return;
            }
        }
        IlO(jSONObject, this.cl);
    }

    private WebView bWL() {
        com.bytedance.sdk.component.DmF.vCE vce;
        WeakReference<com.bytedance.sdk.component.DmF.vCE> weakReference = this.tV;
        if (weakReference == null || (vce = weakReference.get()) == null) {
            return null;
        }
        return vce.getWebView();
    }

    private void cL() {
        com.bytedance.sdk.openadsdk.rp.EV ev = this.oc;
        if (ev == null) {
            return;
        }
        ev.IlO();
    }

    private Context cl() {
        WeakReference<com.bytedance.sdk.component.DmF.vCE> weakReference = this.tV;
        Activity activityIlO = (weakReference == null || weakReference.get() == null) ? null : com.bytedance.sdk.component.utils.MY.IlO(this.tV.get());
        return activityIlO == null ? this.KC : activityIlO;
    }

    private JSONObject ea() {
        try {
            View view = this.EV.get();
            com.bytedance.sdk.component.DmF.vCE vce = this.tV.get();
            if (view != null && vce != null) {
                int[] iArrMY = BS.MY(view);
                int[] iArrMY2 = BS.MY((View) vce);
                if (iArrMY != null && iArrMY2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", BS.EO(cl.IlO(), iArrMY[0] - iArrMY2[0]));
                    jSONObject.put("y", BS.EO(cl.IlO(), iArrMY[1] - iArrMY2[1]));
                    jSONObject.put("w", BS.EO(cl.IlO(), view.getWidth()));
                    jSONObject.put("h", BS.EO(cl.IlO(), view.getHeight()));
                    jSONObject.put("isExist", true);
                    return jSONObject;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void es() {
        com.bytedance.sdk.openadsdk.rp.EV ev = this.oc;
        if (ev == null) {
            return;
        }
        ev.MY();
    }

    private void hp(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc;
        if (jSONObject == null || (cc = this.mmj) == null) {
            return;
        }
        cc.MY(jSONObject);
    }

    private void kBB() {
        if (this.DmF == null) {
            this.DmF = com.bytedance.sdk.openadsdk.NV.IlO.IlO(this, this.cl);
        }
    }

    private JSONObject oeT() {
        return MY(this.cl);
    }

    private void rp(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.OOq.EV(this.cl))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.model.OOq.EV(this.cl));
    }

    private boolean vAh() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
        if (oet == null || oet.vZk() == null || com.bytedance.sdk.openadsdk.core.model.OOq.MY(this.cl) || this.nvX || this.cl.vZk().optInt("parent_type") != 2) {
            return false;
        }
        int iOyN = this.cl.OyN();
        if (iOyN != 8 && iOyN != 7) {
            return false;
        }
        this.nvX = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF() {
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
        if (bwl != null) {
            bwl.IlO();
        }
    }

    private static List<String> zPa() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public void Bc() {
        com.bytedance.sdk.openadsdk.rp.EO eo;
        if (this.uvo && (eo = this.wPn) != null) {
            eo.IlO();
            return;
        }
        Context context = this.KC;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.vAh.IlO((Activity) context)) {
            ((Activity) this.KC).finish();
        }
    }

    public boolean DmF() {
        return this.ssS;
    }

    public boolean NV() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
        return oet != null && oet.Dxv() == 1;
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            EV(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            MY(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.vSq.3
                @Override // java.lang.Runnable
                public void run() {
                    vSq.this.ea(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void chooseAdResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("video_choose");
            long jOptLong = jSONObject.optLong("video_choose_duration");
            com.bytedance.sdk.openadsdk.rp.lEW lew = this.HSR;
            if (lew != null) {
                lew.IlO(iOptInt, jOptLong);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.vSq.4
                @Override // java.lang.Runnable
                public void run() {
                    vSq.this.Cc(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            es(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        zPa(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.AXM.toString();
        }
        try {
            JSONObject jSONObjectIlO = com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.AXM, new JSONObject(str));
            return jSONObjectIlO == null ? this.AXM.toString() : jSONObjectIlO.toString();
        } catch (Exception unused) {
            return this.AXM.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public String getTemplateInfo() {
        IlO("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.AXM;
            if (jSONObject != null) {
                jSONObject.put("setting", oeT());
                com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
                if (oet != null && oet.jM() != null) {
                    this.AXM.put("dynamic_configs", this.cl.jM());
                }
                com.bytedance.sdk.openadsdk.core.model.oeT oet2 = this.cl;
                if (oet2 != null) {
                    this.AXM.put("extension", oet2.qyG());
                }
            }
            IlO("getTemplateInfo", false);
            return this.AXM.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void initRenderFinish() {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.vSq.6
            @Override // java.lang.Runnable
            public void run() {
                if (vSq.this.gQ != null) {
                    vSq.this.gQ.IlO();
                }
            }
        });
    }

    public void lEW() {
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
        if (bwl != null) {
            bwl.MY();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            EO eo = this.fdM;
            if (eo != null) {
                mmj.MY(eo);
            }
            EO eo2 = new EO(this.xF, jSONObject);
            this.fdM = eo2;
            mmj.IlO(eo2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.AndroidObject", "");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            cl(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void skipVideo() {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.vSq.5
            @Override // java.lang.Runnable
            public void run() {
                vSq.this.xF();
            }
        });
    }

    public boolean vCE() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    @JavascriptInterface
    public void videoFrameChanged(String str) {
        if (this.AK == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.component.adexpress.MY.bWL bwl = new com.bytedance.sdk.component.adexpress.MY.bWL();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble = jSONObjectOptJSONObject.optDouble("x");
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("y");
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("width");
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("height");
                if (cL(jSONObjectOptJSONObject)) {
                    bwl.IlO((float) jSONObjectOptJSONObject.optDouble("borderRadiusTopLeft"));
                    bwl.MY((float) jSONObjectOptJSONObject.optDouble("borderRadiusTopRight"));
                    bwl.EO((float) jSONObjectOptJSONObject.optDouble("borderRadiusBottomLeft"));
                    bwl.tV((float) jSONObjectOptJSONObject.optDouble("borderRadiusBottomRight"));
                }
                bwl.EO(dOptDouble);
                bwl.tV(dOptDouble2);
                bwl.Cc(dOptDouble3);
                bwl.vCE(dOptDouble4);
            }
            com.bytedance.sdk.openadsdk.rp.Bc bc = this.AK;
            if (bc != null) {
                bc.IlO(bwl);
            }
        } catch (Throwable unused) {
        }
    }

    private void DmF(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView webViewBWL = bWL();
                    if (webViewBWL != null) {
                        com.bytedance.sdk.component.utils.bWL.IlO(webViewBWL, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (str.startsWith("bytedance://private/setresult/") && (iIndexOf = str.indexOf(38, 30)) > 0) {
                    String strSubstring = str.substring(30, iIndexOf);
                    String strSubstring2 = str.substring(iIndexOf + 1);
                    if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                        return;
                    }
                    Bc(strSubstring2);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void oeT(JSONObject jSONObject) {
        WebView webViewBWL;
        if (jSONObject == null || (webViewBWL = bWL()) == null) {
            return;
        }
        com.bytedance.sdk.component.utils.bWL.IlO(webViewBWL, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")");
    }

    private boolean zPa(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
        if (bwl != null && jSONObject != null) {
            double dEO = bwl.EO();
            double dTV = this.xF.tV();
            int iCc = this.xF.Cc();
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.TopLayoutHelper", "current:", Double.valueOf(dEO), "state", Integer.valueOf(iCc), "countdownTime", Double.valueOf(dTV));
            try {
                jSONObject.put("currentTime", dEO / 1000.0d);
                if (dTV > 0.0d) {
                    jSONObject.put("countDownTime", dTV / 1000.0d);
                }
                jSONObject.put("state", iCc);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean Cc() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
        return oet != null && oet.dY();
    }

    public com.bytedance.sdk.openadsdk.core.model.oeT tV() {
        return this.cl;
    }

    public void vCE(String str) {
        this.BS = str;
    }

    private boolean cL(@NonNull JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private void es(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.xF.IlO(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lEW(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str)) {
            return NV();
        }
        return true;
    }

    private void xF(JSONObject jSONObject) {
        if (jSONObject == null || this.oeT == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                this.oeT.IlO(true, jSONArrayOptJSONArray);
            } else {
                this.oeT.IlO(false, null);
            }
        } catch (Exception unused) {
            this.oeT.IlO(false, null);
        }
    }

    public vSq Cc(String str) {
        this.bWL = str;
        return this;
    }

    public vSq EO(String str) {
        this.NV = str;
        return this;
    }

    public void NV(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("sendLogV3") { // from class: com.bytedance.sdk.openadsdk.core.vSq.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extJson");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("category") && jSONObjectOptJSONObject.has("tag") && jSONObjectOptJSONObject.has("label")) {
                    String strOptString = jSONObjectOptJSONObject.optString("category");
                    String strOptString2 = jSONObjectOptJSONObject.optString("tag");
                    String strOptString3 = jSONObjectOptJSONObject.optString("label");
                    long jOptLong = jSONObject.optLong("value");
                    long jOptLong2 = jSONObject.optLong("extValue");
                    try {
                        jSONObjectOptJSONObject.put("ua_policy", vSq.this.ea);
                    } catch (Exception unused) {
                    }
                    new IlO.C0117IlO(System.currentTimeMillis(), vSq.this.cl).tV(strOptString).MY(strOptString2).EO(strOptString3).Cc(String.valueOf(jOptLong)).vCE(String.valueOf(jOptLong2)).IlO(jSONObjectOptJSONObject).IlO((com.bytedance.sdk.openadsdk.tV.MY.IlO) null);
                }
            }
        });
    }

    public void hp() {
        IlO ilO = this.Dxv;
        if (ilO != null) {
            ilO.IlO();
        }
    }

    public void rp() {
        com.bytedance.sdk.openadsdk.NV.EO eo = this.DmF;
        if (eo != null) {
            eo.IlO();
        }
        EO eo2 = this.fdM;
        if (eo2 != null) {
            mmj.MY(eo2);
            this.fdM = null;
        }
        this.KC = null;
        this.Ea = null;
    }

    public vSq tV(String str) {
        this.rp = str;
        return this;
    }

    public void vCE(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.oeT oetIlO = com.bytedance.sdk.openadsdk.core.MY.IlO(jSONObject);
        if (oetIlO != null) {
            boolean zCc = com.bytedance.sdk.openadsdk.core.model.es.Cc(this.cl);
            IlO(oetIlO, zCc ? zLG.MY(this.hp) : this.BS, !zCc);
        }
    }

    private boolean AXM(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", MY(this.dY));
        } catch (Exception unused) {
        }
        return true;
    }

    private void bWL(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.rp.EO eo = this.wPn;
        if (eo == null || jSONObject == null) {
            return;
        }
        eo.IlO(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    private void cl(JSONObject jSONObject) {
        int i2;
        double dOptDouble;
        double dOptDouble2;
        boolean z2;
        int i8;
        double d8;
        String strOptString;
        com.bytedance.sdk.openadsdk.rp.lEW lew;
        vSq vsq = this;
        if (vsq.es == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = vsq.mmj;
        if (cc != null) {
            cc.zPa();
        }
        com.bytedance.sdk.component.adexpress.MY.bWL bwl = new com.bytedance.sdk.component.adexpress.MY.bWL();
        bwl.IlO(1);
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
            if (jSONObjectOptJSONObject != null) {
                dOptDouble = jSONObjectOptJSONObject.optDouble("width");
                dOptDouble2 = jSONObjectOptJSONObject.optDouble("height");
            } else {
                dOptDouble = 0.0d;
                dOptDouble2 = 0.0d;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                    double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                    z2 = zOptBoolean;
                    i8 = 101;
                    try {
                        double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                        double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                        if (vsq.cL(jSONObjectOptJSONObject2)) {
                            d8 = dOptDouble2;
                            bwl.IlO((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft"));
                            bwl.MY((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight"));
                            bwl.EO((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft"));
                            bwl.tV((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight"));
                        } else {
                            d8 = dOptDouble2;
                        }
                        bwl.EO(dOptDouble3);
                        bwl.tV(dOptDouble4);
                        bwl.Cc(dOptDouble5);
                        bwl.vCE(dOptDouble6);
                    } catch (Exception unused) {
                        vsq = this;
                        i2 = 101;
                    }
                } catch (Exception unused2) {
                    i2 = 101;
                    vsq = this;
                    bwl.MY(i2);
                    bwl.IlO(lEW.IlO(i2));
                    vsq.es.IlO(bwl);
                }
            } else {
                z2 = zOptBoolean;
                d8 = dOptDouble2;
                i8 = 101;
            }
            try {
                strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, lEW.IlO(i8));
                i2 = i8;
            } catch (Exception unused3) {
                vsq = this;
            }
            try {
                int iOptInt = jSONObject.optInt("code", i2);
                bwl.IlO(z2);
                bwl.IlO(dOptDouble);
                bwl.MY(d8);
                bwl.IlO(strOptString);
                bwl.MY(iOptInt);
                vsq = this;
                vsq.es.IlO(bwl);
                if (jSONObjectOptJSONObject2 == null || (lew = vsq.HSR) == null) {
                    return;
                }
                lew.IlO(bwl);
                return;
            } catch (Exception unused4) {
                vsq = this;
                bwl.MY(i2);
                bwl.IlO(lEW.IlO(i2));
                vsq.es.IlO(bwl);
            }
        } catch (Exception unused5) {
        }
        i2 = 101;
        bwl.MY(i2);
        bwl.IlO(lEW.IlO(i2));
        vsq.es.IlO(bwl);
    }

    public void Cc(JSONObject jSONObject) {
        String str;
        double d8;
        double d9;
        double dOptDouble;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AndroidObject", "trigger Class1 method1");
        try {
            String strOptString = jSONObject.optString(f.b.f9966c);
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("clickInfo");
            double d16 = 0.0d;
            if (jSONObjectOptJSONObject2 != null) {
                double dOptDouble2 = jSONObjectOptJSONObject2.optDouble("down_x", 0.0d);
                dOptDouble = jSONObjectOptJSONObject2.optDouble("down_y", 0.0d);
                double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("up_x", 0.0d);
                double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("up_y", 0.0d);
                double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("down_time", 0.0d);
                double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("up_time", 0.0d);
                double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("button_x", 0.0d);
                double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("button_y", 0.0d);
                double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("button_width", 0.0d);
                double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("button_height", 0.0d);
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("rectInfo");
                d15 = dOptDouble10;
                d16 = dOptDouble2;
                d9 = dOptDouble3;
                d10 = dOptDouble5;
                d11 = dOptDouble6;
                d12 = dOptDouble7;
                d13 = dOptDouble8;
                d14 = dOptDouble9;
                str = strOptString;
                d8 = dOptDouble4;
            } else {
                str = strOptString;
                d8 = 0.0d;
                d9 = 0.0d;
                dOptDouble = 0.0d;
                d10 = 0.0d;
                d11 = 0.0d;
                d12 = 0.0d;
                d13 = 0.0d;
                d14 = 0.0d;
                d15 = 0.0d;
                jSONObjectOptJSONObject = null;
            }
            com.bytedance.sdk.openadsdk.core.model.bWL bwlIlO = new bWL.IlO().tV((float) d16).EO((float) dOptDouble).MY((float) d9).IlO((float) d8).MY((long) d10).IlO((long) d11).tV((int) d12).Cc((int) d13).vCE((int) d14).Bc((int) d15).IlO(strOptString2).IlO((SparseArray<EO.IlO>) null).IlO(true).MY(iOptInt).IlO(jSONObjectOptJSONObject).IlO(jSONObject.optInt("clickAreaCategory", -1)).MY(jSONObjectOptJSONObject2).IlO();
            com.bytedance.sdk.component.adexpress.MY.EV ev = this.es;
            if (ev != null) {
                ev.IlO(null, iOptInt, bwlIlO);
            }
            IlO(str, iOptInt, bwlIlO);
        } catch (Exception unused) {
            com.bytedance.sdk.component.adexpress.MY.EV ev2 = this.es;
            if (ev2 != null) {
                ev2.IlO(null, -1, null);
            }
        }
    }

    public void EO() {
        com.bytedance.sdk.component.IlO.cl clVar = this.DM;
        if (clVar == null) {
            return;
        }
        clVar.IlO();
        this.DM = null;
    }

    public vSq MY(String str) {
        this.vCE = str;
        return this;
    }

    public void tV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("zoom_type", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
        com.bytedance.sdk.component.adexpress.MY.bWL bwl = new com.bytedance.sdk.component.adexpress.MY.bWL();
        if (jSONObjectOptJSONObject != null) {
            double dOptDouble = jSONObjectOptJSONObject.optDouble("x");
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("y");
            double dOptDouble3 = jSONObjectOptJSONObject.optDouble("width");
            double dOptDouble4 = jSONObjectOptJSONObject.optDouble("height");
            bwl.EO(dOptDouble);
            bwl.tV(dOptDouble2);
            bwl.Cc(dOptDouble3);
            bwl.vCE(dOptDouble4);
        }
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl2 = this.xF;
        if (bwl2 != null) {
            bwl2.IlO(iOptInt, bwl);
        }
    }

    private void Bc(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                MY my = new MY();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        my.IlO = jSONObjectOptJSONObject.optString("__msg_type", null);
                        my.MY = jSONObjectOptJSONObject.optString("__callback_id", null);
                        my.EO = jSONObjectOptJSONObject.optString("func");
                        my.tV = jSONObjectOptJSONObject.optJSONObject("params");
                        my.Cc = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(my.IlO) && !TextUtils.isEmpty(my.EO)) {
                    Message messageObtainMessage = this.Cc.obtainMessage(11);
                    messageObtainMessage.obj = my;
                    this.Cc.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public com.bytedance.sdk.component.IlO.cl MY() {
        return this.DM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject vAh(JSONObject jSONObject) {
        if (this.IlO != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                for (Map.Entry<String, Object> entry : this.IlO.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO(e.toString(), new Object[0]);
            }
        }
        return jSONObject;
    }

    public vSq MY(com.bytedance.sdk.component.DmF.vCE vce) {
        this.tV = new WeakReference<>(vce);
        return this;
    }

    public JSONObject lEW(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
            if (oet instanceof com.bytedance.sdk.openadsdk.core.model.vAh) {
                List<com.bytedance.sdk.openadsdk.core.model.oeT> listTV = ((com.bytedance.sdk.openadsdk.core.model.vAh) oet).iuH().tV();
                for (int i2 = 0; i2 < listTV.size(); i2++) {
                    jSONArray.put(EO(listTV.get(i2)));
                }
            }
            jSONObject2.put("creatives", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void EO(JSONObject jSONObject) {
        es.IlO(cl(), this.KC instanceof Activity, jSONObject, this.cl, this.BS, this.hp, bWL(), this.Bc);
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.core.widget.IlO.IlO ilO) {
        this.gQ = ilO;
        return this;
    }

    public vSq MY(boolean z2) {
        this.YA = z2;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        this.Bc = cc;
        return this;
    }

    public vSq MY(int i2) {
        this.hp = i2;
        return this;
    }

    public static void MY(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = zPa().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.common.MY.IlO());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.MY.Cc());
        jSONObject.put(C2605va.f10440b, com.bytedance.sdk.openadsdk.common.MY.MY());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.MY.EO());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.common.MY.tV());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.MY.vCE());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.MY.IlO(cl.IlO()));
        if (DeviceUtils.MY(cl.IlO())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", C2300e4.f8279d);
        }
        jSONObject.put("device_type", Build.VERSION.RELEASE);
    }

    public void EV() {
        vAh();
    }

    public com.bytedance.sdk.openadsdk.rp.MY IlO() {
        return this.zLG;
    }

    public void IlO(com.bytedance.sdk.openadsdk.rp.MY my) {
        this.zLG = my;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(JSONObject jSONObject) {
        if (this.xF == null || jSONObject == null) {
            return;
        }
        try {
            this.xF.IlO(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    public vSq IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        WebView webView;
        if (vce != null && (webView = vce.getWebView()) != null) {
            try {
                com.bytedance.sdk.component.IlO.cl clVarMY = com.bytedance.sdk.component.IlO.cl.IlO(webView).IlO(new com.bytedance.sdk.openadsdk.EV.IlO()).IlO("ToutiaoJSBridge").IlO(new com.bytedance.sdk.component.IlO.rp() { // from class: com.bytedance.sdk.openadsdk.core.vSq.1
                    @Override // com.bytedance.sdk.component.IlO.rp
                    @NonNull
                    public <T> T IlO(@NonNull String str, @NonNull Type type) {
                        return null;
                    }

                    @Override // com.bytedance.sdk.component.IlO.rp
                    @NonNull
                    public <T> String IlO(@NonNull T t3) {
                        return null;
                    }
                }).IlO(DmF.MY().es()).MY(true).IlO().MY();
                this.DM = clVarMY;
                com.bytedance.sdk.openadsdk.EV.IlO.Bc.IlO(clVarMY, this);
                com.bytedance.sdk.openadsdk.EV.IlO.IlO.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.MY.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.EO.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.vCE.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.DmF.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.rp.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.NV.IlO(this.DM, vce);
                com.bytedance.sdk.openadsdk.EV.IlO.lEW.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.Cc.IlO(this.DM, this.AXM);
                com.bytedance.sdk.openadsdk.EV.IlO.tV.IlO(this.DM, this);
                com.bytedance.sdk.openadsdk.EV.IlO.bWL.IlO(this.DM, vce, this, this.cl);
                com.bytedance.sdk.openadsdk.EV.IlO.EV.IlO(this.DM, this, this.cl);
                com.bytedance.sdk.openadsdk.EV.IlO.hp.IlO(this.DM, this);
            } catch (Exception unused) {
            }
        }
        return this;
    }

    public void EO(boolean z2) {
        this.EO = z2;
    }

    private void EO(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            oeT(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void DmF(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.IlO ilOIuH;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt(FirebaseAnalytics.Param.INDEX);
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.cl;
        if (!(oet instanceof com.bytedance.sdk.openadsdk.core.model.vAh) || (ilOIuH = ((com.bytedance.sdk.openadsdk.core.model.vAh) oet).iuH()) == null) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.model.oeT> listTV = ilOIuH.tV();
        if (iOptInt < 0 || iOptInt >= listTV.size()) {
            return;
        }
        IlO(listTV.get(iOptInt), this.BS, false);
        com.bytedance.sdk.openadsdk.core.rp.tV.MY my = this.Ea;
        if (my != null) {
            my.tV();
        }
    }

    public void tV(boolean z2) {
        this.quf = z2;
    }

    public JSONObject Bc(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
        if (bwl != null) {
            try {
                jSONObject2.put("state", bwl.IlO(jSONObject) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    public void EO(int i2) {
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
        if (bwl != null) {
            bwl.MY(i2);
        }
    }

    private JSONObject EO(com.bytedance.sdk.openadsdk.core.model.oeT oet) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_ad_event", "1");
        jSONObject2.put("cid", oet.Jm());
        jSONObject2.put("req_id", oet.JAC());
        jSONObject2.put("ad_id", oet.ED());
        jSONObject2.put("log_extra", oet.KT());
        jSONObject2.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.hp.aP().nm());
        jSONObject.put("ad_info", jSONObject2);
        jSONObject.put("endcard_creative", oet.rHm());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(com.bytedance.sdk.openadsdk.core.lEW.bWL bwl, JSONObject jSONObject) {
        if (bwl == null || jSONObject == null) {
            return;
        }
        try {
            bwl.IlO(jSONObject.optBoolean("mute", false), !jSONObject.has("mute") ? "jsb_def" : "jsb_web");
        } catch (Exception unused) {
        }
    }

    public static JSONObject MY(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        int iHFV;
        boolean zZPa;
        JSONObject jSONObject = new JSONObject();
        if (cl.tV() != null) {
            int i2 = 0;
            if (oet != null) {
                try {
                    iHFV = oet.hFV();
                } catch (Exception unused) {
                }
            } else {
                iHFV = 0;
            }
            int iOyN = oet != null ? oet.OyN() : 0;
            int iMY = oet != null ? oet.MY() : 0;
            int iIlO = oet != null ? oet.IlO() : 0;
            boolean zCc = cl.tV().Cc(String.valueOf(iHFV));
            boolean z2 = cl.tV().rp(String.valueOf(iHFV)) == 1;
            if (iOyN != 7 && iOyN != 8) {
                zZPa = cl.tV().MY(String.valueOf(iHFV));
            } else {
                zZPa = cl.tV().zPa(String.valueOf(iHFV));
            }
            jSONObject.put("voice_control", zZPa);
            jSONObject.put("rv_skip_time", iMY);
            jSONObject.put("fv_skip_show", zCc);
            jSONObject.put("iv_skip_time", iIlO);
            jSONObject.put("show_dislike", oet != null && oet.uF());
            jSONObject.put("video_adaptation", oet != null ? oet.DM() : 0);
            if (oet != null && oet.jM() != null) {
                jSONObject.put("dynamic_configs", oet.jM());
            }
            if (com.bytedance.sdk.openadsdk.core.model.es.EO(oet)) {
                jSONObject.put("skip_change_to_close", true);
            } else {
                jSONObject.put("skip_change_to_close", z2);
            }
            if (oet.WIv() && com.bytedance.sdk.openadsdk.core.settings.hp.aP().tU()) {
                i2 = 1;
            }
            jSONObject.put("bar_render_platform", i2);
        }
        return jSONObject;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.tV.tV.Cc cc) {
        this.mmj = cc;
        return this;
    }

    public vSq IlO(boolean z2) {
        this.MY = z2;
        return this;
    }

    public vSq IlO(View view) {
        this.EV = new WeakReference<>(view);
        return this;
    }

    public vSq IlO(int i2) {
        this.ea = i2;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        this.cl = oet;
        if (oet != null) {
            this.cL = oet.vZk();
        }
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.EO eo) {
        this.wPn = eo;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.EV ev) {
        this.oc = ev;
        return this;
    }

    public vSq IlO(Map<String, Object> map) {
        this.IlO = map;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.component.adexpress.MY.EV ev) {
        this.es = ev;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.core.lEW.bWL bwl) {
        this.xF = bwl;
        return this;
    }

    public void Cc(boolean z2) {
        this.uvo = z2;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.core.MY.tV tVVar) {
        this.OOq = tVVar;
        return this;
    }

    public vSq IlO(JSONObject jSONObject) {
        this.AXM = jSONObject;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.IlO ilO) {
        this.vAh = ilO;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.vCE vce) {
        this.kBB = vce;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.Cc cc) {
        this.pP = cc;
        return this;
    }

    public vSq IlO(List<com.bytedance.sdk.openadsdk.core.model.oeT> list) {
        this.dY = list;
        return this;
    }

    public static JSONArray MY(List<com.bytedance.sdk.openadsdk.core.model.oeT> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                jSONArray.put(list.get(i2).eDn());
            }
        }
        return jSONArray;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.lEW lew) {
        this.HSR = lew;
        return this;
    }

    public vSq IlO(com.bytedance.sdk.openadsdk.rp.Bc bc) {
        this.AK = bc;
        return this;
    }

    public static void IlO(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.oeT oet) throws Exception {
        String strED = oet.ED();
        if (!TextUtils.isEmpty(strED)) {
            jSONObject.put("cid", strED);
        }
        String strKT = oet.KT();
        if (!TextUtils.isEmpty(strKT)) {
            jSONObject.put("log_extra", strKT);
        }
        String strTcT = oet.tcT();
        if (!TextUtils.isEmpty(strTcT)) {
            jSONObject.put("download_url", strTcT);
        }
        jSONObject.put("dc", TextUtils.isEmpty(cl.tV().mmj()) ? cl.tV().mmj() : "TX");
        jSONObject.put("language", rp.MY());
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.hp.aP().nm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            oeT(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void MY(@NonNull final Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if ("private".equals(host) || "dispatch_message".equals(host)) {
                    DmF(uri.toString());
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("log_event_handleUri") { // from class: com.bytedance.sdk.openadsdk.core.vSq.10
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    String strIlO;
                    String queryParameter = uri.getQueryParameter("category");
                    String queryParameter2 = uri.getQueryParameter("tag");
                    vSq.this.BS = queryParameter2;
                    String queryParameter3 = uri.getQueryParameter("label");
                    if (vSq.this.lEW(queryParameter3)) {
                        long j3 = 0;
                        try {
                            j = Long.parseLong(uri.getQueryParameter("value"));
                        } catch (Exception unused) {
                            j = 0;
                        }
                        try {
                            j3 = Long.parseLong(uri.getQueryParameter("ext_value"));
                        } catch (Exception unused2) {
                        }
                        long j8 = j3;
                        JSONObject jSONObject = null;
                        try {
                            String queryParameter4 = uri.getQueryParameter("extra");
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                JSONObject jSONObject2 = new JSONObject(queryParameter4);
                                try {
                                    jSONObject2.putOpt("ua_policy", Integer.valueOf(vSq.this.ea));
                                } catch (Throwable unused3) {
                                }
                                jSONObject = jSONObject2;
                            }
                        } catch (Throwable unused4) {
                        }
                        if (C2318f4.f8523d.equals(queryParameter3)) {
                            jSONObject = vSq.this.vAh(jSONObject);
                        }
                        if ("landing_perf_error".equals(queryParameter3) || "landing_perf_stats".equals(queryParameter3)) {
                            try {
                                jSONObject = new JSONObject();
                                for (String str : uri.getQueryParameterNames()) {
                                    try {
                                        if ("extra".equals(str)) {
                                            jSONObject.put("ad_extra_data", new JSONObject(uri.getQueryParameter(str)).optString("ad_extra_data"));
                                        } else {
                                            jSONObject.put(str, uri.getQueryParameter(str));
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                strIlO = vSq.this.vCE;
                            } catch (Exception unused6) {
                                return;
                            }
                        } else {
                            strIlO = vSq.this.IlO(queryParameter2, queryParameter3);
                        }
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(vSq.this.cl, queryParameter, strIlO, queryParameter3, j, j8, jSONObject, com.bytedance.sdk.openadsdk.core.model.es.Cc(vSq.this.cl));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0368 A[PHI: r4
  0x0368: PHI (r4v19 org.json.JSONObject) = (r4v14 org.json.JSONObject), (r4v20 org.json.JSONObject) binds: [B:232:0x03b3, B:214:0x0366] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject IlO(com.bytedance.sdk.openadsdk.core.vSq.MY r23, int r24) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.vSq.IlO(com.bytedance.sdk.openadsdk.core.vSq$MY, int):org.json.JSONObject");
    }

    private void IlO(JSONObject jSONObject, boolean z2, String str) {
        com.bytedance.sdk.openadsdk.core.widget.Cc cc;
        if (z2) {
            try {
                String strOptString = jSONObject.optString("ad_extra_data");
                if (TextUtils.isEmpty(strOptString) || new JSONObject(strOptString).optInt("agg_request_type", -1) != 1 || !C2318f4.f8523d.equals(str) || (cc = this.Bc) == null) {
                    return;
                }
                cc.IlO();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AndroidObject", "callAggClickListener faile", th);
            }
        }
    }

    private boolean IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        String strOptString;
        int iOptInt;
        String strOptString2;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("landingStyle");
            strOptString = jSONObject.optString("url");
            strOptString2 = jSONObject.optString("fallback_url");
        } else {
            strOptString = null;
            iOptInt = -1;
            strOptString2 = null;
        }
        if (iOptInt == 1) {
            if (!com.bytedance.sdk.component.utils.xF.IlO(strOptString)) {
                try {
                    jSONObject2.put("invalid_url", 1);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AndroidObject", "handleUrl, EX1->: ", e);
                }
                return false;
            }
            return true;
        }
        if (iOptInt == 2) {
            try {
                if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2)) {
                    jSONObject2.put("empty_url", 1);
                    return false;
                }
                if (!com.bytedance.sdk.component.utils.xF.IlO(strOptString2)) {
                    jSONObject2.put("invalid_url", 1);
                    return false;
                }
            } catch (JSONException e4) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AndroidObject", "handleUrl, EX2->: ", e4);
            }
        }
        return true;
    }

    private void IlO(String str, boolean z2) {
        if (this.mmj == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            this.mmj.IlO(str);
        } else {
            this.mmj.MY(str);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.MY
    public void IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(InfluenceConstants.TIME);
            String strOptString = jSONObject.optString("flag");
            com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
            if (bwl != null) {
                bwl.IlO(iOptInt, strOptString);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.AndroidObject", "requestPauseVideo json exception");
        }
    }

    private void IlO(final MY my, final JSONObject jSONObject) {
        if (my == null) {
            return;
        }
        try {
            IlO(my.tV, new com.bytedance.sdk.openadsdk.rp.tV() { // from class: com.bytedance.sdk.openadsdk.core.vSq.7
                @Override // com.bytedance.sdk.openadsdk.rp.tV
                public void IlO(boolean z2, List<com.bytedance.sdk.openadsdk.core.model.oeT> list) {
                    if (!z2) {
                        vSq.this.MY(my.MY, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", vSq.MY(list));
                        vSq.this.MY(my.MY, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean IlO(String str, int i2, com.bytedance.sdk.openadsdk.core.model.bWL bwl) {
        HashMap<String, NV> map;
        if (TextUtils.isEmpty(str) || (map = this.lMM) == null || map.get(str) == null) {
            return false;
        }
        throw null;
    }

    public void IlO(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.rp.tV tVVar) {
        if (tVVar == null) {
            return;
        }
        try {
            final com.bytedance.sdk.openadsdk.rp.tV tVVar2 = new com.bytedance.sdk.openadsdk.rp.tV() { // from class: com.bytedance.sdk.openadsdk.core.vSq.8
                @Override // com.bytedance.sdk.openadsdk.rp.tV
                public void IlO(final boolean z2, final List<com.bytedance.sdk.openadsdk.core.model.oeT> list) {
                    mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.vSq.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            tVVar.IlO(z2, list);
                        }
                    });
                }
            };
            if (this.cl != null && !TextUtils.isEmpty(this.rp)) {
                int iOyN = this.cl.OyN();
                AdSlot adSlotSsS = this.cl.ssS();
                com.bytedance.sdk.openadsdk.core.model.pP pPVar = new com.bytedance.sdk.openadsdk.core.model.pP();
                pPVar.vCE = true;
                if (this.cl.uvo() != null || this.cl.Ea() != null) {
                    pPVar.lEW = 2;
                }
                JSONObject jSONObject2 = this.cL;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
                pPVar.Bc = jSONObject2;
                cl.EO().IlO(adSlotSsS, pPVar, iOyN, new xF.IlO() { // from class: com.bytedance.sdk.openadsdk.core.vSq.9
                    @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
                    public void IlO(int i2, String str) {
                        tVVar2.IlO(false, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
                    public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
                        if (ilO.tV() == null || ilO.tV().isEmpty()) {
                            tVVar2.IlO(false, null);
                            eo.IlO(-3);
                            com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                        } else {
                            com.bytedance.sdk.openadsdk.core.model.oeT oet = ilO.tV().get(0);
                            if (oet != null) {
                                vSq.this.cL = oet.vZk();
                            }
                            tVVar2.IlO(true, ilO.tV());
                        }
                    }
                });
                return;
            }
            tVVar2.IlO(false, null);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AndroidObject", "get ads error", e);
        }
    }

    public boolean IlO(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (lEW.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String IlO(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.core.model.es.Cc(this.cl)) {
            if (C2461n2.f9471v.equals(str2)) {
                return zLG.IlO(this.hp);
            }
            return "aggregate_page";
        }
        if (com.bytedance.sdk.openadsdk.core.model.OOq.Cc(this.cl)) {
            return this.vCE;
        }
        if (this.wPn != null) {
            return zLG.IlO(this.hp);
        }
        return this.es == null ? zLG.MY(this.hp) : str;
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof MY) {
                try {
                    IlO((MY) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.NV.MY
    public void IlO(String str, JSONObject jSONObject) {
        EO(str, jSONObject);
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, boolean z2) {
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = new com.bytedance.sdk.openadsdk.core.MY.IlO(cl.IlO(), oet, str, this.hp);
        ilO.IlO(com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(cl.IlO(), oet, str));
        if (!z2) {
            ilO.IlO(false);
        }
        ilO.onClick(null);
    }

    public void IlO(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.lEW.bWL bwl = this.xF;
        if (bwl != null) {
            bwl.IlO(str, jSONObject);
            return;
        }
        com.bytedance.sdk.openadsdk.core.rp.tV.MY my = this.Ea;
        if (my != null) {
            my.IlO(str, jSONObject);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        this.Ea = my;
    }

    public void IlO(IlO ilO) {
        this.Dxv = ilO;
    }
}

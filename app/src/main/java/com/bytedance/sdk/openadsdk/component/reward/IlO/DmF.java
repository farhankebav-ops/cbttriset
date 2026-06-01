package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.xF.Bc;
import com.ironsource.C2300e4;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements Handler.Callback {
    private static final Bc.IlO NV = new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.1
    };
    private HomeWatcherReceiver AXM;
    private boolean DmF;
    private volatile boolean EV;
    private final String bWL;
    private es cl;
    private final IlO ea;
    private com.bytedance.sdk.openadsdk.core.widget.NV es;

    @NonNull
    private final oeT hp;
    private volatile boolean kBB;
    private boolean lEW;
    private com.bytedance.sdk.openadsdk.xF.lEW oeT;
    private boolean pP;
    private final Activity rp;
    private boolean tl;
    private boolean vAh;
    protected final AtomicBoolean IlO = new AtomicBoolean(false);
    private final Handler zPa = new Handler(this);
    boolean MY = false;
    boolean EO = false;
    long tV = 0;
    int Cc = 0;
    int vCE = 0;
    int Bc = 0;
    private int cL = 1;
    private boolean xF = true;
    private final com.bytedance.sdk.openadsdk.rp.Cc OOq = new com.bytedance.sdk.openadsdk.rp.Cc() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.8
        @Override // com.bytedance.sdk.openadsdk.rp.Cc
        public void IlO(int i2) {
        }

        @Override // com.bytedance.sdk.openadsdk.rp.Cc
        public void IlO() {
            if (!DmF.this.ea.BS.isFinishing() && DmF.this.ea.MY.VFH() && OOq.zPa(DmF.this.ea.MY)) {
                DmF.this.zPa.removeMessages(800);
                DmF.this.zPa.sendMessage(DmF.IlO(1, 0));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.rp.Cc
        public void MY() {
        }
    };

    public DmF(IlO ilO) {
        this.lEW = true;
        this.ea = ilO;
        this.rp = ilO.BS;
        this.bWL = ilO.Cc;
        oeT oet = ilO.MY;
        this.hp = oet;
        this.lEW = OOq.Bc(oet);
    }

    private void AXM() {
        if (this.lEW) {
            this.es = (com.bytedance.sdk.openadsdk.core.widget.NV) this.ea.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.jk);
        }
    }

    private boolean oeT() {
        if (this.es == null) {
            return false;
        }
        if (this.hp.VFH() && OOq.cL(this.hp)) {
            this.es.MY(this.hp, this.cL);
            return true;
        }
        this.es.EO();
        return false;
    }

    private String vAh() {
        String strKBB = com.bytedance.sdk.openadsdk.core.cl.tV().kBB();
        if (TextUtils.isEmpty(strKBB) || this.hp.VH() == null) {
            return strKBB;
        }
        String strMY = this.hp.VH().MY();
        double dTV = this.hp.VH().tV();
        int iCc = this.hp.VH().Cc();
        String strIlO = (this.hp.HTA() == null || TextUtils.isEmpty(this.hp.HTA().IlO())) ? "" : this.hp.HTA().IlO();
        String strED = this.hp.ED();
        String strEO = this.hp.VH().EO();
        String strIlO2 = this.hp.VH().IlO();
        String strMY2 = this.hp.VH().MY();
        String strDm = this.hp.dm();
        StringBuilder sb = new StringBuilder("appname=");
        sb.append(URLEncoder.encode(strMY));
        sb.append("&stars=");
        sb.append(dTV);
        sb.append("&comments=");
        sb.append(iCc);
        sb.append("&icon=");
        sb.append(URLEncoder.encode(strIlO));
        sb.append("&downloading=true&id=");
        sb.append(URLEncoder.encode(strED));
        sb.append("&packageName=");
        sb.append(URLEncoder.encode(strEO));
        sb.append("&downloadUrl=");
        sb.append(URLEncoder.encode(strIlO2));
        sb.append("&name=");
        sb.append(URLEncoder.encode(strMY2));
        sb.append("&orientation=");
        sb.append(this.cL == 1 ? C2300e4.h.D : C2300e4.h.C);
        sb.append("&apptitle=");
        sb.append(URLEncoder.encode(strDm));
        return strKBB + "?" + ((Object) sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.bytedance.sdk.openadsdk.xF.tV xF() {
        String strVCE = com.bytedance.sdk.openadsdk.common.MY.vCE();
        strVCE.getClass();
        switch (strVCE) {
            case "2g":
                return com.bytedance.sdk.openadsdk.xF.tV.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.xF.tV.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.xF.tV.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.xF.tV.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.xF.tV.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.xF.tV.TYPE_UNKNOWN;
        }
    }

    public void Bc() {
        if (this.lEW && !this.es.isShown()) {
            com.bytedance.sdk.openadsdk.core.widget.NV nv = this.es;
            if (nv != null) {
                nv.MY(this.hp, this.cL);
                this.es.setProgress(this.ea.lMM.NV() != null ? this.ea.lMM.NV().getProgress() : 0);
            }
            com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
            if (lew != null) {
                lew.oc();
            }
        }
    }

    public int DmF() {
        return this.vCE;
    }

    public void EV() {
        if (this.lEW && this.oeT != null && BS.tV(this.ea.lMM.NV())) {
            this.oeT.EO(true);
        }
    }

    public int NV() {
        return this.Cc;
    }

    public com.bytedance.sdk.openadsdk.rp.Cc bWL() {
        return this.OOq;
    }

    public com.bytedance.sdk.openadsdk.xF.lEW cL() {
        return this.oeT;
    }

    public boolean cl() {
        com.bytedance.sdk.openadsdk.core.widget.NV nv = this.es;
        return nv != null && nv.isShown();
    }

    public boolean ea() {
        return this.kBB;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.bytedance.sdk.openadsdk.core.widget.NV nv;
        es esVar;
        int i2 = message.what;
        if (i2 == 900) {
            if (!this.EV || !OOq.cL(this.ea.MY)) {
                return true;
            }
            int i8 = message.arg1;
            if (i8 > 0) {
                this.ea.YA.tV(true);
                int iMY = this.ea.pP.MY(i8);
                if (iMY == i8) {
                    this.ea.YA.IlO(String.valueOf(i8), null);
                } else if (iMY > 0) {
                    this.ea.YA.IlO(String.valueOf(i8), String.format(pP.IlO(this.ea.BS.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(iMY)));
                } else if (!OOq.lEW(this.hp) || ea()) {
                    this.ea.es.set(true);
                    this.ea.qz.ea();
                } else {
                    this.ea.YA.IlO(String.valueOf(i8), pP.IlO(this.ea.BS.getApplicationContext(), "tt_reward_screen_skip_tx"));
                    this.ea.YA.Cc(true);
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                messageObtain.arg1 = i8 - 1;
                this.zPa.sendMessageDelayed(messageObtain, 1000L);
                tV(i8);
            } else {
                if (!OOq.lEW(this.hp) || (OOq.vAh(this.hp) && this.ea.pP.Bc())) {
                    this.ea.YA.tV(false);
                    this.ea.es.set(true);
                    this.ea.qz.ea();
                } else {
                    this.ea.YA.EO();
                    this.ea.YA.Cc(true);
                }
                if (!this.DmF) {
                    this.pP = true;
                }
            }
            this.ea.ssS.bWL();
        } else {
            if (i2 != 800 || ((nv = this.es) != null && (!nv.isShown() || this.es.tV()))) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                int i9 = message.arg2;
                if (i9 != 0) {
                    jSONObject.put("remove_loading_page_reason", i9);
                }
                String strRp = OOq.rp(this.hp);
                IlO ilO = this.ea;
                if (ilO != null && (esVar = ilO.lMM) != null) {
                    String strPP = esVar.pP();
                    if (!TextUtils.isEmpty(strPP)) {
                        strRp = strPP;
                    }
                }
                jSONObject.put("playable_url", strRp);
                com.bytedance.sdk.openadsdk.core.widget.NV nv2 = this.es;
                displayDuration = nv2 != null ? nv2.getDisplayDuration() : 0L;
                jSONObject.put("duration", displayDuration);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFPM", "handleMessage json error", e);
            }
            long j = displayDuration;
            IlO ilO2 = this.ea;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(ilO2.MY, ilO2.Cc, "remove_loading_page", jSONObject, j);
            this.zPa.removeMessages(800);
            if (!this.rp.isFinishing()) {
                this.ea.pP.Cc();
            }
        }
        return true;
    }

    public void hp() {
        if (this.lEW) {
            this.zPa.removeMessages(900);
            this.zPa.removeMessages(600);
        }
    }

    public boolean lEW() {
        return this.EV;
    }

    public void rp() {
        if (this.lEW) {
            com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
            if (lew != null) {
                lew.EO(false);
            }
            this.zPa.removeMessages(900);
        }
    }

    public boolean zPa() {
        return this.pP;
    }

    public void Cc() {
        if (this.lEW && this.tV <= 0) {
            this.tV = System.currentTimeMillis();
            Handler handler = this.zPa;
            handler.sendMessage(handler.obtainMessage(900, DmF(), 0));
            EO(true);
        }
    }

    public void EO() {
        if (this.lEW && !this.tl) {
            this.tl = true;
            EO(false);
            IlO(this.rp.getApplicationContext());
            com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
            if (lew != null) {
                lew.YA();
            }
            this.zPa.removeCallbacksAndMessages(null);
        }
    }

    public void MY() {
        if (this.lEW && !this.IlO.getAndSet(true)) {
            this.cl.YA();
            if (OOq.lEW(this.hp)) {
                this.cl.Bc();
            }
        }
    }

    public void tV() {
        if (this.lEW) {
            try {
                HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
                this.AXM = homeWatcherReceiver;
                homeWatcherReceiver.IlO(new HomeWatcherReceiver.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.7
                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.IlO
                    public void IlO() {
                        DmF.this.EO = true;
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.IlO
                    public void MY() {
                        DmF.this.EO = true;
                    }
                });
                this.rp.getApplicationContext().registerReceiver(this.AXM, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Throwable unused) {
            }
        }
    }

    public void vCE() {
        com.bytedance.sdk.openadsdk.xF.lEW lew;
        com.bytedance.sdk.openadsdk.utils.bWL bwl;
        if (this.lEW) {
            if (!OOq.lEW(this.hp) && this.es.isShown() && (bwl = this.ea.ts) != null) {
                bwl.IlO(DmF() * 1000);
            }
            if (OOq.es(this.hp) && this.es.isShown()) {
                IlO ilO = this.ea;
                ilO.mmj.MY(ilO.qz);
            }
            com.bytedance.sdk.openadsdk.core.widget.NV nv = this.es;
            if (nv != null) {
                nv.EO();
            }
            if (this.IlO.getAndSet(true)) {
                return;
            }
            if (this.ea.lMM.DM() && (lew = this.oeT) != null) {
                lew.IlO(1);
            }
            if (OOq.Bc(this.hp) && OOq.vAh(this.hp)) {
                es esVar = this.ea.lMM;
                if (esVar == null || esVar.DM()) {
                    IlO ilO2 = this.ea;
                    ilO2.mmj.IlO(ilO2.qz);
                    return;
                }
                int i2 = !this.ea.lMM.cL() ? 2 : 3;
                com.bytedance.sdk.openadsdk.xF.lEW lew2 = this.oeT;
                if (lew2 != null) {
                    lew2.IlO(i2);
                }
                if (OOq.cL(this.ea.MY)) {
                    IlO ilO3 = this.ea;
                    int i8 = ilO3.vCE;
                    oeT oet = ilO3.MY;
                    IlO(i8, oet, oet.EJ());
                    Cc();
                    this.ea.ssS.EV();
                }
                this.ea.mmj.IlO(false);
                this.ea.lMM.mmj();
                this.kBB = true;
                this.ea.YA.EO(false);
                this.ea.pP.Cc(true);
                this.ea.uvo = true;
                if (OOq.es(this.hp)) {
                    this.zPa.removeMessages(900);
                    this.ea.YA.tV(false);
                    vSq vsq = this.ea.HSR;
                    if (vsq != null) {
                        vsq.removeMessages(1);
                        this.ea.HSR.sendEmptyMessageDelayed(600, 1000L);
                    }
                }
                com.bytedance.sdk.openadsdk.xF.lEW lew3 = this.oeT;
                if (lew3 != null) {
                    lew3.EO(true);
                }
            }
        }
    }

    public static Message IlO(int i2, int i8) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 800;
        messageObtain.arg1 = i2;
        if (i2 == 3) {
            messageObtain.arg2 = i8;
        }
        return messageObtain;
    }

    public void Cc(int i2) {
        this.Cc = i2;
    }

    public void IlO(int i2) {
        if (this.lEW) {
            if (i2 == 5) {
                this.DmF = true;
                if (OOq.vAh(this.hp)) {
                    this.zPa.removeMessages(900);
                    this.ea.HSR.sendEmptyMessage(600);
                }
            }
            this.zPa.sendMessage(IlO(i2, 0));
        }
    }

    public void MY(boolean z2) {
        if (this.lEW) {
            if (z2) {
                try {
                    if (!TextUtils.isEmpty(this.cl.pP()) && this.cl.vAh() != 0) {
                        com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO(this.cl.pP(), this.cl.vAh(), this.cl.kBB());
                    }
                } catch (Throwable unused) {
                }
            }
            if (z2) {
                try {
                    if (TextUtils.isEmpty(this.cl.pP())) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.ea.EO.IlO().MY(this.cl.pP());
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void tV(int i2) {
        this.Cc = i2 - 1;
    }

    public void Cc(boolean z2) {
        com.bytedance.sdk.openadsdk.xF.lEW lew;
        if (this.lEW && (lew = this.oeT) != null) {
            lew.IlO(z2);
        }
    }

    public void tV(boolean z2) {
        com.bytedance.sdk.openadsdk.xF.lEW lew;
        if (this.lEW && (lew = this.oeT) != null) {
            lew.EO(z2);
        }
    }

    public void EO(boolean z2) {
        if (this.lEW) {
            this.EV = z2;
            if (z2) {
                return;
            }
            this.zPa.removeMessages(900);
        }
    }

    public void MY(int i2) {
        com.bytedance.sdk.openadsdk.core.widget.NV nv;
        if (this.lEW && (nv = this.es) != null) {
            nv.setProgress(i2);
        }
    }

    public int EO(int i2) {
        return this.Bc - (this.vCE - i2);
    }

    public void IlO() {
        if (this.lEW && !this.vAh) {
            this.vAh = true;
            IlO ilO = this.ea;
            this.cl = ilO.lMM;
            this.cL = ilO.fdM;
            AXM();
            if (oeT() && OOq.cL(this.hp) && OOq.zPa(this.hp)) {
                Handler handler = this.zPa;
                handler.sendMessageDelayed(handler.obtainMessage(800, 2, OOq.IlO(2)), OOq.xF(this.hp) * 1000);
            }
        }
    }

    public void EO(String str) {
        com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
        if (lew == null || !this.lEW) {
            return;
        }
        lew.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(this.hp));
        this.oeT.lEW(str);
    }

    public void MY(String str) {
        com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
        if (lew != null) {
            if (!this.lEW) {
                return;
            }
            lew.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(this.hp));
            this.oeT.DmF(str);
        }
        if (ea()) {
            this.ea.lMM.Cc(true);
            this.ea.dY.IlO(true);
            this.ea.uvo = true;
        }
    }

    public void IlO(final com.bytedance.sdk.openadsdk.rp.vCE vce, boolean z2) {
        com.bytedance.sdk.openadsdk.ea.MY my;
        com.bytedance.sdk.component.IlO.cl clVarMY;
        com.bytedance.sdk.openadsdk.xF.lEW lewCc;
        if (this.lEW && OOq.Bc(this.hp) && this.ea.AK) {
            if (com.bytedance.sdk.openadsdk.core.DmF.MY().es()) {
                com.bytedance.sdk.openadsdk.xF.Bc.IlO(NV);
            }
            com.bytedance.sdk.openadsdk.xF.IlO ilO = new com.bytedance.sdk.openadsdk.xF.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.2
                @Override // com.bytedance.sdk.openadsdk.xF.IlO
                public void IlO(int i2, String str) {
                    super.IlO(i2, str);
                    if (DmF.this.es == null || !DmF.this.es.isShown()) {
                        return;
                    }
                    DmF.this.zPa.sendMessage(DmF.IlO(3, OOq.IlO(i2)));
                }

                @Override // com.bytedance.sdk.openadsdk.xF.IlO
                public void MY() {
                    DmF.this.ea.lMM.rp().EO(true);
                    com.bytedance.sdk.openadsdk.rp.vCE vce2 = vce;
                    if (vce2 != null) {
                        vce2.IlO();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.xF.IlO
                public com.bytedance.sdk.openadsdk.xF.tV IlO() {
                    return DmF.xF();
                }

                @Override // com.bytedance.sdk.openadsdk.xF.IlO
                public void IlO(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.tV.EO.MY(DmF.this.hp, DmF.this.bWL, "playable_track", jSONObject);
                }
            };
            com.bytedance.sdk.openadsdk.xF.EO eo = new com.bytedance.sdk.openadsdk.xF.EO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.3
                @Override // com.bytedance.sdk.openadsdk.xF.EO
                public void IlO(String str, JSONObject jSONObject) {
                    DmF.this.ea.lMM.rp().IlO(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cid", this.hp.ED());
                jSONObject.put("log_extra", this.hp.KT());
                lewCc = com.bytedance.sdk.openadsdk.xF.lEW.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), this.ea.lMM.NV().getWebView(), eo, ilO).Bc(this.ea.lMM.pP()).Cc(com.bytedance.sdk.openadsdk.common.MY.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO())).IlO(com.bytedance.sdk.openadsdk.common.MY.IlO()).EO(jSONObject).IlO("sdkEdition", com.bytedance.sdk.openadsdk.common.MY.EO()).MY(com.bytedance.sdk.openadsdk.common.MY.Cc()).tV(com.bytedance.sdk.openadsdk.common.MY.tV()).tV(false).IlO(z2).IlO(OOq.xF(this.hp)).MY(OOq.xF(this.hp)).Cc(OOq.cL(this.hp));
                this.oeT = lewCc;
            } catch (Exception unused) {
                if (this.oeT == null) {
                    my = new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.4
                        @Override // com.bytedance.sdk.openadsdk.ea.MY
                        public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("PlayablePlugin_init").MY(jSONObject2.toString());
                        }
                    };
                }
            } catch (Throwable th) {
                if (this.oeT == null) {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO("PlayablePlugin_init", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.4
                        @Override // com.bytedance.sdk.openadsdk.ea.MY
                        public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("PlayablePlugin_init").MY(jSONObject2.toString());
                        }
                    });
                }
                throw th;
            }
            if (lewCc == null) {
                my = new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.4
                    @Override // com.bytedance.sdk.openadsdk.ea.MY
                    public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("PlayablePlugin_is_null", true);
                        return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("PlayablePlugin_init").MY(jSONObject2.toString());
                    }
                };
                com.bytedance.sdk.openadsdk.ea.EO.IlO("PlayablePlugin_init", false, my);
            }
            if (this.oeT != null && !TextUtils.isEmpty(OOq.EV(this.hp))) {
                this.oeT.EO(OOq.EV(this.hp));
            }
            com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
            if (lew != null) {
                Set<String> setEV = lew.EV();
                final WeakReference weakReference = new WeakReference(this.oeT);
                for (String str : setEV) {
                    if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (clVarMY = this.ea.lMM.rp().MY()) != null) {
                        clVarMY.IlO(str, new com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.5
                            @Override // com.bytedance.sdk.component.IlO.Cc
                            public JSONObject IlO(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.IlO.vCE vce2) {
                                try {
                                    com.bytedance.sdk.openadsdk.xF.lEW lew2 = (com.bytedance.sdk.openadsdk.xF.lEW) weakReference.get();
                                    if (lew2 == null) {
                                        return null;
                                    }
                                    return lew2.tV(IlO(), jSONObject2);
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void vCE(boolean z2) {
        if (this.lEW && z2 && !this.ea.pP.Bc()) {
            com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
            if (lew != null) {
                lew.IlO(1);
            }
            boolean zCL = OOq.cL(this.hp);
            if ((zCL || OOq.vAh(this.hp)) && this.hp.VFH() && !OOq.zPa(this.hp)) {
                Handler handler = this.zPa;
                handler.sendMessageDelayed(handler.obtainMessage(800, 0, 0), 1000L);
            }
            if (zCL) {
                this.ea.pP.lEW();
                this.ea.lMM.MY(true);
                this.ea.lMM.EO(true);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.ea.MY, this.bWL, "py_loading_success");
            }
        }
    }

    public void IlO(DownloadListener downloadListener) {
        com.bytedance.sdk.component.DmF.vCE vceEV;
        if (this.lEW && (vceEV = this.cl.EV()) != null) {
            String strVAh = vAh();
            if (TextUtils.isEmpty(strVAh)) {
                return;
            }
            vceEV.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(this.rp, this.cl.hp(), this.hp.ED(), null, false) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.DmF.6
                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    if (DmF.this.xF) {
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), DmF.this.hp, DmF.this.bWL, "loading_h5_success");
                    }
                    super.onPageFinished(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    DmF.this.xF = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    DmF.this.xF = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    super.onReceivedError(webView, i2, str, str2);
                    DmF.this.xF = false;
                }
            });
            vceEV.a_(strVAh);
            vceEV.setDisplayZoomControls(false);
            vceEV.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.cl.hp(), this.cl.bWL()));
            vceEV.setDownloadListener(downloadListener);
        }
    }

    public void IlO(boolean z2) {
        if (this.lEW && z2) {
            this.cl.NV().setDomStorageEnabled(true);
        }
    }

    private void IlO(Context context) {
        if (this.lEW) {
            try {
                this.AXM.IlO(null);
                context.getApplicationContext().unregisterReceiver(this.AXM);
            } catch (Throwable unused) {
            }
        }
    }

    public void IlO(String str) {
        if (this.lEW && this.EO) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.tV);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFPM", "sendPlayableEvent error", e);
            }
            com.bytedance.sdk.openadsdk.tV.EO.MY(this.hp, this.bWL, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.EO = false;
            }
        }
    }

    public void IlO(JSONObject jSONObject) {
        if (this.lEW && jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.tV);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFPM", "endShow json error", e);
            }
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        com.bytedance.sdk.openadsdk.core.widget.NV nv;
        if (!this.lEW || (nv = this.es) == null || nv.getDownloadButton() == null) {
            return;
        }
        if (OOq.cL(this.hp) || OOq.vAh(this.hp)) {
            this.es.getDownloadButton().setOnClickListener(cc);
            this.es.getDownloadButton().setOnTouchListener(cc);
        }
    }

    public void IlO(int i2, oeT oet, boolean z2) {
        if (this.lEW && oet != null) {
            this.vCE = oet.XvI();
            this.Bc = com.bytedance.sdk.openadsdk.core.cl.tV().IlO(String.valueOf(i2), z2);
        }
    }

    public void IlO(int i2, String str, String str2) {
        if (this.lEW) {
            try {
                com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
                if (lew != null) {
                    lew.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(this.hp));
                    this.oeT.IlO(i2, str, str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void IlO(boolean z2, String str, int i2) {
        if (this.lEW) {
            try {
                com.bytedance.sdk.openadsdk.xF.lEW lew = this.oeT;
                if (lew != null) {
                    lew.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(this.hp));
                    this.oeT.IlO(z2, str, i2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void IlO(long j) {
        if (this.lEW) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = NV();
            this.zPa.sendMessageDelayed(messageObtain, j);
        }
    }
}

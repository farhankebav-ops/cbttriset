package com.bytedance.sdk.openadsdk.core.widget.IlO;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.ea.IlO.IlO;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements vSq.IlO {
    boolean Bc;
    String DmF;
    float EV;
    Context IlO;
    oeT MY;
    int NV;
    private final boolean OOq;
    float bWL;
    boolean cL;
    boolean cl;
    private boolean dY;
    float ea;
    long es;
    float hp;
    boolean lEW;
    float rp;
    WebView tV;
    private long vSq;
    long zPa;
    private final Handler tl = new vSq(bWL.MY().getLooper(), this);
    String EO = "landingpage";
    int vCE = 0;
    private final String wPn = ".*\\/serp\\?sc=.*&clkt=\\d+$";
    private final String oc = ".*\\/\\?caf_results=.*&clkt=\\d+$";
    IlO kBB = new IlO() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.vCE.1
        @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.vCE.IlO
        public void IlO() {
            vCE vce = vCE.this;
            vce.lEW = true;
            vce.vCE();
            vCE vce2 = vCE.this;
            vce2.IlO(2, vce2.DmF, vce2.NV);
        }
    };
    GestureDetector pP = new GestureDetector(cl.IlO(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.vCE.2
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f8) {
            vCE.this.cl = true;
            return false;
        }
    });
    int Cc = cl.tV().dm();
    Map<Integer, Long> xF = new HashMap();
    Map<Integer, Float> AXM = new HashMap();
    Map<Integer, Long> oeT = new HashMap();
    List<Integer> vAh = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();
    }

    public vCE(WebView webView, oeT oet, Context context, boolean z2) {
        this.MY = oet;
        this.tV = webView;
        this.IlO = context;
        this.OOq = z2;
    }

    private boolean Bc() {
        int i2 = this.vCE + 1;
        this.vCE = i2;
        if (i2 > this.Cc) {
            return true;
        }
        return ("landingpage".equals(this.EO) || "landingpage_endcard".equals(this.EO) || "landingpage_split_screen".equals(this.EO) || "landingpage_direct".equals(this.EO) || "landingpage_split_ceiling".equals(this.EO)) ? false : true;
    }

    private boolean Cc() {
        try {
            int i2 = this.NV;
            if (i2 != 2 && i2 != 3) {
                return false;
            }
            if (Pattern.matches(".*\\/serp\\?sc=.*&clkt=\\d+$", this.DmF)) {
                return true;
            }
            return Pattern.matches(".*\\/\\?caf_results=.*&clkt=\\d+$", this.DmF);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("WebArbitrageBehavior", th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lEW() {
        WebBackForwardList webBackForwardListCopyBackForwardList = this.tV.copyBackForwardList();
        if (webBackForwardListCopyBackForwardList != null) {
            int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
            this.NV = currentIndex + 1;
            if (this.OOq) {
                this.NV = currentIndex + 2;
            }
        }
    }

    private void tV(String str) {
        if (Bc()) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.MY, new IlO.C0112IlO().IlO(this.DmF).MY(Uri.decode(str)).IlO(), this.EO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void vCE() {
        if (this.AXM.get(Integer.valueOf(this.NV)) != null) {
            return;
        }
        float height = this.tV.getHeight() / BS.MY(this.IlO, this.tV.getContentHeight());
        if (height < 0.0f || height > 1.0f) {
            height = 0.0f;
        }
        this.AXM.put(Integer.valueOf(this.NV), Float.valueOf(height));
    }

    public void EO(String str) {
        if (this.Bc) {
            this.cL = true;
        }
        if (this.NV == 1 && !TextUtils.isEmpty(str) && str.contains("query=")) {
            int iIndexOf = str.indexOf("query=") + 6;
            int iIndexOf2 = str.indexOf(C2300e4.i.f8401c, iIndexOf);
            if (iIndexOf < 0 || iIndexOf2 >= str.length() || iIndexOf2 <= iIndexOf) {
                return;
            }
            tV(str.substring(iIndexOf, iIndexOf2));
        }
    }

    public void MY(String str) {
        this.DmF = str;
        lEW();
        this.xF.put(Integer.valueOf(this.NV), Long.valueOf(SystemClock.elapsedRealtime()));
        this.oeT.put(Integer.valueOf(this.NV), Long.valueOf(SystemClock.elapsedRealtime()));
        this.dY = Cc();
    }

    public void IlO(String str) {
        this.EO = str;
    }

    public void IlO() {
        MY(this.NV);
    }

    public void IlO(int i2) {
        float height = (this.tV.getHeight() + i2) / BS.MY(this.IlO, this.tV.getContentHeight());
        Float f4 = this.AXM.get(Integer.valueOf(this.NV));
        if (height > (f4 == null ? 0.0f : f4.floatValue())) {
            this.AXM.put(Integer.valueOf(this.NV), Float.valueOf(height));
        }
    }

    public void MY() {
        this.tV.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.vCE.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z2) {
                if (!z2) {
                    vCE vce = vCE.this;
                    if (!vce.lEW) {
                        vce.vCE();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (jElapsedRealtime - vCE.this.vSq >= 50) {
                            vCE vce2 = vCE.this;
                            vce2.IlO(3, vce2.DmF, vce2.NV);
                            vCE.this.vSq = jElapsedRealtime;
                            return;
                        }
                        return;
                    }
                    vce.lEW = false;
                }
                if (z2) {
                    vCE.this.lEW();
                    vCE vce3 = vCE.this;
                    vce3.xF.put(Integer.valueOf(vce3.NV), Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        });
    }

    private void tV() {
        if (Bc()) {
            return;
        }
        com.bytedance.sdk.openadsdk.ea.IlO.IlO IlO2 = new IlO.C0112IlO().IlO(this.DmF).IlO(this.NV).tV(this.EV).Cc(this.rp).vCE(this.ea).Bc(this.es).IlO();
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = IlO2;
        this.tl.sendMessageDelayed(messageObtain, 20L);
    }

    private void MY(int i2) {
        if (Bc() || this.vAh.contains(Integer.valueOf(i2))) {
            return;
        }
        this.vAh.add(Integer.valueOf(i2));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.MY, new IlO.C0112IlO().IlO(this.DmF).IlO(this.NV).NV(jElapsedRealtime - (this.oeT.get(Integer.valueOf(i2)) != null ? r6.longValue() : jElapsedRealtime)).IlO(), this.EO);
    }

    public IlO EO() {
        return this.kBB;
    }

    private void EO(int i2) {
        if (Bc()) {
            return;
        }
        vCE();
        this.Bc = true;
        com.bytedance.sdk.openadsdk.ea.IlO.IlO IlO2 = new IlO.C0112IlO().IlO(this.DmF).IlO(this.NV).IlO(this.EV).MY(this.rp).EO(this.es).EO(i2).IlO();
        try {
            if (this.dY) {
                WebView.HitTestResult hitTestResult = this.tV.getHitTestResult();
                IlO2.IlO(hitTestResult.getExtra());
                IlO2.IlO(hitTestResult.getType());
            }
        } catch (Throwable unused) {
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 200;
        messageObtain.obj = IlO2;
        this.tl.sendMessageDelayed(messageObtain, 100L);
    }

    public void IlO(MotionEvent motionEvent) {
        this.pP.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.EV = motionEvent.getX();
            this.rp = motionEvent.getY();
            this.zPa = SystemClock.elapsedRealtime();
        } else if (action != 1) {
            if (action != 3) {
                return;
            }
            EO(2);
        } else {
            this.es = SystemClock.elapsedRealtime() - this.zPa;
            if (MY(motionEvent)) {
                tV();
            } else {
                EO(1);
            }
        }
    }

    private boolean MY(MotionEvent motionEvent) {
        this.hp = motionEvent.getX();
        float y = motionEvent.getY();
        this.bWL = y;
        float f4 = this.rp;
        if (y - f4 == 0.0f) {
            return false;
        }
        this.ea = y - f4;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2, String str, int i8) {
        if (Bc()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.xF.get(Integer.valueOf(i8));
        long jLongValue = l != null ? l.longValue() : jElapsedRealtime;
        Float f4 = this.AXM.get(Integer.valueOf(i8));
        com.bytedance.sdk.openadsdk.tV.EO.EO(this.MY, new IlO.C0112IlO().IlO(str).IlO(i8).lEW(jElapsedRealtime - jLongValue).DmF(f4 == null ? 0.0f : f4.floatValue()).MY(i2).IlO(), this.EO);
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        int i2 = message.what;
        com.bytedance.sdk.openadsdk.ea.IlO.IlO ilO = (com.bytedance.sdk.openadsdk.ea.IlO.IlO) message.obj;
        if (i2 == 100) {
            ilO.tV(this.cl ? 2 : 1);
            com.bytedance.sdk.openadsdk.tV.EO.tV(this.MY, ilO, this.EO);
            this.cl = false;
        } else if (i2 == 200) {
            if (this.cL) {
                IlO(1, ilO.EO(), ilO.tV());
            }
            ilO.EO(this.cL ? 1 : 0);
            com.bytedance.sdk.openadsdk.tV.EO.Cc(this.MY, ilO, this.EO);
            this.Bc = false;
            this.cL = false;
        }
    }
}

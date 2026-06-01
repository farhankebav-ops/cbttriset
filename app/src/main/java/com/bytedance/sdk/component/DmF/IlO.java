package com.bytedance.sdk.component.DmF;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.DmF;
import com.bytedance.sdk.component.utils.dY;
import com.bytedance.sdk.component.utils.vSq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends EO implements vSq.IlO {
    private volatile float Bc;
    private final int Cc;
    private final int EO;
    private long EV;
    private final int MY;
    private float cL;
    private float cl;
    private String es;
    private int hp;
    private volatile float lEW;
    private long rp;
    private final List<Integer> tV;
    private final Context vCE;
    private View.OnTouchListener xF;
    private boolean zPa;
    private float DmF = -1.0f;
    private float NV = -1.0f;
    private final Handler ea = new vSq(DmF.IlO().getLooper(), this);
    InterfaceC0045IlO IlO = new InterfaceC0045IlO() { // from class: com.bytedance.sdk.component.DmF.IlO.1
        @Override // com.bytedance.sdk.component.DmF.IlO.InterfaceC0045IlO
        public void IlO() {
            if (IlO.this.DmF == -1.0f && IlO.this.NV == -1.0f && IlO.this.rp == -1) {
                float unused = IlO.this.DmF;
                float unused2 = IlO.this.NV;
                IlO ilO = IlO.this;
                ilO.DmF = ilO.Bc;
                IlO ilO2 = IlO.this;
                ilO2.NV = ilO2.lEW;
                IlO ilO3 = IlO.this;
                ilO3.rp = ilO3.EV;
                IlO.this.zPa = true;
            }
            float unused3 = IlO.this.DmF;
            float unused4 = IlO.this.NV;
        }

        @Override // com.bytedance.sdk.component.DmF.IlO.InterfaceC0045IlO
        public void IlO(int i2) {
            IlO.this.hp = i2;
            IlO.this.MY();
        }
    };
    private int AXM = -1;
    private final List<Integer> bWL = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.DmF.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0045IlO {
        void IlO();

        void IlO(int i2);
    }

    public IlO(Context context, int i2, int i8, List<Integer> list, int i9) {
        this.vCE = context;
        if (i2 == -1) {
            this.MY = dY.IlO(context);
        } else {
            this.MY = dY.IlO(context, i2);
        }
        this.EO = dY.IlO(context, i8);
        this.tV = list;
        this.Cc = i9;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IlO ilO;
        int action = motionEvent.getAction();
        motionEvent.getX();
        motionEvent.getY();
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        this.EV = SystemClock.elapsedRealtime();
        this.Bc = x2;
        this.lEW = y;
        if (action == 0) {
            ilO = this;
            ilO.cl = x2;
            ilO.cL = y;
        } else if (action != 1) {
            ilO = this;
        } else {
            ilO = this;
            if (ilO.IlO(x2, y, this.cl, this.cL, this.vCE)) {
                int iIlO = IlO(ilO.Bc, ilO.lEW, ilO.EV);
                boolean zContains = ilO.bWL.contains(Integer.valueOf(ilO.hp));
                IlO(view, motionEvent, iIlO, !zContains);
                if (!zContains) {
                    ilO.bWL.add(Integer.valueOf(ilO.hp));
                }
                if (iIlO == 0) {
                    motionEvent.setAction(3);
                }
            }
        }
        View.OnTouchListener onTouchListener = ilO.xF;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        this.DmF = -1.0f;
        this.NV = -1.0f;
        this.rp = -1L;
    }

    @Override // com.bytedance.sdk.component.DmF.EO
    public void IlO(View.OnTouchListener onTouchListener) {
        this.xF = onTouchListener;
    }

    public InterfaceC0045IlO IlO() {
        return this.IlO;
    }

    private void IlO(View view, MotionEvent motionEvent, int i2, boolean z2) {
        String url;
        JSONObject jSONObject = new JSONObject();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            try {
                url = webView.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = "";
        }
        jSONObject.put("arbi_current_url", url);
        jSONObject.put("click_x", motionEvent.getX());
        jSONObject.put("click_y", motionEvent.getY());
        jSONObject.put("is_interceptor", i2 == 0 ? 1 : 0);
        jSONObject.put("is_first_click", z2 ? 1 : 0);
        jSONObject.put("click_timestamp", System.currentTimeMillis());
        jSONObject.put("arbi_interceptor_type", i2);
        jSONObject.put("current_url_index", this.hp);
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = jSONObject;
        this.ea.sendMessageDelayed(messageObtain, 200L);
    }

    public void IlO(String str) {
        this.es = str;
    }

    private int IlO(float f4, float f8, long j) {
        if (this.DmF == -1.0f && this.NV == -1.0f && this.rp == -1) {
            return 1;
        }
        if (!this.tV.contains(Integer.valueOf(this.hp))) {
            return 2;
        }
        if (j - this.rp > this.Cc) {
            MY();
            return 3;
        }
        float fAbs = Math.abs(f4 - this.DmF);
        float fAbs2 = Math.abs(f8 - this.NV);
        if (fAbs <= this.MY / 2.0f && fAbs2 <= this.EO / 2.0f) {
            return 0;
        }
        MY();
        return 4;
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        int i2 = message.what;
        Object obj = message.obj;
        JSONObject jSONObject = new JSONObject();
        if (i2 == 100) {
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
                try {
                    jSONObject.put("is_trigger_jump", this.zPa ? 1 : 0);
                    this.zPa = false;
                } catch (Throwable unused) {
                }
            }
            if (com.bytedance.sdk.component.DmF.IlO.IlO.IlO().MY() != null) {
                com.bytedance.sdk.component.DmF.IlO.IlO.IlO().MY().IlO(this.es, "arbitrage_click_event", jSONObject);
            }
        }
    }
}

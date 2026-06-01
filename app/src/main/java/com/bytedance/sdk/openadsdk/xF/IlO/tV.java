package com.bytedance.sdk.openadsdk.xF.IlO;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.rp.vCE;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.xF.IlO.IlO;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static volatile tV MY;
    private final Handler IlO;
    private int EO = 0;
    private int tV = 2;
    private int Cc = 3600000;
    private final ArrayList<MY> vCE = new ArrayList<>();

    private tV() {
        mmj.MY(new lEW("pag_pre_render_init") { // from class: com.bytedance.sdk.openadsdk.xF.IlO.tV.1
            @Override // java.lang.Runnable
            public void run() {
                tV.this.EO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_pre_render_enable", 0);
                tV.this.tV = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_pre_render_max_count", 2);
                if (tV.this.tV <= 0 || tV.this.tV > 4) {
                    tV.this.tV = 2;
                }
                tV.this.Cc = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_pre_render_alive_time", 3600000);
                if (tV.this.Cc <= 0 || tV.this.Cc > 3600000) {
                    tV.this.Cc = 3600000;
                }
            }
        });
        this.IlO = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.tV.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                if (!(message.obj instanceof MY)) {
                    return false;
                }
                tV.this.vCE.remove(message.obj);
                ((MY) message.obj).tV();
                return true;
            }
        });
    }

    public static tV IlO() {
        if (MY == null) {
            synchronized (tV.class) {
                try {
                    if (MY == null) {
                        MY = new tV();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    public boolean MY() {
        return this.EO == 1;
    }

    @MainThread
    public void IlO(@Nullable final oeT oet) {
        if (MY() && oet != null && OOq.vCE(oet)) {
            final String strJAC = oet.JAC();
            if (TextUtils.isEmpty(strJAC)) {
                return;
            }
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.tV.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (tV.this.vCE.size() >= tV.this.tV) {
                            tV.this.vCE.size();
                            MY my = (MY) tV.this.vCE.remove(0);
                            if (my != null) {
                                tV.this.IlO.removeMessages(my.lEW().hashCode());
                                my.tV();
                            }
                        }
                        oet.NV(true);
                        Context contextIlO = cl.IlO();
                        oeT oet2 = oet;
                        final MY my2 = new MY(contextIlO, oet2, oet2.BES(), true, new FrameLayout(cl.IlO()), strJAC);
                        tV.this.vCE.add(my2);
                        my2.Bc();
                        Message messageObtain = Message.obtain();
                        messageObtain.what = strJAC.hashCode();
                        messageObtain.obj = my2;
                        tV.this.IlO.sendMessageDelayed(messageObtain, tV.this.Cc);
                        my2.IlO(new IlO.InterfaceC0123IlO() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.tV.3.1
                            @Override // com.bytedance.sdk.openadsdk.xF.IlO.IlO.InterfaceC0123IlO
                            public void IlO() {
                                tV.this.IlO.removeMessages(strJAC.hashCode());
                                tV.this.vCE.remove(my2);
                                my2.tV();
                            }
                        });
                        oeT oet3 = oet;
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet3, zLG.EO(oet3.ssS().getDurationSlotType()), "PL_start_pre_render", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.tV.3.2
                            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                            public JSONObject IlO() {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("is_pre_render", 1);
                                } catch (JSONException unused) {
                                }
                                return jSONObject;
                            }
                        });
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            });
        }
    }

    @MainThread
    public MY IlO(@NonNull oeT oet, FrameLayout frameLayout, vCE vce) {
        MY my;
        if (MY() && oet.ssS() != null && !TextUtils.isEmpty(oet.ssS().getBidAdm()) && OOq.vCE(oet) && frameLayout != null) {
            String strJAC = oet.JAC();
            if (TextUtils.isEmpty(strJAC)) {
                return null;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.vCE.size()) {
                    i2 = -1;
                    my = null;
                    break;
                }
                my = this.vCE.get(i2);
                if (strJAC.equals(my.lEW())) {
                    break;
                }
                i2++;
            }
            if (my != null) {
                this.IlO.removeMessages(strJAC.hashCode());
                this.vCE.remove(i2);
                this.vCE.size();
                oet.NV(true);
                my.IlO(frameLayout, vce);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, zLG.EO(oet.ssS().getDurationSlotType()), "PL_use_pre_render", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.tV.4
                    @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                    public JSONObject IlO() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_pre_render", 1);
                        } catch (JSONException unused) {
                        }
                        return jSONObject;
                    }
                });
                return my;
            }
        }
        return null;
    }
}

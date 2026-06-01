package com.bytedance.sdk.openadsdk.core.NV.tV;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.MY.EO;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.NV;
import com.bytedance.adsdk.ugeno.core.bWL;
import com.bytedance.adsdk.ugeno.core.hp;
import com.bytedance.adsdk.ugeno.tV.vCE;
import com.bytedance.sdk.openadsdk.core.NV.vCE.tV;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements bWL, hp {
    private InterfaceC0096IlO EO;
    private final Context IlO;
    private EO<View> MY;
    private bWL tV;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.NV.tV.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0096IlO {
        void IlO(EV ev);
    }

    public IlO(Context context) {
        this.IlO = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(JSONObject jSONObject, JSONObject jSONObject2, tV tVVar) {
        try {
            NV nv = new NV(this.IlO);
            EO<View> eoIlO = nv.IlO(jSONObject);
            this.MY = eoIlO;
            if (eoIlO == null) {
                if (tVVar != null) {
                    tVVar.IlO(3000, "ugen render fail");
                    return;
                }
                return;
            }
            View viewEV = eoIlO.EV();
            if (viewEV != null) {
                viewEV.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.NV.tV.IlO.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            }
            nv.IlO((hp) this);
            nv.IlO((bWL) this);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put("language", rp.MY());
                    jSONObject2.put(Q6.F, C2300e4.f8279d);
                } catch (JSONException unused) {
                }
            }
            nv.MY(jSONObject2);
            if (tVVar != null) {
                tVVar.IlO(this.MY);
            }
        } catch (Exception e) {
            if (tVVar != null) {
                tVVar.IlO(3000, "ugen render fail exception is" + e.getMessage());
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.hp
    public void IlO(EO eo, String str, vCE.IlO ilO) {
    }

    public void IlO(final JSONObject jSONObject, final JSONObject jSONObject2, final tV tVVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            MY(jSONObject, jSONObject2, tVVar);
        } else {
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.NV.tV.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.MY(jSONObject, jSONObject2, tVVar);
                }
            });
        }
    }

    public void IlO(InterfaceC0096IlO interfaceC0096IlO) {
        this.EO = interfaceC0096IlO;
    }

    public void IlO(bWL bwl) {
        this.tV = bwl;
    }

    @Override // com.bytedance.adsdk.ugeno.core.hp
    public void IlO(EV ev, hp.MY my, hp.IlO ilO) {
        InterfaceC0096IlO interfaceC0096IlO;
        if (ev == null) {
            return;
        }
        if ((ev.MY() == 1 || ev.MY() == 4) && (interfaceC0096IlO = this.EO) != null) {
            interfaceC0096IlO.IlO(ev);
        }
        if (my == null || ev.tV() == null) {
            return;
        }
        my.IlO(ev.tV());
    }

    @Override // com.bytedance.adsdk.ugeno.core.bWL
    public void IlO(EO eo, MotionEvent motionEvent) {
        bWL bwl = this.tV;
        if (bwl != null) {
            bwl.IlO(eo, motionEvent);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.NV.tV;

import android.R;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.MY.EO;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.bWL;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.NV.IlO.MY;
import com.bytedance.sdk.openadsdk.core.NV.tV.IlO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc;
import com.bytedance.sdk.openadsdk.es.IlO.IlO.tV;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2318f4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements bWL, IlO.InterfaceC0096IlO {
    protected static int IlO = 8;
    private String Bc;
    private final com.bytedance.sdk.openadsdk.core.NV.Bc.IlO Cc;
    private JSONObject DmF;
    private final Activity EO;
    private com.bytedance.sdk.openadsdk.core.NV.vCE.IlO EV;
    private IlO MY;
    private final com.bytedance.sdk.openadsdk.core.NV.vCE.MY NV;
    private float bWL;
    private long cL;
    private float cl;
    private float ea;
    private long es;
    private View hp;
    private String lEW;
    private String rp;
    private final oeT tV;
    private String vCE;
    private boolean xF = true;
    private float zPa;

    public MY(Activity activity, oeT oet, com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO, String str, com.bytedance.sdk.openadsdk.core.NV.vCE.MY my) {
        this.EO = activity;
        this.rp = str;
        this.tV = oet;
        this.NV = my;
        this.Cc = ilO;
    }

    private void MY() {
        int iJz = this.tV.Jz();
        if (iJz != 2 && iJz != 3) {
            if (iJz == 4) {
                Bc.IlO(this.EO, this.tV, this.rp).tV();
                return;
            } else {
                if (iJz != 5) {
                    return;
                }
                zLG.MY(this.EO, this.tV.qz());
                return;
            }
        }
        if (iJz == 3) {
            String strPFe = this.tV.pFe();
            if (!TextUtils.isEmpty(strPFe) && strPFe.contains("play.google.com/store")) {
                if (tV.IlO(this.EO, strPFe, strPFe.substring(strPFe.indexOf("?id=") + 4), this.rp, this.tV)) {
                    return;
                }
            }
        }
        Activity activity = this.EO;
        oeT oet = this.tV;
        int iIlO = zLG.IlO(this.rp);
        String str = this.rp;
        lMM.IlO((Context) activity, oet, iIlO, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.EO.IlO) null, str, Bc.IlO(this.EO, this.tV, str), true, 0);
    }

    public void IlO() {
        if (this.tV == null) {
            this.NV.IlO(1, "material is null", "net");
            return;
        }
        if (this.Cc == null) {
            this.NV.IlO(1, "material ugen template is null", "net");
            return;
        }
        this.MY = new IlO(this.EO);
        this.lEW = this.Cc.EO();
        this.vCE = this.Cc.IlO();
        this.Bc = this.Cc.MY();
        this.DmF = this.tV.eDn();
        this.NV.IlO("endcard");
        com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO("endcard", this.lEW, this.vCE, this.Bc, "", new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.core.NV.tV.MY.1
            @Override // com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO
            public void IlO(JSONObject jSONObject, String str) {
                MY my = MY.this;
                my.IlO(jSONObject, my.DmF);
                MY.this.NV.MY(str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO
            public void IlO(int i2, String str, String str2) {
                MY.this.NV.IlO(i2, str, str2);
            }
        });
    }

    public void IlO(View view) {
        this.hp = view;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.NV.vCE.IlO ilO) {
        this.EV = ilO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        this.MY.IlO((IlO.InterfaceC0096IlO) this);
        this.MY.IlO((bWL) this);
        this.NV.IlO();
        this.MY.IlO(jSONObject, jSONObject2, new com.bytedance.sdk.openadsdk.core.NV.vCE.tV() { // from class: com.bytedance.sdk.openadsdk.core.NV.tV.MY.2
            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.tV
            public void IlO(int i2, String str) {
                if (MY.this.NV != null) {
                    MY.this.NV.IlO(i2, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.tV
            public void IlO(EO<View> eo) {
                if (MY.this.NV != null) {
                    MY.this.NV.IlO(eo);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.tV.IlO.InterfaceC0096IlO
    public void IlO(EV ev) {
        String strOptString = ev.EO().optString("type");
        strOptString.getClass();
        switch (strOptString) {
            case "privacy":
                if (this.EO != null && !TextUtils.isEmpty(cl.tV().lMM())) {
                    TTWebsiteActivity.IlO(this.EO, this.tV, this.rp);
                    break;
                }
                break;
            case "close":
                com.bytedance.sdk.openadsdk.core.NV.vCE.IlO ilO = this.EV;
                if (ilO != null) {
                    ilO.MY();
                    break;
                }
                break;
            case "creative":
                if (this.EO != null && this.tV != null) {
                    MY();
                    ComponentCallbacks2 componentCallbacks2 = this.EO;
                    if (componentCallbacks2 instanceof com.bytedance.sdk.openadsdk.core.rp.tV.MY) {
                        ((com.bytedance.sdk.openadsdk.core.rp.tV.MY) componentCallbacks2).tV();
                    }
                    IlO(ev, this.tV);
                    break;
                }
                break;
        }
    }

    private void IlO(EV ev, oeT oet) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", this.bWL);
            jSONObject.put("down_y", this.ea);
            jSONObject.put("down_time", this.cL);
            jSONObject.put("up_x", this.zPa);
            jSONObject.put("up_y", this.cl);
            jSONObject.put("up_time", this.es);
            View viewEV = ev.IlO().EV();
            int i2 = 1;
            if (viewEV != null) {
                JSONObject jSONObject2 = new JSONObject();
                int[] iArr = new int[2];
                float width = viewEV.getWidth();
                float height = viewEV.getHeight();
                viewEV.getLocationOnScreen(iArr);
                float f4 = iArr[0];
                float f8 = iArr[1];
                jSONObject2.put("width", width);
                jSONObject2.put("height", height);
                jSONObject2.put("left", f4);
                jSONObject2.put("top", f8);
                jSONObject.put("rectInfo", jSONObject2);
            }
            View view = this.hp;
            if (view != null) {
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                jSONObject.put("button_x", iArr2[0]);
                jSONObject.put("button_y", iArr2[1]);
                jSONObject.put("button_width", this.hp.getWidth());
                jSONObject.put("button_height", this.hp.getHeight());
            }
            View viewFindViewById = this.EO.findViewById(R.id.content);
            if (viewFindViewById != null) {
                int[] iArr3 = new int[2];
                viewFindViewById.getLocationOnScreen(iArr3);
                jSONObject.put("ad_x", iArr3[0]);
                jSONObject.put("ad_y", iArr3[1]);
                jSONObject.put("width", viewFindViewById.getWidth());
                jSONObject.put("height", viewFindViewById.getHeight());
            }
            jSONObject.put("click_area_type", ev.IlO().lMM());
            jSONObject.put("brick_id", ev.IlO().dY());
            jSONObject.put("endcard_id", this.vCE);
            jSONObject.put("click_scence", 2);
            if (!this.xF) {
                i2 = 2;
            }
            jSONObject.put("user_behavior_type", i2);
            com.bytedance.sdk.openadsdk.core.NV.vCE.IlO ilO = this.EV;
            if (ilO != null) {
                jSONObject.put("endcard_type", ilO.IlO());
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, this.rp, C2318f4.f8523d, jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.bWL
    public void IlO(EO eo, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.cL = System.currentTimeMillis();
            this.bWL = motionEvent.getRawX();
            this.ea = motionEvent.getRawY();
            this.xF = true;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            if (Math.abs(motionEvent.getRawX() - this.bWL) >= IlO || Math.abs(motionEvent.getRawY() - this.ea) >= IlO) {
                this.xF = false;
                return;
            }
            return;
        }
        this.zPa = motionEvent.getRawX();
        this.cl = motionEvent.getRawY();
        if (Math.abs(this.zPa - this.bWL) >= IlO || Math.abs(this.cl - this.ea) >= IlO) {
            this.xF = false;
        }
        this.es = System.currentTimeMillis();
    }
}

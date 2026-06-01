package com.bytedance.adsdk.ugeno.tV;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.tV.MY.IlO;
import com.bytedance.adsdk.ugeno.tV.tV.IlO;
import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements EV {
    private boolean Cc;
    private com.bytedance.adsdk.ugeno.MY.EO EO;
    private IlO IlO;
    private Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> MY;
    private com.bytedance.adsdk.ugeno.core.Cc tV;
    private boolean vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> IlO;
        public Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> MY;

        public IlO(Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> map, Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> map2) {
            this.IlO = map;
            this.MY = map2;
        }
    }

    public DmF(com.bytedance.adsdk.ugeno.MY.EO eo, IlO ilO) {
        this.EO = eo;
        this.IlO = ilO;
        if (ilO != null) {
            this.MY = ilO.IlO;
        }
    }

    public void EO() {
        IlO ilO = this.IlO;
        if (ilO == null) {
            return;
        }
        for (Map.Entry<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> entry : ilO.IlO.entrySet()) {
            if (entry != null) {
                com.bytedance.adsdk.ugeno.tV.tV.IlO value = entry.getValue();
                if (value instanceof com.bytedance.adsdk.ugeno.tV.tV.MY) {
                    value.IlO(this);
                    value.IlO(new Object[0]);
                }
            }
        }
    }

    public void IlO(com.bytedance.adsdk.ugeno.core.Cc cc) {
        this.tV = cc;
    }

    public void MY() {
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO2 = IlO("twist");
        if (IlO2 != null) {
            IlO2.IlO(this);
            IlO2.IlO(new Object[0]);
        }
    }

    public void tV() {
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO2 = IlO("timer");
        if (IlO2 != null) {
            IlO2.IlO(this);
            IlO2.IlO(new Object[0]);
        }
    }

    public void IlO() {
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO2 = IlO("shake");
        if (IlO2 != null) {
            IlO2.IlO(this);
            IlO2.IlO(new Object[0]);
        }
    }

    public com.bytedance.adsdk.ugeno.tV.tV.IlO MY(String str) {
        Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> map;
        if (this.IlO == null || TextUtils.isEmpty(str) || (map = this.IlO.MY) == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean IlO(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO2 = IlO("touchStart");
        if (IlO2 instanceof com.bytedance.adsdk.ugeno.tV.tV.NV) {
            IlO2.IlO(this);
            IlO2.IlO(motionEvent);
        }
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO3 = IlO("touchEnd");
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO4 = IlO("tap");
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO5 = IlO("slide");
        if (IlO3 instanceof com.bytedance.adsdk.ugeno.tV.tV.DmF) {
            IlO3.IlO(this);
            this.vCE = IlO3.IlO(motionEvent);
        }
        if (IlO4 == null && IlO5 == null) {
            return this.vCE;
        }
        if (this.vCE && motionEvent.getAction() == 1) {
            return true;
        }
        if (IlO4 instanceof com.bytedance.adsdk.ugeno.tV.tV.Bc) {
            IlO4.IlO(this);
            this.Cc = IlO4.IlO(motionEvent);
        }
        boolean z2 = this.Cc;
        if (z2) {
            return true;
        }
        if (!(IlO5 instanceof com.bytedance.adsdk.ugeno.tV.tV.EO)) {
            return z2;
        }
        IlO5.IlO(this);
        return IlO5.IlO(motionEvent);
    }

    private void IlO(String str, List<vCE.IlO> list) {
        com.bytedance.adsdk.ugeno.tV.MY.IlO IlO2;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (vCE.IlO ilO : list) {
            if (ilO != null && (IlO2 = IlO.C0035IlO.IlO(this.EO, str, ilO)) != null) {
                IlO2.IlO();
            }
        }
    }

    public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(String str) {
        Map<String, com.bytedance.adsdk.ugeno.tV.tV.IlO> map = this.MY;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.MY.get(str);
    }

    public void IlO(String str, Object... objArr) {
        com.bytedance.adsdk.ugeno.tV.tV.IlO ilOMY = MY(str);
        if (ilOMY != null) {
            ilOMY.IlO(this);
            ilOMY.IlO(objArr);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.tV.EV
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, List<vCE.IlO> list) {
        com.bytedance.adsdk.ugeno.core.Cc cc = this.tV;
        if (cc != null) {
            cc.IlO(eo, str, list);
        }
        IlO(str, list);
    }

    public static DmF IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str) {
        com.bytedance.adsdk.ugeno.tV.tV.IlO IlO2;
        if (eo != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                IlO ilO = new IlO(new HashMap(), new HashMap());
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && (IlO2 = IlO.C0036IlO.IlO(eo.EV().getContext(), eo, jSONObjectOptJSONObject, eo.rp())) != null) {
                        ilO.IlO.put(IlO2.MY(), IlO2);
                        ilO.MY.put(IlO2.EO(), IlO2);
                    }
                }
                return new DmF(eo, ilO);
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}

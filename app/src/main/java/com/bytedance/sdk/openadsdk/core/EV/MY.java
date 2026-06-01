package com.bytedance.sdk.openadsdk.core.EV;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.EV.EO.IlO;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO {
    private long EV;
    private long NV;

    public MY(int i2, int i8, long j, long j3, IlO.EnumC0084IlO enumC0084IlO, IlO.MY my, String str, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list2, String str2) {
        super(i2, i8, enumC0084IlO, my, str, list, list2, str2);
        this.NV = j;
        this.EV = j3;
        this.DmF = "icon_click";
    }

    @Override // com.bytedance.sdk.openadsdk.core.EV.EO
    public JSONObject IlO() throws JSONException {
        JSONObject jSONObjectIlO = super.IlO();
        if (jSONObjectIlO != null) {
            jSONObjectIlO.put(TypedValues.CycleType.S_WAVE_OFFSET, this.NV);
            jSONObjectIlO.put("duration", this.EV);
        }
        return jSONObjectIlO;
    }

    public static MY IlO(JSONObject jSONObject) {
        EO eoMY = EO.MY(jSONObject);
        if (eoMY == null) {
            return null;
        }
        return new MY(eoMY.IlO, eoMY.MY, jSONObject.optLong(TypedValues.CycleType.S_WAVE_OFFSET, -1L), jSONObject.optLong("duration", -1L), eoMY.EO, eoMY.tV, eoMY.Cc, eoMY.vCE, eoMY.Bc, eoMY.lEW);
    }
}

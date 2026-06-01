package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends IlO {
    private Map<Integer, Boolean> EV;

    public EV(Context context) {
        super(context);
        this.EV = new HashMap();
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        Map<String, String> map = this.Cc;
        int i2 = map != null ? Integer.parseInt(map.get("interval")) : -1;
        if (((Integer) objArr[0]).intValue() < i2) {
            return true;
        }
        Boolean bool = this.EV.get(Integer.valueOf(i2));
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        this.EV.put(Integer.valueOf(i2), Boolean.TRUE);
        this.IlO.IlO(this.MY, this.vCE, this.EO.MY());
        return true;
    }
}

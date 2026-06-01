package com.bytedance.sdk.openadsdk.core.EV.MY;

import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO implements Comparable<MY> {
    private final float IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private final String IlO;
        private final float MY;
        private EO.EnumC0085EO EO = EO.EnumC0085EO.TRACKING_URL;
        private boolean tV = false;

        public IlO(String str, float f4) {
            this.IlO = str;
            this.MY = f4;
        }

        public MY IlO() {
            return new MY(this.MY, this.IlO, this.EO, Boolean.valueOf(this.tV));
        }
    }

    public boolean IlO(float f4) {
        return this.IlO <= f4 && !Cc();
    }

    public JSONObject MY() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", EO());
        jSONObject.put("trackingFraction", this.IlO);
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.EV.MY.EO
    public void k_() {
        super.k_();
    }

    private MY(float f4, String str, EO.EnumC0085EO enumC0085EO, Boolean bool) {
        super(str, enumC0085EO, bool);
        this.IlO = f4;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(MY my) {
        if (my == null) {
            return 1;
        }
        float f4 = this.IlO;
        float f8 = my.IlO;
        if (f4 > f8) {
            return 1;
        }
        return f4 < f8 ? -1 : 0;
    }
}

package com.bytedance.sdk.openadsdk.core.EV.MY;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends EO implements Comparable<IlO> {
    public long IlO;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.EV.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0086IlO {
        private final String IlO;
        private final long MY;
        private EO.EnumC0085EO EO = EO.EnumC0085EO.TRACKING_URL;
        private boolean tV = false;

        public C0086IlO(String str, long j) {
            this.IlO = str;
            this.MY = j;
        }

        public IlO IlO() {
            return new IlO(this.MY, this.IlO, this.EO, Boolean.valueOf(this.tV));
        }
    }

    public IlO(long j, String str, EO.EnumC0085EO enumC0085EO, Boolean bool) {
        super(str, enumC0085EO, bool);
        this.IlO = j;
    }

    public static int IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 3) {
            try {
                return (int) ((Float.parseFloat(strArrSplit[2]) * 1000.0f) + (Integer.parseInt(strArrSplit[1]) * 60000) + (Integer.parseInt(strArrSplit[0]) * 3600000));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public boolean IlO(long j) {
        return this.IlO <= j && !Cc();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(IlO ilO) {
        if (ilO == null) {
            return 1;
        }
        long j = this.IlO;
        long j3 = ilO.IlO;
        if (j > j3) {
            return 1;
        }
        return j < j3 ? -1 : 0;
    }

    public JSONObject IlO() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", EO());
        jSONObject.put("trackingMilliseconds", this.IlO);
        return jSONObject;
    }
}

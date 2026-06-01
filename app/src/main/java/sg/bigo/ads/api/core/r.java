package sg.bigo.ads.api.core;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15529a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15530b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15531c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15532d = 0;

    public r() {
        a();
    }

    private void a() {
        this.f15529a = false;
        this.f15530b = "";
        this.f15531c = 3;
        this.f15532d = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    }

    public final boolean b(int i2) {
        return i2 < this.f15531c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            a();
            return;
        }
        this.f15529a = true;
        this.f15530b = jSONObject.optString("http_succ_code");
        this.f15531c = jSONObject.optInt("retry_cnt", 3);
        int iOptInt = jSONObject.optInt("retry_interval") * 1000;
        this.f15532d = iOptInt;
        if (iOptInt < 20000) {
            this.f15532d = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        }
    }

    public final boolean a(int i2) {
        if (i2 >= 100) {
            return this.f15530b.contains(String.valueOf(i2));
        }
        return false;
    }

    public final boolean a(long j, long j3) {
        return j + ((long) this.f15532d) < j3;
    }
}

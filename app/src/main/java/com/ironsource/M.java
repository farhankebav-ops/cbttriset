package com.ironsource;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f7108a;

    public M(D0 d0) {
        this.f7108a = d0;
    }

    public void a(Activity activity, String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        if (activity != null) {
            map.put(IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW);
        }
        this.f7108a.a(A0.SHOW_AD, map);
    }

    public void b(String str) {
        a(str, (String) null);
    }

    public void c(String str) {
        this.f7108a.a(A0.AD_DISMISS_SCREEN, androidx.camera.core.processing.util.a.u("placement", str));
    }

    public void d(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        this.f7108a.a(A0.AD_ENDED, map);
    }

    public void e(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        this.f7108a.a(A0.AD_INFO_CHANGED, map);
    }

    public void f(String str) {
        this.f7108a.a(A0.AD_LEFT_APPLICATION, androidx.camera.core.processing.util.a.u("placement", str));
    }

    public void g(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        this.f7108a.a(A0.AD_OPENED, map);
    }

    public void h(String str) {
        this.f7108a.a(A0.AD_PRESENT_SCREEN, androidx.camera.core.processing.util.a.u("placement", str));
    }

    public void i(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        this.f7108a.a(A0.AD_STARTED, map);
    }

    public void j(String str) {
        this.f7108a.a(A0.AD_VIEW_BOUND, androidx.camera.core.processing.util.a.u("placement", str));
    }

    public void k(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        this.f7108a.a(A0.AD_VISIBLE, map);
    }

    public void b(String str, String str2) {
        HashMap mapU = androidx.camera.core.processing.util.a.u("placement", str);
        if (!TextUtils.isEmpty(str2)) {
            mapU.put("reason", str2);
        }
        this.f7108a.a(A0.PLACEMENT_CAPPED, mapU);
    }

    public void a(boolean z2) {
        HashMap map = new HashMap();
        map.put("status", z2 ? com.ironsource.mediationsdk.metadata.a.g : "false");
        this.f7108a.a(A0.SHOW_AD_CHANCE, map);
    }

    public void a(String str, int i2, String str2, String str3) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        map.put("reason", str2);
        if (!TextUtils.isEmpty(str3)) {
            map.put(IronSourceConstants.EVENTS_EXT1, str3);
        }
        this.f7108a.a(A0.SHOW_AD_FAILED, map);
    }

    public void a(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        this.f7108a.a(A0.AD_CLICKED, map);
    }

    public void a(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("placement", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(IronSourceConstants.EVENTS_EXT1, str2);
        }
        this.f7108a.a(A0.AD_CLOSED, map);
    }

    public void a(String str, String str2, int i2, long j, String str3, long j3, Map<String, Object> map, String str4) {
        HashMap map2 = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map2.put("placement", str);
        }
        map2.put(IronSourceConstants.EVENTS_REWARD_NAME, str2);
        map2.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(i2));
        map2.put(IronSourceConstants.EVENTS_TRANS_ID, str3);
        if (j3 != 0) {
            map2.put("duration", Long.valueOf(j3));
        }
        if (map != null) {
            map2.putAll(map);
        }
        if (!TextUtils.isEmpty(str4)) {
            map2.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, str4);
        }
        this.f7108a.a(A0.AD_REWARDED, map2, j);
    }

    public void a(String str, String str2, boolean z2) {
        HashMap map = new HashMap();
        map.put("isMultipleAdUnits", 1);
        map.put("placement", str);
        if (!TextUtils.isEmpty(str2)) {
            map.put("reason", str2);
        }
        map.put(IronSourceConstants.EVENTS_EXT1, z2 ? com.ironsource.mediationsdk.metadata.a.g : "false");
        map.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        this.f7108a.a(A0.CHECK_PLACEMENT_CAPPED, map);
    }

    public void a() {
        this.f7108a.a(A0.SESSION_CAPPED, null);
    }
}

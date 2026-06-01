package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bf f6395a = new Bf();

    private Bf() {
    }

    public final void a(int i2) {
        a(D5.TEST_SUITE_FAILED_TO_OPEN, Integer.valueOf(i2), null);
    }

    public final void b() {
        a(this, D5.TEST_SUITE_LAUNCH_TS, null, null, 6, null);
    }

    public final void c() {
        a(this, D5.TEST_SUITE_OPENED_SUCCESSFULLY, null, null, 6, null);
    }

    public final void d() {
        a(this, D5.TEST_SUITE_WEB_CONTROLLER_OPEN_SUCCESSFULLY, null, null, 6, null);
    }

    public final void a(String errorReason) {
        kotlin.jvm.internal.k.e(errorReason, "errorReason");
        a(D5.TEST_SUITE_WEB_CONTROLLER_FAILED_TO_LOAD, Integer.valueOf(IronSourceConstants.errorCode_TEST_SUITE_WEB_CONTROLLER_NOT_LOADED), errorReason);
    }

    public static /* synthetic */ void a(Bf bf, D5 d52, Integer num, String str, int i2, Object obj) throws JSONException {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        bf.a(d52, num, str);
    }

    private final void a(D5 d52, Integer num, String str) throws JSONException {
        Kf kf = Kf.f7064a;
        JSONObject jSONObjectA = kf.a(false);
        if (num != null) {
            jSONObjectA.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
            JSONArray jSONArrayA = a();
            if (jSONArrayA != null) {
                jSONObjectA.put(com.ironsource.mediationsdk.metadata.a.f9241f, jSONArrayA);
            }
        }
        if (str != null) {
            jSONObjectA.put("reason", str);
        }
        kf.a(d52, jSONObjectA);
    }

    private final JSONArray a() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapD = Kf.f7064a.d();
        if (concurrentHashMapD.containsKey(com.ironsource.mediationsdk.metadata.a.f9241f)) {
            return new JSONArray((Collection) concurrentHashMapD.get(com.ironsource.mediationsdk.metadata.a.f9241f));
        }
        return null;
    }
}

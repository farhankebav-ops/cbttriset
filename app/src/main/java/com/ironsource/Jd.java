package com.ironsource;

import com.ironsource.C2543s;
import com.ironsource.S7;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2623wb f7024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, C2543s.d> f7025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, C2543s.d> f7026c;

    public Jd(C2623wb tools, Map<String, C2543s.d> map, Map<String, C2543s.d> map2) {
        kotlin.jvm.internal.k.e(tools, "tools");
        this.f7024a = tools;
        this.f7025b = map;
        this.f7026c = map2;
    }

    private final void b(S7.a aVar, String str, String str2, Integer num) throws JSONException {
        Object objA = a(str2, num);
        if (!(objA instanceof q5.j)) {
            kotlin.jvm.internal.k.b(str2);
            kotlin.jvm.internal.k.b(num);
            aVar.a(str, str2, num.intValue());
        }
        Throwable thA = q5.k.a(objA);
        if (thA != null) {
            this.f7024a.b(str, IronSourceError.ERROR_REWARD_VALIDATION_FAILED, thA.getMessage());
        }
    }

    public final void a(S7.a rewardService) {
        kotlin.jvm.internal.k.e(rewardService, "rewardService");
        Map<String, C2543s.d> map = this.f7026c;
        if (map != null && (r0 = map.entrySet().iterator()) != null) {
            for (Map.Entry<String, C2543s.d> entry : map.entrySet()) {
                String key = entry.getKey();
                Hd hdF = entry.getValue().f();
                if (hdF != null) {
                    b(rewardService, key, hdF.b(), hdF.a());
                }
            }
        }
        Map<String, C2543s.d> map2 = this.f7025b;
        if (map2 == null || (r0 = map2.entrySet().iterator()) == null) {
            return;
        }
        for (Map.Entry<String, C2543s.d> entry2 : map2.entrySet()) {
            String key2 = entry2.getKey();
            Hd hdA = entry2.getValue().a();
            if (hdA != null) {
                a(rewardService, key2, hdA.b(), hdA.a());
            }
        }
    }

    private final void a(S7.a aVar, String str, String str2, Integer num) throws JSONException {
        Object objA = a(str2, num);
        if (!(objA instanceof q5.j)) {
            kotlin.jvm.internal.k.b(str2);
            kotlin.jvm.internal.k.b(num);
            aVar.b(str, str2, num.intValue());
        }
        Throwable thA = q5.k.a(objA);
        if (thA != null) {
            this.f7024a.b(str, IronSourceError.ERROR_REWARD_VALIDATION_FAILED, thA.getMessage());
        }
    }

    private final Object a(String str, Integer num) {
        if (str != null && num != null) {
            return q5.x.f13520a;
        }
        return r2.q.M(new Exception("name - " + str + " or amount - " + num + " is not provided or invalid"));
    }
}

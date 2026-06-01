package com.ironsource;

import android.util.Log;
import com.ironsource.C2328fe;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class A8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static A8 f6327b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private O5 f6328a;

    private A8() {
    }

    private static A8 a() {
        if (f6327b == null) {
            f6327b = new A8();
        }
        return f6327b;
    }

    public static void a(I5 i52, C2654y8 c2654y8) {
        if (i52 != null) {
            try {
                a().f6328a = new O5(i52, c2654y8);
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    public static void a(C2328fe.a aVar) {
        a(aVar, new HashMap());
    }

    public static void a(C2328fe.a aVar, Map<String, Object> map) {
        O5 o52 = a().f6328a;
        if (o52 == null) {
            Log.d(G5.f6802a, G5.U);
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.f8551b));
        }
        o52.a(aVar.f8550a, map);
    }
}

package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.l.c;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, Long> f4632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4634d;

    public f(Context context) {
        this.f4632b = null;
        this.f4633c = 50;
        this.f4634d = 100;
        this.f4631a = context;
        this.f4632b = b();
        this.f4633c = a.a(this.f4633c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.f4634d = a.a(this.f4634d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> b() {
        File fileH = com.apm.insight.l.j.h(this.f4631a);
        HashMap<String, Long> map = new HashMap<>();
        map.put(InfluenceConstants.TIME, Long.valueOf(System.currentTimeMillis()));
        try {
            JSONArray jSONArrayA = com.apm.insight.l.f.a(fileH.getAbsolutePath());
            if (!com.apm.insight.a.a(jSONArrayA)) {
                Long lDecode = Long.decode(jSONArrayA.optString(0, null));
                if (System.currentTimeMillis() - lDecode.longValue() > SignalManager.TWENTY_FOUR_HOURS_MILLIS) {
                    File fileG = com.apm.insight.l.j.g(this.f4631a);
                    fileH.renameTo(new File(fileG, String.valueOf(System.currentTimeMillis())));
                    String[] list = fileG.list();
                    if (list != null && list.length > 5) {
                        Arrays.sort(list);
                        new File(fileG, list[0]).delete();
                        return map;
                    }
                } else {
                    map.put(InfluenceConstants.TIME, lDecode);
                    for (int i2 = 1; i2 < jSONArrayA.length(); i2++) {
                        String[] strArrSplit = jSONArrayA.optString(i2, "").split(" ");
                        if (strArrSplit.length == 2) {
                            map.put(strArrSplit[0], Long.decode(strArrSplit[1]));
                        }
                    }
                }
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            com.apm.insight.c.a();
            j.a(th, "NPTH_CATCH");
        }
        return map;
    }

    public final void a() throws Throwable {
        HashMap<String, Long> map = this.f4632b;
        Long lRemove = map.remove(InfluenceConstants.TIME);
        if (lRemove == null) {
            com.apm.insight.c.a();
            j.a(new RuntimeException("err times, no time"), "NPTH_CATCH");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lRemove);
        sb.append('\n');
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(' ');
            sb.append(entry.getValue());
            sb.append('\n');
        }
        try {
            com.apm.insight.l.f.a(com.apm.insight.l.j.h(this.f4631a), sb.toString(), false);
        } catch (IOException unused) {
        }
    }

    public final boolean a(String str) {
        if (str == null) {
            str = "default";
        }
        return c.AnonymousClass1.a(this.f4632b, str, 1L).longValue() < ((long) this.f4633c) && c.AnonymousClass1.a(this.f4632b, "all", 1L).longValue() < ((long) this.f4634d);
    }
}

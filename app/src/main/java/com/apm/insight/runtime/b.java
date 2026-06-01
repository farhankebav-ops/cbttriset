package com.apm.insight.runtime;

import androidx.work.WorkRequest;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4617a = -30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f4618b;

    public static void a(long j) throws Throwable {
        if (j - f4617a < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            return;
        }
        f4617a = j;
        try {
            if (f4618b == null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                f4618b = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/TrackInfo/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % SignalManager.TWENTY_FOUR_HOURS_MILLIS)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS) + "/" + com.apm.insight.e.f());
            }
            com.apm.insight.l.f.a(f4618b, String.valueOf(System.currentTimeMillis()), false);
        } catch (IOException unused) {
        }
    }

    public static String a(long j, String str) {
        try {
            return com.apm.insight.l.f.a(new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/TrackInfo/" + ((j - (j % SignalManager.TWENTY_FOUR_HOURS_MILLIS)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS) + "/" + str), "\n");
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static void a() {
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i2 = 0; i2 < list.length - 5; i2++) {
                com.apm.insight.l.f.a(new File(file, list[i2]));
            }
        }
    }
}

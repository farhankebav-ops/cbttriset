package com.apm.insight.runtime;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f4657a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f4659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f4660c;

        public a(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length != 3) {
                com.apm.insight.c.a();
                j.a(new RuntimeException("err ProcessTrack line:".concat(str)), "NPTH_CATCH");
                return;
            }
            this.f4659b = strArrSplit[0];
            this.f4658a = strArrSplit[1];
            try {
                this.f4660c = Long.parseLong(strArrSplit[2]);
            } catch (Throwable th) {
                com.apm.insight.c.a();
                j.a(new RuntimeException("err ProcessTrack line:".concat(str), th), "NPTH_CATCH");
            }
        }
    }

    public static File a(long j) {
        return new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j - (j % SignalManager.TWENTY_FOUR_HOURS_MILLIS)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS));
    }

    @NonNull
    public static HashMap<String, a> a(long j, String str) throws Throwable {
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j - (j % SignalManager.TWENTY_FOUR_HOURS_MILLIS)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS));
        String[] list = file.list();
        HashMap<String, a> map = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray jSONArrayA = com.apm.insight.l.f.a(file2, length > 1048576 ? length - 524288 : 0L);
                    int length2 = jSONArrayA.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String strOptString = jSONArrayA.optString(length2);
                            if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(str)) {
                                map.put(str2.replace('_', ':').replace(".txt", ""), new a(strOptString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return map;
    }

    public static void a(String str, String str2) {
        File file;
        try {
            if (f4657a == null) {
                String strC = com.apm.insight.l.a.c(com.apm.insight.e.g());
                if (strC == null) {
                    file = null;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f4657a = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % SignalManager.TWENTY_FOUR_HOURS_MILLIS)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS) + '/' + strC.replace(':', '_') + ".txt");
                    file = f4657a;
                }
            } else {
                file = f4657a;
            }
            if (file != null) {
                com.apm.insight.l.f.a(file, str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }
}

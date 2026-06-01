package com.apm.insight.b;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Printer f4332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList<e> f4333c = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f4334d = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        @Nullable
        String a();

        String b();

        String c();
    }

    public static void a() {
        if (f4331a) {
            return;
        }
        f4331a = true;
        f4332b = new Printer() { // from class: com.apm.insight.b.h.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    h.a(true, str);
                } else if (str.charAt(0) == '<') {
                    h.a(false, str);
                }
            }
        };
        i.a();
        i.a(f4332b);
    }

    public static void a(e eVar) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList = f4333c;
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.add(eVar);
        }
    }

    public static void a(boolean z2, String str) {
        e.f4290a = System.nanoTime() / 1000000;
        e.f4291b = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList<e> copyOnWriteArrayList = f4333c;
        for (int i2 = 0; i2 < copyOnWriteArrayList.size(); i2++) {
            e eVar = copyOnWriteArrayList.get(i2);
            if (eVar == null || !eVar.a()) {
                if (!z2 && eVar.f4292c) {
                    eVar.b("");
                }
            } else if (z2) {
                if (!eVar.f4292c) {
                    eVar.a(str);
                }
            } else if (eVar.f4292c) {
                eVar.b(str);
            }
        }
    }
}

package com.apm.insight.runtime;

import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f4638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4639b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Printer> f4640c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Printer> f4641d = new ArrayList();
    private boolean e = false;

    static {
        new Printer() { // from class: com.apm.insight.runtime.i.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (str == null) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    i.a().a(str);
                } else if (str.charAt(0) == '<') {
                    i.a().b(str);
                }
                i.c();
            }
        };
    }

    private i() {
    }

    public static i a() {
        if (f4638a == null) {
            synchronized (i.class) {
                try {
                    if (f4638a == null) {
                        f4638a = new i();
                    }
                } finally {
                }
            }
        }
        return f4638a;
    }

    public static /* synthetic */ Printer c() {
        return null;
    }

    public final boolean b() {
        return this.f4639b != -1 && SystemClock.uptimeMillis() - this.f4639b > 5000;
    }

    public final void b(String str) {
        this.f4639b = SystemClock.uptimeMillis();
        try {
            a(this.f4641d, str);
        } catch (Exception e) {
            com.apm.insight.a.b((Throwable) e);
        }
    }

    public final void a(String str) {
        this.f4639b = -1L;
        try {
            a(this.f4640c, str);
        } catch (Exception e) {
            com.apm.insight.a.a((Throwable) e);
        }
    }

    private static void a(List<? extends Printer> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Printer printer = list.get(i2);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th) {
            com.apm.insight.a.a(th);
        }
    }
}

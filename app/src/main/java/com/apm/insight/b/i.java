package com.apm.insight.b;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4335a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f4336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Printer f4338d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f4339a = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<Printer> f4342d = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Printer> f4340b = new ArrayList();
        private boolean e = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4341c = false;

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i.b();
            if (str.charAt(0) == '>' && this.f4341c) {
                for (Printer printer : this.f4340b) {
                    if (!this.f4339a.contains(printer)) {
                        this.f4339a.add(printer);
                    }
                }
                this.f4340b.clear();
                this.f4341c = false;
            }
            if (this.f4339a.size() > i.f4335a) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : this.f4339a) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            str.charAt(0);
            i.b();
        }
    }

    public static void a() {
        if (f4337c) {
            return;
        }
        f4337c = true;
        f4336b = new b();
        Printer printerD = d();
        f4338d = printerD;
        if (printerD != null) {
            f4336b.f4339a.add(printerD);
        }
        if (com.apm.insight.e.s()) {
            Looper.getMainLooper().setMessageLogging(f4336b);
        }
    }

    public static /* synthetic */ a b() {
        return null;
    }

    private static Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Printer printer) {
        if (printer == null || f4336b.f4340b.contains(printer)) {
            return;
        }
        f4336b.f4340b.add(printer);
        f4336b.f4341c = true;
    }
}

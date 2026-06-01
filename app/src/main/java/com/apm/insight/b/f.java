package com.apm.insight.b;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f4293a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static g f4294c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f4295b;

    private f(@NonNull Context context) {
        this.f4295b = new b(context);
        g gVar = new g();
        f4294c = gVar;
        gVar.a();
    }

    public static f a(Context context) {
        if (f4293a == null) {
            synchronized (f.class) {
                try {
                    if (f4293a == null) {
                        f4293a = new f(context);
                    }
                } finally {
                }
            }
        }
        return f4293a;
    }

    public static g b() {
        return f4294c;
    }

    public final void c() {
        this.f4295b.a();
    }

    public final void d() {
        this.f4295b.b();
    }

    public final b a() {
        return this.f4295b;
    }
}

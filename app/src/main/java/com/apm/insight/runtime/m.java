package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile p f4655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f4656b;

    public static p a() {
        if (f4655a == null) {
            b();
        }
        return f4655a;
    }

    private static HandlerThread b() {
        if (f4655a == null) {
            synchronized (m.class) {
                try {
                    if (f4655a == null) {
                        p pVar = new p("default_npth_thread");
                        f4655a = pVar;
                        pVar.b();
                    }
                } finally {
                }
            }
        }
        return f4655a.c();
    }
}

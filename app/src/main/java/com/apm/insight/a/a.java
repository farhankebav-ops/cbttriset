package com.apm.insight.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.b.i;
import com.apm.insight.runtime.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements ICrashCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f4251d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f4252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile i.a f4253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile i.a f4254c;
    private volatile boolean e = false;

    private a() {
    }

    public static a a() {
        if (f4251d == null) {
            synchronized (a.class) {
                try {
                    if (f4251d == null) {
                        f4251d = new a();
                    }
                } finally {
                }
            }
        }
        return f4251d;
    }

    @Override // com.apm.insight.ICrashCallback
    public void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
        crashType.equals(CrashType.NATIVE);
    }

    public final void a(String str, i.a aVar, i.a aVar2) {
        this.f4252a = str;
        this.f4253b = aVar;
        this.f4254c = aVar2;
        if (this.e) {
            return;
        }
        this.e = true;
        m.a().a(new Runnable() { // from class: com.apm.insight.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }
}

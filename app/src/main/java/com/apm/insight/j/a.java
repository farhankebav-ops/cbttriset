package com.apm.insight.j;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f4442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4443b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4444c;

    public a(Handler handler, long j) {
        this.f4442a = handler;
        this.f4444c = j;
    }

    public final void a() {
        this.f4442a.post(this);
    }

    public final long b() {
        return this.f4444c;
    }

    public final void a(long j) {
        if (j > 0) {
            this.f4442a.postDelayed(this, j);
        } else {
            this.f4442a.post(this);
        }
    }
}

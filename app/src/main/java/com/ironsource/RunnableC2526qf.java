package com.ironsource;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.utils.IronSourceStorageUtils;

/* JADX INFO: renamed from: com.ironsource.qf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2526qf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2337g5 f9719b;

    public RunnableC2526qf(C2337g5 c2337g5, Handler handler) {
        this.f9719b = c2337g5;
        this.f9718a = handler;
    }

    public CallableC2266c6 a(C2337g5 c2337g5, String str, long j) {
        return new CallableC2266c6(c2337g5, str, j);
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        C8 c8 = new C8(this.f9719b.b().getParent(), this.f9719b.b().getName());
        Message messageA = a();
        messageA.obj = c8;
        String strA = a(c8.getParent());
        if (strA == null) {
            messageA.what = 1020;
            this.f9718a.sendMessage(messageA);
        } else {
            C2355h5 c2355h5Call = a(new C2337g5(c8, this.f9719b.e(), this.f9719b.a(), this.f9719b.c(), this.f9719b.f(), this.f9719b.d()), strA, 3L).call();
            messageA.what = c2355h5Call.b() == 200 ? 1016 : c2355h5Call.b();
            this.f9718a.sendMessage(messageA);
        }
    }

    public Message a() {
        return new Message();
    }

    public String a(String str) {
        return IronSourceStorageUtils.makeDir(str);
    }
}

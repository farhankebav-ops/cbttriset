package com.ironsource;

import java.lang.Thread;

/* JADX INFO: renamed from: com.ironsource.p4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2498p4 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f9620a;

    public C2498p4(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f9620a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        C2515q4 c2515q4 = new C2515q4(th);
        if (c2515q4.d()) {
            new P5(c2515q4.b(), "" + System.currentTimeMillis(), "Crash").a();
        }
        this.f9620a.uncaughtException(thread, th);
    }
}

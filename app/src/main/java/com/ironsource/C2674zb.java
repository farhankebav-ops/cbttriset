package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import java.util.Date;

/* JADX INFO: renamed from: com.ironsource.zb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2674zb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f10637b;

    /* JADX INFO: renamed from: com.ironsource.zb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f10638a;

        public /* synthetic */ a(C2674zb c2674zb, int i2) {
            this();
        }

        public Handler a() {
            return this.f10638a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f10638a = new Handler();
            Looper.loop();
        }

        private a() {
        }
    }

    public C2674zb() {
        a aVar = new a(this, 0);
        this.f10636a = aVar;
        aVar.start();
        this.f10637b = new Date().getTime();
    }

    public boolean a(Object obj) {
        return (obj == null || this.f10636a == null) ? false : true;
    }

    public void a(Runnable runnable) {
        Handler handlerA;
        a aVar = this.f10636a;
        if (aVar == null || (handlerA = aVar.a()) == null) {
            return;
        }
        handlerA.post(runnable);
    }
}

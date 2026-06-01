package com.ironsource;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: renamed from: com.ironsource.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2223a extends Thread {
    private static final int l = 1;
    private static final InterfaceC2241b m = new C0166a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final InterfaceC2536r9 f7934n = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7938d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2241b f7935a = m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2536r9 f7936b = f7934n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f7937c = new Handler(Looper.getMainLooper());
    private String e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7939f = false;
    private boolean g = false;
    private volatile int h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7940i = 1;
    private int j = 0;
    private final Runnable k = new c();

    /* JADX INFO: renamed from: com.ironsource.a$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements InterfaceC2536r9 {
        @Override // com.ironsource.InterfaceC2536r9
        public void a(InterruptedException interruptedException) {
            Log.w("ANRHandler", "Interrupted: " + interruptedException.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.ironsource.a$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2223a c2223a = C2223a.this;
            c2223a.h = (c2223a.h + 1) % Integer.MAX_VALUE;
        }
    }

    public C2223a(int i2) {
        this.f7938d = i2;
    }

    public C2223a c() {
        this.e = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("|ANR-ANRHandler|");
        int i2 = -1;
        while (!isInterrupted() && this.j < this.f7940i) {
            int i8 = this.h;
            this.f7937c.post(this.k);
            try {
                Thread.sleep(this.f7938d);
                if (this.h != i8) {
                    this.j = 0;
                } else if (this.g || !Debug.isDebuggerConnected()) {
                    this.j++;
                    this.f7935a.a();
                    String str = C2531r4.l;
                    if (str != null && !str.trim().isEmpty()) {
                        new P5(C2531r4.l, String.valueOf(System.currentTimeMillis()), "ANR").a();
                    }
                } else {
                    if (this.h != i2) {
                        Log.w("ANRHandler", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i2 = this.h;
                }
            } catch (InterruptedException e) {
                this.f7936b.a(e);
                return;
            }
        }
        if (this.j >= this.f7940i) {
            this.f7935a.b();
        }
    }

    public void a(int i2) {
        this.f7940i = i2;
    }

    public int b() {
        return this.f7940i;
    }

    public int a() {
        return this.j;
    }

    public C2223a b(boolean z2) {
        this.f7939f = z2;
        return this;
    }

    public C2223a a(InterfaceC2241b interfaceC2241b) {
        if (interfaceC2241b == null) {
            this.f7935a = m;
            return this;
        }
        this.f7935a = interfaceC2241b;
        return this;
    }

    public C2223a a(InterfaceC2536r9 interfaceC2536r9) {
        if (interfaceC2536r9 == null) {
            this.f7936b = f7934n;
            return this;
        }
        this.f7936b = interfaceC2536r9;
        return this;
    }

    public C2223a a(String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
        return this;
    }

    public C2223a a(boolean z2) {
        this.g = z2;
        return this;
    }

    private String a(StackTraceElement[] stackTraceElementArr) {
        String string = "";
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    StringBuilder sbR = androidx.camera.core.processing.util.a.r(string);
                    sbR.append(stackTraceElement.toString());
                    sbR.append(";\n");
                    string = sbR.toString();
                }
            }
        }
        return string;
    }

    /* JADX INFO: renamed from: com.ironsource.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class C0166a implements InterfaceC2241b {
        @Override // com.ironsource.InterfaceC2241b
        public void b() {
            throw new RuntimeException("ANRHandler has given up");
        }

        @Override // com.ironsource.InterfaceC2241b
        public void a() {
        }
    }
}

package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.ironsource.EnumC2431la;
import com.ironsource.InterfaceC2413ka;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.lifecycle.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    private static final b m = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static AtomicBoolean f8933n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final long f8934o = 700;
    private final Runnable g;
    private final Runnable h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f8940i;
    private final Runnable j;
    private final Runnable k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8935a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8936b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8937c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8938d = true;
    private EnumC2431la e = EnumC2431la.NONE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<InterfaceC2413ka> f8939f = new CopyOnWriteArrayList();
    private final a.InterfaceC0189a l = new a();

    public b() {
        final int i2 = 0;
        this.g = new Runnable(this) { // from class: com.ironsource.lifecycle.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f8943b;

            {
                this.f8943b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f8943b.f();
                        break;
                    case 1:
                        this.f8943b.g();
                        break;
                    case 2:
                        this.f8943b.h();
                        break;
                    case 3:
                        this.f8943b.i();
                        break;
                    default:
                        this.f8943b.j();
                        break;
                }
            }
        };
        final int i8 = 1;
        this.h = new Runnable(this) { // from class: com.ironsource.lifecycle.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f8943b;

            {
                this.f8943b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i8) {
                    case 0:
                        this.f8943b.f();
                        break;
                    case 1:
                        this.f8943b.g();
                        break;
                    case 2:
                        this.f8943b.h();
                        break;
                    case 3:
                        this.f8943b.i();
                        break;
                    default:
                        this.f8943b.j();
                        break;
                }
            }
        };
        final int i9 = 2;
        this.f8940i = new Runnable(this) { // from class: com.ironsource.lifecycle.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f8943b;

            {
                this.f8943b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i9) {
                    case 0:
                        this.f8943b.f();
                        break;
                    case 1:
                        this.f8943b.g();
                        break;
                    case 2:
                        this.f8943b.h();
                        break;
                    case 3:
                        this.f8943b.i();
                        break;
                    default:
                        this.f8943b.j();
                        break;
                }
            }
        };
        final int i10 = 3;
        this.j = new Runnable(this) { // from class: com.ironsource.lifecycle.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f8943b;

            {
                this.f8943b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case 0:
                        this.f8943b.f();
                        break;
                    case 1:
                        this.f8943b.g();
                        break;
                    case 2:
                        this.f8943b.h();
                        break;
                    case 3:
                        this.f8943b.i();
                        break;
                    default:
                        this.f8943b.j();
                        break;
                }
            }
        };
        final int i11 = 4;
        this.k = new Runnable(this) { // from class: com.ironsource.lifecycle.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f8943b;

            {
                this.f8943b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i11) {
                    case 0:
                        this.f8943b.f();
                        break;
                    case 1:
                        this.f8943b.g();
                        break;
                    case 2:
                        this.f8943b.h();
                        break;
                    case 3:
                        this.f8943b.i();
                        break;
                    default:
                        this.f8943b.j();
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        Iterator<InterfaceC2413ka> it = this.f8939f.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Iterator<InterfaceC2413ka> it = this.f8939f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        Iterator<InterfaceC2413ka> it = this.f8939f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        Iterator<InterfaceC2413ka> it = this.f8939f.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.ironsource.lifecycle.a.b(activity);
        com.ironsource.lifecycle.a aVarA = com.ironsource.lifecycle.a.a(activity);
        if (aVarA != null) {
            aVarA.d(this.l);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        d(activity);
    }

    public static b d() {
        return m;
    }

    public void a(InterfaceC2413ka interfaceC2413ka) {
        if (!IronsourceLifecycleProvider.a() || interfaceC2413ka == null || this.f8939f.contains(interfaceC2413ka)) {
            return;
        }
        this.f8939f.add(interfaceC2413ka);
    }

    public void b(InterfaceC2413ka interfaceC2413ka) {
        if (this.f8939f.contains(interfaceC2413ka)) {
            this.f8939f.remove(interfaceC2413ka);
        }
    }

    public EnumC2431la c() {
        return this.e;
    }

    public boolean e() {
        return this.e == EnumC2431la.STOPPED;
    }

    public void c(Activity activity) {
        int i2 = this.f8935a + 1;
        this.f8935a = i2;
        if (i2 == 1 && this.f8938d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.k);
            this.f8938d = false;
            this.e = EnumC2431la.STARTED;
        }
    }

    public void d(Activity activity) {
        this.f8935a--;
        b();
    }

    public void b(Activity activity) {
        int i2 = this.f8936b + 1;
        this.f8936b = i2;
        if (i2 == 1) {
            if (this.f8937c) {
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.j);
                this.f8937c = false;
                this.e = EnumC2431la.RESUMED;
                return;
            }
            IronSourceThreadManager.INSTANCE.removeUiThreadTask(this.g);
        }
    }

    public void a(Context context) {
        Application application;
        if (!f8933n.compareAndSet(false, true) || (application = (Application) context.getApplicationContext()) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
    }

    public void a(Activity activity) {
        int i2 = this.f8936b - 1;
        this.f8936b = i2;
        if (i2 == 0) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(this.g, 700L);
        }
    }

    private void a() {
        if (this.f8936b == 0) {
            this.f8937c = true;
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.h);
            this.e = EnumC2431la.PAUSED;
        }
    }

    private void b() {
        if (this.f8935a == 0 && this.f8937c) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.f8940i);
            this.f8938d = true;
            this.e = EnumC2431la.STOPPED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements a.InterfaceC0189a {
        public a() {
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0189a
        public void a(Activity activity) {
            b.this.c(activity);
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0189a
        public void onResume(Activity activity) {
            b.this.b(activity);
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0189a
        public void b(Activity activity) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}

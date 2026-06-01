package sg.bigo.ads.common.f;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import sg.bigo.ads.common.f.a;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15612a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f15613b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f15614c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Application f15615d;
    private WeakReference<Activity> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<a, Object> f15616f;

    public interface a {
        void a(Activity activity);
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.f.b$b, reason: collision with other inner class name */
    public static class C0285b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f15635a = new b(0);
    }

    private b() {
        this.f15616f = new WeakHashMap();
    }

    public static Application a() {
        return f15615d;
    }

    @Nullable
    public static Activity b() {
        WeakReference<Activity> weakReference = C0285b.f15635a.e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static int c() {
        int i2;
        if (!f15612a || (i2 = f15614c) < 0) {
            return 0;
        }
        return i2 > 0 ? 1 : 2;
    }

    public static boolean d() {
        return f15614c > 0;
    }

    public static boolean e() {
        return f15613b > 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull final Activity activity, @Nullable Bundle bundle) {
        f15613b++;
        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.3
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f15616f.entrySet().iterator();
                while (it.hasNext()) {
                    final a aVar = (a) ((Map.Entry) it.next()).getKey();
                    if (aVar != null) {
                        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull final Activity activity) {
        f15613b--;
        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.6
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f15616f.entrySet().iterator();
                while (it.hasNext()) {
                    final a aVar = (a) ((Map.Entry) it.next()).getKey();
                    if (aVar != null) {
                        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                aVar.a(activity);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull final Activity activity) {
        this.e = null;
        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.5
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f15616f.entrySet().iterator();
                while (it.hasNext()) {
                    final a aVar = (a) ((Map.Entry) it.next()).getKey();
                    if (aVar != null) {
                        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.5.1
                            @Override // java.lang.Runnable
                            public final void run() {
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull final Activity activity) {
        this.e = new WeakReference<>(activity);
        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.4
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f15616f.entrySet().iterator();
                while (it.hasNext()) {
                    final a aVar = (a) ((Map.Entry) it.next()).getKey();
                    if (aVar != null) {
                        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
        if (f15614c == 0) {
            sg.bigo.ads.common.f.a aVarA = sg.bigo.ads.common.f.a.a();
            aVarA.b();
            if (aVarA.f15611d != null && aVarA.c()) {
                aVarA.f15611d.a(aVarA.f15609b, aVarA.f15610c);
            }
            sg.bigo.ads.common.t.a.a(0, 3, "LAM", "On enter foreground.");
        }
        f15614c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
        int i2 = f15614c - 1;
        f15614c = i2;
        if (i2 == 0) {
            sg.bigo.ads.common.f.a aVarA = sg.bigo.ads.common.f.a.a();
            if (aVarA.f15611d != null && aVarA.c()) {
                a.InterfaceC0284a interfaceC0284a = aVarA.f15611d;
                boolean z2 = aVarA.f15608a;
                long j = aVarA.f15609b;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = aVarA.f15610c;
                System.currentTimeMillis();
                interfaceC0284a.a(z2, j, jElapsedRealtime, j3);
            }
            aVarA.f15608a = false;
            sg.bigo.ads.common.t.a.a(0, 3, "LAM", "On enter background.");
        }
    }

    public /* synthetic */ b(byte b8) {
        this();
    }

    public static void b(final a aVar) {
        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.2
            @Override // java.lang.Runnable
            public final void run() {
                C0285b.f15635a.f15616f.remove(aVar);
            }
        });
    }

    public static synchronized void a(@NonNull Application application) {
        if (f15612a) {
            return;
        }
        f15612a = true;
        f15613b = 0;
        f15614c = 0;
        f15615d = application;
        application.registerActivityLifecycleCallbacks(C0285b.f15635a);
    }

    public static void a(final a aVar) {
        d.b(new Runnable() { // from class: sg.bigo.ads.common.f.b.1
            @Override // java.lang.Runnable
            public final void run() {
                C0285b.f15635a.f15616f.put(aVar, C0285b.f15635a);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}

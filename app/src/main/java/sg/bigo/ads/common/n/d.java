package sg.bigo.ads.common.n;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<sg.bigo.ads.common.n.a> f15815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HandlerThread f15816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f15817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HandlerThread f15818d;
    private static b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HandlerThread f15819f;
    private static b g;
    private static b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static b f15820i;
    private static final WeakHashMap<Object, a> j = new WeakHashMap<>();
    private static boolean k = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f15833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Integer f15834b;

        public a(Runnable runnable, Integer num) {
            this.f15833a = runnable;
            this.f15834b = num;
        }
    }

    static {
        t.a();
    }

    public static void a(int i2, Runnable runnable) {
        b(i2, runnable, 0L);
    }

    private static synchronized void b(int i2, final Runnable runnable, long j3) {
        final b bVar;
        if (runnable == null) {
            return;
        }
        try {
            if (h == null) {
                j();
            }
            if (i2 == 0) {
                if (f15816b == null) {
                    g();
                }
                bVar = f15817c;
            } else if (i2 == 1) {
                if (f15818d == null) {
                    h();
                }
                bVar = e;
            } else if (i2 != 3) {
                bVar = h;
            } else {
                if (f15819f == null) {
                    i();
                }
                bVar = g;
            }
            if (bVar == null) {
                return;
            }
            final Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = h.getLooper();
            }
            final Runnable runnable2 = new Runnable() { // from class: sg.bigo.ads.common.n.d.1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Runnable f15822b = null;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ boolean f15823c = false;

                @Override // java.lang.Runnable
                public final void run() {
                    Runnable runnable3 = d.f15820i != null ? new Runnable() { // from class: sg.bigo.ads.common.n.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.h.post(new Runnable() { // from class: sg.bigo.ads.common.n.d.1.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    sg.bigo.ads.common.t.a.a(0, "ThreadManager", "这里使用了ThreadManager.post函数运行了一个超过30s的任务");
                                }
                            });
                        }
                    } : null;
                    if (d.f15820i != null) {
                        d.f15820i.postDelayed(runnable3, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                    }
                    synchronized (d.j) {
                        d.j.remove(runnable);
                    }
                    if (d.k) {
                        runnable.run();
                    } else {
                        try {
                            runnable.run();
                        } catch (Throwable th) {
                            sg.bigo.ads.common.t.a.a(2, "ThreadManager", "An error occurred while running a task: \n" + Log.getStackTraceString(th));
                            List<sg.bigo.ads.common.n.a> list = d.f15815a;
                            if (list != null) {
                                Iterator<sg.bigo.ads.common.n.a> it = list.iterator();
                                while (it.hasNext()) {
                                    it.next().a(th);
                                }
                            }
                        }
                    }
                    if (d.f15820i != null) {
                        d.f15820i.removeCallbacks(runnable3);
                    }
                    if (this.f15822b != null) {
                        if (this.f15823c || looperMyLooper == d.h.getLooper()) {
                            d.h.post(this.f15822b);
                        } else {
                            new Handler(looperMyLooper).post(this.f15822b);
                        }
                    }
                }
            };
            Runnable runnable3 = new Runnable() { // from class: sg.bigo.ads.common.n.d.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Runnable f15827a = null;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ boolean f15828b = false;

                @Override // java.lang.Runnable
                public final void run() {
                    if (this.f15827a == null) {
                        runnable2.run();
                    } else if (this.f15828b || looperMyLooper == d.h.getLooper()) {
                        d.h.post(new Runnable() { // from class: sg.bigo.ads.common.n.d.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass2.this.f15827a.run();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                bVar.post(runnable2);
                            }
                        });
                    } else {
                        new Handler(looperMyLooper).post(new Runnable() { // from class: sg.bigo.ads.common.n.d.2.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass2.this.f15827a.run();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                bVar.post(runnable2);
                            }
                        });
                    }
                }
            };
            WeakHashMap<Object, a> weakHashMap = j;
            synchronized (weakHashMap) {
                weakHashMap.put(runnable, new a(runnable3, Integer.valueOf(i2)));
            }
            bVar.postDelayed(runnable3, j3);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized void g() {
        if (f15816b == null) {
            HandlerThread handlerThread = new HandlerThread("BGAd-Background", 10);
            f15816b = handlerThread;
            handlerThread.start();
            f15817c = new b("BGAd-Background", f15816b.getLooper());
        }
    }

    private static synchronized void h() {
        if (f15818d == null) {
            HandlerThread handlerThread = new HandlerThread("BGAd-Work", 5);
            f15818d = handlerThread;
            handlerThread.start();
            e = new b("BGAd-Work", f15818d.getLooper());
        }
    }

    private static synchronized void i() {
        if (f15819f == null) {
            HandlerThread handlerThread = new HandlerThread("BGAd-Normal", 0);
            f15819f = handlerThread;
            handlerThread.start();
            g = new b("BGAd-Normal", f15819f.getLooper());
        }
    }

    private static synchronized void j() {
        if (h == null) {
            h = new b("BGAd-Background.Main + 38", Looper.getMainLooper());
        }
    }

    public static void a(int i2, Runnable runnable, long j3) {
        b(i2, runnable, j3);
    }

    public static void b(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            b(2, runnable, 0L);
        }
    }

    public static synchronized void a(Runnable runnable) {
        b bVar;
        if (runnable == null) {
            return;
        }
        try {
            WeakHashMap<Object, a> weakHashMap = j;
            a aVar = weakHashMap.get(runnable);
            if (aVar == null) {
                return;
            }
            Runnable runnable2 = aVar.f15833a;
            if (runnable2 != null) {
                int iIntValue = aVar.f15834b.intValue();
                if (iIntValue == 0) {
                    bVar = f15817c;
                    if (bVar != null) {
                        bVar.removeCallbacks(runnable2);
                    }
                } else if (iIntValue == 1) {
                    bVar = e;
                    if (bVar != null) {
                        bVar.removeCallbacks(runnable2);
                    }
                } else if (iIntValue == 2) {
                    bVar = h;
                    if (bVar != null) {
                        bVar.removeCallbacks(runnable2);
                    }
                } else if (iIntValue == 3) {
                    bVar = g;
                    if (bVar != null) {
                        bVar.removeCallbacks(runnable2);
                    }
                } else if (iIntValue == 1024) {
                    runnable2.run();
                }
                synchronized (weakHashMap) {
                    weakHashMap.remove(runnable);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static synchronized void a(@NonNull sg.bigo.ads.common.n.a aVar) {
        try {
            if (f15815a == null) {
                f15815a = new ArrayList();
            }
            f15815a.add(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean a() {
        return f15818d == Thread.currentThread();
    }
}

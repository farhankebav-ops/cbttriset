package sg.bigo.ads.core.player;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import sg.bigo.ads.api.core.a;
import sg.bigo.ads.common.aa.b;
import sg.bigo.ads.core.player.b.f;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements a.InterfaceC0278a, b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final Handler f17378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<WeakReference<View>> f17379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f17380d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f17382a = new d(0);
    }

    private d() {
        this.f17377a = false;
        this.f17378b = new Handler(Looper.getMainLooper());
        this.f17379c = new ArrayList<>();
        this.f17380d = new Runnable() { // from class: sg.bigo.ads.core.player.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.c()) {
                    d.this.f17378b.postDelayed(this, 500L);
                }
            }
        };
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.api.core.a.1

            /* JADX INFO: renamed from: a */
            final /* synthetic */ InterfaceC0278a f15479a;

            public AnonymousClass1(InterfaceC0278a this) {
                interfaceC0278a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = a.this.f15478b.iterator();
                while (it.hasNext()) {
                    InterfaceC0278a interfaceC0278a = (InterfaceC0278a) ((WeakReference) it.next()).get();
                    if (interfaceC0278a != null && interfaceC0278a == interfaceC0278a) {
                        return;
                    }
                }
                a.this.f15478b.add(new WeakReference(interfaceC0278a));
            }
        }, 1L);
    }

    private synchronized void d() {
        e();
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "startCheckTask called");
        this.f17378b.post(this.f17380d);
    }

    private synchronized void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "removeCheckTask called");
        this.f17378b.removeCallbacksAndMessages(null);
        c();
    }

    @Override // sg.bigo.ads.api.core.a.InterfaceC0278a
    public final void a() {
        d();
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "onActivityResumed");
    }

    @Override // sg.bigo.ads.api.core.a.InterfaceC0278a
    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "onActivityPaused");
        e();
    }

    public final synchronized boolean c() {
        f fVar;
        int playStatus;
        try {
            if (this.f17379c.isEmpty()) {
                return false;
            }
            Iterator<WeakReference<View>> it = this.f17379c.iterator();
            View view = null;
            boolean z2 = false;
            int i2 = 0;
            while (it.hasNext()) {
                View view2 = it.next().get();
                if (view2 instanceof f) {
                    z2 = view2.getContext() != null && sg.bigo.ads.common.aa.b.a(view2.getContext().getApplicationContext());
                    float f4 = 0.0f;
                    if (sg.bigo.ads.common.ab.a.a(view2, new Rect())) {
                        float height = view2.getHeight() * 1.0f * view2.getWidth();
                        float fHeight = r6.height() * 1.0f * r6.width();
                        if (height <= 0.0f) {
                            sg.bigo.ads.common.t.a.a(0, 3, "ImpressionChecker", "adView is not visible, width or height is 0");
                        } else {
                            f4 = fHeight / height;
                        }
                    }
                    int i8 = (int) (100.0f * f4);
                    if (i8 < i2 || i8 < 50 || !z2) {
                        ((f) view2).s();
                    } else {
                        if (i8 == i2) {
                            ((f) view).s();
                        } else {
                            i2 = i8;
                        }
                        view = view2;
                    }
                } else {
                    it.remove();
                    sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "playView is recycled, remove it");
                }
            }
            if (view != null && (playStatus = (fVar = (f) view).getPlayStatus()) != 2 && playStatus != 5 && playStatus != 0) {
                fVar.b();
            }
            return z2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ d(byte b8) {
        this();
    }

    @Override // sg.bigo.ads.common.aa.b.a
    public final void a(int i2) {
        if (i2 == 1) {
            d();
        }
    }

    public final synchronized void b(@NonNull f fVar) {
        try {
            Iterator<WeakReference<View>> it = this.f17379c.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    if (view == fVar) {
                        fVar.s();
                    }
                }
                it.remove();
            }
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "unregister player, size = " + this.f17379c.size());
            if (this.f17379c.isEmpty()) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(@NonNull f fVar) {
        try {
            Iterator<WeakReference<View>> it = this.f17379c.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view == null) {
                    it.remove();
                } else if (view == fVar) {
                    sg.bigo.ads.common.t.a.b("VideoPlayerManager", "register playerView exist already");
                    return;
                }
            }
            this.f17379c.add(new WeakReference<>(fVar));
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "register playerView, size = " + this.f17379c.size());
            d();
            if (!this.f17377a) {
                this.f17377a = true;
                sg.bigo.ads.common.aa.b.a(fVar.getContext().getApplicationContext(), this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

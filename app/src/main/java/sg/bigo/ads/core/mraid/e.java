package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.mraid.a;
import sg.bigo.ads.core.mraid.a.a;
import sg.bigo.ads.core.mraid.c;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements sg.bigo.ads.common.d.d {
    private final c.b A;
    private final c.b B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final Context f17171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final n f17172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final FrameLayout f17173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.core.mraid.a.a f17174d;

    @NonNull
    final j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    o f17175f;

    @Nullable
    public b g;

    @Nullable
    c.C0321c h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.core.mraid.c f17176i;

    @NonNull
    final sg.bigo.ads.core.mraid.c j;

    @NonNull
    final c k;

    @NonNull
    private WeakReference<Activity> l;

    @Nullable
    private ViewGroup m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    private final C0322e f17177n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private l f17178o;

    @Nullable
    private c.C0321c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private Integer f17179q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f17180r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17181s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f17182t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private i f17183u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final h f17184v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f17185w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17186x;
    private sg.bigo.ads.core.mraid.a y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Handler f17187z;

    public interface a extends b {
        void a(String str, String str2);
    }

    public interface b {
        void a();

        void a(@NonNull String str, @Nullable sg.bigo.ads.common.i iVar);

        boolean a(Activity activity, int i2);

        void b();

        boolean b(Activity activity, int i2);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17198b;

        private c() {
            this.f17197a = -1;
            this.f17198b = -1;
        }

        public final void a() {
            int measuredWidth = e.this.h.getMeasuredWidth();
            int measuredHeight = e.this.h.getMeasuredHeight();
            this.f17197a = measuredWidth;
            this.f17198b = measuredHeight;
        }

        public /* synthetic */ c(e eVar, byte b8) {
            this();
        }
    }

    public interface d {
        void a();
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.e$e, reason: collision with other inner class name */
    @VisibleForTesting
    public static class C0322e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        final Handler f17200a = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        a f17201b;

        /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.e$e$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NonNull
            final View[] f17202a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NonNull
            final Handler f17203b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            Runnable f17204c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f17205d;
            final Runnable e;

            private a(@NonNull Handler handler, @NonNull View[] viewArr) {
                this.e = new Runnable() { // from class: sg.bigo.ads.core.mraid.e.e.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (final View view : a.this.f17202a) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                a.a(a.this);
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: sg.bigo.ads.core.mraid.e.e.a.1.1
                                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                    public final boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        a.a(a.this);
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.f17203b = handler;
                this.f17202a = viewArr;
            }

            public final void a() {
                this.f17203b.removeCallbacks(this.e);
                this.f17204c = null;
            }

            public /* synthetic */ a(Handler handler, View[] viewArr, byte b8) {
                this(handler, viewArr);
            }

            public static /* synthetic */ void a(a aVar) {
                Runnable runnable;
                int i2 = aVar.f17205d - 1;
                aVar.f17205d = i2;
                if (i2 != 0 || (runnable = aVar.f17204c) == null) {
                    return;
                }
                runnable.run();
                aVar.f17204c = null;
            }
        }

        public final void a() {
            a aVar = this.f17201b;
            if (aVar != null) {
                aVar.a();
                this.f17201b = null;
            }
        }
    }

    public e(@NonNull Context context, @NonNull n nVar) {
        this(context, nVar, new sg.bigo.ads.core.mraid.c(nVar), new sg.bigo.ads.core.mraid.c(n.INTERSTITIAL), new C0322e());
    }

    public static int a(int i2, int i8, int i9) {
        return Math.max(i2, Math.min(i8, i9));
    }

    private void l() {
        this.f17176i.a();
        this.h = null;
    }

    private void m() {
        this.j.a();
        this.p = null;
    }

    @VisibleForTesting
    private void n() throws sg.bigo.ads.core.mraid.d {
        int iA;
        i iVar = this.f17183u;
        if (iVar != i.NONE) {
            iA = iVar.f17235d;
        } else {
            if (this.f17182t) {
                o();
                return;
            }
            Activity activity = this.l.get();
            if (activity == null) {
                throw new sg.bigo.ads.core.mraid.d("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            iA = sg.bigo.ads.common.aa.b.a(activity);
        }
        a(iA);
    }

    @VisibleForTesting
    private void o() {
        Integer num;
        j().setSystemUiVisibility(this.f17181s);
        Activity activity = this.l.get();
        if (activity != null && (num = this.f17179q) != null) {
            b bVar = this.g;
            if (bVar != null && bVar.b(activity, num.intValue())) {
                return;
            } else {
                activity.setRequestedOrientation(this.f17179q.intValue());
            }
        }
        this.f17179q = null;
    }

    private boolean p() {
        return !this.f17174d.f17137a.isVisible();
    }

    private void q() {
        if (this.y != null) {
            this.f17171a.getContentResolver().unregisterContentObserver(this.y);
            this.y = null;
        }
    }

    @Nullable
    public final c.C0321c b() {
        return this.j.c() ? this.p : this.h;
    }

    @VisibleForTesting
    public final boolean c() {
        Activity activity = this.l.get();
        if (activity == null || b() == null) {
            return false;
        }
        if (this.f17172b != n.INLINE) {
            return true;
        }
        return h.a(activity);
    }

    public final void d() {
        this.f17185w = false;
        k();
        c.C0321c c0321c = this.h;
        if (c0321c != null) {
            c0321c.onResume();
        }
        c.C0321c c0321c2 = this.p;
        if (c0321c2 != null) {
            c0321c2.onResume();
        }
    }

    public final void e() {
        this.f17177n.a();
        try {
            sg.bigo.ads.common.d.a.a().a(this);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        if (!this.f17185w) {
            a(true);
        }
        u.b(this.f17174d);
        l();
        m();
        o();
        q();
        this.m = null;
        u.b(this.f17173c);
        u.b(this.f17174d);
        this.f17186x = true;
    }

    public final void f() {
        b bVar;
        if (this.f17172b != n.INTERSTITIAL || (bVar = this.g) == null) {
            return;
        }
        bVar.g();
    }

    @VisibleForTesting
    public final void g() {
        o oVar;
        o oVar2;
        ViewGroup.LayoutParams layoutParams;
        c.C0321c c0321c;
        if (this.h == null || (oVar = this.f17175f) == o.LOADING || oVar == (oVar2 = o.HIDDEN)) {
            return;
        }
        o oVar3 = o.EXPANDED;
        if (oVar == oVar3 || this.f17172b == n.INTERSTITIAL) {
            o();
        }
        o oVar4 = this.f17175f;
        if (oVar4 != o.RESIZED && oVar4 != oVar3) {
            if (oVar4 == o.DEFAULT) {
                this.f17173c.setVisibility(4);
                a(oVar2);
                return;
            }
            return;
        }
        if (!this.j.c() || (c0321c = this.p) == null) {
            this.f17174d.removeView(this.h);
            this.f17173c.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
            this.f17173c.setVisibility(0);
        } else {
            m();
            this.f17174d.removeView(c0321c);
        }
        c cVar = this.k;
        c.C0321c c0321c2 = e.this.h;
        if (c0321c2 != null && cVar.f17197a > 0 && cVar.f17198b > 0 && (layoutParams = c0321c2.getLayoutParams()) != null) {
            layoutParams.width = cVar.f17197a;
            layoutParams.height = cVar.f17198b;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            e.this.h.setLayoutParams(layoutParams);
        }
        u.b(this.f17174d);
        a(o.DEFAULT);
    }

    @VisibleForTesting
    public final void h() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
    }

    @NonNull
    public final ViewGroup i() {
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            return viewGroup;
        }
        View viewA = u.a(this.l.get(), this.f17173c);
        return viewA instanceof ViewGroup ? (ViewGroup) viewA : this.f17173c;
    }

    @NonNull
    public final ViewGroup j() {
        if (this.m == null) {
            this.m = i();
        }
        return this.m;
    }

    public final void k() {
        o oVar;
        if (this.f17186x || (oVar = this.f17175f) == o.LOADING || oVar == o.HIDDEN || this.h == null) {
            return;
        }
        Context context = this.f17171a;
        if (this.y != null) {
            q();
        }
        this.y = new sg.bigo.ads.core.mraid.a(this.f17187z, context.getApplicationContext(), new a.InterfaceC0319a() { // from class: sg.bigo.ads.core.mraid.e.7
            @Override // sg.bigo.ads.core.mraid.a.InterfaceC0319a
            public final void a(float f4) {
                e.this.f17176i.c("mraidbridge.notifyAudioVolumeChangeEvent(" + f4 + ");");
            }
        });
        context.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.y);
    }

    @VisibleForTesting
    private e(@NonNull Context context, @NonNull n nVar, @NonNull sg.bigo.ads.core.mraid.c cVar, @NonNull sg.bigo.ads.core.mraid.c cVar2, @NonNull C0322e c0322e) {
        o oVar = o.LOADING;
        this.f17175f = oVar;
        this.f17182t = true;
        this.f17183u = i.NONE;
        this.f17185w = true;
        byte b8 = 0;
        this.f17186x = false;
        c.a aVar = new c.a() { // from class: sg.bigo.ads.core.mraid.e.3
            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a() {
                e eVar = e.this;
                eVar.f17176i.a(h.b(eVar.f17171a), h.a(eVar.f17171a), h.d(eVar.f17171a), h.c(eVar.f17171a), eVar.c());
                eVar.f17176i.a(eVar.f17172b);
                sg.bigo.ads.core.mraid.c cVar3 = eVar.f17176i;
                cVar3.a(cVar3.b());
                eVar.f17176i.a(eVar.e);
                eVar.k();
                eVar.a(o.DEFAULT);
                eVar.f17176i.c("mraidbridge.notifyReadyEvent();");
                b bVar = e.this.g;
                if (bVar != null) {
                    bVar.a();
                }
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b() {
                b bVar = e.this.g;
                if (bVar != null) {
                    bVar.b();
                }
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void c() {
                e.this.h();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean d() {
                return e.this.a();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void e() {
                e.this.f();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void f() {
                e.this.g();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(int i2, int i8, int i9, int i10, @NonNull a.EnumC0320a enumC0320a, boolean z2) throws sg.bigo.ads.core.mraid.d {
                e eVar = e.this;
                if (eVar.h == null) {
                    throw new sg.bigo.ads.core.mraid.d("Unable to resize after the WebView is destroyed");
                }
                o oVar2 = eVar.f17175f;
                if (oVar2 == o.LOADING || oVar2 == o.HIDDEN) {
                    return;
                }
                if (oVar2 == o.EXPANDED) {
                    throw new sg.bigo.ads.core.mraid.d("Not allowed to resize from an already expanded ad");
                }
                if (eVar.f17172b == n.INTERSTITIAL) {
                    throw new sg.bigo.ads.core.mraid.d("Not allowed to resize from an interstitial ad");
                }
                eVar.k.a();
                Context context2 = eVar.f17171a;
                int iA = sg.bigo.ads.common.utils.e.a(context2, i2);
                int iA2 = sg.bigo.ads.common.utils.e.a(context2, i8);
                int iA3 = sg.bigo.ads.common.utils.e.a(context2, i9);
                int iA4 = sg.bigo.ads.common.utils.e.a(context2, i10);
                Rect rect = eVar.e.g;
                int i11 = rect.left + iA3;
                int i12 = rect.top + iA4;
                Rect rect2 = new Rect(i11, i12, iA + i11, i12 + iA2);
                if (!z2) {
                    Rect rect3 = eVar.e.f17238c;
                    if (rect2.width() > rect3.width() || rect2.height() > rect3.height()) {
                        StringBuilder sbW = a1.a.w(i2, "resizeProperties specified a size (", ", ", i8, ") and offset (");
                        androidx.camera.core.processing.util.a.w(i9, i10, ", ", ") that doesn't allow the ad to appear within the max allowed size (", sbW);
                        sbW.append(eVar.e.f17239d.width());
                        sbW.append(", ");
                        sbW.append(eVar.e.f17239d.height());
                        sbW.append(")");
                        throw new sg.bigo.ads.core.mraid.d(sbW.toString());
                    }
                    rect2.offsetTo(e.a(rect3.left, rect2.left, rect3.right - rect2.width()), e.a(rect3.top, rect2.top, rect3.bottom - rect2.height()));
                }
                Rect rect4 = new Rect();
                eVar.f17174d.a(enumC0320a, rect2, rect4);
                if (!eVar.e.f17238c.contains(rect4)) {
                    StringBuilder sbW2 = a1.a.w(i2, "resizeProperties specified a size (", ", ", i8, ") and offset (");
                    androidx.camera.core.processing.util.a.w(i9, i10, ", ", ") that doesn't allow the close region to appear within the max allowed size (", sbW2);
                    sbW2.append(eVar.e.f17239d.width());
                    sbW2.append(", ");
                    sbW2.append(eVar.e.f17239d.height());
                    sbW2.append(")");
                    throw new sg.bigo.ads.core.mraid.d(sbW2.toString());
                }
                if (!rect2.contains(rect4)) {
                    StringBuilder sbW3 = a1.a.w(i2, "resizeProperties specified a size (", ", ", iA2, ") and offset (");
                    sbW3.append(i9);
                    sbW3.append(", ");
                    sbW3.append(i10);
                    sbW3.append(") that don't allow the close region to appear within the resized ad.");
                    throw new sg.bigo.ads.core.mraid.d(sbW3.toString());
                }
                eVar.f17174d.setCloseVisible(false);
                eVar.f17174d.setClosePosition(enumC0320a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect2.width(), rect2.height());
                int i13 = rect2.left;
                Rect rect5 = eVar.e.f17238c;
                layoutParams.leftMargin = i13 - rect5.left;
                layoutParams.topMargin = rect2.top - rect5.top;
                o oVar3 = eVar.f17175f;
                if (oVar3 == o.DEFAULT) {
                    eVar.f17173c.removeView(eVar.h);
                    eVar.f17173c.setVisibility(4);
                    eVar.f17174d.addView(eVar.h, new FrameLayout.LayoutParams(-1, -1));
                    eVar.j().addView(eVar.f17174d, layoutParams);
                } else if (oVar3 == o.RESIZED) {
                    eVar.f17174d.setLayoutParams(layoutParams);
                }
                eVar.f17174d.setClosePosition(enumC0320a);
                eVar.a(o.RESIZED);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b(boolean z2) {
                e.this.b(z2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(@NonNull String str) {
                e.this.a(str);
            }

            @Override // sg.bigo.ads.core.mraid.c.a
            public final void a(String str, String str2) {
                b bVar = e.this.g;
                if (bVar == null || !(bVar instanceof a)) {
                    return;
                }
                ((a) bVar).a(str, str2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str, sg.bigo.ads.common.i iVar) {
                e.this.a(str, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(@Nullable String str, boolean z2) throws sg.bigo.ads.core.mraid.d {
                e.this.a(str, z2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(sg.bigo.ads.core.mraid.b bVar) {
                if (e.this.j.c()) {
                    return;
                }
                e.this.f17176i.a(bVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z2) {
                if (e.this.j.c()) {
                    return;
                }
                e.this.f17176i.a(z2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z2, i iVar) throws sg.bigo.ads.core.mraid.d {
                e.this.a(z2, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean a(@NonNull JsResult jsResult) {
                return e.this.a(jsResult);
            }
        };
        this.A = aVar;
        c.b bVar = new c.b() { // from class: sg.bigo.ads.core.mraid.e.4
            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a() {
                final e eVar = e.this;
                eVar.a(new Runnable() { // from class: sg.bigo.ads.core.mraid.e.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        e eVar2 = e.this;
                        eVar2.j.a(h.b(eVar2.f17171a), h.a(e.this.f17171a), h.d(e.this.f17171a), h.c(e.this.f17171a), e.this.c());
                        e eVar3 = e.this;
                        eVar3.j.a(eVar3.f17175f);
                        e eVar4 = e.this;
                        eVar4.j.a(eVar4.f17172b);
                        sg.bigo.ads.core.mraid.c cVar3 = e.this.j;
                        cVar3.a(cVar3.b());
                        e.this.j.c("mraidbridge.notifyReadyEvent();");
                    }
                });
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b() {
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void c() {
                e.this.h();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean d() {
                return e.this.a();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void e() {
                e.this.f();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void f() {
                e.this.g();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(int i2, int i8, int i9, int i10, @NonNull a.EnumC0320a enumC0320a, boolean z2) throws sg.bigo.ads.core.mraid.d {
                throw new sg.bigo.ads.core.mraid.d("Not allowed to resize from an expanded state");
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b(boolean z2) {
                e.this.b(z2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(@NonNull String str) {
                e.this.a(str);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str, @Nullable sg.bigo.ads.common.i iVar) {
                e.this.a(str, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(@Nullable String str, boolean z2) {
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(sg.bigo.ads.core.mraid.b bVar2) {
                e.this.f17176i.a(bVar2);
                e.this.j.a(bVar2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z2) {
                e.this.f17176i.a(z2);
                e.this.j.a(z2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z2, i iVar) throws sg.bigo.ads.core.mraid.d {
                e.this.a(z2, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean a(@NonNull JsResult jsResult) {
                return e.this.a(jsResult);
            }
        };
        this.B = bVar;
        this.C = -1;
        this.f17187z = new Handler(Looper.getMainLooper());
        this.f17171a = context;
        this.l = context instanceof Activity ? new WeakReference<>((Activity) context) : new WeakReference<>(null);
        this.f17172b = nVar;
        this.f17176i = cVar;
        this.j = cVar2;
        this.f17177n = c0322e;
        this.k = new c(this, b8);
        this.f17175f = oVar;
        this.e = new j(context, context.getResources().getDisplayMetrics().density);
        this.f17173c = new FrameLayout(context);
        sg.bigo.ads.core.mraid.a.a aVar2 = new sg.bigo.ads.core.mraid.a.a(context);
        this.f17174d = aVar2;
        aVar2.setOnCloseListener(new a.b() { // from class: sg.bigo.ads.core.mraid.e.1
            @Override // sg.bigo.ads.core.mraid.a.a.b
            public final void a() {
                e.this.g();
            }
        });
        View view = new View(context);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.core.mraid.e.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        aVar2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        sg.bigo.ads.common.d.a.a().a(context, this);
        cVar.f17154a = aVar;
        cVar2.f17154a = bVar;
        this.f17184v = new h();
        this.f17180r = 4871;
    }

    @VisibleForTesting
    private void a(int i2) throws sg.bigo.ads.core.mraid.d {
        Activity activity = this.l.get();
        if (activity == null || !a(this.f17183u)) {
            throw new sg.bigo.ads.core.mraid.d("Attempted to lock orientation to unsupported value: " + this.f17183u.name());
        }
        if (this.f17179q == null) {
            this.f17179q = Integer.valueOf(activity.getRequestedOrientation());
        }
        b bVar = this.g;
        if (bVar == null || !bVar.a(activity, i2)) {
            activity.setRequestedOrientation(i2);
        }
    }

    @VisibleForTesting
    public final void b(boolean z2) {
        if (z2 == p()) {
            return;
        }
        this.f17174d.setCloseVisible(!z2);
    }

    @Override // sg.bigo.ads.common.d.b
    public final void a(Context context, Intent intent) {
        int rotation;
        if (!"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (rotation = ((WindowManager) this.f17171a.getSystemService("window")).getDefaultDisplay().getRotation()) == this.C) {
            return;
        }
        this.C = rotation;
        a((Runnable) null);
    }

    private static void a(@NonNull WebView webView, boolean z2) {
        if (z2) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    public final void a(@Nullable final Runnable runnable) {
        this.f17177n.a();
        final c.C0321c c0321cB = b();
        if (c0321cB == null) {
            return;
        }
        C0322e c0322e = this.f17177n;
        C0322e.a aVar = new C0322e.a(c0322e.f17200a, new View[]{this.f17173c, c0321cB}, (byte) 0);
        c0322e.f17201b = aVar;
        aVar.f17204c = new Runnable() { // from class: sg.bigo.ads.core.mraid.e.6
            @Override // java.lang.Runnable
            public final void run() {
                DisplayMetrics displayMetrics = e.this.f17171a.getResources().getDisplayMetrics();
                j jVar = e.this.e;
                jVar.f17236a.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                jVar.a(jVar.f17236a, jVar.f17237b);
                int[] iArr = new int[2];
                ViewGroup viewGroupI = e.this.i();
                viewGroupI.getLocationOnScreen(iArr);
                j jVar2 = e.this.e;
                int i2 = iArr[0];
                int i8 = iArr[1];
                jVar2.f17238c.set(i2, i8, viewGroupI.getWidth() + i2, viewGroupI.getHeight() + i8);
                jVar2.a(jVar2.f17238c, jVar2.f17239d);
                e.this.f17173c.getLocationOnScreen(iArr);
                e eVar = e.this;
                j jVar3 = eVar.e;
                int i9 = iArr[0];
                int i10 = iArr[1];
                jVar3.g.set(i9, i10, eVar.f17173c.getWidth() + i9, e.this.f17173c.getHeight() + i10);
                jVar3.a(jVar3.g, jVar3.h);
                c0321cB.getLocationOnScreen(iArr);
                j jVar4 = e.this.e;
                int i11 = iArr[0];
                int i12 = iArr[1];
                jVar4.e.set(i11, i12, c0321cB.getWidth() + i11, c0321cB.getHeight() + i12);
                jVar4.a(jVar4.e, jVar4.f17240f);
                e eVar2 = e.this;
                eVar2.f17176i.a(eVar2.e);
                if (e.this.j.c()) {
                    e eVar3 = e.this;
                    eVar3.j.a(eVar3.e);
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
        aVar.f17205d = aVar.f17202a.length;
        aVar.f17203b.post(aVar.e);
    }

    @VisibleForTesting
    public final void a(@NonNull String str) {
        MraidVideoActivity.a(this.f17171a, str);
    }

    @VisibleForTesting
    public final void a(@NonNull String str, @Nullable sg.bigo.ads.common.i iVar) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!"tel".equalsIgnoreCase(scheme) && !"voicemail".equalsIgnoreCase(scheme) && !"sms".equalsIgnoreCase(scheme) && !"mailto".equalsIgnoreCase(scheme) && !"geo".equalsIgnoreCase(scheme) && !"google.streetview".equalsIgnoreCase(scheme)) {
            b bVar = this.g;
            if (bVar != null) {
                bVar.a(str, iVar);
                return;
            }
            return;
        }
        sg.bigo.ads.common.t.a.a(2, "MraidController", "Uri scheme " + uri.getScheme() + " is not allowed.");
    }

    public final void a(@NonNull String str, @Nullable d dVar) {
        a(dVar);
        this.f17176i.a(str);
    }

    public final void a(@Nullable String str, boolean z2) throws sg.bigo.ads.core.mraid.d {
        sg.bigo.ads.core.mraid.a.a aVar;
        c.C0321c c0321c;
        if (this.h == null) {
            throw new sg.bigo.ads.core.mraid.d("Unable to expand after the WebView is destroyed");
        }
        if (this.f17172b == n.INTERSTITIAL) {
            return;
        }
        o oVar = this.f17175f;
        o oVar2 = o.DEFAULT;
        if (oVar == oVar2 || oVar == o.RESIZED) {
            n();
            boolean z7 = str != null;
            if (z7) {
                c.C0321c c0321cA = sg.bigo.ads.core.mraid.c.a(this.f17171a);
                this.p = c0321cA;
                if (c0321cA == null) {
                    return;
                }
                this.j.a(c0321cA);
                this.j.b(str);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            o oVar3 = this.f17175f;
            if (oVar3 == oVar2) {
                this.f17181s = j().getSystemUiVisibility();
                j().setSystemUiVisibility(this.f17180r);
                if (z7) {
                    aVar = this.f17174d;
                    c0321c = this.p;
                } else {
                    this.k.a();
                    this.f17173c.removeView(this.h);
                    this.f17173c.setVisibility(4);
                    aVar = this.f17174d;
                    c0321c = this.h;
                }
                aVar.addView(c0321c, layoutParams);
                j().addView(this.f17174d, new FrameLayout.LayoutParams(-1, -1));
            } else if (oVar3 == o.RESIZED && z7) {
                this.f17174d.removeView(this.h);
                this.f17173c.addView(this.h, layoutParams);
                this.f17173c.setVisibility(4);
                this.f17174d.addView(this.p, layoutParams);
            }
            this.f17174d.setLayoutParams(layoutParams);
            b(z2);
            a(o.EXPANDED);
        }
    }

    public final void a(@Nullable d dVar) {
        c.C0321c c0321cA = sg.bigo.ads.core.mraid.c.a(this.f17171a);
        this.h = c0321cA;
        if (c0321cA == null) {
            return;
        }
        if (dVar != null) {
            dVar.a();
        }
        this.f17176i.a(this.h);
        this.f17173c.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void a(@NonNull o oVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "MraidController", "MRAID state set to ".concat(String.valueOf(oVar)));
        o oVar2 = this.f17175f;
        this.f17175f = oVar;
        this.f17176i.a(oVar);
        sg.bigo.ads.core.mraid.c cVar = this.j;
        if (cVar.f17156c) {
            cVar.a(oVar);
        }
        b bVar = this.g;
        if (bVar != null) {
            o oVar3 = o.EXPANDED;
            if (oVar == oVar3) {
                bVar.d();
            } else if ((oVar2 == oVar3 && oVar == o.DEFAULT) || oVar == o.HIDDEN) {
                bVar.f();
            } else {
                o oVar4 = o.RESIZED;
                if ((oVar2 == oVar4 && oVar == o.DEFAULT) || oVar == oVar4) {
                    bVar.e();
                }
            }
        }
        a((Runnable) null);
    }

    public final void a(boolean z2) {
        this.f17185w = true;
        q();
        c.C0321c c0321c = this.h;
        if (c0321c != null) {
            a(c0321c, z2);
        }
        c.C0321c c0321c2 = this.p;
        if (c0321c2 != null) {
            a(c0321c2, z2);
        }
    }

    @VisibleForTesting
    public final void a(boolean z2, i iVar) throws sg.bigo.ads.core.mraid.d {
        if (!a(iVar)) {
            throw new sg.bigo.ads.core.mraid.d("Unable to force orientation to ".concat(String.valueOf(iVar)));
        }
        this.f17182t = z2;
        this.f17183u = iVar;
        if (this.f17175f == o.EXPANDED || (this.f17172b == n.INTERSTITIAL && !this.f17185w)) {
            n();
        }
    }

    @VisibleForTesting
    public final boolean a() {
        l lVar = this.f17178o;
        if (lVar != null) {
            return lVar.b();
        }
        return true;
    }

    private static boolean a(int i2, int i8) {
        return (i2 & i8) != 0;
    }

    @VisibleForTesting
    public final boolean a(@NonNull JsResult jsResult) {
        l lVar = this.f17178o;
        if (lVar != null) {
            return lVar.a();
        }
        jsResult.confirm();
        return true;
    }

    @VisibleForTesting
    private boolean a(i iVar) {
        ActivityInfo activityInfo;
        if (iVar == i.NONE) {
            return true;
        }
        Activity activity = this.l.get();
        if (activity == null) {
            return false;
        }
        try {
            activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return a(activityInfo.configChanges, 128) && a(activityInfo.configChanges, 1024);
    }
}

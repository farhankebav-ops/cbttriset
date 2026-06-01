package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.WeakHashMap;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends sg.bigo.ads.ad.interstitial.u {
    public static long k = sg.bigo.ads.ad.interstitial.v.f15174c;
    public static long l = sg.bigo.ads.ad.interstitial.v.f15175d;
    public static int m = sg.bigo.ads.ad.interstitial.v.e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected final WeakHashMap<Object, ValueCallback<Bitmap>> f14448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected final sg.bigo.ads.ad.interstitial.d f14449o;
    protected sg.bigo.ads.ad.interstitial.r p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    protected ViewGroup f14450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected ViewGroup f14451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.ad.interstitial.x f14452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.api.a.m f14453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.ad.interstitial.f f14454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    protected TextView f14455v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f14456w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ValueCallback<Double> f14457x;
    private long y;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.a$a, reason: collision with other inner class name */
    public static class C0259a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14480b;

        private C0259a(int i2, boolean z2) {
            this.f14479a = i2;
            this.f14480b = z2;
        }

        public /* synthetic */ C0259a(int i2, boolean z2, byte b8) {
            this(i2, z2);
        }
    }

    public a(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.f14448n = new WeakHashMap<>();
        this.f14457x = new ValueCallback<Double>() { // from class: sg.bigo.ads.ad.interstitial.d.a.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Double d8) {
                Double d9 = d8;
                if (d9 != null) {
                    a.this.a(d9.doubleValue());
                }
            }
        };
        this.y = 0L;
        this.f14449o = new sg.bigo.ads.ad.interstitial.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(sg.bigo.ads.ad.interstitial.u uVar, @Nullable sg.bigo.ads.api.a.m mVar) {
        return uVar instanceof sg.bigo.ads.ad.interstitial.f.c ? ((sg.bigo.ads.ad.interstitial.f.c) uVar).H() : a(mVar, "video_play_page.webview_layout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(sg.bigo.ads.ad.interstitial.u uVar, @Nullable sg.bigo.ads.api.a.m mVar) {
        return uVar instanceof sg.bigo.ads.ad.interstitial.f.c ? ((sg.bigo.ads.ad.interstitial.f.c) uVar).I() : b(mVar, "video_play_page.webview_force_time");
    }

    public abstract void a(double d8);

    @Override // sg.bigo.ads.ad.interstitial.u
    @NonNull
    public final sg.bigo.ads.ad.interstitial.d e() {
        return this.f14449o;
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public void f() {
        super.f();
        this.f14456w = true;
    }

    public final Context j() {
        ViewGroup viewGroup = this.f14450q;
        return viewGroup != null ? viewGroup.getContext() : ((sg.bigo.ads.ad.interstitial.u) this).f15138c.f14024b.e;
    }

    @Nullable
    public abstract ViewGroup k();

    @Nullable
    public abstract MediaView l();

    @Nullable
    public abstract Button m();

    public boolean n() {
        return false;
    }

    public void o() {
        int iX = x();
        if (iX == 2) {
            a(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        if (iX == 3) {
            a(ViewCompat.MEASURED_STATE_MASK);
            r();
        } else if (iX != 4) {
            a(-1);
        } else {
            a(ViewCompat.MEASURED_STATE_MASK);
            s();
        }
    }

    @CallSuper
    public void p() {
        if (this.f14448n.isEmpty()) {
            return;
        }
        a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.3
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    synchronized (a.this.f14448n) {
                        try {
                            Iterator<ValueCallback<Bitmap>> it = a.this.f14448n.values().iterator();
                            while (it.hasNext()) {
                                it.next().onReceiveValue(bitmap2);
                            }
                            a.this.f14448n.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        });
    }

    public void q() {
        String strI = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) this).f15138c.f()).i();
        TextView textView = (TextView) this.f14450q.findViewById(R.id.inter_advertiser);
        TextView textView2 = (TextView) this.f14450q.findViewById(R.id.inter_ad_label);
        if (textView != null) {
            if (TextUtils.isEmpty(strI)) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(strI);
            textView.setPadding(sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1));
            textView2.setText(R.string.bigo_ad_tag);
        }
    }

    public void r() {
        Integer numA = sg.bigo.ads.ad.interstitial.s.a((NativeAd) ((sg.bigo.ads.ad.interstitial.u) this).f15138c);
        if (numA != null) {
            a(numA.intValue());
        } else {
            a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.4
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null) {
                        synchronized (a.this.f14448n) {
                            a aVar = a.this;
                            aVar.f14448n.put(aVar.f14450q, this);
                        }
                    } else {
                        final long j = a.a(a.this) ? a.l : 0L;
                        final Integer numA2 = sg.bigo.ads.common.w.b.a(bitmap2);
                        if (numA2 != null) {
                            a.this.f14450q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.a.4.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a aVar2 = a.this;
                                    sg.bigo.ads.common.w.b.a(aVar2.f14450q, aVar2.f14449o.a(numA2.intValue()), new b.a() { // from class: sg.bigo.ads.ad.interstitial.d.a.4.1.1
                                        @Override // sg.bigo.ads.common.w.b.a
                                        public final long a() {
                                            return j;
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @RequiresApi(api = 17)
    public void s() {
        a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.5
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null) {
                    synchronized (a.this.f14448n) {
                        a aVar = a.this;
                        aVar.f14448n.put(aVar.f14450q, this);
                    }
                } else {
                    final long j = a.a(a.this) ? a.l : 0L;
                    final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(a.this.f14450q.getContext(), bitmap2);
                    final Integer numA = sg.bigo.ads.common.w.b.a(bitmapB);
                    a.this.f14450q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.a.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(a.this.f14450q.getResources(), bitmapB);
                            bitmapDrawable.setAlpha(0);
                            sg.bigo.ads.ad.interstitial.multi_img.a.a(a.this.f14450q, "adview_background_main_tag", bitmapDrawable);
                            sg.bigo.ads.ad.interstitial.c.a(0, a.m, j, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.d.a.5.1.1
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(Integer num) {
                                    Integer num2 = num;
                                    if (num2 != null) {
                                        bitmapDrawable.setAlpha(num2.intValue());
                                    }
                                }
                            }, new ValueCallback<Void>() { // from class: sg.bigo.ads.ad.interstitial.d.a.5.1.2
                                @Override // android.webkit.ValueCallback
                                public final /* bridge */ /* synthetic */ void onReceiveValue(Void r1) {
                                }
                            });
                            Integer num = numA;
                            if (num != null) {
                                a.this.f14449o.a(num.intValue());
                            }
                        }
                    });
                }
            }
        });
    }

    @NonNull
    public final C0259a u() {
        sg.bigo.ads.api.a.m mVar = this.f14453t;
        boolean z2 = false;
        byte b8 = 0;
        byte b9 = 0;
        if (mVar == null) {
            return new C0259a(-16736769, z2, b9 == true ? 1 : 0);
        }
        boolean[] zArr = new boolean[1];
        return new C0259a(sg.bigo.ads.ad.interstitial.s.a(((sg.bigo.ads.ad.interstitial.u) this).f15138c, mVar.a("video_play_page.cta_color"), zArr), true ^ zArr[0], b8 == true ? 1 : 0);
    }

    public final boolean v() {
        sg.bigo.ads.api.a.m mVar = this.f14453t;
        if (mVar != null) {
            return mVar.c("video_play_page.is_cta_show_animation");
        }
        return false;
    }

    public final int w() {
        sg.bigo.ads.api.a.m mVar = this.f14453t;
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar != null ? mVar.a("video_play_page.mediaview_colour") : 3);
    }

    public int x() {
        sg.bigo.ads.api.a.m mVar = this.f14453t;
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar != null ? mVar.a("video_play_page.background_colour") : 1);
    }

    public int y() {
        sg.bigo.ads.api.a.m mVar = this.f14453t;
        if (mVar != null) {
            return mVar.a("video_play_page.ad_component_show_time");
        }
        return -1;
    }

    public static int a(@Nullable sg.bigo.ads.api.a.m mVar, @Nullable String str) {
        int iA = (mVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) str)) ? 0 : mVar.a(str);
        if (iA == 1 || iA == 2 || iA == 3 || iA == 4 || iA == 7 || iA == 8) {
            return iA;
        }
        return 0;
    }

    @IntRange(from = -1, to = 8)
    public static int b(@Nullable sg.bigo.ads.api.a.m mVar, @Nullable String str) {
        int iA = (mVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) str)) ? 0 : mVar.a(str, -1);
        switch (iA) {
            case -1:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return iA;
            case 0:
            default:
                return 0;
        }
    }

    public static sg.bigo.ads.ad.interstitial.c.w b(@NonNull sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar, int i2) {
        return i2 != 3 ? i2 != 5 ? i2 != 6 ? new sg.bigo.ads.ad.interstitial.c.w(cVar, mVar) : new sg.bigo.ads.ad.interstitial.c.z(cVar, mVar) : new sg.bigo.ads.ad.interstitial.c.y(cVar, mVar) : new sg.bigo.ads.ad.interstitial.c.x(cVar, mVar);
    }

    public static w a(@NonNull sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar, int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? new x(cVar, mVar) : new ac(cVar, mVar) : new ab(cVar, mVar) : new aa(cVar, mVar) : new z(cVar, mVar) : new y(cVar, mVar);
    }

    @NonNull
    public static sg.bigo.ads.ad.interstitial.u a(@NonNull sg.bigo.ads.ad.b.c cVar) {
        return new sg.bigo.ads.ad.interstitial.u(cVar);
    }

    @NonNull
    public static sg.bigo.ads.ad.interstitial.u a(@NonNull sg.bigo.ads.ad.b.c cVar, int i2) {
        switch (i2) {
            case 13:
                return new n(cVar);
            case 14:
                return new o(cVar);
            case 15:
                return new p(cVar);
            case 16:
                return new q(cVar);
            case 17:
                return new r(cVar);
            case 18:
                return new s(cVar);
            case 19:
                return new b(cVar);
            case 20:
                return new c(cVar);
            case 21:
                return new d(cVar);
            case 22:
                return new e(cVar);
            case 23:
                return new f(cVar);
            case 24:
                return new g(cVar);
            case 25:
                return new h(cVar);
            case 26:
                return new i(cVar);
            case 27:
                return new j(cVar);
            case 28:
                return new k(cVar);
            case 29:
                return new l(cVar);
            case 30:
            default:
                return new sg.bigo.ads.ad.interstitial.u(cVar);
            case 31:
            case 32:
                sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.s.a(cVar);
                return ((31 == i2 || 32 == i2) && pVarA.a()) ? pVarA.getWidth() / pVarA.getHeight() > 0 ? new u(cVar) : 31 == i2 ? new t(cVar) : new v(cVar) : new sg.bigo.ads.ad.interstitial.u(cVar);
        }
    }

    public void a(int i2) {
        ViewGroup viewGroup = this.f14450q;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(this.f14449o.a(i2));
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final void a(@NonNull ViewGroup viewGroup) {
    }

    public final void a(final TextView textView, final b.a aVar) {
        if (textView == null) {
            return;
        }
        Integer numA = sg.bigo.ads.ad.interstitial.s.a((NativeAd) ((sg.bigo.ads.ad.interstitial.u) this).f15138c);
        if (numA == null) {
            a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.6
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        final int iA = sg.bigo.ads.common.w.b.a(bitmap2, -16736769);
                        textView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.a.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                sg.bigo.ads.ad.interstitial.d.a(textView, iA, aVar);
                            }
                        });
                    } else {
                        synchronized (a.this.f14448n) {
                            a.this.f14448n.put(textView, this);
                        }
                    }
                }
            });
        } else {
            sg.bigo.ads.ad.interstitial.d.a(textView, numA.intValue(), aVar);
        }
    }

    public static /* synthetic */ boolean a(a aVar) {
        return (aVar.y != 0 ? SystemClock.elapsedRealtime() - aVar.y : 0L) > k;
    }

    public final boolean a(sg.bigo.ads.ad.interstitial.r rVar, @NonNull ViewGroup viewGroup, @NonNull sg.bigo.ads.ad.interstitial.x xVar, @NonNull sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.f fVar) {
        ViewGroup viewGroup2;
        if (rVar == null) {
            return false;
        }
        this.p = rVar;
        this.f14450q = viewGroup;
        if (viewGroup != null) {
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.inter_media_container);
            this.f14451r = viewGroup3;
            viewGroup2 = viewGroup3 == null ? this.f14450q : null;
            this.f14452s = xVar;
            this.f14453t = mVar;
            this.f14454u = fVar;
            this.f14455v = (TextView) this.f14450q.findViewById(R.id.inter_warning);
            sg.bigo.ads.common.utils.u.a(this.f14450q, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.a.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    a.this.y = SystemClock.elapsedRealtime();
                }
            });
            o();
            t();
            q();
            this.f14449o.a(this.f14457x);
            return true;
        }
        this.f14451r = viewGroup2;
        this.f14452s = xVar;
        this.f14453t = mVar;
        this.f14454u = fVar;
        this.f14455v = (TextView) this.f14450q.findViewById(R.id.inter_warning);
        sg.bigo.ads.common.utils.u.a(this.f14450q, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                a.this.y = SystemClock.elapsedRealtime();
            }
        });
        o();
        t();
        q();
        this.f14449o.a(this.f14457x);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(sg.bigo.ads.ad.interstitial.u uVar) {
        if (uVar instanceof sg.bigo.ads.ad.interstitial.f.c) {
            return ((sg.bigo.ads.ad.interstitial.f.c) uVar).J();
        }
        return false;
    }

    @CallSuper
    public void t() {
    }
}

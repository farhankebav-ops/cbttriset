package sg.bigo.ads.ad.interstitial.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.p.e;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements sg.bigo.ads.ad.interstitial.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.api.core.c f14243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    final c.b f14244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f14245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WebView f14246d;
    View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.a f14247f;
    long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f14248i;
    a.C0316a k;
    private final boolean l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final sg.bigo.ads.core.player.c f14249n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final p f14250o;

    @NonNull
    private final Ad p;
    boolean g = false;
    boolean j = false;

    @NonNull
    private final List<a.C0316a> m = new ArrayList();

    public class a extends FrameLayout {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f14260b;

        public a(Context context) {
            super(context);
            this.f14260b = new i();
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.f14260b.f15793b = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getActionMasked() == 0) {
                this.f14260b.f15792a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a.C0316a f14261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ViewConfiguration f14262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f14263c;
        float e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f14265f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f14264d = false;
        i g = new i();

        public b(Context context, a.C0316a c0316a) {
            this.f14261a = c0316a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f14262b = viewConfiguration;
            this.f14263c = viewConfiguration.getScaledTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                this.f14264d = true;
                this.e = motionEvent.getX();
                this.f14265f = motionEvent.getY();
                this.g.f15792a = new Point((int) this.e, (int) this.f14265f);
            } else if (motionEvent.getActionMasked() == 1) {
                if (this.f14264d) {
                    this.f14264d = false;
                    float x2 = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.g.f15793b = new Point((int) x2, (int) y);
                    if (Math.abs(this.e - x2) < this.f14263c && Math.abs(this.f14265f - y) < this.f14263c) {
                        c cVar = c.this;
                        cVar.a(cVar.g().f14024b.e, this.g);
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.f14264d = false;
            }
            return true;
        }
    }

    public c(@NonNull Ad ad, @NonNull sg.bigo.ads.api.core.c cVar, @Nullable sg.bigo.ads.core.player.c cVar2, @Nullable p pVar, @Nullable c.b bVar) {
        this.f14249n = cVar2;
        this.f14250o = pVar;
        this.p = ad;
        this.f14243a = cVar;
        this.f14244b = bVar;
        if (pVar != null) {
            Iterator<sg.bigo.ads.core.f.a.a> it = pVar.A.iterator();
            while (it.hasNext()) {
                List<a.C0316a> list = it.next().f16995b;
                if (list != null) {
                    for (a.C0316a c0316a : list) {
                        if (c0316a.a() && c0316a.b()) {
                            this.m.add(c0316a);
                        }
                    }
                    for (a.C0316a c0316a2 : list) {
                        if (c0316a2.a() && c0316a2.c()) {
                            this.m.add(c0316a2);
                        }
                    }
                }
            }
        }
        this.l = !this.m.isEmpty();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    @Nullable
    public final View a() {
        return this.f14245c;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        return (this.g || this.f14245c == null) ? false : true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        View view = this.f14245c;
        if (view instanceof WebView) {
            ((WebView) view).onResume();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        View view = this.f14245c;
        if (view instanceof WebView) {
            ((WebView) view).onPause();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "release");
        WebView webView = this.f14246d;
        if (webView != null) {
            webView.setOnTouchListener(null);
            this.f14246d.destroy();
            this.f14246d = null;
        }
        View view = this.f14245c;
        if (view != null) {
            u.b(view);
            this.f14245c = null;
        }
        this.g = true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        c.b bVar;
        if (this.j || this.f14248i || (bVar = this.f14244b) == null || this.h <= 0) {
            return;
        }
        bVar.a(this.f14243a, SystemClock.elapsedRealtime() - this.h);
    }

    public final sg.bigo.ads.ad.c<?, ?> g() {
        Ad ad = this.p;
        return ad instanceof t ? ((t) ad).f15129z : (sg.bigo.ads.ad.c) ad;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i2) {
        sg.bigo.ads.core.player.c cVar;
        if (i2 != 1 || (cVar = this.f14249n) == null) {
            return;
        }
        cVar.b();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i2, int i8) {
        ViewGroup.LayoutParams layoutParams;
        int i9;
        int i10;
        View view = this.e;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || (i9 = layoutParams.width) == -1 || (i10 = layoutParams.height) == 0 || i9 == 0) {
            return;
        }
        if (i2 > 0 && i8 > 0) {
            float f4 = i2;
            float f8 = i10;
            float f9 = i9;
            float f10 = (f8 * f4) / f9;
            float f11 = i8;
            if (f10 > f11) {
                f4 = (f9 * f11) / f8;
                f10 = f11;
            }
            i9 = (int) f4;
            i10 = (int) f10;
        }
        layoutParams.width = i9;
        layoutParams.height = i10;
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final List<a.C0316a> list, @Nullable final a.C0316a c0316a, final int i2) {
        d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.g) {
                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "static vast companion destroyed, stop preload.");
                    return;
                }
                if (!list.isEmpty()) {
                    c.this.k = (a.C0316a) list.remove(0);
                    String str = c.this.k.f16997b;
                    a0.i(0, str, "try to preload image: ", 3, "StaticVastCompanion");
                    if (URLUtil.isNetworkUrl(str)) {
                        e.a(context, str, c.this.f14243a.al(), new g() { // from class: sg.bigo.ads.ad.interstitial.a.a.c.1.1
                            @Override // sg.bigo.ads.common.p.g
                            public final void a(int i8, @NonNull String str2, String str3) {
                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", a1.a.m("image load failed: ", str2, ", try to preload next image."));
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c cVar = c.this;
                                cVar.a(context, list, cVar.k, i2 + 1);
                            }

                            @Override // sg.bigo.ads.common.p.g
                            public final void a(@NonNull Bitmap bitmap, @NonNull f fVar) {
                                Bitmap bitmap2;
                                String string;
                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "image load success.");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                final c cVar = c.this;
                                final Context context2 = context;
                                a.C0316a c0316a2 = cVar.k;
                                int i8 = i2;
                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "try to handle image.");
                                View view = null;
                                if (c0316a2.b()) {
                                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "handle jpg/png image.");
                                    AdImageView adImageView = new AdImageView(context2);
                                    bitmap2 = bitmap;
                                    adImageView.setImageBitmap(bitmap2);
                                    adImageView.setOnTouchListener(cVar.new b(context2, c0316a2));
                                    string = null;
                                    view = adImageView;
                                } else {
                                    bitmap2 = bitmap;
                                    if (c0316a2.c()) {
                                        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "handle gif image.");
                                        try {
                                            File file = new File(fVar.f15920d);
                                            if (file.exists()) {
                                                URI uri = file.toURI();
                                                WebView webView = new WebView(context2);
                                                webView.getSettings().setAllowFileAccess(true);
                                                webView.getSettings().setAllowFileAccessFromFileURLs(false);
                                                webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
                                                if (uri.toString().startsWith(AdPayload.FILE_SCHEME)) {
                                                    webView.getSettings().setJavaScriptEnabled(false);
                                                } else {
                                                    webView.getSettings().setJavaScriptEnabled(true);
                                                }
                                                webView.loadUrl(uri.toString());
                                                webView.getSettings().setLoadWithOverviewMode(true);
                                                webView.getSettings().setUseWideViewPort(true);
                                                webView.setOnTouchListener(cVar.new b(context2, c0316a2));
                                                cVar.f14246d = webView;
                                                string = null;
                                                view = webView;
                                            } else {
                                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "gif image file is not exists.");
                                                string = "git file not exists";
                                            }
                                        } catch (Exception e) {
                                            string = e.toString();
                                        }
                                    } else {
                                        string = null;
                                    }
                                }
                                if (view == null) {
                                    c.b bVar = cVar.f14244b;
                                    if (bVar != null) {
                                        cVar.j = true;
                                        bVar.a(cVar.f14243a, SystemClock.elapsedRealtime() - cVar.h, c0316a2.f16997b, i8, c0316a2.e, string);
                                        return;
                                    }
                                    return;
                                }
                                int width = bitmap2.getWidth();
                                int height = bitmap2.getHeight();
                                if (width <= 0 || height <= 0) {
                                    width = sg.bigo.ads.common.utils.e.a(context2, c0316a2.f16998c);
                                    height = sg.bigo.ads.common.utils.e.a(context2, c0316a2.f16999d);
                                }
                                float f4 = context2.getResources().getDisplayMetrics().widthPixels;
                                float fC = sg.bigo.ads.common.utils.e.c(context2);
                                if (f4 > 0.0f && fC > 0.0f) {
                                    float f8 = height;
                                    float f9 = width;
                                    float f10 = (f8 * f4) / f9;
                                    if (f10 > fC) {
                                        f4 = (f9 * fC) / f8;
                                    } else {
                                        fC = f10;
                                    }
                                    width = (int) f4;
                                    height = (int) fC;
                                }
                                FrameLayout.LayoutParams layoutParams = (width <= 0 || height <= 0) ? new FrameLayout.LayoutParams(-1, -1) : new FrameLayout.LayoutParams(width, height, 17);
                                final a aVar = cVar.new a(context2);
                                aVar.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.a.a.c.2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        c.this.a(context2, aVar.f14260b);
                                    }
                                });
                                cVar.e = view;
                                aVar.addView(view, layoutParams);
                                cVar.f14245c = aVar;
                                c.b bVar2 = cVar.f14244b;
                                if (bVar2 != null) {
                                    cVar.f14248i = true;
                                    bVar2.a(cVar.f14243a, SystemClock.elapsedRealtime() - cVar.h, c0316a2.f16997b, i8, c0316a2.e);
                                }
                            }
                        });
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", a1.a.m("image url is invalid: ", str, ", try to preload next image."));
                    c cVar = c.this;
                    cVar.a(context, list, cVar.k, i2 + 1);
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "image list empty, stop preload.");
                c cVar2 = c.this;
                c.b bVar = cVar2.f14244b;
                if (bVar != null) {
                    sg.bigo.ads.api.core.c cVar3 = cVar2.f14243a;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - c.this.h;
                    a.C0316a c0316a2 = c0316a;
                    bVar.a(cVar3, jElapsedRealtime, c0316a2 == null ? null : c0316a2.f16997b, i2 - 1, c0316a2 != null ? c0316a2.e : null, "load failed");
                }
            }
        });
    }

    public final void a(Context context, i iVar) {
        sg.bigo.ads.api.core.e eVarA;
        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "handle ad click.");
        if (this.f14243a.f().c() == 0 || !(this.p instanceof sg.bigo.ads.ad.c)) {
            eVarA = sg.bigo.ads.ad.interstitial.a.a.a.a(context, this.p, this.f14243a, null, this.f14250o, this.k);
            eVarA.g = 0;
        } else {
            sg.bigo.ads.controller.landing.d.a(this.f14245c.getContext(), g());
            eVarA = new sg.bigo.ads.api.core.e();
            eVarA.g = 1;
        }
        sg.bigo.ads.core.player.c cVar = this.f14249n;
        if (cVar != null && !cVar.c()) {
            this.f14249n.a();
        }
        c.a aVar = this.f14247f;
        if (aVar != null) {
            aVar.a(iVar, eVarA);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(Context context) {
        String str;
        if (!this.l) {
            str = "image resource is disable.";
        } else if (this.g) {
            str = "static vast companion destroyed, stop preload.";
        } else {
            if (!this.m.isEmpty()) {
                this.h = SystemClock.elapsedRealtime();
                c.b bVar = this.f14244b;
                if (bVar != null) {
                    bVar.a(this.f14243a);
                }
                a(context, this.m, null, 0);
                return true;
            }
            str = "image list empty, stop preload.";
        }
        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", str);
        return false;
    }
}

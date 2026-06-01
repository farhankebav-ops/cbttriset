package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.Objects;
import sg.bigo.ads.R;
import sg.bigo.ads.common.o;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.player.b.c;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends f implements c.a {
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private int E;
    private boolean F;
    private long G;
    private String H;
    private String I;
    private boolean J;
    private boolean K;
    private View L;
    private b M;
    private final TextureView.SurfaceTextureListener N;
    private final View.OnClickListener O;
    private Runnable P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f17341a;
    private int g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g f17342i;

    @Nullable
    private ImageView j;
    private ImageView k;
    private AdImageView l;
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ProgressBar f17343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f17344o;
    private c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f17345q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17346r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f17347s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f17348t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f17349u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f17350v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Runnable f17351w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Runnable f17352x;
    private boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17353z;

    public e(Context context, int i2, int i8, @NonNull sg.bigo.ads.api.c.b bVar, @Nullable sg.bigo.ads.core.a.a aVar) {
        sg.bigo.ads.core.a.a aVar2;
        super(context, bVar, aVar);
        this.p = new c();
        this.f17345q = 0;
        this.f17346r = 0;
        this.f17347s = true;
        this.y = false;
        this.f17353z = true;
        this.A = false;
        this.B = false;
        this.D = false;
        this.G = 0L;
        this.H = "";
        this.I = "";
        this.J = true;
        this.K = false;
        TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: sg.bigo.ads.core.player.b.e.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f17355b = SystemClock.elapsedRealtime();

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i9, int i10) {
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onSurfaceTextureAvailable");
                sg.bigo.ads.common.n.d.a(e.this.f17352x);
                e.this.a(13, SystemClock.elapsedRealtime() - this.f17355b, 0);
                e.this.G = SystemClock.elapsedRealtime();
                e.this.p.a(new Surface(surfaceTexture));
                sg.bigo.ads.core.a.a aVar3 = e.this.e;
                if (aVar3 != null && aVar3.aZ()) {
                    e.this.p.a(e.this.m);
                    e.d(e.this);
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "real video is not ready, begin to load backup image");
                sg.bigo.ads.core.a.a aVar4 = e.this.e;
                if (aVar4 == null || aVar4.bh() == null) {
                    e.g(e.this);
                    return;
                }
                Pair<Bitmap, String> pairBh = e.this.e.bh();
                if (pairBh != null) {
                    e.this.a(pairBh.first);
                    if (e.this.M != null) {
                        e.this.M.a((Bitmap) pairBh.first);
                    }
                }
                e.this.w();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                sg.bigo.ads.common.t.a.b("VideoPlayView", "onSurfaceTextureDestroyed");
                e.this.d(false);
                c cVar = e.this.p;
                try {
                    if (!c.h.get()) {
                        cVar.f17326a.reset();
                    }
                    sg.bigo.ads.common.n.d.a(cVar.g);
                } catch (IllegalStateException e) {
                    c.a aVar3 = cVar.f17328c;
                    if (aVar3 != null) {
                        aVar3.a(11, Log.getStackTraceString(e), cVar.f17331i);
                    }
                    sg.bigo.ads.common.t.a.a(0, "MediaPlayerWrapper", "reset IllegalStateException");
                }
                cVar.f17330f = false;
                cVar.e = false;
                if (!e.this.f17348t) {
                    e eVar = e.this;
                    eVar.f17364f = false;
                    if (eVar.f17345q > 0) {
                        e eVar2 = e.this;
                        eVar2.f17346r = eVar2.f17345q;
                    }
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i9, int i10) {
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onSurfaceTextureSizeChanged");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.N = surfaceTextureListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: sg.bigo.ads.core.player.b.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (view.getId()) {
                    case 200011:
                        e.this.o();
                        break;
                    case 200012:
                        if (!e.this.F || !e.this.B) {
                            e.this.v();
                        }
                        break;
                }
            }
        };
        this.O = onClickListener;
        this.f17341a = 0;
        this.P = new Runnable() { // from class: sg.bigo.ads.core.player.b.e.5
            @Override // java.lang.Runnable
            public final void run() {
                if (e.this.k != null) {
                    e.this.k.setVisibility(8);
                }
            }
        };
        this.I = aVar != null ? aVar.aT() : "";
        if (aVar != null && aVar.bm() != null) {
            this.H = aVar.bm().f16997b;
        }
        w();
        this.f17350v = bVar.f15476f;
        this.f17348t = bVar.e;
        this.g = i2;
        this.h = i8;
        int i9 = bVar.f15472a;
        this.f17349u = bVar.f15473b;
        g gVar = new g(this.f17362c, i2, i8, i9);
        this.f17342i = gVar;
        u.a(gVar, this, null, -1);
        this.f17342i.setSurfaceTextureListener(surfaceTextureListener);
        sg.bigo.ads.core.a.a aVar3 = this.e;
        if (aVar3 != null && aVar3.x() != 2 && y()) {
            sg.bigo.ads.common.n.d.a(this.f17352x);
            if (this.f17352x == null) {
                this.f17352x = new Runnable() { // from class: sg.bigo.ads.core.player.b.e.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.x();
                        sg.bigo.ads.core.a.a aVar4 = e.this.e;
                        sg.bigo.ads.core.d.b.a(aVar4, aVar4 != null ? aVar4.aK() : "", 13, "onSurfaceTextureAvailable not called", 0);
                        e.this.a("AdVideoTooLate", new int[]{10311});
                    }
                };
            }
            sg.bigo.ads.common.n.d.a(2, this.f17352x, this.f17350v);
        }
        if (!bVar.g && (aVar2 = this.e) != null && !TextUtils.isEmpty(aVar2.aN())) {
            a(o.b(getContext().getApplicationContext(), this.e.aN()));
        }
        this.f17347s = this.p.a(bVar.f15475d);
        if (!bVar.f15474c) {
            int iB = sg.bigo.ads.common.utils.a.b(this.f17362c, R.dimen.bigo_ad_volume_padding);
            ImageView imageView = new ImageView(this.f17362c);
            this.j = imageView;
            imageView.setId(200011);
            this.j.setOnClickListener(onClickListener);
            this.j.setPadding(iB, iB, iB, iB);
            this.j.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, this.f17347s ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
            int iB2 = (iB * 2) + sg.bigo.ads.common.utils.a.b(this.f17362c, R.dimen.bigo_ad_volume_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB2, iB2, 85);
            layoutParams.rightMargin = iB;
            layoutParams.bottomMargin = iB;
            this.j.setVisibility(0);
            u.a(this.j, this, layoutParams, -1);
        }
        sg.bigo.ads.core.a.a aVar4 = this.e;
        boolean z2 = aVar4 != null && aVar4.aO();
        this.F = z2;
        if (z2) {
            z();
        }
        int iB3 = sg.bigo.ads.common.utils.a.b(this.f17362c, R.dimen.bigo_ad_replay_size);
        sg.bigo.ads.core.a.a aVar5 = this.e;
        if (aVar5 != null && aVar5.x() == 2 && sg.bigo.ads.api.c.b.b() > 0) {
            iB3 = sg.bigo.ads.common.utils.e.a(this.f17362c, sg.bigo.ads.api.c.b.b());
        }
        ImageView imageView2 = new ImageView(this.f17362c);
        this.k = imageView2;
        imageView2.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, R.drawable.bigo_ad_ic_media_play));
        this.k.setVisibility(this.f17348t ? 0 : 8);
        u.a(this.k, this, new FrameLayout.LayoutParams(iB3, iB3, 17), -1);
        this.p.f17328c = this;
        setId(200012);
        setOnClickListener(onClickListener);
        b(0);
    }

    private void A() {
        if (this.f17343n == null) {
            z();
        }
        this.f17343n.setVisibility(8);
    }

    private void B() {
        if (this.f17344o == null) {
            this.f17344o = sg.bigo.ads.common.utils.a.a(getContext(), R.layout.bigo_ad_default_loading_layout, null, false);
        }
        View view = this.f17344o;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        sg.bigo.ads.core.a.a aVar;
        int i2;
        sg.bigo.ads.core.a.a aVar2 = this.e;
        if (aVar2 == null) {
            return;
        }
        Pair<Bitmap, String> pairBh = aVar2.bh();
        if (this.e.aZ()) {
            aVar = this.e;
            i2 = 0;
        } else if (pairBh == null) {
            aVar = this.e;
            i2 = 5;
        } else if (Objects.equals(pairBh.second, this.H)) {
            aVar = this.e;
            i2 = 1;
        } else {
            if (!Objects.equals(pairBh.second, this.I)) {
                return;
            }
            aVar = this.e;
            i2 = 2;
        }
        aVar.j(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.p.d();
        this.p.e();
    }

    private boolean y() {
        return this.f17350v > 0;
    }

    private void z() {
        Context context = getContext();
        ProgressBar progressBar = new ProgressBar(context);
        this.f17343n = progressBar;
        progressBar.setBackgroundColor(sg.bigo.ads.common.utils.a.c(context, android.R.color.transparent));
        s.a(context, this.f17343n, R.drawable.bigo_ad_progressbar_white);
        this.f17343n.setVisibility(8);
        u.a(this.f17343n, this, new FrameLayout.LayoutParams(-2, -2, 17), -1);
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "destroy player");
        d(false);
        x();
        setOnEventListener(null);
        this.f17343n = null;
        sg.bigo.ads.common.n.d.a(this.f17351w);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void e_() {
        a("AdVideoStart", (int[]) null);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void f() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onPlay");
        this.f17348t = false;
        int i2 = this.f17346r;
        if (i2 > 0) {
            this.p.a(i2);
            this.f17346r = -1;
        }
        a("AdVideoPlaying", (int[]) null);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void g() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", C2300e4.h.t0);
        a("AdVideoPaused", (int[]) null);
    }

    public final int getAdDuration() {
        return this.p.f();
    }

    public final int getAdRemainingTime() {
        return this.p.c();
    }

    public final ImageView getCoverView() {
        return this.l;
    }

    public final int getCurrentPos() {
        return this.f17345q;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final int getPlayStatus() {
        return this.p.f17329d;
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void h() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onStop");
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void j() {
        this.f17348t = true;
        AdImageView adImageView = this.l;
        if (adImageView != null) {
            adImageView.setVisibility(0);
        }
        this.k.setVisibility(this.f17349u ? 8 : 0);
        this.k.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, R.drawable.bigo_ad_ic_media_play));
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onCompletion play");
        d(false);
        a("AdVideoComplete", (int[]) null);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void k() {
        a("AdSizeChange", (int[]) null);
    }

    public final void l() {
        g gVar;
        if (this.e == null || (gVar = this.f17342i) == null || !gVar.isAvailable() || this.K || this.e.bh() == null || this.e.bb()) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.e.bh().first;
        this.K = true;
        B();
        a(bitmap);
        c cVar = this.p;
        a("AdBackupImgReady", new int[]{(cVar == null || TextUtils.isEmpty(cVar.f17327b)) ? 0 : 1});
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final boolean n() {
        return this.J;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onDetachedFromWindow called");
        d(false);
        this.f17343n = null;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onVisibilityChanged visibility != VISIBLE");
            d(false);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onVisibilityChanged visibility == VISIBLE");
            d(true);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        View view;
        FrameLayout.LayoutParams layoutParams;
        super.onWindowVisibilityChanged(i2);
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onWindowVisibilityChanged: ".concat(String.valueOf(i2)));
        View view2 = this.L;
        if (view2 != null) {
            if (i2 == 0) {
                u.b(view2);
                view = this.f17342i;
                layoutParams = null;
            } else {
                u.b(this.f17342i);
                view = this.L;
                layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
            }
            u.a(view, this, layoutParams, 0);
        }
    }

    public final void setIVideoPlayerViewListener(b bVar) {
        this.M = bVar;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void setMute(boolean z2) {
        if (this.f17347s == z2) {
            this.f17353z = false;
            return;
        }
        boolean zA = this.p.a(z2);
        this.f17347s = zA;
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, zA ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
        }
        if (!this.f17353z && !this.A) {
            a("AdVolumeChange", new int[]{this.f17347s ? 0 : 100});
        } else {
            this.f17353z = false;
            this.A = false;
        }
    }

    public final void setPlayInfo$505cff1c(String str) {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", a1.a.m("setPlayInfo path=", str, ",position=0"));
        this.m = str;
        this.f17345q = 0;
    }

    public final void setSeekPos(int i2) {
        this.f17346r = i2;
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final void setStatPrepareEventOnce(boolean z2) {
        this.J = z2;
    }

    public static /* synthetic */ void d(e eVar) {
        if (eVar.y()) {
            sg.bigo.ads.common.n.d.a(eVar.f17351w);
            if (eVar.f17351w == null) {
                eVar.f17351w = new Runnable() { // from class: sg.bigo.ads.core.player.b.e.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.x();
                        e.this.a("AdVideoTooLate", new int[]{10107});
                    }
                };
            }
            sg.bigo.ads.common.n.d.a(2, eVar.f17351w, eVar.f17350v);
        }
    }

    public static /* synthetic */ void g(e eVar) {
        if (eVar.f17344o == null) {
            eVar.f17344o = sg.bigo.ads.common.utils.a.a(eVar.getContext(), R.layout.bigo_ad_default_loading_layout, null, false);
        }
        View view = eVar.f17344o;
        if (view != null) {
            u.a(view, eVar, new FrameLayout.LayoutParams(-2, -2, 17), -1);
            eVar.f17344o.setVisibility(0);
        }
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final boolean c() {
        return this.f17347s;
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final boolean e() {
        return this.p.e;
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void i() {
        String str;
        int adRemainingTime = getAdRemainingTime();
        if (this.F && (str = this.m) != null && !str.startsWith("file:")) {
            if (this.C == adRemainingTime) {
                if (!this.D) {
                    if (this.f17343n == null) {
                        z();
                    }
                    this.f17343n.setVisibility(0);
                    sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onBuffering");
                    this.B = true;
                    a("AdVideoBuffering", (int[]) null);
                }
                this.D = true;
            } else {
                if (this.D) {
                    A();
                    sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "onBuffered");
                    this.B = false;
                    a("AdVideoBuffered", (int[]) null);
                }
                this.D = false;
            }
            this.C = adRemainingTime;
        }
        if (this.E <= 0) {
            int adDuration = getAdDuration();
            this.E = adDuration;
            if (adDuration <= 0) {
                return;
            }
        }
        int i2 = this.E;
        if (adRemainingTime > i2) {
            adRemainingTime = i2;
        }
        this.f17345q = adRemainingTime;
        a("AdRemainingTimeChange", new int[]{adRemainingTime, i2, (int) ((adRemainingTime * 100.0f) / i2)});
    }

    public final void m() {
        g gVar;
        if (this.e == null || (gVar = this.f17342i) == null || this.K || !gVar.isAvailable() || this.e.bb()) {
            return;
        }
        this.K = true;
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "real video is download success, update media player datasource:  " + this.e.c(getContext()));
        this.p.a(this.e.c(getContext().getApplicationContext()));
    }

    @Override // sg.bigo.ads.api.c.a
    public final void a() {
        c cVar = this.p;
        if (cVar.e && cVar.b()) {
            this.y = false;
            if (this.F) {
                A();
            }
            this.D = false;
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "pauseAd called");
        }
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void b() {
        if (this.f17364f || this.f17348t) {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "tryStartAd, video is completed play, unregister it from list");
            d(false);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayView", "try start play video ad");
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, long j, int i8) {
        sg.bigo.ads.core.a.a aVar = this.e;
        sg.bigo.ads.core.d.b.a(aVar, aVar != null ? aVar.aK() : "", i2, j, i8);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void a(int i2, String str, int i8) {
        sg.bigo.ads.core.a.a aVar = this.e;
        sg.bigo.ads.core.d.b.a(aVar, aVar != null ? aVar.aK() : "", i2, str, i8);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final void a(MediaPlayer mediaPlayer, int i2) {
        sg.bigo.ads.common.n.d.a(this.f17351w);
        A();
        B();
        boolean z2 = this.g == 0 && this.h == 0;
        this.g = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.h = videoHeight;
        if (this.K || (z2 && this.g > 0 && videoHeight > 0)) {
            g gVar = this.f17342i;
            gVar.f17368a = this.g;
            gVar.f17369b = videoHeight;
            gVar.requestLayout();
        }
        new HashMap();
        if (this.G > 0) {
            a(10, SystemClock.elapsedRealtime() - this.G, i2);
            this.G = 0L;
        }
        if (this.J) {
            b(18);
        }
        if (this.y || y()) {
            this.y = false;
            b();
        } else {
            if (this.f17364f || this.f17348t) {
                return;
            }
            d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void a(T t3) {
        if (t3 == 0) {
            return;
        }
        if (this.l == null) {
            AdImageView adImageView = new AdImageView(this.f17362c);
            this.l = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        u.a(this.l, this, new FrameLayout.LayoutParams(-1, -1, 17), -1);
        boolean z2 = false;
        if (t3 instanceof String) {
            String str = (String) t3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.l.setVisibility(0);
            AdImageView adImageView2 = this.l;
            sg.bigo.ads.core.a.a aVar = this.e;
            if (aVar != null && aVar.al()) {
                z2 = true;
            }
            adImageView2.a(str, z2);
            return;
        }
        if (t3 instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) t3;
            this.l.setVisibility(0);
            this.l.setImageBitmap(bitmap);
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            this.f17342i.f17368a = bitmap.getWidth();
            this.f17342i.f17369b = bitmap.getHeight();
            this.f17342i.requestLayout();
        }
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final void a(boolean z2) {
        super.a(z2);
        this.f17364f = false;
        if (!this.p.e) {
            sg.bigo.ads.common.t.a.b("VideoPlayView", "incorrect status, the player is not prepared".concat(z2 ? " wating to play" : ", start ad failed"));
            this.y = z2;
            int i2 = this.f17341a;
            if (i2 < 8) {
                int i8 = i2 + 1;
                this.f17341a = i8;
                if (i8 == 8) {
                    sg.bigo.ads.core.d.b.a(this.e, Sdk.SDKMetric.SDKMetricType.BANNER_AUTO_REDIRECT_NOT_OVERRIDE_URL_VALUE, 10107, "Not prepared, src path = " + this.m);
                    return;
                }
                return;
            }
            return;
        }
        if (!sg.bigo.ads.common.aa.b.a(getContext().getApplicationContext())) {
            sg.bigo.ads.common.t.a.b("VideoPlayView", "screen is off, start ad cancel");
            return;
        }
        if (this.p.a()) {
            this.E = getAdDuration();
            sg.bigo.ads.core.a.a aVar = this.e;
            if (aVar != null) {
                aVar.j(0);
            }
        }
        AdImageView adImageView = this.l;
        if (adImageView != null) {
            adImageView.setVisibility(8);
        }
        this.k.setVisibility(8);
        d(true);
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final boolean a(int i2) {
        sg.bigo.ads.common.t.a.a("VideoPlayView", "onInfo called, whatInfo = ".concat(String.valueOf(i2)));
        if (i2 == 3) {
            sg.bigo.ads.common.t.a.a("VideoPlayView", "player pushed first video frame for rendering, video started");
            AdImageView adImageView = this.l;
            if (adImageView != null) {
                adImageView.setVisibility(8);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.core.player.b.c.a
    public final boolean a(int i2, int i8) {
        if (i2 == 100) {
            this.p.e();
            this.p = new c();
        }
        sg.bigo.ads.common.t.a.a(2, "VideoPlayView", "An error occurred during the video playback: ".concat(String.valueOf(i2)));
        a("AdError", new int[]{i2, i8});
        if (i2 == -38) {
            sg.bigo.ads.common.t.a.a(0, "VideoPlayView", "onError code = -38, now reset status and init again.Range=" + this.f17345q);
            this.p.a(this.m);
            return true;
        }
        StringBuilder sbV = a1.a.v(i2, "onError code = ", ", now reset status and init again.Range=");
        sbV.append(this.f17345q);
        sg.bigo.ads.common.t.a.a(0, "VideoPlayView", sbV.toString());
        if (this.p.c() != 0) {
            return true;
        }
        c cVar = this.p;
        if (cVar.f17331i >= 3) {
            return true;
        }
        cVar.b(15);
        return true;
    }
}

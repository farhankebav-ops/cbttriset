package sg.bigo.ads.core.adview;

import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.player.d;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends c implements MediaView.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sg.bigo.ads.core.player.b.f f16800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdImageView f16801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f16802d;
    public Boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public VideoController f16803f;
    public boolean g;
    private boolean h;

    public static class a implements VideoController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private final sg.bigo.ads.core.player.b.f f16804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private VideoController.VideoLifeCallback f16805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private VideoController.d f16806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private VideoController.c f16807d;

        @Nullable
        private VideoController.a e;

        public a(@NonNull sg.bigo.ads.core.player.b.f fVar) {
            this.f16804a = fVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final VideoController.a getBackupLoadCallback() {
            return this.e;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final VideoController.c getLoadHTMLCallback() {
            return this.f16807d;
        }

        @Override // sg.bigo.ads.api.VideoController
        @Nullable
        public final VideoController.d getProgressChangeListener() {
            return this.f16806c;
        }

        @Override // sg.bigo.ads.api.VideoController
        @Nullable
        public final VideoController.VideoLifeCallback getVideoLifeCallback() {
            return this.f16805b;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final boolean isMuted() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            return this.f16804a.c();
        }

        @Override // sg.bigo.ads.api.VideoController
        public final boolean isPaused() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            return this.f16804a.getPlayStatus() == 3;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final boolean isPlaying() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            return this.f16804a.t();
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void mute(boolean z2) {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            this.f16804a.setMute(z2);
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void notifyBackupResourceReady() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            sg.bigo.ads.core.player.b.f fVar = this.f16804a;
            if (fVar instanceof sg.bigo.ads.core.player.b.e) {
                ((sg.bigo.ads.core.player.b.e) fVar).l();
            }
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void notifyPlayViewRegister() {
            d.a.f17382a.a(this.f16804a);
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void notifyResourceReady() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            sg.bigo.ads.core.player.b.f fVar = this.f16804a;
            if (fVar instanceof sg.bigo.ads.core.player.b.e) {
                ((sg.bigo.ads.core.player.b.e) fVar).m();
            }
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void pause() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            this.f16804a.u();
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void play() {
            sg.bigo.ads.core.player.d unused = d.a.f17382a;
            this.f16804a.e(true);
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setBackupLoadCallback(VideoController.a aVar) {
            this.e = aVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setLoadHTMLCallback(VideoController.c cVar) {
            this.f16807d = cVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setProgressChangeListener(VideoController.d dVar) {
            this.f16806c = dVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setVideoLifeCallback(VideoController.VideoLifeCallback videoLifeCallback) {
            this.f16805b = videoLifeCallback;
        }
    }

    public f(@NonNull sg.bigo.ads.api.a<?> aVar) {
        super(aVar);
        this.f16800b = null;
        this.f16801c = null;
        Boolean bool = Boolean.TRUE;
        this.f16802d = bool;
        this.e = bool;
        this.h = true;
        this.g = true;
    }

    @Override // sg.bigo.ads.core.adview.c
    public final void a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        }
        u.a(view, this.f16783a, null, -1);
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final void b() {
        sg.bigo.ads.core.player.b.f fVar = this.f16800b;
        if (fVar != null) {
            fVar.performClick();
        }
    }

    public final int c() {
        AdImageView adImageView = this.f16801c;
        if (adImageView == null || adImageView.getDrawable() == null) {
            return 0;
        }
        return this.f16801c.getDrawable().getIntrinsicHeight();
    }

    public final int d() {
        AdImageView adImageView = this.f16801c;
        if (adImageView == null || adImageView.getDrawable() == null) {
            return 0;
        }
        return this.f16801c.getDrawable().getIntrinsicWidth();
    }

    private boolean b(int i2, int i8) {
        AdImageView adImageView = this.f16801c;
        if (adImageView != null) {
            return u.a(i2, i8, adImageView);
        }
        sg.bigo.ads.core.player.b.f fVar = this.f16800b;
        if (fVar != null) {
            return u.a(i2, i8, fVar);
        }
        return false;
    }

    public final void a(String str) {
        sg.bigo.ads.core.player.b.e eVar = new sg.bigo.ads.core.player.b.e(this.f16783a.getContext(), 0, 0, sg.bigo.ads.api.c.b.b(1), null);
        eVar.setClickable(this.h);
        a(eVar);
        eVar.setPlayInfo$505cff1c(str);
        this.f16803f = new a(eVar);
        this.f16800b = eVar;
    }

    public final void a(@NonNull o oVar, @Nullable sg.bigo.ads.common.p.g gVar) {
        AdImageView adImageView;
        ImageView.ScaleType scaleType;
        AdImageView adImageView2;
        FrameLayout.LayoutParams layoutParams;
        sg.bigo.ads.api.c.b bVarB = sg.bigo.ads.api.c.b.b(oVar.x());
        if (this.f16801c == null) {
            this.f16801c = new AdImageView(this.f16783a.getContext());
        }
        int i2 = bVarB.f15472a;
        if (i2 == 1) {
            adImageView = this.f16801c;
            scaleType = ImageView.ScaleType.FIT_CENTER;
            adImageView.setScaleType(scaleType);
        } else if (i2 != 2) {
            if (i2 == 3) {
                adImageView2 = this.f16801c;
                layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
            } else if (i2 == 4) {
                adImageView2 = this.f16801c;
                layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            }
            adImageView2.setLayoutParams(layoutParams);
            adImageView = this.f16801c;
            scaleType = ImageView.ScaleType.FIT_CENTER;
            adImageView.setScaleType(scaleType);
        } else {
            adImageView = this.f16801c;
            scaleType = ImageView.ScaleType.CENTER_CROP;
            adImageView.setScaleType(scaleType);
        }
        String strAT = oVar.aT();
        a(this.f16801c);
        this.f16801c.setBlurBorder(this.g);
        this.f16801c.a(gVar);
        if (i.f15457a.n().a(9) && URLUtil.isHttpUrl(strAT) && gVar != null) {
            gVar.a(1305, "Invalid http url", "");
        } else {
            this.f16801c.a(strAT, oVar.al());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[PHI: r1
  0x0026: PHI (r1v1 int) = (r1v0 int), (r1v0 int), (r1v4 int) binds: [B:3:0x0010, B:5:0x0018, B:10:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@androidx.annotation.NonNull sg.bigo.ads.core.a.a r9, @androidx.annotation.NonNull sg.bigo.ads.core.f.a.p r10, sg.bigo.ads.core.g.c r11) {
        /*
            r8 = this;
            int r0 = r9.x()
            sg.bigo.ads.api.c.b r5 = sg.bigo.ads.api.c.b.b(r0)
            sg.bigo.ads.api.core.n r0 = r9.aV()
            int r1 = r10.f17065x
            int r10 = r10.f17064w
            if (r0 == 0) goto L26
            long r2 = r0.f15522c
            r6 = 0
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L26
            int r2 = r0.f15520a
            if (r2 <= 0) goto L1f
            r1 = r2
        L1f:
            int r0 = r0.f15521b
            if (r0 <= 0) goto L26
            r4 = r0
        L24:
            r3 = r1
            goto L28
        L26:
            r4 = r10
            goto L24
        L28:
            sg.bigo.ads.core.player.b.e r1 = new sg.bigo.ads.core.player.b.e
            sg.bigo.ads.api.a<?> r10 = r8.f16783a
            android.content.Context r2 = r10.getContext()
            r6 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            boolean r9 = r8.h
            r1.setClickable(r9)
            r8.a(r1)
            sg.bigo.ads.api.a<?> r9 = r8.f16783a
            android.content.Context r9 = r9.getContext()
            java.lang.String r9 = r6.c(r9)
            r1.setPlayInfo$505cff1c(r9)
            r1.setOnEventListener(r11)
            sg.bigo.ads.core.adview.f$a r9 = new sg.bigo.ads.core.adview.f$a
            r9.<init>(r1)
            r8.f16803f = r9
            r8.f16800b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.adview.f.a(sg.bigo.ads.core.a.a, sg.bigo.ads.core.f.a.p, sg.bigo.ads.core.g.c):void");
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final void a(sg.bigo.ads.core.player.b.b bVar) {
        sg.bigo.ads.core.player.b.f fVar = this.f16800b;
        if (fVar instanceof sg.bigo.ads.core.player.b.e) {
            ((sg.bigo.ads.core.player.b.e) fVar).setIVideoPlayerViewListener(bVar);
        }
    }

    public final void a(@NonNull sg.bigo.ads.core.player.b.d dVar) {
        dVar.setVPAIDClickable(this.h);
        a((View) dVar);
        this.f16803f = new a(dVar);
        this.f16800b = dVar;
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final void a(boolean z2) {
        sg.bigo.ads.core.player.b.f fVar = this.f16800b;
        if (fVar != null) {
            fVar.setClickable(z2);
        } else {
            this.h = z2;
        }
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final boolean a() {
        sg.bigo.ads.core.player.b.f fVar = this.f16800b;
        return fVar != null ? fVar.isClickable() : this.h;
    }

    @Override // sg.bigo.ads.core.adview.c
    public final boolean a(int i2, int i8) {
        int i9;
        boolean zB = b(i2, i8);
        if ((super.a(i2, i8) && (b(i2, i8) ^ true)) && this.f16802d.booleanValue()) {
            i9 = 9;
        } else {
            if (!zB || !this.e.booleanValue()) {
                return false;
            }
            i9 = 5;
        }
        a(i9);
        return true;
    }
}

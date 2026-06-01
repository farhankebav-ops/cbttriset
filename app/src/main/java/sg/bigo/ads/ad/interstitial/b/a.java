package sg.bigo.ads.ad.interstitial.b;

import androidx.annotation.CallSuper;
import sg.bigo.ads.ad.interstitial.x;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.common.utils.n;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.bigo.ads.ad.b.c f14281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f14282b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f14285f;
    public InterfaceC0249a g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14284d = false;
    boolean e = false;
    public boolean h = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14283c = 1;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0249a {
        void a(boolean z2, boolean z7);

        void ah();

        void ai();

        void b(long j);
    }

    public static class b implements VideoController.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoController.d f14289a;

        private b(VideoController.d dVar) {
            this.f14289a = dVar;
        }

        @Override // sg.bigo.ads.api.VideoController.d
        @CallSuper
        public void a(int i2, int i8) {
            VideoController.d dVar = this.f14289a;
            if (dVar != null) {
                dVar.a(i2, i8);
            }
        }

        public /* synthetic */ b(VideoController.d dVar, byte b8) {
            this(dVar);
        }
    }

    public static class c implements VideoController.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoController.b f14290a;

        private c(VideoController.b bVar) {
            this.f14290a = bVar;
        }

        @Override // sg.bigo.ads.api.VideoController.b
        @CallSuper
        public final void a() {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.b
        @CallSuper
        public final void b() {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        @CallSuper
        public void onMuteChange(boolean z2) {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.onMuteChange(z2);
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        @CallSuper
        public void onVideoEnd() {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.onVideoEnd();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        @CallSuper
        public void onVideoPause() {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.onVideoPause();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        @CallSuper
        public void onVideoPlay() {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.onVideoPlay();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        @CallSuper
        public void onVideoStart() {
            VideoController.b bVar = this.f14290a;
            if (bVar != null) {
                bVar.onVideoStart();
            }
        }

        public /* synthetic */ c(VideoController.b bVar, byte b8) {
            this(bVar);
        }
    }

    public static /* synthetic */ void a(a aVar) {
        if (!aVar.a()) {
            if (aVar.f14284d) {
                aVar.b();
                return;
            }
            sg.bigo.ads.common.t.a.a(0, "CountdownHelper", "invalid status, isCountdownIgnoreVideoProgress=" + aVar.a() + ", mVideoEnd=" + aVar.f14284d);
            return;
        }
        if (aVar.e) {
            aVar.b();
            return;
        }
        sg.bigo.ads.ad.b.c cVar = aVar.f14281a;
        VideoController videoController = cVar != null ? cVar.getVideoController() : null;
        if (videoController == null || videoController.isPlaying()) {
            return;
        }
        videoController.play();
    }

    private void b() {
        InterfaceC0249a interfaceC0249a = this.g;
        if (interfaceC0249a != null) {
            interfaceC0249a.a(a(), this.f14284d);
        }
    }

    public final void a(boolean z2) {
        if (z2 && !a()) {
            InterfaceC0249a interfaceC0249a = this.g;
            if (interfaceC0249a != null) {
                interfaceC0249a.ah();
                return;
            }
            return;
        }
        if (z2 || !a()) {
            return;
        }
        n nVar = this.f14285f;
        if (nVar != null && nVar.e()) {
            this.f14285f.c();
        }
        InterfaceC0249a interfaceC0249a2 = this.g;
        if (interfaceC0249a2 != null) {
            interfaceC0249a2.ah();
        }
    }

    public final void b(boolean z2) {
        if (z2 && !a()) {
            InterfaceC0249a interfaceC0249a = this.g;
            if (interfaceC0249a != null) {
                interfaceC0249a.ai();
                return;
            }
            return;
        }
        if (z2 || !a()) {
            return;
        }
        n nVar = this.f14285f;
        if (nVar != null) {
            nVar.d();
        }
        InterfaceC0249a interfaceC0249a2 = this.g;
        if (interfaceC0249a2 != null) {
            interfaceC0249a2.ai();
        }
    }

    public final boolean a() {
        return this.f14283c == 2;
    }
}

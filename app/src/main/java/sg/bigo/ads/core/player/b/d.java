package sg.bigo.ads.core.player.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ironsource.Mf;
import com.ironsource.adqualitysdk.sdk.i.a0;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.g.a.a;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends f implements sg.bigo.ads.core.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final sg.bigo.ads.core.g.a.a f17337a;
    private int g;
    private boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17338i;
    private int j;
    private boolean k;
    private final sg.bigo.ads.core.g.e l;
    private boolean m;

    public d(Context context, int i2, int i8, @NonNull sg.bigo.ads.api.c.b bVar, @NonNull sg.bigo.ads.core.a.a aVar) {
        super(context, bVar, aVar);
        this.g = 0;
        this.h = false;
        this.f17338i = false;
        this.k = false;
        sg.bigo.ads.core.g.e eVar = new sg.bigo.ads.core.g.e() { // from class: sg.bigo.ads.core.player.b.d.1
            @Override // sg.bigo.ads.core.g.e
            public final void a() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdImpression");
                d.this.a("AdVPAIDImpression", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoStart");
                d.this.a("AdVideoStart", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void c() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoFirstQuartile");
                d.this.a("AdVideoFirstQuartile", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void d() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoMidpoint");
                d.this.a("AdVideoMidpoint", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void e() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoThirdQuartile");
                d.this.a("AdVideoThirdQuartile", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void f() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoComplete");
                d.this.g = 5;
                d.this.m = true;
                d dVar = d.this;
                dVar.setPlayOrPauseViewHidden(dVar.f17363d.f15473b);
                d.this.c(true);
                d.this.d(false);
                d.this.a("AdVideoComplete", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void g() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdSkippableStateChange");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void h() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", Mf.j);
                d.this.g = 1;
                d.this.h = true;
                d dVar = d.this;
                dVar.setAdVolume(dVar.f17363d.f15475d ? 0.0f : 1.0f);
                if (d.this.n()) {
                    d.this.b(18);
                    d.this.setStatPrepareEventOnce(false);
                }
                if (d.this.k) {
                    d.b(d.this);
                    d.this.b();
                } else if (!d.this.q() && !d.this.m) {
                    d.this.d(true);
                }
                d.this.a("AdLoaded", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void i() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdPlaying");
                d.this.g = 2;
                d.this.a("AdVideoPlaying", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void j() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onStartAd");
                d.this.g = 2;
                d.this.m = false;
                d.this.a("AdVideoPlaying", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void k() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onStopAd");
                d.this.g = 4;
                d.this.a("AdStopped", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void l() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onSkipAd");
                d.this.b(10);
                d.this.a("AdSkipped", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void m() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdPaused");
                d.this.g = 3;
                d.this.a("AdVideoPaused", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void n() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdUserAcceptInvitation");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void o() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdUserMinimize");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void p() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdUserClose");
                d.this.a("AdClosed", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(float f4) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVolumeChange, volume=".concat(String.valueOf(f4)));
                d.this.f17338i = f4 <= 0.0f;
                d dVar = d.this;
                dVar.b(dVar.f17338i);
                d dVar2 = d.this;
                dVar2.a("AdVolumeChange", new int[]{dVar2.f17338i ? 0 : 100});
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b(int i9) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdRemainingTimeChange, remaining=".concat(String.valueOf(i9)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void c(String str) {
                a0.i(0, str, "onAdInteraction, id=", 3, "VPAIDPlayView");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(int i9) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdDurationChange, duration=".concat(String.valueOf(i9)));
                d.this.j = i9;
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b(String str) {
                a0.i(0, str, "onAdLog, message=", 3, "VPAIDPlayView");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(int i9, int i10) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", androidx.camera.core.processing.util.a.i("onAdSizeChange, w=", i9, ", h=", i10));
                d.this.a("AdSizeChange", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b(boolean z2) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdInteraction, adLinear=".concat(String.valueOf(z2)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(String str) {
                a0.i(0, str, "onAdError, message=", 3, "VPAIDPlayView");
                d.this.a("AdError", str, new int[]{-1, -1});
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(String str, String str2, boolean z2) {
                StringBuilder sbZ = a1.a.z("onAdClickThru, url=", str, ", id=", str2, ", playerHandles=");
                sbZ.append(z2);
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", sbZ.toString());
                d.a(d.this, str, z2);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(boolean z2) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdExpandedChange, expanded=".concat(String.valueOf(z2)));
            }
        };
        this.l = eVar;
        this.m = bVar.e;
        p pVarBp = aVar.bp();
        sg.bigo.ads.core.f.a.a.a aVar2 = pVarBp != null ? pVarBp.B : null;
        sg.bigo.ads.core.g.a.a aVar3 = new sg.bigo.ads.core.g.a.a(context, this, aVar.b(context), i2, i8, sg.bigo.ads.api.core.b.b(aVar.x()) ? sg.bigo.ads.core.g.f.FULLSCREEN : sg.bigo.ads.core.g.f.NORMAL, aVar2 != null ? aVar2.a().trim() : "", sg.bigo.ads.api.core.b.d(aVar.x()) ? 3 : bVar.f15472a, aVar.bo());
        this.f17337a = aVar3;
        aVar3.f17068b.setVPAIDEvenListener(eVar);
        aVar3.f17069c = new a.InterfaceC0317a() { // from class: sg.bigo.ads.core.player.b.d.2
            @Override // sg.bigo.ads.core.g.a.a.InterfaceC0317a
            public final void a() {
                sg.bigo.ads.common.t.a.b("VPAIDPlayView", "onVPAIDPlayerDestroy");
                d.this.h = false;
                d.this.d(false);
                if (d.this.m) {
                    return;
                }
                d.this.r();
            }
        };
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final boolean c() {
        return this.f17338i;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void d() {
        d(false);
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final boolean e() {
        return this.h;
    }

    public final String getAdCompanions() {
        return this.f17337a.f17068b.getAdCompanions();
    }

    public final int getAdDuration() {
        return this.f17337a.f17068b.getAdDuration();
    }

    public final boolean getAdExpanded() {
        return this.f17337a.f17068b.getAdExpanded();
    }

    public final int getAdHeight() {
        return this.f17337a.f17068b.getAdHeight();
    }

    public final boolean getAdIcons() {
        return this.f17337a.f17068b.getAdIcons();
    }

    public final boolean getAdLinear() {
        return this.f17337a.f17068b.getAdLinear();
    }

    public final int getAdRemainingTime() {
        return this.f17337a.f17068b.getAdRemainingTime();
    }

    public final boolean getAdSkippableState() {
        return this.f17337a.f17068b.getAdSkippableState();
    }

    public final float getAdVolume() {
        return this.f17337a.f17068b.getAdVolume();
    }

    public final int getAdWidth() {
        return this.f17337a.f17068b.getAdWidth();
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final int getPlayStatus() {
        return this.g;
    }

    public final void setAdVolume(float f4) {
        this.f17337a.f17068b.setAdVolume(f4);
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void setMute(boolean z2) {
        setAdVolume(z2 ? 0.0f : 1.0f);
    }

    public final void setVPAIDClickable(boolean z2) {
        this.f17337a.f17068b.setVPAIDClickable(z2);
    }

    @Override // sg.bigo.ads.api.c.a
    public final void a() {
        this.f17337a.f17068b.a("window.vpaidwrapper.pauseAd()");
        this.k = false;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void b() {
        if (q() || this.m) {
            if (this.m) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "tryStartAd, video is completed play, unregister it from list");
                d(false);
                return;
            }
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "try start play video ad");
        if (this.g == 1) {
            a(false);
        } else {
            this.f17337a.f17068b.a("window.vpaidwrapper.resumeAd()");
        }
    }

    public static /* synthetic */ void a(d dVar, String str, boolean z2) {
        if (sg.bigo.ads.core.g.d.d(str)) {
            sg.bigo.ads.core.a.a aVar = dVar.e;
            c.b bVarN = aVar != null ? aVar.N() : null;
            if (bVarN != null) {
                bVarN.a(str);
            }
        }
        dVar.a("AdVPAIDClickThru", dVar.f17337a.f17068b.getClickPoints(), new int[]{z2 ? 1 : 0});
    }

    public static /* synthetic */ boolean b(d dVar) {
        dVar.k = false;
        return false;
    }

    @Override // sg.bigo.ads.core.player.b.f
    public final void a(boolean z2) {
        super.a(z2);
        if (!this.h) {
            this.k = z2;
            return;
        }
        sg.bigo.ads.core.g.a.b bVar = this.f17337a.f17068b;
        bVar.f17077d.a(3);
        bVar.a("window.vpaidwrapper.startAd()");
        if (!sg.bigo.ads.common.aa.b.a(getContext())) {
            sg.bigo.ads.common.t.a.b("VPAIDPlayView", "screen is off, start ad cancel");
        } else {
            setPlayOrPauseViewHidden(true);
            d(true);
        }
    }
}

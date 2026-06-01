package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0749Fn {
    public final Handler A00;
    public final InterfaceC0750Fo A01;

    public C0749Fn(Handler handler, InterfaceC0750Fo interfaceC0750Fo) {
        this.A00 = interfaceC0750Fo != null ? (Handler) C3M.A01(handler) : null;
        this.A01 = interfaceC0750Fo;
    }

    public final void A00(final int i2, final long j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fj
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A02(i2, j);
                }
            });
        }
    }

    public final void A01(final int i2, final long j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fa
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A03(i2, j);
                }
            });
        }
    }

    public final /* synthetic */ void A02(int i2, long j) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).ACr(i2, j);
    }

    public final /* synthetic */ void A03(int i2, long j) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AD7(i2, j);
    }

    @MetaExoPlayerCustomization("New event handler")
    public final void A04(int i2, C2154or c2154or) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0748Fm(this, i2, c2154or));
        }
    }

    public final void A05(final C2154or c2154or, final C05015j c05015j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fg
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A06(c2154or, c05015j);
                }
            });
        }
    }

    public final /* synthetic */ void A06(C2154or c2154or, C05015j c05015j) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AFk(c2154or);
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AFl(c2154or, c05015j);
    }

    public final void A07(final C2107o4 c2107o4) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fi
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A08(c2107o4);
                }
            });
        }
    }

    public final /* synthetic */ void A08(C2107o4 c2107o4) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AFr(c2107o4);
    }

    public final void A09(final C04985g c04985g) {
        c04985g.A02();
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fk
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0B(c04985g);
                }
            });
        }
    }

    public final void A0A(final C04985g c04985g) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fe
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0C(c04985g);
                }
            });
        }
    }

    public final /* synthetic */ void A0B(C04985g c04985g) {
        c04985g.A02();
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AFe(c04985g);
    }

    public final /* synthetic */ void A0C(C04985g c04985g) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AFf(c04985g);
    }

    public final void A0D(final Object obj) {
        if (this.A00 != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Ff
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0E(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final /* synthetic */ void A0E(Object obj, long j) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AEx(obj, j);
    }

    @MetaExoPlayerCustomization("New event handler")
    public final void A0F(final String str) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fh
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A0G(final String str, final long j, final long j3) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Fd
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0H(str, j, j3);
                }
            });
        }
    }

    public final /* synthetic */ void A0H(String str, long j, long j3) {
        ((InterfaceC0750Fo) AbstractC04664a.A0f(this.A01)).AFd(str, j, j3);
    }
}

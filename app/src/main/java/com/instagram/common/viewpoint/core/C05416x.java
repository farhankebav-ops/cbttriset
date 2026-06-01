package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05416x {
    public static final C2001mL A0E = new C2001mL(new Object());
    public final int A00;
    public final long A01;
    public final long A02;
    public final Timeline A03;
    public final C2001mL A04;
    public final C2001mL A05;
    public final C1991mA A06;
    public final EL A07;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Start Stall Logging")
    public final EnumC1730hX A08;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Determine if stall is from Audio for logging")
    public final boolean A09;
    public final boolean A0A;
    public volatile long A0B;
    public volatile long A0C;
    public volatile long A0D;

    public C05416x(Timeline timeline, long j, C1991mA c1991mA, EL el) {
        this(timeline, A0E, j, -9223372036854775807L, 1, false, c1991mA, el, A0E, j, j, j, EnumC1730hX.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to call base constructor")
    public C05416x(Timeline timeline, C2001mL c2001mL, long j, long j3, int i2, boolean z2, C1991mA c1991mA, EL el, C2001mL c2001mL2, long j8, long j9, long j10) {
        this(timeline, c2001mL, j, j3, i2, z2, c1991mA, el, c2001mL2, j8, j9, j10, EnumC1730hX.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to add new parameters")
    public C05416x(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) Timeline timeline, @MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) C2001mL c2001mL, long j, long j3, int i2, boolean z2, C1991mA c1991mA, EL el, C2001mL c2001mL2, long j8, long j9, long j10, EnumC1730hX enumC1730hX, boolean z7) {
        this.A03 = timeline;
        this.A05 = c2001mL;
        this.A02 = j;
        this.A01 = j3;
        this.A0C = j;
        this.A00 = i2;
        this.A0A = z2;
        this.A06 = c1991mA;
        this.A07 = el;
        this.A04 = c2001mL2;
        this.A0B = j8;
        this.A0D = j9;
        this.A0C = j10;
        this.A08 = enumC1730hX;
        this.A09 = z7;
    }

    public static void A00(C05416x c05416x, C05416x c05416x2) {
        c05416x2.A0C = c05416x.A0C;
        c05416x2.A0B = c05416x.A0B;
        c05416x2.A0D = c05416x.A0D;
    }

    public final C05416x A01(int i2) {
        C05416x c05416x = new C05416x(this.A03, this.A05, this.A02, this.A01, i2, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c05416x);
        return c05416x;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Stall Reason Logging in Hero")
    public final C05416x A02(int i2, EnumC1730hX enumC1730hX, boolean z2) {
        C05416x c05416x = new C05416x(this.A03, this.A05, this.A02, this.A01, i2, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, enumC1730hX, z2);
        A00(this, c05416x);
        return c05416x;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "To track Audio Stalls for Logging")
    public final C05416x A03(int i2, boolean z2) {
        C05416x c05416x = new C05416x(this.A03, this.A05, this.A02, this.A01, i2, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, z2);
        A00(this, c05416x);
        return c05416x;
    }

    public final C05416x A04(Timeline timeline) {
        C05416x c05416x = new C05416x(timeline, this.A05, this.A02, this.A01, this.A00, this.A0A, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c05416x);
        return c05416x;
    }

    public final C05416x A05(C2001mL c2001mL) {
        return new C05416x(this.A03, this.A05, this.A02, this.A01, this.A00, this.A0A, this.A06, this.A07, c2001mL, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
    }

    public final C05416x A06(C2001mL c2001mL, long j, long j3, long j8) {
        long j9 = j3;
        Timeline timeline = this.A03;
        if (!c2001mL.A00()) {
            j9 = -9223372036854775807L;
        }
        return new C05416x(timeline, c2001mL, j, j9, this.A00, this.A0A, this.A06, this.A07, this.A04, this.A0B, j8, j);
    }

    public final C05416x A07(C1991mA c1991mA, EL el) {
        C05416x c05416x = new C05416x(this.A03, this.A05, this.A02, this.A01, this.A00, this.A0A, c1991mA, el, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c05416x);
        return c05416x;
    }

    public final C05416x A08(boolean z2) {
        C05416x c05416x = new C05416x(this.A03, this.A05, this.A02, this.A01, this.A00, z2, this.A06, this.A07, this.A04, this.A0B, this.A0D, this.A0C, this.A08, this.A09);
        A00(this, c05416x);
        return c05416x;
    }
}

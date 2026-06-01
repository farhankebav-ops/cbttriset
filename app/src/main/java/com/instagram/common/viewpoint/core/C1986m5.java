package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.ironsource.W2;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1986m5 implements EA {
    public static String[] A0B = {"ziZaTeBfSFNnIBcgtlZExnB4uOVj2q5B", "5IZt5NWgPCitKNTqtiA", "aLHVXVzU6ljMUMq9dZgrDfQ8JzHl8MF", "mvLcqO7QF6VGSUKAdCZC8bhhp8aLucng", "FQUZNhR4lN6thgMMBkcdaTgoY6ZzypcM", "72R8UBsha86AOqtb805OpiOBiH7oe8El", "AjNBccUrYW9zDFgtuo7TyJwkSvkBJU7y", "GkSBWsvGG5dBFRJxqtw9GV4lDtiTWOM"};
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;
    public final C3T A08;

    @MetaExoPlayerCustomization("This is no longer set in the constructor")
    public final EU A09;
    public final int A0A;

    public C1986m5() {
        this(10000, W2.g, W2.g, 0.75f);
    }

    public C1986m5(int i2, int i8, int i9, float f4) {
        this(null, -1, i2, i8, i9, 1279, 719, f4, 0.75f, 2000L, C3T.A00);
    }

    public C1986m5(EU eu) {
        this(eu, -1, 10000, W2.g, W2.g, 1279, 719, 0.75f, 0.75f, 2000L, C3T.A00);
    }

    public C1986m5(@MetaExoPlayerCustomization("No longer set through factory") EU eu, @MetaExoPlayerCustomization("Non standard variable; used in oculus") int i2, @MetaExoPlayerCustomization("Removed from upstream") int i8, int i9, int i10, int i11, int i12, float f4, float f8, long j, C3T c3t) {
        this.A09 = eu;
        this.A0A = i2;
        this.A05 = i8;
        this.A02 = i9;
        this.A06 = i10;
        this.A04 = i11;
        this.A03 = i12;
        this.A00 = f4;
        this.A01 = f8;
        this.A07 = j;
        this.A08 = c3t;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint> */
    private final C03880y A00(C2120oH c2120oH, int[] iArr, int i2, EU eu, AbstractC0621Am<C0702Ds> abstractC0621Am) {
        return new C03880y(c2120oH, iArr, i2, eu, this.A0A, this.A05, this.A02, this.A06, this.A04, this.A03, this.A00, this.A01, this.A07, abstractC0621Am, this.A08);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.instagram.common.viewpoint.core.EA
    public final InterfaceC1964lj[] A5T(E9[] e9Arr, EU eu, C2001mL c2001mL, Timeline timeline) {
        InterfaceC1964lj interfaceC1964ljA00;
        AbstractC0621Am abstractC0621AmA00 = C03880y.A00(e9Arr);
        InterfaceC1964lj[] interfaceC1964ljArr = new InterfaceC1964lj[e9Arr.length];
        for (int i2 = 0; i2 < e9Arr.length; i2++) {
            E9 e9 = e9Arr[i2];
            if (e9 != null && e9.A02.length != 0) {
                int length = e9.A02.length;
                if (A0B[3].length() != 32) {
                    throw new RuntimeException();
                }
                A0B[1] = "4JDRhnBkti3";
                if (length == 1) {
                    interfaceC1964ljA00 = new C03870x(e9.A01, e9.A02[0], e9.A00);
                } else {
                    interfaceC1964ljA00 = A00(e9.A01, e9.A02, e9.A00, eu, (AbstractC0621Am) abstractC0621AmA00.get(i2));
                }
                interfaceC1964ljArr[i2] = interfaceC1964ljA00;
            }
        }
        return interfaceC1964ljArr;
    }
}

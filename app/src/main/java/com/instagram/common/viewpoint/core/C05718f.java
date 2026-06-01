package com.instagram.common.viewpoint.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05718f {
    public static byte[] A0A;
    public static String[] A0B = {"rRI8qFzkORd3qFRWXYKq4VZ7aOLIEK5J", "8iww", "9Fk01UJleHjJYWOvUCOjDovINy", "Tv7H9N81DtUxkF43CmkgrLrGhTLdsXix", "nBkKdwNSwO57UCO3SoKJGDMTXuqjBDbM", "lOXwNuIjFjHmQAdnwK2N8OZR9kPb", "lPFUJhDD1cvxNL1LCxfPRC2f3Pky1Kvn", "6r"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final C2154or A07;
    public final boolean A08;
    public final AnonymousClass38[] A09;

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{5, 36, 39, 32, 52, 45, 53, 0, 52, 37, 40, 46, 18, 40, 47, 42, 40, 63, 35, 38, 46, 11, 63, 46, 35, 37, 30, 56, 43, 41, 33, 112, 106, 57, 62, 43, 62, 47, 119, 111, 46, 102, 106, 43, 63, 46, 35, 37, 30, 56, 43, 41, 33, 11, 38, 38, 37, 41, 43, 62, 47, 46, 100, 45, 47, 62, 98, 99, 119, 111, 46};
    }

    static {
        A07();
    }

    public C05718f(C2154or c2154or, int i2, int i8, int i9, int i10, int i11, int i12, int i13, AnonymousClass38[] anonymousClass38Arr, boolean z2) {
        this.A07 = c2154or;
        this.A01 = i2;
        this.A04 = i8;
        this.A05 = i9;
        this.A06 = i10;
        this.A02 = i11;
        this.A03 = i12;
        this.A00 = i13;
        this.A09 = anonymousClass38Arr;
        this.A08 = z2;
    }

    public static AudioAttributes A00() {
        return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }

    public static AudioAttributes A01(C2160oy c2160oy, boolean z2) {
        if (z2) {
            return A00();
        }
        return c2160oy.A01().A00;
    }

    private AudioTrack A02(C2160oy c2160oy, int i2) {
        int iA04 = AbstractC04664a.A04(c2160oy.A05);
        if (i2 != 0) {
            return new AudioTrack(iA04, this.A06, this.A02, this.A03, this.A00, 1, i2);
        }
        return new AudioTrack(iA04, this.A06, this.A02, this.A03, this.A00, 1);
    }

    private AudioTrack A03(boolean z2, C2160oy c2160oy, int i2) {
        if (AbstractC04664a.A02 >= 29) {
            return A05(z2, c2160oy, i2);
        }
        if (AbstractC04664a.A02 >= 21) {
            return A04(z2, c2160oy, i2);
        }
        AudioTrack audioTrackA02 = A02(c2160oy, i2);
        String[] strArr = A0B;
        if (strArr[5].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0B;
        strArr2[5] = "QYyaIvQJX9uBRZ92y0XmWMx9BnIt";
        strArr2[7] = "OM";
        return audioTrackA02;
    }

    private AudioTrack A04(boolean z2, C2160oy c2160oy, int i2) {
        return new AudioTrack(A01(c2160oy, z2), C2038mw.A0D(this.A06, this.A02, this.A03), this.A00, 1, i2);
    }

    private AudioTrack A05(boolean z2, C2160oy c2160oy, int i2) {
        AudioFormat audioFormatA0D = C2038mw.A0D(this.A06, this.A02, this.A03);
        AudioAttributes audioTrackAttributes = A01(c2160oy, z2);
        AudioTrack.Builder audioFormat = new AudioTrack.Builder().setAudioAttributes(audioTrackAttributes).setAudioFormat(audioFormatA0D);
        boolean z7 = true;
        AudioTrack.Builder sessionId = audioFormat.setTransferMode(1).setBufferSizeInBytes(this.A00).setSessionId(i2);
        if (this.A04 != 1) {
            z7 = false;
        }
        AudioTrack audioTrackBuild = sessionId.setOffloadedPlayback(z7).build();
        String[] strArr = A0B;
        if (strArr[4].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A0B[1] = "btQ69Jh";
        return audioTrackBuild;
    }

    public final long A08(long j) {
        return (1000000 * j) / ((long) this.A06);
    }

    public final long A09(long j) {
        return (1000000 * j) / ((long) this.A07.A0G);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D23918943: Monitor the audio track usage through audioTrackAllocated")
    public final AudioTrack A0A(boolean z2, C2160oy c2160oy, int i2) throws C8H {
        try {
            AudioTrack audioTrackA03 = A03(z2, c2160oy, i2);
            C2038mw.A0M().incrementAndGet();
            int state = audioTrackA03.getState();
            if (state == 1) {
                return audioTrackA03;
            }
            try {
                audioTrackA03.release();
                C2038mw.A0M().decrementAndGet();
            } catch (Exception e) {
                AnonymousClass44.A08(A06(0, 16, 69), String.format(A06(16, 55, 78), Integer.valueOf(state), Integer.valueOf(C2038mw.A0M().get())), e);
            }
            throw new C8H(state, this.A06, this.A02, this.A00, this.A07, A0D(), null, C2038mw.A0M().get());
        } catch (IllegalArgumentException | UnsupportedOperationException e4) {
            throw new C8H(0, this.A06, this.A02, this.A00, this.A07, A0D(), e4, C2038mw.A0M().get());
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.8F] */
    public final C8F A0B() {
        final int i2 = this.A03;
        final int i8 = this.A06;
        final int i9 = this.A02;
        final boolean z2 = this.A08;
        final boolean z7 = this.A04 == 1;
        final int i10 = this.A00;
        return new Object(i2, i8, i9, z2, z7, i10) { // from class: com.facebook.ads.redexgen.X.8F
            public final int A00;
            public final int A01;
            public final int A02;
            public final int A03;
            public final boolean A04;
            public final boolean A05;

            {
                this.A02 = i2;
                this.A03 = i8;
                this.A01 = i9;
                this.A05 = z2;
                this.A04 = z7;
                this.A00 = i10;
            }
        };
    }

    public final C05718f A0C(int i2) {
        return new C05718f(this.A07, this.A01, this.A04, this.A05, this.A06, this.A02, this.A03, i2, this.A09, this.A08);
    }

    public final boolean A0D() {
        return this.A04 == 1;
    }

    public final boolean A0E(C05718f c05718f) {
        return c05718f.A04 == this.A04 && c05718f.A03 == this.A03 && c05718f.A06 == this.A06 && c05718f.A02 == this.A02 && c05718f.A05 == this.A05;
    }
}

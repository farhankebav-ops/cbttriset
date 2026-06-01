package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E3 {
    public static byte[] A04;
    public static String[] A05 = {"XChyMIA3IiBLGVc4JUcuiIFhw0olIHd5", "L1RbhyPLCDSvJWoCYJVALOKwr45Jj", "4i4NfCjlBic1LnGuByjRmO6XDD8s", "fp6arCeubKdlGGxkl3wydgWAbBMIIbeF", "pgUH6rfDE1GExBA3fVJRXk8gj61UjiI1", "O5JAn4ITNRkPEp9cAHFgOejRoj0rukGX", "JccK1QqImqh6kMtQx4F4QpK5m5M4", "faWXzGQd6eAsmBqhrITpsBscnTY0oqi8"};
    public Spatializer$OnSpatializerStateChangedListener A00;
    public Handler A01;
    public final Spatializer A02;
    public final boolean A03;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{101, 113, 96, 109, 107, 88, 76, 93, 80, 86, 22, 92, 88, 90, 10, 20, 83, 86, 90};
    }

    static {
        A02();
    }

    public E3(Spatializer spatializer) {
        this.A02 = spatializer;
        this.A03 = spatializer.getImmersiveAudioLevel() != 0;
    }

    public static E3 A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(0, 5, 33));
        if (audioManager == null) {
            return null;
        }
        return new E3(audioManager.getSpatializer());
    }

    public final void A03(AnonymousClass92 anonymousClass92, Looper looper) {
        if (this.A00 != null || this.A01 != null) {
            return;
        }
        this.A00 = new E2(this, anonymousClass92);
        this.A01 = new Handler(looper);
        Spatializer spatializer = this.A02;
        Handler handler = this.A01;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new ExecutorC05758l(handler), this.A00);
    }

    public final boolean A04() {
        return this.A02.isAvailable();
    }

    public final boolean A05() {
        return this.A02.isEnabled();
    }

    public final boolean A06() {
        return this.A03;
    }

    public final boolean A07(C2160oy c2160oy, C2154or c2154or) {
        int i2;
        if (A01(5, 14, 28).equals(c2154or.A0W) && c2154or.A06 == 16) {
            i2 = 12;
        } else {
            i2 = c2154or.A06;
        }
        AudioFormat.Builder encoding = new AudioFormat.Builder().setEncoding(2);
        int linearChannelCount = AbstractC04664a.A01(i2);
        AudioFormat.Builder channelMask = encoding.setChannelMask(linearChannelCount);
        if (c2154or.A0G != -1) {
            int linearChannelCount2 = c2154or.A0G;
            channelMask.setSampleRate(linearChannelCount2);
        }
        Spatializer spatializer = this.A02;
        AudioAttributes audioAttributes = c2160oy.A01().A00;
        AudioFormat audioFormatBuild = channelMask.build();
        if (A05[1].length() != 29) {
            throw new RuntimeException();
        }
        A05[5] = "fxex8oBXLxgy8X4V5eG1x3lhnMHn34Gl";
        return spatializer.canBeSpatialized(audioAttributes, audioFormatBuild);
    }
}

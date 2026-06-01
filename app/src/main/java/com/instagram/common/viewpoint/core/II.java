package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class II {
    public static byte[] A01;

    @MetaExoPlayerCustomization("Adding TYPE_xml")
    public static final int A02;
    public final int A00;

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{-26, -37, -38, -114};
    }

    static {
        A04();
        A02 = AbstractC04664a.A0D(A03(0, 4, 3));
    }

    public II(int i2) {
        this.A00 = i2;
    }

    public static int A00(int i2) {
        return 16777215 & i2;
    }

    public static int A01(int i2) {
        return (i2 >> 24) & 255;
    }

    public static String A02(int i2) {
        return A03(0, 0, 9) + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public String toString() {
        return A02(this.A00);
    }
}

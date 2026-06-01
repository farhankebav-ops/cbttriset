package com.instagram.common.viewpoint.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05587o {
    public static final AudioAttributes A00 = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int A00(int i2, int i8) {
        for (int i9 = 8; i9 > 0; i9--) {
            AudioFormat.Builder sampleRate = new AudioFormat.Builder().setEncoding(i2).setSampleRate(i8);
            int channelCount = AbstractC04664a.A01(i9);
            AudioFormat audioFormat = sampleRate.setChannelMask(channelCount).build();
            if (AudioTrack.isDirectPlaybackSupported(audioFormat, A00)) {
                return i9;
            }
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    public static int[] A01() {
        C03971h c03971hA01 = AbstractC0621Am.A01();
        AbstractC2188pg it = C05597p.A06.keySet().iterator();
        while (it.hasNext()) {
            int encoding = ((Integer) it.next()).intValue();
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(encoding).setSampleRate(48000).build(), A00)) {
                c03971hA01.A04(Integer.valueOf(encoding));
            }
        }
        c03971hA01.A04(2);
        return AD.A0C(c03971hA01.A05());
    }
}

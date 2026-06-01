package com.instagram.common.viewpoint.core;

import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8a, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8a {
    public static String[] A00 = {"HyVFju0jW", "C5fZxe", "", "VQC7lBe8X0XIyVl71uwsToKAMftvX", "qc4cjMrzTMcJnGZRxAG6ibX2mVWthZMP", "3OzdIJ", "XboRF4F7pcuh5Lnm7QRi4zxVRlLSdFic", "8bcueyNysUpicTQfAxYptjP2NzHtyKr1"};

    public static void A00(AudioTrack audioTrack, C05698c c05698c) {
        audioTrack.setPreferredDevice(c05698c == null ? null : c05698c.A00);
        String[] strArr = A00;
        if (strArr[7].charAt(11) == strArr[4].charAt(11)) {
            throw new RuntimeException();
        }
        A00[2] = "oWCieRMjyh4ofIxIc5um83fUD9gSksXl";
    }
}

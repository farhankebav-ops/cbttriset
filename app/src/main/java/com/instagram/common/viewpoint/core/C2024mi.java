package com.instagram.common.viewpoint.core;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2024mi implements InterfaceC0631Aw {
    public MediaCodecInfo[] A00;
    public final int A01;

    public C2024mi(boolean z2, boolean z7) {
        int i2;
        if (z2 || z7) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.A01 = i2;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private void A00() {
        if (this.A00 == null) {
            this.A00 = new MediaCodecList(this.A01).getCodecInfos();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final int A7H() {
        A00();
        return this.A00.length;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final MediaCodecInfo A7I(int i2) {
        A00();
        return this.A00[i2];
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final boolean AAI(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final boolean AAJ(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final boolean AIK() {
        return true;
    }
}

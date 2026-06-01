package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ba, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/NoOpMediaCodecPoolTracker;", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;", "<init>", "()V", "reportCodecCreated", "", "creatingEvent", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$CreatingEvent;", "codecInstanceId", "", "reportCodecReleasing", "source", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;", "reportCodecReleased", "reportCodecAcquiredFromPool", "isVideo", "", "codecName", "", "reportCodecReturnedToPool", "Companion", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoOpMediaCodecPoolTracker extends MediaCodecPoolTracker {
    public static byte[] A00;
    public static final C1757i7 A01;
    public static final NoOpMediaCodecPoolTracker A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{36, 40, 35, 34, 36, 9, 38, 42, 34, 9, 24, 15, 11, 30, 3, 4, 13, 47, 28, 15, 4, 30, 84, 72, 82, 85, 68, 66};
    }

    static {
        A01();
        A01 = new C1757i7(null);
        A02 = new NoOpMediaCodecPoolTracker();
    }

    @Override // com.instagram.common.viewpoint.core.MediaCodecPoolTracker
    public final void A06(C1744ho c1744ho, int i2) {
        C2168p6.A09(c1744ho, A00(9, 13, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
    }

    @Override // com.instagram.common.viewpoint.core.MediaCodecPoolTracker
    public final void A07(EnumC1746hq enumC1746hq, int i2) {
        C2168p6.A09(enumC1746hq, A00(22, 6, 54));
    }

    @Override // com.instagram.common.viewpoint.core.MediaCodecPoolTracker
    public final void A08(EnumC1746hq enumC1746hq, int i2) {
        C2168p6.A09(enumC1746hq, A00(22, 6, 54));
    }

    @Override // com.instagram.common.viewpoint.core.MediaCodecPoolTracker
    public final void A09(EnumC1746hq enumC1746hq, int i2) {
        C2168p6.A09(enumC1746hq, A00(22, 6, 54));
    }

    @Override // com.instagram.common.viewpoint.core.MediaCodecPoolTracker
    public final void A0A(boolean z2, String str, EnumC1746hq enumC1746hq, int i2) {
        C2168p6.A09(str, A00(0, 9, 86));
        C2168p6.A09(enumC1746hq, A00(22, 6, 54));
    }
}

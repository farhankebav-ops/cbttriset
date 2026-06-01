package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.he, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\r\u000eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/ImfDataTrack;", "", "mTrackName", "", "mStartTime", "", "mEndTime", "mStickerTrackType", "Lcom/facebook/video/heroplayer/exocustom/ImfDataTrack$StickerTrackType;", "mSegmentMetadata", "Lcom/facebook/video/heroplayer/exocustom/ImfDataTrack$SegmentMetadata;", "<init>", "(Ljava/lang/String;JJLcom/facebook/video/heroplayer/exocustom/ImfDataTrack$StickerTrackType;Lcom/facebook/video/heroplayer/exocustom/ImfDataTrack$SegmentMetadata;)V", "StickerTrackType", "SegmentMetadata", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImfDataTrack {
    public static byte[] A05;
    public final long A00;
    public final long A01;
    public final C1735hc A02;
    public final C1736hd A03;
    public final String A04;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{72, 118, 64, 66, 72, 64, 75, 81, 104, 64, 81, 68, 65, 68, 81, 68, 92, 98, 69, 88, 82, 90, 84, 67, 101, 67, 80, 82, 90, 101, 72, 65, 84, 29, 36, 2, 17, 19, 27, 62, 17, 29, 21};
    }

    public ImfDataTrack(String str, long j, long j3, C1736hd c1736hd, C1735hc c1735hc) {
        C2168p6.A09(str, A00(33, 10, 89));
        C2168p6.A09(c1736hd, A00(16, 17, 24));
        C2168p6.A09(c1735hc, A00(0, 16, 12));
        this.A04 = str;
        this.A01 = j;
        this.A00 = j3;
        this.A03 = c1736hd;
        this.A02 = c1735hc;
    }
}

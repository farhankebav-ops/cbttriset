package androidx.camera.video.internal.encoder;

import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface VideoEncoderInfo extends EncoderInfo {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Finder {
        VideoEncoderInfo find(String str);
    }

    boolean canSwapWidthHeight();

    int getHeightAlignment();

    Range<Integer> getSupportedBitrateRange();

    Range<Integer> getSupportedHeights();

    Range<Integer> getSupportedHeightsFor(int i2);

    Range<Integer> getSupportedWidths();

    Range<Integer> getSupportedWidthsFor(int i2);

    int getWidthAlignment();

    boolean isSizeSupported(int i2, int i8);

    boolean isSizeSupportedAllowSwapping(int i2, int i8);
}

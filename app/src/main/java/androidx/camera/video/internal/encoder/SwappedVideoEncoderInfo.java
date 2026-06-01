package androidx.camera.video.internal.encoder;

import android.util.Range;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SwappedVideoEncoderInfo implements VideoEncoderInfo {
    private final VideoEncoderInfo mVideoEncoderInfo;

    public SwappedVideoEncoderInfo(VideoEncoderInfo videoEncoderInfo) {
        Preconditions.checkArgument(videoEncoderInfo.canSwapWidthHeight());
        this.mVideoEncoderInfo = videoEncoderInfo;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return this.mVideoEncoderInfo.canSwapWidthHeight();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.mVideoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoEncoderInfo.getSupportedBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.mVideoEncoderInfo.getSupportedWidths();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int i2) {
        return this.mVideoEncoderInfo.getSupportedWidthsFor(i2);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mVideoEncoderInfo.getSupportedHeights();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int i2) {
        return this.mVideoEncoderInfo.getSupportedHeightsFor(i2);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int i2, int i8) {
        return this.mVideoEncoderInfo.isSizeSupported(i8, i2);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int i2, int i8) {
        return o.a(this, i2, i8);
    }
}

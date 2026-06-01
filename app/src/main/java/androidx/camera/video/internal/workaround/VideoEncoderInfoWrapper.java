package androidx.camera.video.internal.workaround;

import a1.a;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.o;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class VideoEncoderInfoWrapper implements VideoEncoderInfo {
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Set<Size> mExtraSupportedSizes;
    private final Range<Integer> mSupportedHeights;
    private final Range<Integer> mSupportedWidths;
    private final VideoEncoderInfo mVideoEncoderInfo;

    private VideoEncoderInfoWrapper(VideoEncoderInfo videoEncoderInfo) {
        HashSet hashSet = new HashSet();
        this.mExtraSupportedSizes = hashSet;
        this.mVideoEncoderInfo = videoEncoderInfo;
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        this.mSupportedWidths = Range.create(Integer.valueOf(widthAlignment), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) widthAlignment))) * widthAlignment));
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        this.mSupportedHeights = Range.create(Integer.valueOf(heightAlignment), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) heightAlignment))) * heightAlignment));
        hashSet.addAll(MediaCodecInfoReportIncorrectInfoQuirk.getExtraSupportedSizes());
    }

    private void addExtraSupportedSize(Size size) {
        this.mExtraSupportedSizes.add(size);
    }

    public static VideoEncoderInfo from(VideoEncoderInfo videoEncoderInfo, Size size) {
        if (!(videoEncoderInfo instanceof VideoEncoderInfoWrapper)) {
            if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) != null) {
                videoEncoderInfo = new VideoEncoderInfoWrapper(videoEncoderInfo);
            } else if (size != null && !videoEncoderInfo.isSizeSupportedAllowSwapping(size.getWidth(), size.getHeight())) {
                Logger.w(TAG, "Detected that the device does not support a size " + size + " that should be valid in widths/heights = " + videoEncoderInfo.getSupportedWidths() + "/" + videoEncoderInfo.getSupportedHeights());
                videoEncoderInfo = new VideoEncoderInfoWrapper(videoEncoderInfo);
            }
        }
        if (size != null && (videoEncoderInfo instanceof VideoEncoderInfoWrapper)) {
            ((VideoEncoderInfoWrapper) videoEncoderInfo).addExtraSupportedSize(size);
        }
        return videoEncoderInfo;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return this.mVideoEncoderInfo.canSwapWidthHeight();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
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
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int i2) {
        boolean z2 = this.mSupportedWidths.contains(Integer.valueOf(i2)) && i2 % this.mVideoEncoderInfo.getWidthAlignment() == 0;
        StringBuilder sbV = a.v(i2, "Not supported width: ", " which is not in ");
        sbV.append(this.mSupportedWidths);
        sbV.append(" or can not be divided by alignment ");
        sbV.append(this.mVideoEncoderInfo.getWidthAlignment());
        Preconditions.checkArgument(z2, sbV.toString());
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mSupportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int i2) {
        boolean z2 = this.mSupportedHeights.contains(Integer.valueOf(i2)) && i2 % this.mVideoEncoderInfo.getHeightAlignment() == 0;
        StringBuilder sbV = a.v(i2, "Not supported height: ", " which is not in ");
        sbV.append(this.mSupportedHeights);
        sbV.append(" or can not be divided by alignment ");
        sbV.append(this.mVideoEncoderInfo.getHeightAlignment());
        Preconditions.checkArgument(z2, sbV.toString());
        return this.mSupportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int i2, int i8) {
        if (this.mVideoEncoderInfo.isSizeSupported(i2, i8)) {
            return true;
        }
        for (Size size : this.mExtraSupportedSizes) {
            if (size.getWidth() == i2 && size.getHeight() == i8) {
                return true;
            }
        }
        return this.mSupportedWidths.contains(Integer.valueOf(i2)) && this.mSupportedHeights.contains(Integer.valueOf(i8)) && i2 % this.mVideoEncoderInfo.getWidthAlignment() == 0 && i8 % this.mVideoEncoderInfo.getHeightAlignment() == 0;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int i2, int i8) {
        return o.a(this, i2, i8);
    }
}

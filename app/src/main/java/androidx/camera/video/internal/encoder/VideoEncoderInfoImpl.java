package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class VideoEncoderInfoImpl extends EncoderInfoImpl implements VideoEncoderInfo {
    public static final VideoEncoderInfo.Finder FINDER = new p();
    private static final String TAG = "VideoEncoderInfoImpl";
    private final MediaCodecInfo.VideoCapabilities mVideoCapabilities;

    public VideoEncoderInfoImpl(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.mCodecCapabilities.getVideoCapabilities();
        Objects.requireNonNull(videoCapabilities);
        this.mVideoCapabilities = videoCapabilities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VideoEncoderInfo lambda$static$0(String str) {
        try {
            return VideoEncoderInfoWrapper.from(new VideoEncoderInfoImpl(CodecUtil.findCodecAndGetCodecInfo(str), str), null);
        } catch (InvalidConfigException e) {
            Logger.w(TAG, "Unable to find a VideoEncoderInfoImpl", e);
            return null;
        }
    }

    private static IllegalArgumentException toIllegalArgumentException(Throwable th) {
        return th instanceof IllegalArgumentException ? (IllegalArgumentException) th : new IllegalArgumentException(th);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return true;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoCapabilities.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoCapabilities.getBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.mVideoCapabilities.getSupportedHeights();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int i2) {
        try {
            return this.mVideoCapabilities.getSupportedHeightsFor(i2);
        } catch (Throwable th) {
            throw toIllegalArgumentException(th);
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mVideoCapabilities.getSupportedWidths();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int i2) {
        try {
            return this.mVideoCapabilities.getSupportedWidthsFor(i2);
        } catch (Throwable th) {
            throw toIllegalArgumentException(th);
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoCapabilities.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int i2, int i8) {
        return this.mVideoCapabilities.isSizeSupported(i2, i8);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int i2, int i8) {
        return o.a(this, i2, i8);
    }
}

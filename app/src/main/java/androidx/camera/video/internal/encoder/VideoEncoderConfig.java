package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AutoValue_VideoEncoderConfig;
import com.google.android.gms.common.Scopes;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VideoEncoderConfig implements EncoderConfig {
    private static final int VIDEO_COLOR_FORMAT_DEFAULT = 2130708361;
    private static final int VIDEO_INTRA_FRAME_INTERVAL_DEFAULT = 1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        public abstract VideoEncoderConfig build();

        public abstract Builder setBitrate(int i2);

        public abstract Builder setCaptureFrameRate(int i2);

        public abstract Builder setColorFormat(int i2);

        public abstract Builder setDataSpace(VideoEncoderDataSpace videoEncoderDataSpace);

        public abstract Builder setEncodeFrameRate(int i2);

        public abstract Builder setIFrameInterval(int i2);

        public abstract Builder setInputTimebase(Timebase timebase);

        public abstract Builder setMimeType(String str);

        public abstract Builder setProfile(int i2);

        public abstract Builder setResolution(Size size);
    }

    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(-1).setIFrameInterval(1).setColorFormat(VIDEO_COLOR_FORMAT_DEFAULT).setDataSpace(VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED);
    }

    public abstract int getBitrate();

    public abstract int getCaptureFrameRate();

    public abstract int getColorFormat();

    public abstract VideoEncoderDataSpace getDataSpace();

    public abstract int getEncodeFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    public abstract Size getResolution();

    public abstract Builder toBuilder();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public MediaFormat toMediaFormat() {
        Size resolution = getResolution();
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(getMimeType(), resolution.getWidth(), resolution.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", getColorFormat());
        mediaFormatCreateVideoFormat.setInteger("bitrate", getBitrate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", getEncodeFrameRate());
        if (getEncodeFrameRate() != getCaptureFrameRate()) {
            mediaFormatCreateVideoFormat.setInteger("operating-rate", getCaptureFrameRate());
            mediaFormatCreateVideoFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        }
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() != -1) {
            mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, getProfile());
        }
        VideoEncoderDataSpace dataSpace = getDataSpace();
        if (dataSpace.getStandard() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-standard", dataSpace.getStandard());
        }
        if (dataSpace.getTransfer() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-transfer", dataSpace.getTransfer());
        }
        if (dataSpace.getRange() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-range", dataSpace.getRange());
        }
        return mediaFormatCreateVideoFormat;
    }
}

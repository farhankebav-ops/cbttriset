package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EncoderInfoImpl implements EncoderInfo {
    protected final MediaCodecInfo.CodecCapabilities mCodecCapabilities;
    private final MediaCodecInfo mMediaCodecInfo;

    public EncoderInfoImpl(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        this.mMediaCodecInfo = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Objects.requireNonNull(capabilitiesForType);
            this.mCodecCapabilities = capabilitiesForType;
        } catch (RuntimeException e) {
            throw new InvalidConfigException(a1.a.l("Unable to get CodecCapabilities for mime: ", str), e);
        }
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.mMediaCodecInfo.getName();
    }
}

package androidx.camera.video.internal.utils;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class EncoderProfilesUtil {
    private EncoderProfilesUtil() {
    }

    public static EncoderProfilesProxy.VideoProfileProxy deriveVideoProfile(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, Size size, Range<Integer> range) {
        return EncoderProfilesProxy.VideoProfileProxy.create(videoProfileProxy.getCodec(), videoProfileProxy.getMediaType(), VideoConfigUtil.scaleAndClampBitrate(videoProfileProxy.getBitrate(), videoProfileProxy.getBitDepth(), videoProfileProxy.getBitDepth(), videoProfileProxy.getFrameRate(), videoProfileProxy.getFrameRate(), size.getWidth(), videoProfileProxy.getWidth(), size.getHeight(), videoProfileProxy.getHeight(), range), videoProfileProxy.getFrameRate(), size.getWidth(), size.getHeight(), videoProfileProxy.getProfile(), videoProfileProxy.getBitDepth(), videoProfileProxy.getChromaSubsampling(), videoProfileProxy.getHdrFormat());
    }

    public static EncoderProfilesProxy.VideoProfileProxy getFirstVideoProfile(EncoderProfilesProxy encoderProfilesProxy) {
        if (encoderProfilesProxy == null || encoderProfilesProxy.getVideoProfiles().isEmpty()) {
            return null;
        }
        return encoderProfilesProxy.getVideoProfiles().get(0);
    }
}

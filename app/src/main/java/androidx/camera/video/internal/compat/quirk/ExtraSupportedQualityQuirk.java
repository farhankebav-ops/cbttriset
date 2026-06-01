package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.EncoderProfilesUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ExtraSupportedQualityQuirk implements Quirk {
    private static final String MOTO_C_FRONT_CAM_ID = "1";

    private Map<Integer, EncoderProfilesProxy> getExtraEncoderProfilesForMotoC(CameraInfoInternal cameraInfoInternal, EncoderProfilesProvider encoderProfilesProvider, VideoEncoderInfo.Finder finder) {
        EncoderProfilesProxy all;
        EncoderProfilesProxy.VideoProfileProxy firstVideoProfile;
        if (!"1".equals(cameraInfoInternal.getCameraId()) || encoderProfilesProvider.hasProfile(4) || (firstVideoProfile = EncoderProfilesUtil.getFirstVideoProfile((all = encoderProfilesProvider.getAll(1)))) == null) {
            return null;
        }
        Range<Integer> supportedBitrateRange = getSupportedBitrateRange(firstVideoProfile, finder);
        Size size = SizeUtil.RESOLUTION_480P;
        EncoderProfilesProxy.ImmutableEncoderProfilesProxy immutableEncoderProfilesProxyCreate = EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(all.getDefaultDurationSeconds(), all.getRecommendedFileFormat(), all.getAudioProfiles(), Collections.singletonList(EncoderProfilesUtil.deriveVideoProfile(firstVideoProfile, size, supportedBitrateRange)));
        HashMap map = new HashMap();
        map.put(4, immutableEncoderProfilesProxyCreate);
        if (SizeUtil.getArea(size) > SizeUtil.getArea(firstVideoProfile.getResolution())) {
            map.put(1, immutableEncoderProfilesProxyCreate);
        }
        return map;
    }

    private static Range<Integer> getSupportedBitrateRange(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, VideoEncoderInfo.Finder finder) {
        VideoEncoderInfo videoEncoderInfoFind = finder.find(videoProfileProxy.getMediaType());
        return videoEncoderInfoFind != null ? videoEncoderInfoFind.getSupportedBitrateRange() : VideoSpec.BITRATE_RANGE_AUTO;
    }

    private static boolean isMotoC() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isMotoC();
    }

    public Map<Integer, EncoderProfilesProxy> getExtraEncoderProfiles(CameraInfoInternal cameraInfoInternal, EncoderProfilesProvider encoderProfilesProvider, VideoEncoderInfo.Finder finder) {
        return isMotoC() ? getExtraEncoderProfilesForMotoC(cameraInfoInternal, encoderProfilesProvider, finder) : Collections.EMPTY_MAP;
    }
}

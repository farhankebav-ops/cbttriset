package androidx.camera.video.internal.workaround;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class QualityValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final Map<Integer, Quality> CAMCORDER_TO_VIDEO_QUALITY_MAP;
    private final CameraInfoInternal mCameraInfo;
    private final EncoderProfilesProvider mProvider;
    private final Quirks mQuirks;

    static {
        HashMap map = new HashMap();
        CAMCORDER_TO_VIDEO_QUALITY_MAP = map;
        map.put(1, Quality.HIGHEST);
        map.put(8, Quality.UHD);
        map.put(6, Quality.FHD);
        map.put(5, Quality.HD);
        map.put(4, Quality.SD);
        map.put(0, Quality.LOWEST);
    }

    public QualityValidatedEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, CameraInfoInternal cameraInfoInternal, Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mCameraInfo = cameraInfoInternal;
        this.mQuirks = quirks;
    }

    private boolean isDeviceValidQuality(int i2) {
        Quality quality = CAMCORDER_TO_VIDEO_QUALITY_MAP.get(Integer.valueOf(i2));
        if (quality == null) {
            return true;
        }
        for (VideoQualityQuirk videoQualityQuirk : this.mQuirks.getAll(VideoQualityQuirk.class)) {
            if (videoQualityQuirk != null && videoQualityQuirk.isProblematicVideoQuality(this.mCameraInfo, quality) && !workaroundBySurfaceProcessing(videoQualityQuirk)) {
                return false;
            }
        }
        return true;
    }

    private static boolean workaroundBySurfaceProcessing(Quirk quirk) {
        return (quirk instanceof SurfaceProcessingQuirk) && ((SurfaceProcessingQuirk) quirk).workaroundBySurfaceProcessing();
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int i2) {
        if (hasProfile(i2)) {
            return this.mProvider.getAll(i2);
        }
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i2) {
        return this.mProvider.hasProfile(i2) && isDeviceValidQuality(i2);
    }
}

package androidx.camera.video.internal.workaround;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.compat.quirk.ExtraSupportedQualityQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class QualityAddedEncoderProfilesProvider implements EncoderProfilesProvider {
    private Map<Integer, EncoderProfilesProxy> mExtraQualityToEncoderProfiles;
    private final EncoderProfilesProvider mProvider;

    public QualityAddedEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, Quirks quirks, CameraInfoInternal cameraInfoInternal, VideoEncoderInfo.Finder finder) {
        this.mProvider = encoderProfilesProvider;
        List all = quirks.getAll(ExtraSupportedQualityQuirk.class);
        if (all.isEmpty()) {
            return;
        }
        Preconditions.checkState(all.size() == 1);
        Map<Integer, EncoderProfilesProxy> extraEncoderProfiles = ((ExtraSupportedQualityQuirk) all.get(0)).getExtraEncoderProfiles(cameraInfoInternal, encoderProfilesProvider, finder);
        if (extraEncoderProfiles != null) {
            this.mExtraQualityToEncoderProfiles = new HashMap(extraEncoderProfiles);
        }
    }

    private EncoderProfilesProxy getProfilesInternal(int i2) {
        Map<Integer, EncoderProfilesProxy> map = this.mExtraQualityToEncoderProfiles;
        return (map == null || !map.containsKey(Integer.valueOf(i2))) ? this.mProvider.getAll(i2) : this.mExtraQualityToEncoderProfiles.get(Integer.valueOf(i2));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int i2) {
        return getProfilesInternal(i2);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i2) {
        return getProfilesInternal(i2) != null;
    }
}

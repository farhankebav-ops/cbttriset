package androidx.camera.video.internal;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class DynamicRangeMatchedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final DynamicRange mDynamicRange;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final EncoderProfilesProvider mEncoderProfilesProvider;

    public DynamicRangeMatchedEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, DynamicRange dynamicRange) {
        this.mEncoderProfilesProvider = encoderProfilesProvider;
        this.mDynamicRange = dynamicRange;
    }

    private static EncoderProfilesProxy filterUnmatchedDynamicRange(EncoderProfilesProxy encoderProfilesProxy, DynamicRange dynamicRange) {
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : encoderProfilesProxy.getVideoProfiles()) {
            if (DynamicRangeUtil.isHdrSettingsMatched(videoProfileProxy, dynamicRange)) {
                arrayList.add(videoProfileProxy);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    private EncoderProfilesProxy getProfilesInternal(int i2) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i2))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i2));
        }
        if (!this.mEncoderProfilesProvider.hasProfile(i2)) {
            return null;
        }
        EncoderProfilesProxy encoderProfilesProxyFilterUnmatchedDynamicRange = filterUnmatchedDynamicRange(this.mEncoderProfilesProvider.getAll(i2), this.mDynamicRange);
        this.mEncoderProfilesCache.put(Integer.valueOf(i2), encoderProfilesProxyFilterUnmatchedDynamicRange);
        return encoderProfilesProxyFilterUnmatchedDynamicRange;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int i2) {
        return getProfilesInternal(i2);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i2) {
        return this.mEncoderProfilesProvider.hasProfile(i2) && getProfilesInternal(i2) != null;
    }
}

package androidx.camera.video.internal;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.CapabilitiesByQuality;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.camera.video.internal.utils.EncoderProfilesUtil;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class QualityExploredEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesProvider mBaseEncoderProfilesProvider;
    private final Set<Size> mCameraSupportedResolutions;
    private final Set<DynamicRange> mTargetDynamicRanges;
    private final Set<Quality> mTargetQualities;
    private final VideoEncoderInfo.Finder mVideoEncoderInfoFinder;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final Map<DynamicRange, CapabilitiesByQuality> mDynamicRangeToCapabilitiesMap = new HashMap();

    public QualityExploredEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, Collection<Quality> collection, Collection<DynamicRange> collection2, Collection<Size> collection3, VideoEncoderInfo.Finder finder) {
        checkFullySpecifiedOrThrow(collection2);
        this.mBaseEncoderProfilesProvider = encoderProfilesProvider;
        this.mTargetQualities = new HashSet(collection);
        this.mTargetDynamicRanges = new HashSet(collection2);
        this.mCameraSupportedResolutions = new HashSet(collection3);
        this.mVideoEncoderInfoFinder = finder;
    }

    private static void checkFullySpecifiedOrThrow(Collection<DynamicRange> collection) {
        for (DynamicRange dynamicRange : collection) {
            if (!dynamicRange.isFullySpecified()) {
                throw new IllegalArgumentException("Contains non-fully specified DynamicRange: " + dynamicRange);
            }
        }
    }

    private EncoderProfilesProxy exploreProfiles(Quality.ConstantQuality constantQuality) {
        VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor;
        Preconditions.checkArgument(this.mTargetQualities.contains(constantQuality));
        EncoderProfilesProxy all = this.mBaseEncoderProfilesProvider.getAll(constantQuality.getQualityValue(1));
        for (Size size : constantQuality.getTypicalSizes()) {
            if (this.mCameraSupportedResolutions.contains(size)) {
                TreeMap treeMap = new TreeMap(new CompareSizesByArea());
                ArrayList arrayList = new ArrayList();
                for (DynamicRange dynamicRange : this.mTargetDynamicRanges) {
                    if (!hasMatchedVideoProfileForDynamicRange(all, dynamicRange) && (videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor = getCapabilitiesByQualityFor(dynamicRange).findNearestHigherSupportedEncoderProfilesFor(size)) != null) {
                        EncoderProfilesProxy.VideoProfileProxy defaultVideoProfile = videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor.getDefaultVideoProfile();
                        VideoEncoderInfo videoEncoderInfoFind = this.mVideoEncoderInfoFinder.find(defaultVideoProfile.getMediaType());
                        if (videoEncoderInfoFind != null && videoEncoderInfoFind.isSizeSupportedAllowSwapping(size.getWidth(), size.getHeight())) {
                            treeMap.put(defaultVideoProfile.getResolution(), videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor);
                            arrayList.add(EncoderProfilesUtil.deriveVideoProfile(defaultVideoProfile, size, videoEncoderInfoFind.getSupportedBitrateRange()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    EncoderProfilesProxy encoderProfilesProxy = (EncoderProfilesProxy) SizeUtil.findNearestHigherFor(size, treeMap);
                    Objects.requireNonNull(encoderProfilesProxy);
                    return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
                }
            }
        }
        return null;
    }

    private Quality.ConstantQuality findQualityInTargetQualities(int i2) {
        Iterator<Quality> it = this.mTargetQualities.iterator();
        while (it.hasNext()) {
            Quality.ConstantQuality constantQuality = (Quality.ConstantQuality) it.next();
            if (constantQuality.getQualityValue(1) == i2) {
                return constantQuality;
            }
        }
        return null;
    }

    private CapabilitiesByQuality getCapabilitiesByQualityFor(DynamicRange dynamicRange) {
        if (this.mDynamicRangeToCapabilitiesMap.containsKey(dynamicRange)) {
            CapabilitiesByQuality capabilitiesByQuality = this.mDynamicRangeToCapabilitiesMap.get(dynamicRange);
            Objects.requireNonNull(capabilitiesByQuality);
            return capabilitiesByQuality;
        }
        CapabilitiesByQuality capabilitiesByQuality2 = new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mBaseEncoderProfilesProvider, dynamicRange), 1);
        this.mDynamicRangeToCapabilitiesMap.put(dynamicRange, capabilitiesByQuality2);
        return capabilitiesByQuality2;
    }

    private EncoderProfilesProxy getProfilesInternal(int i2) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i2))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i2));
        }
        EncoderProfilesProxy all = this.mBaseEncoderProfilesProvider.getAll(i2);
        Quality.ConstantQuality constantQualityFindQualityInTargetQualities = findQualityInTargetQualities(i2);
        if (constantQualityFindQualityInTargetQualities != null && !hasMatchedVideoProfileForAllTargetDynamicRanges(all)) {
            all = mergeEncoderProfiles(all, exploreProfiles(constantQualityFindQualityInTargetQualities));
        }
        this.mEncoderProfilesCache.put(Integer.valueOf(i2), all);
        return all;
    }

    private boolean hasMatchedVideoProfileForAllTargetDynamicRanges(EncoderProfilesProxy encoderProfilesProxy) {
        if (encoderProfilesProxy == null) {
            return false;
        }
        Iterator<DynamicRange> it = this.mTargetDynamicRanges.iterator();
        while (it.hasNext()) {
            if (!hasMatchedVideoProfileForDynamicRange(encoderProfilesProxy, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasMatchedVideoProfileForDynamicRange(EncoderProfilesProxy encoderProfilesProxy, DynamicRange dynamicRange) {
        if (encoderProfilesProxy == null) {
            return false;
        }
        Iterator<EncoderProfilesProxy.VideoProfileProxy> it = encoderProfilesProxy.getVideoProfiles().iterator();
        while (it.hasNext()) {
            if (DynamicRangeUtil.isHdrSettingsMatched(it.next(), dynamicRange)) {
                return true;
            }
        }
        return false;
    }

    private static EncoderProfilesProxy mergeEncoderProfiles(EncoderProfilesProxy encoderProfilesProxy, EncoderProfilesProxy encoderProfilesProxy2) {
        if (encoderProfilesProxy == null && encoderProfilesProxy2 == null) {
            return null;
        }
        int defaultDurationSeconds = encoderProfilesProxy != null ? encoderProfilesProxy.getDefaultDurationSeconds() : encoderProfilesProxy2.getDefaultDurationSeconds();
        int recommendedFileFormat = encoderProfilesProxy != null ? encoderProfilesProxy.getRecommendedFileFormat() : encoderProfilesProxy2.getRecommendedFileFormat();
        List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles = encoderProfilesProxy != null ? encoderProfilesProxy.getAudioProfiles() : encoderProfilesProxy2.getAudioProfiles();
        ArrayList arrayList = new ArrayList();
        if (encoderProfilesProxy != null) {
            arrayList.addAll(encoderProfilesProxy.getVideoProfiles());
        }
        if (encoderProfilesProxy2 != null) {
            arrayList.addAll(encoderProfilesProxy2.getVideoProfiles());
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(defaultDurationSeconds, recommendedFileFormat, audioProfiles, arrayList);
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

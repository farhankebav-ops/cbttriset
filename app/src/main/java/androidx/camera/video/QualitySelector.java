package androidx.camera.video;

import android.util.Size;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class QualitySelector {
    private static final String TAG = "QualitySelector";
    private final FallbackStrategy mFallbackStrategy;
    private final List<Quality> mPreferredQualityList;

    public QualitySelector(List<Quality> list, FallbackStrategy fallbackStrategy) {
        Preconditions.checkArgument((list.isEmpty() && fallbackStrategy == FallbackStrategy.NONE) ? false : true, "No preferred quality and fallback strategy.");
        this.mPreferredQualityList = Collections.unmodifiableList(new ArrayList(list));
        this.mFallbackStrategy = fallbackStrategy;
    }

    private void addByFallbackStrategy(List<Quality> list, Set<Quality> set) {
        if (list.isEmpty() || set.containsAll(list)) {
            return;
        }
        Logger.d(TAG, "Select quality by fallbackStrategy = " + this.mFallbackStrategy);
        FallbackStrategy fallbackStrategy = this.mFallbackStrategy;
        if (fallbackStrategy == FallbackStrategy.NONE) {
            return;
        }
        Preconditions.checkState(fallbackStrategy instanceof FallbackStrategy.RuleStrategy, "Currently only support type RuleStrategy");
        FallbackStrategy.RuleStrategy ruleStrategy = (FallbackStrategy.RuleStrategy) this.mFallbackStrategy;
        List<Quality> sortedQualities = Quality.getSortedQualities();
        Quality fallbackQuality = ruleStrategy.getFallbackQuality() == Quality.HIGHEST ? sortedQualities.get(0) : ruleStrategy.getFallbackQuality() == Quality.LOWEST ? sortedQualities.get(sortedQualities.size() - 1) : ruleStrategy.getFallbackQuality();
        int iIndexOf = sortedQualities.indexOf(fallbackQuality);
        Preconditions.checkState(iIndexOf != -1);
        ArrayList arrayList = new ArrayList();
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Quality quality = sortedQualities.get(i2);
            if (list.contains(quality)) {
                arrayList.add(quality);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i8 = iIndexOf + 1; i8 < sortedQualities.size(); i8++) {
            Quality quality2 = sortedQualities.get(i8);
            if (list.contains(quality2)) {
                arrayList2.add(quality2);
            }
        }
        Logger.d(TAG, "sizeSortedQualities = " + sortedQualities + ", fallback quality = " + fallbackQuality + ", largerQualities = " + arrayList + ", smallerQualities = " + arrayList2);
        int fallbackRule = ruleStrategy.getFallbackRule();
        if (fallbackRule != 0) {
            if (fallbackRule == 1) {
                set.addAll(arrayList);
                set.addAll(arrayList2);
                return;
            }
            if (fallbackRule == 2) {
                set.addAll(arrayList);
                return;
            }
            if (fallbackRule == 3) {
                set.addAll(arrayList2);
                set.addAll(arrayList);
            } else {
                if (fallbackRule != 4) {
                    throw new AssertionError("Unhandled fallback strategy: " + this.mFallbackStrategy);
                }
                set.addAll(arrayList2);
            }
        }
    }

    private static void checkQualityConstantsOrThrow(List<Quality> list) {
        for (Quality quality : list) {
            Preconditions.checkArgument(Quality.containsQuality(quality), "qualities contain invalid quality: " + quality);
        }
    }

    public static QualitySelector from(Quality quality) {
        return from(quality, FallbackStrategy.NONE);
    }

    public static QualitySelector fromOrderedList(List<Quality> list) {
        return fromOrderedList(list, FallbackStrategy.NONE);
    }

    private static Size getProfileVideoSize(VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        return videoValidatedEncoderProfilesProxy.getDefaultVideoProfile().getResolution();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Map<Quality, Size> getQualityToResolutionMap(VideoCapabilities videoCapabilities, DynamicRange dynamicRange) {
        HashMap map = new HashMap();
        for (Quality quality : videoCapabilities.getSupportedQualities(dynamicRange)) {
            VideoValidatedEncoderProfilesProxy profiles = videoCapabilities.getProfiles(quality, dynamicRange);
            Objects.requireNonNull(profiles);
            map.put(quality, getProfileVideoSize(profiles));
        }
        return map;
    }

    public static Size getResolution(CameraInfo cameraInfo, Quality quality) {
        checkQualityConstantsOrThrow(quality);
        VideoValidatedEncoderProfilesProxy profiles = Recorder.getVideoCapabilities(cameraInfo).getProfiles(quality, DynamicRange.SDR);
        if (profiles != null) {
            return getProfileVideoSize(profiles);
        }
        return null;
    }

    @Deprecated
    public static List<Quality> getSupportedQualities(CameraInfo cameraInfo) {
        return Recorder.getVideoCapabilities(cameraInfo).getSupportedQualities(DynamicRange.SDR);
    }

    @Deprecated
    public static boolean isQualitySupported(CameraInfo cameraInfo, Quality quality) {
        return Recorder.getVideoCapabilities(cameraInfo).isQualitySupported(quality, DynamicRange.SDR);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting(otherwise = 3)
    public List<Quality> getPrioritizedQualities(List<Quality> list) {
        if (list.isEmpty()) {
            Logger.w(TAG, "No supported quality on the device.");
            return new ArrayList();
        }
        Logger.d(TAG, "supportedQualities = " + list);
        Set<Quality> linkedHashSet = new LinkedHashSet<>();
        Iterator<Quality> it = this.mPreferredQualityList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Quality next = it.next();
            if (next == Quality.HIGHEST) {
                linkedHashSet.addAll(list);
                break;
            }
            if (next == Quality.LOWEST) {
                ArrayList arrayList = new ArrayList(list);
                Collections.reverse(arrayList);
                linkedHashSet.addAll(arrayList);
                break;
            }
            if (list.contains(next)) {
                linkedHashSet.add(next);
            } else {
                Logger.w(TAG, "quality is not supported and will be ignored: " + next);
            }
        }
        addByFallbackStrategy(list, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public String toString() {
        return "QualitySelector{preferredQualities=" + this.mPreferredQualityList + ", fallbackStrategy=" + this.mFallbackStrategy + "}";
    }

    public static QualitySelector from(Quality quality, FallbackStrategy fallbackStrategy) {
        Preconditions.checkNotNull(quality, "quality cannot be null");
        Preconditions.checkNotNull(fallbackStrategy, "fallbackStrategy cannot be null");
        checkQualityConstantsOrThrow(quality);
        return new QualitySelector(Collections.singletonList(quality), fallbackStrategy);
    }

    public static QualitySelector fromOrderedList(List<Quality> list, FallbackStrategy fallbackStrategy) {
        Preconditions.checkNotNull(list, "qualities cannot be null");
        Preconditions.checkNotNull(fallbackStrategy, "fallbackStrategy cannot be null");
        Preconditions.checkArgument(!list.isEmpty(), "qualities cannot be empty");
        checkQualityConstantsOrThrow(list);
        return new QualitySelector(list, fallbackStrategy);
    }

    private static void checkQualityConstantsOrThrow(Quality quality) {
        Preconditions.checkArgument(Quality.containsQuality(quality), "Invalid quality: " + quality);
    }
}

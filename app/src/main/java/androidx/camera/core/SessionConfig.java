package androidx.camera.core;

import android.util.Range;
import androidx.annotation.RestrictTo;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.UseCaseType;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalSessionConfig
public class SessionConfig {
    private final List<CameraEffect> effects;
    private Consumer<Set<GroupableFeature>> featureSelectionListener;
    private Executor featureSelectionListenerExecutor;
    private final Range<Integer> frameRateRange;
    private final boolean isLegacy;
    private final List<GroupableFeature> preferredFeatureGroup;
    private final Set<GroupableFeature> requiredFeatureGroup;
    private final int sessionType;
    private final List<UseCase> useCases;
    private final ViewPort viewPort;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeatureTypeInternal.values().length];
            try {
                iArr[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureTypeInternal.FPS_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionConfig(List<? extends UseCase> useCases) {
        this(useCases, null, null, null, null, null, 62, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
    }

    private final String getUseCaseName(UseCase useCase) {
        return useCase instanceof Preview ? "Preview" : useCase instanceof ImageCapture ? "ImageCapture" : useCase instanceof ImageAnalysis ? "ImageAnalysis" : CameraUseCaseAdapter.isVideoCapture(useCase) ? "VideoCapture" : "UseCase";
    }

    public static /* synthetic */ void setFeatureSelectionListener$default(SessionConfig sessionConfig, Executor executor, Consumer consumer, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFeatureSelectionListener");
        }
        if ((i2 & 1) != 0) {
            executor = CameraXExecutors.mainThreadExecutor();
        }
        sessionConfig.setFeatureSelectionListener(executor, consumer);
    }

    private final void validateDefaultGroupableFeatureValues(UseCase useCase) {
        String str;
        String str2;
        String str3;
        String useCaseName = getUseCaseName(useCase);
        FeatureTypeInternal appConfiguredGroupableFeatureType$camera_core_release = UseCaseType.Companion.getAppConfiguredGroupableFeatureType$camera_core_release(useCase);
        if (appConfiguredGroupableFeatureType$camera_core_release == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("A ");
        kotlin.jvm.internal.k.b(appConfiguredGroupableFeatureType$camera_core_release);
        sb.append(appConfiguredGroupableFeatureType$camera_core_release.name());
        sb.append(" value is set to ");
        sb.append(useCaseName);
        sb.append(" despite using feature groups. Do not use APIs like ");
        sb.append(useCaseName);
        sb.append(".Builder.");
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i2 = iArr[appConfiguredGroupableFeatureType$camera_core_release.ordinal()];
        if (i2 == 1) {
            str = "setDynamicRange";
        } else if (i2 == 2) {
            str = "setTargetFrameRateRange";
        } else if (i2 == 3) {
            str = CameraUseCaseAdapter.isVideoCapture(useCase) ? "setVideoStabilizationEnabled" : "setPreviewStabilizationEnabled";
        } else {
            if (i2 != 4) {
                throw new e2.s(3);
            }
            str = "setOutputFormat";
        }
        sb.append(str);
        sb.append(" while using feature groups. If ");
        int i8 = iArr[appConfiguredGroupableFeatureType$camera_core_release.ordinal()];
        if (i8 == 1) {
            str2 = "HDR";
        } else if (i8 == 2) {
            str2 = "60 FPS";
        } else if (i8 == 3) {
            str2 = "stabilization";
        } else {
            if (i8 != 4) {
                throw new e2.s(3);
            }
            str2 = "JPEG_R output format";
        }
        sb.append(str2);
        sb.append(" is required, instead set ");
        int i9 = iArr[appConfiguredGroupableFeatureType$camera_core_release.ordinal()];
        if (i9 == 1) {
            str3 = "GroupableFeature.HDR_HLG10";
        } else if (i9 == 2) {
            str3 = "GroupableFeature.FPS_60";
        } else if (i9 == 3) {
            str3 = "GroupableFeature.PREVIEW_STABILIZATION";
        } else {
            if (i9 != 4) {
                throw new e2.s(3);
            }
            str3 = "GroupableFeature.IMAGE_ULTRA_HDR";
        }
        throw new IllegalArgumentException(a1.a.r(sb, str3, " as either a required or preferred feature.").toString());
    }

    private final void validateFeatureGroups() {
        if (this.requiredFeatureGroup.isEmpty() && this.preferredFeatureGroup.isEmpty()) {
            return;
        }
        validateRequiredFeatures();
        if (r5.l.U0(this.preferredFeatureGroup).size() != this.preferredFeatureGroup.size()) {
            throw new IllegalArgumentException(("Duplicate values in preferredFeatures(" + this.preferredFeatureGroup + ')').toString());
        }
        Set<GroupableFeature> set = this.requiredFeatureGroup;
        List<GroupableFeature> other = this.preferredFeatureGroup;
        kotlin.jvm.internal.k.e(set, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        Set setQ1 = r5.l.q1(set);
        setQ1.retainAll(other);
        if (!setQ1.isEmpty()) {
            throw new IllegalArgumentException(("requiredFeatures and preferredFeatures have duplicate values: " + setQ1).toString());
        }
        for (UseCase useCase : this.useCases) {
            if (UseCaseType.Companion.getFeatureGroupUseCaseType(useCase) == UseCaseType.UNDEFINED) {
                throw new IllegalArgumentException((useCase + " is not supported with feature group").toString());
            }
            validateDefaultGroupableFeatureValues(useCase);
        }
        if (!this.effects.isEmpty()) {
            throw new IllegalArgumentException("Effects aren't supported with feature group yet");
        }
    }

    private final void validateFrameRate() {
        if (kotlin.jvm.internal.k.a(this.frameRateRange, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            return;
        }
        Iterator<UseCase> it = this.useCases.iterator();
        while (it.hasNext()) {
            if (it.next().getAppConfig().hasTargetFrameRate()) {
                throw new IllegalArgumentException("Can't set target frame rate on a UseCase (by Preview.Builder.setTargetFrameRate() or VideoCapture.Builder.setTargetFrameRate()) if the frame rate range has already been set in the SessionConfig.");
            }
        }
    }

    private final void validateRequiredFeatures() {
        Set<GroupableFeature> set = this.requiredFeatureGroup;
        ArrayList arrayList = new ArrayList(r5.n.L0(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((GroupableFeature) it.next()).getFeatureTypeInternal$camera_core_release());
        }
        for (FeatureTypeInternal featureTypeInternal : r5.l.U0(arrayList)) {
            Set<GroupableFeature> set2 = this.requiredFeatureGroup;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : set2) {
                if (((GroupableFeature) obj).getFeatureTypeInternal$camera_core_release() == featureTypeInternal) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() > 1) {
                throw new IllegalArgumentException(("requiredFeatures has conflicting feature values: " + arrayList2).toString());
            }
        }
    }

    public final List<CameraEffect> getEffects() {
        return this.effects;
    }

    public final Consumer<Set<GroupableFeature>> getFeatureSelectionListener() {
        return this.featureSelectionListener;
    }

    public final Executor getFeatureSelectionListenerExecutor() {
        return this.featureSelectionListenerExecutor;
    }

    public final Range<Integer> getFrameRateRange() {
        return this.frameRateRange;
    }

    public final List<GroupableFeature> getPreferredFeatureGroup() {
        return this.preferredFeatureGroup;
    }

    public final Set<GroupableFeature> getRequiredFeatureGroup() {
        return this.requiredFeatureGroup;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getSessionType() {
        return this.sessionType;
    }

    public final List<UseCase> getUseCases() {
        return this.useCases;
    }

    public final ViewPort getViewPort() {
        return this.viewPort;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isLegacy() {
        return this.isLegacy;
    }

    public final void setFeatureSelectionListener(Consumer<Set<GroupableFeature>> listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        setFeatureSelectionListener$default(this, null, listener, 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionConfig(List<? extends UseCase> useCases, ViewPort viewPort) {
        this(useCases, viewPort, null, null, null, null, 60, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
    }

    public final void setFeatureSelectionListener(Executor executor, Consumer<Set<GroupableFeature>> listener) {
        kotlin.jvm.internal.k.e(executor, "executor");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.featureSelectionListener = listener;
        this.featureSelectionListenerExecutor = executor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionConfig(List<? extends UseCase> useCases, ViewPort viewPort, List<? extends CameraEffect> effects) {
        this(useCases, viewPort, effects, null, null, null, 56, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
        kotlin.jvm.internal.k.e(effects, "effects");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionConfig(List<? extends UseCase> useCases, ViewPort viewPort, List<? extends CameraEffect> effects, Range<Integer> frameRateRange) {
        this(useCases, viewPort, effects, frameRateRange, null, null, 48, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
        kotlin.jvm.internal.k.e(effects, "effects");
        kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ExperimentalSessionConfig
    public static final class Builder {
        private List<CameraEffect> effects;
        private Range<Integer> frameRateRange;
        private final List<GroupableFeature> preferredFeatureGroup;
        private final List<GroupableFeature> requiredFeatureGroup;
        private final List<UseCase> useCases;
        private ViewPort viewPort;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(List<? extends UseCase> useCases) {
            kotlin.jvm.internal.k.e(useCases, "useCases");
            this.useCases = useCases;
            this.effects = new ArrayList();
            Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            kotlin.jvm.internal.k.d(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
            this.frameRateRange = FRAME_RATE_RANGE_UNSPECIFIED;
            this.requiredFeatureGroup = new ArrayList();
            this.preferredFeatureGroup = new ArrayList();
        }

        public final Builder addEffect(CameraEffect effect) {
            kotlin.jvm.internal.k.e(effect, "effect");
            this.effects.add(effect);
            return this;
        }

        public final SessionConfig build() {
            return new SessionConfig(this.useCases, this.viewPort, r5.l.n1(this.effects), this.frameRateRange, r5.l.r1(this.requiredFeatureGroup), r5.l.n1(this.preferredFeatureGroup));
        }

        public final Builder setFrameRateRange(Range<Integer> frameRateRange) {
            kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
            this.frameRateRange = frameRateRange;
            return this;
        }

        public final Builder setPreferredFeatureGroup(GroupableFeature... features) {
            kotlin.jvm.internal.k.e(features, "features");
            this.preferredFeatureGroup.clear();
            r5.l.R0(this.preferredFeatureGroup, features);
            return this;
        }

        public final Builder setRequiredFeatureGroup(GroupableFeature... features) {
            kotlin.jvm.internal.k.e(features, "features");
            this.requiredFeatureGroup.clear();
            r5.l.R0(this.requiredFeatureGroup, features);
            return this;
        }

        public final Builder setViewPort(ViewPort viewPort) {
            kotlin.jvm.internal.k.e(viewPort, "viewPort");
            this.viewPort = viewPort;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(UseCase... useCases) {
            this((List<? extends UseCase>) r5.j.s0(useCases));
            kotlin.jvm.internal.k.e(useCases, "useCases");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionConfig(List<? extends UseCase> useCases, ViewPort viewPort, List<? extends CameraEffect> effects, Range<Integer> frameRateRange, Set<? extends GroupableFeature> requiredFeatureGroup) {
        this(useCases, viewPort, effects, frameRateRange, requiredFeatureGroup, null, 32, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
        kotlin.jvm.internal.k.e(effects, "effects");
        kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
        kotlin.jvm.internal.k.e(requiredFeatureGroup, "requiredFeatureGroup");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SessionConfig(List<? extends UseCase> useCases, ViewPort viewPort, List<? extends CameraEffect> effects, Range<Integer> frameRateRange, Set<? extends GroupableFeature> requiredFeatureGroup, List<? extends GroupableFeature> preferredFeatureGroup) {
        kotlin.jvm.internal.k.e(useCases, "useCases");
        kotlin.jvm.internal.k.e(effects, "effects");
        kotlin.jvm.internal.k.e(frameRateRange, "frameRateRange");
        kotlin.jvm.internal.k.e(requiredFeatureGroup, "requiredFeatureGroup");
        kotlin.jvm.internal.k.e(preferredFeatureGroup, "preferredFeatureGroup");
        this.viewPort = viewPort;
        this.effects = effects;
        this.frameRateRange = frameRateRange;
        this.requiredFeatureGroup = requiredFeatureGroup;
        this.preferredFeatureGroup = preferredFeatureGroup;
        this.useCases = r5.l.U0(useCases);
        this.featureSelectionListener = new androidx.camera.camera2.internal.compat.quirk.b(1);
        ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        kotlin.jvm.internal.k.d(scheduledExecutorServiceMainThreadExecutor, "mainThreadExecutor(...)");
        this.featureSelectionListenerExecutor = scheduledExecutorServiceMainThreadExecutor;
        validateFrameRate();
        validateFeatureGroups();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SessionConfig(List list, ViewPort viewPort, List list2, Range range, Set set, List list3, int i2, kotlin.jvm.internal.f fVar) {
        ViewPort viewPort2 = (i2 & 2) != 0 ? null : viewPort;
        int i8 = i2 & 4;
        r rVar = r.f13638a;
        this(list, viewPort2, i8 != 0 ? rVar : list2, (i2 & 8) != 0 ? StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED : range, (i2 & 16) != 0 ? r5.t.f13640a : set, (i2 & 32) != 0 ? rVar : list3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionConfig(UseCase... useCases) {
        this(r5.j.s0(useCases), null, null, null, null, null, 62, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void featureSelectionListener$lambda$0(Set set) {
    }
}

package androidx.camera.core;

import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class UseCaseGroup {
    private final List<CameraEffect> mEffects;
    private final List<UseCase> mUseCases;
    private final ViewPort mViewPort;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private static final List<Integer> SUPPORTED_TARGETS = Arrays.asList(1, 2, 4, 3, 7);
        private ViewPort mViewPort;
        private final List<UseCase> mUseCases = new ArrayList();
        private final List<CameraEffect> mEffects = new ArrayList();

        private void checkEffectTargets() {
            Iterator<CameraEffect> it = this.mEffects.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int targets = it.next().getTargets();
                TargetUtils.checkSupportedTargets(SUPPORTED_TARGETS, targets);
                int i8 = i2 & targets;
                if (i8 > 0) {
                    Locale locale = Locale.US;
                    throw new IllegalArgumentException(a1.a.m("More than one effects has targets ", TargetUtils.getHumanReadableName(i8), "."));
                }
                i2 |= targets;
            }
        }

        public Builder addEffect(CameraEffect cameraEffect) {
            this.mEffects.add(cameraEffect);
            return this;
        }

        public Builder addUseCase(UseCase useCase) {
            this.mUseCases.add(useCase);
            return this;
        }

        public UseCaseGroup build() {
            Preconditions.checkArgument(!this.mUseCases.isEmpty(), "UseCase must not be empty.");
            checkEffectTargets();
            return new UseCaseGroup(this.mViewPort, this.mUseCases, this.mEffects);
        }

        public Builder setViewPort(ViewPort viewPort) {
            this.mViewPort = viewPort;
            return this;
        }
    }

    public UseCaseGroup(ViewPort viewPort, List<UseCase> list, List<CameraEffect> list2) {
        this.mViewPort = viewPort;
        this.mUseCases = list;
        this.mEffects = list2;
    }

    public List<CameraEffect> getEffects() {
        return this.mEffects;
    }

    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }
}

package androidx.camera.core;

import androidx.annotation.RestrictTo;
import java.util.List;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class LegacySessionConfig extends SessionConfig {
    private final boolean isLegacy;

    public /* synthetic */ LegacySessionConfig(List list, ViewPort viewPort, List list2, int i2, kotlin.jvm.internal.f fVar) {
        this(list, (i2 & 2) != 0 ? null : viewPort, (i2 & 4) != 0 ? r.f13638a : list2);
    }

    @Override // androidx.camera.core.SessionConfig
    public boolean isLegacy() {
        return this.isLegacy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacySessionConfig(List<? extends UseCase> useCases, ViewPort viewPort, List<? extends CameraEffect> effects) {
        super(useCases, viewPort, effects, null, null, null, 56, null);
        kotlin.jvm.internal.k.e(useCases, "useCases");
        kotlin.jvm.internal.k.e(effects, "effects");
        this.isLegacy = true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LegacySessionConfig(UseCaseGroup useCaseGroup) {
        kotlin.jvm.internal.k.e(useCaseGroup, "useCaseGroup");
        List<UseCase> useCases = useCaseGroup.getUseCases();
        kotlin.jvm.internal.k.d(useCases, "getUseCases(...)");
        ViewPort viewPort = useCaseGroup.getViewPort();
        List<CameraEffect> effects = useCaseGroup.getEffects();
        kotlin.jvm.internal.k.d(effects, "getEffects(...)");
        this(useCases, viewPort, effects);
    }
}

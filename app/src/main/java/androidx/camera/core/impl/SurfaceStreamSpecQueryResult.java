package androidx.camera.core.impl;

import androidx.annotation.RestrictTo;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SurfaceStreamSpecQueryResult {
    private final Map<AttachedSurfaceInfo, StreamSpec> attachedSurfaceStreamSpecs;
    private final int maxSupportedFrameRate;
    private final Map<UseCaseConfig<?>, StreamSpec> useCaseStreamSpecs;

    /* JADX WARN: Multi-variable type inference failed */
    public SurfaceStreamSpecQueryResult(Map<UseCaseConfig<?>, ? extends StreamSpec> useCaseStreamSpecs, Map<AttachedSurfaceInfo, ? extends StreamSpec> attachedSurfaceStreamSpecs, int i2) {
        kotlin.jvm.internal.k.e(useCaseStreamSpecs, "useCaseStreamSpecs");
        kotlin.jvm.internal.k.e(attachedSurfaceStreamSpecs, "attachedSurfaceStreamSpecs");
        this.useCaseStreamSpecs = useCaseStreamSpecs;
        this.attachedSurfaceStreamSpecs = attachedSurfaceStreamSpecs;
        this.maxSupportedFrameRate = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurfaceStreamSpecQueryResult copy$default(SurfaceStreamSpecQueryResult surfaceStreamSpecQueryResult, Map map, Map map2, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            map = surfaceStreamSpecQueryResult.useCaseStreamSpecs;
        }
        if ((i8 & 2) != 0) {
            map2 = surfaceStreamSpecQueryResult.attachedSurfaceStreamSpecs;
        }
        if ((i8 & 4) != 0) {
            i2 = surfaceStreamSpecQueryResult.maxSupportedFrameRate;
        }
        return surfaceStreamSpecQueryResult.copy(map, map2, i2);
    }

    public final Map<UseCaseConfig<?>, StreamSpec> component1() {
        return this.useCaseStreamSpecs;
    }

    public final Map<AttachedSurfaceInfo, StreamSpec> component2() {
        return this.attachedSurfaceStreamSpecs;
    }

    public final int component3() {
        return this.maxSupportedFrameRate;
    }

    public final SurfaceStreamSpecQueryResult copy(Map<UseCaseConfig<?>, ? extends StreamSpec> useCaseStreamSpecs, Map<AttachedSurfaceInfo, ? extends StreamSpec> attachedSurfaceStreamSpecs, int i2) {
        kotlin.jvm.internal.k.e(useCaseStreamSpecs, "useCaseStreamSpecs");
        kotlin.jvm.internal.k.e(attachedSurfaceStreamSpecs, "attachedSurfaceStreamSpecs");
        return new SurfaceStreamSpecQueryResult(useCaseStreamSpecs, attachedSurfaceStreamSpecs, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurfaceStreamSpecQueryResult)) {
            return false;
        }
        SurfaceStreamSpecQueryResult surfaceStreamSpecQueryResult = (SurfaceStreamSpecQueryResult) obj;
        return kotlin.jvm.internal.k.a(this.useCaseStreamSpecs, surfaceStreamSpecQueryResult.useCaseStreamSpecs) && kotlin.jvm.internal.k.a(this.attachedSurfaceStreamSpecs, surfaceStreamSpecQueryResult.attachedSurfaceStreamSpecs) && this.maxSupportedFrameRate == surfaceStreamSpecQueryResult.maxSupportedFrameRate;
    }

    public final Map<AttachedSurfaceInfo, StreamSpec> getAttachedSurfaceStreamSpecs() {
        return this.attachedSurfaceStreamSpecs;
    }

    public final int getMaxSupportedFrameRate() {
        return this.maxSupportedFrameRate;
    }

    public final Map<UseCaseConfig<?>, StreamSpec> getUseCaseStreamSpecs() {
        return this.useCaseStreamSpecs;
    }

    public int hashCode() {
        return ((this.attachedSurfaceStreamSpecs.hashCode() + (this.useCaseStreamSpecs.hashCode() * 31)) * 31) + this.maxSupportedFrameRate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SurfaceStreamSpecQueryResult(useCaseStreamSpecs=");
        sb.append(this.useCaseStreamSpecs);
        sb.append(", attachedSurfaceStreamSpecs=");
        sb.append(this.attachedSurfaceStreamSpecs);
        sb.append(", maxSupportedFrameRate=");
        return com.ironsource.adqualitysdk.sdk.i.a0.c(sb, this.maxSupportedFrameRate, ')');
    }
}

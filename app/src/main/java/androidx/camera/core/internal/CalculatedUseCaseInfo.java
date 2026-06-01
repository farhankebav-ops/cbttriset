package androidx.camera.core.internal;

import androidx.annotation.RestrictTo;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.streamsharing.StreamSharing;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CalculatedUseCaseInfo {
    private final Collection<UseCase> appUseCases;
    private final Collection<UseCase> cameraUseCases;
    private final List<UseCase> cameraUseCasesToAttach;
    private final List<UseCase> cameraUseCasesToDetach;
    private final List<UseCase> cameraUseCasesToKeep;
    private final UseCase placeholderForExtensions;
    private final StreamSpecQueryResult primaryStreamSpecResult;
    private final StreamSpecQueryResult secondaryStreamSpecResult;
    private final StreamSharing streamSharing;
    private final Map<UseCase, CameraUseCaseAdapter.ConfigPair> useCaseConfigs;

    /* JADX WARN: Multi-variable type inference failed */
    public CalculatedUseCaseInfo(Collection<? extends UseCase> appUseCases, Collection<? extends UseCase> cameraUseCases, List<? extends UseCase> cameraUseCasesToAttach, List<? extends UseCase> cameraUseCasesToKeep, List<? extends UseCase> cameraUseCasesToDetach, StreamSharing streamSharing, UseCase useCase, Map<UseCase, ? extends CameraUseCaseAdapter.ConfigPair> useCaseConfigs, StreamSpecQueryResult primaryStreamSpecResult, StreamSpecQueryResult streamSpecQueryResult) {
        k.e(appUseCases, "appUseCases");
        k.e(cameraUseCases, "cameraUseCases");
        k.e(cameraUseCasesToAttach, "cameraUseCasesToAttach");
        k.e(cameraUseCasesToKeep, "cameraUseCasesToKeep");
        k.e(cameraUseCasesToDetach, "cameraUseCasesToDetach");
        k.e(useCaseConfigs, "useCaseConfigs");
        k.e(primaryStreamSpecResult, "primaryStreamSpecResult");
        this.appUseCases = appUseCases;
        this.cameraUseCases = cameraUseCases;
        this.cameraUseCasesToAttach = cameraUseCasesToAttach;
        this.cameraUseCasesToKeep = cameraUseCasesToKeep;
        this.cameraUseCasesToDetach = cameraUseCasesToDetach;
        this.streamSharing = streamSharing;
        this.placeholderForExtensions = useCase;
        this.useCaseConfigs = useCaseConfigs;
        this.primaryStreamSpecResult = primaryStreamSpecResult;
        this.secondaryStreamSpecResult = streamSpecQueryResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CalculatedUseCaseInfo copy$default(CalculatedUseCaseInfo calculatedUseCaseInfo, Collection collection, Collection collection2, List list, List list2, List list3, StreamSharing streamSharing, UseCase useCase, Map map, StreamSpecQueryResult streamSpecQueryResult, StreamSpecQueryResult streamSpecQueryResult2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            collection = calculatedUseCaseInfo.appUseCases;
        }
        if ((i2 & 2) != 0) {
            collection2 = calculatedUseCaseInfo.cameraUseCases;
        }
        if ((i2 & 4) != 0) {
            list = calculatedUseCaseInfo.cameraUseCasesToAttach;
        }
        if ((i2 & 8) != 0) {
            list2 = calculatedUseCaseInfo.cameraUseCasesToKeep;
        }
        if ((i2 & 16) != 0) {
            list3 = calculatedUseCaseInfo.cameraUseCasesToDetach;
        }
        if ((i2 & 32) != 0) {
            streamSharing = calculatedUseCaseInfo.streamSharing;
        }
        if ((i2 & 64) != 0) {
            useCase = calculatedUseCaseInfo.placeholderForExtensions;
        }
        if ((i2 & 128) != 0) {
            map = calculatedUseCaseInfo.useCaseConfigs;
        }
        if ((i2 & 256) != 0) {
            streamSpecQueryResult = calculatedUseCaseInfo.primaryStreamSpecResult;
        }
        if ((i2 & 512) != 0) {
            streamSpecQueryResult2 = calculatedUseCaseInfo.secondaryStreamSpecResult;
        }
        StreamSpecQueryResult streamSpecQueryResult3 = streamSpecQueryResult;
        StreamSpecQueryResult streamSpecQueryResult4 = streamSpecQueryResult2;
        UseCase useCase2 = useCase;
        Map map2 = map;
        List list4 = list3;
        StreamSharing streamSharing2 = streamSharing;
        return calculatedUseCaseInfo.copy(collection, collection2, list, list2, list4, streamSharing2, useCase2, map2, streamSpecQueryResult3, streamSpecQueryResult4);
    }

    public final Collection<UseCase> component1() {
        return this.appUseCases;
    }

    public final StreamSpecQueryResult component10() {
        return this.secondaryStreamSpecResult;
    }

    public final Collection<UseCase> component2() {
        return this.cameraUseCases;
    }

    public final List<UseCase> component3() {
        return this.cameraUseCasesToAttach;
    }

    public final List<UseCase> component4() {
        return this.cameraUseCasesToKeep;
    }

    public final List<UseCase> component5() {
        return this.cameraUseCasesToDetach;
    }

    public final StreamSharing component6() {
        return this.streamSharing;
    }

    public final UseCase component7() {
        return this.placeholderForExtensions;
    }

    public final Map<UseCase, CameraUseCaseAdapter.ConfigPair> component8() {
        return this.useCaseConfigs;
    }

    public final StreamSpecQueryResult component9() {
        return this.primaryStreamSpecResult;
    }

    public final CalculatedUseCaseInfo copy(Collection<? extends UseCase> appUseCases, Collection<? extends UseCase> cameraUseCases, List<? extends UseCase> cameraUseCasesToAttach, List<? extends UseCase> cameraUseCasesToKeep, List<? extends UseCase> cameraUseCasesToDetach, StreamSharing streamSharing, UseCase useCase, Map<UseCase, ? extends CameraUseCaseAdapter.ConfigPair> useCaseConfigs, StreamSpecQueryResult primaryStreamSpecResult, StreamSpecQueryResult streamSpecQueryResult) {
        k.e(appUseCases, "appUseCases");
        k.e(cameraUseCases, "cameraUseCases");
        k.e(cameraUseCasesToAttach, "cameraUseCasesToAttach");
        k.e(cameraUseCasesToKeep, "cameraUseCasesToKeep");
        k.e(cameraUseCasesToDetach, "cameraUseCasesToDetach");
        k.e(useCaseConfigs, "useCaseConfigs");
        k.e(primaryStreamSpecResult, "primaryStreamSpecResult");
        return new CalculatedUseCaseInfo(appUseCases, cameraUseCases, cameraUseCasesToAttach, cameraUseCasesToKeep, cameraUseCasesToDetach, streamSharing, useCase, useCaseConfigs, primaryStreamSpecResult, streamSpecQueryResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalculatedUseCaseInfo)) {
            return false;
        }
        CalculatedUseCaseInfo calculatedUseCaseInfo = (CalculatedUseCaseInfo) obj;
        return k.a(this.appUseCases, calculatedUseCaseInfo.appUseCases) && k.a(this.cameraUseCases, calculatedUseCaseInfo.cameraUseCases) && k.a(this.cameraUseCasesToAttach, calculatedUseCaseInfo.cameraUseCasesToAttach) && k.a(this.cameraUseCasesToKeep, calculatedUseCaseInfo.cameraUseCasesToKeep) && k.a(this.cameraUseCasesToDetach, calculatedUseCaseInfo.cameraUseCasesToDetach) && k.a(this.streamSharing, calculatedUseCaseInfo.streamSharing) && k.a(this.placeholderForExtensions, calculatedUseCaseInfo.placeholderForExtensions) && k.a(this.useCaseConfigs, calculatedUseCaseInfo.useCaseConfigs) && k.a(this.primaryStreamSpecResult, calculatedUseCaseInfo.primaryStreamSpecResult) && k.a(this.secondaryStreamSpecResult, calculatedUseCaseInfo.secondaryStreamSpecResult);
    }

    public final Collection<UseCase> getAppUseCases() {
        return this.appUseCases;
    }

    public final Collection<UseCase> getCameraUseCases() {
        return this.cameraUseCases;
    }

    public final List<UseCase> getCameraUseCasesToAttach() {
        return this.cameraUseCasesToAttach;
    }

    public final List<UseCase> getCameraUseCasesToDetach() {
        return this.cameraUseCasesToDetach;
    }

    public final List<UseCase> getCameraUseCasesToKeep() {
        return this.cameraUseCasesToKeep;
    }

    public final UseCase getPlaceholderForExtensions() {
        return this.placeholderForExtensions;
    }

    public final StreamSpecQueryResult getPrimaryStreamSpecResult() {
        return this.primaryStreamSpecResult;
    }

    public final StreamSpecQueryResult getSecondaryStreamSpecResult() {
        return this.secondaryStreamSpecResult;
    }

    public final StreamSharing getStreamSharing() {
        return this.streamSharing;
    }

    public final Map<UseCase, CameraUseCaseAdapter.ConfigPair> getUseCaseConfigs() {
        return this.useCaseConfigs;
    }

    public int hashCode() {
        int iHashCode = (this.cameraUseCasesToDetach.hashCode() + ((this.cameraUseCasesToKeep.hashCode() + ((this.cameraUseCasesToAttach.hashCode() + ((this.cameraUseCases.hashCode() + (this.appUseCases.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        StreamSharing streamSharing = this.streamSharing;
        int iHashCode2 = (iHashCode + (streamSharing == null ? 0 : streamSharing.hashCode())) * 31;
        UseCase useCase = this.placeholderForExtensions;
        int iHashCode3 = (this.primaryStreamSpecResult.hashCode() + ((this.useCaseConfigs.hashCode() + ((iHashCode2 + (useCase == null ? 0 : useCase.hashCode())) * 31)) * 31)) * 31;
        StreamSpecQueryResult streamSpecQueryResult = this.secondaryStreamSpecResult;
        return iHashCode3 + (streamSpecQueryResult != null ? streamSpecQueryResult.hashCode() : 0);
    }

    public String toString() {
        return "CalculatedUseCaseInfo(appUseCases=" + this.appUseCases + ", cameraUseCases=" + this.cameraUseCases + ", cameraUseCasesToAttach=" + this.cameraUseCasesToAttach + ", cameraUseCasesToKeep=" + this.cameraUseCasesToKeep + ", cameraUseCasesToDetach=" + this.cameraUseCasesToDetach + ", streamSharing=" + this.streamSharing + ", placeholderForExtensions=" + this.placeholderForExtensions + ", useCaseConfigs=" + this.useCaseConfigs + ", primaryStreamSpecResult=" + this.primaryStreamSpecResult + ", secondaryStreamSpecResult=" + this.secondaryStreamSpecResult + ')';
    }
}

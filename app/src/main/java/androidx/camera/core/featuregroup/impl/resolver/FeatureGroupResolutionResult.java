package androidx.camera.core.featuregroup.impl.resolver;

import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface FeatureGroupResolutionResult {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Supported implements FeatureGroupResolutionResult {
        private final ResolvedFeatureGroup resolvedFeatureGroup;

        public Supported(ResolvedFeatureGroup resolvedFeatureGroup) {
            k.e(resolvedFeatureGroup, "resolvedFeatureGroup");
            this.resolvedFeatureGroup = resolvedFeatureGroup;
        }

        public static /* synthetic */ Supported copy$default(Supported supported, ResolvedFeatureGroup resolvedFeatureGroup, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                resolvedFeatureGroup = supported.resolvedFeatureGroup;
            }
            return supported.copy(resolvedFeatureGroup);
        }

        public final ResolvedFeatureGroup component1() {
            return this.resolvedFeatureGroup;
        }

        public final Supported copy(ResolvedFeatureGroup resolvedFeatureGroup) {
            k.e(resolvedFeatureGroup, "resolvedFeatureGroup");
            return new Supported(resolvedFeatureGroup);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Supported) && k.a(this.resolvedFeatureGroup, ((Supported) obj).resolvedFeatureGroup);
        }

        public final ResolvedFeatureGroup getResolvedFeatureGroup() {
            return this.resolvedFeatureGroup;
        }

        public int hashCode() {
            return this.resolvedFeatureGroup.hashCode();
        }

        public String toString() {
            return "Supported(resolvedFeatureGroup=" + this.resolvedFeatureGroup + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Unsupported implements FeatureGroupResolutionResult {
        public static final Unsupported INSTANCE = new Unsupported();

        private Unsupported() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class UnsupportedUseCase implements FeatureGroupResolutionResult {
        private final UseCase unsupportedUseCase;

        public UnsupportedUseCase(UseCase unsupportedUseCase) {
            k.e(unsupportedUseCase, "unsupportedUseCase");
            this.unsupportedUseCase = unsupportedUseCase;
        }

        public static /* synthetic */ UnsupportedUseCase copy$default(UnsupportedUseCase unsupportedUseCase, UseCase useCase, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                useCase = unsupportedUseCase.unsupportedUseCase;
            }
            return unsupportedUseCase.copy(useCase);
        }

        public final UseCase component1() {
            return this.unsupportedUseCase;
        }

        public final UnsupportedUseCase copy(UseCase unsupportedUseCase) {
            k.e(unsupportedUseCase, "unsupportedUseCase");
            return new UnsupportedUseCase(unsupportedUseCase);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnsupportedUseCase) && k.a(this.unsupportedUseCase, ((UnsupportedUseCase) obj).unsupportedUseCase);
        }

        public final UseCase getUnsupportedUseCase() {
            return this.unsupportedUseCase;
        }

        public int hashCode() {
            return this.unsupportedUseCase.hashCode();
        }

        public String toString() {
            return "UnsupportedUseCase(unsupportedUseCase=" + this.unsupportedUseCase + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class UseCaseMissing implements FeatureGroupResolutionResult {
        private final GroupableFeature featureRequiring;
        private final String requiredUseCases;

        public UseCaseMissing(String requiredUseCases, GroupableFeature featureRequiring) {
            k.e(requiredUseCases, "requiredUseCases");
            k.e(featureRequiring, "featureRequiring");
            this.requiredUseCases = requiredUseCases;
            this.featureRequiring = featureRequiring;
        }

        public static /* synthetic */ UseCaseMissing copy$default(UseCaseMissing useCaseMissing, String str, GroupableFeature groupableFeature, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = useCaseMissing.requiredUseCases;
            }
            if ((i2 & 2) != 0) {
                groupableFeature = useCaseMissing.featureRequiring;
            }
            return useCaseMissing.copy(str, groupableFeature);
        }

        public final String component1() {
            return this.requiredUseCases;
        }

        public final GroupableFeature component2() {
            return this.featureRequiring;
        }

        public final UseCaseMissing copy(String requiredUseCases, GroupableFeature featureRequiring) {
            k.e(requiredUseCases, "requiredUseCases");
            k.e(featureRequiring, "featureRequiring");
            return new UseCaseMissing(requiredUseCases, featureRequiring);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UseCaseMissing)) {
                return false;
            }
            UseCaseMissing useCaseMissing = (UseCaseMissing) obj;
            return k.a(this.requiredUseCases, useCaseMissing.requiredUseCases) && k.a(this.featureRequiring, useCaseMissing.featureRequiring);
        }

        public final GroupableFeature getFeatureRequiring() {
            return this.featureRequiring;
        }

        public final String getRequiredUseCases() {
            return this.requiredUseCases;
        }

        public int hashCode() {
            return this.featureRequiring.hashCode() + (this.requiredUseCases.hashCode() * 31);
        }

        public String toString() {
            return "UseCaseMissing(requiredUseCases=" + this.requiredUseCases + ", featureRequiring=" + this.featureRequiring + ')';
        }
    }
}

package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class DeletionRequest {
    public static final Companion Companion = new Companion(null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;
    private final List<Uri> domainUris;
    private final Instant end;
    private final int matchBehavior;
    private final List<Uri> originUris;
    private final Instant start;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(26)
    public static final class Builder {
        private final int deletionMode;
        private List<? extends Uri> domainUris;
        private Instant end;
        private final int matchBehavior;
        private List<? extends Uri> originUris;
        private Instant start;

        public Builder(int i2, int i8) {
            this.deletionMode = i2;
            this.matchBehavior = i8;
            Instant MIN = Instant.MIN;
            k.d(MIN, "MIN");
            this.start = MIN;
            Instant MAX = Instant.MAX;
            k.d(MAX, "MAX");
            this.end = MAX;
            r rVar = r.f13638a;
            this.domainUris = rVar;
            this.originUris = rVar;
        }

        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }

        public final Builder setDomainUris(List<? extends Uri> domainUris) {
            k.e(domainUris, "domainUris");
            this.domainUris = domainUris;
            return this;
        }

        public final Builder setEnd(Instant end) {
            k.e(end, "end");
            this.end = end;
            return this;
        }

        public final Builder setOriginUris(List<? extends Uri> originUris) {
            k.e(originUris, "originUris");
            this.originUris = originUris;
            return this;
        }

        public final Builder setStart(Instant start) {
            k.e(start, "start");
            this.start = start;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface DeletionMode {
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeletionRequest(int i2, int i8, Instant start, Instant end, List<? extends Uri> domainUris, List<? extends Uri> originUris) {
        k.e(start, "start");
        k.e(end, "end");
        k.e(domainUris, "domainUris");
        k.e(originUris, "originUris");
        this.deletionMode = i2;
        this.matchBehavior = i8;
        this.start = start;
        this.end = end;
        this.domainUris = domainUris;
        this.originUris = originUris;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.measurement.DeletionRequest convertToAdServices$ads_adservices_release() {
        android.adservices.measurement.DeletionRequest deletionRequestBuild = androidx.privacysandbox.ads.adservices.customaudience.a.o().setDeletionMode(this.deletionMode).setMatchBehavior(this.matchBehavior).setStart(this.start).setEnd(this.end).setDomainUris(this.domainUris).setOriginUris(this.originUris).build();
        k.d(deletionRequestBuild, "Builder()\n            .s…ris)\n            .build()");
        return deletionRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        return this.deletionMode == deletionRequest.deletionMode && new HashSet(this.domainUris).equals(new HashSet(deletionRequest.domainUris)) && new HashSet(this.originUris).equals(new HashSet(deletionRequest.originUris)) && k.a(this.start, deletionRequest.start) && k.a(this.end, deletionRequest.end) && this.matchBehavior == deletionRequest.matchBehavior;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return ((this.end.hashCode() + ((this.start.hashCode() + ((this.originUris.hashCode() + ((this.domainUris.hashCode() + (this.deletionMode * 31)) * 31)) * 31)) * 31)) * 31) + this.matchBehavior;
    }

    public String toString() {
        StringBuilder sbZ = a1.a.z("DeletionRequest { DeletionMode=", this.deletionMode == 0 ? "DELETION_MODE_ALL" : "DELETION_MODE_EXCLUDE_INTERNAL_DATA", ", MatchBehavior=", this.matchBehavior == 0 ? "MATCH_BEHAVIOR_DELETE" : "MATCH_BEHAVIOR_PRESERVE", ", Start=");
        sbZ.append(this.start);
        sbZ.append(", End=");
        sbZ.append(this.end);
        sbZ.append(", DomainUris=");
        sbZ.append(this.domainUris);
        sbZ.append(", OriginUris=");
        sbZ.append(this.originUris);
        sbZ.append(" }");
        return sbZ.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DeletionRequest(int i2, int i8, Instant MIN, Instant MAX, List list, List list2, int i9, f fVar) {
        if ((i9 & 4) != 0) {
            MIN = Instant.MIN;
            k.d(MIN, "MIN");
        }
        Instant instant = MIN;
        if ((i9 & 8) != 0) {
            MAX = Instant.MAX;
            k.d(MAX, "MAX");
        }
        Instant instant2 = MAX;
        int i10 = i9 & 16;
        r rVar = r.f13638a;
        this(i2, i8, instant, instant2, i10 != 0 ? rVar : list, (i9 & 32) != 0 ? rVar : list2);
    }
}

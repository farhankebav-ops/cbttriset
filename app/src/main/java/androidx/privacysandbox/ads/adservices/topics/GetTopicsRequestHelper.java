package androidx.privacysandbox.ads.adservices.topics;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class GetTopicsRequestHelper {
    public static final GetTopicsRequestHelper INSTANCE = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.topics.GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(GetTopicsRequest request) {
        k.e(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = androidx.privacysandbox.ads.adservices.measurement.a.n().setAdsSdkName(request.getAdsSdkName()).setShouldRecordObservation(request.shouldRecordObservation()).build();
        k.d(getTopicsRequestBuild, "Builder()\n            .s…ion)\n            .build()");
        return getTopicsRequestBuild;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.topics.GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(GetTopicsRequest request) {
        k.e(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = androidx.privacysandbox.ads.adservices.measurement.a.n().setAdsSdkName(request.getAdsSdkName()).build();
        k.d(getTopicsRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestBuild;
    }
}

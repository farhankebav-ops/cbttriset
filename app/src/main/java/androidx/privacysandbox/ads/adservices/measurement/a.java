package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.Topic;
import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ WebSourceParams.Builder c(Uri uri) {
        return new WebSourceParams.Builder(uri);
    }

    public static /* synthetic */ WebSourceRegistrationRequest.Builder g(List list, Uri uri) {
        return new WebSourceRegistrationRequest.Builder(list, uri);
    }

    public static /* synthetic */ WebTriggerParams.Builder j(Uri uri) {
        return new WebTriggerParams.Builder(uri);
    }

    public static /* synthetic */ WebTriggerRegistrationRequest.Builder l(List list, Uri uri) {
        return new WebTriggerRegistrationRequest.Builder(list, uri);
    }

    public static /* synthetic */ GetTopicsRequest.Builder n() {
        return new GetTopicsRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ Topic r(Object obj) {
        return (Topic) obj;
    }

    public static /* synthetic */ void t() {
    }

    public static /* synthetic */ void z() {
    }
}

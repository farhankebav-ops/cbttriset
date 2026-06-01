package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.adservices.signals.UpdateSignalsRequest;
import android.adservices.topics.EncryptedTopic;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ FetchAndJoinCustomAudienceRequest.Builder d(Uri uri) {
        return new FetchAndJoinCustomAudienceRequest.Builder(uri);
    }

    public static /* synthetic */ UpdateSignalsRequest.Builder g(Uri uri) {
        return new UpdateSignalsRequest.Builder(uri);
    }

    public static /* bridge */ /* synthetic */ EncryptedTopic i(Object obj) {
        return (EncryptedTopic) obj;
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void v() {
    }
}

package okhttp3.internal;

import kotlin.jvm.internal.k;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnreadableResponseBodyKt {
    public static final Response stripBody(Response response) {
        k.e(response, "<this>");
        return response.newBuilder().body(new UnreadableResponseBody(response.body().contentType(), response.body().contentLength())).build();
    }
}

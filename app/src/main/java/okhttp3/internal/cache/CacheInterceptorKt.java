package okhttp3.internal.cache;

import kotlin.jvm.internal.k;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CacheInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Request requestForCache(Request request) {
        HttpUrl httpUrlCacheUrlOverride = request.cacheUrlOverride();
        return httpUrlCacheUrlOverride != null ? (k.a(request.method(), "GET") || k.a(request.method(), "POST")) ? request.newBuilder().get().url(httpUrlCacheUrlOverride).cacheUrlOverride(null).build() : request : request;
    }
}

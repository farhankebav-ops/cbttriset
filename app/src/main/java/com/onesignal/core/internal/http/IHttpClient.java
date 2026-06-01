package com.onesignal.core.internal.http;

import com.onesignal.core.internal.http.impl.OptionalHeaders;
import org.json.JSONObject;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IHttpClient {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Object delete$default(IHttpClient iHttpClient, String str, OptionalHeaders optionalHeaders, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i2 & 2) != 0) {
                optionalHeaders = null;
            }
            return iHttpClient.delete(str, optionalHeaders, cVar);
        }

        public static /* synthetic */ Object get$default(IHttpClient iHttpClient, String str, OptionalHeaders optionalHeaders, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
            }
            if ((i2 & 2) != 0) {
                optionalHeaders = null;
            }
            return iHttpClient.get(str, optionalHeaders, cVar);
        }

        public static /* synthetic */ Object patch$default(IHttpClient iHttpClient, String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: patch");
            }
            if ((i2 & 4) != 0) {
                optionalHeaders = null;
            }
            return iHttpClient.patch(str, jSONObject, optionalHeaders, cVar);
        }

        public static /* synthetic */ Object post$default(IHttpClient iHttpClient, String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
            }
            if ((i2 & 4) != 0) {
                optionalHeaders = null;
            }
            return iHttpClient.post(str, jSONObject, optionalHeaders, cVar);
        }

        public static /* synthetic */ Object put$default(IHttpClient iHttpClient, String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
            }
            if ((i2 & 4) != 0) {
                optionalHeaders = null;
            }
            return iHttpClient.put(str, jSONObject, optionalHeaders, cVar);
        }
    }

    Object delete(String str, OptionalHeaders optionalHeaders, c<? super HttpResponse> cVar);

    Object get(String str, OptionalHeaders optionalHeaders, c<? super HttpResponse> cVar);

    Object patch(String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, c<? super HttpResponse> cVar);

    Object post(String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, c<? super HttpResponse> cVar);

    Object put(String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, c<? super HttpResponse> cVar);
}

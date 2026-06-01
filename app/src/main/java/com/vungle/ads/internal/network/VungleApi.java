package com.vungle.ads.internal.network;

import androidx.annotation.Keep;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@Keep
public interface VungleApi {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Call pingTPAT$default(VungleApi vungleApi, String str, String str2, HttpMethod httpMethod, Map map, RequestBody requestBody, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pingTPAT");
            }
            if ((i2 & 4) != 0) {
                httpMethod = HttpMethod.GET;
            }
            return vungleApi.pingTPAT(str, str2, httpMethod, (i2 & 8) != 0 ? null : map, (i2 & 16) != 0 ? null : requestBody);
        }
    }

    Call<AdPayload> ads(String str, String str2, CommonRequestBody commonRequestBody);

    Call<ConfigPayload> config(String str, String str2, CommonRequestBody commonRequestBody);

    Call<Void> pingTPAT(String str, String str2, HttpMethod httpMethod, Map<String, String> map, RequestBody requestBody);

    Call<Void> ri(String str, String str2, CommonRequestBody commonRequestBody);

    Call<Void> sendAdMarkup(String str, RequestBody requestBody);

    Call<Void> sendErrors(String str, String str2, RequestBody requestBody);

    Call<Void> sendMetrics(String str, String str2, RequestBody requestBody);
}

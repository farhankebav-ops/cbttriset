package com.unity3d.ads.core.domain;

import com.unity3d.services.core.network.core.HttpClient;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface HttpClientProvider {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(HttpClientProvider httpClientProvider, boolean z2, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            return httpClientProvider.invoke(z2, cVar);
        }
    }

    Object invoke(boolean z2, c<? super HttpClient> cVar);
}

package com.unity3d.ads.core.domain;

import com.unity3d.ads.TokenConfiguration;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface GetHeaderBiddingToken {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(GetHeaderBiddingToken getHeaderBiddingToken, int i2, TokenConfiguration tokenConfiguration, c cVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i8 & 2) != 0) {
                tokenConfiguration = null;
            }
            return getHeaderBiddingToken.invoke(i2, tokenConfiguration, cVar);
        }
    }

    Object invoke(int i2, TokenConfiguration tokenConfiguration, c<? super String> cVar);
}

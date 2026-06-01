package com.vungle.ads.internal.model;

import a1.a;
import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class RtbRequest {
    public static final Companion Companion = new Companion(null);
    private final String sdkUserAgent;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return RtbRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public RtbRequest() {
        this((String) null, 1, (f) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ RtbRequest copy$default(RtbRequest rtbRequest, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rtbRequest.sdkUserAgent;
        }
        return rtbRequest.copy(str);
    }

    public static final void write$Self(RtbRequest self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.sdkUserAgent == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 0, q1.f11501a, self.sdkUserAgent);
    }

    public final String component1() {
        return this.sdkUserAgent;
    }

    public final RtbRequest copy(String str) {
        return new RtbRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RtbRequest) && k.a(this.sdkUserAgent, ((RtbRequest) obj).sdkUserAgent);
    }

    public final String getSdkUserAgent() {
        return this.sdkUserAgent;
    }

    public int hashCode() {
        String str = this.sdkUserAgent;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return a.e(')', this.sdkUserAgent, new StringBuilder("RtbRequest(sdkUserAgent="));
    }

    public /* synthetic */ RtbRequest(int i2, String str, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.sdkUserAgent = null;
        } else {
            this.sdkUserAgent = str;
        }
    }

    public RtbRequest(String str) {
        this.sdkUserAgent = str;
    }

    public /* synthetic */ RtbRequest(String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ void getSdkUserAgent$annotations() {
    }
}

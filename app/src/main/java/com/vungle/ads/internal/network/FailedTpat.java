package com.vungle.ads.internal.network;

import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.c1;
import f7.g0;
import f7.m1;
import f7.q1;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class FailedTpat {
    public static final Companion Companion = new Companion(null);
    private final String body;
    private final Map<String, String> headers;
    private final HttpMethod method;
    private int retryAttempt;
    private int retryCount;
    private String tpatKey;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return FailedTpat$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FailedTpat(int i2, HttpMethod httpMethod, Map map, String str, int i8, int i9, String str2, m1 m1Var) {
        if (16 != (i2 & 16)) {
            c1.j(FailedTpat$$serializer.INSTANCE.getDescriptor(), i2, 16);
            throw null;
        }
        this.method = (i2 & 1) == 0 ? HttpMethod.GET : httpMethod;
        if ((i2 & 2) == 0) {
            this.headers = null;
        } else {
            this.headers = map;
        }
        if ((i2 & 4) == 0) {
            this.body = null;
        } else {
            this.body = str;
        }
        if ((i2 & 8) == 0) {
            this.retryAttempt = 0;
        } else {
            this.retryAttempt = i8;
        }
        this.retryCount = i9;
        if ((i2 & 32) == 0) {
            this.tpatKey = null;
        } else {
            this.tpatKey = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FailedTpat copy$default(FailedTpat failedTpat, HttpMethod httpMethod, Map map, String str, int i2, int i8, String str2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            httpMethod = failedTpat.method;
        }
        if ((i9 & 2) != 0) {
            map = failedTpat.headers;
        }
        if ((i9 & 4) != 0) {
            str = failedTpat.body;
        }
        if ((i9 & 8) != 0) {
            i2 = failedTpat.retryAttempt;
        }
        if ((i9 & 16) != 0) {
            i8 = failedTpat.retryCount;
        }
        if ((i9 & 32) != 0) {
            str2 = failedTpat.tpatKey;
        }
        int i10 = i8;
        String str3 = str2;
        return failedTpat.copy(httpMethod, map, str, i2, i10, str3);
    }

    public static final void write$Self(FailedTpat self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.method != HttpMethod.GET) {
            output.encodeSerializableElement(serialDesc, 0, HttpMethod$$serializer.INSTANCE, self.method);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.headers != null) {
            q1 q1Var = q1.f11501a;
            output.encodeNullableSerializableElement(serialDesc, 1, new g0(q1Var, q1Var, 1), self.headers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.body != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, q1.f11501a, self.body);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.retryAttempt != 0) {
            output.encodeIntElement(serialDesc, 3, self.retryAttempt);
        }
        output.encodeIntElement(serialDesc, 4, self.retryCount);
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.tpatKey == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, q1.f11501a, self.tpatKey);
    }

    public final HttpMethod component1() {
        return this.method;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    public final String component3() {
        return this.body;
    }

    public final int component4() {
        return this.retryAttempt;
    }

    public final int component5() {
        return this.retryCount;
    }

    public final String component6() {
        return this.tpatKey;
    }

    public final FailedTpat copy(HttpMethod method, Map<String, String> map, String str, int i2, int i8, String str2) {
        k.e(method, "method");
        return new FailedTpat(method, map, str, i2, i8, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FailedTpat)) {
            return false;
        }
        FailedTpat failedTpat = (FailedTpat) obj;
        return this.method == failedTpat.method && k.a(this.headers, failedTpat.headers) && k.a(this.body, failedTpat.body) && this.retryAttempt == failedTpat.retryAttempt && this.retryCount == failedTpat.retryCount && k.a(this.tpatKey, failedTpat.tpatKey);
    }

    public final String getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final int getRetryAttempt() {
        return this.retryAttempt;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final String getTpatKey() {
        return this.tpatKey;
    }

    public int hashCode() {
        int iHashCode = this.method.hashCode() * 31;
        Map<String, String> map = this.headers;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.body;
        int iHashCode3 = (((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.retryAttempt) * 31) + this.retryCount) * 31;
        String str2 = this.tpatKey;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setRetryAttempt(int i2) {
        this.retryAttempt = i2;
    }

    public final void setRetryCount(int i2) {
        this.retryCount = i2;
    }

    public final void setTpatKey(String str) {
        this.tpatKey = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FailedTpat(method=");
        sb.append(this.method);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(", retryAttempt=");
        sb.append(this.retryAttempt);
        sb.append(", retryCount=");
        sb.append(this.retryCount);
        sb.append(", tpatKey=");
        return a1.a.e(')', this.tpatKey, sb);
    }

    public FailedTpat(HttpMethod method, Map<String, String> map, String str, int i2, int i8, String str2) {
        k.e(method, "method");
        this.method = method;
        this.headers = map;
        this.body = str;
        this.retryAttempt = i2;
        this.retryCount = i8;
        this.tpatKey = str2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ FailedTpat(com.vungle.ads.internal.network.HttpMethod r2, java.util.Map r3, java.lang.String r4, int r5, int r6, java.lang.String r7, int r8, kotlin.jvm.internal.f r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            com.vungle.ads.internal.network.HttpMethod r2 = com.vungle.ads.internal.network.HttpMethod.GET
        L6:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lc
            r3 = r0
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L11
            r4 = r0
        L11:
            r9 = r8 & 8
            if (r9 == 0) goto L16
            r5 = 0
        L16:
            r8 = r8 & 32
            if (r8 == 0) goto L22
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L29
        L22:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L29:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.FailedTpat.<init>(com.vungle.ads.internal.network.HttpMethod, java.util.Map, java.lang.String, int, int, java.lang.String, int, kotlin.jvm.internal.f):void");
    }
}

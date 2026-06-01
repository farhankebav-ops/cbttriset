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
public final class OmSdkData {
    public static final Companion Companion = new Companion(null);
    private final String params;
    private final String vendorKey;
    private final String vendorURL;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return OmSdkData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public OmSdkData() {
        this((String) null, (String) null, (String) null, 7, (f) null);
    }

    public static /* synthetic */ OmSdkData copy$default(OmSdkData omSdkData, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = omSdkData.params;
        }
        if ((i2 & 2) != 0) {
            str2 = omSdkData.vendorKey;
        }
        if ((i2 & 4) != 0) {
            str3 = omSdkData.vendorURL;
        }
        return omSdkData.copy(str, str2, str3);
    }

    public static final void write$Self(OmSdkData self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.params != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, q1.f11501a, self.params);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.vendorKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.vendorKey);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.vendorURL == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, q1.f11501a, self.vendorURL);
    }

    public final String component1() {
        return this.params;
    }

    public final String component2() {
        return this.vendorKey;
    }

    public final String component3() {
        return this.vendorURL;
    }

    public final OmSdkData copy(String str, String str2, String str3) {
        return new OmSdkData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OmSdkData)) {
            return false;
        }
        OmSdkData omSdkData = (OmSdkData) obj;
        return k.a(this.params, omSdkData.params) && k.a(this.vendorKey, omSdkData.vendorKey) && k.a(this.vendorURL, omSdkData.vendorURL);
    }

    public final String getParams() {
        return this.params;
    }

    public final String getVendorKey() {
        return this.vendorKey;
    }

    public final String getVendorURL() {
        return this.vendorURL;
    }

    public int hashCode() {
        String str = this.params;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorKey;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendorURL;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OmSdkData(params=");
        sb.append(this.params);
        sb.append(", vendorKey=");
        sb.append(this.vendorKey);
        sb.append(", vendorURL=");
        return a.e(')', this.vendorURL, sb);
    }

    public /* synthetic */ OmSdkData(int i2, String str, String str2, String str3, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.params = null;
        } else {
            this.params = str;
        }
        if ((i2 & 2) == 0) {
            this.vendorKey = null;
        } else {
            this.vendorKey = str2;
        }
        if ((i2 & 4) == 0) {
            this.vendorURL = null;
        } else {
            this.vendorURL = str3;
        }
    }

    public OmSdkData(String str, String str2, String str3) {
        this.params = str;
        this.vendorKey = str2;
        this.vendorURL = str3;
    }

    public /* synthetic */ OmSdkData(String str, String str2, String str3, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }
}

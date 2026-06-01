package com.instagram.common.viewpoint.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2145oi implements C1S {
    public final C2149om A00;

    @Deprecated
    public final C06009r A01;
    public final C2147ok A02;
    public final C2Q A03;

    @Deprecated
    public final C2146oj A04;
    public final C2143og A05;
    public final String A06;
    public static String[] A07 = {"wAM8vtdO0lmHfSdh0aX8JSKdnwpCp9D2", "", "J6SB4ddL0FfEeVIHYuGnUGetWM2QRdUO", "0HTq7SjPEUFdYYph8tikUta3pLjb69Rn", "wGA6vSFg01QHk42FD2L8p637KRkqAXcn", "9eG6h6QaFREs2gWO0", "Z5vutuZNVsi2rK7c87KXUNl8wBJYnGEL", "V2BGt2aUfGoyLxnwwGFsOMeTNor3H3xe"};
    public static final C2145oi A09 = new C2I().A05();
    public static final C1R<C2145oi> A08 = new C1R() { // from class: com.facebook.ads.redexgen.X.oo
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2145oi.A00(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2145oi A00(Bundle bundle) {
        String str = (String) C3M.A01(bundle.getString(A02(0), ""));
        Bundle bundle2 = bundle.getBundle(A02(1));
        C2147ok c2147ok = bundle2 == null ? C2147ok.A07 : (C2147ok) C2147ok.A06.A6X(bundle2);
        Bundle bundle3 = bundle.getBundle(A02(2));
        C2143og c2143og = bundle3 == null ? C2143og.A0Z : (C2143og) C2143og.A0Y.A6X(bundle3);
        Bundle bundle4 = bundle.getBundle(A02(3));
        return new C2145oi(str, bundle4 == null ? C06009r.A00 : (C06009r) C2149om.A05.A6X(bundle4), null, c2147ok, c2143og);
    }

    public C2145oi(String str, C06009r c06009r, C2146oj c2146oj, C2147ok c2147ok, C2143og c2143og) {
        this.A06 = str;
        this.A03 = c2146oj;
        this.A04 = c2146oj;
        this.A02 = c2147ok;
        this.A05 = c2143og;
        this.A00 = c06009r;
        this.A01 = c06009r;
    }

    public static String A02(int i2) {
        return Integer.toString(i2, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2145oi)) {
            return false;
        }
        C2145oi c2145oi = (C2145oi) obj;
        if (AbstractC04664a.A1E(this.A06, c2145oi.A06)) {
            C2149om c2149om = this.A00;
            C2149om c2149om2 = c2145oi.A00;
            String[] strArr = A07;
            if (strArr[7].charAt(22) != strArr[2].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "WE1TlvFnuMEFfhCqOSZQGPel0cAOxnij";
            strArr2[2] = "QIjSvgjDyRqWUwkha5pDZVewjWBdao8T";
            if (c2149om.equals(c2149om2) && AbstractC04664a.A1E(this.A03, c2145oi.A03) && AbstractC04664a.A1E(this.A02, c2145oi.A02) && AbstractC04664a.A1E(this.A05, c2145oi.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A06.hashCode();
        int i2 = result * 31;
        int result2 = this.A03 != null ? this.A03.hashCode() : 0;
        int iHashCode = (((i2 + result2) * 31) + this.A02.hashCode()) * 31;
        C2149om c2149om = this.A00;
        String[] strArr = A07;
        String str = strArr[4];
        String str2 = strArr[3];
        int iCharAt = str.charAt(31);
        int result3 = str2.charAt(31);
        if (iCharAt != result3) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "oKnJE1KY80M0C2djBAWfSHeSjkObNKTB";
        strArr2[2] = "bdrBBUaZbF1SVnsIGw0ZL6eMFfyDgZAn";
        int result4 = c2149om.hashCode();
        return ((iHashCode + result4) * 31) + this.A05.hashCode();
    }
}

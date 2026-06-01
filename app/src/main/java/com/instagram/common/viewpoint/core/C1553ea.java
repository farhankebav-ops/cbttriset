package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ea, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1553ea implements InterfaceC1053Rj {
    public static byte[] A03;
    public static String[] A04 = {"1hpByTARN6eOnQ", "46DvCO0dFj9d90pc7Bl3Va1pW3afVu0G", "LtfSHnVMNf9jD1VPw2QJdb6akNXb3KRw", "UXeRQ2HNaneiXsHAoGvRBzblNiVPPyfq", "WcHPi3i27m6LdaHLnkH9ENRpFxyJu3g8", "FTcDokCppzFM6olvGfJVNXVubstDZ8VZ", "v3Z7C81p3UBYKX6nY0MAEeka3DNz7RKw", "vwYfKziuTy1RLYscQHjTEDI4uYjWuvBq"};
    public final InterfaceC1581f2 A01;
    public Set<InterfaceC1056Rm> A00 = new HashSet();
    public final List<InterfaceC1055Rl> A02 = new ArrayList();

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{75, 75, 78, 24, 81, 75, 78, 24, 39, 53, 53, 35, 50, 53};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public synchronized void A03() {
        if (!this.A01.AAV()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<InterfaceC1056Rm> setA01 = A01(this.A01.A7a());
        if (!this.A00.equals(setA01) && setA01 != null) {
            this.A00 = setA01;
            Iterator<InterfaceC1055Rl> it = this.A02.iterator();
            while (it.hasNext()) {
                it.next().A4B();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (InterfaceC1056Rm interfaceC1056Rm : this.A00) {
                String.format(Locale.US, A00(0, 8, 58), interfaceC1056Rm.A9G(), interfaceC1056Rm.getUrl());
            }
        }
    }

    static {
        A02();
    }

    public C1553ea(InterfaceC0647Bn interfaceC0647Bn) {
        this.A01 = interfaceC0647Bn.A5M(EnumC1582f3.A0B);
        this.A01.A3t(new C1600fM(this));
        A03();
    }

    public static Set<InterfaceC1056Rm> A01(JSONObject jSONObject) {
        C1546eT c1546eTA00;
        HashSet hashSet = new HashSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A00(8, 6, 23));
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i8 = jSONArrayOptJSONArray.length();
            if (A04[2].charAt(7) != 'M') {
                throw new RuntimeException();
            }
            A04[0] = "HjevAVNXdTQxpc55Yqf8Zim5Y";
            if (i2 < i8) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject == null || (c1546eTA00 = C1546eT.A00(jSONObjectOptJSONObject)) == null) {
                    return null;
                }
                hashSet.add(c1546eTA00);
                i2++;
            } else {
                return hashSet;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1053Rj
    public final void A3s(InterfaceC1055Rl interfaceC1055Rl) {
        this.A02.add(interfaceC1055Rl);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1053Rj
    public final synchronized Set<InterfaceC1056Rm> A6p() {
        return new HashSet(this.A00);
    }
}

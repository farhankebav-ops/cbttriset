package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2119oG<K0, V0> {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{97, 116, 108, 97, 95, 112, 97, 96, 71, 97, 117, 111};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oG != com.google.common.collect.MultimapBuilder<K0, V0> */
    public AbstractC2119oG() {
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oG != com.google.common.collect.MultimapBuilder<K0, V0> */
    public /* synthetic */ AbstractC2119oG(C0610Ab c0610Ab) {
        this();
    }

    public static AbstractC2118oF<Object> A00(int expectedKeys) {
        AbstractC1966ll.A00(expectedKeys, A03(0, 12, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE));
        return new C0610Ab(expectedKeys);
    }

    public static <K0> AbstractC2118oF<K0> A01(Comparator<K0> comparator) {
        AbstractC1819jA.A04(comparator);
        return new AZ(comparator);
    }

    public static AbstractC2118oF<Comparable> A02() {
        return A01(AbstractC2133oV.A03());
    }
}

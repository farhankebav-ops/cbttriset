package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class A8 implements SharedViewpointManager {
    public static boolean A07;
    public static byte[] A08;
    public static String[] A09 = {"BoSaZzMMCoBoab6kFzr2tWGVTni5", "Vk9jbaVPkS6rtGXBWv67wEIKcLe3GnXQ", "GJsVZyBqNYZRU43kGmqANe", "Uv9MZIJr", "GbPwVrzkFOEMxWNTB1P9oG5CUgrItJXy", "gWutc4DO", "1FOrRj10jdO8", "rnakDij4LZYpzXru71B"};
    public InterfaceC2207q2 A00;
    public InterfaceC2196pp A01;
    public C2183pb A02;
    public final InterfaceC2197pq A04;
    public final ViewpointQeConfig A05;
    public final LinkedHashMap<Integer, Runnable> A06 = new LinkedHashMap<>();
    public final InterfaceC2196pp A03 = new A9(this);

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-28};
    }

    static {
        A04();
        A07 = false;
    }

    public A8(ViewpointQeConfig viewpointQeConfig, InterfaceC2207q2 interfaceC2207q2, InterfaceC2197pq interfaceC2197pq) {
        this.A05 = viewpointQeConfig;
        this.A00 = interfaceC2207q2;
        this.A04 = interfaceC2197pq;
    }

    public static A8 A01() {
        return new A8(new ViewpointQeConfig(), new AC(), null);
    }

    private void A05(AbstractC2199ps abstractC2199ps, InterfaceC2204px interfaceC2204px, A6 a62) {
        this.A02 = C2183pb.A00(this.A05, abstractC2199ps, interfaceC2204px, a62);
        if (0 != 0) {
            this.A02.A01(null);
        }
        this.A02.A02(this.A03);
        String[] strArr = A09;
        if (strArr[4].charAt(11) == strArr[1].charAt(11)) {
            throw new RuntimeException();
        }
        A09[7] = "2MhPhimmgHBptxasGUILH2";
    }

    private void A06(DspViewableNode dspViewableNode, C2205q0 c2205q0) {
        C2183pb c2183pb = this.A02;
        if (c2183pb != null && dspViewableNode != null) {
            if (this.A05.A00 && c2205q0 != null) {
                c2183pb.A04(dspViewableNode, c2205q0);
            } else {
                c2183pb.A03(dspViewableNode);
            }
        }
    }

    private void A07(DspViewableNode dspViewableNode, C2205q0 c2205q0, C2201pu c2201pu) {
        C2183pb c2183pb = this.A02;
        if (c2183pb != null && dspViewableNode != null && c2201pu != null) {
            if (this.A05.A00 && c2205q0 != null) {
                c2201pu.A02 = dspViewableNode.hashCode() + A02(0, 1, 27) + c2201pu.A08 + c2205q0;
                c2183pb.A05(dspViewableNode, c2205q0, c2201pu);
            } else {
                c2183pb.A06(dspViewableNode, c2201pu);
            }
        }
    }

    public final void A08(View view) {
        A06(view != null ? ViewpointViewNode.A00(view) : null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pu != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public final void A09(View view, C2201pu<?, ?> c2201pu) {
        A07(view != null ? ViewpointViewNode.A00(view) : null, null, c2201pu);
    }

    public final void A0A(AbstractC2199ps abstractC2199ps, View view) {
        if (abstractC2199ps != null && view != null) {
            A05(abstractC2199ps, new AA(view, this.A00), new C1H(null));
        }
    }
}

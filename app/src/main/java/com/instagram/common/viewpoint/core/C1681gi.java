package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [com.facebook.ads.internal.util.common.Stateful<android.os.Bundle>] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1681gi {
    public static byte[] A03;
    public final O1 A00;
    public final InterfaceC1491dZ A01;
    public final List<C1680gh> A02;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-11, -10, -29, -10, -21, -11, -10, -21, -27, -11, -60, -75, -61, -60, -61};
    }

    public C1681gi(List<AbstractC0966Nz> list, Bundle bundle, InterfaceC1491dZ interfaceC1491dZ) {
        this.A02 = new ArrayList(list.size());
        this.A01 = interfaceC1491dZ;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 76));
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.A02.add(new C1680gh(list.get(i2), (Bundle) parcelableArrayList.get(i2)));
        }
        this.A00 = (O1) X2.A00(bundle.getByteArray(A00(0, 10, 126)));
    }

    public C1681gi(List<AbstractC0966Nz> list, InterfaceC1491dZ interfaceC1491dZ) {
        this.A02 = new ArrayList(list.size());
        this.A01 = interfaceC1491dZ;
        Iterator<AbstractC0966Nz> it = list.iterator();
        while (it.hasNext()) {
            this.A02.add(new C1680gh(it.next()));
        }
        this.A00 = new O1();
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 126), X2.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A02.size());
        Iterator<C1680gh> it = this.A02.iterator();
        while (it.hasNext()) {
            Bundle bundle2 = it.next().A05();
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(A00(10, 5, 76), arrayList);
        return bundle;
    }

    public final O1 A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        Iterator<C1680gh> it = this.A02.iterator();
        while (it.hasNext()) {
            it.next().A06();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double d8, double d9) {
        if (d9 >= 0.0d) {
            this.A00.A05(d8, d9);
        }
        double dA9N = this.A01.A9N();
        this.A00.A04(d8, dA9N);
        Iterator<C1680gh> it = this.A02.iterator();
        while (it.hasNext()) {
            it.next().A07(d8, dA9N);
        }
    }
}

package com.instagram.common.viewpoint.core;

import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ix, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1807ix implements InterfaceC04884w {
    public static String[] A08 = {"FmqEYLEjOBovlIuvu7xTusZ6GIuR3pge", "QeU0DUuOAkxor0HSqOzEAO6P6r4bp110", "WNDsEfwHyCZVTn6rYNycLV5FNYvDeUGR", "", "9kl6sBOZXnbWpCxdvxnR8wYz13jzyZGc", "QdIGCZBZzwjOBdbigrYBFiKU6cV", "ZYM92CzuhlmQLmzBChoRToTytAMTrYW0", "W1yocJmlBB3ILJesLtmFt5l7ilHzoTT3"};
    public int A00;
    public int A01;
    public InterfaceC04854t A02;
    public InterfaceC04884w A04;
    public InterfaceC0904Ln A05;
    public boolean A07;
    public InterfaceC04884w A03 = new C2085nh();
    public InterfaceC0913Lw A06 = InterfaceC0913Lw.A00;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.InterfaceC04884w
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C7S A5A() {
        return A01(this.A04 != null ? this.A04.A5A() : null, this.A00, this.A01);
    }

    private C7S A01(InterfaceC2089nl interfaceC2089nl, int i2, int i8) {
        C1808iy c1808iyA59;
        InterfaceC0904Ln interfaceC0904Ln = (InterfaceC0904Ln) C3M.A01(this.A05);
        if (this.A07 || interfaceC2089nl == null) {
            c1808iyA59 = null;
        } else if (this.A02 != null) {
            InterfaceC04854t interfaceC04854t = this.A02;
            String[] strArr = A08;
            if (strArr[6].charAt(29) == strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "BsDku37cs2h0edzjFuAGMntAOCTwp5qB";
            strArr2[1] = "0s0KxP1bBIf3QxkhX8XEl0TpXhOFUtvY";
            c1808iyA59 = interfaceC04854t.A59();
        } else {
            c1808iyA59 = new C1809iz().A00(interfaceC0904Ln).A59();
        }
        return new C7S(interfaceC0904Ln, interfaceC2089nl, this.A03.A5A(), c1808iyA59, this.A06, i2, null, i8, null);
    }

    public final AnonymousClass31 A02() {
        return null;
    }

    public final C1807ix A03(int i2) {
        this.A00 = i2;
        return this;
    }

    public final C1807ix A04(InterfaceC04884w interfaceC04884w) {
        this.A03 = interfaceC04884w;
        return this;
    }

    public final C1807ix A05(InterfaceC04884w interfaceC04884w) {
        this.A04 = interfaceC04884w;
        return this;
    }

    public final C1807ix A06(InterfaceC0904Ln interfaceC0904Ln) {
        this.A05 = interfaceC0904Ln;
        return this;
    }

    public final C7S A07() {
        return A01(this.A04 != null ? this.A04.A5A() : null, this.A00 | 1, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
    }
}

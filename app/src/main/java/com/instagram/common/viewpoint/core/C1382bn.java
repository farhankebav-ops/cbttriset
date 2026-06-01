package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1382bn implements InterfaceC1076Sh {
    public static byte[] A04;
    public Context A00;
    public final InterfaceC1075Sg A02;
    public final AtomicBoolean A03 = new AtomicBoolean(false);
    public C1073Se A01 = A00();

    static {
        A03();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{113, 101, 122, 106, 102, 112, 97, 97, 124, 123, 114, 102, 106, 126, 112, 108};
    }

    public C1382bn(Context context, InterfaceC1075Sg interfaceC1075Sg) {
        this.A00 = context;
        this.A02 = interfaceC1075Sg;
    }

    private C1073Se A00() {
        return C1073Se.A00(AbstractC1149Ve.A00(this.A00).getString(A01(0, 16, 100), null));
    }

    private void A02() {
        this.A02.ABw(new C1439ci(this));
    }

    public final void A04(String[] strArr, Integer num, Integer num2) {
        C1073Se c1073Se = new C1073Se(strArr, num, num2);
        C1073Se newSettings = this.A01;
        if (c1073Se.equals(newSettings)) {
            return;
        }
        this.A01 = c1073Se;
        this.A03.set(true);
        SharedPreferences.Editor editorEdit = AbstractC1149Ve.A00(this.A00).edit();
        C1073Se newSettings2 = this.A01;
        editorEdit.putString(A01(0, 16, 100), newSettings2.A07()).apply();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Sh
    public final C1073Se A7c() {
        A02();
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Sh
    public final boolean AAY() {
        A02();
        if (this.A01 == null) {
            return false;
        }
        Set<String> setA0a = U7.A0a(this.A00);
        String identifier = this.A01.A07();
        Iterator<String> it = setA0a.iterator();
        while (it.hasNext()) {
            if (identifier.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Sh
    public final boolean AJC() {
        A02();
        return this.A03.getAndSet(false);
    }
}

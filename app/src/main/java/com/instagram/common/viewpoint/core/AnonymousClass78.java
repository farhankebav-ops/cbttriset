package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.78, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass78 extends AbstractC1752hy {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772012L;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{63, 60, 51, 51, 56, 47};
    }

    public AnonymousClass78(List<C0931Mp> list) {
        super(list);
    }

    public static AnonymousClass78 A00(JSONObject jSONObject, C1477dL c1477dL) {
        AnonymousClass78 anonymousClass78 = new AnonymousClass78(AbstractC1752hy.A08(jSONObject, c1477dL, new C1751hx()));
        anonymousClass78.A29(jSONObject);
        anonymousClass78.A1I(A01(0, 6, 6));
        return anonymousClass78;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0930Mo
    public final int A0l() {
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0930Mo
    public final int A0m() {
        return 0;
    }
}

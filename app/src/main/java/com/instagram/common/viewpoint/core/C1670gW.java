package com.instagram.common.viewpoint.core;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1670gW implements InterfaceC0979On {
    public static String[] A02 = {"gru2Lda4S7GCbNBLtOIdQEnlbYeRFwfL", "XnGCgKT7Pg2", "mKUX8sgZfunspLF5wjmFH8sDBtb3K48d", "jKk7kH4cQGBiDg5TKe33YqGV3AsPygQR", "TZdQK9usf81OKXIWMb61JsmxOZFMnA3k", "eyC2dzaRwXiJKVGsgdgz1meLL5sRgImY", "S4mkNNYHIh7xNNZ0OEskqLhCY0hDyySt", "ZXfiglEYlIOoTIuj216uQxYNuz12aQjw"};
    public final Rect A00 = new Rect();
    public final /* synthetic */ PH A01;

    public C1670gW(PH ph) {
        this.A01 = ph;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0979On
    public final PK ACL(View view, PK pk) {
        PK pkA06 = P3.A06(view, pk);
        if (pkA06.A07()) {
            return pkA06;
        }
        Rect rect = this.A00;
        rect.left = pkA06.A03();
        rect.top = pkA06.A05();
        rect.right = pkA06.A04();
        rect.bottom = pkA06.A02();
        int count = this.A01.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            PK pkA05 = P3.A05(this.A01.getChildAt(i2), pkA06);
            rect.left = Math.min(pkA05.A03(), rect.left);
            rect.top = Math.min(pkA05.A05(), rect.top);
            rect.right = Math.min(pkA05.A04(), rect.right);
            rect.bottom = Math.min(pkA05.A02(), rect.bottom);
        }
        int i8 = rect.left;
        int i9 = rect.top;
        int i10 = rect.right;
        int i11 = rect.bottom;
        if (A02[1].length() != 11) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[6] = "4mRHs0uPE72ppwyI9I2NgTpzqE63n9j5";
        strArr[2] = "Zp0DshFYJF7gm0rY227qRNMYobzVhEjB";
        PK applied = pkA06.A06(i8, i9, i10, i11);
        return applied;
    }
}

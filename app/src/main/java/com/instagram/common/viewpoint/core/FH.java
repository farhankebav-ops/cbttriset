package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FH extends QT {
    public static byte[] A0H;
    public static String[] A0I = {"oHxG", "", "w7XeyG7wcXlBDThCLG4YobF5JePdGcu8", "IQ8LgqWvoXOpUTXgnww89j6rU6uuZ1nj", "", "WKMwHhIum9", "0nm7H4VWCUBWNiJwCQAonSVvBZFyt", "hLsDwSpuFLAE"};
    public InterfaceC1365bW A02;
    public C1550eX A04;
    public List<C1444cn> A05;
    public boolean A09;
    public final int A0A;
    public final Context A0B;
    public final C1657gI A0C;
    public final AbstractC1019Qb A0D;
    public final Set<Integer> A0G = new HashSet();
    public boolean A08 = true;
    public boolean A06 = true;
    public boolean A07 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final InterfaceC1369ba A0F = new FK(this);
    public InterfaceC1367bY A03 = new FJ(this);
    public final InterfaceC1368bZ A0E = new FI(this);

    public static String A05(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        String[] strArr = A0I;
        if (strArr[0].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[7] = "Cbp585p0FHy9";
        strArr2[6] = "QC7w158vCCR5KGktiGCBodiqPhNZq";
        A0H = new byte[]{-122, -102, -103, -108, -92, -107, -111, -122, -98, -92, -118, -109, -122, -121, -111, -118, -119, -92, -107, -122, -105, -122, -110, 81, 91, 103, 78, 81, 90, 91, 92, 103, 94, 81, 76, 77, 87, 103, 88, 73, 90, 73, 85, -51, -58, -61, -52, -60, -68, -42, -61, -68, -51, -68, -61, -42, -57, -72, -55, -72, -60};
    }

    static {
        A08();
    }

    public FH(C03710h c03710h, int i2, List<C1444cn> list, C1550eX c1550eX, Bundle bundle) {
        this.A0C = c03710h.getLayoutManager();
        this.A0A = i2;
        this.A05 = list;
        this.A04 = c1550eX;
        this.A0D = new C1656gH(c03710h.getContext());
        this.A0B = c03710h.getContext();
        c03710h.A1h(this);
        A0D(bundle);
    }

    private AbstractC0830Ir A03(int i2, int i8) {
        return A04(i2, i8, true);
    }

    private AbstractC0830Ir A04(int i2, int i8, boolean z2) {
        AbstractC0830Ir abstractC0830Ir = null;
        while (i2 <= i8) {
            AbstractC0830Ir abstractC0830Ir2 = (AbstractC0830Ir) this.A0C.A1o(i2);
            if (abstractC0830Ir2 == null || abstractC0830Ir2.A1S()) {
                return null;
            }
            boolean zA0a = A0a(abstractC0830Ir2);
            if (abstractC0830Ir == null && abstractC0830Ir2.A1T() && zA0a && !this.A0G.contains(Integer.valueOf(i2)) && (!z2 || A0I(abstractC0830Ir2, this.A0A))) {
                abstractC0830Ir = abstractC0830Ir2;
            }
            if (abstractC0830Ir2.A1T() && !zA0a) {
                A0C(i2, false);
            }
            i2++;
        }
        return abstractC0830Ir;
    }

    private void A06() {
        if (!this.A07) {
            return;
        }
        int lastVisibleItem = this.A0C.A26();
        int firstVisibleItem = this.A0C.A27();
        AbstractC0830Ir abstractC0830IrA03 = A03(lastVisibleItem, firstVisibleItem);
        if (abstractC0830IrA03 != null) {
            abstractC0830IrA03.A1Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int iA25 = this.A0C.A25();
        if (iA25 != -1) {
            int curPos = this.A05.size();
            if (iA25 < curPos - 1) {
                int curPos2 = iA25 + 1;
                A0U(curPos2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(int i2) {
        AbstractC0830Ir abstractC0830IrA04 = A04(i2 + 1, this.A0C.A27(), false);
        if (abstractC0830IrA04 != null) {
            abstractC0830IrA04.A1Q();
            A0U(((Integer) abstractC0830IrA04.getTag(-1593835536)).intValue());
        }
    }

    private void A0A(int i2, int i8) {
        while (i2 <= i8) {
            A0T(i2);
            i2++;
        }
    }

    private final void A0B(int i2, int i8) {
        A0S(i2);
        A0S(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i2, boolean z2) {
        if (z2) {
            this.A0G.add(Integer.valueOf(i2));
        } else {
            this.A0G.remove(Integer.valueOf(i2));
        }
    }

    private void A0D(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 112), 0.0f);
        this.A07 = bundle.getBoolean(A05(0, 23, 62), true);
        this.A08 = bundle.getBoolean(A05(23, 20, 1), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H() {
        return this.A0A == 1;
    }

    public static boolean A0I(AbstractC1311ae abstractC1311ae, int i2) {
        int allowedAreaMaxX;
        int furthestX;
        if (i2 == 2) {
            allowedAreaMaxX = AbstractC1180Wl.A04.widthPixels - 1;
        } else {
            int width = abstractC1311ae.getWidth();
            int allowedAreaMinX = AbstractC1180Wl.A04.widthPixels;
            allowedAreaMaxX = (int) (((width + allowedAreaMinX) * 1.3f) / 2.0f);
        }
        if (i2 == 2) {
            furthestX = 1;
        } else {
            int i8 = AbstractC1180Wl.A04.widthPixels;
            int allowedAreaMinX2 = abstractC1311ae.getWidth();
            furthestX = (int) (((i8 - allowedAreaMinX2) * 0.7f) / 2.0f);
        }
        float x2 = abstractC1311ae.getX();
        int allowedAreaMinX3 = abstractC1311ae.getWidth();
        return ((int) (x2 + ((float) allowedAreaMinX3))) <= allowedAreaMaxX && abstractC1311ae.getX() >= ((float) furthestX);
    }

    private boolean A0J(AbstractC0830Ir abstractC0830Ir) {
        if (!this.A08 || !abstractC0830Ir.A1T()) {
            return false;
        }
        this.A08 = false;
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.QT
    public void A0L(C05246g c05246g, int i2) {
        super.A0L(c05246g, i2);
        if (i2 == 0) {
            this.A09 = true;
            A06();
        }
    }

    @Override // com.instagram.common.viewpoint.core.QT
    public void A0M(C05246g c05246g, int i2, int i8) {
        super.A0M(c05246g, i2, i8);
        this.A09 = false;
        if (this.A06) {
            this.A09 = true;
            A06();
            this.A06 = false;
        }
        int lastVisibleItem = this.A0C.A26();
        int firstVisibleItem = this.A0C.A27();
        A0B(lastVisibleItem, firstVisibleItem);
        A0A(lastVisibleItem, firstVisibleItem);
        A0V(lastVisibleItem, firstVisibleItem, i2);
    }

    public final InterfaceC1367bY A0N() {
        return this.A03;
    }

    public final InterfaceC1368bZ A0O() {
        return this.A0E;
    }

    public final InterfaceC1369ba A0P() {
        return this.A0F;
    }

    public final void A0Q() {
        this.A01 = -1;
        int iA27 = this.A0C.A27();
        for (int iA26 = this.A0C.A26(); iA26 <= iA27 && iA26 >= 0; iA26++) {
            AbstractC0830Ir card = (AbstractC0830Ir) this.A0C.A1o(iA26);
            String[] strArr = A0I;
            String str = strArr[1];
            String str2 = strArr[4];
            int lastPos = str.length();
            int firstPos = str2.length();
            if (lastPos != firstPos) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[0] = "4n0r";
            strArr2[5] = "UAml839wpr";
            if (card != null && card.A1S()) {
                this.A01 = iA26;
                card.A1P();
                return;
            }
        }
    }

    public final void A0R() {
        AbstractC0830Ir abstractC0830Ir = (AbstractC0830Ir) this.A0C.A1o(this.A01);
        if (abstractC0830Ir != null && this.A01 >= 0) {
            abstractC0830Ir.A1Q();
        }
    }

    public final void A0S(int i2) {
        AbstractC0830Ir abstractC0830Ir = (AbstractC0830Ir) this.A0C.A1o(i2);
        if (abstractC0830Ir != null && !A0a(abstractC0830Ir)) {
            A0Z(abstractC0830Ir, false);
        }
    }

    public final void A0T(int i2) {
        AbstractC0830Ir abstractC0830Ir = (AbstractC0830Ir) this.A0C.A1o(i2);
        if (abstractC0830Ir == null) {
            return;
        }
        if (A0a(abstractC0830Ir)) {
            A0Z(abstractC0830Ir, true);
        }
        if (A0J(abstractC0830Ir) && this.A05 != null) {
            this.A0F.setVolume(this.A05.get(((Integer) abstractC0830Ir.getTag(-1593835536)).intValue()).A03().A0H().A0A() ? 0.0f : 1.0f);
        }
    }

    public final void A0U(int i2) {
        this.A0D.A0A(i2);
        this.A0C.A1N(this.A0D);
    }

    public final void A0V(int i2, int i8, int i9) {
        if (!A0H() || this.A02 == null) {
            return;
        }
        int recomputeFrom = this.A0C.A25();
        if (recomputeFrom == -1) {
            recomputeFrom = i9 < 0 ? i2 : i8;
        }
        this.A02.AJp(recomputeFrom);
    }

    public final void A0W(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 112), this.A00);
        bundle.putBoolean(A05(0, 23, 62), this.A07);
        bundle.putBoolean(A05(23, 20, 1), this.A08);
    }

    public void A0X(View view, boolean z2) {
        view.setAlpha(z2 ? 1.0f : 0.5f);
    }

    public final void A0Y(InterfaceC1365bW interfaceC1365bW) {
        this.A02 = interfaceC1365bW;
    }

    public void A0Z(AbstractC0830Ir abstractC0830Ir, boolean z2) {
        if (A0H()) {
            A0X(abstractC0830Ir, z2);
        }
        if (!z2 && abstractC0830Ir.A1S()) {
            abstractC0830Ir.A1P();
        }
    }

    public boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }
}

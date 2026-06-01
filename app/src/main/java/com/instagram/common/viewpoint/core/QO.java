package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class QO {
    public static byte[] A0I;
    public static String[] A0J = {"xyZ8yvYzp3wrHAf7Yx6bEToOMuLBTkeJ", "zRc0P2oS", "sxpemPSbJ0zjH5L170Fpc8WIJnMfTOYM", "JLvxwq6R3Maitb0M5MelMbaPMbiMlz5H", "qno0WD9sdyP92Tf9SwtsGsNlEh6m7cws", "isTf1gingqqcw8OSNjwv80foOygzMJYI", "cYtNYfyLYrQzxoivZChv", "OeXF3cqFYKXlQ2ABbzPAkdUOYZHirWRh"};
    public int A00;
    public C1004Pm A01;
    public AbstractC1019Qb A02;
    public C05246g A03;
    public boolean A08;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public final InterfaceC1027Qj A0G = new C1645g6(this);
    public final InterfaceC1027Qj A0H = new C1644g5(this);
    public C1029Ql A04 = new C1029Ql(this.A0G);
    public C1029Ql A05 = new C1029Ql(this.A0H);
    public boolean A09 = false;
    public boolean A07 = false;
    public boolean A06 = false;
    public boolean A0F = true;
    public boolean A0E = true;

    public static String A09(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0I = new byte[]{99, -122, -122, -121, -122, 66, 120, -117, -121, -103, 66, -118, -125, -107, 66, 116, -121, -123, -101, -123, -114, -121, -108, 120, -117, -121, -103, 66, -125, -107, 66, -110, -125, -108, -121, -112, -106, 66, -124, -105, -106, 66, -104, -117, -121, -103, 66, -117, -107, 66, -112, -111, -106, 66, -125, 66, -108, -121, -125, -114, 66, -123, -118, -117, -114, -122, 80, 66, 119, -112, -120, -117, -114, -106, -121, -108, -121, -122, 66, -117, -112, -122, -121, -102, 92, -88, -58, -45, -45, -44, -39, -123, -46, -44, -37, -54, -123, -58, -123, -56, -51, -50, -47, -55, -123, -53, -41, -44, -46, -123, -45, -44, -45, -110, -54, -35, -50, -40, -39, -50, -45, -52, -123, -50, -45, -55, -54, -35, -97};
    }

    public abstract int A1f(int i2, QW qw, C1021Qd c1021Qd);

    public abstract int A1g(int i2, QW qw, C1021Qd c1021Qd);

    public abstract int A1h(C1021Qd c1021Qd);

    public abstract int A1i(C1021Qd c1021Qd);

    public abstract int A1j(C1021Qd c1021Qd);

    public abstract int A1k(C1021Qd c1021Qd);

    public abstract int A1l(C1021Qd c1021Qd);

    public abstract int A1m(C1021Qd c1021Qd);

    public abstract Parcelable A1n();

    public abstract View A1p(View view, int i2, QW qw, C1021Qd c1021Qd);

    public abstract QP A1q();

    public abstract void A1r(int i2);

    public abstract void A1s(int i2, int i8, C1021Qd c1021Qd, QM qm);

    public abstract void A1t(int i2, QM qm);

    public abstract void A1u(Parcelable parcelable);

    public abstract void A1w(QW qw, C1021Qd c1021Qd);

    public abstract void A1z(C05246g c05246g, C1021Qd c1021Qd, int i2);

    public abstract boolean A21();

    public abstract boolean A22();

    public abstract boolean A23();

    public abstract boolean A24();

    static {
        A0A();
    }

    public static int A02(int i2, int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                int iMax = Math.max(i8, i9);
                int size2 = A0J[1].length();
                if (size2 != 8) {
                    throw new RuntimeException();
                }
                A0J[1] = "W1fJ2ceK";
                int mode2 = Math.min(size, iMax);
                return mode2;
            case BasicMeasure.EXACTLY /* 1073741824 */:
                return size;
            default:
                int mode3 = Math.max(i8, i9);
                return mode3;
        }
    }

    public static int A03(int i2, int i8, int i9, int i10, boolean z2) {
        int iMax = Math.max(0, i2 - i9);
        int i11 = 0;
        int resultMode = 0;
        if (z2) {
            if (i10 >= 0) {
                i11 = i10;
                resultMode = BasicMeasure.EXACTLY;
            } else if (i10 == -1) {
                switch (i8) {
                    case Integer.MIN_VALUE:
                    case BasicMeasure.EXACTLY /* 1073741824 */:
                        i11 = iMax;
                        resultMode = i8;
                        break;
                    case 0:
                        i11 = 0;
                        resultMode = 0;
                        break;
                }
            } else if (i10 == -2) {
                i11 = 0;
                resultMode = 0;
            }
        } else if (i10 >= 0) {
            i11 = i10;
            resultMode = BasicMeasure.EXACTLY;
        } else if (i10 == -1) {
            i11 = iMax;
            resultMode = i8;
        } else if (i10 == -2) {
            i11 = iMax;
            resultMode = (i8 == Integer.MIN_VALUE || i8 == 1073741824) ? Integer.MIN_VALUE : 0;
        }
        int size = View.MeasureSpec.makeMeasureSpec(i11, resultMode);
        return size;
    }

    private final int A04(View view) {
        return ((QP) view.getLayoutParams()).A03.bottom;
    }

    private final int A05(View view) {
        return ((QP) view.getLayoutParams()).A03.left;
    }

    private final int A06(View view) {
        return ((QP) view.getLayoutParams()).A03.right;
    }

    private final int A07(View view) {
        return ((QP) view.getLayoutParams()).A03.top;
    }

    private final int A08(QW qw, C1021Qd c1021Qd) {
        return 0;
    }

    private final void A0B(int i2) {
        A0E(i2, A0v(i2));
    }

    private final void A0C(int i2) {
        View child = A0v(i2);
        if (child != null) {
            this.A01.A0D(i2);
        }
    }

    private final void A0D(int i2, int i8) {
        View view = A0v(i2);
        if (view != null) {
            A0B(i2);
            A0G(view, i8);
            String[] strArr = A0J;
            if (strArr[2].charAt(30) != strArr[5].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[0] = "fev5lwy8caKDFGGcVLFTWETO5UF90dOq";
            strArr2[7] = "EDoCIrgXqzBYQTf4WlngJinORtzJmrfl";
            return;
        }
        throw new IllegalArgumentException(A09(85, 44, 81) + i2 + this.A03.toString());
    }

    private void A0E(int i2, View view) {
        this.A01.A0C(i2);
    }

    private final void A0F(View view) {
        this.A01.A0F(view);
    }

    private final void A0G(View view, int i2) {
        A0H(view, i2, (QP) view.getLayoutParams());
    }

    private final void A0H(View view, int i2, QP qp) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (abstractC1024QgA0F.A0g()) {
            this.A03.A0t.A09(abstractC1024QgA0F);
        } else {
            this.A03.A0t.A0A(abstractC1024QgA0F);
        }
        this.A01.A0H(view, i2, qp, abstractC1024QgA0F.A0g());
    }

    private void A0I(View view, int i2, boolean z2) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (z2 || abstractC1024QgA0F.A0g()) {
            this.A03.A0t.A09(abstractC1024QgA0F);
        } else {
            this.A03.A0t.A0A(abstractC1024QgA0F);
        }
        QP qp = (QP) view.getLayoutParams();
        if (abstractC1024QgA0F.A0m() || abstractC1024QgA0F.A0h()) {
            if (abstractC1024QgA0F.A0h()) {
                abstractC1024QgA0F.A0Y();
            } else {
                abstractC1024QgA0F.A0U();
            }
            this.A01.A0H(view, i2, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            C05246g c05246g = this.A03;
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            A0J[4] = "uqKRxBtg59XPGVJDkfwEUsBOgdJYSppJ";
            if (parent == c05246g) {
                int currentIndex = this.A01.A07(view);
                if (i2 == -1) {
                    i2 = this.A01.A05();
                }
                if (currentIndex != -1) {
                    if (currentIndex != i2) {
                        this.A03.A06.A0D(currentIndex, i2);
                    }
                } else {
                    throw new IllegalStateException(A09(0, 85, 14) + this.A03.indexOfChild(view) + this.A03.A1J());
                }
            } else {
                this.A01.A0I(view, i2, false);
                qp.A01 = true;
                AbstractC1019Qb abstractC1019Qb = this.A02;
                if (A0J[4].charAt(12) == 'v') {
                    throw new RuntimeException();
                }
                A0J[6] = "si9YLNjLFs";
                if (abstractC1019Qb != null && this.A02.A0F()) {
                    this.A02.A0C(view);
                }
            }
        }
        if (qp.A02) {
            View view2 = abstractC1024QgA0F.A0H;
            if (A0J[1].length() != 8) {
                throw new RuntimeException();
            }
            A0J[1] = "bg493IDm";
            view2.invalidate();
            qp.A02 = false;
        }
    }

    private final void A0J(View view, Rect rect) {
        C05246g.A0o(view, rect);
    }

    private void A0L(QW qw, int i2, View view) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (abstractC1024QgA0F.A0l()) {
            return;
        }
        if (abstractC1024QgA0F.A0f()) {
            boolean zA0g = abstractC1024QgA0F.A0g();
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[2] = "wfzQKDpvqCerNRZHLtQvgaB031c5C1YU";
            strArr[5] = "KgFz3HBRwd8cETJWtdM1PF8pjKUjBKYl";
            if (!zA0g && !this.A03.A04.A0M()) {
                A0C(i2);
                qw.A0X(abstractC1024QgA0F);
                return;
            }
        }
        A0B(i2);
        qw.A0S(view);
        this.A03.A0t.A0C(abstractC1024QgA0F);
    }

    private final void A0M(QW qw, C1021Qd c1021Qd, AccessibilityEvent accessibilityEvent) {
        if (this.A03 == null || accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (!this.A03.canScrollVertically(1) && !this.A03.canScrollVertically(-1) && !this.A03.canScrollHorizontally(-1) && !this.A03.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        if (this.A03.A04 != null) {
            accessibilityEvent.setItemCount(this.A03.A04.A0B());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0N(com.instagram.common.viewpoint.core.QW r6, com.instagram.common.viewpoint.core.C1021Qd r7, com.instagram.common.viewpoint.core.PS r8) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.6g r0 = r5.A03
            r1 = -1
            boolean r0 = r0.canScrollVertically(r1)
            r3 = 1
            if (r0 != 0) goto L2d
            com.facebook.ads.redexgen.X.6g r0 = r5.A03
            boolean r4 = r0.canScrollHorizontally(r1)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.QO.A0J
            r0 = 3
            r1 = r1[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto L8e
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.QO.A0J
            java.lang.String r1 = "KDPDh71uiY9dw6lSrmH00w2HuhKAvOYl"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "F84YzGx02ov8ufnexIEGkhiaGhnINbYS"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto L35
        L2d:
            r0 = 8192(0x2000, float:1.148E-41)
            r8.A0N(r0)
            r8.A0R(r3)
        L35:
            com.facebook.ads.redexgen.X.6g r0 = r5.A03
            boolean r0 = r0.canScrollVertically(r3)
            if (r0 != 0) goto L5b
            com.facebook.ads.redexgen.X.6g r4 = r5.A03
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.QO.A0J
            r0 = 3
            r1 = r1[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto L7b
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.QO.A0J
            java.lang.String r1 = "8s5rDkFpP"
            r0 = 6
            r2[r0] = r1
            boolean r0 = r4.canScrollHorizontally(r3)
            if (r0 == 0) goto L63
        L5b:
            r0 = 4096(0x1000, float:5.74E-42)
            r8.A0N(r0)
            r8.A0R(r3)
        L63:
            int r3 = r5.A0t(r6, r7)
            int r2 = r5.A0s(r6, r7)
            boolean r1 = r5.A0R(r6, r7)
            int r0 = r5.A08(r6, r7)
            com.facebook.ads.redexgen.X.PP r0 = com.instagram.common.viewpoint.core.PP.A00(r3, r2, r1, r0)
            r8.A0P(r0)
            return
        L7b:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.QO.A0J
            java.lang.String r1 = "3WqpoC752q4h2Wya5fT3BPHdY3ZkhgYP"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "HauWKBzmz4VUJQZuXSWVI1MWGOc6zBYt"
            r0 = 5
            r2[r0] = r1
            boolean r0 = r4.canScrollHorizontally(r3)
            if (r0 == 0) goto L63
            goto L5b
        L8e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.QO.A0N(com.facebook.ads.redexgen.X.QW, com.facebook.ads.redexgen.X.Qd, com.facebook.ads.redexgen.X.PS):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(AbstractC1019Qb abstractC1019Qb) {
        if (this.A02 == abstractC1019Qb) {
            this.A02 = null;
        }
    }

    private final boolean A0P() {
        return this.A02 != null && this.A02.A0F();
    }

    public static boolean A0Q(int i2, int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        if (i9 > 0 && i2 != i9) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size >= i2) {
                }
                break;
            case 0:
                break;
            case BasicMeasure.EXACTLY /* 1073741824 */:
                if (size == i2) {
                }
                break;
        }
        return false;
    }

    private final boolean A0R(QW qw, C1021Qd c1021Qd) {
        return false;
    }

    private final boolean A0S(QW qw, C1021Qd c1021Qd, int i2, Bundle bundle) {
        if (this.A03 == null) {
            return false;
        }
        int hScroll = 0;
        int i8 = 0;
        switch (i2) {
            case 4096:
                if (this.A03.canScrollVertically(1)) {
                    int hScroll2 = A0Z();
                    int vScroll = A0i();
                    int hScroll3 = hScroll2 - vScroll;
                    int vScroll2 = A0f();
                    hScroll = hScroll3 - vScroll2;
                }
                if (this.A03.canScrollHorizontally(1)) {
                    int iA0j = A0j();
                    int vScroll3 = A0g();
                    int i9 = iA0j - vScroll3;
                    int vScroll4 = A0h();
                    i8 = i9 - vScroll4;
                }
                break;
            case 8192:
                if (this.A03.canScrollVertically(-1)) {
                    int hScroll4 = A0Z();
                    int vScroll5 = A0i();
                    int hScroll5 = hScroll4 - vScroll5;
                    int vScroll6 = A0f();
                    hScroll = -(hScroll5 - vScroll6);
                }
                if (this.A03.canScrollHorizontally(-1)) {
                    int iA0j2 = A0j();
                    int vScroll7 = A0g();
                    int i10 = iA0j2 - vScroll7;
                    int vScroll8 = A0h();
                    i8 = -(i10 - vScroll8);
                }
                break;
        }
        if (hScroll == 0 && i8 == 0) {
            return false;
        }
        this.A03.scrollBy(i8, hScroll);
        return true;
    }

    private final boolean A0T(QW qw, C1021Qd c1021Qd, View view, int i2, Bundle bundle) {
        return false;
    }

    private boolean A0U(C05246g c05246g, int i2, int i8) {
        View focusedChild = c05246g.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int parentBottom = A0g();
        int parentRight = A0i();
        int parentTop = A0j();
        int parentTop2 = parentTop - A0h();
        int parentLeft = A0Z();
        int parentLeft2 = parentLeft - A0f();
        Rect rect = this.A03.A0p;
        A0J(focusedChild, rect);
        if (rect.left - i2 >= parentTop2 || rect.right - i2 <= parentBottom || rect.top - i8 >= parentLeft2 || rect.bottom - i8 <= parentRight) {
            return false;
        }
        return true;
    }

    @Deprecated
    private final boolean A0V(C05246g c05246g, View view, View view2) {
        return A0P() || c05246g.A1s();
    }

    private int[] A0W(View view, Rect rect) {
        int[] iArr = new int[2];
        int offScreenRight = A0g();
        int offScreenTop = A0i();
        int dy = A0j() - A0h();
        int offScreenLeft = A0Z() - A0f();
        int childBottom = (view.getLeft() + rect.left) - view.getScrollX();
        int childRight = (view.getTop() + rect.top) - view.getScrollY();
        int childLeft = rect.width() + childBottom;
        int parentLeft = rect.height();
        int parentBottom = Math.min(0, childBottom - offScreenRight);
        int parentRight = Math.min(0, childRight - offScreenTop);
        int parentTop = Math.max(0, childLeft - dy);
        int parentLeft2 = Math.max(0, (parentLeft + childRight) - offScreenLeft);
        if (A0c() == 1) {
            if (parentTop == 0) {
                parentTop = Math.max(parentBottom, childLeft - dy);
            }
        } else {
            parentTop = parentBottom != 0 ? parentBottom : Math.min(childBottom - offScreenRight, parentTop);
        }
        if (parentRight == 0) {
            parentRight = Math.min(childRight - offScreenTop, parentLeft2);
        }
        iArr[0] = parentTop;
        iArr[1] = parentRight;
        return iArr;
    }

    public final int A0X() {
        return -1;
    }

    public final int A0Y() {
        if (this.A01 != null) {
            return this.A01.A05();
        }
        return 0;
    }

    public final int A0Z() {
        return this.A0A;
    }

    public final int A0a() {
        return this.A0B;
    }

    public final int A0b() {
        QC a8;
        if (this.A03 != null) {
            C05246g c05246g = this.A03;
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            A0J[4] = "NhHtbEzlhB3n2IblVpNcmlHtdyAdrFMd";
            a8 = c05246g.getAdapter();
        } else {
            a8 = null;
        }
        if (a8 != null) {
            return a8.A0B();
        }
        return 0;
    }

    public final int A0c() {
        return P3.A01(this.A03);
    }

    public final int A0d() {
        return P3.A02(this.A03);
    }

    public final int A0e() {
        return P3.A03(this.A03);
    }

    public final int A0f() {
        if (this.A03 != null) {
            return this.A03.getPaddingBottom();
        }
        return 0;
    }

    public final int A0g() {
        if (this.A03 != null) {
            return this.A03.getPaddingLeft();
        }
        return 0;
    }

    public final int A0h() {
        if (this.A03 != null) {
            return this.A03.getPaddingRight();
        }
        return 0;
    }

    public final int A0i() {
        if (this.A03 != null) {
            return this.A03.getPaddingTop();
        }
        return 0;
    }

    public final int A0j() {
        return this.A0C;
    }

    public final int A0k() {
        return this.A0D;
    }

    public final int A0l(View view) {
        return view.getBottom() + A04(view);
    }

    public final int A0m(View view) {
        return view.getLeft() - A05(view);
    }

    public final int A0n(View view) {
        Rect rect = ((QP) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0o(View view) {
        Rect rect = ((QP) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0p(View view) {
        return view.getRight() + A06(view);
    }

    public final int A0q(View view) {
        return view.getTop() - A07(view);
    }

    public final int A0r(View view) {
        return ((QP) view.getLayoutParams()).A00();
    }

    public int A0s(QW qw, C1021Qd c1021Qd) {
        if (this.A03 == null || this.A03.A04 == null || !A22()) {
            return 1;
        }
        return this.A03.A04.A0B();
    }

    public int A0t(QW qw, C1021Qd c1021Qd) {
        if (this.A03 == null || this.A03.A04 == null || !A23()) {
            return 1;
        }
        return this.A03.A04.A0B();
    }

    public final View A0u() {
        View focusedChild;
        if (this.A03 == null || (focusedChild = this.A03.getFocusedChild()) == null || this.A01.A0K(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public final View A0v(int i2) {
        if (this.A01 != null) {
            return this.A01.A09(i2);
        }
        return null;
    }

    public final View A0w(View view, int i2) {
        return null;
    }

    public QP A0x(Context context, AttributeSet attributeSet) {
        return new QP(context, attributeSet);
    }

    public QP A0y(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof QP) {
            return new QP((QP) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new QP((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new QP(layoutParams);
    }

    public final void A0z() {
        if (this.A02 != null) {
            this.A02.A09();
        }
    }

    public final void A10() {
        if (this.A03 != null) {
            this.A03.requestLayout();
        }
    }

    public final void A11(int i2) {
        if (this.A03 != null) {
            this.A03.A1V(i2);
        }
    }

    public final void A12(int i2) {
        if (this.A03 != null) {
            this.A03.A1W(i2);
        }
    }

    public final void A13(int i2, int i8) {
        this.A0C = View.MeasureSpec.getSize(i2);
        this.A0D = View.MeasureSpec.getMode(i2);
        if (this.A0D == 0 && !C05246g.A1B) {
            this.A0C = 0;
        }
        this.A0A = View.MeasureSpec.getSize(i8);
        this.A0B = View.MeasureSpec.getMode(i8);
        if (this.A0B == 0 && !C05246g.A1B) {
            this.A0A = 0;
        }
    }

    public final void A14(int i2, int i8) {
        int iA0Y = A0Y();
        if (iA0Y == 0) {
            this.A03.A1c(i2, i8);
            String[] strArr = A0J;
            String str = strArr[2];
            String str2 = strArr[5];
            int iCharAt = str.charAt(30);
            int count = str2.charAt(30);
            if (iCharAt != count) {
                throw new RuntimeException();
            }
            A0J[1] = "XwkGDyjU";
            return;
        }
        int i9 = Integer.MAX_VALUE;
        int i10 = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < iA0Y; i11++) {
            View viewA0v = A0v(i11);
            Rect rect = this.A03.A0p;
            A0J(viewA0v, rect);
            int count2 = rect.left;
            if (count2 < i9) {
                i9 = rect.left;
            }
            int count3 = rect.right;
            if (count3 > maxY) {
                maxY = rect.right;
            }
            int count4 = rect.top;
            if (count4 < i10) {
                i10 = rect.top;
            }
            int count5 = rect.bottom;
            if (count5 > maxX) {
                maxX = rect.bottom;
            }
        }
        this.A03.A0p.set(i9, i10, maxY, maxX);
        A17(this.A03.A0p, i2, i8);
    }

    public final void A15(int i2, int i8) {
        this.A03.setMeasuredDimension(i2, i8);
    }

    public final void A16(int i2, QW qw) {
        View view = A0v(i2);
        A0C(i2);
        qw.A0T(view);
    }

    public void A17(Rect rect, int i2, int i8) {
        int usedHeight = rect.width() + A0g() + A0h();
        int iHeight = rect.height();
        int usedWidth = A0i();
        int i9 = iHeight + usedWidth;
        int usedWidth2 = A0f();
        int width = i9 + usedWidth2;
        int usedWidth3 = A0e();
        int usedHeight2 = A02(i2, usedHeight, usedWidth3);
        int usedWidth4 = A0d();
        A15(usedHeight2, A02(i8, width, usedWidth4));
    }

    public final void A18(View view) {
        A1A(view, -1);
    }

    public final void A19(View view) {
        A1B(view, -1);
    }

    public final void A1A(View view, int i2) {
        A0I(view, i2, true);
    }

    public final void A1B(View view, int i2) {
        A0I(view, i2, false);
    }

    public final void A1C(View view, int i2, int i8) {
        QP qp = (QP) view.getLayoutParams();
        Rect rectA1D = this.A03.A1D(view);
        int i9 = i2 + rectA1D.left + rectA1D.right;
        int i10 = i8 + rectA1D.top + rectA1D.bottom;
        int iA03 = A03(A0j(), A0k(), A0g() + A0h() + qp.leftMargin + qp.rightMargin + i9, qp.width, A22());
        int iA0Z = A0Z();
        int iA0a = A0a();
        int widthSpec = A0i();
        int iA032 = A03(iA0Z, iA0a, widthSpec + A0f() + qp.topMargin + qp.bottomMargin + i10, qp.height, A23());
        if (A1Y(view, iA03, iA032, qp)) {
            view.measure(iA03, iA032);
        }
    }

    public final void A1D(View view, int i2, int i8, int i9, int i10) {
        QP qp = (QP) view.getLayoutParams();
        Rect rect = qp.A03;
        view.layout(rect.left + i2 + qp.leftMargin, rect.top + i8 + qp.topMargin, (i9 - rect.right) - qp.rightMargin, (i10 - rect.bottom) - qp.bottomMargin);
    }

    public final void A1E(View view, PS ps) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (abstractC1024QgA0F != null) {
            boolean zA0g = abstractC1024QgA0F.A0g();
            if (A0J[4].charAt(12) == 'v') {
                throw new RuntimeException();
            }
            A0J[1] = "uJMRqraa";
            if (!zA0g && !this.A01.A0K(abstractC1024QgA0F.A0H)) {
                A1M(this.A03.A0r, this.A03.A0s, view, ps);
            }
        }
    }

    public final void A1F(View view, QW qw) {
        A0F(view);
        qw.A0T(view);
    }

    public final void A1G(View view, boolean z2, Rect rect) {
        Matrix matrix;
        if (z2) {
            Rect rect2 = ((QP) view.getLayoutParams()).A03;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        C05246g c05246g = this.A03;
        String[] strArr = A0J;
        if (strArr[0].charAt(23) != strArr[7].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[0] = "0LJ8GvUexdNG1AG11Ii0XfPOyD5lBlCr";
        strArr2[7] = "NwYNIOYDHD2wNBVOHxFlNgVOQtOI4Jp5";
        if (c05246g != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.A03.A0q;
            rectF.set(rect);
            matrix.mapRect(rectF);
            int iFloor = (int) Math.floor(rectF.left);
            int iFloor2 = (int) Math.floor(rectF.top);
            double d8 = rectF.right;
            if (A0J[6].length() == 15) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0J;
            strArr3[0] = "AxZOVdXnwoPa2hByvRQIxFpOdsFmpigD";
            strArr3[7] = "eNbgBcin3tlOsNhY3b3xdMmObUbY1NrP";
            rect.set(iFloor, iFloor2, (int) Math.ceil(d8), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void A1H(PS ps) {
        A0N(this.A03.A0r, this.A03.A0s, ps);
    }

    public final void A1I(QW qw) {
        int iA0E = qw.A0E();
        for (int i2 = iA0E - 1; i2 >= 0; i2--) {
            View viewA0F = qw.A0F(i2);
            AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(viewA0F);
            if (!abstractC1024QgA0F.A0l()) {
                abstractC1024QgA0F.A0d(false);
                if (abstractC1024QgA0F.A0i()) {
                    this.A03.removeDetachedView(viewA0F, false);
                }
                if (this.A03.A05 != null) {
                    this.A03.A05.A0L(abstractC1024QgA0F);
                }
                abstractC1024QgA0F.A0d(true);
                qw.A0R(viewA0F);
            }
        }
        qw.A0L();
        if (iA0E > 0) {
            this.A03.invalidate();
        }
    }

    public final void A1J(QW qw) {
        int childCount = A0Y();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            A0L(qw, i2, A0v(i2));
        }
    }

    public final void A1K(QW qw) {
        for (int iA0Y = A0Y() - 1; iA0Y >= 0; iA0Y--) {
            if (!C05246g.A0F(A0v(iA0Y)).A0l()) {
                A16(iA0Y, qw);
            }
        }
    }

    public void A1L(QW qw, C1021Qd c1021Qd, int i2, int i8) {
        this.A03.A1c(i2, i8);
    }

    public void A1M(QW qw, C1021Qd c1021Qd, View view, PS ps) {
        PQ itemInfo = PQ.A00(A23() ? A0r(view) : 0, 1, A22() ? A0r(view) : 0, 1, false, false);
        ps.A0Q(itemInfo);
    }

    public final void A1N(AbstractC1019Qb abstractC1019Qb) {
        if (this.A02 != null) {
            AbstractC1019Qb abstractC1019Qb2 = this.A02;
            if (A0J[4].charAt(12) == 'v') {
                throw new RuntimeException();
            }
            A0J[6] = RequestConfiguration.MAX_AD_CONTENT_RATING_G;
            if (abstractC1019Qb != abstractC1019Qb2 && this.A02.A0F()) {
                AbstractC1019Qb abstractC1019Qb3 = this.A02;
                if (A0J[6].length() != 15) {
                    A0J[3] = "jdqDA9lv9LoPYcF6nkiuFYbBQf2p3Jna";
                    abstractC1019Qb3.A09();
                } else {
                    String[] strArr = A0J;
                    strArr[0] = "CfhUeeIqQu1BzHSX9SgRD70OnW7YoiZA";
                    strArr[7] = "rBLjTriW7e2LTgD4knhZEnVORkWVeovT";
                    abstractC1019Qb3.A09();
                }
            }
        }
        this.A02 = abstractC1019Qb;
        this.A02.A0D(this.A03, this);
    }

    public void A1O(C05246g c05246g) {
    }

    public final void A1P(C05246g c05246g) {
        this.A07 = true;
    }

    public final void A1Q(C05246g c05246g) {
        A13(View.MeasureSpec.makeMeasureSpec(c05246g.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(c05246g.getHeight(), BasicMeasure.EXACTLY));
    }

    public final void A1R(C05246g c05246g) {
        if (c05246g == null) {
            this.A03 = null;
            this.A01 = null;
            this.A0C = 0;
            this.A0A = 0;
        } else {
            this.A03 = c05246g;
            this.A01 = c05246g.A01;
            this.A0C = c05246g.getWidth();
            this.A0A = c05246g.getHeight();
        }
        this.A0D = BasicMeasure.EXACTLY;
        this.A0B = BasicMeasure.EXACTLY;
    }

    public final void A1S(C05246g c05246g, QW qw) {
        this.A07 = false;
        A1y(c05246g, qw);
    }

    public final void A1T(boolean z2) {
        this.A06 = z2;
    }

    public final boolean A1U() {
        int iA0Y = A0Y();
        for (int i2 = 0; i2 < iA0Y; i2++) {
            ViewGroup.LayoutParams layoutParams = A0v(i2).getLayoutParams();
            int childCount = layoutParams.width;
            if (childCount < 0) {
                int childCount2 = layoutParams.height;
                if (childCount2 < 0) {
                    return true;
                }
            }
        }
        if (A0J[4].charAt(12) == 'v') {
            throw new RuntimeException();
        }
        A0J[3] = "WAOKNqtGQ8ovYE750tJA7vys4k4qcWl2";
        return false;
    }

    public final boolean A1V() {
        return this.A03 != null && this.A03.A0B;
    }

    public final boolean A1W() {
        return this.A0E;
    }

    public final boolean A1X(int i2, Bundle bundle) {
        return A0S(this.A03.A0r, this.A03.A0s, i2, bundle);
    }

    public final boolean A1Y(View view, int i2, int i8, QP qp) {
        if (!view.isLayoutRequested()) {
            boolean z2 = this.A0F;
            String[] strArr = A0J;
            if (strArr[0].charAt(23) != strArr[7].charAt(23)) {
                throw new RuntimeException();
            }
            A0J[4] = "WuiXnf3Uz62WBJXd3E4QIRzbwyGUV3fL";
            if (z2 && A0Q(view.getWidth(), i2, qp.width) && A0Q(view.getHeight(), i8, qp.height)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A1Z(View view, int i2, Bundle bundle) {
        return A0T(this.A03.A0r, this.A03.A0s, view, i2, bundle);
    }

    public boolean A1a(QP qp) {
        return qp != null;
    }

    public final boolean A1b(C05246g c05246g, View view, Rect rect, boolean z2) {
        return A1c(c05246g, view, rect, z2, false);
    }

    public final boolean A1c(C05246g c05246g, View view, Rect rect, boolean z2, boolean z7) {
        int[] scrollAmount = A0W(view, rect);
        int i2 = scrollAmount[0];
        int i8 = scrollAmount[1];
        if ((z7 && !A0U(c05246g, i2, i8)) || (i2 == 0 && i8 == 0)) {
            return false;
        }
        if (z2) {
            c05246g.scrollBy(i2, i8);
        } else {
            c05246g.A1e(i2, i8);
        }
        return true;
    }

    public final boolean A1d(C05246g c05246g, C1021Qd c1021Qd, View view, View view2) {
        return A0V(c05246g, view, view2);
    }

    public final boolean A1e(C05246g c05246g, ArrayList<View> views, int i2, int i8) {
        return false;
    }

    public View A1o(int i2) {
        int iA0Y = A0Y();
        for (int i8 = 0; i8 < iA0Y; i8++) {
            View child = A0v(i8);
            AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(child);
            if (abstractC1024QgA0F != null) {
                int childCount = abstractC1024QgA0F.A0O();
                if (childCount == i2 && !abstractC1024QgA0F.A0l() && (this.A03.A0s.A07() || !abstractC1024QgA0F.A0g())) {
                    return child;
                }
            }
        }
        return null;
    }

    public void A1v(AccessibilityEvent accessibilityEvent) {
        A0M(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public void A1x(C1021Qd c1021Qd) {
    }

    public void A1y(C05246g c05246g, QW qw) {
    }

    public void A20(String str) {
        if (this.A03 != null) {
            this.A03.A1n(str);
        }
    }
}

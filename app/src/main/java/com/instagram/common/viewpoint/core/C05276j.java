package com.instagram.common.viewpoint.core;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05276j extends AbstractC1640g0 {
    public static TimeInterpolator A0B;
    public static String[] A0C = {"5", "w4FteHoxEZNBcBknXysU1QdwgOlgu", "XTfmSewcFvVIPqcU8HiF2JwhBroc2", "gTOT0dcLAsFp3JXaujmr6eSvv", "MioH3rC6822UBFONR3LUPujrkCbYq", "9Rk7JcSITmrZ17kamSQ7i6v9RKdnt", "plmSW6Ql", "PR6dCqey"};
    public ArrayList<AbstractC1024Qg> A0A = new ArrayList<>();
    public ArrayList<AbstractC1024Qg> A07 = new ArrayList<>();
    public ArrayList<C1014Pw> A09 = new ArrayList<>();
    public ArrayList<C1013Pv> A08 = new ArrayList<>();
    public ArrayList<ArrayList<AbstractC1024Qg>> A01 = new ArrayList<>();
    public ArrayList<ArrayList<C1014Pw>> A05 = new ArrayList<>();
    public ArrayList<ArrayList<C1013Pv>> A03 = new ArrayList<>();
    public ArrayList<AbstractC1024Qg> A00 = new ArrayList<>();
    public ArrayList<AbstractC1024Qg> A04 = new ArrayList<>();
    public ArrayList<AbstractC1024Qg> A06 = new ArrayList<>();
    public ArrayList<AbstractC1024Qg> A02 = new ArrayList<>();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.QK
    public final void A0H() {
        int size;
        for (int size2 = this.A09.size() - 1; size2 >= 0; size2--) {
            C1014Pw c1014Pw = this.A09.get(size2);
            View view = c1014Pw.A04.A0H;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            A0U(c1014Pw.A04);
            this.A09.remove(size2);
        }
        for (int size3 = this.A0A.size() - 1; size3 >= 0; size3--) {
            A0V(this.A0A.get(size3));
            this.A0A.remove(size3);
        }
        for (int size4 = this.A07.size() - 1; size4 >= 0; size4--) {
            AbstractC1024Qg abstractC1024Qg = this.A07.get(size4);
            abstractC1024Qg.A0H.setAlpha(1.0f);
            A0T(abstractC1024Qg);
            this.A07.remove(size4);
        }
        for (int size5 = this.A08.size() - 1; size5 >= 0; size5--) {
            ArrayList<C1013Pv> arrayList = this.A08;
            String[] strArr = A0C;
            if (strArr[0].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[4] = "IUveBZzBDFrSzC13ImzzVKkvQDdr2";
            strArr2[5] = "sCoWws78k8eiD0jPt8s7ggXNZv987";
            A00(arrayList.get(size5));
        }
        this.A08.clear();
        if (A0M()) {
            for (int size6 = this.A05.size() - 1; size6 >= 0; size6--) {
                ArrayList<C1014Pw> arrayList2 = this.A05.get(size6);
                for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                    C1014Pw c1014Pw2 = arrayList2.get(size7);
                    View view2 = c1014Pw2.A04.A0H;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    A0U(c1014Pw2.A04);
                    arrayList2.remove(size7);
                    if (arrayList2.isEmpty()) {
                        this.A05.remove(arrayList2);
                    }
                }
            }
            for (int size8 = this.A01.size() - 1; size8 >= 0; size8--) {
                ArrayList<AbstractC1024Qg> arrayList3 = this.A01.get(size8);
                for (int size9 = arrayList3.size() - 1; size9 >= 0; size9--) {
                    AbstractC1024Qg abstractC1024Qg2 = arrayList3.get(size9);
                    abstractC1024Qg2.A0H.setAlpha(1.0f);
                    A0T(abstractC1024Qg2);
                    arrayList3.remove(size9);
                    if (arrayList3.isEmpty()) {
                        ArrayList<ArrayList<AbstractC1024Qg>> arrayList4 = this.A01;
                        String[] strArr3 = A0C;
                        if (strArr3[0].length() != strArr3[3].length()) {
                            String[] strArr4 = A0C;
                            strArr4[7] = "VBPMrKBD";
                            strArr4[6] = "WZFlfD4M";
                            arrayList4.remove(arrayList3);
                        } else {
                            arrayList4.remove(arrayList3);
                        }
                    }
                }
            }
            ArrayList<ArrayList<C1013Pv>> arrayList5 = this.A03;
            String[] strArr5 = A0C;
            if (strArr5[7].length() != strArr5[6].length()) {
                size = arrayList5.size() - 1;
            } else {
                String[] strArr6 = A0C;
                strArr6[2] = "1rfkrkAxI3SWkdgenr27gUX73o6p1";
                strArr6[1] = "SSeA7srmTqf1oxxrlzMYS1BTDHSjo";
                size = arrayList5.size() - 1;
            }
            while (size >= 0) {
                ArrayList<C1013Pv> arrayList6 = this.A03.get(size);
                for (int size10 = arrayList6.size() - 1; size10 >= 0; size10--) {
                    A00(arrayList6.get(size10));
                    if (arrayList6.isEmpty()) {
                        this.A03.remove(arrayList6);
                    }
                }
                size--;
            }
            A03(this.A06);
            A03(this.A04);
            A03(this.A00);
            A03(this.A02);
            A0G();
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC1640g0
    public final boolean A0Z(AbstractC1024Qg abstractC1024Qg, int i2, int i8, int i9, int i10) {
        View view = abstractC1024Qg.A0H;
        int translationX = i2 + ((int) abstractC1024Qg.A0H.getTranslationX());
        int translationY = i8 + ((int) abstractC1024Qg.A0H.getTranslationY());
        A02(abstractC1024Qg);
        int i11 = i9 - translationX;
        int i12 = i10 - translationY;
        if (i11 == 0 && i12 == 0) {
            A0U(abstractC1024Qg);
            return false;
        }
        if (i11 != 0) {
            view.setTranslationX(-i11);
        }
        if (i12 != 0) {
            view.setTranslationY(-i12);
        }
        this.A09.add(new C1014Pw(abstractC1024Qg, translationX, translationY, i9, i10));
        return true;
    }

    private void A00(C1013Pv c1013Pv) {
        if (c1013Pv.A05 != null) {
            A05(c1013Pv, c1013Pv.A05);
        }
        if (c1013Pv.A04 != null) {
            A05(c1013Pv, c1013Pv.A04);
        }
    }

    private void A01(AbstractC1024Qg abstractC1024Qg) {
        View view = abstractC1024Qg.A0H;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A06.add(abstractC1024Qg);
        ViewPropertyAnimator animation = viewPropertyAnimatorAnimate.setDuration(A0D());
        animation.alpha(0.0f).setListener(new C1008Pq(this, abstractC1024Qg, viewPropertyAnimatorAnimate, view)).start();
    }

    private void A02(AbstractC1024Qg abstractC1024Qg) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        abstractC1024Qg.A0H.animate().setInterpolator(A0B);
        A0L(abstractC1024Qg);
    }

    private final void A03(List<AbstractC1024Qg> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).A0H.animate().cancel();
        }
    }

    private void A04(List<C1013Pv> list, AbstractC1024Qg abstractC1024Qg) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C1013Pv changeInfo = list.get(size);
            if (A05(changeInfo, abstractC1024Qg) && changeInfo.A05 == null && changeInfo.A04 == null) {
                list.remove(changeInfo);
            }
        }
    }

    private boolean A05(C1013Pv c1013Pv, AbstractC1024Qg abstractC1024Qg) {
        boolean z2 = false;
        if (c1013Pv.A04 == abstractC1024Qg) {
            c1013Pv.A04 = null;
        } else {
            AbstractC1024Qg abstractC1024Qg2 = c1013Pv.A05;
            String[] strArr = A0C;
            if (strArr[2].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "F";
            strArr2[3] = "q2hYYatvKRTsdUwOPBYP5pb4s";
            if (abstractC1024Qg2 == abstractC1024Qg) {
                c1013Pv.A05 = null;
                z2 = true;
            } else {
                return false;
            }
        }
        abstractC1024Qg.A0H.setAlpha(1.0f);
        abstractC1024Qg.A0H.setTranslationX(0.0f);
        abstractC1024Qg.A0H.setTranslationY(0.0f);
        A0W(abstractC1024Qg, z2);
        return true;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0033 */
    @Override // com.instagram.common.viewpoint.core.QK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0I() {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C05276j.A0I():void");
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final void A0L(AbstractC1024Qg abstractC1024Qg) {
        View view = abstractC1024Qg.A0H;
        view.animate().cancel();
        for (int i2 = this.A09.size() - 1; i2 >= 0; i2--) {
            if (this.A09.get(i2).A04 == abstractC1024Qg) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                A0U(abstractC1024Qg);
                this.A09.remove(i2);
            }
        }
        A04(this.A08, abstractC1024Qg);
        if (this.A0A.remove(abstractC1024Qg)) {
            view.setAlpha(1.0f);
            A0V(abstractC1024Qg);
        }
        if (this.A07.remove(abstractC1024Qg)) {
            view.setAlpha(1.0f);
            String[] strArr = A0C;
            if (strArr[2].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[4] = "yxRUaByjpu2evyevZXzo5CX3I8dRP";
            strArr2[5] = "IuT2zeZcrCaCkdpAEhiSgQgKuQzMH";
            A0T(abstractC1024Qg);
        }
        for (int i8 = this.A03.size() - 1; i8 >= 0; i8--) {
            ArrayList<C1013Pv> arrayList = this.A03.get(i8);
            A04(arrayList, abstractC1024Qg);
            if (arrayList.isEmpty()) {
                this.A03.remove(i8);
            }
        }
        for (int size = this.A05.size() - 1; size >= 0; size--) {
            ArrayList<C1014Pw> arrayList2 = this.A05.get(size);
            int i9 = arrayList2.size() - 1;
            while (true) {
                if (i9 < 0) {
                    break;
                }
                if (arrayList2.get(i9).A04 == abstractC1024Qg) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    A0U(abstractC1024Qg);
                    arrayList2.remove(i9);
                    if (arrayList2.isEmpty()) {
                        this.A05.remove(size);
                    }
                } else {
                    i9--;
                }
            }
        }
        for (int size2 = this.A01.size() - 1; size2 >= 0; size2--) {
            ArrayList<AbstractC1024Qg> arrayList3 = this.A01.get(size2);
            if (arrayList3.remove(abstractC1024Qg)) {
                view.setAlpha(1.0f);
                A0T(abstractC1024Qg);
                if (arrayList3.isEmpty()) {
                    this.A01.remove(size2);
                }
            }
        }
        this.A06.remove(abstractC1024Qg);
        this.A00.remove(abstractC1024Qg);
        this.A02.remove(abstractC1024Qg);
        this.A04.remove(abstractC1024Qg);
        A0b();
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0M() {
        return (this.A07.isEmpty() && this.A08.isEmpty() && this.A09.isEmpty() && this.A0A.isEmpty() && this.A04.isEmpty() && this.A06.isEmpty() && this.A00.isEmpty() && this.A02.isEmpty() && this.A05.isEmpty() && this.A01.isEmpty() && this.A03.isEmpty()) ? false : true;
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0S(AbstractC1024Qg abstractC1024Qg, List<Object> payloads) {
        return !payloads.isEmpty() || super.A0S(abstractC1024Qg, payloads);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1640g0
    public final boolean A0X(AbstractC1024Qg abstractC1024Qg) {
        A02(abstractC1024Qg);
        abstractC1024Qg.A0H.setAlpha(0.0f);
        this.A07.add(abstractC1024Qg);
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1640g0
    public final boolean A0Y(AbstractC1024Qg abstractC1024Qg) {
        A02(abstractC1024Qg);
        this.A0A.add(abstractC1024Qg);
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1640g0
    public final boolean A0a(AbstractC1024Qg abstractC1024Qg, AbstractC1024Qg abstractC1024Qg2, int i2, int i8, int i9, int i10) {
        if (abstractC1024Qg == abstractC1024Qg2) {
            return A0Z(abstractC1024Qg, i2, i8, i9, i10);
        }
        float translationX = abstractC1024Qg.A0H.getTranslationX();
        float translationY = abstractC1024Qg.A0H.getTranslationY();
        float prevTranslationY = abstractC1024Qg.A0H.getAlpha();
        A02(abstractC1024Qg);
        float prevTranslationX = i9 - i2;
        int deltaY = (int) (prevTranslationX - translationX);
        float prevTranslationX2 = i10 - i8;
        int deltaX = (int) (prevTranslationX2 - translationY);
        abstractC1024Qg.A0H.setTranslationX(translationX);
        abstractC1024Qg.A0H.setTranslationY(translationY);
        abstractC1024Qg.A0H.setAlpha(prevTranslationY);
        if (abstractC1024Qg2 != null) {
            A02(abstractC1024Qg2);
            float prevTranslationX3 = -deltaY;
            abstractC1024Qg2.A0H.setTranslationX(prevTranslationX3);
            float prevTranslationX4 = -deltaX;
            abstractC1024Qg2.A0H.setTranslationY(prevTranslationX4);
            abstractC1024Qg2.A0H.setAlpha(0.0f);
        }
        this.A08.add(new C1013Pv(abstractC1024Qg, abstractC1024Qg2, i2, i8, i9, i10));
        return true;
    }

    public final void A0b() {
        if (!A0M()) {
            A0G();
        }
    }

    public final void A0c(C1013Pv c1013Pv) {
        View view;
        AbstractC1024Qg holder = c1013Pv.A05;
        if (holder == null) {
            view = null;
        } else {
            view = holder.A0H;
        }
        AbstractC1024Qg holder2 = c1013Pv.A04;
        View view2 = holder2 != null ? holder2.A0H : null;
        if (view != null) {
            ViewPropertyAnimator oldViewAnim = view.animate().setDuration(A0B());
            this.A02.add(c1013Pv.A05);
            oldViewAnim.translationX(c1013Pv.A02 - c1013Pv.A00);
            oldViewAnim.translationY(c1013Pv.A03 - c1013Pv.A01);
            oldViewAnim.alpha(0.0f).setListener(new C1011Pt(this, c1013Pv, oldViewAnim, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.A02.add(c1013Pv.A04);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(A0B()).alpha(1.0f).setListener(new C1012Pu(this, c1013Pv, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public final void A0d(AbstractC1024Qg abstractC1024Qg) {
        View view = abstractC1024Qg.A0H;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A00.add(abstractC1024Qg);
        ViewPropertyAnimator animation = viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(A0A());
        animation.setListener(new C1009Pr(this, abstractC1024Qg, view, viewPropertyAnimatorAnimate)).start();
    }

    public final void A0e(AbstractC1024Qg abstractC1024Qg, int i2, int i8, int i9, int i10) {
        View view = abstractC1024Qg.A0H;
        int i11 = i9 - i2;
        int i12 = i10 - i8;
        if (i11 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i12 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A04.add(abstractC1024Qg);
        viewPropertyAnimatorAnimate.setDuration(A0C()).setListener(new C1010Ps(this, abstractC1024Qg, i11, view, i12, viewPropertyAnimatorAnimate)).start();
    }
}

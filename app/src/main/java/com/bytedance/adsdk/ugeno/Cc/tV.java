package com.bytedance.adsdk.ugeno.Cc;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class tV {
    static final /* synthetic */ boolean EO = true;
    private boolean[] Cc;
    int[] IlO;
    long[] MY;
    private final com.bytedance.adsdk.ugeno.Cc.IlO tV;
    private long[] vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        List<EO> IlO;
        int MY;

        public void IlO() {
            this.IlO = null;
            this.MY = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements Comparable<MY> {
        int IlO;
        int MY;

        private MY() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int compareTo(MY my) {
            int i2 = this.MY;
            int i8 = my.MY;
            return i2 != i8 ? i2 - i8 : this.IlO - my.IlO;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Order{order=");
            sb.append(this.MY);
            sb.append(", index=");
            return a0.c(sb, this.IlO, '}');
        }
    }

    public tV(com.bytedance.adsdk.ugeno.Cc.IlO ilO) {
        this.tV = ilO;
    }

    private int Cc(com.bytedance.adsdk.ugeno.Cc.MY my, boolean z2) {
        return z2 ? my.bWL() : my.hp();
    }

    private int EO(boolean z2) {
        return z2 ? this.tV.getPaddingTop() : this.tV.getPaddingStart();
    }

    private int tV(boolean z2) {
        return z2 ? this.tV.getPaddingBottom() : this.tV.getPaddingEnd();
    }

    private int vCE(com.bytedance.adsdk.ugeno.Cc.MY my, boolean z2) {
        return z2 ? my.zPa() : my.ea();
    }

    public int IlO(long j) {
        return (int) j;
    }

    public int MY(long j) {
        return (int) (j >> 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] IlO(View view, int i2, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.tV.getFlexItemCount();
        List<MY> listMY = MY(flexItemCount);
        MY my = new MY();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.Cc.MY)) {
            my.MY = 1;
        } else {
            my.MY = ((com.bytedance.adsdk.ugeno.Cc.MY) layoutParams).EO();
        }
        if (i2 == -1 || i2 == flexItemCount || i2 >= this.tV.getFlexItemCount()) {
            my.IlO = flexItemCount;
        } else {
            my.IlO = i2;
            while (i2 < flexItemCount) {
                listMY.get(i2).IlO++;
                i2++;
            }
        }
        listMY.add(my);
        return IlO(flexItemCount + 1, listMY, sparseIntArray);
    }

    public long MY(int i2, int i8) {
        return (((long) i2) & 4294967295L) | (((long) i8) << 32);
    }

    private int EO(com.bytedance.adsdk.ugeno.Cc.MY my, boolean z2) {
        if (z2) {
            return my.hp();
        }
        return my.bWL();
    }

    private List<MY> MY(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i8 = 0; i8 < i2; i8++) {
            com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) this.tV.IlO(i8).getLayoutParams();
            MY my2 = new MY();
            my2.MY = my.EO();
            my2.IlO = i8;
            arrayList.add(my2);
        }
        return arrayList;
    }

    private int tV(com.bytedance.adsdk.ugeno.Cc.MY my, boolean z2) {
        if (z2) {
            return my.ea();
        }
        return my.zPa();
    }

    private void EO(int i2) {
        boolean[] zArr = this.Cc;
        if (zArr == null) {
            this.Cc = new boolean[Math.max(i2, 10)];
        } else if (zArr.length < i2) {
            this.Cc = new boolean[Math.max(zArr.length * 2, i2)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public boolean MY(SparseIntArray sparseIntArray) {
        int flexItemCount = this.tV.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View viewIlO = this.tV.IlO(i2);
            if (viewIlO != null && ((com.bytedance.adsdk.ugeno.Cc.MY) viewIlO.getLayoutParams()).EO() != sparseIntArray.get(i2)) {
                return true;
            }
        }
        return false;
    }

    public void MY(IlO ilO, int i2, int i8) {
        IlO(ilO, i8, i2, Integer.MAX_VALUE, 0, -1, (List<EO>) null);
    }

    private int MY(boolean z2) {
        if (z2) {
            return this.tV.getPaddingEnd();
        }
        return this.tV.getPaddingBottom();
    }

    public int[] IlO(SparseIntArray sparseIntArray) {
        int flexItemCount = this.tV.getFlexItemCount();
        return IlO(flexItemCount, MY(flexItemCount), sparseIntArray);
    }

    private int MY(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int[] IlO(int i2, List<MY> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i8 = 0;
        for (MY my : list) {
            int i9 = my.IlO;
            iArr[i8] = i9;
            sparseIntArray.append(i9, my.MY);
            i8++;
        }
        return iArr;
    }

    private int MY(com.bytedance.adsdk.ugeno.Cc.MY my, boolean z2) {
        if (z2) {
            return my.MY();
        }
        return my.IlO();
    }

    private void MY(int i2, int i8, EO eo, int i9, int i10, boolean z2) {
        float f4;
        float f8;
        int iMax;
        int iBc;
        int i11 = eo.Cc;
        float f9 = eo.EV;
        float f10 = 0.0f;
        if (f9 <= 0.0f || i9 > i11) {
            return;
        }
        float f11 = (i11 - i9) / f9;
        eo.Cc = i10 + eo.vCE;
        if (!z2) {
            eo.Bc = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z7 = false;
        int i13 = 0;
        float f12 = 0.0f;
        while (i12 < eo.lEW) {
            int i14 = eo.ea + i12;
            View viewMY = this.tV.MY(i14);
            if (viewMY == null || viewMY.getVisibility() == 8) {
                f4 = f10;
                f8 = f11;
            } else {
                com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) viewMY.getLayoutParams();
                int flexDirection = this.tV.getFlexDirection();
                f4 = f10;
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewMY.getMeasuredHeight();
                    long[] jArr = this.vCE;
                    if (jArr != null) {
                        measuredHeight = MY(jArr[i14]);
                    }
                    int measuredWidth = viewMY.getMeasuredWidth();
                    long[] jArr2 = this.vCE;
                    if (jArr2 != null) {
                        measuredWidth = IlO(jArr2[i14]);
                    }
                    if (!this.Cc[i14] && my.Cc() > f4) {
                        float fCc = measuredHeight - (my.Cc() * f11);
                        if (i12 == eo.lEW - 1) {
                            fCc += f12;
                            f12 = f4;
                        }
                        int iRound = Math.round(fCc);
                        if (iRound < my.lEW()) {
                            iRound = my.lEW();
                            this.Cc[i14] = true;
                            eo.EV -= my.Cc();
                            z7 = true;
                        } else {
                            float f13 = (fCc - iRound) + f12;
                            double d8 = f13;
                            if (d8 > 1.0d) {
                                iRound++;
                                f13 -= 1.0f;
                            } else if (d8 < -1.0d) {
                                iRound--;
                                f13 += 1.0f;
                            }
                            f12 = f13;
                        }
                        int iIlO = IlO(i2, my, eo.hp);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewMY.measure(iIlO, iMakeMeasureSpec);
                        int measuredWidth2 = viewMY.getMeasuredWidth();
                        int measuredHeight2 = viewMY.getMeasuredHeight();
                        IlO(i14, iIlO, iMakeMeasureSpec, viewMY);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i13, my.ea() + my.hp() + measuredWidth + this.tV.IlO(viewMY));
                    eo.Cc = my.zPa() + my.bWL() + measuredHeight + eo.Cc;
                    f8 = f11;
                } else {
                    int measuredWidth3 = viewMY.getMeasuredWidth();
                    long[] jArr3 = this.vCE;
                    if (jArr3 != null) {
                        measuredWidth3 = IlO(jArr3[i14]);
                    }
                    int measuredHeight3 = viewMY.getMeasuredHeight();
                    long[] jArr4 = this.vCE;
                    f8 = f11;
                    if (jArr4 != null) {
                        measuredHeight3 = MY(jArr4[i14]);
                    }
                    if (!this.Cc[i14] && my.Cc() > f4) {
                        float fCc2 = measuredWidth3 - (my.Cc() * f8);
                        if (i12 == eo.lEW - 1) {
                            fCc2 += f12;
                            f12 = f4;
                        }
                        int iRound2 = Math.round(fCc2);
                        if (iRound2 < my.Bc()) {
                            iBc = my.Bc();
                            this.Cc[i14] = true;
                            eo.EV -= my.Cc();
                            z7 = true;
                        } else {
                            float f14 = (fCc2 - iRound2) + f12;
                            double d9 = f14;
                            if (d9 > 1.0d) {
                                iBc = iRound2 + 1;
                                f14 -= 1.0f;
                            } else if (d9 < -1.0d) {
                                iBc = iRound2 - 1;
                                f14 += 1.0f;
                            } else {
                                iBc = iRound2;
                            }
                            f12 = f14;
                        }
                        int iMY = MY(i8, my, eo.hp);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iBc, BasicMeasure.EXACTLY);
                        viewMY.measure(iMakeMeasureSpec2, iMY);
                        int measuredWidth4 = viewMY.getMeasuredWidth();
                        int measuredHeight4 = viewMY.getMeasuredHeight();
                        IlO(i14, iMakeMeasureSpec2, iMY, viewMY);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    int iMax2 = Math.max(i13, my.zPa() + my.bWL() + measuredHeight3 + this.tV.IlO(viewMY));
                    eo.Cc = my.ea() + my.hp() + measuredWidth3 + eo.Cc;
                    iMax = iMax2;
                }
                eo.Bc = Math.max(eo.Bc, iMax);
                i13 = iMax;
            }
            i12++;
            f11 = f8;
            f10 = f4;
        }
        if (!z7 || i11 == eo.Cc) {
            return;
        }
        MY(i2, i8, eo, i9, i10, true);
    }

    public void IlO(IlO ilO, int i2, int i8) {
        IlO(ilO, i2, i8, Integer.MAX_VALUE, 0, -1, (List<EO>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void IlO(IlO ilO, int i2, int i8, int i9, int i10, int i11, List<EO> list) {
        int i12;
        IlO ilO2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iIlO;
        int i18;
        int i19;
        int i20;
        EO eo;
        int i21;
        int i22;
        boolean z2;
        int i23;
        boolean z7;
        int i24;
        int i25 = i2;
        boolean zIlO = this.tV.IlO();
        int mode = View.MeasureSpec.getMode(i25);
        int size = View.MeasureSpec.getSize(i25);
        List<EO> arrayList = list == null ? new ArrayList() : list;
        ilO.IlO = arrayList;
        boolean z8 = i11 == -1;
        int iIlO2 = IlO(zIlO);
        int iMY = MY(zIlO);
        int iEO = EO(zIlO);
        int iTV = tV(zIlO);
        EO eo2 = new EO();
        int i26 = i10;
        eo2.ea = i26;
        int i27 = iIlO2 + iMY;
        eo2.Cc = i27;
        int flexItemCount = this.tV.getFlexItemCount();
        boolean z9 = z8;
        EO eo3 = eo2;
        int i28 = Integer.MIN_VALUE;
        int i29 = 0;
        int iCombineMeasuredStates = 0;
        int i30 = 0;
        while (true) {
            if (i26 >= flexItemCount) {
                i12 = iCombineMeasuredStates;
                ilO2 = ilO;
                break;
            }
            View viewMY = this.tV.MY(i26);
            if (viewMY == null) {
                if (IlO(i26, flexItemCount, eo3)) {
                    IlO(arrayList, eo3, i26, i29);
                }
                i13 = i27;
            } else {
                i13 = i27;
                if (viewMY.getVisibility() == 8) {
                    eo3.DmF++;
                    eo3.lEW++;
                    if (IlO(i26, flexItemCount, eo3)) {
                        IlO(arrayList, eo3, i26, i29);
                    }
                } else {
                    if (viewMY instanceof CompoundButton) {
                        IlO((CompoundButton) viewMY);
                    }
                    com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) viewMY.getLayoutParams();
                    int i31 = flexItemCount;
                    if (my.vCE() == 4) {
                        eo3.bWL.add(Integer.valueOf(i26));
                    }
                    int iIlO3 = IlO(my, zIlO);
                    if (my.rp() != -1.0f && mode == 1073741824) {
                        iIlO3 = Math.round(my.rp() * size);
                    }
                    if (zIlO) {
                        i15 = mode;
                        iIlO = this.tV.IlO(i25, i13 + EO(my, true) + tV(my, true), iIlO3);
                        i14 = size;
                        i16 = i29;
                        int iMY2 = this.tV.MY(i8, iEO + iTV + Cc(my, true) + vCE(my, true) + i29, MY(my, true));
                        viewMY.measure(iIlO, iMY2);
                        IlO(i26, iIlO, iMY2, viewMY);
                        i17 = 0;
                    } else {
                        i14 = size;
                        i15 = mode;
                        i16 = i29;
                        i17 = 0;
                        int iIlO4 = this.tV.IlO(i8, iEO + iTV + Cc(my, false) + vCE(my, false) + i16, MY(my, false));
                        int iMY3 = this.tV.MY(i25, i13 + EO(my, false) + tV(my, false), iIlO3);
                        viewMY.measure(iIlO4, iMY3);
                        IlO(i26, iIlO4, iMY3, viewMY);
                        iIlO = iMY3;
                    }
                    IlO(viewMY, i26);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewMY.getMeasuredState());
                    int i32 = i17;
                    i18 = i26;
                    int i33 = iIlO;
                    EO eo4 = eo3;
                    int i34 = i30;
                    i19 = i13;
                    i20 = i16;
                    boolean z10 = zIlO;
                    size = i14;
                    if (IlO(viewMY, i15, size, eo3.Cc, IlO(viewMY, zIlO) + EO(my, zIlO) + tV(my, zIlO), my, i18, i34, arrayList.size())) {
                        if (eo4.MY() > 0) {
                            IlO(arrayList, eo4, i18 > 0 ? i18 - 1 : i32, i20);
                            i24 = i20 + eo4.Bc;
                        } else {
                            i24 = i20;
                        }
                        if (z10) {
                            if (my.MY() == -1) {
                                com.bytedance.adsdk.ugeno.Cc.IlO ilO3 = this.tV;
                                viewMY.measure(i33, ilO3.MY(i8, my.zPa() + my.bWL() + ilO3.getPaddingTop() + this.tV.getPaddingBottom() + i24, my.MY()));
                                IlO(viewMY, i18);
                            }
                        } else if (my.IlO() == -1) {
                            com.bytedance.adsdk.ugeno.Cc.IlO ilO4 = this.tV;
                            viewMY.measure(ilO4.IlO(i8, my.ea() + my.hp() + ilO4.getPaddingLeft() + this.tV.getPaddingRight() + i24, my.IlO()), i33);
                            IlO(viewMY, i18);
                        }
                        EO eo5 = new EO();
                        eo5.lEW = 1;
                        eo5.Cc = i19;
                        eo5.ea = i18;
                        i20 = i24;
                        i21 = i32;
                        eo = eo5;
                        i22 = Integer.MIN_VALUE;
                    } else {
                        eo = eo4;
                        eo.lEW++;
                        i21 = i34 + 1;
                        i22 = i28;
                    }
                    eo.cl = (eo.cl ? 1 : 0) | (my.tV() != 0.0f ? 1 : i32);
                    eo.cL = (eo.cL ? 1 : 0) | (my.Cc() != 0.0f ? 1 : i32);
                    int[] iArr = this.IlO;
                    if (iArr != null) {
                        iArr[i18] = arrayList.size();
                    }
                    z2 = z10;
                    eo.Cc = IlO(viewMY, z2) + EO(my, z2) + tV(my, z2) + eo.Cc;
                    eo.NV = my.tV() + eo.NV;
                    eo.EV = my.Cc() + eo.EV;
                    this.tV.IlO(viewMY, i18, i21, eo);
                    int iMax = Math.max(i22, MY(viewMY, z2) + Cc(my, z2) + vCE(my, z2) + this.tV.IlO(viewMY));
                    eo.Bc = Math.max(eo.Bc, iMax);
                    if (z2) {
                        if (this.tV.getFlexWrap() != 2) {
                            eo.rp = Math.max(eo.rp, my.bWL() + viewMY.getBaseline());
                        } else {
                            eo.rp = Math.max(eo.rp, my.zPa() + (viewMY.getMeasuredHeight() - viewMY.getBaseline()));
                        }
                    }
                    i23 = i31;
                    if (IlO(i18, i23, eo)) {
                        IlO(arrayList, eo, i18, i20);
                        i20 += eo.Bc;
                    }
                    if (i11 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).zPa >= i11 && i18 >= i11 && !z9) {
                            i20 = -eo.IlO();
                            z7 = true;
                        }
                        if (i20 <= i9 && z7) {
                            ilO2 = ilO;
                            i12 = iCombineMeasuredStates;
                            break;
                        }
                        i28 = iMax;
                        z9 = z7;
                        i30 = i21;
                        int i35 = i18 + 1;
                        zIlO = z2;
                        eo3 = eo;
                        i27 = i19;
                        i29 = i20;
                        i25 = i2;
                        flexItemCount = i23;
                        i26 = i35;
                        mode = i15;
                    }
                    z7 = z9;
                    if (i20 <= i9) {
                    }
                    i28 = iMax;
                    z9 = z7;
                    i30 = i21;
                    int i352 = i18 + 1;
                    zIlO = z2;
                    eo3 = eo;
                    i27 = i19;
                    i29 = i20;
                    i25 = i2;
                    flexItemCount = i23;
                    i26 = i352;
                    mode = i15;
                }
            }
            i18 = i26;
            i15 = mode;
            i23 = flexItemCount;
            i20 = i29;
            z2 = zIlO;
            i19 = i13;
            eo = eo3;
            int i3522 = i18 + 1;
            zIlO = z2;
            eo3 = eo;
            i27 = i19;
            i29 = i20;
            i25 = i2;
            flexItemCount = i23;
            i26 = i3522;
            mode = i15;
        }
        ilO2.MY = i12;
    }

    private int MY(int i2, com.bytedance.adsdk.ugeno.Cc.MY my, int i8) {
        com.bytedance.adsdk.ugeno.Cc.IlO ilO = this.tV;
        int iMY = ilO.MY(i2, my.zPa() + my.bWL() + ilO.getPaddingTop() + this.tV.getPaddingBottom() + i8, my.MY());
        int size = View.MeasureSpec.getSize(iMY);
        if (size > my.NV()) {
            return View.MeasureSpec.makeMeasureSpec(my.NV(), View.MeasureSpec.getMode(iMY));
        }
        return size < my.lEW() ? View.MeasureSpec.makeMeasureSpec(my.lEW(), View.MeasureSpec.getMode(iMY)) : iMY;
    }

    public void MY(int i2, int i8, int i9) {
        int mode;
        int size;
        int flexDirection = this.tV.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
        } else {
            int mode2 = View.MeasureSpec.getMode(i8);
            int size2 = View.MeasureSpec.getSize(i8);
            mode = mode2;
            size = size2;
        }
        List<EO> flexLinesInternal = this.tV.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.tV.getSumOfCrossSize() + i9;
            int i10 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).Bc = size - i9;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.tV.getAlignContent();
                if (alignContent == 1) {
                    int i11 = size - sumOfCrossSize;
                    EO eo = new EO();
                    eo.Bc = i11;
                    flexLinesInternal.add(0, eo);
                    return;
                }
                if (alignContent == 2) {
                    this.tV.setFlexLines(IlO(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f4 = 0.0f;
                        while (i10 < size4) {
                            arrayList.add(flexLinesInternal.get(i10));
                            if (i10 != flexLinesInternal.size() - 1) {
                                EO eo2 = new EO();
                                if (i10 == flexLinesInternal.size() - 2) {
                                    eo2.Bc = Math.round(f4 + size3);
                                    f4 = 0.0f;
                                } else {
                                    eo2.Bc = Math.round(size3);
                                }
                                int i12 = eo2.Bc;
                                float f8 = (size3 - i12) + f4;
                                if (f8 > 1.0f) {
                                    eo2.Bc = i12 + 1;
                                    f8 -= 1.0f;
                                } else if (f8 < -1.0f) {
                                    eo2.Bc = i12 - 1;
                                    f8 += 1.0f;
                                }
                                f4 = f8;
                                arrayList.add(eo2);
                            }
                            i10++;
                        }
                        this.tV.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.tV.setFlexLines(IlO(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    EO eo3 = new EO();
                    eo3.Bc = size5;
                    for (EO eo4 : flexLinesInternal) {
                        arrayList2.add(eo3);
                        arrayList2.add(eo4);
                        arrayList2.add(eo3);
                    }
                    this.tV.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f9 = 0.0f;
                    while (i10 < size7) {
                        EO eo5 = flexLinesInternal.get(i10);
                        float f10 = eo5.Bc + size6;
                        if (i10 == flexLinesInternal.size() - 1) {
                            f10 += f9;
                            f9 = 0.0f;
                        }
                        int iRound = Math.round(f10);
                        float f11 = (f10 - iRound) + f9;
                        if (f11 > 1.0f) {
                            iRound++;
                            f11 -= 1.0f;
                        } else if (f11 < -1.0f) {
                            iRound--;
                            f11 += 1.0f;
                        }
                        f9 = f11;
                        eo5.Bc = iRound;
                        i10++;
                    }
                }
            }
        }
    }

    private void IlO(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) compoundButton.getLayoutParams();
        int iBc = my.Bc();
        int iLEW = my.lEW();
        Drawable drawableIlO = com.bytedance.adsdk.ugeno.Bc.Cc.IlO(compoundButton);
        int minimumWidth = drawableIlO == null ? 0 : drawableIlO.getMinimumWidth();
        int minimumHeight = drawableIlO != null ? drawableIlO.getMinimumHeight() : 0;
        if (iBc == -1) {
            iBc = minimumWidth;
        }
        my.IlO(iBc);
        if (iLEW == -1) {
            iLEW = minimumHeight;
        }
        my.MY(iLEW);
    }

    private int IlO(boolean z2) {
        if (z2) {
            return this.tV.getPaddingStart();
        }
        return this.tV.getPaddingTop();
    }

    private int IlO(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private void MY(View view, int i2, int i8) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i2 - my.hp()) - my.ea()) - this.tV.IlO(view), my.Bc()), my.DmF());
        long[] jArr = this.vCE;
        if (jArr != null) {
            measuredHeight = MY(jArr[i8]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        IlO(i8, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    private int IlO(com.bytedance.adsdk.ugeno.Cc.MY my, boolean z2) {
        if (z2) {
            return my.IlO();
        }
        return my.MY();
    }

    private boolean IlO(View view, int i2, int i8, int i9, int i10, com.bytedance.adsdk.ugeno.Cc.MY my, int i11, int i12, int i13) {
        if (this.tV.getFlexWrap() == 0) {
            return false;
        }
        if (my.EV()) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        int maxLine = this.tV.getMaxLine();
        if (maxLine != -1 && maxLine <= i13 + 1) {
            return false;
        }
        int iIlO = this.tV.IlO(view, i11, i12);
        if (iIlO > 0) {
            i10 += iIlO;
        }
        return i8 < i9 + i10;
    }

    private boolean IlO(int i2, int i8, EO eo) {
        return i2 == i8 - 1 && eo.MY() != 0;
    }

    private void IlO(List<EO> list, EO eo, int i2, int i8) {
        eo.hp = i8;
        this.tV.IlO(eo);
        eo.zPa = i2;
        list.add(eo);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.Cc.MY r0 = (com.bytedance.adsdk.ugeno.Cc.MY) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.Bc()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.Bc()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.DmF()
            if (r1 <= r3) goto L26
            int r1 = r0.DmF()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.lEW()
            if (r2 >= r5) goto L32
            int r2 = r0.lEW()
            goto L3e
        L32:
            int r5 = r0.NV()
            if (r2 <= r5) goto L3d
            int r2 = r0.NV()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.IlO(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.Cc.tV.IlO(android.view.View, int):void");
    }

    public void IlO(int i2, int i8) {
        IlO(i2, i8, 0);
    }

    public void IlO(int i2, int i8, int i9) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i10;
        int i11;
        EO(this.tV.getFlexItemCount());
        if (i9 >= this.tV.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.tV.getFlexDirection();
        int flexDirection2 = this.tV.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            int largestMainSize = this.tV.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.tV.getPaddingLeft();
            paddingRight = this.tV.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode2 = View.MeasureSpec.getMode(i8);
            size = View.MeasureSpec.getSize(i8);
            if (mode2 != 1073741824) {
                size = this.tV.getLargestMainSize();
            }
            paddingLeft = this.tV.getPaddingTop();
            paddingRight = this.tV.getPaddingBottom();
        }
        int i12 = paddingLeft + paddingRight;
        int i13 = size;
        int[] iArr = this.IlO;
        int i14 = iArr != null ? iArr[i9] : 0;
        List<EO> flexLinesInternal = this.tV.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i14 < size2) {
            EO eo = flexLinesInternal.get(i14);
            int i15 = eo.Cc;
            if (i15 < i13 && eo.cl) {
                i10 = i2;
                i11 = i8;
                IlO(i10, i11, eo, i13, i12, false);
            } else {
                i10 = i2;
                i11 = i8;
                if (i15 > i13 && eo.cL) {
                    MY(i10, i11, eo, i13, i12, false);
                }
            }
            i14++;
            i2 = i10;
            i8 = i11;
        }
    }

    private void IlO(int i2, int i8, EO eo, int i9, int i10, boolean z2) {
        int i11;
        float f4;
        float f8;
        int iMax;
        double d8;
        double d9;
        float f9 = eo.NV;
        float f10 = 0.0f;
        if (f9 <= 0.0f || i9 < (i11 = eo.Cc)) {
            return;
        }
        float f11 = (i9 - i11) / f9;
        eo.Cc = i10 + eo.vCE;
        if (!z2) {
            eo.Bc = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z7 = false;
        int i13 = 0;
        float f12 = 0.0f;
        while (i12 < eo.lEW) {
            int i14 = eo.ea + i12;
            View viewMY = this.tV.MY(i14);
            if (viewMY == null || viewMY.getVisibility() == 8) {
                f4 = f10;
                f8 = f11;
                z7 = z7;
            } else {
                com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) viewMY.getLayoutParams();
                int flexDirection = this.tV.getFlexDirection();
                f4 = f10;
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = viewMY.getMeasuredHeight();
                    long[] jArr = this.vCE;
                    if (jArr != null) {
                        measuredHeight = MY(jArr[i14]);
                    }
                    int measuredWidth = viewMY.getMeasuredWidth();
                    long[] jArr2 = this.vCE;
                    f8 = f11;
                    boolean z8 = z7;
                    if (jArr2 != null) {
                        measuredWidth = IlO(jArr2[i14]);
                    }
                    if (this.Cc[i14] || my.tV() <= f4) {
                        z7 = z8;
                    } else {
                        float fTV = (my.tV() * f8) + measuredHeight;
                        if (i12 == eo.lEW - 1) {
                            fTV += f12;
                            f12 = f4;
                        }
                        int iRound = Math.round(fTV);
                        if (iRound > my.NV()) {
                            iRound = my.NV();
                            this.Cc[i14] = true;
                            eo.NV -= my.tV();
                            z7 = true;
                        } else {
                            float f13 = (fTV - iRound) + f12;
                            double d10 = f13;
                            if (d10 > 1.0d) {
                                iRound++;
                                d9 = d10 - 1.0d;
                            } else {
                                if (d10 < -1.0d) {
                                    iRound--;
                                    d9 = d10 + 1.0d;
                                }
                                f12 = f13;
                                z7 = z8;
                            }
                            f13 = (float) d9;
                            f12 = f13;
                            z7 = z8;
                        }
                        int iIlO = IlO(i2, my, eo.hp);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewMY.measure(iIlO, iMakeMeasureSpec);
                        int measuredWidth2 = viewMY.getMeasuredWidth();
                        int measuredHeight2 = viewMY.getMeasuredHeight();
                        IlO(i14, iIlO, iMakeMeasureSpec, viewMY);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    iMax = Math.max(i13, my.ea() + my.hp() + measuredWidth + this.tV.IlO(viewMY));
                    eo.Cc = my.zPa() + my.bWL() + measuredHeight + eo.Cc;
                } else {
                    f8 = f11;
                    boolean z9 = z7;
                    int measuredWidth3 = viewMY.getMeasuredWidth();
                    long[] jArr3 = this.vCE;
                    if (jArr3 != null) {
                        measuredWidth3 = IlO(jArr3[i14]);
                    }
                    int measuredHeight3 = viewMY.getMeasuredHeight();
                    long[] jArr4 = this.vCE;
                    if (jArr4 != null) {
                        measuredHeight3 = MY(jArr4[i14]);
                    }
                    if (this.Cc[i14] || my.tV() <= f4) {
                        z7 = z9;
                    } else {
                        float fTV2 = (my.tV() * f8) + measuredWidth3;
                        if (i12 == eo.lEW - 1) {
                            fTV2 += f12;
                            f12 = f4;
                        }
                        int iRound2 = Math.round(fTV2);
                        if (iRound2 > my.DmF()) {
                            iRound2 = my.DmF();
                            this.Cc[i14] = true;
                            eo.NV -= my.tV();
                            z7 = true;
                        } else {
                            float f14 = (fTV2 - iRound2) + f12;
                            double d11 = f14;
                            if (d11 > 1.0d) {
                                iRound2++;
                                d8 = d11 - 1.0d;
                            } else {
                                if (d11 < -1.0d) {
                                    iRound2--;
                                    d8 = d11 + 1.0d;
                                }
                                f12 = f14;
                                z7 = z9;
                            }
                            f14 = (float) d8;
                            f12 = f14;
                            z7 = z9;
                        }
                        int iMY = MY(i8, my, eo.hp);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewMY.measure(iMakeMeasureSpec2, iMY);
                        int measuredWidth4 = viewMY.getMeasuredWidth();
                        int measuredHeight4 = viewMY.getMeasuredHeight();
                        IlO(i14, iMakeMeasureSpec2, iMY, viewMY);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    int iMax2 = Math.max(i13, my.zPa() + my.bWL() + measuredHeight3 + this.tV.IlO(viewMY));
                    eo.Cc = my.ea() + my.hp() + measuredWidth3 + eo.Cc;
                    iMax = iMax2;
                }
                eo.Bc = Math.max(eo.Bc, iMax);
                i13 = iMax;
            }
            i12++;
            f11 = f8;
            f10 = f4;
        }
        if (!z7 || i11 == eo.Cc) {
            return;
        }
        IlO(i2, i8, eo, i9, i10, true);
    }

    private int IlO(int i2, com.bytedance.adsdk.ugeno.Cc.MY my, int i8) {
        com.bytedance.adsdk.ugeno.Cc.IlO ilO = this.tV;
        int iIlO = ilO.IlO(i2, my.ea() + my.hp() + ilO.getPaddingLeft() + this.tV.getPaddingRight() + i8, my.IlO());
        int size = View.MeasureSpec.getSize(iIlO);
        if (size > my.DmF()) {
            return View.MeasureSpec.makeMeasureSpec(my.DmF(), View.MeasureSpec.getMode(iIlO));
        }
        return size < my.Bc() ? View.MeasureSpec.makeMeasureSpec(my.Bc(), View.MeasureSpec.getMode(iIlO)) : iIlO;
    }

    private List<EO> IlO(List<EO> list, int i2, int i8) {
        int i9 = (i2 - i8) / 2;
        ArrayList arrayList = new ArrayList();
        EO eo = new EO();
        eo.Bc = i9;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 == 0) {
                arrayList.add(eo);
            }
            arrayList.add(list.get(i10));
            if (i10 == list.size() - 1) {
                arrayList.add(eo);
            }
        }
        return arrayList;
    }

    public void IlO() {
        IlO(0);
    }

    public void IlO(int i2) {
        View viewMY;
        if (i2 >= this.tV.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.tV.getFlexDirection();
        if (this.tV.getAlignItems() == 4) {
            int[] iArr = this.IlO;
            List<EO> flexLinesInternal = this.tV.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i8 = iArr != null ? iArr[i2] : 0; i8 < size; i8++) {
                EO eo = flexLinesInternal.get(i8);
                int i9 = eo.lEW;
                for (int i10 = 0; i10 < i9; i10++) {
                    int i11 = eo.ea + i10;
                    if (i10 < this.tV.getFlexItemCount() && (viewMY = this.tV.MY(i11)) != null && viewMY.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) viewMY.getLayoutParams();
                        if (my.vCE() == -1 || my.vCE() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                }
                                MY(viewMY, eo.Bc, i11);
                            } else {
                                IlO(viewMY, eo.Bc, i11);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (EO eo2 : this.tV.getFlexLinesInternal()) {
            for (Integer num : eo2.bWL) {
                View viewMY2 = this.tV.MY(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                    }
                    MY(viewMY2, eo2.Bc, num.intValue());
                } else {
                    IlO(viewMY2, eo2.Bc, num.intValue());
                }
            }
        }
    }

    private void IlO(View view, int i2, int i8) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i2 - my.bWL()) - my.zPa()) - this.tV.IlO(view), my.lEW()), my.NV());
        long[] jArr = this.vCE;
        if (jArr != null) {
            measuredWidth = IlO(jArr[i8]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        IlO(i8, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    public void IlO(View view, EO eo, int i2, int i8, int i9, int i10) {
        com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) view.getLayoutParams();
        int alignItems = this.tV.getAlignItems();
        if (my.vCE() != -1) {
            alignItems = my.vCE();
        }
        int i11 = eo.Bc;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.tV.getFlexWrap() != 2) {
                    int i12 = i8 + i11;
                    view.layout(i2, (i12 - view.getMeasuredHeight()) - my.zPa(), i9, i12 - my.zPa());
                    return;
                }
                view.layout(i2, my.bWL() + view.getMeasuredHeight() + (i8 - i11), i9, my.bWL() + view.getMeasuredHeight() + (i10 - i11));
                return;
            }
            if (alignItems == 2) {
                int iBWL = ((my.bWL() + (i11 - view.getMeasuredHeight())) - my.zPa()) / 2;
                if (this.tV.getFlexWrap() != 2) {
                    int i13 = i8 + iBWL;
                    view.layout(i2, i13, i9, view.getMeasuredHeight() + i13);
                    return;
                } else {
                    int i14 = i8 - iBWL;
                    view.layout(i2, i14, i9, view.getMeasuredHeight() + i14);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.tV.getFlexWrap() != 2) {
                    int iMax = Math.max(eo.rp - view.getBaseline(), my.bWL());
                    view.layout(i2, i8 + iMax, i9, i10 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (eo.rp - view.getMeasuredHeight()), my.zPa());
                    view.layout(i2, i8 - iMax2, i9, i10 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.tV.getFlexWrap() != 2) {
            view.layout(i2, my.bWL() + i8, i9, my.bWL() + i10);
        } else {
            view.layout(i2, i8 - my.zPa(), i9, i10 - my.zPa());
        }
    }

    public void IlO(View view, EO eo, boolean z2, int i2, int i8, int i9, int i10) {
        com.bytedance.adsdk.ugeno.Cc.MY my = (com.bytedance.adsdk.ugeno.Cc.MY) view.getLayoutParams();
        int alignItems = this.tV.getAlignItems();
        if (my.vCE() != -1) {
            alignItems = my.vCE();
        }
        int i11 = eo.Bc;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z2) {
                    view.layout(((i2 + i11) - view.getMeasuredWidth()) - my.ea(), i8, ((i9 + i11) - view.getMeasuredWidth()) - my.ea(), i10);
                    return;
                }
                view.layout(my.hp() + view.getMeasuredWidth() + (i2 - i11), i8, my.hp() + view.getMeasuredWidth() + (i9 - i11), i10);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int iIlO = ((com.bytedance.adsdk.ugeno.Bc.vCE.IlO(marginLayoutParams) + (i11 - view.getMeasuredWidth())) - com.bytedance.adsdk.ugeno.Bc.vCE.MY(marginLayoutParams)) / 2;
                if (!z2) {
                    view.layout(i2 + iIlO, i8, i9 + iIlO, i10);
                    return;
                } else {
                    view.layout(i2 - iIlO, i8, i9 - iIlO, i10);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z2) {
            view.layout(my.hp() + i2, i8, my.hp() + i9, i10);
        } else {
            view.layout(i2 - my.ea(), i8, i9 - my.ea(), i10);
        }
    }

    private void IlO(int i2, int i8, int i9, View view) {
        long[] jArr = this.MY;
        if (jArr != null) {
            jArr[i2] = MY(i8, i9);
        }
        long[] jArr2 = this.vCE;
        if (jArr2 != null) {
            jArr2[i2] = MY(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
}

package com.bytedance.adsdk.ugeno.Cc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.Bc.Bc;
import com.bytedance.adsdk.ugeno.Cc.tV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends ViewGroup implements com.bytedance.adsdk.ugeno.Cc.IlO {
    private Drawable Bc;
    private int Cc;
    private int DmF;
    private int EO;
    private int EV;
    private int IlO;
    private int MY;
    private int NV;
    private SparseIntArray bWL;
    private tV.IlO cL;
    private com.bytedance.adsdk.ugeno.tV cl;
    private tV ea;
    private int[] hp;
    private Drawable lEW;
    private int rp;
    private int tV;
    private int vCE;
    private List<EO> zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends ViewGroup.MarginLayoutParams implements MY {
        public static final Parcelable.Creator<IlO> CREATOR = new Parcelable.Creator<IlO>() { // from class: com.bytedance.adsdk.ugeno.Cc.Cc.IlO.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public IlO createFromParcel(Parcel parcel) {
                return new IlO(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public IlO[] newArray(int i2) {
                return new IlO[i2];
            }
        };
        private int Bc;
        private float Cc;
        private int DmF;
        private float EO;
        private int IlO;
        private float MY;
        private boolean NV;
        private int lEW;
        private int tV;
        private int vCE;

        public IlO(IlO ilO) {
            super((ViewGroup.MarginLayoutParams) ilO);
            this.IlO = 1;
            this.MY = 0.0f;
            this.EO = 0.0f;
            this.tV = -1;
            this.Cc = -1.0f;
            this.vCE = -1;
            this.Bc = -1;
            this.lEW = ViewCompat.MEASURED_SIZE_MASK;
            this.DmF = ViewCompat.MEASURED_SIZE_MASK;
            this.IlO = ilO.IlO;
            this.MY = ilO.MY;
            this.EO = ilO.EO;
            this.tV = ilO.tV;
            this.Cc = ilO.Cc;
            this.vCE = ilO.vCE;
            this.Bc = ilO.Bc;
            this.lEW = ilO.lEW;
            this.DmF = ilO.DmF;
            this.NV = ilO.NV;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int Bc() {
            return this.vCE;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public float Cc() {
            return this.EO;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int DmF() {
            return this.lEW;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int EO() {
            return this.IlO;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public boolean EV() {
            return this.NV;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int IlO() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int MY() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int NV() {
            return this.DmF;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int bWL() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int ea() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int hp() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int lEW() {
            return this.Bc;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public float rp() {
            return this.Cc;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public float tV() {
            return this.MY;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int vCE() {
            return this.tV;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.IlO);
            parcel.writeFloat(this.MY);
            parcel.writeFloat(this.EO);
            parcel.writeInt(this.tV);
            parcel.writeFloat(this.Cc);
            parcel.writeInt(this.vCE);
            parcel.writeInt(this.Bc);
            parcel.writeInt(this.lEW);
            parcel.writeInt(this.DmF);
            parcel.writeByte(this.NV ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public int zPa() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        public void EO(int i2) {
            this.IlO = i2;
        }

        public void IlO(float f4) {
            this.MY = f4;
        }

        public void MY(float f4) {
            this.EO = f4;
        }

        public void tV(int i2) {
            this.tV = i2;
        }

        public void EO(float f4) {
            this.Cc = f4;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public void IlO(int i2) {
            this.vCE = i2;
        }

        @Override // com.bytedance.adsdk.ugeno.Cc.MY
        public void MY(int i2) {
            this.Bc = i2;
        }

        public IlO(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.IlO = 1;
            this.MY = 0.0f;
            this.EO = 0.0f;
            this.tV = -1;
            this.Cc = -1.0f;
            this.vCE = -1;
            this.Bc = -1;
            this.lEW = ViewCompat.MEASURED_SIZE_MASK;
            this.DmF = ViewCompat.MEASURED_SIZE_MASK;
        }

        public IlO(int i2, int i8) {
            super(new ViewGroup.LayoutParams(i2, i8));
            this.IlO = 1;
            this.MY = 0.0f;
            this.EO = 0.0f;
            this.tV = -1;
            this.Cc = -1.0f;
            this.vCE = -1;
            this.Bc = -1;
            this.lEW = ViewCompat.MEASURED_SIZE_MASK;
            this.DmF = ViewCompat.MEASURED_SIZE_MASK;
        }

        public IlO(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.IlO = 1;
            this.MY = 0.0f;
            this.EO = 0.0f;
            this.tV = -1;
            this.Cc = -1.0f;
            this.vCE = -1;
            this.Bc = -1;
            this.lEW = ViewCompat.MEASURED_SIZE_MASK;
            this.DmF = ViewCompat.MEASURED_SIZE_MASK;
        }

        public IlO(Parcel parcel) {
            super(0, 0);
            this.IlO = 1;
            this.MY = 0.0f;
            this.EO = 0.0f;
            this.tV = -1;
            this.Cc = -1.0f;
            this.vCE = -1;
            this.Bc = -1;
            this.lEW = ViewCompat.MEASURED_SIZE_MASK;
            this.DmF = ViewCompat.MEASURED_SIZE_MASK;
            this.IlO = parcel.readInt();
            this.MY = parcel.readFloat();
            this.EO = parcel.readFloat();
            this.tV = parcel.readInt();
            this.Cc = parcel.readFloat();
            this.vCE = parcel.readInt();
            this.Bc = parcel.readInt();
            this.lEW = parcel.readInt();
            this.DmF = parcel.readInt();
            this.NV = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public Cc(Context context) {
        super(context, null);
        this.vCE = -1;
        this.ea = new tV(this);
        this.zPa = new ArrayList();
        this.cL = new tV.IlO();
    }

    private boolean Cc(int i2, int i8) {
        for (int i9 = 1; i9 <= i8; i9++) {
            View viewEO = EO(i2 - i9);
            if (viewEO != null && viewEO.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean tV(int i2, int i8) {
        return Cc(i2, i8) ? IlO() ? (this.NV & 1) != 0 : (this.DmF & 1) != 0 : IlO() ? (this.NV & 2) != 0 : (this.DmF & 2) != 0;
    }

    private boolean vCE(int i2) {
        if (i2 >= 0 && i2 < this.zPa.size()) {
            for (int i8 = i2 + 1; i8 < this.zPa.size(); i8++) {
                if (this.zPa.get(i8).MY() > 0) {
                    return false;
                }
            }
            if (IlO()) {
                return (this.DmF & 4) != 0;
            }
            if ((this.NV & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public View EO(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.hp;
        if (i2 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i2]);
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int IlO(View view) {
        return 0;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public View MY(int i2) {
        return EO(i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.bWL == null) {
            this.bWL = new SparseIntArray(getChildCount());
        }
        this.hp = this.ea.IlO(view, i2, layoutParams, this.bWL);
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof IlO;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof IlO ? new IlO((IlO) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new IlO((ViewGroup.MarginLayoutParams) layoutParams) : new IlO(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getAlignContent() {
        return this.Cc;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getAlignItems() {
        return this.tV;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.Bc;
    }

    public Drawable getDividerDrawableVertical() {
        return this.lEW;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getFlexDirection() {
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<EO> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.zPa.size());
        for (EO eo : this.zPa) {
            if (eo.MY() != 0) {
                arrayList.add(eo);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public List<EO> getFlexLinesInternal() {
        return this.zPa;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getFlexWrap() {
        return this.MY;
    }

    public int getJustifyContent() {
        return this.EO;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getLargestMainSize() {
        Iterator<EO> it = this.zPa.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().Cc);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getMaxLine() {
        return this.vCE;
    }

    public int getShowDividerHorizontal() {
        return this.DmF;
    }

    public int getShowDividerVertical() {
        return this.NV;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int getSumOfCrossSize() {
        int size = this.zPa.size();
        int i2 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            EO eo = this.zPa.get(i8);
            if (tV(i8)) {
                i2 += IlO() ? this.EV : this.rp;
            }
            if (vCE(i8)) {
                i2 += IlO() ? this.EV : this.rp;
            }
            i2 += eo.Bc;
        }
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.tV tVVar = this.cl;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.tV tVVar = this.cl;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lEW == null && this.Bc == null) {
            return;
        }
        if (this.DmF == 0 && this.NV == 0) {
            return;
        }
        int iIlO = Bc.IlO(this);
        int i2 = this.IlO;
        if (i2 == 0) {
            IlO(canvas, iIlO == 1, this.MY == 2);
            return;
        }
        if (i2 == 1) {
            IlO(canvas, iIlO != 1, this.MY == 2);
            return;
        }
        if (i2 == 2) {
            boolean z2 = iIlO == 1;
            if (this.MY == 2) {
                z2 = !z2;
            }
            MY(canvas, z2, false);
            return;
        }
        if (i2 != 3) {
            return;
        }
        boolean z7 = iIlO == 1;
        if (this.MY == 2) {
            z7 = !z7;
        }
        MY(canvas, z7, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        boolean z7;
        Cc cc;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z8;
        Cc cc2;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z9;
        com.bytedance.adsdk.ugeno.tV tVVar = this.cl;
        if (tVVar != null) {
            tVVar.vCE();
        }
        int iIlO = Bc.IlO(this);
        int i19 = this.IlO;
        if (i19 == 0) {
            if (iIlO == 1) {
                z7 = true;
                cc = this;
                i11 = i2;
                i14 = i8;
                i13 = i10;
                i12 = i9;
            } else {
                z7 = false;
                cc = this;
                i11 = i2;
                i12 = i9;
                i13 = i10;
                i14 = i8;
            }
            cc.IlO(z7, i11, i14, i12, i13);
        } else if (i19 == 1) {
            if (iIlO != 1) {
                z8 = true;
                cc2 = this;
                i15 = i2;
                i18 = i8;
                i17 = i10;
                i16 = i9;
            } else {
                z8 = false;
                cc2 = this;
                i15 = i2;
                i16 = i9;
                i17 = i10;
                i18 = i8;
            }
            cc2.IlO(z8, i15, i18, i16, i17);
        } else if (i19 == 2) {
            z9 = iIlO == 1;
            if (this.MY == 2) {
                z9 = !z9;
            }
            IlO(z9, false, i2, i8, i9, i10);
        } else {
            if (i19 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.IlO);
            }
            z9 = iIlO == 1;
            if (this.MY == 2) {
                z9 = !z9;
            }
            IlO(z9, true, i2, i8, i9, i10);
        }
        com.bytedance.adsdk.ugeno.tV tVVar2 = this.cl;
        if (tVVar2 != null) {
            tVVar2.IlO(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        com.bytedance.adsdk.ugeno.tV tVVar = this.cl;
        if (tVVar != null) {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            IlO(iArrIlO[0], iArrIlO[1]);
        } else {
            IlO(i2, i8);
        }
        com.bytedance.adsdk.ugeno.tV tVVar2 = this.cl;
        if (tVVar2 != null) {
            tVVar2.Cc();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        com.bytedance.adsdk.ugeno.tV tVVar = this.cl;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    public void setAlignContent(int i2) {
        if (this.Cc != i2) {
            this.Cc = i2;
            requestLayout();
        }
    }

    public void setAlignItems(int i2) {
        if (this.tV != i2) {
            this.tV = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.Bc) {
            return;
        }
        this.Bc = drawable;
        if (drawable != null) {
            this.EV = drawable.getIntrinsicHeight();
        } else {
            this.EV = 0;
        }
        MY();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.lEW) {
            return;
        }
        this.lEW = drawable;
        if (drawable != null) {
            this.rp = drawable.getIntrinsicWidth();
        } else {
            this.rp = 0;
        }
        MY();
        requestLayout();
    }

    public void setFlexDirection(int i2) {
        if (this.IlO != i2) {
            this.IlO = i2;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public void setFlexLines(List<EO> list) {
        this.zPa = list;
    }

    public void setFlexWrap(int i2) {
        if (this.MY != i2) {
            this.MY = i2;
            requestLayout();
        }
    }

    public void setJustifyContent(int i2) {
        if (this.EO != i2) {
            this.EO = i2;
            requestLayout();
        }
    }

    public void setMaxLine(int i2) {
        if (this.vCE != i2) {
            this.vCE = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.DmF) {
            this.DmF = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.NV) {
            this.NV = i2;
            requestLayout();
        }
    }

    private void IlO(int i2, int i8) {
        if (this.bWL == null) {
            this.bWL = new SparseIntArray(getChildCount());
        }
        if (this.ea.MY(this.bWL)) {
            this.hp = this.ea.IlO(this.bWL);
        }
        int i9 = this.IlO;
        if (i9 == 0 || i9 == 1) {
            MY(i2, i8);
        } else if (i9 == 2 || i9 == 3) {
            EO(i2, i8);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.IlO);
        }
    }

    private void MY(int i2, int i8) {
        this.zPa.clear();
        this.cL.IlO();
        this.ea.IlO(this.cL, i2, i8);
        this.zPa = this.cL.IlO;
        this.ea.IlO(i2, i8);
        if (this.tV == 3) {
            for (EO eo : this.zPa) {
                int iMax = Integer.MIN_VALUE;
                for (int i9 = 0; i9 < eo.lEW; i9++) {
                    View viewEO = EO(eo.ea + i9);
                    if (viewEO != null && viewEO.getVisibility() != 8) {
                        IlO ilO = (IlO) viewEO.getLayoutParams();
                        iMax = this.MY != 2 ? Math.max(iMax, viewEO.getMeasuredHeight() + Math.max(eo.rp - viewEO.getBaseline(), ((ViewGroup.MarginLayoutParams) ilO).topMargin) + ((ViewGroup.MarginLayoutParams) ilO).bottomMargin) : Math.max(iMax, viewEO.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ilO).topMargin + Math.max(viewEO.getBaseline() + (eo.rp - viewEO.getMeasuredHeight()), ((ViewGroup.MarginLayoutParams) ilO).bottomMargin));
                    }
                }
                eo.Bc = iMax;
            }
        }
        this.ea.MY(i2, i8, getPaddingBottom() + getPaddingTop());
        this.ea.IlO();
        IlO(this.IlO, i2, i8, this.cL.MY);
    }

    private boolean Cc(int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            if (this.zPa.get(i8).MY() > 0) {
                return false;
            }
        }
        return true;
    }

    private void EO(int i2, int i8) {
        this.zPa.clear();
        this.cL.IlO();
        this.ea.MY(this.cL, i2, i8);
        this.zPa = this.cL.IlO;
        this.ea.IlO(i2, i8);
        this.ea.MY(i2, i8, getPaddingRight() + getPaddingLeft());
        this.ea.IlO();
        IlO(this.IlO, i2, i8, this.cL.MY);
    }

    private boolean tV(int i2) {
        if (i2 >= 0 && i2 < this.zPa.size()) {
            if (Cc(i2)) {
                return IlO() ? (this.DmF & 1) != 0 : (this.NV & 1) != 0;
            }
            if (IlO()) {
                return (this.DmF & 2) != 0;
            }
            if ((this.NV & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public View IlO(int i2) {
        return getChildAt(i2);
    }

    private void IlO(int i2, int i8, int i9, int i10) {
        int paddingBottom;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        if (i2 == 0 || i2 == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i2)));
            }
            paddingBottom = getLargestMainSize();
            largestMainSize = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i10 = View.combineMeasuredStates(i10, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i8, i10);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i8, i10);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i10 = View.combineMeasuredStates(i10, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i8, i10);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < paddingBottom) {
                i10 = View.combineMeasuredStates(i10, 256);
            } else {
                size2 = paddingBottom;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i9, i10);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(paddingBottom, i9, i10);
        } else if (mode2 == 1073741824) {
            if (size2 < paddingBottom) {
                i10 = View.combineMeasuredStates(i10, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i9, i10);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    private void MY(Canvas canvas, boolean z2, boolean z7) {
        int i2;
        int i8;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.zPa.size();
        for (int i9 = 0; i9 < size; i9++) {
            EO eo = this.zPa.get(i9);
            for (int i10 = 0; i10 < eo.lEW; i10++) {
                int i11 = eo.ea + i10;
                View viewEO = EO(i11);
                if (viewEO != null && viewEO.getVisibility() != 8) {
                    IlO ilO = (IlO) viewEO.getLayoutParams();
                    if (tV(i11, i10)) {
                        if (z7) {
                            top = viewEO.getBottom() + ((ViewGroup.MarginLayoutParams) ilO).bottomMargin;
                        } else {
                            top = (viewEO.getTop() - ((ViewGroup.MarginLayoutParams) ilO).topMargin) - this.EV;
                        }
                        MY(canvas, eo.IlO, top, eo.Bc);
                    }
                    if (i10 == eo.lEW - 1 && (this.DmF & 4) > 0) {
                        if (z7) {
                            bottom = (viewEO.getTop() - ((ViewGroup.MarginLayoutParams) ilO).topMargin) - this.EV;
                        } else {
                            bottom = viewEO.getBottom() + ((ViewGroup.MarginLayoutParams) ilO).bottomMargin;
                        }
                        MY(canvas, eo.IlO, bottom, eo.Bc);
                    }
                }
            }
            if (tV(i9)) {
                if (z2) {
                    i8 = eo.EO;
                } else {
                    i8 = eo.IlO - this.rp;
                }
                IlO(canvas, i8, paddingTop, iMax);
            }
            if (vCE(i9) && (this.NV & 4) > 0) {
                if (z2) {
                    i2 = eo.IlO - this.rp;
                } else {
                    i2 = eo.EO;
                }
                IlO(canvas, i2, paddingTop, iMax);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public boolean IlO() {
        int i2 = this.IlO;
        return i2 == 0 || i2 == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.Cc.Cc.IlO(boolean, int, int, int, int):void");
    }

    private void MY(Canvas canvas, int i2, int i8, int i9) {
        Drawable drawable = this.Bc;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i8, i9 + i2, this.EV + i8);
        this.Bc.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int MY(int i2, int i8, int i9) {
        return ViewGroup.getChildMeasureSpec(i2, i8, i9);
    }

    private void MY() {
        if (this.Bc == null && this.lEW == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(boolean r25, boolean r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.Cc.Cc.IlO(boolean, boolean, int, int, int, int):void");
    }

    private void IlO(Canvas canvas, boolean z2, boolean z7) {
        int i2;
        int i8;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.zPa.size();
        for (int i9 = 0; i9 < size; i9++) {
            EO eo = this.zPa.get(i9);
            for (int i10 = 0; i10 < eo.lEW; i10++) {
                int i11 = eo.ea + i10;
                View viewEO = EO(i11);
                if (viewEO != null && viewEO.getVisibility() != 8) {
                    IlO ilO = (IlO) viewEO.getLayoutParams();
                    if (tV(i11, i10)) {
                        if (z2) {
                            left = viewEO.getRight() + ((ViewGroup.MarginLayoutParams) ilO).rightMargin;
                        } else {
                            left = (viewEO.getLeft() - ((ViewGroup.MarginLayoutParams) ilO).leftMargin) - this.rp;
                        }
                        IlO(canvas, left, eo.MY, eo.Bc);
                    }
                    if (i10 == eo.lEW - 1 && (this.NV & 4) > 0) {
                        if (z2) {
                            right = (viewEO.getLeft() - ((ViewGroup.MarginLayoutParams) ilO).leftMargin) - this.rp;
                        } else {
                            right = viewEO.getRight() + ((ViewGroup.MarginLayoutParams) ilO).rightMargin;
                        }
                        IlO(canvas, right, eo.MY, eo.Bc);
                    }
                }
            }
            if (tV(i9)) {
                if (z7) {
                    i8 = eo.tV;
                } else {
                    i8 = eo.MY - this.EV;
                }
                MY(canvas, paddingLeft, i8, iMax);
            }
            if (vCE(i9) && (this.DmF & 4) > 0) {
                if (z7) {
                    i2 = eo.MY - this.EV;
                } else {
                    i2 = eo.tV;
                }
                MY(canvas, paddingLeft, i2, iMax);
            }
        }
    }

    private void IlO(Canvas canvas, int i2, int i8, int i9) {
        Drawable drawable = this.lEW;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i8, this.rp + i2, i9 + i8);
        this.lEW.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int IlO(View view, int i2, int i8) {
        int i9;
        int i10;
        if (IlO()) {
            i9 = tV(i2, i8) ? this.rp : 0;
            if ((this.NV & 4) <= 0) {
                return i9;
            }
            i10 = this.rp;
        } else {
            i9 = tV(i2, i8) ? this.EV : 0;
            if ((this.DmF & 4) <= 0) {
                return i9;
            }
            i10 = this.EV;
        }
        return i9 + i10;
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public void IlO(EO eo) {
        if (IlO()) {
            if ((this.NV & 4) > 0) {
                int i2 = eo.Cc;
                int i8 = this.rp;
                eo.Cc = i2 + i8;
                eo.vCE += i8;
                return;
            }
            return;
        }
        if ((this.DmF & 4) > 0) {
            int i9 = eo.Cc;
            int i10 = this.EV;
            eo.Cc = i9 + i10;
            eo.vCE += i10;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public int IlO(int i2, int i8, int i9) {
        return ViewGroup.getChildMeasureSpec(i2, i8, i9);
    }

    @Override // com.bytedance.adsdk.ugeno.Cc.IlO
    public void IlO(View view, int i2, int i8, EO eo) {
        if (tV(i2, i8)) {
            if (IlO()) {
                int i9 = eo.Cc;
                int i10 = this.rp;
                eo.Cc = i9 + i10;
                eo.vCE += i10;
                return;
            }
            int i11 = eo.Cc;
            int i12 = this.EV;
            eo.Cc = i11 + i12;
            eo.vCE += i12;
        }
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.cl = eo;
    }
}

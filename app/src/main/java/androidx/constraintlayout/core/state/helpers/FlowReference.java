package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class FlowReference extends HelperReference {
    protected float mFirstHorizontalBias;
    protected int mFirstHorizontalStyle;
    protected float mFirstVerticalBias;
    protected int mFirstVerticalStyle;
    protected Flow mFlow;
    protected int mHorizontalAlign;
    protected int mHorizontalGap;
    protected int mHorizontalStyle;
    protected float mLastHorizontalBias;
    protected int mLastHorizontalStyle;
    protected float mLastVerticalBias;
    protected int mLastVerticalStyle;
    protected HashMap<String, Float> mMapPostMargin;
    protected HashMap<String, Float> mMapPreMargin;
    protected HashMap<String, Float> mMapWeights;
    protected int mMaxElementsWrap;
    protected int mOrientation;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected int mVerticalAlign;
    protected int mVerticalGap;
    protected int mVerticalStyle;
    protected int mWrapMode;

    public FlowReference(State state, State.Helper helper) {
        super(state, helper);
        this.mWrapMode = 0;
        this.mVerticalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mVerticalAlign = 2;
        this.mHorizontalAlign = 2;
        this.mVerticalGap = 0;
        this.mHorizontalGap = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mFirstVerticalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        if (helper == State.Helper.VERTICAL_FLOW) {
            this.mOrientation = 1;
        }
    }

    public void addFlowElement(String str, float f4, float f8, float f9) {
        super.add(str);
        if (!Float.isNaN(f4)) {
            if (this.mMapWeights == null) {
                this.mMapWeights = new HashMap<>();
            }
            this.mMapWeights.put(str, Float.valueOf(f4));
        }
        if (!Float.isNaN(f8)) {
            if (this.mMapPreMargin == null) {
                this.mMapPreMargin = new HashMap<>();
            }
            this.mMapPreMargin.put(str, Float.valueOf(f8));
        }
        if (Float.isNaN(f9)) {
            return;
        }
        if (this.mMapPostMargin == null) {
            this.mMapPostMargin = new HashMap<>();
        }
        this.mMapPostMargin.put(str, Float.valueOf(f9));
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        setConstraintWidget(this.mFlow);
        this.mFlow.setOrientation(this.mOrientation);
        this.mFlow.setWrapMode(this.mWrapMode);
        int i2 = this.mMaxElementsWrap;
        if (i2 != -1) {
            this.mFlow.setMaxElementsWrap(i2);
        }
        int i8 = this.mPaddingLeft;
        if (i8 != 0) {
            this.mFlow.setPaddingLeft(i8);
        }
        int i9 = this.mPaddingTop;
        if (i9 != 0) {
            this.mFlow.setPaddingTop(i9);
        }
        int i10 = this.mPaddingRight;
        if (i10 != 0) {
            this.mFlow.setPaddingRight(i10);
        }
        int i11 = this.mPaddingBottom;
        if (i11 != 0) {
            this.mFlow.setPaddingBottom(i11);
        }
        int i12 = this.mHorizontalGap;
        if (i12 != 0) {
            this.mFlow.setHorizontalGap(i12);
        }
        int i13 = this.mVerticalGap;
        if (i13 != 0) {
            this.mFlow.setVerticalGap(i13);
        }
        float f4 = this.mHorizontalBias;
        if (f4 != 0.5f) {
            this.mFlow.setHorizontalBias(f4);
        }
        float f8 = this.mFirstHorizontalBias;
        if (f8 != 0.5f) {
            this.mFlow.setFirstHorizontalBias(f8);
        }
        float f9 = this.mLastHorizontalBias;
        if (f9 != 0.5f) {
            this.mFlow.setLastHorizontalBias(f9);
        }
        float f10 = this.mVerticalBias;
        if (f10 != 0.5f) {
            this.mFlow.setVerticalBias(f10);
        }
        float f11 = this.mFirstVerticalBias;
        if (f11 != 0.5f) {
            this.mFlow.setFirstVerticalBias(f11);
        }
        float f12 = this.mLastVerticalBias;
        if (f12 != 0.5f) {
            this.mFlow.setLastVerticalBias(f12);
        }
        int i14 = this.mHorizontalAlign;
        if (i14 != 2) {
            this.mFlow.setHorizontalAlign(i14);
        }
        int i15 = this.mVerticalAlign;
        if (i15 != 2) {
            this.mFlow.setVerticalAlign(i15);
        }
        int i16 = this.mVerticalStyle;
        if (i16 != -1) {
            this.mFlow.setVerticalStyle(i16);
        }
        int i17 = this.mFirstVerticalStyle;
        if (i17 != -1) {
            this.mFlow.setFirstVerticalStyle(i17);
        }
        int i18 = this.mLastVerticalStyle;
        if (i18 != -1) {
            this.mFlow.setLastVerticalStyle(i18);
        }
        int i19 = this.mHorizontalStyle;
        if (i19 != -1) {
            this.mFlow.setHorizontalStyle(i19);
        }
        int i20 = this.mFirstHorizontalStyle;
        if (i20 != -1) {
            this.mFlow.setFirstHorizontalStyle(i20);
        }
        int i21 = this.mLastHorizontalStyle;
        if (i21 != -1) {
            this.mFlow.setLastHorizontalStyle(i21);
        }
        applyBase();
    }

    public float getFirstHorizontalBias() {
        return this.mFirstHorizontalBias;
    }

    public int getFirstHorizontalStyle() {
        return this.mFirstHorizontalStyle;
    }

    public float getFirstVerticalBias() {
        return this.mFirstVerticalBias;
    }

    public int getFirstVerticalStyle() {
        return this.mFirstVerticalStyle;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mFlow == null) {
            this.mFlow = new Flow();
        }
        return this.mFlow;
    }

    public int getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public int getHorizontalGap() {
        return this.mHorizontalGap;
    }

    public int getHorizontalStyle() {
        return this.mHorizontalStyle;
    }

    public float getLastHorizontalBias() {
        return this.mLastHorizontalBias;
    }

    public int getLastHorizontalStyle() {
        return this.mLastHorizontalStyle;
    }

    public float getLastVerticalBias() {
        return this.mLastVerticalBias;
    }

    public int getLastVerticalStyle() {
        return this.mLastVerticalStyle;
    }

    public int getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public float getPostMargin(String str) {
        HashMap<String, Float> map = this.mMapPreMargin;
        if (map == null || !map.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPreMargin.get(str).floatValue();
    }

    public float getPreMargin(String str) {
        HashMap<String, Float> map = this.mMapPostMargin;
        if (map == null || !map.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPostMargin.get(str).floatValue();
    }

    public int getVerticalAlign() {
        return this.mVerticalAlign;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public int getVerticalGap() {
        return this.mVerticalGap;
    }

    public int getVerticalStyle() {
        return this.mVerticalStyle;
    }

    public float getWeight(String str) {
        HashMap<String, Float> map = this.mMapWeights;
        if (map != null && map.containsKey(str)) {
            return this.mMapWeights.get(str).floatValue();
        }
        return -1.0f;
    }

    public int getWrapMode() {
        return this.mWrapMode;
    }

    public void setFirstHorizontalBias(float f4) {
        this.mFirstHorizontalBias = f4;
    }

    public void setFirstHorizontalStyle(int i2) {
        this.mFirstHorizontalStyle = i2;
    }

    public void setFirstVerticalBias(float f4) {
        this.mFirstVerticalBias = f4;
    }

    public void setFirstVerticalStyle(int i2) {
        this.mFirstVerticalStyle = i2;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public void setHelperWidget(HelperWidget helperWidget) {
        if (helperWidget instanceof Flow) {
            this.mFlow = (Flow) helperWidget;
        } else {
            this.mFlow = null;
        }
    }

    public void setHorizontalAlign(int i2) {
        this.mHorizontalAlign = i2;
    }

    public void setHorizontalGap(int i2) {
        this.mHorizontalGap = i2;
    }

    public void setHorizontalStyle(int i2) {
        this.mHorizontalStyle = i2;
    }

    public void setLastHorizontalBias(float f4) {
        this.mLastHorizontalBias = f4;
    }

    public void setLastHorizontalStyle(int i2) {
        this.mLastHorizontalStyle = i2;
    }

    public void setLastVerticalBias(float f4) {
        this.mLastVerticalBias = f4;
    }

    public void setLastVerticalStyle(int i2) {
        this.mLastVerticalStyle = i2;
    }

    public void setMaxElementsWrap(int i2) {
        this.mMaxElementsWrap = i2;
    }

    public void setOrientation(int i2) {
        this.mOrientation = i2;
    }

    public void setPaddingBottom(int i2) {
        this.mPaddingBottom = i2;
    }

    public void setPaddingLeft(int i2) {
        this.mPaddingLeft = i2;
    }

    public void setPaddingRight(int i2) {
        this.mPaddingRight = i2;
    }

    public void setPaddingTop(int i2) {
        this.mPaddingTop = i2;
    }

    public void setVerticalAlign(int i2) {
        this.mVerticalAlign = i2;
    }

    public void setVerticalGap(int i2) {
        this.mVerticalGap = i2;
    }

    public void setVerticalStyle(int i2) {
        this.mVerticalStyle = i2;
    }

    public void setWrapMode(int i2) {
        this.mWrapMode = i2;
    }
}

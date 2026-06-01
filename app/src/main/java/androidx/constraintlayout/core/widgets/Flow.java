package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget mBiggest = null;
        int mBiggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i8) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i8;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mBiggest = null;
            this.mBiggestDimension = 0;
            int i2 = this.mCount;
            for (int i8 = 0; i8 < i2 && this.mStartIndex + i8 < Flow.this.mDisplayedWidgetsCount; i8++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i8];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i9 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i9 = 0;
                    }
                    this.mWidth = width + i9 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i10 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i10 = 0;
                    }
                    this.mHeight = widgetHeight2 + i10 + this.mHeight;
                    if (this.mBiggest == null || this.mBiggestDimension < widgetWidth) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.mBiggest == null || this.mBiggestDimension < widgetWidth2) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.mBiggestDimension = 0;
            this.mBiggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z2, int i2, boolean z7) {
            ConstraintWidget constraintWidget;
            int i8;
            char c7;
            float f4;
            float f8;
            int i9 = this.mCount;
            for (int i10 = 0; i10 < i9 && this.mStartIndex + i10 < Flow.this.mDisplayedWidgetsCount; i10++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i10];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i9 == 0 || this.mBiggest == null) {
                return;
            }
            boolean z8 = z7 && i2 == 0;
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < i9; i13++) {
                int i14 = z2 ? (i9 - 1) - i13 : i13;
                if (this.mStartIndex + i14 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.mDisplayedWidgets[this.mStartIndex + i14];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i11 == -1) {
                        i11 = i13;
                    }
                    i12 = i13;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget5 = this.mBiggest;
                constraintWidget5.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i15 = this.mPaddingLeft;
                if (i2 > 0) {
                    i15 += Flow.this.mHorizontalGap;
                }
                if (z2) {
                    constraintWidget5.mRight.connect(this.mRight, i15);
                    if (z7) {
                        constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget5.mRight, 0);
                    }
                } else {
                    constraintWidget5.mLeft.connect(this.mLeft, i15);
                    if (z7) {
                        constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget5.mLeft, 0);
                    }
                }
                for (int i16 = 0; i16 < i9 && this.mStartIndex + i16 < Flow.this.mDisplayedWidgetsCount; i16++) {
                    ConstraintWidget constraintWidget6 = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                    if (constraintWidget6 != null) {
                        if (i16 == 0) {
                            constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                            int i17 = Flow.this.mVerticalStyle;
                            float f9 = Flow.this.mVerticalBias;
                            if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                                i17 = Flow.this.mFirstVerticalStyle;
                                f9 = Flow.this.mFirstVerticalBias;
                            } else if (z7 && Flow.this.mLastVerticalStyle != -1) {
                                i17 = Flow.this.mLastVerticalStyle;
                                f9 = Flow.this.mLastVerticalBias;
                            }
                            constraintWidget6.setVerticalChainStyle(i17);
                            constraintWidget6.setVerticalBiasPercent(f9);
                        }
                        if (i16 == i9 - 1) {
                            constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.mTop.connect(constraintWidget4.mBottom, Flow.this.mVerticalGap);
                            if (i16 == i11) {
                                constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget4.mBottom.connect(constraintWidget6.mTop, 0);
                            if (i16 == i12 + 1) {
                                constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget6 == constraintWidget5) {
                            constraintWidget4 = constraintWidget6;
                        } else if (z2) {
                            int i18 = Flow.this.mHorizontalAlign;
                            if (i18 == 0) {
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            } else if (i18 == 1) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                            } else if (i18 == 2) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            }
                            constraintWidget4 = constraintWidget6;
                        } else {
                            int i19 = Flow.this.mHorizontalAlign;
                            if (i19 == 0) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                            } else if (i19 == 1) {
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            } else if (i19 == 2) {
                                if (z8) {
                                    constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.mBiggest;
            constraintWidget7.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i20 = this.mPaddingTop;
            if (i2 > 0) {
                i20 += Flow.this.mVerticalGap;
            }
            constraintWidget7.mTop.connect(this.mTop, i20);
            if (z7) {
                constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i2 > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget7.mTop, 0);
            }
            char c8 = 3;
            if (Flow.this.mVerticalAlign != 3 || constraintWidget7.hasBaseline()) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i21 = 0; i21 < i9; i21++) {
                    int i22 = z2 ? (i9 - 1) - i21 : i21;
                    if (this.mStartIndex + i22 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i22];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            int i23 = 0;
            while (i23 < i9) {
                int i24 = z2 ? (i9 - 1) - i23 : i23;
                if (this.mStartIndex + i24 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget8 = Flow.this.mDisplayedWidgets[this.mStartIndex + i24];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                    c7 = c8;
                } else {
                    if (i23 == 0) {
                        i8 = 1;
                        constraintWidget8.connect(constraintWidget8.mLeft, this.mLeft, this.mPaddingLeft);
                    } else {
                        i8 = 1;
                    }
                    if (i24 == 0) {
                        int i25 = Flow.this.mHorizontalStyle;
                        float f10 = Flow.this.mHorizontalBias;
                        if (z2) {
                            f10 = 1.0f - f10;
                        }
                        if (this.mStartIndex != 0 || Flow.this.mFirstHorizontalStyle == -1) {
                            if (z7 && Flow.this.mLastHorizontalStyle != -1) {
                                i25 = Flow.this.mLastHorizontalStyle;
                                if (z2) {
                                    f8 = Flow.this.mLastHorizontalBias;
                                    f4 = 1.0f - f8;
                                    f10 = f4;
                                } else {
                                    f4 = Flow.this.mLastHorizontalBias;
                                    f10 = f4;
                                }
                            }
                            constraintWidget8.setHorizontalChainStyle(i25);
                            constraintWidget8.setHorizontalBiasPercent(f10);
                        } else {
                            i25 = Flow.this.mFirstHorizontalStyle;
                            if (z2) {
                                f8 = Flow.this.mFirstHorizontalBias;
                                f4 = 1.0f - f8;
                                f10 = f4;
                                constraintWidget8.setHorizontalChainStyle(i25);
                                constraintWidget8.setHorizontalBiasPercent(f10);
                            } else {
                                f4 = Flow.this.mFirstHorizontalBias;
                                f10 = f4;
                                constraintWidget8.setHorizontalChainStyle(i25);
                                constraintWidget8.setHorizontalBiasPercent(f10);
                            }
                        }
                    }
                    if (i23 == i9 - 1) {
                        constraintWidget8.connect(constraintWidget8.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.mLeft.connect(constraintWidget4.mRight, Flow.this.mHorizontalGap);
                        if (i23 == i11) {
                            constraintWidget8.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget4.mRight.connect(constraintWidget8.mLeft, 0);
                        if (i23 == i12 + 1) {
                            constraintWidget4.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        c7 = 3;
                        if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget8 != constraintWidget && constraintWidget8.hasBaseline()) {
                            constraintWidget8.mBaseline.connect(constraintWidget.mBaseline, 0);
                        } else {
                            int i26 = Flow.this.mVerticalAlign;
                            if (i26 == 0) {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                            } else if (i26 == i8) {
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            } else if (z8) {
                                constraintWidget8.mTop.connect(this.mTop, this.mPaddingTop);
                                constraintWidget8.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            } else {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            }
                        }
                    } else {
                        c7 = 3;
                    }
                }
                i23++;
                c8 = c7;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i2) {
            int i8 = this.mNbMatchConstraintsWidgets;
            if (i8 == 0) {
                return;
            }
            int i9 = this.mCount;
            int i10 = i2 / i8;
            for (int i11 = 0; i11 < i9 && this.mStartIndex + i11 < Flow.this.mDisplayedWidgetsCount; i11++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i11];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i10, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i12 = i10;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                    i10 = i12;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i2) {
            this.mStartIndex = i2;
        }

        public void setup(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i8, int i9, int i10, int i11, int i12) {
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i8;
            this.mPaddingTop = i9;
            this.mPaddingRight = i10;
            this.mPaddingBottom = i11;
            this.mMax = i12;
        }
    }

    private void createAlignedConstraints(boolean z2) {
        ConstraintWidget constraintWidget;
        float f4;
        int i2;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i8 = 0; i8 < this.mDisplayedWidgetsCount; i8++) {
            this.mDisplayedWidgets[i8].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i9 = iArr[0];
        int i10 = iArr[1];
        float f8 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i11 = 0;
        while (i11 < i9) {
            if (z2) {
                i2 = (i9 - i11) - 1;
                f4 = 1.0f - this.mHorizontalBias;
            } else {
                f4 = f8;
                i2 = i11;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i2];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i11 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f4);
                }
                if (i11 == i9 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i11 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i11++;
            f8 = f4;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i12];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i12 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i12 == i10 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i12 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i13 = 0; i13 < i9; i13++) {
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = (i14 * i9) + i13;
                if (this.mOrientation == 1) {
                    i15 = (i13 * i10) + i14;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i15 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i15]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i13];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i14];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetHeight(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i8 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (constraintWidget.mMatchConstraintPercentHeight * i2);
                if (i9 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i9);
                }
                return i9;
            }
            constraintWidget2 = constraintWidget;
            if (i8 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i8 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetWidth(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i8 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (constraintWidget.mMatchConstraintPercentWidth * i2);
                if (i9 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i9, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i9;
            }
            constraintWidget2 = constraintWidget;
            if (i8 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i8 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i8, int i9, int[] iArr) {
        int i10;
        Flow flow;
        int i11;
        ConstraintAnchor constraintAnchor;
        int i12;
        Flow flow2 = this;
        if (i2 == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i13 = i9;
        WidgetsList widgetsList = flow2.new WidgetsList(i8, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i13);
        flow2.mChainList.add(widgetsList);
        if (i8 == 0) {
            i10 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i15 < i2) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i15];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i13);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i16 = i10;
                boolean z2 = (i14 == i13 || (flow2.mHorizontalGap + i14) + widgetWidth > i13) && widgetsList.mBiggest != null;
                if (!z2 && i15 > 0 && (i12 = flow2.mMaxElementsWrap) > 0 && i15 % i12 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = flow2.new WidgetsList(i8, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i13);
                    widgetsList.setStartIndex(i15);
                    flow2.mChainList.add(widgetsList);
                } else {
                    if (i15 > 0) {
                        i14 = flow2.mHorizontalGap + widgetWidth + i14;
                    }
                    widgetsList.add(constraintWidget);
                    i15++;
                    i10 = i16;
                }
                i14 = widgetWidth;
                widgetsList.add(constraintWidget);
                i15++;
                i10 = i16;
            }
        } else {
            i10 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i2) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i18];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i13);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i19 = i10;
                boolean z7 = (i17 == i13 || (flow2.mVerticalGap + i17) + widgetHeight > i13) && widgetsList.mBiggest != null;
                if (!z7 && i18 > 0 && (i11 = flow2.mMaxElementsWrap) > 0 && i18 % i11 == 0) {
                    z7 = true;
                }
                if (z7) {
                    widgetsList = flow2.new WidgetsList(i8, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i13);
                    flow = flow2;
                    widgetsList.setStartIndex(i18);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i18 > 0) {
                        i17 = flow.mVerticalGap + widgetHeight + i17;
                    }
                    widgetsList.add(constraintWidget2);
                    i18++;
                    i13 = i9;
                    i10 = i19;
                    flow2 = flow;
                }
                i17 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i18++;
                i13 = i9;
                i10 = i19;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z8 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i10 > 0 && z8) {
            for (int i20 = 0; i20 < size; i20++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i20);
                if (i8 == 0) {
                    widgetsList2.measureMatchConstraints(i9 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i9 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int paddingBottom2 = paddingBottom;
        int i21 = 0;
        int paddingRight2 = paddingRight;
        int i22 = paddingTop;
        int i23 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i24 = 0;
        for (int i25 = 0; i25 < size; i25++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i25);
            if (i8 == 0) {
                if (i25 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i25 + 1).mBiggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                int i26 = i24;
                widgetsList3.setup(i8, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i23, i22, paddingRight2, paddingBottom2, i9);
                int iMax = Math.max(i21, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i26;
                if (i25 > 0) {
                    height += flow3.mVerticalGap;
                }
                i24 = height;
                i21 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i22 = 0;
            } else {
                int i27 = i21;
                int i28 = i24;
                if (i25 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i25 + 1).mBiggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i8, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i23, i22, paddingRight2, paddingBottom2, i9);
                int width = widgetsList3.getWidth() + i27;
                int iMax2 = Math.max(i28, widgetsList3.getHeight());
                if (i25 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i29 = width;
                i24 = iMax2;
                i21 = i29;
                i23 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i21;
        iArr[1] = i24;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i2, int i8, int i9, int[] iArr) {
        int i10;
        Flow flow;
        int i11;
        boolean z2;
        ConstraintAnchor constraintAnchor;
        int i12;
        Flow flow2 = this;
        if (i2 == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i13 = i9;
        WidgetsList widgetsList = flow2.new WidgetsList(i8, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i13);
        flow2.mChainList.add(widgetsList);
        boolean z7 = true;
        if (i8 == 0) {
            int i14 = 0;
            i10 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i2) {
                i14++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i16];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i13);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i17 = i10;
                boolean z8 = (i15 == i13 || (flow2.mHorizontalGap + i15) + widgetWidth > i13) && widgetsList.mBiggest != null;
                if (!z8 && i16 > 0 && (i12 = flow2.mMaxElementsWrap) > 0 && i14 > i12) {
                    z8 = true;
                }
                if (z8) {
                    widgetsList = flow2.new WidgetsList(i8, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i13);
                    widgetsList.setStartIndex(i16);
                    flow2.mChainList.add(widgetsList);
                    i14 = 1;
                } else {
                    if (i16 > 0) {
                        i15 = flow2.mHorizontalGap + widgetWidth + i15;
                    }
                    widgetsList.add(constraintWidget);
                    i16++;
                    i10 = i17;
                }
                i15 = widgetWidth;
                widgetsList.add(constraintWidget);
                i16++;
                i10 = i17;
            }
        } else {
            int i18 = 0;
            i10 = 0;
            int i19 = 0;
            int i20 = 0;
            while (i20 < i2) {
                i18++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i20];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i13);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i21 = i10;
                boolean z9 = (i19 == i13 || (flow2.mVerticalGap + i19) + widgetHeight > i13) && widgetsList.mBiggest != null;
                if (!z9 && i20 > 0 && (i11 = flow2.mMaxElementsWrap) > 0 && i18 > i11) {
                    z9 = true;
                }
                if (z9) {
                    widgetsList = flow2.new WidgetsList(i8, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i13);
                    flow = flow2;
                    widgetsList.setStartIndex(i20);
                    flow.mChainList.add(widgetsList);
                    i18 = 1;
                } else {
                    flow = flow2;
                    if (i20 > 0) {
                        i19 = flow.mVerticalGap + widgetHeight + i19;
                    }
                    widgetsList.add(constraintWidget2);
                    i20++;
                    i13 = i9;
                    i10 = i21;
                    flow2 = flow;
                }
                i19 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i20++;
                i13 = i9;
                i10 = i21;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z10 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i10 > 0 && z10) {
            for (int i22 = 0; i22 < size; i22++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i22);
                if (i8 == 0) {
                    widgetsList2.measureMatchConstraints(i9 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i9 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int paddingBottom2 = paddingBottom;
        int i23 = 0;
        int i24 = 0;
        int paddingRight2 = paddingRight;
        int i25 = paddingTop;
        int i26 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i27 = 0;
        while (i24 < size) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i24);
            if (i8 == 0) {
                if (i24 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i24 + 1).mBiggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                z2 = z7;
                int i28 = i23;
                widgetsList3.setup(i8, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i26, i25, paddingRight2, paddingBottom2, i9);
                int iMax = Math.max(i27, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i28;
                if (i24 > 0) {
                    height += flow3.mVerticalGap;
                }
                i23 = height;
                i27 = iMax;
                constraintAnchor6 = constraintAnchor10;
                i25 = 0;
            } else {
                int i29 = i23;
                z2 = z7;
                int i30 = i27;
                if (i24 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i24 + 1).mBiggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i8, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i26, i25, paddingRight2, paddingBottom2, i9);
                int width = widgetsList3.getWidth() + i30;
                int iMax2 = Math.max(i29, widgetsList3.getHeight());
                if (i24 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i31 = width;
                i23 = iMax2;
                i27 = i31;
                i26 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i24++;
            z7 = z2;
        }
        iArr[0] = i27;
        iArr[z7 ? 1 : 0] = i23;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i8, int i9, int[] iArr) {
        WidgetsList widgetsList;
        if (i2 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i8, this.mLeft, this.mTop, this.mRight, this.mBottom, i9);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i8, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i9);
            widgetsList = widgetsList2;
        }
        for (int i10 = 0; i10 < i2; i10++) {
            widgetsList.add(constraintWidgetArr[i10]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z2) {
        super.addToSolver(linearSystem, z2);
        boolean z7 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i2 = this.mWrapMode;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.mChainList.size();
                int i8 = 0;
                while (i8 < size) {
                    this.mChainList.get(i8).createConstraints(z7, i8, i8 == size + (-1));
                    i8++;
                }
            } else if (i2 == 2) {
                createAlignedConstraints(z7);
            } else if (i2 == 3) {
                int size2 = this.mChainList.size();
                int i9 = 0;
                while (i9 < size2) {
                    this.mChainList.get(i9).createConstraints(z7, i9, i9 == size2 + (-1));
                    i9++;
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z7, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i2, int i8, int i9, int i10) {
        int i11;
        ConstraintWidget[] constraintWidgetArr;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i12 = (i8 - paddingLeft) - paddingRight;
        int i13 = this.mOrientation;
        if (i13 == 1) {
            i12 = (i10 - paddingTop) - paddingBottom;
        }
        int i14 = i12;
        if (i13 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            i11 = this.mWidgetsCount;
            if (i15 >= i11) {
                break;
            }
            if (this.mWidgets[i15].getVisibility() == 8) {
                i16++;
            }
            i15++;
        }
        if (i16 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i11 - i16];
            int i17 = 0;
            i11 = 0;
            while (i17 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i17];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr4[i11] = constraintWidget;
                    i11++;
                }
                i17++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i18 = i11;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i18;
        int i19 = this.mWrapMode;
        if (i19 == 0) {
            measureNoWrap(constraintWidgetArr, i18, this.mOrientation, i14, iArr);
        } else if (i19 == 1) {
            measureChainWrap(constraintWidgetArr, i18, this.mOrientation, i14, iArr);
        } else if (i19 == 2) {
            measureAligned(constraintWidgetArr, i18, this.mOrientation, i14, iArr);
        } else if (i19 == 3) {
            measureChainWrap_new(constraintWidgetArr, i18, this.mOrientation, i14, iArr);
        }
        int iMin = iArr[0] + paddingLeft + paddingRight;
        int iMin2 = iArr[1] + paddingTop + paddingBottom;
        if (i2 == 1073741824) {
            iMin = i8;
        } else if (i2 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i8);
        } else if (i2 != 0) {
            iMin = 0;
        }
        if (i9 == 1073741824) {
            iMin2 = i10;
        } else if (i9 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i10);
        } else if (i9 != 0) {
            iMin2 = 0;
        }
        setMeasure(iMin, iMin2);
        setWidth(iMin);
        setHeight(iMin2);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
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

    public void setHorizontalAlign(int i2) {
        this.mHorizontalAlign = i2;
    }

    public void setHorizontalBias(float f4) {
        this.mHorizontalBias = f4;
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

    public void setVerticalAlign(int i2) {
        this.mVerticalAlign = i2;
    }

    public void setVerticalBias(float f4) {
        this.mVerticalBias = f4;
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

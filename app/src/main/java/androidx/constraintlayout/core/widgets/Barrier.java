package androidx.constraintlayout.core.widgets;

import a1.a;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    boolean mResolved = false;

    public Barrier() {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z2) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z7;
        int i2;
        int i8;
        int i9;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i10 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i10 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i10];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i10++;
        }
        int i11 = this.mBarrierType;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i11];
        if (!this.mResolved) {
            allSolved();
        }
        if (this.mResolved) {
            this.mResolved = false;
            int i12 = this.mBarrierType;
            if (i12 == 0 || i12 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            } else {
                if (i12 == 2 || i12 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                    return;
                }
                return;
            }
        }
        for (int i13 = 0; i13 < this.mWidgetsCount; i13++) {
            ConstraintWidget constraintWidget = this.mWidgets[i13];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i8 = this.mBarrierType) == 0 || i8 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i9 = this.mBarrierType) == 2 || i9 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z7 = true;
                break;
            }
        }
        z7 = false;
        boolean z8 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z9 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i14 = !(!z7 && (((i2 = this.mBarrierType) == 0 && z8) || ((i2 == 2 && z9) || ((i2 == 1 && z8) || (i2 == 3 && z9))))) ? 4 : 5;
        for (int i15 = 0; i15 < this.mWidgetsCount; i15++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i15];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                int i16 = this.mBarrierType;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i16];
                constraintAnchor3.mSolverVariable = solverVariableCreateObjectVariable;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                int i17 = (constraintAnchor4 == null || constraintAnchor4.mOwner != this) ? 0 : constraintAnchor3.mMargin;
                if (i16 == 0 || i16 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin - i17, z7);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i17, z7);
                }
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i17, i14);
            }
        }
        int i18 = this.mBarrierType;
        if (i18 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i18 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i18 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i18 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allSolved() {
        int i2;
        int i8;
        int i9;
        boolean z2 = true;
        int i10 = 0;
        while (true) {
            i2 = this.mWidgetsCount;
            if (i10 >= i2) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i8 = this.mBarrierType) == 0 || i8 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i9 = this.mBarrierType) == 2 || i9 == 3) && !constraintWidget.isResolvedVertically()))) {
                z2 = false;
            }
            i10++;
        }
        if (!z2 || i2 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z7 = false;
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i11];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z7) {
                    int i12 = this.mBarrierType;
                    if (i12 == 0) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i12 == 1) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i12 == 2) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i12 == 3) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z7 = true;
                }
                int i13 = this.mBarrierType;
                if (i13 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i13 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i13 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i13 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i14 = iMax + this.mMargin;
        int i15 = this.mBarrierType;
        if (i15 == 0 || i15 == 1) {
            setFinalHorizontal(i14, i14);
        } else {
            setFinalVertical(i14, i14);
        }
        this.mResolved = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i2 = this.mBarrierType;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.mResolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.mResolved;
    }

    public void markWidgets() {
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i8 = this.mBarrierType;
                if (i8 == 0 || i8 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i8 == 2 || i8 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.mAllowsGoneWidget = z2;
    }

    public void setBarrierType(int i2) {
        this.mBarrierType = i2;
    }

    public void setMargin(int i2) {
        this.mMargin = i2;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String string = "[Barrier] " + getDebugName() + " {";
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (i2 > 0) {
                string = a.C(string, ", ");
            }
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(string);
            sbR.append(constraintWidget.getDebugName());
            string = sbR.toString();
        }
        return a.C(string, "}");
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static BasicMeasure.Measure sMeasure = new BasicMeasure.Measure();
    private static int sHcount = 0;
    private static int sVcount = 0;

    private static boolean canMeasure(int i2, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.getParent() != null ? (ConstraintWidgetContainer) constraintWidget.getParent() : null;
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getVerticalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z2 = horizontalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedHorizontally() || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (horizontalDimensionBehaviour == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0)) || (horizontalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.mMatchConstraintDefaultWidth == 1 && constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth()));
        boolean z7 = verticalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedVertically() || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (verticalDimensionBehaviour == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1)) || (verticalDimensionBehaviour == dimensionBehaviour && constraintWidget.mMatchConstraintDefaultHeight == 1 && constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight()));
        if (constraintWidget.mDimensionRatio <= 0.0f || !(z2 || z7)) {
            return z2 && z7;
        }
        return true;
    }

    private static void horizontalSolvingPass(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z7;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isHorizontalSolvingPassDone()) {
            return;
        }
        boolean z8 = true;
        sHcount++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
            int i8 = i2 + 1;
            if (canMeasure(i8, constraintWidget)) {
                ConstraintWidgetContainer.measure(i8, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                int i9 = i2 + 1;
                boolean zCanMeasure = canMeasure(i9, constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && zCanMeasure) {
                    z7 = z8;
                    ConstraintWidgetContainer.measure(i9, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                } else {
                    z7 = z8;
                }
                boolean z9 = ((next == constraintWidget2.mLeft && (constraintAnchor4 = constraintWidget2.mRight.mTarget) != null && constraintAnchor4.hasFinalValue()) || (next == constraintWidget2.mRight && (constraintAnchor3 = constraintWidget2.mLeft.mTarget) != null && constraintAnchor3.hasFinalValue())) ? z7 : false;
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget2.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour != dimensionBehaviour || zCanMeasure) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.mLeft;
                        if (next == constraintAnchor5 && constraintWidget2.mRight.mTarget == null) {
                            int margin = constraintAnchor5.getMargin() + finalValue;
                            constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                            horizontalSolvingPass(i9, constraintWidget2, measurer, z2);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.mRight;
                            if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor6.getMargin();
                                constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                                horizontalSolvingPass(i9, constraintWidget2, measurer, z2);
                            } else if (z9 && !constraintWidget2.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(i9, measurer, constraintWidget2, z2);
                            }
                        }
                    }
                } else if (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxWidth >= 0 && constraintWidget2.mMatchConstraintMinWidth >= 0 && ((constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultWidth == 0 && constraintWidget2.getDimensionRatio() == 0.0f)) && !constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout() && z9 && !constraintWidget2.isInHorizontalChain())) {
                    solveHorizontalMatchConstraint(i9, constraintWidget, measurer, constraintWidget2, z2);
                }
                z8 = z7;
            }
        }
        boolean z10 = z8;
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                int i10 = i2 + 1;
                boolean zCanMeasure2 = canMeasure(i10, constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && zCanMeasure2) {
                    ConstraintWidgetContainer.measure(i10, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z11 = ((next2 == constraintWidget3.mLeft && (constraintAnchor2 = constraintWidget3.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mRight && (constraintAnchor = constraintWidget3.mLeft.mTarget) != null && constraintAnchor.hasFinalValue())) ? z10 : false;
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget3.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour2 != dimensionBehaviour2 || zCanMeasure2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.mLeft;
                        if (next2 == constraintAnchor7 && constraintWidget3.mRight.mTarget == null) {
                            int margin3 = constraintAnchor7.getMargin() + finalValue2;
                            constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                            horizontalSolvingPass(i10, constraintWidget3, measurer, z2);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.mRight;
                            if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                                horizontalSolvingPass(i10, constraintWidget3, measurer, z2);
                            } else if (z11 && !constraintWidget3.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(i10, measurer, constraintWidget3, z2);
                            }
                        }
                    }
                } else if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z11 && !constraintWidget3.isInHorizontalChain()) {
                        solveHorizontalMatchConstraint(i10, constraintWidget, measurer, constraintWidget3, z2);
                    }
                }
            }
        }
        constraintWidget.markHorizontalSolvingPassDone();
    }

    public static String ls(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i2; i8++) {
            sb.append("  ");
        }
        sb.append("+-(" + i2 + ") ");
        return sb.toString();
    }

    private static void solveBarrier(int i2, Barrier barrier, BasicMeasure.Measurer measurer, int i8, boolean z2) {
        if (barrier.allSolved()) {
            if (i8 == 0) {
                horizontalSolvingPass(i2 + 1, barrier, measurer, z2);
            } else {
                verticalSolvingPass(i2 + 1, barrier, measurer);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0155  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r20, androidx.constraintlayout.core.LinearSystem r21, int r22, int r23, androidx.constraintlayout.core.widgets.ChainHead r24, boolean r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead, boolean, boolean, boolean):boolean");
    }

    private static void solveHorizontalCenterConstraints(int i2, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z2) {
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i8 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i8 = (finalValue - finalValue2) - width;
        }
        int i9 = ((int) (i8 > 0 ? (horizontalBiasPercent * i8) + 0.5f : horizontalBiasPercent * i8)) + finalValue;
        int i10 = i9 + width;
        if (finalValue > finalValue2) {
            i10 = i9 - width;
        }
        constraintWidget.setFinalHorizontal(i9, i10);
        horizontalSolvingPass(i2 + 1, constraintWidget, measurer, z2);
    }

    private static void solveHorizontalMatchConstraint(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z2) {
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int margin = constraintWidget2.mLeft.getMargin() + constraintWidget2.mLeft.mTarget.getFinalValue();
        int finalValue = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue >= margin) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i8 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i8 == 2) {
                    width = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.getWidth() : constraintWidget.getParent().getWidth()));
                } else if (i8 == 0) {
                    width = finalValue - margin;
                }
                width = Math.max(constraintWidget2.mMatchConstraintMinWidth, width);
                int i9 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i9 > 0) {
                    width = Math.min(i9, width);
                }
            }
            int i10 = margin + ((int) ((horizontalBiasPercent * ((finalValue - margin) - width)) + 0.5f));
            constraintWidget2.setFinalHorizontal(i10, width + i10);
            horizontalSolvingPass(i2 + 1, constraintWidget2, measurer, z2);
        }
    }

    private static void solveVerticalCenterConstraints(int i2, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i8 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i8 = (finalValue - finalValue2) - height;
        }
        int i9 = (int) (i8 > 0 ? (verticalBiasPercent * i8) + 0.5f : verticalBiasPercent * i8);
        int i10 = finalValue + i9;
        int i11 = i10 + height;
        if (finalValue > finalValue2) {
            i10 = finalValue - i9;
            i11 = i10 - height;
        }
        constraintWidget.setFinalVertical(i10, i11);
        verticalSolvingPass(i2 + 1, constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int margin = constraintWidget2.mTop.getMargin() + constraintWidget2.mTop.mTarget.getFinalValue();
        int finalValue = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue >= margin) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i8 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i8 == 2) {
                    height = (int) (verticalBiasPercent * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.getHeight() : constraintWidget.getParent().getHeight()));
                } else if (i8 == 0) {
                    height = finalValue - margin;
                }
                height = Math.max(constraintWidget2.mMatchConstraintMinHeight, height);
                int i9 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i9 > 0) {
                    height = Math.min(i9, height);
                }
            }
            int i10 = margin + ((int) ((verticalBiasPercent * ((finalValue - margin) - height)) + 0.5f));
            constraintWidget2.setFinalVertical(i10, height + i10);
            verticalSolvingPass(i2 + 1, constraintWidget2, measurer);
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        sHcount = 0;
        sVcount = 0;
        constraintWidgetContainer.resetFinalResolution();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i2 = 0; i2 < size; i2++) {
            children.get(i2).resetFinalResolution();
        }
        boolean zIsRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z2 = false;
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget = children.get(i8);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * constraintWidgetContainer.getWidth()) + 0.5f));
                    }
                    z2 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                z7 = true;
            }
        }
        if (z2) {
            for (int i9 = 0; i9 < size; i9++) {
                ConstraintWidget constraintWidget2 = children.get(i9);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        horizontalSolvingPass(0, guideline2, measurer, zIsRtl);
                    }
                }
            }
        }
        horizontalSolvingPass(0, constraintWidgetContainer, measurer, zIsRtl);
        if (z7) {
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget3 = children.get(i10);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0) {
                        solveBarrier(0, barrier, measurer, 0, zIsRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z8 = false;
        boolean z9 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget4 = children.get(i11);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * constraintWidgetContainer.getHeight()) + 0.5f));
                    }
                    z8 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                z9 = true;
            }
        }
        if (z8) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget5 = children.get(i12);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        verticalSolvingPass(1, guideline4, measurer);
                    }
                }
            }
        }
        verticalSolvingPass(0, constraintWidgetContainer, measurer);
        if (z9) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget6 = children.get(i13);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1) {
                        solveBarrier(0, barrier2, measurer, 1, zIsRtl);
                    }
                }
            }
        }
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget7 = children.get(i14);
            if (constraintWidget7.isMeasureRequested() && canMeasure(0, constraintWidget7)) {
                ConstraintWidgetContainer.measure(0, constraintWidget7, measurer, sMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
                if (!(constraintWidget7 instanceof Guideline)) {
                    horizontalSolvingPass(0, constraintWidget7, measurer, zIsRtl);
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).getOrientation() == 0) {
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else {
                    horizontalSolvingPass(0, constraintWidget7, measurer, zIsRtl);
                }
            }
        }
    }

    private static void verticalSolvingPass(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isVerticalSolvingPassDone()) {
            return;
        }
        boolean z2 = true;
        sVcount++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
            int i8 = i2 + 1;
            if (canMeasure(i8, constraintWidget)) {
                ConstraintWidgetContainer.measure(i8, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                int i9 = i2 + 1;
                boolean zCanMeasure = canMeasure(i9, constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && zCanMeasure) {
                    ConstraintWidgetContainer.measure(i9, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z7 = ((next == constraintWidget2.mTop && (constraintAnchor4 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor4.hasFinalValue()) || (next == constraintWidget2.mBottom && (constraintAnchor3 = constraintWidget2.mTop.mTarget) != null && constraintAnchor3.hasFinalValue())) ? z2 : false;
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget2.getVerticalDimensionBehaviour();
                boolean z8 = z2;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour != dimensionBehaviour || zCanMeasure) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.mTop;
                        if (next == constraintAnchor5 && constraintWidget2.mBottom.mTarget == null) {
                            int margin = constraintAnchor5.getMargin() + finalValue;
                            constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                            verticalSolvingPass(i9, constraintWidget2, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.mBottom;
                            if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor6.getMargin();
                                constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                                verticalSolvingPass(i9, constraintWidget2, measurer);
                            } else if (z7 && !constraintWidget2.isInVerticalChain()) {
                                solveVerticalCenterConstraints(i9, measurer, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxHeight >= 0 && constraintWidget2.mMatchConstraintMinHeight >= 0 && ((constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultHeight == 0 && constraintWidget2.getDimensionRatio() == 0.0f)) && !constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout() && z7 && !constraintWidget2.isInVerticalChain())) {
                    solveVerticalMatchConstraint(i9, constraintWidget, measurer, constraintWidget2);
                }
                z2 = z8;
            }
        }
        boolean z9 = z2;
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                int i10 = i2 + 1;
                boolean zCanMeasure2 = canMeasure(i10, constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && zCanMeasure2) {
                    ConstraintWidgetContainer.measure(i10, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z10 = ((next2 == constraintWidget3.mTop && (constraintAnchor2 = constraintWidget3.mBottom.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mBottom && (constraintAnchor = constraintWidget3.mTop.mTarget) != null && constraintAnchor.hasFinalValue())) ? z9 : false;
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget3.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour2 != dimensionBehaviour2 || zCanMeasure2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.mTop;
                        if (next2 == constraintAnchor7 && constraintWidget3.mBottom.mTarget == null) {
                            int margin3 = constraintAnchor7.getMargin() + finalValue2;
                            constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                            verticalSolvingPass(i10, constraintWidget3, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.mBottom;
                            if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                                verticalSolvingPass(i10, constraintWidget3, measurer);
                            } else if (z10 && !constraintWidget3.isInVerticalChain()) {
                                solveVerticalCenterConstraints(i10, measurer, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z10 && !constraintWidget3.isInVerticalChain()) {
                        solveVerticalMatchConstraint(i10, constraintWidget, measurer, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor anchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
            int finalValue3 = anchor3.getFinalValue();
            for (ConstraintAnchor constraintAnchor9 : anchor3.getDependents()) {
                ConstraintWidget constraintWidget4 = constraintAnchor9.mOwner;
                int i11 = i2 + 1;
                boolean zCanMeasure3 = canMeasure(i11, constraintWidget4);
                if (constraintWidget4.isMeasureRequested() && zCanMeasure3) {
                    ConstraintWidgetContainer.measure(i11, constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if (constraintWidget4.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || zCanMeasure3) {
                    if (!constraintWidget4.isMeasureRequested() && constraintAnchor9 == constraintWidget4.mBaseline) {
                        constraintWidget4.setFinalBaseline(constraintAnchor9.getMargin() + finalValue3);
                        verticalSolvingPass(i11, constraintWidget4, measurer);
                    }
                }
            }
        }
        constraintWidget.markVerticalSolvingPassDone();
    }
}

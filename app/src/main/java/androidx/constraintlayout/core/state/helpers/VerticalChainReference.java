package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain;

        static {
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            this.mHelperState.constraints(obj).clearVertical();
        }
        ArrayList<Object> arrayList2 = this.mReferences;
        int size2 = arrayList2.size();
        ConstraintReference constraintReference = null;
        int i8 = 0;
        ConstraintReference constraintReference2 = null;
        while (i8 < size2) {
            Object obj2 = arrayList2.get(i8);
            i8++;
            ConstraintReference constraintReferenceConstraints = this.mHelperState.constraints(obj2);
            if (constraintReference2 == null) {
                Object obj3 = this.mTopToTop;
                if (obj3 != null) {
                    constraintReferenceConstraints.topToTop(obj3).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                } else {
                    Object obj4 = this.mTopToBottom;
                    if (obj4 != null) {
                        constraintReferenceConstraints.topToBottom(obj4).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                    } else {
                        String string = constraintReferenceConstraints.getKey().toString();
                        constraintReferenceConstraints.topToTop(State.PARENT).margin(Float.valueOf(getPreMargin(string))).marginGone(Float.valueOf(getPreGoneMargin(string)));
                    }
                }
                constraintReference2 = constraintReferenceConstraints;
            }
            if (constraintReference != null) {
                String string2 = constraintReference.getKey().toString();
                String string3 = constraintReferenceConstraints.getKey().toString();
                constraintReference.bottomToTop(constraintReferenceConstraints.getKey()).margin(Float.valueOf(getPostMargin(string2))).marginGone(Float.valueOf(getPostGoneMargin(string2)));
                constraintReferenceConstraints.topToBottom(constraintReference.getKey()).margin(Float.valueOf(getPreMargin(string3))).marginGone(Float.valueOf(getPreGoneMargin(string3)));
            }
            float weight = getWeight(obj2.toString());
            if (weight != -1.0f) {
                constraintReferenceConstraints.setVerticalChainWeight(weight);
            }
            constraintReference = constraintReferenceConstraints;
        }
        if (constraintReference != null) {
            Object obj5 = this.mBottomToTop;
            if (obj5 != null) {
                constraintReference.bottomToTop(obj5).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
            } else {
                Object obj6 = this.mBottomToBottom;
                if (obj6 != null) {
                    constraintReference.bottomToBottom(obj6).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
                } else {
                    String string4 = constraintReference.getKey().toString();
                    constraintReference.bottomToBottom(State.PARENT).margin(Float.valueOf(getPostMargin(string4))).marginGone(Float.valueOf(getPostGoneMargin(string4)));
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f4 = this.mBias;
        if (f4 != 0.5f) {
            constraintReference2.verticalBias(f4);
        }
        int i9 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (i9 == 1) {
            constraintReference2.setVerticalChainStyle(0);
        } else if (i9 == 2) {
            constraintReference2.setVerticalChainStyle(1);
        } else {
            if (i9 != 3) {
                return;
            }
            constraintReference2.setVerticalChainStyle(2);
        }
    }
}

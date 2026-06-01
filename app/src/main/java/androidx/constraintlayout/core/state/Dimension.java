package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Dimension {
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    String mRatioString;
    int mValue;
    private final int mWrapContent;
    public static final Object FIXED_DIMENSION = new String("FIXED_DIMENSION");
    public static final Object WRAP_DIMENSION = new String("WRAP_DIMENSION");
    public static final Object SPREAD_DIMENSION = new String("SPREAD_DIMENSION");
    public static final Object PARENT_DIMENSION = new String("PARENT_DIMENSION");
    public static final Object PERCENT_DIMENSION = new String("PERCENT_DIMENSION");
    public static final Object RATIO_DIMENSION = new String("RATIO_DIMENSION");

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.mWrapContent = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    @Deprecated
    public static Dimension Fixed(int i2) {
        return createFixed(i2);
    }

    @Deprecated
    public static Dimension Parent() {
        return createParent();
    }

    @Deprecated
    public static Dimension Percent(Object obj, float f4) {
        return createPercent(obj, f4);
    }

    @Deprecated
    public static Dimension Ratio(String str) {
        return createRatio(str);
    }

    @Deprecated
    public static Dimension Spread() {
        return createSpread();
    }

    @Deprecated
    public static Dimension Suggested(int i2) {
        return createSuggested(i2);
    }

    @Deprecated
    public static Dimension Wrap() {
        return createWrap();
    }

    public static Dimension createFixed(int i2) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i2);
        return dimension;
    }

    public static Dimension createParent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension createPercent(Object obj, float f4) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f4);
        return dimension;
    }

    public static Dimension createRatio(String str) {
        Dimension dimension = new Dimension(RATIO_DIMENSION);
        dimension.ratio(str);
        return dimension;
    }

    public static Dimension createSpread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension createSuggested(int i2) {
        Dimension dimension = new Dimension();
        dimension.suggested(i2);
        return dimension;
    }

    public static Dimension createWrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i2) {
        String str = this.mRatioString;
        if (str != null) {
            constraintWidget.setDimensionRatio(str);
        }
        int i8 = 2;
        if (i2 == 0) {
            if (this.mIsSuggested) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.mInitialValue;
                if (obj == WRAP_DIMENSION) {
                    i8 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i8 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i8, this.mMin, this.mMax, this.mPercent);
                return;
            }
            int i9 = this.mMin;
            if (i9 > 0) {
                constraintWidget.setMinWidth(i9);
            }
            int i10 = this.mMax;
            if (i10 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i10);
            }
            Object obj2 = this.mInitialValue;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.mValue);
                    return;
                }
                return;
            }
        }
        if (this.mIsSuggested) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.mInitialValue;
            if (obj3 == WRAP_DIMENSION) {
                i8 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i8 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i8, this.mMin, this.mMax, this.mPercent);
            return;
        }
        int i11 = this.mMin;
        if (i11 > 0) {
            constraintWidget.setMinHeight(i11);
        }
        int i12 = this.mMax;
        if (i12 < Integer.MAX_VALUE) {
            constraintWidget.setMaxHeight(i12);
        }
        Object obj4 = this.mInitialValue;
        if (obj4 == WRAP_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == PARENT_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(this.mValue);
        }
    }

    public boolean equalsFixedValue(int i2) {
        return this.mInitialValue == null && this.mValue == i2;
    }

    public Dimension fixed(Object obj) {
        this.mInitialValue = obj;
        if (obj instanceof Integer) {
            this.mValue = ((Integer) obj).intValue();
            this.mInitialValue = null;
        }
        return this;
    }

    public int getValue() {
        return this.mValue;
    }

    public Dimension max(int i2) {
        if (this.mMax >= 0) {
            this.mMax = i2;
        }
        return this;
    }

    public Dimension min(int i2) {
        if (i2 >= 0) {
            this.mMin = i2;
        }
        return this;
    }

    public Dimension percent(Object obj, float f4) {
        this.mPercent = f4;
        return this;
    }

    public Dimension ratio(String str) {
        this.mRatioString = str;
        return this;
    }

    public void setValue(int i2) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = i2;
    }

    public Dimension suggested(int i2) {
        this.mIsSuggested = true;
        if (i2 >= 0) {
            this.mMax = i2;
        }
        return this;
    }

    @Deprecated
    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    @Deprecated
    public static Dimension Suggested(Object obj) {
        return createSuggested(obj);
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public static Dimension createFixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension createSuggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.mIsSuggested) {
            this.mInitialValue = obj2;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.mInitialValue = obj;
        this.mIsSuggested = true;
        return this;
    }

    public Dimension fixed(int i2) {
        this.mInitialValue = null;
        this.mValue = i2;
        return this;
    }

    private Dimension(Object obj) {
        this.mWrapContent = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }
}

package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.a;
import androidx.constraintlayout.core.motion.utils.e;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    Motion mMotion;
    private float mProgress;
    PropertySet mPropertySet;
    float mTransitionPathRotate;
    WidgetFrame mWidgetFrame;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public String mAnimateRelativeTo = null;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class PropertySet {
        public int visibility = 4;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
    }

    public MotionWidget() {
        this.mWidgetFrame = new WidgetFrame();
        this.mMotion = new Motion();
        this.mPropertySet = new PropertySet();
    }

    public MotionWidget findViewById(int i2) {
        return null;
    }

    public float getAlpha() {
        return this.mWidgetFrame.alpha;
    }

    public int getBottom() {
        return this.mWidgetFrame.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mWidgetFrame.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mWidgetFrame.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.mWidgetFrame;
        return widgetFrame.bottom - widgetFrame.top;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        int iA = a.a(str);
        return iA != -1 ? iA : e.a(str);
    }

    public int getLeft() {
        return this.mWidgetFrame.left;
    }

    public String getName() {
        return this.mWidgetFrame.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.mWidgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.mWidgetFrame.pivotY;
    }

    public int getRight() {
        return this.mWidgetFrame.right;
    }

    public float getRotationX() {
        return this.mWidgetFrame.rotationX;
    }

    public float getRotationY() {
        return this.mWidgetFrame.rotationY;
    }

    public float getRotationZ() {
        return this.mWidgetFrame.rotationZ;
    }

    public float getScaleX() {
        return this.mWidgetFrame.scaleX;
    }

    public float getScaleY() {
        return this.mWidgetFrame.scaleY;
    }

    public int getTop() {
        return this.mWidgetFrame.top;
    }

    public float getTranslationX() {
        return this.mWidgetFrame.translationX;
    }

    public float getTranslationY() {
        return this.mWidgetFrame.translationY;
    }

    public float getTranslationZ() {
        return this.mWidgetFrame.translationZ;
    }

    public float getValueAttributes(int i2) {
        switch (i2) {
            case 303:
                return this.mWidgetFrame.alpha;
            case 304:
                return this.mWidgetFrame.translationX;
            case 305:
                return this.mWidgetFrame.translationY;
            case 306:
                return this.mWidgetFrame.translationZ;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.mWidgetFrame.rotationX;
            case 309:
                return this.mWidgetFrame.rotationY;
            case 310:
                return this.mWidgetFrame.rotationZ;
            case 311:
                return this.mWidgetFrame.scaleX;
            case 312:
                return this.mWidgetFrame.scaleY;
            case 313:
                return this.mWidgetFrame.pivotX;
            case 314:
                return this.mWidgetFrame.pivotY;
            case 315:
                return this.mProgress;
            case 316:
                return this.mTransitionPathRotate;
        }
    }

    public int getVisibility() {
        return this.mPropertySet.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.mWidgetFrame;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.mWidgetFrame;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.mWidgetFrame.left;
    }

    public int getY() {
        return this.mWidgetFrame.top;
    }

    public void layout(int i2, int i8, int i9, int i10) {
        setBounds(i2, i8, i9, i10);
    }

    public void setBounds(int i2, int i8, int i9, int i10) {
        if (this.mWidgetFrame == null) {
            this.mWidgetFrame = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.mWidgetFrame;
        widgetFrame.top = i8;
        widgetFrame.left = i2;
        widgetFrame.right = i9;
        widgetFrame.bottom = i10;
    }

    public void setCustomAttribute(String str, int i2, float f4) {
        this.mWidgetFrame.setCustomAttribute(str, i2, f4);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.mWidgetFrame.setCustomAttribute(customAttribute.mName, TypedValues.Custom.TYPE_FLOAT, fArr[0]);
    }

    public void setPivotX(float f4) {
        this.mWidgetFrame.pivotX = f4;
    }

    public void setPivotY(float f4) {
        this.mWidgetFrame.pivotY = f4;
    }

    public void setRotationX(float f4) {
        this.mWidgetFrame.rotationX = f4;
    }

    public void setRotationY(float f4) {
        this.mWidgetFrame.rotationY = f4;
    }

    public void setRotationZ(float f4) {
        this.mWidgetFrame.rotationZ = f4;
    }

    public void setScaleX(float f4) {
        this.mWidgetFrame.scaleX = f4;
    }

    public void setScaleY(float f4) {
        this.mWidgetFrame.scaleY = f4;
    }

    public void setTranslationX(float f4) {
        this.mWidgetFrame.translationX = f4;
    }

    public void setTranslationY(float f4) {
        this.mWidgetFrame.translationY = f4;
    }

    public void setTranslationZ(float f4) {
        this.mWidgetFrame.translationZ = f4;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, boolean z2) {
        return false;
    }

    public boolean setValueAttributes(int i2, float f4) {
        switch (i2) {
            case 303:
                this.mWidgetFrame.alpha = f4;
                return true;
            case 304:
                this.mWidgetFrame.translationX = f4;
                return true;
            case 305:
                this.mWidgetFrame.translationY = f4;
                return true;
            case 306:
                this.mWidgetFrame.translationZ = f4;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.mWidgetFrame.rotationX = f4;
                return true;
            case 309:
                this.mWidgetFrame.rotationY = f4;
                return true;
            case 310:
                this.mWidgetFrame.rotationZ = f4;
                return true;
            case 311:
                this.mWidgetFrame.scaleX = f4;
                return true;
            case 312:
                this.mWidgetFrame.scaleY = f4;
                return true;
            case 313:
                this.mWidgetFrame.pivotX = f4;
                return true;
            case 314:
                this.mWidgetFrame.pivotY = f4;
                return true;
            case 315:
                this.mProgress = f4;
                return true;
            case 316:
                this.mTransitionPathRotate = f4;
                return true;
        }
    }

    public boolean setValueMotion(int i2, int i8) {
        switch (i2) {
            case 606:
                this.mMotion.mAnimateCircleAngleTo = i8;
                return true;
            case 607:
                this.mMotion.mPathMotionArc = i8;
                return true;
            case 608:
                this.mMotion.mDrawPath = i8;
                return true;
            case 609:
                this.mMotion.mPolarRelativeTo = i8;
                return true;
            case 610:
                this.mMotion.mQuantizeMotionSteps = i8;
                return true;
            case 611:
                this.mMotion.mQuantizeInterpolatorType = i8;
                return true;
            case 612:
                this.mMotion.mQuantizeInterpolatorID = i8;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i2) {
        this.mPropertySet.visibility = i2;
    }

    public String toString() {
        return this.mWidgetFrame.left + ", " + this.mWidgetFrame.top + ", " + this.mWidgetFrame.right + ", " + this.mWidgetFrame.bottom;
    }

    public void updateMotion(TypedValues typedValues) {
        if (this.mWidgetFrame.getMotionProperties() != null) {
            this.mWidgetFrame.getMotionProperties().applyDelta(typedValues);
        }
    }

    public void setCustomAttribute(String str, int i2, int i8) {
        this.mWidgetFrame.setCustomAttribute(str, i2, i8);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i8) {
        if (setValueAttributes(i2, i8)) {
            return true;
        }
        return setValueMotion(i2, i8);
    }

    public void setCustomAttribute(String str, int i2, boolean z2) {
        this.mWidgetFrame.setCustomAttribute(str, i2, z2);
    }

    public void setCustomAttribute(String str, int i2, String str2) {
        this.mWidgetFrame.setCustomAttribute(str, i2, str2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f4) {
        if (setValueAttributes(i2, f4)) {
            return true;
        }
        return setValueMotion(i2, f4);
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.mWidgetFrame = new WidgetFrame();
        this.mMotion = new Motion();
        this.mPropertySet = new PropertySet();
        this.mWidgetFrame = widgetFrame;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 == 605) {
            this.mMotion.mAnimateRelativeTo = str;
            return true;
        }
        return setValueMotion(i2, str);
    }

    public boolean setValueMotion(int i2, String str) {
        if (i2 == 603) {
            this.mMotion.mTransitionEasing = str;
            return true;
        }
        if (i2 != 604) {
            return false;
        }
        this.mMotion.mQuantizeInterpolatorString = str;
        return true;
    }

    public boolean setValueMotion(int i2, float f4) {
        switch (i2) {
            case 600:
                this.mMotion.mMotionStagger = f4;
                return true;
            case 601:
                this.mMotion.mPathRotate = f4;
                return true;
            case 602:
                this.mMotion.mQuantizeMotionPhase = f4;
                return true;
            default:
                return false;
        }
    }
}

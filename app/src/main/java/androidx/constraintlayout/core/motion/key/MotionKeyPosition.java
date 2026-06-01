package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.f;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int i2 = MotionKey.UNSET;
        this.mCurveFit = i2;
        this.mTransitionEasing = null;
        this.mPathMotionArc = i2;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f4, float f8, float f9, float f10) {
        float f11 = f9 - f4;
        float f12 = f10 - f8;
        float f13 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f14 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f15 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f12) + (f13 * f11) + f4);
        this.mCalculatedPositionY = (int) ((f12 * f15) + (f11 * f14) + f8);
    }

    private void calcPathPosition(float f4, float f8, float f9, float f10) {
        float f11 = f9 - f4;
        float f12 = f10 - f8;
        float f13 = this.mPercentX;
        float f14 = (f11 * f13) + f4;
        float f15 = this.mPercentY;
        this.mCalculatedPositionX = ((-f12) * f15) + f14;
        this.mCalculatedPositionY = (f11 * f15) + (f12 * f13) + f8;
    }

    private void calcScreenPosition(int i2, int i8) {
        float f4 = this.mPercentX;
        float f8 = 0;
        this.mCalculatedPositionX = (i2 * f4) + f8;
        this.mCalculatedPositionY = (i8 * f4) + f8;
    }

    public void calcPosition(int i2, int i8, float f4, float f8, float f9, float f10) {
        int i9 = this.mPositionType;
        if (i9 == 1) {
            calcPathPosition(f4, f8, f9, f10);
        } else if (i9 != 2) {
            calcCartesianPosition(f4, f8, f9, f10);
        } else {
            calcScreenPosition(i2, i8);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return f.a(str);
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i2, int i8, FloatRect floatRect, FloatRect floatRect2, float f4, float f8) {
        calcPosition(i2, i8, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        return Math.abs(f4 - this.mCalculatedPositionX) < SELECTION_SLOPE && Math.abs(f8 - this.mCalculatedPositionY) < SELECTION_SLOPE;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f4, float f8, String[] strArr, float[] fArr) {
        int i2 = this.mPositionType;
        if (i2 == 1) {
            positionPathAttributes(floatRect, floatRect2, f4, f8, strArr, fArr);
        } else if (i2 != 2) {
            positionCartAttributes(floatRect, floatRect2, f4, f8, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f4, f8, strArr, fArr);
        }
    }

    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f4, float f8, String[] strArr, float[] fArr) {
        float fCenterX = floatRect.centerX();
        float fCenterY = floatRect.centerY();
        float fCenterX2 = floatRect2.centerX() - fCenterX;
        float fCenterY2 = floatRect2.centerY() - fCenterY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f4 - fCenterX) / fCenterX2;
            strArr[1] = "percentY";
            fArr[1] = (f8 - fCenterY) / fCenterY2;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = (f4 - fCenterX) / fCenterX2;
            fArr[1] = (f8 - fCenterY) / fCenterY2;
        } else {
            fArr[1] = (f4 - fCenterX) / fCenterX2;
            fArr[0] = (f8 - fCenterY) / fCenterY2;
        }
    }

    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f4, float f8, String[] strArr, float[] fArr) {
        float fCenterX = floatRect.centerX();
        float fCenterY = floatRect.centerY();
        float fCenterX2 = floatRect2.centerX() - fCenterX;
        float fCenterY2 = floatRect2.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f9 = fCenterX2 / fHypot;
        float f10 = fCenterY2 / fHypot;
        float f11 = f8 - fCenterY;
        float f12 = f4 - fCenterX;
        float f13 = ((f9 * f11) - (f12 * f10)) / fHypot;
        float f14 = ((f10 * f11) + (f9 * f12)) / fHypot;
        String str = strArr[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                fArr[0] = f14;
                fArr[1] = f13;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f14;
        fArr[1] = f13;
    }

    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f4, float f8, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f4 / width;
            strArr[1] = "percentY";
            fArr[1] = f8 / height;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = f4 / width;
            fArr[1] = f8 / height;
        } else {
            fArr[1] = f4 / width;
            fArr[0] = f8 / height;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i8) {
        if (i2 == 100) {
            this.mFramePosition = i8;
            return true;
        }
        if (i2 == 508) {
            this.mCurveFit = i8;
            return true;
        }
        if (i2 != 510) {
            return super.setValue(i2, i8);
        }
        this.mPositionType = i8;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public MotionKey mo33clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f4) {
        switch (i2) {
            case 503:
                this.mPercentWidth = f4;
                return true;
            case 504:
                this.mPercentHeight = f4;
                return true;
            case 505:
                this.mPercentWidth = f4;
                this.mPercentHeight = f4;
                return true;
            case 506:
                this.mPercentX = f4;
                return true;
            case 507:
                this.mPercentY = f4;
                return true;
            default:
                return super.setValue(i2, f4);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 != 501) {
            return super.setValue(i2, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }
}

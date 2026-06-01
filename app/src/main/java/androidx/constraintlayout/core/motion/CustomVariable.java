package androidx.constraintlayout.core.motion;

import a1.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable customVariable) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        this.mIntegerValue = customVariable.mIntegerValue;
        this.mFloatValue = customVariable.mFloatValue;
        this.mStringValue = customVariable.mStringValue;
        this.mBooleanValue = customVariable.mBooleanValue;
    }

    private static int clamp(int i2) {
        int i8 = (i2 & (~(i2 >> 31))) - 255;
        return (i8 & (i8 >> 31)) + 255;
    }

    public static String colorString(int i2) {
        return "#" + a.i(i2, new StringBuilder("00000000")).substring(r2.length() - 8);
    }

    public static int hsvToRgb(float f4, float f8, float f9) {
        float f10 = f4 * 6.0f;
        int i2 = (int) f10;
        float f11 = f10 - i2;
        float f12 = f9 * 255.0f;
        int iA = (int) a.a(1.0f, f8, f12, 0.5f);
        int i8 = (int) (((1.0f - (f11 * f8)) * f12) + 0.5f);
        int i9 = (int) (((1.0f - ((1.0f - f11) * f8)) * f12) + 0.5f);
        int i10 = (int) (f12 + 0.5f);
        if (i2 == 0) {
            return ((i10 << 16) + (i9 << 8) + iA) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 1) {
            return ((i8 << 16) + (i10 << 8) + iA) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 2) {
            return ((iA << 16) + (i10 << 8) + i9) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 3) {
            return ((iA << 16) + (i8 << 8) + i10) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 4) {
            return ((i9 << 16) + (iA << 8) + i10) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 != 5) {
            return 0;
        }
        return ((i10 << 16) + (iA << 8) + i8) | ViewCompat.MEASURED_STATE_MASK;
    }

    public static int rgbaTocColor(float f4, float f8, float f9, float f10) {
        int iClamp = clamp((int) (f4 * 255.0f));
        int iClamp2 = clamp((int) (f8 * 255.0f));
        return (iClamp << 16) | (clamp((int) (f10 * 255.0f)) << 24) | (iClamp2 << 8) | clamp((int) (f9 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i2 = this.mType;
        switch (i2) {
            case 900:
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                motionWidget.setCustomAttribute(this.mName, i2, this.mIntegerValue);
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(this.mName, i2, this.mFloatValue);
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                motionWidget.setCustomAttribute(this.mName, i2, this.mStringValue);
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(this.mName, i2, this.mBooleanValue);
                break;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        int i2;
        if (customVariable != null && (i2 = this.mType) == customVariable.mType) {
            switch (i2) {
                case 900:
                case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                    if (this.mIntegerValue == customVariable.mIntegerValue) {
                        return true;
                    }
                    break;
                case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    return this.mFloatValue == customVariable.mFloatValue;
                case TypedValues.Custom.TYPE_COLOR /* 902 */:
                    return this.mIntegerValue == customVariable.mIntegerValue;
                case TypedValues.Custom.TYPE_STRING /* 903 */:
                    return this.mIntegerValue == customVariable.mIntegerValue;
                case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                    return this.mBooleanValue == customVariable.mBooleanValue;
                case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                    return this.mFloatValue == customVariable.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case 900:
                return this.mIntegerValue;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                return this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case 900:
                fArr[0] = this.mIntegerValue;
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                fArr[0] = this.mFloatValue;
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                int i2 = (this.mIntegerValue >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i2 / 255.0f;
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i2 = this.mType;
        return (i2 == 903 || i2 == 904 || i2 == 906) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        return this.mType != 902 ? 1 : 4;
    }

    public void setBooleanValue(boolean z2) {
        this.mBooleanValue = z2;
    }

    public void setFloatValue(float f4) {
        this.mFloatValue = f4;
    }

    public void setIntValue(int i2) {
        this.mIntegerValue = i2;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i2 = this.mType;
        switch (i2) {
            case 900:
                motionWidget.setCustomAttribute(this.mName, i2, (int) fArr[0]);
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(this.mName, i2, fArr[0]);
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                motionWidget.setCustomAttribute(this.mName, this.mType, (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                throw new RuntimeException("unable to interpolate " + this.mName);
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(this.mName, i2, fArr[0] > 0.5f);
                return;
            default:
                return;
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.mIntegerValue = (int) fArr[0];
                return;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.mFloatValue = fArr[0];
                return;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.mIntegerValue = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String strE = a.e(':', this.mName, new StringBuilder());
        switch (this.mType) {
            case 900:
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(strE);
                sbR.append(this.mIntegerValue);
                return sbR.toString();
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(strE);
                sbR2.append(this.mFloatValue);
                return sbR2.toString();
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                StringBuilder sbR3 = androidx.camera.core.processing.util.a.r(strE);
                sbR3.append(colorString(this.mIntegerValue));
                return sbR3.toString();
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                StringBuilder sbR4 = androidx.camera.core.processing.util.a.r(strE);
                sbR4.append(this.mStringValue);
                return sbR4.toString();
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                StringBuilder sbR5 = androidx.camera.core.processing.util.a.r(strE);
                sbR5.append(Boolean.valueOf(this.mBooleanValue));
                return sbR5.toString();
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                StringBuilder sbR6 = androidx.camera.core.processing.util.a.r(strE);
                sbR6.append(this.mFloatValue);
                return sbR6.toString();
            default:
                return a.C(strE, "????");
        }
    }

    public CustomVariable(String str, int i2, String str2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mName = str;
        this.mType = i2;
        this.mStringValue = str2;
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                this.mStringValue = (String) obj;
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }

    public CustomVariable(String str, int i2, int i8) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i2;
        if (i2 == 901) {
            this.mFloatValue = i8;
        } else {
            this.mIntegerValue = i8;
        }
    }

    public CustomVariable(String str, int i2, float f4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i2;
        this.mFloatValue = f4;
    }

    public CustomVariable(String str, int i2, boolean z2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i2;
        this.mBooleanValue = z2;
    }

    public CustomVariable(String str, int i2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i2;
    }

    public CustomVariable(String str, int i2, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i2;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        setValue(obj);
    }
}

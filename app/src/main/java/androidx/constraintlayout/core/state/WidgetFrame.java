package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    private final HashMap<String, CustomVariable> mCustom;
    TypedBundle mMotionProperties;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    private static void add(StringBuilder sb, String str, int i2) {
        sb.append(str);
        sb.append(": ");
        sb.append(i2);
        sb.append(",\n");
    }

    public static void interpolate(int i2, int i8, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f4) {
        int i9;
        int i10;
        int i11;
        float f8;
        int i12;
        float f9;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f10 = 100.0f * f4;
        int i18 = (int) f10;
        int i19 = widgetFrame2.left;
        int i20 = widgetFrame2.top;
        int i21 = widgetFrame3.left;
        int i22 = widgetFrame3.top;
        int i23 = widgetFrame2.right - i19;
        int i24 = widgetFrame2.bottom - i20;
        int i25 = widgetFrame3.right - i21;
        int i26 = widgetFrame3.bottom - i22;
        int i27 = i19;
        float f11 = widgetFrame2.alpha;
        float f12 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            int i28 = i27 - ((int) (i25 / 2.0f));
            i11 = i20 - ((int) (i26 / 2.0f));
            if (Float.isNaN(f11)) {
                i9 = i26;
                i27 = i28;
                i10 = i25;
                f8 = 0.0f;
            } else {
                i27 = i28;
                i10 = i25;
                f8 = f11;
                i9 = i26;
            }
        } else {
            i9 = i26;
            i26 = i24;
            i10 = i23;
            i11 = i20;
            f8 = f11;
        }
        if (widgetFrame3.visibility == 8) {
            i21 -= (int) (i10 / 2.0f);
            i22 -= (int) (i26 / 2.0f);
            if (Float.isNaN(f12)) {
                i12 = i26;
                i25 = i10;
                f12 = 0.0f;
            } else {
                i12 = i26;
                i25 = i10;
            }
        } else {
            i12 = i9;
        }
        if (Float.isNaN(f8) && !Float.isNaN(f12)) {
            f8 = 1.0f;
        }
        if (!Float.isNaN(f8) && Float.isNaN(f12)) {
            f12 = 1.0f;
        }
        int i29 = i21;
        float f13 = widgetFrame2.visibility == 4 ? 0.0f : f8;
        int i30 = i22;
        float f14 = widgetFrame3.visibility == 4 ? 0.0f : f12;
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            f9 = f4;
            i13 = i29;
            i14 = i30;
            i15 = i11;
        } else {
            Transition.KeyPosition keyPositionFindPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i18);
            int i31 = i11;
            Transition.KeyPosition keyPositionFindNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i18);
            if (keyPositionFindPreviousPosition == keyPositionFindNextPosition) {
                keyPositionFindNextPosition = null;
            }
            if (keyPositionFindPreviousPosition != null) {
                i27 = (int) (keyPositionFindPreviousPosition.mX * i2);
                i15 = (int) (keyPositionFindPreviousPosition.mY * i8);
                i16 = keyPositionFindPreviousPosition.mFrame;
            } else {
                i16 = 0;
                i15 = i31;
            }
            if (keyPositionFindNextPosition != null) {
                i13 = (int) (keyPositionFindNextPosition.mX * i2);
                i14 = (int) (keyPositionFindNextPosition.mY * i8);
                i17 = keyPositionFindNextPosition.mFrame;
            } else {
                i17 = 100;
                i13 = i29;
                i14 = i30;
            }
            f9 = (f10 - i16) / (i17 - i16);
        }
        int i32 = i27;
        widgetFrame.widget = widgetFrame2.widget;
        int i33 = (int) (((i13 - i32) * f9) + i32);
        widgetFrame.left = i33;
        int i34 = (int) ((f9 * (i14 - i15)) + i15);
        widgetFrame.top = i34;
        float f15 = 1.0f - f4;
        widgetFrame.right = i33 + ((int) ((i25 * f4) + (i10 * f15)));
        widgetFrame.bottom = i34 + ((int) ((i12 * f4) + (f15 * i26)));
        widgetFrame.pivotX = interpolate(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f4);
        widgetFrame.pivotY = interpolate(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f4);
        widgetFrame.rotationX = interpolate(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f4);
        widgetFrame.rotationY = interpolate(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f4);
        widgetFrame.rotationZ = interpolate(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f4);
        widgetFrame.scaleX = interpolate(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f4);
        widgetFrame.scaleY = interpolate(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f4);
        widgetFrame.translationX = interpolate(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f4);
        widgetFrame.translationY = interpolate(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f4);
        widgetFrame.translationZ = interpolate(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f4);
        widgetFrame.alpha = interpolate(f13, f14, 1.0f, f4);
        Set<String> setKeySet = widgetFrame3.mCustom.keySet();
        widgetFrame.mCustom.clear();
        for (String str : setKeySet) {
            if (widgetFrame2.mCustom.containsKey(str)) {
                CustomVariable customVariable = widgetFrame2.mCustom.get(str);
                CustomVariable customVariable2 = widgetFrame3.mCustom.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.mCustom.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f4)));
                } else {
                    int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[iNumberOfInterpolatedValues];
                    float[] fArr2 = new float[iNumberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i35 = 0; i35 < iNumberOfInterpolatedValues; i35++) {
                        fArr[i35] = interpolate(fArr[i35], fArr2[i35], 0.0f, f4);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    public void addCustomColor(String str, int i2) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i2);
    }

    public void addCustomFloat(String str, float f4) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f4);
    }

    public float centerX() {
        return ((this.right - r0) / 2.0f) + this.left;
    }

    public float centerY() {
        return ((this.bottom - r0) / 2.0f) + this.top;
    }

    public boolean containsCustom(@NonNull String str) {
        return this.mCustom.containsKey(str);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        return constraintWidget == null ? "unknown" : constraintWidget.stringId;
    }

    public TypedBundle getMotionProperties() {
        return this.mMotionProperties;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public void logv(String str) {
        String strC;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbX = a1.a.x(".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbX.append(hashCode() % 1000);
        String string = sbX.toString();
        if (this.widget != null) {
            StringBuilder sbX2 = a1.a.x(string, "/");
            sbX2.append(this.widget.hashCode() % 1000);
            strC = sbX2.toString();
        } else {
            strC = a1.a.C(string, "/NULL");
        }
        System.out.println(strC + " " + str);
    }

    public void parseCustom(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i2 = 0; i2 < size; i2++) {
            CLElement value = ((CLKey) cLObject.get(i2)).getValue();
            String strContent = value.content();
            if (strContent.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_COLOR, Integer.parseInt(strContent.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_STRING, strContent);
            }
        }
    }

    public void printCustomAttributes() {
        String strC;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbX = a1.a.x(".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbX.append(hashCode() % 1000);
        String string = sbX.toString();
        if (this.widget != null) {
            StringBuilder sbX2 = a1.a.x(string, "/");
            sbX2.append(this.widget.hashCode() % 1000);
            sbX2.append(" ");
            strC = sbX2.toString();
        } else {
            strC = a1.a.C(string, "/NULL ");
        }
        HashMap<String, CustomVariable> map = this.mCustom;
        if (map != null) {
            for (String str : map.keySet()) {
                PrintStream printStream = System.out;
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(strC);
                sbR.append(this.mCustom.get(str).toString());
                printStream.println(sbR.toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public void setCustomAttribute(String str, int i2, float f4) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f4);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, f4));
        }
    }

    public void setMotionAttributes(TypedBundle typedBundle) {
        this.mMotionProperties = typedBundle;
    }

    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        str.getClass();
        switch (str) {
            case "phone_orientation":
                phone_orientation = cLElement.getFloat();
                return true;
            case "bottom":
                this.bottom = cLElement.getInt();
                return true;
            case "custom":
                parseCustom(cLElement);
                return true;
            case "rotationX":
                this.rotationX = cLElement.getFloat();
                return true;
            case "rotationY":
                this.rotationY = cLElement.getFloat();
                return true;
            case "rotationZ":
                this.rotationZ = cLElement.getFloat();
                return true;
            case "translationX":
                this.translationX = cLElement.getFloat();
                return true;
            case "translationY":
                this.translationY = cLElement.getFloat();
                return true;
            case "translationZ":
                this.translationZ = cLElement.getFloat();
                return true;
            case "pivotX":
                this.pivotX = cLElement.getFloat();
                return true;
            case "pivotY":
                this.pivotY = cLElement.getFloat();
                return true;
            case "scaleX":
                this.scaleX = cLElement.getFloat();
                return true;
            case "scaleY":
                this.scaleY = cLElement.getFloat();
                return true;
            case "top":
                this.top = cLElement.getInt();
                return true;
            case "left":
                this.left = cLElement.getInt();
                return true;
            case "alpha":
                this.alpha = cLElement.getFloat();
                return true;
            case "right":
                this.right = cLElement.getInt();
                return true;
            case "interpolatedPos":
                this.interpolatedPos = cLElement.getFloat();
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        setMotionAttributes(widgetFrame.mMotionProperties);
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z2) {
        sb.append("{\n");
        add(sb, "left", this.left);
        add(sb, "top", this.top);
        add(sb, "right", this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, type);
            }
        }
        if (z2) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z2) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i2, int i8) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i8);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, i8));
        }
    }

    private static void add(StringBuilder sb, String str, float f4) {
        if (Float.isNaN(f4)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f4);
        sb.append(",\n");
    }

    public void setCustomAttribute(String str, int i2, boolean z2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, z2));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i2, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    private static float interpolate(float f4, float f8, float f9, float f10) {
        boolean zIsNaN = Float.isNaN(f4);
        boolean zIsNaN2 = Float.isNaN(f8);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f4 = f9;
        }
        if (zIsNaN2) {
            f8 = f9;
        }
        return a1.a.a(f8, f4, f10, f4);
    }
}

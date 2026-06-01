package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import com.ironsource.C2300e4;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TransitionParser {
    private static int map(String str, String... strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].equals(str)) {
                return i2;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CLObject cLObject2;
        int i2;
        String[] strArr;
        CLArray arrayOrNull2 = cLObject.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 == null || (arrayOrNull = cLObject.getArrayOrNull("frames")) == null) {
            return;
        }
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
        boolean[] zArr = {false, false, true, true, true, false, false, false, false};
        int size = arrayOrNull.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i8 = 0; i8 < arrayOrNull.size(); i8++) {
            typedBundleArr[i8] = new TypedBundle();
        }
        int i9 = 0;
        for (int i10 = 9; i9 < i10; i10 = 9) {
            String str = strArr2[i9];
            int i11 = iArr[i9];
            boolean z2 = zArr[i9];
            CLArray arrayOrNull3 = cLObject.getArrayOrNull(str);
            if (arrayOrNull3 != null && arrayOrNull3.size() != size) {
                throw new CLParsingException(a1.a.m("incorrect size for ", str, " array, not matching targets array!"), cLObject);
            }
            if (arrayOrNull3 != null) {
                int i12 = 0;
                while (i12 < size) {
                    float pixels = arrayOrNull3.getFloat(i12);
                    String[] strArr3 = strArr2;
                    if (z2) {
                        pixels = transition.mToPixel.toPixels(pixels);
                    }
                    typedBundleArr[i12].add(i11, pixels);
                    i12++;
                    strArr2 = strArr3;
                }
                strArr = strArr2;
            } else {
                strArr = strArr2;
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (z2) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (int i13 = 0; i13 < size; i13++) {
                        typedBundleArr[i13].add(i11, floatOrNaN);
                    }
                }
            }
            i9++;
            strArr2 = strArr;
        }
        int i14 = 0;
        CLElement orNull = cLObject.getOrNull(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM);
        if (orNull == null || !(orNull instanceof CLObject)) {
            customVariableArr = null;
        } else {
            CLObject cLObject3 = (CLObject) orNull;
            int size2 = cLObject3.size();
            customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, arrayOrNull.size(), size2);
            int i15 = 0;
            while (i15 < size2) {
                CLKey cLKey = (CLKey) cLObject3.get(i15);
                String strContent = cLKey.content();
                if (cLKey.getValue() instanceof CLArray) {
                    CLArray cLArray = (CLArray) cLKey.getValue();
                    int size3 = cLArray.size();
                    if (size3 != size || size3 <= 0) {
                        cLObject2 = cLObject3;
                    } else {
                        int i16 = i14;
                        if (cLArray.get(i16) instanceof CLNumber) {
                            int i17 = i16;
                            while (i17 < size) {
                                customVariableArr[i17][i15] = new CustomVariable(strContent, TypedValues.Custom.TYPE_FLOAT, cLArray.get(i17).getFloat());
                                i17++;
                                cLObject3 = cLObject3;
                            }
                            cLObject2 = cLObject3;
                        } else {
                            cLObject2 = cLObject3;
                            int i18 = 0;
                            while (i18 < size) {
                                long colorString = ConstraintSetParser.parseColorString(cLArray.get(i18).content());
                                if (colorString != -1) {
                                    i2 = i18;
                                    customVariableArr[i18][i15] = new CustomVariable(strContent, TypedValues.Custom.TYPE_COLOR, (int) colorString);
                                } else {
                                    i2 = i18;
                                }
                                i18 = i2 + 1;
                            }
                        }
                    }
                } else {
                    cLObject2 = cLObject3;
                    CLElement value = cLKey.getValue();
                    if (value instanceof CLNumber) {
                        float f4 = value.getFloat();
                        for (int i19 = 0; i19 < size; i19++) {
                            customVariableArr[i19][i15] = new CustomVariable(strContent, TypedValues.Custom.TYPE_FLOAT, f4);
                        }
                    } else {
                        long colorString2 = ConstraintSetParser.parseColorString(value.content());
                        if (colorString2 != -1) {
                            int i20 = 0;
                            while (i20 < size) {
                                customVariableArr[i20][i15] = new CustomVariable(strContent, TypedValues.Custom.TYPE_COLOR, (int) colorString2);
                                i20++;
                                size2 = size2;
                                colorString2 = colorString2;
                            }
                        }
                    }
                }
                i15++;
                size2 = size2;
                cLObject3 = cLObject2;
                i14 = 0;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        for (int i21 = 0; i21 < arrayOrNull2.size(); i21++) {
            for (int i22 = 0; i22 < size; i22++) {
                String string = arrayOrNull2.getString(i21);
                TypedBundle typedBundle = typedBundleArr[i22];
                if (stringOrNull2 != null) {
                    typedBundle.add(508, map(stringOrNull2, "spline", "linear"));
                }
                typedBundle.addIfNotNull(501, stringOrNull);
                typedBundle.add(100, arrayOrNull.getInt(i22));
                transition.addKeyAttribute(string, typedBundle, customVariableArr != null ? customVariableArr[i22] : null);
            }
        }
    }

    private static void parseKeyCycle(CLObject cLObject, Transition transition) throws CLParsingException {
        int[] iArr;
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", TypedValues.CycleType.S_WAVE_PERIOD, TypedValues.CycleType.S_WAVE_OFFSET, TypedValues.CycleType.S_WAVE_PHASE};
        int[] iArr2 = {311, 312, 304, 305, 306, 308, 309, 310, 403, TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_WAVE_PHASE};
        int[] iArr3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        int size = array2.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            typedBundleArr[i2] = new TypedBundle();
        }
        boolean z2 = false;
        for (int i8 = 0; i8 < 12; i8++) {
            if (cLObject.has(strArr[i8]) && iArr3[i8] == 1) {
                z2 = true;
            }
        }
        int i9 = 0;
        for (int i10 = 12; i9 < i10; i10 = 12) {
            String str = strArr[i9];
            int i11 = iArr2[i9];
            int i12 = iArr3[i9];
            CLArray arrayOrNull = cLObject.getArrayOrNull(str);
            String[] strArr2 = strArr;
            if (arrayOrNull != null && arrayOrNull.size() != size) {
                throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject);
            }
            if (arrayOrNull != null) {
                int i13 = 0;
                while (i13 < size) {
                    float pixels = arrayOrNull.getFloat(i13);
                    int[] iArr4 = iArr2;
                    if (i12 == 1) {
                        pixels = transition.mToPixel.toPixels(pixels);
                    } else if (i12 == 2 && z2) {
                        pixels = transition.mToPixel.toPixels(pixels);
                    }
                    typedBundleArr[i13].add(i11, pixels);
                    i13++;
                    iArr2 = iArr4;
                }
                iArr = iArr2;
            } else {
                iArr = iArr2;
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (i12 == 1) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    } else if (i12 == 2 && z2) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (int i14 = 0; i14 < size; i14++) {
                        typedBundleArr[i14].add(i11, floatOrNaN);
                    }
                }
            }
            i9++;
            strArr = strArr2;
            iArr2 = iArr;
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        String stringOrNull3 = cLObject.getStringOrNull("easing");
        String stringOrNull4 = cLObject.getStringOrNull("waveShape");
        String stringOrNull5 = cLObject.getStringOrNull(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE);
        for (int i15 = 0; i15 < array.size(); i15++) {
            for (int i16 = 0; i16 < size; i16++) {
                String string = array.getString(i15);
                TypedBundle typedBundle = typedBundleArr[i16];
                if (stringOrNull2 != null) {
                    if (stringOrNull2.equals("linear")) {
                        typedBundle.add(401, 1);
                    } else if (stringOrNull2.equals("spline")) {
                        typedBundle.add(401, 0);
                    }
                }
                typedBundle.addIfNotNull(501, stringOrNull);
                if (stringOrNull3 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_EASING, stringOrNull3);
                }
                if (stringOrNull4 != null) {
                    typedBundle.add(421, stringOrNull4);
                }
                if (stringOrNull5 != null) {
                    typedBundle.add(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, stringOrNull5);
                }
                typedBundle.add(100, array2.getInt(i16));
                transition.addKeyCycle(string, typedBundle);
            }
        }
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        if (arrayOrNull != null) {
            for (int i2 = 0; i2 < arrayOrNull.size(); i2++) {
                CLElement cLElement = arrayOrNull.get(i2);
                if (cLElement instanceof CLObject) {
                    parseKeyPosition((CLObject) cLElement, transition);
                }
            }
        }
        CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull2 != null) {
            for (int i8 = 0; i8 < arrayOrNull2.size(); i8++) {
                CLElement cLElement2 = arrayOrNull2.get(i8);
                if (cLElement2 instanceof CLObject) {
                    parseKeyAttribute((CLObject) cLElement2, transition);
                }
            }
        }
        CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
        if (arrayOrNull3 != null) {
            for (int i9 = 0; i9 < arrayOrNull3.size(); i9++) {
                CLElement cLElement3 = arrayOrNull3.get(i9);
                if (cLElement3 instanceof CLObject) {
                    parseKeyCycle((CLObject) cLElement3, transition);
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        CLArray arrayOrNull = cLObject.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject.getStringOrNull("type");
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull == null || array2.size() == arrayOrNull.size()) {
            if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
                int i2 = 0;
                while (i2 < array.size()) {
                    String string = array.getString(i2);
                    int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                    typedBundle.clear();
                    typedBundle.add(510, map);
                    if (stringOrNull3 != null) {
                        map(typedBundle, 508, stringOrNull3, "spline", "linear");
                    }
                    typedBundle.addIfNotNull(501, stringOrNull2);
                    if (stringOrNull != null) {
                        map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                    }
                    int i8 = 0;
                    while (i8 < array2.size()) {
                        typedBundle.add(100, array2.getInt(i8));
                        set(typedBundle, 506, arrayOrNull, i8);
                        set(typedBundle, 507, arrayOrNull2, i8);
                        set(typedBundle, 503, arrayOrNull3, i8);
                        set(typedBundle, 504, arrayOrNull4, i8);
                        transition.addKeyPosition(string, typedBundle);
                        i8++;
                        stringOrNull4 = stringOrNull4;
                    }
                    i2++;
                    stringOrNull4 = stringOrNull4;
                }
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        String stringOrNull = cLContainer.getStringOrNull("anchor");
        int map = map(cLContainer.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer.getStringOrNull("limitBounds");
        int map3 = map(cLContainer.getStringOrNull(C2300e4.a.f8302t), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer.getStringOrNull("around");
        Transition.OnSwipe onSwipeCreateOnSwipe = transition.createOnSwipe();
        onSwipeCreateOnSwipe.setAnchorId(stringOrNull);
        onSwipeCreateOnSwipe.setAnchorSide(map);
        onSwipeCreateOnSwipe.setDragDirection(map2);
        onSwipeCreateOnSwipe.setDragScale(floatOrNaN);
        onSwipeCreateOnSwipe.setDragThreshold(floatOrNaN2);
        onSwipeCreateOnSwipe.setMaxVelocity(floatOrNaN3);
        onSwipeCreateOnSwipe.setMaxAcceleration(floatOrNaN4);
        onSwipeCreateOnSwipe.setLimitBoundsTo(stringOrNull2);
        onSwipeCreateOnSwipe.setAutoCompleteMode(map3);
        onSwipeCreateOnSwipe.setOnTouchUp(map4);
        onSwipeCreateOnSwipe.setSpringMass(floatOrNaN5);
        onSwipeCreateOnSwipe.setSpringStiffness(floatOrNaN6);
        onSwipeCreateOnSwipe.setSpringDamping(floatOrNaN7);
        onSwipeCreateOnSwipe.setSpringStopThreshold(floatOrNaN8);
        onSwipeCreateOnSwipe.setSpringBoundary(map5);
        onSwipeCreateOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i2, CLArray cLArray, int i8) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i2, cLArray.getFloat(i8));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z2 = true;
        boolean z7 = false;
        if (stringOrNull != null) {
            switch (stringOrNull) {
                case "startVertical":
                    typedBundle.add(509, 1);
                    break;
                case "startHorizontal":
                    typedBundle.add(509, 2);
                    break;
                case "flip":
                    typedBundle.add(509, 3);
                    break;
                case "none":
                    typedBundle.add(509, 0);
                    break;
                case "above":
                    typedBundle.add(509, 5);
                    break;
                case "below":
                    typedBundle.add(509, 4);
                    break;
            }
            z7 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(705, stringOrNull2);
            z7 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (Float.isNaN(floatOrNaN)) {
            z2 = z7;
        } else {
            typedBundle.add(706, floatOrNaN);
        }
        if (z2) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void map(TypedBundle typedBundle, int i2, String str, String... strArr) {
        for (int i8 = 0; i8 < strArr.length; i8++) {
            if (strArr[i8].equals(str)) {
                typedBundle.add(i2, i8);
            }
        }
    }
}

package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i2, int i8) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i8;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8, boolean z2) {
        return typedArray.getBoolean(i2, typedArray.getBoolean(i8, z2));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8) {
        Drawable drawable = typedArray.getDrawable(i2);
        return drawable == null ? typedArray.getDrawable(i8) : drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8, int i9) {
        return typedArray.getInt(i2, typedArray.getInt(i8, i9));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, boolean z2) {
        return !hasAttribute(xmlPullParser, str) ? z2 : typedArray.getBoolean(i2, z2);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, @ColorInt int i8) {
        return !hasAttribute(xmlPullParser, str) ? i8 : typedArray.getColor(i2, i8);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i2) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        int i8 = typedValue.type;
        if (i8 != 2) {
            return (i8 < 28 || i8 > 31) ? ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme) : getNamedColorStateListFromInt(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i2 + ": " + typedValue);
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i2, @ColorInt int i8) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i9 = typedValue.type;
            if (i9 >= 28 && i9 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat complexColorCompatInflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            if (complexColorCompatInflate != null) {
                return complexColorCompatInflate;
            }
        }
        return ComplexColorCompat.from(i8);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, float f4) {
        return !hasAttribute(xmlPullParser, str) ? f4 : typedArray.getFloat(i2, f4);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, int i8) {
        return !hasAttribute(xmlPullParser, str) ? i8 : typedArray.getInt(i2, i8);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, @AnyRes int i8) {
        return !hasAttribute(xmlPullParser, str) ? i8 : typedArray.getResourceId(i2, i8);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.getString(i2);
        }
        return null;
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8, @AnyRes int i9) {
        return typedArray.getResourceId(i2, typedArray.getResourceId(i8, i9));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8) {
        String string = typedArray.getString(i2);
        return string == null ? typedArray.getString(i8) : string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8) {
        CharSequence text = typedArray.getText(i2);
        return text == null ? typedArray.getText(i8) : text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i8) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        return textArray == null ? typedArray.getTextArray(i8) : textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i2) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.peekValue(i2);
        }
        return null;
    }
}

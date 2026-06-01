package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        public static int getType(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i2, boolean z2) {
        return this.mWrapped.getBoolean(i2, z2);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int i2, int i8) {
        return this.mWrapped.getColor(i2, i8);
    }

    public ColorStateList getColorStateList(int i2) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.mWrapped.hasValue(i2) || (resourceId = this.mWrapped.getResourceId(i2, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.mWrapped.getColorStateList(i2) : colorStateList;
    }

    public float getDimension(int i2, float f4) {
        return this.mWrapped.getDimension(i2, f4);
    }

    public int getDimensionPixelOffset(int i2, int i8) {
        return this.mWrapped.getDimensionPixelOffset(i2, i8);
    }

    public int getDimensionPixelSize(int i2, int i8) {
        return this.mWrapped.getDimensionPixelSize(i2, i8);
    }

    public Drawable getDrawable(int i2) {
        int resourceId;
        return (!this.mWrapped.hasValue(i2) || (resourceId = this.mWrapped.getResourceId(i2, 0)) == 0) ? this.mWrapped.getDrawable(i2) : AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i2) {
        int resourceId;
        if (!this.mWrapped.hasValue(i2) || (resourceId = this.mWrapped.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i2, float f4) {
        return this.mWrapped.getFloat(i2, f4);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i2, int i8, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i8, fontCallback);
    }

    public float getFraction(int i2, int i8, int i9, float f4) {
        return this.mWrapped.getFraction(i2, i8, i9, f4);
    }

    public int getIndex(int i2) {
        return this.mWrapped.getIndex(i2);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i2, int i8) {
        return this.mWrapped.getInt(i2, i8);
    }

    public int getInteger(int i2, int i8) {
        return this.mWrapped.getInteger(i2, i8);
    }

    public int getLayoutDimension(int i2, String str) {
        return this.mWrapped.getLayoutDimension(i2, str);
    }

    public String getNonResourceString(int i2) {
        return this.mWrapped.getNonResourceString(i2);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i2, int i8) {
        return this.mWrapped.getResourceId(i2, i8);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i2) {
        return this.mWrapped.getString(i2);
    }

    public CharSequence getText(int i2) {
        return this.mWrapped.getText(i2);
    }

    public CharSequence[] getTextArray(int i2) {
        return this.mWrapped.getTextArray(i2);
    }

    public int getType(int i2) {
        return Api21Impl.getType(this.mWrapped, i2);
    }

    public boolean getValue(int i2, TypedValue typedValue) {
        return this.mWrapped.getValue(i2, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i2) {
        return this.mWrapped.hasValue(i2);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i2) {
        return this.mWrapped.peekValue(i2);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i8) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i8));
    }

    public int getLayoutDimension(int i2, int i8) {
        return this.mWrapped.getLayoutDimension(i2, i8);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i2, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i2, iArr));
    }
}

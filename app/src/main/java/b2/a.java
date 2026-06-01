package b2;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f4143a = {R.attr.theme, androidx.appcompat.R.attr.theme};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f4144b = {com.cbt.exam.browser.R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i2, int i8) {
        return b(context, attributeSet, new int[0], i2, i8);
    }

    public static Context b(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4144b, i2, i8);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i9 = iArr2[0];
        boolean z2 = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == i9;
        if (i9 == 0 || z2) {
            return context;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i9);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i8);
            for (int i10 = 0; i10 < iArr.length; i10++) {
                iArr3[i10] = typedArrayObtainStyledAttributes2.getResourceId(i10, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr3[i11];
            if (i12 != 0) {
                contextThemeWrapper.getTheme().applyStyle(i12, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f4143a);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            contextThemeWrapper.getTheme().applyStyle(resourceId, true);
        }
        return contextThemeWrapper;
    }
}

package m1;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import t1.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static int a(Context context, int i2, int i8) {
        Integer numValueOf;
        TypedValue typedValueA = b.a(context, i2);
        if (typedValueA != null) {
            int i9 = typedValueA.resourceId;
            numValueOf = Integer.valueOf(i9 != 0 ? ContextCompat.getColor(context, i9) : typedValueA.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i8;
    }

    public static int b(View view, int i2) {
        Context context = view.getContext();
        TypedValue typedValueC = b.c(view.getContext(), i2, view.getClass().getCanonicalName());
        int i8 = typedValueC.resourceId;
        return i8 != 0 ? ContextCompat.getColor(context, i8) : typedValueC.data;
    }

    public static int c(int i2, int i8, float f4) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i8, Math.round(Color.alpha(i8) * f4)), i2);
    }
}

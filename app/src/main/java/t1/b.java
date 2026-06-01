package t1;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static TypedValue a(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i2, boolean z2) {
        TypedValue typedValueA = a(context, i2);
        return (typedValueA == null || typedValueA.type != 18) ? z2 : typedValueA.data != 0;
    }

    public static TypedValue c(Context context, int i2, String str) {
        TypedValue typedValueA = a(context, i2);
        if (typedValueA != null) {
            return typedValueA;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }
}

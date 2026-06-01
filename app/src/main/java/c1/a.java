package c1;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f4168a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f4169b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FastOutLinearInInterpolator f4170c = new FastOutLinearInInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinearOutSlowInInterpolator f4171d = new LinearOutSlowInInterpolator();
    public static final DecelerateInterpolator e = new DecelerateInterpolator();

    public static float a(float f4, float f8, float f9) {
        return a1.a.a(f8, f4, f9, f4);
    }

    public static float b(float f4, float f8, float f9, float f10, float f11) {
        return f11 <= f9 ? f4 : f11 >= f10 ? f8 : a(f4, f8, (f11 - f9) / (f10 - f9));
    }

    public static int c(int i2, int i8, float f4) {
        return Math.round(f4 * (i8 - i2)) + i2;
    }
}

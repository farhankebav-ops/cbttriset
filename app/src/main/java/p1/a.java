package p1;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.cbt.exam.browser.R;
import t1.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13320f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13324d;
    public final float e;

    public a(Context context) {
        boolean zB = b.b(context, R.attr.elevationOverlayEnabled, false);
        int iA = m1.a.a(context, R.attr.elevationOverlayColor, 0);
        int iA2 = m1.a.a(context, R.attr.elevationOverlayAccentColor, 0);
        int iA3 = m1.a.a(context, R.attr.colorSurface, 0);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f13321a = zB;
        this.f13322b = iA;
        this.f13323c = iA2;
        this.f13324d = iA3;
        this.e = f4;
    }

    public final int a(int i2, float f4) {
        int i8;
        if (!this.f13321a || ColorUtils.setAlphaComponent(i2, 255) != this.f13324d) {
            return i2;
        }
        float fMin = (this.e <= 0.0f || f4 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f4 / r1)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i2);
        int iC = m1.a.c(ColorUtils.setAlphaComponent(i2, 255), this.f13322b, fMin);
        if (fMin > 0.0f && (i8 = this.f13323c) != 0) {
            iC = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i8, f13320f), iC);
        }
        return ColorUtils.setAlphaComponent(iC, iAlpha);
    }
}

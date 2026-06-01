package cn.pedant.SweetAlert;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.cbt.exam.browser.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class SuccessTickView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f4242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4244d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4245f;
    public final float g;
    public final float h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f4246i;
    public float j;
    public float k;
    public boolean l;

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4241a = -1.0f;
        this.f4243c = a(1.2f);
        this.f4244d = a(3.0f);
        float fA = a(15.0f);
        this.e = fA;
        float fA2 = a(25.0f);
        this.f4245f = fA2;
        this.g = a(3.3f);
        this.h = a(6.7f) + fA2;
        Paint paint = new Paint();
        this.f4242b = paint;
        paint.setColor(getResources().getColor(R.color.success_stroke_color));
        this.j = fA;
        this.k = fA2;
        this.l = false;
    }

    public final float a(float f4) {
        if (this.f4241a == -1.0f) {
            this.f4241a = getResources().getDisplayMetrics().density;
        }
        return (f4 * this.f4241a) + 0.5f;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i2 = (int) (((double) height) / 1.4d);
        float f4 = (((int) (((double) width) / 1.2d)) + this.e) / 2.0f;
        float f8 = this.f4244d;
        float f9 = f4 + f8;
        float f10 = f9 - 1.0f;
        this.f4246i = f10;
        RectF rectF = new RectF();
        boolean z2 = this.l;
        float f11 = this.f4245f;
        if (z2) {
            rectF.left = 0.0f;
            rectF.right = 0.0f + this.j;
            float f12 = (i2 + f11) / 2.0f;
            rectF.top = f12;
            rectF.bottom = f12 + f8;
        } else {
            rectF.right = f10;
            rectF.left = f10 - this.j;
            float f13 = (i2 + f11) / 2.0f;
            rectF.top = f13;
            rectF.bottom = f13 + f8;
        }
        Paint paint = this.f4242b;
        float f14 = this.f4243c;
        canvas.drawRoundRect(rectF, f14, f14, paint);
        RectF rectF2 = new RectF();
        float f15 = (((i2 + f11) / 2.0f) + f8) - 1.0f;
        rectF2.bottom = f15;
        rectF2.left = f4;
        rectF2.right = f9;
        rectF2.top = f15 - this.k;
        canvas.drawRoundRect(rectF2, f14, f14, this.f4242b);
    }
}

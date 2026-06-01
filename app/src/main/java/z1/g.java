package z1;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends w1.k {
    public static final /* synthetic */ int I = 0;
    public f H;

    @Override // w1.k
    public final void f(Canvas canvas) {
        if (this.H.f17904r.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.H.f17904r);
        } else {
            canvas.clipRect(this.H.f17904r, Region.Op.DIFFERENCE);
        }
        super.f(canvas);
        canvas.restore();
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.H = new f(this.H);
        return this;
    }

    public final void x(float f4, float f8, float f9, float f10) {
        RectF rectF = this.H.f17904r;
        if (f4 == rectF.left && f8 == rectF.top && f9 == rectF.right && f10 == rectF.bottom) {
            return;
        }
        rectF.set(f4, f8, f9, f10);
        invalidateSelf();
    }
}

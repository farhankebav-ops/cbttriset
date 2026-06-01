package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends GradientDrawable {
    protected Path IlO;
    private final Paint MY;

    public MY() {
        this.IlO = new Path();
        Paint paint = new Paint(1);
        this.MY = paint;
        paint.setColor(-1);
    }

    public void IlO(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Path path = this.IlO;
        if (path == null || path.isEmpty()) {
            IlO(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.MY, 31);
        IlO(canvas);
        this.MY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.IlO, this.MY);
        this.MY.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void IlO(int i2, int i8, int i9, int i10) {
        this.IlO.addRect(i2, i8, i9, i10, Path.Direction.CW);
        invalidateSelf();
    }

    public MY(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.IlO = new Path();
        Paint paint = new Paint(1);
        this.MY = paint;
        paint.setColor(-1);
    }
}

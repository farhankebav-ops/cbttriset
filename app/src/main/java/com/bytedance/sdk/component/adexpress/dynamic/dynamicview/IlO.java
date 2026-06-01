package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends MY {
    private final Bitmap EO;
    private final Rect MY = new Rect();
    private final Paint tV = new Paint(1);

    public IlO(Bitmap bitmap, MY my) {
        this.EO = bitmap;
        if (my != null) {
            this.IlO = my.IlO;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MY
    public void IlO(Canvas canvas) {
        canvas.drawBitmap(this.EO, this.MY, getBounds(), this.tV);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.EO.getWidth();
        int height = this.EO.getHeight();
        this.MY.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                Rect rect2 = this.MY;
                int i2 = (width - iWidth) / 2;
                rect2.left = i2;
                rect2.right = i2 + iWidth;
            }
            if (height > iHeight) {
                Rect rect3 = this.MY;
                int i8 = (height - iHeight) / 2;
                rect3.top = i8;
                rect3.bottom = i8 + iHeight;
                return;
            }
            return;
        }
        float f4 = iHeight;
        float f8 = f4 * 1.0f;
        float f9 = height;
        float f10 = f8 / f9;
        float f11 = iWidth;
        float f12 = 1.0f * f11;
        float f13 = width;
        if (Math.max(f10, f12 / f13) > f10) {
            int i9 = (int) ((f8 / f11) * f13);
            Rect rect4 = this.MY;
            int i10 = (height - i9) / 2;
            rect4.top = i10;
            rect4.bottom = i10 + i9;
            return;
        }
        int i11 = (int) ((f12 / f4) * f9);
        Rect rect5 = this.MY;
        int i12 = (width - i11) / 2;
        rect5.left = i12;
        rect5.right = i12 + i11;
    }
}

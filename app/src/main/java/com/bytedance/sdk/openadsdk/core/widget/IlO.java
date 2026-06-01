package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.openadsdk.core.Cc.tV {
    private int IlO;
    private int MY;

    public IlO(Context context) {
        super(context);
        this.IlO = 0;
        this.MY = 0;
    }

    private boolean IlO() {
        return getDrawable() == null || getWidth() == 0 || getHeight() == 0;
    }

    private boolean MY() {
        if (getDrawable().getClass() != NinePatchDrawable.class) {
            return (getDrawable() instanceof BitmapDrawable) && ((BitmapDrawable) getDrawable()).getBitmap() == null;
        }
        return true;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        return paint;
    }

    private int getRadius() {
        if (this.IlO == 0) {
            this.IlO = getWidth();
        }
        if (this.MY == 0) {
            this.MY = getHeight();
        }
        int i2 = this.IlO;
        int i8 = this.MY;
        if (i2 >= i8) {
            i2 = i8;
        }
        return i2 / 2;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmapCopy;
        Bitmap bitmapIlO;
        if (IlO()) {
            return;
        }
        measure(0, 0);
        if (MY()) {
            return;
        }
        try {
            bitmapCopy = ((BitmapDrawable) getDrawable()).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmapCopy = null;
        }
        if (bitmapCopy == null) {
            super.onDraw(canvas);
            return;
        }
        try {
            bitmapIlO = IlO(bitmapCopy, getRadius());
        } catch (Throwable unused2) {
            bitmapIlO = null;
        }
        if (bitmapIlO == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmapIlO, (this.IlO / 2) - r2, (this.MY / 2) - r2, (Paint) null);
        }
    }

    private Bitmap IlO(Bitmap bitmap, int i2) {
        int i8 = i2 * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = height > width ? Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width) : height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        if (bitmapCreateBitmap != null) {
            bitmap = bitmapCreateBitmap;
        }
        if (bitmap.getWidth() != i8 || bitmap.getHeight() != i8) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i8, i8, true);
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = getPaint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap2;
    }
}

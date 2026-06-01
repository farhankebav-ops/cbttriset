package com.bytedance.adsdk.ugeno.DmF.tV;

import a1.a;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.webkit.internal.b;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends Drawable {
    private final int Bc;
    private final Paint Cc;
    private final Paint DmF;
    private final RectF EO;
    private final RectF EV;
    private final RectF IlO = new RectF();
    private final RectF MY = new RectF();
    private final Matrix NV;
    private boolean bWL;
    private float cL;
    private boolean cl;
    private float ea;
    private ColorStateList es;
    private Shader.TileMode hp;
    private final RectF lEW;
    private Shader.TileMode rp;
    private final Bitmap tV;
    private final int vCE;
    private ImageView.ScaleType xF;
    private final boolean[] zPa;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.DmF.tV.MY$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            IlO = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public MY(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.EO = rectF;
        this.lEW = new RectF();
        this.NV = new Matrix();
        this.EV = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.rp = tileMode;
        this.hp = tileMode;
        this.bWL = true;
        this.ea = 0.0f;
        this.zPa = new boolean[]{true, true, true, true};
        this.cl = false;
        this.cL = 0.0f;
        this.es = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.xF = ImageView.ScaleType.FIT_CENTER;
        this.tV = bitmap;
        int width = bitmap.getWidth();
        this.vCE = width;
        int height = bitmap.getHeight();
        this.Bc = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.Cc = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.DmF = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.es.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.cL);
    }

    public static MY IlO(Bitmap bitmap) {
        if (bitmap != null) {
            return new MY(bitmap);
        }
        return null;
    }

    public static Bitmap MY(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.bWL) {
            BitmapShader bitmapShader = new BitmapShader(this.tV, this.rp, this.hp);
            Shader.TileMode tileMode = this.rp;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.hp == tileMode2) {
                bitmapShader.setLocalMatrix(this.NV);
            }
            this.Cc.setShader(bitmapShader);
            this.bWL = false;
        }
        if (this.cl) {
            if (this.cL <= 0.0f) {
                canvas.drawOval(this.MY, this.Cc);
                return;
            } else {
                canvas.drawOval(this.MY, this.Cc);
                canvas.drawOval(this.lEW, this.DmF);
                return;
            }
        }
        if (!IlO(this.zPa)) {
            canvas.drawRect(this.MY, this.Cc);
            if (this.cL > 0.0f) {
                canvas.drawRect(this.lEW, this.DmF);
                return;
            }
            return;
        }
        float f4 = this.ea;
        if (this.cL <= 0.0f) {
            canvas.drawRoundRect(this.MY, f4, f4, this.Cc);
            IlO(canvas);
        } else {
            canvas.drawRoundRect(this.MY, f4, f4, this.Cc);
            canvas.drawRoundRect(this.lEW, f4, f4, this.DmF);
            IlO(canvas);
            MY(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Cc.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.Cc.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.Bc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.vCE;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.es.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.IlO.set(rect);
        IlO();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.es.getColorForState(iArr, 0);
        if (this.DmF.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.DmF.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.Cc.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.Cc.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.Cc.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.Cc.setFilterBitmap(z2);
        invalidateSelf();
    }

    public static Drawable IlO(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof MY) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && b.x(drawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), IlO(layerDrawable.getDrawable(i2)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapMY = MY(drawable);
        return bitmapMY != null ? new MY(bitmapMY) : drawable;
    }

    private void MY(Canvas canvas) {
        float f4;
        float f8;
        if (MY(this.zPa) || this.ea == 0.0f) {
            return;
        }
        RectF rectF = this.MY;
        float f9 = rectF.left;
        float f10 = rectF.top;
        float fWidth = rectF.width() + f9;
        float fHeight = this.MY.height() + f10;
        float f11 = this.ea;
        float f12 = this.cL / 2.0f;
        if (this.zPa[0]) {
            f4 = f10;
        } else {
            f4 = f10;
            canvas.drawLine(f9 - f12, f10, f9 + f11, f4, this.DmF);
            canvas.drawLine(f9, f4 - f12, f9, f4 + f11, this.DmF);
        }
        if (!this.zPa[1]) {
            float f13 = f4;
            canvas.drawLine((fWidth - f11) - f12, f13, fWidth, f4, this.DmF);
            canvas.drawLine(fWidth, f13 - f12, fWidth, f13 + f11, this.DmF);
            fWidth = fWidth;
        }
        if (this.zPa[2]) {
            f8 = fHeight;
        } else {
            canvas.drawLine((fWidth - f11) - f12, fHeight, fWidth + f12, fHeight, this.DmF);
            float f14 = fWidth;
            canvas.drawLine(f14, fHeight - f11, fWidth, fHeight, this.DmF);
            f8 = fHeight;
        }
        if (this.zPa[3]) {
            return;
        }
        canvas.drawLine(f9 - f12, f8, f9 + f11, f8, this.DmF);
        canvas.drawLine(f9, f8 - f11, f9, f8, this.DmF);
    }

    private void IlO() {
        float fWidth;
        float fHeight;
        int i2 = AnonymousClass1.IlO[this.xF.ordinal()];
        if (i2 == 1) {
            this.lEW.set(this.IlO);
            RectF rectF = this.lEW;
            float f4 = this.cL;
            rectF.inset(f4 / 2.0f, f4 / 2.0f);
            this.NV.reset();
            this.NV.setTranslate((int) a.a(this.lEW.width(), this.vCE, 0.5f, 0.5f), (int) a.a(this.lEW.height(), this.Bc, 0.5f, 0.5f));
        } else if (i2 == 2) {
            this.lEW.set(this.IlO);
            RectF rectF2 = this.lEW;
            float f8 = this.cL;
            rectF2.inset(f8 / 2.0f, f8 / 2.0f);
            this.NV.reset();
            float fWidth2 = 0.0f;
            if (this.lEW.height() * this.vCE > this.lEW.width() * this.Bc) {
                fWidth = this.lEW.height() / this.Bc;
                fHeight = 0.0f;
                fWidth2 = (this.lEW.width() - (this.vCE * fWidth)) * 0.5f;
            } else {
                fWidth = this.lEW.width() / this.vCE;
                fHeight = (this.lEW.height() - (this.Bc * fWidth)) * 0.5f;
            }
            this.NV.setScale(fWidth, fWidth);
            Matrix matrix = this.NV;
            float f9 = this.cL;
            matrix.postTranslate((f9 / 2.0f) + ((int) (fWidth2 + 0.5f)), (f9 / 2.0f) + ((int) (fHeight + 0.5f)));
        } else if (i2 == 3) {
            this.NV.reset();
            float fMin = (((float) this.vCE) > this.IlO.width() || ((float) this.Bc) > this.IlO.height()) ? Math.min(this.IlO.width() / this.vCE, this.IlO.height() / this.Bc) : 1.0f;
            float fWidth3 = (int) (((this.IlO.width() - (this.vCE * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.IlO.height() - (this.Bc * fMin)) * 0.5f) + 0.5f);
            this.NV.setScale(fMin, fMin);
            this.NV.postTranslate(fWidth3, fHeight2);
            this.lEW.set(this.EO);
            this.NV.mapRect(this.lEW);
            RectF rectF3 = this.lEW;
            float f10 = this.cL;
            rectF3.inset(f10 / 2.0f, f10 / 2.0f);
            this.NV.setRectToRect(this.EO, this.lEW, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.lEW.set(this.EO);
            this.NV.setRectToRect(this.EO, this.IlO, Matrix.ScaleToFit.END);
            this.NV.mapRect(this.lEW);
            RectF rectF4 = this.lEW;
            float f11 = this.cL;
            rectF4.inset(f11 / 2.0f, f11 / 2.0f);
            this.NV.setRectToRect(this.EO, this.lEW, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.lEW.set(this.EO);
            this.NV.setRectToRect(this.EO, this.IlO, Matrix.ScaleToFit.START);
            this.NV.mapRect(this.lEW);
            RectF rectF5 = this.lEW;
            float f12 = this.cL;
            rectF5.inset(f12 / 2.0f, f12 / 2.0f);
            this.NV.setRectToRect(this.EO, this.lEW, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.lEW.set(this.EO);
            this.NV.setRectToRect(this.EO, this.IlO, Matrix.ScaleToFit.CENTER);
            this.NV.mapRect(this.lEW);
            RectF rectF6 = this.lEW;
            float f13 = this.cL;
            rectF6.inset(f13 / 2.0f, f13 / 2.0f);
            this.NV.setRectToRect(this.EO, this.lEW, Matrix.ScaleToFit.FILL);
        } else {
            this.lEW.set(this.IlO);
            RectF rectF7 = this.lEW;
            float f14 = this.cL;
            rectF7.inset(f14 / 2.0f, f14 / 2.0f);
            this.NV.reset();
            this.NV.setRectToRect(this.EO, this.lEW, Matrix.ScaleToFit.FILL);
        }
        this.MY.set(this.lEW);
        this.bWL = true;
    }

    public MY MY(Shader.TileMode tileMode) {
        if (this.hp != tileMode) {
            this.hp = tileMode;
            this.bWL = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean MY(boolean[] zArr) {
        for (boolean z2 : zArr) {
            if (z2) {
                return false;
            }
        }
        return true;
    }

    private void IlO(Canvas canvas) {
        if (MY(this.zPa) || this.ea == 0.0f) {
            return;
        }
        RectF rectF = this.MY;
        float f4 = rectF.left;
        float f8 = rectF.top;
        float fWidth = rectF.width() + f4;
        float fHeight = this.MY.height() + f8;
        float f9 = this.ea;
        if (!this.zPa[0]) {
            this.EV.set(f4, f8, f4 + f9, f8 + f9);
            canvas.drawRect(this.EV, this.Cc);
        }
        if (!this.zPa[1]) {
            this.EV.set(fWidth - f9, f8, fWidth, f9);
            canvas.drawRect(this.EV, this.Cc);
        }
        if (!this.zPa[2]) {
            this.EV.set(fWidth - f9, fHeight - f9, fWidth, fHeight);
            canvas.drawRect(this.EV, this.Cc);
        }
        if (this.zPa[3]) {
            return;
        }
        this.EV.set(f4, fHeight - f9, f9 + f4, fHeight);
        canvas.drawRect(this.EV, this.Cc);
    }

    public MY IlO(float f4, float f8, float f9, float f10) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f8));
        hashSet.add(Float.valueOf(f9));
        hashSet.add(Float.valueOf(f10));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(fFloatValue) && !Float.isNaN(fFloatValue) && fFloatValue >= 0.0f) {
                    this.ea = fFloatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
                }
            } else {
                this.ea = 0.0f;
            }
            boolean[] zArr = this.zPa;
            zArr[0] = f4 > 0.0f;
            zArr[1] = f8 > 0.0f;
            zArr[2] = f9 > 0.0f;
            zArr[3] = f10 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public MY IlO(float f4) {
        this.cL = f4;
        this.DmF.setStrokeWidth(f4);
        return this;
    }

    public MY IlO(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.es = colorStateList;
        this.DmF.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public MY IlO(boolean z2) {
        this.cl = z2;
        return this;
    }

    public MY IlO(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.xF != scaleType) {
            this.xF = scaleType;
            IlO();
        }
        return this;
    }

    public MY IlO(Shader.TileMode tileMode) {
        if (this.rp != tileMode) {
            this.rp = tileMode;
            this.bWL = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean IlO(boolean[] zArr) {
        for (boolean z2 : zArr) {
            if (z2) {
                return true;
            }
        }
        return false;
    }
}

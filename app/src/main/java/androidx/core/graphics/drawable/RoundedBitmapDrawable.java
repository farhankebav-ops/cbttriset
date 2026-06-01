package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    private boolean mIsCircular;
    private int mTargetDensity;
    private int mGravity = Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
    private final Paint mPaint = new Paint(3);
    private final Matrix mShaderMatrix = new Matrix();
    final Rect mDstRect = new Rect();
    private final RectF mDstRectF = new RectF();
    private boolean mApplyGravity = true;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.mTargetDensity = 160;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (bitmap != null) {
            computeBitmapSize();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.mBitmapHeight = -1;
            this.mBitmapWidth = -1;
            this.mBitmapShader = null;
        }
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float f4) {
        return f4 > 0.05f;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        updateDstRect();
        if (this.mPaint.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, this.mPaint);
            return;
        }
        RectF rectF = this.mDstRectF;
        float f4 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, f4, f4, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.mGravity != 119 || this.mIsCircular || (bitmap = this.mBitmap) == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || isGreaterThanZero(this.mCornerRadius)) ? -3 : -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    public void gravityCompatApply(int i2, int i8, int i9, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.mIsCircular) {
            updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z2) {
        this.mPaint.setAntiAlias(z2);
        invalidateSelf();
    }

    public void setCircular(boolean z2) {
        this.mIsCircular = z2;
        this.mApplyGravity = true;
        if (!z2) {
            setCornerRadius(0.0f);
            return;
        }
        updateCircularCornerRadius();
        this.mPaint.setShader(this.mBitmapShader);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f4) {
        if (this.mCornerRadius == f4) {
            return;
        }
        this.mIsCircular = false;
        if (isGreaterThanZero(f4)) {
            this.mPaint.setShader(this.mBitmapShader);
        } else {
            this.mPaint.setShader(null);
        }
        this.mCornerRadius = f4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.mPaint.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.mPaint.setFilterBitmap(z2);
        invalidateSelf();
    }

    public void setGravity(int i2) {
        if (this.mGravity != i2) {
            this.mGravity = i2;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z2) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void updateDstRect() {
        RoundedBitmapDrawable roundedBitmapDrawable;
        if (this.mApplyGravity) {
            if (this.mIsCircular) {
                int iMin = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.gravityCompatApply(this.mGravity, iMin, iMin, getBounds(), this.mDstRect);
                int iMin2 = Math.min(roundedBitmapDrawable.mDstRect.width(), roundedBitmapDrawable.mDstRect.height());
                roundedBitmapDrawable.mDstRect.inset(Math.max(0, (roundedBitmapDrawable.mDstRect.width() - iMin2) / 2), Math.max(0, (roundedBitmapDrawable.mDstRect.height() - iMin2) / 2));
                roundedBitmapDrawable.mCornerRadius = iMin2 * 0.5f;
            } else {
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.gravityCompatApply(roundedBitmapDrawable.mGravity, roundedBitmapDrawable.mBitmapWidth, roundedBitmapDrawable.mBitmapHeight, getBounds(), roundedBitmapDrawable.mDstRect);
            }
            roundedBitmapDrawable.mDstRectF.set(roundedBitmapDrawable.mDstRect);
            if (roundedBitmapDrawable.mBitmapShader != null) {
                Matrix matrix = roundedBitmapDrawable.mShaderMatrix;
                RectF rectF = roundedBitmapDrawable.mDstRectF;
                matrix.setTranslate(rectF.left, rectF.top);
                roundedBitmapDrawable.mShaderMatrix.preScale(roundedBitmapDrawable.mDstRectF.width() / roundedBitmapDrawable.mBitmap.getWidth(), roundedBitmapDrawable.mDstRectF.height() / roundedBitmapDrawable.mBitmap.getHeight());
                roundedBitmapDrawable.mBitmapShader.setLocalMatrix(roundedBitmapDrawable.mShaderMatrix);
                roundedBitmapDrawable.mPaint.setShader(roundedBitmapDrawable.mBitmapShader);
            }
            roundedBitmapDrawable.mApplyGravity = false;
        }
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i2) {
        if (this.mTargetDensity != i2) {
            if (i2 == 0) {
                i2 = 160;
            }
            this.mTargetDensity = i2;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }
}

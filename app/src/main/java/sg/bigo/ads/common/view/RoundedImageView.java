package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class RoundedImageView extends ImageView implements sg.bigo.ads.common.view.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f16119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f16120d;
    private float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16121f;

    public RoundedImageView(Context context) {
        this(context, null);
    }

    private void a() {
        if (getOutlineProvider() instanceof sg.bigo.ads.common.view.b.b) {
            return;
        }
        super.setOutlineProvider(new sg.bigo.ads.common.view.b.b());
    }

    private RectF getImageRectF() {
        float fMin;
        float fMin2;
        float fMax;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = getDrawable();
        float f4 = 0.0f;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float[] fArr = new float[9];
            Matrix imageMatrix = getImageMatrix();
            if (imageMatrix != null && !imageMatrix.isIdentity()) {
                imageMatrix.getValues(fArr);
            }
            float f8 = fArr[2];
            float f9 = fArr[5];
            float f10 = fArr[0];
            float f11 = fArr[4];
            float fMax2 = Float.isNaN(f8) ? 0.0f : Math.max(0.0f, f8);
            fMax = Float.isNaN(f9) ? 0.0f : Math.max(0.0f, f9);
            fMin = Math.min((Float.isNaN(f10) || f10 <= 0.0f) ? intrinsicWidth + fMax2 : (intrinsicWidth * f10) + fMax2, measuredWidth);
            fMin2 = Math.min((Float.isNaN(f11) || f11 <= 0.0f) ? intrinsicHeight + fMax : (intrinsicHeight * f11) + fMax, measuredHeight);
            f4 = fMax2;
        } else {
            fMin = measuredWidth;
            fMin2 = measuredHeight;
            fMax = 0.0f;
        }
        return new RectF(f4, fMax, fMin, fMin2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Path clipPath = getClipPath();
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
        super.draw(canvas);
        RectF imageRectF = getImageRectF();
        if (this.e > 0.0f && !imageRectF.isEmpty()) {
            Paint paint = new Paint();
            paint.setColor(this.f16121f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.e);
            paint.setAntiAlias(true);
            float f4 = this.f16117a;
            canvas.drawRoundRect(imageRectF, f4, f4, paint);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // sg.bigo.ads.common.view.b.a
    public Path getClipPath() {
        RectF imageRectF = getImageRectF();
        if (Float.isNaN(this.f16117a) || Float.isNaN(this.f16118b) || Float.isNaN(this.f16120d) || Float.isNaN(this.f16119c) || imageRectF == null || imageRectF.isEmpty()) {
            return null;
        }
        Path path = new Path();
        float[] fArr = new float[8];
        float f4 = Float.isNaN(this.f16117a) ? 0.0f : this.f16117a;
        fArr[0] = f4;
        fArr[1] = f4;
        float f8 = Float.isNaN(this.f16118b) ? 0.0f : this.f16118b;
        fArr[2] = f8;
        fArr[3] = f8;
        float f9 = Float.isNaN(this.f16120d) ? 0.0f : this.f16120d;
        fArr[4] = f9;
        fArr[5] = f9;
        float f10 = Float.isNaN(this.f16119c) ? 0.0f : this.f16119c;
        fArr[6] = f10;
        fArr[7] = f10;
        path.addRoundRect(imageRectF, fArr, Path.Direction.CW);
        return path;
    }

    public void setCornerRadius(float f4) {
        this.f16117a = f4;
        this.f16118b = f4;
        this.f16119c = f4;
        this.f16120d = f4;
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        a();
    }

    public void setStrokeColor(@ColorInt int i2) {
        this.f16121f = i2;
        invalidate();
    }

    public void setStrokeWidth(float f4) {
        this.e = f4;
        invalidate();
    }

    @Override // android.view.View
    public void setTranslationZ(float f4) {
        super.setTranslationZ(f4);
        a();
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16117a = Float.NaN;
        this.f16118b = Float.NaN;
        this.f16119c = Float.NaN;
        this.f16120d = Float.NaN;
        this.f16121f = -1;
    }

    @Override // android.view.View
    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
    }
}

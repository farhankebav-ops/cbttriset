package sg.bigo.ads.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public class RoundedFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f16113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f16114d;
    private float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16115f;
    private Paint g;
    private RectF h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16116i;
    private float j;
    private Paint k;
    private RectF l;

    public RoundedFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        if (this.j > 0.0f) {
            setLayerType(1, null);
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.k = paint;
            paint.setShadowLayer(this.j, 0.0f, 0.0f, this.f16116i);
        }
    }

    private Path getPath() {
        Path path = new Path();
        float f4 = this.f16111a;
        float f8 = this.f16112b;
        float f9 = this.f16114d;
        float f10 = this.f16113c;
        float[] fArr = {f4, f4, f8, f8, f9, f9, f10, f10};
        RectF rectF = this.l;
        if (rectF == null) {
            rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        return path;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int iSave = canvas.save();
        if (this.k != null) {
            float f4 = this.j;
            RectF rectF = new RectF(f4, f4, getWidth() - this.j, getHeight() - this.j);
            this.l = rectF;
            float f8 = this.f16111a;
            canvas.drawRoundRect(rectF, f8, f8, this.k);
        }
        canvas.clipPath(getPath());
        super.dispatchDraw(canvas);
        Paint paint = this.g;
        float f9 = this.e;
        RectF rectF2 = this.h;
        if (paint != null && rectF2 != null && f9 > 0.0f) {
            float width = getWidth();
            float height = getHeight();
            if (width > 0.0f && height > 0.0f) {
                paint.setColor(this.f16115f);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(f9);
                paint.setAntiAlias(true);
                rectF2.set(0.0f, 0.0f, width, height);
                float f10 = this.f16111a;
                canvas.drawRoundRect(rectF2, f10, f10, paint);
            }
        }
        canvas.restoreToCount(iSave);
    }

    public float getCornerRadiusBottomLeft() {
        return this.f16113c;
    }

    public float getCornerRadiusBottomRight() {
        return this.f16114d;
    }

    public float getCornerRadiusTopLeft() {
        return this.f16111a;
    }

    public float getCornerRadiusTopRight() {
        return this.f16112b;
    }

    public void setCornerRadius(float f4) {
        a(f4, f4, f4, f4);
    }

    public void setShadowColor(@ColorInt int i2) {
        this.f16116i = i2;
        invalidate();
    }

    public void setShadowRadius(float f4) {
        boolean z2 = this.k == null;
        this.j = f4;
        if (z2) {
            a();
        }
        invalidate();
    }

    public void setStrokeColor(@ColorInt int i2) {
        this.f16115f = i2;
        if (this.g == null) {
            this.g = new Paint();
        }
        if (this.h == null) {
            this.h = new RectF();
        }
        invalidate();
    }

    public void setStrokeWidth(float f4) {
        this.e = f4;
        if (this.g == null) {
            this.g = new Paint();
        }
        if (this.h == null) {
            this.h = new RectF();
        }
        invalidate();
    }

    public RoundedFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void a(float f4, float f8, float f9, float f10) {
        this.f16111a = f4;
        this.f16112b = f8;
        this.f16113c = f9;
        this.f16114d = f10;
        invalidate();
    }

    public RoundedFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16115f = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedFrameLayout);
        try {
            float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_bigo_ad_radius, 0.0f);
            this.f16111a = dimension;
            this.f16112b = dimension;
            this.f16113c = dimension;
            this.f16114d = dimension;
            if (dimension == 0.0f) {
                this.f16111a = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_bigo_ad_topLeftRadius, 0.0f);
                this.f16112b = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_bigo_ad_topRightRadius, 0.0f);
                this.f16113c = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_bigo_ad_bottomLeftRadius, 0.0f);
                this.f16114d = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_bigo_ad_bottomRightRadius, 0.0f);
            }
            this.f16116i = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundedFrameLayout_bigo_ad_shadowColor, Color.parseColor("#00FFFFFF"));
            this.j = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_bigo_ad_shadowRadius, -1.0f);
            a();
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception unused) {
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}

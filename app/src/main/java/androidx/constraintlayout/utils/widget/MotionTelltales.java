package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    float[] mVelocity;
    int mVelocityMode;

    public MotionTelltales(Context context) {
        super(context);
        this.mPaintTelltales = new Paint();
        this.mVelocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.mTailColor = typedArrayObtainStyledAttributes.getColor(index, this.mTailColor);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.mVelocityMode = typedArrayObtainStyledAttributes.getInt(index, this.mVelocityMode);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.mTailScale = typedArrayObtainStyledAttributes.getFloat(index, this.mTailScale);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.mMotionLayout = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i2 = 0; i2 < 5; i2++) {
            float f4 = fArr[i2];
            for (int i8 = 0; i8 < 5; i8++) {
                float f8 = fArr[i8];
                this.mMotionLayout.getViewVelocity(this, f8, f4, this.mVelocity, this.mVelocityMode);
                this.mInvertMatrix.mapVectors(this.mVelocity);
                float f9 = width * f8;
                float f10 = height * f4;
                float[] fArr2 = this.mVelocity;
                float f11 = fArr2[0];
                float f12 = this.mTailScale;
                float f13 = f10 - (fArr2[1] * f12);
                this.mInvertMatrix.mapVectors(fArr2);
                canvas.drawLine(f9, f10, f9 - (f11 * f12), f13, this.mPaintTelltales);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaintTelltales = new Paint();
        this.mVelocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaintTelltales = new Paint();
        this.mVelocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }
}

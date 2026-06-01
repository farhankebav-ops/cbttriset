package q1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f13408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f13409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f13410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13411d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13412f;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f13409b = new Rect();
        this.f13410c = new Rect();
        this.f13411d = Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        this.e = true;
        this.f13412f = false;
        TypedArray typedArrayD = l.d(context, attributeSet, b1.a.j, 0, 0, new int[0]);
        this.f13411d = typedArrayD.getInt(1, this.f13411d);
        Drawable drawable = typedArrayD.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.e = typedArrayD.getBoolean(2, true);
        typedArrayD.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f13408a;
        if (drawable != null) {
            if (this.f13412f) {
                this.f13412f = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z2 = this.e;
                Rect rect = this.f13409b;
                if (z2) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i2 = this.f13411d;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f13410c;
                Gravity.apply(i2, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f4, float f8) {
        super.drawableHotspotChanged(f4, f8);
        Drawable drawable = this.f13408a;
        if (drawable != null) {
            drawable.setHotspot(f4, f8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f13408a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f13408a.setState(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f13408a;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f13411d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f13408a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        this.f13412f = z2 | this.f13412f;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.f13412f = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f13408a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f13408a);
            }
            this.f13408a = drawable;
            this.f13412f = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f13411d == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i2) {
        if (this.f13411d != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= GravityCompat.START;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f13411d = i2;
            if (i2 == 119 && this.f13408a != null) {
                this.f13408a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f13408a;
    }
}

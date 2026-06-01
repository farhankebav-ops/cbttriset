package sg.bigo.ads.common.i;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f15794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15795b;

    public a() {
        a(null);
    }

    public final void a(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f15794a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f15794a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return 255;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        Drawable drawable = this.f15794a;
        return drawable != null ? changingConfigurations | drawable.getChangingConfigurations() : changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f15794a;
        return drawable != null ? drawable.getColorFilter() : super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 23)
    public void getHotspotBounds(@NonNull Rect rect) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.getHotspotBounds(rect);
        } else {
            rect.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 29)
    public Insets getOpticalInsets() {
        Drawable drawable = this.f15794a;
        return drawable != null ? drawable.getOpticalInsets() : Insets.NONE;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.getOutline(outline);
        } else {
            super.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Drawable drawable = this.f15794a;
        return drawable != null && drawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f15794a;
        return drawable != null && drawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f15795b && super.mutate() == this) {
            Drawable drawable = this.f15794a;
            if (drawable != null) {
                drawable.mutate();
            }
            this.f15795b = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 23)
    public boolean onLayoutDirectionChanged(int i2) {
        Drawable drawable = this.f15794a;
        return drawable != null && drawable.setLayoutDirection(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f15794a;
        return drawable != null && drawable.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f15794a;
        if (drawable == null || !drawable.isStateful()) {
            return false;
        }
        boolean state = this.f15794a.setState(iArr);
        if (state) {
            onBoundsChange(getBounds());
        }
        return state;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    public void setHotspot(float f4, float f8) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setHotspot(f4, f8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    public void setHotspotBounds(int i2, int i8, int i9, int i10) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setHotspotBounds(i2, i8, i9, i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 29)
    public void setTintBlendMode(@NonNull BlendMode blendMode) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    public void setTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f15794a;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z7) {
        boolean visible = super.setVisible(z2, z7);
        Drawable drawable = this.f15794a;
        return (drawable != null && drawable.setVisible(z2, z7)) | visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}

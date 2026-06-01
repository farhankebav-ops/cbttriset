package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i2, @Px int i8, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i2 == bitmapDrawable.getBitmap().getWidth() && i8 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i2, i8, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i9 = bounds.left;
        int i10 = bounds.top;
        int i11 = bounds.right;
        int i12 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i8, config);
        drawable.setBounds(0, 0, i2, i8);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i9, i10, i11, i12);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i2, int i8, Bitmap.Config config, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i9 & 2) != 0) {
            i8 = drawable.getIntrinsicHeight();
        }
        if ((i9 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i2, i8, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable, @Px int i2, @Px int i8, Bitmap.Config config) {
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return toBitmap(drawable, i2, i8, config);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i2, int i8, Bitmap.Config config, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i9 & 2) != 0) {
            i8 = drawable.getIntrinsicHeight();
        }
        if ((i9 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i2, i8, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i2, @Px int i8, @Px int i9, @Px int i10) {
        drawable.setBounds(i2, i8, i9, i10);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = drawable.getBounds().left;
        }
        if ((i11 & 2) != 0) {
            i8 = drawable.getBounds().top;
        }
        if ((i11 & 4) != 0) {
            i9 = drawable.getBounds().right;
        }
        if ((i11 & 8) != 0) {
            i10 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i2, i8, i9, i10);
    }
}

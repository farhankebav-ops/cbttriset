package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T drawable;

    public DrawableResource(T t3) {
        this.drawable = (T) Preconditions.checkNotNull(t3);
    }

    public void initialize() {
        T t3 = this.drawable;
        if (t3 instanceof BitmapDrawable) {
            ((BitmapDrawable) t3).getBitmap().prepareToDraw();
        } else if (t3 instanceof GifDrawable) {
            ((GifDrawable) t3).getFirstFrame().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.drawable.getConstantState();
        return constantState == null ? this.drawable : (T) constantState.newDrawable();
    }
}

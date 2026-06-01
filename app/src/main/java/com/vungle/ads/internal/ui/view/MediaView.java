package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MediaView extends RelativeLayout {
    private ImageView imageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaView(Context context) {
        super(context);
        k.e(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ImageView imageView = this.imageView;
        if (imageView == null) {
            k.l("imageView");
            throw null;
        }
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = this.imageView;
        if (imageView2 == null) {
            k.l("imageView");
            throw null;
        }
        imageView2.setAdjustViewBounds(true);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            k.l("imageView");
            throw null;
        }
        addView(imageView3);
        requestLayout();
    }

    public final void destroy() {
        ImageView imageView;
        try {
            imageView = this.imageView;
        } catch (Exception e) {
            Logger.Companion.w("NativeAd", "error msg: " + e.getLocalizedMessage());
        }
        if (imageView == null) {
            k.l("imageView");
            throw null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        ImageView imageView2 = this.imageView;
        if (imageView2 == null) {
            k.l("imageView");
            throw null;
        }
        imageView2.setImageDrawable(null);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            k.l("imageView");
            throw null;
        }
        if (imageView3.getParent() != null) {
            ImageView imageView4 = this.imageView;
            if (imageView4 == null) {
                k.l("imageView");
                throw null;
            }
            ViewParent parent = imageView4.getParent();
            k.c(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            ImageView imageView5 = this.imageView;
            if (imageView5 != null) {
                viewGroup.removeView(imageView5);
            } else {
                k.l("imageView");
                throw null;
            }
        }
    }

    public final ImageView getMainImage$vungle_ads_release() {
        ImageView imageView = this.imageView;
        if (imageView != null) {
            return imageView;
        }
        k.l("imageView");
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.e(context, "context");
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.e(context, "context");
        initView(context);
    }
}

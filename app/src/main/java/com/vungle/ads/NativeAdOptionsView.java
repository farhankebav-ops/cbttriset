package com.vungle.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ironsource.C2300e4;
import com.vungle.ads.NativeAd;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeAdOptionsView extends FrameLayout {
    private static final int AD_OPTIONS_VIEW_SIZE = 20;
    public static final Companion Companion = new Companion(null);
    private ImageView icon;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsView(Context context) {
        super(context);
        k.e(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.icon = new ImageView(context);
        int iDpToPixels = ViewUtility.INSTANCE.dpToPixels(context, 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPixels, iDpToPixels);
        ImageView imageView = this.icon;
        if (imageView == null) {
            k.l(C2300e4.h.H0);
            throw null;
        }
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = this.icon;
        if (imageView2 != null) {
            addView(imageView2);
        } else {
            k.l(C2300e4.h.H0);
            throw null;
        }
    }

    public final void destroy() {
        ImageView imageView;
        try {
            imageView = this.icon;
        } catch (Exception e) {
            Logger.Companion.w("NativeAd", "error msg: " + e.getLocalizedMessage());
        }
        if (imageView == null) {
            k.l(C2300e4.h.H0);
            throw null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            k.l(C2300e4.h.H0);
            throw null;
        }
        imageView2.setImageDrawable(null);
        removeAllViews();
        if (getParent() != null) {
            ViewParent parent = getParent();
            k.c(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
    }

    public final ImageView getPrivacyIcon$vungle_ads_release() {
        ImageView imageView = this.icon;
        if (imageView != null) {
            return imageView;
        }
        k.l(C2300e4.h.H0);
        throw null;
    }

    public final void renderTo(FrameLayout rootView, @NativeAd.AdOptionsPosition int i2) {
        k.e(rootView, "rootView");
        if (getParent() != null) {
            ViewParent parent = getParent();
            k.c(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        rootView.addView(this);
        ViewUtility viewUtility = ViewUtility.INSTANCE;
        Context context = getContext();
        k.d(context, "context");
        int iDpToPixels = viewUtility.dpToPixels(context, 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPixels, iDpToPixels);
        if (i2 == 0) {
            layoutParams.gravity = 8388659;
        } else if (i2 == 1) {
            layoutParams.gravity = 8388661;
        } else if (i2 == 2) {
            layoutParams.gravity = 8388691;
        } else if (i2 != 3) {
            layoutParams.gravity = 8388661;
        } else {
            layoutParams.gravity = 8388693;
        }
        setLayoutParams(layoutParams);
        rootView.requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.e(context, "context");
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.e(context, "context");
        initView(context);
    }
}

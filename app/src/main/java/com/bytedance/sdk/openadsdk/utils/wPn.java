package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.webkit.internal.b;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class wPn implements com.bytedance.sdk.component.Cc.zPa {
    private final WeakReference<ImageView> IlO;

    public wPn(ImageView imageView) {
        this.IlO = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.Cc.zPa
    public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
        ImageView imageView = this.IlO.get();
        if (imageView == null) {
            return;
        }
        try {
            Object objMY = ev.MY();
            if (objMY instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) objMY);
                return;
            }
            if (!(objMY instanceof Drawable)) {
                imageView.setVisibility(8);
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && b.x((Drawable) objMY)) {
                b.g((Drawable) objMY).start();
            }
            imageView.setImageDrawable((Drawable) objMY);
        } catch (Throwable unused) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.Cc.zPa
    public void IlO(int i2, String str, @Nullable Throwable th) {
        ImageView imageView = this.IlO.get();
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}

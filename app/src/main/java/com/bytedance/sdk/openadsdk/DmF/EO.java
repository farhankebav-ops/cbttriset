package com.bytedance.sdk.openadsdk.DmF;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.webkit.internal.b;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.zPa;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements zPa {
    private zPa EO;
    private final WeakReference<ImageView> IlO;
    private final String MY = "ImageLoaderToViewWrapper";

    private EO(ImageView imageView, zPa zpa) {
        this.IlO = new WeakReference<>(imageView);
        this.EO = zpa;
    }

    public static zPa IlO(oeT oet, String str, ImageView imageView) {
        return new MY(oet, str, new EO(imageView));
    }

    public static zPa IlO(oeT oet, String str, ImageView imageView, zPa zpa) {
        return new MY(oet, str, new EO(imageView, zpa));
    }

    private EO(ImageView imageView) {
        this.IlO = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.Cc.zPa
    public void IlO(EV ev) {
        final ImageView imageView = this.IlO.get();
        if (imageView != null) {
            final Object objMY = ev.MY();
            if (objMY instanceof Bitmap) {
                if (mmj.vCE()) {
                    imageView.setImageBitmap((Bitmap) objMY);
                } else {
                    bWL.EO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.DmF.EO.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap((Bitmap) objMY);
                        }
                    });
                }
                zPa zpa = this.EO;
                if (zpa != null) {
                    zpa.IlO(ev);
                    return;
                }
                return;
            }
            if (objMY instanceof Drawable) {
                if (mmj.vCE()) {
                    IlO(objMY, imageView);
                } else {
                    bWL.EO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.DmF.EO.2
                        @Override // java.lang.Runnable
                        public void run() {
                            EO.this.IlO(objMY, imageView);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Object obj, ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 28 && b.y(obj)) {
            b.h(obj).start();
        }
        imageView.setImageDrawable((Drawable) obj);
    }

    @Override // com.bytedance.sdk.component.Cc.zPa
    public void IlO(int i2, String str, @Nullable Throwable th) {
        zPa zpa = this.EO;
        if (zpa != null) {
            zpa.IlO(i2, str, th);
        }
    }
}

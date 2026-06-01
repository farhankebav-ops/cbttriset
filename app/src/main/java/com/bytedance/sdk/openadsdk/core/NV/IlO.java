package com.bytedance.sdk.openadsdk.core.NV;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.webkit.internal.b;
import com.bytedance.adsdk.ugeno.IlO;
import com.bytedance.adsdk.ugeno.core.DmF;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.NV;
import com.bytedance.sdk.component.Cc.zPa;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.adsdk.ugeno.IlO {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.NV.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0089IlO {
        void IlO(Drawable drawable);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements zPa {
        private final int EO;
        private final WeakReference<ImageView> IlO;
        private final IlO MY;
        private final int tV;

        public MY(ImageView imageView, IlO ilO, int i2, int i8) {
            this.IlO = new WeakReference<>(imageView);
            this.MY = ilO;
            this.EO = i2;
            this.tV = i8;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(EV ev) {
            try {
                final ImageView imageView = this.IlO.get();
                if (imageView == null) {
                    return;
                }
                final Object objMY = ev.MY();
                if (objMY instanceof Drawable) {
                    mmj.IlO((Runnable) new lEW("load_draw_img") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && b.y(objMY)) {
                                b.h(objMY).start();
                            }
                            imageView.setImageDrawable((Drawable) objMY);
                        }
                    });
                    return;
                }
                if (!(objMY instanceof byte[])) {
                    if (objMY instanceof Bitmap) {
                        mmj.IlO((Runnable) new lEW("ug_load_bitmap") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.3
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap((Bitmap) objMY);
                            }
                        });
                    }
                } else {
                    if (ev.Cc()) {
                        if (Build.VERSION.SDK_INT <= 30) {
                            this.MY.IlO((byte[]) objMY, imageView);
                            return;
                        } else {
                            this.MY.IlO(imageView, (byte[]) objMY, this.EO, this.tV);
                            return;
                        }
                    }
                    if (this.MY.IlO((byte[]) objMY)) {
                        this.MY.IlO(imageView, (byte[]) objMY, this.EO, this.tV);
                        return;
                    }
                    final Bitmap bitmapIlO = new com.bytedance.sdk.component.Cc.tV.EO.MY.MY(this.EO, this.tV, imageView.getScaleType(), Bitmap.Config.RGB_565, this.EO, this.tV).IlO((byte[]) objMY);
                    if (bitmapIlO != null) {
                        mmj.IlO((Runnable) new lEW("load_static_img") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.2
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(bitmapIlO);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                oeT.EO("ImageLoaderProvider", th.getMessage());
            }
        }
    }

    private void MY(final ImageView imageView, byte[] bArr, int i2, int i8) {
        final Bitmap bitmapIlO = new com.bytedance.sdk.component.Cc.tV.EO.MY.MY(i2, i8, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i2, i8).IlO(bArr);
        if (bitmapIlO != null) {
            mmj.IlO((Runnable) new lEW("loadStaticImage") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapIlO);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable MY(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileIlO;
        try {
            boolean zEO = com.bytedance.sdk.openadsdk.multipro.MY.EO();
            fileIlO = Bc.IlO(cl.IlO(), zEO, zEO ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileIlO);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT >= 28) {
                Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileIlO));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return drawableDecodeDrawable;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(cl.IlO().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
            return bitmapDrawable;
        } catch (Throwable th2) {
            th = th2;
            try {
                oeT.IlO("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO
    public void IlO(DmF dmF, String str, ImageView imageView, int i2, int i8) {
        String strIlO = EO.IlO(str);
        NV nvEO = com.bytedance.sdk.openadsdk.DmF.tV.IlO(strIlO).EO(1);
        IlO(dmF, nvEO, strIlO);
        nvEO.IlO(new MY(imageView, this, i2, i8), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final ImageView imageView, byte[] bArr, int i2, int i8) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                if (drawableDecodeDrawable != null) {
                    mmj.IlO((Runnable) new lEW("loadAnimatedDrawable") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.y(drawableDecodeDrawable)) {
                                b.h(drawableDecodeDrawable).start();
                            }
                            imageView.setImageDrawable(drawableDecodeDrawable);
                        }
                    });
                    return;
                }
                return;
            } catch (IOException e) {
                oeT.EO("ImageLoaderProvider", e.getMessage());
                return;
            }
        }
        MY(imageView, bArr, i2, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(byte[] bArr, final ImageView imageView) {
        try {
            IlO(bArr, new InterfaceC0089IlO() { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.3
                @Override // com.bytedance.sdk.openadsdk.core.NV.IlO.InterfaceC0089IlO
                public void IlO(final Drawable drawable) {
                    mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && b.y(drawable)) {
                                b.h(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            oeT.EO("ImageLoaderProvider", e.getMessage());
        }
    }

    private void IlO(final byte[] bArr, final InterfaceC0089IlO interfaceC0089IlO) {
        mmj.MY(new lEW("pag_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableMY = IlO.this.MY(bArr);
                InterfaceC0089IlO interfaceC0089IlO2 = interfaceC0089IlO;
                if (interfaceC0089IlO2 != null) {
                    interfaceC0089IlO2.IlO(drawableMY);
                }
            }
        });
    }

    public boolean IlO(byte[] bArr) {
        return com.bytedance.sdk.component.utils.EV.IlO(bArr, 0);
    }

    public void MY(DmF dmF, String str, final IlO.InterfaceC0030IlO interfaceC0030IlO) {
        NV nvEO = com.bytedance.sdk.openadsdk.DmF.tV.IlO(str).EO(2);
        IlO(dmF, nvEO, str);
        nvEO.IlO(new zPa() { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.5
            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(EV ev) {
                if (ev == null) {
                    interfaceC0030IlO.IlO(null);
                    return;
                }
                if (interfaceC0030IlO != null) {
                    Object objMY = ev.MY();
                    if (objMY instanceof Bitmap) {
                        interfaceC0030IlO.IlO((Bitmap) objMY);
                        return;
                    }
                    if (ev.MY() instanceof byte[]) {
                        try {
                            interfaceC0030IlO.IlO(BitmapFactory.decodeByteArray((byte[]) ev.MY(), 0, ((byte[]) ev.MY()).length));
                            return;
                        } catch (Throwable unused) {
                        }
                    }
                    interfaceC0030IlO.IlO(null);
                }
            }

            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(int i2, String str2, Throwable th) {
                IlO.InterfaceC0030IlO interfaceC0030IlO2 = interfaceC0030IlO;
                if (interfaceC0030IlO2 != null) {
                    interfaceC0030IlO2.IlO(null);
                }
            }
        }, 4);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO
    public void IlO(DmF dmF, String str, IlO.InterfaceC0030IlO interfaceC0030IlO) {
        MY(dmF, EO.IlO(str), interfaceC0030IlO);
    }

    private void IlO(DmF dmF, @NonNull NV nv, String str) {
        Map<String, Object> mapMY;
        if (dmF == null || (mapMY = dmF.MY()) == null) {
            return;
        }
        Object obj = mapMY.get("image_info");
        if (obj instanceof Map) {
            nv.IlO((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapMY.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        nv.MY(str2);
    }
}

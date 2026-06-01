package com.bytedance.sdk.component.Cc.tV.EO.MY;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bytedance.sdk.component.Cc.tV.EO.vCE;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.component.utils.oeT;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Cc.tV.EO.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0044IlO {
        void IlO();

        void IlO(Drawable drawable);

        void IlO(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(byte[] bArr, vCE vce, InterfaceC0044IlO interfaceC0044IlO) {
        File fileIlO;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            boolean zBc = vce.Bc();
            fileIlO = Bc.IlO(vce.IlO(), zBc, zBc ? "P_GIF_MUTIL_CACHE/" : "/P_GIF_CACHE/", "P_U_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileIlO);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT < 28) {
                if (interfaceC0044IlO != null) {
                    interfaceC0044IlO.IlO(bArr);
                }
                try {
                    fileOutputStream.close();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileIlO));
            if (interfaceC0044IlO != null) {
                interfaceC0044IlO.IlO(drawableDecodeDrawable);
            }
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                oeT.IlO("PAGGifDefaultDecoder", "Gif  getSourceByFile fail : ", th);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (interfaceC0044IlO != null) {
                    interfaceC0044IlO.IlO();
                }
            } catch (Throwable th3) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th3;
            }
        }
    }

    public void IlO(byte[] bArr, vCE vce, InterfaceC0044IlO interfaceC0044IlO) {
        if (Build.VERSION.SDK_INT <= 30) {
            IlO(bArr, interfaceC0044IlO, vce);
        } else {
            IlO(bArr, interfaceC0044IlO);
        }
    }

    public void IlO(byte[] bArr, InterfaceC0044IlO interfaceC0044IlO) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT < 28) {
            if (interfaceC0044IlO != null) {
                interfaceC0044IlO.IlO(bArr);
                return;
            }
            return;
        }
        try {
            Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
            if (interfaceC0044IlO != null) {
                interfaceC0044IlO.IlO(drawableDecodeDrawable);
            }
        } catch (Throwable th) {
            oeT.EO("PAGGifDefaultDecoder", th.getMessage());
            if (interfaceC0044IlO != null) {
                interfaceC0044IlO.IlO();
            }
        }
    }

    private void IlO(final byte[] bArr, final InterfaceC0044IlO interfaceC0044IlO, final vCE vce) {
        try {
            vce.lEW().submit(new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.MY(bArr, vce, interfaceC0044IlO);
                }
            });
        } catch (Throwable th) {
            oeT.EO("PAGGifDefaultDecoder", th.getMessage());
            if (interfaceC0044IlO != null) {
                interfaceC0044IlO.IlO();
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.cL.IlO.MY;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();

        void IlO(com.bytedance.sdk.openadsdk.cL.IlO.EO eo);
    }

    public static void IlO(com.bytedance.sdk.openadsdk.cL.vCE vce, int i2, int i8, IlO ilO, String str) {
        IlO(vce, i2, i8, ilO, str, 0);
    }

    public static void IlO(com.bytedance.sdk.openadsdk.cL.vCE vce, int i2, int i8, final IlO ilO, String str, int i9) {
        Objects.toString(vce);
        com.bytedance.sdk.openadsdk.cL.Bc.IlO().EO().IlO(vce, new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.utils.cl.1
            @Override // com.bytedance.sdk.openadsdk.cL.IlO.MY.IlO
            public void IlO(String str2, com.bytedance.sdk.openadsdk.cL.IlO.EO eo) {
                IlO ilO2;
                if (eo.Cc() && (ilO2 = ilO) != null) {
                    ilO2.IlO(eo);
                    return;
                }
                IlO ilO3 = ilO;
                if (ilO3 != null) {
                    ilO3.IlO();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.cL.IlO.MY.IlO
            public void IlO(int i10, String str2, Throwable th) {
                IlO ilO2 = ilO;
                if (ilO2 != null) {
                    ilO2.IlO();
                }
            }
        }, i2, i8, ImageView.ScaleType.CENTER_INSIDE, str, i9, null);
    }

    public static Drawable IlO(byte[] bArr, int i2) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}

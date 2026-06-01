package com.bytedance.sdk.component.adexpress.vCE;

import a1.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends com.bytedance.adsdk.MY.vCE {
    private Map<String, Bitmap> IlO;
    private String MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.Cc.zPa {
        private final String EO;
        private final WeakReference<NV> IlO;
        private final com.bytedance.adsdk.MY.NV MY;
        private final Map<String, Bitmap> tV;

        public IlO(NV nv, com.bytedance.adsdk.MY.NV nv2, String str, Map<String, Bitmap> map) {
            this.IlO = new WeakReference<>(nv);
            this.MY = nv2;
            this.EO = str;
            this.tV = map;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            Object objMY = ev.MY();
            if (objMY instanceof Bitmap) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap((Bitmap) objMY, this.MY.IlO(), this.MY.MY(), false);
                this.tV.put(this.EO, bitmapCreateScaledBitmap);
                NV nv = this.IlO.get();
                if (nv != null) {
                    nv.IlO(this.MY.lEW(), bitmapCreateScaledBitmap);
                }
            }
        }
    }

    public NV(Context context) {
        super(context);
        this.IlO = new HashMap();
    }

    public void lEW() {
        if (TextUtils.isEmpty(this.MY)) {
            return;
        }
        setProgress(0.0f);
        IlO(true);
        setAnimationFromUrl(this.MY);
        setImageAssetDelegate(new com.bytedance.adsdk.MY.tV() { // from class: com.bytedance.sdk.component.adexpress.vCE.NV.1
            @Override // com.bytedance.adsdk.MY.tV
            public Bitmap IlO(final com.bytedance.adsdk.MY.NV nv) {
                final String strLEW = nv.lEW();
                String strNV = nv.NV();
                String strDmF = nv.DmF();
                if (TextUtils.equals(strLEW, "image_0") && TextUtils.equals(strDmF, "Lark20201123-180048_2.png")) {
                    strDmF = "hand.png";
                }
                Bitmap bitmap = (Bitmap) NV.this.IlO.get(strLEW);
                if (bitmap != null) {
                    return bitmap;
                }
                if (TextUtils.isEmpty(strNV) || !TextUtils.isEmpty(strDmF)) {
                    strNV = (TextUtils.isEmpty(strDmF) || !TextUtils.isEmpty(strNV)) ? (TextUtils.isEmpty(strDmF) || TextUtils.isEmpty(strNV)) ? "" : a.C(strNV, strDmF) : strDmF;
                }
                if (TextUtils.isEmpty(strNV)) {
                    return null;
                }
                com.bytedance.sdk.component.Cc.NV nvIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().Cc().IlO(strNV).EO(2).IlO(new com.bytedance.sdk.component.Cc.lEW() { // from class: com.bytedance.sdk.component.adexpress.vCE.NV.1.1
                    @Override // com.bytedance.sdk.component.Cc.lEW
                    public Bitmap IlO(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, nv.IlO(), nv.MY(), false);
                        NV.this.IlO.put(strLEW, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                });
                NV nv2 = NV.this;
                nvIlO.IlO(new IlO(nv2, nv, strLEW, nv2.IlO));
                return (Bitmap) NV.this.IlO.get(strLEW);
            }
        });
        IlO();
    }

    public void setImageLottieTosPath(String str) {
        this.MY = str;
    }

    public void setAnimationsLoop(boolean z2) {
    }

    public void setData(Map<String, String> map) {
    }

    public void setLottieAdDescMaxLength(int i2) {
    }

    public void setLottieAdTitleMaxLength(int i2) {
    }

    public void setLottieAppNameMaxLength(int i2) {
    }
}

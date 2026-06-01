package com.bytedance.adsdk.MY.MY;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.MY.NV;
import com.bytedance.adsdk.MY.tV;
import com.bytedance.adsdk.MY.vCE.vCE;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static final Object IlO = new Object();
    private final Map<String, NV> Cc;
    private final String EO;
    private final Context MY;
    private tV tV;

    public MY(Drawable.Callback callback, String str, tV tVVar, Map<String, NV> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.EO = str;
        } else {
            this.EO = str.concat("/");
        }
        this.Cc = map;
        IlO(tVVar);
        if (callback instanceof View) {
            this.MY = ((View) callback).getContext().getApplicationContext();
        } else {
            this.MY = null;
        }
    }

    private Bitmap MY(String str, Bitmap bitmap) {
        synchronized (IlO) {
            this.Cc.get(str).IlO(bitmap);
        }
        return bitmap;
    }

    public void IlO(tV tVVar) {
        this.tV = tVVar;
    }

    public Bitmap IlO(String str, Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapEV = this.Cc.get(str).EV();
            MY(str, bitmap);
            return bitmapEV;
        }
        NV nv = this.Cc.get(str);
        Bitmap bitmapEV2 = nv.EV();
        nv.IlO(null);
        return bitmapEV2;
    }

    public Bitmap IlO(String str) {
        NV nv = this.Cc.get(str);
        if (nv == null) {
            return null;
        }
        Bitmap bitmapEV = nv.EV();
        if (bitmapEV != null) {
            return bitmapEV;
        }
        tV tVVar = this.tV;
        if (tVVar != null) {
            return tVVar.IlO(nv);
        }
        Context context = this.MY;
        if (context == null) {
            return null;
        }
        String strDmF = nv.DmF();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strDmF.startsWith("data:") && strDmF.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strDmF.substring(strDmF.indexOf(44) + 1), 0);
                return MY(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.EO)) {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.EO + strDmF), null, options);
                    if (bitmapDecodeStream == null) {
                        return null;
                    }
                    return MY(str, vCE.IlO(bitmapDecodeStream, nv.IlO(), nv.MY()));
                } catch (IllegalArgumentException unused2) {
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException unused3) {
            return null;
        }
    }

    public boolean IlO(Context context) {
        return (context == null && this.MY == null) || this.MY.equals(context);
    }
}

package com.bytedance.adsdk.MY.MY;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.MY.EO;
import com.bytedance.adsdk.MY.EO.Bc;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private EO Cc;
    private final AssetManager tV;
    private final Bc<String> IlO = new Bc<>();
    private final Map<Bc<String>, Typeface> MY = new HashMap();
    private final Map<String, Typeface> EO = new HashMap();
    private String vCE = ".ttf";

    public IlO(Drawable.Callback callback, EO eo) {
        this.Cc = eo;
        if (callback instanceof View) {
            this.tV = ((View) callback).getContext().getAssets();
        } else {
            this.tV = null;
        }
    }

    private Typeface MY(com.bytedance.adsdk.MY.EO.EO eo) {
        Typeface typefaceCreateFromAsset;
        String strIlO = eo.IlO();
        Typeface typeface = this.EO.get(strIlO);
        if (typeface != null) {
            return typeface;
        }
        String strEO = eo.EO();
        String strMY = eo.MY();
        EO eo2 = this.Cc;
        if (eo2 != null) {
            typefaceCreateFromAsset = eo2.IlO(strIlO, strEO, strMY);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.Cc.IlO(strIlO);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        EO eo3 = this.Cc;
        if (eo3 != null && typefaceCreateFromAsset == null) {
            String strMY2 = eo3.MY(strIlO, strEO, strMY);
            if (strMY2 == null) {
                strMY2 = this.Cc.MY(strIlO);
            }
            if (strMY2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.tV, strMY2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (eo.tV() != null) {
            return eo.tV();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.tV, "fonts/" + strIlO + this.vCE);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.EO.put(strIlO, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public void IlO(EO eo) {
        this.Cc = eo;
    }

    public void IlO(String str) {
        this.vCE = str;
    }

    public Typeface IlO(com.bytedance.adsdk.MY.EO.EO eo) {
        this.IlO.IlO(eo.IlO(), eo.EO());
        Typeface typeface = this.MY.get(this.IlO);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceIlO = IlO(MY(eo), eo.EO());
        this.MY.put(this.IlO, typefaceIlO);
        return typefaceIlO;
    }

    private Typeface IlO(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i2 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }
}

package com.bytedance.adsdk.ugeno.Bc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static TypedValue EO;
    private static final Object MY = new Object();
    public static Handler IlO = new Handler(Looper.getMainLooper());

    public static float IlO(Context context, String str) {
        float f4;
        float f8 = context.getResources().getDisplayMetrics().density;
        try {
            f4 = Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            f4 = 0.0f;
        }
        return (f4 * f8) + 0.5f;
    }

    public static int MY(Context context, float f4) {
        float f8 = context.getResources().getDisplayMetrics().density;
        if (f8 <= 0.0f) {
            f8 = 1.0f;
        }
        return (int) ((f4 / f8) + 0.5f);
    }

    public static float IlO(Context context, float f4) {
        return (f4 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static Bitmap IlO(Context context, Bitmap bitmap, int i2) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return null;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            RenderScript renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                return null;
            }
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(i2);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable IlO(Context context, int i2) {
        return context.getDrawable(i2);
    }

    public static boolean IlO() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void IlO(Runnable runnable) {
        if (IlO()) {
            runnable.run();
        } else {
            IlO.post(runnable);
        }
    }
}

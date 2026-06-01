package com.bytedance.sdk.component.adexpress.tV;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.pP;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private static boolean IlO;

    public static float EO(Context context, float f4) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().MY();
        }
        return f4 * tV(context);
    }

    public static int IlO(float f4, float f8, float f9, float f10) {
        return (((int) ((f4 * 255.0f) + 0.5f)) << 24) | (((int) ((f8 * 255.0f) + 0.5f)) << 16) | (((int) ((f9 * 255.0f) + 0.5f)) << 8) | ((int) ((f10 * 255.0f) + 0.5f));
    }

    public static int MY(Context context, float f4) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().MY();
        }
        float fTV = tV(context);
        if (fTV <= 0.0f) {
            fTV = 1.0f;
        }
        return (int) ((f4 / fTV) + 0.5f);
    }

    private static float tV(Context context) {
        try {
            if (IlO) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", null).setAccessible(true);
                return ((Integer) r1.invoke(r0, null)).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static float IlO(Context context, float f4) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().MY();
        }
        return (f4 * tV(context)) + 0.5f;
    }

    public static String EO(@NonNull Context context) {
        String language;
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = pP.MY(context).getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return IlO(language);
    }

    public static int MY(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().MY();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int IlO(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().MY();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String IlO(String str) {
        str.getClass();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}

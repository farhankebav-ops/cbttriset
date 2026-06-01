package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class pP {
    private static boolean Cc = false;
    private static Resources EO = null;
    private static Context IlO = null;
    private static String MY = null;
    private static String tV = null;
    private static boolean vCE = false;

    public static int Bc(Context context, String str) {
        return MY(context).getColor(lEW(context, str));
    }

    public static int Cc(Context context, String str) {
        return IlO(context, str, "id");
    }

    public static int DmF(Context context, String str) {
        return IlO(context, str, "anim");
    }

    public static Drawable EO(Context context, String str) {
        try {
            return MY(context).getDrawable(tV(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void IlO(Context context) {
        IlO = context;
    }

    public static int MY(Context context, String str) {
        return IlO(context, str, TypedValues.Custom.S_STRING);
    }

    public static int lEW(Context context, String str) {
        return IlO(context, str, "color");
    }

    private static String tV(Context context) {
        if (tV == null) {
            tV = context.getPackageName();
        }
        return tV;
    }

    public static int vCE(Context context, String str) {
        return IlO(context, str, "style");
    }

    public static void IlO(String str) {
        tV = str;
    }

    public static Resources MY(Context context) {
        Resources resources = EO;
        if (resources == null) {
            resources = null;
        }
        Context context2 = IlO;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static synchronized void EO(Context context) {
        try {
            if (TextUtils.isEmpty(MY)) {
                return;
            }
            Resources resources = context.getResources();
            EO = new Resources(MY(resources.getAssets(), MY + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            tV = context.getPackageName();
            Cc = true;
        } catch (Throwable th) {
            Log.e("ResourceHelp", "makePluginResources failed", th);
        }
    }

    private static int IlO(Context context, String str, String str2) {
        int identifier = MY(context).getIdentifier(str, str2, tV(context));
        if (identifier != 0) {
            return identifier;
        }
        if (!Cc) {
            EO(context);
            return MY(context).getIdentifier(str, str2, tV(context));
        }
        return context.getResources().getIdentifier(str, str2, tV(context));
    }

    public static int tV(Context context, String str) {
        try {
            return IlO(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    private static AssetManager MY(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(null).newInstance(null);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            IlO(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            IlO(assetManager, str);
        }
        try {
            dY.IlO(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static String IlO(Context context, String str) {
        return MY(context).getString(MY(context, str));
    }

    public static boolean IlO(AssetManager assetManager, String str) {
        Method methodIlO = dY.IlO((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodIlO == null) {
            methodIlO = dY.IlO((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodIlO != null) {
            int i2 = 3;
            while (true) {
                int i8 = i2 - 1;
                if (i2 < 0) {
                    break;
                }
                if (((Integer) methodIlO.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                }
                i2 = i8;
            }
        }
        return false;
    }
}

package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Picture;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class BS {
    private static ViewConfiguration Bc = null;
    private static int Cc = -1;
    private static float DmF = -1.0f;
    private static float EO = -1.0f;
    private static final Object EV = new Object();
    private static float IlO = -1.0f;
    private static int MY = -1;
    private static Boolean NV = null;
    private static int lEW = -1;
    private static boolean rp = true;
    private static int tV = -1;
    private static WindowManager vCE;

    public static float Bc(Context context) {
        IlO(context, true);
        return IlO;
    }

    public static int Cc(Context context) {
        IlO(context);
        return Cc;
    }

    public static int DmF(Context context) {
        IlO(context);
        return MY;
    }

    private static boolean EO() {
        return IlO < 0.0f || MY < 0 || EO < 0.0f || tV < 0 || Cc < 0;
    }

    public static int EV(Context context) {
        return ((Integer) NV(context).second).intValue();
    }

    private static boolean IlO(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    public static Pair<Integer, Integer> NV(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.cl.IlO();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static boolean bWL(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean cl(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean ea(Context context) {
        String str = Build.MODEL;
        return str.equals("IN2010") || str.equals("IN2020") || str.equals("KB2000") || str.startsWith("ONEPLUS");
    }

    public static boolean hp(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", null).invoke(clsLoadClass, null)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static float lEW(Context context) {
        IlO(context);
        return EO;
    }

    public static int rp(Context context) {
        return ((Integer) NV(context).first).intValue();
    }

    public static int tV(Context context) {
        IlO(context);
        return EO(context, tV);
    }

    public static int vCE(Context context) {
        IlO(context);
        return EO(context, Cc);
    }

    public static boolean zPa(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", TypedValues.Custom.S_STRING, "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int EO(Context context, float f4) {
        IlO(context, true);
        float fBc = Bc(context);
        if (fBc <= 0.0f) {
            fBc = 1.0f;
        }
        return (int) ((f4 / fBc) + 0.5f);
    }

    public static void IlO(Context context) {
        IlO(context, false);
    }

    public static int MY(Context context, float f4) {
        return Float.valueOf(IlO(context, f4, true)).intValue();
    }

    public static void Bc(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static void Cc(View view) {
        if (view == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.BS.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    BS.IlO(view2, 8);
                    view2.setAlpha(1.0f);
                }
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void IlO(Context context, boolean z2) {
        Context contextIlO = context == null ? com.bytedance.sdk.openadsdk.core.cl.IlO() : context;
        if (contextIlO == null) {
            return;
        }
        vCE = (WindowManager) contextIlO.getSystemService("window");
        if (EO() || z2) {
            DisplayMetrics displayMetrics = contextIlO.getResources().getDisplayMetrics();
            IlO = displayMetrics.density;
            MY = displayMetrics.densityDpi;
            EO = displayMetrics.scaledDensity;
            tV = displayMetrics.widthPixels;
            Cc = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i2 = tV;
            int i8 = Cc;
            if (i2 > i8) {
                tV = i8;
                Cc = i2;
                return;
            }
            return;
        }
        int i9 = tV;
        int i10 = Cc;
        if (i9 < i10) {
            tV = i10;
            Cc = i9;
        }
    }

    public static int[] MY(Context context) {
        if (context == null) {
            return null;
        }
        if (vCE == null) {
            vCE = (WindowManager) com.bytedance.sdk.openadsdk.core.cl.IlO().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = vCE;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i8 = displayMetrics.heightPixels;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                i2 = point.x;
                i8 = point.y;
            } catch (Exception unused) {
            }
            iArr[0] = i2;
            iArr[1] = i8;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static boolean tV(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void vCE(View view) {
        if (view == null) {
            return;
        }
        IlO(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.BS.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int EO(Context context) {
        IlO(context);
        return tV;
    }

    public static boolean tV(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                if (rootWindowInsets != null) {
                    displayCutout = rootWindowInsets.getDisplayCutout();
                    rp = false;
                } else {
                    displayCutout = null;
                }
                if (displayCutout != null) {
                    return true;
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e.getMessage());
            }
        }
        return false;
    }

    @Nullable
    public static int[] EO(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean EO(Activity activity) {
        if (NV == null) {
            synchronized (EV) {
                try {
                    if (NV == null) {
                        String strIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("cutout_devices", "");
                        String str = Build.MODEL;
                        if (!TextUtils.isEmpty(strIlO) && !TextUtils.isEmpty(str)) {
                            try {
                                JSONArray jSONArray = new JSONArray(strIlO);
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    if (str.equals(jSONArray.getString(i2))) {
                                        NV = Boolean.TRUE;
                                        return true;
                                    }
                                }
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e.getMessage());
                            }
                        }
                        NV = Boolean.valueOf(tV(activity) || IlO("ro.miui.notch", activity) == 1 || hp(activity) || cl(activity) || bWL(activity) || ea(activity) || zPa(activity));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return NV.booleanValue();
    }

    public static float IlO(Context context, float f4) {
        IlO(context);
        return lEW(context) * f4;
    }

    public static float IlO(Context context, float f4, boolean z2) {
        IlO(context);
        return (Bc(context) * f4) + (z2 ? 0.5f : 0.0f);
    }

    public static int[] MY(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    @Nullable
    public static int[] IlO(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void MY(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().clearFlags(1792);
        } catch (Exception unused) {
        }
    }

    public static void IlO(View view, int i2) {
        if (view == null || view.getVisibility() == i2 || !IlO(i2)) {
            return;
        }
        view.setVisibility(i2);
    }

    public static boolean MY() {
        return rp && Build.VERSION.SDK_INT >= 28;
    }

    private static Bitmap MY(com.bytedance.sdk.component.DmF.vCE vce) {
        if (vce == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(vce.getWidth(), vce.getHeight(), Bitmap.Config.RGB_565);
            vce.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void IlO(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void EO(final com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, String str2, final Bitmap bitmap, final String str3, final long j) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.utils.BS.4
                        @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                        public JSONObject IlO() {
                            try {
                                int iIlO = BS.IlO(bitmap);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str3);
                                long j3 = j;
                                if (j3 != -1) {
                                    jSONObject.put("page_id", j3);
                                }
                                jSONObject.put("render_type", "h5");
                                jSONObject.put("render_type_2", 0);
                                jSONObject.put("is_blank", iIlO == 100 ? 1 : 0);
                                jSONObject.put("is_playable", com.bytedance.sdk.openadsdk.core.model.OOq.MY(oet) ? 1 : 0);
                                jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(oet) ? 1 : 0);
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                    return jSONObject2;
                                } catch (JSONException unused) {
                                    return jSONObject2;
                                }
                            } catch (JSONException unused2) {
                                return null;
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>".concat(String.valueOf(th)));
            }
        }
    }

    public static void IlO(View view, int i2, int i8, int i9, int i10) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        IlO(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i8, i9, i10);
    }

    private static ArrayList<Integer> MY(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = width * height;
            int[] iArr = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i8 = 0; i8 < i2; i8++) {
                int i9 = iArr[i8];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i9) >> 16, (65280 & i9) >> 8, i9 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void IlO(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i8, int i9, int i10) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i2 && marginLayoutParams.topMargin == i8 && marginLayoutParams.rightMargin == i9 && marginLayoutParams.bottomMargin == i10) {
            return;
        }
        if (i2 != -3) {
            marginLayoutParams.leftMargin = i2;
        }
        if (i8 != -3) {
            marginLayoutParams.topMargin = i8;
        }
        if (i9 != -3) {
            marginLayoutParams.rightMargin = i9;
        }
        if (i10 != -3) {
            marginLayoutParams.bottomMargin = i10;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    private static Bitmap IlO(WebView webView) {
        Bitmap bitmapCreateBitmap = null;
        try {
            Picture pictureCapturePicture = webView.capturePicture();
            bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("UIUtils", th.getMessage());
            return bitmapCreateBitmap;
        }
    }

    public static void MY(View view, final float f4) {
        if (view != null && f4 > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.utils.BS.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f4);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static float IlO() {
        float f4 = DmF;
        if (f4 > 0.0f) {
            return f4;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.cl.IlO().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        DmF = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void IlO(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            activity.getWindow().addFlags(1792);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e.getMessage());
        }
    }

    public static int IlO(String str, Activity activity) {
        if (OOq.Cc()) {
            try {
                Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), 0)).intValue();
            } catch (ClassNotFoundException e) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e.getMessage());
            } catch (IllegalAccessException e4) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e4.getMessage());
            } catch (IllegalArgumentException e8) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e8.getMessage());
            } catch (NoSuchMethodException e9) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e9.getMessage());
            } catch (InvocationTargetException e10) {
                com.bytedance.sdk.component.utils.oeT.EO("UIUtils", e10.getMessage());
            }
        }
        return 0;
    }

    public static void IlO(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.oeT.EO("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void IlO(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.oeT.EO("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void IlO(View view, float f4) {
        if (view == null) {
            return;
        }
        view.setAlpha(f4);
    }

    public static void IlO(TextView textView, com.bytedance.sdk.openadsdk.core.widget.ea eaVar, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        IlO(textView, eaVar, oet, 14);
    }

    public static void IlO(TextView textView, com.bytedance.sdk.openadsdk.core.widget.ea eaVar, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2) {
        IlO(textView, eaVar, (oet == null || oet.VH() == null) ? -1.0d : oet.VH().tV(), i2);
    }

    public static void IlO(TextView textView, com.bytedance.sdk.openadsdk.core.widget.ea eaVar, double d8, int i2) {
        if (d8 == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            eaVar.setVisibility(8);
        } else {
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d8)));
            }
            IlO(eaVar, d8, i2);
        }
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.widget.ea eaVar, double d8, int i2) {
        if (d8 < 0.0d) {
            eaVar.setVisibility(8);
        } else {
            eaVar.setVisibility(0);
            eaVar.IlO(d8, i2);
        }
    }

    public static Bitmap IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        WebView webView = vce.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap bitmapMY = MY(vce);
        if (bitmapMY == null) {
            bitmapMY = IlO(webView);
        }
        webView.setLayerType(layerType, null);
        if (bitmapMY == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.tV.IlO(bitmapMY, bitmapMY.getWidth() / 6, bitmapMY.getHeight() / 6);
    }

    public static void IlO(final com.bytedance.sdk.openadsdk.core.model.oeT oet, final String str, final String str2, final Bitmap bitmap, final String str3, final long j) {
        mmj.MY(new com.bytedance.sdk.component.lEW.lEW("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.utils.BS.3
            @Override // java.lang.Runnable
            public void run() {
                BS.EO(oet, str, str2, bitmap, str3, j);
            }
        }, 10);
    }

    public static int IlO(Bitmap bitmap) {
        try {
            ArrayList<Integer> arrayListMY = MY(bitmap);
            if (arrayListMY == null) {
                return -1;
            }
            HashMap map = new HashMap();
            int size = arrayListMY.size();
            int iIntValue = 0;
            int i2 = 0;
            while (i2 < size) {
                Integer num = arrayListMY.get(i2);
                i2++;
                Integer num2 = num;
                if (map.containsKey(num2)) {
                    Integer numValueOf = Integer.valueOf(((Integer) map.get(num2)).intValue() + 1);
                    map.remove(num2);
                    map.put(num2, numValueOf);
                } else {
                    map.put(num2, 1);
                }
            }
            int i8 = 0;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (i8 < iIntValue2) {
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    i8 = iIntValue2;
                }
            }
            if (iIntValue == 0) {
                return -1;
            }
            return (int) ((i8 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean IlO(float f4, float f8, Context context) {
        if (f4 != -1.0f && f8 != -1.0f) {
            if (Bc == null) {
                Bc = ViewConfiguration.get(context);
            }
            if (lEW == -1) {
                lEW = Bc.getScaledTouchSlop();
            }
            if (f4 - f8 > lEW) {
                return true;
            }
        }
        return false;
    }

    public static void IlO(boolean z2) {
        NV = Boolean.valueOf(z2);
    }
}

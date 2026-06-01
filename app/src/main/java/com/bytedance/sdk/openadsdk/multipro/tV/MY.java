package com.bytedance.sdk.openadsdk.multipro.tV;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.IlO;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.DmF;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class MY {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> IlO;

    public static Map<String, ?> EO(Context context, String str) {
        SharedPreferences sharedPreferencesIlO = IlO(context, str);
        if (sharedPreferencesIlO == null) {
            return null;
        }
        return sharedPreferencesIlO.getAll();
    }

    @Nullable
    public static SharedPreferences IlO(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(IlO(str), 0);
        } catch (Throwable th) {
            oeT.EO("SPMultiHelperImpl", "getSharedPreferences error ", th.getMessage());
            return null;
        }
    }

    private static void MY(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = IlO;
        if (softReference == null || softReference.get() == null || (map = IlO.get().get(IlO(str))) == null) {
            return;
        }
        map.clear();
    }

    private static String IlO(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object IlO(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = IlO;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(IlO(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static Object MY(Context context, String str, String str2, String str3) {
        String strIlO = IlO(str);
        if (!IlO(context, strIlO, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
            return IlO.IlO(context, strIlO, str2, (String) null);
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(IlO.IlO(context, strIlO, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(IlO.IlO(context, strIlO, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(IlO.IlO(context, strIlO, str2, 0L));
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(IlO.IlO(context, strIlO, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return IlO.IlO(context, strIlO, str2, (String) null);
        }
        return null;
    }

    private static void IlO(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = IlO;
        if (softReference == null || softReference.get() == null) {
            IlO = new SoftReference<>(new ConcurrentHashMap());
        }
        String strIlO = IlO(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = IlO.get();
        if (concurrentHashMap.get(strIlO) == null) {
            concurrentHashMap.put(strIlO, new HashMap());
        }
        concurrentHashMap.get(strIlO).put(str2, obj);
    }

    public static synchronized <T> void IlO(Context context, String str, String str2, T t3) {
        String strIlO = IlO.IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            com.bytedance.sdk.component.IlO IlO2 = com.bytedance.sdk.component.IlO.IlO(context, strIlO);
            if (t3.equals(IlO(strIlO, str2))) {
                return;
            }
            IlO.EO eoMY = IlO2.MY();
            IlO(eoMY, str2, (Object) t3);
            eoMY.apply();
            IlO(strIlO, str2, t3);
            return;
        }
        SharedPreferences sharedPreferencesIlO = IlO(context, strIlO);
        if (sharedPreferencesIlO == null) {
            return;
        }
        if (t3.equals(IlO(strIlO, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesIlO.edit();
        IlO(editorEdit, str2, t3);
        editorEdit.apply();
        IlO(strIlO, str2, t3);
    }

    public static void MY(Context context, String str, String str2) {
        try {
            String strIlO = IlO.IlO(str, str2);
            if (DmF.Bc(strIlO)) {
                com.bytedance.sdk.component.IlO.IlO(context, strIlO).MY().remove(str2).apply();
                return;
            }
            SharedPreferences sharedPreferencesIlO = IlO(context, strIlO);
            if (sharedPreferencesIlO == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesIlO.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = IlO;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            Map<String, Object> map = IlO.get().get(IlO(strIlO));
            if (map != null && map.size() != 0) {
                map.remove(str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void MY(Context context, String str) {
        if (DmF.Bc(str)) {
            com.bytedance.sdk.component.IlO.IlO(context, str).MY().clear().apply();
            MY(str);
            return;
        }
        SharedPreferences sharedPreferencesIlO = IlO(context, str);
        if (sharedPreferencesIlO == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesIlO.edit();
        editorEdit.clear();
        editorEdit.apply();
        MY(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void IlO(SharedPreferences.Editor editor, String str, T t3) {
        if (t3 instanceof Integer) {
            editor.putInt(str, ((Integer) t3).intValue());
        }
        if (t3 instanceof Long) {
            editor.putLong(str, ((Long) t3).longValue());
        }
        if (t3 instanceof Float) {
            editor.putFloat(str, ((Float) t3).floatValue());
        }
        if (t3 instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t3).booleanValue());
        }
        if (t3 instanceof String) {
            editor.putString(str, (String) t3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void IlO(IlO.EO eo, String str, T t3) {
        if (t3 instanceof Integer) {
            eo.putInt(str, ((Integer) t3).intValue());
        }
        if (t3 instanceof Long) {
            eo.putLong(str, ((Long) t3).longValue());
        }
        if (t3 instanceof Float) {
            eo.putFloat(str, ((Float) t3).floatValue());
        }
        if (t3 instanceof Boolean) {
            eo.putBoolean(str, ((Boolean) t3).booleanValue());
        }
        if (t3 instanceof String) {
            eo.putString(str, (String) t3);
        }
    }

    public static String IlO(Context context, String str, String str2, String str3) {
        Object objIlO = IlO(str, str2);
        if (objIlO != null) {
            return String.valueOf(objIlO);
        }
        Object objMY = MY(context, str, str2, str3);
        IlO(str, str2, objMY);
        return String.valueOf(objMY);
    }

    public static boolean IlO(Context context, String str, String str2) {
        String strIlO = IlO.IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            return com.bytedance.sdk.component.IlO.IlO(context, strIlO).IlO(str2);
        }
        SharedPreferences sharedPreferencesIlO = IlO(context, strIlO);
        return sharedPreferencesIlO != null && sharedPreferencesIlO.contains(str2);
    }
}

package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oc {
    public static Method IlO(String str, String str2, Class<?>... clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class<?> clsIlO = IlO(str);
                if (clsIlO != null) {
                    return clsIlO.getMethod(str2, clsArr);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Class<?> IlO(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, IlO());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str, true, oc.class.getClassLoader());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str);
        }
    }

    private static ClassLoader IlO() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? oc.class.getClassLoader() : contextClassLoader;
    }
}

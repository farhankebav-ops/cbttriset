package com.pgl.ssdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f10811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f10812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f10813c;

    static {
        try {
            f10811a = Class.class.getDeclaredMethod("forName", String.class);
            f10812b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f10813c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object a(Object obj, Class cls, String str, Object obj2) {
        try {
            Field fieldA = a(cls, str);
            if (fieldA != null) {
                fieldA.setAccessible(true);
                return fieldA.get(obj);
            }
        } catch (Throwable unused) {
        }
        return obj2;
    }

    public static Field a(Class cls, String str) {
        if (!a()) {
            return null;
        }
        try {
            Field field = (Field) f10813c.invoke(cls, str);
            try {
                field.setAccessible(true);
                return field;
            } catch (Throwable unused) {
                return field;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Method a(Class cls, String str, Class[] clsArr) {
        if (!a()) {
            return null;
        }
        try {
            Method method = (Method) f10812b.invoke(cls, str, clsArr);
            try {
                method.setAccessible(true);
                return method;
            } catch (Throwable unused) {
                return method;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Object a(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            Method methodA = a(cls, str, clsArr);
            if (methodA != null) {
                return methodA.invoke(obj, objArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return (f10811a == null || f10812b == null || f10813c == null) ? false : true;
    }
}

package com.apm.insight.h;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f4426a;

    /* JADX INFO: renamed from: com.apm.insight.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0014a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f4427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f4428b;
    }

    static {
        HashMap map = new HashMap();
        f4426a = map;
        Class cls = Boolean.TYPE;
        map.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        map.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        map.put(Character.class, cls3);
        Class cls4 = Short.TYPE;
        map.put(Short.class, cls4);
        Class cls5 = Integer.TYPE;
        map.put(Integer.class, cls5);
        Class cls6 = Float.TYPE;
        map.put(Float.class, cls6);
        Class cls7 = Long.TYPE;
        map.put(Long.class, cls7);
        Class cls8 = Double.TYPE;
        map.put(Double.class, cls8);
        map.put(cls, cls);
        map.put(cls2, cls2);
        map.put(cls3, cls3);
        map.put(cls4, cls4);
        map.put(cls5, cls5);
        map.put(cls6, cls6);
        map.put(cls7, cls7);
        map.put(cls8, cls8);
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        Method method;
        Class<?>[] parameterTypes;
        try {
            Class<?> cls = Class.forName(str);
            Class<?>[] clsArr = new Class[4];
            for (int i2 = 0; i2 < 4; i2++) {
                Object obj = objArr[i2];
                clsArr[i2] = (obj == null || !(obj instanceof C0014a)) ? obj == null ? null : obj.getClass() : ((C0014a) obj).f4427a;
            }
            while (true) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i8];
                    if (method.getName().equals(str2) && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 4) {
                        for (int i9 = 0; i9 < parameterTypes.length; i9++) {
                            if (!parameterTypes[i9].isAssignableFrom(clsArr[i9])) {
                                Map<Class<?>, Class<?>> map = f4426a;
                                if (map.containsKey(parameterTypes[i9]) && map.get(parameterTypes[i9]).equals(map.get(clsArr[i9]))) {
                                }
                            }
                        }
                        break;
                    }
                    i8++;
                }
                if (method != null) {
                    method.setAccessible(true);
                    Object[] objArr2 = new Object[4];
                    for (int i10 = 0; i10 < 4; i10++) {
                        Object obj2 = objArr[i10];
                        if (obj2 == null || !(obj2 instanceof C0014a)) {
                            objArr2[i10] = obj2;
                        } else {
                            objArr2[i10] = ((C0014a) obj2).f4428b;
                        }
                    }
                    return (T) method.invoke(null, objArr2);
                }
                if (cls.getSuperclass() == null) {
                    throw new NoSuchMethodException();
                }
                cls = cls.getSuperclass();
            }
        } catch (Exception e) {
            Log.w("JavaCalls", a1.a.n("Meet exception when call Method '", str2, "' in ", str), e);
            return null;
        }
    }
}

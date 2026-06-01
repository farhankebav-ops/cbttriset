package sg.bigo.ads.common.r;

import android.util.Log;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static Object a(Object obj, String str) {
        Field field;
        try {
            try {
                field = obj.getClass().getDeclaredField(str);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                sg.bigo.ads.common.t.a.a(0, "ReflectionHelper", Log.getStackTraceString(e));
                return null;
            }
        } catch (Exception unused) {
            field = obj.getClass().getField(str);
        }
        field.setAccessible(true);
        return field.get(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(java.lang.Object r10, java.lang.String r11, java.lang.Class r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            java.lang.Class r1 = r10.getClass()
            java.lang.reflect.Method[] r1 = r1.getMethods()
            int r2 = r1.length
            r3 = 0
            r4 = r3
        Lf:
            if (r4 >= r2) goto L70
            r5 = r1[r4]
            java.lang.String r6 = r5.getName()
            boolean r6 = android.text.TextUtils.equals(r11, r6)
            if (r6 == 0) goto L6d
            java.lang.Class[] r6 = r5.getParameterTypes()
            boolean r7 = sg.bigo.ads.common.utils.k.a(r0)
            if (r7 == 0) goto L6c
            boolean r7 = sg.bigo.ads.common.utils.k.a(r6)
            if (r7 == 0) goto L2f
            r7 = r3
            goto L30
        L2f:
            int r7 = r6.length
        L30:
            r8 = 1
            if (r7 == 0) goto L35
        L33:
            r6 = r3
            goto L45
        L35:
            r7 = r3
        L36:
            if (r7 >= 0) goto L44
            r9 = r6[r7]
            boolean r9 = java.util.Objects.equals(r0, r9)
            if (r9 != 0) goto L41
            goto L33
        L41:
            int r7 = r7 + 1
            goto L36
        L44:
            r6 = r8
        L45:
            if (r6 == 0) goto L6d
            java.lang.Class r6 = r5.getReturnType()
            boolean r7 = a(r12)
            if (r7 == 0) goto L57
            boolean r7 = a(r6)
            if (r7 != 0) goto L59
        L57:
            if (r6 != r12) goto L6d
        L59:
            r5.setAccessible(r8)     // Catch: java.lang.Exception -> L61
            java.lang.Object r10 = r5.invoke(r10, r0)     // Catch: java.lang.Exception -> L61
            return r10
        L61:
            r10 = move-exception
            java.lang.String r11 = "ReflectionHelper"
            java.lang.String r10 = android.util.Log.getStackTraceString(r10)
            sg.bigo.ads.common.t.a.a(r3, r11, r10)
            goto L70
        L6c:
            throw r0
        L6d:
            int r4 = r4 + 1
            goto Lf
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.r.a.a(java.lang.Object, java.lang.String, java.lang.Class):java.lang.Object");
    }

    @Nullable
    public static <T> T a(String str, Class<T> cls) {
        try {
            Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (T) declaredConstructor.newInstance(null);
        } catch (Exception unused) {
            a0.i(0, str, "Cannot find class: ", 5, "ReflectionHelper");
            return null;
        }
    }

    private static boolean a(Class cls) {
        return cls == null || Void.class == cls;
    }

    public static boolean a(Class<?> cls, String... strArr) {
        Class<?> cls2;
        if (k.a(strArr)) {
            return false;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                cls2 = Class.forName(strArr[i2]);
            } catch (Exception unused) {
                cls2 = null;
            }
            if (cls2 != null && cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}

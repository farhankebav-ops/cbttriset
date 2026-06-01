package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.mlkit.common.MlKitException;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class jz {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Map<c, Method> f2931 = null;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2932 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2933 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2934;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c {

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f2935 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static long f2936 = -6255176130970394591L;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f2937;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private String f2938;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private Class f2939;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private List<Class> f2940;

        public c(Object obj, String str, List<Class> list) {
            if (obj instanceof Class) {
                this.f2939 = (Class) obj;
            } else {
                this.f2939 = obj.getClass();
            }
            this.f2938 = str;
            this.f2940 = list;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m2850(String str, int i2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (j.f2671) {
                try {
                    j.f2669 = i2;
                    char[] cArr2 = new char[cArr.length];
                    j.f2670 = 0;
                    while (true) {
                        int i8 = j.f2670;
                        if (i8 < cArr.length) {
                            cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2936);
                            j.f2670++;
                        } else {
                            str2 = new String(cArr2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }

        public final boolean equals(Object obj) {
            int i2 = f2937;
            int i8 = i2 + 69;
            f2935 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
            if (this == obj) {
                int i9 = i2 + 91;
                f2935 = i9 % 128;
                if (i9 % 2 == 0) {
                    int i10 = 25 / 0;
                }
                return true;
            }
            if (obj != null) {
                f2935 = (i2 + 91) % 128;
                if (c.class == obj.getClass()) {
                    c cVar = (c) obj;
                    if (this.f2939.equals(cVar.f2939) && this.f2938.equals(cVar.f2938)) {
                        return this.f2940.equals(cVar.f2940);
                    }
                    return false;
                }
            }
            return false;
        }

        public final int hashCode() {
            f2937 = (f2935 + 51) % 128;
            int iHashCode = this.f2940.hashCode() + ((this.f2938.hashCode() + (this.f2939.hashCode() * 31)) * 31);
            f2935 = (f2937 + 77) % 128;
            return iHashCode;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(m2850("\ue06c䬉뛏\ue1ae䵺룄\ue3ab佟먯\ue5fd免밇\ue7c9务빸\ue9cc咊", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 43853).intern());
            sb.append(m2850("\ue04c裟ㄡ\uda58䊀\ueb37鑳㲵ꗅ乹\uf6b8鿉ࡐ", 26801 - (ViewConfiguration.getEdgeSlop() >> 16)).intern());
            sb.append(this.f2939);
            sb.append(m2850("\ue00d⾨缞躗\udee0\uee18㶿䷑鴍겞ﳚఏ宨殉문", 53160 - Process.getGidForName("")).intern());
            sb.append(this.f2938);
            sb.append('\'');
            sb.append(m2850("\ue00dﻶ\udda2벅鮏窕妨㢌៸\uf6fd헴듙鏆犗", 7927 - KeyEvent.getDeadChar(0, 0)).intern());
            sb.append(this.f2940);
            sb.append('}');
            String string = sb.toString();
            int i2 = f2937 + 29;
            f2935 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 16 / 0;
            }
            return string;
        }
    }

    static {
        m2837();
        f2931 = new ConcurrentHashMap();
        f2932 = (f2933 + 51) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Object m2831(Class cls, List<Object> list, Class... clsArr) throws Exception {
        f2932 = (f2933 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        Object objNewInstance = cls.getConstructor(clsArr).newInstance(list.toArray());
        f2932 = (f2933 + 97) % 128;
        return objNewInstance;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2837() {
        f2934 = 196;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Class m2840(String str, boolean z2) {
        f2932 = (f2933 + 65) % 128;
        try {
            Class<?> cls = Class.forName(str);
            f2933 = (f2932 + 17) % 128;
            return cls;
        } catch (Throwable th) {
            if (!z2) {
                return null;
            }
            String strIntern = m2846(299 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 14 - ((byte) KeyEvent.getModifierMetaStateMask()), "\f￭\u0006\u0007\u0001\f\ufffb�\u0004\ufffe�￪\u000b\u0004\u0001", 12 - TextUtils.getCapsMode("", 0, 0), true).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2846(285 - (ViewConfiguration.getFadingEdgeLength() >> 16), AndroidCharacter.getMirror('0') - '*', "￪ￇ\u001a\u001a\b\u0013", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), true).intern());
            sb.append(str);
            sb.append(m2846(290 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 10 - View.resolveSize(0, 0), "\u0006ￂ\u0010\u0011\u0016ￂ\b\u0011\u0017\u0010", Color.red(0) + 1, false).intern());
            co.m1671(strIntern, sb.toString(), th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.reflect.Method] */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static Method m2847(Object obj, String str, List<Class> list) {
        int i2 = f2932 + 49;
        f2933 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                m2839(list);
                throw null;
            }
            Class<?>[] clsArrM2839 = m2839(list);
            if (!(obj instanceof Class)) {
                return obj.getClass().getMethod(str, clsArrM2839);
            }
            f2933 = (f2932 + 103) % 128;
            try {
                obj = ((Class) obj).getMethod(str, clsArrM2839);
                return obj;
            } catch (NoSuchMethodException unused) {
                return Class.class.getMethod(str, clsArrM2839);
            }
        } catch (NoSuchMethodException e) {
            String strIntern = m2846((ViewConfiguration.getPressedStateDuration() >> 16) + MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 15 - TextUtils.getOffsetBefore("", 0), "\f￭\u0006\u0007\u0001\f\ufffb�\u0004\ufffe�￪\u000b\u0004\u0001", TextUtils.getTrimmedLength("") + 12, true).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2846(TextUtils.indexOf("", "") + 261, (Process.myPid() >> 22) + 4, "\uffdf.\r￦", MotionEvent.axisFromString("") + 4, true).intern());
            sb.append(str);
            sb.append(m2846((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 284, View.getDefaultSize(0, 0) + 19, "\f\uffc8\u000e\u0017\u001a\uffc8ￏ\uffc8\u0015\r\u001c\u0010\u0017\f\uffc8\u000e\u0017\u001d\u0016", 6 - (ViewConfiguration.getTouchSlop() >> 8), false).intern());
            sb.append(obj);
            co.m1671(strIntern, sb.toString(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static List<Class> m2832(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        f2933 = (f2932 + 35) % 128;
        for (Object obj : list) {
            if (obj != null) {
                int i2 = f2933 + 25;
                f2932 = i2 % 128;
                if (i2 % 2 != 0) {
                    arrayList.add(obj.getClass());
                    throw null;
                }
                arrayList.add(obj.getClass());
            } else {
                arrayList.add(Object.class);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static Object m2834(Class cls, List<Object> list) throws Exception {
        f2932 = (f2933 + 5) % 128;
        Object objNewInstance = m2841(cls, list).newInstance(list.toArray());
        int i2 = f2932 + 105;
        f2933 = i2 % 128;
        if (i2 % 2 != 0) {
            return objNewInstance;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Method m2836(Object obj, String str, List<Object> list) {
        int i2 = f2932 + 13;
        f2933 = i2 % 128;
        int i8 = i2 % 2;
        return m2835(obj.getClass(), str, list, false);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Method m2835(Class cls, String str, List<Object> list, boolean z2) {
        Method[] methods;
        int length;
        int i2 = f2933 + 75;
        f2932 = i2 % 128;
        if (i2 % 2 != 0) {
            methods = cls.getMethods();
            length = methods.length;
        } else {
            methods = cls.getMethods();
            length = methods.length;
        }
        for (int i8 = 0; i8 < length; i8++) {
            Method method = methods[i8];
            if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                f2933 = (f2932 + 5) % 128;
                if (Modifier.isStatic(method.getModifiers()) == z2 && m2838(method, list)) {
                    return method;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static Constructor m2841(Class cls, List<Object> list) {
        Constructor<?>[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i2 = 0;
        while (i2 < length) {
            Constructor<?> constructor = constructors[i2];
            if (constructor.getParameterTypes().length == list.size()) {
                f2933 = (f2932 + 37) % 128;
                if (m2844(constructor, list)) {
                    return constructor;
                }
            }
            i2++;
            f2932 = (f2933 + 81) % 128;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m2833(java.lang.Class[] r5, java.util.List<java.lang.Object> r6) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.jz.f2933
            int r0 = r0 + 93
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.jz.f2932 = r0
            r0 = 0
            r1 = r0
        La:
            int r2 = r5.length
            if (r1 >= r2) goto L3b
            java.lang.Object r2 = r6.get(r1)
            if (r2 != 0) goto L25
            int r3 = com.ironsource.adqualitysdk.sdk.i.jz.f2932
            int r3 = r3 + 11
            int r3 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.jz.f2933 = r3
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r4 = r5[r1]
            boolean r3 = r3.isAssignableFrom(r4)
            if (r3 == 0) goto L2f
        L25:
            if (r2 == 0) goto L38
            r3 = r5[r1]
            boolean r2 = m2843(r3, r2)
            if (r2 != 0) goto L38
        L2f:
            int r5 = com.ironsource.adqualitysdk.sdk.i.jz.f2933
            int r5 = r5 + 75
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.jz.f2932 = r5
            return r0
        L38:
            int r1 = r1 + 1
            goto La
        L3b:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jz.m2833(java.lang.Class[], java.util.List):boolean");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Method m2842(Object obj, String str, List<Object> list) {
        Method methodM2836;
        c cVar = new c(obj, str, m2832(list));
        Method method = f2931.get(cVar);
        if (method != null) {
            if (m2833(method.getParameterTypes(), list)) {
                int i2 = f2933 + 47;
                f2932 = i2 % 128;
                if (i2 % 2 != 0) {
                    int i8 = 23 / 0;
                }
                return method;
            }
            String strIntern = m2846(((Process.getThreadPriority(0) + 20) >> 6) + MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 15 - (Process.myPid() >> 22), "\f￭\u0006\u0007\u0001\f\ufffb�\u0004\ufffe�￪\u000b\u0004\u0001", 12 - Color.alpha(0), true).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2846(290 - View.resolveSizeAndState(0, 0, 0), 29 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), "\u000f\u0007\u0016\n\u0011\u0006ￂ\uffe7\u0014\u0014\u0011\u0014ￂ\t\u0007\u0016\u0016\u000b\u0010\tￂ\u0005\u0003\u0005\n\u0007\u0006ￂ", TextUtils.getCapsMode("", 0, 0) + 7, false).intern());
            sb.append(cVar);
            co.m1671(strIntern, sb.toString(), null);
        }
        if (obj instanceof Class) {
            methodM2836 = m2835((Class) obj, str, list, true);
            if (methodM2836 == null) {
                f2933 = (f2932 + 95) % 128;
                methodM2836 = m2836(Class.class, str, list);
            }
        } else {
            methodM2836 = m2836(obj, str, list);
        }
        if (methodM2836 != null) {
            f2931.put(cVar, methodM2836);
        }
        return methodM2836;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static Field[] m2849(Field[] fieldArr, Field[] fieldArr2) {
        f2933 = (f2932 + 97) % 128;
        int length = fieldArr.length;
        int length2 = fieldArr2.length;
        Field[] fieldArr3 = new Field[length + length2];
        System.arraycopy(fieldArr, 0, fieldArr3, 0, length);
        System.arraycopy(fieldArr2, 0, fieldArr3, length, length2);
        f2933 = (f2932 + 1) % 128;
        return fieldArr3;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean m2838(Method method, List<Object> list) {
        int i2 = f2932 + 77;
        f2933 = i2 % 128;
        int i8 = i2 % 2;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (i8 == 0) {
            m2833(parameterTypes, list);
            throw null;
        }
        boolean zM2833 = m2833(parameterTypes, list);
        f2933 = (f2932 + 103) % 128;
        return zM2833;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Class[] m2839(List<Class> list) {
        f2933 = (f2932 + 53) % 128;
        Class[] clsArr = new Class[list.size()];
        int i2 = 0;
        while (i2 < list.size()) {
            int i8 = f2933 + 21;
            f2932 = i8 % 128;
            if (i8 % 2 != 0) {
                clsArr[i2] = list.get(i2);
                i2 += 75;
            } else {
                clsArr[i2] = list.get(i2);
                i2++;
            }
        }
        return clsArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m2848(java.lang.Class r7, java.util.List<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jz.m2848(java.lang.Class, java.util.List):boolean");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m2844(Constructor constructor, List<Object> list) {
        f2932 = (f2933 + 31) % 128;
        boolean zM2833 = m2833(constructor.getParameterTypes(), list);
        int i2 = f2932 + 29;
        f2933 = i2 % 128;
        if (i2 % 2 != 0) {
            return zM2833;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0192, code lost:
    
        if (r12.isAssignableFrom(java.lang.Boolean.class) != false) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0140  */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m2843(java.lang.Class r11, java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jz.m2843(java.lang.Class, java.lang.Object):boolean");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2846(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f2934);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        e.f1926 = i14 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Method[] m2845(Method[] methodArr, Method[] methodArr2) {
        f2932 = (f2933 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        int length = methodArr.length;
        int length2 = methodArr2.length;
        Method[] methodArr3 = new Method[length + length2];
        System.arraycopy(methodArr, 0, methodArr3, 0, length);
        System.arraycopy(methodArr2, 0, methodArr3, length, length2);
        f2933 = (f2932 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return methodArr3;
    }
}

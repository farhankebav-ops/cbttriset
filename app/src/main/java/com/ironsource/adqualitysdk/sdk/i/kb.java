package com.ironsource.adqualitysdk.sdk.i;

import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class kb {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static char[] f2948 = {':', 'd', 'g', 'x', 's', 'p', 'a', 'a', 'o', 'j', 16, 'B', 'i', 'k', 'n', 'l', 'i', 'F', 'L', 'v', 'n', 'j', 'f', 'k', 'c', 'Z', 'b', '@', 'B', 'h', 'm', 'r', 'r', 'k', 'D', 'I', 'p', 'p', 'r', '[', 16, '-', 'V', 'k', 'i', 'i', 'l', 's', 'n', 'j', 'F', 'B', 'h', 'm', 'r', 'r', 'k', 'D', 'I', 'p', 'p', 'r', '[', ':', 'p', 'l', 'm', 'O', 180, 206, 208, 211, 209, 206, 171, ';', 'r', 'i', 'b', 'j', 'n', 'l', 'n', 'G', '@', 'i', 'l', 'm', '\\', '[', 'r', 'p', 'p', 'I', 'C', 'f', 'l', 't', 'n', 'k', 'j', 'C', 'D', 'k', '1', 'i', 'p', 'i', 'j', 'l', 'd', 'S', 'R', 'f', 'l', 'g', 'a', 'b', 'g', 'i', 'f', 'l', '\\', 'T'};

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f2949 = 0;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f2950 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private Object f2951;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private c f2952;

        public a(Object obj, c cVar) {
            this.f2951 = obj;
            this.f2952 = cVar;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private Object m2889() {
            int i2 = f2950;
            Object obj = this.f2951;
            int i8 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f2949 = i8 % 128;
            if (i8 % 2 == 0) {
                return obj;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2890(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
            String str2;
            Object bytes = str;
            if (str != null) {
                bytes = str.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            synchronized (g.f2126) {
                try {
                    int i2 = iArr[0];
                    int i8 = iArr[1];
                    int i9 = iArr[2];
                    int i10 = iArr[3];
                    char[] cArr = new char[i8];
                    System.arraycopy(f2948, i2, cArr, 0, i8);
                    if (bArr != null) {
                        char[] cArr2 = new char[i8];
                        g.f2125 = 0;
                        char c7 = 0;
                        while (true) {
                            int i11 = g.f2125;
                            if (i11 >= i8) {
                                break;
                            }
                            if (bArr[i11] == 1) {
                                cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                            } else {
                                cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                            }
                            c7 = cArr2[i11];
                            g.f2125 = i11 + 1;
                        }
                        cArr = cArr2;
                    }
                    if (i10 > 0) {
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr, 0, cArr3, 0, i8);
                        int i12 = i8 - i10;
                        System.arraycopy(cArr3, 0, cArr, i12, i10);
                        System.arraycopy(cArr3, i10, cArr, 0, i12);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        g.f2125 = 0;
                        while (true) {
                            int i13 = g.f2125;
                            if (i13 >= i8) {
                                break;
                            }
                            cArr4[i13] = cArr[(i8 - i13) - 1];
                            g.f2125 = i13 + 1;
                        }
                        cArr = cArr4;
                    }
                    if (i9 > 0) {
                        g.f2125 = 0;
                        while (true) {
                            int i14 = g.f2125;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr[i14] = (char) (cArr[i14] - iArr[2]);
                            g.f2125 = i14 + 1;
                        }
                    }
                    str2 = new String(cArr);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private Object m2891(Method method) {
            int i2 = (f2949 + 101) % 128;
            f2950 = i2;
            if (method == null) {
                return null;
            }
            f2949 = (i2 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            String name = method.getName();
            if (name.hashCode() != 1622498214 || !name.equals(m2890("\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001", false, new int[]{104, 20, 0, 15}).intern())) {
                return null;
            }
            int i8 = f2949 + 7;
            f2950 = i8 % 128;
            if (i8 % 2 == 0) {
                return null;
            }
            return m2889();
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static Object[] m2892(Object[] objArr) {
            int i2 = f2949 + 99;
            f2950 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            if (objArr != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : objArr) {
                        if (Proxy.isProxyClass(obj.getClass())) {
                            int i8 = f2950 + 15;
                            f2949 = i8 % 128;
                            if (i8 % 2 != 0) {
                                arrayList.add(Proxy.getInvocationHandler(obj));
                                throw null;
                            }
                            arrayList.add(Proxy.getInvocationHandler(obj));
                        } else {
                            arrayList.add(obj);
                        }
                    }
                    return arrayList.toArray();
                } catch (Throwable th) {
                    kd.m2919(m2890("\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{0, 10, 0, 7}).intern(), m2890("\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001", false, new int[]{75, 29, 0, 13}).intern(), th, true);
                }
            }
            return objArr;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static boolean m2893(Method method) {
            String name = method.getName();
            if (name.hashCode() == 1622498214 && name.equals(m2890("\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001", false, new int[]{104, 20, 0, 15}).intern())) {
                f2949 = (f2950 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
                return true;
            }
            int i2 = f2950 + 73;
            f2949 = i2 % 128;
            if (i2 % 2 == 0) {
                return false;
            }
            throw null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object objM2891;
            int i2;
            int i8 = f2949 + 37;
            f2950 = i8 % 128;
            if (i8 % 2 == 0) {
                m2893(method);
                throw null;
            }
            if (m2893(method)) {
                try {
                    objM2891 = m2891(method);
                    i2 = f2950 + 57;
                } catch (Throwable th) {
                    String strIntern = m2890("\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{0, 10, 0, 7}).intern();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2890("\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", true, new int[]{10, 30, 0, 0}).intern());
                    sb.append(method.getName());
                    kd.m2919(strIntern, sb.toString(), th, true);
                    return null;
                }
            } else {
                try {
                    this.f2952.mo1884(obj, method, objArr);
                } catch (Throwable th2) {
                    String strIntern2 = m2890("\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{0, 10, 0, 7}).intern();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(m2890("\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", true, new int[]{40, 23, 0, 0}).intern());
                    Object obj2 = this.f2951;
                    sb2.append(obj2 != null ? obj2.toString() : m2890("\u0001\u0001\u0000\u0000", false, new int[]{63, 4, 0, 3}).intern());
                    sb2.append(m2890("\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001", true, new int[]{67, 8, 101, 0}).intern());
                    sb2.append(method.getName());
                    kd.m2919(strIntern2, sb2.toString(), th2, true);
                }
                Object obj3 = this.f2951;
                if (obj3 != null) {
                    return method.invoke(obj3, objArr);
                }
                if (!Object.class.equals(method.getDeclaringClass())) {
                    return null;
                }
                objM2891 = method.invoke(this, m2892(objArr));
                i2 = f2950 + 93;
            }
            f2949 = i2 % 128;
            return objM2891;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c {
        /* JADX INFO: renamed from: ﻐ */
        void mo1884(Object obj, Method method, Object[] objArr);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static boolean m2887(Object obj) {
        return obj != null && Proxy.isProxyClass(obj.getClass()) && (obj instanceof hc);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Object m2888(Class<?> cls, Object obj, c cVar) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls, hc.class}, new a(obj, cVar));
    }
}

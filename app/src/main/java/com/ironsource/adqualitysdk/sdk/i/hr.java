package com.ironsource.adqualitysdk.sdk.i;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hr {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private dp f2376;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private hr f2377;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e {

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private ht f2378;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private int f2379;

        private e() {
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final boolean m2356(Method method) {
            if (this.f2378 == null || (method.getModifiers() & this.f2378.m2341()) != this.f2378.m2341() || (method.getModifiers() & this.f2378.m2343()) != 0 || this.f2378.m2368().contains(method.getReturnType())) {
                return false;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (this.f2378.m2367() != -1 && this.f2378.m2367() != parameterTypes.length) {
                return false;
            }
            List<Class> listM2370 = this.f2378.m2370();
            if (listM2370 != null) {
                if (listM2370.size() != parameterTypes.length) {
                    return false;
                }
                for (int i2 = 0; i2 < listM2370.size(); i2++) {
                    if (!listM2370.get(i2).equals(parameterTypes[i2])) {
                        return false;
                    }
                }
            }
            if (this.f2378.m2371() != null ? this.f2378.m2372() ? method.getReturnType().equals(this.f2378.m2371()) : this.f2378.m2371().isAssignableFrom(method.getReturnType()) : true) {
                int i8 = this.f2379;
                if (i8 == 0) {
                    return true;
                }
                this.f2379 = i8 - 1;
            }
            return false;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final void m2358(ht htVar) {
            this.f2378 = htVar;
            this.f2379 = htVar.m2369();
        }

        public /* synthetic */ e(byte b8) {
            this();
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final ht m2357() {
            return this.f2378;
        }
    }

    public hr() {
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m2345(Class cls, ht htVar, List<Method> list) {
        e eVar = new e((byte) 0);
        eVar.m2358(htVar);
        m2348(cls, eVar, list);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static List<Method> m2346(Class cls, ht htVar) {
        ArrayList arrayList = new ArrayList();
        m2345(cls, htVar, arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m2348(Class cls, e eVar, List<Method> list) {
        ht htVarM2357 = eVar.m2357();
        for (Method method : (htVarM2357 == null || !htVarM2357.m2340()) ? Arrays.asList(cls.getDeclaredMethods()) : m2349(cls, htVarM2357.m2340(), htVarM2357.m2342())) {
            if (eVar.m2356(method)) {
                list.add(method);
            }
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static List<Method> m2349(Class cls, boolean z2, int i2) {
        Method[] methodArrM2845 = new Method[0];
        if (cls != null) {
            methodArrM2845 = jz.m2845(cls.getDeclaredMethods(), cls.getMethods());
            if (!z2) {
                return Arrays.asList(methodArrM2845);
            }
            Class superclass = cls.getSuperclass();
            for (int i8 = 0; superclass != null && i8 != i2; i8++) {
                methodArrM2845 = jz.m2845(jz.m2845(methodArrM2845, superclass.getDeclaredMethods()), superclass.getMethods());
                superclass = superclass.getSuperclass();
            }
        }
        return Arrays.asList(methodArrM2845);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final List<dm> m2355() {
        ArrayList arrayList = new ArrayList(this.f2376.m2072());
        hr hrVar = this.f2377;
        if (hrVar != null) {
            arrayList.addAll(hrVar.m2355());
        }
        return arrayList;
    }

    public hr(dp dpVar, hr hrVar) {
        this.f2376 = dpVar;
        this.f2377 = hrVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final hr m2351() {
        return this.f2377;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final dl m2350(String str) {
        dl dlVar;
        hr hrVar = this;
        do {
            dlVar = hrVar.f2376.m2073().get(str);
            if (dlVar != null) {
                break;
            }
            hrVar = hrVar.f2377;
        } while (hrVar != null);
        return dlVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Method m2347(Class cls, ht htVar) {
        ArrayList arrayList = new ArrayList();
        m2345(cls, htVar, arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Method) arrayList.get(0);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final List<String> m2354() {
        ArrayList arrayList = new ArrayList(this.f2376.m2076());
        hr hrVar = this.f2377;
        if (hrVar != null) {
            arrayList.addAll(hrVar.m2354());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m2352() {
        return this.f2376.m2075();
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final dq m2353(String str) {
        dq dqVar;
        hr hrVar = this;
        do {
            dqVar = hrVar.f2376.m2078().get(str);
            if (dqVar != null) {
                break;
            }
            hrVar = hrVar.f2377;
        } while (hrVar != null);
        return dqVar;
    }
}

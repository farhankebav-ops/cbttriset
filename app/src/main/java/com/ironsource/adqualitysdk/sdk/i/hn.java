package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.hm;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class hn {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private List<Field> f2352;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private hm f2353;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private a f2354;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a {

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private hm f2356;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private int f2357;

        private a() {
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final void m2334(hm hmVar) {
            this.f2356 = hmVar;
            this.f2357 = hmVar.m2310();
        }

        /* JADX INFO: renamed from: ﻛ */
        public boolean mo2333(Field field) {
            if (this.f2356 == null || (field.getModifiers() & this.f2356.m2341()) != this.f2356.m2341() || (field.getModifiers() & this.f2356.m2343()) != 0 || this.f2356.m2308().contains(field.getType())) {
                return false;
            }
            if (this.f2356.m2311() ? field.getType().equals(this.f2356.m2309()) : this.f2356.m2309().isAssignableFrom(field.getType())) {
                int i2 = this.f2357;
                if (i2 == 0) {
                    return true;
                }
                this.f2357 = i2 - 1;
            }
            return false;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final hm m2335() {
            return this.f2356;
        }

        public /* synthetic */ a(hn hnVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2324(Class cls, a aVar, List<Field> list) {
        for (Field field : m2326(cls, aVar.m2335())) {
            if (aVar.mo2333(field)) {
                field.setAccessible(true);
                list.add(field);
            }
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static hm.e m2325() {
        return new hm.e();
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final <T> Field m2330(Class cls, Class<T> cls2) {
        Field fieldM2329;
        synchronized (jv.class) {
            try {
                if (this.f2353 == null) {
                    this.f2353 = new hm();
                }
                this.f2353.m2313(cls2);
                fieldM2329 = m2329(cls, this.f2353);
            } catch (Throwable th) {
                throw th;
            }
        }
        return fieldM2329;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final List<Field> m2331(Class cls, hm hmVar) {
        ArrayList arrayList = new ArrayList();
        m2327(cls, hmVar, arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Field m2332(Class cls, final String str) {
        a aVar = new a(this) { // from class: com.ironsource.adqualitysdk.sdk.i.hn.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.hn.a
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final boolean mo2333(Field field) {
                return field.getType().getName().toLowerCase().startsWith(str.toLowerCase());
            }
        };
        synchronized (hn.class) {
            try {
                if (this.f2352 == null) {
                    this.f2352 = new ArrayList();
                }
                this.f2352.clear();
                m2324(cls, aVar, this.f2352);
                if (this.f2352.isEmpty()) {
                    return null;
                }
                return this.f2352.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Field[] m2326(Class cls, hm hmVar) {
        if (hmVar != null && hmVar.m2340()) {
            return m2328(cls, hmVar.m2340(), hmVar.m2342(), null);
        }
        try {
            return cls.getDeclaredFields();
        } catch (Error unused) {
            return cls.getFields();
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m2327(Class cls, hm hmVar, List<Field> list) {
        synchronized (hn.class) {
            try {
                if (this.f2354 == null) {
                    this.f2354 = new a(this);
                }
                this.f2354.m2334(hmVar);
                m2324(cls, this.f2354, list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final Field m2329(Class cls, hm hmVar) {
        synchronized (jv.class) {
            try {
                if (this.f2352 == null) {
                    this.f2352 = new ArrayList();
                }
                this.f2352.clear();
                m2327(cls, hmVar, this.f2352);
                if (this.f2352.isEmpty()) {
                    return null;
                }
                return this.f2352.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Field[] m2328(Class cls, boolean z2, int i2, List<String> list) {
        while (cls != null && !jz.m2848(cls, list)) {
            cls = cls.getSuperclass();
        }
        Field[] fieldArrM2849 = new Field[0];
        if (cls != null) {
            Field[] declaredFields = new Field[0];
            Field[] fields = new Field[0];
            try {
                declaredFields = cls.getDeclaredFields();
            } catch (Error unused) {
            }
            try {
                fields = cls.getFields();
            } catch (Error unused2) {
            }
            fieldArrM2849 = jz.m2849(declaredFields, fields);
            if (!z2) {
                return fieldArrM2849;
            }
            Class superclass = cls.getSuperclass();
            for (int i8 = 0; superclass != null && i8 != i2; i8++) {
                try {
                    fieldArrM2849 = jz.m2849(fieldArrM2849, superclass.getDeclaredFields());
                } catch (Error unused3) {
                }
                try {
                    fieldArrM2849 = jz.m2849(fieldArrM2849, superclass.getFields());
                } catch (Error unused4) {
                }
                superclass = superclass.getSuperclass();
            }
        }
        return fieldArrM2849;
    }
}

package com.apm.insight.runtime.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.runtime.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f4612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<CrashType, c> f4614c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f4615d;
    private d e;

    /* JADX INFO: renamed from: com.apm.insight.runtime.a.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4616a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f4616a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4616a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4616a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4616a[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4616a[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4616a[CrashType.CUSTOM_JAVA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4616a[CrashType.BLOCK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4616a[CrashType.ENSURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private f(@NonNull Context context) {
        this.f4613b = context;
        try {
            this.f4615d = b.d();
            this.e = new d(this.f4613b);
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
    }

    public static f a() {
        if (f4612a == null) {
            Context contextG = com.apm.insight.e.g();
            if (contextG == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            f4612a = new f(contextG);
        }
        return f4612a;
    }

    @Nullable
    private c a(CrashType crashType) {
        c jVar = this.f4614c.get(crashType);
        if (jVar != null) {
            return jVar;
        }
        switch (AnonymousClass1.f4616a[crashType.ordinal()]) {
            case 1:
                jVar = new j(this.f4613b, this.f4615d, this.e);
                break;
            case 2:
                jVar = new k(this.f4613b, this.f4615d, this.e);
                break;
            case 3:
                jVar = new l(this.f4613b, this.f4615d, this.e);
                break;
            case 4:
                jVar = new a(this.f4613b, this.f4615d, this.e);
                break;
            case 5:
                jVar = new h(this.f4613b, this.f4615d, this.e);
                break;
            case 6:
                jVar = new g(this.f4613b, this.f4615d, this.e);
                break;
            case 7:
                jVar = new e(this.f4613b, this.f4615d, this.e);
                break;
            case 8:
                jVar = new i(this.f4613b, this.f4615d, this.e);
                break;
        }
        if (jVar != null) {
            this.f4614c.put(crashType, jVar);
        }
        return jVar;
    }

    public final com.apm.insight.entity.a a(CrashType crashType, @Nullable c.a aVar) {
        c cVarA;
        if (crashType == null || (cVarA = a(crashType)) == null) {
            return null;
        }
        return cVarA.a(null, aVar, true);
    }

    public final com.apm.insight.entity.a a(CrashType crashType, com.apm.insight.entity.a aVar) {
        c cVarA;
        return (crashType == null || (cVarA = a(crashType)) == null) ? aVar : cVarA.a(aVar, null, false);
    }

    public final com.apm.insight.entity.a a(List<com.apm.insight.entity.a> list, JSONArray jSONArray) {
        if (list.isEmpty()) {
            return null;
        }
        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
        JSONArray jSONArray2 = new JSONArray();
        Iterator<com.apm.insight.entity.a> it = list.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next().c());
        }
        aVar.a("data", (Object) jSONArray2);
        aVar.a("all_data", (Object) jSONArray);
        Header headerA = Header.a(this.f4613b);
        Header.a(headerA);
        headerA.c();
        headerA.d();
        headerA.e();
        Header.b(headerA);
        aVar.a(headerA);
        return aVar;
    }
}

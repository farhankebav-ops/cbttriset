package f7;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d7.g[] f11427a = new d7.g[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b7.c[] f11428b = new b7.c[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f11429c = new Object();

    public static final h0 a(String str, b7.c cVar) {
        return new h0(str, new i0(cVar));
    }

    public static final Set b(d7.g gVar) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        if (gVar instanceof l) {
            return ((l) gVar).a();
        }
        HashSet hashSet = new HashSet(gVar.d());
        int iD = gVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            hashSet.add(gVar.e(i2));
        }
        return hashSet;
    }

    public static final d7.g[] c(List list) {
        d7.g[] gVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (gVarArr = (d7.g[]) list.toArray(new d7.g[0])) == null) ? f11427a : gVarArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c1, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0188, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final b7.c d(l6.c r16, b7.c... r17) {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f7.c1.d(l6.c, b7.c[]):b7.c");
    }

    public static final int e(d7.g gVar, d7.g[] typeParams) {
        kotlin.jvm.internal.k.e(typeParams, "typeParams");
        int iHashCode = (gVar.h().hashCode() * 31) + Arrays.hashCode(typeParams);
        int iD = gVar.d();
        int i2 = 1;
        while (true) {
            int iHashCode2 = 0;
            if (!(iD > 0)) {
                break;
            }
            int i8 = iD - 1;
            int i9 = i2 * 31;
            String strH = gVar.g(gVar.d() - iD).h();
            if (strH != null) {
                iHashCode2 = strH.hashCode();
            }
            i2 = i9 + iHashCode2;
            iD = i8;
        }
        int iD2 = gVar.d();
        int iHashCode3 = 1;
        while (true) {
            if (!(iD2 > 0)) {
                return (((iHashCode * 31) + i2) * 31) + iHashCode3;
            }
            int i10 = iD2 - 1;
            int i11 = iHashCode3 * 31;
            a.a kind = gVar.g(gVar.d() - iD2).getKind();
            iHashCode3 = i11 + (kind != null ? kind.hashCode() : 0);
            iD2 = i10;
        }
    }

    public static final b7.c f(Object obj, b7.c... cVarArr) throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (cVarArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = cVarArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr2[i2] = b7.c.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(cVarArr, cVarArr.length));
            if (objInvoke instanceof b7.c) {
                return (b7.c) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    public static final boolean g(l6.c cVar) {
        kotlin.jvm.internal.k.e(cVar, "<this>");
        return a.a.B(cVar).isInterface();
    }

    public static final l6.c h(l6.r rVar) {
        l6.c cVarC = rVar.c();
        if (cVarC instanceof l6.c) {
            return cVarC;
        }
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + cVarC);
    }

    public static final void i(l6.c cVar) {
        String strF = ((kotlin.jvm.internal.e) cVar).f();
        if (strF == null) {
            strF = "<local class name not available>";
        }
        throw new b7.i(a1.a.m("Serializer for class '", strF, "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n"));
    }

    public static final void j(d7.g descriptor, int i2, int i8) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i9 = (~i2) & i8;
        for (int i10 = 0; i10 < 32; i10++) {
            if ((i9 & 1) != 0) {
                arrayList.add(descriptor.e(i10));
            }
            i9 >>>= 1;
        }
        String serialName = descriptor.h();
        kotlin.jvm.internal.k.e(serialName, "serialName");
        throw new b7.d(arrayList, arrayList.size() == 1 ? androidx.camera.core.processing.util.a.n(new StringBuilder("Field '"), (String) arrayList.get(0), "' is required for type with serial name '", serialName, "', but it was missing") : "Fields " + arrayList + " are required for type with serial name '" + serialName + "', but they were missing", null);
    }

    public static final void k(String str, l6.c baseClass) {
        String string;
        kotlin.jvm.internal.k.e(baseClass, "baseClass");
        StringBuilder sb = new StringBuilder("in the polymorphic scope of '");
        kotlin.jvm.internal.e eVar = (kotlin.jvm.internal.e) baseClass;
        sb.append(eVar.f());
        sb.append('\'');
        String string2 = sb.toString();
        if (str == null) {
            string = androidx.camera.core.processing.util.a.f('.', "Class discriminator was missing and no default serializers were registered ", string2);
        } else {
            StringBuilder sbZ = a1.a.z("Serializer for subclass '", str, "' is not found ", string2, ".\nCheck if class with serial name '");
            androidx.camera.core.processing.util.a.A(sbZ, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbZ.append(eVar.f());
            sbZ.append("' has to be sealed and '@Serializable'.");
            string = sbZ.toString();
        }
        throw new b7.i(string);
    }
}

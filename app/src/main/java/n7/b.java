package n7;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.location.LocationRequestCompat;
import androidx.work.PeriodicWorkRequest;
import com.cbt.exam.browser.activity.BaseActivity;
import e2.s;
import e6.p;
import f7.c1;
import f7.h0;
import f7.l1;
import g7.n;
import g7.r;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.k;
import okhttp3.internal.ws.RealWebSocket;
import q5.f;
import q5.g;
import q5.l;
import q5.m;
import q5.u;
import q5.y;
import q6.c0;
import r2.q;
import r5.t;
import r5.x;
import s6.a0;
import s6.o;
import v4.c;
import v4.d;
import v5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final boolean A(char c7) {
        return Character.isWhitespace(c7) || Character.isSpaceChar(c7);
    }

    public static f B(g gVar, e6.a initializer) {
        u uVar = u.f13517a;
        k.e(initializer, "initializer");
        int iOrdinal = gVar.ordinal();
        if (iOrdinal == 0) {
            return new m(initializer);
        }
        if (iOrdinal == 1) {
            l lVar = new l();
            lVar.f13503a = initializer;
            lVar.f13504b = uVar;
            return lVar;
        }
        if (iOrdinal != 2) {
            throw new s(3);
        }
        y yVar = new y();
        yVar.f13521a = initializer;
        yVar.f13522b = uVar;
        return yVar;
    }

    public static m C(e6.a initializer) {
        k.e(initializer, "initializer");
        return new m(initializer);
    }

    public static int D(int i2) {
        RoundingMode roundingMode = RoundingMode.UNNECESSARY;
        if (i2 <= 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "x (", ") must be > 0"));
        }
        switch (h2.a.f11682a[roundingMode.ordinal()]) {
            case 1:
                if (!((i2 > 0) & (((i2 + (-1)) & i2) == 0))) {
                    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                }
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i2 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
                return (31 - iNumberOfLeadingZeros) + ((~(~(((-1257966797) >>> iNumberOfLeadingZeros) - i2))) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static Set E(Set set, Set set2) {
        if (set2.isEmpty()) {
            return r5.l.r1(set);
        }
        if (!(set2 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(set2);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!set2.contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static void F(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!(th instanceof d) && !(th instanceof c) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof v4.b)) {
            th = new s6.s(th);
        }
        th.printStackTrace();
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static LinkedHashSet G(Set set, Collection elements) {
        k.e(set, "<this>");
        k.e(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(x.d0(set.size() + Integer.valueOf(elements.size()).intValue()));
        linkedHashSet.addAll(set);
        r5.l.Q0(elements, linkedHashSet);
        return linkedHashSet;
    }

    public static final void I(a4.a aVar, String str, Boolean bool) {
        h0 h0Var = n.f11618a;
        aVar.l(str, bool == null ? g7.u.INSTANCE : new r(bool, false, null));
    }

    public static final void J(a4.a aVar, String key, String str) {
        k.e(key, "key");
        aVar.l(key, n.b(str));
    }

    public static final byte[] K(InputStream inputStream) throws IOException {
        k.e(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        k.d(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final String L(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i2 = reader.read(cArr);
        while (i2 >= 0) {
            stringWriter.write(cArr, 0, i2);
            i2 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        k.d(string, "toString(...)");
        return string;
    }

    public static final long M(long j, long j3, o6.c cVar) {
        long j8 = j - j3;
        if (((j8 ^ j) & (~(j8 ^ j3))) >= 0) {
            return q.B0(j8, cVar);
        }
        o6.c cVar2 = o6.c.f13211c;
        if (cVar.compareTo(cVar2) >= 0) {
            return o6.a.j(y(j8));
        }
        long jQ = a.a.q(1L, cVar2, cVar);
        long j9 = (j / jQ) - (j3 / jQ);
        long j10 = (j % jQ) - (j3 % jQ);
        int i2 = o6.a.f13207d;
        return o6.a.g(q.B0(j9, cVar2), q.B0(j10, cVar));
    }

    public static Set N(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        k.d(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static Set O(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return t.f13640a;
        }
        if (length == 1) {
            return N(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(x.d0(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static int P(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * (-862048943)), 15)) * 461845907);
    }

    public static final Object Q(v6.r rVar, v6.r rVar2, p pVar) throws Throwable {
        Object uVar;
        Object objO;
        try {
            if (pVar instanceof x5.a) {
                d0.d(2, pVar);
                uVar = pVar.invoke(rVar2, rVar);
            } else {
                uVar = a.a.Z(pVar, rVar2, rVar);
            }
        } catch (Throwable th) {
            uVar = new q6.u(false, th);
        }
        w5.a aVar = w5.a.f17774a;
        if (uVar == aVar || (objO = rVar.O(uVar)) == c0.e) {
            return aVar;
        }
        if (objO instanceof q6.u) {
            throw ((q6.u) objO).f13591a;
        }
        return c0.F(objO);
    }

    public static boolean R(String str) {
        return str == null || str.isEmpty();
    }

    public static final q5.q S(String str) {
        int i2;
        i(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        if (k.g(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int i9 = 119304647;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            int i10 = i8 ^ Integer.MIN_VALUE;
            if (Integer.compare(i10, i9 ^ Integer.MIN_VALUE) > 0) {
                if (i9 != 119304647) {
                    return null;
                }
                i9 = (int) ((((long) (-1)) & 4294967295L) / (4294967295L & ((long) 10)));
                if (Integer.compare(i10, i9 ^ Integer.MIN_VALUE) > 0) {
                    return null;
                }
            }
            int i11 = i8 * 10;
            int i12 = iDigit + i11;
            if (Integer.compare(i12 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            i8 = i12;
        }
        return new q5.q(i8);
    }

    public static final q5.s T(String str) {
        int i2;
        long j;
        k.e(str, "<this>");
        int i8 = 10;
        i(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        char cCharAt = str.charAt(0);
        int i9 = 1;
        if (k.g(cCharAt, 48) >= 0) {
            i2 = 0;
        } else {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i2 = 1;
        }
        long j3 = 10;
        long j8 = 0;
        long j9 = 512409557603043100L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), i8);
            if (iDigit < 0) {
                return null;
            }
            int i10 = length;
            long j10 = j8 ^ Long.MIN_VALUE;
            int i11 = i2;
            if (Long.compare(j10, j9 ^ Long.MIN_VALUE) <= 0) {
                j = j3;
            } else {
                if (j9 != 512409557603043100L) {
                    return null;
                }
                if (j3 >= 0) {
                    long j11 = (LocationRequestCompat.PASSIVE_INTERVAL / j3) << i9;
                    j = j3;
                    j9 = j11 + ((long) ((((-1) - (j11 * j3)) ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE) ? i9 : 0));
                } else if (LocationRequestCompat.PASSIVE_INTERVAL < (j3 ^ Long.MIN_VALUE)) {
                    j = j3;
                    j9 = 0;
                } else {
                    j9 = 1;
                    j = j3;
                }
                if (Long.compare(j10, j9 ^ Long.MIN_VALUE) > 0) {
                    return null;
                }
            }
            long j12 = j8 * j;
            long j13 = (((long) iDigit) & 4294967295L) + j12;
            if (Long.compare(j13 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i2 = i11 + 1;
            j8 = j13;
            length = i10;
            j3 = j;
            i8 = 10;
            i9 = 1;
        }
        return new q5.s(j8);
    }

    public static final void U(a0 a0Var, Object obj) {
        Object objD = a0Var.d(obj);
        if (!(objD instanceof s6.n)) {
        } else {
            Object obj2 = ((o) c0.A(i.f17610a, new s6.q(a0Var, obj, (v5.c) null))).f13753a;
        }
    }

    public static void V(Object obj, String str, boolean z2) {
        if (!z2) {
            throw new s(a.a.K(str, obj), 0);
        }
    }

    public static int W(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            default:
                return 0;
        }
    }

    public static File a(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static File c(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, a1.a.C(str2, ".temp"));
    }

    public static Object d(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void e(Parcel parcel, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i2);
        }
    }

    public static s5.i f(s5.i iVar) {
        s5.f fVar = iVar.f13717a;
        fVar.b();
        return fVar.f13712i > 0 ? iVar : s5.i.f13716b;
    }

    public static s4.p g(Callable callable) {
        try {
            Object objCall = callable.call();
            z4.b.a(objCall, "Scheduler Callable result can't be null");
            return (s4.p) objCall;
        } catch (Throwable th) {
            throw l5.c.c(th);
        }
    }

    public static Object h(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static void i(int i2) {
        if (2 > i2 || i2 >= 37) {
            StringBuilder sbV = a1.a.v(i2, "radix ", " was not in valid range ");
            sbV.append(new k6.d(2, 36, 1));
            throw new IllegalArgumentException(sbV.toString());
        }
    }

    public static int j(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static final void k(int i2, int i8) {
        if (i2 <= i8) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i8 + ").");
    }

    public static final long l(InputStream inputStream, OutputStream outputStream) throws IOException {
        k.e(inputStream, "<this>");
        byte[] bArr = new byte[8192];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r0 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r4 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r4 < 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m(int r4, int r5) {
        /*
            java.math.RoundingMode r0 = java.math.RoundingMode.CEILING
            r0.getClass()
            if (r5 == 0) goto L4c
            int r1 = r4 / r5
            int r2 = r5 * r1
            int r2 = r4 - r2
            if (r2 != 0) goto L10
            goto L43
        L10:
            r4 = r4 ^ r5
            int r4 = r4 >> 31
            r4 = r4 | 1
            int[] r3 = h2.a.f11682a
            int r0 = r0.ordinal()
            r0 = r3[r0]
            switch(r0) {
                case 1: goto L41;
                case 2: goto L43;
                case 3: goto L3d;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L26;
                case 7: goto L26;
                case 8: goto L26;
                default: goto L20;
            }
        L20:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L26:
            int r0 = java.lang.Math.abs(r2)
            int r5 = java.lang.Math.abs(r5)
            int r5 = r5 - r0
            int r0 = r0 - r5
            if (r0 != 0) goto L37
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_UP
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_EVEN
            goto L43
        L37:
            if (r0 <= 0) goto L43
            goto L3f
        L3a:
            if (r4 <= 0) goto L43
            goto L3f
        L3d:
            if (r4 >= 0) goto L43
        L3f:
            int r1 = r1 + r4
            return r1
        L41:
            if (r2 != 0) goto L44
        L43:
            return r1
        L44:
            java.lang.ArithmeticException r4 = new java.lang.ArithmeticException
            java.lang.String r5 = "mode was UNNECESSARY, but rounding was necessary"
            r4.<init>(r5)
            throw r4
        L4c:
            java.lang.ArithmeticException r4 = new java.lang.ArithmeticException
            java.lang.String r5 = "/ by zero"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.b.m(int, int):int");
    }

    public static final y5.b n(Enum[] entries) {
        k.e(entries, "entries");
        return new y5.b(entries);
    }

    public static final boolean o(char c7, char c8, boolean z2) {
        if (c7 == c8) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c7);
        char upperCase2 = Character.toUpperCase(c8);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final b7.b p(f7.b bVar, e7.c cVar, String str) {
        b7.c cVar2;
        k.e(bVar, "<this>");
        i7.f serializersModule = cVar.getSerializersModule();
        l6.c baseClass = ((b7.f) bVar).f4152a;
        i7.d dVar = (i7.d) serializersModule;
        dVar.getClass();
        k.e(baseClass, "baseClass");
        Map map = (Map) dVar.f12044d.get(baseClass);
        b7.c cVar3 = map != null ? (b7.c) map.get(str) : null;
        if (!(cVar3 instanceof b7.c)) {
            cVar3 = null;
        }
        if (cVar3 != null) {
            cVar2 = cVar3;
        } else {
            Object obj = dVar.e.get(baseClass);
            e6.l lVar = d0.e(1, obj) ? (e6.l) obj : null;
            cVar2 = lVar != null ? (b7.b) lVar.invoke(str) : null;
        }
        if (cVar2 != null) {
            return cVar2;
        }
        c1.k(str, baseClass);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final b7.j q(f7.b r3, e7.f r4, java.lang.Object r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.k.e(r3, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.k.e(r5, r0)
            i7.f r4 = r4.getSerializersModule()
            b7.f r3 = (b7.f) r3
            l6.c r3 = r3.f4152a
            i7.d r4 = (i7.d) r4
            r4.getClass()
            java.lang.String r0 = "baseClass"
            kotlin.jvm.internal.k.e(r3, r0)
            r0 = r3
            kotlin.jvm.internal.e r0 = (kotlin.jvm.internal.e) r0
            boolean r0 = r0.g(r5)
            r1 = 0
            if (r0 != 0) goto L27
            goto L67
        L27:
            java.util.Map r0 = r4.f12042b
            java.lang.Object r0 = r0.get(r3)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L40
            java.lang.Class r2 = r5.getClass()
            kotlin.jvm.internal.e r2 = kotlin.jvm.internal.b0.a(r2)
            java.lang.Object r0 = r0.get(r2)
            b7.c r0 = (b7.c) r0
            goto L41
        L40:
            r0 = r1
        L41:
            boolean r2 = r0 instanceof b7.j
            if (r2 == 0) goto L48
            b7.j r0 = (b7.j) r0
            goto L49
        L48:
            r0 = r1
        L49:
            if (r0 == 0) goto L4c
            goto L68
        L4c:
            java.util.Map r4 = r4.f12043c
            java.lang.Object r4 = r4.get(r3)
            r0 = 1
            boolean r0 = kotlin.jvm.internal.d0.e(r0, r4)
            if (r0 == 0) goto L5c
            e6.l r4 = (e6.l) r4
            goto L5d
        L5c:
            r4 = r1
        L5d:
            if (r4 == 0) goto L67
            java.lang.Object r4 = r4.invoke(r5)
            r0 = r4
            b7.j r0 = (b7.j) r0
            goto L68
        L67:
            r0 = r1
        L68:
            if (r0 != 0) goto L80
            java.lang.Class r4 = r5.getClass()
            kotlin.jvm.internal.e r4 = kotlin.jvm.internal.b0.a(r4)
            java.lang.String r5 = r4.f()
            if (r5 != 0) goto L7c
            java.lang.String r5 = java.lang.String.valueOf(r4)
        L7c:
            f7.c1.k(r5, r3)
            throw r1
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.b.q(f7.b, e7.f, java.lang.Object):b7.j");
    }

    public static final void r(BufferedReader bufferedReader, e6.l lVar) throws IOException {
        try {
            Iterator it = new m6.a(new c6.m(bufferedReader, 0)).iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            bufferedReader.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                q.I(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static final l6.c s(d7.g gVar) {
        k.e(gVar, "<this>");
        if (gVar instanceof d7.b) {
            return ((d7.b) gVar).f11179b;
        }
        if (gVar instanceof l1) {
            return s(((l1) gVar).f11480a);
        }
        return null;
    }

    public static Object u(j2.q qVar) {
        Object obj;
        q.G(qVar, "Future was expected to be done: %s", qVar.isDone());
        boolean z2 = false;
        while (true) {
            try {
                obj = qVar.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static String v(BaseActivity baseActivity) {
        long j = baseActivity.getSharedPreferences("penalty_prefs", 0).getLong("penalty_time", 0L);
        return j == 0 ? "Tidak ada pelanggaran aktif." : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
    }

    public static String w(BaseActivity baseActivity) {
        long j = baseActivity.getSharedPreferences("penalty_prefs", 0).getLong("penalty_time", 0L);
        if (j == 0) {
            return "Tidak ada pelanggaran aktif.";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j + 21600000));
    }

    public static void x(BaseActivity baseActivity) {
        SharedPreferences sharedPreferences = baseActivity.getSharedPreferences("penalty_prefs", 0);
        int i2 = sharedPreferences.getInt("violation_count", 0) + 1;
        long jCurrentTimeMillis = System.currentTimeMillis() + (i2 == 1 ? RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS : i2 == 2 ? PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS : (((r1 - 1) * 5) + 5) * 60000);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("violation_count", i2);
        editorEdit.putLong("penalty_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public static final long y(long j) {
        if (j < 0) {
            int i2 = o6.a.f13207d;
            return o6.a.f13206c;
        }
        int i8 = o6.a.f13207d;
        return o6.a.f13205b;
    }

    public static l6.t z(f0 f0Var) {
        return new l6.t(l6.u.f12831a, f0Var);
    }

    public abstract void H(String str);

    public abstract void t(w1.y yVar, float f4, float f8);
}

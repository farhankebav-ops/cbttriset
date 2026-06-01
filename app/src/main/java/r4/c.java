package r4;

import android.content.Context;
import j4.b5;
import j4.f1;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.k;
import l7.g0;
import l7.m;
import m7.i;
import n6.t;
import r5.j;
import x4.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements t.b, b5, y0.a, x4.a, x4.c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13626a;

    public /* synthetic */ c(int i2) {
        this.f13626a = i2;
    }

    public static final boolean b(g0 g0Var) {
        g0 g0Var2 = i.f13016d;
        return !t.f0(g0Var.b(), ".class", true);
    }

    public static m c(String str) {
        int i2;
        char cCharAt;
        k.e(str, "<this>");
        byte[] bArr = l7.a.f12834a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i8 = (int) ((((long) length) * 6) / 8);
        byte[] bArrCopyOf = new byte[i8];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i9 < length) {
                char cCharAt2 = str.charAt(i9);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i2 = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i2 = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i2 = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i9++;
                    } else {
                        i2 = 63;
                    }
                } else {
                    i2 = 62;
                }
                i11 = (i11 << 6) | i2;
                i10++;
                if (i10 % 4 == 0) {
                    bArrCopyOf[i12] = (byte) (i11 >> 16);
                    int i13 = i12 + 2;
                    bArrCopyOf[i12 + 1] = (byte) (i11 >> 8);
                    i12 += 3;
                    bArrCopyOf[i13] = (byte) i11;
                }
                i9++;
            } else {
                int i14 = i10 % 4;
                if (i14 != 1) {
                    if (i14 == 2) {
                        bArrCopyOf[i12] = (byte) ((i11 << 12) >> 16);
                        i12++;
                    } else if (i14 == 3) {
                        int i15 = i11 << 6;
                        int i16 = i12 + 1;
                        bArrCopyOf[i12] = (byte) (i15 >> 16);
                        i12 += 2;
                        bArrCopyOf[i16] = (byte) (i15 >> 8);
                    }
                    if (i12 != i8) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i12);
                        k.d(bArrCopyOf, "copyOf(...)");
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new m(bArrCopyOf);
        }
        return null;
    }

    public static m d(String str) {
        k.e(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i8 = i2 * 2;
            bArr[i2] = (byte) (m7.b.a(str.charAt(i8 + 1)) + (m7.b.a(str.charAt(i8)) << 4));
        }
        return new m(bArr);
    }

    public static m e(String str) {
        k.e(str, "<this>");
        byte[] bytes = str.getBytes(n6.a.f13073a);
        k.d(bytes, "getBytes(...)");
        m mVar = new m(bytes);
        mVar.f12883c = str;
        return mVar;
    }

    public static m f(byte... data) {
        k.e(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        k.d(bArrCopyOf, "copyOf(...)");
        return new m(bArrCopyOf);
    }

    public static m g(byte[] bArr) {
        m mVar = m.f12880d;
        int length = bArr.length;
        l7.b.e(bArr.length, 0, length);
        return new m(j.i0(bArr, 0, length));
    }

    public static g0 h(g0 g0Var, g0 base) {
        k.e(g0Var, "<this>");
        k.e(base, "base");
        return i.f13016d.e(t.k0(n6.m.F0(g0Var.f12851a.t(), base.f12851a.t()), '\\', '/'));
    }

    public void a(Context context, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, t.a aVar2) {
        ConcurrentHashMap concurrentHashMap = c0.a.f4160a;
        synchronized (c0.a.class) {
            if (aVar != null) {
                try {
                    ConcurrentHashMap concurrentHashMap2 = c0.a.f4160a;
                    c0.c cVar = (c0.c) concurrentHashMap2.get(aVar.cl());
                    if (cVar == null) {
                        cVar = new c0.c(context, aVar);
                        concurrentHashMap2.put(aVar.cl(), cVar);
                        aVar.vCE();
                        aVar.cl();
                    }
                    cVar.d(aVar2);
                    aVar.vCE();
                    aVar.cl();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        u.b bVar = z5.b.f17986a;
        if (bVar != null) {
            ((b0.b) bVar).e();
        }
    }

    @Override // j4.b5
    public void close(Object obj) {
        ((ExecutorService) ((Executor) obj)).shutdown();
    }

    @Override // j4.b5
    public Object create() {
        return Executors.newCachedThreadPool(f1.e("grpc-okhttp-%d"));
    }

    @Override // y0.a
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Override // x4.d
    public boolean test(Object obj) {
        return true;
    }

    public String toString() {
        switch (this.f13626a) {
            case 7:
                return "EmptyAction";
            case 8:
                return "IdentityFunction";
            default:
                return super.toString();
        }
    }

    @Override // x4.a
    public void run() {
    }

    @Override // x4.c
    public Object apply(Object obj) {
        return obj;
    }
}

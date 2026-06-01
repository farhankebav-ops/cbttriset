package l7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12839a = new h();

    public static final boolean a(int i2, int i8, int i9, byte[] a8, byte[] b8) {
        kotlin.jvm.internal.k.e(a8, "a");
        kotlin.jvm.internal.k.e(b8, "b");
        for (int i10 = 0; i10 < i9; i10++) {
            if (a8[i10 + i2] != b8[i10 + i8]) {
                return false;
            }
        }
        return true;
    }

    public static final i0 b(n0 n0Var) {
        kotlin.jvm.internal.k.e(n0Var, "<this>");
        return new i0(n0Var);
    }

    public static final j0 c(o0 o0Var) {
        kotlin.jvm.internal.k.e(o0Var, "<this>");
        return new j0(o0Var);
    }

    public static void d(long j, j jVar, int i2, ArrayList arrayList, int i8, int i9, ArrayList arrayList2) {
        int i10;
        int i11;
        ArrayList arrayList3;
        long j3;
        int i12;
        int i13 = i2;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i8 >= i9) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i14 = i8; i14 < i9; i14++) {
            if (((m) arrayList4.get(i14)).d() < i13) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        m mVar = (m) arrayList.get(i8);
        m mVar2 = (m) arrayList4.get(i9 - 1);
        if (i13 == mVar.d()) {
            int iIntValue = ((Number) arrayList5.get(i8)).intValue();
            int i15 = i8 + 1;
            m mVar3 = (m) arrayList4.get(i15);
            i10 = i15;
            i11 = iIntValue;
            mVar = mVar3;
        } else {
            i10 = i8;
            i11 = -1;
        }
        if (mVar.i(i13) == mVar2.i(i13)) {
            int iMin = Math.min(mVar.d(), mVar2.d());
            int i16 = 0;
            for (int i17 = i13; i17 < iMin && mVar.i(i17) == mVar2.i(i17); i17++) {
                i16++;
            }
            long j8 = 4;
            long j9 = (jVar.f12868b / j8) + j + ((long) 2) + ((long) i16) + 1;
            jVar.X(-i16);
            jVar.X(i11);
            int i18 = i13 + i16;
            while (i13 < i18) {
                jVar.X(mVar.i(i13) & 255);
                i13++;
            }
            if (i10 + 1 == i9) {
                if (i18 != ((m) arrayList4.get(i10)).d()) {
                    throw new IllegalStateException("Check failed.");
                }
                jVar.X(((Number) arrayList5.get(i10)).intValue());
                return;
            } else {
                j jVar2 = new j();
                jVar.X(((int) ((jVar2.f12868b / j8) + j9)) * (-1));
                d(j9, jVar2, i18, arrayList4, i10, i9, arrayList5);
                jVar.H(jVar2);
                return;
            }
        }
        int i19 = 1;
        for (int i20 = i10 + 1; i20 < i9; i20++) {
            if (((m) arrayList4.get(i20 - 1)).i(i13) != ((m) arrayList4.get(i20)).i(i13)) {
                i19++;
            }
        }
        long j10 = 4;
        long j11 = (jVar.f12868b / j10) + j + ((long) 2) + ((long) (i19 * 2));
        jVar.X(i19);
        jVar.X(i11);
        for (int i21 = i10; i21 < i9; i21++) {
            int i22 = ((m) arrayList4.get(i21)).i(i13);
            if (i21 == i10 || i22 != ((m) arrayList4.get(i21 - 1)).i(i13)) {
                jVar.X(i22 & 255);
            }
        }
        j jVar3 = new j();
        int i23 = i10;
        while (i23 < i9) {
            byte bI = ((m) arrayList4.get(i23)).i(i13);
            int i24 = i23 + 1;
            int i25 = i24;
            while (true) {
                if (i25 >= i9) {
                    i25 = i9;
                    break;
                } else if (bI != ((m) arrayList4.get(i25)).i(i13)) {
                    break;
                } else {
                    i25++;
                }
            }
            if (i24 == i25 && i13 + 1 == ((m) arrayList4.get(i23)).d()) {
                jVar.X(((Number) arrayList5.get(i23)).intValue());
                arrayList3 = arrayList5;
                j3 = j11;
                i12 = i25;
            } else {
                jVar.X(((int) ((jVar3.f12868b / j10) + j11)) * (-1));
                arrayList3 = arrayList5;
                j3 = j11;
                i12 = i25;
                d(j3, jVar3, i13 + 1, arrayList, i23, i12, arrayList3);
                arrayList4 = arrayList;
            }
            j11 = j3;
            i23 = i12;
            arrayList5 = arrayList3;
        }
        jVar.H(jVar3);
    }

    public static final void e(long j, long j3, long j8) {
        if ((j3 | j8) < 0 || j3 > j || j - j3 < j8) {
            StringBuilder sbT = androidx.camera.core.processing.util.a.t("size=", j, " offset=");
            sbT.append(j3);
            sbT.append(" byteCount=");
            sbT.append(j8);
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0111, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static l7.f0 f(l7.m... r12) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.b.f(l7.m[]):l7.f0");
    }

    public static final int g(int i2) {
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final d h(OutputStream outputStream) {
        return new d(1, outputStream, new r0());
    }

    public static final n0 i(Socket socket) throws IOException {
        kotlin.jvm.internal.k.e(socket, "<this>");
        m7.j jVar = new m7.j(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.k.d(outputStream, "getOutputStream(...)");
        return jVar.sink(new d(1, outputStream, jVar));
    }

    public static final e j(InputStream inputStream) {
        return new e(inputStream, new r0());
    }

    public static final o0 k(Socket socket) throws IOException {
        kotlin.jvm.internal.k.e(socket, "<this>");
        m7.j jVar = new m7.j(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.k.d(inputStream, "getInputStream(...)");
        return jVar.source(new e(inputStream, jVar));
    }

    public static final String l(byte b8) {
        char[] cArr = m7.b.f12998a;
        return new String(new char[]{cArr[(b8 >> 4) & 15], cArr[b8 & 15]});
    }

    public static final String m(int i2) {
        if (i2 == 0) {
            return "0";
        }
        char[] cArr = m7.b.f12998a;
        int i8 = 0;
        char[] cArr2 = {cArr[(i2 >> 28) & 15], cArr[(i2 >> 24) & 15], cArr[(i2 >> 20) & 15], cArr[(i2 >> 16) & 15], cArr[(i2 >> 12) & 15], cArr[(i2 >> 8) & 15], cArr[(i2 >> 4) & 15], cArr[i2 & 15]};
        while (i8 < 8 && cArr2[i8] == '0') {
            i8++;
        }
        r5.e.Companion.getClass();
        r5.b.a(i8, 8, 8);
        return new String(cArr2, i8, 8 - i8);
    }
}

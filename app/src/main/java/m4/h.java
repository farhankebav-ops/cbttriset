package m4;

import i4.a1;
import i4.m1;
import i4.n1;
import j4.e1;
import j4.k1;
import j4.x;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import k4.m;
import k4.n;
import l7.j0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f12957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f12958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f12959c;

    public h(j0 j0Var) {
        this.f12957a = j0Var;
        f fVar = new f(j0Var);
        this.f12958b = fVar;
        this.f12959c = new c(fVar);
    }

    public final boolean a(m mVar) throws IOException {
        a aVar;
        n1 n1VarH;
        boolean z2 = false;
        try {
            this.f12957a.F(9L);
            int iA = j.a(this.f12957a);
            if (iA < 0 || iA > 16384) {
                j.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
                throw null;
            }
            byte b8 = (byte) (this.f12957a.readByte() & 255);
            byte b9 = (byte) (this.f12957a.readByte() & 255);
            int i2 = this.f12957a.readInt() & Integer.MAX_VALUE;
            Logger logger = j.f12964a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(g.a(true, i2, iA, b8, b9));
            }
            switch (b8) {
                case 0:
                    b(mVar, iA, b9, i2);
                    return true;
                case 1:
                    g(mVar, iA, b9, i2);
                    return true;
                case 2:
                    if (iA != 5) {
                        j.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i2 == 0) {
                        j.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        throw null;
                    }
                    j0 j0Var = this.f12957a;
                    j0Var.readInt();
                    j0Var.readByte();
                    return true;
                case 3:
                    k(mVar, iA, i2);
                    return true;
                case 4:
                    l(mVar, iA, b9, i2);
                    return true;
                case 5:
                    j(mVar, iA, b9, i2);
                    return true;
                case 6:
                    i(mVar, iA, b9, i2);
                    return true;
                case 7:
                    j0 j0Var2 = this.f12957a;
                    if (iA < 8) {
                        j.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i2 != 0) {
                        j.c("TYPE_GOAWAY streamId != 0", new Object[0]);
                        throw null;
                    }
                    int i8 = j0Var2.readInt();
                    int i9 = j0Var2.readInt();
                    int i10 = iA - 8;
                    a[] aVarArrValues = a.values();
                    int length = aVarArrValues.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length) {
                            aVar = aVarArrValues[i11];
                            if (aVar.f12931a != i9) {
                                i11++;
                            }
                        } else {
                            aVar = null;
                        }
                    }
                    if (aVar == null) {
                        j.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i9));
                        throw null;
                    }
                    l7.m mVarJ = l7.m.f12880d;
                    if (i10 > 0) {
                        mVarJ = j0Var2.J(i10);
                    }
                    n nVar = mVar.f12658d;
                    mVar.f12655a.l(1, i8, aVar, mVarJ);
                    if (aVar == a.ENHANCE_YOUR_CALM) {
                        String strT = mVarJ.t();
                        n.Q.log(Level.WARNING, mVar + ": Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: " + strT);
                        if ("too_many_pings".equals(strT)) {
                            nVar.J.run();
                        }
                    }
                    long j = aVar.f12931a;
                    e1[] e1VarArr = e1.f12171d;
                    e1 e1Var = (j >= ((long) e1VarArr.length) || j < 0) ? null : e1VarArr[(int) j];
                    if (e1Var == null) {
                        n1VarH = n1.d(e1.f12170c.f12173b.f11918a.f11909a).h("Unrecognized HTTP/2 error code: " + j);
                    } else {
                        n1VarH = e1Var.f12173b;
                    }
                    n1 n1VarB = n1VarH.b("Received Goaway");
                    if (mVarJ.d() > 0) {
                        n1VarB = n1VarB.b(mVarJ.t());
                    }
                    Map map = n.P;
                    nVar.t(i8, null, n1VarB);
                    return true;
                case 8:
                    if (iA != 4) {
                        j.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iA));
                        throw null;
                    }
                    long j3 = ((long) this.f12957a.readInt()) & 2147483647L;
                    if (j3 == 0) {
                        j.c("windowSizeIncrement was 0", new Object[0]);
                        throw null;
                    }
                    mVar.f12655a.p(1, i2, j3);
                    if (j3 == 0) {
                        if (i2 == 0) {
                            n.e(mVar.f12658d, "Received 0 flow control window increment.");
                            return true;
                        }
                        mVar.f12658d.h(i2, n1.l.h("Received 0 flow control window increment."), x.f12538a, false, a.PROTOCOL_ERROR, null);
                        return true;
                    }
                    synchronized (mVar.f12658d.k) {
                        try {
                            if (i2 == 0) {
                                mVar.f12658d.j.b(null, (int) j3);
                                return true;
                            }
                            k4.k kVar = (k4.k) mVar.f12658d.f12665n.get(Integer.valueOf(i2));
                            if (kVar != null) {
                                mVar.f12658d.j.b(kVar.f12652n.o(), (int) j3);
                            } else if (!mVar.f12658d.m(i2)) {
                                z2 = true;
                            }
                            if (z2) {
                                n.e(mVar.f12658d, "Received window_update for unknown stream: " + i2);
                            }
                            return true;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                default:
                    this.f12957a.skip(iA);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public final void b(m mVar, int i2, byte b8, int i8) throws IOException {
        boolean z2 = (b8 & 1) != 0;
        if ((b8 & 32) != 0) {
            j.c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short s7 = (b8 & 8) != 0 ? (short) (this.f12957a.readByte() & 255) : (short) 0;
        int iB = j.b(i2, b8, s7);
        j0 j0Var = this.f12957a;
        mVar.f12655a.k(1, i8, j0Var.f12870b, iB, z2);
        k4.k kVarL = mVar.f12658d.l(i8);
        if (kVarL != null) {
            long j = iB;
            j0Var.F(j);
            l7.j jVar = new l7.j();
            jVar.write(j0Var.f12870b, j);
            r4.c cVar = kVarL.f12652n.I;
            r4.b.f13625a.getClass();
            synchronized (mVar.f12658d.k) {
                kVarL.f12652n.p(i2 - iB, z2, jVar);
            }
        } else {
            if (!mVar.f12658d.m(i8)) {
                n.e(mVar.f12658d, "Received data for unknown stream: " + i8);
                this.f12957a.skip(s7);
            }
            synchronized (mVar.f12658d.k) {
                mVar.f12658d.f12664i.g(i8, a.STREAM_CLOSED);
            }
            j0Var.skip(iB);
        }
        n nVar = mVar.f12658d;
        int i9 = nVar.f12669s + i2;
        nVar.f12669s = i9;
        if (i9 >= nVar.f12663f * 0.5f) {
            synchronized (nVar.k) {
                mVar.f12658d.f12664i.j(0, r11.f12669s);
            }
            mVar.f12658d.f12669s = 0;
        }
        this.f12957a.skip(s7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12957a.close();
    }

    public final ArrayList e(int i2, short s7, byte b8, int i8) throws IOException {
        f fVar = this.f12958b;
        fVar.e = i2;
        fVar.f12950b = i2;
        fVar.f12953f = s7;
        fVar.f12951c = b8;
        fVar.f12952d = i8;
        c cVar = this.f12959c;
        j0 j0Var = cVar.f12938b;
        ArrayList arrayList = cVar.f12937a;
        while (!j0Var.M()) {
            byte b9 = j0Var.readByte();
            int i9 = b9 & 255;
            if (i9 == 128) {
                throw new IOException("index == 0");
            }
            if ((b9 & 128) == 128) {
                int iE = cVar.e(i9, 127);
                int i10 = iE - 1;
                if (i10 >= 0) {
                    b[] bVarArr = e.f12947b;
                    if (i10 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i10]);
                    }
                }
                int length = cVar.f12941f + 1 + (i10 - e.f12947b.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.e;
                    if (length <= bVarArr2.length - 1) {
                        arrayList.add(bVarArr2[length]);
                    }
                }
                throw new IOException(a1.a.g(iE, "Header index too large "));
            }
            if (i9 == 64) {
                l7.m mVarD = cVar.d();
                e.a(mVarD);
                cVar.c(new b(mVarD, cVar.d()));
            } else if ((b9 & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i9, 63) - 1), cVar.d()));
            } else if ((b9 & 32) == 32) {
                int iE2 = cVar.e(i9, 31);
                cVar.f12940d = iE2;
                if (iE2 < 0 || iE2 > cVar.f12939c) {
                    throw new IOException("Invalid dynamic table size update " + cVar.f12940d);
                }
                int i11 = cVar.h;
                if (iE2 < i11) {
                    if (iE2 == 0) {
                        Arrays.fill(cVar.e, (Object) null);
                        cVar.f12941f = cVar.e.length - 1;
                        cVar.g = 0;
                        cVar.h = 0;
                    } else {
                        cVar.a(i11 - iE2);
                    }
                }
            } else if (i9 == 16 || i9 == 0) {
                l7.m mVarD2 = cVar.d();
                e.a(mVarD2);
                arrayList.add(new b(mVarD2, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i9, 15) - 1), cVar.d()));
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList.clear();
        return arrayList2;
    }

    public final void g(m mVar, int i2, byte b8, int i8) throws IOException {
        n1 n1VarH = null;
        boolean z2 = false;
        if (i8 == 0) {
            j.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z7 = (b8 & 1) != 0;
        short s7 = (b8 & 8) != 0 ? (short) (this.f12957a.readByte() & 255) : (short) 0;
        if ((b8 & 32) != 0) {
            j0 j0Var = this.f12957a;
            j0Var.readInt();
            j0Var.readByte();
            i2 -= 5;
        }
        ArrayList arrayListE = e(j.b(i2, b8, s7), s7, b8, i8);
        android.support.v4.media.g gVar = mVar.f12655a;
        if (gVar.j()) {
            ((Logger) gVar.f3263b).log((Level) gVar.f3264c, "INBOUND HEADERS: streamId=" + i8 + " headers=" + arrayListE + " endStream=" + z7);
        }
        if (mVar.f12658d.K != Integer.MAX_VALUE) {
            long jD = 0;
            for (int i9 = 0; i9 < arrayListE.size(); i9++) {
                b bVar = (b) arrayListE.get(i9);
                jD += (long) (bVar.f12935b.d() + bVar.f12934a.d() + 32);
            }
            int iMin = (int) Math.min(jD, 2147483647L);
            int i10 = mVar.f12658d.K;
            if (iMin > i10) {
                n1 n1Var = n1.j;
                Locale locale = Locale.US;
                StringBuilder sbS = androidx.camera.core.processing.util.a.s("Response ", i10, z7 ? "trailer" : "header", " metadata larger than ", ": ");
                sbS.append(iMin);
                n1VarH = n1Var.h(sbS.toString());
            }
        }
        synchronized (mVar.f12658d.k) {
            try {
                k4.k kVar = (k4.k) mVar.f12658d.f12665n.get(Integer.valueOf(i8));
                if (kVar == null) {
                    if (mVar.f12658d.m(i8)) {
                        mVar.f12658d.f12664i.g(i8, a.STREAM_CLOSED);
                    } else {
                        z2 = true;
                    }
                } else if (n1VarH == null) {
                    r4.c cVar = kVar.f12652n.I;
                    r4.b.f13625a.getClass();
                    kVar.f12652n.q(arrayListE, z7);
                } else {
                    if (!z7) {
                        mVar.f12658d.f12664i.g(i8, a.CANCEL);
                    }
                    kVar.f12652n.g(n1VarH, x.f12538a, false, new a1());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            n.e(mVar.f12658d, "Received header for unknown stream: " + i8);
        }
    }

    public final void i(m mVar, int i2, byte b8, int i8) throws IOException {
        k1 k1Var = null;
        if (i2 != 8) {
            j.c("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        }
        if (i8 != 0) {
            j.c("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        int i9 = this.f12957a.readInt();
        int i10 = this.f12957a.readInt();
        boolean z2 = (b8 & 1) != 0;
        long j = (((long) i9) << 32) | (((long) i10) & 4294967295L);
        mVar.f12655a.m(1, j);
        if (!z2) {
            synchronized (mVar.f12658d.k) {
                mVar.f12658d.f12664i.e(true, i9, i10);
            }
            return;
        }
        synchronized (mVar.f12658d.k) {
            try {
                n nVar = mVar.f12658d;
                k1 k1Var2 = nVar.f12674x;
                if (k1Var2 != null) {
                    long j3 = k1Var2.f12279a;
                    if (j3 == j) {
                        nVar.f12674x = null;
                        k1Var = k1Var2;
                    } else {
                        Logger logger = n.Q;
                        Level level = Level.WARNING;
                        Locale locale = Locale.US;
                        logger.log(level, "Received unexpected ping ack. Expecting " + j3 + ", got " + j);
                    }
                } else {
                    n.Q.warning("Received unexpected ping ack. No ping outstanding");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (k1Var != null) {
            k1Var.b();
        }
    }

    public final void j(m mVar, int i2, byte b8, int i8) throws IOException {
        if (i8 == 0) {
            j.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short s7 = (b8 & 8) != 0 ? (short) (this.f12957a.readByte() & 255) : (short) 0;
        int i9 = this.f12957a.readInt() & Integer.MAX_VALUE;
        ArrayList arrayListE = e(j.b(i2 - 4, b8, s7), s7, b8, i8);
        android.support.v4.media.g gVar = mVar.f12655a;
        if (gVar.j()) {
            ((Logger) gVar.f3263b).log((Level) gVar.f3264c, "INBOUND PUSH_PROMISE: streamId=" + i8 + " promisedStreamId=" + i9 + " headers=" + arrayListE);
        }
        synchronized (mVar.f12658d.k) {
            mVar.f12658d.f12664i.g(i8, a.PROTOCOL_ERROR);
        }
    }

    public final void k(m mVar, int i2, int i8) throws IOException {
        a aVar;
        if (i2 != 4) {
            j.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        }
        if (i8 == 0) {
            j.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int i9 = this.f12957a.readInt();
        a[] aVarArrValues = a.values();
        int length = aVarArrValues.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                aVar = null;
                break;
            }
            aVar = aVarArrValues[i10];
            if (aVar.f12931a == i9) {
                break;
            } else {
                i10++;
            }
        }
        if (aVar == null) {
            j.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i9));
            throw null;
        }
        mVar.f12655a.n(1, i8, aVar);
        n1 n1VarB = n.x(aVar).b("Rst Stream");
        m1 m1Var = n1VarB.f11918a;
        boolean z2 = m1Var == m1.CANCELLED || m1Var == m1.DEADLINE_EXCEEDED;
        synchronized (mVar.f12658d.k) {
            try {
                k4.k kVar = (k4.k) mVar.f12658d.f12665n.get(Integer.valueOf(i8));
                if (kVar != null) {
                    r4.c cVar = kVar.f12652n.I;
                    r4.b.f13625a.getClass();
                    mVar.f12658d.h(i8, n1VarB, aVar == a.REFUSED_STREAM ? x.f12539b : x.f12538a, z2, null, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        m4.j.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", java.lang.Integer.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(k4.m r10, int r11, byte r12, int r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.h.l(k4.m, int, byte, int):void");
    }
}

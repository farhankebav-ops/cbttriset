package m7;

import e6.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.z;
import l7.g0;
import l7.j0;
import l7.m0;
import n6.t;
import okhttp3.internal.ws.WebSocketProtocol;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f12998a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f12999b = new byte[0];

    public static final int a(char c7) {
        if ('0' <= c7 && c7 < ':') {
            return c7 - '0';
        }
        if ('a' <= c7 && c7 < 'g') {
            return c7 - 'W';
        }
        if ('A' <= c7 && c7 < 'G') {
            return c7 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c7);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        String str = g0.f12850b;
        g0 g0VarD = w1.f.d("/", false);
        LinkedHashMap linkedHashMapG0 = x.g0(new q5.i(g0VarD, new k(g0VarD, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532)));
        for (k kVar : r5.l.j1(arrayList, new b0.a(1))) {
            if (((k) linkedHashMapG0.put(kVar.f13021a, kVar)) == null) {
                while (true) {
                    g0 g0Var = kVar.f13021a;
                    g0 g0VarC = g0Var.c();
                    if (g0VarC != null) {
                        k kVar2 = (k) linkedHashMapG0.get(g0VarC);
                        if (kVar2 != null) {
                            kVar2.f13029q.add(g0Var);
                            break;
                        }
                        k kVar3 = new k(g0VarC, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                        linkedHashMapG0.put(g0VarC, kVar3);
                        kVar3.f13029q.add(g0Var);
                        kVar = kVar3;
                    }
                }
            }
        }
        return linkedHashMapG0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
    
        if (r0 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
    
        if (r15 != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00df, code lost:
    
        r6.addLast(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
    
        r3 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e6, code lost:
    
        r3 = r1;
        r1 = r2;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0141, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0142, code lost:
    
        r10 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0163 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(m6.j r25, l7.t r26, r5.i r27, l7.g0 r28, boolean r29, boolean r30, x5.a r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.b.c(m6.j, l7.t, r5.i, l7.g0, boolean, boolean, x5.a):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long d(l7.j0 r18, l7.m r19, int r20, long r21) {
        /*
            r0 = r18
            r2 = r19
            l7.j r1 = r0.f12870b
            java.lang.String r3 = "bytes"
            kotlin.jvm.internal.k.e(r2, r3)
            int r3 = r2.d()
            long r4 = (long) r3
            r3 = 0
            long r6 = (long) r3
            r3 = r20
            long r8 = (long) r3
            l7.b.e(r4, r6, r8)
            boolean r4 = r0.f12871c
            if (r4 != 0) goto L80
            r4 = 0
            r7 = r3
        L1f:
            r3 = r4
            r5 = r21
            long r10 = m7.a.a(r1, r2, r3, r5, r7)
            r4 = r3
            r6 = -1
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 == 0) goto L2e
            return r10
        L2e:
            long r10 = r1.f12868b
            long r12 = r10 - r8
            r14 = 1
            long r12 = r12 + r14
            int r3 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r3 < 0) goto L3c
        L39:
            r16 = r6
            goto L7f
        L3c:
            int r3 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r3 >= 0) goto L43
            r16 = r6
            goto L64
        L43:
            long r10 = r10 - r21
            long r10 = r10 + r14
            long r10 = java.lang.Math.max(r14, r10)
            int r3 = (int) r10
            long r10 = r1.f12868b
            long r10 = r10 - r4
            long r10 = r10 + r14
            long r10 = java.lang.Math.min(r8, r10)
            int r10 = (int) r10
            int r10 = r10 + (-1)
            if (r3 > r10) goto L39
        L58:
            long r14 = r1.f12868b
            r16 = r6
            long r6 = (long) r10
            long r14 = r14 - r6
            boolean r6 = r1.l(r10, r2, r14)
            if (r6 == 0) goto L78
        L64:
            l7.o0 r3 = r0.f12869a
            r6 = 8192(0x2000, double:4.0474E-320)
            long r6 = r3.read(r1, r6)
            int r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r3 != 0) goto L71
            goto L7f
        L71:
            long r4 = java.lang.Math.max(r4, r12)
            r7 = r20
            goto L1f
        L78:
            if (r10 == r3) goto L7f
            int r10 = r10 + (-1)
            r6 = r16
            goto L58
        L7f:
            return r16
        L80:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "closed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.b.d(l7.j0, l7.m, int, long):long");
    }

    public static final String e(int i2) {
        n7.b.i(16);
        String string = Integer.toString(i2, 16);
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return "0x".concat(string);
    }

    public static final k f(final j0 j0Var) throws IOException {
        int iB = j0Var.b();
        if (iB != 33639248) {
            throw new IOException("bad zip: expected " + e(33639248) + " but was " + e(iB));
        }
        j0Var.skip(4L);
        short sG = j0Var.g();
        int i2 = sG & 65535;
        if ((sG & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + e(i2));
        }
        int iG = j0Var.g() & 65535;
        int iG2 = j0Var.g() & 65535;
        int iG3 = j0Var.g() & 65535;
        long jB = ((long) j0Var.b()) & 4294967295L;
        final z zVar = new z();
        zVar.f12731a = ((long) j0Var.b()) & 4294967295L;
        final z zVar2 = new z();
        zVar2.f12731a = ((long) j0Var.b()) & 4294967295L;
        int iG4 = j0Var.g() & 65535;
        int iG5 = j0Var.g() & 65535;
        int iG6 = 65535 & j0Var.g();
        j0Var.skip(8L);
        final z zVar3 = new z();
        zVar3.f12731a = ((long) j0Var.b()) & 4294967295L;
        String strI = j0Var.i(iG4);
        if (n6.m.r0(strI, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        final long j = zVar2.f12731a == 4294967295L ? 8 : 0L;
        if (zVar.f12731a == 4294967295L) {
            j += (long) 8;
        }
        if (zVar3.f12731a == 4294967295L) {
            j += (long) 8;
        }
        final a0 a0Var = new a0();
        final a0 a0Var2 = new a0();
        final a0 a0Var3 = new a0();
        final w wVar = new w();
        g(j0Var, iG5, new p() { // from class: m7.m
            @Override // e6.p
            public final Object invoke(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                j0 j0Var2 = j0Var;
                if (iIntValue == 1) {
                    w wVar2 = wVar;
                    if (wVar2.f12728a) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    wVar2.f12728a = true;
                    if (jLongValue < j) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    z zVar4 = zVar2;
                    long jE = zVar4.f12731a;
                    if (jE == 4294967295L) {
                        jE = j0Var2.e();
                    }
                    zVar4.f12731a = jE;
                    z zVar5 = zVar;
                    zVar5.f12731a = zVar5.f12731a == 4294967295L ? j0Var2.e() : 0L;
                    z zVar6 = zVar3;
                    zVar6.f12731a = zVar6.f12731a == 4294967295L ? j0Var2.e() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        throw new IOException("bad zip: NTFS extra too short");
                    }
                    j0Var2.skip(4L);
                    b.g(j0Var2, (int) (jLongValue - 4), new l(a0Var, j0Var2, a0Var2, a0Var3));
                }
                return q5.x.f13520a;
            }
        });
        if (j > 0 && !wVar.f12728a) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String strI2 = j0Var.i(iG6);
        String str = g0.f12850b;
        return new k(w1.f.d("/", false).e(strI), t.f0(strI, "/", false), strI2, jB, zVar.f12731a, zVar2.f12731a, iG, zVar3.f12731a, iG3, iG2, (Long) a0Var.f12717a, (Long) a0Var2.f12717a, (Long) a0Var3.f12717a, 57344);
    }

    public static final void g(j0 j0Var, int i2, p pVar) throws IOException {
        l7.j jVar = j0Var.f12870b;
        long j = i2;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iG = j0Var.g() & 65535;
            long jG = ((long) j0Var.g()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j3 = j - ((long) 4);
            if (j3 < jG) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            j0Var.F(jG);
            long j8 = jVar.f12868b;
            pVar.invoke(Integer.valueOf(iG), Long.valueOf(jG));
            long j9 = (jVar.f12868b + jG) - j8;
            if (j9 < 0) {
                throw new IOException(a1.a.g(iG, "unsupported zip: too many bytes processed for "));
            }
            if (j9 > 0) {
                jVar.skip(j9);
            }
            j = j3 - jG;
        }
    }

    public static final k h(j0 j0Var, k kVar) throws IOException {
        int iB = j0Var.b();
        if (iB != 67324752) {
            throw new IOException("bad zip: expected " + e(67324752) + " but was " + e(iB));
        }
        j0Var.skip(2L);
        short sG = j0Var.g();
        int i2 = sG & 65535;
        if ((sG & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + e(i2));
        }
        j0Var.skip(18L);
        long jG = ((long) j0Var.g()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int iG = j0Var.g() & 65535;
        j0Var.skip(jG);
        if (kVar == null) {
            j0Var.skip(iG);
            return null;
        }
        a0 a0Var = new a0();
        a0 a0Var2 = new a0();
        a0 a0Var3 = new a0();
        g(j0Var, iG, new l(j0Var, a0Var, a0Var2, a0Var3));
        return new k(kVar.f13021a, kVar.f13022b, kVar.f13023c, kVar.f13024d, kVar.e, kVar.f13025f, kVar.g, kVar.h, kVar.f13026i, kVar.j, kVar.k, kVar.l, kVar.m, (Integer) a0Var.f12717a, (Integer) a0Var2.f12717a, (Integer) a0Var3.f12717a);
    }

    public static final int i(m0 m0Var, int i2) {
        int i8;
        int[] iArr = m0Var.f12884f;
        int i9 = i2 + 1;
        int length = m0Var.e.length;
        kotlin.jvm.internal.k.e(iArr, "<this>");
        int i10 = length - 1;
        int i11 = 0;
        while (true) {
            if (i11 <= i10) {
                i8 = (i11 + i10) >>> 1;
                int i12 = iArr[i8];
                if (i12 >= i9) {
                    if (i12 <= i9) {
                        break;
                    }
                    i10 = i8 - 1;
                } else {
                    i11 = i8 + 1;
                }
            } else {
                i8 = (-i11) - 1;
                break;
            }
        }
        return i8 >= 0 ? i8 : ~i8;
    }
}

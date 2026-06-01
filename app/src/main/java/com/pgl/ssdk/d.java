package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q f10746b;

        public a(long j, q qVar) {
            this.f10745a = j;
            this.f10746b = qVar;
        }

        public q a() {
            return this.f10746b;
        }

        public long b() {
            return this.f10745a;
        }
    }

    public static t a(q qVar) throws IOException, s {
        o<ByteBuffer, Long> oVarA = p.a(qVar);
        if (oVarA == null) {
            throw new s("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBufferA = oVarA.a();
        long jLongValue = oVarA.b().longValue();
        byteBufferA.order(ByteOrder.LITTLE_ENDIAN);
        long jC = p.c(byteBufferA);
        if (jC > jLongValue) {
            StringBuilder sbT = androidx.camera.core.processing.util.a.t("ZIP Central Directory start offset out of range: ", jC, ". ZIP End of Central Directory offset: ");
            sbT.append(jLongValue);
            throw new s(sbT.toString());
        }
        long jD = p.d(byteBufferA);
        long j = jC + jD;
        if (j <= jLongValue) {
            return new t(jC, jD, p.e(byteBufferA), jLongValue, byteBufferA);
        }
        StringBuilder sbT2 = androidx.camera.core.processing.util.a.t("ZIP Central Directory overlaps with End of Central Directory. CD end: ", j, ", EoCD start: ");
        sbT2.append(jLongValue);
        throw new s(sbT2.toString());
    }

    public static a a(q qVar, t tVar) throws b, IOException {
        long jA = tVar.a();
        long jC = tVar.c() + jA;
        long jE = tVar.e();
        if (jC != jE) {
            StringBuilder sbT = androidx.camera.core.processing.util.a.t("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: ", jC, ", EoCD start: ");
            sbT.append(jE);
            throw new b(sbT.toString());
        }
        if (jA >= 32) {
            ByteBuffer byteBufferA = qVar.a(jA - 24, 24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferA.order(byteOrder);
            if (byteBufferA.getLong(8) == 2334950737559900225L && byteBufferA.getLong(16) == 3617552046287187010L) {
                long j = byteBufferA.getLong(0);
                if (j < byteBufferA.capacity() || j > 2147483639) {
                    throw new b("APK Signing Block size out of range: ".concat(String.valueOf(j)));
                }
                long j3 = (int) (8 + j);
                long j8 = jA - j3;
                if (j8 >= 0) {
                    ByteBuffer byteBufferA2 = qVar.a(j8, 8);
                    byteBufferA2.order(byteOrder);
                    long j9 = byteBufferA2.getLong(0);
                    if (j9 == j) {
                        return new a(j8, qVar.a(j8, j3));
                    }
                    StringBuilder sbT2 = androidx.camera.core.processing.util.a.t("APK Signing Block sizes in header and footer do not match: ", j9, " vs ");
                    sbT2.append(j);
                    throw new b(sbT2.toString());
                }
                throw new b("APK Signing Block offset out of range: ".concat(String.valueOf(j8)));
            }
            throw new b("No APK Signing Block before ZIP Central Directory");
        }
        throw new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jA)));
    }
}

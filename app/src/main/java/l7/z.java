package l7;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f12912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f12913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f12914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f12915d;
    public final CRC32 e;

    public z(l source) {
        kotlin.jvm.internal.k.e(source, "source");
        j0 j0Var = new j0(source);
        this.f12913b = j0Var;
        Inflater inflater = new Inflater(true);
        this.f12914c = inflater;
        this.f12915d = new a0(j0Var, inflater);
        this.e = new CRC32();
    }

    public static void a(int i2, int i8, String str) throws IOException {
        if (i8 == i2) {
            return;
        }
        StringBuilder sbX = a1.a.x(str, ": actual 0x");
        sbX.append(n6.m.D0(8, b.m(i8)));
        sbX.append(" != expected 0x");
        sbX.append(n6.m.D0(8, b.m(i2)));
        throw new IOException(sbX.toString());
    }

    public final void b(long j, j jVar, long j3) {
        k0 k0Var = jVar.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        while (true) {
            int i2 = k0Var.f12874c;
            int i8 = k0Var.f12873b;
            if (j < i2 - i8) {
                break;
            }
            j -= (long) (i2 - i8);
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
        }
        while (j3 > 0) {
            int i9 = (int) (((long) k0Var.f12873b) + j);
            int iMin = (int) Math.min(k0Var.f12874c - i9, j3);
            this.e.update(k0Var.f12872a, i9, iMin);
            j3 -= (long) iMin;
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12915d.close();
    }

    @Override // l7.o0
    public final long read(j sink, long j) throws IOException {
        z zVar = this;
        kotlin.jvm.internal.k.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        byte b8 = zVar.f12912a;
        CRC32 crc32 = zVar.e;
        j0 j0Var = zVar.f12913b;
        if (b8 == 0) {
            j0Var.F(10L);
            j jVar = j0Var.f12870b;
            byte bI = jVar.i(3L);
            boolean z2 = ((bI >> 1) & 1) == 1;
            if (z2) {
                zVar.b(0L, jVar, 10L);
            }
            a(8075, j0Var.readShort(), "ID1ID2");
            j0Var.skip(8L);
            if (((bI >> 2) & 1) == 1) {
                j0Var.F(2L);
                if (z2) {
                    b(0L, jVar, 2L);
                }
                long jP = jVar.p() & 65535;
                j0Var.F(jP);
                if (z2) {
                    b(0L, jVar, jP);
                }
                j0Var.skip(jP);
            }
            if (((bI >> 3) & 1) == 1) {
                long jA = j0Var.a((byte) 0, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    b(0L, jVar, jA + 1);
                }
                j0Var.skip(jA + 1);
            }
            if (((bI >> 4) & 1) == 1) {
                long jA2 = j0Var.a((byte) 0, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    zVar = this;
                    zVar.b(0L, jVar, jA2 + 1);
                } else {
                    zVar = this;
                }
                j0Var.skip(jA2 + 1);
            } else {
                zVar = this;
            }
            if (z2) {
                a(j0Var.g(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            zVar.f12912a = (byte) 1;
        }
        if (zVar.f12912a == 1) {
            long j3 = sink.f12868b;
            long j8 = zVar.f12915d.read(sink, j);
            if (j8 != -1) {
                zVar.b(j3, sink, j8);
                return j8;
            }
            zVar.f12912a = (byte) 2;
        }
        if (zVar.f12912a == 2) {
            a(j0Var.b(), (int) crc32.getValue(), "CRC");
            a(j0Var.b(), (int) zVar.f12914c.getBytesWritten(), "ISIZE");
            zVar.f12912a = (byte) 3;
            if (!j0Var.M()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // l7.o0
    public final r0 timeout() {
        return this.f12913b.f12869a.timeout();
    }
}

package l7;

import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f12852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f12854c;
    public byte[] e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12855d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12856f = -1;
    public int g = -1;

    public final void a(long j) {
        j jVar = this.f12852a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.f12853b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j3 = jVar.f12868b;
        if (j <= j3) {
            if (j < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("newSize < 0: ", j).toString());
            }
            long j8 = j3 - j;
            while (true) {
                if (j8 <= 0) {
                    break;
                }
                k0 k0Var = jVar.f12867a;
                kotlin.jvm.internal.k.b(k0Var);
                k0 k0Var2 = k0Var.g;
                kotlin.jvm.internal.k.b(k0Var2);
                int i2 = k0Var2.f12874c;
                long j9 = i2 - k0Var2.f12873b;
                if (j9 > j8) {
                    k0Var2.f12874c = i2 - ((int) j8);
                    break;
                } else {
                    jVar.f12867a = k0Var2.a();
                    l0.a(k0Var2);
                    j8 -= j9;
                }
            }
            this.f12854c = null;
            this.f12855d = j;
            this.e = null;
            this.f12856f = -1;
            this.g = -1;
        } else if (j > j3) {
            long j10 = j - j3;
            int i8 = 1;
            boolean z2 = true;
            for (long j11 = 0; j10 > j11; j11 = 0) {
                k0 k0VarV = jVar.v(i8);
                int iMin = (int) Math.min(j10, 8192 - k0VarV.f12874c);
                int i9 = k0VarV.f12874c + iMin;
                k0VarV.f12874c = i9;
                j10 -= (long) iMin;
                if (z2) {
                    this.f12854c = k0VarV;
                    this.f12855d = j3;
                    this.e = k0VarV.f12872a;
                    this.f12856f = i9 - iMin;
                    this.g = i9;
                    z2 = false;
                }
                i8 = 1;
            }
        }
        jVar.f12868b = j;
    }

    public final int b(long j) {
        j jVar = this.f12852a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j >= -1) {
            long j3 = jVar.f12868b;
            if (j <= j3) {
                if (j == -1 || j == j3) {
                    this.f12854c = null;
                    this.f12855d = j;
                    this.e = null;
                    this.f12856f = -1;
                    this.g = -1;
                    return -1;
                }
                k0 k0Var = jVar.f12867a;
                k0 k0Var2 = this.f12854c;
                long j8 = 0;
                if (k0Var2 != null) {
                    long j9 = this.f12855d - ((long) (this.f12856f - k0Var2.f12873b));
                    if (j9 > j) {
                        k0Var2 = k0Var;
                        k0Var = k0Var2;
                        j3 = j9;
                    } else {
                        j8 = j9;
                    }
                } else {
                    k0Var2 = k0Var;
                }
                if (j3 - j > j - j8) {
                    while (true) {
                        kotlin.jvm.internal.k.b(k0Var2);
                        long j10 = ((long) (k0Var2.f12874c - k0Var2.f12873b)) + j8;
                        if (j < j10) {
                            break;
                        }
                        k0Var2 = k0Var2.f12876f;
                        j8 = j10;
                    }
                } else {
                    while (j3 > j) {
                        kotlin.jvm.internal.k.b(k0Var);
                        k0Var = k0Var.g;
                        kotlin.jvm.internal.k.b(k0Var);
                        j3 -= (long) (k0Var.f12874c - k0Var.f12873b);
                    }
                    k0Var2 = k0Var;
                    j8 = j3;
                }
                if (this.f12853b) {
                    kotlin.jvm.internal.k.b(k0Var2);
                    if (k0Var2.f12875d) {
                        byte[] bArr = k0Var2.f12872a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(...)");
                        k0 k0Var3 = new k0(bArrCopyOf, k0Var2.f12873b, k0Var2.f12874c, false, true);
                        if (jVar.f12867a == k0Var2) {
                            jVar.f12867a = k0Var3;
                        }
                        k0Var2.b(k0Var3);
                        k0 k0Var4 = k0Var3.g;
                        kotlin.jvm.internal.k.b(k0Var4);
                        k0Var4.a();
                        k0Var2 = k0Var3;
                    }
                }
                this.f12854c = k0Var2;
                this.f12855d = j;
                kotlin.jvm.internal.k.b(k0Var2);
                this.e = k0Var2.f12872a;
                int i2 = k0Var2.f12873b + ((int) (j - j8));
                this.f12856f = i2;
                int i8 = k0Var2.f12874c;
                this.g = i8;
                return i8 - i2;
            }
        }
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("offset=", j, " > size=");
        sbT.append(jVar.f12868b);
        throw new ArrayIndexOutOfBoundsException(sbT.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f12852a == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f12852a = null;
        this.f12854c = null;
        this.f12855d = -1L;
        this.e = null;
        this.f12856f = -1;
        this.g = -1;
    }
}

package j4;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d3 implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12154a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k4.u f12156c;
    public final w1.f g;
    public final d5 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12159i;
    public int j;
    public long l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12155b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i4.k f12157d = i4.j.f11874b;
    public final c3 e = new c3(this, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ByteBuffer f12158f = ByteBuffer.allocate(5);
    public int k = -1;

    public d3(d dVar, w1.f fVar, d5 d5Var) {
        this.f12154a = dVar;
        this.g = fVar;
        this.h = d5Var;
    }

    public static int h(o4.a aVar, OutputStream outputStream) throws IOException {
        MessageLite messageLite = aVar.f13186a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            aVar.f13186a.writeTo(outputStream);
            aVar.f13186a = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = aVar.f13188c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        ExtensionRegistryLite extensionRegistryLite = o4.c.f13193a;
        r2.q.D(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int i2 = byteArrayInputStream.read(bArr);
            if (i2 == -1) {
                int i8 = (int) j;
                aVar.f13188c = null;
                return i8;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    @Override // j4.c1
    public final void a(int i2) {
        r2.q.H(this.f12155b == -1, "max size already set");
        this.f12155b = i2;
    }

    @Override // j4.c1
    public final c1 b(i4.k kVar) {
        this.f12157d = kVar;
        return this;
    }

    @Override // j4.c1
    public final void c(o4.a aVar) {
        if (this.f12159i) {
            throw new IllegalStateException("Framer already closed");
        }
        this.j++;
        int i2 = this.k + 1;
        this.k = i2;
        this.l = 0L;
        d5 d5Var = this.h;
        i4.i[] iVarArr = d5Var.f12162a;
        i4.i[] iVarArr2 = d5Var.f12162a;
        int i8 = 0;
        for (i4.i iVar : iVarArr) {
            iVar.i(i2);
        }
        boolean z2 = this.f12157d != i4.j.f11874b;
        try {
            int iAvailable = aVar.available();
            int i9 = (iAvailable == 0 || !z2) ? i(aVar, iAvailable) : f(aVar);
            if (iAvailable != -1 && i9 != iAvailable) {
                throw i4.n1.l.h(androidx.camera.core.processing.util.a.i("Message length inaccurate ", i9, " != ", iAvailable)).a();
            }
            long j = i9;
            for (i4.i iVar2 : iVarArr2) {
                iVar2.k(j);
            }
            long j3 = this.l;
            for (i4.i iVar3 : iVarArr2) {
                iVar3.l(j3);
            }
            int i10 = this.k;
            long j8 = this.l;
            i4.i[] iVarArr3 = d5Var.f12162a;
            int length = iVarArr3.length;
            while (i8 < length) {
                long j9 = j;
                iVarArr3[i8].j(i10, j8, j9);
                i8++;
                j = j9;
            }
        } catch (i4.p1 e) {
            throw e;
        } catch (IOException e4) {
            throw i4.n1.l.h("Failed to frame message").g(e4).a();
        } catch (RuntimeException e8) {
            throw i4.n1.l.h("Failed to frame message").g(e8).a();
        }
    }

    @Override // j4.c1
    public final void close() {
        if (this.f12159i) {
            return;
        }
        this.f12159i = true;
        k4.u uVar = this.f12156c;
        if (uVar != null && uVar.f12690c == 0) {
            this.f12156c = null;
        }
        d(true, true);
    }

    public final void d(boolean z2, boolean z7) {
        k4.u uVar = this.f12156c;
        this.f12156c = null;
        this.f12154a.t(uVar, z2, z7, this.j);
        this.j = 0;
    }

    public final void e(b3 b3Var, boolean z2) {
        ArrayList arrayList = b3Var.f12130a;
        int size = arrayList.size();
        int i2 = 0;
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            i2 += ((k4.u) obj).f12690c;
        }
        int i9 = this.f12155b;
        if (i9 >= 0 && i2 > i9) {
            i4.n1 n1Var = i4.n1.j;
            Locale locale = Locale.US;
            throw n1Var.h("message too large " + i2 + " > " + i9).a();
        }
        ByteBuffer byteBuffer = this.f12158f;
        byteBuffer.clear();
        byteBuffer.put(z2 ? (byte) 1 : (byte) 0).putInt(i2);
        this.g.getClass();
        k4.u uVarB = w1.f.b(5);
        uVarB.a(byteBuffer.array(), 0, byteBuffer.position());
        if (i2 == 0) {
            this.f12156c = uVarB;
            return;
        }
        int i10 = this.j - 1;
        d dVar = this.f12154a;
        dVar.t(uVarB, false, false, i10);
        this.j = 1;
        for (int i11 = 0; i11 < arrayList.size() - 1; i11++) {
            dVar.t((k4.u) arrayList.get(i11), false, false, 0);
        }
        this.f12156c = (k4.u) arrayList.get(arrayList.size() - 1);
        this.l = i2;
    }

    public final int f(o4.a aVar) throws IOException {
        b3 b3Var = new b3(this);
        OutputStream outputStreamA = this.f12157d.a(b3Var);
        try {
            int iH = h(aVar, outputStreamA);
            outputStreamA.close();
            int i2 = this.f12155b;
            if (i2 < 0 || iH <= i2) {
                e(b3Var, true);
                return iH;
            }
            i4.n1 n1Var = i4.n1.j;
            Locale locale = Locale.US;
            throw n1Var.h("message too large " + iH + " > " + i2).a();
        } catch (Throwable th) {
            outputStreamA.close();
            throw th;
        }
    }

    @Override // j4.c1
    public final void flush() {
        k4.u uVar = this.f12156c;
        if (uVar == null || uVar.f12690c <= 0) {
            return;
        }
        d(false, true);
    }

    public final void g(byte[] bArr, int i2, int i8) {
        while (i8 > 0) {
            k4.u uVar = this.f12156c;
            if (uVar != null && uVar.f12689b == 0) {
                d(false, false);
            }
            if (this.f12156c == null) {
                this.g.getClass();
                this.f12156c = w1.f.b(i8);
            }
            int iMin = Math.min(i8, this.f12156c.f12689b);
            this.f12156c.a(bArr, i2, iMin);
            i2 += iMin;
            i8 -= iMin;
        }
    }

    public final int i(o4.a aVar, int i2) throws IOException {
        if (i2 == -1) {
            b3 b3Var = new b3(this);
            int iH = h(aVar, b3Var);
            e(b3Var, false);
            return iH;
        }
        this.l = i2;
        int i8 = this.f12155b;
        if (i8 >= 0 && i2 > i8) {
            i4.n1 n1Var = i4.n1.j;
            Locale locale = Locale.US;
            throw n1Var.h("message too large " + i2 + " > " + i8).a();
        }
        ByteBuffer byteBuffer = this.f12158f;
        byteBuffer.clear();
        byteBuffer.put((byte) 0).putInt(i2);
        if (this.f12156c == null) {
            int iPosition = byteBuffer.position() + i2;
            this.g.getClass();
            this.f12156c = w1.f.b(iPosition);
        }
        g(byteBuffer.array(), 0, byteBuffer.position());
        return h(aVar, this.e);
    }

    @Override // j4.c1
    public final boolean isClosed() {
        return this.f12159i;
    }
}

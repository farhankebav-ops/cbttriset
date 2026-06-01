package k4;

import com.ironsource.G5;
import com.ironsource.adqualitysdk.sdk.i.a0;
import i4.a1;
import i4.g0;
import i4.h0;
import i4.n1;
import i4.v0;
import i4.y0;
import j4.a2;
import j4.a3;
import j4.d5;
import j4.f1;
import j4.f5;
import j4.i1;
import j4.t3;
import j4.u3;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends i1 implements v {
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public final d E;
    public final y F;
    public final n G;
    public boolean H;
    public final r4.c I;
    public w J;
    public int K;
    public final /* synthetic */ k L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f12648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList f12649x;
    public final l7.j y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12650z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, int i2, d5 d5Var, Object obj, d dVar, y yVar, n nVar, int i8) {
        super(i2, d5Var, kVar.f12151c);
        this.L = kVar;
        this.f12254s = e2.d.f11228b;
        this.y = new l7.j();
        this.f12650z = false;
        this.A = false;
        this.B = false;
        this.H = true;
        this.K = -1;
        r2.q.D(obj, "lock");
        this.f12648w = obj;
        this.E = dVar;
        this.F = yVar;
        this.G = nVar;
        this.C = i8;
        this.D = i8;
        this.f12647v = i8;
        r4.b.f13625a.getClass();
        this.I = r4.a.f13623a;
    }

    public static void k(j jVar, a1 a1Var, String str) {
        k kVar = jVar.L;
        String str2 = kVar.m;
        String str3 = kVar.k;
        boolean z2 = kVar.f12654q;
        n nVar = jVar.G;
        boolean z7 = nVar.B == null;
        m4.b bVar = e.f12627a;
        r2.q.D(a1Var, "headers");
        r2.q.D(str, "defaultPath");
        r2.q.D(str2, "authority");
        a1Var.a(f1.f12188i);
        a1Var.a(f1.j);
        v0 v0Var = f1.k;
        a1Var.a(v0Var);
        ArrayList arrayList = new ArrayList(a1Var.f11820b + 7);
        if (z7) {
            arrayList.add(e.f12628b);
        } else {
            arrayList.add(e.f12627a);
        }
        if (z2) {
            arrayList.add(e.f12630d);
        } else {
            arrayList.add(e.f12629c);
        }
        arrayList.add(new m4.b(m4.b.h, str2));
        arrayList.add(new m4.b(m4.b.f12933f, str));
        arrayList.add(new m4.b(v0Var.f11972a, str3));
        arrayList.add(e.e);
        arrayList.add(e.f12631f);
        Logger logger = f5.f12196a;
        Charset charset = g0.f11865a;
        int i2 = a1Var.f11820b * 2;
        byte[][] bArr = new byte[i2][];
        Object[] objArr = a1Var.f11819a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, i2);
        } else {
            for (int i8 = 0; i8 < a1Var.f11820b; i8++) {
                int i9 = i8 * 2;
                Object[] objArr2 = a1Var.f11819a;
                bArr[i9] = (byte[]) objArr2[i9];
                int i10 = i9 + 1;
                Object obj = objArr2[i10];
                if (!(obj instanceof byte[])) {
                    a0.l(obj);
                    throw null;
                }
                bArr[i10] = (byte[]) obj;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12 += 2) {
            byte[] bArr2 = bArr[i12];
            byte[] bArr3 = bArr[i12 + 1];
            if (f5.a(bArr2, f5.f12197b)) {
                bArr[i11] = bArr2;
                bArr[i11 + 1] = g0.f11866b.c(bArr3).getBytes(e2.d.f11227a);
            } else {
                for (byte b8 : bArr3) {
                    if (b8 < 32 || b8 > 126) {
                        String str4 = new String(bArr2, e2.d.f11227a);
                        Logger logger2 = f5.f12196a;
                        StringBuilder sbY = a1.a.y("Metadata key=", str4, ", value=");
                        sbY.append(Arrays.toString(bArr3));
                        sbY.append(" contains invalid ASCII characters");
                        logger2.warning(sbY.toString());
                        break;
                    }
                }
                bArr[i11] = bArr2;
                bArr[i11 + 1] = bArr3;
            }
            i11 += 2;
        }
        if (i11 != i2) {
            bArr = (byte[][]) Arrays.copyOfRange(bArr, 0, i11);
        }
        for (int i13 = 0; i13 < bArr.length; i13 += 2) {
            byte[] bArr4 = bArr[i13];
            l7.m mVar = l7.m.f12880d;
            l7.m mVarF = r4.c.f(bArr4);
            byte[] bArr5 = mVarF.f12881a;
            if (bArr5.length != 0 && bArr5[0] != 58) {
                arrayList.add(new m4.b(mVarF, r4.c.f(bArr[i13 + 1])));
            }
        }
        jVar.f12649x = arrayList;
        n1 n1Var = nVar.f12672v;
        if (n1Var != null) {
            kVar.f12652n.g(n1Var, j4.x.f12541d, true, new a1());
            return;
        }
        if (nVar.f12665n.size() < nVar.C) {
            nVar.v(kVar);
            return;
        }
        nVar.D.add(kVar);
        if (!nVar.f12675z) {
            nVar.f12675z = true;
            a2 a2Var = nVar.F;
            if (a2Var != null) {
                a2Var.b();
            }
        }
        if (kVar.e) {
            nVar.M.c(kVar, true);
        }
    }

    public static void l(j jVar, l7.j jVar2, boolean z2, boolean z7) {
        if (jVar.B) {
            return;
        }
        if (!jVar.H) {
            r2.q.H(jVar.K != -1, "streamId should be set");
            jVar.F.a(z2, jVar.J, jVar2, z7);
        } else {
            jVar.y.write(jVar2, (int) jVar2.f12868b);
            jVar.f12650z |= z2;
            jVar.A |= z7;
        }
    }

    @Override // j4.c
    public final void a(int i2) {
        int i8 = this.D - i2;
        this.D = i8;
        float f4 = i8;
        int i9 = this.f12647v;
        if (f4 <= i9 * 0.5f) {
            int i10 = i9 - i8;
            this.C += i10;
            this.D = i8 + i10;
            this.E.j(this.K, i10);
        }
    }

    @Override // j4.c
    public final void c(boolean z2) {
        j4.x xVar = j4.x.f12538a;
        if (this.f12140n) {
            this.G.h(this.K, null, xVar, false, null, null);
        } else {
            this.G.h(this.K, null, xVar, false, m4.a.CANCEL, null);
        }
        r2.q.H(this.f12141o, "status should have been reported on deframer closed");
        this.l = true;
        if (this.p && z2) {
            h(n1.l.h("Encountered end-of-stream mid-frame"), true, new a1());
        }
        j4.b bVar = this.m;
        if (bVar != null) {
            bVar.run();
            this.m = null;
        }
    }

    public final void m(n1 n1Var, boolean z2, a1 a1Var) throws EOFException {
        if (this.B) {
            return;
        }
        this.B = true;
        if (!this.H) {
            this.G.h(this.K, n1Var, j4.x.f12538a, z2, m4.a.CANCEL, a1Var);
            return;
        }
        n nVar = this.G;
        LinkedList linkedList = nVar.D;
        k kVar = this.L;
        linkedList.remove(kVar);
        nVar.n(kVar);
        this.f12649x = null;
        this.y.a();
        this.H = false;
        if (a1Var == null) {
            a1Var = new a1();
        }
        h(n1Var, true, a1Var);
    }

    public final void n(Throwable th) throws EOFException {
        m(n1.e(th), true, new a1());
    }

    public final w o() {
        w wVar;
        synchronized (this.f12648w) {
            wVar = this.J;
        }
        return wVar;
    }

    public final void p(int i2, boolean z2, l7.j jVar) throws Throwable {
        Throwable th;
        long j = jVar.f12868b;
        int i8 = this.C - (((int) j) + i2);
        this.C = i8;
        this.D -= i2;
        if (i8 < 0) {
            this.E.g(this.K, m4.a.FLOW_CONTROL_ERROR);
            this.G.h(this.K, n1.l.h("Received data size exceeded our receiving window size"), j4.x.f12538a, false, null, null);
            return;
        }
        r rVar = new r(jVar);
        n1 n1Var = this.f12252q;
        boolean z7 = false;
        if (n1Var != null) {
            Charset charset = this.f12254s;
            t3 t3Var = u3.f12491a;
            r2.q.D(charset, G5.M);
            int i9 = (int) jVar.f12868b;
            byte[] bArr = new byte[i9];
            rVar.k(bArr, 0, i9);
            this.f12252q = n1Var.b("DATA-----------------------------\n".concat(new String(bArr, charset)));
            rVar.close();
            if (this.f12252q.f11919b.length() > 1000 || z2) {
                m(this.f12252q, false, this.f12253r);
                return;
            }
            return;
        }
        if (!this.f12255t) {
            m(n1.l.h("headers not received before payload"), false, new a1());
            return;
        }
        int i10 = (int) j;
        boolean z8 = true;
        try {
            if (this.f12141o) {
                j4.d.f12150i.log(Level.INFO, "Received data on closed stream");
                rVar.close();
            } else {
                try {
                    a3 a3Var = this.f12134a;
                    a3Var.getClass();
                    try {
                        if (a3Var.isClosed() || a3Var.f12116q) {
                            rVar.close();
                        } else {
                            a3Var.l.q(rVar);
                            try {
                                a3Var.a();
                            } catch (Throwable th2) {
                                th = th2;
                                z8 = false;
                                if (z8) {
                                    rVar.close();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    try {
                        n(th4);
                    } catch (Throwable th5) {
                        th = th5;
                        if (!z7) {
                            throw th;
                        }
                        rVar.close();
                        throw th;
                    }
                }
            }
            if (z2) {
                if (i10 > 0) {
                    this.f12252q = n1.l.h("Received unexpected EOS on non-empty DATA frame from server");
                } else {
                    this.f12252q = n1.l.h("Received unexpected EOS on empty DATA frame from server");
                }
                a1 a1Var = new a1();
                this.f12253r = a1Var;
                h(this.f12252q, false, a1Var);
            }
        } catch (Throwable th6) {
            th = th6;
            z7 = true;
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void q(ArrayList arrayList, boolean z2) throws EOFException {
        n1 n1VarB;
        y0 y0Var = i1.f12251u;
        if (z2) {
            byte[][] bArrA = z.a(arrayList);
            int length = bArrA.length / 2;
            a1 a1Var = new a1();
            a1Var.f11820b = length;
            a1Var.f11819a = bArrA;
            if (this.f12252q == null && !this.f12255t) {
                n1 n1VarJ = i1.j(a1Var);
                this.f12252q = n1VarJ;
                if (n1VarJ != null) {
                    this.f12253r = a1Var;
                }
            }
            n1 n1Var = this.f12252q;
            if (n1Var != null) {
                n1 n1VarB2 = n1Var.b("trailers: " + a1Var);
                this.f12252q = n1VarB2;
                m(n1VarB2, false, this.f12253r);
                return;
            }
            y0 y0Var2 = h0.f11868b;
            n1 n1Var2 = (n1) a1Var.c(y0Var2);
            if (n1Var2 != null) {
                n1VarB = n1Var2.h((String) a1Var.c(h0.f11867a));
            } else if (this.f12255t) {
                n1VarB = n1.g.h("missing GRPC status in response");
            } else {
                Integer num = (Integer) a1Var.c(y0Var);
                n1VarB = (num != null ? f1.g(num.intValue()) : n1.l.h("missing HTTP status code")).b("missing GRPC status, inferred error from HTTP status code");
            }
            a1Var.a(y0Var);
            a1Var.a(y0Var2);
            a1Var.a(h0.f11867a);
            if (this.f12141o) {
                j4.d.f12150i.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{n1VarB, a1Var});
                return;
            }
            for (i4.i iVar : this.h.f12162a) {
                iVar.e(a1Var);
            }
            g(n1VarB, j4.x.f12538a, false, a1Var);
            return;
        }
        byte[][] bArrA2 = z.a(arrayList);
        int length2 = bArrA2.length / 2;
        a1 a1Var2 = new a1();
        a1Var2.f11820b = length2;
        a1Var2.f11819a = bArrA2;
        n1 n1Var3 = this.f12252q;
        if (n1Var3 != null) {
            this.f12252q = n1Var3.b("headers: " + a1Var2);
            return;
        }
        try {
            if (this.f12255t) {
                n1 n1VarH = n1.l.h("Received headers twice");
                this.f12252q = n1VarH;
                this.f12252q = n1VarH.b("headers: " + a1Var2);
                this.f12253r = a1Var2;
                this.f12254s = i1.i(a1Var2);
                return;
            }
            Integer num2 = (Integer) a1Var2.c(y0Var);
            if (num2 != null && num2.intValue() >= 100 && num2.intValue() < 200) {
                n1 n1Var4 = this.f12252q;
                if (n1Var4 != null) {
                    this.f12252q = n1Var4.b("headers: " + a1Var2);
                    this.f12253r = a1Var2;
                    this.f12254s = i1.i(a1Var2);
                    return;
                }
                return;
            }
            this.f12255t = true;
            n1 n1VarJ2 = i1.j(a1Var2);
            this.f12252q = n1VarJ2;
            if (n1VarJ2 != null) {
                this.f12252q = n1VarJ2.b("headers: " + a1Var2);
                this.f12253r = a1Var2;
                this.f12254s = i1.i(a1Var2);
                return;
            }
            a1Var2.a(y0Var);
            a1Var2.a(h0.f11868b);
            a1Var2.a(h0.f11867a);
            d(a1Var2);
            n1 n1Var5 = this.f12252q;
            if (n1Var5 != null) {
                this.f12252q = n1Var5.b("headers: " + a1Var2);
                this.f12253r = a1Var2;
                this.f12254s = i1.i(a1Var2);
            }
        } catch (Throwable th) {
            n1 n1Var6 = this.f12252q;
            if (n1Var6 != null) {
                this.f12252q = n1Var6.b("headers: " + a1Var2);
                this.f12253r = a1Var2;
                this.f12254s = i1.i(a1Var2);
            }
            throw th;
        }
    }
}

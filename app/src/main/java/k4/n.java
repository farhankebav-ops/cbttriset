package k4;

import androidx.core.location.LocationRequestCompat;
import com.unity3d.services.UnityAdsConstants;
import i4.a1;
import i4.b1;
import i4.c1;
import i4.e0;
import i4.n1;
import i4.o1;
import j4.a2;
import j4.d5;
import j4.e3;
import j4.f0;
import j4.f1;
import j4.g5;
import j4.j1;
import j4.k1;
import j4.m1;
import j4.r1;
import j4.w4;
import j4.x2;
import j4.z1;
import j4.z4;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import l7.i0;
import l7.o0;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n implements f0 {
    public static final Map P;
    public static final Logger Q;
    public final SocketFactory A;
    public final SSLSocketFactory B;
    public int C;
    public final LinkedList D;
    public final l4.c E;
    public a2 F;
    public boolean G;
    public long H;
    public long I;
    public final a4.c J;
    public final int K;
    public final g5 L;
    public final m1 M;
    public final i4.y N;
    public final int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f12659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f12662d;
    public final e2.n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12663f;
    public final m4.j g;
    public r1 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f12664i;
    public y j;
    public final Object k;
    public final e0 l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap f12665n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Executor f12666o;
    public final w4 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f12667q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f12668r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public m f12670t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i4.b f12671u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n1 f12672v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12673w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public k1 f12674x;
    public boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12675z;

    static {
        EnumMap enumMap = new EnumMap(m4.a.class);
        n1 n1Var = n1.l;
        enumMap.put(m4.a.NO_ERROR, n1Var.h("No error: A GRPC status of OK should have been sent"));
        enumMap.put(m4.a.PROTOCOL_ERROR, n1Var.h("Protocol error"));
        enumMap.put(m4.a.INTERNAL_ERROR, n1Var.h(UnityAdsConstants.Messages.MSG_INTERNAL_ERROR));
        enumMap.put(m4.a.FLOW_CONTROL_ERROR, n1Var.h("Flow control error"));
        enumMap.put(m4.a.STREAM_CLOSED, n1Var.h("Stream closed"));
        enumMap.put(m4.a.FRAME_TOO_LARGE, n1Var.h("Frame too large"));
        enumMap.put(m4.a.REFUSED_STREAM, n1.m.h("Refused stream"));
        enumMap.put(m4.a.CANCEL, n1.f11914f.h("Cancelled"));
        enumMap.put(m4.a.COMPRESSION_ERROR, n1Var.h("Compression error"));
        enumMap.put(m4.a.CONNECT_ERROR, n1Var.h("Connect error"));
        enumMap.put(m4.a.ENHANCE_YOUR_CALM, n1.j.h("Enhance your calm"));
        enumMap.put(m4.a.INADEQUATE_SECURITY, n1.f11915i.h("Inadequate security"));
        P = Collections.unmodifiableMap(enumMap);
        Q = Logger.getLogger(n.class.getName());
    }

    public n(g gVar, InetSocketAddress inetSocketAddress, String str, i4.b bVar, i4.y yVar, a4.c cVar) {
        e3 e3Var = f1.f12192r;
        m4.j jVar = new m4.j();
        this.f12662d = new Random();
        Object obj = new Object();
        this.k = obj;
        this.f12665n = new HashMap();
        this.C = 0;
        this.D = new LinkedList();
        this.M = new m1(this, 2);
        this.O = 30000;
        r2.q.D(inetSocketAddress, "address");
        this.f12659a = inetSocketAddress;
        this.f12660b = str;
        this.f12668r = gVar.h;
        this.f12663f = gVar.l;
        Executor executor = gVar.f12634b;
        r2.q.D(executor, "executor");
        this.f12666o = executor;
        this.p = new w4(gVar.f12634b);
        ScheduledExecutorService scheduledExecutorService = gVar.f12636d;
        r2.q.D(scheduledExecutorService, "scheduledExecutorService");
        this.f12667q = scheduledExecutorService;
        this.m = 3;
        this.A = SocketFactory.getDefault();
        this.B = gVar.f12637f;
        l4.c cVar2 = gVar.g;
        r2.q.D(cVar2, "connectionSpec");
        this.E = cVar2;
        r2.q.D(e3Var, "stopwatchFactory");
        this.e = e3Var;
        this.g = jVar;
        this.f12661c = "grpc-java-okhttp/1.62.2";
        this.N = yVar;
        this.J = cVar;
        this.K = gVar.m;
        gVar.e.getClass();
        this.L = new g5();
        this.l = e0.a(n.class, inetSocketAddress.toString());
        i4.b bVar2 = i4.b.f11821b;
        i4.a aVar = z4.f12573b;
        IdentityHashMap identityHashMap = new IdentityHashMap(1);
        identityHashMap.put(aVar, bVar);
        for (Map.Entry entry : bVar2.f11822a.entrySet()) {
            if (!identityHashMap.containsKey(entry.getKey())) {
                identityHashMap.put((i4.a) entry.getKey(), entry.getValue());
            }
        }
        this.f12671u = new i4.b(identityHashMap);
        synchronized (obj) {
        }
    }

    public static void e(n nVar, String str) {
        m4.a aVar = m4.a.PROTOCOL_ERROR;
        nVar.t(0, aVar, x(aVar).b(str));
    }

    public static Socket f(n nVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws o1 {
        Socket socketCreateSocket;
        SocketFactory socketFactory = nVar.A;
        Socket socket = null;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
        } catch (IOException e) {
            e = e;
        }
        try {
            socketCreateSocket.setTcpNoDelay(true);
            socketCreateSocket.setSoTimeout(nVar.O);
            o0 o0VarK = l7.b.k(socketCreateSocket);
            i0 i0VarB = l7.b.b(l7.b.i(socketCreateSocket));
            android.support.v4.media.g gVarG = nVar.g(inetSocketAddress, str, str2);
            a4.a aVar = (a4.a) gVarG.f3264c;
            n4.a aVar2 = (n4.a) gVarG.f3263b;
            Locale locale = Locale.US;
            i0VarB.C("CONNECT " + aVar2.f13063a + ":" + aVar2.f13064b + " HTTP/1.1");
            i0VarB.C("\r\n");
            String[] strArr = (String[]) aVar.f3216b;
            String[] strArr2 = (String[]) aVar.f3216b;
            int length = strArr.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                int i8 = i2 * 2;
                i0VarB.C((i8 < 0 || i8 >= strArr2.length) ? null : strArr2[i8]);
                i0VarB.C(": ");
                int i9 = i8 + 1;
                i0VarB.C((i9 < 0 || i9 >= strArr2.length) ? null : strArr2[i9]);
                i0VarB.C("\r\n");
            }
            i0VarB.C("\r\n");
            i0VarB.flush();
            f2.g gVarC = f2.g.c(q(o0VarK));
            int i10 = gVarC.f11326c;
            while (!q(o0VarK).equals("")) {
            }
            if (i10 >= 200 && i10 < 300) {
                socketCreateSocket.setSoTimeout(0);
                return socketCreateSocket;
            }
            l7.j jVar = new l7.j();
            try {
                socketCreateSocket.shutdownOutput();
                o0VarK.read(jVar, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
            } catch (IOException e4) {
                jVar.d0("Unable to read body: " + e4.toString());
            }
            try {
                socketCreateSocket.close();
            } catch (IOException unused) {
            }
            Locale locale2 = Locale.US;
            throw new o1(n1.m.h("Response returned from proxy was not successful (expected 2xx, got " + i10 + " " + ((String) gVarC.f11327d) + "). Response body:\n" + jVar.r()));
        } catch (IOException e8) {
            e = e8;
            socket = socketCreateSocket;
            if (socket != null) {
                f1.b(socket);
            }
            throw new o1(n1.m.h("Failed trying to connect with proxy").g(e));
        }
    }

    public static String q(o0 o0Var) throws EOFException {
        l7.j jVar = new l7.j();
        while (o0Var.read(jVar, 1L) != -1) {
            if (jVar.i(jVar.f12868b - 1) == 10) {
                return jVar.h(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
        throw new EOFException("\\n not found: " + jVar.J(jVar.f12868b).e());
    }

    public static n1 x(m4.a aVar) {
        n1 n1Var = (n1) P.get(aVar);
        if (n1Var != null) {
            return n1Var;
        }
        return n1.g.h("Unknown http2 error code: " + aVar.f12931a);
    }

    @Override // i4.d0
    public final e0 a() {
        return this.l;
    }

    @Override // j4.z
    public final j4.w b(c1 c1Var, a1 a1Var, i4.d dVar, i4.i[] iVarArr) {
        k kVar;
        r2.q.D(c1Var, "method");
        r2.q.D(a1Var, "headers");
        i4.b bVar = this.f12671u;
        d5 d5Var = new d5(iVarArr);
        for (i4.i iVar : iVarArr) {
            iVar.n(bVar, a1Var);
        }
        synchronized (this.k) {
            kVar = new k(c1Var, a1Var, this.f12664i, this, this.j, this.k, this.f12668r, this.f12663f, this.f12660b, this.f12661c, d5Var, this.L, dVar);
        }
        return kVar;
    }

    @Override // j4.y2
    public final Runnable c(x2 x2Var) {
        this.h = (r1) x2Var;
        if (this.G) {
            a2 a2Var = new a2(new a4.a(this, 16), this.f12667q, this.H, this.I);
            this.F = a2Var;
            a2Var.c();
        }
        c cVar = new c(this.p, this);
        m4.j jVar = this.g;
        i0 i0VarB = l7.b.b(cVar);
        jVar.getClass();
        b bVar = new b(cVar, new m4.i(i0VarB));
        synchronized (this.k) {
            d dVar = new d(this, bVar);
            this.f12664i = dVar;
            this.j = new y(this, dVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.p.execute(new a4.b(this, countDownLatch, cVar, 7));
        try {
            r();
            countDownLatch.countDown();
            this.p.execute(new a4.c(this, 18));
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    @Override // j4.y2
    public final void d(n1 n1Var) {
        synchronized (this.k) {
            try {
                if (this.f12672v != null) {
                    return;
                }
                this.f12672v = n1Var;
                this.h.c(n1Var);
                w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0196 A[EDGE_INSN: B:105:0x0196->B:155:0x023e BREAK  A[LOOP:9: B:142:0x021b->B:153:0x023a]] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0095 A[EDGE_INSN: B:221:0x0095->B:30:0x0095 BREAK  A[LOOP:7: B:50:0x00d0->B:78:0x0118], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0118 A[LOOP:7: B:50:0x00d0->B:78:0x0118, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.support.v4.media.g g(java.net.InetSocketAddress r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instruction units count: 784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.n.g(java.net.InetSocketAddress, java.lang.String, java.lang.String):android.support.v4.media.g");
    }

    @Override // j4.f0
    public final i4.b getAttributes() {
        return this.f12671u;
    }

    public final void h(int i2, n1 n1Var, j4.x xVar, boolean z2, m4.a aVar, a1 a1Var) {
        synchronized (this.k) {
            try {
                k kVar = (k) this.f12665n.remove(Integer.valueOf(i2));
                if (kVar != null) {
                    if (aVar != null) {
                        this.f12664i.g(i2, m4.a.CANCEL);
                    }
                    if (n1Var != null) {
                        j jVar = kVar.f12652n;
                        if (a1Var == null) {
                            a1Var = new a1();
                        }
                        jVar.g(n1Var, xVar, z2, a1Var);
                    }
                    if (!u()) {
                        w();
                        n(kVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final w[] i() {
        w[] wVarArr;
        synchronized (this.k) {
            try {
                wVarArr = new w[this.f12665n.size()];
                Iterator it = this.f12665n.values().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    wVarArr[i2] = ((k) it.next()).f12652n.o();
                    i2++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVarArr;
    }

    public final int j() {
        URI uriA = f1.a(this.f12660b);
        return uriA.getPort() != -1 ? uriA.getPort() : this.f12659a.getPort();
    }

    public final o1 k() {
        synchronized (this.k) {
            try {
                n1 n1Var = this.f12672v;
                if (n1Var != null) {
                    return new o1(n1Var);
                }
                return new o1(n1.m.h("Connection closed"));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final k l(int i2) {
        k kVar;
        synchronized (this.k) {
            kVar = (k) this.f12665n.get(Integer.valueOf(i2));
        }
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.k
            monitor-enter(r0)
            int r1 = r2.m     // Catch: java.lang.Throwable -> Lf
            if (r3 >= r1) goto Lc
            r1 = 1
            r3 = r3 & r1
            if (r3 != r1) goto Lc
            goto Ld
        Lc:
            r1 = 0
        Ld:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            return r1
        Lf:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.n.m(int):boolean");
    }

    public final void n(k kVar) {
        if (this.f12675z && this.D.isEmpty() && this.f12665n.isEmpty()) {
            this.f12675z = false;
            a2 a2Var = this.F;
            if (a2Var != null) {
                synchronized (a2Var) {
                    int i2 = a2Var.f12105d;
                    if (i2 == 2 || i2 == 3) {
                        a2Var.f12105d = 1;
                    }
                    if (a2Var.f12105d == 4) {
                        a2Var.f12105d = 5;
                    }
                }
            }
        }
        if (kVar.e) {
            this.M.c(kVar, false);
        }
    }

    public final void o(Exception exc) {
        t(0, m4.a.INTERNAL_ERROR, n1.m.g(exc));
    }

    public final void p(z1 z1Var) {
        long jNextLong;
        k1 k1Var;
        boolean z2;
        j2.n nVar = j2.n.f12086a;
        synchronized (this.k) {
            try {
                if (this.f12664i == null) {
                    throw new IllegalStateException();
                }
                if (this.y) {
                    o1 o1VarK = k();
                    Logger logger = k1.g;
                    try {
                        nVar.execute(new j1(z1Var, o1VarK));
                    } catch (Throwable th) {
                        k1.g.log(Level.SEVERE, "Failed to execute PingCallback", th);
                    }
                    return;
                }
                k1 k1Var2 = this.f12674x;
                if (k1Var2 != null) {
                    jNextLong = 0;
                    k1Var = k1Var2;
                    z2 = false;
                } else {
                    jNextLong = this.f12662d.nextLong();
                    e2.m mVar = (e2.m) this.e.get();
                    mVar.b();
                    k1Var = new k1(jNextLong, mVar);
                    this.f12674x = k1Var;
                    this.L.getClass();
                    z2 = true;
                }
                if (z2) {
                    this.f12664i.e(false, (int) (jNextLong >>> 32), (int) jNextLong);
                }
                k1Var.a(z1Var);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r() {
        synchronized (this.k) {
            try {
                d dVar = this.f12664i;
                dVar.getClass();
                try {
                    dVar.f12625b.b();
                } catch (IOException e) {
                    dVar.f12624a.o(e);
                }
                com.unity3d.scar.adapter.common.a aVar = new com.unity3d.scar.adapter.common.a(3);
                aVar.i(7, this.f12663f);
                d dVar2 = this.f12664i;
                dVar2.f12626c.o(2, aVar);
                try {
                    dVar2.f12625b.j(aVar);
                } catch (IOException e4) {
                    dVar2.f12624a.o(e4);
                }
                if (this.f12663f > 65535) {
                    this.f12664i.j(0, r1 - 65535);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s(n1 n1Var) {
        d(n1Var);
        synchronized (this.k) {
            try {
                Iterator it = this.f12665n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    it.remove();
                    ((k) entry.getValue()).f12652n.h(n1Var, false, new a1());
                    n((k) entry.getValue());
                }
                for (k kVar : this.D) {
                    kVar.f12652n.g(n1Var, j4.x.f12541d, true, new a1());
                    n(kVar);
                }
                this.D.clear();
                w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(int i2, m4.a aVar, n1 n1Var) {
        synchronized (this.k) {
            try {
                if (this.f12672v == null) {
                    this.f12672v = n1Var;
                    this.h.c(n1Var);
                }
                if (aVar != null && !this.f12673w) {
                    this.f12673w = true;
                    this.f12664i.b(aVar, new byte[0]);
                }
                Iterator it = this.f12665n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i2) {
                        it.remove();
                        ((k) entry.getValue()).f12652n.g(n1Var, j4.x.f12539b, false, new a1());
                        n((k) entry.getValue());
                    }
                }
                for (k kVar : this.D) {
                    kVar.f12652n.g(n1Var, j4.x.f12541d, true, new a1());
                    n(kVar);
                }
                this.D.clear();
                w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.d("logId", this.l.f11854c);
        iVarY.c(this.f12659a, "address");
        return iVarY.toString();
    }

    public final boolean u() {
        boolean z2 = false;
        while (true) {
            LinkedList linkedList = this.D;
            if (linkedList.isEmpty() || this.f12665n.size() >= this.C) {
                break;
            }
            v((k) linkedList.poll());
            z2 = true;
        }
        return z2;
    }

    public final void v(k kVar) {
        r2.q.H(kVar.f12652n.K == -1, "StreamId already assigned");
        this.f12665n.put(Integer.valueOf(this.m), kVar);
        if (!this.f12675z) {
            this.f12675z = true;
            a2 a2Var = this.F;
            if (a2Var != null) {
                a2Var.b();
            }
        }
        if (kVar.e) {
            this.M.c(kVar, true);
        }
        j jVar = kVar.f12652n;
        int i2 = this.m;
        if (!(jVar.K == -1)) {
            throw new IllegalStateException(a.a.K("the stream has been started with id %s", Integer.valueOf(i2)));
        }
        jVar.K = i2;
        y yVar = jVar.F;
        jVar.J = new w(yVar, i2, yVar.f12697a, jVar);
        j jVar2 = jVar.L.f12652n;
        if (jVar2.j == null) {
            throw new IllegalStateException();
        }
        synchronized (jVar2.f12135b) {
            r2.q.H(!jVar2.f12138f, "Already allocated");
            jVar2.f12138f = true;
        }
        jVar2.f();
        g5 g5Var = jVar2.f12136c;
        g5Var.getClass();
        ((e3) g5Var.f12229b).p();
        if (jVar.H) {
            jVar.E.i(jVar.K, jVar.f12649x, jVar.L.f12654q);
            for (i4.i iVar : jVar.L.l.f12162a) {
                iVar.h();
            }
            jVar.f12649x = null;
            l7.j jVar3 = jVar.y;
            if (jVar3.f12868b > 0) {
                jVar.F.a(jVar.f12650z, jVar.J, jVar3, jVar.A);
            }
            jVar.H = false;
        }
        b1 b1Var = (b1) kVar.j.f11838c;
        if ((b1Var != b1.f11827a && b1Var != b1.f11828b) || kVar.f12654q) {
            this.f12664i.flush();
        }
        int i8 = this.m;
        if (i8 < 2147483645) {
            this.m = i8 + 2;
        } else {
            this.m = Integer.MAX_VALUE;
            t(Integer.MAX_VALUE, m4.a.NO_ERROR, n1.m.h("Stream ids exhausted"));
        }
    }

    public final void w() {
        if (this.f12672v == null || !this.f12665n.isEmpty() || !this.D.isEmpty() || this.y) {
            return;
        }
        this.y = true;
        a2 a2Var = this.F;
        if (a2Var != null) {
            synchronized (a2Var) {
                try {
                    if (a2Var.f12105d != 6) {
                        a2Var.f12105d = 6;
                        ScheduledFuture scheduledFuture = a2Var.e;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        ScheduledFuture scheduledFuture2 = a2Var.f12106f;
                        if (scheduledFuture2 != null) {
                            scheduledFuture2.cancel(false);
                            a2Var.f12106f = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        k1 k1Var = this.f12674x;
        if (k1Var != null) {
            k1Var.c(k());
            this.f12674x = null;
        }
        if (!this.f12673w) {
            this.f12673w = true;
            this.f12664i.b(m4.a.NO_ERROR, new byte[0]);
        }
        this.f12664i.close();
    }
}

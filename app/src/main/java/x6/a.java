package x6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17793i = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f17794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f17795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f17796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f17797d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17798f;
    public boolean g;
    public final /* synthetic */ c h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i2) {
        this.h = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f17794a = new m();
        this.f17795b = new a0();
        this.f17796c = b.f17802d;
        this.nextParkedWorker = c.k;
        int iNanoTime = (int) System.nanoTime();
        this.f17798f = iNanoTime == 0 ? 42 : iNanoTime;
        f(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r12 = x6.m.f17826d.get(r10);
        r0 = x6.m.f17825c.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r12 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (x6.m.e.get(r10) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r0 = r0 - 1;
        r1 = r10.c(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r1 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r8 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final x6.i a(boolean r12) {
        /*
            r11 = this;
            x6.b r0 = r11.f17796c
            x6.b r1 = x6.b.f17799a
            x6.c r3 = r11.h
            r8 = 0
            r9 = 1
            x6.m r10 = r11.f17794a
            if (r0 != r1) goto Le
            goto L86
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = x6.c.f17804i
        L10:
            long r4 = r0.get(r3)
            r1 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r1 = r1 & r4
            r6 = 42
            long r1 = r1 >> r6
            int r1 = (int) r1
            if (r1 != 0) goto L73
            r10.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = x6.m.f17824b
            java.lang.Object r0 = r12.get(r10)
            x6.i r0 = (x6.i) r0
            if (r0 != 0) goto L2e
            goto L41
        L2e:
            boolean r1 = r0.f17816b
            if (r1 != r9) goto L41
        L32:
            boolean r1 = r12.compareAndSet(r10, r0, r8)
            if (r1 == 0) goto L3a
            r8 = r0
            goto L61
        L3a:
            java.lang.Object r1 = r12.get(r10)
            if (r1 == r0) goto L32
            goto L23
        L41:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = x6.m.f17826d
            int r12 = r12.get(r10)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = x6.m.f17825c
            int r0 = r0.get(r10)
        L4d:
            if (r12 == r0) goto L61
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = x6.m.e
            int r1 = r1.get(r10)
            if (r1 != 0) goto L58
            goto L61
        L58:
            int r0 = r0 + (-1)
            x6.i r1 = r10.c(r0, r9)
            if (r1 == 0) goto L4d
            r8 = r1
        L61:
            if (r8 != 0) goto L72
            x6.f r12 = r3.f17809f
            java.lang.Object r12 = r12.d()
            x6.i r12 = (x6.i) r12
            if (r12 != 0) goto L71
            x6.i r12 = r11.i(r9)
        L71:
            return r12
        L72:
            return r8
        L73:
            r1 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r6 = r4 - r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = x6.c.f17804i
            boolean r1 = r2.compareAndSet(r3, r4, r6)
            if (r1 == 0) goto L10
            x6.b r0 = x6.b.f17799a
            r11.f17796c = r0
        L86:
            if (r12 == 0) goto Lba
            int r12 = r3.f17805a
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L93
            goto L94
        L93:
            r9 = 0
        L94:
            if (r9 == 0) goto L9d
            x6.i r12 = r11.e()
            if (r12 == 0) goto L9d
            return r12
        L9d:
            r10.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = x6.m.f17824b
            java.lang.Object r12 = r12.getAndSet(r10, r8)
            x6.i r12 = (x6.i) r12
            if (r12 != 0) goto Lae
            x6.i r12 = r10.b()
        Lae:
            if (r12 == 0) goto Lb1
            return r12
        Lb1:
            if (r9 != 0) goto Lc1
            x6.i r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lba:
            x6.i r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lc1:
            r12 = 3
            x6.i r12 = r11.i(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.a.a(boolean):x6.i");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i2) {
        int i8 = this.f17798f;
        int i9 = i8 ^ (i8 << 13);
        int i10 = i9 ^ (i9 >> 17);
        int i11 = i10 ^ (i10 << 5);
        this.f17798f = i11;
        int i12 = i2 - 1;
        return (i12 & i2) == 0 ? i11 & i12 : (i11 & Integer.MAX_VALUE) % i2;
    }

    public final i e() {
        int iD = d(2);
        c cVar = this.h;
        if (iD == 0) {
            i iVar = (i) cVar.e.d();
            return iVar != null ? iVar : (i) cVar.f17809f.d();
        }
        i iVar2 = (i) cVar.f17809f.d();
        return iVar2 != null ? iVar2 : (i) cVar.e.d();
    }

    public final void f(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h.f17808d);
        sb.append("-worker-");
        sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
        setName(sb.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f17796c;
        boolean z2 = bVar2 == b.f17799a;
        if (z2) {
            c.f17804i.addAndGet(this.h, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f17796c = bVar;
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        r7 = -2;
        r5 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final x6.i i(int r26) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.a.i(int):x6.i");
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.a.run():void");
    }
}

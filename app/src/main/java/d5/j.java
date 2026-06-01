package d5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11107c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f11108d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f11109f;
    public final Object g;

    public j(s4.g gVar, int i2) {
        super(gVar);
        this.g = new h5.b(i2);
        this.f11109f = new AtomicInteger();
    }

    @Override // s4.e
    public final void b(Object obj) {
        switch (this.f11107c) {
            case 0:
                if (!this.e && !this.f11100b.b()) {
                    if (obj != null) {
                        ((h5.b) this.g).offer(obj);
                        i();
                    } else {
                        e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    }
                    break;
                }
                break;
            default:
                if (!this.e && !this.f11100b.b()) {
                    if (obj != null) {
                        ((AtomicReference) this.g).set(obj);
                        i();
                    } else {
                        e(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    }
                    break;
                }
                break;
        }
    }

    @Override // d5.i
    public final void f() {
        switch (this.f11107c) {
            case 0:
                i();
                break;
            default:
                i();
                break;
        }
    }

    @Override // d5.i
    public final void g() {
        switch (this.f11107c) {
            case 0:
                if (this.f11109f.getAndIncrement() == 0) {
                    ((h5.b) this.g).clear();
                }
                break;
            default:
                if (this.f11109f.getAndIncrement() == 0) {
                    ((AtomicReference) this.g).lazySet(null);
                }
                break;
        }
    }

    @Override // d5.i
    public final boolean h(Throwable th) {
        switch (this.f11107c) {
            case 0:
                if (!this.e && !this.f11100b.b()) {
                    this.f11108d = th;
                    this.e = true;
                    i();
                    break;
                }
                break;
            default:
                if (!this.e && !this.f11100b.b()) {
                    this.f11108d = th;
                    this.e = true;
                    i();
                    break;
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        if (r9 != r5) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r17.f11100b.b() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        r2.lazySet(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        r5 = r17.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        if (r2.get() != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0071, code lost:
    
        if (r5 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        if (r12 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
    
        r1 = r17.f11108d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        if (r1 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
    
        d(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
    
        if (r9 == 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
    
        a.a.P(r17, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0088, code lost:
    
        r4 = r17.f11109f.addAndGet(-r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.j.i():void");
    }

    public j(s4.g gVar) {
        super(gVar);
        this.g = new AtomicReference();
        this.f11109f = new AtomicInteger();
    }
}

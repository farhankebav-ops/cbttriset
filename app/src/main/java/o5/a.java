package o5;

import f2.g;
import l5.e;
import s4.m;
import x4.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements u4.b, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f13194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f13195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13197d;
    public g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13198f;
    public volatile boolean g;
    public long h;

    public a(m mVar, b bVar) {
        this.f13194a = mVar;
        this.f13195b = bVar;
    }

    public final void a() {
        g gVar;
        Object obj;
        while (!this.g) {
            synchronized (this) {
                try {
                    gVar = this.e;
                    if (gVar == null) {
                        this.f13197d = false;
                        return;
                    }
                    this.e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (Object[] objArr = (Object[]) gVar.f11325b; objArr != null; objArr = objArr[4]) {
                for (int i2 = 0; i2 < 4 && (obj = objArr[i2]) != null; i2++) {
                    if (test(obj)) {
                        break;
                    }
                }
            }
        }
    }

    public final void b(Object obj, long j) {
        if (this.g) {
            return;
        }
        if (!this.f13198f) {
            synchronized (this) {
                try {
                    if (this.g) {
                        return;
                    }
                    if (this.h == j) {
                        return;
                    }
                    if (this.f13197d) {
                        g gVar = this.e;
                        if (gVar == null) {
                            gVar = new g();
                            this.e = gVar;
                        }
                        int i2 = gVar.f11326c;
                        if (i2 == 4) {
                            Object[] objArr = new Object[5];
                            ((Object[]) gVar.f11327d)[4] = objArr;
                            gVar.f11327d = objArr;
                            i2 = 0;
                        }
                        ((Object[]) gVar.f11327d)[i2] = obj;
                        gVar.f11326c = i2 + 1;
                        return;
                    }
                    this.f13196c = true;
                    this.f13198f = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        test(obj);
    }

    @Override // u4.b
    public final void dispose() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.f13195b.e(this);
    }

    @Override // x4.d
    public final boolean test(Object obj) {
        if (this.g) {
            return true;
        }
        m mVar = this.f13194a;
        if (obj == e.f12825a) {
            mVar.onComplete();
            return true;
        }
        if (obj instanceof l5.d) {
            mVar.onError(((l5.d) obj).f12824a);
            return true;
        }
        mVar.b(obj);
        return false;
    }
}

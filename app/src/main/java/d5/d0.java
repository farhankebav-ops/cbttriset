package d5;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 extends k5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f11074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11077d;
    public final s4.g e;

    public d0(s4.g gVar, Object[] objArr, int i2) {
        this.f11077d = i2;
        this.f11074a = objArr;
        this.e = gVar;
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j) && a.a.f(this, j) == 0) {
            if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                switch (this.f11077d) {
                    case 0:
                        Object[] objArr = this.f11074a;
                        int length = objArr.length;
                        a5.a aVar = (a5.a) this.e;
                        for (int i2 = this.f11075b; i2 != length; i2++) {
                            if (!this.f11076c) {
                                Object obj = objArr[i2];
                                if (obj == null) {
                                    aVar.onError(new NullPointerException("array element is null"));
                                } else {
                                    aVar.e(obj);
                                }
                            }
                            break;
                        }
                        if (!this.f11076c) {
                            aVar.onComplete();
                            break;
                        }
                        break;
                    default:
                        Object[] objArr2 = this.f11074a;
                        int length2 = objArr2.length;
                        s4.g gVar = this.e;
                        for (int i8 = this.f11075b; i8 != length2; i8++) {
                            if (!this.f11076c) {
                                Object obj2 = objArr2[i8];
                                if (obj2 == null) {
                                    gVar.onError(new NullPointerException("array element is null"));
                                } else {
                                    gVar.b(obj2);
                                }
                            }
                            break;
                        }
                        if (!this.f11076c) {
                            gVar.onComplete();
                            break;
                        }
                        break;
                }
            }
            switch (this.f11077d) {
                case 0:
                    Object[] objArr3 = this.f11074a;
                    int length3 = objArr3.length;
                    int i9 = this.f11075b;
                    a5.a aVar2 = (a5.a) this.e;
                    do {
                        long j3 = 0;
                        while (true) {
                            if (j3 != j && i9 != length3) {
                                if (!this.f11076c) {
                                    Object obj3 = objArr3[i9];
                                    if (obj3 == null) {
                                        aVar2.onError(new NullPointerException("array element is null"));
                                    } else {
                                        if (aVar2.e(obj3)) {
                                            j3++;
                                        }
                                        i9++;
                                    }
                                }
                                break;
                            } else if (i9 == length3) {
                                if (!this.f11076c) {
                                    aVar2.onComplete();
                                }
                                break;
                            } else {
                                j = get();
                                if (j3 == j) {
                                    this.f11075b = i9;
                                    j = addAndGet(-j3);
                                }
                            }
                        }
                    } while (j != 0);
                    break;
                default:
                    Object[] objArr4 = this.f11074a;
                    int length4 = objArr4.length;
                    int i10 = this.f11075b;
                    s4.g gVar2 = this.e;
                    do {
                        long j8 = 0;
                        while (true) {
                            if (j8 != j && i10 != length4) {
                                if (!this.f11076c) {
                                    Object obj4 = objArr4[i10];
                                    if (obj4 == null) {
                                        gVar2.onError(new NullPointerException("array element is null"));
                                    } else {
                                        gVar2.b(obj4);
                                        j8++;
                                        i10++;
                                    }
                                }
                                break;
                            } else if (i10 == length4) {
                                if (!this.f11076c) {
                                    gVar2.onComplete();
                                }
                                break;
                            } else {
                                j = get();
                                if (j8 == j) {
                                    this.f11075b = i10;
                                    j = addAndGet(-j8);
                                }
                            }
                        }
                    } while (j != 0);
                    break;
            }
        }
    }

    @Override // o7.b
    public final void cancel() {
        this.f11076c = true;
    }

    @Override // a5.h
    public final void clear() {
        this.f11075b = this.f11074a.length;
    }

    @Override // a5.d
    public final int d(int i2) {
        return 1;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f11075b == this.f11074a.length;
    }

    @Override // a5.h
    public final Object poll() {
        int i2 = this.f11075b;
        Object[] objArr = this.f11074a;
        if (i2 == objArr.length) {
            return null;
        }
        this.f11075b = i2 + 1;
        Object obj = objArr[i2];
        z4.b.a(obj, "array element is null");
        return obj;
    }
}

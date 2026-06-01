package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e0 extends k5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f11084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f11085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11087d;
    public final s4.g e;

    public e0(s4.g gVar, Iterator it, int i2) {
        this.f11087d = i2;
        this.f11084a = it;
        this.e = gVar;
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j) && a.a.f(this, j) == 0) {
            if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                switch (this.f11087d) {
                    case 0:
                        Iterator it = this.f11084a;
                        a5.a aVar = (a5.a) this.e;
                        while (!this.f11085b) {
                            try {
                                Object next = it.next();
                                if (this.f11085b) {
                                    break;
                                } else if (next == null) {
                                    aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    break;
                                } else {
                                    aVar.e(next);
                                    if (this.f11085b) {
                                        break;
                                    } else {
                                        try {
                                            if (!it.hasNext()) {
                                                if (!this.f11085b) {
                                                    aVar.onComplete();
                                                }
                                                break;
                                            }
                                        } catch (Throwable th) {
                                            r2.q.y0(th);
                                            aVar.onError(th);
                                            return;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                r2.q.y0(th2);
                                aVar.onError(th2);
                            }
                        }
                        break;
                    default:
                        Iterator it2 = this.f11084a;
                        s4.g gVar = this.e;
                        while (!this.f11085b) {
                            try {
                                Object next2 = it2.next();
                                if (this.f11085b) {
                                    break;
                                } else if (next2 == null) {
                                    gVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    break;
                                } else {
                                    gVar.b(next2);
                                    if (this.f11085b) {
                                        break;
                                    } else {
                                        try {
                                            if (!it2.hasNext()) {
                                                if (!this.f11085b) {
                                                    gVar.onComplete();
                                                }
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            r2.q.y0(th3);
                                            gVar.onError(th3);
                                            return;
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                r2.q.y0(th4);
                                gVar.onError(th4);
                                return;
                            }
                        }
                        break;
                }
            }
            switch (this.f11087d) {
                case 0:
                    Iterator it3 = this.f11084a;
                    a5.a aVar2 = (a5.a) this.e;
                    do {
                        long j3 = 0;
                        while (true) {
                            if (j3 == j) {
                                j = get();
                                if (j3 == j) {
                                    j = addAndGet(-j3);
                                }
                            } else if (this.f11085b) {
                                break;
                            } else {
                                try {
                                    Object next3 = it3.next();
                                    if (this.f11085b) {
                                        break;
                                    } else if (next3 == null) {
                                        aVar2.onError(new NullPointerException("Iterator.next() returned a null value"));
                                        break;
                                    } else {
                                        boolean zE = aVar2.e(next3);
                                        if (this.f11085b) {
                                            break;
                                        } else {
                                            try {
                                                if (!it3.hasNext()) {
                                                    if (!this.f11085b) {
                                                        aVar2.onComplete();
                                                    }
                                                    break;
                                                } else if (zE) {
                                                    j3++;
                                                }
                                            } catch (Throwable th5) {
                                                r2.q.y0(th5);
                                                aVar2.onError(th5);
                                                return;
                                            }
                                        }
                                    }
                                } catch (Throwable th6) {
                                    r2.q.y0(th6);
                                    aVar2.onError(th6);
                                    return;
                                }
                            }
                        }
                    } while (j != 0);
                    break;
                default:
                    Iterator it4 = this.f11084a;
                    s4.g gVar2 = this.e;
                    do {
                        long j8 = 0;
                        while (true) {
                            if (j8 != j) {
                                if (!this.f11085b) {
                                    try {
                                        Object next4 = it4.next();
                                        if (!this.f11085b) {
                                            if (next4 == null) {
                                                gVar2.onError(new NullPointerException("Iterator.next() returned a null value"));
                                            } else {
                                                gVar2.b(next4);
                                                if (!this.f11085b) {
                                                    try {
                                                        if (it4.hasNext()) {
                                                            j8++;
                                                        } else if (!this.f11085b) {
                                                            gVar2.onComplete();
                                                        }
                                                    } catch (Throwable th7) {
                                                        r2.q.y0(th7);
                                                        gVar2.onError(th7);
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Throwable th8) {
                                        r2.q.y0(th8);
                                        gVar2.onError(th8);
                                        return;
                                    }
                                }
                                break;
                            } else {
                                j = get();
                                if (j8 == j) {
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
        this.f11085b = true;
    }

    @Override // a5.h
    public final void clear() {
        this.f11084a = null;
    }

    @Override // a5.d
    public final int d(int i2) {
        return 1;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        Iterator it = this.f11084a;
        return it == null || !it.hasNext();
    }

    @Override // a5.h
    public final Object poll() {
        Iterator it = this.f11084a;
        if (it == null) {
            return null;
        }
        if (!this.f11086c) {
            this.f11086c = true;
        } else if (!it.hasNext()) {
            return null;
        }
        Object next = this.f11084a.next();
        z4.b.a(next, "Iterator.next() returned a null value");
        return next;
    }
}

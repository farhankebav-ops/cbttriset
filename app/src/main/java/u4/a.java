package u4;

import d1.g;
import i5.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import l5.c;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f17536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17537c;

    public /* synthetic */ a(int i2) {
        this.f17535a = i2;
    }

    private final boolean b(b bVar) {
        if (!this.f17536b) {
            synchronized (this) {
                try {
                    if (!this.f17536b) {
                        g gVar = (g) this.f17537c;
                        if (gVar == null) {
                            gVar = new g();
                            int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
                            gVar.f11042a = iNumberOfLeadingZeros - 1;
                            gVar.f11044c = (int) (0.75f * iNumberOfLeadingZeros);
                            gVar.f11045d = new Object[iNumberOfLeadingZeros];
                            this.f17537c = gVar;
                        }
                        gVar.a(bVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        bVar.dispose();
        return false;
    }

    private final boolean d(b bVar) {
        Object obj;
        z4.b.a(bVar, "Disposable item is null");
        if (this.f17536b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f17536b) {
                    return false;
                }
                g gVar = (g) this.f17537c;
                if (gVar != null) {
                    Object[] objArr = (Object[]) gVar.f11045d;
                    int i2 = gVar.f11042a;
                    int iHashCode = bVar.hashCode() * (-1640531527);
                    int i8 = (iHashCode ^ (iHashCode >>> 16)) & i2;
                    Object obj2 = objArr[i8];
                    if (obj2 != null) {
                        if (obj2.equals(bVar)) {
                            gVar.c(i8, i2, objArr);
                        } else {
                            do {
                                i8 = (i8 + 1) & i2;
                                obj = objArr[i8];
                                if (obj == null) {
                                }
                            } while (!obj.equals(bVar));
                            gVar.c(i8, i2, objArr);
                        }
                        return true;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    private final void e() {
        if (this.f17536b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f17536b) {
                    return;
                }
                this.f17536b = true;
                g gVar = (g) this.f17537c;
                ArrayList arrayList = null;
                this.f17537c = null;
                if (gVar == null) {
                    return;
                }
                for (Object obj : (Object[]) gVar.f11045d) {
                    if (obj instanceof b) {
                        try {
                            ((b) obj).dispose();
                        } catch (Throwable th) {
                            q.y0(th);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(th);
                        }
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new v4.b(arrayList);
                    }
                    throw c.c((Throwable) arrayList.get(0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean a(b bVar) {
        switch (this.f17535a) {
            case 0:
                return b(bVar);
            default:
                if (!this.f17536b) {
                    synchronized (this) {
                        try {
                            if (!this.f17536b) {
                                LinkedList linkedList = (LinkedList) this.f17537c;
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                    this.f17537c = linkedList;
                                }
                                linkedList.add(bVar);
                                return true;
                            }
                        } finally {
                        }
                    }
                }
                bVar.dispose();
                return false;
        }
    }

    public final boolean c(b bVar) {
        switch (this.f17535a) {
            case 0:
                return d(bVar);
            default:
                boolean z2 = false;
                if (!this.f17536b) {
                    synchronized (this) {
                        try {
                            if (!this.f17536b) {
                                LinkedList linkedList = (LinkedList) this.f17537c;
                                if (linkedList != null && linkedList.remove(bVar)) {
                                    z2 = true;
                                }
                            }
                        } finally {
                        }
                    }
                    break;
                }
                return z2;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f17535a) {
            case 0:
                e();
                return;
            default:
                if (this.f17536b) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (!this.f17536b) {
                            this.f17536b = true;
                            LinkedList linkedList = (LinkedList) this.f17537c;
                            ArrayList arrayList = null;
                            this.f17537c = null;
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    try {
                                        ((b) it.next()).dispose();
                                    } catch (Throwable th) {
                                        q.y0(th);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(th);
                                    }
                                }
                                if (arrayList != null) {
                                    if (arrayList.size() != 1) {
                                        throw new v4.b(arrayList);
                                    }
                                    throw c.c((Throwable) arrayList.get(0));
                                }
                            }
                        }
                    } finally {
                    }
                }
                return;
        }
    }

    public final boolean f(b bVar) {
        switch (this.f17535a) {
            case 0:
                if (c(bVar)) {
                    bVar.dispose();
                }
                break;
            default:
                if (c(bVar)) {
                    ((n) bVar).dispose();
                }
                break;
        }
        return true;
    }
}

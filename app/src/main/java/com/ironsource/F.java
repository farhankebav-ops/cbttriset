package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class F {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6730c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2595v0 f6731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Cg f6732b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.F$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class C0164a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6733a;

            static {
                int[] iArr = new int[Gg.values().length];
                try {
                    iArr[Gg.BIDDER_SENSITIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Gg.DEFAULT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f6733a = iArr;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final F a(AbstractC2595v0 adUnitData, Cg waterfallInstances) {
            kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
            kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
            int i2 = C0164a.f6733a[(adUnitData.d() ? Gg.BIDDER_SENSITIVE : Gg.DEFAULT).ordinal()];
            if (i2 == 1) {
                return new C2632x3(adUnitData, waterfallInstances);
            }
            if (i2 == 2) {
                return adUnitData.q() ? new C2492of(adUnitData, waterfallInstances) : new K4(adUnitData, waterfallInstances);
            }
            throw new e2.s(3);
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<AbstractC2662z> f6734a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<AbstractC2662z> f6735b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<AbstractC2662z> f6736c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6737d;

        public final List<AbstractC2662z> a() {
            return this.f6734a;
        }

        public final List<AbstractC2662z> b() {
            return this.f6735b;
        }

        public final List<AbstractC2662z> c() {
            return this.f6736c;
        }

        public final boolean d() {
            return this.f6737d;
        }

        public final boolean e() {
            return g() == 0;
        }

        public final boolean f() {
            return this.f6734a.isEmpty() && this.f6736c.isEmpty();
        }

        public final int g() {
            return this.f6736c.size() + this.f6735b.size() + this.f6734a.size();
        }

        public final void a(boolean z2) {
            this.f6737d = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AbstractC2662z f6738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<AbstractC2662z> f6739b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(AbstractC2662z abstractC2662z, List<? extends AbstractC2662z> orderedInstances) {
            kotlin.jvm.internal.k.e(orderedInstances, "orderedInstances");
            this.f6738a = abstractC2662z;
            this.f6739b = orderedInstances;
        }

        public final AbstractC2662z a() {
            return this.f6738a;
        }

        public final List<AbstractC2662z> b() {
            return this.f6739b;
        }

        public final AbstractC2662z c() {
            return this.f6738a;
        }

        public final List<AbstractC2662z> d() {
            return this.f6739b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.k.a(this.f6738a, cVar.f6738a) && kotlin.jvm.internal.k.a(this.f6739b, cVar.f6739b);
        }

        public int hashCode() {
            AbstractC2662z abstractC2662z = this.f6738a;
            return this.f6739b.hashCode() + ((abstractC2662z == null ? 0 : abstractC2662z.hashCode()) * 31);
        }

        public String toString() {
            return "ShowSelection(instanceToShow=" + this.f6738a + ", orderedInstances=" + this.f6739b + ")";
        }

        public final c a(AbstractC2662z abstractC2662z, List<? extends AbstractC2662z> orderedInstances) {
            kotlin.jvm.internal.k.e(orderedInstances, "orderedInstances");
            return new c(abstractC2662z, orderedInstances);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c a(c cVar, AbstractC2662z abstractC2662z, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                abstractC2662z = cVar.f6738a;
            }
            if ((i2 & 2) != 0) {
                list = cVar.f6739b;
            }
            return cVar.a(abstractC2662z, list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t3, T t7) {
            return n7.b.j(Integer.valueOf(((AbstractC2662z) t3).h().l()), Integer.valueOf(((AbstractC2662z) t7).h().l()));
        }
    }

    public F(AbstractC2595v0 adUnitData, Cg waterfallInstances) {
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        this.f6731a = adUnitData;
        this.f6732b = waterfallInstances;
    }

    private final List<AbstractC2662z> b() {
        return r5.l.j1(this.f6732b.b(), new d());
    }

    public abstract void a(AbstractC2662z abstractC2662z, b bVar);

    public boolean a(AbstractC2662z instance, Cg waterfallInstances) {
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        return false;
    }

    public final c c() {
        Object next;
        List<AbstractC2662z> listB = b();
        Iterator<T> it = listB.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AbstractC2662z) next).w()) {
                break;
            }
        }
        return new c((AbstractC2662z) next, listB);
    }

    public final b d() {
        IronLog.INTERNAL.verbose(this.f6731a.b().a().name() + " waterfall size: " + this.f6732b.b().size());
        b bVar = new b();
        Iterator<AbstractC2662z> it = this.f6732b.b().iterator();
        while (it.hasNext() && !b(it.next(), bVar)) {
        }
        return bVar;
    }

    public final boolean a(AbstractC2662z instance) {
        Object next;
        kotlin.jvm.internal.k.e(instance, "instance");
        Iterator<T> it = b().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((AbstractC2662z) next).v()) {
                break;
            }
        }
        return kotlin.jvm.internal.k.a(next, instance);
    }

    private final boolean b(AbstractC2662z abstractC2662z, b bVar) {
        if (abstractC2662z.v()) {
            IronLog.INTERNAL.verbose(abstractC2662z.d().name() + " - Instance " + abstractC2662z.q() + " is failed to load");
        } else if (abstractC2662z.w()) {
            IronLog.INTERNAL.verbose(abstractC2662z.d().name() + " - Instance " + abstractC2662z.q() + " is already loaded");
            bVar.b().add(abstractC2662z);
        } else if (abstractC2662z.x()) {
            IronLog.INTERNAL.verbose(abstractC2662z.d().name() + " - Instance " + abstractC2662z.q() + " still loading");
            bVar.c().add(abstractC2662z);
        } else if (a(abstractC2662z, this.f6732b)) {
            IronLog.INTERNAL.verbose(abstractC2662z.d().name() + " - Instance " + abstractC2662z.q() + " is not better than already loaded instances");
        } else {
            a(abstractC2662z, bVar);
        }
        return a(bVar);
    }

    public final boolean a() {
        int i2;
        List<AbstractC2662z> listB = this.f6732b.b();
        if (listB == null || !listB.isEmpty()) {
            Iterator<T> it = listB.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (((AbstractC2662z) it.next()).w() && (i2 = i2 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        } else {
            i2 = 0;
        }
        return i2 >= this.f6731a.k();
    }

    public boolean a(b loadSelection) {
        kotlin.jvm.internal.k.e(loadSelection, "loadSelection");
        return loadSelection.g() >= this.f6731a.k();
    }
}

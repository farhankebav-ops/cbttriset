package com.ironsource;

import com.ironsource.AbstractC2547s3;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ig<Smash extends AbstractC2547s3<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final U f6994a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t3, T t7) {
            return n7.b.j(Integer.valueOf(((AbstractC2547s3) t3).i().l()), Integer.valueOf(((AbstractC2547s3) t7).i().l()));
        }
    }

    public Ig(U managerData) {
        kotlin.jvm.internal.k.e(managerData, "managerData");
        this.f6994a = managerData;
    }

    public final boolean a(AbstractC2547s3<?> smash, List<? extends Smash> waterfall) {
        Object next;
        kotlin.jvm.internal.k.e(smash, "smash");
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        Iterator<T> it = b(waterfall).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((AbstractC2547s3) next).x()) {
                break;
            }
        }
        return kotlin.jvm.internal.k.a(next, smash);
    }

    public final List<Smash> b(List<? extends Smash> waterfall) {
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        return r5.l.j1(waterfall, new a());
    }

    public final Smash c(List<? extends Smash> waterfall) {
        Object next;
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        Iterator<T> it = b(waterfall).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AbstractC2547s3) next).B()) {
                break;
            }
        }
        return (Smash) next;
    }

    public final Jg<Smash> d(List<? extends Smash> waterfall) {
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        IronLog.INTERNAL.verbose(this.f6994a.b().name() + " waterfall size: " + waterfall.size());
        Kg<Smash> kgA = Kg.g.a(this.f6994a.c() ? Gg.BIDDER_SENSITIVE : Gg.DEFAULT, this.f6994a.i(), this.f6994a.m(), waterfall);
        Iterator<? extends Smash> it = waterfall.iterator();
        while (it.hasNext()) {
            kgA.d(it.next());
            if (kgA.e()) {
                return new Jg<>(kgA);
            }
        }
        return new Jg<>(kgA);
    }

    public final boolean a(List<? extends Smash> waterfall) {
        int i2;
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        if (waterfall.isEmpty()) {
            i2 = 0;
        } else {
            Iterator<T> it = waterfall.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (((AbstractC2547s3) it.next()).y() && (i2 = i2 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i2 >= this.f6994a.i();
    }
}

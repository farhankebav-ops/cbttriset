package com.ironsource;

import com.ironsource.AbstractC2547s3;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Kg<Smash extends AbstractC2547s3<?>> {
    public static final a g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Smash> f7067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Smash> f7068d;
    private final List<Smash> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Smash> f7069f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.Kg$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class C0165a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f7070a;

            static {
                int[] iArr = new int[Gg.values().length];
                try {
                    iArr[Gg.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Gg.BIDDER_SENSITIVE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f7070a = iArr;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final <Smash extends AbstractC2547s3<?>> Kg<Smash> a(Gg loadingStrategy, int i2, boolean z2, List<? extends Smash> waterfall) {
            kotlin.jvm.internal.k.e(loadingStrategy, "loadingStrategy");
            kotlin.jvm.internal.k.e(waterfall, "waterfall");
            int i8 = C0165a.f7070a[loadingStrategy.ordinal()];
            if (i8 == 1) {
                return new N4(i2, z2, waterfall);
            }
            if (i8 != 2) {
                throw new e2.s(3);
            }
            return new C2649y3(i2, z2, waterfall, false, 8, null);
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Kg(int i2, boolean z2, List<? extends Smash> waterfall) {
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        this.f7065a = i2;
        this.f7066b = z2;
        this.f7067c = waterfall;
        this.f7068d = new ArrayList();
        this.e = new ArrayList();
        this.f7069f = new ArrayList();
    }

    private final boolean b(Smash smash) {
        return b() < a(smash);
    }

    public final List<Smash> a() {
        return this.f7069f;
    }

    public final List<Smash> c() {
        return this.f7068d;
    }

    public abstract void c(Smash smash);

    public final int d() {
        return this.f7069f.size() + this.e.size() + this.f7068d.size();
    }

    public boolean e() {
        return d() >= this.f7065a;
    }

    private final int a(Smash smash) {
        return smash.i().l();
    }

    public final void d(Smash smash) {
        kotlin.jvm.internal.k.e(smash, "smash");
        if (smash.x()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - smash " + smash.k() + " is failed to load");
            return;
        }
        if (smash.y()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is already loaded");
            this.e.add(smash);
            return;
        }
        if (smash.z()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " still loading");
            this.f7069f.add(smash);
            return;
        }
        if (smash.A().get()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " marked as loading candidate");
            this.f7069f.add(smash);
            return;
        }
        if (!this.f7066b || !b(smash)) {
            c(smash);
            return;
        }
        IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is not better than already loaded smashes");
    }

    private final int b() {
        Integer num;
        List<Smash> list = this.f7067c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AbstractC2547s3) obj).y()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(a((AbstractC2547s3) it.next()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(a((AbstractC2547s3) it.next()));
                if (numValueOf.compareTo(numValueOf2) > 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }
}

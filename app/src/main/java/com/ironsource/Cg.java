package com.ironsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<AbstractC2662z> f6414a;

    /* JADX WARN: Multi-variable type inference failed */
    public Cg(List<? extends AbstractC2662z> instances) {
        kotlin.jvm.internal.k.e(instances, "instances");
        this.f6414a = instances;
    }

    public final List<AbstractC2662z> a() {
        return this.f6414a;
    }

    public final List<AbstractC2662z> b() {
        return this.f6414a;
    }

    public final int c() {
        return this.f6414a.size();
    }

    public final String d() {
        ArrayList arrayList = new ArrayList();
        for (AbstractC2662z abstractC2662z : this.f6414a) {
            arrayList.add(a(abstractC2662z.h(), abstractC2662z.r()));
        }
        return r5.l.c1(arrayList, ",", null, null, null, 62);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cg) && kotlin.jvm.internal.k.a(this.f6414a, ((Cg) obj).f6414a);
    }

    public int hashCode() {
        return this.f6414a.hashCode();
    }

    public String toString() {
        return "WaterfallInstances(instances=" + this.f6414a + ")";
    }

    public final Cg a(List<? extends AbstractC2662z> instances) {
        kotlin.jvm.internal.k.e(instances, "instances");
        return new Cg(instances);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cg a(Cg cg, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = cg.f6414a;
        }
        return cg.a(list);
    }

    private final String a(C2461n2 c2461n2, int i2) {
        return String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), c2461n2.c()}, 2));
    }
}

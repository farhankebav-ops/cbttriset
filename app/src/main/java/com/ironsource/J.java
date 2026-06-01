package com.ironsource;

import com.ironsource.C2494p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<H> f6996b = new CopyOnWriteArrayList();

    public J(int i2) {
        this.f6995a = i2;
    }

    private final boolean b() {
        return this.f6995a == 0;
    }

    private final boolean c() {
        return this.f6995a != -1;
    }

    public final void a(H h) {
        if (b()) {
            return;
        }
        if (a()) {
            List<H> list = this.f6996b;
            kotlin.jvm.internal.k.e(list, "<this>");
            if (!list.isEmpty()) {
                list.remove(0);
            }
        }
        if (h == null) {
            h = new H(C2494p0.a.NotPartOfWaterfall);
        }
        this.f6996b.add(h);
    }

    public final String d() {
        List<H> list = this.f6996b;
        ArrayList arrayList = new ArrayList(r5.n.L0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((H) it.next()).b().ordinal()));
        }
        return r5.l.c1(arrayList, ",", null, null, null, 62);
    }

    private final boolean a() {
        return c() && this.f6996b.size() >= this.f6995a;
    }
}

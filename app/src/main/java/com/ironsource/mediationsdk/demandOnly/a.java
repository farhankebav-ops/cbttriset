package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.C2461n2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface a {

    /* JADX INFO: renamed from: com.ironsource.mediationsdk.demandOnly.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C0192a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<C2461n2> f9072a;

        public C0192a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public C2461n2 a(String instanceName) {
            Object next;
            kotlin.jvm.internal.k.e(instanceName, "instanceName");
            Iterator<T> it = this.f9072a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (kotlin.jvm.internal.k.a(((C2461n2) next).c(), instanceName)) {
                    break;
                }
            }
            return (C2461n2) next;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public String b() {
            return this.f9072a.isEmpty() ? "" : a1.a.l("1", ((C2461n2) r5.l.X0(this.f9072a)).c());
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public C2461n2 get(int i2) {
            if (i2 < 0 || i2 >= this.f9072a.size()) {
                return null;
            }
            return this.f9072a.get(i2);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public boolean isEmpty() {
            return this.f9072a.isEmpty();
        }

        public C0192a(List<C2461n2> waterfall) {
            kotlin.jvm.internal.k.e(waterfall, "waterfall");
            this.f9072a = waterfall;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public List<C2461n2> a() {
            return this.f9072a;
        }

        public /* synthetic */ C0192a(List list, int i2, kotlin.jvm.internal.f fVar) {
            this((i2 & 1) != 0 ? new ArrayList() : list);
        }
    }

    C2461n2 a(String str);

    List<C2461n2> a();

    String b();

    C2461n2 get(int i2);

    boolean isEmpty();
}

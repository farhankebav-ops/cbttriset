package com.ironsource;

import com.ironsource.C2593uf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.ironsource.cg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2276cg implements InterfaceC2363hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f8159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f8160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f8161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<AbstractC2345gd> f8162d;
    private final C2593uf e;

    /* JADX WARN: Multi-variable type inference failed */
    public C2276cg(C2459n0 adTools, Runnable task, long j, List<? extends AbstractC2345gd> pauseTriggers) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(task, "task");
        kotlin.jvm.internal.k.e(pauseTriggers, "pauseTriggers");
        this.f8159a = adTools;
        this.f8160b = task;
        this.f8161c = j;
        this.f8162d = pauseTriggers;
        this.e = new C2593uf(adTools.a(), new di(this, 1), j);
        for (AbstractC2345gd abstractC2345gd : pauseTriggers) {
            abstractC2345gd.a(this);
            if (abstractC2345gd.d()) {
                a(abstractC2345gd.b());
            }
        }
        if (a()) {
            C2593uf.a aVarA = this.e.a();
            List<AbstractC2345gd> list = this.f8162d;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((AbstractC2345gd) obj).d()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                long jC = ((AbstractC2345gd) next).c();
                do {
                    Object next2 = it.next();
                    long jC2 = ((AbstractC2345gd) next2).c();
                    if (jC > jC2) {
                        next = next2;
                        jC = jC2;
                    }
                } while (it.hasNext());
            }
            a(((AbstractC2345gd) next).b(), aVarA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2276cg this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.b();
    }

    @Override // com.ironsource.InterfaceC2363hd
    public void a(AbstractC2345gd pauseableTrigger) {
        kotlin.jvm.internal.k.e(pauseableTrigger, "pauseableTrigger");
        this.f8159a.d(new ei(this, pauseableTrigger, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2276cg this$0, AbstractC2345gd pauseableTrigger) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(pauseableTrigger, "$pauseableTrigger");
        this$0.a(pauseableTrigger.b());
        if (!this$0.a() || this$0.e.e()) {
            return;
        }
        this$0.a(pauseableTrigger.b(), this$0.e.a());
    }

    @Override // com.ironsource.InterfaceC2363hd
    public void b(AbstractC2345gd pauseableTrigger) {
        kotlin.jvm.internal.k.e(pauseableTrigger, "pauseableTrigger");
        this.f8159a.d(new ei(this, pauseableTrigger, 1));
    }

    public final void c() {
        this.f8159a.d(new di(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2276cg this$0, AbstractC2345gd pauseableTrigger) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(pauseableTrigger, "$pauseableTrigger");
        this$0.b(pauseableTrigger.b());
        if (this$0.a() || !this$0.e.e()) {
            return;
        }
        this$0.b(pauseableTrigger.b(), this$0.e.b());
    }

    private final void a(String str) {
        this.f8159a.e().h().d(str);
    }

    private final void a(String str, C2593uf.a aVar) {
        this.f8159a.e().h().a(str, this.f8161c, aVar.c(), aVar.d());
    }

    private final void b(String str) {
        this.f8159a.e().h().e(str);
    }

    private final void b(String str, C2593uf.a aVar) {
        this.f8159a.e().h().b(str, this.f8161c, aVar.c(), aVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2276cg this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Iterator<AbstractC2345gd> it = this$0.f8162d.iterator();
        while (it.hasNext()) {
            it.next().a((InterfaceC2363hd) null);
        }
        this$0.e.a();
    }

    private final void b() {
        c();
        this.f8160b.run();
    }

    private final boolean a() {
        List<AbstractC2345gd> list = this.f8162d;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((AbstractC2345gd) it.next()).d()) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ C2276cg(C2459n0 c2459n0, Runnable runnable, long j, List list, int i2, kotlin.jvm.internal.f fVar) {
        this(c2459n0, runnable, j, (i2 & 8) != 0 ? new ArrayList() : list);
    }
}

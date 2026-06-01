package c6;

import com.unity3d.services.core.network.domain.CleanupDirectory$invoke$$inlined$sortedBy$1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import r5.p;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements m6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4231a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4233c;

    public i(File start) {
        j jVar = j.f4234a;
        kotlin.jvm.internal.k.e(start, "start");
        this.f4232b = start;
        this.f4233c = jVar;
    }

    @Override // m6.h
    public final Iterator iterator() {
        switch (this.f4231a) {
            case 0:
                return new g(this);
            case 1:
                return new m6.g(this);
            default:
                m mVar = (m) this.f4232b;
                ArrayList arrayList = new ArrayList();
                Iterator it = ((Iterable) mVar.f4240b).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                p.N0(arrayList, (CleanupDirectory$invoke$$inlined$sortedBy$1) this.f4233c);
                return arrayList.iterator();
        }
    }

    public i(e6.a aVar, e6.l getNextValue) {
        kotlin.jvm.internal.k.e(getNextValue, "getNextValue");
        this.f4232b = aVar;
        this.f4233c = getNextValue;
    }

    public i(m mVar, CleanupDirectory$invoke$$inlined$sortedBy$1 cleanupDirectory$invoke$$inlined$sortedBy$1) {
        this.f4232b = mVar;
        this.f4233c = cleanupDirectory$invoke$$inlined$sortedBy$1;
    }
}

package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class R0 extends com.ironsource.mediationsdk.h {
    private final Map<String, J> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R0(List<? extends NetworkSettings> providers, int i2) {
        super(providers, i2);
        kotlin.jvm.internal.k.e(providers, "providers");
        int iD0 = r5.x.d0(r5.n.L0(providers, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0 < 16 ? 16 : iD0);
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(((NetworkSettings) it.next()).getProviderName(), new J(i2));
        }
        this.e = linkedHashMap;
    }

    public final void a(Cg waterfallInstances) {
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        List<AbstractC2662z> listB = waterfallInstances.b();
        int iD0 = r5.x.d0(r5.n.L0(listB, 10));
        if (iD0 < 16) {
            iD0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0);
        for (AbstractC2662z abstractC2662z : listB) {
            linkedHashMap.put(abstractC2662z.p(), abstractC2662z.s());
        }
        a(linkedHashMap);
    }

    @Override // com.ironsource.mediationsdk.h
    public String a(String instanceName) {
        String strD;
        kotlin.jvm.internal.k.e(instanceName, "instanceName");
        J j = this.e.get(instanceName);
        return (j == null || (strD = j.d()) == null) ? "" : strD;
    }

    private final void a(Map<String, H> map) {
        for (Map.Entry<String, J> entry : this.e.entrySet()) {
            entry.getValue().a(map.get(entry.getKey()));
        }
    }
}

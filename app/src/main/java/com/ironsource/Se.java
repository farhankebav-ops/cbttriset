package com.ironsource;

import com.ironsource.O8;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Se implements O8, O8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f7606a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Integer> f7607b = new HashMap();

    @Override // com.ironsource.O8.a
    public void a(List<? extends O8.b> smashes) {
        kotlin.jvm.internal.k.e(smashes, "smashes");
        for (O8.b bVar : smashes) {
            this.f7606a.put(bVar.c(), 0);
            this.f7607b.put(bVar.c(), Integer.valueOf(bVar.b()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.ironsource.O8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(com.ironsource.O8.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "smash"
            kotlin.jvm.internal.k.e(r3, r0)
            monitor-enter(r2)
            java.lang.String r0 = r3.c()     // Catch: java.lang.Throwable -> L29
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.f7606a     // Catch: java.lang.Throwable -> L29
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L2b
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.f7606a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Throwable -> L29
            kotlin.jvm.internal.k.b(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L29
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L29
            int r3 = r3.b()     // Catch: java.lang.Throwable -> L29
            if (r0 < r3) goto L2b
            r3 = 1
            goto L2c
        L29:
            r3 = move-exception
            goto L2e
        L2b:
            r3 = 0
        L2c:
            monitor-exit(r2)
            return r3
        L2e:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.Se.b(com.ironsource.O8$b):boolean");
    }

    @Override // com.ironsource.O8.a
    public void a(O8.b smash) {
        kotlin.jvm.internal.k.e(smash, "smash");
        synchronized (this) {
            String strC = smash.c();
            if (this.f7606a.containsKey(strC)) {
                Map<String, Integer> map = this.f7606a;
                Integer num = map.get(strC);
                kotlin.jvm.internal.k.b(num);
                map.put(strC, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    @Override // com.ironsource.O8
    public boolean a() {
        for (String str : this.f7607b.keySet()) {
            Integer num = this.f7606a.get(str);
            kotlin.jvm.internal.k.b(num);
            int iIntValue = num.intValue();
            Integer num2 = this.f7607b.get(str);
            kotlin.jvm.internal.k.b(num2);
            if (iIntValue < num2.intValue()) {
                return false;
            }
        }
        return true;
    }
}

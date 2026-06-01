package i4;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f11889b = new l(new j(2), j.f11874b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f11890a = new ConcurrentHashMap();

    public l(k... kVarArr) {
        for (k kVar : kVarArr) {
            this.f11890a.put(kVar.getMessageEncoding(), kVar);
        }
    }
}

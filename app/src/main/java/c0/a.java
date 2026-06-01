package c0;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4160a = new ConcurrentHashMap();

    public static synchronized void a(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        try {
            c cVar = (c) f4160a.remove(aVar.cl());
            if (cVar != null) {
                cVar.f4165c = true;
            }
            aVar.vCE();
            aVar.cl();
        } catch (Throwable th) {
            throw th;
        }
    }
}

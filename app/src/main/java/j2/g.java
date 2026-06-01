package j2;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class g {
    public static /* synthetic */ boolean a(Unsafe unsafe, p4.a aVar, long j, d dVar, d dVar2) {
        while (!unsafe.compareAndSwapObject(aVar, j, dVar, dVar2)) {
            if (unsafe.getObject(aVar, j) != dVar) {
                return false;
            }
        }
        return true;
    }
}

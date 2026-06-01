package j2;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ boolean a(Unsafe unsafe, m mVar, long j, l lVar, l lVar2) {
        while (!unsafe.compareAndSwapObject(mVar, j, lVar, lVar2)) {
            if (unsafe.getObject(mVar, j) != lVar) {
                return false;
            }
        }
        return true;
    }
}

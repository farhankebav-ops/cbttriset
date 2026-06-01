package j2;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ boolean a(Unsafe unsafe, m mVar, long j, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(mVar, j, obj, obj2)) {
            if (unsafe.getObject(mVar, j) != obj) {
                return false;
            }
        }
        return true;
    }
}

package androidx.datastore.core;

import e6.l;
import e6.p;
import t6.e;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface InterProcessCoordinator {
    e getUpdateNotifications();

    Object getVersion(c<? super Integer> cVar);

    Object incrementAndGetVersion(c<? super Integer> cVar);

    <T> Object lock(l lVar, c<? super T> cVar);

    <T> Object tryLock(p pVar, c<? super T> cVar);
}

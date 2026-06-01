package androidx.datastore.core;

import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface DataMigration<T> {
    Object cleanUp(c<? super x> cVar);

    Object migrate(T t3, c<? super T> cVar);

    Object shouldMigrate(T t3, c<? super Boolean> cVar);
}

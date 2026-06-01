package okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ boolean a(RoutePlanner routePlanner, RealConnection realConnection, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasNext");
        }
        if ((i2 & 1) != 0) {
            realConnection = null;
        }
        return routePlanner.hasNext(realConnection);
    }
}

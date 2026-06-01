package j2;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12088a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12089b = p4.a.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Logger f12090c;

    public final Logger a() {
        Logger logger = this.f12090c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f12088a) {
            try {
                Logger logger2 = this.f12090c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f12089b);
                this.f12090c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

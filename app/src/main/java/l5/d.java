package l5;

import com.ironsource.C2300e4;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f12824a;

    public d(Throwable th) {
        this.f12824a = th;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        Object obj2 = ((d) obj).f12824a;
        Throwable th = this.f12824a;
        if (th != obj2) {
            return th != null && th.equals(obj2);
        }
        return true;
    }

    public final int hashCode() {
        return this.f12824a.hashCode();
    }

    public final String toString() {
        return "NotificationLite.Error[" + this.f12824a + C2300e4.i.e;
    }
}

package i5;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12025a;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12025a) {
            case 0:
                ArrayList arrayList = new ArrayList(p.f12029d.keySet());
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) obj;
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        p.f12029d.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
                break;
        }
    }

    public String toString() {
        switch (this.f12025a) {
            case 1:
                return "EmptyRunnable";
            default:
                return super.toString();
        }
    }

    private final void a() {
    }
}

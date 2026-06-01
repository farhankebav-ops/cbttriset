package i5;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12013a = 0;

    public /* synthetic */ k(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ReentrantLock reentrantLock;
        l7.f fVarC;
        switch (this.f12013a) {
            case 1:
                break;
            default:
                super.run();
                return;
        }
        while (true) {
            try {
                l7.f.Companion.getClass();
                reentrantLock = l7.f.lock;
                reentrantLock.lock();
                try {
                    l7.f.Companion.getClass();
                    fVarC = l7.c.c();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
                continue;
            }
            if (fVarC == l7.f.head) {
                l7.c unused2 = l7.f.Companion;
                l7.f.head = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (fVarC != null) {
                    fVarC.timedOut();
                }
            }
        }
    }

    public /* synthetic */ k(String str) {
        super(str);
    }
}

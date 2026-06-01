package sg.bigo.ads.common.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.o.f;

/* JADX INFO: loaded from: classes6.dex */
class e implements ServiceConnection, IBinder.DeathRecipient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f15844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f15845d = new Object();
    private final Context e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f15847b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BlockingQueue<IBinder> f15846a = new LinkedBlockingQueue(1);

    private e(Context context) {
        this.e = context;
    }

    public static e a(Context context) {
        if (f15844c == null) {
            synchronized (e.class) {
                try {
                    if (f15844c == null) {
                        f15844c = new e(context);
                    }
                } finally {
                }
            }
        }
        return f15844c;
    }

    private void b() {
        try {
            synchronized (f15845d) {
                this.f15846a.clear();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        a();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        a();
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        b();
    }

    public final f a(long j, TimeUnit timeUnit) {
        try {
            IBinder iBinderPoll = this.f15846a.poll(j, timeUnit);
            if (iBinderPoll == null) {
                return null;
            }
            a(iBinderPoll);
            return f.a.a(iBinderPoll);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public final synchronized void a() {
        if (this.f15847b) {
            try {
                this.f15847b = false;
                b();
                this.e.unbindService(this);
            } catch (Exception unused) {
            }
        }
    }

    private void a(IBinder iBinder) {
        try {
            synchronized (f15845d) {
                this.f15846a.clear();
                this.f15846a.add(iBinder);
            }
        } catch (Exception unused) {
        }
    }
}

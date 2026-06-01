package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Z5 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Pc> f7895a;

    public Z5(Looper looper) {
        super(looper);
        this.f7895a = new ConcurrentHashMap<>();
    }

    private boolean a(int i2) {
        return i2 == 1016 || i2 == 1015;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            C8 c8 = (C8) message.obj;
            String path = c8.getPath();
            Pc pc = this.f7895a.get(path);
            if (pc == null) {
                return;
            }
            if (a(message.what)) {
                pc.a(c8);
            } else {
                int i2 = message.what;
                pc.a(c8, new C2586u8(i2, C2419kg.a(i2)));
            }
            this.f7895a.remove(path);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void a(String str, Pc pc) {
        if (str == null || pc == null) {
            return;
        }
        this.f7895a.put(str, pc);
    }
}

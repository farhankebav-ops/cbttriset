package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;

/* JADX INFO: renamed from: com.ironsource.i5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class HandlerC2373i5 extends Handler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8713b = "DownloadHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Pc f8714a;

    public HandlerC2373i5(Looper looper) {
        super(looper);
    }

    public void a(Pc pc) {
        if (pc == null) {
            throw new IllegalArgumentException();
        }
        this.f8714a = pc;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Pc pc = this.f8714a;
        if (pc == null) {
            Logger.i(f8713b, "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            int i2 = message.what;
            if (i2 == 1016) {
                pc.a((C8) message.obj);
            } else {
                this.f8714a.a((C8) message.obj, new C2586u8(i2, C2419kg.a(i2)));
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            Logger.i(f8713b, "handleMessage | Got exception: " + th.getMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void a() {
        this.f8714a = null;
    }
}

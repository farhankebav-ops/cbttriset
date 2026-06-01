package sg.bigo.ads.common.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15809a;

    public b(String str, Looper looper) {
        super(looper);
        this.f15809a = str;
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message message, long j) {
        return super.sendMessageAtTime(message, j);
    }

    @Override // android.os.Handler
    public final String toString() {
        return a1.a.r(new StringBuilder("HandlerEx ("), this.f15809a, ") {}");
    }
}

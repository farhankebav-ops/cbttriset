package y1;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            message.obj.getClass();
            throw new ClassCastException();
        }
        if (i2 != 1) {
            return false;
        }
        message.obj.getClass();
        throw new ClassCastException();
    }
}

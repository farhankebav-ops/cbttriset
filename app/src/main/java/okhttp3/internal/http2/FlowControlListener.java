package okhttp3.internal.http2;

import kotlin.jvm.internal.k;
import okhttp3.internal.http2.flowcontrol.WindowCounter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface FlowControlListener {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class None implements FlowControlListener {
        public static final None INSTANCE = new None();

        private None() {
        }

        @Override // okhttp3.internal.http2.FlowControlListener
        public void receivingConnectionWindowChanged(WindowCounter windowCounter) {
            k.e(windowCounter, "windowCounter");
        }

        @Override // okhttp3.internal.http2.FlowControlListener
        public void receivingStreamWindowChanged(int i2, WindowCounter windowCounter, long j) {
            k.e(windowCounter, "windowCounter");
        }
    }

    void receivingConnectionWindowChanged(WindowCounter windowCounter);

    void receivingStreamWindowChanged(int i2, WindowCounter windowCounter, long j);
}

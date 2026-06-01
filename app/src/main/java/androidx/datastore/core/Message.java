package androidx.datastore.core;

import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.q;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Message<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super(null);
            this.lastState = state;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Update<T> extends Message<T> {
        private final q ack;
        private final h callerContext;
        private final State<T> lastState;
        private final p transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(p transform, q ack, State<T> state, h callerContext) {
            super(null);
            k.e(transform, "transform");
            k.e(ack, "ack");
            k.e(callerContext, "callerContext");
            this.transform = transform;
            this.ack = ack;
            this.lastState = state;
            this.callerContext = callerContext;
        }

        public final q getAck() {
            return this.ack;
        }

        public final h getCallerContext() {
            return this.callerContext;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }

        public final p getTransform() {
            return this.transform;
        }
    }

    public /* synthetic */ Message(f fVar) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }
}

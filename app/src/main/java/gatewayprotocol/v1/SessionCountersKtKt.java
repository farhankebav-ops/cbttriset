package gatewayprotocol.v1;

import gatewayprotocol.v1.SessionCountersKt;
import gatewayprotocol.v1.SessionCountersOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionCountersKtKt {
    /* JADX INFO: renamed from: -initializesessionCounters, reason: not valid java name */
    public static final SessionCountersOuterClass.SessionCounters m3431initializesessionCounters(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.Companion;
        SessionCountersOuterClass.SessionCounters.Builder builderNewBuilder = SessionCountersOuterClass.SessionCounters.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        SessionCountersKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final SessionCountersOuterClass.SessionCounters copy(SessionCountersOuterClass.SessionCounters sessionCounters, e6.l block) {
        kotlin.jvm.internal.k.e(sessionCounters, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.Companion;
        SessionCountersOuterClass.SessionCounters.Builder builder = sessionCounters.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        SessionCountersKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}

package j4;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u2 {
    public static final e2.f g = new e2.f("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo", 3, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f12486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f12487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f12488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f12489d;
    public final o4 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h1 f12490f;

    public u2(Map map, boolean z2, int i2, int i8) {
        long j;
        boolean z7;
        o4 o4Var;
        h1 h1Var;
        this.f12486a = x1.i("timeout", map);
        this.f12487b = x1.b("waitForReady", map);
        Integer numF = x1.f("maxResponseMessageBytes", map);
        this.f12488c = numF;
        if (numF != null) {
            r2.q.w(numF, "maxInboundMessageSize %s exceeds bounds", numF.intValue() >= 0);
        }
        Integer numF2 = x1.f("maxRequestMessageBytes", map);
        this.f12489d = numF2;
        if (numF2 != null) {
            r2.q.w(numF2, "maxOutboundMessageSize %s exceeds bounds", numF2.intValue() >= 0);
        }
        Map mapG = z2 ? x1.g("retryPolicy", map) : null;
        if (mapG == null) {
            j = 0;
            o4Var = null;
            z7 = true;
        } else {
            Integer numF3 = x1.f("maxAttempts", mapG);
            r2.q.D(numF3, "maxAttempts cannot be empty");
            int iIntValue = numF3.intValue();
            r2.q.v(iIntValue, "maxAttempts must be greater than 1: %s", iIntValue >= 2);
            int iMin = Math.min(iIntValue, i2);
            Long lI = x1.i("initialBackoff", mapG);
            r2.q.D(lI, "initialBackoff cannot be empty");
            long jLongValue = lI.longValue();
            r2.q.z(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            Long lI2 = x1.i("maxBackoff", mapG);
            r2.q.D(lI2, "maxBackoff cannot be empty");
            long jLongValue2 = lI2.longValue();
            j = 0;
            z7 = true;
            r2.q.z(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double dE = x1.e("backoffMultiplier", mapG);
            r2.q.D(dE, "backoffMultiplier cannot be empty");
            double dDoubleValue = dE.doubleValue();
            r2.q.w(dE, "backoffMultiplier must be greater than 0: %s", dDoubleValue > 0.0d);
            Long lI3 = x1.i("perAttemptRecvTimeout", mapG);
            r2.q.w(lI3, "perAttemptRecvTimeout cannot be negative: %s", lI3 == null || lI3.longValue() >= 0);
            Set setF = z4.f("retryableStatusCodes", mapG);
            n7.b.V("retryableStatusCodes", "%s is required in retry policy", setF != null);
            n7.b.V("retryableStatusCodes", "%s must not contain OK", !setF.contains(i4.m1.OK));
            r2.q.y((lI3 == null && setF.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            o4Var = new o4(iMin, jLongValue, jLongValue2, dDoubleValue, lI3, setF);
        }
        this.e = o4Var;
        Map mapG2 = z2 ? x1.g("hedgingPolicy", map) : null;
        if (mapG2 == null) {
            h1Var = null;
        } else {
            Integer numF4 = x1.f("maxAttempts", mapG2);
            r2.q.D(numF4, "maxAttempts cannot be empty");
            int iIntValue2 = numF4.intValue();
            r2.q.v(iIntValue2, "maxAttempts must be greater than 1: %s", iIntValue2 >= 2 ? z7 : false);
            int iMin2 = Math.min(iIntValue2, i8);
            Long lI4 = x1.i("hedgingDelay", mapG2);
            r2.q.D(lI4, "hedgingDelay cannot be empty");
            long jLongValue3 = lI4.longValue();
            r2.q.z(jLongValue3 >= j ? z7 : false, "hedgingDelay must not be negative: %s", jLongValue3);
            Set setF2 = z4.f("nonFatalStatusCodes", mapG2);
            if (setF2 == null) {
                setF2 = Collections.unmodifiableSet(EnumSet.noneOf(i4.m1.class));
            } else {
                n7.b.V("nonFatalStatusCodes", "%s must not contain OK", !setF2.contains(i4.m1.OK));
            }
            h1Var = new h1(iMin2, jLongValue3, setF2);
        }
        this.f12490f = h1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u2)) {
            return false;
        }
        u2 u2Var = (u2) obj;
        return Objects.equals(this.f12486a, u2Var.f12486a) && Objects.equals(this.f12487b, u2Var.f12487b) && Objects.equals(this.f12488c, u2Var.f12488c) && Objects.equals(this.f12489d, u2Var.f12489d) && Objects.equals(this.e, u2Var.e) && Objects.equals(this.f12490f, u2Var.f12490f);
    }

    public final int hashCode() {
        return Objects.hash(this.f12486a, this.f12487b, this.f12488c, this.f12489d, this.e, this.f12490f);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12486a, "timeoutNanos");
        iVarY.c(this.f12487b, "waitForReady");
        iVarY.c(this.f12488c, "maxInboundMessageSize");
        iVarY.c(this.f12489d, "maxOutboundMessageSize");
        iVarY.c(this.e, "retryPolicy");
        iVarY.c(this.f12490f, "hedgingPolicy");
        return iVarY.toString();
    }
}

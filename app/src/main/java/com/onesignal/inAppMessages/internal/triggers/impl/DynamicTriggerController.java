package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DynamicTriggerController implements IEventNotifier<ITriggerHandler> {
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_LAST_IN_APP_TIME_AGO = 999999;
    private static final double REQUIRED_ACCURACY = 0.3d;
    private final ISessionService _session;
    private final InAppStateService _state;
    private final ITime _time;
    private final EventProducer<ITriggerHandler> events;
    private final List<String> scheduledMessages;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Trigger.OSTriggerKind.values().length];
            iArr[Trigger.OSTriggerKind.SESSION_TIME.ordinal()] = 1;
            iArr[Trigger.OSTriggerKind.TIME_SINCE_LAST_IN_APP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Trigger.OSTriggerOperator.values().length];
            iArr2[Trigger.OSTriggerOperator.LESS_THAN.ordinal()] = 1;
            iArr2[Trigger.OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 2;
            iArr2[Trigger.OSTriggerOperator.GREATER_THAN.ordinal()] = 3;
            iArr2[Trigger.OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 4;
            iArr2[Trigger.OSTriggerOperator.EQUAL_TO.ordinal()] = 5;
            iArr2[Trigger.OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DynamicTriggerController(InAppStateService _state, ISessionService _session, ITime _time) {
        k.e(_state, "_state");
        k.e(_session, "_session");
        k.e(_time, "_time");
        this._state = _state;
        this._session = _session;
        this._time = _time;
        this.events = new EventProducer<>();
        this.scheduledMessages = new ArrayList();
    }

    private final boolean evaluateTimeIntervalWithOperator(double d8, double d9, Trigger.OSTriggerOperator oSTriggerOperator) {
        switch (WhenMappings.$EnumSwitchMapping$1[oSTriggerOperator.ordinal()]) {
            case 1:
                return d9 < d8;
            case 2:
                return d9 <= d8 || roughlyEqual(d8, d9);
            case 3:
                return d9 >= d8;
            case 4:
                return d9 >= d8 || roughlyEqual(d8, d9);
            case 5:
                return roughlyEqual(d8, d9);
            case 6:
                return !roughlyEqual(d8, d9);
            default:
                Logging.error$default("Attempted to apply an invalid operator on a time-based in-app-message trigger: " + oSTriggerOperator, null, 2, null);
                return false;
        }
    }

    private final boolean roughlyEqual(double d8, double d9) {
        return Math.abs(d8 - d9) < REQUIRED_ACCURACY;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:7:0x0014, B:11:0x001e, B:29:0x0067, B:31:0x0089, B:38:0x009c, B:42:0x00a6, B:16:0x0034, B:20:0x003e, B:23:0x004a, B:28:0x0065, B:27:0x0059), top: B:47:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dynamicTriggerShouldFire(com.onesignal.inAppMessages.internal.Trigger r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "trigger"
            r2 = r17
            kotlin.jvm.internal.k.e(r2, r0)
            java.lang.Object r0 = r2.getValue()
            r7 = 0
            if (r0 != 0) goto L11
            return r7
        L11:
            java.util.List<java.lang.String> r8 = r1.scheduledMessages
            monitor-enter(r8)
            java.lang.Object r0 = r2.getValue()     // Catch: java.lang.Throwable -> L57
            boolean r0 = r0 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L1e
            monitor-exit(r8)
            return r7
        L1e:
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r0 = r2.getKind()     // Catch: java.lang.Throwable -> L57
            int[] r3 = com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> L57
            int r0 = r0.ordinal()     // Catch: java.lang.Throwable -> L57
            r0 = r3[r0]     // Catch: java.lang.Throwable -> L57
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L59
            r3 = 2
            if (r0 == r3) goto L34
            r12 = r10
            goto L67
        L34:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r1._state     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = r0.getInAppMessageIdShowing()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L3e
            monitor-exit(r8)
            return r7
        L3e:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r1._state     // Catch: java.lang.Throwable -> L57
            java.lang.Long r0 = r0.getLastTimeInAppDismissed()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L4a
            r3 = 999999(0xf423f, double:4.94065E-318)
            goto L55
        L4a:
            com.onesignal.core.internal.time.ITime r3 = r1._time     // Catch: java.lang.Throwable -> L57
            long r3 = r3.getCurrentTimeMillis()     // Catch: java.lang.Throwable -> L57
            long r5 = r0.longValue()     // Catch: java.lang.Throwable -> L57
            goto L65
        L55:
            r12 = r3
            goto L67
        L57:
            r0 = move-exception
            goto Lb7
        L59:
            com.onesignal.core.internal.time.ITime r0 = r1._time     // Catch: java.lang.Throwable -> L57
            long r3 = r0.getCurrentTimeMillis()     // Catch: java.lang.Throwable -> L57
            com.onesignal.session.internal.session.ISessionService r0 = r1._session     // Catch: java.lang.Throwable -> L57
            long r5 = r0.getStartTime()     // Catch: java.lang.Throwable -> L57
        L65:
            long r3 = r3 - r5
            goto L55
        L67:
            java.lang.String r0 = r2.getTriggerId()     // Catch: java.lang.Throwable -> L57
            java.lang.Object r3 = r2.getValue()     // Catch: java.lang.Throwable -> L57
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Throwable -> L57
            kotlin.jvm.internal.k.b(r3)     // Catch: java.lang.Throwable -> L57
            double r3 = r3.doubleValue()     // Catch: java.lang.Throwable -> L57
            r5 = 1000(0x3e8, float:1.401E-42)
            double r5 = (double) r5     // Catch: java.lang.Throwable -> L57
            double r3 = r3 * r5
            long r14 = (long) r3     // Catch: java.lang.Throwable -> L57
            double r2 = (double) r14     // Catch: java.lang.Throwable -> L57
            double r4 = (double) r12     // Catch: java.lang.Throwable -> L57
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerOperator r6 = r17.getOperatorType()     // Catch: java.lang.Throwable -> L57
            boolean r2 = r1.evaluateTimeIntervalWithOperator(r2, r4, r6)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L95
            com.onesignal.common.events.EventProducer<com.onesignal.inAppMessages.internal.triggers.ITriggerHandler> r2 = r1.events     // Catch: java.lang.Throwable -> L57
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$1 r3 = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$1     // Catch: java.lang.Throwable -> L57
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L57
            r2.fire(r3)     // Catch: java.lang.Throwable -> L57
            monitor-exit(r8)
            return r9
        L95:
            long r14 = r14 - r12
            int r2 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r2 > 0) goto L9c
            monitor-exit(r8)
            return r7
        L9c:
            java.util.List<java.lang.String> r2 = r1.scheduledMessages     // Catch: java.lang.Throwable -> L57
            boolean r2 = r2.contains(r0)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto La6
            monitor-exit(r8)
            return r7
        La6:
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerTimer r2 = com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerTimer.INSTANCE     // Catch: java.lang.Throwable -> L57
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$2 r3 = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$2     // Catch: java.lang.Throwable -> L57
            r3.<init>()     // Catch: java.lang.Throwable -> L57
            r2.scheduleTrigger(r3, r0, r14)     // Catch: java.lang.Throwable -> L57
            java.util.List<java.lang.String> r2 = r1.scheduledMessages     // Catch: java.lang.Throwable -> L57
            r2.add(r0)     // Catch: java.lang.Throwable -> L57
            monitor-exit(r8)
            return r7
        Lb7:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire(com.onesignal.inAppMessages.internal.Trigger):boolean");
    }

    public final EventProducer<ITriggerHandler> getEvents() {
        return this.events;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ITriggerHandler handler) {
        k.e(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ITriggerHandler handler) {
        k.e(handler, "handler");
        this.events.unsubscribe(handler);
    }
}

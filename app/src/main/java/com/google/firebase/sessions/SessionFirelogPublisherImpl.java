package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import v5.h;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    public static final Companion Companion = new Companion(null);
    private static final double randomValueForSampling = Math.random();
    private final h backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$mayLogSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$mayLogSession$1", f = "SessionFirelogPublisher.kt", l = {70, 71, 77}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ SessionDetails $sessionDetails;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SessionDetails sessionDetails, v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$sessionDetails = sessionDetails;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return SessionFirelogPublisherImpl.this.new AnonymousClass1(this.$sessionDetails, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L43
                if (r1 == r4) goto L3f
                if (r1 == r3) goto L3b
                if (r1 != r2) goto L33
                java.lang.Object r0 = r8.L$5
                com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
                java.lang.Object r1 = r8.L$4
                com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
                java.lang.Object r2 = r8.L$3
                com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
                java.lang.Object r3 = r8.L$2
                com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
                java.lang.Object r4 = r8.L$1
                com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
                java.lang.Object r5 = r8.L$0
                com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
                r2.q.z0(r9)
                r7 = r3
                r3 = r0
                r0 = r7
                r7 = r2
                r2 = r1
                r1 = r7
            L30:
                r7 = r4
                goto L9b
            L33:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L3b:
                r2.q.z0(r9)
                goto L6a
            L3f:
                r2.q.z0(r9)
                goto L51
            L43:
                r2.q.z0(r9)
                com.google.firebase.sessions.SessionFirelogPublisherImpl r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                r8.label = r4
                java.lang.Object r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$shouldLogSession(r9, r8)
                if (r9 != r0) goto L51
                goto L93
            L51:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto Lae
                com.google.firebase.sessions.InstallationId$Companion r9 = com.google.firebase.sessions.InstallationId.Companion
                com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                com.google.firebase.installations.FirebaseInstallationsApi r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseInstallations$p(r1)
                r8.label = r3
                java.lang.Object r9 = r9.create(r1, r8)
                if (r9 != r0) goto L6a
                goto L93
            L6a:
                r5 = r9
                com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
                com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.INSTANCE
                com.google.firebase.FirebaseApp r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseApp$p(r4)
                com.google.firebase.sessions.SessionDetails r1 = r8.$sessionDetails
                com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getSessionSettings$p(r6)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
                r8.L$0 = r5
                r8.L$1 = r4
                r8.L$2 = r3
                r8.L$3 = r9
                r8.L$4 = r1
                r8.L$5 = r6
                r8.label = r2
                java.lang.Object r2 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r8)
                if (r2 != r0) goto L94
            L93:
                return r0
            L94:
                r0 = r1
                r1 = r9
                r9 = r2
                r2 = r0
                r0 = r3
                r3 = r6
                goto L30
            L9b:
                r4 = r9
                java.util.Map r4 = (java.util.Map) r4
                r9 = r5
                java.lang.String r5 = r9.getFid()
                java.lang.String r6 = r9.getAuthToken()
                com.google.firebase.sessions.SessionEvent r9 = r0.buildSession(r1, r2, r3, r4, r5, r6)
                com.google.firebase.sessions.SessionFirelogPublisherImpl.access$attemptLoggingSessionEvent(r7, r9)
            Lae:
                q5.x r9 = q5.x.f13520a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {98, 104}, m = "shouldLogSession")
    public static final class C22181 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C22181(v5.c<? super C22181> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.shouldLogSession(this);
        }
    }

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, @Background h backgroundDispatcher) {
        k.e(firebaseApp, "firebaseApp");
        k.e(firebaseInstallations, "firebaseInstallations");
        k.e(sessionSettings, "sessionSettings");
        k.e(eventGDTLogger, "eventGDTLogger");
        k.e(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
            Log.d(FirebaseSessions.TAG, "Successfully logged Session Start event.");
        } catch (RuntimeException e) {
            Log.e(FirebaseSessions.TAG, "Error logging Session Start event to DataTransport: ", e);
        }
    }

    private final boolean shouldCollectEvents() {
        return randomValueForSampling <= this.sessionSettings.getSamplingRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object shouldLogSession(v5.c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl.C22181
            if (r0 == 0) goto L13
            r0 = r7
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl.C22181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            java.lang.String r5 = "FirebaseSessions"
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionFirelogPublisherImpl r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r0
            r2.q.z0(r7)
            goto L84
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.SessionFirelogPublisherImpl r2 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r2
            r2.q.z0(r7)
            goto L51
        L40:
            r2.q.z0(r7)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r0)
            if (r7 != r1) goto L50
            goto L82
        L50:
            r2 = r6
        L51:
            java.util.Map r7 = (java.util.Map) r7
            java.util.Collection r7 = r7.values()
            if (r7 == 0) goto L60
            boolean r4 = r7.isEmpty()
            if (r4 == 0) goto L60
            goto La5
        L60:
            java.util.Iterator r7 = r7.iterator()
        L64:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto La5
            java.lang.Object r4 = r7.next()
            com.google.firebase.sessions.api.SessionSubscriber r4 = (com.google.firebase.sessions.api.SessionSubscriber) r4
            boolean r4 = r4.isDataCollectionEnabled()
            if (r4 == 0) goto L64
            com.google.firebase.sessions.settings.SessionsSettings r7 = r2.sessionSettings
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.updateSettings(r0)
            if (r7 != r1) goto L83
        L82:
            return r1
        L83:
            r0 = r2
        L84:
            com.google.firebase.sessions.settings.SessionsSettings r7 = r0.sessionSettings
            boolean r7 = r7.getSessionsEnabled()
            if (r7 != 0) goto L94
            java.lang.String r7 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r5, r7)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L94:
            boolean r7 = r0.shouldCollectEvents()
            if (r7 != 0) goto La2
            java.lang.String r7 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r5, r7)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        La2:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        La5:
            java.lang.String r7 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r5, r7)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.shouldLogSession(v5.c):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void mayLogSession(SessionDetails sessionDetails) {
        k.e(sessionDetails, "sessionDetails");
        c0.u(c0.b(this.backgroundDispatcher), null, new AnonymousClass1(sessionDetails, null), 3);
    }
}

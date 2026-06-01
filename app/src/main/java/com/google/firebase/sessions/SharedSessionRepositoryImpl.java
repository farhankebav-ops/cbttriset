package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.DataStore;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import e6.q;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import t6.f;
import t6.s;
import v5.h;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SharedSessionRepositoryImpl implements SharedSessionRepository {
    private final h backgroundDispatcher;
    private boolean isInForeground;
    public SessionData localSessionData;
    private NotificationType previousNotificationType;
    private String previousSessionId;
    private final ProcessDataManager processDataManager;
    private final DataStore<SessionData> sessionDataStore;
    private final SessionFirelogPublisher sessionFirelogPublisher;
    private final SessionGenerator sessionGenerator;
    private final SessionsSettings sessionsSettings;
    private final TimeProvider timeProvider;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$1", f = "SharedSessionRepository.kt", l = {94}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$1$1", f = "SharedSessionRepository.kt", l = {92}, m = "invokeSuspend")
        public static final class C01401 extends i implements q {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ SharedSessionRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01401(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, v5.c<? super C01401> cVar) {
                super(3, cVar);
                this.this$0 = sharedSessionRepositoryImpl;
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    r2.q.z0(obj);
                    f fVar = (f) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    SessionData sessionData = new SessionData(this.this$0.sessionGenerator.generateNewSession(null), (Time) null, (Map) null, 4, (kotlin.jvm.internal.f) null);
                    Log.d(FirebaseSessions.TAG, "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + sessionData.getSessionDetails().getSessionId());
                    this.L$0 = null;
                    this.label = 1;
                    if (fVar.emit(sessionData, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return x.f13520a;
            }

            @Override // e6.q
            public final Object invoke(f fVar, Throwable th, v5.c<? super x> cVar) {
                C01401 c01401 = new C01401(this.this$0, cVar);
                c01401.L$0 = fVar;
                c01401.L$1 = th;
                return c01401.invokeSuspend(x.f13520a);
            }
        }

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return SharedSessionRepositoryImpl.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                s sVar = new s(SharedSessionRepositoryImpl.this.sessionDataStore.getData(), new C01401(SharedSessionRepositoryImpl.this, null));
                final SharedSessionRepositoryImpl sharedSessionRepositoryImpl = SharedSessionRepositoryImpl.this;
                f fVar = new f() { // from class: com.google.firebase.sessions.SharedSessionRepositoryImpl.1.2
                    @Override // t6.f
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, v5.c cVar) {
                        return emit((SessionData) obj2, (v5.c<? super x>) cVar);
                    }

                    public final Object emit(SessionData sessionData, v5.c<? super x> cVar) throws Throwable {
                        sharedSessionRepositoryImpl.setLocalSessionData$com_google_firebase_firebase_sessions(sessionData);
                        Object objNotifySubscribers = sharedSessionRepositoryImpl.notifySubscribers(sessionData.getSessionDetails().getSessionId(), NotificationType.GENERAL, cVar);
                        return objNotifySubscribers == w5.a.f17774a ? objNotifySubscribers : x.f13520a;
                    }
                };
                this.label = 1;
                if (sVar.collect(fVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NotificationType {
        private static final /* synthetic */ y5.a $ENTRIES;
        private static final /* synthetic */ NotificationType[] $VALUES;
        public static final NotificationType GENERAL = new NotificationType("GENERAL", 0);
        public static final NotificationType FALLBACK = new NotificationType("FALLBACK", 1);

        private static final /* synthetic */ NotificationType[] $values() {
            return new NotificationType[]{GENERAL, FALLBACK};
        }

        static {
            NotificationType[] notificationTypeArr$values = $values();
            $VALUES = notificationTypeArr$values;
            $ENTRIES = n7.b.n(notificationTypeArr$values);
        }

        private NotificationType(String str, int i2) {
        }

        public static y5.a getEntries() {
            return $ENTRIES;
        }

        public static NotificationType valueOf(String str) {
            return (NotificationType) Enum.valueOf(NotificationType.class, str);
        }

        public static NotificationType[] values() {
            return (NotificationType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationType.values().length];
            try {
                iArr[NotificationType.GENERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationType.FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1", f = "SharedSessionRepository.kt", l = {112}, m = "invokeSuspend")
    public static final class C22191 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1$1", f = "SharedSessionRepository.kt", l = {}, m = "invokeSuspend")
        public static final class C01411 extends i implements p {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SharedSessionRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01411(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, v5.c<? super C01411> cVar) {
                super(2, cVar);
                this.this$0 = sharedSessionRepositoryImpl;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                C01411 c01411 = new C01411(this.this$0, cVar);
                c01411.L$0 = obj;
                return c01411;
            }

            @Override // e6.p
            public final Object invoke(SessionData sessionData, v5.c<? super SessionData> cVar) {
                return ((C01411) create(sessionData, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                return SessionData.copy$default((SessionData) this.L$0, null, this.this$0.timeProvider.currentTime(), null, 5, null);
            }
        }

        public C22191(v5.c<? super C22191> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return SharedSessionRepositoryImpl.this.new C22191(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    r2.q.z0(obj);
                    DataStore dataStore = SharedSessionRepositoryImpl.this.sessionDataStore;
                    C01411 c01411 = new C01411(SharedSessionRepositoryImpl.this, null);
                    this.label = 1;
                    if (dataStore.updateData(c01411, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
            } catch (Exception e) {
                Log.d(FirebaseSessions.TAG, "App backgrounded, failed to update data. Message: " + e.getMessage());
                SharedSessionRepositoryImpl sharedSessionRepositoryImpl = SharedSessionRepositoryImpl.this;
                sharedSessionRepositoryImpl.setLocalSessionData$com_google_firebase_firebase_sessions(SessionData.copy$default(sharedSessionRepositoryImpl.getLocalSessionData$com_google_firebase_firebase_sessions(), null, SharedSessionRepositoryImpl.this.timeProvider.currentTime(), null, 5, null));
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((C22191) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1", f = "SharedSessionRepository.kt", l = {Sdk.SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE, 186}, m = "invokeSuspend")
    public static final class C22201 extends i implements p {
        final /* synthetic */ SessionData $sessionData;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1", f = "SharedSessionRepository.kt", l = {}, m = "invokeSuspend")
        public static final class C01421 extends i implements p {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SharedSessionRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01421(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, v5.c<? super C01421> cVar) {
                super(2, cVar);
                this.this$0 = sharedSessionRepositoryImpl;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                C01421 c01421 = new C01421(this.this$0, cVar);
                c01421.L$0 = obj;
                return c01421;
            }

            @Override // e6.p
            public final Object invoke(SessionData sessionData, v5.c<? super SessionData> cVar) {
                return ((C01421) create(sessionData, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                SessionData sessionData = (SessionData) this.L$0;
                boolean zIsSessionExpired = this.this$0.isSessionExpired(sessionData);
                boolean zIsColdStart = this.this$0.isColdStart(sessionData);
                boolean zIsMyProcessStale = this.this$0.isMyProcessStale(sessionData);
                Map<String, ProcessData> mapGenerateProcessDataMap = zIsColdStart ? this.this$0.processDataManager.generateProcessDataMap() : zIsMyProcessStale ? this.this$0.processDataManager.updateProcessDataMap(sessionData.getProcessDataMap()) : sessionData.getProcessDataMap();
                SessionDetails sessionDetails = zIsColdStart ? null : sessionData.getSessionDetails();
                if (!zIsSessionExpired && !zIsColdStart) {
                    return zIsMyProcessStale ? SessionData.copy$default(sessionData, null, null, this.this$0.processDataManager.updateProcessDataMap(mapGenerateProcessDataMap), 3, null) : sessionData;
                }
                SessionDetails sessionDetailsGenerateNewSession = this.this$0.sessionGenerator.generateNewSession(sessionDetails);
                this.this$0.sessionFirelogPublisher.mayLogSession(sessionDetailsGenerateNewSession);
                this.this$0.processDataManager.onSessionGenerated();
                return sessionData.copy(sessionDetailsGenerateNewSession, null, mapGenerateProcessDataMap);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22201(SessionData sessionData, v5.c<? super C22201> cVar) {
            super(2, cVar);
            this.$sessionData = sessionData;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return SharedSessionRepositoryImpl.this.new C22201(this.$sessionData, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        
            if (r10.updateData(r0, r9) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
        
            if (r10.notifySubscribers(r0, r3, r9) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
        
            return r1;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                w5.a r1 = w5.a.f17774a
                int r0 = r9.label
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L21
                if (r0 == r3) goto L19
                if (r0 != r2) goto L11
                r2.q.z0(r10)
                goto L95
            L11:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L19:
                r2.q.z0(r10)     // Catch: java.lang.Exception -> L1e
                goto L95
            L1e:
                r0 = move-exception
                r10 = r0
                goto L3b
            L21:
                r2.q.z0(r10)
                com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this     // Catch: java.lang.Exception -> L1e
                androidx.datastore.core.DataStore r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.access$getSessionDataStore$p(r10)     // Catch: java.lang.Exception -> L1e
                com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1 r0 = new com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1     // Catch: java.lang.Exception -> L1e
                com.google.firebase.sessions.SharedSessionRepositoryImpl r4 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this     // Catch: java.lang.Exception -> L1e
                r5 = 0
                r0.<init>(r4, r5)     // Catch: java.lang.Exception -> L1e
                r9.label = r3     // Catch: java.lang.Exception -> L1e
                java.lang.Object r10 = r10.updateData(r0, r9)     // Catch: java.lang.Exception -> L1e
                if (r10 != r1) goto L95
                goto L94
            L3b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r3 = "App foregrounded, failed to update data. Message: "
                r0.<init>(r3)
                java.lang.String r10 = r10.getMessage()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "FirebaseSessions"
                android.util.Log.d(r0, r10)
                com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this
                com.google.firebase.sessions.SessionData r0 = r9.$sessionData
                boolean r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.access$isSessionExpired(r10, r0)
                if (r10 == 0) goto L95
                com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this
                com.google.firebase.sessions.SessionGenerator r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.access$getSessionGenerator$p(r10)
                com.google.firebase.sessions.SessionData r0 = r9.$sessionData
                com.google.firebase.sessions.SessionDetails r0 = r0.getSessionDetails()
                com.google.firebase.sessions.SessionDetails r4 = r10.generateNewSession(r0)
                com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this
                com.google.firebase.sessions.SessionData r3 = r9.$sessionData
                r7 = 4
                r8 = 0
                r5 = 0
                r6 = 0
                com.google.firebase.sessions.SessionData r0 = com.google.firebase.sessions.SessionData.copy$default(r3, r4, r5, r6, r7, r8)
                r10.setLocalSessionData$com_google_firebase_firebase_sessions(r0)
                com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this
                com.google.firebase.sessions.SessionFirelogPublisher r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.access$getSessionFirelogPublisher$p(r10)
                r10.mayLogSession(r4)
                com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.this
                java.lang.String r0 = r4.getSessionId()
                com.google.firebase.sessions.SharedSessionRepositoryImpl$NotificationType r3 = com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType.FALLBACK
                r9.label = r2
                java.lang.Object r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.access$notifySubscribers(r10, r0, r3, r9)
                if (r10 != r1) goto L95
            L94:
                return r1
            L95:
                q5.x r10 = q5.x.f13520a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SharedSessionRepositoryImpl.C22201.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((C22201) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$notifySubscribers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl", f = "SharedSessionRepository.kt", l = {199}, m = "notifySubscribers")
    public static final class C22211 extends x5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22211(v5.c<? super C22211> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedSessionRepositoryImpl.this.notifySubscribers(null, null, this);
        }
    }

    public SharedSessionRepositoryImpl(SessionsSettings sessionsSettings, SessionGenerator sessionGenerator, SessionFirelogPublisher sessionFirelogPublisher, TimeProvider timeProvider, DataStore<SessionData> sessionDataStore, ProcessDataManager processDataManager, @Background h backgroundDispatcher) {
        k.e(sessionsSettings, "sessionsSettings");
        k.e(sessionGenerator, "sessionGenerator");
        k.e(sessionFirelogPublisher, "sessionFirelogPublisher");
        k.e(timeProvider, "timeProvider");
        k.e(sessionDataStore, "sessionDataStore");
        k.e(processDataManager, "processDataManager");
        k.e(backgroundDispatcher, "backgroundDispatcher");
        this.sessionsSettings = sessionsSettings;
        this.sessionGenerator = sessionGenerator;
        this.sessionFirelogPublisher = sessionFirelogPublisher;
        this.timeProvider = timeProvider;
        this.sessionDataStore = sessionDataStore;
        this.processDataManager = processDataManager;
        this.backgroundDispatcher = backgroundDispatcher;
        this.previousNotificationType = NotificationType.GENERAL;
        this.previousSessionId = "";
        c0.u(c0.b(backgroundDispatcher), null, new AnonymousClass1(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isColdStart(SessionData sessionData) {
        Map<String, ProcessData> processDataMap = sessionData.getProcessDataMap();
        if (processDataMap == null) {
            Log.d(FirebaseSessions.TAG, "No process data map");
            return true;
        }
        boolean zIsColdStart = this.processDataManager.isColdStart(processDataMap);
        if (zIsColdStart) {
            Log.d(FirebaseSessions.TAG, "Cold app start detected");
        }
        return zIsColdStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMyProcessStale(SessionData sessionData) {
        Map<String, ProcessData> processDataMap = sessionData.getProcessDataMap();
        if (processDataMap == null) {
            Log.d(FirebaseSessions.TAG, "No process data for " + this.processDataManager.getMyProcessName());
            return true;
        }
        boolean zIsMyProcessStale = this.processDataManager.isMyProcessStale(processDataMap);
        if (zIsMyProcessStale) {
            Log.d(FirebaseSessions.TAG, "Process " + this.processDataManager.getMyProcessName() + " is stale");
        }
        return zIsMyProcessStale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSessionExpired(SessionData sessionData) {
        Time backgroundTime = sessionData.getBackgroundTime();
        if (backgroundTime == null) {
            Log.d(FirebaseSessions.TAG, "Session " + sessionData.getSessionDetails().getSessionId() + " has not backgrounded yet");
            return false;
        }
        boolean z2 = o6.a.c(this.timeProvider.currentTime().m215minus5sfh64U(backgroundTime), this.sessionsSettings.m219getSessionRestartTimeoutUwyO8pc()) > 0;
        if (z2) {
            Log.d(FirebaseSessions.TAG, "Session " + sessionData.getSessionDetails().getSessionId() + " is expired");
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object notifySubscribers(java.lang.String r7, com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType r8, v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.google.firebase.sessions.SharedSessionRepositoryImpl.C22211
            if (r0 == 0) goto L13
            r0 = r9
            com.google.firebase.sessions.SharedSessionRepositoryImpl$notifySubscribers$1 r0 = (com.google.firebase.sessions.SharedSessionRepositoryImpl.C22211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.SharedSessionRepositoryImpl$notifySubscribers$1 r0 = new com.google.firebase.sessions.SharedSessionRepositoryImpl$notifySubscribers$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.L$1
            r8 = r7
            com.google.firebase.sessions.SharedSessionRepositoryImpl$NotificationType r8 = (com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType) r8
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            r2.q.z0(r9)
            goto L59
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            r2.q.z0(r9)
            r6.previousNotificationType = r8
            java.lang.String r9 = r6.previousSessionId
            boolean r9 = kotlin.jvm.internal.k.a(r9, r7)
            if (r9 == 0) goto L48
            return r3
        L48:
            r6.previousSessionId = r7
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r9 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            java.util.Map r9 = (java.util.Map) r9
            java.util.Collection r9 = r9.values()
            java.util.Iterator r9 = r9.iterator()
        L63:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Lc4
            java.lang.Object r0 = r9.next()
            com.google.firebase.sessions.api.SessionSubscriber r0 = (com.google.firebase.sessions.api.SessionSubscriber) r0
            com.google.firebase.sessions.api.SessionSubscriber$SessionDetails r1 = new com.google.firebase.sessions.api.SessionSubscriber$SessionDetails
            r1.<init>(r7)
            r0.onSessionChanged(r1)
            int[] r1 = com.google.firebase.sessions.SharedSessionRepositoryImpl.WhenMappings.$EnumSwitchMapping$0
            int r2 = r8.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "Notified "
            if (r1 == r4) goto La6
            r5 = 2
            if (r1 != r5) goto L9f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            com.google.firebase.sessions.api.SessionSubscriber$Name r0 = r0.getSessionSubscriberName()
            r1.append(r0)
            java.lang.String r0 = " of new fallback session "
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = r1.toString()
            goto Lbe
        L9f:
            e2.s r7 = new e2.s
            r8 = 3
            r7.<init>(r8)
            throw r7
        La6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            com.google.firebase.sessions.api.SessionSubscriber$Name r0 = r0.getSessionSubscriberName()
            r1.append(r0)
            java.lang.String r0 = " of new session "
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = r1.toString()
        Lbe:
            java.lang.String r1 = "FirebaseSessions"
            android.util.Log.d(r1, r0)
            goto L63
        Lc4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SharedSessionRepositoryImpl.notifySubscribers(java.lang.String, com.google.firebase.sessions.SharedSessionRepositoryImpl$NotificationType, v5.c):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public void appBackground() {
        this.isInForeground = false;
        if (this.localSessionData == null) {
            Log.d(FirebaseSessions.TAG, "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d(FirebaseSessions.TAG, "App backgrounded on " + this.processDataManager.getMyProcessName());
        c0.u(c0.b(this.backgroundDispatcher), null, new C22191(null), 3);
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public void appForeground() {
        this.isInForeground = true;
        if (this.localSessionData == null) {
            Log.d(FirebaseSessions.TAG, "App foregrounded, but local SessionData not initialized");
            return;
        }
        SessionData localSessionData$com_google_firebase_firebase_sessions = getLocalSessionData$com_google_firebase_firebase_sessions();
        Log.d(FirebaseSessions.TAG, "App foregrounded on " + this.processDataManager.getMyProcessName());
        if (isSessionExpired(localSessionData$com_google_firebase_firebase_sessions) || isMyProcessStale(localSessionData$com_google_firebase_firebase_sessions)) {
            c0.u(c0.b(this.backgroundDispatcher), null, new C22201(localSessionData$com_google_firebase_firebase_sessions, null), 3);
        }
    }

    public final SessionData getLocalSessionData$com_google_firebase_firebase_sessions() {
        SessionData sessionData = this.localSessionData;
        if (sessionData != null) {
            return sessionData;
        }
        k.l("localSessionData");
        throw null;
    }

    public final NotificationType getPreviousNotificationType$com_google_firebase_firebase_sessions() {
        return this.previousNotificationType;
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public boolean isInForeground() {
        return this.isInForeground;
    }

    public final void setLocalSessionData$com_google_firebase_firebase_sessions(SessionData sessionData) {
        k.e(sessionData, "<set-?>");
        this.localSessionData = sessionData;
    }

    public final void setPreviousNotificationType$com_google_firebase_firebase_sessions(NotificationType notificationType) {
        k.e(notificationType, "<set-?>");
        this.previousNotificationType = notificationType;
    }
}

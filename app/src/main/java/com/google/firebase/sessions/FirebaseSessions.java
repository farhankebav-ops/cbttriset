package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.annotations.concurrent.Background;
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
public final class FirebaseSessions {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "FirebaseSessions";
    private final FirebaseApp firebaseApp;
    private final SessionsSettings settings;

    /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {51, 55}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ SessionsActivityLifecycleCallbacks $sessionsActivityLifecycleCallbacks;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks, v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$sessionsActivityLifecycleCallbacks = sessionsActivityLifecycleCallbacks;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks, String str, FirebaseOptions firebaseOptions) {
            Log.w(FirebaseSessions.TAG, "FirebaseApp instance deleted. Sessions library will stop collecting data.");
            sessionsActivityLifecycleCallbacks.onAppDelete();
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return FirebaseSessions.this.new AnonymousClass1(this.$sessionsActivityLifecycleCallbacks, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        
            if (r6.updateSettings(r5) == r0) goto L25;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1e
                if (r1 == r4) goto L1a
                if (r1 != r3) goto L12
                r2.q.z0(r6)
                goto L60
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                r2.q.z0(r6)
                goto L2c
            L1e:
                r2.q.z0(r6)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r6 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
                r5.label = r4
                java.lang.Object r6 = r6.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r5)
                if (r6 != r0) goto L2c
                goto L5f
            L2c:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                if (r6 == 0) goto L3b
                boolean r1 = r6.isEmpty()
                if (r1 == 0) goto L3b
                goto L89
            L3b:
                java.util.Iterator r6 = r6.iterator()
            L3f:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L89
                java.lang.Object r1 = r6.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.isDataCollectionEnabled()
                if (r1 == 0) goto L3f
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r6)
                r5.label = r3
                java.lang.Object r6 = r6.updateSettings(r5)
                if (r6 != r0) goto L60
            L5f:
                return r0
            L60:
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r6)
                boolean r6 = r6.getSessionsEnabled()
                if (r6 != 0) goto L78
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                java.lang.Integer r0 = new java.lang.Integer
                r0.<init>(r6)
                goto L94
            L78:
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.FirebaseApp r6 = com.google.firebase.sessions.FirebaseSessions.access$getFirebaseApp$p(r6)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks r0 = r5.$sessionsActivityLifecycleCallbacks
                com.google.firebase.sessions.b r1 = new com.google.firebase.sessions.b
                r1.<init>()
                r6.addLifecycleEventListener(r1)
                goto L94
            L89:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                java.lang.Integer r0 = new java.lang.Integer
                r0.<init>(r6)
            L94:
                q5.x r6 = q5.x.f13520a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final FirebaseSessions getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessions.class);
            k.d(obj, "get(...)");
            return (FirebaseSessions) obj;
        }

        private Companion() {
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp, SessionsSettings settings, @Background h backgroundDispatcher, SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks) {
        k.e(firebaseApp, "firebaseApp");
        k.e(settings, "settings");
        k.e(backgroundDispatcher, "backgroundDispatcher");
        k.e(sessionsActivityLifecycleCallbacks, "sessionsActivityLifecycleCallbacks");
        this.firebaseApp = firebaseApp;
        this.settings = settings;
        Log.d(TAG, "Initializing Firebase Sessions 3.0.3.");
        Context applicationContext = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(sessionsActivityLifecycleCallbacks);
            c0.u(c0.b(backgroundDispatcher), null, new AnonymousClass1(sessionsActivityLifecycleCallbacks, null), 3);
        } else {
            Log.e(TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
        }
    }
}

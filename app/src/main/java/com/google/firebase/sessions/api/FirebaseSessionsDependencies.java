package com.google.firebase.sessions.api;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import z6.a;
import z6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class FirebaseSessionsDependencies {
    public static final FirebaseSessionsDependencies INSTANCE = new FirebaseSessionsDependencies();
    private static final Map<SessionSubscriber.Name, Dependency> dependencies = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Dependency {
        private final a mutex;
        private SessionSubscriber subscriber;

        public Dependency(a mutex, SessionSubscriber sessionSubscriber) {
            k.e(mutex, "mutex");
            this.mutex = mutex;
            this.subscriber = sessionSubscriber;
        }

        public static /* synthetic */ Dependency copy$default(Dependency dependency, a aVar, SessionSubscriber sessionSubscriber, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                aVar = dependency.mutex;
            }
            if ((i2 & 2) != 0) {
                sessionSubscriber = dependency.subscriber;
            }
            return dependency.copy(aVar, sessionSubscriber);
        }

        public final a component1() {
            return this.mutex;
        }

        public final SessionSubscriber component2() {
            return this.subscriber;
        }

        public final Dependency copy(a mutex, SessionSubscriber sessionSubscriber) {
            k.e(mutex, "mutex");
            return new Dependency(mutex, sessionSubscriber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) obj;
            return k.a(this.mutex, dependency.mutex) && k.a(this.subscriber, dependency.subscriber);
        }

        public final a getMutex() {
            return this.mutex;
        }

        public final SessionSubscriber getSubscriber() {
            return this.subscriber;
        }

        public int hashCode() {
            int iHashCode = this.mutex.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.subscriber;
            return iHashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public final void setSubscriber(SessionSubscriber sessionSubscriber) {
            this.subscriber = sessionSubscriber;
        }

        public String toString() {
            return "Dependency(mutex=" + this.mutex + ", subscriber=" + this.subscriber + ')';
        }

        public /* synthetic */ Dependency(a aVar, SessionSubscriber sessionSubscriber, int i2, f fVar) {
            this(aVar, (i2 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    private FirebaseSessionsDependencies() {
    }

    public static final void addDependency(SessionSubscriber.Name subscriberName) {
        k.e(subscriberName, "subscriberName");
        Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
        if (dependencies2.containsKey(subscriberName)) {
            Log.d(FirebaseSessions.TAG, "Dependency " + subscriberName + " already added.");
            return;
        }
        k.d(dependencies2, "dependencies");
        dependencies2.put(subscriberName, new Dependency(new c(true), null, 2, 0 == true ? 1 : 0));
        Log.d(FirebaseSessions.TAG, "Dependency to " + subscriberName + " added.");
    }

    private final Dependency getDependency(SessionSubscriber.Name name) {
        Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
        k.d(dependencies2, "dependencies");
        Dependency dependency = dependencies2.get(name);
        if (dependency != null) {
            return dependency;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    public static final void register(SessionSubscriber subscriber) {
        k.e(subscriber, "subscriber");
        SessionSubscriber.Name sessionSubscriberName = subscriber.getSessionSubscriberName();
        Dependency dependency = INSTANCE.getDependency(sessionSubscriberName);
        if (dependency.getSubscriber() != null) {
            Log.d(FirebaseSessions.TAG, "Subscriber " + sessionSubscriberName + " already registered.");
            return;
        }
        dependency.setSubscriber(subscriber);
        Log.d(FirebaseSessions.TAG, "Subscriber " + sessionSubscriberName + " registered.");
        ((c) dependency.getMutex()).f(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009f -> B:21:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getRegisteredSubscribers$com_google_firebase_firebase_sessions(v5.c<? super java.util.Map<com.google.firebase.sessions.api.SessionSubscriber.Name, ? extends com.google.firebase.sessions.api.SessionSubscriber>> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            if (r0 == 0) goto L13
            r0 = r11
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = new com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r2 = r0.L$5
            java.lang.Object r4 = r0.L$4
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r0.L$3
            z6.a r5 = (z6.a) r5
            java.lang.Object r6 = r0.L$2
            com.google.firebase.sessions.api.SessionSubscriber$Name r6 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r6
            java.lang.Object r7 = r0.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$0
            java.util.Map r8 = (java.util.Map) r8
            r2.q.z0(r11)
            goto La0
        L3d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L45:
            r2.q.z0(r11)
            java.util.Map<com.google.firebase.sessions.api.SessionSubscriber$Name, com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency> r11 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.dependencies
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.k.d(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r4 = r11.size()
            int r4 = r5.x.d0(r4)
            r2.<init>(r4)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r7 = r11
            r4 = r2
        L66:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto Lb8
            java.lang.Object r11 = r7.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r5 = r11.getKey()
            r6 = r5
            com.google.firebase.sessions.api.SessionSubscriber$Name r6 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r6
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency r11 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies.Dependency) r11
            z6.a r11 = r11.getMutex()
            r0.L$0 = r4
            r0.L$1 = r7
            r0.L$2 = r6
            r0.L$3 = r11
            r0.L$4 = r4
            r0.L$5 = r2
            r0.label = r3
            r5 = r11
            z6.c r5 = (z6.c) r5
            java.lang.Object r11 = r5.d(r0)
            if (r11 != r1) goto L9f
            return r1
        L9f:
            r8 = r4
        La0:
            r11 = 0
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r9 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE     // Catch: java.lang.Throwable -> Lb1
            com.google.firebase.sessions.api.SessionSubscriber r6 = r9.getSubscriber$com_google_firebase_firebase_sessions(r6)     // Catch: java.lang.Throwable -> Lb1
            z6.c r5 = (z6.c) r5
            r5.f(r11)
            r4.put(r2, r6)
            r4 = r8
            goto L66
        Lb1:
            r0 = move-exception
            z6.c r5 = (z6.c) r5
            r5.f(r11)
            throw r0
        Lb8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.api.FirebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(v5.c):java.lang.Object");
    }

    @VisibleForTesting
    public final SessionSubscriber getSubscriber$com_google_firebase_firebase_sessions(SessionSubscriber.Name subscriberName) {
        k.e(subscriberName, "subscriberName");
        SessionSubscriber subscriber = getDependency(subscriberName).getSubscriber();
        if (subscriber != null) {
            return subscriber;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }

    @VisibleForTesting
    public final void reset$com_google_firebase_firebase_sessions() {
        dependencies.clear();
    }
}

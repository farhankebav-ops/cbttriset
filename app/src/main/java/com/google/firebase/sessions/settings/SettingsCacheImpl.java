package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.TimeProvider;
import e6.p;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import t6.f;
import v5.c;
import v5.h;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SettingsCacheImpl implements SettingsCache {
    private final h backgroundDispatcher;
    private final AtomicReference<SessionConfigs> sessionConfigsAtomicReference;
    private final DataStore<SessionConfigs> sessionConfigsDataStore;
    private final TimeProvider timeProvider;

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$1", f = "SettingsCache.kt", l = {73}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class C01431 implements f, g {
            final /* synthetic */ AtomicReference<SessionConfigs> $tmp0;

            public C01431(AtomicReference<SessionConfigs> atomicReference) {
                this.$tmp0 = atomicReference;
            }

            public final Object emit(SessionConfigs sessionConfigs, c<? super x> cVar) {
                Object objInvokeSuspend$set = AnonymousClass1.invokeSuspend$set(this.$tmp0, sessionConfigs, cVar);
                return objInvokeSuspend$set == a.f17774a ? objInvokeSuspend$set : x.f13520a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof f) && (obj instanceof g)) {
                    return k.a(getFunctionDelegate(), ((g) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.g
            public final q5.c getFunctionDelegate() {
                return new kotlin.jvm.internal.a(2, this.$tmp0, AtomicReference.class, "set", "set(Ljava/lang/Object;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // t6.f
            public /* bridge */ /* synthetic */ Object emit(Object obj, c cVar) {
                return emit((SessionConfigs) obj, (c<? super x>) cVar);
            }
        }

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$set(AtomicReference atomicReference, SessionConfigs sessionConfigs, c cVar) {
            atomicReference.set(sessionConfigs);
            return x.f13520a;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return SettingsCacheImpl.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                t6.e data = SettingsCacheImpl.this.sessionConfigsDataStore.getData();
                C01431 c01431 = new C01431(SettingsCacheImpl.this.sessionConfigsAtomicReference);
                this.label = 1;
                if (data.collect(c01431, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.sessions.settings.SettingsCacheImpl", f = "SettingsCache.kt", l = {98}, m = "updateConfigs")
    public static final class C22221 extends x5.c {
        int label;
        /* synthetic */ Object result;

        public C22221(c<? super C22221> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsCacheImpl.this.updateConfigs(null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ SessionConfigs $sessionConfigs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SessionConfigs sessionConfigs, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$sessionConfigs = sessionConfigs;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$sessionConfigs, cVar);
        }

        @Override // e6.p
        public final Object invoke(SessionConfigs sessionConfigs, c<? super SessionConfigs> cVar) {
            return ((AnonymousClass2) create(sessionConfigs, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return this.$sessionConfigs;
        }
    }

    public SettingsCacheImpl(@Background h backgroundDispatcher, TimeProvider timeProvider, DataStore<SessionConfigs> sessionConfigsDataStore) {
        k.e(backgroundDispatcher, "backgroundDispatcher");
        k.e(timeProvider, "timeProvider");
        k.e(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.timeProvider = timeProvider;
        this.sessionConfigsDataStore = sessionConfigsDataStore;
        this.sessionConfigsAtomicReference = new AtomicReference<>();
        c0.u(c0.b(backgroundDispatcher), null, new AnonymousClass1(null), 3);
    }

    private final SessionConfigs getSessionConfigs() throws Throwable {
        if (this.sessionConfigsAtomicReference.get() == null) {
            AtomicReference<SessionConfigs> atomicReference = this.sessionConfigsAtomicReference;
            Object objA = c0.A(v5.i.f17610a, new SettingsCacheImpl$sessionConfigs$1(this, null));
            while (!atomicReference.compareAndSet(null, (SessionConfigs) objA) && atomicReference.get() == null) {
            }
        }
        SessionConfigs sessionConfigs = this.sessionConfigsAtomicReference.get();
        k.d(sessionConfigs, "get(...)");
        return sessionConfigs;
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public boolean hasCacheExpired() {
        Long cacheUpdatedTimeSeconds = getSessionConfigs().getCacheUpdatedTimeSeconds();
        Integer cacheDurationSeconds = getSessionConfigs().getCacheDurationSeconds();
        return cacheUpdatedTimeSeconds == null || cacheDurationSeconds == null || this.timeProvider.currentTime().getSeconds() - cacheUpdatedTimeSeconds.longValue() >= ((long) cacheDurationSeconds.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeConfigs$com_google_firebase_firebase_sessions(v5.c<java.lang.Object> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            r2.q.z0(r6)     // Catch: java.io.IOException -> L27
            return r6
        L27:
            r6 = move-exception
            goto L46
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            r2.q.z0(r6)
            androidx.datastore.core.DataStore<com.google.firebase.sessions.settings.SessionConfigs> r6 = r5.sessionConfigsDataStore     // Catch: java.io.IOException -> L27
            com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$2     // Catch: java.io.IOException -> L27
            r4 = 0
            r2.<init>(r4)     // Catch: java.io.IOException -> L27
            r0.label = r3     // Catch: java.io.IOException -> L27
            java.lang.Object r6 = r6.updateData(r2, r0)     // Catch: java.io.IOException -> L27
            if (r6 != r1) goto L45
            return r1
        L45:
            return r6
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to remove config values: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "FirebaseSessions"
            int r6 = android.util.Log.w(r0, r6)
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCacheImpl.removeConfigs$com_google_firebase_firebase_sessions(v5.c):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Integer sessionRestartTimeout() {
        return getSessionConfigs().getSessionTimeoutSeconds();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Double sessionSamplingRate() {
        return getSessionConfigs().getSessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Boolean sessionsEnabled() {
        return getSessionConfigs().getSessionsEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.firebase.sessions.settings.SettingsCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateConfigs(com.google.firebase.sessions.settings.SessionConfigs r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.firebase.sessions.settings.SettingsCacheImpl.C22221
            if (r0 == 0) goto L13
            r0 = r7
            com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCacheImpl.C22221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            r2.q.z0(r7)     // Catch: java.io.IOException -> L27
            goto L58
        L27:
            r6 = move-exception
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            r2.q.z0(r7)
            androidx.datastore.core.DataStore<com.google.firebase.sessions.settings.SessionConfigs> r7 = r5.sessionConfigsDataStore     // Catch: java.io.IOException -> L27
            com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2     // Catch: java.io.IOException -> L27
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.io.IOException -> L27
            r0.label = r3     // Catch: java.io.IOException -> L27
            java.lang.Object r6 = r7.updateData(r2, r0)     // Catch: java.io.IOException -> L27
            if (r6 != r1) goto L58
            return r1
        L45:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to update config values: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L58:
            q5.x r6 = q5.x.f13520a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCacheImpl.updateConfigs(com.google.firebase.sessions.settings.SessionConfigs, v5.c):java.lang.Object");
    }
}

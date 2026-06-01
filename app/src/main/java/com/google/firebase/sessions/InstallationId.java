package com.google.firebase.sessions;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class InstallationId {
    public static final Companion Companion = new Companion(null);
    private final String authToken;
    private final String fid;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
        
            if (r10 == r1) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [com.google.firebase.installations.FirebaseInstallationsApi] */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.installations.FirebaseInstallationsApi, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object create(com.google.firebase.installations.FirebaseInstallationsApi r9, v5.c<? super com.google.firebase.sessions.InstallationId> r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L13
                r0 = r10
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                java.lang.String r3 = "FirebaseSessions"
                r4 = 2
                r5 = 1
                java.lang.String r6 = ""
                if (r2 == 0) goto L46
                if (r2 == r5) goto L3c
                if (r2 != r4) goto L34
                java.lang.Object r9 = r0.L$0
                java.lang.String r9 = (java.lang.String) r9
                r2.q.z0(r10)     // Catch: java.lang.Exception -> L32
                goto L83
            L32:
                r10 = move-exception
                goto L8a
            L34:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3c:
                java.lang.Object r9 = r0.L$0
                com.google.firebase.installations.FirebaseInstallationsApi r9 = (com.google.firebase.installations.FirebaseInstallationsApi) r9
                r2.q.z0(r10)     // Catch: java.lang.Exception -> L44
                goto L5e
            L44:
                r10 = move-exception
                goto L68
            L46:
                r2.q.z0(r10)
                r10 = 0
                com.google.android.gms.tasks.Task r10 = r9.getToken(r10)     // Catch: java.lang.Exception -> L44
                java.lang.String r2 = "getToken(...)"
                kotlin.jvm.internal.k.d(r10, r2)     // Catch: java.lang.Exception -> L44
                r0.L$0 = r9     // Catch: java.lang.Exception -> L44
                r0.label = r5     // Catch: java.lang.Exception -> L44
                java.lang.Object r10 = a.a.j(r10, r0)     // Catch: java.lang.Exception -> L44
                if (r10 != r1) goto L5e
                goto L82
            L5e:
                com.google.firebase.installations.InstallationTokenResult r10 = (com.google.firebase.installations.InstallationTokenResult) r10     // Catch: java.lang.Exception -> L44
                java.lang.String r10 = r10.getToken()     // Catch: java.lang.Exception -> L44
                r7 = r10
                r10 = r9
                r9 = r7
                goto L6f
            L68:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r3, r2, r10)
                r10 = r9
                r9 = r6
            L6f:
                com.google.android.gms.tasks.Task r10 = r10.getId()     // Catch: java.lang.Exception -> L32
                java.lang.String r2 = "getId(...)"
                kotlin.jvm.internal.k.d(r10, r2)     // Catch: java.lang.Exception -> L32
                r0.L$0 = r9     // Catch: java.lang.Exception -> L32
                r0.label = r4     // Catch: java.lang.Exception -> L32
                java.lang.Object r10 = a.a.j(r10, r0)     // Catch: java.lang.Exception -> L32
                if (r10 != r1) goto L83
            L82:
                return r1
            L83:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L32
                if (r10 != 0) goto L88
                goto L8f
            L88:
                r6 = r10
                goto L8f
            L8a:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r3, r0, r10)
            L8f:
                com.google.firebase.sessions.InstallationId r10 = new com.google.firebase.sessions.InstallationId
                r0 = 0
                r10.<init>(r6, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.create(com.google.firebase.installations.FirebaseInstallationsApi, v5.c):java.lang.Object");
        }

        private Companion() {
        }
    }

    public /* synthetic */ InstallationId(String str, String str2, f fVar) {
        this(str, str2);
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }

    private InstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }
}

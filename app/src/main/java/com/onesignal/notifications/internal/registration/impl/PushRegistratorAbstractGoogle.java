package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class PushRegistratorAbstractGoogle implements IPushRegistrator, IPushRegistratorCallback {
    public static final Companion Companion = new Companion(null);
    private static final int REGISTRATION_RETRY_BACKOFF_MS = 10000;
    private static final int REGISTRATION_RETRY_COUNT = 5;
    private ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final GooglePlayServicesUpgradePrompt _upgradePrompt;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$attemptRegistration$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle", f = "PushRegistratorAbstractGoogle.kt", l = {128}, m = "attemptRegistration")
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushRegistratorAbstractGoogle.this.attemptRegistration(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle", f = "PushRegistratorAbstractGoogle.kt", l = {84, 86}, m = "internalRegisterForPush")
    public static final class C28111 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28111(v5.c<? super C28111> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushRegistratorAbstractGoogle.this.internalRegisterForPush(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle", f = "PushRegistratorAbstractGoogle.kt", l = {108, 113}, m = "registerInBackground")
    public static final class C28121 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28121(v5.c<? super C28121> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushRegistratorAbstractGoogle.this.registerInBackground(null, this);
        }
    }

    public PushRegistratorAbstractGoogle(IDeviceService _deviceService, ConfigModelStore _configModelStore, GooglePlayServicesUpgradePrompt _upgradePrompt) {
        k.e(_deviceService, "_deviceService");
        k.e(_configModelStore, "_configModelStore");
        k.e(_upgradePrompt, "_upgradePrompt");
        this._deviceService = _deviceService;
        this._configModelStore = _configModelStore;
        this._upgradePrompt = _upgradePrompt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptRegistration(java.lang.String r9, int r10, v5.c<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.attemptRegistration(java.lang.String, int, v5.c):java.lang.Object");
    }

    public static /* synthetic */ Object fireCallback$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, String str, v5.c cVar) throws Exception {
        throw new Exception("Google has no callback mechanism for push registration!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object internalRegisterForPush(java.lang.String r7, v5.c<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.C28111
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.C28111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r3) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r7 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r7
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L2f
            goto L6c
        L2f:
            r8 = move-exception
            goto L79
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r7 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r7
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L2f
            goto L58
        L41:
            r2.q.z0(r8)
            com.onesignal.core.internal.device.IDeviceService r8 = r6._deviceService     // Catch: java.lang.Throwable -> L5b
            boolean r8 = r8.isGMSInstalledAndEnabled()     // Catch: java.lang.Throwable -> L5b
            if (r8 == 0) goto L5e
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L5b
            r0.label = r3     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r8 = r6.registerInBackground(r7, r0)     // Catch: java.lang.Throwable -> L5b
            if (r8 != r1) goto L57
            goto L6a
        L57:
            r7 = r6
        L58:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r8 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r8     // Catch: java.lang.Throwable -> L2f
            return r8
        L5b:
            r8 = move-exception
            r7 = r6
            goto L79
        L5e:
            com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt r7 = r6._upgradePrompt     // Catch: java.lang.Throwable -> L5b
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L5b
            r0.label = r4     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r7 = r7.showUpdateGPSDialog(r0)     // Catch: java.lang.Throwable -> L5b
            if (r7 != r1) goto L6b
        L6a:
            return r1
        L6b:
            r7 = r6
        L6c:
            java.lang.String r8 = "'Google Play services' app not installed or disabled on the device."
            com.onesignal.debug.internal.logging.Logging.error$default(r8, r5, r4, r5)     // Catch: java.lang.Throwable -> L2f
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r8 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch: java.lang.Throwable -> L2f
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.OUTDATED_GOOGLE_PLAY_SERVICES_APP     // Catch: java.lang.Throwable -> L2f
            r8.<init>(r5, r0)     // Catch: java.lang.Throwable -> L2f
            return r8
        L79:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not register with "
            r0.<init>(r1)
            java.lang.String r7 = r7.getProviderName()
            r0.append(r7)
            java.lang.String r7 = " due to an issue with your AndroidManifest.xml or with 'Google Play services'."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.error(r7, r8)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r7 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r8 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_INIT_ERROR
            r7.<init>(r5, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.internalRegisterForPush(java.lang.String, v5.c):java.lang.Object");
    }

    private final boolean isValidProjectNumber(String str) {
        try {
            k.b(str);
            Float.parseFloat(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final SubscriptionStatus pushStatusFromThrowable(Throwable th) {
        String rootCauseMessage = AndroidUtils.INSTANCE.getRootCauseMessage(th);
        return th instanceof IOException ? k.a(rootCauseMessage, "SERVICE_NOT_AVAILABLE") ? SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE : k.a(rootCauseMessage, "AUTHENTICATION_FAILED") ? SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED : SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER : SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION;
    }

    public static /* synthetic */ Object registerForPush$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, v5.c cVar) {
        if (!pushRegistratorAbstractGoogle._configModelStore.getModel().isInitializedWithRemote()) {
            return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_INIT_ERROR);
        }
        if (!pushRegistratorAbstractGoogle._deviceService.getHasFCMLibrary()) {
            Logging.fatal$default("The Firebase FCM library is missing! Please make sure to include it in your project.", null, 2, null);
            return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.MISSING_FIREBASE_FCM_LIBRARY);
        }
        if (!pushRegistratorAbstractGoogle.isValidProjectNumber(pushRegistratorAbstractGoogle._configModelStore.getModel().getGoogleProjectNumber())) {
            Logging.error$default("Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.", null, 2, null);
            return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.INVALID_FCM_SENDER_ID);
        }
        String googleProjectNumber = pushRegistratorAbstractGoogle._configModelStore.getModel().getGoogleProjectNumber();
        k.b(googleProjectNumber);
        return pushRegistratorAbstractGoogle.internalRegisterForPush(googleProjectNumber, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (q6.c0.k((r10 + 1) * 10000, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007c -> B:29:0x007f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registerInBackground(java.lang.String r10, v5.c<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.C28121
            if (r0 == 0) goto L13
            r0 = r11
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.C28121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r5 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r5
            r2.q.z0(r11)
            goto L7f
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r5 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r5
            r2.q.z0(r11)
            goto L66
        L4a:
            r2.q.z0(r11)
            r11 = 0
            r2 = r9
        L4f:
            r5 = 5
            if (r11 >= r5) goto L84
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r4
            java.lang.Object r5 = r2.attemptRegistration(r10, r11, r0)
            if (r5 != r1) goto L61
            goto L7e
        L61:
            r8 = r2
            r2 = r10
            r10 = r11
            r11 = r5
            r5 = r8
        L66:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r11 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r11
            if (r11 == 0) goto L6b
            return r11
        L6b:
            int r11 = r10 + 1
            int r11 = r11 * 10000
            long r6 = (long) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r11 = q6.c0.k(r6, r0)
            if (r11 != r1) goto L7f
        L7e:
            return r1
        L7f:
            int r11 = r10 + 1
            r10 = r2
            r2 = r5
            goto L4f
        L84:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r10 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r11 = 0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_INIT_ERROR
            r10.<init>(r11, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.registerInBackground(java.lang.String, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String str, v5.c<? super x> cVar) {
        return fireCallback$suspendImpl(this, str, cVar);
    }

    public abstract String getProviderName();

    public abstract Object getToken(String str, v5.c<? super String> cVar) throws ExecutionException, InterruptedException, IOException;

    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(v5.c<? super IPushRegistrator.RegisterResult> cVar) {
        return registerForPush$suspendImpl(this, cVar);
    }
}

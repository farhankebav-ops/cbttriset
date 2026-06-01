package com.onesignal.notifications.internal.registration.impl;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.config.FCMConfigModel;
import com.onesignal.core.internal.device.IDeviceService;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushRegistratorFCM extends PushRegistratorAbstractGoogle {
    public static final Companion Companion = new Companion(null);
    private static final String FCM_APP_NAME = "ONESIGNAL_SDK_FCM_APP_NAME";
    private static final String FCM_DEFAULT_API_KEY_BASE64 = "QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV";
    private static final String FCM_DEFAULT_APP_ID = "1:754795614042:android:c682b8144a8dd52bc1ad63";
    private static final String FCM_DEFAULT_PROJECT_ID = "onesignal-shared-public";
    private final IApplicationService _applicationService;
    private ConfigModelStore _configModelStore;
    private final String apiKey;
    private final String appId;
    private FirebaseApp firebaseApp;
    private final String projectId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushRegistratorFCM(ConfigModelStore _configModelStore, IApplicationService _applicationService, GooglePlayServicesUpgradePrompt upgradePrompt, IDeviceService deviceService) {
        super(deviceService, _configModelStore, upgradePrompt);
        k.e(_configModelStore, "_configModelStore");
        k.e(_applicationService, "_applicationService");
        k.e(upgradePrompt, "upgradePrompt");
        k.e(deviceService, "deviceService");
        this._configModelStore = _configModelStore;
        this._applicationService = _applicationService;
        FCMConfigModel fcmParams = _configModelStore.getModel().getFcmParams();
        String projectId = fcmParams.getProjectId();
        this.projectId = projectId == null ? FCM_DEFAULT_PROJECT_ID : projectId;
        String appId = fcmParams.getAppId();
        this.appId = appId == null ? FCM_DEFAULT_APP_ID : appId;
        byte[] bArrDecode = Base64.decode(FCM_DEFAULT_API_KEY_BASE64, 0);
        k.d(bArrDecode, "decode(FCM_DEFAULT_API_KEY_BASE64, Base64.DEFAULT)");
        String str = new String(bArrDecode, n6.a.f13073a);
        String apiKey = fcmParams.getApiKey();
        this.apiKey = apiKey != null ? apiKey : str;
    }

    private final String getTokenWithClassFirebaseMessaging() throws Exception {
        FirebaseApp firebaseApp = this.firebaseApp;
        k.b(firebaseApp);
        Task<String> token = ((FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class)).getToken();
        k.d(token, "fcmInstance.token");
        try {
            Object objAwait = Tasks.await(token);
            k.d(objAwait, "await(tokenTask)");
            return (String) objAwait;
        } catch (ExecutionException e) {
            Exception exception = token.getException();
            if (exception == null) {
                throw e;
            }
            throw exception;
        }
    }

    private final void initFirebaseApp(String str) {
        if (this.firebaseApp != null) {
            return;
        }
        FirebaseOptions firebaseOptionsBuild = new FirebaseOptions.Builder().setGcmSenderId(str).setApplicationId(this.appId).setApiKey(this.apiKey).setProjectId(this.projectId).build();
        k.d(firebaseOptionsBuild, "Builder()\n              …\n                .build()");
        this.firebaseApp = FirebaseApp.initializeApp(this._applicationService.getAppContext(), firebaseOptionsBuild, FCM_APP_NAME);
    }

    @Override // com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle
    public String getProviderName() {
        return "FCM";
    }

    @Override // com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle
    public Object getToken(String str, c<? super String> cVar) throws ExecutionException, InterruptedException {
        initFirebaseApp(str);
        return getTokenWithClassFirebaseMessaging();
    }

    public final IApplicationService get_applicationService() {
        return this._applicationService;
    }

    public final ConfigModelStore get_configModelStore() {
        return this._configModelStore;
    }

    public final void set_configModelStore(ConfigModelStore configModelStore) {
        k.e(configModelStore, "<set-?>");
        this._configModelStore = configModelStore;
    }
}

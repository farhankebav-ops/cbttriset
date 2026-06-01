package com.onesignal.internal;

import android.os.Build;
import com.onesignal.IOneSignal;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.ISingletonModelStore;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.common.services.ServiceProvider;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.CoreModule;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.debug.IDebugManager;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.DebugManager;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.SessionModule;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.user.IUserManager;
import com.onesignal.user.UserModule;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import e6.l;
import e6.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import r5.m;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalImp implements IOneSignal, IServiceProvider {
    private Boolean _consentGiven;
    private Boolean _consentRequired;
    private Boolean _disableGMSMissingPrompt;
    private ConfigModel configModel;
    private boolean isInitialized;
    private final List<String> listOfModules;
    private IOperationRepo operationRepo;
    private final ServiceProvider services;
    private SessionModel sessionModel;
    private final String sdkVersion = OneSignalUtils.SDK_VERSION;
    private final IDebugManager debug = new DebugManager();
    private final Object initLock = new Object();
    private final Object loginLock = new Object();

    /* JADX INFO: renamed from: com.onesignal.internal.OneSignalImp$login$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.internal.OneSignalImp$login$2", f = "OneSignalImp.kt", l = {387}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements l {
        final /* synthetic */ a0 $currentIdentityExternalId;
        final /* synthetic */ a0 $currentIdentityOneSignalId;
        final /* synthetic */ String $externalId;
        final /* synthetic */ a0 $newIdentityOneSignalId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a0 a0Var, String str, a0 a0Var2, a0 a0Var3, c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$newIdentityOneSignalId = a0Var;
            this.$externalId = str;
            this.$currentIdentityExternalId = a0Var2;
            this.$currentIdentityOneSignalId = a0Var3;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return OneSignalImp.this.new AnonymousClass2(this.$newIdentityOneSignalId, this.$externalId, this.$currentIdentityExternalId, this.$currentIdentityOneSignalId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOperationRepo iOperationRepo = OneSignalImp.this.operationRepo;
                k.b(iOperationRepo);
                ConfigModel configModel = OneSignalImp.this.configModel;
                k.b(configModel);
                LoginUserOperation loginUserOperation = new LoginUserOperation(configModel.getAppId(), (String) this.$newIdentityOneSignalId.f12717a, this.$externalId, this.$currentIdentityExternalId.f12717a == null ? (String) this.$currentIdentityOneSignalId.f12717a : null);
                this.label = 1;
                obj = IOperationRepo.DefaultImpls.enqueueAndWait$default(iOperationRepo, loginUserOperation, false, this, 2, null);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                Logging.log(LogLevel.ERROR, "Could not login user");
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OneSignalImp() throws IllegalAccessException, InstantiationException {
        List<String> listH0 = m.H0("com.onesignal.notifications.NotificationsModule", "com.onesignal.inAppMessages.InAppMessagesModule", "com.onesignal.location.LocationModule");
        this.listOfModules = listH0;
        ServiceBuilder serviceBuilder = new ServiceBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CoreModule());
        arrayList.add(new SessionModule());
        arrayList.add(new UserModule());
        Iterator<String> it = listH0.iterator();
        while (it.hasNext()) {
            try {
                Object objNewInstance = Class.forName(it.next()).newInstance();
                k.c(objNewInstance, "null cannot be cast to non-null type com.onesignal.common.modules.IModule");
                arrayList.add((IModule) objNewInstance);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((IModule) obj).register(serviceBuilder);
        }
        this.services = serviceBuilder.build();
    }

    private final void createAndSwitchToNewUser(boolean z2, p pVar) {
        Object next;
        String strCreateLocalId;
        String address;
        SubscriptionStatus status;
        Logging.debug$default("createAndSwitchToNewUser()", null, 2, null);
        String strCreateLocalId2 = IDManager.INSTANCE.createLocalId();
        IdentityModel identityModel = new IdentityModel();
        identityModel.setOnesignalId(strCreateLocalId2);
        PropertiesModel propertiesModel = new PropertiesModel();
        propertiesModel.setOnesignalId(strCreateLocalId2);
        if (pVar != null) {
            pVar.invoke(identityModel, propertiesModel);
        }
        ArrayList arrayList = new ArrayList();
        SubscriptionModelStore subscriptionModelStore = getSubscriptionModelStore();
        k.b(subscriptionModelStore);
        Iterator it = subscriptionModelStore.list().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String id = ((SubscriptionModel) next).getId();
            ConfigModel configModel = this.configModel;
            k.b(configModel);
            if (k.a(id, configModel.getPushSubscriptionId())) {
                break;
            }
        }
        SubscriptionModel subscriptionModel = (SubscriptionModel) next;
        SubscriptionModel subscriptionModel2 = new SubscriptionModel();
        if (subscriptionModel == null || (strCreateLocalId = subscriptionModel.getId()) == null) {
            strCreateLocalId = IDManager.INSTANCE.createLocalId();
        }
        subscriptionModel2.setId(strCreateLocalId);
        subscriptionModel2.setType(SubscriptionType.PUSH);
        subscriptionModel2.setOptedIn(subscriptionModel != null ? subscriptionModel.getOptedIn() : true);
        if (subscriptionModel == null || (address = subscriptionModel.getAddress()) == null) {
            address = "";
        }
        subscriptionModel2.setAddress(address);
        if (subscriptionModel == null || (status = subscriptionModel.getStatus()) == null) {
            status = SubscriptionStatus.NO_PERMISSION;
        }
        subscriptionModel2.setStatus(status);
        subscriptionModel2.setSdk(OneSignalUtils.SDK_VERSION);
        String RELEASE = Build.VERSION.RELEASE;
        k.d(RELEASE, "RELEASE");
        subscriptionModel2.setDeviceOS(RELEASE);
        String carrierName = DeviceUtils.INSTANCE.getCarrierName(((IApplicationService) this.services.getService(IApplicationService.class)).getAppContext());
        if (carrierName == null) {
            carrierName = "";
        }
        subscriptionModel2.setCarrier(carrierName);
        String appVersion = AndroidUtils.INSTANCE.getAppVersion(((IApplicationService) this.services.getService(IApplicationService.class)).getAppContext());
        subscriptionModel2.setAppVersion(appVersion != null ? appVersion : "");
        ConfigModel configModel2 = this.configModel;
        k.b(configModel2);
        configModel2.setPushSubscriptionId(subscriptionModel2.getId());
        arrayList.add(subscriptionModel2);
        SubscriptionModelStore subscriptionModelStore2 = getSubscriptionModelStore();
        k.b(subscriptionModelStore2);
        subscriptionModelStore2.clear(ModelChangeTags.NO_PROPOGATE);
        IdentityModelStore identityModelStore = getIdentityModelStore();
        k.b(identityModelStore);
        ISingletonModelStore.DefaultImpls.replace$default(identityModelStore, identityModel, null, 2, null);
        PropertiesModelStore propertiesModelStore = getPropertiesModelStore();
        k.b(propertiesModelStore);
        ISingletonModelStore.DefaultImpls.replace$default(propertiesModelStore, propertiesModel, null, 2, null);
        if (z2) {
            SubscriptionModelStore subscriptionModelStore3 = getSubscriptionModelStore();
            k.b(subscriptionModelStore3);
            subscriptionModelStore3.replaceAll(arrayList, ModelChangeTags.NO_PROPOGATE);
        } else {
            SubscriptionModelStore subscriptionModelStore4 = getSubscriptionModelStore();
            k.b(subscriptionModelStore4);
            IModelStore.DefaultImpls.replaceAll$default(subscriptionModelStore4, arrayList, null, 2, null);
        }
    }

    public static /* synthetic */ void createAndSwitchToNewUser$default(OneSignalImp oneSignalImp, boolean z2, p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            pVar = null;
        }
        oneSignalImp.createAndSwitchToNewUser(z2, pVar);
    }

    private final IdentityModelStore getIdentityModelStore() {
        return (IdentityModelStore) this.services.getService(IdentityModelStore.class);
    }

    private final String getLegacyAppId() {
        return IPreferencesService.DefaultImpls.getString$default(getPreferencesService(), PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_LEGACY_APP_ID, null, 4, null);
    }

    private final IPreferencesService getPreferencesService() {
        return (IPreferencesService) this.services.getService(IPreferencesService.class);
    }

    private final PropertiesModelStore getPropertiesModelStore() {
        return (PropertiesModelStore) this.services.getService(PropertiesModelStore.class);
    }

    private final SubscriptionModelStore getSubscriptionModelStore() {
        return (SubscriptionModelStore) this.services.getService(SubscriptionModelStore.class);
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> List<T> getAllServices(Class<T> c7) {
        k.e(c7, "c");
        return this.services.getAllServices(c7);
    }

    @Override // com.onesignal.IOneSignal
    public boolean getConsentGiven() {
        Boolean consentGiven;
        ConfigModel configModel = this.configModel;
        return (configModel == null || (consentGiven = configModel.getConsentGiven()) == null) ? k.a(this._consentGiven, Boolean.TRUE) : consentGiven.booleanValue();
    }

    @Override // com.onesignal.IOneSignal
    public boolean getConsentRequired() {
        Boolean consentRequired;
        ConfigModel configModel = this.configModel;
        return (configModel == null || (consentRequired = configModel.getConsentRequired()) == null) ? k.a(this._consentRequired, Boolean.TRUE) : consentRequired.booleanValue();
    }

    @Override // com.onesignal.IOneSignal
    public IDebugManager getDebug() {
        return this.debug;
    }

    @Override // com.onesignal.IOneSignal
    public boolean getDisableGMSMissingPrompt() {
        ConfigModel configModel = this.configModel;
        return configModel != null ? configModel.getDisableGMSMissingPrompt() : k.a(this._disableGMSMissingPrompt, Boolean.TRUE);
    }

    @Override // com.onesignal.IOneSignal
    public IInAppMessagesManager getInAppMessages() throws Exception {
        if (isInitialized()) {
            return (IInAppMessagesManager) this.services.getService(IInAppMessagesManager.class);
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public ILocationManager getLocation() throws Exception {
        if (isInitialized()) {
            return (ILocationManager) this.services.getService(ILocationManager.class);
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public INotificationsManager getNotifications() throws Exception {
        if (isInitialized()) {
            return (INotificationsManager) this.services.getService(INotificationsManager.class);
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> T getService(Class<T> c7) {
        k.e(c7, "c");
        return (T) this.services.getService(c7);
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> T getServiceOrNull(Class<T> c7) {
        k.e(c7, "c");
        return (T) this.services.getServiceOrNull(c7);
    }

    @Override // com.onesignal.IOneSignal
    public ISessionManager getSession() throws Exception {
        if (isInitialized()) {
            return (ISessionManager) this.services.getService(ISessionManager.class);
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.IOneSignal
    public IUserManager getUser() throws Exception {
        if (isInitialized()) {
            return (IUserManager) this.services.getService(IUserManager.class);
        }
        throw new Exception("Must call 'initWithContext' before use");
    }

    @Override // com.onesignal.common.services.IServiceProvider
    public <T> boolean hasService(Class<T> c7) {
        k.e(c7, "c");
        return this.services.hasService(c7);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0180 A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0034, B:6:0x003b, B:11:0x0045, B:13:0x009e, B:15:0x00ab, B:17:0x00b1, B:20:0x00b8, B:23:0x00cc, B:25:0x00d9, B:28:0x00e9, B:29:0x00f1, B:31:0x00f5, B:32:0x0102, B:34:0x0106, B:35:0x0113, B:37:0x0117, B:38:0x0128, B:40:0x0134, B:43:0x014a, B:81:0x02d9, B:44:0x016c, B:46:0x0180, B:47:0x01c8, B:49:0x01e3, B:54:0x020a, B:61:0x021c, B:64:0x0229, B:66:0x022e, B:70:0x023c, B:72:0x0245, B:75:0x026c, B:78:0x0287, B:80:0x02a1, B:71:0x0240, B:57:0x0213, B:52:0x0204), top: B:86:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c8 A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0034, B:6:0x003b, B:11:0x0045, B:13:0x009e, B:15:0x00ab, B:17:0x00b1, B:20:0x00b8, B:23:0x00cc, B:25:0x00d9, B:28:0x00e9, B:29:0x00f1, B:31:0x00f5, B:32:0x0102, B:34:0x0106, B:35:0x0113, B:37:0x0117, B:38:0x0128, B:40:0x0134, B:43:0x014a, B:81:0x02d9, B:44:0x016c, B:46:0x0180, B:47:0x01c8, B:49:0x01e3, B:54:0x020a, B:61:0x021c, B:64:0x0229, B:66:0x022e, B:70:0x023c, B:72:0x0245, B:75:0x026c, B:78:0x0287, B:80:0x02a1, B:71:0x0240, B:57:0x0213, B:52:0x0204), top: B:86:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0034, B:6:0x003b, B:11:0x0045, B:13:0x009e, B:15:0x00ab, B:17:0x00b1, B:20:0x00b8, B:23:0x00cc, B:25:0x00d9, B:28:0x00e9, B:29:0x00f1, B:31:0x00f5, B:32:0x0102, B:34:0x0106, B:35:0x0113, B:37:0x0117, B:38:0x0128, B:40:0x0134, B:43:0x014a, B:81:0x02d9, B:44:0x016c, B:46:0x0180, B:47:0x01c8, B:49:0x01e3, B:54:0x020a, B:61:0x021c, B:64:0x0229, B:66:0x022e, B:70:0x023c, B:72:0x0245, B:75:0x026c, B:78:0x0287, B:80:0x02a1, B:71:0x0240, B:57:0x0213, B:52:0x0204), top: B:86:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0240 A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:4:0x0034, B:6:0x003b, B:11:0x0045, B:13:0x009e, B:15:0x00ab, B:17:0x00b1, B:20:0x00b8, B:23:0x00cc, B:25:0x00d9, B:28:0x00e9, B:29:0x00f1, B:31:0x00f5, B:32:0x0102, B:34:0x0106, B:35:0x0113, B:37:0x0117, B:38:0x0128, B:40:0x0134, B:43:0x014a, B:81:0x02d9, B:44:0x016c, B:46:0x0180, B:47:0x01c8, B:49:0x01e3, B:54:0x020a, B:61:0x021c, B:64:0x0229, B:66:0x022e, B:70:0x023c, B:72:0x0245, B:75:0x026c, B:78:0x0287, B:80:0x02a1, B:71:0x0240, B:57:0x0213, B:52:0x0204), top: B:86:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0285  */
    @Override // com.onesignal.IOneSignal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean initWithContext(android.content.Context r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.internal.OneSignalImp.initWithContext(android.content.Context, java.lang.String):boolean");
    }

    @Override // com.onesignal.IOneSignal
    public boolean isInitialized() {
        return this.isInitialized;
    }

    @Override // com.onesignal.IOneSignal
    public void login(String str) {
        IOneSignal.DefaultImpls.login(this, str);
    }

    @Override // com.onesignal.IOneSignal
    public void logout() throws Exception {
        Logging.log(LogLevel.DEBUG, "logout()");
        if (!isInitialized()) {
            throw new Exception("Must call 'initWithContext' before 'logout'");
        }
        synchronized (this.loginLock) {
            IdentityModelStore identityModelStore = getIdentityModelStore();
            k.b(identityModelStore);
            if (identityModelStore.getModel().getExternalId() == null) {
                return;
            }
            createAndSwitchToNewUser$default(this, false, null, 3, null);
            IOperationRepo iOperationRepo = this.operationRepo;
            k.b(iOperationRepo);
            ConfigModel configModel = this.configModel;
            k.b(configModel);
            String appId = configModel.getAppId();
            IdentityModelStore identityModelStore2 = getIdentityModelStore();
            k.b(identityModelStore2);
            String onesignalId = identityModelStore2.getModel().getOnesignalId();
            IdentityModelStore identityModelStore3 = getIdentityModelStore();
            k.b(identityModelStore3);
            IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo, new LoginUserOperation(appId, onesignalId, identityModelStore3.getModel().getExternalId(), null, 8, null), false, 2, null);
        }
    }

    @Override // com.onesignal.IOneSignal
    public void setConsentGiven(boolean z2) {
        IOperationRepo iOperationRepo;
        Boolean bool = this._consentGiven;
        this._consentGiven = Boolean.valueOf(z2);
        ConfigModel configModel = this.configModel;
        if (configModel != null) {
            configModel.setConsentGiven(Boolean.valueOf(z2));
        }
        if (k.a(bool, Boolean.valueOf(z2)) || !z2 || (iOperationRepo = this.operationRepo) == null) {
            return;
        }
        iOperationRepo.forceExecuteOperations();
    }

    @Override // com.onesignal.IOneSignal
    public void setConsentRequired(boolean z2) {
        this._consentRequired = Boolean.valueOf(z2);
        ConfigModel configModel = this.configModel;
        if (configModel == null) {
            return;
        }
        configModel.setConsentRequired(Boolean.valueOf(z2));
    }

    @Override // com.onesignal.IOneSignal
    public void setDisableGMSMissingPrompt(boolean z2) {
        this._disableGMSMissingPrompt = Boolean.valueOf(z2);
        ConfigModel configModel = this.configModel;
        if (configModel == null) {
            return;
        }
        configModel.setDisableGMSMissingPrompt(z2);
    }

    public void setInitialized(boolean z2) {
        this.isInitialized = z2;
    }

    @Override // com.onesignal.IOneSignal
    public void login(String externalId, String str) throws Exception {
        k.e(externalId, "externalId");
        Logging.log(LogLevel.DEBUG, "login(externalId: " + externalId + ", jwtBearerToken: " + str + ')');
        if (!isInitialized()) {
            throw new Exception("Must call 'initWithContext' before 'login'");
        }
        a0 a0Var = new a0();
        a0 a0Var2 = new a0();
        a0 a0Var3 = new a0();
        a0Var3.f12717a = "";
        synchronized (this.loginLock) {
            IdentityModelStore identityModelStore = getIdentityModelStore();
            k.b(identityModelStore);
            a0Var.f12717a = identityModelStore.getModel().getExternalId();
            IdentityModelStore identityModelStore2 = getIdentityModelStore();
            k.b(identityModelStore2);
            a0Var2.f12717a = identityModelStore2.getModel().getOnesignalId();
            if (k.a(a0Var.f12717a, externalId)) {
                return;
            }
            createAndSwitchToNewUser$default(this, false, new OneSignalImp$login$1$1(externalId), 1, null);
            IdentityModelStore identityModelStore3 = getIdentityModelStore();
            k.b(identityModelStore3);
            a0Var3.f12717a = identityModelStore3.getModel().getOnesignalId();
            ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass2(a0Var3, externalId, a0Var, a0Var2, null), 1, null);
        }
    }
}

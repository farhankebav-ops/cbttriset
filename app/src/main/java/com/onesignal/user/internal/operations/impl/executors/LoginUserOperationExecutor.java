package com.onesignal.user.internal.operations.impl.executors;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.RootToolsInternalMethods;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import com.vungle.ads.internal.protos.Sdk;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;
import r5.l;
import r5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoginUserOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion(null);
    public static final String LOGIN_USER = "login-user";
    private final IApplicationService _application;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IdentityOperationExecutor _identityOperationExecutor;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;
    private final IUserBackendService _userBackend;

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
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ExecutionResult.values().length];
            iArr[ExecutionResult.SUCCESS.ordinal()] = 1;
            iArr[ExecutionResult.FAIL_CONFLICT.ordinal()] = 2;
            iArr[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr2[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr2[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SubscriptionType.values().length];
            iArr3[SubscriptionType.SMS.ordinal()] = 1;
            iArr3[SubscriptionType.EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$createUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor", f = "LoginUserOperationExecutor.kt", l = {171}, m = "createUser")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginUserOperationExecutor.this.createUser(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$loginUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor", f = "LoginUserOperationExecutor.kt", l = {81, 87, 128, Sdk.SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE}, m = "loginUser")
    public static final class C28401 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C28401(v5.c<? super C28401> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginUserOperationExecutor.this.loginUser(null, null, this);
        }
    }

    public LoginUserOperationExecutor(IdentityOperationExecutor _identityOperationExecutor, IApplicationService _application, IDeviceService _deviceService, IUserBackendService _userBackend, IdentityModelStore _identityModelStore, PropertiesModelStore _propertiesModelStore, SubscriptionModelStore _subscriptionsModelStore, ConfigModelStore _configModelStore, ILanguageContext _languageContext) {
        k.e(_identityOperationExecutor, "_identityOperationExecutor");
        k.e(_application, "_application");
        k.e(_deviceService, "_deviceService");
        k.e(_userBackend, "_userBackend");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_propertiesModelStore, "_propertiesModelStore");
        k.e(_subscriptionsModelStore, "_subscriptionsModelStore");
        k.e(_configModelStore, "_configModelStore");
        k.e(_languageContext, "_languageContext");
        this._identityOperationExecutor = _identityOperationExecutor;
        this._application = _application;
        this._deviceService = _deviceService;
        this._userBackend = _userBackend;
        this._identityModelStore = _identityModelStore;
        this._propertiesModelStore = _propertiesModelStore;
        this._subscriptionsModelStore = _subscriptionsModelStore;
        this._configModelStore = _configModelStore;
        this._languageContext = _languageContext;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(TransferSubscriptionOperation transferSubscriptionOperation, Map<String, SubscriptionObject> map) {
        LinkedHashMap linkedHashMapO0 = x.o0(map);
        if (!linkedHashMapO0.containsKey(transferSubscriptionOperation.getSubscriptionId())) {
            linkedHashMapO0.put(transferSubscriptionOperation.getSubscriptionId(), new SubscriptionObject(transferSubscriptionOperation.getSubscriptionId(), null, null, null, null, null, null, null, null, null, null, null, 4094, null));
            return linkedHashMapO0;
        }
        String subscriptionId = transferSubscriptionOperation.getSubscriptionId();
        String subscriptionId2 = transferSubscriptionOperation.getSubscriptionId();
        SubscriptionObject subscriptionObject = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject);
        SubscriptionObjectType type = subscriptionObject.getType();
        SubscriptionObject subscriptionObject2 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject2);
        String token = subscriptionObject2.getToken();
        SubscriptionObject subscriptionObject3 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject3);
        Boolean enabled = subscriptionObject3.getEnabled();
        SubscriptionObject subscriptionObject4 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject4);
        Integer notificationTypes = subscriptionObject4.getNotificationTypes();
        SubscriptionObject subscriptionObject5 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject5);
        String sdk = subscriptionObject5.getSdk();
        SubscriptionObject subscriptionObject6 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject6);
        String deviceModel = subscriptionObject6.getDeviceModel();
        SubscriptionObject subscriptionObject7 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject7);
        String deviceOS = subscriptionObject7.getDeviceOS();
        SubscriptionObject subscriptionObject8 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject8);
        Boolean rooted = subscriptionObject8.getRooted();
        SubscriptionObject subscriptionObject9 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject9);
        Integer netType = subscriptionObject9.getNetType();
        SubscriptionObject subscriptionObject10 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject10);
        String carrier = subscriptionObject10.getCarrier();
        SubscriptionObject subscriptionObject11 = map.get(transferSubscriptionOperation.getSubscriptionId());
        k.b(subscriptionObject11);
        linkedHashMapO0.put(subscriptionId, new SubscriptionObject(subscriptionId2, type, token, enabled, notificationTypes, sdk, deviceModel, deviceOS, rooted, netType, carrier, subscriptionObject11.getAppVersion()));
        return linkedHashMapO0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createUser(com.onesignal.user.internal.operations.LoginUserOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.createUser(com.onesignal.user.internal.operations.LoginUserOperation, java.util.List, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginUser(com.onesignal.user.internal.operations.LoginUserOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.loginUser(com.onesignal.user.internal.operations.LoginUserOperation, java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List<? extends Operation> list, v5.c<? super ExecutionResponse> cVar) throws Exception {
        Logging.debug$default("LoginUserOperationExecutor(operation: " + list + ')', null, 2, null);
        Operation operation = (Operation) l.X0(list);
        if (operation instanceof LoginUserOperation) {
            return loginUser((LoginUserOperation) operation, l.V0(list), cVar);
        }
        throw new Exception("Unrecognized operation: " + operation);
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return q.j0(LOGIN_USER);
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(CreateSubscriptionOperation createSubscriptionOperation, Map<String, SubscriptionObject> map) {
        SubscriptionObjectType subscriptionObjectTypeFromDeviceType;
        LinkedHashMap linkedHashMapO0 = x.o0(map);
        int i2 = WhenMappings.$EnumSwitchMapping$2[createSubscriptionOperation.getType().ordinal()];
        if (i2 == 1) {
            subscriptionObjectTypeFromDeviceType = SubscriptionObjectType.SMS;
        } else if (i2 != 2) {
            subscriptionObjectTypeFromDeviceType = SubscriptionObjectType.Companion.fromDeviceType(this._deviceService.getDeviceType());
        } else {
            subscriptionObjectTypeFromDeviceType = SubscriptionObjectType.EMAIL;
        }
        SubscriptionObjectType subscriptionObjectType = subscriptionObjectTypeFromDeviceType;
        String subscriptionId = !IDManager.INSTANCE.isLocalId(createSubscriptionOperation.getSubscriptionId()) ? createSubscriptionOperation.getSubscriptionId() : null;
        String subscriptionId2 = createSubscriptionOperation.getSubscriptionId();
        String address = createSubscriptionOperation.getAddress();
        Boolean boolValueOf = Boolean.valueOf(createSubscriptionOperation.getEnabled());
        Integer numValueOf = Integer.valueOf(createSubscriptionOperation.getStatus().getValue());
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        Boolean boolValueOf2 = Boolean.valueOf(RootToolsInternalMethods.INSTANCE.isRooted());
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        linkedHashMapO0.put(subscriptionId2, new SubscriptionObject(subscriptionId, subscriptionObjectType, address, boolValueOf, numValueOf, OneSignalUtils.SDK_VERSION, str, str2, boolValueOf2, deviceUtils.getNetType(this._application.getAppContext()), deviceUtils.getCarrierName(this._application.getAppContext()), AndroidUtils.INSTANCE.getAppVersion(this._application.getAppContext())));
        return linkedHashMapO0;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(UpdateSubscriptionOperation updateSubscriptionOperation, Map<String, SubscriptionObject> map) {
        LinkedHashMap linkedHashMapO0 = x.o0(map);
        if (linkedHashMapO0.containsKey(updateSubscriptionOperation.getSubscriptionId())) {
            String subscriptionId = updateSubscriptionOperation.getSubscriptionId();
            SubscriptionObject subscriptionObject = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject);
            String id = subscriptionObject.getId();
            SubscriptionObject subscriptionObject2 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject2);
            SubscriptionObjectType type = subscriptionObject2.getType();
            String address = updateSubscriptionOperation.getAddress();
            Boolean boolValueOf = Boolean.valueOf(updateSubscriptionOperation.getEnabled());
            Integer numValueOf = Integer.valueOf(updateSubscriptionOperation.getStatus().getValue());
            SubscriptionObject subscriptionObject3 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject3);
            String sdk = subscriptionObject3.getSdk();
            SubscriptionObject subscriptionObject4 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject4);
            String deviceModel = subscriptionObject4.getDeviceModel();
            SubscriptionObject subscriptionObject5 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject5);
            String deviceOS = subscriptionObject5.getDeviceOS();
            SubscriptionObject subscriptionObject6 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject6);
            Boolean rooted = subscriptionObject6.getRooted();
            SubscriptionObject subscriptionObject7 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject7);
            Integer netType = subscriptionObject7.getNetType();
            SubscriptionObject subscriptionObject8 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject8);
            String carrier = subscriptionObject8.getCarrier();
            SubscriptionObject subscriptionObject9 = map.get(updateSubscriptionOperation.getSubscriptionId());
            k.b(subscriptionObject9);
            linkedHashMapO0.put(subscriptionId, new SubscriptionObject(id, type, address, boolValueOf, numValueOf, sdk, deviceModel, deviceOS, rooted, netType, carrier, subscriptionObject9.getAppVersion()));
        }
        return linkedHashMapO0;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(DeleteSubscriptionOperation deleteSubscriptionOperation, Map<String, SubscriptionObject> map) {
        LinkedHashMap linkedHashMapO0 = x.o0(map);
        linkedHashMapO0.remove(deleteSubscriptionOperation.getSubscriptionId());
        return linkedHashMapO0;
    }
}

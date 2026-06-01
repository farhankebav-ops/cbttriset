package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;
import r5.l;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoginUserFromSubscriptionOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion(null);
    public static final String LOGIN_USER_FROM_SUBSCRIPTION_USER = "login-user-from-subscription";
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final ISubscriptionBackendService _subscriptionBackend;

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

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor$loginUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor", f = "LoginUserFromSubscriptionOperationExecutor.kt", l = {46}, m = "loginUser")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginUserFromSubscriptionOperationExecutor.this.loginUser(null, this);
        }
    }

    public LoginUserFromSubscriptionOperationExecutor(ISubscriptionBackendService _subscriptionBackend, IdentityModelStore _identityModelStore, PropertiesModelStore _propertiesModelStore) {
        k.e(_subscriptionBackend, "_subscriptionBackend");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_propertiesModelStore, "_propertiesModelStore");
        this._subscriptionBackend = _subscriptionBackend;
        this._identityModelStore = _identityModelStore;
        this._propertiesModelStore = _propertiesModelStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginUser(com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation r17, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor.loginUser(com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List<? extends Operation> list, v5.c<? super ExecutionResponse> cVar) throws Exception {
        Logging.debug$default("LoginUserFromSubscriptionOperationExecutor(operation: " + list + ')', null, 2, null);
        if (list.size() > 1) {
            throw new Exception("Only supports one operation! Attempted operations:\n" + list);
        }
        Operation operation = (Operation) l.X0(list);
        if (operation instanceof LoginUserFromSubscriptionOperation) {
            return loginUser((LoginUserFromSubscriptionOperation) operation, cVar);
        }
        throw new Exception("Unrecognized operation: " + operation);
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return q.j0(LOGIN_USER_FROM_SUBSCRIPTION_USER);
    }
}

package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;
import r5.l;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RefreshUserOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion(null);
    public static final String REFRESH_USER = "refresh-user";
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final NewRecordsState _newRecordState;
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

        static {
            int[] iArr = new int[SubscriptionObjectType.values().length];
            iArr[SubscriptionObjectType.EMAIL.ordinal()] = 1;
            iArr[SubscriptionObjectType.SMS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr2[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr2[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            iArr2[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor$getUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor", f = "RefreshUserOperationExecutor.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE}, m = "getUser")
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
            return RefreshUserOperationExecutor.this.getUser(null, this);
        }
    }

    public RefreshUserOperationExecutor(IUserBackendService _userBackend, IdentityModelStore _identityModelStore, PropertiesModelStore _propertiesModelStore, SubscriptionModelStore _subscriptionsModelStore, ConfigModelStore _configModelStore, IRebuildUserService _buildUserService, NewRecordsState _newRecordState) {
        k.e(_userBackend, "_userBackend");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_propertiesModelStore, "_propertiesModelStore");
        k.e(_subscriptionsModelStore, "_subscriptionsModelStore");
        k.e(_configModelStore, "_configModelStore");
        k.e(_buildUserService, "_buildUserService");
        k.e(_newRecordState, "_newRecordState");
        this._userBackend = _userBackend;
        this._identityModelStore = _identityModelStore;
        this._propertiesModelStore = _propertiesModelStore;
        this._subscriptionsModelStore = _subscriptionsModelStore;
        this._configModelStore = _configModelStore;
        this._buildUserService = _buildUserService;
        this._newRecordState = _newRecordState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[Catch: BackendException -> 0x0036, TryCatch #2 {BackendException -> 0x0036, blocks: (B:12:0x0032, B:25:0x0061, B:27:0x0079, B:29:0x0087, B:30:0x0098, B:32:0x009e, B:33:0x00b0, B:35:0x00c6, B:36:0x00d1, B:38:0x00db, B:39:0x00e6, B:41:0x00f0, B:42:0x0100, B:44:0x0106, B:46:0x0112, B:47:0x0125, B:49:0x012f, B:50:0x013a, B:51:0x0147, B:53:0x014d, B:57:0x016b, B:59:0x0176, B:61:0x0181, B:63:0x0187, B:64:0x0189, B:67:0x019f, B:70:0x01a7, B:72:0x01b2, B:76:0x01bd, B:79:0x01c7, B:82:0x01d1, B:85:0x01db, B:89:0x01e6, B:91:0x01f1, B:68:0x01a2, B:69:0x01a5, B:60:0x017b, B:92:0x01f6, B:94:0x0204, B:96:0x020e, B:97:0x0211), top: B:127:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087 A[Catch: BackendException -> 0x0036, TryCatch #2 {BackendException -> 0x0036, blocks: (B:12:0x0032, B:25:0x0061, B:27:0x0079, B:29:0x0087, B:30:0x0098, B:32:0x009e, B:33:0x00b0, B:35:0x00c6, B:36:0x00d1, B:38:0x00db, B:39:0x00e6, B:41:0x00f0, B:42:0x0100, B:44:0x0106, B:46:0x0112, B:47:0x0125, B:49:0x012f, B:50:0x013a, B:51:0x0147, B:53:0x014d, B:57:0x016b, B:59:0x0176, B:61:0x0181, B:63:0x0187, B:64:0x0189, B:67:0x019f, B:70:0x01a7, B:72:0x01b2, B:76:0x01bd, B:79:0x01c7, B:82:0x01d1, B:85:0x01db, B:89:0x01e6, B:91:0x01f1, B:68:0x01a2, B:69:0x01a5, B:60:0x017b, B:92:0x01f6, B:94:0x0204, B:96:0x020e, B:97:0x0211), top: B:127:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUser(com.onesignal.user.internal.operations.RefreshUserOperation r18, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 723
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.getUser(com.onesignal.user.internal.operations.RefreshUserOperation, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List<? extends Operation> list, v5.c<? super ExecutionResponse> cVar) throws Exception {
        Logging.log(LogLevel.DEBUG, "RefreshUserOperationExecutor(operation: " + list + ')');
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!(((Operation) it.next()) instanceof RefreshUserOperation)) {
                    throw new Exception("Unrecognized operation(s)! Attempted operations:\n" + list);
                }
            }
        }
        Operation operation = (Operation) l.X0(list);
        if (operation instanceof RefreshUserOperation) {
            return getUser((RefreshUserOperation) operation, cVar);
        }
        throw new Exception("Unrecognized operation: " + operation);
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return q.j0(REFRESH_USER);
    }
}

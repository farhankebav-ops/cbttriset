package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.m;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IdentityOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion(null);
    public static final String DELETE_ALIAS = "delete-alias";
    public static final String SET_ALIAS = "set-alias";
    private final IRebuildUserService _buildUserService;
    private final IIdentityBackendService _identityBackend;
    private final IdentityModelStore _identityModelStore;
    private final NewRecordsState _newRecordState;

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
            iArr[NetworkUtils.ResponseStatusType.INVALID.ordinal()] = 2;
            iArr[NetworkUtils.ResponseStatusType.CONFLICT.ordinal()] = 3;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            iArr[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor", f = "IdentityOperationExecutor.kt", l = {48, 91}, m = "execute")
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
            return IdentityOperationExecutor.this.execute(null, this);
        }
    }

    public IdentityOperationExecutor(IIdentityBackendService _identityBackend, IdentityModelStore _identityModelStore, IRebuildUserService _buildUserService, NewRecordsState _newRecordState) {
        k.e(_identityBackend, "_identityBackend");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_buildUserService, "_buildUserService");
        k.e(_newRecordState, "_newRecordState");
        this._identityBackend = _identityBackend;
        this._identityModelStore = _identityModelStore;
        this._buildUserService = _buildUserService;
        this._newRecordState = _newRecordState;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x026e A[Catch: BackendException -> 0x0040, TRY_LEAVE, TryCatch #0 {BackendException -> 0x0040, blocks: (B:14:0x003b, B:103:0x0255, B:105:0x026e), top: B:131:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014b A[Catch: BackendException -> 0x005a, TRY_LEAVE, TryCatch #2 {BackendException -> 0x005a, blocks: (B:21:0x0055, B:66:0x0132, B:68:0x014b), top: B:135:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0218  */
    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(java.util.List<? extends com.onesignal.core.internal.operations.Operation> r24, v5.c<? super com.onesignal.core.internal.operations.ExecutionResponse> r25) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.execute(java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.core.internal.operations.IOperationExecutor
    public List<String> getOperations() {
        return m.H0(SET_ALIAS, DELETE_ALIAS);
    }
}

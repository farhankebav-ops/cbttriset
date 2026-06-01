package com.onesignal.user.internal.migrations;

import com.onesignal.common.IDManager;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserOperation;
import e6.p;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import q6.z0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;
import x6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RecoverFromDroppedLoginBug implements IStartableService {
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;

    /* JADX INFO: renamed from: com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug$start$1", f = "RecoverFromDroppedLoginBug.kt", l = {39}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return RecoverFromDroppedLoginBug.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOperationRepo iOperationRepo = RecoverFromDroppedLoginBug.this._operationRepo;
                this.label = 1;
                if (iOperationRepo.awaitInitialized(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            if (RecoverFromDroppedLoginBug.this.isInBadState()) {
                Logging.warn$default("User with externalId:" + RecoverFromDroppedLoginBug.this._identityModelStore.getModel().getExternalId() + " was in a bad state, causing it to not update on OneSignal's backend! We are recovering and replaying all unsent operations now.", null, 2, null);
                RecoverFromDroppedLoginBug.this.recoverByAddingBackDroppedLoginOperation();
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public RecoverFromDroppedLoginBug(IOperationRepo _operationRepo, IdentityModelStore _identityModelStore, ConfigModelStore _configModelStore) {
        k.e(_operationRepo, "_operationRepo");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_configModelStore, "_configModelStore");
        this._operationRepo = _operationRepo;
        this._identityModelStore = _identityModelStore;
        this._configModelStore = _configModelStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInBadState() {
        return (this._identityModelStore.getModel().getExternalId() == null || !IDManager.INSTANCE.isLocalId(this._identityModelStore.getModel().getOnesignalId()) || this._operationRepo.containsInstanceOf(b0.a(LoginUserOperation.class))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recoverByAddingBackDroppedLoginOperation() {
        IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new LoginUserOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), this._identityModelStore.getModel().getExternalId(), null), false, 2, null);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        x6.e eVar = m0.f13566a;
        c0.u(z0.f13606a, d.f17810a, new AnonymousClass1(null), 2);
    }
}

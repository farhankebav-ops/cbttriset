package com.onesignal.user.internal.service;

import com.onesignal.common.IDManager;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UserRefreshService implements IStartableService, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final ISessionService _sessionService;

    public UserRefreshService(IApplicationService _applicationService, ISessionService _sessionService, IOperationRepo _operationRepo, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore) {
        k.e(_applicationService, "_applicationService");
        k.e(_sessionService, "_sessionService");
        k.e(_operationRepo, "_operationRepo");
        k.e(_configModelStore, "_configModelStore");
        k.e(_identityModelStore, "_identityModelStore");
        this._applicationService = _applicationService;
        this._sessionService = _sessionService;
        this._operationRepo = _operationRepo;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
    }

    private final void refreshUser() {
        if (IDManager.INSTANCE.isLocalId(this._identityModelStore.getModel().getOnesignalId()) || !this._applicationService.isInForeground()) {
            return;
        }
        IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new RefreshUserOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId()), false, 2, null);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        refreshUser();
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._sessionService.subscribe(this);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long j) {
    }
}

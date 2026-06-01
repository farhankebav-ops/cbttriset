package com.onesignal.user;

import com.ironsource.adqualitysdk.sdk.i.a0;
import com.onesignal.common.consistency.impl.ConsistencyManager;
import com.onesignal.common.consistency.models.IConsistencyManager;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.UserManager;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.impl.IdentityBackendService;
import com.onesignal.user.internal.backend.impl.SubscriptionBackendService;
import com.onesignal.user.internal.backend.impl.UserBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.builduser.impl.RebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.migrations.RecoverConfigPushSubscription;
import com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug;
import com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.listeners.IdentityModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.PropertiesModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.SubscriptionModelStoreListener;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.service.UserRefreshService;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.impl.SubscriptionManager;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UserModule implements IModule {
    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        k.e(builder, "builder");
        builder.register(ConsistencyManager.class).provides(IConsistencyManager.class);
        builder.register(PropertiesModelStore.class).provides(PropertiesModelStore.class);
        builder.register(PropertiesModelStoreListener.class).provides(IBootstrapService.class);
        a0.k(builder, IdentityModelStore.class, IdentityModelStore.class, IdentityModelStoreListener.class, IBootstrapService.class);
        builder.register(IdentityBackendService.class).provides(IIdentityBackendService.class);
        builder.register(IdentityOperationExecutor.class).provides(IdentityOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(SubscriptionModelStore.class).provides(SubscriptionModelStore.class);
        a0.k(builder, SubscriptionModelStoreListener.class, IBootstrapService.class, SubscriptionBackendService.class, ISubscriptionBackendService.class);
        builder.register(SubscriptionOperationExecutor.class).provides(SubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(SubscriptionManager.class).provides(ISubscriptionManager.class);
        builder.register(RebuildUserService.class).provides(IRebuildUserService.class);
        builder.register(UserBackendService.class).provides(IUserBackendService.class);
        builder.register(UpdateUserOperationExecutor.class).provides(UpdateUserOperationExecutor.class).provides(IOperationExecutor.class);
        builder.register(LoginUserOperationExecutor.class).provides(IOperationExecutor.class);
        a0.k(builder, LoginUserFromSubscriptionOperationExecutor.class, IOperationExecutor.class, RefreshUserOperationExecutor.class, IOperationExecutor.class);
        a0.k(builder, UserManager.class, IUserManager.class, UserRefreshService.class, IStartableService.class);
        a0.k(builder, RecoverFromDroppedLoginBug.class, IStartableService.class, RecoverConfigPushSubscription.class, IStartableService.class);
        builder.register(NewRecordsState.class).provides(NewRecordsState.class);
    }
}

package com.onesignal.user.internal.operations.impl.listeners;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.DeleteAliasOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IdentityModelStoreListener extends SingletonModelStoreListener<IdentityModel> {
    private final ConfigModelStore _configModelStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentityModelStoreListener(IdentityModelStore store, IOperationRepo opRepo, ConfigModelStore _configModelStore) {
        super(store, opRepo);
        k.e(store, "store");
        k.e(opRepo, "opRepo");
        k.e(_configModelStore, "_configModelStore");
        this._configModelStore = _configModelStore;
    }

    @Override // com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener
    public Operation getReplaceOperation(IdentityModel model) {
        k.e(model, "model");
        return null;
    }

    @Override // com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener
    public Operation getUpdateOperation(IdentityModel model, String path, String property, Object obj, Object obj2) {
        k.e(model, "model");
        k.e(path, "path");
        k.e(property, "property");
        return (obj2 == null || !(obj2 instanceof String)) ? new DeleteAliasOperation(this._configModelStore.getModel().getAppId(), model.getOnesignalId(), property) : new SetAliasOperation(this._configModelStore.getModel().getAppId(), model.getOnesignalId(), property, (String) obj2);
    }
}

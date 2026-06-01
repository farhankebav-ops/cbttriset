package com.onesignal.user.internal.operations.impl.listeners;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertiesModelStoreListener extends SingletonModelStoreListener<PropertiesModel> {
    private final ConfigModelStore _configModelStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertiesModelStoreListener(PropertiesModelStore store, IOperationRepo opRepo, ConfigModelStore _configModelStore) {
        super(store, opRepo);
        k.e(store, "store");
        k.e(opRepo, "opRepo");
        k.e(_configModelStore, "_configModelStore");
        this._configModelStore = _configModelStore;
    }

    @Override // com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener
    public Operation getReplaceOperation(PropertiesModel model) {
        k.e(model, "model");
        return null;
    }

    @Override // com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener
    public Operation getUpdateOperation(PropertiesModel model, String path, String property, Object obj, Object obj2) {
        k.e(model, "model");
        k.e(path, "path");
        k.e(property, "property");
        if (t.n0(path, "locationTimestamp", false) || t.n0(path, "locationBackground", false) || t.n0(path, "locationType", false) || t.n0(path, "locationAccuracy", false)) {
            return null;
        }
        return t.n0(path, "tags", false) ? (obj2 == null || !(obj2 instanceof String)) ? new DeleteTagOperation(this._configModelStore.getModel().getAppId(), model.getOnesignalId(), property) : new SetTagOperation(this._configModelStore.getModel().getAppId(), model.getOnesignalId(), property, (String) obj2) : new SetPropertyOperation(this._configModelStore.getModel().getAppId(), model.getOnesignalId(), property, obj2);
    }
}

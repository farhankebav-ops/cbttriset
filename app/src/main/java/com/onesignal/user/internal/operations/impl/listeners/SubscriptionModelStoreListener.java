package com.onesignal.user.internal.operations.impl.listeners;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.ModelStoreListener;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriptionModelStoreListener extends ModelStoreListener<SubscriptionModel> {
    public static final Companion Companion = new Companion(null);
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final q5.i getSubscriptionEnabledAndStatus(com.onesignal.user.internal.subscriptions.SubscriptionModel r3) {
            /*
                r2 = this;
                java.lang.String r0 = "model"
                kotlin.jvm.internal.k.e(r3, r0)
                boolean r0 = r3.getOptedIn()
                if (r0 == 0) goto L1f
                com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = r3.getStatus()
                com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
                if (r0 != r1) goto L1f
                java.lang.String r0 = r3.getAddress()
                int r0 = r0.length()
                if (r0 <= 0) goto L1f
                r3 = 1
                goto L2f
            L1f:
                boolean r0 = r3.getOptedIn()
                if (r0 != 0) goto L29
                com.onesignal.user.internal.subscriptions.SubscriptionStatus r3 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.UNSUBSCRIBE
            L27:
                r1 = r3
                goto L2e
            L29:
                com.onesignal.user.internal.subscriptions.SubscriptionStatus r3 = r3.getStatus()
                goto L27
            L2e:
                r3 = 0
            L2f:
                q5.i r0 = new q5.i
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                r0.<init>(r3, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.listeners.SubscriptionModelStoreListener.Companion.getSubscriptionEnabledAndStatus(com.onesignal.user.internal.subscriptions.SubscriptionModel):q5.i");
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionModelStoreListener(SubscriptionModelStore store, IOperationRepo opRepo, IdentityModelStore _identityModelStore, ConfigModelStore _configModelStore) {
        super(store, opRepo);
        k.e(store, "store");
        k.e(opRepo, "opRepo");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_configModelStore, "_configModelStore");
        this._identityModelStore = _identityModelStore;
        this._configModelStore = _configModelStore;
    }

    @Override // com.onesignal.core.internal.operations.listeners.ModelStoreListener
    public Operation getAddOperation(SubscriptionModel model) {
        k.e(model, "model");
        i subscriptionEnabledAndStatus = Companion.getSubscriptionEnabledAndStatus(model);
        return new CreateSubscriptionOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), model.getId(), model.getType(), ((Boolean) subscriptionEnabledAndStatus.f13498a).booleanValue(), model.getAddress(), (SubscriptionStatus) subscriptionEnabledAndStatus.f13499b);
    }

    @Override // com.onesignal.core.internal.operations.listeners.ModelStoreListener
    public Operation getRemoveOperation(SubscriptionModel model) {
        k.e(model, "model");
        return new DeleteSubscriptionOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), model.getId());
    }

    @Override // com.onesignal.core.internal.operations.listeners.ModelStoreListener
    public Operation getUpdateOperation(SubscriptionModel model, String path, String property, Object obj, Object obj2) {
        k.e(model, "model");
        k.e(path, "path");
        k.e(property, "property");
        i subscriptionEnabledAndStatus = Companion.getSubscriptionEnabledAndStatus(model);
        return new UpdateSubscriptionOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), model.getId(), model.getType(), ((Boolean) subscriptionEnabledAndStatus.f13498a).booleanValue(), model.getAddress(), (SubscriptionStatus) subscriptionEnabledAndStatus.f13499b);
    }
}

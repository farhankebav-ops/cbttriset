package com.onesignal.core.internal.operations.impl;

import a1.a;
import com.onesignal.common.modeling.ModelStore;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteAliasOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import java.util.Set;
import kotlin.jvm.internal.k;
import n7.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OperationModelStore extends ModelStore<Operation> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationModelStore(IPreferencesService prefs) {
        super("operations", prefs);
        k.e(prefs, "prefs");
    }

    private final boolean isValidOperation(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("name")) {
            Logging.error$default("jsonObject must have 'name' attribute", null, 2, null);
            return false;
        }
        String string = jSONObject.getString("name");
        Set setO = b.O(LoginUserOperationExecutor.LOGIN_USER, LoginUserFromSubscriptionOperationExecutor.LOGIN_USER_FROM_SUBSCRIPTION_USER);
        if (jSONObject.has("onesignalId") || setO.contains(string)) {
            return true;
        }
        Logging.error$default(string + " jsonObject must have 'onesignalId' attribute", null, 2, null);
        return false;
    }

    public final void loadOperations() {
        load();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.onesignal.common.modeling.IModelStore
    public Operation create(JSONObject jSONObject) throws Exception {
        Operation deleteAliasOperation;
        if (jSONObject == null) {
            Logging.error$default("null jsonObject sent to OperationModelStore.create", null, 2, null);
            return null;
        }
        if (!isValidOperation(jSONObject)) {
            return null;
        }
        String string = jSONObject.getString("name");
        if (string != null) {
            switch (string.hashCode()) {
                case -1865677906:
                    if (string.equals(IdentityOperationExecutor.DELETE_ALIAS)) {
                        deleteAliasOperation = new DeleteAliasOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1793763409:
                    if (string.equals(LoginUserOperationExecutor.LOGIN_USER)) {
                        deleteAliasOperation = new LoginUserOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1606689981:
                    if (string.equals(UpdateUserOperationExecutor.TRACK_PURCHASE)) {
                        deleteAliasOperation = new TrackPurchaseOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1188793632:
                    if (string.equals(UpdateUserOperationExecutor.SET_PROPERTY)) {
                        deleteAliasOperation = new SetPropertyOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -1080179201:
                    if (string.equals(SubscriptionOperationExecutor.DELETE_SUBSCRIPTION)) {
                        deleteAliasOperation = new DeleteSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -828599391:
                    if (string.equals(SubscriptionOperationExecutor.UPDATE_SUBSCRIPTION)) {
                        deleteAliasOperation = new UpdateSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -516221659:
                    if (string.equals(IdentityOperationExecutor.SET_ALIAS)) {
                        deleteAliasOperation = new SetAliasOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case -92337283:
                    if (string.equals(RefreshUserOperationExecutor.REFRESH_USER)) {
                        deleteAliasOperation = new RefreshUserOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 532599746:
                    if (string.equals(LoginUserFromSubscriptionOperationExecutor.LOGIN_USER_FROM_SUBSCRIPTION_USER)) {
                        deleteAliasOperation = new LoginUserFromSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 846157390:
                    if (string.equals(SubscriptionOperationExecutor.CREATE_SUBSCRIPTION)) {
                        deleteAliasOperation = new CreateSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1707031487:
                    if (string.equals(SubscriptionOperationExecutor.TRANSFER_SUBSCRIPTION)) {
                        deleteAliasOperation = new TransferSubscriptionOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1763437688:
                    if (string.equals(UpdateUserOperationExecutor.DELETE_TAG)) {
                        deleteAliasOperation = new DeleteTagOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1852485538:
                    if (string.equals(UpdateUserOperationExecutor.TRACK_SESSION_END)) {
                        deleteAliasOperation = new TrackSessionEndOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 1983836079:
                    if (string.equals(UpdateUserOperationExecutor.SET_TAG)) {
                        deleteAliasOperation = new SetTagOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
                case 2135250281:
                    if (string.equals(UpdateUserOperationExecutor.TRACK_SESSION_START)) {
                        deleteAliasOperation = new TrackSessionStartOperation();
                        deleteAliasOperation.initializeFromJson(jSONObject);
                        return deleteAliasOperation;
                    }
                    break;
            }
        }
        throw new Exception(a.l("Unrecognized operation: ", string));
    }
}

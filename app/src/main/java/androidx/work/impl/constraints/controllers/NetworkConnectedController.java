package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class NetworkConnectedController extends ConstraintController<NetworkState> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkConnectedController(ConstraintTracker<NetworkState> tracker) {
        super(tracker);
        k.e(tracker, "tracker");
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec) {
        k.e(workSpec, "workSpec");
        return workSpec.constraints.getRequiredNetworkType() == NetworkType.CONNECTED;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isConstrained(NetworkState value) {
        k.e(value, "value");
        return Build.VERSION.SDK_INT >= 26 ? (value.isConnected() && value.isValidated()) ? false : true : !value.isConnected();
    }
}

package androidx.work.impl.constraints;

import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkConstraintsTrackerImpl implements WorkConstraintsTracker, ConstraintController.OnConstraintUpdatedCallback {
    private final WorkConstraintsCallback callback;
    private final ConstraintController<?>[] constraintControllers;
    private final Object lock;

    @VisibleForTesting
    public WorkConstraintsTrackerImpl(WorkConstraintsCallback workConstraintsCallback, ConstraintController<?>[] constraintControllers) {
        k.e(constraintControllers, "constraintControllers");
        this.callback = workConstraintsCallback;
        this.constraintControllers = constraintControllers;
        this.lock = new Object();
    }

    public final boolean areAllConstraintsMet(String workSpecId) {
        ConstraintController<?> constraintController;
        boolean z2;
        k.e(workSpecId, "workSpecId");
        synchronized (this.lock) {
            try {
                ConstraintController<?>[] constraintControllerArr = this.constraintControllers;
                int length = constraintControllerArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        constraintController = null;
                        break;
                    }
                    constraintController = constraintControllerArr[i2];
                    if (constraintController.isWorkSpecConstrained(workSpecId)) {
                        break;
                    }
                    i2++;
                }
                if (constraintController != null) {
                    Logger.get().debug(WorkConstraintsTrackerKt.TAG, "Work " + workSpecId + " constrained by " + constraintController.getClass().getSimpleName());
                }
                z2 = constraintController == null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintMet(List<WorkSpec> workSpecs) {
        k.e(workSpecs, "workSpecs");
        synchronized (this.lock) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : workSpecs) {
                    if (areAllConstraintsMet(((WorkSpec) obj).id)) {
                        arrayList.add(obj);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    Logger.get().debug(WorkConstraintsTrackerKt.TAG, "Constraints met for " + ((WorkSpec) obj2));
                }
                WorkConstraintsCallback workConstraintsCallback = this.callback;
                if (workConstraintsCallback != null) {
                    workConstraintsCallback.onAllConstraintsMet(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintNotMet(List<WorkSpec> workSpecs) {
        k.e(workSpecs, "workSpecs");
        synchronized (this.lock) {
            WorkConstraintsCallback workConstraintsCallback = this.callback;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.onAllConstraintsNotMet(workSpecs);
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void replace(Iterable<WorkSpec> workSpecs) {
        k.e(workSpecs, "workSpecs");
        synchronized (this.lock) {
            try {
                for (ConstraintController<?> constraintController : this.constraintControllers) {
                    constraintController.setCallback(null);
                }
                for (ConstraintController<?> constraintController2 : this.constraintControllers) {
                    constraintController2.replace(workSpecs);
                }
                for (ConstraintController<?> constraintController3 : this.constraintControllers) {
                    constraintController3.setCallback(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void reset() {
        synchronized (this.lock) {
            for (ConstraintController<?> constraintController : this.constraintControllers) {
                constraintController.reset();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTrackerImpl(Trackers trackers, WorkConstraintsCallback workConstraintsCallback) {
        this(workConstraintsCallback, (ConstraintController<?>[]) new ConstraintController[]{new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker())});
        k.e(trackers, "trackers");
    }
}

package androidx.camera.core.impl.utils;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.impl.SessionProcessor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionProcessorUtil {
    private SessionProcessorUtil() {
    }

    public static FocusMeteringAction getModifiedFocusMeteringAction(SessionProcessor sessionProcessor, FocusMeteringAction focusMeteringAction) {
        boolean z2;
        if (sessionProcessor == null) {
            return focusMeteringAction;
        }
        FocusMeteringAction.Builder builder = new FocusMeteringAction.Builder(focusMeteringAction);
        boolean z7 = true;
        if (focusMeteringAction.getMeteringPointsAf().isEmpty() || isOperationSupported(sessionProcessor, 1, 2)) {
            z2 = false;
        } else {
            builder.removePoints(1);
            z2 = true;
        }
        if (!focusMeteringAction.getMeteringPointsAe().isEmpty() && !isOperationSupported(sessionProcessor, 3)) {
            builder.removePoints(2);
            z2 = true;
        }
        if (focusMeteringAction.getMeteringPointsAwb().isEmpty() || isOperationSupported(sessionProcessor, 4)) {
            z7 = z2;
        } else {
            builder.removePoints(4);
        }
        if (!z7) {
            return focusMeteringAction;
        }
        FocusMeteringAction focusMeteringActionBuild = builder.build();
        if (focusMeteringActionBuild.getMeteringPointsAf().isEmpty() && focusMeteringActionBuild.getMeteringPointsAe().isEmpty() && focusMeteringActionBuild.getMeteringPointsAwb().isEmpty()) {
            return null;
        }
        return builder.build();
    }

    public static boolean isOperationSupported(SessionProcessor sessionProcessor, int... iArr) {
        if (sessionProcessor == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        return sessionProcessor.getSupportedCameraOperations().containsAll(arrayList);
    }
}

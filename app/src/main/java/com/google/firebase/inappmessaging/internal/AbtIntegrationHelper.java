package com.google.firebase.inappmessaging.internal;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.AbtExperimentInfo;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.ExperimentPayloadProto;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class AbtIntegrationHelper {
    private final FirebaseABTesting abTesting;

    @VisibleForTesting
    Executor executor;

    public AbtIntegrationHelper(FirebaseABTesting firebaseABTesting, @Blocking Executor executor) {
        this.abTesting = firebaseABTesting;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setExperimentActive$1(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        try {
            Logging.logd("Updating active experiment: " + experimentPayload.toString());
            this.abTesting.reportActiveExperiment(new AbtExperimentInfo(experimentPayload.getExperimentId(), experimentPayload.getVariantId(), experimentPayload.getTriggerEvent(), new Date(experimentPayload.getExperimentStartTimeMillis()), experimentPayload.getTriggerTimeoutMillis(), experimentPayload.getTimeToLiveMillis()));
        } catch (AbtException e) {
            Logging.loge("Unable to set experiment as active with ABT, missing analytics?\n" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRunningExperiments$0(ArrayList arrayList) {
        try {
            Logging.logd("Updating running experiments with: " + arrayList.size() + " experiments");
            this.abTesting.validateRunningExperiments(arrayList);
        } catch (AbtException e) {
            Logging.loge("Unable to register experiments with ABT, missing analytics?\n" + e.getMessage());
        }
    }

    public void setExperimentActive(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        this.executor.execute(new e(3, this, experimentPayload));
    }

    public void updateRunningExperiments(r2.o oVar) {
        ArrayList arrayList = new ArrayList();
        for (q2.f fVar : oVar.e()) {
            if (!fVar.d() && q0.c.a(fVar.e(), 2)) {
                ExperimentPayloadProto.ExperimentPayload experimentPayloadF = fVar.c().f();
                arrayList.add(new AbtExperimentInfo(experimentPayloadF.getExperimentId(), experimentPayloadF.getVariantId(), experimentPayloadF.getTriggerEvent(), new Date(experimentPayloadF.getExperimentStartTimeMillis()), experimentPayloadF.getTriggerTimeoutMillis(), experimentPayloadF.getTimeToLiveMillis()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.executor.execute(new e(2, this, arrayList));
    }
}

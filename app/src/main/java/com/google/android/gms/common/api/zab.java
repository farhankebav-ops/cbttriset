package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zab implements PendingResult.StatusListener {
    final /* synthetic */ Batch zaa;

    public zab(Batch batch) {
        this.zaa = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        synchronized (this.zaa.zai) {
            try {
                if (this.zaa.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.zaa.zag = true;
                } else if (!status.isSuccess()) {
                    this.zaa.zaf = true;
                }
                Batch batch = this.zaa;
                batch.zae--;
                Batch batch2 = this.zaa;
                if (batch2.zae == 0) {
                    if (batch2.zag) {
                        super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                    } else {
                        Status status2 = batch2.zaf ? new Status(13) : Status.RESULT_SUCCESS;
                        Batch batch3 = this.zaa;
                        batch3.setResult(new BatchResult(status2, batch3.zah));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.ironsource.dj;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.ads.operation.show.b;
import m0.e;
import p0.k;
import p0.v;
import v0.f;
import z0.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5212a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
        int i8 = jobParameters.getExtras().getInt("attemptNumber");
        v.b(getApplicationContext());
        if (string == null) {
            throw new NullPointerException("Null backendName");
        }
        e eVarB = a.b(i2);
        byte[] bArrDecode = string2 != null ? Base64.decode(string2, 0) : null;
        f fVar = v.a().f13315d;
        fVar.e.execute(new dj(fVar, new k(string, bArrDecode, eVarB), i8, new b(14, this, jobParameters), 1));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

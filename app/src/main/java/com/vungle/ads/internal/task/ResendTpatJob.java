package com.vungle.ads.internal.task;

import android.content.Context;
import android.os.Bundle;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ResendTpatJob implements Job {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ResendTpatJob";
    private final Context context;
    private final PathProvider pathProvider;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final JobInfo makeJobInfo() {
            return new JobInfo(ResendTpatJob.TAG).setPriority(0).setUpdateCurrent(true);
        }

        private Companion() {
        }
    }

    public ResendTpatJob(Context context, PathProvider pathProvider) {
        k.e(context, "context");
        k.e(pathProvider, "pathProvider");
        this.context = context;
        this.pathProvider = pathProvider;
    }

    /* JADX INFO: renamed from: onRunJob$lambda-0, reason: not valid java name */
    private static final TpatSender m3356onRunJob$lambda0(q5.f fVar) {
        return (TpatSender) fVar.getValue();
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    @Override // com.vungle.ads.internal.task.Job
    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        k.e(bundle, "bundle");
        k.e(jobRunner, "jobRunner");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        m3356onRunJob$lambda0(b.B(g.f13494a, new ResendTpatJob$onRunJob$$inlined$inject$1(this.context))).resendStoredTpats$vungle_ads_release();
        return 0;
    }
}

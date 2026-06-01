package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.task.JobRunner;
import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: renamed from: com.vungle.ads.internal.load.BaseAdLoader$onAdReady$lambda-2$$inlined$inject$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BaseAdLoader$onAdReady$lambda2$$inlined$inject$1 extends l implements a {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdLoader$onAdReady$lambda2$$inlined$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.task.JobRunner, java.lang.Object] */
    @Override // e6.a
    public final JobRunner invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(JobRunner.class);
    }
}

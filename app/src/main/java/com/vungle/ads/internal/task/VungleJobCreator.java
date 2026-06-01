package com.vungle.ads.internal.task;

import android.content.Context;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleJobCreator implements JobCreator {
    private final Context context;
    private final PathProvider pathProvider;

    public VungleJobCreator(Context context, PathProvider pathProvider) {
        k.e(context, "context");
        k.e(pathProvider, "pathProvider");
        this.context = context;
        this.pathProvider = pathProvider;
    }

    @Override // com.vungle.ads.internal.task.JobCreator
    public Job create(String tag) throws UnknownTagException {
        k.e(tag, "tag");
        if (tag.length() == 0) {
            throw new UnknownTagException("Job tag is null");
        }
        if (tag.equals(CleanupJob.TAG)) {
            return new CleanupJob(this.context, this.pathProvider);
        }
        if (tag.equals(ResendTpatJob.TAG)) {
            return new ResendTpatJob(this.context, this.pathProvider);
        }
        throw new UnknownTagException("Unknown Job Type ".concat(tag));
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }
}

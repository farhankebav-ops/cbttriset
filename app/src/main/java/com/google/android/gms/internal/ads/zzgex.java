package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgex extends zzfrs {
    private final zzfzn zzb;

    public zzgex(Context context, Executor executor, zzfzn zzfznVar) {
        super(context, executor, new TaskCompletionSource().getTask(), false);
        this.zzb = zzfznVar;
    }

    private static Task zzh() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(Boolean.TRUE);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.internal.ads.zzfrs
    public final Task zzb(int i2, long j) {
        this.zzb.zzb(i2, j, null, null);
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzfrs
    public final Task zzc(int i2, long j, Exception exc) {
        this.zzb.zzb(i2, j, exc, null);
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzfrs
    public final Task zze(int i2, String str) {
        this.zzb.zzb(i2, -1L, null, str);
        return zzh();
    }
}

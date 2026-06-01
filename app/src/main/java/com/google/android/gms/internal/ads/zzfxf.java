package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfxf {
    public static j2.q zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzfxd zzfxdVar = new zzfxd(task, null);
        task.addOnCompleteListener(zzguz.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfxe
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                zzfxd zzfxdVar2 = zzfxdVar;
                if (task2.isCanceled()) {
                    zzfxdVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzfxdVar2.zza(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception == null) {
                    throw new IllegalStateException();
                }
                zzfxdVar2.zzb(exception);
            }
        });
        return zzfxdVar;
    }
}

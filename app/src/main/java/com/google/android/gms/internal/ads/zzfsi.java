package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfsi {
    private final Context zza;
    private final Executor zzb;
    private final zzfrs zzc;
    private final zzfsh zzd;
    private Task zze;

    @VisibleForTesting
    public zzfsi(Context context, Executor executor, zzfrs zzfrsVar, zzfru zzfruVar, zzfse zzfseVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfrsVar;
        this.zzd = zzfseVar;
    }

    public static zzfsi zza(@NonNull Context context, @NonNull Executor executor, @NonNull zzfrs zzfrsVar, @NonNull zzfru zzfruVar) {
        final zzfsi zzfsiVar = new zzfsi(context, executor, zzfrsVar, zzfruVar, new zzfse());
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzfsg
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        };
        Executor executor2 = zzfsiVar.zzb;
        zzfsiVar.zze = Tasks.call(executor2, callable).addOnFailureListener(executor2, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfsf
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.zza.zzd(exc);
            }
        });
        return zzfsiVar;
    }

    public final zzauz zzb() {
        zzfsh zzfshVar = this.zzd;
        Task task = this.zze;
        return !task.isSuccessful() ? zzfshVar.zza() : (zzauz) task.getResult();
    }

    public final /* synthetic */ zzauz zzc() throws PackageManager.NameNotFoundException {
        Context context = this.zza;
        return zzfrz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void zzd(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}

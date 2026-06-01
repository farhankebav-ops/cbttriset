package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzfrs {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfrs(@NonNull Context context, @NonNull Executor executor, @NonNull Task task, boolean z2) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z2;
    }

    public static zzfrs zza(@NonNull final Context context, @NonNull Executor executor, boolean z2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z2) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfro
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    taskCompletionSource.setResult(zzfto.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfrq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    taskCompletionSource.setResult(zzfto.zzc());
                }
            });
        }
        return new zzfrs(context, executor, taskCompletionSource.getTask(), z2);
    }

    public static void zzg(int i2) {
        zzf = i2;
    }

    private final Task zzh(final int i2, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfrr.zza);
        }
        Context context = this.zzb;
        final zzati zzatiVarZza = zzatm.zza();
        zzatiVarZza.zza(context.getPackageName());
        zzatiVarZza.zzb(j);
        zzatiVarZza.zzg(zzf);
        if (exc != null) {
            int i8 = zzgna.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzatiVarZza.zzc(stringWriter.toString());
            zzatiVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzatiVarZza.zze(str2);
        }
        if (str != null) {
            zzatiVarZza.zzf(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfrp
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                if (!task.isSuccessful()) {
                    return Boolean.FALSE;
                }
                int i9 = i2;
                zzftn zzftnVarZza = ((zzfto) task.getResult()).zza(((zzatm) zzatiVarZza.zzbu()).zzaN());
                zzftnVarZza.zzc(i9);
                zzftnVarZza.zza();
                return Boolean.TRUE;
            }
        });
    }

    public Task zzb(int i2, long j) {
        return zzh(i2, j, null, null, null, null);
    }

    public Task zzc(int i2, long j, Exception exc) {
        return zzh(i2, j, exc, null, null, null);
    }

    public final Task zzd(int i2, long j, String str, Map map) {
        return zzh(i2, j, null, str, null, null);
    }

    public Task zze(int i2, String str) {
        return zzh(i2, 0L, null, null, null, str);
    }

    public final Task zzf(int i2, long j, String str) {
        return zzh(i2, j, null, null, null, str);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ShowFirstParty
public final class zzfsc {
    private final Context zza;
    private final Looper zzb;

    public zzfsc(@NonNull Context context, @NonNull Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(@NonNull String str) {
        zzfsm zzfsmVarZza = zzfso.zza();
        Context context = this.zza;
        zzfsmVarZza.zza(context.getPackageName());
        zzfsmVarZza.zzc(2);
        zzfsk zzfskVarZza = zzfsl.zza();
        zzfskVarZza.zza(str);
        zzfskVarZza.zzb(2);
        zzfsmVarZza.zzb(zzfskVarZza);
        new zzfsd(context, this.zzb, (zzfso) zzfsmVarZza.zzbu()).zza();
    }
}

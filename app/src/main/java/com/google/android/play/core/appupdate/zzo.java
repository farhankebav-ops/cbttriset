package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzo extends com.google.android.play.core.appupdate.internal.zzg {
    final com.google.android.play.core.appupdate.internal.zzm zza;
    final TaskCompletionSource zzb;
    final /* synthetic */ zzr zzc;

    public zzo(zzr zzrVar, com.google.android.play.core.appupdate.internal.zzm zzmVar, TaskCompletionSource taskCompletionSource) {
        this.zzc = zzrVar;
        this.zza = zzmVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzb(Bundle bundle) throws RemoteException {
        this.zzc.zza.zzu(this.zzb);
        this.zza.zzd("onCompleteUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzc(Bundle bundle) throws RemoteException {
        this.zzc.zza.zzu(this.zzb);
        this.zza.zzd("onRequestInfo", new Object[0]);
    }
}

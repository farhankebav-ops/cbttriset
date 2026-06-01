package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzq extends zzo {
    final /* synthetic */ zzr zzd;
    private final String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnRequestInstallCallback"), taskCompletionSource);
        this.zzd = zzrVar;
        this.zze = str;
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzc(Bundle bundle) throws RemoteException {
        super.zzc(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.zzb.trySetException(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.zzb.trySetResult(zzr.zzf(this.zzd, bundle, this.zze));
        }
    }
}

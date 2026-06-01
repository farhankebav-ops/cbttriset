package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzph extends BroadcastReceiver {
    final /* synthetic */ zzpj zza;

    public /* synthetic */ zzph(zzpj zzpjVar, byte[] bArr) {
        Objects.requireNonNull(zzpjVar);
        this.zza = zzpjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzpj zzpjVar = this.zza;
        zzpjVar.zzf(zzpe.zzb(context, intent, zzpjVar.zzj(), zzpjVar.zzh()));
    }
}

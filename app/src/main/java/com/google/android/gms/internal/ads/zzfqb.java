package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfqb extends BroadcastReceiver {
    final /* synthetic */ zzfqc zza;

    public zzfqb(zzfqc zzfqcVar) {
        Objects.requireNonNull(zzfqcVar);
        this.zza = zzfqcVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            zzfqc zzfqcVar = this.zza;
            zzfqcVar.zzd(true, zzfqcVar.zzf());
            zzfqcVar.zze(true);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzfqc zzfqcVar2 = this.zza;
            zzfqcVar2.zzd(false, zzfqcVar2.zzf());
            zzfqcVar2.zze(false);
        }
    }
}

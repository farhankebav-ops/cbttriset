package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzed extends BroadcastReceiver {
    final /* synthetic */ zzee zza;

    public /* synthetic */ zzed(zzee zzeeVar, byte[] bArr) {
        Objects.requireNonNull(zzeeVar);
        this.zza = zzeeVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, Intent intent) {
        this.zza.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzec
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza.zzd(context);
            }
        });
    }
}

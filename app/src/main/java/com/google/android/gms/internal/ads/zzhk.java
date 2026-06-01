package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhk extends BroadcastReceiver {
    private final zzdm zza;

    public zzhk(zzhm zzhmVar, zzdm zzdmVar, zzhl zzhlVar) {
        Objects.requireNonNull(zzhmVar);
        this.zza = zzdmVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zza.zzm(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzhj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                }
            });
        }
    }
}

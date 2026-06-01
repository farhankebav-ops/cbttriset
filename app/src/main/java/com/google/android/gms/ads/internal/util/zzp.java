package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzp extends BroadcastReceiver {
    public /* synthetic */ zzp(zzs zzsVar, byte[] bArr) {
        Objects.requireNonNull(zzsVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        com.google.android.gms.ads.internal.util.client.zzl.zzg();
        zzd.zza(context);
    }
}

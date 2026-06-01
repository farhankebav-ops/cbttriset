package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzsh extends Handler {
    final /* synthetic */ zzsj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzsh(zzsj zzsjVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zzsjVar);
        this.zza = zzsjVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zza.zzh(message);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzej implements zzdl {

    @Nullable
    private Message zza;

    private zzej() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdl
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        this.zza = null;
        zzek.zzn(this);
    }

    public final zzej zzb(Message message, zzek zzekVar) {
        this.zza = message;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzek.zzn(this);
        return zSendMessageAtFrontOfQueue;
    }

    public /* synthetic */ zzej(byte[] bArr) {
    }
}

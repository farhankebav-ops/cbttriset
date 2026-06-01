package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzre extends AudioTrack$StreamEventCallback {
    final /* synthetic */ zzrg zza;

    public zzre(zzrg zzrgVar) {
        Objects.requireNonNull(zzrgVar);
        this.zza = zzrgVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i2) {
        zzrh zzrhVar = this.zza.zza;
        if (audioTrack.equals(zzrhVar.zzJ()) && zzrhVar.zzI() != null && zzrhVar.zzL()) {
            zzrhVar.zzI().zza();
        }
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzrh zzrhVar = this.zza.zza;
        if (audioTrack.equals(zzrhVar.zzJ())) {
            zzrhVar.zzK(true);
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        zzrh zzrhVar = this.zza.zza;
        if (audioTrack.equals(zzrhVar.zzJ()) && zzrhVar.zzI() != null && zzrhVar.zzL()) {
            zzrhVar.zzI().zza();
        }
    }
}

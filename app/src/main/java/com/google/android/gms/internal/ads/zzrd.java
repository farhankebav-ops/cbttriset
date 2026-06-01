package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzrd implements zzqk {
    final /* synthetic */ zzrh zza;

    public /* synthetic */ zzrd(zzrh zzrhVar, byte[] bArr) {
        Objects.requireNonNull(zzrhVar);
        this.zza = zzrhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zza(long j) {
        zzrh zzrhVar = this.zza;
        if (zzrhVar.zzI() != null) {
            ((zzrk) zzrhVar.zzI()).zza.zzaw().zzd(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzb(long j, long j3, long j8, long j9) {
        zzrh zzrhVar = this.zza;
        long jZzF = zzrhVar.zzF();
        long jZzG = zzrhVar.zzG();
        int length = String.valueOf(j).length();
        int length2 = String.valueOf(j3).length();
        int length3 = String.valueOf(j8).length();
        int length4 = String.valueOf(j9).length();
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 2 + length3 + 2 + length4 + 2 + String.valueOf(jZzF).length() + 2 + String.valueOf(jZzG).length());
        androidx.camera.core.processing.util.a.y(sb, "Spurious audio timestamp (frame position mismatch): ", j, ", ");
        sb.append(j3);
        androidx.camera.core.processing.util.a.y(sb, ", ", j8, ", ");
        sb.append(j9);
        androidx.camera.core.processing.util.a.y(sb, ", ", jZzF, ", ");
        sb.append(jZzG);
        zzdt.zzc("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzc(long j, long j3, long j8, long j9) {
        zzrh zzrhVar = this.zza;
        long jZzF = zzrhVar.zzF();
        long jZzG = zzrhVar.zzG();
        int length = String.valueOf(j).length();
        int length2 = String.valueOf(j3).length();
        int length3 = String.valueOf(j8).length();
        int length4 = String.valueOf(j9).length();
        StringBuilder sb = new StringBuilder(length + 52 + length2 + 2 + length3 + 2 + length4 + 2 + String.valueOf(jZzF).length() + 2 + String.valueOf(jZzG).length());
        androidx.camera.core.processing.util.a.y(sb, "Spurious audio timestamp (system clock mismatch): ", j, ", ");
        sb.append(j3);
        androidx.camera.core.processing.util.a.y(sb, ", ", j8, ", ");
        sb.append(j9);
        androidx.camera.core.processing.util.a.y(sb, ", ", jZzF, ", ");
        sb.append(jZzG);
        zzdt.zzc("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzd(long j) {
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 41);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j);
        zzdt.zzc("DefaultAudioSink", sb.toString());
    }
}

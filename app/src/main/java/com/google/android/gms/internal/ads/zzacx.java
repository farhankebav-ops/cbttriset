package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacx implements zzaem {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzaem
    public final int zzv(zzj zzjVar, int i2, boolean z2, int i8) throws IOException {
        int iZza = zzjVar.zza(this.zza, 0, Math.min(4096, i2));
        if (iZza != -1) {
            return iZza;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzw(zzeg zzegVar, int i2, int i8) {
        zzegVar.zzk(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final /* synthetic */ int zzy(zzj zzjVar, int i2, boolean z2) {
        return f.a(this, zzjVar, i2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final /* synthetic */ void zzz(zzeg zzegVar, int i2) {
        f.b(this, zzegVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzu(zzv zzvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzx(long j, int i2, int i8, int i9, @Nullable zzael zzaelVar) {
    }
}

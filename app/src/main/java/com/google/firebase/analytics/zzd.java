package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzd implements zzlk {
    final /* synthetic */ zzfb zza;

    public zzd(zzfb zzfbVar) {
        this.zza = zzfbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzi(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzb(String str, String str2, Bundle bundle, long j) {
        this.zza.zzj(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final Map zzd(@Nullable String str, @Nullable String str2, boolean z2) {
        return this.zza.zzC(str, str2, z2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zze(zzjp zzjpVar) {
        this.zza.zzd(zzjpVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzf(zzjq zzjqVar) {
        this.zza.zzf(zzjqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzg(zzjq zzjqVar) {
        this.zza.zzg(zzjqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    @Nullable
    public final String zzh() {
        return this.zza.zzA();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    @Nullable
    public final String zzi() {
        return this.zza.zzB();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    @Nullable
    public final String zzj() {
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    @Nullable
    public final String zzk() {
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final long zzl() {
        return this.zza.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzm(String str) {
        this.zza.zzu(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzn(String str) {
        this.zza.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzo(Bundle bundle) {
        this.zza.zzl(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzp(String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zza.zzm(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final List zzq(@Nullable String str, @Nullable String str2) {
        return this.zza.zzn(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final int zzr(String str) {
        return this.zza.zzF(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    @Nullable
    public final Object zzx(int i2) {
        return this.zza.zzJ(i2);
    }
}

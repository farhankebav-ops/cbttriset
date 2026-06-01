package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzqh {
    void zzA();

    void zzB();

    void zza(zzqe zzqeVar);

    void zzb(@Nullable zzpc zzpcVar);

    void zzc(zzdc zzdcVar);

    boolean zzd(zzv zzvVar);

    int zze(zzv zzvVar);

    zzpl zzf(zzv zzvVar);

    long zzg(boolean z2);

    void zzh(zzv zzvVar, int i2, @Nullable int[] iArr) throws zzqc;

    void zzi();

    void zzj();

    boolean zzk(ByteBuffer byteBuffer, long j, int i2) throws zzqg, zzqd;

    void zzl() throws zzqg;

    boolean zzm();

    boolean zzn();

    void zzo(zzav zzavVar);

    zzav zzp();

    void zzq(boolean z2);

    void zzr(zzd zzdVar);

    void zzs(int i2);

    void zzt(zze zzeVar);

    void zzu(@Nullable AudioDeviceInfo audioDeviceInfo);

    long zzv();

    @RequiresApi(29)
    void zzw(int i2, int i8);

    void zzx(float f4);

    void zzy();

    void zzz();
}

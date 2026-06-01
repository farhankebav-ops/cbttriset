package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzcdr extends zzciq, zzcit, zzbot {
    Context getContext();

    void setBackgroundColor(int i2);

    void zzA(int i2);

    void zzB(int i2);

    @Nullable
    zzcdg zzdr();

    void zzds(boolean z2);

    @Nullable
    zzcie zzh();

    @Nullable
    zzbfg zzi();

    @Nullable
    Activity zzj();

    @Nullable
    com.google.android.gms.ads.internal.zza zzk();

    void zzl();

    String zzm();

    @Nullable
    String zzn();

    void zzo(int i2);

    int zzp();

    zzbfh zzq();

    @Nullable
    zzcfe zzr(String str);

    VersionInfoParcel zzs();

    void zzt(String str, zzcfe zzcfeVar);

    void zzu(boolean z2, long j);

    void zzv(int i2);

    void zzw(zzcie zzcieVar);

    int zzx();

    int zzy();

    void zzz();
}

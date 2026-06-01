package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqg extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzv zzc;

    public zzqg(int i2, zzv zzvVar, boolean z2) {
        super(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 25), "AudioTrack write failed: ", i2));
        this.zzb = z2;
        this.zza = i2;
        this.zzc = zzvVar;
    }
}

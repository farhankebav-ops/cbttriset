package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzazr implements Callable {
    protected final zzayd zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzauc zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzazr(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        this.zza = zzaydVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaucVar;
        this.zzf = i2;
        this.zzg = i8;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int i2;
        try {
            long jNanoTime = System.nanoTime();
            zzayd zzaydVar = this.zza;
            Method methodZzo = zzaydVar.zzo(this.zzb, this.zzc);
            this.zze = methodZzo;
            if (methodZzo == null) {
                return null;
            }
            zza();
            zzawu zzawuVarZzh = zzaydVar.zzh();
            if (zzawuVarZzh == null || (i2 = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzawuVarZzh.zza(this.zzg, i2, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public abstract void zza() throws IllegalAccessException, InvocationTargetException;
}

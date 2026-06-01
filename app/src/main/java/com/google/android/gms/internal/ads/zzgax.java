package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgax {
    public long zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public double zze;
    public float zzf;
    public float zzg;
    public float zzh;
    public float zzi;
    private double zzj;
    private double zzk;

    private static double zzb(MotionEvent motionEvent, double d8, double d9, double d10) {
        return Math.hypot(((double) motionEvent.getRawX()) - d8, ((double) motionEvent.getRawY()) - d9) + d10;
    }

    public final /* synthetic */ void zza(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zza++;
            this.zze = 0.0d;
            this.zzj = motionEvent.getRawX();
            this.zzk = motionEvent.getRawY();
            this.zzf = motionEvent.getX();
            this.zzg = motionEvent.getY();
            this.zzh = motionEvent.getRawX();
            this.zzi = motionEvent.getRawY();
            return;
        }
        if (action == 1) {
            this.zzc++;
            this.zze = zzb(motionEvent, this.zzj, this.zzk, this.zze);
            this.zzj = motionEvent.getRawX();
            this.zzk = motionEvent.getRawY();
            return;
        }
        if (action != 2) {
            if (action != 3) {
                return;
            }
            this.zzd++;
        } else {
            this.zzb += (long) (motionEvent.getHistorySize() + 1);
            this.zze = zzb(motionEvent, this.zzj, this.zzk, this.zze);
            this.zzj = motionEvent.getRawX();
            this.zzk = motionEvent.getRawY();
        }
    }
}

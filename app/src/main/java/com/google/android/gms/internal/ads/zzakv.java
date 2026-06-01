package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakv {
    private final zzeg zza = new zzeg();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    @Nullable
    public final zzcm zza() {
        int i2;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzeg zzegVar = this.zza;
        if (zzegVar.zze() == 0 || zzegVar.zzg() != zzegVar.zze() || !this.zzc) {
            return null;
        }
        zzegVar.zzh(0);
        int i8 = this.zzh * this.zzi;
        int[] iArr = new int[i8];
        int i9 = 0;
        while (i9 < i8) {
            int iZzs = zzegVar.zzs();
            if (iZzs != 0) {
                i2 = i9 + 1;
                iArr[i9] = this.zzb[iZzs];
            } else {
                int iZzs2 = zzegVar.zzs();
                if (iZzs2 != 0) {
                    int iZzs3 = iZzs2 & 63;
                    if ((iZzs2 & 64) != 0) {
                        iZzs3 = (iZzs3 << 8) | zzegVar.zzs();
                    }
                    i2 = iZzs3 + i9;
                    Arrays.fill(iArr, i9, i2, (iZzs2 & 128) == 0 ? this.zzb[0] : this.zzb[zzegVar.zzs()]);
                }
            }
            i9 = i2;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcl zzclVar = new zzcl();
        zzclVar.zzc(bitmapCreateBitmap);
        zzclVar.zzi(this.zzf / this.zzd);
        zzclVar.zzj(0);
        zzclVar.zzf(this.zzg / this.zze, 0);
        zzclVar.zzg(0);
        zzclVar.zzm(this.zzh / this.zzd);
        zzclVar.zzn(this.zzi / this.zze);
        return zzclVar.zzr();
    }

    public final void zzb() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zza(0);
        this.zzc = false;
    }

    public final /* synthetic */ void zzc(zzeg zzegVar, int i2) {
        if (i2 % 5 != 2) {
            return;
        }
        zzegVar.zzk(2);
        int[] iArr = this.zzb;
        Arrays.fill(iArr, 0);
        int i8 = 0;
        for (int i9 = i2 / 5; i8 < i9; i9 = i9) {
            int iZzs = zzegVar.zzs();
            int iZzs2 = zzegVar.zzs();
            int iZzs3 = zzegVar.zzs();
            int iZzs4 = zzegVar.zzs();
            double d8 = iZzs2;
            int iZzs5 = zzegVar.zzs() << 24;
            String str = zzep.zza;
            double d9 = iZzs3 - 128;
            double d10 = iZzs4 - 128;
            iArr[iZzs] = (Math.max(0, Math.min((int) ((1.402d * d9) + d8), 255)) << 16) | iZzs5 | (Math.max(0, Math.min((int) ((d8 - (0.34414d * d10)) - (d9 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) ((d10 * 1.772d) + d8), 255));
            i8++;
        }
        this.zzc = true;
    }

    public final /* synthetic */ void zzd(zzeg zzegVar, int i2) {
        int iZzx;
        if (i2 < 4) {
            return;
        }
        zzegVar.zzk(3);
        int i8 = i2 - 4;
        if ((zzegVar.zzs() & 128) != 0) {
            if (i8 < 7 || (iZzx = zzegVar.zzx()) < 4) {
                return;
            }
            this.zzh = zzegVar.zzt();
            this.zzi = zzegVar.zzt();
            this.zza.zza(iZzx - 4);
            i8 = i2 - 11;
        }
        zzeg zzegVar2 = this.zza;
        int iZzg = zzegVar2.zzg();
        int iZze = zzegVar2.zze();
        if (iZzg >= iZze || i8 <= 0) {
            return;
        }
        int iMin = Math.min(i8, iZze - iZzg);
        zzegVar.zzm(zzegVar2.zzi(), iZzg, iMin);
        zzegVar2.zzh(iZzg + iMin);
    }

    public final /* synthetic */ void zze(zzeg zzegVar, int i2) {
        if (i2 < 19) {
            return;
        }
        this.zzd = zzegVar.zzt();
        this.zze = zzegVar.zzt();
        zzegVar.zzk(11);
        this.zzf = zzegVar.zzt();
        this.zzg = zzegVar.zzt();
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbk {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzbbz zze;
    private final zzbcg zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzbbk(int i2, int i8, int i9, int i10, int i11, int i12, int i13, boolean z2) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = z2;
        this.zze = new zzbbz(i10);
        this.zzf = new zzbcg(i11, i12, i13);
    }

    private final void zzm(@Nullable String str, boolean z2, float f4, float f8, float f9, float f10) {
        if (str != null) {
            if (str.length() < this.zzc) {
                return;
            }
            synchronized (this.zzg) {
                try {
                    this.zzh.add(str);
                    this.zzk += str.length();
                    if (z2) {
                        this.zzi.add(str);
                        this.zzj.add(new zzbbv(f4, f8, f9, f10, r10.size() - 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static final String zzn(ArrayList arrayList, int i2) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            sb.append((String) arrayList.get(i8));
            sb.append(' ');
            i8++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbbk)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzbbk) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.zzh;
        int i2 = this.zzl;
        int i8 = this.zzn;
        int i9 = this.zzk;
        String strZzn = zzn(arrayList, 100);
        String strZzn2 = zzn(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(i8).length();
        int length3 = String.valueOf(i9).length();
        int length4 = String.valueOf(strZzn).length();
        int length5 = String.valueOf(strZzn2).length();
        int length6 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 14 + length3 + 8 + length4 + 14 + length5 + 12 + length6 + 20 + String.valueOf(str2).length() + 32 + String.valueOf(str3).length());
        com.google.android.gms.ads.internal.client.a.k(i2, i8, "ActivityContent fetchId: ", " score:", sb);
        sb.append(" total_length:");
        sb.append(i9);
        sb.append("\n text: ");
        sb.append(strZzn);
        androidx.camera.core.processing.util.a.A(sb, "\n viewableText", strZzn2, "\n signture: ", str);
        return androidx.camera.core.processing.util.a.n(sb, "\n viewableSignture: ", str2, "\n viewableSignatureForVertical: ", str3);
    }

    public final boolean zza() {
        boolean z2;
        synchronized (this.zzg) {
            z2 = this.zzm == 0;
        }
        return z2;
    }

    public final String zzb() {
        return this.zzo;
    }

    public final String zzc() {
        return this.zzq;
    }

    public final void zzd() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zze() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzf(String str, boolean z2, float f4, float f8, float f9, float f10) {
        zzm(str, z2, f4, f8, f9, f10);
        synchronized (this.zzg) {
            try {
                if (this.zzm < 0) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzd("ActivityContent: negative number of WebViews.");
                }
                zzi();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzg(String str, boolean z2, float f4, float f8, float f9, float f10) {
        zzm(str, z2, f4, f8, f9, f10);
    }

    public final void zzh() {
        synchronized (this.zzg) {
            try {
                int iZzj = zzj(this.zzk, this.zzl);
                if (iZzj > this.zzn) {
                    this.zzn = iZzj;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            try {
                int iZzj = zzj(this.zzk, this.zzl);
                if (iZzj > this.zzn) {
                    this.zzn = iZzj;
                    if (!com.google.android.gms.ads.internal.zzt.zzh().zzo().zzc()) {
                        zzbbz zzbbzVar = this.zze;
                        this.zzo = zzbbzVar.zza(this.zzh);
                        this.zzp = zzbbzVar.zza(this.zzi);
                    }
                    if (!com.google.android.gms.ads.internal.zzt.zzh().zzo().zze()) {
                        this.zzq = this.zzf.zza(this.zzi, this.zzj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final int zzj(int i2, int i8) {
        if (this.zzd) {
            return this.zzb;
        }
        return (i8 * this.zzb) + (i2 * this.zza);
    }

    public final void zzk(int i2) {
        this.zzl = i2;
    }

    @VisibleForTesting
    public final int zzl() {
        return this.zzk;
    }
}

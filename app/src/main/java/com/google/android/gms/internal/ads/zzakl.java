package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakl implements zzaem {
    private final zzaem zza;
    private final zzakg zzb;

    @Nullable
    private zzaki zzg;
    private zzv zzh;
    private boolean zzi;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzep.zzb;
    private final zzeg zzc = new zzeg();

    public zzakl(zzaem zzaemVar, zzakg zzakgVar) {
        this.zza = zzaemVar;
        this.zzb = zzakgVar;
    }

    private final void zzc(int i2) {
        int length = this.zzf.length;
        int i8 = this.zze;
        if (length - i8 >= i2) {
            return;
        }
        int i9 = i8 - this.zzd;
        int iMax = Math.max(i9 + i9, i2 + i9);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i9);
        this.zzd = 0;
        this.zze = i9;
        this.zzf = bArr2;
    }

    public final void zza(boolean z2) {
        this.zzi = true;
    }

    public final /* synthetic */ void zzb(long j, int i2, zzaka zzakaVar) {
        this.zzh.getClass();
        zzgpe zzgpeVar = zzakaVar.zza;
        long j3 = zzakaVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzgpeVar.size());
        Iterator<E> it = zzgpeVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzcm) it.next()).zzb());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j3);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzeg zzegVar = this.zzc;
        int length = bArrMarshall.length;
        zzegVar.zzb(bArrMarshall, length);
        zzaem zzaemVar = this.zza;
        zzaemVar.zzz(zzegVar, length);
        long j8 = zzakaVar.zzb;
        if (j8 == -9223372036854775807L) {
            zzgmd.zzh(this.zzh.zzt == LocationRequestCompat.PASSIVE_INTERVAL);
        } else {
            long j9 = this.zzh.zzt;
            j = j9 == LocationRequestCompat.PASSIVE_INTERVAL ? j + j8 : j8 + j9;
        }
        zzaemVar.zzx(j, i2 | 1, length, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzu(zzv zzvVar) {
        String str = zzvVar.zzo;
        str.getClass();
        zzgmd.zza(zzas.zzg(str) == 3);
        if (!zzvVar.equals(this.zzh)) {
            this.zzh = zzvVar;
            zzakg zzakgVar = this.zzb;
            this.zzg = zzakgVar.zza(zzvVar) ? zzakgVar.zzc(zzvVar) : null;
        }
        if (this.zzg == null) {
            this.zza.zzu(zzvVar);
            return;
        }
        zzaem zzaemVar = this.zza;
        zzt zztVarZza = zzvVar.zza();
        zztVarZza.zzm("application/x-media3-cues");
        zztVarZza.zzj(str);
        zztVarZza.zzr(LocationRequestCompat.PASSIVE_INTERVAL);
        zztVarZza.zzK(this.zzb.zzb(zzvVar));
        zzaemVar.zzu(zztVarZza.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final int zzv(zzj zzjVar, int i2, boolean z2, int i8) throws IOException {
        if (this.zzg == null) {
            return this.zza.zzv(zzjVar, i2, z2, 0);
        }
        zzc(i2);
        int iZza = zzjVar.zza(this.zzf, this.zze, i2);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzw(zzeg zzegVar, int i2, int i8) {
        if (this.zzg == null) {
            this.zza.zzw(zzegVar, i2, i8);
            return;
        }
        zzc(i2);
        zzegVar.zzm(this.zzf, this.zze, i2);
        this.zze += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzx(final long j, final int i2, int i8, int i9, @Nullable zzael zzaelVar) {
        if (this.zzg == null) {
            this.zza.zzx(j, i2, i8, i9, zzaelVar);
            return;
        }
        zzgmd.zzb(zzaelVar == null, "DRM on subtitles is not supported");
        int i10 = (this.zze - i9) - i8;
        try {
            this.zzg.zza(this.zzf, i10, i8, zzakh.zza(), new zzdg() { // from class: com.google.android.gms.internal.ads.zzakk
                @Override // com.google.android.gms.internal.ads.zzdg
                public final /* synthetic */ void zza(Object obj) {
                    this.zza.zzb(j, i2, (zzaka) obj);
                }
            });
        } catch (RuntimeException e) {
            if (!this.zzi) {
                throw e;
            }
            zzdt.zzd("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e);
        }
        int i11 = i10 + i8;
        this.zzd = i11;
        if (i11 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final /* synthetic */ int zzy(zzj zzjVar, int i2, boolean z2) {
        return f.a(this, zzjVar, i2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final /* synthetic */ void zzz(zzeg zzegVar, int i2) {
        f.b(this, zzegVar, i2);
    }
}

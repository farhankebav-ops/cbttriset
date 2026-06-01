package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaey implements zzada {
    private final zzeg zza;
    private final zzaex zzb;
    private final boolean zzc;
    private final zzakg zzd;
    private int zze;
    private zzadd zzf;
    private zzaez zzg;
    private long zzh;
    private zzafb[] zzi;
    private long zzj;

    @Nullable
    private zzafb zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaey() {
        this(1, zzakg.zza);
    }

    @Nullable
    private final zzafb zzh(int i2) {
        for (zzafb zzafbVar : this.zzi) {
            if (zzafbVar.zzc(i2)) {
                return zzafbVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = this.zza;
        zzadbVar.zzi(zzegVar.zzi(), 0, 12);
        zzegVar.zzh(0);
        if (zzegVar.zzC() != 1179011410) {
            return false;
        }
        zzegVar.zzk(4);
        return zzegVar.zzC() == 541677121;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zze = 0;
        if (this.zzc) {
            zzaddVar = new zzakj(zzaddVar, this.zzd);
        }
        this.zzf = zzaddVar;
        this.zzj = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        boolean z2;
        int i2;
        long j;
        long j3 = this.zzj;
        if (j3 != -1) {
            long jZzn = zzadbVar.zzn();
            if (j3 < jZzn || j3 > 262144 + jZzn) {
                zzaeaVar.zza = j3;
                z2 = true;
            } else {
                zzadbVar.zzf((int) (j3 - jZzn));
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.zzj = -1L;
        if (z2) {
            return 1;
        }
        int i8 = this.zze;
        zzafb zzafbVar = null;
        if (i8 == 0) {
            if (!zza(zzadbVar)) {
                throw zzat.zzb("AVI Header List not found", null);
            }
            zzadbVar.zzf(12);
            this.zze = 1;
            return 0;
        }
        if (i8 == 1) {
            zzeg zzegVar = this.zza;
            zzadbVar.zzc(zzegVar.zzi(), 0, 12);
            zzegVar.zzh(0);
            zzaex zzaexVar = this.zzb;
            zzaexVar.zza(zzegVar);
            int i9 = zzaexVar.zza;
            if (i9 != 1414744396) {
                StringBuilder sb = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i9, 22));
                sb.append("LIST expected, found: ");
                sb.append(i9);
                throw zzat.zzb(sb.toString(), null);
            }
            int iZzC = zzegVar.zzC();
            if (iZzC == 1819436136) {
                this.zzl = zzaexVar.zzb;
                this.zze = 2;
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(iZzC, 22));
            sb2.append("hdrl expected, found: ");
            sb2.append(iZzC);
            throw zzat.zzb(sb2.toString(), null);
        }
        if (i8 == 2) {
            int i10 = this.zzl - 4;
            zzeg zzegVar2 = new zzeg(i10);
            zzadbVar.zzc(zzegVar2.zzi(), 0, i10);
            zzafc zzafcVarZzb = zzafc.zzb(1819436136, zzegVar2);
            if (zzafcVarZzb.zza() != 1819436136) {
                int iZza = zzafcVarZzb.zza();
                StringBuilder sb3 = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb3.append("Unexpected header list type ");
                sb3.append(iZza);
                throw zzat.zzb(sb3.toString(), null);
            }
            zzaez zzaezVar = (zzaez) zzafcVarZzb.zzc(zzaez.class);
            if (zzaezVar == null) {
                throw zzat.zzb("AviHeader not found", null);
            }
            this.zzg = zzaezVar;
            this.zzh = ((long) zzaezVar.zzc) * ((long) zzaezVar.zza);
            ArrayList arrayList = new ArrayList();
            zzgpe zzgpeVar = zzafcVarZzb.zza;
            int size = zzgpeVar.size();
            int i11 = 0;
            int i12 = 0;
            while (i11 < size) {
                zzaev zzaevVar = (zzaev) zzgpeVar.get(i11);
                if (zzaevVar.zza() == 1819440243) {
                    zzafc zzafcVar = (zzafc) zzaevVar;
                    int i13 = i12 + 1;
                    zzafa zzafaVar = (zzafa) zzafcVar.zzc(zzafa.class);
                    zzafd zzafdVar = (zzafd) zzafcVar.zzc(zzafd.class);
                    if (zzafaVar == null) {
                        zzdt.zzc("AviExtractor", "Missing Stream Header");
                    } else if (zzafdVar == null) {
                        zzdt.zzc("AviExtractor", "Missing Stream Format");
                    } else {
                        long jZzd = zzafaVar.zzd();
                        zzv zzvVar = zzafdVar.zza;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzb(i12);
                        int i14 = zzafaVar.zze;
                        if (i14 != 0) {
                            zztVarZza.zzn(i14);
                        }
                        zzafe zzafeVar = (zzafe) zzafcVar.zzc(zzafe.class);
                        if (zzafeVar != null) {
                            zztVarZza.zzc(zzafeVar.zza);
                        }
                        int iZzg = zzas.zzg(zzvVar.zzo);
                        if (iZzg == 1) {
                            zzaem zzaemVarZzu = this.zzf.zzu(i12, iZzg);
                            zzaemVarZzu.zzu(zztVarZza.zzM());
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzafbVar = new zzafb(i12, zzafaVar, zzaemVarZzu);
                        } else if (iZzg == 2) {
                            iZzg = 2;
                            zzaem zzaemVarZzu2 = this.zzf.zzu(i12, iZzg);
                            zzaemVarZzu2.zzu(zztVarZza.zzM());
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzafbVar = new zzafb(i12, zzafaVar, zzaemVarZzu2);
                        } else {
                            zzafbVar = null;
                        }
                    }
                    if (zzafbVar != null) {
                        arrayList.add(zzafbVar);
                    }
                    i12 = i13;
                }
                i11++;
                zzafbVar = null;
            }
            this.zzi = (zzafb[]) arrayList.toArray(new zzafb[0]);
            this.zzf.zzv();
            this.zze = 3;
            return 0;
        }
        if (i8 == 3) {
            long j8 = this.zzm;
            if (j8 != -1 && zzadbVar.zzn() != j8) {
                this.zzj = j8;
                return 0;
            }
            zzeg zzegVar3 = this.zza;
            zzadbVar.zzi(zzegVar3.zzi(), 0, 12);
            zzadbVar.zzl();
            zzegVar3.zzh(0);
            zzaex zzaexVar2 = this.zzb;
            zzaexVar2.zza(zzegVar3);
            int iZzC2 = zzegVar3.zzC();
            int i15 = zzaexVar2.zza;
            if (i15 == 1179011410) {
                zzadbVar.zzf(12);
                return 0;
            }
            if (i15 != 1414744396 || iZzC2 != 1769369453) {
                this.zzj = zzadbVar.zzn() + ((long) zzaexVar2.zzb) + 8;
                return 0;
            }
            long jZzn2 = zzadbVar.zzn();
            this.zzm = jZzn2;
            long j9 = jZzn2 + ((long) zzaexVar2.zzb) + 8;
            this.zzn = j9;
            if (!this.zzp) {
                zzaez zzaezVar2 = this.zzg;
                zzaezVar2.getClass();
                if ((zzaezVar2.zzb & 16) == 16) {
                    this.zze = 4;
                    this.zzj = j9;
                    return 0;
                }
                this.zzf.zzw(new zzaec(this.zzh, 0L));
                this.zzp = true;
            }
            this.zzj = zzadbVar.zzn() + 12;
            this.zze = 6;
            return 0;
        }
        if (i8 == 4) {
            zzeg zzegVar4 = this.zza;
            zzadbVar.zzc(zzegVar4.zzi(), 0, 8);
            zzegVar4.zzh(0);
            int iZzC3 = zzegVar4.zzC();
            int iZzC4 = zzegVar4.zzC();
            if (iZzC3 != 829973609) {
                this.zzj = zzadbVar.zzn() + ((long) iZzC4);
                return 0;
            }
            this.zze = 5;
            this.zzo = iZzC4;
            return 0;
        }
        if (i8 != 5) {
            if (zzadbVar.zzn() >= this.zzn) {
                return -1;
            }
            zzafb zzafbVar2 = this.zzk;
            if (zzafbVar2 != null) {
                if (!zzafbVar2.zze(zzadbVar)) {
                    return 0;
                }
                this.zzk = null;
                return 0;
            }
            if ((zzadbVar.zzn() & 1) == 1) {
                zzadbVar.zzf(1);
            }
            zzeg zzegVar5 = this.zza;
            zzadbVar.zzi(zzegVar5.zzi(), 0, 12);
            zzegVar5.zzh(0);
            int iZzC5 = zzegVar5.zzC();
            if (iZzC5 == 1414744396) {
                zzegVar5.zzh(8);
                zzadbVar.zzf(zzegVar5.zzC() != 1769369453 ? 8 : 12);
                zzadbVar.zzl();
                return 0;
            }
            int iZzC6 = zzegVar5.zzC();
            if (iZzC5 == 1263424842) {
                this.zzj = zzadbVar.zzn() + ((long) iZzC6) + 8;
                return 0;
            }
            zzadbVar.zzf(8);
            zzadbVar.zzl();
            zzafb zzafbVarZzh = zzh(iZzC5);
            if (zzafbVarZzh == null) {
                this.zzj = zzadbVar.zzn() + ((long) iZzC6);
                return 0;
            }
            zzafbVarZzh.zzd(iZzC6);
            this.zzk = zzafbVarZzh;
            return 0;
        }
        zzeg zzegVar6 = new zzeg(this.zzo);
        zzadbVar.zzc(zzegVar6.zzi(), 0, this.zzo);
        if (zzegVar6.zzd() < 16) {
            i2 = 0;
            j = 0;
        } else {
            int iZzg2 = zzegVar6.zzg();
            zzegVar6.zzk(8);
            long jZzC = zzegVar6.zzC();
            i2 = 0;
            long j10 = this.zzm;
            j = jZzC > j10 ? 0L : j10 + 8;
            zzegVar6.zzh(iZzg2);
        }
        while (zzegVar6.zzd() >= 16) {
            int iZzC7 = zzegVar6.zzC();
            int iZzC8 = zzegVar6.zzC();
            long jZzC2 = ((long) zzegVar6.zzC()) + j;
            zzegVar6.zzk(4);
            zzafb zzafbVarZzh2 = zzh(iZzC7);
            if (zzafbVarZzh2 != null) {
                zzafbVarZzh2.zza(jZzC2, (iZzC8 & 16) == 16 ? 1 : i2);
            }
        }
        zzafb[] zzafbVarArr = this.zzi;
        int length = zzafbVarArr.length;
        for (int i16 = i2; i16 < length; i16++) {
            zzafbVarArr[i16].zzb();
        }
        this.zzp = true;
        if (this.zzi.length == 0) {
            this.zzf.zzw(new zzaec(this.zzh, 0L));
        } else {
            this.zzf.zzw(new zzaew(this, this.zzh));
        }
        this.zze = 6;
        this.zzj = this.zzm;
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzafb zzafbVar : this.zzi) {
            zzafbVar.zzf(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }

    public final /* synthetic */ zzafb[] zzg() {
        return this.zzi;
    }

    public zzaey(int i2, zzakg zzakgVar) {
        this.zzd = zzakgVar;
        this.zzc = 1 == (i2 ^ 1);
        this.zza = new zzeg(12);
        this.zzb = new zzaex(null);
        this.zzf = new zzady();
        this.zzi = new zzafb[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }
}

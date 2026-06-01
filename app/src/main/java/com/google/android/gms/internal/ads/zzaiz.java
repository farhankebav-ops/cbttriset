package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaiz implements zzada {
    public static final /* synthetic */ int zza = 0;
    private int zzA;

    @Nullable
    private zzafz zzB;
    private final zzakg zzb;
    private final int zzc;
    private final zzeg zzd;
    private final zzeg zze;
    private final zzeg zzf;
    private final zzeg zzg;
    private final ArrayDeque zzh;
    private final zzajd zzi;
    private final List zzj;
    private zzgpe zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzo;

    @Nullable
    private zzeg zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private long zzw;
    private zzadd zzx;
    private zzaiy[] zzy;

    @Nullable
    private long[][] zzz;

    @Deprecated
    public zzaiz() {
        this(zzakg.zza, 16);
    }

    public static /* synthetic */ long zzg(zzaji zzajiVar, long j, long j3) {
        int iZzk = zzk(zzajiVar, j);
        return iZzk == -1 ? j3 : Math.min(zzajiVar.zzc[iZzk], j3);
    }

    private final void zzi() {
        this.zzl = 0;
        this.zzo = 0;
    }

    private final void zzj(long j) throws zzat {
        zzap zzapVar;
        int i2;
        ArrayDeque arrayDeque;
        List list;
        int i8;
        long j3;
        zzap zzapVar2;
        while (true) {
            ArrayDeque arrayDeque2 = this.zzh;
            if (arrayDeque2.isEmpty() || ((zzeu) arrayDeque2.peek()).zza != j) {
                break;
            }
            zzeu zzeuVar = (zzeu) arrayDeque2.pop();
            if (zzeuVar.zzd == 1836019574) {
                zzeu zzeuVarZzd = zzeuVar.zzd(1835365473);
                new ArrayList();
                zzap zzapVarZze = zzeuVarZzd != null ? zzaik.zze(zzeuVarZzd) : null;
                ArrayList arrayList = new ArrayList();
                int i9 = 0;
                boolean z2 = this.zzA == 1;
                zzads zzadsVar = new zzads();
                zzev zzevVarZzc = zzeuVar.zzc(1969517665);
                if (zzevVarZzc != null) {
                    zzap zzapVarZzc = zzaik.zzc(zzevVarZzc);
                    zzadsVar.zza(zzapVarZzc);
                    zzapVar = zzapVarZzc;
                } else {
                    zzapVar = null;
                }
                zzev zzevVarZzc2 = zzeuVar.zzc(1836476516);
                zzevVarZzc2.getClass();
                zzap zzapVar3 = new zzap(-9223372036854775807L, zzaik.zzd(zzevVarZzc2.zza));
                int i10 = this.zzc;
                List listZzb = zzaik.zzb(zzeuVar, zzadsVar, -9223372036854775807L, null, 1 == (i10 & 1), z2, zzaiw.zza, false);
                String strZza = zzaiu.zza(listZzb);
                int i11 = 0;
                int i12 = 0;
                long j8 = -9223372036854775807L;
                int size = -1;
                while (i11 < listZzb.size()) {
                    zzaji zzajiVar = (zzaji) listZzb.get(i11);
                    int i13 = i9;
                    if (zzajiVar.zzb == 0) {
                        arrayDeque = arrayDeque2;
                        i8 = i11;
                        i2 = i12;
                        list = listZzb;
                    } else {
                        zzajf zzajfVar = zzajiVar.zza;
                        zzadd zzaddVar = this.zzx;
                        i2 = i12 + 1;
                        arrayDeque = arrayDeque2;
                        int i14 = zzajfVar.zzb;
                        zzaiy zzaiyVar = new zzaiy(zzajfVar, zzajiVar, zzaddVar.zzu(i12, i14));
                        list = listZzb;
                        long j9 = zzajfVar.zze;
                        if (j9 == -9223372036854775807L) {
                            j9 = zzajiVar.zzh;
                        }
                        i8 = i11;
                        zzaem zzaemVar = zzaiyVar.zzc;
                        long jMax = Math.max(j8, j9);
                        zzv zzvVar = zzajfVar.zzg;
                        String str = zzvVar.zzo;
                        int i15 = "audio/true-hd".equals(str) ? zzajiVar.zze * 16 : zzajiVar.zze + 30;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzn(i15);
                        if (i14 == 2) {
                            int i16 = zzvVar.zzf;
                            if ((i10 & 8) != 0) {
                                i16 |= size == -1 ? 1 : 2;
                            }
                            zztVarZza.zzg(i16);
                            i14 = 2;
                        }
                        zzait.zzb(i14, zzadsVar, zztVarZza);
                        zzap zzapVar4 = zzvVar.zzl;
                        List list2 = this.zzj;
                        if (list2.isEmpty()) {
                            j3 = jMax;
                            zzapVar2 = null;
                        } else {
                            j3 = jMax;
                            zzapVar2 = new zzap(list2);
                        }
                        zzap[] zzapVarArr = new zzap[3];
                        zzapVarArr[i13] = zzapVar2;
                        zzapVarArr[1] = zzapVar;
                        zzapVarArr[2] = zzapVar3;
                        zzait.zza(i14, zzapVarZze, zztVarZza, zzapVar4, zzapVarArr);
                        zztVarZza.zzl(strZza);
                        if (Objects.equals(str, "audio/mpeg")) {
                            zzaiyVar.zzf = zztVarZza.zzM();
                        } else {
                            zzaemVar.zzu(zztVarZza.zzM());
                        }
                        if (i14 == 2 && size == -1) {
                            size = arrayList.size();
                        }
                        arrayList.add(zzaiyVar);
                        j8 = j3;
                    }
                    i11 = i8 + 1;
                    listZzb = list;
                    i9 = i13;
                    i12 = i2;
                    arrayDeque2 = arrayDeque;
                }
                ArrayDeque arrayDeque3 = arrayDeque2;
                int i17 = -1;
                zzaiy[] zzaiyVarArr = (zzaiy[]) arrayList.toArray(new zzaiy[i9]);
                this.zzy = zzaiyVarArr;
                int length = zzaiyVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i18 = 0; i18 < zzaiyVarArr.length; i18++) {
                    jArr[i18] = new long[zzaiyVarArr[i18].zzb.zzb];
                    jArr2[i18] = zzaiyVarArr[i18].zzb.zzf[0];
                }
                long j10 = 0;
                int i19 = 0;
                while (i19 < zzaiyVarArr.length) {
                    long j11 = Long.MAX_VALUE;
                    int i20 = i17;
                    for (int i21 = 0; i21 < zzaiyVarArr.length; i21++) {
                        if (!zArr[i21]) {
                            long j12 = jArr2[i21];
                            if (j12 <= j11) {
                                i20 = i21;
                                j11 = j12;
                            }
                        }
                    }
                    int i22 = iArr[i20];
                    long[] jArr3 = jArr[i20];
                    jArr3[i22] = j10;
                    zzaji zzajiVar2 = zzaiyVarArr[i20].zzb;
                    zzaiy[] zzaiyVarArr2 = zzaiyVarArr;
                    boolean[] zArr2 = zArr;
                    j10 += (long) zzajiVar2.zzd[i22];
                    int i23 = i22 + 1;
                    iArr[i20] = i23;
                    if (i23 < jArr3.length) {
                        jArr2[i20] = zzajiVar2.zzf[i23];
                    } else {
                        zArr2[i20] = true;
                        i19++;
                    }
                    zzaiyVarArr = zzaiyVarArr2;
                    zArr = zArr2;
                    i17 = -1;
                }
                this.zzz = jArr;
                this.zzx.zzv();
                this.zzx.zzw(new zzaix(j8, this.zzy, size));
                arrayDeque3.clear();
                this.zzl = 2;
            } else if (!arrayDeque2.isEmpty()) {
                ((zzeu) arrayDeque2.peek()).zzb(zzeuVar);
            }
        }
        if (this.zzl != 2) {
            zzi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(zzaji zzajiVar, long j) {
        int iZza = zzajiVar.zza(j);
        return iZza == -1 ? zzajiVar.zzb(j) : iZza;
    }

    private static int zzl(int i2) {
        if (i2 != 1751476579) {
            return i2 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzaeh zzaehVarZzb = zzaje.zzb(zzadbVar, (this.zzc & 2) != 0);
        this.zzk = zzaehVarZzb != null ? zzgpe.zzj(zzaehVarZzb) : zzgpe.zzi();
        return zzaehVarZzb == null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        if ((this.zzc & 16) == 0) {
            zzaddVar = new zzakj(zzaddVar, this.zzb);
        }
        this.zzx = zzaddVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    @Override // com.google.android.gms.internal.ads.zzada
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzadb r35, com.google.android.gms.internal.ads.zzaea r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiz.zzd(com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzaea):int");
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzh.clear();
        this.zzo = 0;
        this.zzq = -1;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = false;
        if (j == 0) {
            if (this.zzl != 3) {
                zzi();
                return;
            } else {
                this.zzi.zza();
                this.zzj.clear();
                return;
            }
        }
        for (zzaiy zzaiyVar : this.zzy) {
            zzaji zzajiVar = zzaiyVar.zzb;
            int iZza = zzajiVar.zza(j3);
            if (iZza == -1) {
                iZza = zzajiVar.zzb(j3);
            }
            zzaiyVar.zze = iZza;
            zzaen zzaenVar = zzaiyVar.zzd;
            if (zzaenVar != null) {
                zzaenVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }

    public zzaiz(zzakg zzakgVar, int i2) {
        this.zzb = zzakgVar;
        this.zzc = i2;
        this.zzk = zzgpe.zzi();
        this.zzl = (i2 & 4) != 0 ? 3 : 0;
        this.zzi = new zzajd();
        this.zzj = new ArrayList();
        this.zzg = new zzeg(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzeg(zzfm.zza);
        this.zze = new zzeg(6);
        this.zzf = new zzeg();
        this.zzq = -1;
        this.zzx = zzadd.zza;
        this.zzy = new zzaiy[0];
    }
}

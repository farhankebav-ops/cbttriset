package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahj {
    public byte[] zzO;
    public zzaen zzU;
    public boolean zzW;
    public zzaem zzY;
    public zzv zzZ;
    public boolean zza;
    public int zzaa;
    private int zzab;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzael zzj;
    public byte[] zzk;
    public zzq zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public boolean zzy = false;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = -1;
    public int zzC = 1000;
    public int zzD = 200;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public float zzN = -1.0f;
    public int zzP = 1;
    public int zzQ = -1;
    public int zzR = 8000;
    public long zzS = 0;
    public long zzT = 0;
    public boolean zzV = false;
    public boolean zzX = true;
    private String zzac = "eng";

    private static Pair zzf(zzeg zzegVar) throws zzat {
        try {
            zzegVar.zzk(16);
            long jZzA = zzegVar.zzA();
            if (jZzA == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzA == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzA != 826496599) {
                zzdt.zzc("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzg = zzegVar.zzg() + 20;
            byte[] bArrZzi = zzegVar.zzi();
            while (true) {
                int length = bArrZzi.length;
                if (iZzg >= length - 4) {
                    throw zzat.zzb("Failed to find FourCC VC1 initialization data", null);
                }
                int i2 = iZzg + 1;
                if (bArrZzi[iZzg] == 0 && bArrZzi[i2] == 0 && bArrZzi[iZzg + 2] == 1 && bArrZzi[iZzg + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzi, iZzg, length)));
                }
                iZzg = i2;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzat {
        int i2;
        int i8;
        try {
            if (bArr[0] != 2) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i9 = 0;
            int i10 = 1;
            while (true) {
                int i11 = bArr[i10];
                i10++;
                i2 = i11 & 255;
                if (i2 != 255) {
                    break;
                }
                i9 += 255;
            }
            int i12 = i9 + i2;
            int i13 = 0;
            while (true) {
                int i14 = bArr[i10];
                i10++;
                i8 = i14 & 255;
                if (i8 != 255) {
                    break;
                }
                i13 += 255;
            }
            int i15 = i13 + i8;
            if (bArr[i10] != 1) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i10, bArr2, 0, i12);
            int i16 = i10 + i12;
            if (bArr[i16] != 3) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i17 = i16 + i15;
            if (bArr[i17] != 5) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i17;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i17, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzeg zzegVar) throws zzat {
        try {
            int iZzu = zzegVar.zzu();
            if (iZzu == 1) {
                return true;
            }
            if (iZzu == 65534) {
                zzegVar.zzh(24);
                if (zzegVar.zzD() == zzahk.zzf.getMostSignificantBits()) {
                    if (zzegVar.zzD() == zzahk.zzf.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzat {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        throw zzat.zzb("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzadd r19, int r20) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zza(com.google.android.gms.internal.ads.zzadd, int):void");
    }

    public final /* synthetic */ void zzb() {
        this.zzY.getClass();
    }

    public final /* synthetic */ int zzc() {
        return this.zzab;
    }

    public final /* synthetic */ void zzd(int i2) {
        this.zzab = i2;
    }

    public final /* synthetic */ void zze(String str) {
        this.zzac = str;
    }
}

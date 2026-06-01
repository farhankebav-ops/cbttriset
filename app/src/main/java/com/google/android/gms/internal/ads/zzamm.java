package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamm implements zzamq {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;

    @Nullable
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzaem zzi;
    private zzaem zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzaem zzw;
    private long zzx;
    private final zzef zzc = new zzef(new byte[7], 7);
    private final zzeg zzd = new zzeg(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzamm(boolean z2, @Nullable String str, int i2, String str2) {
        this.zzb = z2;
        this.zze = str;
        this.zzf = i2;
        this.zzg = str2;
        zzi();
    }

    public static boolean zzf(int i2) {
        return (i2 & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzi();
    }

    private final boolean zzh(zzeg zzegVar, byte[] bArr, int i2) {
        int iMin = Math.min(zzegVar.zzd(), i2 - this.zzl);
        zzegVar.zzm(bArr, this.zzl, iMin);
        int i8 = this.zzl + iMin;
        this.zzl = i8;
        return i8 == i2;
    }

    private final void zzi() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzj(zzaem zzaemVar, long j, int i2, int i8) {
        this.zzk = 4;
        this.zzl = i2;
        this.zzw = zzaemVar;
        this.zzx = j;
        this.zzu = i8;
    }

    private final void zzk() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private static final boolean zzl(byte b8, byte b9) {
        return zzf((b9 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzeg zzegVar, byte[] bArr, int i2) {
        if (zzegVar.zzd() < i2) {
            return false;
        }
        zzegVar.zzm(bArr, 0, i2);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzv = -9223372036854775807L;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzh = zzaoeVar.zzc();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 1);
        this.zzi = zzaemVarZzu;
        this.zzw = zzaemVarZzu;
        if (!this.zzb) {
            this.zzj = new zzacx();
            return;
        }
        zzaoeVar.zza();
        zzaem zzaemVarZzu2 = zzaddVar.zzu(zzaoeVar.zzb(), 5);
        this.zzj = zzaemVarZzu2;
        zzt zztVar = new zzt();
        zztVar.zza(zzaoeVar.zzc());
        zztVar.zzl(this.zzg);
        zztVar.zzm("application/id3");
        zzaemVarZzu2.zzu(zztVar.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i2) {
        this.zzv = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x025b, code lost:
    
        r18.zzk = 1;
        r18.zzl = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0261, code lost:
    
        zzk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0264, code lost:
    
        r19.zzh(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0247, code lost:
    
        r18.zzr = (r14 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0250, code lost:
    
        if (1 == ((r14 & 1) ^ 1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0252, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0254, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0255, code lost:
    
        r18.zzn = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0259, code lost:
    
        if (r18.zzo != false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0247 A[EDGE_INSN: B:143:0x0247->B:94:0x0247 BREAK  A[LOOP:1: B:48:0x01a0->B:169:0x01a0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ff  */
    @Override // com.google.android.gms.internal.ads.zzamq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzeg r19) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamm.zzd(com.google.android.gms.internal.ads.zzeg):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z2) {
    }
}

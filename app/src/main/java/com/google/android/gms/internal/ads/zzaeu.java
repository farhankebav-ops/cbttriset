package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaeu implements zzada {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private final byte[] zze;
    private final zzaem zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private zzadd zzn;
    private zzaem zzo;
    private zzaem zzp;
    private zzaed zzq;
    private long zzr;
    private boolean zzs;

    static {
        String str = zzep.zza;
        Charset charset = StandardCharsets.UTF_8;
        zzc = "#!AMR\n".getBytes(charset);
        zzd = "#!AMR-WB\n".getBytes(charset);
    }

    public zzaeu() {
        throw null;
    }

    private final boolean zzg(zzadb zzadbVar) throws IOException {
        byte[] bArr = zzc;
        if (zzh(zzadbVar, bArr)) {
            this.zzg = false;
            zzadbVar.zzf(bArr.length);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzh(zzadbVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        zzadbVar.zzf(bArr2.length);
        return true;
    }

    private static boolean zzh(zzadb zzadbVar, byte[] bArr) throws IOException {
        zzadbVar.zzl();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzadbVar.zzi(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[Catch: EOFException -> 0x00a4, TryCatch #0 {EOFException -> 0x00a4, blocks: (B:4:0x0007, B:6:0x0018, B:20:0x003a, B:22:0x0043, B:21:0x003f, B:31:0x005d, B:32:0x0085, B:33:0x0086, B:34:0x00a3), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f A[Catch: EOFException -> 0x00a4, TryCatch #0 {EOFException -> 0x00a4, blocks: (B:4:0x0007, B:6:0x0018, B:20:0x003a, B:22:0x0043, B:21:0x003f, B:31:0x005d, B:32:0x0085, B:33:0x0086, B:34:0x00a3), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"realTrackOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzi(com.google.android.gms.internal.ads.zzadb r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeu.zzi(com.google.android.gms.internal.ads.zzadb):int");
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return zzg(zzadbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzn = zzaddVar;
        zzaem zzaemVarZzu = zzaddVar.zzu(0, 1);
        this.zzo = zzaemVarZzu;
        this.zzp = zzaemVarZzu;
        zzaddVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        this.zzo.getClass();
        String str = zzep.zza;
        if (zzadbVar.zzn() == 0 && !zzg(zzadbVar)) {
            throw zzat.zzb("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z2 = this.zzg;
            String str2 = true != z2 ? "audio/amr" : "audio/amr-wb";
            String str3 = true != z2 ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z2 ? 8000 : 16000;
            int i8 = z2 ? zzb[8] : zza[7];
            zzaem zzaemVar = this.zzo;
            zzt zztVar = new zzt();
            zztVar.zzl(str2);
            zztVar.zzm(str3);
            zztVar.zzn(i8);
            zztVar.zzE(1);
            zztVar.zzF(i2);
            zzaemVar.zzu(zztVar.zzM());
        }
        int iZzi = zzi(zzadbVar);
        if (this.zzq == null) {
            zzaec zzaecVar = new zzaec(-9223372036854775807L, 0L);
            this.zzq = zzaecVar;
            this.zzn.zzw(zzaecVar);
        }
        return iZzi == -1 ? -1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzr = j3;
        this.zzm = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }

    public zzaeu(int i2) {
        this.zze = new byte[1];
        this.zzk = -1;
        zzacx zzacxVar = new zzacx();
        this.zzf = zzacxVar;
        this.zzp = zzacxVar;
    }
}

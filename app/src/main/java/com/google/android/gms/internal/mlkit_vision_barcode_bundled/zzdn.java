package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdn extends zzcx {
    private static final Logger zzb = Logger.getLogger(zzdn.class.getName());
    private static final boolean zzc = zzgz.zzx();
    zzdo zza;

    private zzdn() {
        throw null;
    }

    public static int zzA(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public static int zzB(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i2, zzfm zzfmVar, zzge zzgeVar) {
        int iZzA = zzA(i2 << 3);
        return ((zzcq) zzfmVar).zzB(zzgeVar) + iZzA + iZzA;
    }

    public static int zzx(zzfm zzfmVar) {
        int iZzF = zzfmVar.zzF();
        return zzA(iZzF) + iZzF;
    }

    public static int zzy(zzfm zzfmVar, zzge zzgeVar) {
        int iZzB = ((zzcq) zzfmVar).zzB(zzgeVar);
        return zzA(iZzB) + iZzB;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzhe.zze(str);
        } catch (zzhd unused) {
            length = str.getBytes(zzep.zza).length;
        }
        return zzA(length) + length;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzhd zzhdVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhdVar);
        byte[] bytes = str.getBytes(zzep.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b8) throws IOException;

    public abstract void zzd(int i2, boolean z2) throws IOException;

    public abstract void zze(int i2, zzdf zzdfVar) throws IOException;

    public abstract void zzf(int i2, int i8) throws IOException;

    public abstract void zzg(int i2) throws IOException;

    public abstract void zzh(int i2, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i2, int i8) throws IOException;

    public abstract void zzk(int i2) throws IOException;

    public abstract void zzl(byte[] bArr, int i2, int i8) throws IOException;

    public abstract void zzm(int i2, zzfm zzfmVar, zzge zzgeVar) throws IOException;

    public abstract void zzn(int i2, zzfm zzfmVar) throws IOException;

    public abstract void zzo(int i2, zzdf zzdfVar) throws IOException;

    public abstract void zzp(int i2, String str) throws IOException;

    public abstract void zzr(int i2, int i8) throws IOException;

    public abstract void zzs(int i2, int i8) throws IOException;

    public abstract void zzt(int i2) throws IOException;

    public abstract void zzu(int i2, long j) throws IOException;

    public abstract void zzv(long j) throws IOException;

    public /* synthetic */ zzdn(zzdm zzdmVar) {
    }
}

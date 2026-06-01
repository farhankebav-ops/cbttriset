package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgbk {
    private MessageDigest zza;
    private final zzgjd zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private SecureRandom zze;

    public zzgbk(zzgjd zzgjdVar) {
        this.zzb = zzgjdVar;
    }

    public final void zza() {
        if (zzc()) {
            return;
        }
        zzb(new SecureRandom());
    }

    public final synchronized void zzb(SecureRandom secureRandom) {
        zzgjb zzgjbVarZza = this.zzb.zza(202);
        try {
            try {
                try {
                    zzgjbVarZza.zza();
                    this.zze = secureRandom;
                    this.zza = MessageDigest.getInstance("MD5");
                    this.zzd = true;
                } catch (NoSuchAlgorithmException e) {
                    zzgjbVarZza.zzb(e);
                }
                zzgjbVarZza.zzc();
            } catch (Throwable th) {
                zzgjbVarZza.zzb(th);
                throw th;
            }
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    public final synchronized boolean zzc() {
        return this.zzd;
    }

    public final byte[] zzd(byte[] bArr, String str, boolean z2) throws UnsupportedEncodingException {
        int length = bArr.length;
        int i2 = true != z2 ? 255 : 239;
        zzgmd.zza(length <= i2);
        ByteBuffer byteBufferPut = ByteBuffer.allocate(i2 + 1).put((byte) length);
        if (length < i2) {
            int i8 = i2 - length;
            byte[] bArr2 = new byte[i8];
            this.zze.nextBytes(bArr2);
            bArr = Arrays.copyOf(bArr, length + i8);
            System.arraycopy(bArr2, 0, bArr, length, i8);
        }
        byte[] bArrArray = byteBufferPut.put(bArr).array();
        if (z2) {
            bArrArray = ByteBuffer.allocate(256).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzgbn[] zzgbnVarArr = new zzgca().zzcG;
        int length2 = zzgbnVarArr.length;
        for (int i9 = 0; i9 < 12; i9++) {
            zzgbnVarArr[i9].zza(bArrArray, bArr3);
        }
        if (!zzgmu.zzc(str)) {
            new zzgbm(str.length() > 32 ? str.substring(0, 32).getBytes(StandardCharsets.UTF_8) : str.getBytes(StandardCharsets.UTF_8)).zza(bArr3);
        }
        return bArr3;
    }

    public final byte[] zze(byte[] bArr) {
        byte[] bArrDigest;
        synchronized (this.zzc) {
            this.zza.reset();
            this.zza.update(bArr);
            bArrDigest = this.zza.digest();
        }
        return bArrDigest;
    }

    public final zzavp zzf(byte[] bArr, String str) throws UnsupportedEncodingException {
        zzavp zzavpVarZza = zzavq.zza();
        byte[] bArrZze = zze(bArr);
        zzhvi zzhviVar = zzhvi.zzb;
        zzavpVarZza.zzb(zzhvi.zzr(bArrZze, 0, bArrZze.length));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int length = bArr.length;
            if (i2 >= ((length - 1) / 255) + 1) {
                break;
            }
            int i8 = i2 * 255;
            int i9 = i8 + 255;
            if (length > i9) {
                length = i9;
            }
            arrayList.add(Arrays.copyOfRange(bArr, i8, length));
            i2++;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            zzavpVarZza.zza(zzhvi.zzr(zzd((byte[]) obj, str, false), 0, 256));
        }
        return zzavpVarZza;
    }

    public final String zzg(int i2, String str) throws UnsupportedEncodingException {
        zzauc zzaucVarZzj = zzauz.zzj();
        zzaucVarZzj.zzl(i2);
        return Base64.encodeToString(zzd(((zzauz) zzaucVarZzj.zzbu()).zzaN(), str, true), 11);
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzftb {
    private final zzbai zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzftb(@NonNull zzbai zzbaiVar, @NonNull File file, @NonNull File file2, @NonNull File file3) {
        this.zza = zzbaiVar;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzbai zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzb;
    }

    public final File zzc() {
        return this.zzc;
    }

    public final byte[] zzd() throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArrZzv;
        ArrayList arrayList;
        int iMin;
        FileInputStream fileInputStream2 = null;
        if (this.zze == null) {
            try {
                fileInputStream = new FileInputStream(this.zzd);
            } catch (IOException unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                zzhvi zzhviVar = zzhvi.zzb;
                arrayList = new ArrayList();
                iMin = 256;
            } catch (IOException unused2) {
                IOUtils.closeQuietly(fileInputStream);
                bArrZzv = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly(fileInputStream2);
                throw th;
            }
            while (true) {
                byte[] bArr = new byte[iMin];
                int i2 = 0;
                while (i2 < iMin) {
                    int i8 = fileInputStream.read(bArr, i2, iMin - i2);
                    if (i8 == -1) {
                        break;
                    }
                    i2 += i8;
                }
                zzhvi zzhviVarZzr = i2 == 0 ? null : zzhvi.zzr(bArr, 0, i2);
                if (zzhviVarZzr == null) {
                    break;
                }
                arrayList.add(zzhviVarZzr);
                iMin = Math.min(iMin + iMin, 8192);
                this.zze = bArrZzv;
            }
            bArrZzv = zzhvi.zzt(arrayList).zzv();
            IOUtils.closeQuietly(fileInputStream);
            this.zze = bArrZzv;
        }
        byte[] bArr2 = this.zze;
        if (bArr2 == null) {
            return null;
        }
        return Arrays.copyOf(bArr2, bArr2.length);
    }

    public final boolean zze(long j) {
        return this.zza.zzc() - (System.currentTimeMillis() / 1000) < 3600;
    }
}

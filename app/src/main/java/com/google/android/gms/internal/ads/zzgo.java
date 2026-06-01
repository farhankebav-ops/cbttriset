package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgo extends zzft {

    @Nullable
    private RandomAccessFile zza;

    @Nullable
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzgo() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws zzgn {
        if (i8 == 0) {
            return 0;
        }
        long j = this.zzc;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            String str = zzep.zza;
            int i9 = randomAccessFile.read(bArr, i2, (int) Math.min(j, i8));
            if (i9 > 0) {
                this.zzc -= (long) i9;
                zzh(i9);
            }
            return i9;
        } catch (IOException e) {
            throw new zzgn(e, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws zzgn {
        Uri uri = zzgfVar.zza;
        this.zzb = uri;
        zzf(zzgfVar);
        try {
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            this.zza = randomAccessFile;
            try {
                long j = zzgfVar.zze;
                randomAccessFile.seek(j);
                long length = zzgfVar.zzf;
                if (length == -1) {
                    length = this.zza.length() - j;
                }
                this.zzc = length;
                if (length < 0) {
                    throw new zzgn(null, null, 2008);
                }
                this.zzd = true;
                zzg(zzgfVar);
                return this.zzc;
            } catch (IOException e) {
                throw new zzgn(e, 2000);
            }
        } catch (FileNotFoundException e4) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new zzgn(e4, ((e4.getCause() instanceof ErrnoException) && ((ErrnoException) e4.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005);
            }
            String path2 = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();
            StringBuilder sbZ = a1.a.z("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=", path2, ",query=", query, ",fragment=");
            sbZ.append(fragment);
            throw new zzgn(sbZ.toString(), e4, 1004);
        } catch (SecurityException e8) {
            throw new zzgn(e8, 2006);
        } catch (RuntimeException e9) {
            throw new zzgn(e9, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzgn {
        this.zzb = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.zza;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.zza = null;
                if (this.zzd) {
                    this.zzd = false;
                    zzi();
                }
            } catch (IOException e) {
                throw new zzgn(e, 2000);
            }
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzi();
            }
            throw th;
        }
    }
}

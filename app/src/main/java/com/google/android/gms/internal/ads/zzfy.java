package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfy extends zzft {
    private final ContentResolver zza;

    @Nullable
    private Uri zzb;

    @Nullable
    private AssetFileDescriptor zzc;

    @Nullable
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzfy(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws zzfx {
        if (i8 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i8 = (int) Math.min(j, i8);
            } catch (IOException e) {
                throw new zzfx(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        String str = zzep.zza;
        int i9 = fileInputStream.read(bArr, i2, i8);
        if (i9 == -1) {
            return -1;
        }
        long j3 = this.zze;
        if (j3 != -1) {
            this.zze = j3 - ((long) i9);
        }
        zzh(i9);
        return i9;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws zzfx {
        int i2;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        long jPosition;
        try {
            try {
                Uri uriNormalizeScheme = zzgfVar.zza.normalizeScheme();
                this.zzb = uriNormalizeScheme;
                zzf(zzgfVar);
                if (Objects.equals(uriNormalizeScheme.getScheme(), "content")) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = this.zza.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = this.zza.openAssetFileDescriptor(uriNormalizeScheme, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
                }
                this.zzc = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    String strValueOf = String.valueOf(uriNormalizeScheme);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
                    sb.append("Could not open file descriptor for: ");
                    sb.append(strValueOf);
                    IOException iOException = new IOException(sb.toString());
                    i2 = 2000;
                    try {
                        throw new zzfx(iOException, 2000);
                    } catch (IOException e) {
                        e = e;
                        throw new zzfx(e, true != (e instanceof FileNotFoundException) ? i2 : 2005);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.zzd = fileInputStream;
                if (length != -1 && zzgfVar.zze > length) {
                    throw new zzfx(null, 2008);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long j = zzgfVar.zze;
                long jSkip = fileInputStream.skip(startOffset + j) - startOffset;
                if (jSkip != j) {
                    throw new zzfx(null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.zze = -1L;
                        jPosition = -1;
                    } else {
                        jPosition = size - channel.position();
                        this.zze = jPosition;
                        if (jPosition < 0) {
                            throw new zzfx(null, 2008);
                        }
                    }
                } else {
                    long j3 = length - jSkip;
                    this.zze = j3;
                    if (j3 < 0) {
                        throw new zzfx(null, 2008);
                    }
                    jPosition = j3;
                }
                long j8 = zzgfVar.zzf;
                if (j8 != -1) {
                    this.zze = jPosition == -1 ? j8 : Math.min(jPosition, j8);
                }
                this.zzf = true;
                zzg(zzgfVar);
                return j8 != -1 ? j8 : this.zze;
            } catch (IOException e4) {
                e = e4;
                i2 = 2000;
            }
        } catch (zzfx e8) {
            throw e8;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzfx {
        this.zzb = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = this.zzd;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.zzd = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzc;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzi();
                        }
                    } catch (IOException e) {
                        throw new zzfx(e, 2000);
                    }
                } catch (Throwable th) {
                    this.zzd = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzi();
                        }
                        throw th;
                    } catch (IOException e4) {
                        throw new zzfx(e4, 2000);
                    }
                }
            } catch (Throwable th2) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzi();
                }
                throw th2;
            }
        } catch (IOException e8) {
            throw new zzfx(e8, 2000);
        }
    }
}

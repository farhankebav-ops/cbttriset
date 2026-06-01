package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgx extends zzft {
    private final Context zza;

    @Nullable
    private zzgf zzb;

    @Nullable
    private AssetFileDescriptor zzc;

    @Nullable
    private InputStream zzd;
    private long zze;
    private boolean zzf;

    public zzgx(Context context) {
        super(false);
        this.zza = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
        sb.append("rawresource:///");
        sb.append(i2);
        return Uri.parse(sb.toString());
    }

    private static AssetFileDescriptor zzk(Context context, zzgf zzgfVar) throws zzgw {
        Resources resourcesForApplication;
        int identifier;
        Uri uriNormalizeScheme = zzgfVar.zza.normalizeScheme();
        if (TextUtils.equals("rawresource", uriNormalizeScheme.getScheme())) {
            resourcesForApplication = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                int size = pathSegments.size();
                throw new zzgw(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(size).length() + 61), "rawresource:// URI must have exactly one path element, found ", size));
            }
            identifier = zzl(pathSegments.get(0));
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                String scheme = uriNormalizeScheme.getScheme();
                throw new zzgw(a1.a.s(new StringBuilder(String.valueOf(scheme).length() + 62), "Unsupported URI scheme (", scheme, "). Only android.resource is supported."), null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new zzgw("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e, 2005);
                }
            }
            if (path.matches("\\d+")) {
                identifier = zzl(path);
            } else {
                identifier = resourcesForApplication.getIdentifier(a1.a.s(new StringBuilder(packageName.length() + 1 + path.length()), packageName, ":", path), "raw", null);
                if (identifier == 0) {
                    throw new zzgw("Resource not found.", null, 2005);
                }
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resourcesForApplication.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd != null) {
                return assetFileDescriptorOpenRawResourceFd;
            }
            throw new zzgw("Resource is compressed: ".concat(String.valueOf(uriNormalizeScheme)), null, 2000);
        } catch (Resources.NotFoundException e4) {
            throw new zzgw(null, e4, 2005);
        }
    }

    private static int zzl(String str) throws zzgw {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new zzgw("Resource identifier must be an integer.", null, 1004);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws zzgw {
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
                throw new zzgw(null, e, 2000);
            }
        }
        InputStream inputStream = this.zzd;
        String str = zzep.zza;
        int i9 = inputStream.read(bArr, i2, i8);
        if (i9 == -1) {
            if (this.zze == -1) {
                return -1;
            }
            throw new zzgw("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j3 = this.zze;
        if (j3 != -1) {
            this.zze = j3 - ((long) i9);
        }
        zzh(i9);
        return i9;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws zzgw {
        long size;
        this.zzb = zzgfVar;
        zzf(zzgfVar);
        AssetFileDescriptor assetFileDescriptorZzk = zzk(this.zza, zzgfVar);
        this.zzc = assetFileDescriptorZzk;
        long length = assetFileDescriptorZzk.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.zzc.getFileDescriptor());
        this.zzd = fileInputStream;
        if (length != -1) {
            try {
                if (zzgfVar.zze > length) {
                    throw new zzgw(null, null, 2008);
                }
            } catch (zzgw e) {
                throw e;
            } catch (IOException e4) {
                throw new zzgw(null, e4, 2000);
            }
        }
        long startOffset = this.zzc.getStartOffset();
        long j = zzgfVar.zze;
        long jSkip = fileInputStream.skip(startOffset + j) - startOffset;
        if (jSkip != j) {
            throw new zzgw(null, null, 2008);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.zze = -1L;
                size = -1;
            } else {
                size = channel.size() - channel.position();
                this.zze = size;
                if (size < 0) {
                    throw new zzgw(null, null, 2008);
                }
            }
        } else {
            long j3 = length - jSkip;
            this.zze = j3;
            if (j3 < 0) {
                throw new zzgc(2008);
            }
            size = j3;
        }
        long j8 = zzgfVar.zzf;
        if (j8 != -1) {
            this.zze = size == -1 ? j8 : Math.min(size, j8);
        }
        this.zzf = true;
        zzg(zzgfVar);
        return j8 != -1 ? j8 : this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        zzgf zzgfVar = this.zzb;
        if (zzgfVar != null) {
            return zzgfVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzgw {
        this.zzb = null;
        try {
            try {
                try {
                    InputStream inputStream = this.zzd;
                    if (inputStream != null) {
                        inputStream.close();
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
                        throw new zzgw(null, e, 2000);
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
                        throw new zzgw(null, e4, 2000);
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
            throw new zzgw(null, e8, 2000);
        }
    }
}

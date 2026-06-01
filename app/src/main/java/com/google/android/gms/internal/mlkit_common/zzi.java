package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import androidx.core.content.ContextCompat;
import com.ironsource.C2300e4;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzi {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        String str = Build.HARDWARE;
        zzc = new String[]{C2300e4.h.I0, (str.equals("goldfish") || str.equals("ranchu")) ? "androidx.test.services.storage.runfiles" : ""};
        int i2 = Build.VERSION.SDK_INT;
        zzd = new String[]{i2 <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : "", i2 <= 25 ? "com.google.android.inputmethod.latin.dev.inputcontent" : "", "com.google.android.apps.docs.storage.legacy"};
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        zzh zzhVar = zzh.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriZzc = zzc(uri);
        String scheme = uriZzc.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(uriZzc, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        }
        if ("content".equals(scheme)) {
            if (!zzj(context, uriZzc, 1, zzhVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriZzc, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            zzd(assetFileDescriptorOpenAssetFileDescriptor);
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        if (!C2300e4.h.f8363b.equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uriZzc, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        zzd(assetFileDescriptorOpenAssetFileDescriptor2);
        try {
            zzi(context, assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor(), uriZzc, zzhVar);
            return assetFileDescriptorOpenAssetFileDescriptor2;
        } catch (FileNotFoundException e) {
            zzg(assetFileDescriptorOpenAssetFileDescriptor2, e);
            throw e;
        } catch (IOException e4) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
            fileNotFoundException.initCause(e4);
            zzg(assetFileDescriptorOpenAssetFileDescriptor2, fileNotFoundException);
            throw fileNotFoundException;
        }
    }

    public static InputStream zzb(Context context, Uri uri, zzh zzhVar) throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriZzc = zzc(uri);
        String scheme = uriZzc.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openInputStream(uriZzc);
        }
        if ("content".equals(scheme)) {
            if (!zzj(context, uriZzc, 1, zzhVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uriZzc);
            zzd(inputStreamOpenInputStream);
            return inputStreamOpenInputStream;
        }
        if (!C2300e4.h.f8363b.equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(uriZzc.getPath()).getCanonicalFile()), AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            try {
                zzi(context, parcelFileDescriptorOpenFileDescriptor, uriZzc, zzhVar);
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorOpenFileDescriptor);
            } catch (FileNotFoundException e) {
                zzh(parcelFileDescriptorOpenFileDescriptor, e);
                throw e;
            } catch (IOException e4) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e4);
                zzh(parcelFileDescriptorOpenFileDescriptor, fileNotFoundException);
                throw fileNotFoundException;
            }
        } catch (IOException e8) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
            fileNotFoundException2.initCause(e8);
            throw fileNotFoundException2;
        }
    }

    private static Uri zzc(Uri uri) {
        return Build.VERSION.SDK_INT < 30 ? Uri.parse(uri.toString()) : uri;
    }

    private static Object zzd(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static String zze(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith("/") ? canonicalPath.concat("/") : canonicalPath;
    }

    private static void zzf(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        try {
            StructStat structStatFstat = Os.fstat(parcelFileDescriptor.getFileDescriptor());
            try {
                StructStat structStatLstat = Os.lstat(str);
                if (OsConstants.S_ISLNK(structStatLstat.st_mode)) {
                    throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(str)));
                }
                if (structStatFstat.st_dev != structStatLstat.st_dev || structStatFstat.st_ino != structStatLstat.st_ino) {
                    throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(str)));
                }
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        } catch (ErrnoException e4) {
            throw new IOException(e4);
        }
    }

    private static void zzg(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            fileNotFoundException.addSuppressed(e);
        }
    }

    private static void zzh(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            fileNotFoundException.addSuppressed(e);
        }
    }

    private static void zzi(final Context context, ParcelFileDescriptor parcelFileDescriptor, Uri uri, zzh zzhVar) throws IOException {
        File dataDir;
        String canonicalPath = new File(uri.getPath()).getCanonicalPath();
        zzf(parcelFileDescriptor, canonicalPath);
        if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
            zzh.zza(zzhVar);
            File dataDir2 = ContextCompat.getDataDir(context);
            boolean z2 = true;
            if (dataDir2 == null ? !canonicalPath.startsWith(zze(Environment.getDataDirectory())) : !canonicalPath.startsWith(zze(dataDir2))) {
                Context contextCreateDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(context);
                if (contextCreateDeviceProtectedStorageContext == null || (dataDir = ContextCompat.getDataDir(contextCreateDeviceProtectedStorageContext)) == null || !canonicalPath.startsWith(zze(dataDir))) {
                    File[] fileArrZzk = zzk(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzb
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            int i2 = zzi.zza;
                            return ContextCompat.getExternalFilesDirs(context, null);
                        }
                    });
                    int length = fileArrZzk.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            File file = fileArrZzk[i2];
                            if (file != null && canonicalPath.startsWith(zze(file))) {
                                break;
                            } else {
                                i2++;
                            }
                        } else {
                            File[] fileArrZzk2 = zzk(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzc
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    int i8 = zzi.zza;
                                    return ContextCompat.getExternalCacheDirs(context);
                                }
                            });
                            int length2 = fileArrZzk2.length;
                            int i8 = 0;
                            while (true) {
                                if (i8 < length2) {
                                    File file2 = fileArrZzk2[i8];
                                    if (file2 != null && canonicalPath.startsWith(zze(file2))) {
                                        break;
                                    } else {
                                        i8++;
                                    }
                                } else {
                                    z2 = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (z2 == zzhVar.zzb) {
                return;
            }
        }
        throw new FileNotFoundException("Can't open file: ".concat(canonicalPath));
    }

    private static boolean zzj(Context context, Uri uri, int i2, zzh zzhVar) {
        String authority = uri.getAuthority();
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (providerInfoResolveContentProvider == null) {
            int iLastIndexOf = authority.lastIndexOf(64);
            if (iLastIndexOf >= 0) {
                authority = authority.substring(iLastIndexOf + 1);
                providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (providerInfoResolveContentProvider == null) {
                return !zzhVar.zzb;
            }
        }
        if (zzh.zzc(zzhVar, context, new zzj(uri, providerInfoResolveContentProvider, authority)) - 1 == 1) {
            return false;
        }
        if (context.getPackageName().equals(providerInfoResolveContentProvider.packageName)) {
            return zzhVar.zzb;
        }
        if (zzhVar.zzb) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && providerInfoResolveContentProvider.exported) {
            String[] strArr = zzc;
            int length = strArr.length;
            for (int i8 = 0; i8 < 2; i8++) {
                if (strArr[i8].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = zzd;
            int length2 = strArr2.length;
            for (int i9 = 0; i9 < 3; i9++) {
                if (strArr2[i9].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = zzb;
            for (int i10 = 0; i10 < 6; i10++) {
                String str = strArr3[i10];
                if (str.charAt(str.length() - 1) == '.') {
                    if (providerInfoResolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (providerInfoResolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File[] zzk(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}

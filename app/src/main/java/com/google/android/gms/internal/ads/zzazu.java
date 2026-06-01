package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazu {
    public static String zza(Context context, String str, List list, Executor executor) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, CertificateEncodingException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
            return null;
        }
        final zzgvb zzgvbVarZze = zzgvb.zze();
        context.getPackageManager().requestChecksums(str, false, 8, list, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzazt
            public final /* synthetic */ void onChecksumsReady(List list2) {
                zzgvb zzgvbVar = zzgvbVarZze;
                if (list2 == null) {
                    zzgvbVar.zza((Object) null);
                    return;
                }
                try {
                    int size = list2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ApkChecksum apkChecksumB = c.a.b(list2.get(i2));
                        if (apkChecksumB.getType() == 8) {
                            zzgvbVar.zza(zzayg.zza(apkChecksumB.getValue()));
                            return;
                        }
                    }
                    zzgvbVar.zza((Object) null);
                } catch (Throwable unused) {
                    zzgvbVar.zza((Object) null);
                }
            }
        });
        return (String) zzgvbVarZze.get();
    }
}

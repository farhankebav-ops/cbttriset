package com.google.android.gms.internal.ads;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfrn {

    @VisibleForTesting
    protected static final byte[] zza = {61, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};

    @VisibleForTesting
    protected static final byte[] zzb = {-110, -13, -34, 70, -83, 43, 97, 21, -44, 16, -54, -125, -28, -57, -125, -127, -7, 17, 102, -69, 116, -121, -79, 43, -13, 120, 58, 55, -29, -108, 95, 83};
    private final byte[] zzc = zzb;
    private final byte[] zzd = zza;

    public final boolean zza(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] x509CertificateArrZza = zzapa.zza(file.getAbsolutePath());
            if (x509CertificateArrZza.length != 1) {
                throw new GeneralSecurityException("APK has more than one signature.");
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(x509CertificateArrZza[0][0].getEncoded());
            if (Arrays.equals(this.zzd, bArrDigest)) {
                return true;
            }
            return !"user".equals(Build.TYPE) && Arrays.equals(this.zzc, bArrDigest);
        } catch (zzaox e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException e4) {
            e = e4;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        } catch (RuntimeException e8) {
            e = e8;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        }
    }
}

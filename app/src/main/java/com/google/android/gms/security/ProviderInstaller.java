package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ProviderInstaller {

    @NonNull
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();

    @Nullable
    @GuardedBy("ProviderInstaller.lock")
    private static Method zzc = null;

    @GuardedBy("ProviderInstaller.lock")
    private static boolean zzd = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i2, @Nullable Intent intent);

        void onProviderInstalled();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[Catch: all -> 0x0028, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098 A[Catch: all -> 0x0028, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void installIfNeeded(@androidx.annotation.NonNull android.content.Context r12) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            java.lang.String r0 = "Context must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12, r0)
            com.google.android.gms.common.GoogleApiAvailabilityLight r0 = com.google.android.gms.security.ProviderInstaller.zza
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.verifyGooglePlayServicesIsAvailable(r12, r1)
            long r0 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r2 = com.google.android.gms.security.ProviderInstaller.zzb
            monitor-enter(r2)
            boolean r3 = com.google.android.gms.security.ProviderInstaller.zzd     // Catch: java.lang.Throwable -> L28
            r4 = 0
            if (r3 != 0) goto L47
            java.lang.String r3 = "Failed to load providerinstaller module: "
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r5 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2b
            java.lang.String r6 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.load(r12, r5, r6)     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2b
            android.content.Context r3 = r5.getModuleContext()     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2b
            goto L3e
        L28:
            r12 = move-exception
            goto La7
        L2b:
            r5 = move-exception
            java.lang.String r6 = "ProviderInstaller"
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r3.concat(r5)     // Catch: java.lang.Throwable -> L28
            android.util.Log.w(r6, r3)     // Catch: java.lang.Throwable -> L28
            r3 = r4
        L3e:
            if (r3 == 0) goto L47
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            zzb(r3, r12, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
            goto L97
        L47:
            boolean r3 = com.google.android.gms.security.ProviderInstaller.zzd     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "Failed to report request stats: "
            android.content.Context r6 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r12)     // Catch: java.lang.Throwable -> L28
            if (r6 != 0) goto L52
            goto L8f
        L52:
            r4 = 1
            com.google.android.gms.security.ProviderInstaller.zzd = r4     // Catch: java.lang.Throwable -> L28
            if (r3 != 0) goto L8e
            long r7 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            java.lang.String r3 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r9 = "reportRequestStats2"
            java.lang.ClassLoader r10 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            com.google.android.gms.internal.common.zzi r11 = com.google.android.gms.internal.common.zzi.zzb(r11, r12)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzh r0 = com.google.android.gms.internal.common.zzh.zza(r0)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzh r1 = com.google.android.gms.internal.common.zzh.zza(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r7 = 3
            com.google.android.gms.internal.common.zzi[] r7 = new com.google.android.gms.internal.common.zzi[r7]     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r8 = 0
            r7[r8] = r11     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r7[r4] = r0     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r0 = 2
            r7[r0] = r1     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzj.zzb(r3, r9, r10, r7)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            goto L8e
        L80:
            r0 = move-exception
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r5.concat(r0)     // Catch: java.lang.Throwable -> L28
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L28
        L8e:
            r4 = r6
        L8f:
            if (r4 == 0) goto L98
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            zzb(r4, r12, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
        L97:
            return
        L98:
            java.lang.String r12 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r12, r0)     // Catch: java.lang.Throwable -> L28
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r12 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException     // Catch: java.lang.Throwable -> L28
            r0 = 8
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L28
            throw r12     // Catch: java.lang.Throwable -> L28
        La7:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.installIfNeeded(android.content.Context):void");
    }

    public static void installIfNeededAsync(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    @GuardedBy("ProviderInstaller.lock")
    private static void zzb(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            zzc.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e.toString() : cause.toString())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}

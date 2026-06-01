package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.processing.util.a;
import androidx.work.WorkRequest;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.ironsource.C2300e4;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AdvertisingIdClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5213a = 0;
    private static final Object zzg = new Object();
    private static volatile AdvertisingIdClient zzh;

    @Nullable
    BlockingServiceConnection zza;

    @Nullable
    zzf zzb;
    boolean zzc;
    final Object zzd;

    @Nullable
    zzb zze;
    final long zzf;
    private final Context zzi;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdkWithMembers
    public static final class Info {

        @Nullable
        private final String zza;
        private final boolean zzb;

        @Deprecated
        public Info(@Nullable String str, boolean z2) {
            this.zza = str;
            this.zzb = z2;
        }

        @Nullable
        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        @NonNull
        public String toString() {
            return "{" + this.zza + "}" + this.zzb;
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(@NonNull Context context) {
        this(context, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getAdvertisingIdInfo(@androidx.annotation.NonNull android.content.Context r16) throws com.google.android.gms.common.GooglePlayServicesRepairableException, java.lang.IllegalStateException, com.google.android.gms.common.GooglePlayServicesNotAvailableException, java.io.IOException {
        /*
            java.lang.String r0 = "GetInfoInternal elapse "
            com.google.android.gms.ads.identifier.AdvertisingIdClient r1 = com.google.android.gms.ads.identifier.AdvertisingIdClient.zzh
            if (r1 != 0) goto L26
            java.lang.Object r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.zzg
            monitor-enter(r2)
            com.google.android.gms.ads.identifier.AdvertisingIdClient r1 = com.google.android.gms.ads.identifier.AdvertisingIdClient.zzh     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L20
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r3 = "Creating AdvertisingIdClient"
            android.util.Log.d(r1, r3)     // Catch: java.lang.Throwable -> L1e
            com.google.android.gms.ads.identifier.AdvertisingIdClient r1 = new com.google.android.gms.ads.identifier.AdvertisingIdClient     // Catch: java.lang.Throwable -> L1e
            r3 = r16
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L1e
            com.google.android.gms.ads.identifier.AdvertisingIdClient.zzh = r1     // Catch: java.lang.Throwable -> L1e
            goto L22
        L1e:
            r0 = move-exception
            goto L24
        L20:
            r3 = r16
        L22:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
            goto L28
        L24:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
            throw r0
        L26:
            r3 = r16
        L28:
            java.lang.String r2 = "AdvertisingIdClient"
            java.lang.String r4 = "AdvertisingIdClient already created."
            android.util.Log.d(r2, r4)
            com.google.android.gms.ads.identifier.zzd r2 = com.google.android.gms.ads.identifier.zzd.zza(r3)
            long r11 = android.os.SystemClock.elapsedRealtime()
            r13 = -1
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = r1.zzf(r13)     // Catch: java.lang.Throwable -> L85
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L85
            long r7 = r5 - r11
            java.lang.String r9 = ""
            r10 = 0
            r5 = 1
            r6 = 0
            r3 = r1
            r3.zze(r4, r5, r6, r7, r9, r10)     // Catch: java.lang.Throwable -> L82
            r14 = r7
            r8 = r11
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7f
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 - r8
            r7 = 0
            int r12 = (int) r5
            r6 = 35401(0x8a49, float:4.9607E-41)
            r5 = r2
            r5.zzc(r6, r7, r8, r10, r12)     // Catch: java.lang.Throwable -> L7b
            r1 = r5
            r11 = r8
            java.lang.String r2 = "AdvertisingIdClient"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L78
            r5.append(r14)     // Catch: java.lang.Throwable -> L78
            java.lang.String r0 = "ms"
            r5.append(r0)     // Catch: java.lang.Throwable -> L78
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L78
            android.util.Log.i(r2, r0)     // Catch: java.lang.Throwable -> L78
            return r4
        L78:
            r0 = move-exception
        L79:
            r10 = r0
            goto L88
        L7b:
            r0 = move-exception
            r1 = r5
        L7d:
            r11 = r8
            goto L79
        L7f:
            r0 = move-exception
            r1 = r2
            goto L7d
        L82:
            r0 = move-exception
        L83:
            r1 = r2
            goto L79
        L85:
            r0 = move-exception
            r3 = r1
            goto L83
        L88:
            r7 = -1
            java.lang.String r9 = ""
            r4 = 0
            r5 = 1
            r6 = 0
            r3.zze(r4, r5, r6, r7, r9, r10)
            r0 = r10
            boolean r2 = r0 instanceof java.io.IOException
            if (r2 != 0) goto Lae
            boolean r2 = r0 instanceof com.google.android.gms.common.GooglePlayServicesNotAvailableException
            if (r2 != 0) goto Lab
            boolean r2 = r0 instanceof com.google.android.gms.common.GooglePlayServicesRepairableException
            if (r2 != 0) goto La8
            boolean r2 = r0 instanceof java.lang.IllegalStateException
            if (r2 == 0) goto La5
            r13 = 8
        La5:
            r8 = r11
            r7 = r13
            goto Lb0
        La8:
            r13 = 16
            goto La5
        Lab:
            r13 = 9
            goto La5
        Lae:
            r13 = 1
            goto La5
        Lb0:
            long r10 = java.lang.System.currentTimeMillis()
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 - r8
            int r12 = (int) r2
            r6 = 35401(0x8a49, float:4.9607E-41)
            r5 = r1
            r5.zzc(r6, r7, r8, r10, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(android.content.Context):com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(@NonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        boolean zZzd;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
        try {
            advertisingIdClient.zzc(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                advertisingIdClient.zzd();
                Preconditions.checkNotNull(advertisingIdClient.zza);
                Preconditions.checkNotNull(advertisingIdClient.zzb);
                try {
                    zZzd = advertisingIdClient.zzb.zzd();
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception", e);
                }
            }
            advertisingIdClient.zzb();
            advertisingIdClient.zza();
            return zZzd;
        } catch (Throwable th) {
            advertisingIdClient.zza();
            throw th;
        }
    }

    private final Info zzf(int i2) throws IOException {
        Info info;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            zzd();
            Preconditions.checkNotNull(this.zza);
            Preconditions.checkNotNull(this.zzb);
            try {
                info = new Info(this.zzb.zzc(), this.zzb.zze(true));
            } catch (RemoteException e) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                throw new IOException("Remote exception", e);
            }
        }
        zzb();
        return info;
    }

    public final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    @NonNull
    @KeepForSdk
    public Info getInfo() throws IOException {
        return zzf(-1);
    }

    @KeepForSdk
    public void start() throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zzc(true);
    }

    public final void zza() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzi == null || this.zza == null) {
                    return;
                }
                try {
                    if (this.zzc) {
                        ConnectionTracker.getInstance().unbindService(this.zzi, this.zza);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.zzc = false;
                this.zzb = null;
                this.zza = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public final void zzb() {
        synchronized (this.zzd) {
            zzb zzbVar = this.zze;
            if (zzbVar != null) {
                zzbVar.zza.countDown();
                try {
                    this.zze.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.zzf;
            if (j > 0) {
                this.zze = new zzb(this, j);
            }
        }
    }

    @VisibleForTesting
    public final void zzc(boolean z2) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        IOException iOException;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        if (z2) {
            zzb();
        }
        synchronized (this) {
            try {
                if (this.zzc) {
                    return;
                }
                Context context = this.zzi;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
                    if (iIsGooglePlayServicesAvailable != 0 && iIsGooglePlayServicesAvailable != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.zza = blockingServiceConnection;
                        try {
                            try {
                                this.zzb = com.google.android.gms.internal.ads_identifier.zze.zza(blockingServiceConnection.getServiceWithTimeout(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS));
                                this.zzc = true;
                            } finally {
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        }
                    } finally {
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new GooglePlayServicesNotAvailableException(9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final synchronized void zzd() throws IOException {
        try {
            if (!this.zzc) {
                try {
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is not bounded. Starting to bind it...");
                    zzc(false);
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is bounded");
                    if (!this.zzc) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
        } finally {
        }
    }

    @VisibleForTesting
    public final boolean zze(@Nullable Info info, boolean z2, float f4, long j, String str, @Nullable Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap mapU = a.u(C2300e4.h.L0, "1");
        if (info != null) {
            mapU.put("limit_ad_tracking", true != info.isLimitAdTrackingEnabled() ? "0" : "1");
            String id = info.getId();
            if (id != null) {
                mapU.put("ad_id_size", Integer.toString(id.length()));
            }
        }
        if (th != null) {
            mapU.put("error", th.getClass().getName());
        }
        mapU.put("tag", "AdvertisingIdClient");
        mapU.put("time_spent", Long.toString(j));
        new zza(this, mapU).start();
        return true;
    }

    @VisibleForTesting
    public AdvertisingIdClient(@NonNull Context context, long j, boolean z2, boolean z7) {
        this.zzd = new Object();
        Preconditions.checkNotNull(context);
        this.zzi = context.getApplicationContext();
        this.zzc = false;
        this.zzf = j;
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z2) {
    }
}

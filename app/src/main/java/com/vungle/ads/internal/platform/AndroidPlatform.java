package com.vungle.ads.internal.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.camera.core.impl.b;
import androidx.core.util.Consumer;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdvertisingInfo;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;
import q5.g;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidPlatform implements Platform {
    public static final Companion Companion = new Companion(null);
    private static final String PREF_KEY_SDK_INSTALL_TIME = "sit";
    private static final String TAG = "AndroidPlatform";
    private AdvertisingInfo advertisingInfo;
    private String appSetId;
    private Integer appSetIdScope;
    private final AudioManager audioManager;
    private final Context context;
    private final boolean isSideLoaded;
    private final PowerManager powerManager;
    private Long sdkInstallationTime;
    private final VungleThreadPoolExecutor uaExecutor;
    private String userAgent;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getCarrierName$vungle_ads_release(Context context) {
            k.e(context, "context");
            Object systemService = context.getSystemService("phone");
            k.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getNetworkOperatorName();
        }

        private Companion() {
        }
    }

    public AndroidPlatform(Context context, VungleThreadPoolExecutor uaExecutor) {
        k.e(context, "context");
        k.e(uaExecutor, "uaExecutor");
        this.context = context;
        this.uaExecutor = uaExecutor;
        updateAppSetID();
        Object systemService = context.getSystemService("power");
        k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        this.powerManager = (PowerManager) systemService;
        Object systemService2 = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        k.c(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService2;
    }

    private final AdvertisingInfo getAmazonAdvertisingInfo() {
        AdvertisingInfo advertisingInfo = new AdvertisingInfo();
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            boolean z2 = true;
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                z2 = false;
            }
            advertisingInfo.setLimitAdTracking(z2);
            advertisingInfo.setAdvertisingId(Settings.Secure.getString(contentResolver, "advertising_id"));
            return advertisingInfo;
        } catch (Settings.SettingNotFoundException e) {
            Logger.Companion.w(TAG, "Error getting Amazon advertising info: Setting not found.", e);
            return advertisingInfo;
        } catch (Exception e4) {
            Logger.Companion.w(TAG, "Error getting Amazon advertising info", e4);
            return advertisingInfo;
        }
    }

    private final AdvertisingInfo getGoogleAdvertisingInfo() throws Throwable {
        AdvertisingInfo advertisingInfo = new AdvertisingInfo();
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            k.d(advertisingIdInfo, "getAdvertisingIdInfo(context)");
            advertisingInfo.setAdvertisingId(advertisingIdInfo.getId());
            advertisingInfo.setLimitAdTracking(advertisingIdInfo.isLimitAdTrackingEnabled());
            return advertisingInfo;
        } catch (GooglePlayServicesNotAvailableException e) {
            Logger.Companion.e(TAG, "Play services Not available: " + e.getLocalizedMessage());
            return advertisingInfo;
        } catch (Exception e4) {
            Logger.Companion.e(TAG, "Error getting Google advertising info: " + e4.getLocalizedMessage());
            return advertisingInfo;
        } catch (NoClassDefFoundError e8) {
            Logger.Companion.e(TAG, "Play services Not available: " + e8.getLocalizedMessage());
            advertisingInfo.setAdvertisingId(Settings.Secure.getString(this.context.getContentResolver(), "advertising_id"));
            return advertisingInfo;
        }
    }

    /* JADX INFO: renamed from: getSDKInstallationTime$lambda-4, reason: not valid java name */
    private static final FilePreferences m3333getSDKInstallationTime$lambda4(q5.f fVar) {
        return (FilePreferences) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getUserAgentLazy$lambda-0, reason: not valid java name */
    public static final void m3334getUserAgentLazy$lambda0(AndroidPlatform this$0, Consumer consumer) {
        k.e(this$0, "this$0");
        k.e(consumer, "$consumer");
        WebViewUtil.INSTANCE.getUserAgent(this$0.context, consumer);
    }

    private final void updateAppSetID() {
        String str = this.appSetId;
        if (str == null || str.length() == 0) {
            try {
                AppSetIdClient client = AppSet.getClient(this.context);
                k.d(client, "getClient(context)");
                Task<AppSetIdInfo> appSetIdInfo = client.getAppSetIdInfo();
                k.d(appSetIdInfo, "client.appSetIdInfo");
                appSetIdInfo.addOnSuccessListener(new b(this, 28));
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Error getting AppSetID: " + e.getLocalizedMessage());
            } catch (NoClassDefFoundError e4) {
                Logger.Companion.e(TAG, "Required libs to get AppSetID Not available: " + e4.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateAppSetID$lambda-6, reason: not valid java name */
    public static final void m3335updateAppSetID$lambda6(AndroidPlatform this$0, AppSetIdInfo appSetIdInfo) {
        k.e(this$0, "this$0");
        if (appSetIdInfo != null) {
            this$0.appSetId = appSetIdInfo.getId();
            this$0.appSetIdScope = Integer.valueOf(appSetIdInfo.getScope());
        }
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public AdvertisingInfo getAdvertisingInfo() {
        String advertisingId;
        AdvertisingInfo advertisingInfo = this.advertisingInfo;
        if (advertisingInfo != null && (advertisingId = advertisingInfo.getAdvertisingId()) != null && advertisingId.length() != 0) {
            return advertisingInfo;
        }
        AdvertisingInfo amazonAdvertisingInfo = t.g0(Build.MANUFACTURER, "Amazon") ? getAmazonAdvertisingInfo() : getGoogleAdvertisingInfo();
        this.advertisingInfo = amazonAdvertisingInfo;
        return amazonAdvertisingInfo;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public String getAppSetId() {
        return this.appSetId;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public Integer getAppSetIdScope() {
        return this.appSetIdScope;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public long getBuildTime() {
        return Build.TIME;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public String getCarrierName() {
        String carrierName$vungle_ads_release = Companion.getCarrierName$vungle_ads_release(this.context);
        k.d(carrierName$vungle_ads_release, "getCarrierName(context)");
        return carrierName$vungle_ads_release;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public long getLastBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public long getOSInstallationTime() {
        Object objM;
        try {
            objM = Long.valueOf((Build.VERSION.SDK_INT >= 33 ? this.context.getPackageManager().getPackageInfo("android", PackageManager.PackageInfoFlags.of(0L)) : this.context.getPackageManager().getPackageInfo("android", 0)).firstInstallTime);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        Throwable thA = q5.k.a(objM);
        if (thA != null) {
            if (thA instanceof PackageManager.NameNotFoundException) {
                Logger.Companion.e(TAG, "Error getting OS installation time: " + ((PackageManager.NameNotFoundException) thA).getLocalizedMessage());
            }
            objM = -1L;
        }
        return ((Number) objM).longValue();
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public long getSDKInstallationTime() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        q5.f fVarB = n7.b.B(g.f13494a, new AndroidPlatform$getSDKInstallationTime$$inlined$inject$1(this.context));
        Long l = this.sdkInstallationTime;
        if (l != null) {
            return l.longValue();
        }
        long jCurrentTimeMillis = m3333getSDKInstallationTime$lambda4(fVarB).getLong(PREF_KEY_SDK_INSTALL_TIME, 0L);
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            m3333getSDKInstallationTime$lambda4(fVarB).put(PREF_KEY_SDK_INSTALL_TIME, jCurrentTimeMillis).apply();
        }
        this.sdkInstallationTime = Long.valueOf(jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public String getUserAgent() {
        String str = this.userAgent;
        return str == null ? System.getProperty("http.agent") : str;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public void getUserAgentLazy(Consumer<String> consumer) {
        k.e(consumer, "consumer");
        this.uaExecutor.execute(new com.unity3d.services.ads.operation.show.b(5, this, consumer));
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public float getVolumeLevel() {
        try {
            return this.audioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public boolean isBatterySaverEnabled() {
        return this.powerManager.isPowerSaveMode();
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public boolean isProblematicMaliDevice() {
        String str = Build.HARDWARE;
        boolean z2 = str != null && m.q0(str, "mali", true);
        int i2 = Build.VERSION.SDK_INT;
        return z2 && (29 <= i2 && i2 < 34);
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public boolean isSdCardPresent() {
        try {
            return k.a(Environment.getExternalStorageState(), "mounted");
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Acquiring external storage state failed", e);
            return false;
        }
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public boolean isSideLoaded() {
        return this.isSideLoaded;
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public boolean isSilentModeEnabled() {
        try {
            if (this.audioManager.getRingerMode() != 0) {
                if (this.audioManager.getRingerMode() != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.vungle.ads.internal.platform.Platform
    public boolean isSoundEnabled() {
        try {
            return this.audioManager.getStreamVolume(3) > 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}

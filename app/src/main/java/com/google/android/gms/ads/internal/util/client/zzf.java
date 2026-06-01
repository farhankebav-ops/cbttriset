package com.google.android.gms.ads.internal.util.client;

import a1.a;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzfrm;
import com.google.android.gms.internal.ads.zzfuz;
import com.ironsource.Q6;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzf {
    public static final Handler zza = new zzfuz(Looper.getMainLooper());
    private static final String zzb = AdView.class.getName();
    private static final String zzc = InterstitialAd.class.getName();
    private static final String zzd = AdManagerAdView.class.getName();
    private static final String zze = AdManagerInterstitialAd.class.getName();
    private static final String zzf = zzfrm.class.getName();
    private static final String zzg = AdLoader.class.getName();
    private float zzh = -1.0f;

    public static final int zzA(DisplayMetrics displayMetrics, int i2) {
        return Math.round(i2 / displayMetrics.density);
    }

    public static final void zzB(Context context, @Nullable String str, String str2, Bundle bundle, boolean z2, zze zzeVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString(Q6.F, Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            int apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(context);
            str = a.q(new StringBuilder(String.valueOf(apkVersion).length() + 10), ".253830000", apkVersion);
        }
        bundle.putString("js", str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps");
        for (String str3 : bundle.keySet()) {
            builderAppendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzeVar.zza(builderAppendQueryParameter.toString());
    }

    public static final int zzC(Context context, int i2) {
        return zzu(context.getResources().getDisplayMetrics(), i2);
    }

    @Nullable
    public static final String zzD(Context context) {
        zzbeu.zza(context);
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || zzw()) {
            string = "emulator";
        }
        return zzE(string, "MD5");
    }

    @Nullable
    private static String zzE(String str, String str2) {
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    private final JSONArray zzF(Collection collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zzG(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void zzG(JSONArray jSONArray, @Nullable Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzm((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(zzk((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(zzF((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zzn((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zzH(JSONObject jSONObject, String str, @Nullable Object obj) throws JSONException {
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzr)).booleanValue()) {
            str = String.valueOf(str);
        }
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzm((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, zzk((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONObject.put(String.valueOf(str), zzF((Collection) obj));
            return;
        }
        if (obj instanceof Object[]) {
            jSONObject.put(str, zzF(Arrays.asList((Object[]) obj)));
            return;
        }
        int i2 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            Integer[] numArr = new Integer[length];
            while (i2 < length) {
                numArr[i2] = Integer.valueOf(iArr[i2]);
                i2++;
            }
            jSONObject.put(str, zzn(numArr));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length2 = dArr.length;
            Double[] dArr2 = new Double[length2];
            while (i2 < length2) {
                dArr2[i2] = Double.valueOf(dArr[i2]);
                i2++;
            }
            jSONObject.put(str, zzn(dArr2));
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length3 = jArr.length;
            Long[] lArr = new Long[length3];
            while (i2 < length3) {
                lArr[i2] = Long.valueOf(jArr[i2]);
                i2++;
            }
            jSONObject.put(str, zzn(lArr));
            return;
        }
        if (!(obj instanceof boolean[])) {
            jSONObject.put(str, obj);
            return;
        }
        boolean[] zArr = (boolean[]) obj;
        int length4 = zArr.length;
        Boolean[] boolArr = new Boolean[length4];
        while (i2 < length4) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
            i2++;
        }
        jSONObject.put(str, zzn(boolArr));
    }

    private static final void zzI(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar, @Nullable String str, int i2, int i8) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i2);
        textView.setBackgroundColor(i8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i2);
        int iZzC = zzC(context, 3);
        int i9 = zzrVar.zzf;
        int i10 = zzrVar.zzc;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(i9 - iZzC, i10 - iZzC, 17));
        viewGroup.addView(frameLayout, i9, i10);
    }

    public static Object zzd(Map map, Object obj, Object obj2) {
        return map.containsKey(obj) ? map.get(obj) : obj2;
    }

    @Nullable
    public static ActivityManager.MemoryInfo zze(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (NullPointerException unused) {
            zzo.zzi("Error retrieving the memory information.");
            return memoryInfo;
        }
    }

    @Nullable
    public static String zzf(String str) {
        return zzE(str, "MD5");
    }

    @Nullable
    public static String zzg(String str) {
        return zzE(str, "SHA-256");
    }

    public static String zzi() {
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return string;
    }

    public static AdSize zzj(Context context, int i2, int i8, int i9) {
        int iZzp = zzp(context, i9);
        if (iZzp == -1) {
            return AdSize.INVALID;
        }
        return new AdSize(i2, Math.max(Math.min(i2 > 655 ? Math.round((i2 / 728.0f) * 90.0f) : i2 > 632 ? 81 : i2 > 526 ? Math.round((i2 / 468.0f) * 60.0f) : i2 > 432 ? 68 : Math.round((i2 / 320.0f) * 50.0f), Math.min(90, Math.round(iZzp * 0.15f))), 50));
    }

    public static boolean zzo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith((String) zzbhd.zzd.zze());
    }

    public static int zzp(Context context, int i2) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context == null) {
            return -1;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || (configuration = resources.getConfiguration()) == null) {
            return -1;
        }
        int i8 = configuration.orientation;
        if (i2 == 0) {
            i2 = i8;
        }
        return i2 == i8 ? Math.round(displayMetrics.heightPixels / displayMetrics.density) : Math.round(displayMetrics.widthPixels / displayMetrics.density);
    }

    @Nullable
    public static PreloadConfiguration zzq(zzft zzftVar) {
        PreloadConfiguration preloadConfigurationZzr = zzr(zzftVar);
        if (preloadConfigurationZzr == null) {
            return null;
        }
        PreloadConfiguration.Builder builder = new PreloadConfiguration.Builder(preloadConfigurationZzr.getAdUnitId());
        builder.setAdRequest(preloadConfigurationZzr.getAdRequest());
        builder.setBufferSize(preloadConfigurationZzr.getBufferSize());
        return builder.build();
    }

    @Nullable
    public static PreloadConfiguration zzr(@NonNull zzft zzftVar) {
        String str = zzftVar.zza;
        AdFormat adFormat = AdFormat.getAdFormat(zzftVar.zzb);
        if (adFormat == null) {
            return null;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzftVar.zzc;
        AdRequest.Builder builder = new AdRequest.Builder();
        List list = zzmVar.zze;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                builder.addKeyword((String) it.next());
            }
        }
        builder.zza(zzmVar.zzm);
        Bundle bundle = zzmVar.zzn;
        for (String str2 : bundle.keySet()) {
            builder.addCustomTargeting(str2, bundle.getString(str2));
        }
        builder.setAdString(zzmVar.zzx);
        String str3 = zzmVar.zzl;
        if (str3 != null) {
            builder.setContentUrl(str3);
        }
        builder.setNeighboringContentUrls(zzmVar.zzv);
        builder.setRequestAgent(zzmVar.zzp);
        AdRequest adRequestBuild = builder.build();
        PreloadConfiguration.Builder builder2 = new PreloadConfiguration.Builder(str, adFormat);
        builder2.setAdRequest(adRequestBuild);
        builder2.setBufferSize(zzftVar.zzd);
        return builder2.build();
    }

    public static zzft zzs(Context context, PreloadConfiguration preloadConfiguration, AdFormat adFormat) {
        PreloadConfiguration.Builder builder = new PreloadConfiguration.Builder(preloadConfiguration.getAdUnitId(), adFormat);
        builder.setAdRequest(preloadConfiguration.getAdRequest());
        builder.setBufferSize(preloadConfiguration.getBufferSize());
        return zzt(context, builder.build(), 2);
    }

    public static zzft zzt(Context context, PreloadConfiguration preloadConfiguration, int i2) {
        int bufferSize;
        int iIntValue;
        com.google.android.gms.ads.internal.client.zzm zzmVarZza = com.google.android.gms.ads.internal.client.zzq.zza.zza(context, preloadConfiguration.getAdRequest().zza());
        int iIntValue2 = 1;
        if (i2 == 1) {
            zzmVarZza.zzc.putBoolean("is_sdk_preload", true);
        } else {
            zzmVarZza.zzc.putBoolean("zenith_v2", true);
        }
        if (preloadConfiguration.getBufferSize() <= 0) {
            AdFormat adFormat = preloadConfiguration.getAdFormat();
            AdFormat adFormat2 = AdFormat.BANNER;
            int iOrdinal = adFormat.ordinal();
            if (iOrdinal == 1) {
                bufferSize = ((Integer) zzbd.zzc().zzd(zzbeu.zzN)).intValue();
            } else if (iOrdinal == 2) {
                bufferSize = ((Integer) zzbd.zzc().zzd(zzbeu.zzO)).intValue();
            } else if (iOrdinal != 5) {
                bufferSize = 1;
            } else {
                bufferSize = ((Integer) zzbd.zzc().zzd(zzbeu.zzM)).intValue();
            }
        } else {
            bufferSize = preloadConfiguration.getBufferSize();
        }
        AdFormat adFormat3 = preloadConfiguration.getAdFormat();
        AdFormat adFormat4 = AdFormat.BANNER;
        int iOrdinal2 = adFormat3.ordinal();
        if (iOrdinal2 == 1) {
            iIntValue = ((Integer) zzbd.zzc().zzd(zzbeu.zzK)).intValue();
        } else if (iOrdinal2 == 2) {
            iIntValue = ((Integer) zzbd.zzc().zzd(zzbeu.zzL)).intValue();
        } else if (iOrdinal2 != 5) {
            iIntValue = 1;
        } else {
            iIntValue = ((Integer) zzbd.zzc().zzd(zzbeu.zzJ)).intValue();
        }
        int iMax = Math.max(Math.min(iIntValue, 15), 1);
        int iOrdinal3 = preloadConfiguration.getAdFormat().ordinal();
        if (iOrdinal3 == 1) {
            iIntValue2 = ((Integer) zzbd.zzc().zzd(zzbeu.zzQ)).intValue();
        } else if (iOrdinal3 == 2) {
            iIntValue2 = ((Integer) zzbd.zzc().zzd(zzbeu.zzR)).intValue();
        } else if (iOrdinal3 == 5) {
            iIntValue2 = ((Integer) zzbd.zzc().zzd(zzbeu.zzP)).intValue();
        }
        return new zzft(preloadConfiguration.getAdUnitId(), preloadConfiguration.getAdFormat().getValue(), zzmVarZza, Math.max(Math.min(bufferSize, iMax), Math.min(iIntValue2, iMax)));
    }

    public static final int zzu(DisplayMetrics displayMetrics, int i2) {
        return (int) TypedValue.applyDimension(1, i2, displayMetrics);
    }

    @Nullable
    @VisibleForTesting
    public static final String zzv(StackTraceElement[] stackTraceElementArr, String str) {
        int i2;
        String className;
        int i8 = 0;
        while (true) {
            i2 = i8 + 1;
            if (i2 >= stackTraceElementArr.length) {
                className = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i8];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzb.equalsIgnoreCase(className2) || zzc.equalsIgnoreCase(className2) || zzd.equalsIgnoreCase(className2) || zze.equalsIgnoreCase(className2) || zzf.equalsIgnoreCase(className2) || zzg.equalsIgnoreCase(className2))) {
                break;
            }
            i8 = i2;
        }
        className = stackTraceElementArr[i2].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                for (int i9 = 2; i9 > 0 && stringTokenizer.hasMoreElements(); i9--) {
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                }
                str = sb.toString();
            }
            if (className != null && !className.contains(str)) {
                return className;
            }
        }
        return null;
    }

    public static final boolean zzw() {
        boolean zBooleanValue = ((Boolean) zzbd.zzc().zzd(zzbeu.zzmu)).booleanValue();
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains("emulator")) {
            return true;
        }
        return zBooleanValue && Build.HARDWARE.contains("ranchu");
    }

    public static final boolean zzx(Context context, int i2) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i2) == 0;
    }

    public static final boolean zzy(Context context) {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
        return iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 2;
    }

    public static final boolean zzz() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final int zza(Context context, int i2) {
        if (this.zzh < 0.0f) {
            synchronized (this) {
                try {
                    if (this.zzh < 0.0f) {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        if (windowManager == null) {
                            return 0;
                        }
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        this.zzh = displayMetrics.density;
                    }
                } finally {
                }
            }
        }
        return Math.round(i2 / this.zzh);
    }

    public final void zzb(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar, @Nullable String str, @Nullable String str2) {
        if (str2 != null) {
            zzo.zzi(str2);
        }
        zzI(viewGroup, zzrVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    public final void zzc(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar, @Nullable String str) {
        zzI(viewGroup, zzrVar, "Ads by Google", ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public final void zzh(final Context context, @Nullable String str, String str2, Bundle bundle, boolean z2) {
        zzB(context, str, "gmob-apps", bundle, true, new zze() { // from class: com.google.android.gms.ads.internal.util.client.zzd
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final /* synthetic */ zzt zza(String str3) {
                new zzc(this.zza, context, str3).start();
                return zzt.SUCCESS;
            }
        });
    }

    public final JSONObject zzk(Map map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zzH(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: ".concat(String.valueOf(e.getMessage())));
        }
    }

    public final JSONObject zzl(@Nullable Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zzm(bundle);
            } catch (JSONException e) {
                zzo.zzg("Error converting Bundle to JSON", e);
            }
        }
        return null;
    }

    public final JSONObject zzm(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zzH(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    @VisibleForTesting
    public final JSONArray zzn(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            zzG(jSONArray, obj);
        }
        return jSONArray;
    }
}

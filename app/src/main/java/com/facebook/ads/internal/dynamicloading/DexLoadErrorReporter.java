package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.infer.annotation.Nullsafe;
import com.ironsource.C2300e4;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class DexLoadErrorReporter {
    private static final String LOGGING_URL = "https://www.facebook.com/adnw_logging/";
    public static final double SAMPLING = 0.1d;
    private static final AtomicBoolean sAlreadyReported = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public static void addEnvFields(Context context, JSONObject jSONObject, String str) throws JSONException, PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        jSONObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jSONObject.put("APPNAME", context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jSONObject.put("APPVERS", context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jSONObject.put("OSVERS", Build.VERSION.RELEASE);
        jSONObject.put("SDK", "android");
        jSONObject.put("SESSION_ID", str);
        jSONObject.put("MODEL", Build.MODEL);
        jSONObject.put("BUNDLE", packageName);
        jSONObject.put("SDK_VERSION", BuildConfigApi.getVersionName(context));
        jSONObject.put("OS", C2300e4.f8279d);
    }

    public static void reportDexLoadingIssue(final Context context, final String str, double d8) {
        AtomicBoolean atomicBoolean = sAlreadyReported;
        if (atomicBoolean.get() || Math.random() >= d8) {
            return;
        }
        atomicBoolean.set(true);
        new Thread() { // from class: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.1
            /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(9:74|3|92|4|5|82|6|90|7)|(12:78|8|9|(4:11|88|12|95)(1:94)|16|76|39|(2:84|41)|(2:72|46)|(1:96)|26|52)|17|86|18|19|68|22|26|52|(1:(0))) */
            /* JADX WARN: Can't wrap try/catch for region: R(21:0|2|74|3|92|4|5|82|6|90|7|(12:78|8|9|(4:11|88|12|95)(1:94)|16|76|39|(2:84|41)|(2:72|46)|(1:96)|26|52)|17|86|18|19|68|22|26|52|(1:(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0143, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0144, code lost:
            
                r3 = "Can't close connection.";
                r4 = com.facebook.ads.AudienceNetworkAds.TAG;
                android.util.Log.e(r4, r3, r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x014f, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0150, code lost:
            
                android.util.Log.e(r4, r3, r0);
             */
            /* JADX WARN: Removed duplicated region for block: B:72:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:84:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 434
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.AnonymousClass1.run():void");
            }
        }.start();
    }
}

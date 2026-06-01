package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.webkit.ProxyConfig;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidUtils {
    public static final AndroidUtils INSTANCE = new AndroidUtils();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum SchemaType {
        DATA("data"),
        HTTPS("https"),
        HTTP(ProxyConfig.MATCH_HTTP);

        public static final Companion Companion = new Companion(null);
        private final String text;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final SchemaType fromString(String str) {
                for (SchemaType schemaType : SchemaType.values()) {
                    if (t.g0(schemaType.text, str)) {
                        return schemaType;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        SchemaType(String str) {
            this.text = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SchemaType.values().length];
            iArr[SchemaType.DATA.ordinal()] = 1;
            iArr[SchemaType.HTTPS.ordinal()] = 2;
            iArr[SchemaType.HTTP.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AndroidUtils() {
    }

    public final List<String> filterManifestPermissions(List<String> permissions, IApplicationService applicationService) throws PackageManager.NameNotFoundException {
        k.e(permissions, "permissions");
        k.e(applicationService, "applicationService");
        PackageInfo packageInfo = applicationService.getAppContext().getPackageManager().getPackageInfo(applicationService.getAppContext().getPackageName(), 4096);
        k.d(packageInfo, "applicationService.appCo…eManager.GET_PERMISSIONS)");
        String[] strArr = packageInfo.requestedPermissions;
        k.d(strArr, "packageInfo.requestedPermissions");
        List listH0 = m.H0(Arrays.copyOf(strArr, strArr.length));
        ArrayList arrayList = new ArrayList();
        for (Object obj : permissions) {
            if (listH0.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void finishSafely(Activity activity) {
        k.e(activity, "activity");
        if (activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    public final String getAppVersion(Context context) {
        Integer numValueOf;
        k.e(context, "context");
        try {
            numValueOf = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.toString();
        }
        return null;
    }

    public final String getManifestMeta(Context context, String str) {
        k.e(context, "context");
        Bundle manifestMetaBundle = getManifestMetaBundle(context);
        if (manifestMetaBundle != null) {
            return manifestMetaBundle.getString(str);
        }
        return null;
    }

    public final boolean getManifestMetaBoolean(Context context, String str) {
        k.e(context, "context");
        Bundle manifestMetaBundle = getManifestMetaBundle(context);
        if (manifestMetaBundle != null) {
            return manifestMetaBundle.getBoolean(str);
        }
        return false;
    }

    public final Bundle getManifestMetaBundle(Context context) {
        k.e(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            k.d(applicationInfo, "context.packageManager.g…A_DATA,\n                )");
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.error("Manifest application info not found", e);
            return null;
        }
    }

    public final int getRandomDelay(int i2, int i8) {
        return new Random().nextInt((i8 + 1) - i2) + i2;
    }

    public final String getResourceString(Context context, String str, String str2) {
        k.e(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : str2;
    }

    public final String getRootCauseMessage(Throwable throwable) {
        k.e(throwable, "throwable");
        return getRootCauseThrowable(throwable).getMessage();
    }

    public final Throwable getRootCauseThrowable(Throwable subjectThrowable) {
        k.e(subjectThrowable, "subjectThrowable");
        while (subjectThrowable.getCause() != null && subjectThrowable.getCause() != subjectThrowable) {
            subjectThrowable = subjectThrowable.getCause();
            k.b(subjectThrowable);
        }
        return subjectThrowable;
    }

    public final int getTargetSdkVersion(Context context) {
        k.e(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            k.d(applicationInfo, "packageManager.getApplicationInfo(packageName, 0)");
            return applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 21;
        }
    }

    public final boolean hasConfigChangeFlag(Activity activity, int i2) {
        k.e(activity, "activity");
        try {
            return (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & i2) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean hasNotificationManagerCompat() {
        return true;
    }

    public final boolean hasPermission(String permission, boolean z2, IApplicationService applicationService) {
        k.e(permission, "permission");
        k.e(applicationService, "applicationService");
        try {
            PackageInfo packageInfo = applicationService.getAppContext().getPackageManager().getPackageInfo(applicationService.getAppContext().getPackageName(), 4096);
            k.d(packageInfo, "applicationService.appCo…NS,\n                    )");
            String[] strArr = packageInfo.requestedPermissions;
            k.d(strArr, "packageInfo.requestedPermissions");
            if (!m.H0(Arrays.copyOf(strArr, strArr.length)).contains(permission)) {
                return false;
            }
            if (z2) {
                return ContextCompat.checkSelfPermission(applicationService.getAppContext(), permission) != -1;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isActivityFullyReady(Activity activity) {
        k.e(activity, "activity");
        boolean z2 = activity.getWindow().getDecorView().getApplicationWindowToken() != null;
        View decorView = activity.getWindow().getDecorView();
        k.d(decorView, "activity.window.decorView");
        return z2 && (decorView.getRootWindowInsets() != null);
    }

    public final boolean isRunningOnMainThread() {
        return k.a(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    public final boolean isStringNotEmpty(String str) {
        return !TextUtils.isEmpty(str);
    }

    public final boolean isValidResourceName(String str) {
        if (str == null) {
            return false;
        }
        Pattern patternCompile = Pattern.compile("^[0-9]");
        k.d(patternCompile, "compile(...)");
        return !patternCompile.matcher(str).matches();
    }

    @Keep
    public final boolean opaqueHasClass(Class<?> _class) {
        k.e(_class, "_class");
        return true;
    }

    public final void openURLInBrowser(Context appContext, Uri uri) {
        k.e(appContext, "appContext");
        k.e(uri, "uri");
        appContext.startActivity(openURLInBrowserIntent(uri));
    }

    public final Intent openURLInBrowserIntent(Uri uri) {
        Intent intentMakeMainSelectorActivity;
        k.e(uri, "uri");
        SchemaType schemaTypeFromString = uri.getScheme() != null ? SchemaType.Companion.fromString(uri.getScheme()) : null;
        if (schemaTypeFromString == null) {
            schemaTypeFromString = SchemaType.HTTP;
            String string = uri.toString();
            k.d(string, "uri.toString()");
            if (!n6.m.q0(string, "://", false)) {
                uri = Uri.parse("http://" + uri);
                k.d(uri, "parse(\"http://$uri\")");
            }
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[schemaTypeFromString.ordinal()];
        if (i2 != 1) {
            intentMakeMainSelectorActivity = (i2 == 2 || i2 != 3) ? new Intent("android.intent.action.VIEW", uri) : new Intent("android.intent.action.VIEW", uri);
        } else {
            intentMakeMainSelectorActivity = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            k.d(intentMakeMainSelectorActivity, "makeMainSelectorActivity…ent.CATEGORY_APP_BROWSER)");
            intentMakeMainSelectorActivity.setData(uri);
        }
        intentMakeMainSelectorActivity.addFlags(268435456);
        return intentMakeMainSelectorActivity;
    }

    public final void openURLInBrowser(Context appContext, String url) {
        k.e(appContext, "appContext");
        k.e(url, "url");
        int length = url.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean z7 = k.g(url.charAt(!z2 ? i2 : length), 32) <= 0;
            if (z2) {
                if (!z7) {
                    break;
                } else {
                    length--;
                }
            } else if (z7) {
                i2++;
            } else {
                z2 = true;
            }
        }
        Uri uri = Uri.parse(url.subSequence(i2, length + 1).toString());
        k.d(uri, "parse(url.trim { it <= ' ' })");
        openURLInBrowser(appContext, uri);
    }
}

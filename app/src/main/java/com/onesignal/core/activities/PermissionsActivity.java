package com.onesignal.core.activities;

import a1.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.ActivityCompat;
import com.onesignal.OneSignal;
import com.onesignal.core.R;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.permissions.impl.RequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.vungle.ads.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PermissionsActivity extends Activity {
    public static final Companion Companion = new Companion(null);
    public static final int DELAY_TIME_CALLBACK_CALL = 500;
    public static final String INTENT_EXTRA_ANDROID_PERMISSION_STRING = "INTENT_EXTRA_ANDROID_PERMISSION_STRING";
    public static final String INTENT_EXTRA_CALLBACK_CLASS = "INTENT_EXTRA_CALLBACK_CLASS";
    public static final String INTENT_EXTRA_PERMISSION_TYPE = "INTENT_EXTRA_PERMISSION_TYPE";
    public static final int ONESIGNAL_PERMISSION_REQUEST_CODE = 2;
    private String permissionRequestType;
    private IPreferencesService preferenceService;
    private RequestPermissionService requestPermissionService;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    private final void finishActivity() {
        finish();
        overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
    }

    private final void handleBundleParams(Bundle bundle) {
        reregisterCallbackHandlers(bundle);
        k.b(bundle);
        this.permissionRequestType = bundle.getString(INTENT_EXTRA_PERMISSION_TYPE);
        String string = bundle.getString(INTENT_EXTRA_ANDROID_PERMISSION_STRING);
        k.b(string);
        requestPermission(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onRequestPermissionsResult$lambda-0, reason: not valid java name */
    public static final void m3137onRequestPermissionsResult$lambda0(PermissionsActivity this$0, String[] permissions, int[] grantResults) {
        k.e(this$0, "this$0");
        k.e(permissions, "$permissions");
        k.e(grantResults, "$grantResults");
        RequestPermissionService requestPermissionService = this$0.requestPermissionService;
        k.b(requestPermissionService);
        String str = this$0.permissionRequestType;
        k.b(str);
        IRequestPermissionService.PermissionCallback callback = requestPermissionService.getCallback(str);
        if (callback == null) {
            throw new RuntimeException("Missing handler for permissionRequestType: " + this$0.permissionRequestType);
        }
        if (permissions.length == 0) {
            callback.onReject(false);
            return;
        }
        String str2 = permissions[0];
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            callback.onReject(this$0.shouldShowSettings(str2));
            return;
        }
        callback.onAccept();
        IPreferencesService iPreferencesService = this$0.preferenceService;
        k.b(iPreferencesService);
        iPreferencesService.saveBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_USER_RESOLVED_PERMISSION_PREFIX + str2, Boolean.TRUE);
    }

    private final void requestPermission(String str) {
        RequestPermissionService requestPermissionService = this.requestPermissionService;
        k.b(requestPermissionService);
        if (requestPermissionService.getWaiting()) {
            return;
        }
        RequestPermissionService requestPermissionService2 = this.requestPermissionService;
        k.b(requestPermissionService2);
        requestPermissionService2.setWaiting(true);
        RequestPermissionService requestPermissionService3 = this.requestPermissionService;
        k.b(requestPermissionService3);
        requestPermissionService3.setShouldShowRequestPermissionRationaleBeforeRequest(ActivityCompat.shouldShowRequestPermissionRationale(this, str));
        ActivityCompat.requestPermissions(this, new String[]{str}, 2);
    }

    private final void reregisterCallbackHandlers(Bundle bundle) {
        k.b(bundle);
        String string = bundle.getString(INTENT_EXTRA_CALLBACK_CLASS);
        try {
            Class.forName(string);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException(a.l("Could not find callback class for PermissionActivity: ", string));
        }
    }

    private final boolean shouldShowSettings(String str) {
        RequestPermissionService requestPermissionService = this.requestPermissionService;
        k.b(requestPermissionService);
        if (!requestPermissionService.getFallbackToSettings()) {
            return false;
        }
        RequestPermissionService requestPermissionService2 = this.requestPermissionService;
        k.b(requestPermissionService2);
        if (requestPermissionService2.getShouldShowRequestPermissionRationaleBeforeRequest() && !ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
            IPreferencesService iPreferencesService = this.preferenceService;
            k.b(iPreferencesService);
            iPreferencesService.saveBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_USER_RESOLVED_PERMISSION_PREFIX + str, Boolean.TRUE);
            return false;
        }
        IPreferencesService iPreferencesService2 = this.preferenceService;
        k.b(iPreferencesService2);
        Boolean bool = iPreferencesService2.getBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_USER_RESOLVED_PERMISSION_PREFIX + str, Boolean.FALSE);
        k.b(bool);
        return bool.booleanValue();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!OneSignal.initWithContext(this)) {
            finishActivity();
            return;
        }
        if (getIntent().getExtras() == null) {
            finishActivity();
            return;
        }
        OneSignal oneSignal = OneSignal.INSTANCE;
        this.requestPermissionService = (RequestPermissionService) oneSignal.getServices().getService(RequestPermissionService.class);
        this.preferenceService = (IPreferencesService) oneSignal.getServices().getService(IPreferencesService.class);
        handleBundleParams(getIntent().getExtras());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        k.e(intent, "intent");
        super.onNewIntent(intent);
        handleBundleParams(intent.getExtras());
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        k.e(permissions, "permissions");
        k.e(grantResults, "grantResults");
        RequestPermissionService requestPermissionService = this.requestPermissionService;
        k.b(requestPermissionService);
        requestPermissionService.setWaiting(false);
        if (i2 == 2) {
            new Handler().postDelayed(new b(this, permissions, grantResults, 4), 500L);
        }
        finishActivity();
    }
}

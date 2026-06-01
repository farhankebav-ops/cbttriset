package com.onesignal.core.internal.permissions.impl;

import android.app.Activity;
import android.content.Intent;
import com.onesignal.core.R;
import com.onesignal.core.activities.PermissionsActivity;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import java.util.HashMap;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RequestPermissionService implements IRequestPermissionService {
    private final IApplicationService _application;
    private final HashMap<String, IRequestPermissionService.PermissionCallback> callbackMap;
    private boolean fallbackToSettings;
    private boolean shouldShowRequestPermissionRationaleBeforeRequest;
    private boolean waiting;

    public RequestPermissionService(IApplicationService _application) {
        k.e(_application, "_application");
        this._application = _application;
        this.callbackMap = new HashMap<>();
    }

    public final IRequestPermissionService.PermissionCallback getCallback(String permissionType) {
        k.e(permissionType, "permissionType");
        return this.callbackMap.get(permissionType);
    }

    public final boolean getFallbackToSettings() {
        return this.fallbackToSettings;
    }

    public final boolean getShouldShowRequestPermissionRationaleBeforeRequest() {
        return this.shouldShowRequestPermissionRationaleBeforeRequest;
    }

    public final boolean getWaiting() {
        return this.waiting;
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService
    public void registerAsCallback(String permissionType, IRequestPermissionService.PermissionCallback callback) {
        k.e(permissionType, "permissionType");
        k.e(callback, "callback");
        this.callbackMap.put(permissionType, callback);
    }

    public final void setFallbackToSettings(boolean z2) {
        this.fallbackToSettings = z2;
    }

    public final void setShouldShowRequestPermissionRationaleBeforeRequest(boolean z2) {
        this.shouldShowRequestPermissionRationaleBeforeRequest = z2;
    }

    public final void setWaiting(boolean z2) {
        this.waiting = z2;
    }

    @Override // com.onesignal.core.internal.permissions.IRequestPermissionService
    public void startPrompt(boolean z2, final String str, final String str2, final Class<?> callbackClass) {
        k.e(callbackClass, "callbackClass");
        if (this.waiting) {
            return;
        }
        this.fallbackToSettings = z2;
        this._application.addActivityLifecycleHandler(new IActivityLifecycleHandler() { // from class: com.onesignal.core.internal.permissions.impl.RequestPermissionService.startPrompt.1
            @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityAvailable(Activity activity) {
                k.e(activity, "activity");
                if (activity.getClass().equals(PermissionsActivity.class)) {
                    RequestPermissionService.this._application.removeActivityLifecycleHandler(this);
                    return;
                }
                Intent intent = new Intent(activity, (Class<?>) PermissionsActivity.class);
                intent.setFlags(131072);
                intent.putExtra(PermissionsActivity.INTENT_EXTRA_PERMISSION_TYPE, str).putExtra(PermissionsActivity.INTENT_EXTRA_ANDROID_PERMISSION_STRING, str2).putExtra(PermissionsActivity.INTENT_EXTRA_CALLBACK_CLASS, callbackClass.getName());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
            }

            @Override // com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityStopped(Activity activity) {
                k.e(activity, "activity");
            }
        });
    }
}

package com.onesignal.notifications.internal.registration.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v5.c;
import v6.n;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GooglePlayServicesUpgradePrompt {
    public static final Companion Companion = new Companion(null);
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2", f = "GooglePlayServicesUpgradePrompt.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-1, reason: not valid java name */
        public static final void m3175invokeSuspend$lambda1(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, DialogInterface dialogInterface, int i2) {
            googlePlayServicesUpgradePrompt._configModelStore.getModel().setUserRejectedGMSUpdate(true);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return GooglePlayServicesUpgradePrompt.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            final Activity current = GooglePlayServicesUpgradePrompt.this._applicationService.getCurrent();
            x xVar = x.f13520a;
            if (current == null) {
                return xVar;
            }
            AndroidUtils androidUtils = AndroidUtils.INSTANCE;
            String resourceString = androidUtils.getResourceString(current, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
            String resourceString2 = androidUtils.getResourceString(current, "onesignal_gms_missing_alert_button_update", "Update");
            String resourceString3 = androidUtils.getResourceString(current, "onesignal_gms_missing_alert_button_skip", "Skip");
            String resourceString4 = androidUtils.getResourceString(current, "onesignal_gms_missing_alert_button_close", "Close");
            AlertDialog.Builder message = new AlertDialog.Builder(current).setMessage(resourceString);
            final GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt = GooglePlayServicesUpgradePrompt.this;
            AlertDialog.Builder positiveButton = message.setPositiveButton(resourceString2, new DialogInterface.OnClickListener() { // from class: com.onesignal.notifications.internal.registration.impl.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    GooglePlayServicesUpgradePrompt.access$openPlayStoreToApp(googlePlayServicesUpgradePrompt, current);
                }
            });
            final GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt2 = GooglePlayServicesUpgradePrompt.this;
            positiveButton.setNegativeButton(resourceString3, new DialogInterface.OnClickListener() { // from class: com.onesignal.notifications.internal.registration.impl.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    GooglePlayServicesUpgradePrompt.AnonymousClass2.m3175invokeSuspend$lambda1(googlePlayServicesUpgradePrompt2, dialogInterface, i2);
                }
            }).setNeutralButton(resourceString4, (DialogInterface.OnClickListener) null).create().show();
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public GooglePlayServicesUpgradePrompt(IApplicationService _applicationService, IDeviceService _deviceService, ConfigModelStore _configModelStore) {
        k.e(_applicationService, "_applicationService");
        k.e(_deviceService, "_deviceService");
        k.e(_configModelStore, "_configModelStore");
        this._applicationService = _applicationService;
        this._deviceService = _deviceService;
        this._configModelStore = _configModelStore;
    }

    public static final /* synthetic */ void access$openPlayStoreToApp(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, Activity activity) {
        googlePlayServicesUpgradePrompt.openPlayStoreToApp(activity);
    }

    private final boolean isGooglePlayStoreInstalled() {
        try {
            PackageManager packageManager = this._applicationService.getAppContext().getPackageManager();
            k.c(packageManager.getPackageInfo("com.google.android.gms", 128).applicationInfo.loadLabel(packageManager), "null cannot be cast to non-null type kotlin.String");
            return !((String) r0).equals("Market");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPlayStoreToApp(Activity activity) {
        try {
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            k.d(googleApiAvailability, "getInstance()");
            PendingIntent errorResolutionPendingIntent = googleApiAvailability.getErrorResolutionPendingIntent(activity, googleApiAvailability.isGooglePlayServicesAvailable(this._applicationService.getAppContext()), PLAY_SERVICES_RESOLUTION_REQUEST);
            if (errorResolutionPendingIntent != null) {
                errorResolutionPendingIntent.send();
            }
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

    public final Object showUpdateGPSDialog(c<? super x> cVar) throws Throwable {
        if (this._deviceService.isAndroidDeviceType() && isGooglePlayStoreInstalled() && !this._configModelStore.getModel().getDisableGMSMissingPrompt() && !this._configModelStore.getModel().getUserRejectedGMSUpdate()) {
            x6.e eVar = m0.f13566a;
            Object objH = c0.H(new AnonymousClass2(null), n.f17641a, cVar);
            if (objH == w5.a.f17774a) {
                return objH;
            }
        }
        return x.f13520a;
    }
}

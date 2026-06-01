package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {

    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Nullable
    @Deprecated
    public static Dialog getErrorDialog(int i2, @NonNull Activity activity, int i8) {
        return getErrorDialog(i2, activity, i8, null);
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, @NonNull Context context, int i8) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i2, i8);
    }

    @NonNull
    @Deprecated
    public static String getErrorString(int i2) {
        return GooglePlayServicesUtilLight.getErrorString(i2);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @ResultIgnorabilityUnspecified
    @HideFirstParty
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i2);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i2, @NonNull Activity activity, int i8) {
        return showErrorDialogFragment(i2, activity, i8, null);
    }

    @Deprecated
    public static void showErrorNotification(int i2, @NonNull Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i2) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i2)) {
            googleApiAvailability.zaf(context);
        } else {
            googleApiAvailability.showErrorNotification(context, i2);
        }
    }

    @Nullable
    @Deprecated
    public static Dialog getErrorDialog(int i2, @NonNull Activity activity, int i8, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i2)) {
            i2 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i2, i8, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i2) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i2);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i2, @NonNull Activity activity, int i8, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i2, activity, null, i8, onCancelListener);
    }

    @ResultIgnorabilityUnspecified
    public static boolean showErrorDialogFragment(int i2, @NonNull Activity activity, @Nullable Fragment fragment, int i8, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i2)) {
            i2 = 18;
        }
        int i9 = i2;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i9, i8, onCancelListener);
        }
        Dialog dialogZaa = googleApiAvailability.zaa(activity, i9, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i9, "d"), i8), onCancelListener, null);
        if (dialogZaa == null) {
            return false;
        }
        googleApiAvailability.zad(activity, dialogZaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}

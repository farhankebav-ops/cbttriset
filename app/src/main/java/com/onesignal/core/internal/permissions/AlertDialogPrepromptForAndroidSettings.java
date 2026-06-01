package com.onesignal.core.internal.permissions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.WindowManager;
import com.onesignal.core.R;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Arrays;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AlertDialogPrepromptForAndroidSettings {
    public static final AlertDialogPrepromptForAndroidSettings INSTANCE = new AlertDialogPrepromptForAndroidSettings();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Callback {
        void onAccept();

        void onDecline();
    }

    private AlertDialogPrepromptForAndroidSettings() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: show$lambda-0, reason: not valid java name */
    public static final void m3140show$lambda0(Callback callback, DialogInterface dialogInterface, int i2) {
        k.e(callback, "$callback");
        callback.onAccept();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: show$lambda-1, reason: not valid java name */
    public static final void m3141show$lambda1(Callback callback, DialogInterface dialogInterface, int i2) {
        k.e(callback, "$callback");
        callback.onDecline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: show$lambda-2, reason: not valid java name */
    public static final void m3142show$lambda2(Callback callback, DialogInterface dialogInterface) {
        k.e(callback, "$callback");
        callback.onDecline();
    }

    public final void show(Activity activity, String titlePrefix, String previouslyDeniedPostfix, final Callback callback) {
        k.e(activity, "activity");
        k.e(titlePrefix, "titlePrefix");
        k.e(previouslyDeniedPostfix, "previouslyDeniedPostfix");
        k.e(callback, "callback");
        String string = activity.getString(R.string.permission_not_available_title);
        k.d(string, "activity.getString(R.str…sion_not_available_title)");
        final int i2 = 1;
        final int i8 = 0;
        String str = String.format(string, Arrays.copyOf(new Object[]{titlePrefix}, 1));
        String string2 = activity.getString(R.string.permission_not_available_message);
        k.d(string2, "activity.getString(R.str…on_not_available_message)");
        try {
            new AlertDialog.Builder(activity).setTitle(str).setMessage(String.format(string2, Arrays.copyOf(new Object[]{previouslyDeniedPostfix}, 1))).setPositiveButton(R.string.permission_not_available_open_settings_option, new DialogInterface.OnClickListener() { // from class: i3.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i9) {
                    switch (i8) {
                        case 0:
                            AlertDialogPrepromptForAndroidSettings.m3140show$lambda0(callback, dialogInterface, i9);
                            break;
                        default:
                            AlertDialogPrepromptForAndroidSettings.m3141show$lambda1(callback, dialogInterface, i9);
                            break;
                    }
                }
            }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // from class: i3.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i9) {
                    switch (i2) {
                        case 0:
                            AlertDialogPrepromptForAndroidSettings.m3140show$lambda0(callback, dialogInterface, i9);
                            break;
                        default:
                            AlertDialogPrepromptForAndroidSettings.m3141show$lambda1(callback, dialogInterface, i9);
                            break;
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i3.b
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    AlertDialogPrepromptForAndroidSettings.m3142show$lambda2(callback, dialogInterface);
                }
            }).show();
        } catch (WindowManager.BadTokenException unused) {
            Logging.log(LogLevel.ERROR, "Alert dialog for Android settings was skipped because the activity was unavailable to display it.");
            callback.onDecline();
        }
    }
}

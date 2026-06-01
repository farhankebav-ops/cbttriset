package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.IntentSender;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface AppUpdateManager {
    @NonNull
    Task<Void> completeUpdate();

    @NonNull
    Task<AppUpdateInfo> getAppUpdateInfo();

    void registerListener(@NonNull InstallStateUpdatedListener installStateUpdatedListener);

    Task<Integer> startUpdateFlow(@NonNull AppUpdateInfo appUpdateInfo, @NonNull Activity activity, @NonNull AppUpdateOptions appUpdateOptions);

    @Deprecated
    boolean startUpdateFlowForResult(@NonNull AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, @NonNull Activity activity, int i8) throws IntentSender.SendIntentException;

    @Deprecated
    boolean startUpdateFlowForResult(@NonNull AppUpdateInfo appUpdateInfo, @AppUpdateType int i2, @NonNull IntentSenderForResultStarter intentSenderForResultStarter, int i8) throws IntentSender.SendIntentException;

    boolean startUpdateFlowForResult(@NonNull AppUpdateInfo appUpdateInfo, @NonNull Activity activity, @NonNull AppUpdateOptions appUpdateOptions, int i2) throws IntentSender.SendIntentException;

    boolean startUpdateFlowForResult(@NonNull AppUpdateInfo appUpdateInfo, @NonNull ActivityResultLauncher<IntentSenderRequest> activityResultLauncher, @NonNull AppUpdateOptions appUpdateOptions);

    boolean startUpdateFlowForResult(@NonNull AppUpdateInfo appUpdateInfo, @NonNull IntentSenderForResultStarter intentSenderForResultStarter, @NonNull AppUpdateOptions appUpdateOptions, int i2) throws IntentSender.SendIntentException;

    void unregisterListener(@NonNull InstallStateUpdatedListener installStateUpdatedListener);
}

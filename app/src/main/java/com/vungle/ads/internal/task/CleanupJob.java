package com.vungle.ads.internal.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CleanupJob implements Job {
    private static final String AD_ID_KEY = "AD_ID_KEY";
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "CleanupJob";
    private final Context context;
    private final PathProvider pathProvider;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ JobInfo makeJobInfo$default(Companion companion, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return companion.makeJobInfo(str);
        }

        public final JobInfo makeJobInfo(String str) {
            JobInfo priority = new JobInfo(CleanupJob.TAG).setPriority(0);
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(CleanupJob.AD_ID_KEY, str);
            }
            return priority.setExtras(bundle).setUpdateCurrent(str == null);
        }

        private Companion() {
        }
    }

    public CleanupJob(Context context, PathProvider pathProvider) {
        k.e(context, "context");
        k.e(pathProvider, "pathProvider");
        this.context = context;
        this.pathProvider = pathProvider;
    }

    private final void checkIfSdkUpgraded() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        q5.f fVarB = b.B(g.f13494a, new CleanupJob$checkIfSdkUpgraded$$inlined$inject$1(this.context));
        int i2 = m3355checkIfSdkUpgraded$lambda4(fVarB).getInt("VERSION_CODE", -1);
        if (i2 < 70600) {
            if (i2 < 70000) {
                dropV6Data();
            }
            if (i2 < 70100) {
                dropV700Data();
            }
            if (i2 < 70301) {
                dropV730TempData();
            }
            if (i2 < 70500) {
                dropV742TpatData();
            }
            if (i2 < 70600) {
                dropV750Data();
            }
            m3355checkIfSdkUpgraded$lambda4(fVarB).put("VERSION_CODE", BuildConfig.VERSION_CODE).apply();
        }
    }

    /* JADX INFO: renamed from: checkIfSdkUpgraded$lambda-4, reason: not valid java name */
    private static final FilePreferences m3355checkIfSdkUpgraded$lambda4(q5.f fVar) {
        return (FilePreferences) fVar.getValue();
    }

    private final void dropV6Data() {
        Logger.Companion.d(TAG, "CleanupJob: drop old files data");
        File file = new File(this.context.getNoBackupFilesDir(), "vungle_db");
        if (file.exists()) {
            FileUtility.delete$default(file, null, 2, null);
            FileUtility.delete$default(new File(file.getPath() + "-journal"), null, 2, null);
        } else {
            this.context.deleteDatabase("vungle_db");
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("com.vungle.sdk", 0);
        String string = sharedPreferences.getString("cache_path", null);
        if (Build.VERSION.SDK_INT >= 24) {
            this.context.deleteSharedPreferences("com.vungle.sdk");
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            k.d(editor, "editor");
            editor.clear();
            editor.apply();
        }
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        k.d(noBackupFilesDir, "context.noBackupFilesDir");
        FileUtility.delete$default(new File(noBackupFilesDir, "vungle_settings"), null, 2, null);
        if (string != null) {
            FileUtility.delete$default(new File(string), null, 2, null);
        }
    }

    private final void dropV700Data() {
        FileUtility.delete$default(new File(this.context.getApplicationInfo().dataDir, "vungle"), null, 2, null);
    }

    private final void dropV730TempData() {
        try {
            FileUtility.delete$default(new File(this.pathProvider.getSharedPrefsDir(), "vungleSettings"), null, 2, null);
            FileUtility.delete$default(new File(this.pathProvider.getSharedPrefsDir(), "failedTpatSet"), null, 2, null);
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Failed to delete temp data", e);
        }
    }

    private final void dropV742TpatData() {
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        try {
            FileUtility.delete$default(new File(noBackupFilesDir, "failedTpats"), null, 2, null);
            FileUtility.delete$default(new File(noBackupFilesDir, "failedGenericTpats"), null, 2, null);
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Failed to delete 742 tpat data", e);
        }
    }

    private final void dropV750Data() {
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        try {
            FileUtility.delete$default(new File(noBackupFilesDir, "vungle_cache/downloads"), null, 2, null);
            FileUtility.delete$default(new File(noBackupFilesDir, "vungle_cache/js"), null, 2, null);
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Failed to delete 750 data", e);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    @Override // com.vungle.ads.internal.task.Job
    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        File downloadsDirForAd;
        k.e(bundle, "bundle");
        k.e(jobRunner, "jobRunner");
        File vmDir = this.pathProvider.getVmDir();
        String string = bundle.getString(AD_ID_KEY);
        if (string == null || (downloadsDirForAd = this.pathProvider.getDownloadsDirForAd(string)) == null) {
            downloadsDirForAd = vmDir;
        }
        Logger.Companion.d(TAG, "CleanupJob: Current directory snapshot");
        try {
            if (!k.a(downloadsDirForAd, vmDir)) {
                FileUtility.delete$default(downloadsDirForAd, null, 2, null);
                return 0;
            }
            checkIfSdkUpgraded();
            FileUtility.deleteContents(downloadsDirForAd, b.O(Constants.OM_SDK_JS, Constants.OM_SESSION_JS));
            return 0;
        } catch (IOException unused) {
            return 1;
        }
    }
}

package com.google.firebase.crashlytics.internal;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface NativeSessionFileProvider {
    @Nullable
    File getAppFile();

    @Nullable
    CrashlyticsReport.ApplicationExitInfo getApplicationExitInto();

    @Nullable
    File getBinaryImagesFile();

    @Nullable
    File getDeviceFile();

    @Nullable
    File getMetadataFile();

    @Nullable
    File getMinidumpFile();

    @Nullable
    File getOsFile();

    @Nullable
    File getSessionFile();
}

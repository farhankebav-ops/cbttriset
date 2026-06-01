package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
interface NativeSessionFile {
    @Nullable
    CrashlyticsReport.FilesPayload.File asFilePayload();

    @NonNull
    String getReportsEndpointFilename();

    @Nullable
    InputStream getStream();
}

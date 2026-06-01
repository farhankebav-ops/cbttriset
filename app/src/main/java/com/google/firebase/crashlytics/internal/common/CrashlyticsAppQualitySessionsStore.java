package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class CrashlyticsAppQualitySessionsStore {
    private static final String AQS_SESSION_ID_FILENAME_PREFIX = "aqs.";
    private static final FilenameFilter AQS_SESSION_ID_FILE_FILTER;
    private static final Comparator<File> FILE_RECENCY_COMPARATOR;
    private final FileStore fileStore;

    @Nullable
    private String sessionId = null;

    @Nullable
    private String appQualitySessionId = null;

    static {
        int i2 = 0;
        AQS_SESSION_ID_FILE_FILTER = new a(i2);
        FILE_RECENCY_COMPARATOR = new b(i2);
    }

    public CrashlyticsAppQualitySessionsStore(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(File file, String str) {
        return str.startsWith(AQS_SESSION_ID_FILENAME_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    private static void persist(FileStore fileStore, @Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            fileStore.getSessionFile(str, AQS_SESSION_ID_FILENAME_PREFIX.concat(str2)).createNewFile();
        } catch (IOException e) {
            Logger.getLogger().w("Failed to persist App Quality Sessions session id.", e);
        }
    }

    @Nullable
    @VisibleForTesting
    public static String readAqsSessionIdFile(FileStore fileStore, @NonNull String str) {
        List<File> sessionFiles = fileStore.getSessionFiles(str, AQS_SESSION_ID_FILE_FILTER);
        if (!sessionFiles.isEmpty()) {
            return ((File) Collections.min(sessionFiles, FILE_RECENCY_COMPARATOR)).getName().substring(4);
        }
        Logger.getLogger().w("Unable to read App Quality Sessions session id.");
        return null;
    }

    @Nullable
    public synchronized String getAppQualitySessionId(@NonNull String str) {
        if (Objects.equals(this.sessionId, str)) {
            return this.appQualitySessionId;
        }
        return readAqsSessionIdFile(this.fileStore, str);
    }

    public synchronized void rotateAppQualitySessionId(@NonNull String str) {
        if (!Objects.equals(this.appQualitySessionId, str)) {
            persist(this.fileStore, this.sessionId, str);
            this.appQualitySessionId = str;
        }
    }

    public synchronized void rotateSessionId(@Nullable String str) {
        if (!Objects.equals(this.sessionId, str)) {
            persist(this.fileStore, str, this.appQualitySessionId);
            this.sessionId = str;
        }
    }
}

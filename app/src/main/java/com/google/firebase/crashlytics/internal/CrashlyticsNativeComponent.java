package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface CrashlyticsNativeComponent {
    @NonNull
    NativeSessionFileProvider getSessionFileProvider(@NonNull String str);

    boolean hasCrashDataForCurrentSession();

    boolean hasCrashDataForSession(@NonNull String str);

    void prepareNativeSession(@NonNull String str, @NonNull String str2, long j, @NonNull StaticSessionData staticSessionData);
}

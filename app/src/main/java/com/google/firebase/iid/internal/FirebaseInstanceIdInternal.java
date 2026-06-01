package com.google.firebase.iid.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@KeepForSdk
public interface FirebaseInstanceIdInternal {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdk
    public interface NewTokenListener {
        @KeepForSdk
        void onNewToken(String str);
    }

    @KeepForSdk
    void addNewTokenListener(NewTokenListener newTokenListener);

    @KeepForSdk
    void deleteToken(@NonNull String str, @NonNull String str2) throws IOException;

    @KeepForSdk
    String getId();

    @Nullable
    @KeepForSdk
    String getToken();

    @NonNull
    @KeepForSdk
    Task<String> getTokenTask();
}

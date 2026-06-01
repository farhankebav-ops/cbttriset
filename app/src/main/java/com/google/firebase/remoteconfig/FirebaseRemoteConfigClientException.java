package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class FirebaseRemoteConfigClientException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigClientException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @NonNull FirebaseRemoteConfigException.Code code) {
        super(str, code);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @Nullable Throwable th, @NonNull FirebaseRemoteConfigException.Code code) {
        super(str, th, code);
    }
}

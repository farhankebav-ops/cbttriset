package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class FirebaseRemoteConfigException extends FirebaseException {
    private final Code code;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Code {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);

        private final int value;

        Code(int i2) {
            this.value = i2;
        }

        public int value() {
            return this.value;
        }
    }

    public FirebaseRemoteConfigException(@NonNull String str) {
        super(str);
        this.code = Code.UNKNOWN;
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.code = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @NonNull Code code) {
        super(str);
        this.code = code;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th, @NonNull Code code) {
        super(str, th);
        this.code = code;
    }
}

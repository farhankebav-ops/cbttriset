package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class InstallationResponse {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        @NonNull
        public abstract InstallationResponse build();

        @NonNull
        public abstract Builder setAuthToken(@NonNull TokenResult tokenResult);

        @NonNull
        public abstract Builder setFid(@NonNull String str);

        @NonNull
        public abstract Builder setRefreshToken(@NonNull String str);

        @NonNull
        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder setUri(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_InstallationResponse.Builder();
    }

    @Nullable
    public abstract TokenResult getAuthToken();

    @Nullable
    public abstract String getFid();

    @Nullable
    public abstract String getRefreshToken();

    @Nullable
    public abstract ResponseCode getResponseCode();

    @Nullable
    public abstract String getUri();

    @NonNull
    public abstract Builder toBuilder();
}

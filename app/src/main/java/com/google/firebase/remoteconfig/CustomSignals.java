package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CustomSignals {
    final Map<String, String> customSignals;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private Map<String, String> customSignals = new HashMap();

        @NonNull
        public CustomSignals build() {
            return new CustomSignals(this);
        }

        @NonNull
        public Builder put(@NonNull String str, @Nullable String str2) {
            this.customSignals.put(str, str2);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, long j) {
            this.customSignals.put(str, Long.toString(j));
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, double d8) {
            this.customSignals.put(str, Double.toString(d8));
            return this;
        }
    }

    public CustomSignals(@NonNull Builder builder) {
        this.customSignals = builder.customSignals;
    }
}

package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CustomKeysAndValues {
    final Map<String, String> keysAndValues;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private Map<String, String> keysAndValues = new HashMap();

        @NonNull
        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z2) {
            this.keysAndValues.put(str, Boolean.toString(z2));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d8) {
            this.keysAndValues.put(str, Double.toString(d8));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f4) {
            this.keysAndValues.put(str, Float.toString(f4));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i2) {
            this.keysAndValues.put(str, Integer.toString(i2));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j) {
            this.keysAndValues.put(str, Long.toString(j));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @NonNull String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }
    }

    public CustomKeysAndValues(@NonNull Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}

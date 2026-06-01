package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(@NonNull String key, double d8) {
        k.e(key, "key");
        this.zza.putDouble(key, d8);
    }

    public final void param(@NonNull String key, long j) {
        k.e(key, "key");
        this.zza.putLong(key, j);
    }

    public final void param(@NonNull String key, @NonNull Bundle value) {
        k.e(key, "key");
        k.e(value, "value");
        this.zza.putBundle(key, value);
    }

    public final void param(@NonNull String key, @NonNull String value) {
        k.e(key, "key");
        k.e(value, "value");
        this.zza.putString(key, value);
    }

    public final void param(@NonNull String key, @NonNull Bundle[] value) {
        k.e(key, "key");
        k.e(value, "value");
        this.zza.putParcelableArray(key, value);
    }
}

package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    @NonNull
    public T getResult() {
        return (T) this.zza;
    }

    public void setResult(@NonNull T t3) {
        this.zza = t3;
    }

    public Response(@NonNull T t3) {
        this.zza = t3;
    }
}

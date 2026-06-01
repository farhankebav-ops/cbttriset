package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcad implements ThreadFactory {
    private final AtomicInteger zza;

    public zzcad(zzcaf zzcafVar) {
        Objects.requireNonNull(zzcafVar);
        this.zza = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        return new Thread(runnable, androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(andIncrement).length() + 31), "AdWorker(SCION_TASK_EXECUTOR) #", andIncrement));
    }
}

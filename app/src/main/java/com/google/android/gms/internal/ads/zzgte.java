package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgte extends AbstractExecutorService implements zzgus, AutoCloseable {
    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        com.bytedance.sdk.openadsdk.common.a.s(this);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzgvh.zze(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzgus
    public final /* synthetic */ Future submit(Runnable runnable) {
        return (j2.q) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzgus
    public final j2.q zza(Runnable runnable) {
        return (j2.q) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzgus
    public final j2.q zzb(Runnable runnable, Object obj) {
        return (j2.q) super.submit(runnable, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgus
    public final j2.q zzc(Callable callable) {
        return (j2.q) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzgvh(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzgus
    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (j2.q) super.submit(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzgus
    public final /* synthetic */ Future submit(Callable callable) {
        return (j2.q) super.submit(callable);
    }
}

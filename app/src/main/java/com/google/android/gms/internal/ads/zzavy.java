package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzavy implements Runnable {
    private zzavy() {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzavz.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzavz.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzavz.zzb;
        } catch (Throwable th) {
            zzavz.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    public /* synthetic */ zzavy(byte[] bArr) {
    }
}

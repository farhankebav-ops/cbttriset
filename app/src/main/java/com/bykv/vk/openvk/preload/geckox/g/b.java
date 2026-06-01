package com.bykv.vk.openvk.preload.geckox.g;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f5000a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ReentrantLock f5001b = new ReentrantLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FileLock f5003d;

    private b(String str, FileLock fileLock) {
        this.f5002c = str;
        this.f5003d = fileLock;
    }

    public static b a(String str) throws Exception {
        f5001b.lock();
        try {
            FileLock fileLockA = FileLock.a(str);
            Map<String, Lock> map = f5000a;
            Lock reentrantLock = map.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(str, reentrantLock);
            }
            reentrantLock.lock();
            return new b(str, fileLockA);
        } catch (Exception e) {
            f5001b.unlock();
            throw e;
        }
    }

    public final void a() {
        try {
            this.f5003d.a();
            this.f5003d.b();
            Lock lock = f5000a.get(this.f5002c);
            if (lock != null) {
                lock.unlock();
            }
        } finally {
            f5001b.unlock();
        }
    }
}

package com.bykv.vk.openvk.preload.geckox.g;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f4997a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileLock f4998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4999c;

    private a(String str, FileLock fileLock) {
        this.f4999c = str;
        this.f4998b = fileLock;
    }

    public static a a(String str) throws Exception {
        Map<String, Lock> map = f4997a;
        synchronized (map) {
            try {
                Lock reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                if (!reentrantLock.tryLock()) {
                    return null;
                }
                try {
                    FileLock fileLockC = FileLock.c(str);
                    if (fileLockC == null) {
                        reentrantLock.unlock();
                        return null;
                    }
                    return new a(str, fileLockC);
                } catch (Exception e) {
                    reentrantLock.lock();
                    com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException(e));
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        Map<String, Lock> map = f4997a;
        synchronized (map) {
            try {
                try {
                    this.f4998b.a();
                    this.f4998b.b();
                    map.get(this.f4999c).unlock();
                } catch (Throwable th) {
                    f4997a.get(this.f4999c).unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

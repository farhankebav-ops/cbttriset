package com.bykv.vk.openvk.preload.geckox.utils;

import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class FileLock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f5043a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5045c;

    static {
        System.loadLibrary("file_lock_pgl");
    }

    private FileLock(String str, int i2) {
        this.f5045c = str;
        this.f5044b = i2;
    }

    public static FileLock a(String str) {
        try {
            int iD = d(str);
            nLockFile(iD);
            return new FileLock(str, iD);
        } catch (Exception e) {
            StringBuilder sbY = a1.a.y("lock failed, file:", str, ", pid:");
            sbY.append(Process.myPid());
            sbY.append(" caused by:");
            sbY.append(e.getMessage());
            throw new RuntimeException(sbY.toString());
        }
    }

    public static FileLock b(String str) {
        try {
            int iD = d(str);
            if (nTryLock(iD)) {
                return new FileLock(str, iD);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(a1.a.j(e, a1.a.y("try lock failed, file:", str, " caused by:")));
        }
    }

    public static FileLock c(String str) throws Exception {
        try {
            int iD = d(str);
            if (nTryLock(iD)) {
                return new FileLock(str, iD);
            }
            new FileLock(str, iD).b();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(a1.a.j(e, a1.a.y("try lock failed, file:", str, " caused by:")));
        }
    }

    private static int d(String str) throws Exception {
        Integer numValueOf;
        Map<String, Integer> map = f5043a;
        synchronized (map) {
            try {
                numValueOf = map.get(str);
                if (numValueOf == null) {
                    new File(str).getParentFile().mkdirs();
                    numValueOf = Integer.valueOf(nGetFD(str));
                    map.put(str, numValueOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return numValueOf.intValue();
    }

    private static native int nGetFD(String str) throws Exception;

    private static native void nLockFile(int i2) throws Exception;

    private static native void nLockFileSegment(int i2, int i8) throws Exception;

    private static native void nRelease(int i2) throws Exception;

    private static native boolean nTryLock(int i2) throws Exception;

    private static native void nUnlockFile(int i2) throws Exception;

    public static FileLock a(String str, int i2) {
        try {
            int iD = d(str);
            nLockFileSegment(iD, i2);
            return new FileLock(str, iD);
        } catch (Exception e) {
            throw new RuntimeException(a1.a.j(e, a1.a.y("lock segment failed, file:", str, " caused by:")));
        }
    }

    public final void b() {
        Integer numRemove;
        Map<String, Integer> map = f5043a;
        synchronized (map) {
            numRemove = map.remove(this.f5045c);
        }
        try {
            nRelease(numRemove.intValue());
        } catch (Exception e) {
            throw new RuntimeException("release lock failed, file:" + this.f5045c + " caused by:" + e.getMessage());
        }
    }

    public final void a() {
        try {
            nUnlockFile(this.f5044b);
        } catch (Exception unused) {
            throw new RuntimeException("release lock failed，path:" + this.f5045c);
        }
    }
}

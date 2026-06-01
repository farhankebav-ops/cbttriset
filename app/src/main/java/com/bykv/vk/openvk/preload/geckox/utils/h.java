package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f5051a = {80, 75, 3, 4};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f5052b = {80, 75, 5, 6};

    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            boolean z2 = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        if (z2) {
                            CloseableUtils.close(zipInputStream);
                            return;
                        }
                        inputStream.reset();
                        if (!a(inputStream)) {
                            throw new RuntimeException("not zip file  channel:".concat(String.valueOf(str2)));
                        }
                        throw new RuntimeException("unzip file: channel:".concat(String.valueOf(str2)));
                    }
                    String name = nextEntry.getName();
                    if (!name.startsWith("__MACOSX/") && !name.equals(".DS_Store") && !name.contains("../")) {
                        if (!name.startsWith(str2 + File.separator)) {
                            throw new RuntimeException("the zip package outermost folder is not named by channel channel:".concat(String.valueOf(str2)));
                        }
                        if (nextEntry.isDirectory()) {
                            File file = new File(canonicalPath, name);
                            if (!file.getCanonicalPath().startsWith(canonicalPath)) {
                                throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                            }
                            file.mkdirs();
                        } else {
                            String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                            if (!canonicalPath2.startsWith(canonicalPath)) {
                                throw new RuntimeException("directory traversal, file name:".concat(name));
                            }
                            File file2 = new File(canonicalPath2);
                            file2.getParentFile().mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(file2);
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                b.a(zipInputStream, fileOutputStream);
                                CloseableUtils.close(fileOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                                CloseableUtils.close(closeable);
                                throw th;
                            }
                        }
                    }
                    z2 = true;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = zipInputStream;
                    CloseableUtils.close(closeable);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.io.InputStream r4) throws java.lang.Exception {
        /*
            r0 = 4
            byte[] r1 = new byte[r0]     // Catch: java.lang.Throwable -> L1b
            r2 = 0
            int r3 = r4.read(r1, r2, r0)     // Catch: java.lang.Throwable -> L1b
            if (r3 != r0) goto L22
            byte[] r0 = com.bykv.vk.openvk.preload.geckox.utils.h.f5051a     // Catch: java.lang.Throwable -> L1b
            boolean r0 = java.util.Arrays.equals(r0, r1)     // Catch: java.lang.Throwable -> L1b
            if (r0 != 0) goto L1d
            byte[] r0 = com.bykv.vk.openvk.preload.geckox.utils.h.f5052b     // Catch: java.lang.Throwable -> L1b
            boolean r0 = java.util.Arrays.equals(r0, r1)     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1e
            goto L1d
        L1b:
            r0 = move-exception
            goto L26
        L1d:
            r2 = 1
        L1e:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close(r4)
            return r2
        L22:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close(r4)
            return r2
        L26:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.utils.h.a(java.io.InputStream):boolean");
    }
}

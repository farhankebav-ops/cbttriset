package sg.bigo.ads.common.utils;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static long a(long j, int i2) {
        char c7;
        if (i2 == 2) {
            c7 = '\n';
        } else if (i2 == 3) {
            c7 = 20;
        } else {
            if (i2 != 4) {
                return j;
            }
            c7 = 30;
        }
        return j >> c7;
    }

    public static void b(@NonNull File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        b(file2);
                    } else {
                        a(file2);
                    }
                }
            }
        }
        a(file);
    }

    public static String c(String str) {
        return a1.a.C(str, ".tmp");
    }

    public static String d(String str) {
        return a1.a.C(str, ".tmp");
    }

    public static long a(String str, int i2) {
        File file = new File(str);
        if (file.exists()) {
            return a(file.length(), i2);
        }
        return 0L;
    }

    public static boolean b(String str) {
        if (q.a((CharSequence) str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return file.delete();
    }

    public static boolean b(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "FileUtils"
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            r7 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            r3.read(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            java.lang.String r2 = "ftyp"
            boolean r2 = r4.contains(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            if (r2 == 0) goto L37
            java.lang.String r2 = "moov"
            boolean r2 = r4.contains(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            if (r2 == 0) goto L37
            java.lang.String r2 = "contains ftyp moov"
            r4 = 3
            sg.bigo.ads.common.t.a.a(r7, r4, r0, r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            r7 = 1
            goto L37
        L32:
            r7 = move-exception
            r2 = r3
            goto L66
        L35:
            r2 = move-exception
            goto L41
        L37:
            r3.close()     // Catch: java.io.IOException -> L65
            goto L65
        L3b:
            r7 = move-exception
            goto L66
        L3d:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L41:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            java.lang.String r5 = "read file "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Throwable -> L32
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = " failed"
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r2.getMessage()     // Catch: java.lang.Throwable -> L32
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L32
            sg.bigo.ads.common.t.a.a(r7, r0, r1)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L65
            goto L37
        L65:
            return r7
        L66:
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.io.IOException -> L6b
        L6b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.f.a(java.lang.String):boolean");
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str, str2);
        try {
            boolean zMkdirs = !file.exists() ? file.mkdirs() : true;
            if (file2.exists()) {
                return zMkdirs;
            }
            if (zMkdirs) {
                if (file2.createNewFile()) {
                    return true;
                }
            }
            return false;
        } catch (IOException unused) {
            return false;
        }
    }

    public static void c(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
    }

    public static boolean c(File file) {
        try {
            File parentFile = file.getParentFile();
            boolean zMkdirs = !parentFile.exists() ? parentFile.mkdirs() : true;
            if (file.exists()) {
                return zMkdirs;
            }
            if (zMkdirs) {
                if (file.createNewFile()) {
                    return true;
                }
            }
            return false;
        } catch (IOException unused) {
            return false;
        }
    }
}

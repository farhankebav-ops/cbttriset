package com.apm.insight.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.apm.insight.l.f;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    static {
        new ArrayList();
    }

    @Nullable
    public static String a(Context context, String str, File file) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String strA = a(applicationInfo.sourceDir, str, file);
        if (strA == null) {
            return null;
        }
        for (String str2 : applicationInfo.splitSourceDirs) {
            strA = a(str2, str, file);
            if (strA == null) {
                return null;
            }
        }
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
            if (!(classLoader instanceof BaseDexClassLoader)) {
                return strA;
            }
            Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField2.setAccessible(true);
            for (String str3 : (String[]) declaredField2.get(obj)) {
                File file2 = new File(str3, System.mapLibraryName(str));
                if (file2.exists()) {
                    f.a(file2, file);
                    com.apm.insight.a.a(file.getAbsolutePath());
                    return null;
                }
            }
            return "not_found";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    private static String a(String str, String str2, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        String str3;
        ZipEntry entry;
        FileOutputStream fileOutputStream = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                StringBuilder sb = new StringBuilder("lib/");
                str3 = Build.CPU_ABI;
                sb.append(str3);
                sb.append("/");
                sb.append(System.mapLibraryName(str2));
                entry = zipFile.getEntry(sb.toString());
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        if (entry == null) {
            int iIndexOf = str3.indexOf(45);
            StringBuilder sb2 = new StringBuilder("lib/");
            if (iIndexOf <= 0) {
                iIndexOf = str3.length();
            }
            sb2.append(str3.substring(0, iIndexOf));
            sb2.append("/");
            sb2.append(System.mapLibraryName(str2));
            String string = sb2.toString();
            ZipEntry entry2 = zipFile.getEntry(string);
            if (entry2 == null) {
                message = "Library entry not found:".concat(String.valueOf(string));
                com.apm.insight.a.a((Closeable) null);
                com.apm.insight.a.a((Closeable) null);
                com.apm.insight.a.a(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = inputStream2.read(bArr);
                    if (i2 > 0) {
                        fileOutputStream2.write(bArr, 0, i2);
                    } else {
                        com.apm.insight.a.a(file.getAbsolutePath());
                        com.apm.insight.a.a((Closeable) fileOutputStream2);
                        com.apm.insight.a.a((Closeable) inputStream2);
                        com.apm.insight.a.a(zipFile);
                        return null;
                    }
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                th = th3;
                try {
                    message = th.getMessage();
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                    com.apm.insight.a.a((Closeable) inputStream);
                    com.apm.insight.a.a(zipFile);
                    return message;
                } catch (Throwable th4) {
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                    com.apm.insight.a.a((Closeable) inputStream);
                    com.apm.insight.a.a(zipFile);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            inputStream = inputStream2;
            th = th5;
        }
    }
}

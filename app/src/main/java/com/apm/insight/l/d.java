package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4519a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4520b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f4521c = Pattern.compile("^0-([\\d]+)$");

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = b("ro.build.version.emui");
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return e();
        }
        return true;
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                com.apm.insight.a.a((Closeable) bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean c() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static int d() {
        int i2 = f4520b;
        if (i2 > 0) {
            return i2;
        }
        int iC = c("/sys/devices/system/cpu/possible");
        if (iC <= 0) {
            iC = c("/sys/devices/system/cpu/present");
        }
        if (iC <= 0) {
            iC = e("/sys/devices/system/cpu/");
        }
        if (iC <= 0) {
            iC = Runtime.getRuntime().availableProcessors();
        }
        if (iC <= 0) {
            iC = 1;
        }
        f4520b = iC;
        return iC;
    }

    private static boolean e() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int c(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    int iD = d(line);
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    return iD;
                }
            } catch (Throwable unused2) {
                if (bufferedReader == null) {
                    return -1;
                }
            }
        } catch (Throwable unused3) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
            return -1;
        } catch (IOException unused4) {
            return -1;
        }
    }

    private static int e(String str) {
        try {
            File[] fileArrListFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.apm.insight.l.d.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Pattern f4522a = Pattern.compile("^cpu[\\d]+$");

                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    return this.f4522a.matcher(str2).matches();
                }
            });
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return -1;
            }
            return fileArrListFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String a() {
        return b("ro.build.version.emui");
    }

    public static boolean b() {
        if (!f4519a) {
            try {
                Class.forName("miui.os.Build");
                com.apm.insight.k.e.f4483a = true;
                f4519a = true;
                return true;
            } catch (Exception unused) {
                f4519a = true;
            }
        }
        return com.apm.insight.k.e.f4483a;
    }

    private static int d(String str) {
        Matcher matcher = f4521c.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        try {
            return Integer.parseInt(matcher.group(1)) + 1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}

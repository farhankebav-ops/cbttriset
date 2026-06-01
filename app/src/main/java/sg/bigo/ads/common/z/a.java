package sg.bigo.ads.common.z;

import android.os.Build;
import com.ironsource.G5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f16255a = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f16256b = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String[] f16257c = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f16258d = {"goldfish"};

    public static int a() {
        try {
            if (!e() && !d() && !f()) {
                if (!g()) {
                    return 0;
                }
            }
            return 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String b() {
        StringBuilder sb = new StringBuilder(" Build.BOARD = ");
        sb.append(Build.BOARD);
        sb.append(", Build.BOOTLOADER = ");
        sb.append(Build.BOOTLOADER);
        sb.append(", Build.BRAND = ");
        sb.append(Build.BRAND);
        sb.append(", Build.DEVICE = ");
        sb.append(Build.DEVICE);
        sb.append(", Build.DISPLAY = ");
        sb.append(Build.DISPLAY);
        sb.append(", Build.FINGERPRINT = ");
        sb.append(Build.FINGERPRINT);
        sb.append(", Build.HARDWARE = ");
        sb.append(Build.HARDWARE);
        sb.append(", Build.HOST = ");
        sb.append(Build.HOST);
        sb.append(", Build.MANUFACTURER = ");
        sb.append(Build.MANUFACTURER);
        sb.append(", Build.MODEL = ");
        sb.append(Build.MODEL);
        sb.append(", Build.PRODUCT = ");
        sb.append(Build.PRODUCT);
        sb.append(", Build.TIME = ");
        sb.append(Build.TIME);
        sb.append(", Build.TYPE = ");
        sb.append(Build.TYPE);
        sb.append(", Build.ID = ");
        sb.append(Build.USER);
        sb.append(", Build.VERSION.CODENAME = ");
        sb.append(Build.VERSION.CODENAME);
        sb.append(", Build.VERSION.INCREMENTAL = ");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append(", Build.VERSION.RELEASE = ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(", Build.VERSION.SDK_INT = ");
        return a1.a.q(sb, ",", Build.VERSION.SDK_INT);
    }

    public static String c() {
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), G5.N));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString().toLowerCase();
                }
                sb.append(line);
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean d() {
        try {
            for (String str : f16256b) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean e() {
        try {
            for (String str : f16255a) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean f() {
        try {
            for (String str : f16257c) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean g() {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i2 = 0; i2 < 2; i2++) {
            File file = fileArr[i2];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                String str = new String(bArr);
                for (String str2 : f16258d) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

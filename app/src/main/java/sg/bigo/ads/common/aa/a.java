package sg.bigo.ads.common.aa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15563a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15564b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f15565c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f15566d;

    /* JADX INFO: renamed from: sg.bigo.ads.common.aa.a$a, reason: collision with other inner class name */
    public final class C0280a implements FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i2 = 3; i2 < name.length(); i2++) {
                if (!Character.isDigit(name.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a() {
        if (f15563a) {
            return f15565c;
        }
        int iA = sg.bigo.ads.common.x.a.a();
        f15565c = iA;
        if (iA != 0) {
            f15563a = true;
            return iA;
        }
        try {
            f15565c = new File("/sys/devices/system/cpu/").listFiles(new C0280a()).length;
        } catch (Throwable unused) {
        }
        if (f15565c <= 1) {
            f15565c = Runtime.getRuntime().availableProcessors();
        }
        f15563a = true;
        sg.bigo.ads.common.x.a.a(f15565c);
        return f15565c;
    }

    public static long b() {
        if (f15564b) {
            long j = f15566d;
            if (j != 0) {
                return j;
            }
        }
        long jB = sg.bigo.ads.common.x.a.b();
        f15566d = jB;
        if (jB != 0) {
            f15564b = true;
            return jB;
        }
        int i2 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < a(); i9++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i9 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i10 = 0;
                        while (Character.isDigit(bArr[i10]) && i10 < 128) {
                            i10++;
                        }
                        int i11 = Integer.parseInt(new String(bArr, 0, i10));
                        if (i11 > i8) {
                            i8 = i11;
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (Exception unused2) {
            }
        }
        if (i8 == -1) {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.split(":", 2);
                    if ("cpu MHz".equals(strArrSplit[0].replaceAll("[\\t\\n\\r]", ""))) {
                        int i12 = (strArrSplit[1].contains(".") ? (int) Double.parseDouble(strArrSplit[1]) : Integer.parseInt(strArrSplit[1])) * 1000;
                        if (i12 > i8) {
                            i8 = i12;
                        }
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    fileReader.close();
                    bufferedReader.close();
                    throw th2;
                }
            }
            fileReader.close();
            bufferedReader.close();
        }
        i2 = i8;
        f15564b = true;
        long j3 = i2 / 1000;
        f15566d = j3;
        sg.bigo.ads.common.x.a.a(j3);
        return f15566d;
    }
}

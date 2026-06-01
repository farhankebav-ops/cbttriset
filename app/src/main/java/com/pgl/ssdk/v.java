package com.pgl.ssdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.C2605va;
import com.ironsource.Q6;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f10814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f10815b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f10816c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10817d = null;
    private static String e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f10818f = null;
    private static int g = -1;
    private static long h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f10819i = 0;
    private static volatile long j = -1;

    public static void a(File file, boolean z2) throws Throwable {
        e eVarA;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
                try {
                    if (TextUtils.isEmpty(f10814a) && (eVarA = a(file)) != null) {
                        f10814a = a(eVarA.a());
                        f10817d = eVarA.b();
                        if (z2) {
                            a();
                            try {
                                randomAccessFile2.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(e)) {
                        e = a(randomAccessFile2);
                    }
                    if (h == 0) {
                        h = randomAccessFile2.length() / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
                    }
                    if (f10819i == 0) {
                        f10819i = b(file);
                    }
                    randomAccessFile2.close();
                } catch (FileNotFoundException unused2) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (IOException unused3) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
        }
    }

    public static String b() throws Throwable {
        long j3;
        boolean z2;
        String string;
        String string2;
        String string3;
        String string4;
        long j8;
        long j9;
        int i2;
        String str;
        if (TextUtils.isEmpty(f10814a) || TextUtils.isEmpty(e) || g == -1) {
            SharedPreferences sharedPreferencesA = w0.a(z.b());
            long j10 = -1;
            if (sharedPreferencesA != null) {
                j10 = sharedPreferencesA.getLong(Q6.Z0, -1L);
                string2 = sharedPreferencesA.getString("sa", null);
                string3 = sharedPreferencesA.getString("sj", null);
                string4 = sharedPreferencesA.getString("md5", null);
                j8 = sharedPreferencesA.getLong("as", 0L);
                j9 = sharedPreferencesA.getLong("ds", 0L);
                z2 = true;
                i2 = sharedPreferencesA.getInt("cpc", -1);
                j3 = 0;
                string = sharedPreferencesA.getString(C2605va.f10441c, null);
            } else {
                j3 = 0;
                z2 = true;
                string = null;
                string2 = null;
                string3 = null;
                string4 = null;
                j8 = 0;
                j9 = 0;
                i2 = 0;
            }
            String strC = c();
            if (strC == null) {
                return null;
            }
            File file = new File(strC);
            str = null;
            Object[] objArr = (Object[]) com.pgl.ssdk.ces.a.meta(158, z.b(), strC);
            Integer num = (Integer) objArr[0];
            String str2 = (String) objArr[z2 ? 1 : 0];
            long jLastModified = file.lastModified();
            if (jLastModified != j10 || string2 == null || i2 == -1) {
                j = jLastModified;
                if (str2 != null) {
                    f10818f = str2;
                }
                if (num != null) {
                    g = num.intValue();
                }
                a(file, false);
                a();
            } else {
                f10814a = string2;
                f10817d = string3;
                h = j8;
                f10819i = j9;
                e = string4;
                g = i2;
                f10818f = string;
            }
        } else {
            j3 = 0;
            str = null;
            z2 = true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f10814a)) {
                jSONObject.put("sign", f10814a);
            }
            if (!TextUtils.isEmpty(f10817d)) {
                jSONObject.put("subject", f10817d);
            }
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("md5", e);
            }
            if (!TextUtils.isEmpty(f10818f)) {
                jSONObject.put("path", f10818f);
            }
            long j11 = h;
            if (j11 != j3) {
                jSONObject.put("apkSize", j11);
            }
            long j12 = f10819i;
            if (j12 != j3) {
                jSONObject.put("dexSize", j12);
            }
            int i8 = g;
            if (i8 != -1) {
                jSONObject.put("code", i8);
            }
            f();
            jSONObject.put("signpm", f10815b);
            if (!TextUtils.isEmpty(f10815b) && !TextUtils.isEmpty(f10814a)) {
                if (!f10815b.equals(f10814a)) {
                    f10816c = z2;
                }
                jSONObject.put("rebud", f10816c);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    public static String c() {
        if (z.b() == null) {
            return null;
        }
        String packageCodePath = z.b().getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public static void d() throws Throwable {
        if (TextUtils.isEmpty(f10814a)) {
            SharedPreferences sharedPreferencesA = w0.a(z.b());
            String string = null;
            long j3 = -1;
            if (sharedPreferencesA != null) {
                j3 = sharedPreferencesA.getLong(Q6.Z0, -1L);
                string = sharedPreferencesA.getString("sa", null);
            }
            String strC = c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            File file = new File(strC);
            long jLastModified = file.lastModified();
            if (jLastModified != j3 || string == null) {
                j = jLastModified;
                a(file, true);
                a();
            } else {
                f10814a = string;
            }
        }
        f();
        if (TextUtils.isEmpty(f10815b) || TextUtils.isEmpty(f10814a) || f10815b.equals(f10814a)) {
            return;
        }
        f10816c = true;
    }

    public static String e() throws Throwable {
        d();
        return f10814a;
    }

    public static String f() {
        if (!TextUtils.isEmpty(f10815b)) {
            return f10815b;
        }
        try {
            String strA = a(z.b().getPackageManager().getPackageInfo(z.b().getPackageName(), 64).signatures[0].toByteArray());
            f10815b = strA;
            return strA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() throws Throwable {
        d();
        return f10816c;
    }

    public static void a() {
        SharedPreferences sharedPreferencesA = w0.a(z.b());
        if (sharedPreferencesA != null) {
            if (!TextUtils.isEmpty(f10814a)) {
                sharedPreferencesA.edit().putString("sa", f10814a).apply();
            }
            if (!TextUtils.isEmpty(e)) {
                sharedPreferencesA.edit().putString("md5", e).apply();
            }
            if (!TextUtils.isEmpty(f10817d)) {
                sharedPreferencesA.edit().putString("sj", f10817d).apply();
            }
            if (h != 0) {
                sharedPreferencesA.edit().putLong("as", h).apply();
            }
            if (f10819i != 0) {
                sharedPreferencesA.edit().putLong("ds", f10819i).apply();
            }
            if (j != -1) {
                sharedPreferencesA.edit().putLong(Q6.Z0, j).apply();
            }
            if (g != -1) {
                sharedPreferencesA.edit().putInt("cpc", g).apply();
            }
            if (TextUtils.isEmpty(f10818f)) {
                return;
            }
            sharedPreferencesA.edit().putString(C2605va.f10441c, f10818f).apply();
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b8 : bArrDigest) {
                sb.append(Integer.toHexString((b8 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    @com.pgl.ssdk.ces.out.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.pgl.ssdk.e a(java.io.File r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1e com.pgl.ssdk.g.a -> L25
            java.lang.String r2 = "r"
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L1e com.pgl.ssdk.g.a -> L25
            long r2 = r1.length()     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            r4 = 0
            com.pgl.ssdk.q r2 = com.pgl.ssdk.r.a(r1, r4, r2)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            com.pgl.ssdk.c$a r3 = com.pgl.ssdk.c.a(r2)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            java.util.List r2 = com.pgl.ssdk.l.a(r2, r3)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            r1.close()     // Catch: java.io.IOException -> L2c
            goto L2c
        L1e:
            r1 = r0
        L1f:
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L2b
            goto L2b
        L25:
            r1 = r0
        L26:
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L2b
        L2b:
            r2 = r0
        L2c:
            if (r2 == 0) goto L34
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L38
        L34:
            java.util.List r2 = com.pgl.ssdk.k.a(r6)
        L38:
            if (r2 == 0) goto L48
            boolean r6 = r2.isEmpty()
            if (r6 != 0) goto L48
            r6 = 0
            java.lang.Object r6 = r2.get(r6)
            com.pgl.ssdk.e r6 = (com.pgl.ssdk.e) r6
            return r6
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.v.a(java.io.File):com.pgl.ssdk.e");
    }

    public static long b(File file) throws Throwable {
        String str;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                int i2 = 0;
                int size = 0;
                while (true) {
                    if (i2 == 0) {
                        str = "classes.dex";
                    } else {
                        str = String.format(Locale.getDefault(), "classes%d.dex", Integer.valueOf(i2));
                    }
                    ZipEntry entry = zipFile2.getEntry(str);
                    if (entry == null) {
                        break;
                    }
                    try {
                        size = (int) (((long) size) + entry.getSize());
                        i2++;
                    } catch (ZipException unused) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (IOException unused2) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                long j3 = size / 1000;
                try {
                    zipFile2.close();
                } catch (IOException unused4) {
                }
                return j3;
            } catch (ZipException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
            return 0L;
        }
    }

    public static String a(RandomAccessFile randomAccessFile) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = randomAccessFile.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            while (string.length() < 32) {
                string = "0".concat(string);
            }
            return string;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}

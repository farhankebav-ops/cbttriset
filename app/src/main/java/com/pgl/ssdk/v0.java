package com.pgl.ssdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f10820a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10822b;

        public a(int i2, String... strArr) {
            this.f10821a = i2;
            JSONArray jSONArray = new JSONArray();
            for (String str : strArr) {
                jSONArray.put(str);
            }
            this.f10822b = jSONArray.toString();
        }
    }

    private static ZipEntry a(ZipFile zipFile, String str, String str2) {
        StringBuilder sbY = a1.a.y("lib/", str, "/");
        sbY.append(System.mapLibraryName(str2));
        ZipEntry entry = zipFile.getEntry(sbY.toString());
        if (entry != null) {
            return entry;
        }
        int iIndexOf = str.indexOf(45);
        StringBuilder sb = new StringBuilder("lib/");
        if (iIndexOf <= 0) {
            iIndexOf = str.length();
        }
        sb.append(str.substring(0, iIndexOf));
        sb.append("/");
        sb.append(System.mapLibraryName(str2));
        return zipFile.getEntry(sb.toString());
    }

    public static synchronized a b(Context context, String str) {
        if (f10820a.contains(str)) {
            return null;
        }
        try {
            System.loadLibrary(str);
            f10820a.add(str);
        } catch (UnsatisfiedLinkError e) {
            File fileA = a(context, str);
            if (fileA == null) {
                return new a(3, e.getMessage(), "output null");
            }
            if (fileA.exists()) {
                fileA.delete();
            }
            a aVarA = a(context, str, fileA);
            if (aVarA != null) {
                return aVarA;
            }
            try {
                System.load(fileA.getAbsolutePath());
                f10820a.add(str);
            } catch (Throwable th) {
                return new a(3, e.getMessage(), th.getMessage());
            }
        } catch (Throwable th2) {
            return new a(3, th2.getMessage());
        }
        return null;
    }

    private static File a(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "libso");
        if (!file.exists()) {
            r0.a(file.getAbsolutePath());
        }
        return file;
    }

    private static File a(Context context, String str) {
        String strMapLibraryName = System.mapLibraryName(str);
        File fileA = a(context);
        if (fileA != null) {
            return new File(fileA, strMapLibraryName);
        }
        return null;
    }

    private static a a(Context context, String str, File file) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ZipFile zipFile = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            ZipFile zipFile2 = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                ZipEntry zipEntryA = a(zipFile2, Build.CPU_ABI, str);
                if (zipEntryA == null) {
                    try {
                        zipEntryA = a(zipFile2, Build.CPU_ABI2, str);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = null;
                        fileOutputStream = null;
                        zipFile = zipFile2;
                        try {
                            return new a(3, th.getMessage());
                        } finally {
                            r0.a(fileOutputStream);
                            r0.a(inputStream);
                            r0.a(zipFile);
                        }
                    }
                }
                if (zipEntryA != null) {
                    file.createNewFile();
                    InputStream inputStream2 = zipFile2.getInputStream(zipEntryA);
                    try {
                        fileOutputStream2 = new FileOutputStream(file);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                    }
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i2 = inputStream2.read(bArr);
                            if (i2 > 0) {
                                fileOutputStream2.write(bArr, 0, i2);
                            } else {
                                r0.a(file.getAbsolutePath(), 493);
                                r0.a(fileOutputStream2);
                                r0.a(inputStream2);
                                r0.a(zipFile2);
                                return null;
                            }
                        }
                    } catch (Throwable th3) {
                        fileOutputStream3 = fileOutputStream2;
                        inputStream = inputStream2;
                        th = th3;
                        fileOutputStream = fileOutputStream3;
                        zipFile = zipFile2;
                        return new a(3, th.getMessage());
                    }
                } else {
                    a aVar = new a(2, a(zipFile2, str));
                    r0.a((Closeable) null);
                    r0.a((Closeable) null);
                    r0.a(zipFile2);
                    return aVar;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    private static String a(ZipFile zipFile, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"armeabi-v7a", "arm64-v8a", "x86", "x86_64", "armeabi"};
        for (int i2 = 0; i2 < 5; i2++) {
            String str2 = strArr[i2];
            if (a(zipFile, str2, str) != null) {
                arrayList.add(str2);
            }
        }
        List listAsList = Arrays.asList(Build.SUPPORTED_ABIS);
        ArrayList arrayList2 = new ArrayList();
        String str3 = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str3)) {
            arrayList2.add(str3);
        }
        String str4 = Build.CPU_ABI2;
        if (!TextUtils.isEmpty(str4)) {
            arrayList2.add(str4);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("supportedABIS", listAsList);
            jSONObject.put("curABIs", arrayList2);
            jSONObject.put("apkABIS", arrayList);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}

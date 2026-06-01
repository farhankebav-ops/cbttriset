package com.apm.insight.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.FtsOptions;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeImpl;
import com.ironsource.C2300e4;
import com.ironsource.C2605va;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f4528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f4529d;

    public f(int i2) {
        this.f4526a = i2;
    }

    public static void a(@NonNull File file, @NonNull String str, boolean z2) throws Throwable {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z2);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            com.apm.insight.a.a((Closeable) fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.apm.insight.a.a((Closeable) fileOutputStream2);
            throw th;
        }
    }

    private static String b(File file, String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        com.apm.insight.a.a((Closeable) bufferedReader2);
                        return sb.toString();
                    }
                    if (sb.length() != 0 && str != null) {
                        sb.append(str);
                    }
                    sb.append(line);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Nullable
    public static Map<String, String> c(File file) throws Throwable {
        FileInputStream fileInputStream;
        Properties properties;
        FileInputStream fileInputStream2 = null;
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(file);
        } catch (IOException e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            com.apm.insight.a.a((Closeable) fileInputStream2);
            throw th;
        }
        try {
            try {
                properties.load(fileInputStream);
                Set<String> setStringPropertyNames = properties.stringPropertyNames();
                HashMap map = new HashMap();
                for (String str : setStringPropertyNames) {
                    map.put(str, properties.getProperty(str));
                }
                com.apm.insight.a.a((Closeable) fileInputStream);
                return map;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                com.apm.insight.a.a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            com.apm.insight.a.b((Throwable) e);
            com.apm.insight.a.a((Closeable) fileInputStream);
            return null;
        }
    }

    public static void d(File file) {
        File file2 = new File(file, "lock");
        try {
            file2.createNewFile();
            NativeImpl.c(file2.getAbsolutePath());
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
    }

    public static boolean e(File file) {
        if (!file.isFile()) {
            file = new File(file, "lock");
        }
        if (!file.exists()) {
            return false;
        }
        try {
            int iC = NativeImpl.c(file.getAbsolutePath());
            if (iC > 0) {
                NativeImpl.a(iC);
                return false;
            }
            if (iC < 0) {
                return true;
            }
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
        return false;
    }

    private static com.apm.insight.entity.a f(File file) {
        com.apm.insight.entity.a aVarA = a(new File(file, "logEventStack"), file.getName().contains("oom"));
        boolean z2 = false;
        for (int i2 = 0; i2 < 6; i2++) {
            File fileA = j.a(file, ".".concat(String.valueOf(i2)));
            if (fileA.exists()) {
                try {
                    aVarA.c(new JSONObject(a(fileA.getAbsolutePath(), "\n")));
                    z2 = true;
                } catch (Throwable unused) {
                }
            }
        }
        aVarA.a("crash_type", z2 ? "step" : FtsOptions.TOKENIZER_SIMPLE);
        JSONObject jSONObjectOptJSONObject = aVarA.c().optJSONObject("header");
        com.apm.insight.e.g();
        JSONObject jSONObjectF = Header.a(aVarA.c().optLong("crash_time", 0L)).f();
        if (jSONObjectOptJSONObject == null) {
            aVarA.a(jSONObjectF);
        } else {
            com.apm.insight.a.a(jSONObjectOptJSONObject, jSONObjectF);
        }
        return aVarA;
    }

    public f(byte[] bArr) {
        this.f4526a = 204;
        this.f4529d = bArr;
    }

    public f(int i2, Throwable th) {
        this.f4526a = i2;
        this.f4527b = th.getMessage();
    }

    public static void a(@NonNull File file, @NonNull JSONObject jSONObject) throws IOException {
        BufferedWriter bufferedWriter;
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                h.a(jSONObject, bufferedWriter);
                com.apm.insight.a.a((Closeable) bufferedWriter);
            } catch (Throwable unused) {
                com.apm.insight.a.a((Closeable) bufferedWriter);
            }
        } catch (Throwable unused2) {
            bufferedWriter = null;
        }
    }

    public f(String str) {
        this.f4526a = 206;
        this.f4527b = str;
    }

    public static boolean b(File file) {
        String[] list = file.list();
        return list == null || list.length == 0;
    }

    public static void a(@NonNull File file, @NonNull JSONArray jSONArray) throws IOException {
        BufferedWriter bufferedWriter;
        if (jSONArray == null) {
            return;
        }
        file.getParentFile().mkdirs();
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                h.a(jSONArray, bufferedWriter);
                com.apm.insight.a.a((Closeable) bufferedWriter);
            } catch (Throwable unused) {
                com.apm.insight.a.a((Closeable) bufferedWriter);
            }
        } catch (Throwable unused2) {
            bufferedWriter = null;
        }
    }

    public static com.apm.insight.f.b c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(a(str, "\n"));
            com.apm.insight.f.b bVar = new com.apm.insight.f.b();
            bVar.d(jSONObject.optString(C2605va.f10440b));
            bVar.c(jSONObject.optString("did"));
            bVar.e(jSONObject.optString("processName"));
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("alogFiles");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i2));
                }
                bVar.a(arrayList);
            }
            return bVar;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public f(JSONObject jSONObject) {
        this.f4526a = 0;
        this.f4528c = jSONObject;
    }

    private static String b(File file, String str, String str2, JSONObject jSONObject, boolean z2) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put(C2300e4.h.E0, jSONObject);
            jSONObject2.put("dump_file", "");
            jSONObject2.put("encrypt", z2);
            a(file2, jSONObject2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static boolean a(@NonNull File file) {
        boolean zA;
        boolean z2 = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.canWrite()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        for (int i2 = 0; fileArrListFiles != null && i2 < fileArrListFiles.length; i2++) {
            if (fileArrListFiles[i2].isFile()) {
                if (fileArrListFiles[i2].canWrite()) {
                    zA = fileArrListFiles[i2].delete();
                } else {
                    z2 = false;
                }
            } else {
                zA = a(fileArrListFiles[i2]);
            }
            z2 &= zA;
        }
        return file.delete() & z2;
    }

    public static void b(String str, String str2) throws Exception {
        ZipOutputStream zipOutputStream;
        Throwable th;
        File file = new File(str);
        try {
            new File(str2).getParentFile().mkdirs();
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        } catch (Throwable th2) {
            zipOutputStream = null;
            th = th2;
        }
        try {
            a(zipOutputStream, file, "");
            com.apm.insight.a.a((Closeable) zipOutputStream);
        } catch (Throwable th3) {
            th = th3;
            com.apm.insight.a.a((Closeable) zipOutputStream);
            throw th;
        }
    }

    public static String a(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(new File(str), str2);
    }

    public static com.apm.insight.f.b b(String str) {
        try {
            String strA = a(str, "\n");
            if (strA == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strA);
            com.apm.insight.f.b bVar = new com.apm.insight.f.b();
            bVar.a(jSONObject.optString("url"));
            bVar.a(jSONObject.optJSONObject(C2300e4.h.E0));
            bVar.b(jSONObject.optString("dump_file"));
            bVar.a(jSONObject.optBoolean("encrypt", false));
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(File file, String str) throws IOException {
        return b(file, str);
    }

    public static JSONArray a(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(str), -1L);
    }

    public static JSONArray a(@NonNull File file, long j) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String line = bufferedReader2.readLine();
                if (line != null) {
                    jSONArray.put(line);
                } else {
                    com.apm.insight.a.a((Closeable) bufferedReader2);
                    return jSONArray;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Nullable
    public final byte[] b() {
        return this.f4529d;
    }

    public static com.apm.insight.f.b a(File file, CrashType crashType) {
        String strC;
        com.apm.insight.entity.a aVarF = f(file);
        String name = file.getName();
        String strSubstring = name.substring(name.lastIndexOf(95) + 1);
        JSONObject jSONObjectOptJSONObject = aVarF.c().optJSONObject("header");
        if (jSONObjectOptJSONObject.optString("unique_key", null) == null) {
            try {
                jSONObjectOptJSONObject.put("unique_key", "android_" + com.apm.insight.e.c().a() + "_" + strSubstring + "_" + CrashType.LAUNCH);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.apm.insight.f.b bVar = new com.apm.insight.f.b();
        if (crashType == CrashType.LAUNCH) {
            strC = com.apm.insight.k.e.e();
        } else {
            strC = com.apm.insight.k.e.c();
        }
        bVar.a(strC);
        bVar.a(aVarF.c());
        bVar.a(com.apm.insight.k.e.a());
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.apm.insight.entity.a a(java.io.File r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.f.a(java.io.File, boolean):com.apm.insight.entity.a");
    }

    @Nullable
    public static void a(File file, Map<String, String> map) throws Throwable {
        if (map == null || map.isEmpty()) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                Properties properties = new Properties();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        properties.setProperty(entry.getKey(), entry.getValue());
                    }
                    properties.store(fileOutputStream2, "no");
                    com.apm.insight.a.a((Closeable) fileOutputStream2);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    com.apm.insight.a.b((Throwable) e);
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    public static String a(File file, String str, String str2, JSONObject jSONObject, boolean z2) {
        return b(file, str, str2, jSONObject, z2);
    }

    public static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file2 == null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            file2.getParentFile().mkdirs();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = fileInputStream2.read(bArr);
                        if (i2 <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                    }
                    com.apm.insight.a.a((Closeable) fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        com.apm.insight.a.a((Closeable) fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        com.apm.insight.a.a((Closeable) fileInputStream);
                        com.apm.insight.a.a((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    com.apm.insight.a.a((Closeable) fileInputStream);
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        com.apm.insight.a.a((Closeable) fileOutputStream);
    }

    public static void a(OutputStream outputStream, File... fileArr) throws IOException {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (File file : fileArr) {
                    a(zipOutputStream2, file);
                }
                com.apm.insight.a.a((Closeable) zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                com.apm.insight.a.a((Closeable) zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        File[] fileArrListFiles = file.isDirectory() ? file.listFiles() : new File[]{file};
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            a(zipOutputStream, file2, file2.getName());
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            zipOutputStream.putNextEntry(new ZipEntry(a1.a.C(str, "/")));
            String strConcat = str.length() == 0 ? "" : str.concat("/");
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                File file2 = fileArrListFiles[i2];
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(strConcat);
                sbR.append(fileArrListFiles[i2].getName());
                a(zipOutputStream, file2, sbR.toString());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i8 = fileInputStream2.read(bArr);
                    if (-1 != i8) {
                        zipOutputStream.write(bArr, 0, i8);
                    } else {
                        com.apm.insight.a.a((Closeable) fileInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                com.apm.insight.a.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean a() {
        return this.f4526a != 207;
    }
}

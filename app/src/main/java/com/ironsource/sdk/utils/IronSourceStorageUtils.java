package com.ironsource.sdk.utils;

import a1.a;
import android.content.Context;
import android.os.Build;
import com.ironsource.B7;
import com.ironsource.C2300e4;
import com.ironsource.C2531r4;
import com.ironsource.C2559sf;
import com.ironsource.C8;
import com.ironsource.Mb;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceStorageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10212a = "supersonicads";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C2559sf f10213b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10214c = false;

    private static void a(Context context) {
        C2559sf c2559sf = f10213b;
        if (c2559sf != null && c2559sf.b()) {
            deleteCacheDirectories(context);
        }
        C2559sf c2559sf2 = f10213b;
        if (c2559sf2 == null || !c2559sf2.c()) {
            return;
        }
        deleteFilesDirectories(context);
    }

    private static File b(Context context) {
        B7 b7I = Mb.U().i();
        C2559sf c2559sf = f10213b;
        return (c2559sf == null || !c2559sf.d()) ? b7I.f(context) : b7I.l(context);
    }

    public static String buildAbsolutePathToDirInCache(String str, String str2) {
        return str2 == null ? str : a.r(androidx.camera.core.processing.util.a.r(str), File.separator, str2);
    }

    public static JSONObject buildFilesMap(String str, String str2) {
        File file = new File(str, str2);
        JSONObject jSONObject = new JSONObject();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    Object objC = c(file2);
                    if (objC instanceof JSONArray) {
                        jSONObject.put("files", c(file2));
                    } else if (objC instanceof JSONObject) {
                        jSONObject.put(file2.getName(), c(file2));
                    }
                } catch (JSONException e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject buildFilesMapOfDirectory(C8 c8, JSONObject jSONObject) throws Exception {
        if (c8 == null || !c8.isDirectory()) {
            return new JSONObject();
        }
        File[] fileArrListFiles = c8.listFiles();
        if (fileArrListFiles == null) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        for (File file : fileArrListFiles) {
            C8 c82 = new C8(file.getPath());
            if (c82.isFile()) {
                String name = c82.getName();
                JSONObject jSONObjectA = c82.a();
                if (jSONObject.has(name)) {
                    jSONObject2.put(name, SDKUtils.mergeJSONObjects(jSONObjectA, jSONObject.getJSONObject(name)));
                } else {
                    jSONObject2.put(name, jSONObjectA);
                }
            } else if (c82.isDirectory()) {
                jSONObject2.put(c82.getName(), buildFilesMapOfDirectory(c82, jSONObject));
            }
        }
        return jSONObject2;
    }

    private static File c(Context context) {
        B7 b7I = Mb.U().i();
        C2559sf c2559sf = f10213b;
        return (c2559sf == null || !c2559sf.d()) ? b7I.j(context) : b7I.B(context);
    }

    public static void deleteCacheDirectories(Context context) {
        B7 b7I = Mb.U().i();
        a(b7I.l(context));
        a(b7I.B(context));
    }

    public static synchronized boolean deleteFile(C8 c8) {
        if (!c8.exists()) {
            return false;
        }
        return c8.delete();
    }

    public static void deleteFilesDirectories(Context context) {
        B7 b7I = Mb.U().i();
        a(b7I.f(context));
        a(b7I.j(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean deleteFolder(java.lang.String r2) {
        /*
            java.lang.Class<com.ironsource.sdk.utils.IronSourceStorageUtils> r0 = com.ironsource.sdk.utils.IronSourceStorageUtils.class
            monitor-enter(r0)
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L16
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L16
            boolean r2 = deleteFolderContentRecursive(r1)     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L18
            boolean r2 = r1.delete()     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L18
            r2 = 1
            goto L19
        L16:
            r2 = move-exception
            goto L1b
        L18:
            r2 = 0
        L19:
            monitor-exit(r0)
            return r2
        L1b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.utils.IronSourceStorageUtils.deleteFolder(java.lang.String):boolean");
    }

    public static boolean deleteFolderContentRecursive(File file) {
        File[] fileArrListFiles = file.listFiles();
        boolean zDeleteFolderContentRecursive = true;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    zDeleteFolderContentRecursive &= deleteFolderContentRecursive(file2);
                }
                if (!file2.delete()) {
                    zDeleteFolderContentRecursive = false;
                }
            }
        }
        return zDeleteFolderContentRecursive;
    }

    public static void ensurePathSafety(File file, String str) throws Exception {
        C2559sf c2559sf = f10213b;
        if (c2559sf == null || !c2559sf.e()) {
            String canonicalPath = new File(str).getCanonicalPath();
            String canonicalPath2 = file.getCanonicalPath();
            if (!canonicalPath2.startsWith(canonicalPath)) {
                throw new Exception(C2300e4.c.f8320u.concat(canonicalPath2));
            }
        }
    }

    public static String getCachedFilesMap(String str, String str2) {
        JSONObject jSONObjectBuildFilesMap = buildFilesMap(str, str2);
        try {
            jSONObjectBuildFilesMap.put("path", str2);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectBuildFilesMap.toString();
    }

    public static String getDiskCacheDirPath(Context context) {
        File fileB;
        if (!a() || !SDKUtils.isExternalStorageAvailable() || (fileB = b(context)) == null || !fileB.canWrite()) {
            return c(context).getPath();
        }
        f10214c = true;
        return fileB.getPath();
    }

    public static ArrayList<C8> getFilesInFolderRecursive(C8 c8) {
        if (c8 == null || !c8.isDirectory()) {
            return new ArrayList<>();
        }
        ArrayList<C8> arrayList = new ArrayList<>();
        File[] fileArrListFiles = c8.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                C8 c82 = new C8(file.getPath());
                if (c82.isDirectory()) {
                    arrayList.addAll(getFilesInFolderRecursive(c82));
                }
                if (c82.isFile()) {
                    arrayList.add(c82);
                }
            }
        }
        return arrayList;
    }

    public static String getNetworkStorageDir(Context context) {
        File fileB = b(new File(getDiskCacheDirPath(context)));
        if (!fileB.exists()) {
            fileB.mkdir();
        }
        return fileB.getPath();
    }

    public static long getTotalSizeOfDir(C8 c8) {
        long totalSizeOfDir;
        long j = 0;
        if (c8 != null && c8.isDirectory()) {
            File[] fileArrListFiles = c8.listFiles();
            if (fileArrListFiles == null) {
                return 0L;
            }
            for (File file : fileArrListFiles) {
                C8 c82 = new C8(file.getPath());
                if (c82.isFile()) {
                    totalSizeOfDir = c82.length();
                } else if (c82.isDirectory()) {
                    totalSizeOfDir = getTotalSizeOfDir(c82);
                }
                j = totalSizeOfDir + j;
            }
        }
        return j;
    }

    public static void initializeCacheDirectory(Context context, C2559sf c2559sf) {
        f10213b = c2559sf;
        a(context);
    }

    public static boolean isPathExist(String str, String str2) {
        return new File(str, str2).exists();
    }

    public static boolean isUxt() {
        return f10214c;
    }

    public static String makeDir(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static String readFile(C8 c8) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(c8));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    public static boolean renameFile(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    public static int saveFile(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[102400];
            int i2 = 0;
            while (true) {
                int i8 = byteArrayInputStream.read(bArr2);
                if (i8 == -1) {
                    return i2;
                }
                fileOutputStream.write(bArr2, 0, i8);
                i2 += i8;
            }
        } finally {
            fileOutputStream.close();
            byteArrayInputStream.close();
        }
    }

    private static void a(File file) {
        if (file != null) {
            deleteFolder(b(file).getPath());
        }
    }

    private static File b(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        String str = File.separator;
        return new File(a.s(sb, str, f10212a, str));
    }

    private static Object c(File file) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (file.isFile()) {
                jSONArray.put(file.getName());
                return jSONArray;
            }
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    jSONObject.put(file2.getName(), c(file2));
                } else {
                    jSONArray.put(file2.getName());
                    jSONObject.put("files", jSONArray);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }

    private static boolean a() {
        C2559sf c2559sf;
        return Build.VERSION.SDK_INT > 29 && (c2559sf = f10213b) != null && c2559sf.a();
    }
}

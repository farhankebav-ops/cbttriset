package com.pgl.ssdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.ironsource.Y1;
import com.pgl.ssdk.ces.out.PglSSCallBack;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f10761a = 28800;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f10762b = 5;

    public static long a(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[8192];
        long j3 = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return j3;
            }
            j3 += (long) i2;
        }
    }

    public static long b() {
        Context contextB = z.b();
        if (contextB == null) {
            return 0L;
        }
        long jA = w0.a(contextB, "pgl_frt", 0L);
        if (jA != 0) {
            return jA;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        w0.b(contextB, "pgl_frt", jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized void c() {
        if (d()) {
            String strC = v.c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            File file = new File(strC);
            if (file.exists()) {
                JSONObject jSONObjectA = a(file, true);
                jSONObjectA.put("apk_info", v.b());
                jSONObjectA.put("app_name", b0.d(z.b()));
                PglSSManager pglSSManager = PglSSManager.getInstance();
                if (pglSSManager == null) {
                    t0.a(String.valueOf(jSONObjectA));
                    return;
                }
                PglSSCallBack pglCallBack = pglSSManager.getPglCallBack();
                if (pglCallBack != null) {
                    pglCallBack.reportSoftDecData("detailed_app_info", jSONObjectA.toString());
                }
            }
        }
    }

    private static boolean d() {
        int iA = w0.a(z.b(), "pgl_is_hit", 0);
        t0.a("hitsTimes " + iA);
        if (iA > 0) {
            return false;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - b();
        t0.a("runningTime ".concat(String.valueOf(jCurrentTimeMillis)));
        if (jCurrentTimeMillis < f10761a) {
            return false;
        }
        w0.b(z.b(), "pgl_is_hit", 1);
        return e();
    }

    private static boolean e() {
        boolean z2 = f10762b == 100;
        return !z2 ? ((int) ((Math.random() * 100.0d) + 1.0d)) <= f10762b : z2;
    }

    public static void a(JSONObject jSONObject, String str, List<String> list, boolean z2) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z2) {
            try {
                jSONObject.put(str + "_size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, n.a(list));
    }

    private static JSONObject a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        a(jSONObject, "xml", arrayList, true);
        a(jSONObject, "png", arrayList2, true);
        a(jSONObject, Y1.f7807d, arrayList3, true);
        return jSONObject;
    }

    public static JSONObject a() throws JSONException {
        String[] strArr;
        Context contextB = z.b();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (contextB != null) {
            ApplicationInfo applicationInfo = contextB.getApplicationInfo();
            String str = applicationInfo.nativeLibraryDir;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                        for (File file2 : fileArrListFiles) {
                            arrayList.add(file2.getName());
                        }
                    }
                    if ("arm64".equals(file.getName())) {
                        a(jSONObject2, "v8a", arrayList, false);
                    } else {
                        a(jSONObject2, "v7a", arrayList, false);
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put("lib", jSONObject2);
                    }
                }
            }
            if (arrayList.isEmpty() && (strArr = applicationInfo.splitPublicSourceDirs) != null) {
                for (String str2 : strArr) {
                    if (str2.endsWith("armeabi-v7a.apk") || str2.endsWith("arm64_v8a.apk")) {
                        File file3 = new File(str2);
                        if (file3.exists()) {
                            return a(file3, false);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject a(File file, boolean z2) {
        ZipFile zipFile;
        int i2;
        char c7;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement != null) {
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) || !zipEntryNextElement.isDirectory()) {
                            String[] strArrSplit = name.split("/");
                            long size = zipEntryNextElement.getSize();
                            Enumeration<? extends ZipEntry> enumeration = enumerationEntries;
                            if (name.startsWith("res/drawable/")) {
                                i2 = 2;
                                if (name.length() > 13) {
                                    arrayList2.add(strArrSplit[2]);
                                }
                                enumerationEntries = enumeration;
                            } else {
                                i2 = 2;
                            }
                            if (name.startsWith("res/")) {
                                c7 = 1;
                                if (strArrSplit.length == i2) {
                                    arrayList3.add(strArrSplit[1]);
                                }
                                enumerationEntries = enumeration;
                            } else {
                                c7 = 1;
                            }
                            if (name.startsWith("assets/") && strArrSplit.length >= 2) {
                                arrayList.add(strArrSplit[c7]);
                                if (name.startsWith("assets/assets/resources/native/") && strArrSplit.length >= 6 && jSONObject2.length() < 10) {
                                    if (!TextUtils.isEmpty(strArrSplit[4]) && !jSONObject2.has(strArrSplit[4])) {
                                        jSONObject2.put(strArrSplit[4], a(size, zipFile.getInputStream(zipEntryNextElement)));
                                    } else if (jSONObject2.has(strArrSplit[4])) {
                                        jSONObject2.put(strArrSplit[4], a(size, zipFile.getInputStream(zipEntryNextElement)) + jSONObject2.getLong(strArrSplit[4]));
                                    }
                                }
                            } else if (name.startsWith("lib/armeabi/") && name.length() > 12) {
                                arrayList4.add(strArrSplit[2]);
                            } else if (name.startsWith("lib/armeabi-v7a/") && name.length() > 16) {
                                arrayList5.add(strArrSplit[2]);
                            } else if (name.startsWith("lib/arm64-v8a/") && name.length() > 14) {
                                arrayList6.add(strArrSplit[2]);
                            }
                            enumerationEntries = enumeration;
                        }
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                a(jSONObject3, "eabi", arrayList4, false);
                a(jSONObject3, "v7a", arrayList5, false);
                a(jSONObject3, "v8a", arrayList6, false);
                if (jSONObject3.length() > 0) {
                    jSONObject.put("lib", jSONObject3);
                }
                if (z2 && jSONObject3.length() <= 0) {
                    jSONObject = a();
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("cocos", jSONObject2);
                }
                a(jSONObject, "assets", arrayList, false);
                JSONObject jSONObjectA = a(arrayList2);
                if (jSONObjectA != null && jSONObjectA.length() > 0) {
                    jSONObject.put("drawable", jSONObjectA);
                }
                JSONObject jSONObjectA2 = a(arrayList3);
                if (jSONObjectA2 != null && jSONObjectA2.length() > 0) {
                    jSONObject.put("res", jSONObjectA2);
                }
            } catch (Throwable unused) {
                if (zipFile != null) {
                }
                return jSONObject;
            }
        } catch (Throwable unused2) {
            zipFile = null;
        }
        try {
            zipFile.close();
        } catch (IOException unused3) {
        }
        return jSONObject;
    }
}

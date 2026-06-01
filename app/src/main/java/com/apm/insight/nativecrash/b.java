package com.apm.insight.nativecrash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.apm.insight.ICommonParams;
import com.apm.insight.l.m;
import com.apm.insight.runtime.j;
import com.ironsource.C2605va;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICommonParams f4567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ICommonParams f4568c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a extends c {
        public a(File file) {
            super(file);
            this.f4570b = "Total FD Count:";
            this.f4571c = ":";
            this.f4572d = -2;
        }
    }

    /* JADX INFO: renamed from: com.apm.insight.nativecrash.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0017b extends c {
        public C0017b(File file) {
            super(file);
            this.f4570b = "VmSize:";
            this.f4571c = "\\s+";
            this.f4572d = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends c {
        public d(File file) {
            super(file);
        }

        @NonNull
        public final HashMap<String, List<String>> b() {
            HashMap<String, List<String>> map = new HashMap<>();
            try {
                JSONArray jSONArrayA = com.apm.insight.l.f.a(this.f4569a.getAbsolutePath());
                if (jSONArrayA != null) {
                    for (int i2 = 0; i2 < jSONArrayA.length(); i2++) {
                        String strOptString = jSONArrayA.optString(i2);
                        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("[tid:0") && strOptString.endsWith("sigstack:0x0]")) {
                            int iIndexOf = strOptString.indexOf("[routine:0x");
                            int i8 = iIndexOf + 11;
                            String strSubstring = iIndexOf > 0 ? strOptString.substring(i8, strOptString.indexOf(93, i8)) : "unknown addr";
                            List<String> arrayList = map.get(strSubstring);
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                                map.put(strSubstring, arrayList);
                            }
                            arrayList.add(strOptString);
                        }
                    }
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                com.apm.insight.c.a();
                j.a(th, "NPTH_CATCH");
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends c {
        public e(File file) {
            super(file);
        }

        @NonNull
        public final JSONArray a(HashMap<String, List<String>> map) {
            int iIndexOf;
            List<String> list;
            JSONArray jSONArray = new JSONArray();
            if (!map.isEmpty()) {
                try {
                    JSONArray jSONArrayA = com.apm.insight.l.f.a(this.f4569a.getAbsolutePath());
                    if (jSONArrayA != null) {
                        for (int i2 = 0; i2 < jSONArrayA.length(); i2++) {
                            String strOptString = jSONArrayA.optString(i2);
                            if (!TextUtils.isEmpty(strOptString) && (iIndexOf = strOptString.indexOf(":")) > 2) {
                                String strSubstring = strOptString.substring(2, iIndexOf);
                                if (map.containsKey(strSubstring) && (list = map.get(strSubstring)) != null) {
                                    Iterator<String> it = list.iterator();
                                    while (it.hasNext()) {
                                        jSONArray.put(it.next() + " " + strOptString);
                                    }
                                    map.remove(strSubstring);
                                }
                            }
                        }
                        Iterator<List<String>> it2 = map.values().iterator();
                        while (it2.hasNext()) {
                            Iterator<String> it3 = it2.next().iterator();
                            while (it3.hasNext()) {
                                jSONArray.put(it3.next() + "  0x000000:unknown");
                            }
                        }
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    j.a(th, "NPTH_CATCH");
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class f extends c {
        public f(File file) {
            super(file);
            this.f4570b = "Total Threads Count:";
            this.f4571c = ":";
            this.f4572d = -2;
        }
    }

    public b(Context context, ICommonParams iCommonParams) {
        this(context, iCommonParams, null);
    }

    @NonNull
    public static JSONArray a(File file, File file2) {
        return new e(file2).a(new d(file).b());
    }

    public static int b(String str) {
        return new f(com.apm.insight.l.j.c(str)).a();
    }

    public static int c(String str) {
        return new C0017b(com.apm.insight.l.j.d(str)).a();
    }

    public final String d() {
        try {
            return this.f4567b.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String e() {
        try {
            return String.valueOf(this.f4567b.getCommonParams().get(C2605va.f10440b));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    public final long f() {
        try {
            return this.f4567b.getUserId();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public b(Context context, ICommonParams iCommonParams, b bVar) {
        this.f4566a = context;
        this.f4567b = iCommonParams;
        this.f4568c = bVar == null ? null : bVar.f4567b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.HashMap] */
    @NonNull
    public final Map<String, Object> b() {
        Map<String, Object> map;
        Throwable th;
        ?? map2;
        try {
            ICommonParams iCommonParams = this.f4568c;
            Map<String, Object> commonParams = iCommonParams != null ? iCommonParams.getCommonParams() : new HashMap();
            try {
                commonParams.putAll(this.f4567b.getCommonParams());
                th = null;
                map2 = commonParams;
            } catch (Throwable th2) {
                map = commonParams;
                th = th2;
                Map<String, Object> map3 = map;
                th = th;
                map2 = map3;
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
        }
        if (map2 == 0) {
            map2 = new HashMap(4);
            if (th != null) {
                try {
                    map2.put("err_info", m.a(th));
                } catch (Throwable unused) {
                }
            }
        }
        if (a((Map<String, Object>) map2)) {
            try {
                PackageInfo packageInfo = this.f4566a.getPackageManager().getPackageInfo(this.f4566a.getPackageName(), 128);
                map2.put("version_name", packageInfo.versionName);
                map2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (map2.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = map2.get("version_code");
                    }
                    map2.put("update_version_code", obj);
                }
            } catch (Throwable unused2) {
                map2.put("version_name", com.apm.insight.l.a.d(this.f4566a));
                map2.put("version_code", Integer.valueOf(com.apm.insight.l.a.e(this.f4566a)));
                if (map2.get("update_version_code") == null) {
                    map2.put("update_version_code", map2.get("version_code"));
                }
            }
        } else {
            try {
                String str = this.f4566a.getPackageManager().getPackageInfo(this.f4566a.getPackageName(), 128).versionName;
                String str2 = (String) Class.forName(this.f4566a.getPackageName() + ".BuildConfig").getDeclaredField("VERSION_NAME").get(null);
                if (str != null && !str.equals(str2)) {
                    map2.put("manifest_version", str);
                }
            } catch (Throwable unused3) {
            }
        }
        return map2;
    }

    @NonNull
    public final ICommonParams c() {
        return this.f4567b;
    }

    public static int a(String str) {
        return new a(com.apm.insight.l.j.b(str)).a();
    }

    public final Map<String, Object> a() {
        Object obj;
        Map<String, Object> mapB = b();
        if (((mapB == null || (obj = mapB.get(C2605va.f10440b)) == null) ? null : String.valueOf(obj)) == null) {
            mapB.put(C2605va.f10440b, 4444);
        }
        return mapB;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected File f4569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f4570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected String f4571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected int f4572d;

        public c(File file) {
            this.f4569a = file;
        }

        public final int a() {
            int i2;
            Throwable th;
            if (!this.f4569a.exists() || !this.f4569a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f4569a));
                int iA = -1;
                do {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        iA = a(line);
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = iA;
                        bufferedReader = bufferedReader2;
                        try {
                            com.apm.insight.c.a();
                            j.a(th, "NPTH_CATCH");
                            return i2;
                        } finally {
                            if (bufferedReader != null) {
                                com.apm.insight.a.a((Closeable) bufferedReader);
                            }
                        }
                    }
                } while (iA == -1);
                com.apm.insight.a.a((Closeable) bufferedReader2);
                return iA;
            } catch (Throwable th3) {
                i2 = -1;
                th = th3;
            }
        }

        private int a(String str) {
            int i2 = this.f4572d;
            if (!str.startsWith(this.f4570b)) {
                return i2;
            }
            try {
                i2 = Integer.parseInt(str.split(this.f4571c)[1].trim());
            } catch (NumberFormatException e) {
                com.apm.insight.c.a();
                j.a(e, "NPTH_CATCH");
            }
            if (i2 < 0) {
                return -2;
            }
            return i2;
        }
    }

    public static boolean a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }
}

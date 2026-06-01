package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f4661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f4662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f4663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f4664d;
    private Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4665f = null;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private File f4670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f4671d;

        public /* synthetic */ a(File file, byte b8) {
            this(file);
        }

        public static /* synthetic */ void d(a aVar) {
            aVar.f4670c.delete();
        }

        private a(File file) {
            this.f4671d = null;
            this.f4670c = file;
            String[] strArrSplit = file.getName().split("-|\\.");
            if (strArrSplit.length >= 2) {
                this.f4668a = Long.parseLong(strArrSplit[0]);
                this.f4669b = Long.parseLong(strArrSplit[1]);
                return;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name) || name.length() < 13) {
                return;
            }
            String strSubstring = name.substring(0, 13);
            if (TextUtils.isDigitsOnly(strSubstring)) {
                long j = Long.parseLong(strSubstring);
                this.f4668a = j;
                this.f4669b = j;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject a() {
            if (this.f4671d == null) {
                try {
                    this.f4671d = new JSONObject(com.apm.insight.l.f.a(this.f4670c.getAbsolutePath(), "\n"));
                } catch (Throwable unused) {
                }
                if (this.f4671d == null) {
                    this.f4671d = new JSONObject();
                }
            }
            return this.f4671d;
        }

        public static /* synthetic */ boolean a(a aVar, long j) {
            long j3 = aVar.f4668a;
            if (j3 > j && j3 - j > 604800000) {
                return true;
            }
            long j8 = aVar.f4669b;
            if (j8 >= j || j - j8 <= 604800000) {
                return aVar.f4670c.lastModified() < j && j - aVar.f4670c.lastModified() > 604800000;
            }
            return true;
        }
    }

    private o(Context context) {
        File fileC = com.apm.insight.l.j.c(context);
        if (!fileC.exists() || (!fileC.isDirectory() && fileC.delete())) {
            fileC.mkdirs();
            com.apm.insight.runtime.a.b.a();
        }
        this.f4662b = fileC;
        this.f4663c = new File(fileC, "did");
        this.f4664d = new File(fileC, "device_uuid");
        this.e = context;
    }

    public static o a() {
        if (f4661a == null) {
            f4661a = new o(com.apm.insight.e.g());
        }
        return f4661a;
    }

    public final String b() {
        try {
            return com.apm.insight.l.f.a(this.f4663c.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return "0";
        }
    }

    public final String c() {
        try {
            return com.apm.insight.l.f.a(this.f4664d.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return null;
        }
    }

    private ArrayList<a> c(final String str) {
        File[] fileArrListFiles = this.f4662b.listFiles(new FilenameFilter() { // from class: com.apm.insight.runtime.o.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.endsWith(str) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str2).matches();
            }
        });
        ArrayList<a> arrayList = new ArrayList<>();
        if (fileArrListFiles != null) {
            com.apm.insight.a.a((Object) ("foundRuntimeContextFiles " + fileArrListFiles.length));
            byte b8 = 0;
            a aVar = null;
            for (File file : fileArrListFiles) {
                try {
                    a aVar2 = new a(file, b8);
                    arrayList.add(aVar2);
                    if (this.f4665f == null && ".ctx".equals(str) && (aVar == null || aVar2.f4669b >= aVar.f4669b)) {
                        aVar = aVar2;
                    }
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    j.a(th, "NPTH_CATCH");
                }
            }
            if (this.f4665f == null && aVar != null) {
                this.f4665f = aVar;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.Map<java.lang.String, java.lang.Object> r9, org.json.JSONArray r10) {
        /*
            r8 = this;
            android.content.Context r0 = r8.e
            com.apm.insight.entity.Header r0 = com.apm.insight.entity.Header.a(r0)
            org.json.JSONObject r6 = r0.a(r9)
            boolean r9 = com.apm.insight.entity.Header.c(r6)
            if (r9 == 0) goto L13
            r1 = r8
            goto L9d
        L13:
            long r2 = java.lang.System.currentTimeMillis()
            com.apm.insight.runtime.o$a r9 = r8.f4665f
            if (r9 != 0) goto L20
            java.lang.String r9 = ".ctx"
            r8.c(r9)
        L20:
            com.apm.insight.runtime.o$a r9 = r8.f4665f
            if (r9 != 0) goto L2b
            r4 = r2
            r1 = r8
            r7 = r10
            r1.a(r2, r4, r6, r7)
            return
        L2b:
            r7 = r10
            org.json.JSONObject r10 = com.apm.insight.runtime.o.a.a(r9)
            boolean r0 = com.apm.insight.entity.Header.c(r10)
            if (r0 != 0) goto L6e
            boolean r0 = com.apm.insight.entity.Header.c(r6)
            if (r0 == 0) goto L3e
            r1 = r8
            goto L73
        L3e:
            java.lang.String r0 = "update_version_code"
            java.lang.Object r1 = r6.opt(r0)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object r0 = r10.opt(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6e
            boolean r10 = com.apm.insight.entity.Header.d(r10)
            if (r10 == 0) goto L6e
            r4 = r2
            long r2 = com.apm.insight.runtime.o.a.b(r9)
            r1 = r8
            r1.a(r2, r4, r6, r7)
            r2 = r4
            java.io.File r9 = com.apm.insight.runtime.o.a.c(r9)
            com.apm.insight.l.f.a(r9)
            goto L73
        L6e:
            r4 = r2
            r1 = r8
            r1.a(r2, r4, r6, r7)
        L73:
            java.lang.String r9 = ""
            java.util.ArrayList r9 = r8.c(r9)     // Catch: java.lang.Throwable -> L9a
            int r10 = r9.size()     // Catch: java.lang.Throwable -> L9a
            r0 = 6
            if (r10 > r0) goto L81
            goto L9d
        L81:
            int r10 = r9.size()     // Catch: java.lang.Throwable -> L9a
            r0 = 0
        L86:
            if (r0 >= r10) goto L9d
            java.lang.Object r4 = r9.get(r0)     // Catch: java.lang.Throwable -> L9a
            int r0 = r0 + 1
            com.apm.insight.runtime.o$a r4 = (com.apm.insight.runtime.o.a) r4     // Catch: java.lang.Throwable -> L9a
            boolean r5 = com.apm.insight.runtime.o.a.a(r4, r2)     // Catch: java.lang.Throwable -> L9a
            if (r5 == 0) goto L86
            com.apm.insight.runtime.o.a.d(r4)     // Catch: java.lang.Throwable -> L9a
            goto L86
        L9a:
            r0 = move-exception
            r9 = r0
            goto L9e
        L9d:
            return
        L9e:
            com.apm.insight.c.a()
            java.lang.String r10 = "NPTH_CATCH"
            com.apm.insight.runtime.j.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.o.a(java.util.Map, org.json.JSONArray):void");
    }

    public final void b(String str) {
        try {
            com.apm.insight.l.f.a(this.f4664d, str, false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final JSONArray b(long j) {
        File file;
        String strA;
        ArrayList<a> arrayListC = c(".allData");
        int size = arrayListC.size();
        int i2 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                file = null;
                break;
            }
            a aVar = arrayListC.get(i8);
            i8++;
            a aVar2 = aVar;
            if (j >= aVar2.f4668a && j <= aVar2.f4669b) {
                file = aVar2.f4670c;
                break;
            }
        }
        if (file == null) {
            ArrayList<a> arrayListC2 = c(".allData");
            int size2 = arrayListC2.size();
            a aVar3 = null;
            while (i2 < size2) {
                a aVar4 = arrayListC2.get(i2);
                i2++;
                a aVar5 = aVar4;
                if (aVar3 == null || Math.abs(aVar3.f4669b - j) > Math.abs(aVar5.f4669b - j)) {
                    aVar3 = aVar5;
                }
            }
            file = aVar3 == null ? null : aVar3.f4670c;
        }
        if (file != null) {
            try {
                strA = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
            } catch (Throwable th) {
                th = th;
                strA = null;
            }
            try {
                return new JSONArray(strA);
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.c.a();
                j.a(new IOException("content :".concat(String.valueOf(strA)), th), "NPTH_CATCH");
                return null;
            }
        }
        return null;
    }

    private void a(long j, long j3, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.f4662b, j + "-" + j3 + ".ctx");
        File file2 = new File(this.f4662b, j + "-" + j3 + ".allData");
        try {
            com.apm.insight.l.f.a(file, jSONObject);
            com.apm.insight.l.f.a(file2, jSONArray);
            this.f4665f = new a(file, (byte) 0);
        } catch (IOException e) {
            com.apm.insight.c.a();
            j.a(e, "NPTH_CATCH");
        }
    }

    public final void a(String str) {
        try {
            com.apm.insight.l.f.a(this.f4663c, str, false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final JSONObject a(long j) {
        JSONObject jSONObject;
        File file;
        String strA;
        ArrayList<a> arrayListC = c(".ctx");
        int size = arrayListC.size();
        int i2 = 0;
        int i8 = 0;
        while (true) {
            jSONObject = null;
            if (i8 >= size) {
                file = null;
                break;
            }
            a aVar = arrayListC.get(i8);
            i8++;
            a aVar2 = aVar;
            if (j >= aVar2.f4668a && j <= aVar2.f4669b) {
                file = aVar2.f4670c;
                break;
            }
        }
        if (file == null) {
            ArrayList<a> arrayListC2 = c(".ctx");
            int size2 = arrayListC2.size();
            a aVar3 = null;
            while (i2 < size2) {
                a aVar4 = arrayListC2.get(i2);
                i2++;
                a aVar5 = aVar4;
                if (aVar3 == null || Math.abs(aVar3.f4669b - j) > Math.abs(aVar5.f4669b - j)) {
                    aVar3 = aVar5;
                }
            }
            file = aVar3 == null ? null : aVar3.f4670c;
            i2 = 1;
        }
        if (file != null) {
            try {
                strA = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
            } catch (Throwable th) {
                th = th;
                strA = null;
            }
            try {
                jSONObject = new JSONObject(strA);
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.c.a();
                j.a(new IOException("content :".concat(String.valueOf(strA)), th), "NPTH_CATCH");
            }
        }
        if (jSONObject != null && i2 != 0) {
            try {
                jSONObject.put("unauthentic_version", 1);
            } catch (JSONException e) {
                com.apm.insight.c.a();
                j.a(e, "NPTH_CATCH");
            }
        }
        return jSONObject;
    }
}

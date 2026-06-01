package b0;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4119d;
    public String e;

    public static HashSet a() {
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar;
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar2;
        HashSet hashSet = new HashSet();
        for (a0.a aVar3 : a0.a.e.values()) {
            if (aVar3 != null && (aVar2 = aVar3.f3202d) != null) {
                hashSet.add(n7.b.c(aVar2.Cc(), aVar2.cl()).getAbsolutePath());
                hashSet.add(n7.b.a(aVar2.Cc(), aVar2.cl()).getAbsolutePath());
            }
        }
        for (c0.c cVar : c0.a.f4160a.values()) {
            if (cVar != null && (aVar = cVar.f4164b) != null) {
                hashSet.add(n7.b.c(aVar.Cc(), aVar.cl()).getAbsolutePath());
                hashSet.add(n7.b.a(aVar.Cc(), aVar.cl()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    public final String b() {
        if (this.e == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4116a);
            this.e = a1.a.r(sb, File.separator, "video_default");
            File file = new File(this.e);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.e;
    }

    public final String c() {
        if (this.f4117b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4116a);
            this.f4117b = a1.a.r(sb, File.separator, "video_reward_full");
            File file = new File(this.f4117b);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f4117b;
    }

    public final String d() {
        if (this.f4119d == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4116a);
            this.f4119d = a1.a.r(sb, File.separator, "video_splash");
            File file = new File(this.f4119d);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f4119d;
    }

    public final synchronized void e() {
        try {
            ArrayList arrayListF = f();
            int size = arrayListF.size();
            HashSet hashSetA = null;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListF.get(i2);
                i2++;
                u.a aVar = (u.a) obj;
                File[] fileArr = aVar.f17514a;
                if (fileArr != null && fileArr.length >= aVar.f17515b) {
                    if (hashSetA == null) {
                        hashSetA = a();
                    }
                    int i8 = aVar.f17515b - 2;
                    if (i8 < 0) {
                        i8 = 0;
                    }
                    File[] fileArr2 = aVar.f17514a;
                    if (i8 >= 0 && fileArr2 != null) {
                        try {
                            if (fileArr2.length > i8) {
                                List listAsList = Arrays.asList(fileArr2);
                                Collections.sort(listAsList, new a(0));
                                while (i8 < listAsList.size()) {
                                    if (!hashSetA.contains(((File) listAsList.get(i8)).getAbsolutePath())) {
                                        ((File) listAsList.get(i8)).delete();
                                    }
                                    i8++;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u.a(new File(c()).listFiles(), z5.b.f17988c));
        arrayList.add(new u.a(new File(d()).listFiles(), z5.b.f17987b));
        if (this.f4118c == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4116a);
            this.f4118c = a1.a.r(sb, File.separator, "video_brand");
            File file = new File(this.f4118c);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        arrayList.add(new u.a(new File(this.f4118c).listFiles(), z5.b.f17989d));
        arrayList.add(new u.a(new File(b()).listFiles(), z5.b.e));
        return arrayList;
    }
}

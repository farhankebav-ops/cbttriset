package com.bykv.vk.openvk.preload.geckox.a;

import com.bykv.vk.openvk.preload.geckox.utils.f;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public c(Field field) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(field);
    }

    public static void a(final String str) {
        f.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c.c(str);
                } catch (Throwable th) {
                    com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException("delete old channel version failed，path：" + str, th));
                }
            }
        });
    }

    public static boolean b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("update.lock");
            com.bykv.vk.openvk.preload.geckox.g.a aVarA = com.bykv.vk.openvk.preload.geckox.g.a.a(sb.toString());
            if (aVarA == null) {
                return true;
            }
            try {
                com.bykv.vk.openvk.preload.geckox.g.b bVarA = com.bykv.vk.openvk.preload.geckox.g.b.a(str + str2 + "select.lock");
                try {
                    com.bykv.vk.openvk.preload.geckox.utils.b.c(new File(str));
                } catch (Throwable unused) {
                }
                bVarA.a();
                return true;
            } finally {
                aVarA.a();
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static /* synthetic */ void c(String str) throws Exception {
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(str);
        String str2 = File.separator;
        sbR.append(str2);
        sbR.append("update.lock");
        com.bykv.vk.openvk.preload.geckox.g.a aVarA = com.bykv.vk.openvk.preload.geckox.g.a.a(sbR.toString());
        if (aVarA != null) {
            try {
                com.bykv.vk.openvk.preload.geckox.g.b bVarA = com.bykv.vk.openvk.preload.geckox.g.b.a(str + str2 + "select.lock");
                try {
                    File[] fileArrListFiles = new File(str).listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.2
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    List<File> listA = (fileArrListFiles == null || fileArrListFiles.length == 0 || fileArrListFiles.length == 1) ? null : a(fileArrListFiles);
                    if (listA != null && !listA.isEmpty()) {
                        Iterator<File> it = listA.iterator();
                        while (it.hasNext()) {
                            com.bykv.vk.openvk.preload.geckox.g.c.c(it.next().getAbsolutePath() + File.separator + "using.lock");
                        }
                        bVarA.a();
                    }
                } finally {
                    bVarA.a();
                }
            } finally {
                aVarA.a();
            }
        }
    }

    private static List<File> a(File[] fileArr) {
        long j;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        File file = null;
        long j3 = -1;
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (name.endsWith("--updating")) {
                arrayList.add(file2);
            } else if (name.endsWith("--pending-delete")) {
                a(file2);
            } else {
                try {
                    long j8 = Long.parseLong(name);
                    if (j8 > j3) {
                        if (file != null) {
                            try {
                                arrayList2.add(file);
                            } catch (Exception unused) {
                                j3 = j8;
                                a(file2);
                            }
                        }
                        file = file2;
                        j3 = j8;
                    } else {
                        arrayList2.add(file2);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            File file3 = (File) obj;
            String name2 = file3.getName();
            int iIndexOf = name2.indexOf("--updating");
            if (iIndexOf == -1) {
                a(file3);
            } else {
                try {
                    j = Long.parseLong(name2.substring(0, iIndexOf));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    j = -1;
                }
                if (j <= j3) {
                    a(file3);
                }
            }
        }
        return arrayList2;
    }

    private static void a(final File file) {
        com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
            }
        });
    }
}

package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class BsPatch {
    static {
        System.loadLibrary("geckox_bspatch");
    }

    public static void a(File file, File file2, File file3, String str) throws Exception {
        if (!file.exists()) {
            throw new FileNotFoundException("full package not exist：" + file.getAbsolutePath());
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("patch package not exist：" + file2.getAbsolutePath());
        }
        file3.mkdirs();
        File file4 = new File(file3, str);
        file4.delete();
        int iPatch = patch(file.getAbsolutePath(), file4.getAbsolutePath(), file2.getAbsolutePath());
        if (iPatch == 0) {
            return;
        }
        StringBuilder sbV = a1.a.v(iPatch, "patch merged failed, code：", " full:");
        sbV.append(file.getAbsolutePath());
        sbV.append(" patch:");
        sbV.append(file2.getAbsolutePath());
        sbV.append(" dest:");
        sbV.append(file4.getAbsolutePath());
        throw new RuntimeException(sbV.toString());
    }

    private static native int patch(String str, String str2, String str3) throws Exception;
}

package com.bytedance.sdk.component.adexpress.IlO.MY;

import com.ironsource.G5;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static com.bytedance.sdk.component.adexpress.IlO.EO.IlO IlO;

    public static void EO() {
        EO.IlO(Cc.lEW(), MY(), "temp_pkg_info.json");
    }

    public static void IlO() {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(Cc.lEW(), "temp_pkg_info.json");
                long length = file.length();
                Long lValueOf = Long.valueOf(length);
                if (length > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileInputStream2.read(bArr);
                        com.bytedance.sdk.component.adexpress.IlO.EO.IlO IlO2 = com.bytedance.sdk.component.adexpress.IlO.EO.IlO.IlO(new JSONObject(new String(bArr, G5.N)));
                        if (IlO2 != null) {
                            IlO = IlO2;
                            IlO2.EO();
                        }
                        fileInputStream = fileInputStream2;
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return;
                        }
                        return;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable unused2) {
            }
        } catch (IOException unused3) {
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.IlO.EO.IlO MY() {
        return IlO;
    }

    public static void tV() {
        EO.MY(Cc.lEW(), MY(), "temp_pkg_info.json");
        IlO = null;
    }

    public static boolean MY(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO) {
        return EO.EO(MY(), ilO);
    }

    public static synchronized void IlO(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO) {
        if (ilO != null) {
            if (ilO.lEW()) {
                IlO = ilO;
            }
        }
    }

    public static boolean IlO(String str) {
        return EO.IlO(MY(), str);
    }
}

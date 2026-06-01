package com.bytedance.sdk.component.Bc.MY;

import a1.a;
import android.text.TextUtils;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.rp;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends EO {
    public File IlO;
    public File MY;
    private volatile boolean NV;

    public IlO(EV ev) {
        super(ev);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Bc(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Cc(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long vCE(Map<String, String> map) {
        String str = map.containsKey("content-length") ? map.get("content-length") : map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        if (!TextUtils.isEmpty(str) && str != null) {
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public void IlO(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.IlO = new File(str, str2);
        this.MY = new File(str, a.C(str2, ".temp"));
    }

    @Override // com.bytedance.sdk.component.Bc.MY.EO
    public void MY() {
        this.NV = true;
        super.MY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        try {
            this.IlO.delete();
        } catch (Throwable unused) {
        }
        try {
            this.MY.delete();
        } catch (Throwable unused2) {
        }
    }

    public void IlO(final com.bytedance.sdk.component.Bc.IlO.IlO ilO) {
        File file = this.IlO;
        if (file == null || this.MY == null) {
            if (ilO != null) {
                ilO.IlO(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.IlO.length() != 0 && ilO != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.Bc.MY my = new com.bytedance.sdk.component.Bc.MY(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            my.IlO(this.IlO);
            ilO.IlO(this, my);
            return;
        }
        long length = this.MY.length();
        final long j = length >= 0 ? length : 0L;
        rp.IlO ilO2 = new rp.IlO();
        ilO2.IlO((Object) EO());
        MY("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.lEW)) {
            ilO.IlO(this, new IOException("Url is Empty"));
            return;
        }
        try {
            ilO2.MY(this.lEW);
            if (!TextUtils.isEmpty(this.Cc)) {
                ilO2.IlO(this.Cc);
            }
            int i2 = this.vCE;
            if (i2 > 0) {
                ilO2.IlO(i2);
            }
            IlO(ilO2);
            com.bytedance.sdk.component.MY.IlO.MY myIlO = this.EO.IlO(ilO2.IlO().MY());
            if (myIlO == null) {
                ilO.IlO(this, new IOException("new call error"));
            } else {
                myIlO.IlO(new com.bytedance.sdk.component.MY.IlO.EO() { // from class: com.bytedance.sdk.component.Bc.MY.IlO.1
                    @Override // com.bytedance.sdk.component.MY.IlO.EO
                    public void IlO(com.bytedance.sdk.component.MY.IlO.MY my2, IOException iOException) {
                        com.bytedance.sdk.component.Bc.IlO.IlO ilO3 = ilO;
                        if (ilO3 != null) {
                            ilO3.IlO(IlO.this, iOException);
                        }
                        IlO.this.Cc();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:127:0x017f A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x014f A[Catch: all -> 0x013b, TryCatch #6 {all -> 0x013b, blocks: (B:44:0x0122, B:46:0x0130, B:48:0x0134, B:51:0x013e, B:52:0x0145, B:54:0x014f, B:56:0x015b, B:59:0x016c, B:62:0x0177, B:63:0x017e, B:58:0x0163, B:65:0x0181, B:67:0x0189, B:70:0x0195, B:72:0x019f, B:74:0x01ab, B:76:0x01b7, B:77:0x01c6, B:78:0x01d3, B:81:0x01ed), top: B:120:0x0122 }] */
                    @Override // com.bytedance.sdk.component.MY.IlO.EO
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void IlO(com.bytedance.sdk.component.MY.IlO.MY r21, com.bytedance.sdk.component.MY.IlO.bWL r22) throws java.io.IOException {
                        /*
                            Method dump skipped, instruction units count: 567
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Bc.MY.IlO.AnonymousClass1.IlO(com.bytedance.sdk.component.MY.IlO.MY, com.bytedance.sdk.component.MY.IlO.bWL):void");
                    }
                });
            }
        } catch (IllegalArgumentException unused) {
            ilO.IlO(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0133 A[PHI: r10
  0x0133: PHI (r10v4 long) = (r10v3 long), (r10v8 long) binds: [B:41:0x00f9, B:44:0x0108] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.Bc.MY IlO() {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Bc.MY.IlO.IlO():com.bytedance.sdk.component.Bc.MY");
    }
}

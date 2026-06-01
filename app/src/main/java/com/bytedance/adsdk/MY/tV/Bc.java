package com.bytedance.adsdk.MY.tV;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private final Cc IlO;

    public Bc(Cc cc) {
        this.IlO = cc;
    }

    private File MY(String str) throws FileNotFoundException {
        File file = new File(IlO(), IlO(str, EO.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(IlO(), IlO(str, EO.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public Pair<EO, InputStream> IlO(String str) {
        try {
            File fileMY = MY(str);
            if (fileMY == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileMY);
            EO eo = fileMY.getAbsolutePath().endsWith(".zip") ? EO.ZIP : EO.JSON;
            fileMY.getAbsolutePath();
            return new Pair<>(eo, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File IlO(String str, InputStream inputStream, EO eo) throws IOException {
        File file = new File(IlO(), IlO(str, eo, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 != -1) {
                        fileOutputStream.write(bArr, 0, i2);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    public void IlO(String str, EO eo) {
        File file = new File(IlO(), IlO(str, eo, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        file2.toString();
        if (zRenameTo) {
            return;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
    }

    private File IlO() {
        File fileIlO = this.IlO.IlO();
        if (fileIlO.isFile()) {
            fileIlO.delete();
        }
        if (!fileIlO.exists()) {
            fileIlO.mkdirs();
        }
        return fileIlO;
    }

    private static String IlO(String str, EO eo, boolean z2) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z2 ? eo.IlO() : eo.EO);
        return sb.toString();
    }
}

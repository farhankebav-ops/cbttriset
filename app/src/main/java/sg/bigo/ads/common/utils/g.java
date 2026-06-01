package sg.bigo.ads.common.utils;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0055: MOVE (r7 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:19:0x0055 */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(java.io.File r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.g.b(java.io.File):byte[]");
    }

    @NonNull
    public static String a(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    String string = byteArrayOutputStream.toString();
                    a((Closeable) inputStream);
                    a(byteArrayOutputStream);
                    return string;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException unused2) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            a((Closeable) inputStream);
            if (byteArrayOutputStream2 != null) {
                a(byteArrayOutputStream2);
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a((Closeable) inputStream);
            if (byteArrayOutputStream2 != null) {
                a(byteArrayOutputStream2);
            }
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}

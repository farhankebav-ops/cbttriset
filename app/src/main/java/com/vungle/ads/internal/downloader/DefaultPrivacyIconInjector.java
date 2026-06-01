package com.vungle.ads.internal.downloader;

import android.util.Base64;
import androidx.annotation.WorkerThread;
import com.vungle.ads.internal.Constants;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.internal.k;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DefaultPrivacyIconInjector {
    public static final DefaultPrivacyIconInjector INSTANCE = new DefaultPrivacyIconInjector();

    private DefaultPrivacyIconInjector() {
    }

    private final boolean writePrivacyFileFromString(File file) {
        Object objM;
        try {
            byte[] bArrDecode = Base64.decode(Constants.LO_PRIVACY_ICON_STRING, 0);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
                objM = Boolean.TRUE;
            } finally {
            }
        } catch (Throwable th) {
            objM = q.M(th);
        }
        Object obj = Boolean.FALSE;
        if (objM instanceof j) {
            objM = obj;
        }
        return ((Boolean) objM).booleanValue();
    }

    @WorkerThread
    public final File injectPrivacyIcon(File dir) {
        k.e(dir, "dir");
        File file = new File(dir, Constants.PRIVACY_ICON_FILE_NAME);
        if (file.exists() || writePrivacyFileFromString(file)) {
            return file;
        }
        return null;
    }
}

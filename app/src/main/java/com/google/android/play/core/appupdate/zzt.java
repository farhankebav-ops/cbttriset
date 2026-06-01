package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzt {
    private final Context zza;

    public zzt(Context context) {
        this.zza = context;
    }

    private static long zzb(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        long jZzb = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                jZzb += zzb(file2);
            }
        }
        return jZzb;
    }

    public final long zza() {
        return zzb(new File(this.zza.getFilesDir(), "assetpacks"));
    }
}

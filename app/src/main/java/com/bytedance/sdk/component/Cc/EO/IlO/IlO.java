package com.bytedance.sdk.component.Cc.EO.IlO;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.unity3d.services.core.di.ServiceProvider;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.sdk.component.Cc.MY, Cloneable {
    private static volatile com.bytedance.sdk.component.Cc.MY vCE;
    private File Cc;
    private boolean EO;
    private long IlO;
    private int MY;
    private boolean tV;

    public IlO(int i2, long j, File file) {
        this(i2, j, i2 != 0, j != 0, file);
    }

    private static long EV() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static com.bytedance.sdk.component.Cc.MY NV() {
        return vCE;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean Bc() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean Cc() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean DmF() {
        return true;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public int EO() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public long IlO() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public int MY() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public File lEW() {
        return this.Cc;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public int tV() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean vCE() {
        return false;
    }

    public IlO(int i2, long j, boolean z2, boolean z7, File file) {
        this.IlO = j;
        this.MY = i2;
        this.EO = z2;
        this.tV = z7;
        this.Cc = file;
    }

    public static void IlO(Context context, com.bytedance.sdk.component.Cc.MY my) {
        if (my != null) {
            vCE = my;
        } else {
            vCE = IlO(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.Cc.MY IlO(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (vCE == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            jMin = Math.min(EV() / 16, 41943040L);
        } else {
            iMin = Math.min(vCE.MY() / 2, 31457280);
            jMin = Math.min(vCE.IlO() / 2, 41943040L);
        }
        return new IlO(Math.max(iMin, 26214400), Math.max(jMin, ServiceProvider.HTTP_CACHE_DISK_SIZE), file);
    }
}

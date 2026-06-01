package com.bytedance.sdk.component.Cc.tV.EO.IlO;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements com.bytedance.sdk.component.Cc.MY, Cloneable {
    private static volatile com.bytedance.sdk.component.Cc.MY DmF;
    private boolean Bc;
    private boolean Cc;
    private int EO;
    private long IlO;
    private int MY;
    private File lEW;
    private int tV;
    private boolean vCE;

    public MY(int i2, int i8, int i9, long j, File file) {
        this(i2, i8, i9, j, i8 != 0, j != 0, file);
    }

    public static com.bytedance.sdk.component.Cc.MY NV() {
        return DmF;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean Bc() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean Cc() {
        return this.Cc;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean DmF() {
        return true;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public int EO() {
        return this.EO;
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
        return this.lEW;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public int tV() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.component.Cc.MY
    public boolean vCE() {
        return this.Bc;
    }

    public MY(int i2, int i8, int i9, long j, boolean z2, boolean z7, File file) {
        this.IlO = j;
        this.MY = i2;
        this.EO = i8;
        this.tV = i9;
        this.Cc = z2;
        this.vCE = z7;
        this.lEW = file;
        this.Bc = i9 != 0;
    }

    public static void IlO(Context context, com.bytedance.sdk.component.Cc.MY my) {
        if (my != null) {
            DmF = my;
        } else {
            DmF = IlO(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.Cc.MY IlO(File file) {
        long jIlO;
        int iEO;
        int iTV;
        file.mkdirs();
        if (DmF == null) {
            iEO = 10;
            iTV = 14;
            jIlO = 20;
        } else {
            jIlO = DmF.IlO();
            iEO = DmF.EO();
            iTV = DmF.tV();
        }
        return new MY(0, iEO, iTV, jIlO, file);
    }
}

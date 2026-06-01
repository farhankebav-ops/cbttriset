package com.bytedance.sdk.component.Bc;

import com.bytedance.sdk.component.MY.IlO.NV;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    NV Bc;
    final long Cc;
    private final boolean DmF;
    final Map<String, String> EO;
    final int IlO;
    final String MY;
    final String tV;
    final long vCE;
    private File lEW = null;
    private byte[] NV = null;

    public MY(boolean z2, int i2, String str, Map<String, String> map, String str2, long j, long j3) {
        this.DmF = z2;
        this.IlO = i2;
        this.MY = str;
        this.EO = map;
        this.tV = str2;
        this.Cc = j;
        this.vCE = j3;
    }

    public NV Bc() {
        return this.Bc;
    }

    public File Cc() {
        return this.lEW;
    }

    public Map<String, String> EO() {
        return this.EO;
    }

    public int IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.MY;
    }

    public String tV() {
        return this.tV;
    }

    public boolean vCE() {
        return this.DmF;
    }

    public void IlO(File file) {
        this.lEW = file;
    }

    public void IlO(byte[] bArr) {
        this.NV = bArr;
    }

    public void IlO(NV nv) {
        this.Bc = nv;
    }
}

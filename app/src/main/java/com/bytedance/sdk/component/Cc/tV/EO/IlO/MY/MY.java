package com.bytedance.sdk.component.Cc.tV.EO.IlO.MY;

import com.bytedance.sdk.component.Cc.es;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements es {
    private int EO;
    private long IlO = 1048576;
    private int MY;
    private com.bytedance.sdk.component.Cc.tV.EO.IlO.EO<String, byte[]> tV;

    public MY(int i2, int i8) {
        this.EO = i2;
        this.MY = i8;
        this.tV = new com.bytedance.sdk.component.Cc.tV.EO.IlO.EO<>(i8);
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean MY(String str) {
        return this.tV.IlO(str) != null;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean IlO(String str, byte[] bArr) {
        if (str != null && bArr != null) {
            try {
                if (bArr.length > this.IlO) {
                    return false;
                }
                this.tV.IlO(str, bArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public byte[] IlO(String str) {
        try {
            return this.tV.IlO(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}

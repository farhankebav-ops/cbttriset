package com.bytedance.sdk.component.Cc.tV.EO.IlO.IlO;

import com.bytedance.sdk.component.Cc.EO;
import com.bytedance.sdk.component.utils.NV;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements EO {
    private int IlO;
    private IlO MY;

    public MY(File file, long j) {
        int i2 = (int) j;
        this.IlO = i2;
        this.MY = IlO.IlO(i2, file);
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public boolean MY(String str) {
        try {
            InputStream inputStreamIlO = this.MY.IlO(str);
            boolean z2 = inputStreamIlO != null;
            NV.IlO(inputStreamIlO);
            return z2;
        } catch (Throwable th) {
            try {
                th.getMessage();
                return false;
            } finally {
                NV.IlO(null);
            }
        }
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    /* JADX INFO: renamed from: MY, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] IlO(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStreamIlO;
        IlO ilO = this.MY;
        if (ilO != null && str != null) {
            try {
                inputStreamIlO = ilO.IlO(str);
                if (inputStreamIlO != null) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException unused) {
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        NV.IlO(inputStreamIlO);
                        NV.IlO(byteArrayOutputStream);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i2 = inputStreamIlO.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        NV.IlO(inputStreamIlO);
                        NV.IlO(byteArrayOutputStream);
                        throw th;
                    }
                } else {
                    byteArrayOutputStream = null;
                }
                if (byteArrayOutputStream != null) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    NV.IlO(inputStreamIlO);
                    NV.IlO(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (IOException unused3) {
                inputStreamIlO = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                inputStreamIlO = null;
            }
            NV.IlO(inputStreamIlO);
            NV.IlO(byteArrayOutputStream);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.Cc.EO
    public InputStream IlO(String str) {
        IlO ilO = this.MY;
        if (ilO == null) {
            return null;
        }
        return ilO.IlO(str);
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean IlO(String str, byte[] bArr) {
        IlO ilO = this.MY;
        if (ilO == null || bArr == null || str == null) {
            return false;
        }
        return ilO.IlO(str, bArr);
    }
}

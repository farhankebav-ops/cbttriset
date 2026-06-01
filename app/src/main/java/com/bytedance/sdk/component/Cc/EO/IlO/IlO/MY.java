package com.bytedance.sdk.component.Cc.EO.IlO.IlO;

import android.util.Log;
import com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO;
import com.bytedance.sdk.component.utils.NV;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements com.bytedance.sdk.component.Cc.EO {
    private long IlO;
    private IlO MY;

    public MY(File file, long j, ExecutorService executorService) {
        this.IlO = j;
        try {
            this.MY = IlO.IlO(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public boolean MY(String str) {
        try {
            try {
                IlO.EO eoIlO = this.MY.IlO(str);
                boolean z2 = eoIlO != null;
                NV.IlO(eoIlO);
                return z2;
            } catch (IOException e) {
                Log.w("LruCountDiskCache", e.getMessage());
                NV.IlO(null);
                return false;
            }
        } catch (Throwable th) {
            NV.IlO(null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // com.bytedance.sdk.component.Cc.IlO
    /* JADX INFO: renamed from: MY, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] IlO(String str) throws Throwable {
        Closeable closeable;
        ?? r7;
        ByteArrayOutputStream byteArrayOutputStream;
        IlO ilO = this.MY;
        ?? r1 = 0;
        if (ilO != null) {
            try {
                if (str != 0) {
                    try {
                        IlO.EO eoIlO = ilO.IlO((String) str);
                        if (eoIlO == null) {
                            NV.IlO(null);
                            NV.IlO(null);
                            return null;
                        }
                        str = eoIlO.IlO(0);
                        if (str != 0) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i2 = str.read(bArr);
                                        if (i2 == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, i2);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    r7 = str;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                byteArrayOutputStream = null;
                                r7 = str;
                            } catch (Throwable th) {
                                th = th;
                                closeable = null;
                                r1 = str;
                                NV.IlO(r1);
                                NV.IlO(closeable);
                                throw th;
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        NV.IlO(str);
                        NV.IlO(byteArrayOutputStream);
                        return byteArray;
                    } catch (IOException e8) {
                        e = e8;
                        r7 = 0;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        NV.IlO(r1);
                        NV.IlO(closeable);
                        throw th;
                    }
                    Log.w("LruCountDiskCache", e.toString());
                    NV.IlO(r7);
                    NV.IlO(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.Cc.EO
    public InputStream IlO(String str) throws Throwable {
        IlO ilO = this.MY;
        if (ilO == null) {
            return null;
        }
        try {
            IlO.EO eoIlO = ilO.IlO(str);
            if (eoIlO != null) {
                return eoIlO.IlO(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean IlO(String str, byte[] bArr) throws Throwable {
        Closeable closeable;
        IlO ilO = this.MY;
        if (ilO == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        IlO.C0042IlO c0042IlO = null;
        try {
            try {
                IlO.C0042IlO c0042IlOMY = ilO.MY(str);
                try {
                    if (c0042IlOMY == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        NV.IlO(null);
                        return false;
                    }
                    OutputStream outputStreamIlO = c0042IlOMY.IlO(0);
                    if (outputStreamIlO == IlO.EO) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        NV.IlO(outputStreamIlO);
                        return false;
                    }
                    outputStreamIlO.write(bArr);
                    c0042IlOMY.IlO();
                    this.MY.IlO();
                    NV.IlO(outputStreamIlO);
                    return true;
                } catch (IOException e) {
                    e = e;
                    closeable = null;
                    c0042IlO = c0042IlOMY;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (c0042IlO != null) {
                            try {
                                c0042IlO.MY();
                            } catch (IOException unused) {
                            }
                        }
                        NV.IlO(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        NV.IlO(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                NV.IlO(closeable2);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            closeable = null;
        }
    }
}

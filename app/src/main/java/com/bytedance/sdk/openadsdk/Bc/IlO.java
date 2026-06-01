package com.bytedance.sdk.openadsdk.Bc;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import com.bytedance.sdk.component.MY.IlO.Cc;
import com.bytedance.sdk.component.MY.IlO.DmF;
import com.bytedance.sdk.component.MY.IlO.EO;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.hp;
import com.bytedance.sdk.component.MY.IlO.rp;
import com.bytedance.sdk.component.MY.IlO.vCE;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements INetWork {
    protected EV IlO;
    protected EV MY;

    public IlO() {
        EV.IlO ilO = new EV.IlO();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.IlO = ilO.IlO(10L, timeUnit).MY(10L, timeUnit).EO(10L, timeUnit).IlO();
        this.MY = new EV.IlO().IlO(10L, timeUnit).MY(30L, timeUnit).EO(30L, timeUnit).IlO();
    }

    private Map<String, String> IlO(vCE vce) {
        if (vce == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < vce.IlO(); i2++) {
            map.put(vce.IlO(i2), vce.MY(i2));
        }
        return map;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doGet(String str) throws Exception {
        bWL bwlMY = this.IlO.IlO(new rp.IlO().IlO().MY(str).IlO("gecko").MY()).MY();
        return new Response(IlO(bwlMY.Bc()), bwlMY.EO() == 200 ? bwlMY.vCE().MY() : null, bwlMY.EO(), bwlMY.Cc());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        Cc.IlO ilO = new Cc.IlO();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                ilO.IlO((String) pair.first, (String) pair.second);
            }
        }
        bWL bwlMY = this.IlO.IlO(new rp.IlO().MY(str).IlO((hp) ilO.IlO()).IlO("gecko").MY()).MY();
        return new Response(IlO(bwlMY.Bc()), bwlMY.EO() == 200 ? bwlMY.vCE().MY() : null, bwlMY.EO(), bwlMY.Cc());
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0044: MOVE (r7 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:69), block:B:12:0x0044 */
    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception {
        Exception e;
        Closeable closeable;
        Closeable closeable2 = null;
        int i2 = 0;
        try {
            try {
                try {
                    bWL bwlMY = this.MY.IlO(new rp.IlO().IlO().IlO("gecko").MY(str).MY()).MY();
                    int iEO = bwlMY.EO();
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(bwlMY.vCE().EO());
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i8 = bufferedInputStream.read(bArr, 0, 2048);
                                if (i8 == -1) {
                                    CloseableUtils.close(bufferedInputStream);
                                    return;
                                }
                                bufferOutputStream.write(bArr, 0, i8);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i2 = iEO;
                            throw new RuntimeException("downloadFile failed, code: " + i2 + ", url:" + str + ", caused by:" + e.getMessage(), e);
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } catch (Throwable th) {
                    th = th;
                    CloseableUtils.close(closeable2);
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            CloseableUtils.close(closeable2);
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void syncDoGet(final String str) {
        this.IlO.IlO(new rp.IlO().IlO().MY(str).IlO("gecko").MY()).IlO(new EO() { // from class: com.bytedance.sdk.openadsdk.Bc.IlO.1
            @Override // com.bytedance.sdk.component.MY.IlO.EO
            public void IlO(com.bytedance.sdk.component.MY.IlO.MY my, bWL bwl) throws IOException {
            }

            @Override // com.bytedance.sdk.component.MY.IlO.EO
            public void IlO(com.bytedance.sdk.component.MY.IlO.MY my, IOException iOException) {
            }
        });
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, String str2) throws Exception {
        bWL bwlMY = this.IlO.IlO(new rp.IlO().MY(str).IlO(hp.IlO(DmF.IlO("application/json; charset=utf-8"), str2)).IlO("gecko").MY()).MY();
        return new Response(IlO(bwlMY.Bc()), bwlMY.EO() == 200 ? bwlMY.vCE().MY() : null, bwlMY.EO(), bwlMY.Cc());
    }
}

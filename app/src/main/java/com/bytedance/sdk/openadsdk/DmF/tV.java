package com.bytedance.sdk.openadsdk.DmF;

import android.content.Context;
import com.bytedance.sdk.component.Cc.AXM;
import com.bytedance.sdk.component.Cc.EO.Cc;
import com.bytedance.sdk.component.Cc.ea;
import com.bytedance.sdk.component.Cc.oeT;
import com.bytedance.sdk.component.Cc.tV.EO.Cc;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.rp;
import com.bytedance.sdk.component.MY.IlO.vCE;
import com.bytedance.sdk.component.utils.NV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.YA;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        private static final ea MY = IlO(cl.IlO());
        public static boolean IlO = true;
        private static int EO = 10;
        private static int tV = 15;
        private static int Cc = 30;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.DmF.tV$IlO$IlO, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static class C0068IlO implements com.bytedance.sdk.component.Cc.tV {
            private C0068IlO() {
            }

            @Override // com.bytedance.sdk.component.Cc.tV
            /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.component.Cc.MY.EO IlO(com.bytedance.sdk.component.Cc.Cc cc) {
                EV evVCE = Bc.IlO().MY().vCE();
                rp rpVarMY = new rp.IlO().MY(cc.IlO()).IlO().MY();
                bWL bwlMY = null;
                com.bytedance.sdk.component.Cc.MY.tV tVVar = cc.EO() ? new com.bytedance.sdk.component.Cc.MY.tV() : null;
                if (tVVar != null) {
                    tVVar.IlO(System.currentTimeMillis());
                }
                try {
                    bwlMY = evVCE.IlO(rpVarMY).MY();
                    if (tVVar != null) {
                        tVVar.MY(System.currentTimeMillis());
                    }
                    return new com.bytedance.sdk.component.Cc.MY.EO(bwlMY.EO(), bwlMY.vCE().tV(), "", IlO(cc, bwlMY));
                } catch (Throwable th) {
                    try {
                        return IlO(tVVar, th);
                    } finally {
                        NV.IlO(bwlMY);
                    }
                }
            }

            private Map<String, String> IlO(com.bytedance.sdk.component.Cc.Cc cc, bWL bwl) {
                if (!cc.MY()) {
                    return null;
                }
                vCE vceBc = bwl.Bc();
                HashMap map = new HashMap();
                int iIlO = vceBc.IlO();
                for (int i2 = 0; i2 < iIlO; i2++) {
                    String strIlO = vceBc.IlO(i2);
                    String strMY = vceBc.MY(i2);
                    if (strIlO != null) {
                        map.put(strIlO, strMY);
                    }
                }
                return map;
            }

            private com.bytedance.sdk.component.Cc.MY.EO IlO(com.bytedance.sdk.component.Cc.MY.tV tVVar, Throwable th) {
                th.getMessage();
                if (tVVar != null) {
                    tVVar.EO(System.currentTimeMillis());
                }
                com.bytedance.sdk.component.Cc.MY.EO eo = new com.bytedance.sdk.component.Cc.MY.EO(98765, th, "net failed");
                eo.IlO(tVVar);
                return eo;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static com.bytedance.sdk.component.Cc.NV MY(String str) {
            return IlO(MY.IlO(str).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())));
        }

        public static void IlO() {
            IlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("image_config", "use_new_img", 1) == 1;
            EO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("image_config", "bitmap_cache_count", 10);
            tV = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("image_config", "data_cache_count", 15);
            Cc = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("image_config", "disk_cache_count", 30);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static com.bytedance.sdk.component.Cc.NV MY(zPa zpa) {
            return IlO(MY.IlO(zpa.IlO()).IlO(zpa.MY()).MY(zpa.EO()).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())).IlO(zpa.Bc()));
        }

        private static ea IlO(Context context) {
            IlO();
            if (IlO) {
                return com.bytedance.sdk.component.Cc.tV.EO.MY.IlO(context, new Cc.IlO().IlO(new com.bytedance.sdk.component.Cc.tV.EO.IlO.MY(0, EO, tV, Cc, new File(CacheDirFactory.getImageCacheDir("image_p")))).IlO(com.bytedance.sdk.openadsdk.multipro.MY.EO()).IlO(new AXM() { // from class: com.bytedance.sdk.openadsdk.DmF.tV.IlO.2
                    @Override // com.bytedance.sdk.component.Cc.AXM
                    public ExecutorService IlO() {
                        return mmj.MY();
                    }

                    @Override // com.bytedance.sdk.component.Cc.AXM
                    public ExecutorService MY() {
                        return mmj.EO();
                    }
                }).IlO(new oeT() { // from class: com.bytedance.sdk.openadsdk.DmF.tV.IlO.1
                    @Override // com.bytedance.sdk.component.Cc.oeT
                    public void IlO(int i2, String str) {
                        com.bytedance.sdk.openadsdk.ea.EO.IlO(str, true);
                    }
                }).IlO(new C0068IlO()).IlO());
            }
            return com.bytedance.sdk.component.Cc.EO.MY.IlO(context, new Cc.IlO().IlO(new com.bytedance.sdk.component.Cc.EO.IlO.IlO(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040L, new File(CacheDirFactory.getImageCacheDir("image")))).IlO(com.bytedance.sdk.openadsdk.multipro.MY.EO()).IlO(new AXM() { // from class: com.bytedance.sdk.openadsdk.DmF.tV.IlO.4
                @Override // com.bytedance.sdk.component.Cc.AXM
                public ExecutorService IlO() {
                    return mmj.MY();
                }

                @Override // com.bytedance.sdk.component.Cc.AXM
                public ExecutorService MY() {
                    return null;
                }
            }).IlO(new oeT() { // from class: com.bytedance.sdk.openadsdk.DmF.tV.IlO.3
                @Override // com.bytedance.sdk.component.Cc.oeT
                public void IlO(int i2, String str) {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO(str, false);
                }
            }).IlO(new C0068IlO()).IlO());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static InputStream MY(String str, String str2) {
            return MY.IlO(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean MY(String str, String str2, String str3) {
            return MY.IlO(str, str2, str3);
        }

        private static com.bytedance.sdk.component.Cc.NV IlO(com.bytedance.sdk.component.Cc.NV nv) {
            return YA.IlO() ? nv.IlO(new Cc()) : nv;
        }
    }

    public static com.bytedance.sdk.component.Cc.NV IlO(String str) {
        return IlO.MY(str);
    }

    public static boolean MY() {
        return IlO.IlO;
    }

    public static com.bytedance.sdk.component.Cc.NV IlO(zPa zpa) {
        return IlO.MY(zpa);
    }

    public static InputStream IlO(String str, String str2) {
        return IlO.MY(str, str2);
    }

    public static boolean IlO(String str, String str2, String str3) {
        return IlO.MY(str, str2, str3);
    }

    public static ea IlO() {
        return IlO.MY;
    }
}

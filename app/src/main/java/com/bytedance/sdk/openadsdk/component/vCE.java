package com.bytedance.sdk.openadsdk.component;

import a1.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.NV;
import com.bytedance.sdk.component.Cc.zPa;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.common.IlO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.pP;
import com.bytedance.sdk.openadsdk.core.model.vSq;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.cl;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private static volatile vCE EO = null;
    private static String IlO = "/openad_image_cache";
    private static String MY = "openad_image_cache";
    private final Map<String, AtomicInteger> Bc = new ConcurrentHashMap();
    private final xF<com.bytedance.sdk.openadsdk.tV.IlO> Cc;
    private final com.bytedance.sdk.openadsdk.MY.MY tV;
    private final Context vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface EO {
        void IlO();

        void IlO(int i2, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO extends lEW {
        private final com.bytedance.sdk.openadsdk.component.Cc.IlO MY;

        public IlO(com.bytedance.sdk.openadsdk.component.Cc.IlO ilO) {
            super("App Open Ad Write Cache");
            this.MY = ilO;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
                    com.bytedance.sdk.openadsdk.common.IlO.IlO("tt_openad_materialMeta").IlO(this.MY.MY().ssS(), this.MY.EO());
                    return;
                }
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad_materialMeta", "material" + this.MY.IlO(), com.bytedance.sdk.component.utils.IlO.IlO(this.MY.MY().eDn()).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO();

        void IlO(@Nullable com.bytedance.sdk.openadsdk.cL.IlO.EO eo);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface tV {
        void IlO(Object obj);
    }

    private vCE(Context context) {
        if (context != null) {
            this.vCE = context.getApplicationContext();
        } else {
            this.vCE = cl.IlO();
        }
        this.tV = new com.bytedance.sdk.openadsdk.MY.MY(10, 8, true);
        this.Cc = cl.EO();
        if (com.bytedance.sdk.openadsdk.DmF.tV.MY()) {
            IlO = a.r(new StringBuilder(), IlO, "_p");
            MY = a.r(new StringBuilder(), MY, "_p");
        }
        com.bytedance.sdk.openadsdk.common.IlO.IlO("tt_openad_materialMeta", new IlO.C0074IlO("tt_openad_materialMeta") { // from class: com.bytedance.sdk.openadsdk.component.vCE.1
            @Override // com.bytedance.sdk.openadsdk.common.IlO.C0074IlO
            public String IlO(String str) {
                return "tt_openad_materialMeta";
            }

            @Override // com.bytedance.sdk.openadsdk.common.IlO.C0074IlO
            public String MY(String str) {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tt_openad_materialMeta", "material".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.IlO.C0074IlO
            public String tV(String str) {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.IlO.C0074IlO
            public void IlO(AdSlot adSlot, String str, String str2) {
                String codeId = adSlot.getCodeId();
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad_materialMeta", "material".concat(String.valueOf(codeId)), str);
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(codeId)), adSlot.toJsonObj().toString());
            }
        });
    }

    public void Bc(int i2) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad_materialMeta", "material".concat(String.valueOf(i2)));
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "material_expiration_time".concat(String.valueOf(i2)));
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "video_has_cached".concat(String.valueOf(i2)));
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "image_has_cached".concat(String.valueOf(i2)));
    }

    @Nullable
    public oeT Cc(int i2) {
        oeT oetVCE;
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            com.bytedance.sdk.openadsdk.core.model.IlO IlO2 = com.bytedance.sdk.openadsdk.common.IlO.IlO("tt_openad_materialMeta").IlO(String.valueOf(i2), false);
            oetVCE = IlO2 != null ? IlO2.vCE() : null;
        } else {
            oetVCE = vCE(i2);
        }
        long jIlO = com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "material_expiration_time".concat(String.valueOf(i2)), -1L);
        if (System.currentTimeMillis() / 1000 < jIlO && oetVCE != null) {
            return oetVCE;
        }
        if (oetVCE != null || jIlO != -1) {
            Bc(i2);
            if (oetVCE != null) {
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(oetVCE);
            }
        }
        return null;
    }

    public boolean tV(int i2) {
        return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "image_has_cached".concat(String.valueOf(i2)), false);
    }

    @Nullable
    public oeT vCE(int i2) {
        String strMY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tt_openad_materialMeta", "material".concat(String.valueOf(i2)), null);
        if (!TextUtils.isEmpty(strMY)) {
            try {
                JSONObject jSONObjectIlO = cl.EO().IlO(new JSONObject(strMY));
                return jSONObjectIlO.has("creatives") ? com.bytedance.sdk.openadsdk.core.model.IlO.EO(jSONObjectIlO).vCE() : com.bytedance.sdk.openadsdk.core.MY.IlO(jSONObjectIlO);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdCacheManager", e.getMessage());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.Bc.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.Bc.put(adSlot.getCodeId(), atomicInteger);
    }

    public void EO(int i2) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "image_has_cached".concat(String.valueOf(i2)), Boolean.TRUE);
    }

    private int EO(AdSlot adSlot) {
        StringBuilder sb = new StringBuilder("material_expiration_time");
        sb.append(adSlot.getCodeId());
        return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", sb.toString(), -1L) == -1 ? 0 : 1;
    }

    public static vCE IlO(Context context) {
        if (EO == null) {
            synchronized (vCE.class) {
                try {
                    if (EO == null) {
                        EO = new vCE(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return EO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(@NonNull final oeT oet, final AdSlot adSlot, final vSq vsq, final com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        final int iHFV = oet.hFV();
        IlO(oet, vsq, new MY() { // from class: com.bytedance.sdk.openadsdk.component.vCE.6
            @Override // com.bytedance.sdk.openadsdk.component.vCE.MY
            public void IlO(com.bytedance.sdk.openadsdk.cL.IlO.EO eo) {
                com.bytedance.sdk.openadsdk.component.Cc.IlO ilO2 = new com.bytedance.sdk.openadsdk.component.Cc.IlO(iHFV, oet, ilO);
                vCE.this.IlO(ilO2);
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(ilO2.MY(), 1, vsq);
                vCE.this.MY(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.vCE.MY
            public void IlO() {
                vCE.this.MY(adSlot);
            }
        });
    }

    public boolean MY(int i2) {
        return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "video_has_cached".concat(String.valueOf(i2)), false);
    }

    public static void IlO(oeT oet, tV tVVar) {
        IlO(oet, tVVar, 0);
    }

    private void MY(com.bytedance.sdk.openadsdk.component.Cc.IlO ilO) {
        mmj.IlO(new IlO(ilO), 5);
    }

    public static void IlO(oeT oet, final tV tVVar, final int i2) {
        String str = oet.fdM().f4689f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NV nvTV = com.bytedance.sdk.openadsdk.DmF.tV.IlO(str).IlO(oet.fdM().f4686b).MY(oet.fdM().f4685a).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO()));
        if (i2 > 0 && Build.VERSION.SDK_INT >= 26) {
            nvTV.EO(2).IlO(new com.bytedance.sdk.component.Cc.lEW() { // from class: com.bytedance.sdk.openadsdk.component.vCE.2
                @Override // com.bytedance.sdk.component.Cc.lEW
                public Bitmap IlO(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.tV.IlO.IlO(cl.IlO(), bitmap, i2);
                }
            });
        } else {
            nvTV.EO(1);
        }
        nvTV.IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, str, new zPa() { // from class: com.bytedance.sdk.openadsdk.component.vCE.3
            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(int i8, String str2, @Nullable Throwable th) {
            }

            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(EV ev) {
                tV tVVar2;
                if (ev == null || ev.MY() == null || ev.EO() == null || (tVVar2 = tVVar) == null) {
                    return;
                }
                tVVar2.IlO(ev.MY());
            }
        }));
    }

    public boolean MY(oeT oet) {
        if (oet == null || oet.Hg() == null || oet.Hg().size() == 0 || TextUtils.isEmpty(oet.Hg().get(0).IlO())) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.zPa zpa = oet.Hg().get(0);
        return IlO(zpa.IlO(), zpa.Bc());
    }

    public String MY() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            return a.r(a.x(name, "/"), MY, "/");
        }
        return a.r(a.x(name, "/"), IlO, "/");
    }

    public void IlO(final AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.Bc.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        if (atomicInteger.get() + EO(adSlot) > 0) {
            return;
        }
        atomicInteger.incrementAndGet();
        this.Bc.put(adSlot.getCodeId(), atomicInteger);
        final vSq vsq = new vSq();
        vsq.IlO(DM.MY());
        pP pPVar = new pP();
        pPVar.NV = vsq;
        pPVar.tV = 2;
        pPVar.lEW = 2;
        this.Cc.IlO(adSlot, pPVar, 3, new xF.IlO() { // from class: com.bytedance.sdk.openadsdk.component.vCE.4
            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(int i2, String str) {
                vCE.this.MY(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
                if (ilO == null || ilO.tV() == null || ilO.tV().size() == 0) {
                    eo.IlO(-3);
                    com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                    return;
                }
                oeT oet = ilO.tV().get(0);
                if (oet == null || !oet.mV()) {
                    if (oeT.Cc(oet)) {
                        vCE.this.IlO(oet, adSlot, vsq, ilO);
                        return;
                    } else {
                        vCE.this.MY(oet, adSlot, vsq, ilO);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.component.Cc.IlO ilO2 = new com.bytedance.sdk.openadsdk.component.Cc.IlO(oet.hFV(), oet, ilO);
                vCE.this.IlO(ilO2);
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(ilO2.MY(), 1, vsq);
                vCE.this.MY(adSlot);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(@NonNull final oeT oet, final AdSlot adSlot, final vSq vsq, final com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        final int iHFV = oet.hFV();
        IlO(oet, adSlot, vsq, new EO() { // from class: com.bytedance.sdk.openadsdk.component.vCE.5
            @Override // com.bytedance.sdk.openadsdk.component.vCE.EO
            public void IlO() {
                com.bytedance.sdk.openadsdk.component.Cc.IlO ilO2 = new com.bytedance.sdk.openadsdk.component.Cc.IlO(iHFV, oet, ilO);
                vCE.this.IlO(ilO2);
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(ilO2.MY(), 1, vsq);
                vCE.this.MY(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.vCE.EO
            public void IlO(int i2, String str) {
                vCE.this.MY(adSlot);
            }
        });
    }

    public void IlO(@NonNull final oeT oet, AdSlot adSlot, final vSq vsq, final EO eo) {
        final DM dmMY = DM.MY();
        final int iHFV = oet.hFV();
        c cVarFdM = oet.fdM();
        String str = cVarFdM.g;
        String strA = cVarFdM.a();
        if (TextUtils.isEmpty(strA)) {
            strA = com.bytedance.sdk.component.utils.Cc.IlO(str);
        }
        final File fileIlO = com.bytedance.sdk.openadsdk.component.Bc.IlO.IlO(strA);
        if (fileIlO.exists()) {
            com.bytedance.sdk.openadsdk.component.Bc.IlO.IlO(fileIlO);
            IlO(iHFV);
            long jTV = dmMY.tV();
            if (vsq != null) {
                vsq.IlO(jTV);
                vsq.IlO(1);
            }
            eo.IlO();
            IlO(oet, (tV) null);
            return;
        }
        if (cl.tV().pP(String.valueOf(iHFV)) && !com.bytedance.sdk.component.utils.xF.tV(cl.IlO())) {
            eo.IlO(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(fileIlO.getParent(), oet);
        myIlO.IlO("material_meta", oet);
        myIlO.IlO("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.IlO(myIlO, new t.a() { // from class: com.bytedance.sdk.openadsdk.component.vCE.7
            @Override // t.a
            public void IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, int i2) {
                vCE.this.IlO(iHFV);
                long jTV2 = dmMY.tV();
                com.bytedance.sdk.openadsdk.component.tV.IlO.MY(oet, jTV2, true);
                vSq vsq2 = vsq;
                if (vsq2 != null) {
                    vsq2.IlO(jTV2);
                    vsq.IlO(2);
                }
                eo.IlO();
                vCE.IlO(oet, (tV) null);
            }

            @Override // t.a
            public void IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, int i2, String str2) {
                long jTV2 = dmMY.tV();
                com.bytedance.sdk.openadsdk.component.tV.IlO.MY(oet, jTV2, false);
                vSq vsq2 = vsq;
                if (vsq2 != null) {
                    vsq2.IlO(jTV2);
                }
                eo.IlO(i2, str2);
                try {
                    if (fileIlO.exists() && fileIlO.isFile()) {
                        com.bytedance.sdk.component.utils.Bc.EO(fileIlO);
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // t.a
            public void MY(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, int i2) {
            }
        });
    }

    public void IlO(final oeT oet, final vSq vsq, final MY my) {
        final DM dmMY = DM.MY();
        final int iHFV = oet.hFV();
        com.bytedance.sdk.openadsdk.core.model.zPa zpa = oet.Hg().get(0);
        String strBc = zpa.Bc();
        String strIlO = zpa.IlO();
        int iMY = zpa.MY();
        int iEO = zpa.EO();
        String strIlO2 = TextUtils.isEmpty(strBc) ? com.bytedance.sdk.component.utils.Cc.IlO(strIlO) : strBc;
        if (TextUtils.isEmpty(strIlO2)) {
            if (my != null) {
                my.IlO();
                return;
            }
            return;
        }
        File fileMY = com.bytedance.sdk.openadsdk.component.Bc.IlO.MY(strIlO2);
        if (IlO(strIlO, strBc)) {
            EO(iHFV);
            long jTV = dmMY.tV();
            if (vsq != null) {
                vsq.IlO(jTV);
                vsq.IlO(1);
            }
            my.IlO(null);
            return;
        }
        com.bytedance.sdk.openadsdk.utils.cl.IlO(new com.bytedance.sdk.openadsdk.cL.vCE(strIlO, zpa.Bc()), iMY, iEO, new cl.IlO() { // from class: com.bytedance.sdk.openadsdk.component.vCE.8
            @Override // com.bytedance.sdk.openadsdk.utils.cl.IlO
            @MainThread
            public void IlO(@NonNull com.bytedance.sdk.openadsdk.cL.IlO.EO eo) {
                if (!eo.Cc()) {
                    com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(oet, dmMY.tV(), false);
                    my.IlO();
                    return;
                }
                vCE.this.EO(iHFV);
                long jTV2 = dmMY.tV();
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(oet, jTV2, true);
                vSq vsq2 = vsq;
                if (vsq2 != null) {
                    vsq2.IlO(jTV2);
                    vsq.IlO(2);
                }
                my.IlO(eo);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.cl.IlO
            @MainThread
            public void IlO() {
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(oet, dmMY.tV(), false);
                my.IlO();
            }
        }, fileMY.getParent());
    }

    public void IlO(int i2) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "video_has_cached".concat(String.valueOf(i2)), Boolean.TRUE);
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.Cc.IlO ilO) {
        if (ilO.MY() == null || oeT.Bc(ilO.MY()) || ilO.MY().uAj()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad", "material_expiration_time" + ilO.IlO(), Long.valueOf(ilO.MY().OW()));
        MY(ilO);
    }

    @Nullable
    public String IlO(oeT oet) {
        if (oet != null && oet.fdM() != null && !TextUtils.isEmpty(oet.fdM().g)) {
            String str = oet.fdM().g;
            String strA = oet.fdM().a();
            if (TextUtils.isEmpty(strA)) {
                strA = com.bytedance.sdk.component.utils.Cc.IlO(str);
            }
            File fileIlO = com.bytedance.sdk.openadsdk.component.Bc.IlO.IlO(strA);
            if (fileIlO.exists() && fileIlO.isFile()) {
                return fileIlO.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean IlO(String str, String str2) {
        boolean z2;
        File file;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.Cc.IlO(str);
            }
            File fileMY = com.bytedance.sdk.openadsdk.component.Bc.IlO.MY(str2);
            InputStream inputStreamIlO = com.bytedance.sdk.openadsdk.DmF.tV.IlO(str, str2);
            if (inputStreamIlO != null) {
                try {
                    inputStreamIlO.close();
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdCacheManager", e.getMessage());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (com.bytedance.sdk.openadsdk.DmF.tV.IlO(str, str2, fileMY.getParent())) {
                    return true;
                }
                if (com.bytedance.sdk.openadsdk.DmF.tV.MY()) {
                    file = new File(fileMY.getPath());
                } else {
                    file = new File(fileMY.getPath() + ".0");
                }
                if (file.exists()) {
                    return true;
                }
            }
            return z2;
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdCacheManager", e4.getMessage());
            return false;
        }
    }

    public void IlO() {
        File[] fileArrListFiles;
        try {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.vCE.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.vCE.9
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains(vCE.MY) || name.contains("openad_video_cache");
                }
            })) == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.Bc.EO(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }
}

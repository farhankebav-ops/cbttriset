package com.bytedance.adsdk.MY.tV;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.MY.rp;
import com.ironsource.G5;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private final Bc IlO;
    private final vCE MY;

    public lEW(Bc bc, vCE vce) {
        this.IlO = bc;
        this.MY = vce;
    }

    private rp<com.bytedance.adsdk.MY.Bc> EO(Context context, String str, String str2) {
        Closeable closeable = null;
        try {
            try {
                tV tVVarIlO = this.MY.IlO(str);
                if (!tVVarIlO.IlO()) {
                    rp<com.bytedance.adsdk.MY.Bc> rpVar = new rp<>(new IllegalArgumentException(tVVarIlO.tV()));
                    try {
                        tVVarIlO.close();
                    } catch (IOException unused) {
                    }
                    return rpVar;
                }
                rp<com.bytedance.adsdk.MY.Bc> rpVarIlO = IlO(context, str, tVVarIlO.MY(), tVVarIlO.EO(), str2);
                rpVarIlO.IlO();
                try {
                    tVVarIlO.close();
                } catch (IOException unused2) {
                }
                return rpVarIlO;
            } catch (Exception e) {
                rp<com.bytedance.adsdk.MY.Bc> rpVar2 = new rp<>(e);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException unused3) {
                    }
                }
                return rpVar2;
            }
        } finally {
        }
    }

    private com.bytedance.adsdk.MY.Bc MY(Context context, String str, String str2) {
        Bc bc;
        Pair<EO, InputStream> pairIlO;
        if (str2 == null || (bc = this.IlO) == null || (pairIlO = bc.IlO(str)) == null) {
            return null;
        }
        EO eo = (EO) pairIlO.first;
        InputStream inputStream = (InputStream) pairIlO.second;
        rp<com.bytedance.adsdk.MY.Bc> rpVarIlO = eo == EO.ZIP ? com.bytedance.adsdk.MY.lEW.IlO(context, new ZipInputStream(inputStream), str2) : com.bytedance.adsdk.MY.lEW.MY(inputStream, str2);
        if (rpVarIlO.IlO() != null) {
            return rpVarIlO.IlO();
        }
        return null;
    }

    public rp<com.bytedance.adsdk.MY.Bc> IlO(Context context, String str, String str2) {
        com.bytedance.adsdk.MY.Bc bcMY = MY(context, str, str2);
        return bcMY != null ? new rp<>(bcMY) : EO(context, str, str2);
    }

    private rp<com.bytedance.adsdk.MY.Bc> IlO(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        rp<com.bytedance.adsdk.MY.Bc> rpVarIlO;
        EO eo;
        Bc bc;
        if (str2 == null) {
            str2 = G5.L;
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            eo = EO.JSON;
            rpVarIlO = IlO(str, inputStream, str3);
        } else {
            EO eo2 = EO.ZIP;
            rpVarIlO = IlO(context, str, inputStream, str3);
            eo = eo2;
        }
        if (str3 != null && rpVarIlO.IlO() != null && (bc = this.IlO) != null) {
            bc.IlO(str, eo);
        }
        return rpVarIlO;
    }

    private rp<com.bytedance.adsdk.MY.Bc> IlO(Context context, String str, InputStream inputStream, String str2) throws IOException {
        Bc bc;
        if (str2 != null && (bc = this.IlO) != null) {
            return com.bytedance.adsdk.MY.lEW.IlO(context, new ZipInputStream(new FileInputStream(bc.IlO(str, inputStream, EO.ZIP))), str);
        }
        return com.bytedance.adsdk.MY.lEW.IlO(context, new ZipInputStream(inputStream), (String) null);
    }

    private rp<com.bytedance.adsdk.MY.Bc> IlO(String str, InputStream inputStream, String str2) throws IOException {
        Bc bc;
        if (str2 != null && (bc = this.IlO) != null) {
            return com.bytedance.adsdk.MY.lEW.MY(new FileInputStream(bc.IlO(str, inputStream, EO.JSON).getAbsolutePath()), str);
        }
        return com.bytedance.adsdk.MY.lEW.MY(inputStream, (String) null);
    }
}

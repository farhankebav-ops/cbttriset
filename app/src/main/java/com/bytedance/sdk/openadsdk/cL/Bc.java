package com.bytedance.sdk.openadsdk.cL;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.Bc.IlO;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.MY.IlO.IlO.IlO.Cc;
import com.bytedance.sdk.component.MY.IlO.IlO.IlO.NV;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.lEW;
import com.bytedance.sdk.component.MY.IlO.rp;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.utils.MY;
import com.bytedance.sdk.openadsdk.DmF.EO;
import com.bytedance.sdk.openadsdk.cL.IlO.tV;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.zPa;
import com.bytedance.sdk.openadsdk.core.oeT;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private static volatile Bc IlO;
    private tV EO;
    private final com.bytedance.sdk.component.Bc.IlO MY;
    private final Map<String, JSONObject> tV = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO implements lEW {
        public IlO() {
        }

        @Override // com.bytedance.sdk.component.MY.IlO.lEW
        public bWL IlO(lEW.IlO ilO) throws IOException {
            JSONObject jSONObjectIlO;
            rp rpVarIlO = ilO.IlO();
            if (rpVarIlO.MY() != null && !rpVarIlO.MY().tV().isEmpty()) {
                List<String> listTV = rpVarIlO.MY().tV();
                StringBuilder sb = new StringBuilder();
                for (String str : listTV) {
                    sb.append("/");
                    sb.append(str);
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string) && string.equals("/monitor/collect/c/session")) {
                    return ilO.IlO(rpVarIlO);
                }
            }
            rp.IlO ilODmF = rpVarIlO.DmF();
            String strMY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            if (!TextUtils.isEmpty(strMY) && (jSONObjectIlO = Bc.this.IlO(strMY)) != null) {
                ilODmF.MY("transfer-param", jSONObjectIlO.optString("message"));
                if (jSONObjectIlO.optInt("cypher") == 4) {
                    ilODmF.MY("cypher", "4");
                } else {
                    ilODmF.MY("cypher", ExifInterface.GPS_MEASUREMENT_3D);
                }
            }
            try {
                ilODmF.MY("x-pangle-target-idc", hp.aP().eDn());
            } catch (Throwable unused) {
            }
            return ilO.IlO(ilODmF.MY());
        }
    }

    private Bc(Context context) {
        IlO.C0041IlO c0041IlO = new IlO.C0041IlO();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.bytedance.sdk.component.Bc.IlO IlO2 = c0041IlO.IlO(WorkRequest.MIN_BACKOFF_MILLIS, timeUnit).MY(WorkRequest.MIN_BACKOFF_MILLIS, timeUnit).EO(WorkRequest.MIN_BACKOFF_MILLIS, timeUnit).IlO(new IlO()).IlO(true).IlO();
        this.MY = IlO2;
        com.bytedance.sdk.component.MY.IlO.IlO.IlO.IlO.IlO(new NV() { // from class: com.bytedance.sdk.openadsdk.cL.Bc.1
            @Override // com.bytedance.sdk.component.MY.IlO.IlO.IlO.NV
            public ExecutorService IlO() {
                if (hp.aP().vZk()) {
                    return mmj.EV();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.MY.IlO.IlO.IlO.NV
            public boolean MY() {
                return hp.aP().vZk();
            }
        });
        com.bytedance.sdk.component.Bc.IlO.IlO(new Cc() { // from class: com.bytedance.sdk.openadsdk.cL.Bc.2
            @Override // com.bytedance.sdk.component.MY.IlO.IlO.IlO.Cc
            public boolean IlO() {
                return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("net_http_protocol", 0) == 1;
            }
        });
        com.bytedance.sdk.component.MY.IlO.tV tVVarIlO = IlO2.vCE().IlO();
        if (tVVarIlO != null) {
            tVVarIlO.IlO(32);
        }
    }

    private void tV() {
        if (this.EO == null) {
            this.EO = new tV();
        }
    }

    public tV EO() {
        tV();
        return this.EO;
    }

    public com.bytedance.sdk.component.Bc.IlO MY() {
        return this.MY;
    }

    public static Bc IlO() {
        if (IlO == null) {
            synchronized (Bc.class) {
                try {
                    if (IlO == null) {
                        IlO = new Bc(cl.IlO());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject IlO(String str) {
        JSONObject jSONObject = this.tV.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ipv6", str);
        } catch (JSONException unused) {
        }
        JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject2, new oeT(PangleEncryptConstant.CryptDataScene.UNKNOWN));
        this.tV.put(str, jSONObjectEncryptType4);
        return jSONObjectEncryptType4;
    }

    public void IlO(String str, int i2, int i8, ImageView imageView, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(str).IlO(i2).MY(i8).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())).EO(1).IlO(EO.IlO(oet, str, imageView));
    }

    public void IlO(int i2, final ImageView imageView, final com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null || !TextUtils.isEmpty(oet.rp())) {
            com.bytedance.sdk.openadsdk.DmF.tV.IlO(oet.rp()).IlO(i2).MY(i2).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())).EO(1).IlO(EO.IlO(oet, oet.rp(), imageView));
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.cL.Bc.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (imageView.getDrawable() != null) {
                            Intent intent = new Intent();
                            String strHp = oet.hp();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse(strHp));
                            try {
                                MY.IlO(cl.IlO(), intent, null);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void IlO(zPa zpa, ImageView imageView, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (zpa == null || TextUtils.isEmpty(zpa.IlO()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpa).EO(1).IlO(EO.IlO(oet, zpa.IlO(), imageView));
    }

    public void IlO(zPa zpa, ImageView imageView, com.bytedance.sdk.openadsdk.core.model.oeT oet, com.bytedance.sdk.component.Cc.zPa zpa2) {
        if (zpa == null || TextUtils.isEmpty(zpa.IlO()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpa).EO(1).IlO(EO.IlO(oet, zpa.IlO(), imageView, zpa2));
    }

    public void IlO(String str, View view) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(str).EO(2).IlO(new com.bytedance.sdk.component.Cc.lEW() { // from class: com.bytedance.sdk.openadsdk.cL.Bc.5
            @Override // com.bytedance.sdk.component.Cc.lEW
            public Bitmap IlO(Bitmap bitmap) {
                View view2 = (View) weakReference.get();
                if (view2 == null) {
                    return null;
                }
                return com.bytedance.sdk.component.adexpress.tV.IlO.IlO(view2.getContext(), bitmap, 10);
            }
        }).IlO(new com.bytedance.sdk.component.Cc.zPa() { // from class: com.bytedance.sdk.openadsdk.cL.Bc.4
            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(EV ev) {
                final View view2;
                if (ev == null) {
                    return;
                }
                final Object objMY = ev.MY();
                if (!(objMY instanceof Bitmap) || (view2 = (View) weakReference.get()) == null) {
                    return;
                }
                if (!mmj.vCE()) {
                    view2.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.cL.Bc.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View view3 = view2;
                            if (view3 instanceof ImageView) {
                                ((ImageView) view3).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) objMY));
                            } else {
                                view3.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) objMY));
                            }
                        }
                    });
                } else if (view2 instanceof ImageView) {
                    ((ImageView) view2).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) objMY));
                } else {
                    view2.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) objMY));
                }
            }
        });
    }
}

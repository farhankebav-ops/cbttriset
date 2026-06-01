package com.bytedance.sdk.component.Bc.MY;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.component.MY.IlO.Bc;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.IlO;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.ea;
import com.bytedance.sdk.component.MY.IlO.rp;
import com.bytedance.sdk.component.MY.IlO.vCE;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO {
    public static final com.bytedance.sdk.component.MY.IlO.IlO IlO = new IlO.C0048IlO().IlO().MY();
    public static final com.bytedance.sdk.component.MY.IlO.IlO MY = new IlO.C0048IlO().MY();
    private boolean EV;
    private com.bytedance.sdk.component.MY.IlO.IlO NV;
    private Map<String, String> rp;

    public MY(EV ev) {
        super(ev);
        this.NV = IlO;
        this.EV = false;
        this.rp = new HashMap();
    }

    public void IlO(boolean z2) {
        this.EV = z2;
    }

    public void IlO(final com.bytedance.sdk.component.Bc.IlO.IlO ilO) {
        try {
            rp.IlO ilO2 = new rp.IlO();
            if (this.EV) {
                ilO2.MY(this.lEW);
            } else {
                Bc.IlO ilO3 = new Bc.IlO();
                Uri uri = Uri.parse(this.lEW);
                ilO3.IlO(uri.getScheme());
                ilO3.MY(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    ilO3.EO(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.rp.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.rp.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, Key.STRING_CHARSET_NAME);
                        if (value == null) {
                            value = "";
                        }
                        ilO3.IlO(strEncode, URLEncoder.encode(value, Key.STRING_CHARSET_NAME));
                    }
                }
                ilO2.IlO(ilO3.MY());
            }
            IlO(ilO2);
            ilO2.IlO(this.NV);
            ilO2.IlO((Object) EO());
            if (!TextUtils.isEmpty(this.Cc)) {
                ilO2.IlO(this.Cc);
            }
            int i2 = this.vCE;
            if (i2 > 0) {
                ilO2.IlO(i2);
            }
            this.EO.IlO(ilO2.IlO().MY()).IlO(new com.bytedance.sdk.component.MY.IlO.EO() { // from class: com.bytedance.sdk.component.Bc.MY.MY.1
                @Override // com.bytedance.sdk.component.MY.IlO.EO
                public void IlO(com.bytedance.sdk.component.MY.IlO.MY my, IOException iOException) {
                    com.bytedance.sdk.component.Bc.IlO.IlO ilO4 = ilO;
                    if (ilO4 != null) {
                        ilO4.IlO(MY.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.MY.IlO.EO
                public void IlO(com.bytedance.sdk.component.MY.IlO.MY my, bWL bwl) throws IOException {
                    String strMY;
                    if (ilO != null) {
                        HashMap map = new HashMap();
                        if (bwl != null) {
                            vCE vceBc = bwl.Bc();
                            if (vceBc != null) {
                                for (int i8 = 0; i8 < vceBc.IlO(); i8++) {
                                    map.put(vceBc.IlO(i8), vceBc.MY(i8));
                                }
                            }
                            ea eaVarVCE = bwl.vCE();
                            if (eaVarVCE == null) {
                                strMY = "";
                            } else {
                                strMY = eaVarVCE.MY();
                            }
                            ilO.IlO(MY.this, new com.bytedance.sdk.component.Bc.MY(bwl.tV(), bwl.EO(), bwl.Cc(), map, strMY, bwl.MY(), bwl.IlO()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (ilO != null) {
                ilO.IlO(this, new IOException(th.getMessage()));
            }
        }
    }

    public com.bytedance.sdk.component.Bc.MY IlO() {
        try {
            rp.IlO ilO = new rp.IlO();
            if (this.EV) {
                ilO.MY(this.lEW);
            } else {
                Bc.IlO ilO2 = new Bc.IlO();
                Uri uri = Uri.parse(this.lEW);
                ilO2.IlO(uri.getScheme());
                ilO2.MY(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    ilO2.EO(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.rp.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.rp.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, Key.STRING_CHARSET_NAME);
                        if (value == null) {
                            value = "";
                        }
                        ilO2.IlO(strEncode, URLEncoder.encode(value, Key.STRING_CHARSET_NAME));
                    }
                }
                ilO.IlO(ilO2.MY());
            }
            IlO(ilO);
            ilO.IlO(this.NV);
            ilO.IlO((Object) EO());
            bWL bwlMY = this.EO.IlO(ilO.IlO().MY()).MY();
            if (bwlMY == null) {
                return null;
            }
            HashMap map = new HashMap();
            vCE vceBc = bwlMY.Bc();
            if (vceBc != null) {
                for (int i2 = 0; i2 < vceBc.IlO(); i2++) {
                    map.put(vceBc.IlO(i2), vceBc.MY(i2));
                }
            }
            ea eaVarVCE = bwlMY.vCE();
            return new com.bytedance.sdk.component.Bc.MY(bwlMY.tV(), bwlMY.EO(), bwlMY.Cc(), map, eaVarVCE != null ? eaVarVCE.MY() : "", bwlMY.MY(), bwlMY.IlO());
        } catch (Throwable unused) {
            return null;
        }
    }
}

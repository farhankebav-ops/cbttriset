package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import android.text.TextUtils;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.hp;
import com.bytedance.sdk.component.MY.IlO.lEW;
import com.bytedance.sdk.component.MY.IlO.rp;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements com.bytedance.sdk.component.MY.IlO.MY {
    private static List<Object> tV;
    private AtomicBoolean EO = new AtomicBoolean(false);
    rp IlO;
    com.bytedance.sdk.component.MY.IlO.tV MY;

    static {
        try {
            tV = new ArrayList();
            Class<?> cls = Class.forName("com.android.okhttp.Protocol");
            Enum enumValueOf = Enum.valueOf(cls, "HTTP_1_1");
            if (enumValueOf != null) {
                tV.add(enumValueOf);
            }
            Enum enumValueOf2 = Enum.valueOf(cls, "HTTP_2");
            if (enumValueOf2 != null) {
                tV.add(enumValueOf2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public MY(rp rpVar, com.bytedance.sdk.component.MY.IlO.tV tVVar) {
        this.IlO = rpVar;
        this.MY = tVVar;
    }

    private boolean Cc() {
        if (this.IlO.tV() == null) {
            return false;
        }
        return this.IlO.tV().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY
    public void EO() {
        this.EO.set(true);
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY
    public rp IlO() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY
    public bWL MY() throws IOException {
        List<com.bytedance.sdk.component.MY.IlO.lEW> list;
        com.bytedance.sdk.component.EO.IlO.IlO ilO;
        rp rpVar = this.IlO;
        if (rpVar != null && (ilO = rpVar.MY) != null) {
            if (ilO.bWL() == 0) {
                this.IlO.MY.ea();
            }
            this.IlO.MY.IlO();
        }
        this.MY.EO().remove(this);
        this.MY.tV().add(this);
        com.bytedance.sdk.component.MY.IlO.tV tVVar = this.MY;
        if (tVVar instanceof vCE) {
            if (this.MY.tV().size() + tVVar.EO().size() > this.MY.IlO() || this.EO.get()) {
                this.MY.tV().remove(this);
                return new lEW(lEW.IlO, "Maximum number of requests exceeded", this.IlO);
            }
        }
        try {
            EV ev = this.IlO.IlO;
            if (ev == null || (list = ev.IlO) == null || list.size() <= 0) {
                return IlO(this.IlO);
            }
            ArrayList arrayList = new ArrayList(this.IlO.IlO.IlO);
            arrayList.add(new com.bytedance.sdk.component.MY.IlO.lEW() { // from class: com.bytedance.sdk.component.MY.IlO.IlO.IlO.MY.1
                @Override // com.bytedance.sdk.component.MY.IlO.lEW
                public bWL IlO(lEW.IlO ilO2) throws IOException {
                    return MY.this.IlO(ilO2.IlO());
                }
            });
            return ((com.bytedance.sdk.component.MY.IlO.lEW) arrayList.get(0)).IlO(new EO(arrayList, this.IlO));
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.MY.IlO.MY clone() {
        return new MY(this.IlO, this.MY);
    }

    private boolean IlO(hp hpVar) {
        rp rpVar;
        byte[] bArr;
        return hpVar != null && (rpVar = this.IlO) != null && "POST".equalsIgnoreCase(rpVar.EO()) && hpVar.vCE == hp.IlO.BYTE_ARRAY_TYPE && (bArr = hpVar.Cc) != null && bArr.length > 0;
    }

    public bWL IlO(rp rpVar) throws IOException {
        return IlO(rpVar, com.bytedance.sdk.component.Bc.IlO.Cc());
    }

    public bWL IlO(rp rpVar, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection;
        IOException e;
        String strIlO;
        int responseCode = lEW.IlO;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(rpVar.MY().IlO().toString()).openConnection();
                if (z2) {
                    try {
                        if (!"setting".equals(rpVar.vCE()) && !"gecko".equals(rpVar.vCE()) && !"load_ug_t".equals(rpVar.vCE())) {
                            IlO(httpURLConnection);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        if (responseCode == -1 && z2) {
                            bWL bwlIlO = IlO(rpVar, false);
                            this.MY.tV().remove(this);
                            return bwlIlO;
                        }
                        strIlO = IlO(httpURLConnection, e);
                        this.MY.tV().remove(this);
                    } catch (Exception e8) {
                        e = e8;
                        httpURLConnection2 = httpURLConnection;
                        strIlO = IlO(httpURLConnection2, e);
                        this.MY.tV().remove(this);
                    }
                }
                if (rpVar.tV() != null && rpVar.tV().size() > 0) {
                    for (Map.Entry<String, List<String>> entry : rpVar.tV().entrySet()) {
                        String key = entry.getKey();
                        for (String str : entry.getValue()) {
                            if ("_disable_retry".equals(key) && "1".equals(str)) {
                                MY(httpURLConnection);
                            } else {
                                httpURLConnection.addRequestProperty(key, str);
                            }
                        }
                    }
                }
                EV ev = rpVar.IlO;
                if (ev != null) {
                    TimeUnit timeUnit = ev.EO;
                    if (timeUnit != null) {
                        httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(ev.MY));
                    }
                    EV ev2 = rpVar.IlO;
                    if (ev2.EO != null) {
                        httpURLConnection.setReadTimeout((int) ev2.Cc.toMillis(ev2.tV));
                    }
                }
                if (rpVar.lEW() == null) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    if (!Cc() && rpVar.lEW().EO != null) {
                        httpURLConnection.addRequestProperty("Content-Type", rpVar.lEW().EO.IlO());
                    }
                    httpURLConnection.setRequestMethod(rpVar.EO());
                    if ("POST".equalsIgnoreCase(rpVar.EO())) {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        if (IlO(rpVar.lEW())) {
                            outputStream.write(rpVar.lEW().Cc);
                        } else if (MY(rpVar.lEW())) {
                            outputStream.write(rpVar.lEW().tV.getBytes());
                        }
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                com.bytedance.sdk.component.EO.IlO.IlO ilO = rpVar.MY;
                if (ilO != null) {
                    ilO.MY();
                }
                httpURLConnection.connect();
                com.bytedance.sdk.component.EO.IlO.IlO ilO2 = rpVar.MY;
                if (ilO2 != null) {
                    ilO2.EO();
                }
                responseCode = httpURLConnection.getResponseCode();
                com.bytedance.sdk.component.EO.IlO.IlO ilO3 = rpVar.MY;
                if (ilO3 != null) {
                    ilO3.Cc();
                }
            } catch (IOException e9) {
                httpURLConnection = null;
                e = e9;
            } catch (Exception e10) {
                e = e10;
            }
            if (this.EO.get()) {
                httpURLConnection.disconnect();
                this.MY.tV().remove(this);
                strIlO = "internal error";
                return new lEW(responseCode, strIlO, rpVar);
            }
            lEW lew = new lEW(httpURLConnection, rpVar);
            this.MY.tV().remove(this);
            return lew;
        } catch (Throwable th) {
            this.MY.tV().remove(this);
            throw th;
        }
    }

    private boolean MY(hp hpVar) {
        rp rpVar;
        return (hpVar == null || (rpVar = this.IlO) == null || !"POST".equalsIgnoreCase(rpVar.EO()) || hpVar.vCE != hp.IlO.STRING_TYPE || TextUtils.isEmpty(hpVar.tV)) ? false : true;
    }

    private static void MY(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            obj2.getClass().getDeclaredMethod("setRetryOnConnectionFailure", Boolean.TYPE).invoke(obj2, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }

    private static String IlO(HttpURLConnection httpURLConnection, Exception exc) {
        try {
            return httpURLConnection.getErrorStream().toString();
        } catch (Throwable unused) {
            return exc.getMessage();
        }
    }

    private static void IlO(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (tV.size() == 2) {
                obj2.getClass().getDeclaredMethod("setProtocols", List.class).invoke(obj2, tV);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY
    public void IlO(final com.bytedance.sdk.component.MY.IlO.EO eo) {
        com.bytedance.sdk.component.EO.IlO.IlO ilO;
        rp rpVar = this.IlO;
        if (rpVar != null && (ilO = rpVar.MY) != null) {
            ilO.ea();
        }
        this.MY.MY().submit(new com.bytedance.sdk.component.lEW.EO.MY(this.IlO.Bc(), this.IlO.vCE()) { // from class: com.bytedance.sdk.component.MY.IlO.IlO.IlO.MY.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    bWL bwlMY = MY.this.MY();
                    if (bwlMY == null) {
                        eo.IlO(MY.this, new IOException("response is null"));
                    } else {
                        eo.IlO(MY.this, bwlMY);
                    }
                } catch (IOException e) {
                    eo.IlO(MY.this, e);
                }
            }
        });
    }
}

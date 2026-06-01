package com.bytedance.sdk.openadsdk.oeT;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.G5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private tV EO;
    private MY MY;
    private IlO tV;
    private final String IlO = "StrategyCenter";
    private int Cc = 0;
    private Runnable vCE = new Runnable() { // from class: com.bytedance.sdk.openadsdk.oeT.EO.2
        @Override // java.lang.Runnable
        public void run() {
            EO.this.MY();
        }
    };

    public EO(tV tVVar) {
        this.MY = null;
        Cc cc = new Cc(tVVar);
        this.EO = cc;
        String strEO = cc.EO();
        if (!TextUtils.isEmpty(strEO) && !strEO.startsWith("pag")) {
            strEO = "pag_".concat(strEO);
        }
        this.MY = new MY(this.EO.MY(), strEO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        tV tVVar = this.EO;
        if (tVVar == null || tVVar.Cc() == null || this.EO.vCE() == null) {
            return;
        }
        this.EO.IlO().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oeT.EO.1
            @Override // java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                OutputStream outputStream;
                EO.this.Cc++;
                try {
                    if (EO.this.tV != null) {
                        EO.this.tV.IlO();
                    }
                    httpURLConnection = (HttpURLConnection) new URL(EO.this.EO.Cc()).openConnection();
                    if (EO.this.EO.Bc() != null && EO.this.EO.Bc().size() > 0) {
                        for (Map.Entry<String, String> entry : EO.this.EO.Bc().entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", G5.L);
                    try {
                        outputStream = httpURLConnection.getOutputStream();
                    } catch (Throwable th) {
                        th = th;
                        outputStream = null;
                    }
                } catch (Throwable th2) {
                    Log.e("StrategyCenter", th2.getMessage() == null ? "error " : th2.getMessage());
                    if (EO.this.tV != null) {
                        EO.this.tV.IlO(-1, th2.getMessage());
                    }
                }
                try {
                    outputStream.write(EO.this.EO.vCE().toString().getBytes());
                    outputStream.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i("StrategyCenter", "executing strategy fetch");
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                stringBuffer.append(line);
                            }
                        }
                        bufferedReader.close();
                        JSONObject jSONObjectIlO = EO.this.EO.IlO(new JSONObject(stringBuffer.toString()));
                        EO.this.MY.IlO();
                        EO.this.MY.IlO(jSONObjectIlO);
                        if (EO.this.tV != null) {
                            EO.this.tV.MY();
                        }
                    } else if (EO.this.tV != null) {
                        EO.this.tV.IlO(responseCode, httpURLConnection.getResponseMessage());
                    }
                    EO.this.MY.IlO("local_last_update_time", System.currentTimeMillis());
                    EO.this.IlO();
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            }
        });
    }

    public void IlO(IlO ilO) {
        this.tV = ilO;
    }

    public void IlO() {
        if (this.EO != null) {
            int i2 = 3600000;
            int iIlO = this.MY.IlO("req_interval", 3600000);
            long j = 0;
            long jMY = this.MY.MY("local_last_update_time", 0L);
            if (iIlO >= 600000 && iIlO <= 86400000) {
                i2 = iIlO;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - jMY;
            Log.i("StrategyCenter", "before  realInterval=".concat(String.valueOf(jCurrentTimeMillis)));
            if (jCurrentTimeMillis >= 0) {
                long j3 = i2;
                if (jCurrentTimeMillis <= j3) {
                    j = j3 - jCurrentTimeMillis;
                }
            }
            Log.i("StrategyCenter", "after  realInterval=".concat(String.valueOf(j)));
            this.EO.tV().removeCallbacks(this.vCE);
            if (this.Cc > 24) {
                return;
            }
            this.EO.tV().postDelayed(this.vCE, j);
        }
    }

    public int IlO(String str, int i2) {
        MY my = this.MY;
        return my == null ? i2 : my.IlO(str, i2);
    }

    public String IlO(String str, String str2) {
        MY my = this.MY;
        return my == null ? str2 : my.IlO(str, str2);
    }

    public boolean IlO(String str, boolean z2) {
        MY my = this.MY;
        return my == null ? z2 : my.IlO(str, z2);
    }
}

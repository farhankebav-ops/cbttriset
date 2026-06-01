package com.mimikridev.ads.util;

import android.app.Activity;
import android.util.Log;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class CheckStatus extends AsyncTaskExecutor<Void, Void, String> {
    public static final String TAG = "CheckStatus";
    public static boolean isWortise = true;
    Activity activity;
    String line;
    HttpURLConnection httpURLConnection = null;
    BufferedReader bufferedReader = null;

    public CheckStatus(Activity activity) {
        this.activity = activity;
    }

    @Override // com.mimikridev.ads.util.AsyncTaskExecutor
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.mimikridev.ads.util.AsyncTaskExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void r6) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mimikridev.ads.util.CheckStatus.doInBackground(java.lang.Void):java.lang.String");
    }

    @Override // com.mimikridev.ads.util.AsyncTaskExecutor
    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$execute$2(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("wortise");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Response response = new Response();
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    response.setStatus(jSONObject.getBoolean("status"));
                    response.setTitle(jSONObject.getString("title"));
                    response.setMessage(jSONObject.getString("message"));
                    arrayList.add(response);
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                if (!((Response) arrayList.get(0)).status) {
                    isWortise = false;
                    n1.b bVar = new n1.b(this.activity, 0);
                    bVar.d(((Response) arrayList.get(0)).title);
                    bVar.b(((Response) arrayList.get(0)).message);
                    bVar.c(new c());
                    bVar.a();
                    bVar.show();
                    Log.d(TAG, "Wortise Ads is discontinued");
                }
                Log.d(TAG, "Status: " + ((Response) arrayList.get(0)).status);
                Log.d(TAG, "Title: " + ((Response) arrayList.get(0)).title);
                Log.d(TAG, "Message: " + ((Response) arrayList.get(0)).message);
            } catch (JSONException e) {
                Log.d(TAG, "error: " + e.getMessage());
            }
        }
    }
}

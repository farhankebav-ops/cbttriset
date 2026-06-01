package com.google.firebase.crashlytics.internal.network;

import a1.a;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.ironsource.C2300e4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpGetRequest {
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private static final String METHOD_GET = "GET";
    private static final int READ_BUFFER_SIZE = 8192;
    private final Map<String, String> headers = new HashMap();
    private final Map<String, String> queryParams;
    private final String url;

    public HttpGetRequest(String str, Map<String, String> map) {
        this.url = str;
        this.queryParams = map;
    }

    private String createParamsString(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        Map.Entry<String, String> next = it.next();
        sb.append(next.getKey());
        sb.append(C2300e4.i.f8399b);
        sb.append(next.getValue() != null ? URLEncoder.encode(next.getValue(), Key.STRING_CHARSET_NAME) : "");
        while (it.hasNext()) {
            Map.Entry<String, String> next2 = it.next();
            sb.append(C2300e4.i.f8401c);
            sb.append(next2.getKey());
            sb.append(C2300e4.i.f8399b);
            sb.append(next2.getValue() != null ? URLEncoder.encode(next2.getValue(), Key.STRING_CHARSET_NAME) : "");
        }
        return sb.toString();
    }

    private String createUrlWithParams(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String strCreateParamsString = createParamsString(map);
        if (strCreateParamsString.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return a.D(str, "?", strCreateParamsString);
        }
        if (!str.endsWith(C2300e4.i.f8401c)) {
            strCreateParamsString = C2300e4.i.f8401c.concat(strCreateParamsString);
        }
        return a.C(str, strCreateParamsString);
    }

    private String readStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Key.STRING_CHARSET_NAME));
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = bufferedReader.read(cArr);
            if (i2 == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, i2);
        }
    }

    public HttpResponse execute() throws Throwable {
        HttpsURLConnection httpsURLConnection;
        CrashlyticsWorkers.checkBlockingThread();
        InputStream inputStream = null;
        String stream = null;
        inputStream = null;
        try {
            String strCreateUrlWithParams = createUrlWithParams(this.url, this.queryParams);
            Logger.getLogger().v("GET Request URL: " + strCreateUrlWithParams);
            httpsURLConnection = (HttpsURLConnection) new URL(strCreateUrlWithParams).openConnection();
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                    httpsURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        stream = readStream(inputStream2);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new HttpResponse(responseCode, stream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
    }

    public HttpGetRequest header(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public HttpGetRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }
}

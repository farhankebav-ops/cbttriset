package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.r;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.ironsource.i7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2375i7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8715a = 15000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8716b = "GET";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8717c = "POST";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8718d = "UTF-8";
    public static final String e = "ERROR:";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8719f = "Bad Request - 400";
    private static final ExecutorService g = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: com.ironsource.i7$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC2392j7 f8722c;

        public a(String str, String str2, InterfaceC2392j7 interfaceC2392j7) {
            this.f8720a = str;
            this.f8721b = str2;
            this.f8722c = interfaceC2392j7;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            HttpURLConnection httpURLConnectionB;
            OutputStream outputStream = null;
            try {
                httpURLConnectionB = C2375i7.b(this.f8720a);
            } catch (Exception e) {
                e = e;
                httpURLConnectionB = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnectionB = null;
                C2375i7.a(outputStream, httpURLConnectionB, (BufferedReader) null);
                throw th;
            }
            try {
                try {
                    outputStream = httpURLConnectionB.getOutputStream();
                    C2375i7.a(this.f8721b, outputStream);
                    int responseCode = httpURLConnectionB.getResponseCode();
                    boolean z2 = responseCode == 200;
                    if (!z2) {
                        IronLog.INTERNAL.error("invalid response code " + responseCode + " sending request");
                    }
                    this.f8722c.a(z2);
                } catch (Throwable th2) {
                    th = th2;
                    C2375i7.a(outputStream, httpURLConnectionB, (BufferedReader) null);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                C2531r4.d().a(e);
                IronLog.INTERNAL.error("exception while sending request " + e.getMessage());
                this.f8722c.a(false);
            }
            C2375i7.a(outputStream, httpURLConnectionB, (BufferedReader) null);
        }
    }

    public static String a(String str) throws Exception {
        return a(str, (r.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpURLConnection b(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(f8715a);
        httpURLConnection.setConnectTimeout(f8715a);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    public static String a(String str, r.b bVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        Exception e4;
        BufferedReader bufferedReader2;
        Throwable th;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e8) {
            e = e8;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            bufferedReader = null;
        }
        try {
            httpURLConnection.setReadTimeout(f8715a);
            httpURLConnection.setConnectTimeout(f8715a);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 400) {
                if (bVar != null) {
                    bVar.a(f8719f);
                }
                a((OutputStream) null, httpURLConnection, (BufferedReader) null);
                return null;
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            try {
                String strA = a(bufferedReader2);
                a((OutputStream) null, httpURLConnection, bufferedReader2);
                return strA;
            } catch (Exception e9) {
                e4 = e9;
                try {
                    C2531r4.d().a(e4);
                    a((OutputStream) null, httpURLConnection, bufferedReader2);
                    return null;
                } catch (Throwable th3) {
                    bufferedReader = bufferedReader2;
                    th = th3;
                    BufferedReader bufferedReader3 = bufferedReader;
                    th = th;
                    bufferedReader2 = bufferedReader3;
                    a((OutputStream) null, httpURLConnection, bufferedReader2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                a((OutputStream) null, httpURLConnection, bufferedReader2);
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            e4 = e;
            bufferedReader2 = null;
            C2531r4.d().a(e4);
            a((OutputStream) null, httpURLConnection, bufferedReader2);
            return null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            BufferedReader bufferedReader32 = bufferedReader;
            th = th;
            bufferedReader2 = bufferedReader32;
            a((OutputStream) null, httpURLConnection, bufferedReader2);
            throw th;
        }
    }

    public static void a(String str, String str2, InterfaceC2392j7 interfaceC2392j7) {
        g.submit(new a(str, str2, interfaceC2392j7));
    }

    public static String a(String str, String str2, r.b bVar) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        Exception e4;
        HttpURLConnection httpURLConnectionB;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnectionB = b(str);
            try {
                httpURLConnectionB.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                outputStream = httpURLConnectionB.getOutputStream();
            } catch (Exception e8) {
                e4 = e8;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                outputStream = null;
            }
        } catch (Exception e9) {
            e4 = e9;
            httpURLConnectionB = null;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            outputStream = null;
            httpURLConnectionB = httpURLConnection;
            a(outputStream, httpURLConnectionB, bufferedReader);
            throw th;
        }
        try {
            a(str2, outputStream);
            int responseCode = httpURLConnectionB.getResponseCode();
            if (responseCode == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionB.getInputStream()));
                try {
                    String strA = a(bufferedReader);
                    a(outputStream, httpURLConnectionB, bufferedReader);
                    return strA;
                } catch (Exception e10) {
                    e4 = e10;
                    try {
                        C2531r4.d().a(e4);
                        IronLog.INTERNAL.error("exception while sending request " + e4.getMessage());
                        a(outputStream, httpURLConnectionB, bufferedReader);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection = httpURLConnectionB;
                        httpURLConnectionB = httpURLConnection;
                        a(outputStream, httpURLConnectionB, bufferedReader);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    a(outputStream, httpURLConnectionB, bufferedReader);
                    throw th;
                }
            }
            if (responseCode == 400 && bVar != null) {
                bVar.a(f8719f);
            }
            a(outputStream, httpURLConnectionB, (BufferedReader) null);
            return null;
        } catch (Exception e11) {
            e4 = e11;
            bufferedReader = null;
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("exception while sending request " + e4.getMessage());
            a(outputStream, httpURLConnectionB, bufferedReader);
            return null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            httpURLConnection = httpURLConnectionB;
            httpURLConnectionB = httpURLConnection;
            a(outputStream, httpURLConnectionB, bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(str);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(OutputStream outputStream, HttpURLConnection httpURLConnection, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error("exception while closing output stream " + e4.getMessage());
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                C2531r4.d().a(e8);
                IronLog.INTERNAL.error("exception while closing reader " + e8.getMessage());
            }
        }
    }
}

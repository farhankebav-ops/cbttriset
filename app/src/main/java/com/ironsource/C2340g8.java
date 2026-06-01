package com.ironsource;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLException;

/* JADX INFO: renamed from: com.ironsource.g8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2340g8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8594a = "POST";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8595b = "GET";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8596c = "ISHttpService";

    /* JADX INFO: renamed from: com.ironsource.g8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {
        private static final int h = 15000;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f8597i = 15000;
        private static final String j = "UTF-8";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f8598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f8599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f8600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f8601d;
        final int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f8602f;
        ArrayList<Pair<String, String>> g;

        /* JADX INFO: renamed from: com.ironsource.g8$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static class C0182a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            String f8604b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            String f8606d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            List<Pair<String, String>> f8603a = new ArrayList();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            String f8605c = "POST";
            int e = 15000;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f8607f = 15000;
            String g = "UTF-8";

            public C0182a a(String str) {
                this.f8606d = str;
                return this;
            }

            public C0182a b(String str) {
                this.g = str;
                return this;
            }

            public C0182a c(String str) {
                this.f8604b = str;
                return this;
            }

            public C0182a d(String str) {
                this.f8605c = str;
                return this;
            }

            public C0182a a(int i2) {
                this.e = i2;
                return this;
            }

            public C0182a b(int i2) {
                this.f8607f = i2;
                return this;
            }

            public C0182a a(Pair<String, String> pair) {
                this.f8603a.add(pair);
                return this;
            }

            public C0182a a(List<Pair<String, String>> list) {
                this.f8603a.addAll(list);
                return this;
            }

            public a a() {
                return new a(this);
            }
        }

        public a(C0182a c0182a) {
            this.f8598a = c0182a.f8604b;
            this.f8599b = c0182a.f8605c;
            this.f8600c = c0182a.f8606d;
            this.g = new ArrayList<>(c0182a.f8603a);
            this.f8601d = c0182a.e;
            this.e = c0182a.f8607f;
            this.f8602f = c0182a.g;
        }

        public boolean a() {
            return "POST".equals(this.f8599b);
        }
    }

    public static Gd a(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri uriBuild = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        a.C0182a c0182a = new a.C0182a();
        c0182a.c(uriBuild.toString()).a(str2).d("GET").a(list);
        return b(c0182a.a());
    }

    public static Gd b(String str, String str2, List<Pair<String, String>> list) throws Exception {
        a.C0182a c0182a = new a.C0182a();
        c0182a.c(str).a(str2).d("POST").a(list);
        return b(c0182a.a());
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0067: MOVE (r8 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:32:0x0067 */
    public static Gd b(a aVar) throws Exception {
        HttpURLConnection httpURLConnectionA;
        InputStream inputStream;
        InputStream inputStream2;
        if (a(aVar.f8598a, aVar.f8600c)) {
            Gd gd = new Gd();
            InputStream inputStream3 = null;
            inputStream3 = null;
            inputStream3 = null;
            inputStream3 = null;
            inputStream3 = null;
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    httpURLConnectionA = a(aVar);
                } catch (InterruptedIOException e) {
                    e = e;
                    Log.d(f8596c, "Failed post to " + aVar.f8598a + " exception: " + e.getMessage());
                    throw e;
                } catch (SSLException e4) {
                    e = e4;
                    Log.d(f8596c, "Failed post to " + aVar.f8598a + " exception: " + e.getMessage());
                    throw e;
                } catch (IOException e8) {
                    e = e8;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnectionA = null;
                }
                try {
                    a(httpURLConnectionA, aVar.g);
                    a(httpURLConnectionA, aVar);
                    inputStream3 = httpURLConnectionA.getInputStream();
                    gd.f6881a = httpURLConnectionA.getResponseCode();
                    if (inputStream3 != null) {
                        gd.f6882b = C2401jg.a(inputStream3);
                    }
                } catch (InterruptedIOException e9) {
                    e = e9;
                    Log.d(f8596c, "Failed post to " + aVar.f8598a + " exception: " + e.getMessage());
                    throw e;
                } catch (SSLException e10) {
                    e = e10;
                    Log.d(f8596c, "Failed post to " + aVar.f8598a + " exception: " + e.getMessage());
                    throw e;
                } catch (IOException e11) {
                    e = e11;
                    inputStream = inputStream3;
                    httpURLConnection = httpURLConnectionA;
                    C2531r4.d().a(e);
                    if (httpURLConnection != null && httpURLConnection.getHeaderFields().isEmpty()) {
                        throw new Gc(e);
                    }
                    if (httpURLConnection != null) {
                        int responseCode = httpURLConnection.getResponseCode();
                        gd.f6881a = responseCode;
                        if (responseCode >= 400) {
                            Log.d(f8596c, "Failed post to " + aVar.f8598a + " StatusCode: " + gd.f6881a);
                            if (inputStream != null) {
                                InputStream inputStream4 = inputStream;
                                httpURLConnectionA = httpURLConnection;
                                inputStream3 = inputStream4;
                                inputStream3.close();
                            } else {
                                httpURLConnectionA = httpURLConnection;
                            }
                        }
                    }
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                    throw th;
                }
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                httpURLConnectionA.disconnect();
                return gd;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnectionA = null;
                inputStream3 = inputStream2;
            }
        } else {
            throw new InvalidParameterException("not valid params");
        }
    }

    private static void a(HttpURLConnection httpURLConnection, a aVar) throws Exception {
        if (aVar.a()) {
            byte[] bytes = aVar.f8600c.getBytes(aVar.f8602f);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
            a(httpURLConnection, bytes);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair<String, String> pair : list) {
            httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }

    private static boolean a(String str, String str2) {
        return (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) ? false : true;
    }

    private static HttpURLConnection a(a aVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.f8598a).openConnection();
        httpURLConnection.setConnectTimeout(aVar.f8601d);
        httpURLConnection.setReadTimeout(aVar.e);
        httpURLConnection.setRequestMethod(aVar.f8599b);
        return httpURLConnection;
    }
}

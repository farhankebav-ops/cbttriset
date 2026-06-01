package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.ironsource.C2270ca;
import com.ironsource.C2461n2;
import com.ironsource.C2496p2;
import com.ironsource.C2499p5;
import com.ironsource.C2531r4;
import com.ironsource.L9;
import com.ironsource.Me;
import com.ironsource.S1;
import com.ironsource.Y1;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9163a = "1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9164b = "102";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9165c = "102";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9166d = "GenericNotifications";
    private f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IronSource.a f9167f;
    private C2496p2 g;
    private S1 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ISBannerSize f9168i;

    public e(f fVar) {
        this.e = fVar;
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i2, C2270ca c2270ca, ISBannerSize iSBannerSize) {
        this.f9168i = iSBannerSize;
        a(context, map, list, hVar, i2, c2270ca);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected S1 f9169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected d.a f9170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f9171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected String f9172d;
        protected long e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f9173f;
        private int h;
        private final URL k;
        private final JSONObject l;
        private final boolean m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f9175n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final long f9176o;
        private final boolean p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final boolean f9177q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f9178r;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected String f9174i = "";
        protected int j = 0;
        protected String g = a((Integer) null);

        public a(S1 s12, URL url, JSONObject jSONObject, boolean z2, C2496p2 c2496p2) {
            this.f9169a = s12;
            this.k = url;
            this.l = jSONObject;
            this.m = z2;
            this.f9175n = c2496p2.g();
            this.f9176o = c2496p2.m();
            this.p = c2496p2.o();
            this.f9177q = c2496p2.p();
            this.h = c2496p2.d();
            this.f9178r = c2496p2.n();
        }

        private void a(long j, long j3) {
            long time = j - (new Date().getTime() - j3);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        public boolean b() {
            long time;
            int responseCode;
            this.e = new Date().getTime();
            try {
                this.h = this.j == 1015 ? 1 : this.h;
                this.f9173f = 0;
                HttpURLConnection httpURLConnectionA = null;
                while (true) {
                    int i2 = this.f9173f;
                    int i8 = this.f9175n;
                    if (i2 >= i8) {
                        this.f9173f = i8 - 1;
                        this.g = a(Integer.valueOf(this.f9171c));
                        return false;
                    }
                    try {
                        time = new Date().getTime();
                        String str = "Auction Handler: auction trial " + (this.f9173f + 1) + " out of " + this.f9175n + " max trials";
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                        IronSourceUtils.i(str);
                        httpURLConnectionA = a(this.k, this.f9176o);
                        a(httpURLConnectionA, this.l, this.p);
                        responseCode = httpURLConnectionA.getResponseCode();
                    } catch (SocketTimeoutException e) {
                        C2531r4.d().a(e);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        this.f9171c = 1006;
                        this.f9172d = "Connection timed out";
                        IronLog.INTERNAL.error("Auction socket timeout exception " + e.getMessage());
                    } catch (Throwable th) {
                        C2531r4.d().a(th);
                        IronLog.INTERNAL.error("getting exception " + th);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        this.f9171c = 1000;
                        this.f9172d = th.getMessage();
                        this.g = a(Integer.valueOf(this.f9171c));
                        return false;
                    }
                    if (responseCode == 200 || responseCode == 204) {
                        try {
                            a(a(httpURLConnectionA), this.m, this.f9177q);
                            httpURLConnectionA.disconnect();
                            return true;
                        } catch (JSONException e4) {
                            C2531r4.d().a(e4);
                            if (e4.getMessage() != null && e4.getMessage().equalsIgnoreCase("decryption error")) {
                                this.f9171c = 1003;
                                this.f9172d = "Auction decryption error";
                            } else if (e4.getMessage() == null || !e4.getMessage().equalsIgnoreCase("decompression error")) {
                                this.f9171c = 1002;
                                this.f9172d = "Auction parsing error";
                            } else {
                                this.f9171c = 1008;
                                this.f9172d = "Auction decompression error";
                            }
                            this.g = a(Integer.valueOf(this.f9171c));
                            IronLog.INTERNAL.error("Auction handle response exception " + e4.getMessage());
                            httpURLConnectionA.disconnect();
                            return false;
                        }
                    }
                    this.f9171c = 1001;
                    String str2 = "Auction response code not valid, error code response from server - " + responseCode;
                    this.f9172d = str2;
                    IronLog.INTERNAL.error(str2);
                    httpURLConnectionA.disconnect();
                    if (this.f9173f < this.f9175n - 1) {
                        a(this.f9176o, time);
                    }
                    this.f9173f++;
                }
            } catch (Exception e8) {
                C2531r4.d().a(e8);
                this.f9171c = 1007;
                this.f9172d = e8.getMessage();
                this.f9173f = 0;
                this.g = a(Integer.valueOf(this.f9171c));
                IronLog.INTERNAL.error("Auction request exception " + e8.getMessage());
                return false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zB = b();
            S1 s12 = this.f9169a;
            if (s12 == null) {
                return;
            }
            a(zB, s12, new Date().getTime() - this.e);
        }

        private String a() {
            if (this.h == 2) {
                return C2499p5.b().d();
            }
            return C2499p5.b().c();
        }

        private void a(HttpURLConnection httpURLConnection, JSONObject jSONObject, boolean z2) throws Exception {
            String strA;
            String strE;
            String str;
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Key.STRING_CHARSET_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            if (this.h == 2) {
                try {
                    strA = C2499p5.b().a();
                } catch (JSONException e) {
                    C2531r4.d().a(e);
                    this.f9174i = e.getLocalizedMessage();
                    this.j = 1015;
                    this.h = 1;
                    IronLog.INTERNAL.error("get encrypted session key exception " + e.getMessage());
                    strA = "";
                }
            } else {
                strA = "";
            }
            String string = jSONObject.toString();
            String strA2 = a();
            if (z2) {
                IronLog.INTERNAL.verbose("compressing and encrypting auction request");
                strE = L9.a(strA2, string);
            } else {
                strE = L9.e(strA2, string);
            }
            if (this.h == 2) {
                str = String.format("{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}", strA, strE);
            } else {
                str = String.format("{\"request\" : \"%1$s\"}", strE);
            }
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }

        private HttpURLConnection a(URL url, long j) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        public JSONObject a(JSONObject jSONObject, boolean z2) throws JSONException {
            String str;
            String strA = a();
            if (this.h == 2) {
                str = "ct";
            } else {
                str = Me.f7195n;
            }
            String string = jSONObject.getString(str);
            if (z2) {
                return b(strA, string);
            }
            return a(strA, string);
        }

        public void a(String str, boolean z2, boolean z7) throws JSONException {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z2) {
                    jSONObject = a(jSONObject, z7);
                }
                d.a aVarA = d.b().a(jSONObject);
                this.f9170b = aVarA;
                this.f9171c = aVarA.c();
                this.f9172d = this.f9170b.d();
                return;
            }
            throw new JSONException("empty response");
        }

        private JSONObject a(String str, String str2) throws JSONException {
            String strB = L9.b(str, str2);
            if (!TextUtils.isEmpty(strB)) {
                return new JSONObject(strB);
            }
            throw new JSONException("decryption error");
        }

        private String a(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        private JSONObject b(String str, String str2) throws JSONException {
            IronLog.INTERNAL.verbose("decrypting and decompressing auction response");
            String strD = L9.d(str, str2);
            if (strD != null) {
                return new JSONObject(strD);
            }
            throw new JSONException("decompression error");
        }

        public void a(boolean z2, S1 s12, long j) {
            if (z2) {
                s12.a(this.f9170b.h(), this.f9170b.a(), this.f9170b.e(), this.f9170b.f(), this.f9170b.b(), this.f9173f + 1, j, this.j, this.f9174i);
            } else {
                s12.a(this.f9171c, this.f9172d, this.f9173f + 1, this.g, j);
            }
        }

        private String a(Integer num) {
            return Y1.f7804a.a(this.f9178r, num);
        }
    }

    public void a(Context context, i iVar, S1 s12) {
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.e.a(context, iVar, s12));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("execute auction exception " + e.getMessage());
            if (s12 != null) {
                s12.a(1000, e.getMessage(), 0, Y1.f7804a.a(this.e.a(), 1000), 0L);
            }
        }
    }

    @Deprecated
    public e(IronSource.a aVar, C2496p2 c2496p2, S1 s12) {
        this.f9167f = aVar;
        this.g = c2496p2;
        this.h = s12;
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i2, C2270ca c2270ca) {
        e eVar;
        try {
            boolean zG = IronSourceUtils.g();
            eVar = this;
            try {
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(eVar.h, new URL(eVar.g.a(false)), eVar.a(map, list, hVar, i2, zG, c2270ca), zG, eVar.g));
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                C2531r4.d().a(exc);
                IronLog.INTERNAL.error("execute auction exception " + exc.getMessage());
                eVar.h.a(1000, exc.getMessage(), 0, Y1.f7804a.a(eVar.g.n(), 1000), 0L);
            }
        } catch (Exception e4) {
            e = e4;
            eVar = this;
        }
    }

    public void a(C2461n2 c2461n2, int i2, C2461n2 c2461n22, String str) {
        Iterator<String> it = c2461n2.b().iterator();
        while (it.hasNext()) {
            C2461n2 c2461n23 = c2461n2;
            int i8 = i2;
            String str2 = str;
            d.b().a("reportImpression", c2461n23.c(), d.b().a(it.next(), i8, c2461n23, "", "", str2));
            i2 = i8;
            c2461n2 = c2461n23;
            str = str2;
        }
        C2461n2 c2461n24 = c2461n2;
        int i9 = i2;
        String str3 = str;
        if (c2461n22 != null) {
            Iterator<String> it2 = c2461n22.b().iterator();
            while (it2.hasNext()) {
                d.b().a("reportImpression", "GenericNotifications", d.b().a(it2.next(), i9, c2461n24, "", "102", str3));
            }
        }
    }

    public void a(C2461n2 c2461n2, int i2, C2461n2 c2461n22) {
        Iterator<String> it = c2461n2.h().iterator();
        while (it.hasNext()) {
            C2461n2 c2461n23 = c2461n2;
            int i8 = i2;
            d.b().a("reportLoadSuccess", c2461n23.c(), d.b().a(it.next(), i8, c2461n23, "", "", ""));
            i2 = i8;
            c2461n2 = c2461n23;
        }
        C2461n2 c2461n24 = c2461n2;
        int i9 = i2;
        if (c2461n22 != null) {
            Iterator<String> it2 = c2461n22.h().iterator();
            while (it2.hasNext()) {
                d.b().a("reportLoadSuccess", "GenericNotifications", d.b().a(it2.next(), i9, c2461n24, "", "102", ""));
            }
        }
    }

    public void a(CopyOnWriteArrayList<A> copyOnWriteArrayList, ConcurrentHashMap<String, C2461n2> concurrentHashMap, int i2, C2461n2 c2461n2, C2461n2 c2461n22) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<A> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        a(arrayList, concurrentHashMap, i2, c2461n2, c2461n22);
    }

    public void a(ArrayList<String> arrayList, ConcurrentHashMap<String, C2461n2> concurrentHashMap, int i2, C2461n2 c2461n2, C2461n2 c2461n22) {
        int iJ = c2461n22.j();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            String str = arrayList.get(i8);
            i8++;
            String str2 = str;
            if (!str2.equals(c2461n22.c())) {
                C2461n2 c2461n23 = concurrentHashMap.get(str2);
                int iJ2 = c2461n23.j();
                String strI = c2461n23.i();
                String str3 = iJ2 < iJ ? "1" : "102";
                IronLog.INTERNAL.verbose("instance=" + c2461n23.c() + ", instancePriceOrder= " + iJ2 + ", loseReasonCode=" + str3 + ", winnerInstance=" + c2461n22.c() + ", winnerInstancePriceOrder=" + iJ);
                Iterator<String> it = c2461n23.g().iterator();
                while (it.hasNext()) {
                    d.b().a("reportAuctionLose", c2461n23.c(), d.b().a(it.next(), i2, c2461n22, strI, str3, ""));
                }
            }
        }
        if (c2461n2 != null) {
            Iterator<String> it2 = c2461n2.g().iterator();
            while (it2.hasNext()) {
                d.b().a("reportAuctionLose", "GenericNotifications", d.b().a(it2.next(), i2, c2461n22, "", "102", ""));
            }
        }
    }

    private JSONObject a(Map<String, Object> map, List<String> list, h hVar, int i2, boolean z2, C2270ca c2270ca) throws JSONException {
        i iVar = new i(this.f9167f);
        iVar.a(map);
        iVar.a(list);
        iVar.a(hVar);
        iVar.a(i2);
        iVar.a(this.f9168i);
        iVar.a(c2270ca);
        iVar.b(z2);
        return d.b().a(iVar);
    }

    public boolean a() {
        return this.e.b();
    }
}

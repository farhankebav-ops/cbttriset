package sg.bigo.ads.common.u.a;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.Q6;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.u.f;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.common.u.b.c<? extends sg.bigo.ads.common.u.a> f15940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    URL f15941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f15942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f15943d;
    private final g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final URL f15944f;
    private int g;
    private HttpURLConnection h;

    private c(@NonNull sg.bigo.ads.common.u.b.c cVar, @Nullable URL url, @Nullable URL url2, @NonNull b bVar, @Nullable g gVar) {
        this.f15942c = false;
        this.f15940a = cVar;
        this.f15941b = url;
        this.f15944f = url2;
        this.f15943d = bVar;
        this.e = gVar;
        sg.bigo.ads.common.t.a.a(0, 3, "HttpRequest", "request, " + cVar + ", redirectURL= " + url2 + ", content=" + cVar.d());
    }

    public final HttpURLConnection a() throws IOException {
        String str;
        URL urlA = this.f15944f;
        if (urlA == null) {
            this.f15940a.a("PreHost");
            T t3 = this.f15940a.j;
            String strA = t3.a();
            String strF = t3.f();
            String strD = t3.d();
            if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strD) && !TextUtils.equals(strF, strD)) {
                this.f15940a.a("PreHost", strF);
            }
            if (t3.e()) {
                this.f15940a.a("Host", strD);
            }
            this.f15940a.h();
            urlA = a(Uri.parse(strA));
            this.f15941b = urlA;
        } else if (urlA != null && this.e != null && this.f15940a.f15969n) {
            urlA = a(Uri.parse(urlA.toString()));
        }
        boolean zEqualsIgnoreCase = "HTTPS".equalsIgnoreCase(urlA.getProtocol());
        URLConnection uRLConnectionOpenConnection = urlA.openConnection();
        this.h = zEqualsIgnoreCase ? (HttpsURLConnection) uRLConnectionOpenConnection : (HttpURLConnection) uRLConnectionOpenConnection;
        this.h.setInstanceFollowRedirects(false);
        this.h.setDoInput(true);
        this.h.setUseCaches(false);
        this.h.setConnectTimeout((int) this.f15940a.l);
        this.h.setReadTimeout((int) this.f15940a.l);
        this.h.setRequestMethod(this.f15940a.a());
        Map<String, Set<String>> map = this.f15940a.m;
        if (!map.containsKey("Connection")) {
            map.put("Connection", new HashSet(Collections.singletonList("Keep-Alive")));
        }
        Set<String> set = map.get("Range");
        Set<String> set2 = map.get("Accept-Encoding");
        if (k.a(set) && k.a(set2)) {
            this.f15942c = true;
            map.put("Accept-Encoding", new HashSet(Collections.singletonList("gzip")));
        }
        if (!map.containsKey("Host")) {
            try {
                b bVar = this.f15943d;
                String host = this.h.getURL().getHost();
                str = TextUtils.isEmpty(host) ? "" : bVar.f15939a.get(host);
            } catch (Exception unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                map.put("Host", new HashSet(Collections.singletonList(str)));
            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !k.a(value)) {
                for (String str2 : value) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.h.addRequestProperty(key, str2);
                    }
                }
            }
        }
        byte[] bArrC = this.f15940a.c();
        if (bArrC != null && bArrC.length > 0) {
            f fVarB = this.f15940a.b();
            if (fVarB != null) {
                this.h.setRequestProperty("Content-Type", fVarB.toString());
            }
            this.h.setDoOutput(true);
            this.h.setRequestProperty("Content-Length", Long.toString(this.f15940a.e()));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.h.getOutputStream());
            bufferedOutputStream.write(bArrC);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        return this.h;
    }

    public final boolean b() {
        return this.f15944f != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f15944f != null) {
            sb.append("originUrl=");
            sb.append(this.f15940a.g());
            sb.append(", redirectURL=");
            sb.append(this.f15944f);
            sb.append(", redirectCount=");
            sb.append(this.g);
        } else {
            sb.append("requestUrl=");
            sb.append(this.f15940a.g());
        }
        return sb.toString();
    }

    public c(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull b bVar, @Nullable g gVar) {
        this(cVar, null, null, bVar, gVar);
    }

    private URL a(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (this.e == null || !this.f15940a.f15969n) {
            return new URL(uri.toString());
        }
        Uri.Builder builderBuildUpon = Uri.parse(uri.toString()).buildUpon();
        a(builderBuildUpon, "sdk_ver", this.e.y());
        a(builderBuildUpon, "sdk_vc", "50501");
        a(builderBuildUpon, "country", this.e.U());
        a(builderBuildUpon, "app_key", this.e.a());
        a(builderBuildUpon, "pkg_ver", this.e.c());
        StringBuilder sb = new StringBuilder();
        sb.append(this.e.d());
        a(builderBuildUpon, "pkg_vc", sb.toString());
        a(builderBuildUpon, Q6.F, this.e.i());
        a(builderBuildUpon, "os_ver", this.e.j());
        a(builderBuildUpon, "os_lang", this.e.k());
        a(builderBuildUpon, "vendor", this.e.l());
        a(builderBuildUpon, Q6.B, this.e.m());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.e.p());
        a(builderBuildUpon, "dpi", sb2.toString());
        a(builderBuildUpon, "dpi_f", this.e.q());
        a(builderBuildUpon, "resolution", this.e.o());
        a(builderBuildUpon, "net", this.e.r());
        a(builderBuildUpon, "tz", this.e.s());
        if (this.f15940a.f()) {
            a(builderBuildUpon, "enc", "1");
        }
        return new URL(builderBuildUpon.build().toString());
    }

    @NonNull
    public final c a(@NonNull URL url) {
        c cVar = new c(this.f15940a, this.f15941b, url, this.f15943d, this.e);
        cVar.g = this.g + 1;
        return cVar;
    }

    private static void a(Uri.Builder builder, String str, String str2) {
        if (builder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }
}

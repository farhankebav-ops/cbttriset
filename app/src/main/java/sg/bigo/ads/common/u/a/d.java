package sg.bigo.ads.common.u.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.common.MlKitException;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import sg.bigo.ads.common.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final HttpURLConnection f15945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f15946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h<List<String>> f15947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f15948d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f15949f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f15950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f15953d;
        public final int e;

        private a(URL url, String str, int i2, String str2, int i8) {
            this.f15950a = url;
            this.f15951b = str;
            this.f15952c = i2;
            this.f15953d = str2;
            this.e = i8;
        }

        public /* synthetic */ a(URL url, String str, int i2, String str2, int i8, byte b8) {
            this(url, str, i2, str2, i8);
        }
    }

    public d(@NonNull c cVar) throws IOException {
        this.f15948d = cVar;
        HttpURLConnection httpURLConnectionA = cVar.a();
        this.f15945a = httpURLConnectionA;
        this.f15946b = httpURLConnectionA.getResponseCode();
        this.e = httpURLConnectionA.getRequestMethod();
        h<List<String>> hVar = new h<>();
        this.f15947c = hVar;
        Map<String, List<String>> headerFields = httpURLConnectionA.getHeaderFields();
        if (headerFields != null) {
            hVar.a(headerFields);
        }
        boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionA.getContentEncoding());
        this.f15949f = zEqualsIgnoreCase;
        if (zEqualsIgnoreCase && cVar.f15942c) {
            hVar.b("Content-Encoding");
            hVar.b("Content-Length");
        }
    }

    public final InputStream a() throws IOException {
        InputStream inputStream = this.f15945a.getInputStream();
        return (this.f15949f && this.f15948d.f15942c) ? new GZIPInputStream(inputStream) : inputStream;
    }

    @Nullable
    public final a b() {
        int i2 = this.f15946b;
        if (i2 == 307 || i2 == 308) {
            String strA = a("Location");
            if (this.e.equalsIgnoreCase("GET") || this.e.equalsIgnoreCase("HEAD")) {
                return new a(null, strA, 0, "", this.f15946b, (byte) 0);
            }
            return new a(null, strA, 706, "redirect code(" + this.f15946b + ") is only available for GET or HEAD method, current request method is " + this.e, this.f15946b, (byte) 0);
        }
        switch (i2) {
            case MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE /* 300 */:
            case 301:
            case 302:
            case 303:
                String strA2 = a("Location");
                if (TextUtils.isEmpty(strA2)) {
                    return new a(null, strA2, 707, "empty location.", this.f15946b, (byte) 0);
                }
                try {
                    URL url = new URL(this.f15945a.getURL(), strA2);
                    String string = url.toString();
                    if (TextUtils.equals(string, this.f15945a.getURL().toString())) {
                        return new a(url, strA2, 705, a1.a.n("redirect to the same url, location is ", strA2, ", redirectURL is ", string), this.f15946b, (byte) 0);
                    }
                    URL url2 = this.f15948d.f15941b;
                    if (url2 != null && TextUtils.equals(string, url2.toString())) {
                        return new a(url, strA2, 704, a1.a.n("redirect to origin url, location is ", strA2, ", redirectURL is ", string), this.f15946b, (byte) 0);
                    }
                    return new a(url, strA2, 0, "", this.f15946b, (byte) 0);
                } catch (Exception unused) {
                    return new a(null, strA2, IronSourceError.ERROR_NT_INSTANCE_LOAD_TIMEOUT, a1.a.m("location->\"", strA2, "\" is not a network url."), this.f15946b, (byte) 0);
                }
            default:
                return null;
        }
    }

    @Nullable
    private String a(String str) {
        List<String> listA = this.f15947c.a(str);
        int size = listA != null ? listA.size() : 0;
        String str2 = "";
        while (TextUtils.isEmpty(str2) && size > 0) {
            str2 = listA.get(0);
        }
        return str2;
    }
}

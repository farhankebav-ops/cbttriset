package sg.bigo.ads.core.player.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HttpURLConnection f17300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    InputStream f17301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f17302c;

    public g(String str) {
        this.f17302c = str;
    }

    public final int a(byte[] bArr) {
        StringBuilder sb;
        String str;
        InputStream inputStream = this.f17301b;
        if (inputStream == null) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error reading data from " + this.f17302c + ": connection is absent!");
            return 0;
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            e = e;
            sb = new StringBuilder("Reading source ");
            sb.append(this.f17302c);
            str = " is interrupted, error message is : ";
            sb.append(str);
            sb.append(e.toString());
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", sb.toString());
            return 0;
        } catch (IOException e4) {
            e = e4;
            sb = new StringBuilder("Error reading data from ");
            sb.append(this.f17302c);
            str = ", error message is : ";
            sb.append(str);
            sb.append(e.toString());
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", sb.toString());
            return 0;
        }
    }

    public final HttpURLConnection b() {
        HttpURLConnection httpURLConnection;
        String headerField = this.f17302c;
        HttpURLConnection httpURLConnection2 = null;
        int i2 = 0;
        while (true) {
            try {
                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Open connection  to " + headerField);
                httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                if (httpURLConnection == null) {
                    break;
                }
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    boolean z2 = responseCode == 301 || responseCode == 302 || responseCode == 303;
                    if (z2) {
                        headerField = httpURLConnection.getHeaderField("Location");
                        i2++;
                        httpURLConnection.disconnect();
                    }
                    if (i2 > 5) {
                        sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Too many redirects: ".concat(String.valueOf(i2)));
                    }
                    if (!z2) {
                        break;
                    }
                    httpURLConnection2 = httpURLConnection;
                } catch (IOException e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "PingHttpUrlSource#openConnection, error message is : " + e.toString());
                    return httpURLConnection2;
                }
            } catch (IOException e4) {
                e = e4;
            }
        }
        return httpURLConnection;
    }

    public final void a() {
        StringBuilder sb;
        HttpURLConnection httpURLConnection = this.f17300a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                sb = new StringBuilder("Error closing connection correctly, the error message is : ");
                sb.append(e.toString());
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", sb.toString());
            } catch (IllegalArgumentException e4) {
                e = e4;
                sb = new StringBuilder("connection disconnect error..., the error message is : ");
                sb.append(e.toString());
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", sb.toString());
            } catch (NullPointerException e8) {
                e = e8;
                sb = new StringBuilder("connection disconnect error..., the error message is : ");
                sb.append(e.toString());
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", sb.toString());
            }
        }
    }
}

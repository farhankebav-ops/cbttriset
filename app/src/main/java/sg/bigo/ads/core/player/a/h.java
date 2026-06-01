package sg.bigo.ads.core.player.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import sg.bigo.ads.common.m;

/* JADX INFO: loaded from: classes6.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f17303a = Executors.newSingleThreadExecutor(new sg.bigo.ads.common.n.c("Ping"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17305c;

    public class a implements Callable<Boolean> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Boolean call() {
            return Boolean.valueOf(h.this.b());
        }

        public /* synthetic */ a(h hVar, byte b8) {
            this();
        }
    }

    public h(String str, int i2) {
        this.f17304b = (String) m.a(str);
        this.f17305c = i2;
    }

    private List<Proxy> c() {
        ArrayList arrayList = new ArrayList();
        try {
            return ProxySelector.getDefault().select(new URI(d()));
        } catch (URISyntaxException e) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Pinger#getDefaultProxies, error message is : " + e.toString());
            return arrayList;
        }
    }

    private String d() {
        Locale locale = Locale.US;
        return "http://" + this.f17304b + ":" + this.f17305c + "/ping";
    }

    public final boolean a() {
        String str;
        int i2 = 70;
        byte b8 = 0;
        int i8 = 0;
        while (i8 < 3) {
            try {
            } catch (InterruptedException | ExecutionException unused) {
                str = "Error pinging server due to unexpected error";
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", str);
            } catch (TimeoutException unused2) {
                str = "Error pinging server (attempt: " + i8 + ", timeout: " + i2 + "). ";
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", str);
            }
            if (((Boolean) this.f17303a.submit(new a(this, b8)).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i8++;
            i2 *= 2;
        }
        sg.bigo.ads.common.t.a.a(0, "ProxyCache", String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i8), Integer.valueOf(i2 / 2), c()));
        return false;
    }

    public final boolean b() {
        g gVar = new g(d());
        try {
            byte[] bytes = "ping ok".getBytes();
            try {
                HttpURLConnection httpURLConnectionB = gVar.b();
                gVar.f17300a = httpURLConnectionB;
                if (httpURLConnectionB != null) {
                    gVar.f17301b = new BufferedInputStream(gVar.f17300a.getInputStream(), 8192);
                }
            } catch (IOException e) {
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error opening connection for " + gVar.f17302c + " with offset 0, error message is : " + e.toString());
            }
            byte[] bArr = new byte[bytes.length];
            gVar.a(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } finally {
            gVar.a();
        }
    }
}

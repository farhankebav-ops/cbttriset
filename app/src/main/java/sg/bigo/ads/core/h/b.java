package sg.bigo.ads.core.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.a.i;

/* JADX INFO: loaded from: classes6.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f17102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private sg.bigo.ads.core.h.c f17103b;
    boolean g;
    public final C0318b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f17104i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private final b f17105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        private final C0318b f17106b;

        public a(@NonNull b bVar, @NonNull C0318b c0318b) {
            this.f17105a = bVar;
            this.f17106b = c0318b;
        }

        @JavascriptInterface
        public final void onCustomJSEventCallback(String str, String str2) {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", a1.a.n("onCustomJSEventCallback, eventType: ", str, ", eventJson: ", str2));
            sg.bigo.ads.core.h.c customWebChromeClient = this.f17105a.getCustomWebChromeClient();
            if (customWebChromeClient != null) {
                customWebChromeClient.a(this.f17105a, str, str2);
            }
        }

        @JavascriptInterface
        public final void webCollect(String str) {
            String string;
            C0318b c0318b = this.f17106b;
            if (c0318b.f17107a == null) {
                c0318b.f17107a = new ArrayList();
            }
            if (!str.contains("notify") || str.startsWith(C2300e4.i.f8403d)) {
                string = str;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("cur", SystemClock.elapsedRealtime());
                    string = jSONObject.toString();
                } catch (Exception unused) {
                    string = str;
                }
            }
            c0318b.f17107a.add(string);
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "webCollect: ".concat(str));
        }

        @JavascriptInterface
        public final void webStat(String str, String str2) {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", a1.a.n("statUniversalInfo, eventId: ", str, ", msgJson: ", str2));
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.h.b$b, reason: collision with other inner class name */
    public static class C0318b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<String> f17107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<String> f17108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Boolean f17109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Boolean f17110d;
        public long e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f17111f = -1;
        public long g = -1;

        public final boolean a(String str) {
            List<String> list = this.f17108b;
            if (str != null && list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Boolean f17113b;

        private c() {
        }

        public final Boolean a() {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "Try to check not blank by bit");
            if (this.f17113b != null) {
                sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "Has result for checking not blank by bit");
                return this.f17113b;
            }
            b bVar = b.this;
            if (bVar.j) {
                sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "WebView is destroyed stop checking not blank by bit");
                return null;
            }
            int width = bVar.getWidth();
            int height = b.this.getHeight();
            if (width > 0 && height > 0) {
                try {
                    int[] iArr = new int[width * height];
                    Bitmap bitmapA = sg.bigo.ads.common.utils.d.a(width, height, Bitmap.Config.RGB_565);
                    if (bitmapA == null) {
                        return null;
                    }
                    b.this.draw(new Canvas(bitmapA));
                    bitmapA.getPixels(iArr, 0, width, 0, 0, width, height);
                    bitmapA.recycle();
                    this.f17113b = Boolean.valueOf(!a(iArr));
                    sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "The result of current banner checking not blank by bit: " + this.f17113b);
                    return this.f17113b;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public /* synthetic */ c(b bVar, byte b8) {
            this();
        }

        private static boolean a(int[] iArr) {
            if (iArr.length <= 0) {
                return false;
            }
            int length = iArr.length;
            int i2 = length - 1;
            int i8 = 0;
            while (true) {
                int i9 = length / 2;
                if (i8 >= i9 || i2 < i9) {
                    return true;
                }
                if (iArr[i8] != iArr[i2]) {
                    return false;
                }
                i8++;
                i2--;
            }
        }
    }

    public b(Context context) {
        super(context);
        this.g = false;
        C0318b c0318b = new C0318b();
        this.h = c0318b;
        a aVar = new a(this, c0318b);
        this.f17102a = aVar;
        addJavascriptInterface(aVar, "bigossp");
    }

    public final void a(int i2, WebResourceRequest webResourceRequest, int i8, CharSequence charSequence) {
        if (webResourceRequest != null) {
            StringBuilder sbV = a1.a.v(i2, "dispatchResourceError, type: ", ", url: ");
            sbV.append(webResourceRequest.getUrl());
            sbV.append(", errorCode: ");
            sbV.append(i8);
            sbV.append(", desc: ");
            sbV.append((Object) charSequence);
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", sbV.toString());
            C0318b c0318b = this.h;
            String strValueOf = String.valueOf(webResourceRequest.getUrl());
            if (c0318b.f17108b == null) {
                c0318b.f17108b = new ArrayList();
            }
            c0318b.f17108b.add(strValueOf);
        }
    }

    @Nullable
    public sg.bigo.ads.core.h.c getCustomWebChromeClient() {
        return this.f17103b;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(@Nullable WebChromeClient webChromeClient) {
        this.f17103b = webChromeClient instanceof sg.bigo.ads.core.h.c ? (sg.bigo.ads.core.h.c) webChromeClient : null;
        super.setWebChromeClient(webChromeClient);
    }

    public static void a(@NonNull C0318b c0318b) {
        List<String> list;
        long jElapsedRealtime;
        JSONObject jSONObjectOptJSONObject;
        if (!i.f15457a.n().a(0) || (list = c0318b.f17107a) == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (str.startsWith(C2300e4.i.f8403d)) {
                sb.append(str.substring(1, str.length() - 1));
                sb.append(",");
            }
            sb.append(str);
            sb.append(",");
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray(C2300e4.i.f8403d + sb.substring(0, sb.length() - 1) + C2300e4.i.e);
            int length = jSONArray2.length();
            JSONObject jSONObject = null;
            JSONObject jSONObject2 = null;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("type");
                    if ("render_start".equals(strOptString)) {
                        jSONObject = jSONObjectOptJSONObject2;
                    }
                    if ("render".equals(strOptString) && jSONObject2 == null) {
                        jSONObject2 = jSONObjectOptJSONObject2;
                    }
                    if (!"mayError".equals(strOptString) || ((jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("params")) != null && c0318b.a(jSONObjectOptJSONObject.optString("url")))) {
                        jSONArray.put(jSONObjectOptJSONObject2);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                sg.bigo.ads.core.d.b.a(3002, 10113, jSONArray.toString());
            }
            if (jSONObject != null) {
                if (jSONObject2 != null) {
                    c0318b.f17109c = Boolean.TRUE;
                    jElapsedRealtime = jSONObject2.optLong("cur");
                } else {
                    c0318b.f17109c = Boolean.FALSE;
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                }
                c0318b.e = jElapsedRealtime;
            }
        } catch (Exception unused) {
        }
    }
}

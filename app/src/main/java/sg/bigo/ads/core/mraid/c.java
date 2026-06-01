package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.ironsource.C2300e4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import sg.bigo.ads.core.mraid.a.a;
import sg.bigo.ads.core.mraid.h;
import sg.bigo.ads.core.mraid.p;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    b f17154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    sg.bigo.ads.common.ac.a f17155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f17156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17157d;

    @NonNull
    private final n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    private final h f17158f;

    @Nullable
    private C0321c g;
    private final WebViewClient h;

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.c$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17165a;

        static {
            int[] iArr = new int[g.values().length];
            f17165a = iArr;
            try {
                iArr[g.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17165a[g.RESIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17165a[g.UNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17165a[g.EXPAND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17165a[g.USE_CUSTOM_CLOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17165a[g.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17165a[g.SET_ORIENTATION_PROPERTIES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17165a[g.PLAY_VIDEO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17165a[g.STORE_PICTURE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17165a[g.CREATE_CALENDAR_EVENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17165a[g.UNSPECIFIED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public interface a extends b {
        void a(String str, String str2);
    }

    public interface b {
        void a();

        void a(int i2, int i8, int i9, int i10, @NonNull a.EnumC0320a enumC0320a, boolean z2);

        void a(String str);

        void a(String str, @Nullable sg.bigo.ads.common.i iVar);

        void a(String str, boolean z2);

        void a(sg.bigo.ads.core.mraid.b bVar);

        void a(boolean z2);

        void a(boolean z2, i iVar);

        boolean a(@NonNull JsResult jsResult);

        void b();

        void b(boolean z2);

        void c();

        boolean d();

        void e();

        void f();
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.c$c, reason: collision with other inner class name */
    public static class C0321c extends sg.bigo.ads.core.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f17166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private a f17167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private p f17168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private sg.bigo.ads.common.i f17169d;

        /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.c$c$a */
        public interface a {
            void a(sg.bigo.ads.core.mraid.b bVar);

            void a(boolean z2);
        }

        private C0321c(Context context) {
            super(context);
            this.f17169d = new sg.bigo.ads.common.i();
            this.f17168c = new p(this);
            this.f17168c.f17259d = new p.b() { // from class: sg.bigo.ads.core.mraid.c.c.1
                @Override // sg.bigo.ads.core.mraid.p.b
                public final void a(boolean z2, sg.bigo.ads.core.mraid.b bVar) {
                    C0321c.this.setMraidViewable(z2);
                    C0321c.a(C0321c.this, bVar);
                }
            };
        }

        public static /* synthetic */ void a(C0321c c0321c, sg.bigo.ads.core.mraid.b bVar) {
            a aVar = c0321c.f17167b;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMraidViewable(boolean z2) {
            if (this.f17166a == z2) {
                return;
            }
            this.f17166a = z2;
            a aVar = this.f17167b;
            if (aVar != null) {
                aVar.a(z2);
            }
        }

        @Override // sg.bigo.ads.core.h.e, android.webkit.WebView
        public final void destroy() {
            super.destroy();
            setWebChromeClient(null);
            setWebViewClient(null);
            this.f17168c = null;
            this.f17167b = null;
        }

        @Nullable
        public final sg.bigo.ads.common.i getClickPoints() {
            return this.f17169d;
        }

        @Override // android.webkit.WebView, android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.f17169d.f15793b = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getActionMasked() == 0) {
                this.f17169d.f15792a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public final void onVisibilityChanged(@NonNull View view, int i2) {
            super.onVisibilityChanged(view, i2);
            if (this.f17168c == null) {
                setMraidViewable(i2 == 0);
            } else if (i2 != 0) {
                setMraidViewable(false);
            }
        }

        public final void setVisibilityChangedListener(@Nullable a aVar) {
            this.f17167b = aVar;
        }

        public /* synthetic */ C0321c(Context context, byte b8) {
            this(context);
        }
    }

    public c(@Nullable n nVar) {
        this(nVar, new h());
    }

    private static int a(int i2, int i8) throws d {
        if (i2 < i8 || i2 > 100000) {
            throw new d("Integer parameter out of range: ".concat(String.valueOf(i2)));
        }
        return i2;
    }

    @NonNull
    private static String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    private boolean d() {
        sg.bigo.ads.common.ac.a aVar = this.f17155b;
        if (aVar != null) {
            return this.f17157d ? aVar.f15578a.f15581a : aVar.a();
        }
        return false;
    }

    private static String e(String str) throws d {
        if (str != null) {
            return str;
        }
        throw new d("Parameter cannot be null");
    }

    private static int f(@NonNull String str) throws d {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new d("Invalid numeric parameter: ".concat(String.valueOf(str)));
        }
    }

    private static boolean g(String str) throws d {
        if (com.ironsource.mediationsdk.metadata.a.g.equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new d("Invalid boolean parameter: ".concat(String.valueOf(str)));
    }

    public final void c(@NonNull String str) {
        if (this.g == null) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t".concat(String.valueOf(str)));
        } else {
            a0.i(0, str, "Injecting Javascript into MRAID WebView:\n\t", 3, "MraidBridge");
            this.g.loadUrl("javascript:".concat(String.valueOf(str)));
        }
    }

    @VisibleForTesting
    private c(@Nullable n nVar, @NonNull h hVar) {
        this.f17157d = false;
        this.h = new k() { // from class: sg.bigo.ads.core.mraid.c.4
            @Override // sg.bigo.ads.core.mraid.k, sg.bigo.ads.core.h.d
            public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                c cVar = c.this;
                sg.bigo.ads.common.t.a.a(0, "MraidBridge", (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? "Render process is gone" : "Render process has crashed");
                cVar.a();
                b bVar = cVar.f17154a;
                if (bVar != null) {
                    bVar.c();
                }
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onPageFinished(@NonNull WebView webView, @NonNull String str) {
                super.onPageFinished(webView, str);
                c cVar = c.this;
                if (cVar.f17156c) {
                    return;
                }
                cVar.f17156c = true;
                b bVar = cVar.f17154a;
                if (bVar != null) {
                    bVar.a();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(@NonNull WebView webView, int i2, @NonNull String str, @NonNull String str2) {
                sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Error: ".concat(String.valueOf(str)));
                super.onReceivedError(webView, i2, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(@NonNull WebView webView, String str) {
                return c.this.d(str);
            }
        };
        this.e = nVar;
        this.f17158f = hVar;
    }

    @NonNull
    private static String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    public final void b(String str) {
        C0321c c0321c = this.g;
        if (c0321c == null) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "MRAID bridge called setContentHtml while WebView was not attached");
        } else {
            this.f17156c = false;
            c0321c.loadUrl(str);
        }
    }

    @VisibleForTesting
    public final boolean d(String str) {
        Map<String, String> mapA;
        i iVar;
        String str2;
        StringBuilder sb;
        b bVar;
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return true;
            }
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if ("mopub".equals(scheme)) {
                if ("failLoad".equals(host) && this.e == n.INLINE && (bVar = this.f17154a) != null) {
                    bVar.b();
                }
                return true;
            }
            if (d() && !"mraid".equals(scheme)) {
                try {
                    sb = new StringBuilder("mraid://open?url=");
                    str2 = str;
                } catch (UnsupportedEncodingException unused) {
                    str2 = str;
                }
                try {
                    sb.append(URLEncoder.encode(str2, Key.STRING_CHARSET_NAME));
                    uri = Uri.parse(sb.toString());
                    host = uri.getHost();
                    scheme = uri.getScheme();
                } catch (UnsupportedEncodingException unused2) {
                    sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Invalid MRAID URL encoding: ".concat(String.valueOf(str2)));
                    a(g.OPEN, "Non-mraid URL is invalid");
                    return false;
                }
            }
            if (!"mraid".equals(scheme)) {
                sg.bigo.ads.common.ac.a aVar = this.f17155b;
                return aVar != null && aVar.a();
            }
            final g gVarA = g.a(host);
            try {
                mapA = a(uri);
                if (gVarA.a(this.e) && !d()) {
                    throw new d("Cannot execute this command unless the user clicks");
                }
            } catch (IllegalArgumentException e) {
                e = e;
                a(gVarA, e.getMessage());
            } catch (d e4) {
                e = e4;
                a(gVarA, e.getMessage());
            }
            if (this.f17154a == null) {
                throw new d("Invalid state to execute this command");
            }
            if (this.g == null) {
                throw new d("The current WebView is being destroyed");
            }
            switch (AnonymousClass6.f17165a[gVarA.ordinal()]) {
                case 1:
                    this.f17154a.f();
                    break;
                case 2:
                    int iA = a(f(mapA.get("width")), 0);
                    int iA2 = a(f(mapA.get("height")), 0);
                    int iA3 = a(f(mapA.get("offsetX")), -100000);
                    int iA4 = a(f(mapA.get("offsetY")), -100000);
                    String str3 = mapA.get("customClosePosition");
                    a.EnumC0320a enumC0320a = a.EnumC0320a.TOP_RIGHT;
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.equals(C2300e4.e.f8333c)) {
                            enumC0320a = a.EnumC0320a.TOP_LEFT;
                        } else if (!str3.equals(C2300e4.e.f8332b)) {
                            if (str3.equals("center")) {
                                enumC0320a = a.EnumC0320a.CENTER;
                            } else if (str3.equals(C2300e4.e.e)) {
                                enumC0320a = a.EnumC0320a.BOTTOM_LEFT;
                            } else if (str3.equals(C2300e4.e.f8334d)) {
                                enumC0320a = a.EnumC0320a.BOTTOM_RIGHT;
                            } else if (str3.equals("top-center")) {
                                enumC0320a = a.EnumC0320a.TOP_CENTER;
                            } else {
                                if (!str3.equals("bottom-center")) {
                                    throw new d("Invalid close position: ".concat(str3));
                                }
                                enumC0320a = a.EnumC0320a.BOTTOM_CENTER;
                            }
                        }
                    }
                    this.f17154a.a(iA, iA2, iA3, iA4, enumC0320a, a(mapA.get("allowOffscreen"), true));
                    this.f17154a.b(false);
                    break;
                case 3:
                    this.f17154a.e();
                    break;
                case 4:
                    this.f17154a.a(mapA.get("url"), a(mapA));
                    break;
                case 5:
                    this.f17154a.b(a(mapA));
                    break;
                case 6:
                    this.f17154a.a(e(mapA.get("url")), this.g.getClickPoints());
                    break;
                case 7:
                    boolean zG = g(mapA.get("allowOrientationChange"));
                    String str4 = mapA.get("forceOrientation");
                    if (C2300e4.h.D.equals(str4)) {
                        iVar = i.PORTRAIT;
                    } else if (C2300e4.h.C.equals(str4)) {
                        iVar = i.LANDSCAPE;
                    } else {
                        if (!"none".equals(str4)) {
                            throw new d("Invalid orientation: ".concat(String.valueOf(str4)));
                        }
                        iVar = i.NONE;
                    }
                    this.f17154a.a(zG, iVar);
                    break;
                case 8:
                    this.f17154a.a(e(mapA.get("uri")));
                    break;
                case 9:
                    final String strE = e(mapA.get("uri"));
                    final h hVar = this.f17158f;
                    final Context context = this.g.getContext();
                    final h.c cVar = new h.c() { // from class: sg.bigo.ads.core.mraid.c.5
                        @Override // sg.bigo.ads.core.mraid.h.c
                        public final void a(d dVar) {
                            c.this.a(gVarA, dVar.getMessage());
                        }
                    };
                    if (!h.c(context)) {
                        sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
                        throw new d("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
                    }
                    if (!(context instanceof Activity)) {
                        Toast.makeText(context, "Downloading image", 0).show();
                        hVar.a(context, strE, cVar);
                    } else {
                        new AlertDialog.Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: sg.bigo.ads.core.mraid.h.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                h.this.a(context, strE, cVar);
                            }
                        }).setCancelable(true).show();
                    }
                    break;
                    break;
                case 10:
                    h.a(this.g.getContext(), mapA);
                    break;
                case 11:
                    throw new d("Unspecified MRAID Javascript command");
            }
            c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(gVarA.l) + ")");
            return true;
        } catch (Exception unused3) {
            return true;
        }
    }

    @NonNull
    private static Map<String, String> a(@NonNull Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            map.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
        }
        return map;
    }

    public final boolean b() {
        C0321c c0321c = this.g;
        return c0321c != null && c0321c.f17166a;
    }

    @Nullable
    public static C0321c a(@NonNull Context context) {
        try {
            return new C0321c(context, (byte) 0);
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(e));
            return null;
        }
    }

    public final void a() {
        C0321c c0321c = this.g;
        if (c0321c != null) {
            c0321c.setOnTouchListener(null);
            this.g.setVisibilityChangedListener(null);
            this.g.destroy();
            this.g = null;
        }
    }

    public final void a(@NonNull String str) {
        if (this.g == null) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.f17156c = false;
        sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "MraidBridge setContentHtml");
        this.g.loadDataWithBaseURL("https://mraid.bigo.sg", str, "text/html", null, null);
    }

    public final boolean c() {
        return this.g != null;
    }

    public final void a(sg.bigo.ads.core.mraid.b bVar) {
        StringBuilder sb = new StringBuilder("mraidbridge.notifyExposureChangeEvent(");
        sb.append(String.valueOf(bVar.f17151a) + ", " + sg.bigo.ads.core.mraid.b.a(bVar.f17152b) + ", " + sg.bigo.ads.core.mraid.b.a(bVar.f17153c));
        sb.append(");");
        c(sb.toString());
    }

    public final void a(@NonNull C0321c c0321c) {
        this.g = c0321c;
        c0321c.getSettings().setJavaScriptEnabled(true);
        if (this.e == n.INTERSTITIAL) {
            c0321c.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.g.setScrollContainer(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setHorizontalScrollBarEnabled(false);
        this.g.setBackgroundColor(0);
        this.g.setWebViewClient(this.h);
        this.g.setWebChromeClient(new sg.bigo.ads.core.h.c() { // from class: sg.bigo.ads.core.mraid.c.1
            @Override // sg.bigo.ads.core.h.c
            public final void a(WebView webView, String str, String str2) {
                super.a(webView, str, str2);
                b bVar = c.this.f17154a;
                if (bVar == null || !(bVar instanceof a)) {
                    return;
                }
                ((a) bVar).a(str, str2);
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
                b bVar = c.this.f17154a;
                return bVar != null ? bVar.d() : super.onConsoleMessage(consoleMessage);
            }

            @Override // sg.bigo.ads.core.h.c, android.webkit.WebChromeClient
            public final boolean onJsAlert(@NonNull WebView webView, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
                b bVar = c.this.f17154a;
                return bVar != null ? bVar.a(jsResult) : super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        this.f17155b = new sg.bigo.ads.common.ac.a(this.g.getContext());
        this.g.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.core.mraid.c.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.f17155b.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.g.setVisibilityChangedListener(new C0321c.a() { // from class: sg.bigo.ads.core.mraid.c.3
            @Override // sg.bigo.ads.core.mraid.c.C0321c.a
            public final void a(sg.bigo.ads.core.mraid.b bVar) {
                b bVar2 = c.this.f17154a;
                if (bVar2 != null) {
                    bVar2.a(bVar);
                }
            }

            @Override // sg.bigo.ads.core.mraid.c.C0321c.a
            public final void a(boolean z2) {
                b bVar = c.this.f17154a;
                if (bVar != null) {
                    bVar.a(z2);
                }
            }
        });
    }

    public final void a(@NonNull g gVar, @NonNull String str) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(gVar.l) + ", " + JSONObject.quote(str) + ")");
    }

    public final void a(@NonNull j jVar) {
        String str;
        StringBuilder sb = new StringBuilder("mraidbridge.setScreenSize(");
        sb.append(b(jVar.f17237b));
        sb.append(");mraidbridge.setMaxSize(");
        sb.append(b(jVar.f17239d));
        sb.append(");mraidbridge.setCurrentPosition(");
        sb.append(a(jVar.f17240f));
        sb.append(");mraidbridge.setDefaultPosition(");
        sb.append(a(jVar.h));
        sb.append(");mraidbridge.setCurrentAppOrientation(");
        C0321c c0321c = this.g;
        if (c0321c == null) {
            str = "";
        } else {
            Context context = c0321c.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            String str2 = context.getResources().getConfiguration().orientation == 2 ? C2300e4.h.C : C2300e4.h.D;
            boolean z2 = false;
            if (activity == null) {
                sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "Context is not an Activity, set locked to false");
            } else if (activity.getRequestedOrientation() != -1) {
                z2 = true;
            }
            str = "'" + str2 + "', " + z2;
        }
        sb.append(str);
        sb.append(")");
        c(sb.toString());
        c("mraidbridge.notifySizeChangeEvent(" + b(jVar.f17240f) + ")");
    }

    public final void a(n nVar) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(nVar.toString().toLowerCase(Locale.US)) + ")");
    }

    public final void a(o oVar) {
        c("mraidbridge.setState(" + JSONObject.quote(oVar.toString().toLowerCase(Locale.US)) + ")");
    }

    public final void a(boolean z2) {
        c("mraidbridge.setIsViewable(" + z2 + ")");
    }

    public final void a(boolean z2, boolean z7, boolean z8, boolean z9, boolean z10) {
        c("mraidbridge.setSupports(" + z2 + "," + z7 + "," + z8 + "," + z9 + "," + z10 + ")");
    }

    private static boolean a(@Nullable String str, boolean z2) {
        return str == null ? z2 : g(str);
    }

    private static boolean a(@NonNull Map<String, String> map) {
        return a(map.get("shouldUseCustomClose"), false);
    }
}

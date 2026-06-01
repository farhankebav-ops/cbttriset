package sg.bigo.ads.core.h;

import android.app.Activity;
import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class c extends WebChromeClient {
    public void a(WebView webView, String str, String str2) {
    }

    @Override // android.webkit.WebChromeClient
    @Nullable
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster == null ? sg.bigo.ads.common.utils.d.a(1, 1, Bitmap.Config.ARGB_8888) : defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(@NonNull WebView webView, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
        return a(webView, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(@NonNull WebView webView, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
        return a(webView, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(@NonNull WebView webView, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
        return a(webView, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(@NonNull WebView webView, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JsPromptResult jsPromptResult) {
        return a(webView, jsPromptResult);
    }

    private static boolean a(@NonNull WebView webView, @NonNull JsResult jsResult) {
        if (webView.getContext() instanceof Activity) {
            return false;
        }
        jsResult.confirm();
        return true;
    }
}

package org.chromium.support_lib_boundary;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface WebViewProviderBoundaryInterface {
    InvocationHandler addDocumentStartJavaScript(String str, String[] strArr);

    void addWebMessageListener(String str, String[] strArr, InvocationHandler invocationHandler);

    InvocationHandler[] createWebMessageChannel();

    InvocationHandler getProfile();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    InvocationHandler getWebViewRenderer();

    InvocationHandler getWebViewRendererClient();

    void insertVisualStateCallback(long j, InvocationHandler invocationHandler);

    boolean isAudioMuted();

    void postMessageToMainFrame(InvocationHandler invocationHandler, Uri uri);

    void removeWebMessageListener(String str);

    void setAudioMuted(boolean z2);

    void setProfile(String str);

    void setWebViewRendererClient(InvocationHandler invocationHandler);
}

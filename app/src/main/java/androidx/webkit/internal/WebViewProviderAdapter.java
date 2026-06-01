package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.Profile;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewProviderAdapter {
    final WebViewProviderBoundaryInterface mImpl;

    public WebViewProviderAdapter(@NonNull WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.mImpl = webViewProviderBoundaryInterface;
    }

    @NonNull
    public ScriptHandlerImpl addDocumentStartJavaScript(@NonNull String str, @NonNull String[] strArr) {
        return ScriptHandlerImpl.toScriptHandler(this.mImpl.addDocumentStartJavaScript(str, strArr));
    }

    public void addWebMessageListener(@NonNull String str, @NonNull String[] strArr, @NonNull WebViewCompat.WebMessageListener webMessageListener) {
        this.mImpl.addWebMessageListener(str, strArr, new n7.a(new WebMessageListenerAdapter(webMessageListener)));
    }

    @NonNull
    public WebMessagePortCompat[] createWebMessageChannel() {
        InvocationHandler[] invocationHandlerArrCreateWebMessageChannel = this.mImpl.createWebMessageChannel();
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArrCreateWebMessageChannel.length];
        for (int i2 = 0; i2 < invocationHandlerArrCreateWebMessageChannel.length; i2++) {
            webMessagePortCompatArr[i2] = new WebMessagePortImpl(invocationHandlerArrCreateWebMessageChannel[i2]);
        }
        return webMessagePortCompatArr;
    }

    @NonNull
    public Profile getProfile() {
        return new ProfileImpl((ProfileBoundaryInterface) n7.b.h(ProfileBoundaryInterface.class, this.mImpl.getProfile()));
    }

    @Nullable
    public WebChromeClient getWebChromeClient() {
        return this.mImpl.getWebChromeClient();
    }

    @NonNull
    public WebViewClient getWebViewClient() {
        return this.mImpl.getWebViewClient();
    }

    @Nullable
    public WebViewRenderProcess getWebViewRenderProcess() {
        return WebViewRenderProcessImpl.forInvocationHandler(this.mImpl.getWebViewRenderer());
    }

    @Nullable
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        InvocationHandler webViewRendererClient = this.mImpl.getWebViewRendererClient();
        if (webViewRendererClient == null) {
            return null;
        }
        return ((WebViewRenderProcessClientAdapter) ((n7.a) webViewRendererClient).f13106a).getWebViewRenderProcessClient();
    }

    public void insertVisualStateCallback(long j, @NonNull WebViewCompat.VisualStateCallback visualStateCallback) {
        this.mImpl.insertVisualStateCallback(j, new n7.a(new VisualStateCallbackAdapter(visualStateCallback)));
    }

    public boolean isAudioMuted() {
        return this.mImpl.isAudioMuted();
    }

    public void postWebMessage(@NonNull WebMessageCompat webMessageCompat, @NonNull Uri uri) {
        this.mImpl.postMessageToMainFrame(new n7.a(new WebMessageAdapter(webMessageCompat)), uri);
    }

    public void removeWebMessageListener(@NonNull String str) {
        this.mImpl.removeWebMessageListener(str);
    }

    public void setAudioMuted(boolean z2) {
        this.mImpl.setAudioMuted(z2);
    }

    public void setProfileWithName(@NonNull String str) {
        this.mImpl.setProfile(str);
    }

    public void setWebViewRenderProcessClient(@Nullable Executor executor, @Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mImpl.setWebViewRendererClient(webViewRenderProcessClient != null ? new n7.a(new WebViewRenderProcessClientAdapter(executor, webViewRenderProcessClient)) : null);
    }
}

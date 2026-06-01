package androidx.webkit.internal;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebMessagePortImpl extends WebMessagePortCompat {
    private WebMessagePortBoundaryInterface mBoundaryInterface;
    private WebMessagePort mFrameworksImpl;

    public WebMessagePortImpl(@NonNull WebMessagePort webMessagePort) {
        this.mFrameworksImpl = webMessagePort;
    }

    @NonNull
    @RequiresApi(23)
    public static WebMessage compatToFrameworkMessage(@NonNull WebMessageCompat webMessageCompat) {
        return ApiHelperForM.createWebMessage(webMessageCompat);
    }

    @Nullable
    @RequiresApi(23)
    public static WebMessagePort[] compatToPorts(@Nullable WebMessagePortCompat[] webMessagePortCompatArr) {
        if (webMessagePortCompatArr == null) {
            return null;
        }
        int length = webMessagePortCompatArr.length;
        WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
        for (int i2 = 0; i2 < length; i2++) {
            webMessagePortArr[i2] = webMessagePortCompatArr[i2].getFrameworkPort();
        }
        return webMessagePortArr;
    }

    @NonNull
    @RequiresApi(23)
    public static WebMessageCompat frameworkMessageToCompat(@NonNull WebMessage webMessage) {
        return ApiHelperForM.createWebMessageCompat(webMessage);
    }

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (WebMessagePortBoundaryInterface) n7.b.h(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(23)
    private WebMessagePort getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    @Nullable
    public static WebMessagePortCompat[] portsToCompat(@Nullable WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
        for (int i2 = 0; i2 < webMessagePortArr.length; i2++) {
            webMessagePortCompatArr[i2] = new WebMessagePortImpl(webMessagePortArr[i2]);
        }
        return webMessagePortCompatArr;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void close() {
        ApiFeature.M m = WebViewFeatureInternal.WEB_MESSAGE_PORT_CLOSE;
        if (m.isSupportedByFramework()) {
            ApiHelperForM.close(getFrameworksImpl());
        } else {
            if (!m.isSupportedByWebView()) {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
            getBoundaryInterface().close();
        }
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @NonNull
    @RequiresApi(23)
    public WebMessagePort getFrameworkPort() {
        return getFrameworksImpl();
    }

    @Override // androidx.webkit.WebMessagePortCompat
    @NonNull
    public InvocationHandler getInvocationHandler() {
        return Proxy.getInvocationHandler(getBoundaryInterface());
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void postMessage(@NonNull WebMessageCompat webMessageCompat) {
        ApiFeature.M m = WebViewFeatureInternal.WEB_MESSAGE_PORT_POST_MESSAGE;
        if (m.isSupportedByFramework() && webMessageCompat.getType() == 0) {
            ApiHelperForM.postMessage(getFrameworksImpl(), compatToFrameworkMessage(webMessageCompat));
        } else {
            if (!m.isSupportedByWebView() || !WebMessageAdapter.isMessagePayloadTypeSupportedByWebView(webMessageCompat.getType())) {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
            getBoundaryInterface().postMessage(new n7.a(new WebMessageAdapter(webMessageCompat)));
        }
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void setWebMessageCallback(@NonNull WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        ApiFeature.M m = WebViewFeatureInternal.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK;
        if (m.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(new n7.a(new WebMessageCallbackAdapter(webMessageCallbackCompat)));
        } else {
            if (!m.isSupportedByFramework()) {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
            ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), webMessageCallbackCompat);
        }
    }

    public WebMessagePortImpl(@NonNull InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) n7.b.h(WebMessagePortBoundaryInterface.class, invocationHandler);
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void setWebMessageCallback(@Nullable Handler handler, @NonNull WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        ApiFeature.M m = WebViewFeatureInternal.CREATE_WEB_MESSAGE_CHANNEL;
        if (m.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(new n7.a(new WebMessageCallbackAdapter(webMessageCallbackCompat)), handler);
        } else {
            if (m.isSupportedByFramework()) {
                ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), webMessageCallbackCompat, handler);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}

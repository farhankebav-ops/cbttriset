package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewFeature;
import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebMessageAdapter implements WebMessageBoundaryInterface {
    private static final String[] sFeatures = {WebViewFeature.WEB_MESSAGE_ARRAY_BUFFER};
    private final WebMessageCompat mWebMessageCompat;

    public WebMessageAdapter(@NonNull WebMessageCompat webMessageCompat) {
        this.mWebMessageCompat = webMessageCompat;
    }

    public static boolean isMessagePayloadTypeSupportedByWebView(int i2) {
        return i2 == 0 || (i2 == 1 && WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView());
    }

    @NonNull
    private static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i2 = 0; i2 < invocationHandlerArr.length; i2++) {
            webMessagePortCompatArr[i2] = new WebMessagePortImpl(invocationHandlerArr[i2]);
        }
        return webMessagePortCompatArr;
    }

    @Nullable
    public static WebMessageCompat webMessageCompatFromBoundaryInterface(@NonNull WebMessageBoundaryInterface webMessageBoundaryInterface) {
        WebMessagePortCompat[] webMessagePortCompats = toWebMessagePortCompats(webMessageBoundaryInterface.getPorts());
        if (!WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView()) {
            return new WebMessageCompat(webMessageBoundaryInterface.getData(), webMessagePortCompats);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) n7.b.h(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString(), webMessagePortCompats);
        }
        if (type != 1) {
            return null;
        }
        return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), webMessagePortCompats);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    @Nullable
    @Deprecated
    public String getData() {
        return this.mWebMessageCompat.getData();
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    @Nullable
    public InvocationHandler getMessagePayload() {
        WebMessagePayloadAdapter webMessagePayloadAdapter;
        int type = this.mWebMessageCompat.getType();
        if (type == 0) {
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(this.mWebMessageCompat.getData());
        } else {
            if (type != 1) {
                throw new IllegalStateException("Unknown web message payload type: " + this.mWebMessageCompat.getType());
            }
            byte[] arrayBuffer = this.mWebMessageCompat.getArrayBuffer();
            Objects.requireNonNull(arrayBuffer);
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(arrayBuffer);
        }
        return new n7.a(webMessagePayloadAdapter);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    @Nullable
    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
        if (ports == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[ports.length];
        for (int i2 = 0; i2 < ports.length; i2++) {
            invocationHandlerArr[i2] = ports[i2].getInvocationHandler();
        }
        return invocationHandlerArr;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    @NonNull
    public String[] getSupportedFeatures() {
        return sFeatures;
    }
}

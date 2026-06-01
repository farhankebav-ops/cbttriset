package com.unity3d.services.ads.token;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.GameSessionIdReader;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.k;
import n7.b;
import org.json.JSONArray;
import org.json.JSONException;
import q5.f;
import q5.g;
import q5.x;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InMemoryTokenStorage implements TokenStorage, IServiceComponent {
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private final q0 accessCounter = x0.c(-1);
    private final q0 initToken = x0.c(null);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final f asyncTokenStorage$delegate = b.B(g.f13496c, new InMemoryTokenStorage$special$$inlined$inject$default$1(this, ""));

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_nativeGeneratedToken_$lambda$2(String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_NATIVE_DATA, str);
    }

    private final AsyncTokenStorage getAsyncTokenStorage() {
        return (AsyncTokenStorage) this.asyncTokenStorage$delegate.getValue();
    }

    private final void triggerTokenAvailable(boolean z2) {
        InitializeEventsMetricSender.getInstance().sdkTokenDidBecomeAvailableWithConfig(z2);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void appendTokens(JSONArray tokens) throws JSONException {
        k.e(tokens, "tokens");
        ((d1) this.accessCounter).g(-1, 0);
        int length = tokens.length();
        for (int i2 = 0; i2 < length; i2++) {
            this.queue.add(tokens.getString(i2));
        }
        if (length > 0) {
            triggerTokenAvailable(false);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void createTokens(JSONArray tokens) throws JSONException {
        k.e(tokens, "tokens");
        deleteTokens();
        appendTokens(tokens);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void deleteTokens() {
        d1 d1Var;
        Object value;
        this.queue.clear();
        q0 q0Var = this.accessCounter;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            ((Number) value).intValue();
        } while (!d1Var.g(value, -1));
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public x getNativeGeneratedToken() {
        new NativeTokenGenerator(this.executorService, new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()), null).generateToken(new com.mimikridev.utilmanager.config.b(1));
        return x.f13520a;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public String getToken() {
        d1 d1Var;
        Object value;
        Number number;
        if (((Number) ((d1) this.accessCounter).getValue()).intValue() == -1) {
            return (String) ((d1) this.initToken).getValue();
        }
        if (this.queue.isEmpty()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, new Object[0]);
            return null;
        }
        q0 q0Var = this.accessCounter;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            number = (Number) value;
        } while (!d1Var.g(value, Integer.valueOf(number.intValue() + 1)));
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_ACCESS, Integer.valueOf(number.intValue()));
        return this.queue.poll();
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void setInitToken(String str) {
        d1 d1Var;
        Object value;
        if (str == null) {
            return;
        }
        q0 q0Var = this.initToken;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, str));
        triggerTokenAvailable(true);
        getAsyncTokenStorage().onTokenAvailable();
    }
}

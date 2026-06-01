package sg.bigo.ads.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import sg.bigo.ads.a.a.b;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomTabsClient f13784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomTabsServiceConnection f13785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0226a f13786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CustomTabsCallback f13787d;
    private CustomTabsSession e;

    /* JADX INFO: renamed from: sg.bigo.ads.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0226a {
        void c();

        void d();
    }

    public interface b {
        void a(Context context, b.a aVar);

        void a(b.a aVar);
    }

    public final CustomTabsSession a() {
        CustomTabsSession customTabsSessionNewSession;
        CustomTabsClient customTabsClient = this.f13784a;
        if (customTabsClient != null) {
            customTabsSessionNewSession = this.e == null ? customTabsClient.newSession(new CustomTabsCallback() { // from class: sg.bigo.ads.a.a.a.1
                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void extraCallback(String str, Bundle bundle) {
                    super.extraCallback(str, bundle);
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onMessageChannelReady(Bundle bundle) {
                    super.onMessageChannelReady(bundle);
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onNavigationEvent(int i2, @Nullable Bundle bundle) {
                    super.onNavigationEvent(i2, bundle);
                    CustomTabsCallback customTabsCallback = a.this.f13787d;
                    if (customTabsCallback != null) {
                        customTabsCallback.onNavigationEvent(i2, bundle);
                    }
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onPostMessage(String str, Bundle bundle) {
                    super.onPostMessage(str, bundle);
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onRelationshipValidationResult(int i2, Uri uri, boolean z2, Bundle bundle) {
                    super.onRelationshipValidationResult(i2, uri, z2, bundle);
                }
            }) : null;
            return this.e;
        }
        this.e = customTabsSessionNewSession;
        return this.e;
    }

    @Override // sg.bigo.ads.a.a.d
    public final void b() {
        this.f13784a = null;
        this.e = null;
        InterfaceC0226a interfaceC0226a = this.f13786c;
        if (interfaceC0226a != null) {
            interfaceC0226a.d();
        }
    }

    @Override // sg.bigo.ads.a.a.d
    public final void a(CustomTabsClient customTabsClient) {
        this.f13784a = customTabsClient;
        customTabsClient.warmup(0L);
        InterfaceC0226a interfaceC0226a = this.f13786c;
        if (interfaceC0226a != null) {
            interfaceC0226a.c();
        }
    }
}

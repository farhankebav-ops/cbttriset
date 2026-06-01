package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class InflaterModule {
    private final Application application;
    private final InAppMessage inAppMessage;
    private final InAppMessageLayoutConfig inAppMessageLayoutConfig;

    public InflaterModule(InAppMessage inAppMessage, InAppMessageLayoutConfig inAppMessageLayoutConfig, Application application) {
        this.inAppMessage = inAppMessage;
        this.inAppMessageLayoutConfig = inAppMessageLayoutConfig;
        this.application = application;
    }

    @Provides
    @InAppMessageScope
    public InAppMessageLayoutConfig inAppMessageLayoutConfig() {
        return this.inAppMessageLayoutConfig;
    }

    @Provides
    public InAppMessage providesBannerMessage() {
        return this.inAppMessage;
    }

    @Provides
    @InAppMessageScope
    public LayoutInflater providesInflaterservice() {
        return (LayoutInflater) this.application.getSystemService("layout_inflater");
    }
}

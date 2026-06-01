package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import java.util.Map;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {ApplicationModule.class, InflaterConfigModule.class})
public interface UniversalComponent {
    DisplayMetrics displayMetrics();

    FiamWindowManager fiamWindowManager();

    BindingWrapperFactory inflaterClient();

    Map<String, a> myKeyStringMap();

    Application providesApplication();
}

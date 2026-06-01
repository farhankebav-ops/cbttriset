package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import w4.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class ForegroundFlowableModule {
    @Provides
    @AppForeground
    public a providesAppForegroundEventStream(Application application) {
        ForegroundNotifier foregroundNotifier = new ForegroundNotifier();
        a aVarForegroundFlowable = foregroundNotifier.foregroundFlowable();
        aVarForegroundFlowable.f();
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        return aVarForegroundFlowable;
    }
}

package com.unity3d.services.core.configuration;

import android.app.Application;
import android.content.Context;
import androidx.startup.Initializer;
import com.google.android.gms.net.CronetProviderInstaller;
import com.unity3d.ads.core.data.repository.OrientationRepository;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.List;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import q5.x;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdsSdkInitializer implements Initializer<x> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ x create(Context context) {
        create2(context);
        return x.f13520a;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return r.f13638a;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public void create2(Context context) {
        k.e(context, "context");
        ClientProperties.setApplicationContext(context.getApplicationContext());
        if (context instanceof Application) {
            ClientProperties.setApplication((Application) context);
        } else if (context.getApplicationContext() instanceof Application) {
            Context applicationContext = context.getApplicationContext();
            k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ClientProperties.setApplication((Application) applicationContext);
        }
        SdkProperties.setAppInitializationTimeSinceEpoch(System.currentTimeMillis());
        ((OrientationRepository) ServiceProvider.INSTANCE.getRegistry().getService("", b0.a(OrientationRepository.class))).invoke();
        try {
            CronetProviderInstaller.installProvider(context);
        } catch (Throwable unused) {
        }
    }
}

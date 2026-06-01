package com.onesignal.core.internal.startup;

import com.onesignal.common.services.ServiceProvider;
import com.vungle.ads.internal.omsdk.a;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class StartupService {
    private final ServiceProvider services;

    public StartupService(ServiceProvider services) {
        k.e(services, "services");
        this.services = services;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: scheduleStart$lambda-2, reason: not valid java name */
    public static final void m3144scheduleStart$lambda2(StartupService this$0) {
        k.e(this$0, "this$0");
        Iterator it = this$0.services.getAllServices(IStartableService.class).iterator();
        while (it.hasNext()) {
            ((IStartableService) it.next()).start();
        }
    }

    public final void bootstrap() {
        Iterator it = this.services.getAllServices(IBootstrapService.class).iterator();
        while (it.hasNext()) {
            ((IBootstrapService) it.next()).bootstrap();
        }
    }

    public final void scheduleStart() {
        new Thread(new a(this, 5)).start();
    }
}

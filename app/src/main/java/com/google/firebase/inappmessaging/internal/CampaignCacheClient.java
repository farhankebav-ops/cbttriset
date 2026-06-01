package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.time.Clock;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CampaignCacheClient {
    private final Application application;
    private r2.o cachedResponse;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    public CampaignCacheClient(@CampaignCache ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        this.storageClient = protoStorageClient;
        this.application = application;
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isResponseValid(r2.o oVar) {
        long jD = oVar.d();
        long jNow = this.clock.now();
        File file = new File(this.application.getApplicationContext().getFilesDir(), ProtoStorageClientModule.CAMPAIGN_CACHE_FILE);
        if (jD != 0) {
            return jNow < jD;
        }
        if (file.exists()) {
            return jNow < TimeUnit.DAYS.toMillis(1L) + file.lastModified();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r2.o lambda$get$1() throws Exception {
        return this.cachedResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$get$2(r2.o oVar) throws Exception {
        this.cachedResponse = oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$get$3(Throwable th) throws Exception {
        this.cachedResponse = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$put$0(r2.o oVar) throws Exception {
        this.cachedResponse = oVar;
    }

    public s4.h get() {
        e5.l lVar = new e5.l(new androidx.webkit.internal.c(this, 4));
        s4.h hVar = this.storageClient.read(r2.o.parser());
        b bVar = new b(this, 0);
        hVar.getClass();
        w1.f fVar = z4.b.f17984d;
        return new e5.s(new e5.g(new e5.g(lVar, new e5.s(hVar, bVar, fVar), 2), new b(this, 1), 0), fVar, new b(this, 2));
    }

    public s4.a put(r2.o oVar) {
        return this.storageClient.write(oVar).c(new a(0, this, oVar));
    }
}

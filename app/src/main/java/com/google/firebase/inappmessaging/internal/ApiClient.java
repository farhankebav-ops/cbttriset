package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class ApiClient {
    private static final String FETCHING_CAMPAIGN_MESSAGE = "Fetching campaigns from service.";
    private final Application application;
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final p5.a grpcClient;
    private final ProviderInstaller providerInstaller;

    public ApiClient(p5.a aVar, FirebaseApp firebaseApp, Application application, Clock clock, ProviderInstaller providerInstaller) {
        this.grpcClient = aVar;
        this.firebaseApp = firebaseApp;
        this.application = application;
        this.clock = clock;
        this.providerInstaller = providerInstaller;
    }

    private r2.i getClientAppInfo(InstallationIdResult installationIdResult) {
        r2.h hVarE = r2.i.e();
        hVarE.c(this.firebaseApp.getOptions().getApplicationId());
        hVarE.a(installationIdResult.installationId());
        hVarE.b(installationIdResult.installationTokenResult().getToken());
        return (r2.i) hVarE.build();
    }

    private l2.c getClientSignals() {
        l2.b bVarF = l2.c.f();
        bVarF.c(String.valueOf(Build.VERSION.SDK_INT));
        bVarF.b(Locale.getDefault().toString());
        bVarF.d(TimeZone.getDefault().getID());
        String versionName = getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            bVarF.a(versionName);
        }
        return (l2.c) bVarF.build();
    }

    private String getVersionName() {
        try {
            return this.application.getPackageManager().getPackageInfo(this.application.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.loge("Error finding versionName : " + e.getMessage());
            return null;
        }
    }

    private r2.o withCacheExpirationSafeguards(r2.o oVar) {
        if (oVar.d() >= TimeUnit.MINUTES.toMillis(1L) + this.clock.now()) {
            if (oVar.d() <= TimeUnit.DAYS.toMillis(3L) + this.clock.now()) {
                return oVar;
            }
        }
        r2.n nVar = (r2.n) oVar.toBuilder();
        nVar.a(TimeUnit.DAYS.toMillis(1L) + this.clock.now());
        return (r2.o) nVar.build();
    }

    public r2.o getFiams(InstallationIdResult installationIdResult, r2.f fVar) {
        Logging.logi(FETCHING_CAMPAIGN_MESSAGE);
        this.providerInstaller.install();
        GrpcClient grpcClient = (GrpcClient) this.grpcClient.get();
        r2.k kVarG = r2.l.g();
        kVarG.c(this.firebaseApp.getOptions().getGcmSenderId());
        kVarG.a(fVar.c());
        kVarG.b(getClientSignals());
        kVarG.d(getClientAppInfo(installationIdResult));
        return withCacheExpirationSafeguards(grpcClient.fetchEligibleCampaigns((r2.l) kVarG.build()));
    }
}

package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.android.gms.net.CronetProviderInstaller;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.MediationTraitsMetadataReader;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.network.core.CronetClient;
import com.unity3d.services.core.network.core.CronetEngineBuilderFactory;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;
import q5.i;
import q6.j;
import q6.l;
import r5.x;
import x5.c;
import x5.e;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidHttpClientProvider implements HttpClientProvider {
    private final AlternativeFlowReader alternativeFlowReader;
    private final Map<Boolean, HttpClient> cacheHttpClientMap;
    private final CleanupDirectory cleanupDirectory;
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final Context context;
    private final CronetEngineBuilderFactory cronetEngineBuilderFactory;
    private final ISDKDispatchers dispatchers;
    private final z6.a httpClientMutex;
    private final MediationTraitsMetadataReader mediationTraitsMetadataReader;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHttpClientProvider", f = "AndroidHttpClientProvider.kt", l = {177, 78}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidHttpClientProvider.this.invoke(false, this);
        }
    }

    public AndroidHttpClientProvider(ConfigFileFromLocalStorage configFileFromLocalStorage, AlternativeFlowReader alternativeFlowReader, ISDKDispatchers dispatchers, SendDiagnosticEvent sendDiagnosticEvent, Context context, CronetEngineBuilderFactory cronetEngineBuilderFactory, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, MediationTraitsMetadataReader mediationTraitsMetadataReader) {
        k.e(configFileFromLocalStorage, "configFileFromLocalStorage");
        k.e(alternativeFlowReader, "alternativeFlowReader");
        k.e(dispatchers, "dispatchers");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(context, "context");
        k.e(cronetEngineBuilderFactory, "cronetEngineBuilderFactory");
        k.e(sessionRepository, "sessionRepository");
        k.e(cleanupDirectory, "cleanupDirectory");
        k.e(mediationTraitsMetadataReader, "mediationTraitsMetadataReader");
        this.configFileFromLocalStorage = configFileFromLocalStorage;
        this.alternativeFlowReader = alternativeFlowReader;
        this.dispatchers = dispatchers;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.context = context;
        this.cronetEngineBuilderFactory = cronetEngineBuilderFactory;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.mediationTraitsMetadataReader = mediationTraitsMetadataReader;
        this.httpClientMutex = d.a();
        this.cacheHttpClientMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildCronetCachePath(Context context) {
        File filesDir = context.getFilesDir();
        k.d(filesDir, "context.filesDir");
        File fileD0 = c6.k.d0(filesDir, UnityAdsConstants.DefaultUrls.HTTP_CACHE_DIR_NAME);
        if (!fileD0.exists()) {
            fileD0.mkdirs();
        }
        String absolutePath = fileD0.getAbsolutePath();
        k.d(absolutePath, "cacheDir.absolutePath");
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildNetworkClient(final Context context, final ISDKDispatchers iSDKDispatchers, v5.c<? super HttpClient> cVar) {
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        CronetProviderInstaller.installProvider(context).addOnCompleteListener(new OnCompleteListener() { // from class: com.unity3d.ads.core.domain.AndroidHttpClientProvider$buildNetworkClient$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<Void> it) {
                String str;
                String message;
                long maxCachedAssetSizeMb;
                k.e(it, "it");
                str = "Errored without message.";
                if (!it.isSuccessful()) {
                    SendDiagnosticEvent sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
                    Exception exception = it.getException();
                    if (exception != null && (message = exception.getMessage()) != null) {
                        str = message;
                    }
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_cronet_install_error", null, x.e0(new i("reason", str)), null, null, null, 58, null);
                    lVar.resumeWith(new OkHttp3Client(iSDKDispatchers, new OkHttpClient(), context, this.this$0.sessionRepository, this.this$0.cleanupDirectory, this.this$0.alternativeFlowReader));
                    return;
                }
                if (this.this$0.sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
                    long j = 1024;
                    maxCachedAssetSizeMb = ((long) this.this$0.sessionRepository.getNativeConfiguration().getCachedAssetsConfiguration().getMaxCachedAssetSizeMb()) * j * j;
                } else {
                    maxCachedAssetSizeMb = ServiceProvider.HTTP_CACHE_DISK_SIZE;
                }
                try {
                    CronetEngine cronetEngine = this.this$0.cronetEngineBuilderFactory.createCronetEngineBuilder(context).setStoragePath(this.this$0.buildCronetCachePath(context)).enableHttpCache(3, maxCachedAssetSizeMb).enableQuic(true).addQuicHint(ServiceProvider.GATEWAY_HOST, 443, 443).addQuicHint(ServiceProvider.CDN_CREATIVES_HOST, 443, 443).build();
                    j jVar = lVar;
                    k.d(cronetEngine, "cronetEngine");
                    jVar.resumeWith(new CronetClient(cronetEngine, iSDKDispatchers));
                } catch (Throwable th) {
                    SendDiagnosticEvent sendDiagnosticEvent2 = this.this$0.sendDiagnosticEvent;
                    String message2 = th.getMessage();
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, "native_cronet_engine_error", null, x.e0(new i("reason", message2 != null ? message2 : "Errored without message.")), null, null, null, 58, null);
                    lVar.resumeWith(new OkHttp3Client(iSDKDispatchers, new OkHttpClient(), context, this.this$0.sessionRepository, this.this$0.cleanupDirectory, this.this$0.alternativeFlowReader));
                }
            }
        });
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x016d: CHECK_CAST (r8 I:z6.c) = (z6.c) (r8 I:??[OBJECT, ARRAY]), block:B:64:0x016d */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:13:0x0039, B:42:0x00dc, B:44:0x00e0, B:49:0x00eb, B:51:0x0109, B:61:0x015e, B:24:0x0071, B:27:0x0081, B:29:0x0097, B:35:0x00a3, B:37:0x00b3, B:38:0x00be, B:53:0x0124, B:55:0x0133, B:57:0x0139, B:59:0x013f, B:60:0x0157), top: B:66:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0109 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:13:0x0039, B:42:0x00dc, B:44:0x00e0, B:49:0x00eb, B:51:0x0109, B:61:0x015e, B:24:0x0071, B:27:0x0081, B:29:0x0097, B:35:0x00a3, B:37:0x00b3, B:38:0x00be, B:53:0x0124, B:55:0x0133, B:57:0x0139, B:59:0x013f, B:60:0x0157), top: B:66:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean, int] */
    @Override // com.unity3d.ads.core.domain.HttpClientProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(boolean r19, v5.c<? super com.unity3d.services.core.network.core.HttpClient> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidHttpClientProvider.invoke(boolean, v5.c):java.lang.Object");
    }
}

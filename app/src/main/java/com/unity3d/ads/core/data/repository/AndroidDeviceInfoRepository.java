package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import t6.d1;
import t6.e;
import t6.q0;
import t6.x0;
import x5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidDeviceInfoRepository implements DeviceInfoRepository {
    private final q0 allowedPii;
    private final String analyticsUserId;
    private final DynamicDeviceInfoDataSource dynamicDeviceInfoDataSource;
    private final PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource;
    private final SessionRepository sessionRepository;
    private final StaticDeviceInfoDataSource staticDeviceInfoDataSource;
    private final e volumeSettingsChange;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository$getAuidByteString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository", f = "AndroidDeviceInfoRepository.kt", l = {38}, m = "getAuidByteString")
    public static final class AnonymousClass1 extends c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidDeviceInfoRepository.this.getAuidByteString(this);
        }
    }

    public AndroidDeviceInfoRepository(StaticDeviceInfoDataSource staticDeviceInfoDataSource, DynamicDeviceInfoDataSource dynamicDeviceInfoDataSource, PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource, SessionRepository sessionRepository) {
        k.e(staticDeviceInfoDataSource, "staticDeviceInfoDataSource");
        k.e(dynamicDeviceInfoDataSource, "dynamicDeviceInfoDataSource");
        k.e(privacyDeviceInfoDataSource, "privacyDeviceInfoDataSource");
        k.e(sessionRepository, "sessionRepository");
        this.staticDeviceInfoDataSource = staticDeviceInfoDataSource;
        this.dynamicDeviceInfoDataSource = dynamicDeviceInfoDataSource;
        this.privacyDeviceInfoDataSource = privacyDeviceInfoDataSource;
        this.sessionRepository = sessionRepository;
        AllowedPiiOuterClass.AllowedPii defaultInstance = AllowedPiiOuterClass.AllowedPii.getDefaultInstance();
        k.d(defaultInstance, "getDefaultInstance()");
        this.allowedPii = x0.c(defaultInstance);
        this.analyticsUserId = staticDeviceInfoDataSource.getAnalyticsUserId();
        this.volumeSettingsChange = dynamicDeviceInfoDataSource.getVolumeSettingsChange();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public StaticDeviceInfoOuterClass.StaticDeviceInfo cachedStaticDeviceInfo() {
        return this.staticDeviceInfoDataSource.fetchCached();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public q0 getAllowedPii() {
        return this.allowedPii;
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getAnalyticsUserId() {
        return this.analyticsUserId;
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getAppName() {
        return this.staticDeviceInfoDataSource.getAppName();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getAuidByteString(v5.c<? super com.google.protobuf.ByteString> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository$getAuidByteString$1 r0 = (com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository$getAuidByteString$1 r0 = new com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository$getAuidByteString$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            r2.q.z0(r5)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            r2.q.z0(r5)
            r0.label = r3
            java.lang.Object r5 = r4.getAuidString(r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            java.lang.String r5 = (java.lang.String) r5
            r0 = 0
            if (r5 != 0) goto L41
            return r0
        L41:
            java.util.UUID r5 = java.util.UUID.fromString(r5)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = "fromString(auidString)"
            kotlin.jvm.internal.k.d(r5, r1)     // Catch: java.lang.Throwable -> L4f
            com.google.protobuf.ByteString r5 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r5)     // Catch: java.lang.Throwable -> L4f
            return r5
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository.getAuidByteString(v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public Object getAuidString(v5.c<? super String> cVar) {
        return this.staticDeviceInfoDataSource.getAuid(cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getConnectionTypeStr() {
        return this.dynamicDeviceInfoDataSource.getConnectionTypeStr();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public int getCurrentUiTheme() {
        return this.dynamicDeviceInfoDataSource.getCurrentUiTheme();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
        return this.dynamicDeviceInfoDataSource.fetch();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public boolean getHasInternet() {
        return this.dynamicDeviceInfoDataSource.hasInternet();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public Object getIdfi(v5.c<? super String> cVar) {
        return this.staticDeviceInfoDataSource.getIdfi(cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public List<String> getLocaleList() {
        return this.dynamicDeviceInfoDataSource.getLocaleList();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getManufacturer() {
        return this.staticDeviceInfoDataSource.getManufacturer();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getModel() {
        return this.staticDeviceInfoDataSource.getModel();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getOrientation() {
        return this.dynamicDeviceInfoDataSource.getOrientation();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public String getOsVersion() {
        return this.staticDeviceInfoDataSource.getOsVersion();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public PiiOuterClass.Pii getPiiData() {
        return this.privacyDeviceInfoDataSource.fetch((AllowedPiiOuterClass.AllowedPii) ((d1) getAllowedPii()).getValue());
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public int getRingerMode() {
        return this.dynamicDeviceInfoDataSource.getRingerMode();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public long getSystemBootTime() {
        return this.staticDeviceInfoDataSource.getSystemBootTime();
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public Object getUnityBuildGuid(v5.c<? super String> cVar) {
        return this.staticDeviceInfoDataSource.getUnityBuildGuid(cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public e getVolumeSettingsChange() {
        return this.volumeSettingsChange;
    }

    @Override // com.unity3d.ads.core.data.repository.DeviceInfoRepository
    public Object staticDeviceInfo(v5.c<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> cVar) {
        StaticDeviceInfoDataSource staticDeviceInfoDataSource = this.staticDeviceInfoDataSource;
        List<String> additionalStorePackagesList = this.sessionRepository.getNativeConfiguration().getAdditionalStorePackagesList();
        k.d(additionalStorePackagesList, "sessionRepository.native…ditionalStorePackagesList");
        return staticDeviceInfoDataSource.fetch(additionalStorePackagesList, cVar);
    }
}

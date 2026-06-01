package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.configuration.MediationInitBlobMetadataReader;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetInitializationRequestPayload implements GetInitializationRequestPayload {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetClientInfo getClientInfo;
    private final LegacyUserConsentRepository legacyUserConsentRepository;
    private final MediationInitBlobMetadataReader mediationInitBlobMetadataReader;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload", f = "AndroidGetInitializationRequestPayload.kt", l = {24, 25, 33, 34, 45, 50, 55, 60, 78}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidGetInitializationRequestPayload.this.invoke(this);
        }
    }

    public AndroidGetInitializationRequestPayload(GetClientInfo getClientInfo, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, LegacyUserConsentRepository legacyUserConsentRepository, MediationInitBlobMetadataReader mediationInitBlobMetadataReader) {
        k.e(getClientInfo, "getClientInfo");
        k.e(sessionRepository, "sessionRepository");
        k.e(deviceInfoRepository, "deviceInfoRepository");
        k.e(legacyUserConsentRepository, "legacyUserConsentRepository");
        k.e(mediationInitBlobMetadataReader, "mediationInitBlobMetadataReader");
        this.getClientInfo = getClientInfo;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.legacyUserConsentRepository = legacyUserConsentRepository;
        this.mediationInitBlobMetadataReader = mediationInitBlobMetadataReader;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02a5 A[PHI: r1 r4 r5 r9
  0x02a5: PHI (r1v70 java.lang.Object) = (r1v69 java.lang.Object), (r1v1 java.lang.Object) binds: [B:61:0x02a1, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
  0x02a5: PHI (r4v28 gatewayprotocol.v1.InitializationRequestKt$Dsl) = (r4v25 gatewayprotocol.v1.InitializationRequestKt$Dsl), (r4v30 gatewayprotocol.v1.InitializationRequestKt$Dsl) binds: [B:61:0x02a1, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
  0x02a5: PHI (r5v13 gatewayprotocol.v1.InitializationRequestKt$Dsl) = (r5v10 gatewayprotocol.v1.InitializationRequestKt$Dsl), (r5v15 gatewayprotocol.v1.InitializationRequestKt$Dsl) binds: [B:61:0x02a1, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
  0x02a5: PHI (r9v20 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload) = 
  (r9v17 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload)
  (r9v22 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload)
 binds: [B:61:0x02a1, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02cb A[PHI: r1 r4 r5 r9
  0x02cb: PHI (r1v74 java.lang.Object) = (r1v73 java.lang.Object), (r1v1 java.lang.Object) binds: [B:73:0x02c7, B:14:0x0050] A[DONT_GENERATE, DONT_INLINE]
  0x02cb: PHI (r4v31 gatewayprotocol.v1.InitializationRequestKt$Dsl) = (r4v28 gatewayprotocol.v1.InitializationRequestKt$Dsl), (r4v33 gatewayprotocol.v1.InitializationRequestKt$Dsl) binds: [B:73:0x02c7, B:14:0x0050] A[DONT_GENERATE, DONT_INLINE]
  0x02cb: PHI (r5v16 gatewayprotocol.v1.InitializationRequestKt$Dsl) = (r5v13 gatewayprotocol.v1.InitializationRequestKt$Dsl), (r5v18 gatewayprotocol.v1.InitializationRequestKt$Dsl) binds: [B:73:0x02c7, B:14:0x0050] A[DONT_GENERATE, DONT_INLINE]
  0x02cb: PHI (r9v23 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload) = 
  (r9v20 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload)
  (r9v25 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload)
 binds: [B:73:0x02c7, B:14:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02e9 A[PHI: r1 r4 r5 r9
  0x02e9: PHI (r1v78 java.lang.Object) = (r1v77 java.lang.Object), (r1v1 java.lang.Object) binds: [B:79:0x02e6, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
  0x02e9: PHI (r4v34 gatewayprotocol.v1.InitializationRequestKt$Dsl) = (r4v31 gatewayprotocol.v1.InitializationRequestKt$Dsl), (r4v36 gatewayprotocol.v1.InitializationRequestKt$Dsl) binds: [B:79:0x02e6, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
  0x02e9: PHI (r5v19 gatewayprotocol.v1.InitializationRequestKt$Dsl) = (r5v16 gatewayprotocol.v1.InitializationRequestKt$Dsl), (r5v21 gatewayprotocol.v1.InitializationRequestKt$Dsl) binds: [B:79:0x02e6, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
  0x02e9: PHI (r9v26 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload) = 
  (r9v23 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload)
  (r9v29 com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload)
 binds: [B:79:0x02e6, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0320  */
    @Override // com.unity3d.ads.core.domain.GetInitializationRequestPayload
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(v5.c<? super gatewayprotocol.v1.InitializationRequestOuterClass.InitializationRequest> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 906
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload.invoke(v5.c):java.lang.Object");
    }
}

package com.unity3d.ads.core.domain.exposure;

import a.a;
import android.util.Base64;
import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.ads.core.domain.CacheFile;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.GetIsFileCache;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.offerwall.GetIsOfferwallAdReady;
import com.unity3d.ads.core.domain.offerwall.LoadOfferwallAd;
import com.unity3d.ads.core.domain.om.AndroidOmInteraction;
import com.unity3d.ads.core.domain.om.GetOmData;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.domain.om.OmImpressionOccurred;
import com.unity3d.ads.core.domain.scar.LoadScarAd;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.utils.ContinuationFromCallback;
import com.unity3d.services.core.api.Storage;
import com.unity3d.services.core.network.model.RequestType;
import gatewayprotocol.v1.AllowedPiiKt;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n;
import org.json.JSONObject;
import q5.x;
import r2.q;
import s5.f;
import t6.d1;
import t6.q0;
import v5.c;
import v5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonAdViewerExposedFunctionsKt {

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29151 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ CacheFile $cacheFile;

        public C29151(CacheFile cacheFile, AdObject adObject) {
            this.$cacheFile = cacheFile;
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r8, v5.c<java.lang.Object> r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1
                if (r0 == 0) goto L14
                r0 = r9
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.label = r1
            L12:
                r6 = r0
                goto L1a
            L14:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1
                r0.<init>(r7, r9)
                goto L12
            L1a:
                java.lang.Object r9 = r6.result
                w5.a r0 = w5.a.f17774a
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                r2.q.z0(r9)
                goto L63
            L29:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L31:
                r2.q.z0(r9)
                r9 = 0
                r1 = r8[r9]
                java.lang.String r3 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.k.c(r1, r3)
                org.json.JSONObject r1 = (org.json.JSONObject) r1
                java.lang.String r3 = "url"
                r4 = r2
                java.lang.String r2 = r1.getString(r3)
                r5 = 2
                java.lang.Object r8 = r5.j.p0(r5, r8)
                org.json.JSONArray r8 = (org.json.JSONArray) r8
                java.lang.String r5 = "priority"
                int r5 = r1.optInt(r5, r9)
                com.unity3d.ads.core.domain.CacheFile r1 = r7.$cacheFile
                kotlin.jvm.internal.k.d(r2, r3)
                com.unity3d.ads.core.data.model.AdObject r3 = r7.$adObject
                r6.label = r4
                r4 = r8
                java.lang.Object r9 = r1.invoke(r2, r3, r4, r5, r6)
                if (r9 != r0) goto L63
                return r0
            L63:
                com.unity3d.ads.core.data.model.CacheResult r9 = (com.unity3d.ads.core.data.model.CacheResult) r9
                boolean r8 = r9 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
                if (r8 == 0) goto L82
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r0 = "unity-ads-cache://unity.ads.cache/"
                r8.<init>(r0)
                com.unity3d.ads.core.data.model.CacheResult$Success r9 = (com.unity3d.ads.core.data.model.CacheResult.Success) r9
                com.unity3d.ads.core.data.model.CachedFile r9 = r9.getCachedFile()
                java.lang.String r9 = r9.getName()
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                return r8
            L82:
                boolean r8 = r9 instanceof com.unity3d.ads.core.data.model.CacheResult.Failure
                if (r8 == 0) goto L9a
                com.unity3d.ads.core.data.model.CacheResult$Failure r9 = (com.unity3d.ads.core.data.model.CacheResult.Failure) r9
                com.unity3d.ads.core.data.model.CacheError r8 = r9.getError()
                java.lang.String r8 = r8.name()
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L9a:
                e2.s r8 = new e2.s
                r9 = 3
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29151.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29211 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        public C29211(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r4, v5.c<java.lang.Object> r5) throws java.lang.Throwable {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L2f
                if (r1 != r2) goto L27
                r2.q.z0(r5)
                goto L3d
            L27:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L2f:
                r2.q.z0(r5)
                com.unity3d.ads.core.data.repository.SessionRepository r5 = r3.$sessionRepository
                r4.label = r2
                java.lang.Object r5 = r5.getPrivacy(r4)
                if (r5 != r0) goto L3d
                return r0
            L3d:
                com.google.protobuf.ByteString r5 = (com.google.protobuf.ByteString) r5
                r4 = 0
                r0 = 0
                java.lang.String r4 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64$default(r5, r4, r2, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29211.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29221 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        public C29221(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r4, v5.c<java.lang.Object> r5) throws java.lang.Throwable {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L2f
                if (r1 != r2) goto L27
                r2.q.z0(r5)
                goto L3d
            L27:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L2f:
                r2.q.z0(r5)
                com.unity3d.ads.core.data.repository.SessionRepository r5 = r3.$sessionRepository
                r4.label = r2
                java.lang.Object r5 = r5.getPrivacyFsm(r4)
                if (r5 != r0) goto L3d
                return r0
            L3d:
                com.google.protobuf.ByteString r5 = (com.google.protobuf.ByteString) r5
                r4 = 0
                r0 = 0
                java.lang.String r4 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64$default(r5, r4, r2, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29221.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadOfferwallAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29341 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ LoadOfferwallAd $loadOfferwallAd;

        public C29341(AdObject adObject, LoadOfferwallAd loadOfferwallAd) {
            this.$adObject = adObject;
            this.$loadOfferwallAd = loadOfferwallAd;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r5, v5.c<? super q5.x> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadOfferwallAd$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadOfferwallAd$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadOfferwallAd$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadOfferwallAd$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadOfferwallAd$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r6)
                goto L5a
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                r2.q.z0(r6)
                r6 = 0
                r5 = r5[r6]
                java.lang.String r6 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.k.c(r5, r6)
                org.json.JSONObject r5 = (org.json.JSONObject) r5
                java.lang.String r6 = "placementName"
                java.lang.String r5 = r5.optString(r6)
                com.unity3d.ads.core.data.model.AdObject r2 = r4.$adObject
                r2.setOfferwallAd(r3)
                com.unity3d.ads.core.data.model.AdObject r2 = r4.$adObject
                r2.setOfferwallPlacementName(r5)
                com.unity3d.ads.core.domain.offerwall.LoadOfferwallAd r2 = r4.$loadOfferwallAd
                kotlin.jvm.internal.k.d(r5, r6)
                r0.label = r3
                java.lang.Object r5 = r2.invoke(r5, r0)
                if (r5 != r1) goto L5a
                return r1
            L5a:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29341.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29351 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ LoadScarAd $loadScarAd;

        public C29351(AdObject adObject, LoadScarAd loadScarAd) {
            this.$adObject = adObject;
            this.$loadScarAd = loadScarAd;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
            /*
                r11 = this;
                boolean r0 = r13 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1
                if (r0 == 0) goto L14
                r0 = r13
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.label = r1
            L12:
                r8 = r0
                goto L1a
            L14:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1
                r0.<init>(r11, r13)
                goto L12
            L1a:
                java.lang.Object r13 = r8.result
                w5.a r0 = w5.a.f17774a
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                r2.q.z0(r13)
                goto L94
            L29:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L31:
                r2.q.z0(r13)
                r13 = 0
                r12 = r12[r13]
                java.lang.String r13 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.k.c(r12, r13)
                org.json.JSONObject r12 = (org.json.JSONObject) r12
                java.lang.String r13 = "type"
                java.lang.String r13 = r12.optString(r13)
                java.lang.String r1 = "adUnitId"
                java.lang.String r4 = r12.optString(r1)
                java.lang.String r3 = "adString"
                java.lang.String r5 = r12.optString(r3)
                java.lang.String r6 = "queryId"
                r7 = r6
                java.lang.String r6 = r12.optString(r7)
                java.lang.String r9 = "videoLength"
                int r12 = r12.optInt(r9)
                com.unity3d.ads.core.data.model.AdObject r9 = r11.$adObject
                r9.setScarAd(r2)
                com.unity3d.ads.core.data.model.AdObject r9 = r11.$adObject
                r9.setScarAdUnitId(r4)
                com.unity3d.ads.core.data.model.AdObject r9 = r11.$adObject
                r9.setScarQueryId(r6)
                com.unity3d.ads.core.data.model.AdObject r9 = r11.$adObject
                r9.setScarAdString(r5)
                r9 = r1
                com.unity3d.ads.core.domain.scar.LoadScarAd r1 = r11.$loadScarAd
                java.lang.String r10 = "adType"
                kotlin.jvm.internal.k.d(r13, r10)
                com.unity3d.ads.core.data.model.AdObject r10 = r11.$adObject
                java.lang.String r10 = r10.getPlacementId()
                kotlin.jvm.internal.k.d(r4, r9)
                kotlin.jvm.internal.k.d(r5, r3)
                kotlin.jvm.internal.k.d(r6, r7)
                r8.label = r2
                r7 = r12
                r2 = r13
                r3 = r10
                java.lang.Object r12 = r1.invoke(r2, r3, r4, r5, r6, r7, r8)
                if (r12 != r0) goto L94
                return r0
            L94:
                q5.x r12 = q5.x.f13520a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29351.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29371 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ OmFinishSession $omFinishSession;

        public C29371(OmFinishSession omFinishSession, AdObject adObject) {
            this.$omFinishSession = omFinishSession;
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r4, v5.c<? super q5.x> r5) throws java.lang.Throwable {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L2f
                if (r1 != r2) goto L27
                r2.q.z0(r5)
                goto L3f
            L27:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L2f:
                r2.q.z0(r5)
                com.unity3d.ads.core.domain.om.OmFinishSession r5 = r3.$omFinishSession
                com.unity3d.ads.core.data.model.AdObject r1 = r3.$adObject
                r4.label = r2
                java.lang.Object r4 = r5.invoke(r1, r4)
                if (r4 != r0) goto L3f
                return r0
            L3f:
                q5.x r4 = q5.x.f13520a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29371.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29381 implements ExposedFunction {
        final /* synthetic */ GetOmData $getOmData;

        public C29381(GetOmData getOmData) {
            this.$getOmData = getOmData;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r4, v5.c<java.lang.Object> r5) throws java.lang.Throwable {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L2f
                if (r1 != r2) goto L27
                r2.q.z0(r5)
                goto L3d
            L27:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L2f:
                r2.q.z0(r5)
                com.unity3d.ads.core.domain.om.GetOmData r5 = r3.$getOmData
                r4.label = r2
                java.lang.Object r5 = r5.invoke(r4)
                if (r5 != r0) goto L3d
                return r0
            L3d:
                com.unity3d.ads.core.data.model.OMData r5 = (com.unity3d.ads.core.data.model.OMData) r5
                s5.f r4 = new s5.f
                r4.<init>()
                java.lang.String r0 = "version"
                java.lang.String r1 = r5.getVersion()
                r4.put(r0, r1)
                java.lang.String r0 = "partnerName"
                java.lang.String r1 = r5.getPartnerName()
                r4.put(r0, r1)
                java.lang.String r0 = "partnerVersion"
                java.lang.String r5 = r5.getPartnerVersion()
                r4.put(r0, r5)
                s5.f r4 = r4.b()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29381.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29391 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ OmImpressionOccurred $omImpressionOccurred;

        public C29391(OmImpressionOccurred omImpressionOccurred, AdObject adObject) {
            this.$omImpressionOccurred = omImpressionOccurred;
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r5, v5.c<? super q5.x> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r6)
                goto L4d
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                r2.q.z0(r6)
                r6 = 0
                r5 = r5[r6]
                java.lang.String r6 = "null cannot be cast to non-null type kotlin.Boolean"
                kotlin.jvm.internal.k.c(r5, r6)
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                com.unity3d.ads.core.domain.om.OmImpressionOccurred r6 = r4.$omImpressionOccurred
                com.unity3d.ads.core.data.model.AdObject r2 = r4.$adObject
                r0.label = r3
                java.lang.Object r5 = r6.invoke(r2, r5, r0)
                if (r5 != r1) goto L4d
                return r1
            L4d:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29391.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29401 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ AndroidOmInteraction $omStartSession;

        public C29401(AndroidOmInteraction androidOmInteraction, AdObject adObject) {
            this.$omStartSession = androidOmInteraction;
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r5, v5.c<? super q5.x> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r6)
                goto L49
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                r2.q.z0(r6)
                r6 = 0
                r5 = r5[r6]
                java.lang.String r6 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.k.c(r5, r6)
                org.json.JSONObject r5 = (org.json.JSONObject) r5
                com.unity3d.ads.core.domain.om.AndroidOmInteraction r6 = r4.$omStartSession
                com.unity3d.ads.core.data.model.AdObject r2 = r4.$adObject
                r0.label = r3
                java.lang.Object r5 = r6.invoke(r2, r5, r0)
                if (r5 != r1) goto L49
                return r1
            L49:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29401.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29431 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ Refresh $refresh;

        public C29431(Refresh refresh, AdObject adObject) {
            this.$refresh = refresh;
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r8, v5.c<java.lang.Object> r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r9
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                java.lang.String r3 = "adDataRefreshToken"
                r4 = 0
                r5 = 0
                r6 = 1
                if (r2 == 0) goto L33
                if (r2 != r6) goto L2b
                r2.q.z0(r9)
                goto L68
            L2b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L33:
                r2.q.z0(r9)
                int r9 = r8.length
                if (r9 != 0) goto L3c
                com.google.protobuf.ByteString r8 = com.google.protobuf.ByteString.EMPTY
                goto L52
            L3c:
                r8 = r8[r5]
                java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.k.c(r8, r9)
                org.json.JSONObject r8 = (org.json.JSONObject) r8
                java.lang.String r8 = r8.optString(r3)
                java.lang.String r9 = "refreshToken"
                kotlin.jvm.internal.k.d(r8, r9)
                com.google.protobuf.ByteString r8 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64$default(r8, r5, r6, r4)
            L52:
                com.unity3d.ads.core.domain.Refresh r9 = r7.$refresh
                java.lang.String r2 = "refreshTokenByteString"
                kotlin.jvm.internal.k.d(r8, r2)
                com.unity3d.ads.core.data.model.AdObject r2 = r7.$adObject
                com.google.protobuf.ByteString r2 = r2.getOpportunityId()
                r0.label = r6
                java.lang.Object r9 = r9.invoke(r8, r2, r0)
                if (r9 != r1) goto L68
                return r1
            L68:
                gatewayprotocol.v1.AdDataRefreshResponseOuterClass$AdDataRefreshResponse r9 = (gatewayprotocol.v1.AdDataRefreshResponseOuterClass.AdDataRefreshResponse) r9
                boolean r8 = r9.hasError()
                if (r8 != 0) goto Lae
                s5.f r8 = new s5.f
                r8.<init>()
                com.google.protobuf.ByteString r0 = r9.getAdData()
                java.lang.String r1 = "adRefreshResponse.adData"
                kotlin.jvm.internal.k.d(r0, r1)
                java.lang.String r0 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64$default(r0, r5, r6, r4)
                java.lang.String r1 = "adData"
                r8.put(r1, r0)
                com.google.protobuf.ByteString r0 = r9.getAdDataRefreshToken()
                java.lang.String r1 = "adRefreshResponse.adDataRefreshToken"
                kotlin.jvm.internal.k.d(r0, r1)
                java.lang.String r0 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64$default(r0, r5, r6, r4)
                r8.put(r3, r0)
                com.google.protobuf.ByteString r9 = r9.getTrackingToken()
                java.lang.String r0 = "adRefreshResponse.trackingToken"
                kotlin.jvm.internal.k.d(r9, r0)
                java.lang.String r9 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64$default(r9, r5, r6, r4)
                java.lang.String r0 = "trackingToken"
                r8.put(r0, r9)
                s5.f r8 = r8.b()
                return r8
            Lae:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r9 = "Refresh failed"
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29431.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$request$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29441 implements ExposedFunction {
        final /* synthetic */ ExecuteAdViewerRequest $executeAdViewerRequest;
        final /* synthetic */ RequestType $type;

        public C29441(ExecuteAdViewerRequest executeAdViewerRequest, RequestType requestType) {
            this.$executeAdViewerRequest = executeAdViewerRequest;
            this.$type = requestType;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r9, v5.c<java.lang.Object> r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29441.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29461 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ GetOperativeEventApi $getOperativeEventApi;

        public C29461(GetOperativeEventApi getOperativeEventApi, AdObject adObject) {
            this.$getOperativeEventApi = getOperativeEventApi;
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r7
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r7)
                goto L59
            L27:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L2f:
                r2.q.z0(r7)
                gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType r7 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_SPECIFIED_BY_AD_PLAYER
                r2 = 0
                r6 = r6[r2]
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                kotlin.jvm.internal.k.c(r6, r2)
                java.lang.String r6 = (java.lang.String) r6
                r2 = 2
                byte[] r6 = android.util.Base64.decode(r6, r2)
                java.lang.String r2 = "decode(it[0] as String, Base64.NO_WRAP)"
                kotlin.jvm.internal.k.d(r6, r2)
                com.google.protobuf.ByteString r6 = com.google.protobuf.kotlin.ByteStringsKt.toByteString(r6)
                com.unity3d.ads.core.domain.events.GetOperativeEventApi r2 = r5.$getOperativeEventApi
                com.unity3d.ads.core.data.model.AdObject r4 = r5.$adObject
                r0.label = r3
                java.lang.Object r6 = r2.invoke(r7, r4, r6, r0)
                if (r6 != r1) goto L59
                return r1
            L59:
                q5.x r6 = q5.x.f13520a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29461.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29471 implements ExposedFunction {
        final /* synthetic */ SendPrivacyUpdateRequest $sendPrivacyUpdateRequest;

        public C29471(SendPrivacyUpdateRequest sendPrivacyUpdateRequest) {
            this.$sendPrivacyUpdateRequest = sendPrivacyUpdateRequest;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r10, v5.c<java.lang.Object> r11) throws java.lang.Throwable {
            /*
                r9 = this;
                boolean r0 = r11 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r11
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1
                r0.<init>(r9, r11)
            L18:
                java.lang.Object r11 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 0
                java.lang.String r4 = "version"
                java.lang.String r5 = "content"
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L35
                if (r2 != r7) goto L2d
                r2.q.z0(r11)
                goto L5d
            L2d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L35:
                r2.q.z0(r11)
                r10 = r10[r6]
                java.lang.String r11 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.k.c(r10, r11)
                org.json.JSONObject r10 = (org.json.JSONObject) r10
                java.lang.String r11 = r10.optString(r5)
                int r10 = r10.optInt(r4)
                com.unity3d.ads.core.domain.SendPrivacyUpdateRequest r2 = r9.$sendPrivacyUpdateRequest
                java.lang.String r8 = "privacyUpdateContentBase64"
                kotlin.jvm.internal.k.d(r11, r8)
                com.google.protobuf.ByteString r11 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64$default(r11, r6, r7, r3)
                r0.label = r7
                java.lang.Object r11 = r2.invoke(r10, r11, r0)
                if (r11 != r1) goto L5d
                return r1
            L5d:
                gatewayprotocol.v1.PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse r11 = (gatewayprotocol.v1.PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse) r11
                s5.f r10 = new s5.f
                r10.<init>()
                int r0 = r11.getVersion()
                java.lang.Integer r1 = new java.lang.Integer
                r1.<init>(r0)
                r10.put(r4, r1)
                com.google.protobuf.ByteString r11 = r11.getContent()
                java.lang.String r0 = "response.content"
                kotlin.jvm.internal.k.d(r11, r0)
                java.lang.String r11 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64$default(r11, r6, r7, r3)
                r10.put(r5, r11)
                s5.f r10 = r10.b()
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29471.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setOrientation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29501 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;

        public C29501(AdObject adObject) {
            this.$adObject = adObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setOrientation$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r8
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setOrientation$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setOrientation$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setOrientation$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setOrientation$1$invoke$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r8)
                goto L63
            L27:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2f:
                r2.q.z0(r8)
                r8 = 0
                r7 = r7[r8]
                java.lang.String r8 = "null cannot be cast to non-null type kotlin.Int"
                kotlin.jvm.internal.k.c(r7, r8)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r7 = r7.intValue()
                com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$Companion r8 = com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.Companion
                t6.p0 r8 = r8.getDisplayMessages()
                com.unity3d.ads.adplayer.DisplayMessage$SetOrientation r2 = new com.unity3d.ads.adplayer.DisplayMessage$SetOrientation
                com.unity3d.ads.core.data.model.AdObject r4 = r6.$adObject
                com.google.protobuf.ByteString r4 = r4.getOpportunityId()
                java.lang.String r4 = r4.toStringUtf8()
                java.lang.String r5 = "adObject.opportunityId.toStringUtf8()"
                kotlin.jvm.internal.k.d(r4, r5)
                r2.<init>(r4, r7)
                r0.label = r3
                java.lang.Object r7 = r8.emit(r2, r0)
                if (r7 != r1) goto L63
                return r1
            L63:
                q5.x r7 = q5.x.f13520a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29501.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29511 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        public C29511(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r5, v5.c<? super q5.x> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r6)
                goto L55
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                r2.q.z0(r6)
                com.unity3d.ads.core.data.repository.SessionRepository r6 = r4.$sessionRepository
                r2 = 0
                r5 = r5[r2]
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                kotlin.jvm.internal.k.c(r5, r2)
                java.lang.String r5 = (java.lang.String) r5
                r2 = 2
                byte[] r5 = android.util.Base64.decode(r5, r2)
                java.lang.String r2 = "decode(it[0] as String, Base64.NO_WRAP)"
                kotlin.jvm.internal.k.d(r5, r2)
                com.google.protobuf.ByteString r5 = com.google.protobuf.kotlin.ByteStringsKt.toByteString(r5)
                r0.label = r3
                java.lang.Object r5 = r6.setPrivacy(r5, r0)
                if (r5 != r1) goto L55
                return r1
            L55:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29511.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C29521 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        public C29521(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(java.lang.Object[] r5, v5.c<? super q5.x> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                r2.q.z0(r6)
                goto L55
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                r2.q.z0(r6)
                com.unity3d.ads.core.data.repository.SessionRepository r6 = r4.$sessionRepository
                r2 = 0
                r5 = r5[r2]
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                kotlin.jvm.internal.k.c(r5, r2)
                java.lang.String r5 = (java.lang.String) r5
                r2 = 2
                byte[] r5 = android.util.Base64.decode(r5, r2)
                java.lang.String r2 = "decode(it[0] as String, Base64.NO_WRAP)"
                kotlin.jvm.internal.k.d(r5, r2)
                com.google.protobuf.ByteString r5 = com.google.protobuf.kotlin.ByteStringsKt.toByteString(r5)
                r0.label = r3
                java.lang.Object r5 = r6.setPrivacyFsm(r5, r0)
                if (r5 != r1) goto L55
                return r1
            L55:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29521.invoke(java.lang.Object[], v5.c):java.lang.Object");
        }
    }

    public static final ExposedFunction attributionRegisterClick(final AndroidAttribution androidAttribution, final AdObject adObject) {
        k.e(androidAttribution, "androidAttribution");
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.attributionRegisterClick.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                AndroidAttribution androidAttribution2 = androidAttribution;
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                return androidAttribution2.registerClick((String) obj, adObject, cVar);
            }
        };
    }

    public static final ExposedFunction attributionRegisterView(final AndroidAttribution androidAttribution, final AdObject adObject) {
        k.e(androidAttribution, "androidAttribution");
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.attributionRegisterView.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                AndroidAttribution androidAttribution2 = androidAttribution;
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                return androidAttribution2.registerView((String) obj, adObject, cVar);
            }
        };
    }

    public static final ExposedFunction clearStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.clearStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Storage.clear((String) obj, new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }

    public static final ExposedFunction deleteStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.deleteStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                Storage.delete((String) obj, (String) obj2, new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }

    public static final ExposedFunction download(CacheFile cacheFile, AdObject adObject) {
        k.e(cacheFile, "cacheFile");
        k.e(adObject, "adObject");
        return new C29151(cacheFile, adObject);
    }

    /* JADX INFO: renamed from: getAdContext-yLuu4LI, reason: not valid java name */
    public static final ExposedFunction m3217getAdContextyLuu4LI(AndroidGetAdPlayerContext getAndroidAdPlayerContext, String adData, String impressionConfig, String adDataRefreshToken, IsOMActivated isOMActivated, AdObject adObject) {
        k.e(getAndroidAdPlayerContext, "getAndroidAdPlayerContext");
        k.e(adData, "adData");
        k.e(impressionConfig, "impressionConfig");
        k.e(adDataRefreshToken, "adDataRefreshToken");
        k.e(isOMActivated, "isOMActivated");
        k.e(adObject, "adObject");
        return new CommonAdViewerExposedFunctionsKt$getAdContext$1(adData, impressionConfig, adDataRefreshToken, getAndroidAdPlayerContext, adObject, isOMActivated);
    }

    public static final ExposedFunction getAllowedPii(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getAllowedPii.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                String strEncodeToString = Base64.encodeToString(((AllowedPiiOuterClass.AllowedPii) ((d1) deviceInfoRepository.getAllowedPii()).getValue()).toByteArray(), 2);
                k.d(strEncodeToString, "encodeToString(deviceInf…eArray(), Base64.NO_WRAP)");
                return strEncodeToString;
            }
        };
    }

    public static final ExposedFunction getConnectionType(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getConnectionType.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                DynamicDeviceInfoOuterClass.ConnectionType connectionType = deviceInfoRepository.getDynamicDeviceInfo().getConnectionType();
                k.d(connectionType, "deviceInfoRepository.dyn…DeviceInfo.connectionType");
                return connectionType;
            }
        };
    }

    public static final ExposedFunction getDeviceMaxVolume(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getDeviceMaxVolume.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                return new Double(deviceInfoRepository.getDynamicDeviceInfo().getAndroid().getMaxVolume());
            }
        };
    }

    public static final ExposedFunction getDeviceVolume(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getDeviceVolume.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                return new Double(deviceInfoRepository.getDynamicDeviceInfo().getAndroid().getVolume());
            }
        };
    }

    public static final ExposedFunction getKeysStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getKeysStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = objArr[2];
                k.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                Storage.getKeys((String) obj, (String) obj2, (Boolean) obj3, new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }

    public static final ExposedFunction getPrivacy(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new C29211(sessionRepository);
    }

    public static final ExposedFunction getPrivacyFsm(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new C29221(sessionRepository);
    }

    public static final ExposedFunction getScreenHeight(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getScreenHeight.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                return new Integer(deviceInfoRepository.getDynamicDeviceInfo().getScreenHeight());
            }
        };
    }

    public static final ExposedFunction getScreenWidth(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getScreenWidth.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                return new Integer(deviceInfoRepository.getDynamicDeviceInfo().getScreenWidth());
            }
        };
    }

    public static final ExposedFunction getSessionToken(final SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getSessionToken.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                return ProtobufExtensionsKt.toBase64$default(sessionRepository.getSessionToken(), false, 1, null);
            }
        };
    }

    public static final ExposedFunction getStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                Storage.get((String) obj, (String) obj2, new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }

    public static final ExposedFunction hbTokenIncrementStarts(final SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.hbTokenIncrementStarts.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                sessionRepository.incrementTokenStartsCount();
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction hbTokenIncrementWins(final SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.hbTokenIncrementWins.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                sessionRepository.incrementTokenWinsCount();
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction hbTokenReset(final SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.hbTokenReset.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                sessionRepository.resetTokenCounters();
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction incrementBannerImpressionCount(final SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.incrementBannerImpressionCount.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                sessionRepository.incrementBannerImpressionCount();
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction isAttributionAvailable(final AndroidAttribution androidAttribution) {
        k.e(androidAttribution, "androidAttribution");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.isAttributionAvailable.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                return androidAttribution.isAvailable(cVar);
            }
        };
    }

    public static final ExposedFunction isFileCached(final GetIsFileCache getIfFileCache) {
        k.e(getIfFileCache, "getIfFileCache");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.isFileCached.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                return getIfFileCache.invoke((String) obj, cVar);
            }
        };
    }

    public static final ExposedFunction isOfferwallAdReady(final GetIsOfferwallAdReady getIsOfferwallAdReady) {
        k.e(getIsOfferwallAdReady, "getIsOfferwallAdReady");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.isOfferwallAdReady.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) {
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
                String placementName = ((JSONObject) obj).optString("placementName");
                GetIsOfferwallAdReady getIsOfferwallAdReady2 = getIsOfferwallAdReady;
                k.d(placementName, "placementName");
                return getIsOfferwallAdReady2.invoke(placementName, cVar);
            }
        };
    }

    public static final ExposedFunction loadOfferwallAd(LoadOfferwallAd loadOfferwallAd, AdObject adObject) {
        k.e(loadOfferwallAd, "loadOfferwallAd");
        k.e(adObject, "adObject");
        return new C29341(adObject, loadOfferwallAd);
    }

    public static final ExposedFunction loadScarAd(LoadScarAd loadScarAd, AdObject adObject) {
        k.e(loadScarAd, "loadScarAd");
        k.e(adObject, "adObject");
        return new C29351(adObject, loadScarAd);
    }

    public static final ExposedFunction markCampaignStateShown(final CampaignRepository campaignRepository, final AdObject adObject) {
        k.e(campaignRepository, "campaignRepository");
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.markCampaignStateShown.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                campaignRepository.setShowTimestamp(adObject.getOpportunityId());
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction omFinishSession(OmFinishSession omFinishSession, AdObject adObject) {
        k.e(omFinishSession, "omFinishSession");
        k.e(adObject, "adObject");
        return new C29371(omFinishSession, adObject);
    }

    public static final ExposedFunction omGetData(GetOmData getOmData) {
        k.e(getOmData, "getOmData");
        return new C29381(getOmData);
    }

    public static final ExposedFunction omImpression(OmImpressionOccurred omImpressionOccurred, AdObject adObject) {
        k.e(omImpressionOccurred, "omImpressionOccurred");
        k.e(adObject, "adObject");
        return new C29391(omImpressionOccurred, adObject);
    }

    public static final ExposedFunction omStartSession(AndroidOmInteraction omStartSession, AdObject adObject) {
        k.e(omStartSession, "omStartSession");
        k.e(adObject, "adObject");
        return new C29401(omStartSession, adObject);
    }

    public static final ExposedFunction openUrl(final HandleOpenUrl handleOpenUrl) {
        k.e(handleOpenUrl, "handleOpenUrl");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.openUrl.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                Object objP0 = r5.j.p0(1, objArr);
                JSONObject jSONObject = objP0 instanceof JSONObject ? (JSONObject) objP0 : null;
                handleOpenUrl.invoke(str, jSONObject != null ? jSONObject.optString("packageName") : null);
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction readStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.readStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Storage.read((String) obj, new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }

    public static final ExposedFunction refreshAdData(Refresh refresh, AdObject adObject) {
        k.e(refresh, "refresh");
        k.e(adObject, "adObject");
        return new C29431(refresh, adObject);
    }

    public static final ExposedFunction request(RequestType type, ExecuteAdViewerRequest executeAdViewerRequest) {
        k.e(type, "type");
        k.e(executeAdViewerRequest, "executeAdViewerRequest");
        return new C29441(executeAdViewerRequest, type);
    }

    public static final ExposedFunction sendDiagnosticEvent(final SendDiagnosticEvent sendDiagnosticEvent, final AdObject adObject) {
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.sendDiagnosticEvent.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                String string;
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                Object obj2 = objArr[1];
                k.c(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj2;
                f fVar = new f();
                Iterator<String> itKeys = jSONObject.keys();
                k.d(itKeys, "tags.keys()");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    fVar.put(next, jSONObject.getString(next));
                }
                f fVarB = fVar.b();
                Object objP0 = r5.j.p0(2, objArr);
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, str, (objP0 == null || (string = objP0.toString()) == null) ? null : new Double(Double.parseDouble(string)), fVarB, null, adObject, null, 40, null);
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction sendOperativeEvent(GetOperativeEventApi getOperativeEventApi, AdObject adObject) {
        k.e(getOperativeEventApi, "getOperativeEventApi");
        k.e(adObject, "adObject");
        return new C29461(getOperativeEventApi, adObject);
    }

    public static final ExposedFunction sendPrivacyUpdateRequest(SendPrivacyUpdateRequest sendPrivacyUpdateRequest) {
        k.e(sendPrivacyUpdateRequest, "sendPrivacyUpdateRequest");
        return new C29471(sendPrivacyUpdateRequest);
    }

    public static final ExposedFunction setAllowedPii(final DeviceInfoRepository deviceInfoRepository) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.setAllowedPii.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                d1 d1Var;
                Object value;
                final AllowedPiiKt.Dsl dsl_create;
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                q0 allowedPii = deviceInfoRepository.getAllowedPii();
                do {
                    d1Var = (d1) allowedPii;
                    value = d1Var.getValue();
                    AllowedPiiKt.Dsl.Companion companion = AllowedPiiKt.Dsl.Companion;
                    AllowedPiiOuterClass.AllowedPii.Builder builder = ((AllowedPiiOuterClass.AllowedPii) value).toBuilder();
                    k.d(builder, "this.toBuilder()");
                    dsl_create = companion._create(builder);
                    Object objOpt = jSONObject.opt("idfa");
                    Boolean bool = objOpt instanceof Boolean ? (Boolean) objOpt : null;
                    if (bool != null) {
                        new n(dsl_create) { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$2
                            @Override // l6.m
                            public Object get() {
                                return Boolean.valueOf(((AllowedPiiKt.Dsl) this.receiver).getIdfa());
                            }

                            @Override // l6.h
                            public void set(Object obj2) {
                                ((AllowedPiiKt.Dsl) this.receiver).setIdfa(((Boolean) obj2).booleanValue());
                            }
                        }.set(bool);
                    }
                    Object objOpt2 = jSONObject.opt("idfv");
                    Boolean bool2 = objOpt2 instanceof Boolean ? (Boolean) objOpt2 : null;
                    if (bool2 != null) {
                        new n(dsl_create) { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$4
                            @Override // l6.m
                            public Object get() {
                                return Boolean.valueOf(((AllowedPiiKt.Dsl) this.receiver).getIdfv());
                            }

                            @Override // l6.h
                            public void set(Object obj2) {
                                ((AllowedPiiKt.Dsl) this.receiver).setIdfv(((Boolean) obj2).booleanValue());
                            }
                        }.set(bool2);
                    }
                    Object objOpt3 = jSONObject.opt("appset_id");
                    Boolean bool3 = objOpt3 instanceof Boolean ? (Boolean) objOpt3 : null;
                    if (bool3 != null) {
                        new n(dsl_create) { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$6
                            @Override // l6.m
                            public Object get() {
                                return Boolean.valueOf(((AllowedPiiKt.Dsl) this.receiver).getAppsetId());
                            }

                            @Override // l6.h
                            public void set(Object obj2) {
                                ((AllowedPiiKt.Dsl) this.receiver).setAppsetId(((Boolean) obj2).booleanValue());
                            }
                        }.set(bool3);
                    }
                } while (!d1Var.g(value, dsl_create._build()));
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction setOpportunityTTL(final AdObject adObject) {
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.setOpportunityTTL.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) obj).intValue();
                q0 ttl = adObject.getTtl();
                int i2 = o6.a.f13207d;
                o6.a aVar = new o6.a(q.A0(iIntValue, o6.c.f13212d));
                d1 d1Var = (d1) ttl;
                d1Var.getClass();
                d1Var.i(null, aVar);
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction setOrientation(AdObject adObject) {
        k.e(adObject, "adObject");
        return new C29501(adObject);
    }

    public static final ExposedFunction setPrivacy(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new C29511(sessionRepository);
    }

    public static final ExposedFunction setPrivacyFsm(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        return new C29521(sessionRepository);
    }

    public static final ExposedFunction setStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.setStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                k.c(obj2, "null cannot be cast to non-null type kotlin.String");
                Storage.set((String) obj, (String) obj2, objArr[2], new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }

    public static final ExposedFunction showOfferwallAd() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.showOfferwallAd.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction showScarAd() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.showScarAd.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction updateCampaignState(final CampaignRepository campaignRepository, final AdObject adObject) {
        k.e(campaignRepository, "campaignRepository");
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.updateCampaignState.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invoke(java.lang.Object[] r6, v5.c<? super q5.x> r7) {
                /*
                    r5 = this;
                    java.lang.String r7 = "<this>"
                    kotlin.jvm.internal.k.e(r6, r7)
                    int r7 = r6.length
                    r0 = 0
                    r1 = 0
                    if (r7 != 0) goto Lc
                    r6 = r1
                    goto Le
                Lc:
                    r6 = r6[r0]
                Le:
                    boolean r7 = r6 instanceof org.json.JSONObject
                    if (r7 == 0) goto L15
                    org.json.JSONObject r6 = (org.json.JSONObject) r6
                    goto L16
                L15:
                    r6 = r1
                L16:
                    if (r6 == 0) goto Lad
                    java.lang.String r7 = "data"
                    java.lang.String r2 = r6.optString(r7)
                    if (r2 == 0) goto La5
                    boolean r3 = n6.m.A0(r2)
                    if (r3 != 0) goto La5
                    java.lang.String r3 = "dataVersion"
                    int r6 = r6.optInt(r3)
                    if (r6 == 0) goto L9d
                    com.unity3d.ads.core.data.model.AdObject r3 = r1
                    com.google.protobuf.ByteString r3 = r3.getOpportunityId()
                    com.unity3d.ads.core.data.model.AdObject r4 = r1
                    java.lang.String r4 = r4.getPlacementId()
                    kotlin.jvm.internal.k.d(r2, r7)
                    r7 = 1
                    com.google.protobuf.ByteString r7 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64$default(r2, r0, r7, r1)
                    boolean r0 = r7.isEmpty()
                    if (r0 != 0) goto L95
                    com.unity3d.ads.core.data.repository.CampaignRepository r0 = r2
                    gatewayprotocol.v1.CampaignStateOuterClass$Campaign r0 = r0.getCampaign(r3)
                    if (r0 == 0) goto L6e
                    gatewayprotocol.v1.CampaignKt$Dsl$Companion r1 = gatewayprotocol.v1.CampaignKt.Dsl.Companion
                    com.google.protobuf.GeneratedMessageLite$Builder r0 = r0.toBuilder()
                    java.lang.String r2 = "this.toBuilder()"
                    kotlin.jvm.internal.k.d(r0, r2)
                    gatewayprotocol.v1.CampaignStateOuterClass$Campaign$Builder r0 = (gatewayprotocol.v1.CampaignStateOuterClass.Campaign.Builder) r0
                    gatewayprotocol.v1.CampaignKt$Dsl r0 = r1._create(r0)
                    r0.setData(r7)
                    r0.setDataVersion(r6)
                    gatewayprotocol.v1.CampaignStateOuterClass$Campaign r0 = r0._build()
                    if (r0 == 0) goto L6e
                    goto L8d
                L6e:
                    gatewayprotocol.v1.CampaignKt$Dsl$Companion r0 = gatewayprotocol.v1.CampaignKt.Dsl.Companion
                    gatewayprotocol.v1.CampaignStateOuterClass$Campaign$Builder r1 = gatewayprotocol.v1.CampaignStateOuterClass.Campaign.newBuilder()
                    java.lang.String r2 = "newBuilder()"
                    kotlin.jvm.internal.k.d(r1, r2)
                    gatewayprotocol.v1.CampaignKt$Dsl r0 = r0._create(r1)
                    r0.setData(r7)
                    r0.setDataVersion(r6)
                    r0.setPlacementId(r4)
                    r0.setImpressionOpportunityId(r3)
                    gatewayprotocol.v1.CampaignStateOuterClass$Campaign r0 = r0._build()
                L8d:
                    com.unity3d.ads.core.data.repository.CampaignRepository r6 = r2
                    r6.setCampaign(r3, r0)
                    q5.x r6 = q5.x.f13520a
                    return r6
                L95:
                    java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                    java.lang.String r7 = "Update campaign state requires a non-empty data byte string"
                    r6.<init>(r7)
                    throw r6
                L9d:
                    java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                    java.lang.String r7 = "Update campaign state requires a dataVersion integer"
                    r6.<init>(r7)
                    throw r6
                La5:
                    java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                    java.lang.String r7 = "Update campaign state requires a data string"
                    r6.<init>(r7)
                    throw r6
                Lad:
                    java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                    java.lang.String r7 = "Update campaign state requires a JSONObject"
                    r6.<init>(r7)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C29561.invoke(java.lang.Object[], v5.c):java.lang.Object");
            }
        };
    }

    public static final ExposedFunction updateTrackingToken(final AdObject adObject) {
        k.e(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.updateTrackingToken.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<? super x> cVar) {
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
                String token = ((JSONObject) obj).optString(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN);
                if (token != null && token.length() != 0) {
                    AdObject adObject2 = adObject;
                    k.d(token, "token");
                    adObject2.setTrackingToken(ProtobufExtensionsKt.fromBase64$default(token, false, 1, null));
                }
                return x.f13520a;
            }
        };
    }

    public static final ExposedFunction writeStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.writeStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, e6.p
            public final Object invoke(Object[] objArr, c<Object> cVar) throws Throwable {
                j jVar = new j(a.I(cVar));
                Object obj = objArr[0];
                k.c(obj, "null cannot be cast to non-null type kotlin.String");
                Storage.write((String) obj, new ContinuationFromCallback(jVar));
                Object objA = jVar.a();
                w5.a aVar = w5.a.f17774a;
                return objA;
            }
        };
    }
}

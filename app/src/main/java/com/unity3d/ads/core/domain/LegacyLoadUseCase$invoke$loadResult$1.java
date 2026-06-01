package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.LoadResult;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.AdRequestOuterClass;
import q5.x;
import q6.a0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1", f = "LegacyLoadUseCase.kt", l = {127, Sdk.SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE, Sdk.SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE}, m = "invokeSuspend")
public final class LegacyLoadUseCase$invoke$loadResult$1 extends i implements p {
    final /* synthetic */ Context $context;
    final /* synthetic */ AdRequestOuterClass.BannerSize $gatewayBannerSize;
    final /* synthetic */ UnityAdsLoadOptions $loadOptions;
    final /* synthetic */ String $opportunityId;
    final /* synthetic */ String $placement;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitializationState.values().length];
            try {
                iArr[InitializationState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationState.NOT_INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InitializationState.INITIALIZING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacyLoadUseCase$invoke$loadResult$1(String str, String str2, LegacyLoadUseCase legacyLoadUseCase, Context context, AdRequestOuterClass.BannerSize bannerSize, UnityAdsLoadOptions unityAdsLoadOptions, c<? super LegacyLoadUseCase$invoke$loadResult$1> cVar) {
        super(2, cVar);
        this.$placement = str;
        this.$opportunityId = str2;
        this.this$0 = legacyLoadUseCase;
        this.$context = context;
        this.$gatewayBannerSize = bannerSize;
        this.$loadOptions = unityAdsLoadOptions;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new LegacyLoadUseCase$invoke$loadResult$1(this.$placement, this.$opportunityId, this.this$0, this.$context, this.$gatewayBannerSize, this.$loadOptions, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0147, code lost:
    
        if (r0 == r8) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x017d, code lost:
    
        if (r0 == r8) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super LoadResult> cVar) {
        return ((LegacyLoadUseCase$invoke$loadResult$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}

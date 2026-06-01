package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.OpenAdvertisingId;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.PiiKt;
import gatewayprotocol.v1.PiiOuterClass;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidPrivacyDeviceInfoDataSource implements PrivacyDeviceInfoDataSource {
    private final AndroidAppSetIdDataSource appSetIdDataSource;
    private final Context context;
    private final FIdDataSource fIdDataSource;
    private final q0 idfaInitialized;

    public AndroidPrivacyDeviceInfoDataSource(Context context, FIdDataSource fIdDataSource, AndroidAppSetIdDataSource appSetIdDataSource) {
        k.e(context, "context");
        k.e(fIdDataSource, "fIdDataSource");
        k.e(appSetIdDataSource, "appSetIdDataSource");
        this.context = context;
        this.fIdDataSource = fIdDataSource;
        this.appSetIdDataSource = appSetIdDataSource;
        this.idfaInitialized = x0.c(Boolean.FALSE);
    }

    private final String getAdvertisingTrackingId() {
        String advertisingTrackingId = AdvertisingId.getAdvertisingTrackingId();
        return advertisingTrackingId == null ? "" : advertisingTrackingId;
    }

    private final String getOpenAdvertisingTrackingId() {
        String openAdvertisingTrackingId = OpenAdvertisingId.getOpenAdvertisingTrackingId();
        return openAdvertisingTrackingId == null ? "" : openAdvertisingTrackingId;
    }

    @Override // com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource
    public PiiOuterClass.Pii fetch(AllowedPiiOuterClass.AllowedPii allowed) {
        String appSetId;
        String strInvoke;
        k.e(allowed, "allowed");
        if (!((Boolean) ((d1) this.idfaInitialized).getValue()).booleanValue()) {
            q0 q0Var = this.idfaInitialized;
            Boolean bool = Boolean.TRUE;
            d1 d1Var = (d1) q0Var;
            d1Var.getClass();
            d1Var.i(null, bool);
            AdvertisingId.init(this.context);
            OpenAdvertisingId.init(this.context);
        }
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.Companion;
        PiiOuterClass.Pii.Builder builderNewBuilder = PiiOuterClass.Pii.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        final PiiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        if (allowed.getIdfa()) {
            String advertisingTrackingId = getAdvertisingTrackingId();
            if (advertisingTrackingId.length() > 0) {
                UUID uuidFromString = UUID.fromString(advertisingTrackingId);
                k.d(uuidFromString, "fromString(adId)");
                dsl_create.setAdvertisingId(ProtobufExtensionsKt.toByteString(uuidFromString));
            }
            String openAdvertisingTrackingId = getOpenAdvertisingTrackingId();
            if (openAdvertisingTrackingId.length() > 0) {
                UUID uuidFromString2 = UUID.fromString(openAdvertisingTrackingId);
                k.d(uuidFromString2, "fromString(openAdId)");
                dsl_create.setOpenAdvertisingTrackingId(ProtobufExtensionsKt.toByteString(uuidFromString2));
            }
        }
        if (allowed.getFid() && (strInvoke = this.fIdDataSource.invoke()) != null) {
            if (strInvoke.length() <= 0) {
                strInvoke = null;
            }
            if (strInvoke != null) {
                new n(dsl_create) { // from class: com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource$fetch$1$3
                    @Override // l6.m
                    public Object get() {
                        return ((PiiKt.Dsl) this.receiver).getFid();
                    }

                    @Override // l6.h
                    public void set(Object obj) {
                        ((PiiKt.Dsl) this.receiver).setFid((String) obj);
                    }
                }.set(strInvoke);
            }
        }
        if (allowed.getAppsetId() && (appSetId = this.appSetIdDataSource.getAppSetId()) != null) {
            String str = appSetId.length() > 0 ? appSetId : null;
            if (str != null) {
                new n(dsl_create) { // from class: com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource$fetch$1$6
                    @Override // l6.m
                    public Object get() {
                        return ((PiiKt.Dsl) this.receiver).getAppsetId();
                    }

                    @Override // l6.h
                    public void set(Object obj) {
                        ((PiiKt.Dsl) this.receiver).setAppsetId((String) obj);
                    }
                }.set(str);
            }
        }
        return dsl_create._build();
    }
}

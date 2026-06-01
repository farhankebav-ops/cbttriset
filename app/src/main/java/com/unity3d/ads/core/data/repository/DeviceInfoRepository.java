package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import java.util.List;
import t6.e;
import t6.q0;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface DeviceInfoRepository {
    StaticDeviceInfoOuterClass.StaticDeviceInfo cachedStaticDeviceInfo();

    q0 getAllowedPii();

    String getAnalyticsUserId();

    String getAppName();

    Object getAuidByteString(c<? super ByteString> cVar);

    Object getAuidString(c<? super String> cVar);

    String getConnectionTypeStr();

    int getCurrentUiTheme();

    DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo();

    boolean getHasInternet();

    Object getIdfi(c<? super String> cVar);

    List<String> getLocaleList();

    String getManufacturer();

    String getModel();

    String getOrientation();

    String getOsVersion();

    PiiOuterClass.Pii getPiiData();

    int getRingerMode();

    long getSystemBootTime();

    Object getUnityBuildGuid(c<? super String> cVar);

    e getVolumeSettingsChange();

    Object staticDeviceInfo(c<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> cVar);
}

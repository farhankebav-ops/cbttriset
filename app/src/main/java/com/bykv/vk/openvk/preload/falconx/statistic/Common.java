package com.bykv.vk.openvk.preload.falconx.statistic;

import android.os.Build;
import com.bykv.vk.openvk.preload.a.a.b;
import com.ironsource.Q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Common {

    @b(a = "app_version")
    public String appVersion;

    @b(a = "device_id")
    public String deviceId;

    @b(a = "region")
    public String region;

    @b(a = "sdk_version")
    public String sdkVersion = "2.0.3-rc.9-pangle";

    @b(a = "device_model")
    public String deviceModel = Build.MODEL;

    @b(a = Q6.F)
    public int os = 0;
}

package com.ironsource;

import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.oc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2489oc {

    /* JADX INFO: renamed from: com.ironsource.oc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9557a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f9558b = "SDKPluginType";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9559c = "sessionid";

        private a() {
        }
    }

    public final Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String pluginType = ConfigFile.getConfigFile().getPluginType();
        if (pluginType != null) {
            linkedHashMap.put(a.f9558b, pluginType);
        }
        String strD = IronSourceUtils.d();
        if (strD != null) {
            linkedHashMap.put("sessionid", strD);
        }
        return linkedHashMap;
    }
}

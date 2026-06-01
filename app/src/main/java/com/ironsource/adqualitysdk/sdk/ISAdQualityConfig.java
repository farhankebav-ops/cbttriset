package com.ironsource.adqualitysdk.sdk;

import android.text.TextUtils;
import com.ironsource.adqualitysdk.sdk.i.am;
import com.ironsource.adqualitysdk.sdk.i.k;
import com.ironsource.adqualitysdk.sdk.i.ka;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ISAdQualityConfig {

    /* JADX INFO: renamed from: ﭴ, reason: collision with root package name */
    private final Map<String, String> f7988;

    /* JADX INFO: renamed from: ﮐ, reason: collision with root package name */
    private final String f7989;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private final boolean f4;

    /* JADX INFO: renamed from: ﱡ, reason: collision with root package name */
    private final ISAdQualityLogLevel f7990;

    /* JADX INFO: renamed from: ﺙ, reason: collision with root package name */
    private final ISAdQualityDeviceIdType f7991;

    /* JADX INFO: renamed from: ﻏ, reason: collision with root package name */
    private final boolean f7992;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final boolean f8;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final String f9;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final Set<ISAdQualityInitListener> f10;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final boolean f11;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final boolean f12;

    public /* synthetic */ ISAdQualityConfig(String str, boolean z2, boolean z7, boolean z8, ISAdQualityLogLevel iSAdQualityLogLevel, Set set, String str2, boolean z9, boolean z10, ISAdQualityDeviceIdType iSAdQualityDeviceIdType, Map map, byte b8) {
        this(str, z2, z7, z8, iSAdQualityLogLevel, set, str2, z9, z10, iSAdQualityDeviceIdType, map);
    }

    public static ISAdQualityConfig merge(ISAdQualityConfig iSAdQualityConfig, ISAdQualityConfig iSAdQualityConfig2) {
        Builder builder = new Builder();
        if (iSAdQualityConfig.f12) {
            builder.setUserId(iSAdQualityConfig.f9);
        } else if (iSAdQualityConfig2.f12) {
            builder.setUserId(iSAdQualityConfig2.f9);
        }
        if (iSAdQualityConfig.f8) {
            builder.setTestMode(iSAdQualityConfig.f11);
        } else if (iSAdQualityConfig2.f8) {
            builder.setTestMode(iSAdQualityConfig2.f11);
        }
        if (iSAdQualityConfig.f4) {
            builder.setCoppa(iSAdQualityConfig.f7992);
        } else if (iSAdQualityConfig2.f4) {
            builder.setCoppa(iSAdQualityConfig2.f7992);
        }
        ISAdQualityLogLevel iSAdQualityLogLevel = iSAdQualityConfig.f7990;
        if (iSAdQualityLogLevel == null) {
            iSAdQualityLogLevel = iSAdQualityConfig2.f7990;
        }
        builder.setLogLevel(iSAdQualityLogLevel);
        Iterator<ISAdQualityInitListener> it = iSAdQualityConfig.f10.iterator();
        while (it.hasNext()) {
            builder.addAdQualityInitListener(it.next());
        }
        Iterator<ISAdQualityInitListener> it2 = iSAdQualityConfig2.f10.iterator();
        while (it2.hasNext()) {
            builder.addAdQualityInitListener(it2.next());
        }
        String str = iSAdQualityConfig.f7989;
        if (str != null) {
            builder.setInitializationSource(str);
        } else {
            String str2 = iSAdQualityConfig2.f7989;
            if (str2 != null) {
                builder.setInitializationSource(str2);
            }
        }
        ISAdQualityDeviceIdType iSAdQualityDeviceIdType = iSAdQualityConfig.f7991;
        if (iSAdQualityDeviceIdType == null) {
            iSAdQualityDeviceIdType = iSAdQualityConfig2.f7991;
        }
        builder.setDeviceIdType(iSAdQualityDeviceIdType);
        HashMap map = new HashMap(iSAdQualityConfig2.f7988);
        map.putAll(iSAdQualityConfig.f7988);
        for (Map.Entry entry : map.entrySet()) {
            builder.setMetaData((String) entry.getKey(), (String) entry.getValue());
        }
        return builder.build();
    }

    public Set<ISAdQualityInitListener> getAdQualityInitListeners() {
        return this.f10;
    }

    public boolean getCoppa() {
        return this.f7992;
    }

    public ISAdQualityDeviceIdType getDeviceIdType() {
        return this.f7991;
    }

    public String getInitializationSource() {
        return this.f7989;
    }

    public ISAdQualityLogLevel getLogLevel() {
        return this.f7990;
    }

    public Map<String, String> getMetaData() {
        return this.f7988;
    }

    public String getUserId() {
        return this.f9;
    }

    public boolean isTestMode() {
        return this.f11;
    }

    public boolean isUserIdSet() {
        return this.f12;
    }

    private ISAdQualityConfig(String str, boolean z2, boolean z7, boolean z8, ISAdQualityLogLevel iSAdQualityLogLevel, Set<ISAdQualityInitListener> set, String str2, boolean z9, boolean z10, ISAdQualityDeviceIdType iSAdQualityDeviceIdType, Map<String, String> map) {
        this.f9 = str;
        this.f12 = z2;
        this.f11 = z7;
        this.f8 = z8;
        this.f7990 = iSAdQualityLogLevel;
        this.f10 = set;
        this.f7989 = str2;
        this.f7992 = z9;
        this.f4 = z10;
        this.f7991 = iSAdQualityDeviceIdType;
        this.f7988 = map;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private String f22 = null;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private boolean f19 = false;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private boolean f21 = false;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private boolean f23 = false;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private ISAdQualityLogLevel f20 = ISAdQualityLogLevel.INFO;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private final Set<ISAdQualityInitListener> f17 = new HashSet();

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private String f16 = null;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private boolean f15 = false;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private boolean f18 = false;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private ISAdQualityDeviceIdType f14 = ISAdQualityDeviceIdType.NONE;

        /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
        private final Map<String, String> f13 = new HashMap();

        public Builder addAdQualityInitListener(ISAdQualityInitListener iSAdQualityInitListener) {
            this.f17.add(iSAdQualityInitListener);
            return this;
        }

        public ISAdQualityConfig build() {
            return new ISAdQualityConfig(this.f22, this.f19, this.f21, this.f23, this.f20, this.f17, this.f16, this.f15, this.f18, this.f14, this.f13, (byte) 0);
        }

        public Builder removeAdQualityInitListener(ISAdQualityInitListener iSAdQualityInitListener) {
            this.f17.remove(iSAdQualityInitListener);
            return this;
        }

        @Deprecated
        public Builder setAdQualityInitListener(ISAdQualityInitListener iSAdQualityInitListener) {
            return addAdQualityInitListener(iSAdQualityInitListener);
        }

        public Builder setCoppa(boolean z2) {
            this.f15 = z2;
            this.f18 = true;
            return this;
        }

        public Builder setDeviceIdType(ISAdQualityDeviceIdType iSAdQualityDeviceIdType) {
            this.f14 = iSAdQualityDeviceIdType;
            return this;
        }

        public Builder setInitializationSource(String str) {
            if (ka.m2881(str, 20)) {
                this.f16 = str;
                return this;
            }
            StringBuilder sb = new StringBuilder("setInitializationSource( ");
            sb.append(str);
            sb.append(" ) init source must have length of 1-20");
            k.m2868("ISAdQualityConfig", sb.toString());
            return this;
        }

        public Builder setLogLevel(ISAdQualityLogLevel iSAdQualityLogLevel) {
            this.f20 = iSAdQualityLogLevel;
            return this;
        }

        public Builder setMetaData(JSONObject jSONObject) {
            if (jSONObject != null) {
                for (int i2 = 0; i2 < jSONObject.names().length(); i2++) {
                    try {
                        String string = jSONObject.names().getString(i2);
                        Object objOpt = jSONObject.opt(string);
                        if (objOpt instanceof String) {
                            setMetaData(string, (String) objOpt);
                        } else {
                            StringBuilder sb = new StringBuilder("setMetaData( ");
                            sb.append(string);
                            sb.append(" , ");
                            sb.append(objOpt);
                            sb.append(" ) value must be a string");
                            k.m2868("ISAdQualityConfig", sb.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return this;
        }

        public Builder setTestMode(boolean z2) {
            this.f21 = z2;
            this.f23 = true;
            return this;
        }

        public Builder setUserId(String str) {
            this.f22 = str;
            this.f19 = true;
            return this;
        }

        public Builder setMetaData(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    if (!am.m514(str)) {
                        if (am.m517(this.f13, str)) {
                            StringBuilder sb = new StringBuilder("setMetaData( ");
                            sb.append(str);
                            sb.append(" , ");
                            sb.append(str2);
                            sb.append(" ) limited to 5 meta data values. Ignoring meta data value.");
                            k.m2868("ISAdQualityConfig", sb.toString());
                            return this;
                        }
                        if (!am.m515(str, str2)) {
                            StringBuilder sb2 = new StringBuilder("setMetaData( ");
                            sb2.append(str);
                            sb2.append(" , ");
                            sb2.append(str2);
                            sb2.append(" ) the length of both the key and the value should be between 1 and 64 characters.");
                            k.m2868("ISAdQualityConfig", sb2.toString());
                            return this;
                        }
                    }
                    this.f13.put(str, str2);
                }
            } catch (Exception unused) {
            }
            return this;
        }
    }
}

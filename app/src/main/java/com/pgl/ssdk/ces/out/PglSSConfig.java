package com.pgl.ssdk.ces.out;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PglSSConfig {
    public static final int COLLECT_MODE_DEFAULT = 0;
    public static final int COLLECT_MODE_ML_MINIMIZE = 1;
    public static final String CUSTOMINFO_KEY_ALLOWED_FIELDS = "fields_allowed";
    public static final String CUSTOMINFO_KEY_CHECKCLAZZ = "check_clz";
    public static final String CUSTOMINFO_KEY_IPV6 = "key_ipv6";
    public static final String CUSTOMINFO_KEY_SEC_CONFIG_STR = "sec_config";
    public static final String CUSTOMINFO_KEY_TARGET_IDC = "target-idc";
    public static final String CUSTOMINFO_KEY_TRANSFER_HOST = "key_transfer_host";
    public static final int OVREGION_TYPE_SG = 2;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10735d;
    private Map<String, Object> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PglSSCallBack f10736f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10738b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10739c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10740d;

        public PglSSConfig build() {
            if (TextUtils.isEmpty(this.f10737a)) {
                return null;
            }
            return new PglSSConfig(this.f10737a, this.f10738b, this.f10739c, this.f10740d);
        }

        public Builder setAdsdkVersion(String str) {
            this.f10740d = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.f10737a = str;
            return this;
        }

        public Builder setCollectMode(int i2) {
            this.f10739c = i2;
            return this;
        }

        public Builder setOVRegionType(int i2) {
            this.f10738b = i2;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAdSdkVersion() {
        return this.f10735d;
    }

    public String getAppId() {
        return this.f10732a;
    }

    public PglSSCallBack getCallBack() {
        return this.f10736f;
    }

    public int getCollectMode() {
        return this.f10734c;
    }

    public Map<String, Object> getCustomInfo() {
        return this.e;
    }

    public int getOVRegionType() {
        return this.f10733b;
    }

    public void setCallBack(PglSSCallBack pglSSCallBack) {
        this.f10736f = pglSSCallBack;
    }

    public void setCustomInfo(Map<String, Object> map) {
        this.e = map;
    }

    private PglSSConfig(String str, int i2, int i8, String str2) {
        this.f10732a = str;
        this.f10733b = i2;
        this.f10734c = i8;
        this.f10735d = str2;
    }
}

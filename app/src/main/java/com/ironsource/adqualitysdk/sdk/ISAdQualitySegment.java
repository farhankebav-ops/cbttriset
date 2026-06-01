package com.ironsource.adqualitysdk.sdk;

import android.text.TextUtils;
import com.ironsource.adqualitysdk.sdk.i.k;
import com.ironsource.adqualitysdk.sdk.i.ka;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ISAdQualitySegment {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private final long f40;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private final Map<String, String> f41;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private double f42;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final String f43;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final int f44;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final AtomicBoolean f45;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final String f46;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final int f47;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private String f54;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private String f55;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private double f53 = 999999.99d;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private int f56 = -1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private int f52 = -1;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private AtomicBoolean f51 = null;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private long f48 = 0;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private double f50 = -1.0d;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private Map<String, String> f49 = new HashMap();

        public ISAdQualitySegment build() {
            return new ISAdQualitySegment(this.f55, this.f56, this.f54, this.f52, this.f51, this.f50, this.f48, new HashMap(this.f49), (byte) 0);
        }

        public Builder setAge(int i2) {
            if (i2 == 0) {
                return this;
            }
            if (i2 > 0 && i2 <= 199) {
                this.f56 = i2;
                return this;
            }
            StringBuilder sb = new StringBuilder("setAge( ");
            sb.append(i2);
            sb.append(" ) age must be between 1-199");
            k.m2868("ISAdQualitySegment Builder", sb.toString());
            return this;
        }

        public Builder setCustomData(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return this;
            }
            try {
                if (this.f49.size() >= 5) {
                    StringBuilder sb = new StringBuilder("setCustomData( ");
                    sb.append(str);
                    sb.append(" , ");
                    sb.append(str2);
                    sb.append(" ) limited to 5 custom values. Ignoring custom value.");
                    k.m2868("ISAdQualitySegment Builder", sb.toString());
                    return this;
                }
                if (ka.m2886(str) && ka.m2886(str2) && ka.m2881(str, 32) && ka.m2881(str2, 32)) {
                    this.f49.put("sgct_".concat(String.valueOf(str)), str2);
                    return this;
                }
                StringBuilder sb2 = new StringBuilder("setCustomData( ");
                sb2.append(str);
                sb2.append(" , ");
                sb2.append(str2);
                sb2.append(" ) key and value must be alphanumeric and 1-32 in length");
                k.m2868("ISAdQualitySegment Builder", sb2.toString());
                return this;
            } catch (Exception e) {
                e.printStackTrace();
                return this;
            }
        }

        public Builder setGender(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            Locale locale = Locale.ENGLISH;
            if (str.toLowerCase(locale).equals(IronSourceConstants.a.f9378b) || str.toLowerCase(locale).equals(IronSourceConstants.a.f9379c)) {
                this.f54 = str.toLowerCase(locale);
                return this;
            }
            StringBuilder sb = new StringBuilder("setGender( ");
            sb.append(str);
            sb.append(" ) is invalid");
            k.m2868("ISAdQualitySegment Builder", sb.toString());
            return this;
        }

        public Builder setInAppPurchasesTotal(double d8) {
            if (d8 >= 0.0d && d8 < this.f53) {
                this.f50 = Math.floor(d8 * 100.0d) / 100.0d;
                return this;
            }
            StringBuilder sb = new StringBuilder("setIAPTotal( ");
            sb.append(d8);
            sb.append(" ) iapt must be between 0-");
            sb.append(this.f53);
            k.m2868("ISAdQualitySegment Builder", sb.toString());
            return this;
        }

        public Builder setIsPaying(boolean z2) {
            if (this.f51 == null) {
                this.f51 = new AtomicBoolean();
            }
            this.f51.set(z2);
            return this;
        }

        public Builder setLevel(int i2) {
            if (i2 == 0) {
                return this;
            }
            if (i2 > 0 && i2 < 999999) {
                this.f52 = i2;
                return this;
            }
            StringBuilder sb = new StringBuilder("setLevel( ");
            sb.append(i2);
            sb.append(" ) level must be between 1-999999");
            k.m2868("ISAdQualitySegment Builder", sb.toString());
            return this;
        }

        public Builder setSegmentName(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (ka.m2886(str) && ka.m2881(str, 32)) {
                this.f55 = str;
                return this;
            }
            StringBuilder sb = new StringBuilder("setSegmentName( ");
            sb.append(str);
            sb.append(" ) segment name must be alphanumeric and 1-32 in length");
            k.m2868("ISAdQualitySegment Builder", sb.toString());
            return this;
        }

        public Builder setUserCreationDate(long j) {
            if (j == 0) {
                return this;
            }
            if (j > 0) {
                this.f48 = j;
                return this;
            }
            StringBuilder sb = new StringBuilder("setUserCreationDate( ");
            sb.append(j);
            sb.append(" ) is an invalid timestamp");
            k.m2868("ISAdQualitySegment Builder", sb.toString());
            return this;
        }
    }

    public /* synthetic */ ISAdQualitySegment(String str, int i2, String str2, int i8, AtomicBoolean atomicBoolean, double d8, long j, Map map, byte b8) {
        this(str, i2, str2, i8, atomicBoolean, d8, j, map);
    }

    public int getAge() {
        return this.f47;
    }

    public Map<String, String> getCustomData() {
        return this.f41;
    }

    public String getGender() {
        return this.f46;
    }

    public double getInAppPurchasesTotal() {
        return this.f42;
    }

    public AtomicBoolean getIsPaying() {
        return this.f45;
    }

    public int getLevel() {
        return this.f44;
    }

    public String getName() {
        return this.f43;
    }

    public long getUserCreationDate() {
        return this.f40;
    }

    private ISAdQualitySegment(String str, int i2, String str2, int i8, AtomicBoolean atomicBoolean, double d8, long j, Map<String, String> map) {
        this.f43 = str;
        this.f47 = i2;
        this.f46 = str2;
        this.f44 = i8;
        this.f45 = atomicBoolean;
        this.f42 = d8;
        this.f40 = j;
        this.f41 = map;
    }
}

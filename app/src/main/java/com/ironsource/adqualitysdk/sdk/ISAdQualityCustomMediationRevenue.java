package com.ironsource.adqualitysdk.sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ISAdQualityCustomMediationRevenue {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final String f24;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final double f25;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final ISAdQualityAdType f26;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final ISAdQualityMediationNetwork f27;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private ISAdQualityMediationNetwork f28 = ISAdQualityMediationNetwork.UNKNOWN;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private ISAdQualityAdType f29 = ISAdQualityAdType.UNKNOWN;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private String f30;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private double f31;

        public ISAdQualityCustomMediationRevenue build() {
            return new ISAdQualityCustomMediationRevenue(this.f28, this.f29, this.f31, this.f30, (byte) 0);
        }

        public Builder setAdType(ISAdQualityAdType iSAdQualityAdType) {
            this.f29 = iSAdQualityAdType;
            return this;
        }

        public Builder setMediationNetwork(ISAdQualityMediationNetwork iSAdQualityMediationNetwork) {
            this.f28 = iSAdQualityMediationNetwork;
            return this;
        }

        public Builder setPlacement(String str) {
            this.f30 = str;
            return this;
        }

        public Builder setRevenue(double d8) {
            this.f31 = d8;
            return this;
        }
    }

    public /* synthetic */ ISAdQualityCustomMediationRevenue(ISAdQualityMediationNetwork iSAdQualityMediationNetwork, ISAdQualityAdType iSAdQualityAdType, double d8, String str, byte b8) {
        this(iSAdQualityMediationNetwork, iSAdQualityAdType, d8, str);
    }

    public ISAdQualityAdType getAdType() {
        return this.f26;
    }

    public ISAdQualityMediationNetwork getMediationNetwork() {
        return this.f27;
    }

    public String getPlacement() {
        return this.f24;
    }

    public double getRevenue() {
        return this.f25;
    }

    private ISAdQualityCustomMediationRevenue(ISAdQualityMediationNetwork iSAdQualityMediationNetwork, ISAdQualityAdType iSAdQualityAdType, double d8, String str) {
        this.f27 = iSAdQualityMediationNetwork;
        this.f26 = iSAdQualityAdType;
        this.f25 = d8;
        this.f24 = str;
    }
}

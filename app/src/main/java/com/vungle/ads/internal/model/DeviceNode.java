package com.vungle.ads.internal.model;

import androidx.camera.core.processing.util.a;
import b7.c;
import b7.h;
import com.vungle.ads.internal.protos.Sdk;
import d7.g;
import e7.d;
import f7.c1;
import f7.l0;
import f7.m1;
import f7.q0;
import f7.q1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class DeviceNode {
    public static final Companion Companion = new Companion(null);
    private final String carrier;
    private VungleExt ext;
    private int h;
    private String ifa;
    private Integer lmt;
    private final String make;
    private final String model;
    private final String os;
    private final String osv;
    private String ua;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11008w;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return DeviceNode$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class VungleExt {
        public static final Companion Companion = new Companion(null);
        private String amazonAdvertisingId;
        private String appSetId;
        private Integer appSetIdScope;
        private float batteryLevel;
        private int batterySaverEnabled;
        private String batteryState;
        private String connectionType;
        private String connectionTypeDetail;
        private String gaid;
        private boolean isGooglePlayServicesAvailable;
        private boolean isSideloadEnabled;
        private boolean isTv;
        private String language;
        private String locale;
        private Long obt;
        private Long oit;
        private Long ort;
        private int sdCardAvailable;
        private Long sit;
        private int soundEnabled;
        private String timeZone;
        private float volumeLevel;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return DeviceNode$VungleExt$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public VungleExt() {
            this(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, 4194303, (f) null);
        }

        public static /* synthetic */ VungleExt copy$default(VungleExt vungleExt, boolean z2, String str, Integer num, float f4, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f8, int i8, boolean z7, int i9, boolean z8, String str8, String str9, Long l, Long l8, Long l9, Long l10, int i10, Object obj) {
            Long l11;
            Long l12;
            boolean z9 = (i10 & 1) != 0 ? vungleExt.isGooglePlayServicesAvailable : z2;
            String str10 = (i10 & 2) != 0 ? vungleExt.appSetId : str;
            Integer num2 = (i10 & 4) != 0 ? vungleExt.appSetIdScope : num;
            float f9 = (i10 & 8) != 0 ? vungleExt.batteryLevel : f4;
            String str11 = (i10 & 16) != 0 ? vungleExt.batteryState : str2;
            int i11 = (i10 & 32) != 0 ? vungleExt.batterySaverEnabled : i2;
            String str12 = (i10 & 64) != 0 ? vungleExt.connectionType : str3;
            String str13 = (i10 & 128) != 0 ? vungleExt.connectionTypeDetail : str4;
            String str14 = (i10 & 256) != 0 ? vungleExt.locale : str5;
            String str15 = (i10 & 512) != 0 ? vungleExt.language : str6;
            String str16 = (i10 & 1024) != 0 ? vungleExt.timeZone : str7;
            float f10 = (i10 & 2048) != 0 ? vungleExt.volumeLevel : f8;
            int i12 = (i10 & 4096) != 0 ? vungleExt.soundEnabled : i8;
            boolean z10 = (i10 & 8192) != 0 ? vungleExt.isTv : z7;
            boolean z11 = z9;
            int i13 = (i10 & 16384) != 0 ? vungleExt.sdCardAvailable : i9;
            boolean z12 = (i10 & 32768) != 0 ? vungleExt.isSideloadEnabled : z8;
            String str17 = (i10 & 65536) != 0 ? vungleExt.gaid : str8;
            String str18 = (i10 & 131072) != 0 ? vungleExt.amazonAdvertisingId : str9;
            Long l13 = (i10 & 262144) != 0 ? vungleExt.sit : l;
            Long l14 = (i10 & 524288) != 0 ? vungleExt.oit : l8;
            Long l15 = (i10 & 1048576) != 0 ? vungleExt.ort : l9;
            if ((i10 & 2097152) != 0) {
                l12 = l15;
                l11 = vungleExt.obt;
            } else {
                l11 = l10;
                l12 = l15;
            }
            return vungleExt.copy(z11, str10, num2, f9, str11, i11, str12, str13, str14, str15, str16, f10, i12, z10, i13, z12, str17, str18, l13, l14, l12, l11);
        }

        public static final void write$Self(VungleExt self, d output, g serialDesc) {
            Float fValueOf = Float.valueOf(0.0f);
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isGooglePlayServicesAvailable) {
                output.encodeBooleanElement(serialDesc, 0, self.isGooglePlayServicesAvailable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.appSetId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.appSetId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appSetIdScope != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, l0.f11478a, self.appSetIdScope);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Float.valueOf(self.batteryLevel).equals(fValueOf)) {
                output.encodeFloatElement(serialDesc, 3, self.batteryLevel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.batteryState != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, q1.f11501a, self.batteryState);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.batterySaverEnabled != 0) {
                output.encodeIntElement(serialDesc, 5, self.batterySaverEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.connectionType != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, q1.f11501a, self.connectionType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.connectionTypeDetail != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, q1.f11501a, self.connectionTypeDetail);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.locale != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, q1.f11501a, self.locale);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.language != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, q1.f11501a, self.language);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.timeZone != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, q1.f11501a, self.timeZone);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || !Float.valueOf(self.volumeLevel).equals(fValueOf)) {
                output.encodeFloatElement(serialDesc, 11, self.volumeLevel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.soundEnabled != 1) {
                output.encodeIntElement(serialDesc, 12, self.soundEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.isTv) {
                output.encodeBooleanElement(serialDesc, 13, self.isTv);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sdCardAvailable != 1) {
                output.encodeIntElement(serialDesc, 14, self.sdCardAvailable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.isSideloadEnabled) {
                output.encodeBooleanElement(serialDesc, 15, self.isSideloadEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.gaid != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, q1.f11501a, self.gaid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.amazonAdvertisingId != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, q1.f11501a, self.amazonAdvertisingId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.sit != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, q0.f11499a, self.sit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.oit != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, q0.f11499a, self.oit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.ort != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, q0.f11499a, self.ort);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 21) && self.obt == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 21, q0.f11499a, self.obt);
        }

        public final boolean component1() {
            return this.isGooglePlayServicesAvailable;
        }

        public final String component10() {
            return this.language;
        }

        public final String component11() {
            return this.timeZone;
        }

        public final float component12() {
            return this.volumeLevel;
        }

        public final int component13() {
            return this.soundEnabled;
        }

        public final boolean component14() {
            return this.isTv;
        }

        public final int component15() {
            return this.sdCardAvailable;
        }

        public final boolean component16() {
            return this.isSideloadEnabled;
        }

        public final String component17() {
            return this.gaid;
        }

        public final String component18() {
            return this.amazonAdvertisingId;
        }

        public final Long component19() {
            return this.sit;
        }

        public final String component2() {
            return this.appSetId;
        }

        public final Long component20() {
            return this.oit;
        }

        public final Long component21() {
            return this.ort;
        }

        public final Long component22() {
            return this.obt;
        }

        public final Integer component3() {
            return this.appSetIdScope;
        }

        public final float component4() {
            return this.batteryLevel;
        }

        public final String component5() {
            return this.batteryState;
        }

        public final int component6() {
            return this.batterySaverEnabled;
        }

        public final String component7() {
            return this.connectionType;
        }

        public final String component8() {
            return this.connectionTypeDetail;
        }

        public final String component9() {
            return this.locale;
        }

        public final VungleExt copy(boolean z2, String str, Integer num, float f4, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f8, int i8, boolean z7, int i9, boolean z8, String str8, String str9, Long l, Long l8, Long l9, Long l10) {
            return new VungleExt(z2, str, num, f4, str2, i2, str3, str4, str5, str6, str7, f8, i8, z7, i9, z8, str8, str9, l, l8, l9, l10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VungleExt)) {
                return false;
            }
            VungleExt vungleExt = (VungleExt) obj;
            return this.isGooglePlayServicesAvailable == vungleExt.isGooglePlayServicesAvailable && k.a(this.appSetId, vungleExt.appSetId) && k.a(this.appSetIdScope, vungleExt.appSetIdScope) && Float.valueOf(this.batteryLevel).equals(Float.valueOf(vungleExt.batteryLevel)) && k.a(this.batteryState, vungleExt.batteryState) && this.batterySaverEnabled == vungleExt.batterySaverEnabled && k.a(this.connectionType, vungleExt.connectionType) && k.a(this.connectionTypeDetail, vungleExt.connectionTypeDetail) && k.a(this.locale, vungleExt.locale) && k.a(this.language, vungleExt.language) && k.a(this.timeZone, vungleExt.timeZone) && Float.valueOf(this.volumeLevel).equals(Float.valueOf(vungleExt.volumeLevel)) && this.soundEnabled == vungleExt.soundEnabled && this.isTv == vungleExt.isTv && this.sdCardAvailable == vungleExt.sdCardAvailable && this.isSideloadEnabled == vungleExt.isSideloadEnabled && k.a(this.gaid, vungleExt.gaid) && k.a(this.amazonAdvertisingId, vungleExt.amazonAdvertisingId) && k.a(this.sit, vungleExt.sit) && k.a(this.oit, vungleExt.oit) && k.a(this.ort, vungleExt.ort) && k.a(this.obt, vungleExt.obt);
        }

        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        public final String getAppSetId() {
            return this.appSetId;
        }

        public final Integer getAppSetIdScope() {
            return this.appSetIdScope;
        }

        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        public final String getBatteryState() {
            return this.batteryState;
        }

        public final String getConnectionType() {
            return this.connectionType;
        }

        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        public final String getGaid() {
            return this.gaid;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Long getObt() {
            return this.obt;
        }

        public final Long getOit() {
            return this.oit;
        }

        public final Long getOrt() {
            return this.ort;
        }

        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        public final Long getSit() {
            return this.sit;
        }

        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v55 */
        /* JADX WARN: Type inference failed for: r0v56 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r2v26, types: [int] */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v32 */
        public int hashCode() {
            boolean z2 = this.isGooglePlayServicesAvailable;
            ?? r02 = z2;
            if (z2) {
                r02 = 1;
            }
            int i2 = r02 * 31;
            String str = this.appSetId;
            int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.appSetIdScope;
            int iFloatToIntBits = (Float.floatToIntBits(this.batteryLevel) + ((iHashCode + (num == null ? 0 : num.hashCode())) * 31)) * 31;
            String str2 = this.batteryState;
            int iHashCode2 = (((iFloatToIntBits + (str2 == null ? 0 : str2.hashCode())) * 31) + this.batterySaverEnabled) * 31;
            String str3 = this.connectionType;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.connectionTypeDetail;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.language;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.timeZone;
            int iFloatToIntBits2 = (((Float.floatToIntBits(this.volumeLevel) + ((iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31)) * 31) + this.soundEnabled) * 31;
            boolean z7 = this.isTv;
            ?? r22 = z7;
            if (z7) {
                r22 = 1;
            }
            int i8 = (((iFloatToIntBits2 + r22) * 31) + this.sdCardAvailable) * 31;
            boolean z8 = this.isSideloadEnabled;
            int i9 = (i8 + (z8 ? 1 : z8)) * 31;
            String str8 = this.gaid;
            int iHashCode7 = (i9 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.amazonAdvertisingId;
            int iHashCode8 = (iHashCode7 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Long l = this.sit;
            int iHashCode9 = (iHashCode8 + (l == null ? 0 : l.hashCode())) * 31;
            Long l8 = this.oit;
            int iHashCode10 = (iHashCode9 + (l8 == null ? 0 : l8.hashCode())) * 31;
            Long l9 = this.ort;
            int iHashCode11 = (iHashCode10 + (l9 == null ? 0 : l9.hashCode())) * 31;
            Long l10 = this.obt;
            return iHashCode11 + (l10 != null ? l10.hashCode() : 0);
        }

        public final boolean isGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        public final boolean isSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        public final boolean isTv() {
            return this.isTv;
        }

        public final void setAmazonAdvertisingId(String str) {
            this.amazonAdvertisingId = str;
        }

        public final void setAppSetId(String str) {
            this.appSetId = str;
        }

        public final void setAppSetIdScope(Integer num) {
            this.appSetIdScope = num;
        }

        public final void setBatteryLevel(float f4) {
            this.batteryLevel = f4;
        }

        public final void setBatterySaverEnabled(int i2) {
            this.batterySaverEnabled = i2;
        }

        public final void setBatteryState(String str) {
            this.batteryState = str;
        }

        public final void setConnectionType(String str) {
            this.connectionType = str;
        }

        public final void setConnectionTypeDetail(String str) {
            this.connectionTypeDetail = str;
        }

        public final void setGaid(String str) {
            this.gaid = str;
        }

        public final void setGooglePlayServicesAvailable(boolean z2) {
            this.isGooglePlayServicesAvailable = z2;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final void setLocale(String str) {
            this.locale = str;
        }

        public final void setObt(Long l) {
            this.obt = l;
        }

        public final void setOit(Long l) {
            this.oit = l;
        }

        public final void setOrt(Long l) {
            this.ort = l;
        }

        public final void setSdCardAvailable(int i2) {
            this.sdCardAvailable = i2;
        }

        public final void setSideloadEnabled(boolean z2) {
            this.isSideloadEnabled = z2;
        }

        public final void setSit(Long l) {
            this.sit = l;
        }

        public final void setSoundEnabled(int i2) {
            this.soundEnabled = i2;
        }

        public final void setTimeZone(String str) {
            this.timeZone = str;
        }

        public final void setTv(boolean z2) {
            this.isTv = z2;
        }

        public final void setVolumeLevel(float f4) {
            this.volumeLevel = f4;
        }

        public String toString() {
            return "VungleExt(isGooglePlayServicesAvailable=" + this.isGooglePlayServicesAvailable + ", appSetId=" + this.appSetId + ", appSetIdScope=" + this.appSetIdScope + ", batteryLevel=" + this.batteryLevel + ", batteryState=" + this.batteryState + ", batterySaverEnabled=" + this.batterySaverEnabled + ", connectionType=" + this.connectionType + ", connectionTypeDetail=" + this.connectionTypeDetail + ", locale=" + this.locale + ", language=" + this.language + ", timeZone=" + this.timeZone + ", volumeLevel=" + this.volumeLevel + ", soundEnabled=" + this.soundEnabled + ", isTv=" + this.isTv + ", sdCardAvailable=" + this.sdCardAvailable + ", isSideloadEnabled=" + this.isSideloadEnabled + ", gaid=" + this.gaid + ", amazonAdvertisingId=" + this.amazonAdvertisingId + ", sit=" + this.sit + ", oit=" + this.oit + ", ort=" + this.ort + ", obt=" + this.obt + ')';
        }

        public /* synthetic */ VungleExt(int i2, boolean z2, String str, Integer num, float f4, String str2, int i8, String str3, String str4, String str5, String str6, String str7, float f8, int i9, boolean z7, int i10, boolean z8, String str8, String str9, Long l, Long l8, Long l9, Long l10, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.isGooglePlayServicesAvailable = false;
            } else {
                this.isGooglePlayServicesAvailable = z2;
            }
            if ((i2 & 2) == 0) {
                this.appSetId = null;
            } else {
                this.appSetId = str;
            }
            if ((i2 & 4) == 0) {
                this.appSetIdScope = null;
            } else {
                this.appSetIdScope = num;
            }
            if ((i2 & 8) == 0) {
                this.batteryLevel = 0.0f;
            } else {
                this.batteryLevel = f4;
            }
            if ((i2 & 16) == 0) {
                this.batteryState = null;
            } else {
                this.batteryState = str2;
            }
            if ((i2 & 32) == 0) {
                this.batterySaverEnabled = 0;
            } else {
                this.batterySaverEnabled = i8;
            }
            if ((i2 & 64) == 0) {
                this.connectionType = null;
            } else {
                this.connectionType = str3;
            }
            if ((i2 & 128) == 0) {
                this.connectionTypeDetail = null;
            } else {
                this.connectionTypeDetail = str4;
            }
            if ((i2 & 256) == 0) {
                this.locale = null;
            } else {
                this.locale = str5;
            }
            if ((i2 & 512) == 0) {
                this.language = null;
            } else {
                this.language = str6;
            }
            if ((i2 & 1024) == 0) {
                this.timeZone = null;
            } else {
                this.timeZone = str7;
            }
            if ((i2 & 2048) == 0) {
                this.volumeLevel = 0.0f;
            } else {
                this.volumeLevel = f8;
            }
            if ((i2 & 4096) == 0) {
                this.soundEnabled = 1;
            } else {
                this.soundEnabled = i9;
            }
            if ((i2 & 8192) == 0) {
                this.isTv = false;
            } else {
                this.isTv = z7;
            }
            if ((i2 & 16384) == 0) {
                this.sdCardAvailable = 1;
            } else {
                this.sdCardAvailable = i10;
            }
            if ((32768 & i2) == 0) {
                this.isSideloadEnabled = false;
            } else {
                this.isSideloadEnabled = z8;
            }
            if ((65536 & i2) == 0) {
                this.gaid = null;
            } else {
                this.gaid = str8;
            }
            if ((131072 & i2) == 0) {
                this.amazonAdvertisingId = null;
            } else {
                this.amazonAdvertisingId = str9;
            }
            if ((262144 & i2) == 0) {
                this.sit = null;
            } else {
                this.sit = l;
            }
            if ((524288 & i2) == 0) {
                this.oit = null;
            } else {
                this.oit = l8;
            }
            if ((1048576 & i2) == 0) {
                this.ort = null;
            } else {
                this.ort = l9;
            }
            if ((i2 & 2097152) == 0) {
                this.obt = null;
            } else {
                this.obt = l10;
            }
        }

        public VungleExt(boolean z2, String str, Integer num, float f4, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f8, int i8, boolean z7, int i9, boolean z8, String str8, String str9, Long l, Long l8, Long l9, Long l10) {
            this.isGooglePlayServicesAvailable = z2;
            this.appSetId = str;
            this.appSetIdScope = num;
            this.batteryLevel = f4;
            this.batteryState = str2;
            this.batterySaverEnabled = i2;
            this.connectionType = str3;
            this.connectionTypeDetail = str4;
            this.locale = str5;
            this.language = str6;
            this.timeZone = str7;
            this.volumeLevel = f8;
            this.soundEnabled = i8;
            this.isTv = z7;
            this.sdCardAvailable = i9;
            this.isSideloadEnabled = z8;
            this.gaid = str8;
            this.amazonAdvertisingId = str9;
            this.sit = l;
            this.oit = l8;
            this.ort = l9;
            this.obt = l10;
        }

        public static /* synthetic */ void getAmazonAdvertisingId$annotations() {
        }

        public static /* synthetic */ void getAppSetId$annotations() {
        }

        public static /* synthetic */ void getAppSetIdScope$annotations() {
        }

        public static /* synthetic */ void getBatteryLevel$annotations() {
        }

        public static /* synthetic */ void getBatterySaverEnabled$annotations() {
        }

        public static /* synthetic */ void getBatteryState$annotations() {
        }

        public static /* synthetic */ void getConnectionType$annotations() {
        }

        public static /* synthetic */ void getConnectionTypeDetail$annotations() {
        }

        public static /* synthetic */ void getGaid$annotations() {
        }

        public static /* synthetic */ void getLanguage$annotations() {
        }

        public static /* synthetic */ void getLocale$annotations() {
        }

        public static /* synthetic */ void getObt$annotations() {
        }

        public static /* synthetic */ void getOit$annotations() {
        }

        public static /* synthetic */ void getOrt$annotations() {
        }

        public static /* synthetic */ void getSdCardAvailable$annotations() {
        }

        public static /* synthetic */ void getSit$annotations() {
        }

        public static /* synthetic */ void getSoundEnabled$annotations() {
        }

        public static /* synthetic */ void getTimeZone$annotations() {
        }

        public static /* synthetic */ void getVolumeLevel$annotations() {
        }

        public static /* synthetic */ void isGooglePlayServicesAvailable$annotations() {
        }

        public static /* synthetic */ void isSideloadEnabled$annotations() {
        }

        public static /* synthetic */ void isTv$annotations() {
        }

        public /* synthetic */ VungleExt(boolean z2, String str, Integer num, float f4, String str2, int i2, String str3, String str4, String str5, String str6, String str7, float f8, int i8, boolean z7, int i9, boolean z8, String str8, String str9, Long l, Long l8, Long l9, Long l10, int i10, f fVar) {
            this((i10 & 1) != 0 ? false : z2, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? 0.0f : f4, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? 0 : i2, (i10 & 64) != 0 ? null : str3, (i10 & 128) != 0 ? null : str4, (i10 & 256) != 0 ? null : str5, (i10 & 512) != 0 ? null : str6, (i10 & 1024) != 0 ? null : str7, (i10 & 2048) == 0 ? f8 : 0.0f, (i10 & 4096) != 0 ? 1 : i8, (i10 & 8192) != 0 ? false : z7, (i10 & 16384) == 0 ? i9 : 1, (32768 & i10) != 0 ? false : z8, (i10 & 65536) != 0 ? null : str8, (i10 & 131072) != 0 ? null : str9, (i10 & 262144) != 0 ? null : l, (i10 & 524288) != 0 ? null : l8, (i10 & 1048576) != 0 ? null : l9, (i10 & 2097152) != 0 ? null : l10);
        }
    }

    public /* synthetic */ DeviceNode(int i2, String str, String str2, String str3, String str4, String str5, int i8, int i9, String str6, String str7, Integer num, VungleExt vungleExt, m1 m1Var) {
        if (119 != (i2 & Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)) {
            c1.j(DeviceNode$$serializer.INSTANCE.getDescriptor(), i2, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE);
            throw null;
        }
        this.make = str;
        this.model = str2;
        this.osv = str3;
        if ((i2 & 8) == 0) {
            this.carrier = null;
        } else {
            this.carrier = str4;
        }
        this.os = str5;
        this.f11008w = i8;
        this.h = i9;
        if ((i2 & 128) == 0) {
            this.ua = null;
        } else {
            this.ua = str6;
        }
        if ((i2 & 256) == 0) {
            this.ifa = null;
        } else {
            this.ifa = str7;
        }
        if ((i2 & 512) == 0) {
            this.lmt = null;
        } else {
            this.lmt = num;
        }
        if ((i2 & 1024) == 0) {
            this.ext = null;
        } else {
            this.ext = vungleExt;
        }
    }

    public static /* synthetic */ DeviceNode copy$default(DeviceNode deviceNode, String str, String str2, String str3, String str4, String str5, int i2, int i8, String str6, String str7, Integer num, VungleExt vungleExt, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = deviceNode.make;
        }
        if ((i9 & 2) != 0) {
            str2 = deviceNode.model;
        }
        if ((i9 & 4) != 0) {
            str3 = deviceNode.osv;
        }
        if ((i9 & 8) != 0) {
            str4 = deviceNode.carrier;
        }
        if ((i9 & 16) != 0) {
            str5 = deviceNode.os;
        }
        if ((i9 & 32) != 0) {
            i2 = deviceNode.f11008w;
        }
        if ((i9 & 64) != 0) {
            i8 = deviceNode.h;
        }
        if ((i9 & 128) != 0) {
            str6 = deviceNode.ua;
        }
        if ((i9 & 256) != 0) {
            str7 = deviceNode.ifa;
        }
        if ((i9 & 512) != 0) {
            num = deviceNode.lmt;
        }
        if ((i9 & 1024) != 0) {
            vungleExt = deviceNode.ext;
        }
        Integer num2 = num;
        VungleExt vungleExt2 = vungleExt;
        String str8 = str6;
        String str9 = str7;
        int i10 = i2;
        int i11 = i8;
        String str10 = str5;
        String str11 = str3;
        return deviceNode.copy(str, str2, str11, str4, str10, i10, i11, str8, str9, num2, vungleExt2);
    }

    public static final void write$Self(DeviceNode self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.make);
        output.encodeStringElement(serialDesc, 1, self.model);
        output.encodeStringElement(serialDesc, 2, self.osv);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.carrier != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, q1.f11501a, self.carrier);
        }
        output.encodeStringElement(serialDesc, 4, self.os);
        output.encodeIntElement(serialDesc, 5, self.f11008w);
        output.encodeIntElement(serialDesc, 6, self.h);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.ua != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, q1.f11501a, self.ua);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.ifa != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, q1.f11501a, self.ifa);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.lmt != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, l0.f11478a, self.lmt);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.ext == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 10, DeviceNode$VungleExt$$serializer.INSTANCE, self.ext);
    }

    public final String component1() {
        return this.make;
    }

    public final Integer component10() {
        return this.lmt;
    }

    public final VungleExt component11() {
        return this.ext;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.osv;
    }

    public final String component4() {
        return this.carrier;
    }

    public final String component5() {
        return this.os;
    }

    public final int component6() {
        return this.f11008w;
    }

    public final int component7() {
        return this.h;
    }

    public final String component8() {
        return this.ua;
    }

    public final String component9() {
        return this.ifa;
    }

    public final DeviceNode copy(String make, String model, String osv, String str, String os, int i2, int i8, String str2, String str3, Integer num, VungleExt vungleExt) {
        k.e(make, "make");
        k.e(model, "model");
        k.e(osv, "osv");
        k.e(os, "os");
        return new DeviceNode(make, model, osv, str, os, i2, i8, str2, str3, num, vungleExt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceNode)) {
            return false;
        }
        DeviceNode deviceNode = (DeviceNode) obj;
        return k.a(this.make, deviceNode.make) && k.a(this.model, deviceNode.model) && k.a(this.osv, deviceNode.osv) && k.a(this.carrier, deviceNode.carrier) && k.a(this.os, deviceNode.os) && this.f11008w == deviceNode.f11008w && this.h == deviceNode.h && k.a(this.ua, deviceNode.ua) && k.a(this.ifa, deviceNode.ifa) && k.a(this.lmt, deviceNode.lmt) && k.a(this.ext, deviceNode.ext);
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final VungleExt getExt() {
        return this.ext;
    }

    public final int getH() {
        return this.h;
    }

    public final String getIfa() {
        return this.ifa;
    }

    public final Integer getLmt() {
        return this.lmt;
    }

    public final String getMake() {
        return this.make;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getOsv() {
        return this.osv;
    }

    public final String getUa() {
        return this.ua;
    }

    public final int getW() {
        return this.f11008w;
    }

    public int hashCode() {
        int iB = a.b(a.b(this.make.hashCode() * 31, 31, this.model), 31, this.osv);
        String str = this.carrier;
        int iB2 = (((a.b((iB + (str == null ? 0 : str.hashCode())) * 31, 31, this.os) + this.f11008w) * 31) + this.h) * 31;
        String str2 = this.ua;
        int iHashCode = (iB2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ifa;
        int iHashCode2 = (iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lmt;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        VungleExt vungleExt = this.ext;
        return iHashCode3 + (vungleExt != null ? vungleExt.hashCode() : 0);
    }

    public final void setExt(VungleExt vungleExt) {
        this.ext = vungleExt;
    }

    public final void setH(int i2) {
        this.h = i2;
    }

    public final void setIfa(String str) {
        this.ifa = str;
    }

    public final void setLmt(Integer num) {
        this.lmt = num;
    }

    public final void setUa(String str) {
        this.ua = str;
    }

    public final void setW(int i2) {
        this.f11008w = i2;
    }

    public String toString() {
        return "DeviceNode(make=" + this.make + ", model=" + this.model + ", osv=" + this.osv + ", carrier=" + this.carrier + ", os=" + this.os + ", w=" + this.f11008w + ", h=" + this.h + ", ua=" + this.ua + ", ifa=" + this.ifa + ", lmt=" + this.lmt + ", ext=" + this.ext + ')';
    }

    public DeviceNode(String make, String model, String osv, String str, String os, int i2, int i8, String str2, String str3, Integer num, VungleExt vungleExt) {
        k.e(make, "make");
        k.e(model, "model");
        k.e(osv, "osv");
        k.e(os, "os");
        this.make = make;
        this.model = model;
        this.osv = osv;
        this.carrier = str;
        this.os = os;
        this.f11008w = i2;
        this.h = i8;
        this.ua = str2;
        this.ifa = str3;
        this.lmt = num;
        this.ext = vungleExt;
    }

    public /* synthetic */ DeviceNode(String str, String str2, String str3, String str4, String str5, int i2, int i8, String str6, String str7, Integer num, VungleExt vungleExt, int i9, f fVar) {
        this(str, str2, str3, (i9 & 8) != 0 ? null : str4, str5, i2, i8, (i9 & 128) != 0 ? null : str6, (i9 & 256) != 0 ? null : str7, (i9 & 512) != 0 ? null : num, (i9 & 1024) != 0 ? null : vungleExt);
    }
}

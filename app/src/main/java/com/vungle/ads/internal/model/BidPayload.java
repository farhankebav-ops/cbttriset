package com.vungle.ads.internal.model;

import a.a;
import android.util.Base64;
import b7.h;
import d7.g;
import e7.d;
import f7.l0;
import f7.m1;
import f7.q1;
import g7.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class BidPayload {
    public static final Companion Companion = new Companion(null);
    private final AdPayload ad;
    private final String adunit;
    private final List<String> impression;
    private final c json;
    private final Integer version;

    /* JADX INFO: renamed from: com.vungle.ads.internal.model.BidPayload$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((g7.h) obj);
            return x.f13520a;
        }

        public final void invoke(g7.h Json) {
            k.e(Json, "$this$Json");
            Json.f11611c = true;
            Json.f11609a = true;
            Json.f11610b = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final b7.c serializer() {
            return BidPayload$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public BidPayload() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BidPayload copy$default(BidPayload bidPayload, Integer num, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = bidPayload.version;
        }
        if ((i2 & 2) != 0) {
            str = bidPayload.adunit;
        }
        if ((i2 & 4) != 0) {
            list = bidPayload.impression;
        }
        return bidPayload.copy(num, str, list);
    }

    private final String gzipDecode(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 1024);
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i2 = gZIPInputStream.read(bArr2);
                    if (i2 == -1) {
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        String string = byteArrayOutputStream.toString();
                        k.d(string, "result.toString()");
                        return string;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i2);
                }
            } finally {
            }
        } finally {
        }
    }

    public static final void write$Self(BidPayload self, d output, g serialDesc) {
        String decodedAdsResponse;
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.version != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, l0.f11478a, self.version);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.adunit != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.adunit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.impression != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, new f7.d(q1.f11501a, 0), self.impression);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3)) {
            AdPayload adPayload = self.ad;
            AdPayload adPayload2 = null;
            if (self.adunit != null && (decodedAdsResponse = self.getDecodedAdsResponse()) != null) {
                c cVar = self.json;
                adPayload2 = (AdPayload) cVar.a(q.q0(cVar.f11599b, b0.b(AdPayload.class)), decodedAdsResponse);
            }
            if (k.a(adPayload, adPayload2)) {
                return;
            }
        }
        output.encodeNullableSerializableElement(serialDesc, 3, AdPayload$$serializer.INSTANCE, self.ad);
    }

    public final Integer component1() {
        return this.version;
    }

    public final String component2() {
        return this.adunit;
    }

    public final List<String> component3() {
        return this.impression;
    }

    public final BidPayload copy(Integer num, String str, List<String> list) {
        return new BidPayload(num, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BidPayload)) {
            return false;
        }
        BidPayload bidPayload = (BidPayload) obj;
        return k.a(this.version, bidPayload.version) && k.a(this.adunit, bidPayload.adunit) && k.a(this.impression, bidPayload.impression);
    }

    public final AdPayload getAdPayload() {
        return this.ad;
    }

    public final String getAdunit() {
        return this.adunit;
    }

    public final String getCreativeId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.getCreativeId();
        }
        return null;
    }

    public final String getDecodedAdsResponse() throws Throwable {
        byte[] bArrDecode = Base64.decode(this.adunit, 0);
        if (bArrDecode != null) {
            return gzipDecode(bArrDecode);
        }
        return null;
    }

    public final String getEventId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.eventId();
        }
        return null;
    }

    public final List<String> getImpression() {
        return this.impression;
    }

    public final String getPlacementId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.placementId();
        }
        return null;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Integer num = this.version;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.adunit;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.impression;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BidPayload(version=" + this.version + ", adunit=" + this.adunit + ", impression=" + this.impression + ')';
    }

    public BidPayload(int i2, Integer num, String str, List list, AdPayload adPayload, m1 m1Var) {
        String decodedAdsResponse;
        AdPayload adPayload2 = null;
        if ((i2 & 1) == 0) {
            this.version = null;
        } else {
            this.version = num;
        }
        if ((i2 & 2) == 0) {
            this.adunit = null;
        } else {
            this.adunit = str;
        }
        if ((i2 & 4) == 0) {
            this.impression = null;
        } else {
            this.impression = list;
        }
        g7.q qVarB = a.b(AnonymousClass1.INSTANCE);
        this.json = qVarB;
        if ((i2 & 8) != 0) {
            this.ad = adPayload;
            return;
        }
        if (this.adunit != null && (decodedAdsResponse = getDecodedAdsResponse()) != null) {
            adPayload2 = (AdPayload) qVarB.a(q.q0(qVarB.f11599b, b0.b(AdPayload.class)), decodedAdsResponse);
        }
        this.ad = adPayload2;
    }

    public BidPayload(Integer num, String str, List<String> list) {
        String decodedAdsResponse;
        this.version = num;
        this.adunit = str;
        this.impression = list;
        g7.q qVarB = a.b(BidPayload$json$1.INSTANCE);
        this.json = qVarB;
        AdPayload adPayload = null;
        if (str != null && (decodedAdsResponse = getDecodedAdsResponse()) != null) {
            adPayload = (AdPayload) qVarB.a(q.q0(qVarB.f11599b, b0.b(AdPayload.class)), decodedAdsResponse);
        }
        this.ad = adPayload;
    }

    private static /* synthetic */ void getJson$annotations() {
    }

    public /* synthetic */ BidPayload(Integer num, String str, List list, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list);
    }
}

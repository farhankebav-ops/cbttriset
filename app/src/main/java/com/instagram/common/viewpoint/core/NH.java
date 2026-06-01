package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NH {
    public static byte[] A05;
    public static String[] A06 = {"SwW", "nKJOmWTx3LjNZvOp7YbBROgXIyGkfXUh", "cNvS8LZQYgXEdOP85dYAvAy4C3J", "ICxq6EmLG0dgZi7UJ5PBV2wBsvrmCfpb", "tKedy3gZYTLe", "bmz0vq", "hvIAQTYE0cdtFIL2", "tj9oqRvQS19ndgZTuA"};
    public SF A00;
    public EnumC1266Zt A01 = EnumC1266Zt.A05;
    public ArrayList<C1388bt> A02 = new ArrayList<>();
    public final AbstractC0930Mo A03;
    public final NG A04;

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-35, 23, 35, 28, 27, -66, -29, -23, -38, -25, -29, -42, -31, -107, -70, -25, -25, -28, -25, -107, -89, -91, -91, -85, -107, -20, -34, -23, -35, -28, -22, -23, -107, -42, -107, -21, -42, -31, -34, -39, -107, -74, -39, -66, -29, -37, -28, -93, 21, 24, 19, 24, 21, 40, 21, 19, 22, 41, 34, 24, 32, 25, -29, -14, -21, -36, -31, -38, -30, -25, -40, -23, -38, -21, -38, -26, -20, 18, 23, 16, 24, 29, 20, 19, -16, 19, -13, 16, 35, 16, -15, 36, 29, 19, 27, 20, 63, 68, 74, 59, 72, 73, 74, 63, 74, 63, 55, 66};
    }

    static {
        A06();
    }

    public NH(C1477dL c1477dL, NU nu, NG ng, String str) {
        JSONObject dataObject = nu.A03();
        this.A03 = A01(c1477dL, nu, str, dataObject);
        this.A04 = ng;
    }

    private AdError A00(C1477dL c1477dL, AbstractC1752hy abstractC1752hy) {
        if (abstractC1752hy == null || abstractC1752hy.A27().isEmpty()) {
            c1477dL.A08().AAy(A04(62, 3, 33), AbstractC1090Sv.A0Z, new C1091Sw(A04(5, 43, 20)));
            return AdError.internalError(2006);
        }
        return null;
    }

    public static AbstractC0930Mo A01(C1477dL c1477dL, NU nu, String str, JSONObject jSONObject) {
        AbstractC0930Mo abstractC0930MoA00 = null;
        if (jSONObject.has(A04(65, 12, 24))) {
            try {
                abstractC0930MoA00 = C1750hw.A01(jSONObject, c1477dL, true);
                abstractC0930MoA00.A1L(true);
                abstractC0930MoA00.A1I(A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE));
            } catch (JSONException unused) {
            }
        }
        if (abstractC0930MoA00 == null) {
            abstractC0930MoA00 = AnonymousClass77.A00(jSONObject, c1477dL);
        }
        abstractC0930MoA00.A1H(str);
        TF tfA01 = nu.A01();
        if (tfA01 != null) {
            abstractC0930MoA00.A1D(tfA01.A06());
        }
        return abstractC0930MoA00;
    }

    private SF A03(C1477dL c1477dL) {
        return this.A00 != null ? this.A00 : new SF(c1477dL);
    }

    private void A08(C1477dL c1477dL, AnonymousClass77 anonymousClass77) {
        NB playableData = anonymousClass77.A20().A0H().A07();
        A0B(playableData != null ? playableData.A0B() : EnumC1266Zt.A05);
        C1734hb c1734hb = new C1734hb(this);
        SF sf = new SF(c1477dL);
        boolean z2 = U7.A2A(c1477dL) && C1049Rf.A0A(anonymousClass77.A1C());
        if (z2) {
            C1049Rf unifiedAssetsLoader = new C1049Rf(sf, anonymousClass77.A1C(), anonymousClass77.A0v(), anonymousClass77.A17(), z2, new C1733ha(this));
            sf.A0e(new C1120Ua(anonymousClass77.A25(), c1477dL.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        NR.A02(c1477dL, anonymousClass77, true, c1734hb);
    }

    private void A09(C1477dL c1477dL, EnumSet<CacheFlag> enumSet, AbstractC1752hy abstractC1752hy, int i2, NG ng) {
        boolean zA1Y = abstractC1752hy.A1Y();
        SF sfA03 = A03(c1477dL);
        sfA03.A0e(new C1120Ua(abstractC1752hy.A25(), c1477dL.A0A()));
        boolean z2 = U7.A2A(c1477dL) && C1049Rf.A0A(abstractC1752hy.A1C());
        if (z2) {
            new C1049Rf(sfA03, abstractC1752hy.A1C(), abstractC1752hy.A0v(), abstractC1752hy.A17(), z2, new C1739hi(this, c1477dL, zA1Y, abstractC1752hy, ng)).A0B();
            return;
        }
        String strA04 = A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE);
        if (zA1Y) {
            SB sb = new SB(abstractC1752hy.A0s(), abstractC1752hy.A17(), strA04);
            sb.A04 = true;
            sb.A03 = A04(0, 5, 78);
            sfA03.A0Y(sb);
        }
        sfA03.A0d(new SD(abstractC1752hy.A23().A01(), C1443cm.A04, C1443cm.A04, abstractC1752hy.A17(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE)));
        boolean zContains = enumSet.contains(CacheFlag.VIDEO);
        int i8 = 0;
        boolean zA2s = U7.A2s(c1477dL, C1532eF.A03());
        for (C0931Mp adInfo : abstractC1752hy.A27()) {
            SD sd = new SD(adInfo.A0H().A08(), NN.A00(adInfo.A0H()), NN.A01(adInfo.A0H()), abstractC1752hy.A17(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE));
            if (i8 == 0) {
                sfA03.A0c(sd);
            } else {
                sfA03.A0d(sd);
            }
            Iterator<String> it = adInfo.A0K().A02().iterator();
            while (it.hasNext()) {
                sfA03.A0d(new SD(it.next(), -1, -1, abstractC1752hy.A17(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE)));
            }
            if (zContains && !TextUtils.isEmpty(adInfo.A0H().A09())) {
                SB sb2 = new SB(adInfo.A0H().A09(), abstractC1752hy.A17(), A04(96, 12, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), adInfo.A0H().A06());
                sb2.A04 = false;
                if (i8 == 0) {
                    if (zA1Y && !zA2s) {
                        sfA03.A0Y(sb2);
                    } else {
                        sfA03.A0b(sb2);
                    }
                } else if (zA1Y && !zA2s) {
                    sfA03.A0Z(sb2);
                } else {
                    sfA03.A0a(sb2);
                }
            }
            i8++;
        }
        sfA03.A0X(new C1737hg(this, c1477dL, zA1Y, abstractC1752hy, ng), new S8(abstractC1752hy.A17(), strA04, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1477dL c1477dL, EnumSet<CacheFlag> enumSet, C1750hw c1750hw, AbstractC1752hy abstractC1752hy, int i2, NG ng) {
        A09(c1477dL, enumSet, abstractC1752hy, i2, new C1741hk(this, c1477dL, abstractC1752hy, c1750hw, i2, ng, enumSet));
    }

    private void A0B(EnumC1266Zt enumC1266Zt) {
        this.A01 = enumC1266Zt;
    }

    private boolean A0C(C1477dL c1477dL, AbstractC1752hy abstractC1752hy) {
        AdError adErrorA00 = A00(c1477dL, abstractC1752hy);
        if (adErrorA00 != null) {
            this.A04.ACF(adErrorA00);
            return true;
        }
        return false;
    }

    public final AbstractC0930Mo A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        return com.instagram.common.viewpoint.core.EnumC1147Vb.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        return com.instagram.common.viewpoint.core.EnumC1147Vb.A0B;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.instagram.common.viewpoint.core.EnumC1147Vb A0E() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.Mo r0 = r5.A03
            boolean r0 = r0.A1T()
            if (r0 == 0) goto Lb
            com.facebook.ads.redexgen.X.Vb r0 = com.instagram.common.viewpoint.core.EnumC1147Vb.A04
            return r0
        Lb:
            com.facebook.ads.redexgen.X.Mo r4 = r5.A03
            com.facebook.ads.redexgen.X.hy r4 = (com.instagram.common.viewpoint.core.AbstractC1752hy) r4
            boolean r0 = r4.A1Y()
            if (r0 == 0) goto L18
            com.facebook.ads.redexgen.X.Vb r0 = com.instagram.common.viewpoint.core.EnumC1147Vb.A06
            return r0
        L18:
            java.util.List r0 = r4.A27()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L26
            com.facebook.ads.redexgen.X.Vb r0 = com.instagram.common.viewpoint.core.EnumC1147Vb.A0A
            return r0
        L26:
            com.facebook.ads.redexgen.X.Mp r0 = r4.A20()
            com.facebook.ads.redexgen.X.Ms r0 = r0.A0H()
            com.facebook.ads.redexgen.X.NB r3 = r0.A07()
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.NH.A06
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 14
            if (r1 == r0) goto L77
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.NH.A06
            java.lang.String r1 = "HO5lN2vl3hawZ3xdOTbB4PXxItmZOFKM"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "QabHGQsenJFHZf5mHftqzVXi6FXcwsQx"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L50
            com.facebook.ads.redexgen.X.Vb r0 = com.instagram.common.viewpoint.core.EnumC1147Vb.A0C
            return r0
        L50:
            boolean r3 = r5.A0L(r4)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.NH.A06
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L71
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.NH.A06
            java.lang.String r1 = "iV2CDA2M2IfUZLXvhnmiNr1pV0Sur2CQ"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "GDT4frbvCKvkZrCQcOaJTMqN9T6RIdn0"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L74
        L6e:
            com.facebook.ads.redexgen.X.Vb r0 = com.instagram.common.viewpoint.core.EnumC1147Vb.A0D
            return r0
        L71:
            if (r3 == 0) goto L74
            goto L6e
        L74:
            com.facebook.ads.redexgen.X.Vb r0 = com.instagram.common.viewpoint.core.EnumC1147Vb.A0B
            return r0
        L77:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.NH.A0E():com.facebook.ads.redexgen.X.Vb");
    }

    public final EnumC1266Zt A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A1T()) {
            return ((C1750hw) this.A03).A20();
        }
        return ((AbstractC1752hy) this.A03).A25();
    }

    public final void A0H() {
        this.A04.AJm();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A1F(rewardData);
        this.A03.A1J(str);
        if (A0D().A1T()) {
            intent.putExtra(A04(77, 19, 78), this.A03);
        }
        intent.putExtra(A04(48, 14, 83), this.A03);
    }

    public final void A0J(C1477dL c1477dL, EnumSet<CacheFlag> enumSet) {
        if (A0E() == EnumC1147Vb.A04) {
            C1750hw c1750hw = (C1750hw) this.A03;
            AbstractC1752hy abstractC1752hyA1w = c1750hw.A1w();
            if (A0C(c1477dL, abstractC1752hyA1w) || abstractC1752hyA1w == null) {
                return;
            }
            this.A04.AGo();
            A0A(c1477dL, enumSet, c1750hw, abstractC1752hyA1w, 0, this.A04);
            return;
        }
        AbstractC1752hy abstractC1752hy = (AbstractC1752hy) this.A03;
        if (A06[5].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "h3j4XQE4N9RDZ4AU6tvjsFYKX3e30HKG";
        strArr[3] = "lDhcJ7lgFtqhZjTb781X3zaoWDc2BWUc";
        if (A0C(c1477dL, abstractC1752hy)) {
            return;
        }
        this.A04.AGo();
        if (A0E() == EnumC1147Vb.A0C) {
            AnonymousClass77 anonymousClass77 = (AnonymousClass77) this.A03;
            String[] strArr2 = A06;
            if (strArr2[2].length() != strArr2[6].length()) {
                A06[7] = "0uVLF1bkkTEn2WeYm46QMmOd1A6";
                A08(c1477dL, anonymousClass77);
                return;
            } else {
                A08(c1477dL, anonymousClass77);
                return;
            }
        }
        A09(c1477dL, enumSet, (AnonymousClass77) this.A03, -1, this.A04);
    }

    public final boolean A0K() {
        return this.A03.A1P();
    }

    public final boolean A0L(AbstractC1752hy abstractC1752hy) {
        return !TextUtils.isEmpty(abstractC1752hy.A20().A0H().A09());
    }
}

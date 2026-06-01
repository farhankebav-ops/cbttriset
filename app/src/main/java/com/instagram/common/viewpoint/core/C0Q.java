package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0Q extends AnonymousClass14 implements C6W {
    public static byte[] A0K;
    public static String[] A0L = {"77C8vP87Fd7b4BP9SQRJBzWPVk4TewQg", "oQ2qsKrmaNuyaLFB2ph9zkmGtpzAonXt", "MDqZPLCoXCzEQwxPxYtAKuxbh2tAcx1k", "aWPkhw6gWy0BTxYknUchyjQmABWF", "ais5GYfL5LR1KEYd6HRi1BBd2kmjCeGs", "pdewp8MC9mt7vaqV0Zkeu3U5mw150Zm9", "qv2CVs2gAdpJ8ZKBYAbfHfBiBdoePlCI", "lcPZgHPLbCISPmjsMn5qIGSBsvlpomMq"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;

    @MetaExoPlayerCustomization
    public AudioManager A06;
    public MediaFormat A07;
    public C2154or A08;
    public AnonymousClass75 A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public final Context A0F;
    public final C8C A0G;
    public final boolean A0H;
    public final boolean A0I;
    public final C8N A0J;

    public static String A07(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A0L[3].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0L;
            strArr[4] = "GcWDzLLiTAl0tD46XyRRBcNodd92JrSP";
            strArr[0] = "GhxldHXMoVDog6OAV5RKTarDpyl0kviC";
            bArrCopyOfRange[i10] = (byte) ((b8 - i9) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0K = new byte[]{-103, -79, -80, -75, -83, -113, -69, -80, -79, -81, -115, -63, -80, -75, -69, -98, -79, -70, -80, -79, -66, -79, -66, -77, -79, -68, -110, -73, -87, -89, -110, -59, -59, -57, -110, -56, -55, -57, -36, -38, -27, -69, -12, -4, -4, -12, -7, -14, -69, -1, -18, 4, -69, -15, -14, -16, -4, -15, -14, -1, -17, -17, -15, -69, -14, 0, -15, -69, -13, -12, -12, -13, -15, 2, -69, 2, 7, -2, -13, -51, -51, -49, -103, -32, -51, -34, -45, -47, -32, -103, -34, -47, -46, -103, -40, -47, -30, -47, -40, 7, 27, 10, 15, 21, 18, 38, 21, 26, 32, -32, 35, 18, 40, -90, -85, -92, -79, -79, -88, -81, 112, -90, -78, -72, -79, -73, -31, -34, -21, -24, -27, -19, -34, -59, -62, -49, -52, -50, -55, -47, -62, -39, -51, -28, -103, -43, -38, -36, -31, -32, -103, -33, -43, -26, -47, -68, -72, -68, -76, -67, -64, -124, -79, 126, -124, -128, 126, -124, -126, -68, -66, -75, -69, -66, -75, -64, -59, -27, -45, -33, -30, -34, -41, -97, -28, -45, -26, -41, -54, -72, -60, -54, -52, -59, -66, -2, -23, -10, -13, -22, -16, -8, -23};
    }

    static {
        A09();
    }

    public C0Q(Context context, C1749hv c1749hv, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, InterfaceC0626Ar interfaceC0626Ar, C9U c9u, boolean z2, boolean z7, boolean z8, Handler handler, C8D c8d, C05597p c05597p, AnonymousClass38... anonymousClass38Arr) {
        this(context, c1749hv, mediaCodecRendererMetaParameters, interfaceC0626Ar, c9u, z2, z7, z8, handler, c8d, new C2038mw(c05597p, anonymousClass38Arr));
    }

    public C0Q(Context context, C1749hv c1749hv, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, InterfaceC0626Ar interfaceC0626Ar, C9U c9u, boolean z2, boolean z7, boolean z8, Handler handler, C8D c8d, C8N c8n) {
        super(1, c1749hv, mediaCodecRendererMetaParameters, interfaceC0626Ar, c9u, z2, false, 0, 0);
        this.A01 = 0;
        this.A02 = 0;
        this.A05 = 0L;
        this.A0F = context.getApplicationContext();
        this.A0J = c8n;
        this.A0H = z7;
        this.A0I = z8;
        this.A0G = new C8C(handler, c8d);
        c8n.AIl(new C2036mu(this));
        c8n.AIg(c1749hv.A0B);
    }

    @MetaExoPlayerCustomization("Added in D36293647 for DRC")
    private int A00() {
        int i2 = this.A11.A07;
        if (this.A11.A0D) {
            int i8 = this.A11.A02;
            int xHEAACEffectType = this.A11.A03;
            int iA00 = ContextAwareXHEAACDRCTypeUtil.A00(i8, xHEAACEffectType);
            if (this.A11.A0E) {
                if (this.A06 == null) {
                    this.A06 = (AudioManager) this.A0F.getSystemService(A07(99, 5, 101));
                }
                int iA01 = ContextAwareXHEAACDRCTypeUtil.A01(this.A06);
                int DRCTypeFromHeadset = A0L[3].length();
                if (DRCTypeFromHeadset != 28) {
                    throw new RuntimeException();
                }
                String[] strArr = A0L;
                strArr[1] = "LZogbi5BZWCXkICBwmOMX8OtkvvUDPu5";
                strArr[6] = "HFkZzMhVfRobNZeBREZjfgSbFT9rBjx5";
                if (iA01 != 3) {
                    return iA01;
                }
                return iA00;
            }
            return iA00;
        }
        return i2;
    }

    public static int A01(C2154or c2154or) {
        if (A07(104, 9, 112).equals(c2154or.A0W)) {
            return c2154or.A0C;
        }
        return 2;
    }

    private int A02(AR ar, C2154or c2154or) {
        if (A07(38, 22, 76).equals(ar.A03) && AbstractC04664a.A02 < 24) {
            int i2 = AbstractC04664a.A02;
            String[] strArr = A0L;
            if (strArr[2].charAt(3) != strArr[7].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[2] = "s8yZpZp8nIrL7EQY3mPJ1kqCekDwsY6i";
            strArr2[7] = "yd2Z0BEEocl53iuZqAxtcOKT0DXRknsH";
            if (i2 != 23 || !AbstractC04664a.A18(this.A0F)) {
                String[] strArr3 = A0L;
                if (strArr3[4].charAt(18) != strArr3[0].charAt(18)) {
                    throw new RuntimeException();
                }
                A0L[3] = "9QHOUbokymVnxuZO6z7rLJCC2XoG";
                return -1;
            }
        }
        int i8 = c2154or.A0B;
        String[] strArr4 = A0L;
        if (strArr4[2].charAt(3) != strArr4[7].charAt(3)) {
            return i8;
        }
        String[] strArr5 = A0L;
        strArr5[2] = "bWiZaXhFQHkoAXZnJ4ncaGOlncM6vz1V";
        strArr5[7] = "kg6ZwO8ePPrkJPsuoAADu0ZS0U6OWo96";
        return i8;
    }

    private final int A03(AR ar, C2154or c2154or, C2154or[] c2154orArr) {
        int maxInputSize = A02(ar, c2154or);
        return maxInputSize;
    }

    private final MediaFormat A04(C2154or c2154or, String str, int i2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A07(ModuleDescriptor.MODULE_VERSION, 4, 14), str);
        mediaFormat.setInteger(A07(113, 13, 2), c2154or.A06);
        mediaFormat.setInteger(A07(177, 11, 49), c2154or.A0G);
        AnonymousClass46.A06(mediaFormat, c2154or.A0X);
        AnonymousClass46.A04(mediaFormat, A07(141, 14, 43), i2);
        if (AbstractC04664a.A02 >= 23) {
            String strA07 = A07(169, 8, 11);
            String[] strArr = A0L;
            if (strArr[4].charAt(18) != strArr[0].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[1] = "w8gjBPJzE632nZpBrlzwe1tLIvq8CsOY";
            strArr2[6] = "ag3DPBWcd6fSOrmBwunkDpt77Nl4HY4l";
            mediaFormat.setInteger(strA07, 0);
        }
        if (c2154or.A0R != null && c2154or.A0R.equals(A07(159, 10, 15)) && this.A11.A0F) {
            mediaFormat.setInteger(A07(60, 19, 77), A00());
            mediaFormat.setInteger(A07(79, 20, 43), this.A11.A08);
        }
        return mediaFormat;
    }

    public static /* synthetic */ AnonymousClass75 A05(C0Q c0q) {
        return null;
    }

    private void A08() {
        long jA7X = this.A0J.A7X(AAG());
        if (jA7X != Long.MIN_VALUE) {
            if (!this.A0B) {
                long j = this.A04;
                String[] strArr = A0L;
                if (strArr[2].charAt(3) != strArr[7].charAt(3)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0L;
                strArr2[4] = "nIJcPeFAtvuDBzBlXMRw0HpU2OMpTIMr";
                strArr2[0] = "dapTBdH8hqStbvnLCARUyCc0T0ChI3T8";
                jA7X = Math.max(j, jA7X);
            }
            this.A04 = jA7X;
            this.A0B = false;
        }
    }

    private boolean A0A(C2154or c2154or) {
        String str = c2154or.A0W;
        String mimeType = A07(104, 9, 112);
        if (!mimeType.equals(str)) {
            return this.A0J.AJc(c2154or);
        }
        String[] strArr = A0L;
        if (strArr[2].charAt(3) != strArr[7].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0L;
        strArr2[4] = "mDVewdn3RvQYeqn2qaR7zJPFTyK9zqzw";
        strArr2[0] = "a0e3mP5dmYOn07QMhHRhkP7lbfukdIg9";
        return false;
    }

    public static boolean A0B(String str) {
        if (AbstractC04664a.A02 < 24 && A07(23, 15, 35).equals(str)) {
            if (A07(188, 7, 22).equals(AbstractC04664a.A05) && (AbstractC04664a.A03.startsWith(A07(195, 8, 67)) || AbstractC04664a.A03.startsWith(A07(126, 7, 56)) || AbstractC04664a.A03.startsWith(A07(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 8, 28)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.C9Z
    public final void A1X() {
        super.A1X();
        this.A0J.AGG();
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.C9Z
    public final void A1Y() {
        A08();
        this.A0J.pause();
        super.A1Y();
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.C9Z
    public final void A1Z() {
        try {
            this.A0J.flush();
            try {
                super.A1Z();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.A1Z();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.C9Z
    public final void A1a(long j, boolean z2) throws C9Y {
        super.A1a(j, z2);
        if (this.A0D) {
            this.A0J.A6L();
        } else {
            this.A0J.flush();
        }
        this.A04 = j;
        this.A0A = true;
        this.A0B = true;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.C9Z
    public final void A1b(boolean z2, boolean z7) throws C9Y {
        super.A1b(z2, z7);
        this.A0G.A08(this.A0j);
        if (A1V().A00) {
            this.A0J.A6E();
        } else {
            this.A0J.A5r();
        }
        this.A0J.AIw(A1W());
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final int A1g(AO ao, AR ar, C2154or c2154or, C2154or c2154or2) {
        if (this.A11.A0N && A02(ar, c2154or2) <= this.A00 && ar.A0U(c2154or, c2154or2, true) && c2154or.A08 == 0 && c2154or.A09 == 0 && c2154or2.A08 == 0 && c2154or2.A09 == 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A1h(com.instagram.common.viewpoint.core.InterfaceC0626Ar r10, com.instagram.common.viewpoint.core.C9U r11, com.instagram.common.viewpoint.core.C2154or r12) throws com.instagram.common.viewpoint.core.C0630Av {
        /*
            r9 = this;
            java.lang.String r4 = r12.A0W
            boolean r0 = com.instagram.common.viewpoint.core.AbstractC04212h.A0C(r4)
            r3 = 0
            if (r0 != 0) goto La
            return r3
        La:
            int r0 = com.instagram.common.viewpoint.core.AbstractC04664a.A02
            r5 = 21
            if (r0 < r5) goto L29
            r8 = 32
        L12:
            boolean r7 = com.instagram.common.viewpoint.core.AnonymousClass14.A1G(r12)
            r6 = 4
            if (r7 == 0) goto L2b
            boolean r0 = r9.A0A(r12)
            if (r0 == 0) goto L2b
            com.facebook.ads.redexgen.X.AR r0 = com.instagram.common.viewpoint.core.C0633Ay.A0I()
            if (r0 == 0) goto L2b
            r0 = r8 | 8
            r0 = r0 | r6
            return r0
        L29:
            r8 = 0
            goto L12
        L2b:
            r2 = 104(0x68, float:1.46E-43)
            r1 = 9
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            r4 = 1
            if (r0 == 0) goto L48
            com.facebook.ads.redexgen.X.8N r2 = r9.A0J
            int r1 = r12.A06
            int r0 = r12.A0C
            boolean r0 = r2.AJe(r1, r0)
            if (r0 == 0) goto L53
        L48:
            com.facebook.ads.redexgen.X.8N r1 = r9.A0J
            int r0 = r12.A06
            r2 = 2
            boolean r0 = r1.AJe(r0, r2)
            if (r0 != 0) goto L54
        L53:
            return r4
        L54:
            java.util.List r1 = r9.A1l(r10, r12, r3)
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L63
            int r0 = com.instagram.common.viewpoint.core.AnonymousClass76.A00(r4)
            return r0
        L63:
            if (r7 != 0) goto L6a
            int r0 = com.instagram.common.viewpoint.core.AnonymousClass76.A00(r2)
            return r0
        L6a:
            java.lang.Object r4 = r1.get(r3)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C0Q.A0L
            r0 = 5
            r1 = r1[r0]
            r0 = 0
            char r1 = r1.charAt(r0)
            r0 = 112(0x70, float:1.57E-43)
            if (r1 == r0) goto L82
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L82:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C0Q.A0L
            java.lang.String r1 = "n12bmxDOOVBzqYYOQBRjqp0moJyAYtSu"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "BaglFChNOdaklTSyUQRitIBwXJJTR14H"
            r0 = 0
            r2[r0] = r1
            com.facebook.ads.redexgen.X.AR r4 = (com.instagram.common.viewpoint.core.AR) r4
            int r0 = com.instagram.common.viewpoint.core.AbstractC04664a.A02
            if (r0 < r5) goto Lad
            int r0 = r12.A0G
            r1 = -1
            if (r0 == r1) goto La1
            int r0 = r12.A0G
            boolean r0 = r4.A0Q(r0)
            if (r0 == 0) goto Lae
        La1:
            int r0 = r12.A06
            if (r0 == r1) goto Lad
            int r0 = r12.A06
            boolean r0 = r4.A0P(r0)
            if (r0 == 0) goto Lae
        Lad:
            r3 = 1
        Lae:
            if (r3 == 0) goto Lbf
            boolean r0 = r4.A0T(r12)
            if (r0 == 0) goto Lbf
            r0 = 16
        Lb8:
            if (r3 == 0) goto Lbd
        Lba:
            r0 = r0 | r8
            r0 = r0 | r6
            return r0
        Lbd:
            r6 = 3
            goto Lba
        Lbf:
            r0 = 8
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C0Q.A1h(com.facebook.ads.redexgen.X.Ar, com.facebook.ads.redexgen.X.9U, com.facebook.ads.redexgen.X.or):int");
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final List<AR> A1l(InterfaceC0626Ar interfaceC0626Ar, C2154or c2154or, boolean z2) throws C0630Av {
        AR arA0I;
        String mimeType = c2154or.A0W;
        if (mimeType == null) {
            return Collections.emptyList();
        }
        if (A0A(c2154or) && (arA0I = C0633Ay.A0I()) != null) {
            List<AR> listSingletonList = Collections.singletonList(arA0I);
            String[] strArr = A0L;
            if (strArr[1].charAt(15) != strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[4] = "VH1rG9jH3WXhHTxnLXRxhYBKNNIMNlpD";
            strArr2[0] = "4dJInhYjvnfEcXSyIbRNEiIfORerumv3";
            return listSingletonList;
        }
        return Collections.unmodifiableList(interfaceC0626Ar.A7g(c2154or.A0W, z2, false));
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final void A1o() throws C9Y {
        try {
            this.A0J.AGI();
        } catch (C8M e) {
            throw A1T(e, e.A01, e.A02, IronSourceConstants.errorCode_isReadyException);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final void A1s(C2154or c2154or) throws C9Y {
        super.A1s(c2154or);
        this.A08 = c2154or;
        this.A0G.A05(this.A08, null);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final void A1u(C2076nY c2076nY) {
        if (this.A0A && !c2076nY.A04()) {
            if (Math.abs(c2076nY.A01 - this.A04) > 500000) {
                this.A04 = c2076nY.A01;
            }
            this.A0A = false;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x0098 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1v(com.instagram.common.viewpoint.core.AO r9, android.media.MediaFormat r10) throws com.instagram.common.viewpoint.core.C9Y {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C0Q.A1v(com.facebook.ads.redexgen.X.AO, android.media.MediaFormat):void");
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final void A1w(AR ar, AO ao, C2154or c2154or, MediaCrypto mediaCrypto) {
        this.A00 = A03(ar, c2154or, A1e());
        this.A0C = A0B(ar.A03);
        String str = ar.A02;
        String strA07 = A07(104, 9, 112);
        this.A0E = strA07.equals(str) && !strA07.equals(c2154or.A0W);
        MediaFormat mediaFormatA04 = A04(c2154or, ar.A01, this.A00);
        ao.A50(mediaFormatA04, null, mediaCrypto, 0, null);
        if (this.A0E) {
            this.A07 = mediaFormatA04;
            this.A07.setString(A07(ModuleDescriptor.MODULE_VERSION, 4, 14), c2154or.A0W);
        } else {
            this.A07 = null;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public final void A1x(String str) {
        this.A0G.A0F(str);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final void A1y(String str, long j, long j3) {
        this.A0G.A0G(str, j, j3);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    @MetaExoPlayerCustomization("Added in D6142814")
    public final boolean A22() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14
    public final boolean A23(long j, long j3, AO ao, ByteBuffer byteBuffer, int i2, int i8, long j8, boolean z2, boolean z7) throws C9Y {
        if (this.A0E) {
            int i9 = i8 & 2;
            if (A0L[3].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0L;
            strArr[2] = "qFTZlqBsfbROWjHKIBaS9ttrRfnfHc6a";
            strArr[7] = "sZoZRvagNjZKK9rko7XS8oWwcuS8hqha";
            if (i9 != 0) {
                ao.AGy(i2, false);
                return true;
            }
        }
        if (z2) {
            ao.AGy(i2, false);
            if (A0L[5].charAt(0) != 'p') {
                String[] strArr2 = A0L;
                strArr2[4] = "i4U0xdeb2kJYTtTzacReJ5RV5axgIdhD";
                strArr2[0] = "rrPeATHc6C5SnSGUS9RZuIpTT0sGFjMh";
                this.A0j.A0B++;
                this.A0J.A9Z();
                return true;
            }
            String[] strArr3 = A0L;
            strArr3[1] = "GzmR5b8Z6T6If0UBPoEMKvf6QjFSlvzk";
            strArr3[6] = "qLQdQ1juS6S8x5RB3mUlKTK412OZk0qd";
            this.A0j.A0B++;
            this.A0J.A9Z();
            return true;
        }
        if (this.A0I && A01(this.A08) == 2 && i8 == 0 && this.A03 > 0 && byteBuffer.limit() - byteBuffer.position() >= 12) {
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            byteBuffer.position(10);
            short s7 = byteBuffer.getShort();
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            int i10 = this.A01;
            int iLimit2 = byteBuffer.limit();
            int originalPosition = byteBuffer.position();
            this.A01 = i10 + (iLimit2 - originalPosition);
            int i11 = this.A02;
            String[] strArr4 = A0L;
            String str = strArr4[4];
            String str2 = strArr4[0];
            int iCharAt = str.charAt(18);
            int originalPosition2 = str2.charAt(18);
            if (iCharAt != originalPosition2) {
                throw new RuntimeException();
            }
            String[] strArr5 = A0L;
            strArr5[1] = "MwudhWWmLfAHxFUBWVuNAQ0R1ppnonhu";
            strArr5[6] = "h4oByFchRKdWl7IBcc7CSq20vr2fgRzF";
            this.A02 = i11 + 1;
            long j9 = this.A05;
            int originalPosition3 = Math.abs((int) s7);
            this.A05 = j9 + ((long) originalPosition3);
            int i12 = this.A01;
            int originalPosition4 = this.A03;
            if (i12 >= originalPosition4 * 2) {
                this.A0G.A00((int) (this.A05 / ((long) this.A02)));
                this.A01 = 0;
                this.A02 = 0;
                this.A05 = 0L;
            }
        }
        if (this.A0H) {
            int iLimit3 = byteBuffer.limit();
            int originalPosition5 = byteBuffer.position();
            if (iLimit3 > originalPosition5) {
                int iPosition2 = byteBuffer.position();
                int iLimit4 = byteBuffer.limit();
                int originalPosition6 = iLimit4 - iPosition2;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(originalPosition6);
                byteBufferAllocate.put(byteBuffer);
                byteBufferAllocate.flip();
                byteBuffer.position(iPosition2);
                byteBuffer.limit(iLimit4);
                this.A0G.A0K(byteBufferAllocate.array(), j8 / 1000);
            }
        }
        try {
            if (!this.A0J.A9W(byteBuffer, j8, 1)) {
                return false;
            }
            ao.AGy(i2, false);
            this.A0j.A09++;
            return true;
        } catch (C8H e) {
            throw A1T(e, this.A08, e.A02, IronSourceConstants.errorCode_biddingDataException);
        } catch (C8M e4) {
            throw A1T(e4, this.A0i, e4.A02, IronSourceConstants.errorCode_isReadyException);
        }
    }

    public final void A26() {
        this.A0B = true;
    }

    @Override // com.instagram.common.viewpoint.core.C9Z, com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final C6W A8L() {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.C6W
    public final C2138ob A8e() {
        return this.A0J.A8e();
    }

    @Override // com.instagram.common.viewpoint.core.C6W
    public final long A8h() {
        if (A92() == 2) {
            A08();
        }
        long j = this.A04;
        String[] strArr = A0L;
        if (strArr[1].charAt(15) != strArr[6].charAt(15)) {
            throw new RuntimeException();
        }
        A0L[5] = "p6YKYNxicnjzLIFANgsfPKErY7h8fvSp";
        return j;
    }

    @Override // com.instagram.common.viewpoint.core.C9Z, com.instagram.common.viewpoint.core.AnonymousClass70
    public final void A9a(int i2, Object obj) throws C9Y {
        switch (i2) {
            case 2:
                this.A0J.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.A0J.AIW((C2160oy) obj);
                return;
            case 4:
            case 5:
            case 7:
            case 8:
            default:
                super.A9a(i2, obj);
                return;
            case 6:
                this.A0J.AIY((C1P) obj);
                return;
            case 9:
                this.A0J.AJ4(((Boolean) obj).booleanValue());
                return;
            case 10:
                this.A0J.AIX(((Integer) obj).intValue());
                return;
            case 11:
                this.A09 = null;
                return;
            case 12:
                if (AbstractC04664a.A02 < 23) {
                    return;
                }
                C8N c8n = this.A0J;
                if (A0L[3].length() != 28) {
                    throw new RuntimeException();
                }
                A0L[3] = "XCf3J2AEJJ1Zd2j3qAi6tezJ2mG7";
                C05798q.A00(c8n, obj);
                return;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final boolean AAG() {
        return super.AAG() && this.A0J.AAG();
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass14, com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final boolean AAV() {
        if (!this.A0J.A9g()) {
            boolean zAAV = super.AAV();
            if (A0L[5].charAt(0) != 'p') {
                throw new RuntimeException();
            }
            A0L[3] = "YZui0KIXZR8KzjI1EkPC1GaIUT4y";
            if (!zAAV) {
                return false;
            }
        }
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.C6W
    public final void AIt(C2138ob c2138ob) {
        this.A0J.AIt(c2138ob);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM, com.instagram.common.viewpoint.core.C7D
    public final String getName() {
        return A07(0, 23, 11);
    }
}

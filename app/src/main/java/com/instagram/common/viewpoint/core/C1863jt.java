package com.instagram.common.viewpoint.core;

import android.util.SparseArray;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1863jt implements InterfaceC0867Kc {
    public static byte[] A02;
    public static String[] A03 = {"H5L2tIFZt", "7T8ctTOgfri2uFWYkrl4fLjFw3zYZmyw", "rpSuNqLmPSNrp8BaktpsZc4frut4njZi", "OS1ujTmztQNXT6hqD6nsoX0kfRSYmmsY", "PkY6KfFeVbpCvwlFdEj", "TmaVkoyYGnCbszGh0vcMc", "p0AihzwiszaEN", "o1l4pHohEGjnpBhSGl6NtukXiQnI0CCo"};
    public final int A00;
    public final List<C2154or> A01;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private List<C2154or> A03(C0866Kb c0866Kb) {
        String strA02;
        int i2;
        if (A05(32)) {
            return this.A01;
        }
        C4J c4j = new C4J(c0866Kb.A03);
        List<C2154or> arrayList = this.A01;
        while (c4j.A07() > 0) {
            int iA0I = c4j.A0I();
            int iA09 = c4j.A09() + c4j.A0I();
            if (iA0I == 134) {
                arrayList = new ArrayList<>();
                int iA0I2 = c4j.A0I() & 31;
                for (int i8 = 0; i8 < iA0I2; i8++) {
                    String strA0W = c4j.A0W(3);
                    int iA0I3 = c4j.A0I();
                    boolean z2 = (iA0I3 & 128) != 0;
                    if (z2) {
                        strA02 = A02(19, 19, 47);
                        i2 = iA0I3 & 63;
                    } else {
                        strA02 = A02(0, 19, 57);
                        i2 = 1;
                    }
                    byte bA0I = (byte) c4j.A0I();
                    c4j.A0g(1);
                    List<byte[]> listA04 = null;
                    if (z2) {
                        boolean z7 = (bA0I & 64) != 0;
                        if (A03[5].length() != 21) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[6] = "Fx9tcNCtSciYr";
                        strArr[4] = "fWuzF8xs7o61BMX22RC";
                        listA04 = C3U.A04(z7);
                    }
                    arrayList.add(new C2D().A11(strA02).A10(strA0W).A0Z(i2).A12(listA04).A14());
                }
            }
            c4j.A0f(iA09);
        }
        return arrayList;
    }

    public static void A04() {
        A02 = new byte[]{-30, -15, -15, -19, -22, -28, -30, -11, -22, -16, -17, -80, -28, -26, -30, -82, -73, -79, -71, -40, -25, -25, -29, -32, -38, -40, -21, -32, -26, -27, -90, -38, -36, -40, -92, -82, -89, -81, 12, 27, 27, 23, 20, 14, 12, 31, 20, 26, 25, -38, 33, 25, 15, -39, 15, 33, 13, -39, 12, 20, 31, -61, -46, -46, -50, -53, -59, -61, -42, -53, -47, -48, -111, -38, -113, -43, -59, -42, -57, -107, -105};
    }

    static {
        A04();
    }

    public C1863jt() {
        this(0);
    }

    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public C1863jt(int i2) {
        this(i2, MetaExoPlayerCustomizedCollections.A03(new C2154or[0]));
    }

    public C1863jt(int i2, List<C2154or> list) {
        this.A00 = i2;
        this.A01 = list;
    }

    private KX A00(C0866Kb c0866Kb) {
        return new KX(A03(c0866Kb));
    }

    private C0872Kh A01(C0866Kb c0866Kb) {
        return new C0872Kh(A03(c0866Kb));
    }

    private boolean A05(int i2) {
        return (this.A00 & i2) != 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0867Kc
    public final SparseArray<InterfaceC0870Kf> A5I() {
        return new SparseArray<>();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0867Kc
    public final InterfaceC0870Kf A5N(int i2, C0866Kb c0866Kb) {
        switch (i2) {
            case 2:
            case 128:
                return new C1852ji(new C1860jq(A01(c0866Kb)));
            case 3:
            case 4:
                return new C1852ji(new C1854jk(c0866Kb.A01));
            case 15:
                if (A05(2)) {
                    return null;
                }
                return new C1852ji(new C1864ju(false, c0866Kb.A01));
            case 16:
                return new C1852ji(new C1859jp(A01(c0866Kb)));
            case 17:
                if (A05(2)) {
                    return null;
                }
                return new C1852ji(new C1855jl(c0866Kb.A01));
            case 21:
                return new C1852ji(new C1856jm());
            case 27:
                if (A05(4)) {
                    return null;
                }
                return new C1852ji(new C1858jo(A00(c0866Kb), A05(1), A05(8)));
            case 36:
                return new C1852ji(new C1857jn(A00(c0866Kb)));
            case 89:
                return new C1852ji(new C1861jr(c0866Kb.A02));
            case EMPTY_TPAT_ERROR_VALUE:
            case INVALID_CONFIG_RESPONSE_VALUE:
                return new C1852ji(new C1870k0(c0866Kb.A01));
            case MRAID_DOWNLOAD_JS_ERROR_VALUE:
                if (!A05(64)) {
                    return null;
                }
                break;
            case STORE_REGION_CODE_ERROR_VALUE:
                if (A05(16)) {
                    return null;
                }
                return new C1847jd(new C1853jj(A02(61, 20, 26)));
            case CONFIG_REFRESH_FAILED_VALUE:
                break;
            case 172:
                return new C1852ji(new C1867jx(c0866Kb.A01));
            case 257:
                return new C1847jd(new C1853jj(A02(38, 23, 99)));
            default:
                return null;
        }
        return new C1852ji(new C1862js(c0866Kb.A01));
    }
}

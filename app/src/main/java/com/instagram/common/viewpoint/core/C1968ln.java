package com.instagram.common.viewpoint.core;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ln, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1968ln extends E5<C1968ln> implements Comparable<C1968ln> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A01(List<C1968ln> list, List<C1968ln> list2) {
        return list.get(0).compareTo(list2.get(0));
    }

    public C1968ln(int i2, C2120oH c2120oH, int i8, AnonymousClass93 anonymousClass93, int i9, String str) {
        List<String> listA03;
        super(i2, c2120oH, i8);
        int i10 = 0;
        this.A08 = AnonymousClass92.A0S(i9, false);
        int i11 = super.A02.A0H & (~((C2113oA) anonymousClass93).A00);
        this.A06 = (i11 & 1) != 0;
        this.A07 = (i11 & 2) != 0;
        int i12 = Integer.MAX_VALUE;
        int bestLanguageScore = 0;
        if (anonymousClass93.A0K.isEmpty()) {
            listA03 = MetaExoPlayerCustomizedCollections.A03("");
        } else {
            listA03 = anonymousClass93.A0K;
        }
        int bestLanguageIndex = 0;
        while (true) {
            if (bestLanguageIndex >= listA03.size()) {
                break;
            }
            int iA02 = AnonymousClass92.A02(super.A02, listA03.get(bestLanguageIndex), anonymousClass93.A0P);
            if (iA02 > 0) {
                i12 = bestLanguageIndex;
                bestLanguageScore = iA02;
                break;
            }
            bestLanguageIndex++;
        }
        this.A00 = i12;
        this.A01 = bestLanguageScore;
        this.A02 = AnonymousClass92.A00(super.A02.A0E, ((C2113oA) anonymousClass93).A0C);
        this.A05 = (super.A02.A0E & 1088) != 0;
        this.A03 = AnonymousClass92.A02(super.A02, str, AnonymousClass92.A0K(str) == null);
        boolean z2 = this.A01 > 0 || (anonymousClass93.A0K.isEmpty() && this.A02 > 0) || this.A06 || (this.A07 && this.A03 > 0);
        if (AnonymousClass92.A0S(i9, anonymousClass93.A0B) && z2) {
            i10 = 1;
        }
        this.A04 = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1968ln c1968ln) {
        AbstractC1985m4 abstractC1985m4A06 = AbstractC1985m4.A01().A09(this.A08, c1968ln.A08).A08(Integer.valueOf(this.A00), Integer.valueOf(c1968ln.A00), AbstractC2133oV.A03().A06()).A06(this.A01, c1968ln.A01).A06(this.A02, c1968ln.A02).A09(this.A06, c1968ln.A06).A08(Boolean.valueOf(this.A07), Boolean.valueOf(c1968ln.A07), this.A01 == 0 ? AbstractC2133oV.A03() : AbstractC2133oV.A03().A06()).A06(this.A03, c1968ln.A03);
        if (this.A02 == 0) {
            abstractC1985m4A06 = abstractC1985m4A06.A0A(this.A05, c1968ln.A05);
        }
        return abstractC1985m4A06.A05();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$TextTrackInfo> */
    public static AbstractC0621Am<C1968ln> A02(int i2, C2120oH c2120oH, AnonymousClass93 anonymousClass93, int[] iArr, String str) {
        C03971h c03971hA01 = AbstractC0621Am.A01();
        for (int i8 = 0; i8 < c2120oH.A01; i8++) {
            c03971hA01.A04(new C1968ln(i2, c2120oH, i8, anonymousClass93, iArr[i8], str));
        }
        return c03971hA01.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.E5
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final boolean A09(C1968ln c1968ln) {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.E5
    public final int A08() {
        return this.A04;
    }
}

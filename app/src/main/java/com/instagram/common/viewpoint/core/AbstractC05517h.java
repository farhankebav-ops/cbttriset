package com.instagram.common.viewpoint.core;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC05517h implements InterfaceC1893kN {
    public static String[] A06 = {"A1ZwXb6JdBVxSPYV1ZzpyUVQy2gRfJA9", "vkvPFBYHwcZnb4NzphHjmgFJFbjiYwSo", "W7sj7Up3ABI8RZFTAAZOEHe7srfTkl57", "fls3PiASqtk6GqNgTZFqwBZFoYeyHn2V", "1yDmXHBn42mad7W8CPx8A7RWKYn1BqT7", "CjPJSc8sfbO2R56Y3Yx9Z137FYjSqvlb", "2KSypf5DjPiLYF3nQ7brfSsHONTUzR5A", "k5ePLg8NJJ"};
    public long A00;
    public long A01;
    public C03830t A02;
    public final ArrayDeque<C03830t> A03 = new ArrayDeque<>();
    public final ArrayDeque<AbstractC05527i> A04;
    public final PriorityQueue<C03830t> A05;

    public abstract C1888kI A0Z();

    public abstract void A0b(C05537j c05537j);

    public abstract boolean A0d();

    public AbstractC05517h() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.A03.add(new C03830t());
        }
        this.A04 = new ArrayDeque<>();
        for (int i8 = 0; i8 < 2; i8++) {
            ArrayDeque<AbstractC05527i> arrayDeque = this.A04;
            final C5S c5s = new C5S() { // from class: com.facebook.ads.redexgen.X.kL
                @Override // com.instagram.common.viewpoint.core.C5S
                public final void AGz(AbstractC2075nX abstractC2075nX) {
                    this.A00.A0c((C03820s) abstractC2075nX);
                }
            };
            arrayDeque.add(new AbstractC05527i(c5s) { // from class: com.facebook.ads.redexgen.X.0s
                public C5S<C03820s> A00;

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5S != com.facebook.ads.androidx.media3.decoder.DecoderOutputBuffer$Owner<com.facebook.ads.androidx.media3.extractor.text.cea.CeaDecoder$CeaOutputBuffer> */
                {
                    this.A00 = c5s;
                }

                @Override // com.instagram.common.viewpoint.core.AbstractC05527i, com.instagram.common.viewpoint.core.AbstractC2075nX
                public final void A0B() {
                    this.A00.AGz(this);
                }
            });
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0U(C03830t c03830t) {
        c03830t.A0A();
        this.A03.add(c03830t);
    }

    public final long A0V() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.C5O
    /* JADX INFO: renamed from: A0W, reason: merged with bridge method [inline-methods] */
    public C05537j A5j() throws C1892kM {
        C3M.A08(this.A02 == null);
        if (this.A03.isEmpty()) {
            return null;
        }
        this.A02 = this.A03.pollFirst();
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f7, code lost:
    
        return null;
     */
    @Override // com.instagram.common.viewpoint.core.C5O
    /* JADX INFO: renamed from: A0X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.instagram.common.viewpoint.core.AbstractC05527i A5l() throws com.instagram.common.viewpoint.core.C1892kM {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.AbstractC05517h.A5l():com.facebook.ads.redexgen.X.7i");
    }

    public final AbstractC05527i A0Y() {
        return this.A04.pollFirst();
    }

    @Override // com.instagram.common.viewpoint.core.C5O
    /* JADX INFO: renamed from: A0a, reason: merged with bridge method [inline-methods] */
    public void AGZ(C05537j c05537j) throws C1892kM {
        C3M.A07(c05537j == this.A02);
        C03830t c03830t = (C03830t) c05537j;
        if (c03830t.A04()) {
            A0U(c03830t);
        } else {
            long j = this.A01;
            this.A01 = 1 + j;
            c03830t.A00 = j;
            this.A05.add(c03830t);
        }
        if (A06[7].length() != 10) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[0] = "rj1eyhsOe6SuoM1rYy40tvsoNCkJE80J";
        strArr[1] = "ibYLffFAaVDMN4cD1vowu1tbJEM8Lkom";
        this.A02 = null;
    }

    public final void A0c(AbstractC05527i abstractC05527i) {
        abstractC05527i.A0A();
        this.A04.add(abstractC05527i);
    }

    @Override // com.instagram.common.viewpoint.core.C5O
    public void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1893kN
    public void AIx(long j) {
        this.A00 = j;
    }

    @Override // com.instagram.common.viewpoint.core.C5O
    public void flush() {
        this.A01 = 0L;
        this.A00 = 0L;
        while (!this.A05.isEmpty()) {
            A0U((C03830t) AbstractC04664a.A0f(this.A05.poll()));
        }
        if (this.A02 != null) {
            A0U(this.A02);
            this.A02 = null;
        }
    }
}

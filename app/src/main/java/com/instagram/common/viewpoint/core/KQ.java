package com.instagram.common.viewpoint.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KQ {
    public static String[] A0I = {"PiFB59Vxde45j8XGh3VNLS0bXquL", "eCGnEp7n3q", "QH0EN4bfbiXOmvaYxmEgWcgYRTVGFgtW", "ynU2FJVvbbIz4lLWIxM7HwzaaEzIs2yM", "B", "nKAZbJPu58l8", "2xLWRKjlXe7o2y", "tMbtJGMRwKJD523"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final H1 A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<C0777Gp> A0D = new SparseArray<>();
    public final SparseArray<C0776Go> A0C = new SparseArray<>();
    public KP A06 = new KP();
    public KP A07 = new KP();
    public byte[] A0B = new byte[128];
    public final C0780Gs A0E = new C0780Gs(this.A0B, 0, 0);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x021e A[PHI: r18 r20
  0x021e: PHI (r18v1 int) = (r18v0 int), (r18v0 int), (r18v0 int), (r18v0 int), (r18v3 int), (r18v3 int) binds: [B:92:0x01fa, B:94:0x01fe, B:99:0x0211, B:100:0x0213, B:82:0x01c6, B:83:0x01c8] A[DONT_GENERATE, DONT_INLINE]
  0x021e: PHI (r20v2 int) = (r20v0 int), (r20v0 int), (r20v1 int), (r20v1 int), (r20v0 int), (r20v0 int) binds: [B:92:0x01fa, B:94:0x01fe, B:99:0x0211, B:100:0x0213, B:82:0x01c6, B:83:0x01c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(byte[] r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.KQ.A05(byte[], int, int):void");
    }

    public KQ(H1 h12, boolean z2, boolean z7) {
        this.A0F = h12;
        this.A0G = z2;
        this.A0H = z7;
        A01();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void A00(int i2) {
        if (this.A05 == -9223372036854775807L) {
            return;
        }
        boolean z2 = this.A0A;
        this.A0F.AIA(this.A05, z2 ? 1 : 0, (int) (this.A02 - this.A04), i2, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    public final void A02(long j, int i2, long j3) {
        this.A01 = i2;
        this.A03 = j3;
        this.A02 = j;
        if (!this.A0G || this.A01 != 1) {
            if (!this.A0H) {
                return;
            }
            if (this.A01 != 5 && this.A01 != 1 && this.A01 != 2) {
                return;
            }
        }
        KP kp = this.A06;
        KP kp2 = this.A07;
        if (A0I[1].length() != 10) {
            throw new RuntimeException();
        }
        A0I[6] = "uj74NyijhUvg4q";
        this.A06 = kp2;
        this.A07 = kp;
        KP newSliceHeader = this.A07;
        newSliceHeader.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A03(C0776Go c0776Go) {
        this.A0C.append(c0776Go.A00, c0776Go);
    }

    public final void A04(C0777Gp c0777Gp) {
        this.A0D.append(c0777Gp.A09, c0777Gp);
    }

    public final boolean A06() {
        return this.A0H;
    }

    public final boolean A07(long j, int i2, boolean z2, boolean z7) {
        boolean z8 = false;
        if (this.A01 == 9 || (this.A0H && this.A07.A00(this.A06))) {
            if (z2 && this.A09) {
                A00(i2 + ((int) (j - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        if (this.A0G) {
            z7 = this.A07.A05();
        }
        boolean z9 = this.A0A;
        if (this.A01 == 5 || (z7 && this.A01 == 1)) {
            z8 = true;
        }
        this.A0A = z9 | z8;
        boolean treatIFrameAsKeyframe = this.A0A;
        return treatIFrameAsKeyframe;
    }
}

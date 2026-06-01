package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KN {
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final H1 A07;

    public KN(H1 h12) {
        this.A07 = h12;
    }

    public final void A00() {
        this.A05 = false;
        this.A04 = false;
        this.A06 = false;
        this.A00 = -1;
    }

    public final void A01(int i2, long j) {
        this.A00 = i2;
        this.A06 = false;
        boolean z2 = true;
        this.A05 = i2 == 182 || i2 == 179;
        if (i2 != 182) {
            z2 = false;
        }
        this.A04 = z2;
        this.A01 = 0;
        this.A03 = j;
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
    public final void A02(long j, int i2, boolean z2) {
        if (this.A00 == 182 && z2 && this.A05 && this.A03 != -9223372036854775807L) {
            this.A07.AIA(this.A03, this.A06 ? 1 : 0, (int) (j - this.A02), i2, null);
        }
        if (this.A00 != 179) {
            this.A02 = j;
        }
    }

    public final void A03(byte[] bArr, int i2, int i8) {
        if (this.A04) {
            int i9 = (i2 + 1) - this.A01;
            if (i9 < i8) {
                int headerOffset = bArr[i9];
                this.A06 = ((headerOffset & 192) >> 6) == 0;
                this.A04 = false;
                return;
            }
            this.A01 += i8 - i2;
        }
    }
}

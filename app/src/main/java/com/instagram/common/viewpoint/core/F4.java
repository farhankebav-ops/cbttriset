package com.instagram.common.viewpoint.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F4 extends QC<C0731Ev> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public AbstractC1207Xm A04;
    public InterfaceC1208Xn A05;
    public String A06;
    public List<C1444cn> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC1752hy A0A;
    public final SF A0B;
    public final C1477dL A0C;
    public final US A0D;
    public final XH A0E;
    public final FH A0F;
    public final C1550eX A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public F4(C1477dL c1477dL, List<C1444cn> list, AbstractC1752hy abstractC1752hy, US us, SF sf, C1550eX c1550eX, XH xh, InterfaceC1208Xn interfaceC1208Xn, String str, int i2, int i8, int i9, int i10, FH fh, AbstractC1207Xm abstractC1207Xm) {
        this.A0C = c1477dL;
        this.A0D = us;
        this.A0B = sf;
        this.A0G = c1550eX;
        this.A0E = xh;
        this.A05 = interfaceC1208Xn;
        this.A0A = abstractC1752hy;
        this.A07 = list;
        this.A00 = i2;
        this.A03 = i10;
        this.A06 = str;
        this.A01 = i9;
        this.A02 = i8;
        this.A0F = fh;
        this.A04 = abstractC1207Xm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.QC
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C0731Ev A0F(ViewGroup viewGroup, int i2) {
        return new C0731Ev(AbstractC1374bf.A00(new C1314ah(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0R(this.A04).A0W(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A21());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.QC
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(C0731Ev c0731Ev, int i2) {
        c0731Ev.A0q(this.A07.get(i2), this.A0D, this.A0B, this.A0E, this.A06);
        if (!this.A08 && i2 == 0) {
            c0731Ev.AIV();
            this.A08 = true;
        }
    }

    @Override // com.instagram.common.viewpoint.core.QC
    public final int A0B() {
        return this.A07.size();
    }
}

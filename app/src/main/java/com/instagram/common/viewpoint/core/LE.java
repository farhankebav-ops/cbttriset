package com.instagram.common.viewpoint.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LE extends QC<FD> {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC1208Xn A03;
    public C1550eX A04;
    public String A05;
    public List<C1444cn> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC1752hy A08;
    public final SF A09;
    public final C1477dL A0A;
    public final US A0B;
    public final C1020Qc A0C;
    public final XH A0D;
    public final C05105s A0E;
    public final C0680Cw A0F;

    public LE(C1477dL c1477dL, List<C1444cn> list, AbstractC1752hy abstractC1752hy, US us, C1020Qc c1020Qc, InterfaceC1208Xn interfaceC1208Xn, String str, C05105s c05105s, C0680Cw c0680Cw) {
        this.A0A = c1477dL;
        this.A0B = us;
        this.A0C = c1020Qc;
        this.A09 = c1020Qc.A11();
        this.A04 = c1020Qc.A1B();
        this.A0D = c1020Qc.A1A();
        this.A03 = interfaceC1208Xn;
        this.A08 = abstractC1752hy;
        this.A06 = list;
        this.A05 = str;
        this.A0E = c05105s;
        this.A0F = c0680Cw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.QC
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final FD A0F(ViewGroup viewGroup, int i2) {
        return new FD(AbstractC1278a6.A00(new C1314ah(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0T(this.A0F).A0O(this.A0C).A0W(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A21());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.QC
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(FD fd, int i2) {
        C1444cn c1444cn = this.A06.get(i2);
        fd.A0q(this.A04);
        fd.A0p(c1444cn, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.instagram.common.viewpoint.core.QC
    public final int A0B() {
        return this.A06.size();
    }

    public final void A0O(int i2, int i8, int i9) {
        boolean needsUpdate = i2 != this.A00;
        this.A00 = i2;
        this.A02 = i8;
        this.A01 = i9;
        if (needsUpdate) {
            A0G();
        }
    }

    public final void A0P(C1550eX c1550eX) {
        this.A04 = c1550eX;
    }
}

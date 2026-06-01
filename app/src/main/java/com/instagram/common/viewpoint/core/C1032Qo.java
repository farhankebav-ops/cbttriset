package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1032Qo {
    public static byte[] A02;
    public static String[] A03 = {"TTkBeT", "dgqPpyxawDBTokVKz6usds7DGGljbLlG", "Om", "1", "lOfLhIubd0jJyTpTkNltmpZf14oHCLV9", "yX0qRkYxaN2cv8t3SuJSwpxSeia", "n9D4XHOOTGgVdLWa6Wuko3wZCERnKgc", "NKR9b6EIrIhl49GaATLNKeLdYiLud"};
    public final C1674gb<AbstractC1024Qg, C1030Qm> A00 = new C1674gb<>();
    public final OS<AbstractC1024Qg> A01 = new OS<>();

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {78, 118, 112, 119, 35, 115, 113, 108, 117, 106, 103, 102, 35, 101, 111, 98, 100, 35, 83, 81, 70, 35, 108, 113, 35, 83, 76, 80, 87};
        if (A03[1].charAt(27) != 'j') {
            throw new RuntimeException();
        }
        A03[0] = "DMTuNl";
        A02 = bArr;
    }

    static {
        A02();
    }

    private QJ A00(AbstractC1024Qg abstractC1024Qg, int i2) {
        C1030Qm c1030QmA0B;
        QJ info;
        int iA08 = this.A00.A08(abstractC1024Qg);
        if (iA08 >= 0 && (c1030QmA0B = this.A00.A0B(iA08)) != null) {
            int i8 = c1030QmA0B.A00;
            if (A03[2].length() != 2) {
                throw new RuntimeException();
            }
            A03[2] = "6x";
            if ((i8 & i2) != 0) {
                int i9 = c1030QmA0B.A00;
                int index = ~i2;
                c1030QmA0B.A00 = i9 & index;
                if (i2 == 4) {
                    info = c1030QmA0B.A02;
                } else if (i2 == 8) {
                    info = c1030QmA0B.A01;
                } else {
                    throw new IllegalArgumentException(A01(0, 29, 14));
                }
                int index2 = c1030QmA0B.A00;
                if ((index2 & 12) == 0) {
                    this.A00.A0A(iA08);
                    C1030Qm.A02(c1030QmA0B);
                }
                return info;
            }
        }
        return null;
    }

    public final QJ A03(AbstractC1024Qg abstractC1024Qg) {
        return A00(abstractC1024Qg, 8);
    }

    public final QJ A04(AbstractC1024Qg abstractC1024Qg) {
        return A00(abstractC1024Qg, 4);
    }

    public final AbstractC1024Qg A05(long j) {
        return this.A01.A08(j);
    }

    public final void A06() {
        this.A00.clear();
        this.A01.A09();
    }

    public final void A07() {
        C1030Qm.A01();
    }

    public final void A08(long j, AbstractC1024Qg abstractC1024Qg) {
        this.A01.A0B(j, abstractC1024Qg);
    }

    public final void A09(AbstractC1024Qg abstractC1024Qg) {
        C1030Qm c1030QmA00 = this.A00.get(abstractC1024Qg);
        if (c1030QmA00 == null) {
            c1030QmA00 = C1030Qm.A00();
            this.A00.put(abstractC1024Qg, c1030QmA00);
        }
        c1030QmA00.A00 |= 1;
    }

    public final void A0A(AbstractC1024Qg abstractC1024Qg) {
        C1030Qm c1030Qm = this.A00.get(abstractC1024Qg);
        if (c1030Qm == null) {
            return;
        }
        c1030Qm.A00 &= -2;
    }

    public final void A0B(AbstractC1024Qg abstractC1024Qg) {
        int iA06 = this.A01.A06() - 1;
        while (true) {
            if (iA06 < 0) {
                break;
            }
            if (abstractC1024Qg == this.A01.A07(iA06)) {
                this.A01.A0A(iA06);
                break;
            }
            iA06--;
        }
        C1030Qm info = this.A00.remove(abstractC1024Qg);
        if (info != null) {
            C1030Qm.A02(info);
        }
    }

    public final void A0C(AbstractC1024Qg abstractC1024Qg) {
        A0A(abstractC1024Qg);
    }

    public final void A0D(AbstractC1024Qg abstractC1024Qg, QJ qj) {
        C1030Qm c1030QmA00 = this.A00.get(abstractC1024Qg);
        if (c1030QmA00 == null) {
            c1030QmA00 = C1030Qm.A00();
            this.A00.put(abstractC1024Qg, c1030QmA00);
        }
        c1030QmA00.A00 |= 2;
        c1030QmA00.A02 = qj;
    }

    public final void A0E(AbstractC1024Qg abstractC1024Qg, QJ qj) {
        C1030Qm c1030QmA00 = this.A00.get(abstractC1024Qg);
        if (c1030QmA00 == null) {
            c1030QmA00 = C1030Qm.A00();
            this.A00.put(abstractC1024Qg, c1030QmA00);
        }
        c1030QmA00.A01 = qj;
        c1030QmA00.A00 |= 8;
    }

    public final void A0F(AbstractC1024Qg abstractC1024Qg, QJ qj) {
        C1030Qm c1030QmA00 = this.A00.get(abstractC1024Qg);
        if (c1030QmA00 == null) {
            c1030QmA00 = C1030Qm.A00();
            this.A00.put(abstractC1024Qg, c1030QmA00);
        }
        c1030QmA00.A02 = qj;
        c1030QmA00.A00 |= 4;
    }

    public final void A0G(InterfaceC1031Qn interfaceC1031Qn) {
        for (int size = this.A00.size() - 1; size >= 0; size--) {
            AbstractC1024Qg abstractC1024QgA09 = this.A00.A09(size);
            C1030Qm c1030QmA0A = this.A00.A0A(size);
            if ((c1030QmA0A.A00 & 3) == 3) {
                interfaceC1031Qn.AJo(abstractC1024QgA09);
            } else {
                int index = c1030QmA0A.A00;
                if ((index & 1) != 0) {
                    if (c1030QmA0A.A02 == null) {
                        interfaceC1031Qn.AJo(abstractC1024QgA09);
                    } else {
                        interfaceC1031Qn.AGR(abstractC1024QgA09, c1030QmA0A.A02, c1030QmA0A.A01);
                    }
                } else if ((c1030QmA0A.A00 & 14) == 14) {
                    interfaceC1031Qn.AGP(abstractC1024QgA09, c1030QmA0A.A02, c1030QmA0A.A01);
                } else if ((c1030QmA0A.A00 & 12) == 12) {
                    interfaceC1031Qn.AGT(abstractC1024QgA09, c1030QmA0A.A02, c1030QmA0A.A01);
                } else {
                    int index2 = c1030QmA0A.A00;
                    if ((index2 & 4) != 0) {
                        interfaceC1031Qn.AGR(abstractC1024QgA09, c1030QmA0A.A02, null);
                    } else {
                        int index3 = c1030QmA0A.A00;
                        if ((index3 & 8) != 0) {
                            QJ qj = c1030QmA0A.A02;
                            if (A03[4].charAt(6) == 'y') {
                                throw new RuntimeException();
                            }
                            A03[7] = "pRTOxDzzIVV0VuKMKqyuKOShfW9n8";
                            interfaceC1031Qn.AGP(abstractC1024QgA09, qj, c1030QmA0A.A01);
                        } else {
                            continue;
                        }
                    }
                }
            }
            C1030Qm.A02(c1030QmA0A);
        }
    }

    public final boolean A0H(AbstractC1024Qg abstractC1024Qg) {
        C1030Qm record = this.A00.get(abstractC1024Qg);
        return (record == null || (record.A00 & 1) == 0) ? false : true;
    }

    public final boolean A0I(AbstractC1024Qg abstractC1024Qg) {
        C1030Qm record = this.A00.get(abstractC1024Qg);
        return (record == null || (record.A00 & 4) == 0) ? false : true;
    }
}

package com.instagram.common.viewpoint.core;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC05547k extends AbstractC2074nW<C05537j, AbstractC05527i, C1892kM> implements InterfaceC1893kN {
    public static byte[] A01;
    public static String[] A02 = {"gN8", "v0q6HziqC5r28rLi1ZsQmD2OK0fgspik", "XftI4eRfVNg33Op0jQPz8O6PbCkMHbWE", "SdzNGuU6dc81VqISrLBD", "AmzsDcSyCxTNGO", "BjhKb3Az99p878kvj1gxEmyEzdFIjRD", "VkdZ1nUYKY17rCLbk1Npuh3A0WHSXOLE", "WDjquUi0atGhsKhHWhKEDeyGOzHRt12i"};
    public final String A00;

    public static String A0L(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = (byte) ((bArrCopyOfRange[i10] - i9) - 100);
            if (A02[0].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "7OO3CpMfw2stGNBOXFHDwltwdlKTQaUN";
            strArr[7] = "XdJDd6VP529P2X7c3MAKusUlyNrjc2WF";
            bArrCopyOfRange[i10] = b8;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        if (A02[0].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[5] = "V56IsTeJwH5mFHCmn3IS5snx7jCRlGG";
        strArr[4] = "owU73l6HwKvTqc";
        A01 = new byte[]{28, 53, 44, 63, 55, 44, 42, 59, 44, 43, -25, 43, 44, 42, 54, 43, 44, -25, 44, 57, 57, 54, 57};
    }

    public abstract J7 A0g(byte[] bArr, int i2, boolean z2) throws C1892kM;

    static {
        A0M();
    }

    public AbstractC05547k(String str) {
        super(new C05537j[2], new AbstractC05527i[2]);
        this.A00 = str;
        A0d(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.0w] */
    @Override // com.instagram.common.viewpoint.core.AbstractC2074nW
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final C03860w A0c() {
        return new AbstractC05527i(this) { // from class: com.facebook.ads.redexgen.X.0w
            public final AbstractC05547k A00;

            {
                this.A00 = this;
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC05527i, com.instagram.common.viewpoint.core.AbstractC2075nX
            public final void A0B() {
                this.A00.A0h(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC2074nW
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public final C1892kM A0Y(C05537j c05537j, AbstractC05527i abstractC05527i, boolean z2) {
        try {
            ByteBuffer inputData = (ByteBuffer) C3M.A01(c05537j.A02);
            abstractC05527i.A0C(c05537j.A01, A0g(inputData.array(), inputData.limit(), z2), c05537j.A00);
            abstractC05527i.A01(Integer.MIN_VALUE);
            return null;
        } catch (C1892kM e) {
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC2074nW
    /* JADX INFO: renamed from: A0J, reason: merged with bridge method [inline-methods] */
    public final C1892kM A0Z(Throwable th) {
        return new C1892kM(A0L(0, 23, 99), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC2074nW
    /* JADX INFO: renamed from: A0K, reason: merged with bridge method [inline-methods] */
    public final C05537j A0a() {
        return new C05537j();
    }

    public final void A0h(AbstractC05527i abstractC05527i) {
        super.A0f(abstractC05527i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1893kN
    public final void AIx(long j) {
    }
}

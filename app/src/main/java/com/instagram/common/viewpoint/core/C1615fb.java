package com.instagram.common.viewpoint.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.ads.NativeAd;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1615fb implements S7 {
    public static String[] A02 = {"XqTxzibSN1zAjaiM9LtVSqsxSG", "xqN5bEwB0Nihon7KSuA", "FVkOY26I4teb9ftOLmk9A45ZS3TS2DIY", "wzTDEcMKt7VvW9W8eKeIWksTnJ0tE", "iGRCr9OHUARnshCNCmKS3XNzEIA09VDm", "MJLgHxMJm3Fw", ExifInterface.LATITUDE_SOUTH, "m77T1m6dtAhGTcgbhkAg"};
    public final List<C1773iN> A00;
    public final /* synthetic */ C1614fa A01;

    public C1615fb(C1614fa c1614fa, List<C1773iN> list) {
        this.A01 = c1614fa;
        this.A00 = list;
    }

    private void A00() {
        this.A01.A00.A05(true);
        this.A01.A00.A02();
        this.A01.A00.A03(0);
        Iterator<C1773iN> it = this.A00.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A02[4].charAt(3) == 'E') {
                throw new RuntimeException();
            }
            A02[0] = "GKxyFdZ7ADxfGJ";
            if (zHasNext) {
                C1020Qc c1020Qc = new C1020Qc(this.A01.A01, it.next(), null, C1020Qc.A0K(), this.A01.A00.A01());
                if (c1020Qc.A0z() != null && c1020Qc.A0z().A0F() != null) {
                    ((AbstractC1718hL) c1020Qc.A0z().A0F()).A00(c1020Qc);
                }
                this.A01.A00.A04(new NativeAd(this.A01.A01, c1020Qc));
            } else {
                AbstractC1155Vk.A00(new C1616fc(this));
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACh() {
        A00();
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACq() {
        A00();
    }
}

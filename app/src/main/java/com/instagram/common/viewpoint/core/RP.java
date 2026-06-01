package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class RP extends AsyncTask<RR, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"Er5x4Nf8UA9tVLePD2EX", "DtYF9X90t5u", "I941X6fzqWLmgCmjxes", "iBgQ7OI2DFUGAw4NUel9vSUdaaiAzSqO", "QcmiodlDN7oY3kgnmckrDpvdiERsjn9V", "z", "b", "KLyCCmbDECCjA8c7XM6gY8wQDdZdMwfW"};
    public final RQ A00;
    public final C1477dL A01;
    public final boolean A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final Drawable A00(RR... rrArr) throws Throwable {
        if (!AbstractC1156Vl.A02(this) && rrArr != null) {
            try {
                if (rrArr.length >= 1) {
                    String str = rrArr[0].A01;
                    String str2 = rrArr[0].A00;
                    Bitmap bitmapA0O = null;
                    try {
                        bitmapA0O = new SF(this.A01).A0O(str, -1, -1);
                    } catch (Throwable th) {
                        this.A01.A08().AAy(A01(0, 7, 4), AbstractC1090Sv.A1V, new C1091Sw(th));
                    }
                    if (bitmapA0O != null) {
                        return C1020Qc.A05(this.A01, bitmapA0O, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                AbstractC1156Vl.A00(th2, this);
                return null;
            }
        }
        return null;
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            int i11 = (bArrCopyOfRange[i10] ^ i9) ^ 36;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A04[2] = "XzO4PGfz9rpTObXE3Krp6";
            bArrCopyOfRange[i10] = (byte) i11;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 69, 78, 69, 82, 73, 67};
    }

    static {
        A02();
    }

    public RP(C1477dL c1477dL, RQ rq, boolean z2) {
        this.A01 = c1477dL;
        this.A00 = rq;
        this.A02 = z2;
    }

    public /* synthetic */ RP(C1477dL c1477dL, RQ rq, boolean z2, C1613fZ c1613fZ) {
        this(c1477dL, rq, z2);
    }

    private final void A03(Drawable drawable) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.ADU(drawable);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Drawable doInBackground(RR[] rrArr) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return null;
        }
        try {
            return A00(rrArr);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}

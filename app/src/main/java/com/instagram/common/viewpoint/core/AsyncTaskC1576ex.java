package com.instagram.common.viewpoint.core;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC1576ex extends AsyncTask<String, Void, C1577ey> {
    public static byte[] A05;
    public static String[] A06 = {"naFNcZuGe", "C9JAYYW4", "8H9N3VrVfLlJ9IUdYMoO", "YylQBw7bkupjVtNcwFivzoGwGcTau", "utPcy8I9vNMcCezdgtn", "ehhspVm5", "7sb5kaLRz1R8p", "m"};
    public static final String A07;
    public static final Set<String> A08;
    public SQ A00;
    public InterfaceC1555ec A01;
    public InterfaceC1575ew A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final C1577ey A00(String... strArr) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return null;
        }
        String[] strArr2 = A06;
        if (strArr2[4].length() == strArr2[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr3 = A06;
        strArr3[3] = "OBWBCzNqNMhSgl0vUrcBODbII9DBW";
        strArr3[2] = "nuEeWi2rsMih0JuNdplL";
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A08.contains(str)) {
                String strA02 = A02(str);
                if (this.A03 != null && !this.A03.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        strA02 = A03(strA02, entry.getKey(), entry.getValue());
                    }
                }
                int i2 = 1;
                while (true) {
                    int i8 = i2 + 1;
                    if (i2 > 2) {
                        return null;
                    }
                    if (A06(strA02)) {
                        return new C1577ey(this.A01);
                    }
                    i2 = i8;
                }
            }
            return null;
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            return null;
        }
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{75, 62, 43, 105, 56, 15, 15, 18, 15, 93, 18, 13, 24, 19, 20, 19, 26, 93, 8, 15, 17, 71, 93, 15, 0, 15, 2, 1, 9, 54, 45, 52, 52};
    }

    static {
        A04();
        A07 = AsyncTaskC1576ex.class.getSimpleName();
        A08 = new HashSet();
        A08.add(A01(0, 1, 15));
        A08.add(A01(29, 4, 63));
    }

    public AsyncTaskC1576ex(SQ sq) {
        this(sq, null, null);
    }

    public AsyncTaskC1576ex(SQ sq, Map<String, String> extraData) {
        this(sq, extraData, null);
    }

    public AsyncTaskC1576ex(SQ sq, Map<String, String> extraData, Map<String, String> postData) {
        this.A00 = sq;
        this.A03 = extraData != null ? new HashMap(extraData) : null;
        this.A04 = postData != null ? new HashMap(postData) : null;
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 9), AbstractC1186Wr.A01(this.A00.A04().A6o()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String strA01 = A01(3, 1, 49);
        if (str.contains(strA01)) {
            strA01 = A01(1, 1, 127);
        }
        StringBuilder sbAppend = new StringBuilder().append(str).append(strA01).append(str2);
        String prepend = A01(2, 1, 113);
        StringBuilder sbAppend2 = sbAppend.append(prepend);
        String prepend2 = URLEncoder.encode(str3);
        return sbAppend2.append(prepend2).toString();
    }

    private final void A05(C1577ey response) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (this.A02 != null) {
                this.A02.AGS(response);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }

    private boolean A06(String str) {
        InterfaceC1555ec interfaceC1555ecAGC;
        InterfaceC1556ed interfaceC1556edA00 = C1574ev.A00(this.A00);
        try {
            if (this.A04 == null || this.A04.size() == 0) {
                interfaceC1555ecAGC = interfaceC1556edA00.AGC(str, new C1570er());
            } else {
                C1570er params = new C1570er();
                params.A05(this.A04);
                interfaceC1555ecAGC = interfaceC1556edA00.AGD(str, params.A08());
            }
            this.A01 = interfaceC1555ecAGC;
        } catch (Exception e) {
            Log.e(A07, A01(4, 19, 26) + str, e);
        }
        return this.A01 != null && this.A01.A94() == 200;
    }

    public final void A07(InterfaceC1575ew interfaceC1575ew) {
        this.A02 = interfaceC1575ew;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ C1577ey doInBackground(String[] strArr) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        if (this.A02 != null) {
            this.A02.AGQ();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(C1577ey c1577ey) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            A05(c1577ey);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}

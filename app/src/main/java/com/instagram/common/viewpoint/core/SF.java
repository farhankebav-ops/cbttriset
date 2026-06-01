package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.vungle.ads.internal.protos.Sdk;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SF {
    public static InterfaceC0880Kp A0A;
    public static List<String> A0B;
    public static byte[] A0C;
    public static String[] A0D = {"9sbbD15", "Lu4K49mlxrSXSmjNh7fbv8QTyeXNNeG", "dxmg93Ac1Ci0DpKcQcYnCSB5QhHSt8Hl", "k6rgF4fsXLHTj2vl", "7FEQyJVT", "NWpMXisSbHx8hQWP", "4pbn9SiXGJE3zFdxdKEeQNSdsbhvbmq3", "cv"};
    public static final String A0E;
    public static final Map<String, C0886Kv> A0F;
    public static final Map<String, SH> A0G;
    public long A00;
    public C1120Ua A01;
    public final SG A03;
    public final SQ A04;
    public final boolean A08;
    public final boolean A09;
    public final Map<String, Bitmap> A07 = Collections.synchronizedMap(new HashMap());
    public final Handler A02 = new Handler(Looper.getMainLooper());
    public final List<Callable<Boolean>> A05 = new ArrayList();
    public final List<Callable<Boolean>> A06 = new ArrayList();

    public static String A08(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 92);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static AtomicBoolean A0D(ArrayList<Callable<Boolean>> arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator<Callable<Boolean>> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(XU.A02().submit(it.next()));
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        try {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Boolean bool = (Boolean) ((Future) it2.next()).get();
                atomicBoolean.set(atomicBoolean.get() && bool != null && bool.booleanValue());
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e(A0E, A08(86, 42, 126), e);
            atomicBoolean.set(false);
        }
        return atomicBoolean;
    }

    public static void A0F() {
        A0C = new byte[]{121, 122, 45, 42, 126, 126, 41, 126, 91, 91, 88, 87, 86, 10, 91, 88, 34, 33, 46, 114, 38, 117, 113, 36, 11, 41, 43, 32, 45, 104, 59, 60, 41, 58, 60, 45, 44, 102, 100, 70, 68, 79, 78, 73, 64, 7, 68, 72, 74, 87, 75, 66, 83, 66, 63, 29, 31, 20, 21, 18, 27, 92, 26, 29, 21, 16, 25, 24, 69, 103, 101, 110, 111, 104, 97, 38, 117, 114, 103, 116, 114, 99, 98, 40, 40, 40, 103, 90, 65, 71, 82, 86, 75, 77, 76, 2, 85, 74, 75, 78, 71, 2, 71, 90, 71, 65, 87, 86, 75, 76, 69, 2, 65, 67, 65, 74, 71, 2, 70, 77, 85, 76, 78, 77, 67, 70, 81, 12, 66, 64, 66, 73, 68, 98, 78, 76, 81, 77, 68, 85, 72, 78, 79, 105, 78, 78, 74, 111, 109, 111, 100, 105, 74, 109, 101, 96, 121, 126, 105, 68, 99, 99, 103, 104, 117, 104, 110, 120, 121, 104, 101, 102, 104, 109, 119, 116, 122, 127, 68, 111, 114, 118, 126, 68, 118, 104, 89, 66, 69, 93};
    }

    static {
        A0F();
        A0E = SF.class.getSimpleName();
        A0F = Collections.synchronizedMap(new HashMap());
        A0G = Collections.synchronizedMap(new HashMap());
    }

    public SF(SQ sq) {
        this.A04 = sq;
        this.A03 = SG.A06(sq.A02());
        this.A08 = U7.A2i(sq);
        this.A09 = U7.A2r(sq, C1532eF.A03());
    }

    public static synchronized InterfaceC0880Kp A03(C1451cu c1451cu) {
        if (A0A == null) {
            A0A = AbstractC0881Kq.A00(c1451cu, new C0887Kw().A00(U7.A06(c1451cu)).A02(c1451cu.A05().AAF()).A01(-1).A03(U7.A0p(c1451cu)).A04(U7.A2q(c1451cu)).A05(), A05(c1451cu));
        }
        return A0A;
    }

    public static C0886Kv A04(SQ sq, String str) {
        C0886Kv c0886Kv = A0F.get(str);
        if (SI.A06(sq) && c0886Kv != null) {
            C0886Kv storedCacheData = new C0886Kv(c0886Kv);
            return storedCacheData;
        }
        C0886Kv storedCacheData2 = new C0886Kv(str);
        return storedCacheData2;
    }

    public static C1503dl A05(C1451cu c1451cu) {
        return new C1503dl(c1451cu);
    }

    public static synchronized List<String> A09(SQ sq) {
        if (A0B == null) {
            A0B = new ArrayList();
            A0J(A0B, sq);
        }
        return A0B;
    }

    public static /* synthetic */ Map A0A() {
        Map<String, SH> map = A0G;
        if (A0D[7].length() == 16) {
            throw new RuntimeException();
        }
        A0D[6] = "WjQPXn0MHZbTNsTxKlY7B5aUAaJR9kiv";
        return map;
    }

    public static void A0H(SQ sq, String str) {
        if (SI.A06(sq) && !TextUtils.isEmpty(str)) {
            SH sh = A0G.get(str);
            if (A0D[7].length() == 16) {
                throw new RuntimeException();
            }
            A0D[6] = "a10tGuQmEwUEP0sxRmqxEmZkNnUikCvX";
            if (sh != null) {
                sh.A00 = A08(186, 4, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
                C1451cu c1451cuA02 = sq.A02();
                C1536eJ c1536eJA06 = C1536eJ.A06(c1451cuA02);
                String strA09 = C1536eJ.A09(c1451cuA02, WQ.A00(str));
                if (strA09 == null) {
                    strA09 = str;
                }
                SI.A04(sq, sh, c1536eJA06.A0J(strA09));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(UZ uz) {
        if (this.A01 == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(A08(174, 12, 71), XG.A05(this.A00));
        this.A01.A04(uz, map);
    }

    public static void A0J(List<String> cacheDirs, SQ sq) {
        A0K(cacheDirs, C1832jO.A01(sq));
        A0K(cacheDirs, SG.A07(sq));
    }

    public static void A0K(List<String> list, File file) {
        String path;
        if (file == null || (path = file.getPath()) == null) {
            return;
        }
        String path2 = A08(0, 0, 103);
        if (path != path2) {
            Locale locale = Locale.getDefault();
            String path3 = A0D[4];
            if (path3.length() == 2) {
                throw new RuntimeException();
            }
            A0D[4] = "BAOa9xP";
            String path4 = path.toLowerCase(locale);
            list.add(path4);
        }
    }

    public final float A0M(String str) {
        return this.A03.A0E(str);
    }

    public final Bitmap A0N(String str) {
        return this.A07.get(str);
    }

    public final Bitmap A0O(String str, int i2, int i8) {
        if (this.A08) {
            C0886Kv c0886KvA04 = A04(this.A04, str);
            c0886KvA04.A03 = A08(186, 4, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
            c0886KvA04.A01 = i8;
            c0886KvA04.A00 = i2;
            return A03(this.A04.A02()).AHu(c0886KvA04, true).A00();
        }
        return this.A03.A0G(this.A04, str, i2, i8, A08(170, 4, 85));
    }

    public final File A0P(String str) {
        C0886Kv c0886KvA04 = A04(this.A04, str);
        c0886KvA04.A03 = A08(186, 4, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        return A03(this.A04.A02()).AHv(c0886KvA04);
    }

    public final File A0Q(String str) {
        if (this.A08) {
            return A0P(str);
        }
        return this.A03.A0H(str);
    }

    public final String A0R(String str) {
        if (this.A08) {
            return A0S(str);
        }
        return this.A03.A0I(str);
    }

    public final String A0S(String str) {
        C0886Kv c0886KvA04 = A04(this.A04, str);
        c0886KvA04.A03 = A08(186, 4, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        String strAHx = A03(this.A04.A02()).AHx(c0886KvA04);
        return strAHx != null ? strAHx : str;
    }

    public final String A0T(String str) {
        if (this.A09) {
            A0H(this.A04, str);
            return str;
        }
        return A0S(str);
    }

    public final void A0U() {
        VF.A05(A08(128, 19, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), A08(38, 16, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A08(8, 8, 50));
    }

    public final void A0V() {
        VF.A05(A08(147, 16, 80), A08(54, 14, 32), A08(16, 8, 75));
    }

    public final void A0W() {
        this.A07.clear();
    }

    public final void A0X(S7 s7, S8 s8) {
        VF.A05(A08(163, 7, 81), A08(68, 18, 90), A08(0, 8, 20));
        this.A00 = System.currentTimeMillis();
        SI.A02(this.A04, s8, SI.A07, A08(24, 14, 20), -1L);
        XU.A03().execute(new C1504dm(this, new ArrayList(this.A05), s8, s7, new ArrayList(this.A06)));
        this.A05.clear();
        this.A06.clear();
    }

    public final void A0Y(SB sb) {
        this.A05.add(new SC(this, sb));
    }

    public final void A0Z(SB sb) {
        sb.A05 = true;
        this.A06.add(new SC(this, sb));
    }

    public final void A0a(SB sb) {
        sb.A05 = true;
        if (this.A09) {
            this.A06.add(new SA(this, sb));
        } else {
            this.A06.add(new SC(this, sb));
        }
    }

    public final void A0b(SB sb) {
        if (this.A09) {
            this.A05.add(new SA(this, sb));
        } else {
            this.A05.add(new SC(this, sb));
        }
    }

    public final void A0c(SD sd) {
        SE se = new SE(this, sd);
        if (!sd.A03) {
            this.A05.add(se);
        } else {
            this.A06.add(se);
        }
    }

    public final void A0d(SD sd) {
        sd.A03 = true;
        A0c(sd);
    }

    public final void A0e(C1120Ua c1120Ua) {
        this.A01 = c1120Ua;
    }
}

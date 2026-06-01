package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1773iN implements MK, MP {
    public static byte[] A0C;
    public static String[] A0D = {"axrzCdv0FVVdCRJ2G5bzsKW6gzdnjkd", "bTiRlDodVRVUvI5asAv5OrmPjdR2kQoL", "0F0kzsbgf", "9OhtkIX5JTQzZAf31yyS0L6RFdCICf7G", "a5UohLNEI7iVSyxaj4LiJgBVL6R7sy1L", "7foeJoxu0TAivWs2uWCvQbVxkZa0ERHH", "EHJaWrfXkxbvFmDXjSXoaOL8kiGJisUm", "EwwWMCMqNj"};
    public static final String A0E;
    public int A00;
    public C1761iB A01;
    public InterfaceC0921Me A02;
    public C0922Mf A03;
    public InterfaceC1134Uo A04;
    public List<C1020Qc> A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C1477dL A0A;
    public final String A0B;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 27);
            if (A0D[0].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "ypXQoKhxcHRWJrqojmqi5sMtZ7xfThaX";
            strArr[6] = "2LOy6kLjroQDrfbojOuFHdbjLd88ORkx";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{55, 18, 23, 6, 2, 19, 4, 86, 23, 26, 4, 19, 23, 18, 15, 86, 26, 25, 23, 18, 19, 18, 86, 18, 23, 2, 23, 2, 45, 40, 34, 42, 97, 41, 32, 49, 49, 36, 47, 36, 37, 97, 46, 47, 97, 45, 46, 34, 42, 50, 34, 51, 36, 36, 47, 97, 32, 37, 87, 120, 125, 119, 127, 52, 120, 123, 115, 115, 113, 112, 119, 117, 120, 120, 113, 102, 64, 109, 100, 113, 46, 44, 63, 41, 46, 35, 57, 85, 87, 68, 82, 95, 88, 82, 114, 101, 58, 53, 32, 61, 34, 49, 12, 17, 30, 15, 12, 23, 16, 11, 100, 127, 120, 96, 100, 116, 88, 117, 33, 62, 50, 32};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C1774iO(this, map2, A03(map)), this.A01.A07() * 1000);
        } catch (Exception unused) {
        }
    }

    static {
        A04();
        A0E = C1773iN.class.getSimpleName();
    }

    public C1773iN(C1477dL c1477dL) {
        this(c1477dL, new C1761iB());
    }

    public C1773iN(C1477dL c1477dL, C1761iB c1761iB) {
        this.A0B = UUID.randomUUID().toString();
        this.A00 = 200;
        this.A01 = c1761iB;
        this.A0A = c1477dL;
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap map2 = new HashMap();
        String strA02 = A02(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 4, 76);
        if (map.containsKey(strA02)) {
            map2.put(strA02, map.get(strA02));
        }
        String strA022 = A02(102, 8, 100);
        if (map.containsKey(strA022)) {
            map2.put(strA022, map.get(strA022));
        }
        return map2;
    }

    private void A05(C1761iB c1761iB) {
        if (!this.A06) {
            this.A01 = c1761iB;
            List<C1761iB> listA0c = this.A01.A0c();
            if (listA0c != null && listA0c.size() > 0) {
                int size = listA0c.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    C1773iN adapter = new C1773iN(this.A0A);
                    adapter.A05(listA0c.get(i2));
                    arrayList.add(new C1020Qc(this.A0A, adapter, (TF) null, this.A04));
                }
                this.A05 = arrayList;
            }
            this.A06 = true;
            this.A07 = A07();
            return;
        }
        throw new IllegalStateException(A02(0, 27, 109));
    }

    private boolean A07() {
        return (!(this.A01.A0e() || TextUtils.isEmpty(this.A01.A0V())) || (!TextUtils.isEmpty(this.A01.A0S()) && this.A01.A0e())) && (this.A01.A0F() != null || this.A01.A0e()) && (this.A01.A0E() != null || A8c() == AdPlacementType.NATIVE_BANNER);
    }

    public final int A08() {
        return this.A01.A02();
    }

    public final int A09() {
        return this.A01.A05();
    }

    public final int A0A() {
        int iA06 = this.A01.A06();
        if (iA06 < 0 || iA06 > 100) {
            return 0;
        }
        return iA06;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01.A08();
    }

    public final int A0D() {
        return this.A01.A09();
    }

    public final C1761iB A0E() {
        return this.A01;
    }

    public final InterfaceC0921Me A0F() {
        return this.A02;
    }

    public final String A0G() {
        return this.A01.A0Y();
    }

    public final List<C1020Qc> A0H() {
        if (!A0R()) {
            return null;
        }
        return this.A05;
    }

    public final void A0I() {
        if (!this.A09) {
            String strA0Z = A0E().A0Z();
            if (strA0Z != null) {
                US usA0A = this.A0A.A0A();
                String[] strArr = A0D;
                if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "MHNGbcOaMZIG61BxjY7eI95TuiNlx0Gr";
                strArr2[6] = "kvjKrlZQ6RBIZv1Jj5ESJw4vFB55PB3z";
                usA0A.AGF(strA0Z);
            }
            this.A09 = true;
        }
    }

    public final void A0J() {
        if (this.A05 != null && !this.A05.isEmpty()) {
            Iterator<C1020Qc> it = this.A05.iterator();
            while (it.hasNext()) {
                it.next().unregisterView();
            }
        }
    }

    public final void A0K(InterfaceC0921Me interfaceC0921Me) {
        this.A02 = interfaceC0921Me;
    }

    public final void A0L(C1477dL c1477dL, InterfaceC0921Me interfaceC0921Me, US us, NU nu, InterfaceC1134Uo interfaceC1134Uo) {
        int iA06;
        this.A02 = interfaceC0921Me;
        this.A04 = interfaceC1134Uo;
        JSONObject jSONObjectA03 = nu.A03();
        TF tfA01 = nu.A01();
        if (tfA01 != null) {
            iA06 = tfA01.A06();
        } else {
            iA06 = 200;
        }
        this.A00 = iA06;
        A05(AbstractC0923Mg.A00(c1477dL, jSONObjectA03, AbstractC1186Wr.A02(jSONObjectA03, A02(94, 2, 10))));
        if (ML.A06(c1477dL, this, us)) {
            c1477dL.A0F().A4u();
            interfaceC0921Me.AEK(this, V1.A00(AdErrorType.NO_FILL));
        } else {
            if (interfaceC0921Me != null) {
                interfaceC0921Me.AEH(this);
            }
            this.A03 = new C0922Mf(c1477dL, this.A0B, this, interfaceC0921Me);
            this.A03.A02();
        }
    }

    public final void A0M(Map<String, String> extraData) {
        N3 n3A21;
        if (!A0R()) {
            return;
        }
        boolean shouldBlockLockscreenClicks = U7.A20(this.A0A);
        if (shouldBlockLockscreenClicks) {
            boolean shouldBlockLockscreenClicks2 = XQ.A03(extraData);
            if (shouldBlockLockscreenClicks2) {
                Log.e(A0E, A02(27, 31, 90));
                return;
            }
        }
        HashMap map = new HashMap();
        if (extraData != null) {
            map.putAll(extraData);
        }
        boolean shouldBlockLockscreenClicks3 = this.A01.A0e();
        if (shouldBlockLockscreenClicks3) {
            map.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
            map.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
        }
        map.put(A02(70, 10, 15), AdPlacementType.NATIVE.name());
        map.put(A02(110, 8, 10), this.A0B);
        C1477dL c1477dL = this.A0A;
        US usA0A = this.A0A.A0A();
        String strA7G = this.A01.A7G();
        Uri uriA0B = this.A01.A0B();
        if (this.A01.A0C() != null) {
            n3A21 = this.A01.A0C().A21();
        } else {
            n3A21 = null;
        }
        MH mhA00 = MI.A00(c1477dL, usA0A, strA7G, uriA0B, map, n3A21);
        ME meA0G = ME.A09;
        if (mhA00 != null) {
            meA0G = mhA00.A0G(null);
        }
        if (meA0G != ME.A06) {
            WX.A04(this.A0A, A02(58, 12, 15));
            if (this.A02 != null) {
                this.A02.AEG(this);
            }
        }
    }

    public final void A0N(Map<String, String> extraData) {
        this.A0A.A0A().AAs(this.A01.A7G(), extraData);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0O(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1773iN.A0O(java.util.Map):void");
    }

    public final boolean A0P() {
        return true;
    }

    public final boolean A0Q() {
        return A0R() && this.A01.A0B() != null;
    }

    public final boolean A0R() {
        return this.A06 && this.A07;
    }

    public final boolean A0S() {
        return this.A01.A0d();
    }

    public final boolean A0T() {
        return U7.A1W(this.A0A) && A0R() && this.A01.A0f();
    }

    public final boolean A0U() {
        return U7.A1W(this.A0A) && A0R() && this.A01.A0g();
    }

    @Override // com.instagram.common.viewpoint.core.MK
    public final String A7G() {
        return this.A01.A7G();
    }

    @Override // com.instagram.common.viewpoint.core.MK
    public final Collection<String> A7h() {
        return A0E().A7h();
    }

    @Override // com.instagram.common.viewpoint.core.MK
    public final MJ A8C() {
        return A0E().A8C();
    }

    public AdPlacementType A8c() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final boolean AJa() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final void onDestroy() {
        if (this.A03 != null) {
            C0922Mf c0922Mf = this.A03;
            String[] strArr = A0D;
            if (strArr[4].charAt(16) != strArr[6].charAt(16)) {
                throw new RuntimeException();
            }
            A0D[7] = "xLZjaQWgus";
            c0922Mf.A03();
        }
    }
}

package com.instagram.common.viewpoint.core;

import android.view.View;
import androidx.work.WorkRequest;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.72, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass72 extends AbstractC1723hQ {
    public static byte[] A03;
    public long A00;
    public View A01;
    public C6M A02;

    static {
        A05();
    }

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{20, 23, 38, -15, -16, -3, -3, -12, 1, -18, 1, -12, -11, 1, -12, 2, -9, -18, 3, -8, -4, -12, -5, 0, -7, 1, 6, -9, 8, -7, 10, -7, 5, 11, 38, 55, 27, 40, 40, 37, 40, -42, 45, 30, 31, 34, 27, -42, 38, 23, 40, 41, 31, 36, 29, -42, 25, 30, 23, 31, 36, 27, 26, -42, 23, 26, 41, -42, -8, 23, 36, 36, 27, 40};
    }

    public AnonymousClass72(C6M c6m, NT nt) {
        super(c6m, nt);
        this.A00 = WorkRequest.MIN_BACKOFF_MILLIS;
        this.A02 = c6m;
    }

    private C1726hT A01(Runnable runnable) {
        return new C1726hT(this, runnable);
    }

    private List<JSONObject> A04(NU nu) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA03 = nu.A03();
        if (jSONObjectA03.has(A03(22, 12, 71))) {
            try {
                this.A00 = jSONObjectA03.getJSONObject(r1).optInt(A03(3, 19, 62), 10000);
                JSONArray adsArray = jSONObjectA03.getJSONArray(A03(0, 3, 98));
                if (adsArray.length() > 0) {
                    for (int i2 = 0; i2 < adsArray.length(); i2++) {
                        arrayList.add((JSONObject) adsArray.get(i2));
                    }
                }
            } catch (JSONException unused) {
                String strA03 = A03(36, 38, 101);
                this.A02.A0F().A5Y(V1.A01(AdErrorType.UNKNOWN_ERROR, strA03).A03().getErrorCode(), strA03);
                return arrayList;
            }
        } else {
            arrayList.add(jSONObjectA03);
        }
        return arrayList;
    }

    private void A06(InterfaceC1789id interfaceC1789id, JSONObject jSONObject, TF tf) {
        this.A0C = false;
        C1725hS c1725hS = new C1725hS(this, interfaceC1789id, AbstractC1186Wr.A02(jSONObject, A03(34, 2, 114)));
        A0H().postDelayed(c1725hS, tf.A05());
        interfaceC1789id.AAk(this.A02, this.A09, this.A08.A08, A01(c1725hS), jSONObject, tf);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final void A0P() {
        if (this.A01 != null) {
            this.A02.A0F().A4W();
            this.A07.A0E(this.A01);
        } else {
            this.A02.A0F().A4X();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final void A0R(MP mp, TE te, TC tc, final NU nu) {
        this.A02.A0F().A4Q();
        final InterfaceC1789id interfaceC1789id = (InterfaceC1789id) mp;
        if (interfaceC1789id.AJa()) {
            final List<JSONObject> listA04 = A04(nu);
            A06(interfaceC1789id, listA04.get(0), nu.A01());
            if (listA04.size() > 1) {
                A0H().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.NV
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A02.A0a(interfaceC1789id, listA04, nu);
                    }
                }, this.A00);
                return;
            }
            return;
        }
        A06(interfaceC1789id, nu.A03(), nu.A01());
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final void A0U(String str) {
        this.A02.A0F().A4V(str != null);
        super.A0U(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final void A0Y(boolean z2) {
        super.A0Y(z2);
        this.A01 = null;
    }

    public final /* synthetic */ void A0a(InterfaceC1789id interfaceC1789id, List list, NU nu) {
        A06(interfaceC1789id, (JSONObject) list.get(1), nu.A01());
    }
}

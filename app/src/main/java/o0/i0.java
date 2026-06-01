package o0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f13136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ i0[] f13137b;

    /* JADX INFO: Fake field, exist only in values array */
    i0 EF0;

    static {
        i0 i0Var = new i0("UNKNOWN_MOBILE_SUBTYPE", 0);
        i0 i0Var2 = new i0("GPRS", 1);
        i0 i0Var3 = new i0("EDGE", 2);
        i0 i0Var4 = new i0("UMTS", 3);
        i0 i0Var5 = new i0("CDMA", 4);
        i0 i0Var6 = new i0("EVDO_0", 5);
        i0 i0Var7 = new i0("EVDO_A", 6);
        i0 i0Var8 = new i0("RTT", 7);
        i0 i0Var9 = new i0("HSDPA", 8);
        i0 i0Var10 = new i0("HSUPA", 9);
        i0 i0Var11 = new i0("HSPA", 10);
        i0 i0Var12 = new i0("IDEN", 11);
        i0 i0Var13 = new i0("EVDO_B", 12);
        i0 i0Var14 = new i0("LTE", 13);
        i0 i0Var15 = new i0("EHRPD", 14);
        i0 i0Var16 = new i0("HSPAP", 15);
        i0 i0Var17 = new i0("GSM", 16);
        i0 i0Var18 = new i0("TD_SCDMA", 17);
        i0 i0Var19 = new i0("IWLAN", 18);
        i0 i0Var20 = new i0("LTE_CA", 19);
        f13137b = new i0[]{i0Var, i0Var2, i0Var3, i0Var4, i0Var5, i0Var6, i0Var7, i0Var8, i0Var9, i0Var10, i0Var11, i0Var12, i0Var13, i0Var14, i0Var15, i0Var16, i0Var17, i0Var18, i0Var19, i0Var20, new i0("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        f13136a = sparseArray;
        sparseArray.put(0, i0Var);
        sparseArray.put(1, i0Var2);
        sparseArray.put(2, i0Var3);
        sparseArray.put(3, i0Var4);
        sparseArray.put(4, i0Var5);
        sparseArray.put(5, i0Var6);
        sparseArray.put(6, i0Var7);
        sparseArray.put(7, i0Var8);
        sparseArray.put(8, i0Var9);
        sparseArray.put(9, i0Var10);
        sparseArray.put(10, i0Var11);
        sparseArray.put(11, i0Var12);
        sparseArray.put(12, i0Var13);
        sparseArray.put(13, i0Var14);
        sparseArray.put(14, i0Var15);
        sparseArray.put(15, i0Var16);
        sparseArray.put(16, i0Var17);
        sparseArray.put(17, i0Var18);
        sparseArray.put(18, i0Var19);
        sparseArray.put(19, i0Var20);
    }

    public static i0 valueOf(String str) {
        return (i0) Enum.valueOf(i0.class, str);
    }

    public static i0[] values() {
        return (i0[]) f13137b.clone();
    }
}

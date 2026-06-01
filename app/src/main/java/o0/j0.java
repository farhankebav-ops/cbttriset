package o0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f13143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ j0[] f13144b;

    /* JADX INFO: Fake field, exist only in values array */
    j0 EF0;

    static {
        j0 j0Var = new j0("MOBILE", 0);
        j0 j0Var2 = new j0("WIFI", 1);
        j0 j0Var3 = new j0("MOBILE_MMS", 2);
        j0 j0Var4 = new j0("MOBILE_SUPL", 3);
        j0 j0Var5 = new j0("MOBILE_DUN", 4);
        j0 j0Var6 = new j0("MOBILE_HIPRI", 5);
        j0 j0Var7 = new j0("WIMAX", 6);
        j0 j0Var8 = new j0("BLUETOOTH", 7);
        j0 j0Var9 = new j0("DUMMY", 8);
        j0 j0Var10 = new j0("ETHERNET", 9);
        j0 j0Var11 = new j0("MOBILE_FOTA", 10);
        j0 j0Var12 = new j0("MOBILE_IMS", 11);
        j0 j0Var13 = new j0("MOBILE_CBS", 12);
        j0 j0Var14 = new j0("WIFI_P2P", 13);
        j0 j0Var15 = new j0("MOBILE_IA", 14);
        j0 j0Var16 = new j0("MOBILE_EMERGENCY", 15);
        j0 j0Var17 = new j0("PROXY", 16);
        j0 j0Var18 = new j0("VPN", 17);
        j0 j0Var19 = new j0("NONE", 18);
        f13144b = new j0[]{j0Var, j0Var2, j0Var3, j0Var4, j0Var5, j0Var6, j0Var7, j0Var8, j0Var9, j0Var10, j0Var11, j0Var12, j0Var13, j0Var14, j0Var15, j0Var16, j0Var17, j0Var18, j0Var19};
        SparseArray sparseArray = new SparseArray();
        f13143a = sparseArray;
        sparseArray.put(0, j0Var);
        sparseArray.put(1, j0Var2);
        sparseArray.put(2, j0Var3);
        sparseArray.put(3, j0Var4);
        sparseArray.put(4, j0Var5);
        sparseArray.put(5, j0Var6);
        sparseArray.put(6, j0Var7);
        sparseArray.put(7, j0Var8);
        sparseArray.put(8, j0Var9);
        sparseArray.put(9, j0Var10);
        sparseArray.put(10, j0Var11);
        sparseArray.put(11, j0Var12);
        sparseArray.put(12, j0Var13);
        sparseArray.put(13, j0Var14);
        sparseArray.put(14, j0Var15);
        sparseArray.put(15, j0Var16);
        sparseArray.put(16, j0Var17);
        sparseArray.put(17, j0Var18);
        sparseArray.put(-1, j0Var19);
    }

    public static j0 valueOf(String str) {
        return (j0) Enum.valueOf(j0.class, str);
    }

    public static j0[] values() {
        return (j0[]) f13144b.clone();
    }
}

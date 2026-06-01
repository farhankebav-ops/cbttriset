package o0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f13149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ l0[] f13150b;

    static {
        l0 l0Var = new l0("DEFAULT", 0);
        f13149a = l0Var;
        l0 l0Var2 = new l0("UNMETERED_ONLY", 1);
        l0 l0Var3 = new l0("UNMETERED_OR_DAILY", 2);
        l0 l0Var4 = new l0("FAST_IF_RADIO_AWAKE", 3);
        l0 l0Var5 = new l0("NEVER", 4);
        l0 l0Var6 = new l0("UNRECOGNIZED", 5);
        f13150b = new l0[]{l0Var, l0Var2, l0Var3, l0Var4, l0Var5, l0Var6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, l0Var);
        sparseArray.put(1, l0Var2);
        sparseArray.put(2, l0Var3);
        sparseArray.put(3, l0Var4);
        sparseArray.put(4, l0Var5);
        sparseArray.put(-1, l0Var6);
    }

    public static l0 valueOf(String str) {
        return (l0) Enum.valueOf(l0.class, str);
    }

    public static l0[] values() {
        return (l0[]) f13150b.clone();
    }
}

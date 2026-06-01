package o0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f13113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b0[] f13114b;

    /* JADX INFO: Fake field, exist only in values array */
    b0 EF0;

    static {
        b0 b0Var = new b0("NOT_SET", 0);
        b0 b0Var2 = new b0("EVENT_OVERRIDE", 1);
        f13113a = b0Var2;
        f13114b = new b0[]{b0Var, b0Var2};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, b0Var);
        sparseArray.put(5, b0Var2);
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) f13114b.clone();
    }
}

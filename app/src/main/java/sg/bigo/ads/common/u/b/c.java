package sg.bigo.ads.common.u.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import sg.bigo.ads.common.u.a;
import sg.bigo.ads.common.u.f;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c<T extends sg.bigo.ads.common.u.a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15968i;
    public final T j;

    @Nullable
    public Executor k;
    public long l = 15000;
    public final Map<String, Set<String>> m = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f15969n;

    public c(int i2, @NonNull T t3, boolean z2, Context context) {
        this.f15968i = i2;
        this.j = t3;
        this.f15969n = z2;
        a("BIGO-Ad-Request-Id", String.valueOf(i2));
        a("User-Agent", sg.bigo.ads.common.aa.c.c(context));
    }

    @NonNull
    private Set<String> b(@NonNull String str) {
        Set<String> set = this.m.get(str);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.m.put(str, hashSet);
        return hashSet;
    }

    @NonNull
    public String a() {
        return "GET";
    }

    @Nullable
    public byte[] c() {
        return null;
    }

    @Nullable
    public String d() {
        return null;
    }

    public int e() {
        return -1;
    }

    public boolean f() {
        return false;
    }

    @NonNull
    public final String g() {
        return this.j.a();
    }

    public final void a(String str) {
        b(str).clear();
    }

    @Nullable
    public f b() {
        return null;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        b(str).add(str2);
    }

    public void h() {
    }
}

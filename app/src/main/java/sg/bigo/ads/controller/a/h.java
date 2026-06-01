package sg.bigo.ads.controller.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f16376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16379d;
    public final String e;

    public h(@Nullable String str, boolean z2) {
        this(str, true, z2, 0, "success");
    }

    public static h a(@Nullable String str, boolean z2, int i2, String str2) {
        return new h(str, false, z2, i2, str2);
    }

    @NonNull
    public final String toString() {
        return super.toString();
    }

    public h(@Nullable String str, boolean z2, boolean z7, int i2, String str2) {
        this.f16376a = str;
        this.f16377b = z2;
        this.f16378c = z7;
        this.f16379d = i2;
        this.e = str2;
    }
}

package sg.bigo.ads.core.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f17016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f17017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f17019d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17020f;
    private final int g;

    public b(int i2, int i8, int i9, int i10, @NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.f17016a = i2;
        this.f17017b = i8;
        this.g = i10;
        this.f17018c = str;
        this.f17020f = i9;
        this.f17019d = str2;
        this.e = str3;
    }

    public final boolean a() {
        return TextUtils.equals(this.f17019d, "application/javascript");
    }
}

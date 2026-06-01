package sg.bigo.ads.controller.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f16381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f16382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f16383c;

    public j(String str, @Nullable String str2, int i2) {
        this.f16381a = str;
        this.f16382b = str2;
        this.f16383c = i2;
    }

    @NonNull
    public final String a() {
        return this.f16381a;
    }

    @Nullable
    public final String b() {
        return this.f16382b;
    }

    public final boolean c() {
        return d.a(this.f16382b);
    }

    public final int d() {
        return this.f16383c;
    }

    @NonNull
    public String toString() {
        return super.toString();
    }
}

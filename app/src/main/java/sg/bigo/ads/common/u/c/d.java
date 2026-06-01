package sg.bigo.ads.common.u.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.utils.g;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f15980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f15981b;

    public d(@NonNull a aVar) {
        this.f15980a = aVar;
        this.f15981b = g.a(aVar.f15974b);
    }

    @NonNull
    public final String a() {
        return this.f15981b;
    }

    @Nullable
    public final String a(String str) {
        return this.f15980a.a(str);
    }
}

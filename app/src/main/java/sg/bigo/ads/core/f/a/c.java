package sg.bigo.ads.core.f.a;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends n implements Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17021a;

    public c(@NonNull String str, int i2) {
        super(str);
        this.f17021a = i2;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(@NonNull c cVar) {
        return this.f17021a - cVar.f17021a;
    }

    @Override // sg.bigo.ads.core.f.a.n
    public final String toString() {
        StringBuilder sb = new StringBuilder("{\"Content\":\"");
        sb.append(this.f17045b);
        sb.append("\",\"pro_ms\":\"");
        return a1.a.q(sb, "\"}", this.f17021a);
    }
}

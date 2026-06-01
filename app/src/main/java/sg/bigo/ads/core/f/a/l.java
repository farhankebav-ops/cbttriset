package sg.bigo.ads.core.f.a;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class l extends n implements Comparable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17042a;

    public l(@NonNull String str, float f4) {
        super(str);
        this.f17042a = f4;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull l lVar) {
        return Double.compare(this.f17042a, lVar.f17042a);
    }

    @Override // sg.bigo.ads.core.f.a.n
    public final String toString() {
        return "{\"Content\":\"" + this.f17045b + "\",\"progress\":\"" + this.f17042a + "\"}";
    }
}

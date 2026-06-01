package sg.bigo.ads.common.h.b;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f15760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    sg.bigo.ads.common.h.a f15761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f15762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f15763d;
    int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f15764f;

    public a(@NonNull sg.bigo.ads.common.h.a aVar) {
        this.f15761b = aVar;
        this.f15760a = aVar.f15727a;
    }

    public final void a(long j) {
        this.f15761b.f15732i = j;
    }

    public final void b(long j) {
        this.f15761b.g = j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return this.f15760a.equals(aVar.f15760a) && this.f15761b.f15730d.equals(aVar.f15761b.f15730d) && this.f15761b.f15729c.equals(aVar.f15761b.f15729c);
    }

    public String toString() {
        return this.f15761b.toString();
    }
}

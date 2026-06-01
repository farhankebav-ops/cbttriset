package sg.bigo.ads.core.f.a;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17034a;

    public j(@NonNull String str, boolean z2) {
        super(str);
        this.f17034a = z2;
    }

    @Override // sg.bigo.ads.core.f.a.n
    public final String toString() {
        StringBuilder sb = new StringBuilder("{\"Content\":\"");
        sb.append(this.f17045b);
        sb.append("\",\"mute\":\"");
        return a1.a.u(sb, this.f17034a, "\"}");
    }
}

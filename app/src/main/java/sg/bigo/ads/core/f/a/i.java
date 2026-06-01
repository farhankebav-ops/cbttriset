package sg.bigo.ads.core.f.a;

import androidx.annotation.NonNull;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final Node f17033a;

    public i(@NonNull Node node) {
        this.f17033a = node;
    }

    public final String a() {
        return sg.bigo.ads.core.f.a.e(this.f17033a, "type");
    }

    public final String b() {
        return sg.bigo.ads.core.f.a.b(this.f17033a);
    }

    public final int c() {
        return sg.bigo.ads.core.f.a.d(this.f17033a, "fileSize").intValue();
    }

    public final int d() {
        return sg.bigo.ads.core.f.a.d(this.f17033a, "bitrate").intValue();
    }

    public final String e() {
        return sg.bigo.ads.core.f.a.e(this.f17033a, "md5");
    }
}

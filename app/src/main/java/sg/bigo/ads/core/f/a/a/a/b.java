package sg.bigo.ads.core.f.a.a.a;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements sg.bigo.ads.core.f.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Node f17002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<sg.bigo.ads.core.f.a.a.d> f17003b;

    public b(@NonNull Node node) {
        this.f17002a = node;
    }

    @Override // sg.bigo.ads.core.f.a.a.b
    public final List<sg.bigo.ads.core.f.a.a.d> a() {
        if (this.f17003b == null) {
            this.f17003b = new ArrayList();
            Iterator<Node> it = sg.bigo.ads.core.f.a.c(this.f17002a, "Companion").iterator();
            while (it.hasNext()) {
                this.f17003b.add(new d(it.next()));
            }
        }
        return this.f17003b;
    }
}

package sg.bigo.ads.core.f.a.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements sg.bigo.ads.core.f.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Node f17006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17009d;
    private String g;
    private sg.bigo.ads.core.f.a.a.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f17011i;
    private final List<sg.bigo.ads.core.f.a.a.g> e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f17010f = new ArrayList();
    private final List<sg.bigo.ads.core.f.a.a.c> j = new ArrayList();

    public d(@NonNull Node node) {
        this.f17006a = node;
        this.f17007b = sg.bigo.ads.core.f.a.e(node, "id");
        this.f17008c = sg.bigo.ads.core.f.a.d(node, "width").intValue();
        this.f17009d = sg.bigo.ads.core.f.a.d(node, "height").intValue();
        g();
    }

    private void g() {
        List<Node> listB = sg.bigo.ads.core.f.a.b(this.f17006a, "StaticResource", null, null);
        if (!k.a((Collection) listB)) {
            for (Node node : listB) {
                this.e.add(new g(sg.bigo.ads.core.f.a.e(node, "creativeType"), sg.bigo.ads.core.f.a.a(node)));
            }
        }
        List<Node> listB2 = sg.bigo.ads.core.f.a.b(this.f17006a, "IFrameResource", null, null);
        if (!k.a((Collection) listB2)) {
            Iterator<Node> it = listB2.iterator();
            while (it.hasNext()) {
                this.e.add(new f(sg.bigo.ads.core.f.a.b(it.next())));
            }
        }
        List<Node> listB3 = sg.bigo.ads.core.f.a.b(this.f17006a, "HTMLResource", null, null);
        if (!k.a((Collection) listB3)) {
            Iterator<Node> it2 = listB3.iterator();
            while (it2.hasNext()) {
                this.e.add(new e(sg.bigo.ads.core.f.a.b(it2.next())));
            }
        }
        Node nodeA = sg.bigo.ads.core.f.a.a(this.f17006a, "AltText", null, null);
        if (nodeA != null) {
            this.g = sg.bigo.ads.core.f.a.b(nodeA);
        }
        Node nodeA2 = sg.bigo.ads.core.f.a.a(this.f17006a, "AdParameters", null, null);
        if (nodeA2 != null) {
            this.h = new a(TextUtils.equals(sg.bigo.ads.core.f.a.e(nodeA2, "xmlEncoded"), com.ironsource.mediationsdk.metadata.a.g), sg.bigo.ads.core.f.a.b(nodeA2));
        }
        Node nodeA3 = sg.bigo.ads.core.f.a.a(this.f17006a, "CompanionClickThrough", null, null);
        if (nodeA3 != null) {
            this.f17011i = sg.bigo.ads.core.f.a.a(nodeA3);
        }
        List<Node> listB4 = sg.bigo.ads.core.f.a.b(this.f17006a, "CompanionClickTracking", null, null);
        if (!k.a((Collection) listB4)) {
            for (Node node2 : listB4) {
                this.j.add(new c(sg.bigo.ads.core.f.a.e(node2, "id"), sg.bigo.ads.core.f.a.a(node2)));
            }
        }
        Node nodeA4 = sg.bigo.ads.core.f.a.a(this.f17006a, "TrackingEvents", null, null);
        if (nodeA4 != null) {
            List<Node> listB5 = sg.bigo.ads.core.f.a.b(nodeA4, "Tracking", NotificationCompat.CATEGORY_EVENT, Arrays.asList("creativeView"));
            if (k.a((Collection) listB5)) {
                return;
            }
            Iterator<Node> it3 = listB5.iterator();
            while (it3.hasNext()) {
                String strA = sg.bigo.ads.core.f.a.a(it3.next());
                if (!TextUtils.isEmpty(strA)) {
                    this.f17010f.add(strA);
                }
            }
        }
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final int a() {
        return this.f17008c;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final int b() {
        return this.f17009d;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final List<sg.bigo.ads.core.f.a.a.g> c() {
        return this.e;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final String d() {
        return this.f17011i;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final List<sg.bigo.ads.core.f.a.a.c> e() {
        return this.j;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final List<String> f() {
        return this.f17010f;
    }
}

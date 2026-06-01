package d7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f11175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f11176d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f11177f;
    public final ArrayList g;

    public a(String serialName) {
        kotlin.jvm.internal.k.e(serialName, "serialName");
        this.f11173a = serialName;
        this.f11174b = r.f13638a;
        this.f11175c = new ArrayList();
        this.f11176d = new HashSet();
        this.e = new ArrayList();
        this.f11177f = new ArrayList();
        this.g = new ArrayList();
    }

    public static void a(a aVar, String str, g descriptor) {
        aVar.getClass();
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        if (!aVar.f11176d.add(str)) {
            StringBuilder sbY = a1.a.y("Element with name '", str, "' is already registered in ");
            sbY.append(aVar.f11173a);
            throw new IllegalArgumentException(sbY.toString().toString());
        }
        aVar.f11175c.add(str);
        aVar.e.add(descriptor);
        aVar.f11177f.add(r.f13638a);
        aVar.g.add(false);
    }
}

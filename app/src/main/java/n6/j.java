package n6;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends r5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e2.h f13101a;

    public j(e2.h hVar) {
        this.f13101a = hVar;
    }

    @Override // r5.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        String strGroup = ((Matcher) this.f13101a.f11231a).group(i2);
        return strGroup == null ? "" : strGroup;
    }

    @Override // r5.a
    public final int getSize() {
        return ((Matcher) this.f13101a.f11231a).groupCount() + 1;
    }

    @Override // r5.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // r5.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}

package b0;

import android.view.View;
import java.io.File;
import java.util.Comparator;
import m7.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4115a;

    public /* synthetic */ a(int i2) {
        this.f4115a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4115a) {
            case 0:
                long jLastModified = ((File) obj2).lastModified() - ((File) obj).lastModified();
                if (jLastModified == 0) {
                    return 0;
                }
                return jLastModified < 0 ? -1 : 1;
            case 1:
                return n7.b.j(((k) obj).f13021a, ((k) obj2).f13021a);
            default:
                return ((View) obj).getTop() - ((View) obj2).getTop();
        }
    }
}

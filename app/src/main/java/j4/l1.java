package j4;

import com.ironsource.C2300e4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12300b;

    public l1(int i2) {
        this.f12299a = i2;
        switch (i2) {
            case 1:
                this.f12300b = new ArrayList(20);
                break;
            default:
                this.f12300b = new ArrayList();
                break;
        }
    }

    public void a(Object obj, String str) {
        this.f12300b.add(str + C2300e4.i.f8399b + obj);
    }

    public String toString() {
        switch (this.f12299a) {
            case 0:
                return this.f12300b.toString();
            default:
                return super.toString();
        }
    }
}

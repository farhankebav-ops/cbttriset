package v4;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends n7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17603b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f17602a = i2;
        this.f17603b = obj;
    }

    @Override // n7.b
    public final void H(String str) {
        switch (this.f17602a) {
            case 0:
                ((PrintStream) this.f17603b).println((Object) str);
                break;
            default:
                ((PrintWriter) this.f17603b).println((Object) str);
                break;
        }
    }
}

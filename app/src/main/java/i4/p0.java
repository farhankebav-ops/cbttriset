package i4;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p0 {
    public abstract String a();

    public abstract o0 b(x xVar);

    public abstract e1 c(Map map);

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(a(), "policy");
        iVarY.f(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, String.valueOf(5));
        iVarY.e("available", true);
        return iVarY.toString();
    }
}

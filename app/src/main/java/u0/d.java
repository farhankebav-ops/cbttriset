package u0;

import androidx.work.WorkRequest;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import m0.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements r0.b {
    @Override // p5.a
    public final Object get() {
        r4.c cVar = new r4.c(6);
        HashMap map = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(e.f12921a, new v0.b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, SignalManager.TWENTY_FOUR_HOURS_MILLIS, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(e.f12923c, new v0.b(1000L, SignalManager.TWENTY_FOUR_HOURS_MILLIS, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(v0.c.f17572b)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(e.f12922b, new v0.b(SignalManager.TWENTY_FOUR_HOURS_MILLIS, SignalManager.TWENTY_FOUR_HOURS_MILLIS, setUnmodifiableSet));
        if (map.keySet().size() < e.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new v0.a(cVar, map);
    }
}

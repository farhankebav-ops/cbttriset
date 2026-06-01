package i4;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11921a;

    static {
        p t1Var;
        AtomicReference atomicReference = new AtomicReference();
        try {
            t1Var = (p) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(p.class).getConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            atomicReference.set(e);
            t1Var = new t1();
        } catch (Exception e4) {
            throw new RuntimeException("Storage override failed to initialize", e4);
        }
        f11921a = t1Var;
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            q.f11931a.log(Level.FINE, "Storage override doesn't exist. Using default", th);
        }
    }
}

package v6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17649a = 0;

    static {
        Object objM;
        Object objM2;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objM = x5.a.class.getCanonicalName();
        } catch (Throwable th) {
            objM = r2.q.M(th);
        }
        if (q5.k.a(objM) != null) {
            objM = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objM2 = t.class.getCanonicalName();
        } catch (Throwable th2) {
            objM2 = r2.q.M(th2);
        }
        if (q5.k.a(objM2) != null) {
            objM2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}

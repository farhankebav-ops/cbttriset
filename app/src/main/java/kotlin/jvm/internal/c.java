package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c implements l6.b, Serializable {
    public static final Object NO_RECEIVER = b.f12718a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient l6.b reflected;
    private final String signature;

    public c(Object obj, Class cls, String str, String str2, boolean z2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z2;
    }

    @Override // l6.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // l6.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public l6.b compute() {
        l6.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        l6.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract l6.b computeReflected();

    @Override // l6.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // l6.b
    public String getName() {
        return this.name;
    }

    public l6.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return b0.a(cls);
        }
        b0.f12719a.getClass();
        return new r(cls);
    }

    @Override // l6.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract l6.b getReflected();

    @Override // l6.b
    public l6.r getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // l6.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // l6.b
    public l6.v getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // l6.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // l6.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // l6.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // l6.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}

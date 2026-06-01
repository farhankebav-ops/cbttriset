package w1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.SystemClock;
import androidx.core.util.Preconditions;
import com.google.firebase.inappmessaging.internal.InstallationIdResult;
import com.google.firebase.installations.InstallationTokenResult;
import java.io.File;
import java.nio.file.Path;
import l7.g0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class f implements y0.a, x4.c, x4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17703a;

    public /* synthetic */ f(int i2) {
        this.f17703a = i2;
    }

    public static k4.u b(int i2) {
        return new k4.u(Math.min(1048576, Math.max(4096, i2)), new l7.j());
    }

    public static f c(Context context, int i2) {
        Preconditions.checkArgument(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, b1.a.f4134q);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        t1.c.a(context, typedArrayObtainStyledAttributes, 4);
        t1.c.a(context, typedArrayObtainStyledAttributes, 9);
        t1.c.a(context, typedArrayObtainStyledAttributes, 7);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        o.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        f fVar = new f(1);
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        return fVar;
    }

    public static g0 d(String str, boolean z2) {
        kotlin.jvm.internal.k.e(str, "<this>");
        l7.m mVar = m7.f.f13007a;
        l7.j jVar = new l7.j();
        jVar.d0(str);
        return m7.f.d(jVar, z2);
    }

    public static g0 e(File file) {
        String str = g0.f12850b;
        String string = file.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return d(string, false);
    }

    public static g0 f(Path path) {
        String str = g0.f12850b;
        kotlin.jvm.internal.k.e(path, "<this>");
        return d(path.toString(), false);
    }

    @Override // x4.b
    public void accept(Object obj) {
        switch (this.f17703a) {
            case 7:
                break;
            default:
                n7.b.F(new v4.d((Throwable) obj));
                break;
        }
    }

    @Override // x4.c
    public Object apply(Object obj) {
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 2) {
            return InstallationIdResult.create((String) objArr[0], (InstallationTokenResult) objArr[1]);
        }
        throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
    }

    @Override // y0.a
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }

    public String toString() {
        switch (this.f17703a) {
            case 7:
                return "EmptyConsumer";
            default:
                return super.toString();
        }
    }

    public f(androidx.camera.camera2.internal.compat.workaround.c cVar) {
        this.f17703a = 6;
    }

    private final void a(Object obj) {
    }
}

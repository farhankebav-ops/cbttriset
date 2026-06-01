package x;

import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.rp.MY.Cc;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a implements SurfaceHolder.Callback, e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f17780c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f17781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f17782b;

    @Override // x.e
    public final void IlO(int i2, int i8) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i8;
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
    }

    @Override // x.e
    public final void a(Cc cc) {
        this.f17781a = new WeakReference(cc);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator it = f17780c.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar != null && ((SurfaceHolder.Callback) gVar.f17784a.get()) == null) {
                holder.removeCallback(gVar);
                it.remove();
            }
        }
        holder.addCallback(this.f17782b);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i8, int i9) {
        WeakReference weakReference = this.f17781a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((c) this.f17781a.get()).IlO(surfaceHolder, i2, i8, i9);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference weakReference = this.f17781a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((c) this.f17781a.get()).IlO(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference weakReference = this.f17781a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((c) this.f17781a.get()).MY(surfaceHolder);
    }

    @Override // x.e
    public View getView() {
        return this;
    }

    public void setWindowVisibilityChangedListener(d dVar) {
    }
}

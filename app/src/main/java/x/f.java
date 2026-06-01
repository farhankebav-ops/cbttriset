package x;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.rp.MY.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends TextureView implements TextureView.SurfaceTextureListener, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cc f17783a;

    @Override // x.e
    public final void IlO(int i2, int i8) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i8;
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
    }

    @Override // x.e
    public final void a(Cc cc) {
        this.f17783a = cc;
        setSurfaceTextureListener(this);
    }

    @Override // x.e
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i8) {
        Cc cc = this.f17783a;
        if (cc != null) {
            cc.IlO(surfaceTexture, i2, i8);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Cc cc = this.f17783a;
        if (cc != null) {
            return cc.IlO(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    @Override // x.e
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setWindowVisibilityChangedListener(d dVar) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i8) {
    }
}

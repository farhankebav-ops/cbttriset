package sg.bigo.ads.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RenderScript f15591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScriptIntrinsicBlur f15592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Allocation f15593d;
    private Allocation e;

    @RequiresApi(api = 17)
    public b(Context context) {
        this.f15590a = context;
    }

    private boolean b() {
        return (this.f15591b == null || this.f15592c == null) ? false : true;
    }

    @Override // sg.bigo.ads.common.c.a
    public final void a() {
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f15592c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f15592c = null;
        }
        RenderScript renderScript = this.f15591b;
        if (renderScript != null) {
            renderScript.destroy();
            this.f15591b = null;
        }
        Allocation allocation = this.f15593d;
        if (allocation != null) {
            allocation.destroy();
            this.f15593d = null;
        }
        Allocation allocation2 = this.e;
        if (allocation2 != null) {
            allocation2.destroy();
            this.e = null;
        }
    }

    @Override // sg.bigo.ads.common.c.a
    public final void a(Bitmap bitmap, Bitmap bitmap2) {
        if (b()) {
            if (this.f15593d == null) {
                this.f15593d = Allocation.createFromBitmap(this.f15591b, bitmap);
            }
            if (this.e == null) {
                this.e = Allocation.createFromBitmap(this.f15591b, bitmap2);
            }
            this.f15593d.copyFrom(bitmap);
            this.f15592c.setInput(this.f15593d);
            this.f15592c.forEach(this.e);
            this.e.copyTo(bitmap2);
        }
    }

    public final boolean a(float f4) {
        if (!b()) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(this.f15590a);
                this.f15591b = renderScriptCreate;
                this.f15592c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (Exception unused) {
                a();
                return false;
            }
        }
        this.f15592c.setRadius(f4);
        return true;
    }

    @Override // sg.bigo.ads.common.c.a
    public final boolean a(Bitmap bitmap, float f4) {
        if (!a(f4)) {
            return false;
        }
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f15591b, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f15593d = allocationCreateFromBitmap;
        this.e = Allocation.createTyped(this.f15591b, allocationCreateFromBitmap.getType());
        return true;
    }
}

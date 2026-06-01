package sg.bigo.ads.api.core;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseAdActivityImpl {

    @NonNull
    public final Activity I;
    public int J = 0;

    public BaseAdActivityImpl(@NonNull Activity activity) {
        this.I = activity;
    }

    public abstract void D();

    public abstract void N();

    public boolean P() {
        return false;
    }

    public abstract void U();

    public abstract void V();

    public abstract void W();

    public abstract void X();

    public abstract void a(int i2, int i8, Intent intent);

    public final void ao() {
        Window window;
        if (P() || (window = this.I.getWindow()) == null) {
            return;
        }
        sg.bigo.ads.common.utils.s.a(window);
    }

    public void ap() {
        this.I.finish();
    }

    public final boolean aq() {
        return this.J == 1;
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    public abstract void g(boolean z2);

    public final void n(@LayoutRes int i2) {
        this.I.setContentView(sg.bigo.ads.common.utils.a.a(this.I, i2, null, false));
    }

    @Nullable
    public final <T extends View> T o(@IdRes int i2) {
        return (T) this.I.findViewById(i2);
    }
}

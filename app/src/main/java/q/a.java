package q;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13341a;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f13341a) {
            case 0:
                Drawable background = view.getBackground();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        background.clearColorFilter();
                        view.invalidate();
                        return false;
                    }
                    if (action != 11) {
                        return false;
                    }
                }
                background.setColorFilter(536870912, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                return false;
            default:
                return true;
        }
    }
}

package f1;

import android.view.View;
import com.google.android.material.bottomappbar.BottomAppBar$Behavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar$Behavior f11308a;

    public a(BottomAppBar$Behavior bottomAppBar$Behavior) {
        this.f11308a = bottomAppBar$Behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        if (this.f11308a.l.get() != null) {
            throw new ClassCastException();
        }
        view.removeOnLayoutChangeListener(this);
    }
}

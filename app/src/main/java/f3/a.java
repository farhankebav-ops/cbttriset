package f3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewParent;
import androidx.camera.video.internal.audio.h;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements OnCompleteListener, AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11357c;

    public /* synthetic */ a(Object obj, int i2, int i8) {
        this.f11355a = i8;
        this.f11357c = obj;
        this.f11356b = i2;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f11355a) {
            case 0:
                FirebaseUtil.lambda$InAppReview$4((SharedPreferences) this.f11357c, this.f11356b, task);
                break;
            default:
                FirebaseUtil.lambda$fetchRemoteConfig$0((Activity) this.f11357c, this.f11356b, task);
                break;
        }
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f11357c;
        int i2 = this.f11356b;
        if (i2 == 1 || i2 == 2) {
            throw new IllegalArgumentException(a1.a.r(new StringBuilder("STATE_"), i2 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = sideSheetBehavior.p;
        if (weakReference == null || weakReference.get() == null) {
            sideSheetBehavior.a(i2);
            return true;
        }
        View view2 = (View) sideSheetBehavior.p.get();
        h hVar = new h(sideSheetBehavior, i2, 2);
        ViewParent parent = view2.getParent();
        if (parent != null && parent.isLayoutRequested() && view2.isAttachedToWindow()) {
            view2.post(hVar);
            return true;
        }
        hVar.run();
        return true;
    }
}

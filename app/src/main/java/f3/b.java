package f3;

import android.app.Activity;
import android.content.DialogInterface;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import com.vungle.ads.internal.presenter.NativeAdPresenter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11359b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f11358a = i2;
        this.f11359b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        switch (this.f11358a) {
            case 0:
                FirebaseUtil.lambda$checkMinUpdate$2((Activity) this.f11359b, dialogInterface, i2);
                break;
            case 1:
                ((Activity) this.f11359b).finish();
                break;
            default:
                NativeAdPresenter.m3345showGdpr$lambda8((NativeAdPresenter) this.f11359b, dialogInterface, i2);
                break;
        }
    }
}

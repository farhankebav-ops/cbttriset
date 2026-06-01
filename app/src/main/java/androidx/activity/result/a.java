package androidx.activity.result;

import com.google.android.gms.tasks.OnSuccessListener;
import com.unity3d.ads.core.data.datasource.AndroidAppSetIdDataSource;
import e6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback, OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3321b;

    public /* synthetic */ a(int i2, l lVar) {
        this.f3320a = i2;
        this.f3321b = lVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f3320a) {
            case 0:
                this.f3321b.invoke(obj);
                break;
            default:
                this.f3321b.invoke(obj);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        AndroidAppSetIdDataSource.invoke$lambda$1(this.f3321b, obj);
    }
}

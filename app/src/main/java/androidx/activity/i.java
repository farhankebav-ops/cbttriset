package androidx.activity;

import android.content.IntentSender;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.profileinstaller.DeviceProfileWriter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3312d;

    public /* synthetic */ i(Object obj, int i2, Object obj2, int i8) {
        this.f3309a = i8;
        this.f3310b = obj;
        this.f3311c = i2;
        this.f3312d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3309a) {
            case 0:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0((ComponentActivity$activityResultRegistry$1) this.f3310b, this.f3311c, (ActivityResultContract.SynchronousResult) this.f3312d);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1((ComponentActivity$activityResultRegistry$1) this.f3310b, this.f3311c, (IntentSender.SendIntentException) this.f3312d);
                break;
            default:
                ((DeviceProfileWriter) this.f3310b).lambda$result$0(this.f3311c, this.f3312d);
                break;
        }
    }
}

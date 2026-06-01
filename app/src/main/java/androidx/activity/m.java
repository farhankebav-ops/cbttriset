package androidx.activity;

import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import g7.c0;
import g7.v;
import g7.z;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3313a;

    public /* synthetic */ m(int i2) {
        this.f3313a = i2;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f3313a) {
            case 0:
                return ImmLeaksCleaner.cleaner_delegate$lambda$5();
            case 1:
                return ActivityResultRegistry.generateRandomNumber$lambda$2();
            case 2:
                return CreationExtras.Empty.INSTANCE;
            case 3:
                return x.f13520a;
            case 4:
                return CrashlyticsWorkers.Companion.checkBackgroundThread$lambda$2();
            case 5:
                return CrashlyticsWorkers.Companion.checkNotMainThread$lambda$0();
            case 6:
                return CrashlyticsWorkers.Companion.checkBlockingThread$lambda$1();
            case 7:
                return Long.valueOf(System.currentTimeMillis());
            case 8:
                return c0.f11602b;
            case 9:
                return v.f11627b;
            case 10:
                return g7.s.f11625b;
            case 11:
                return z.f11633b;
            default:
                return g7.g.f11608b;
        }
    }
}

package androidx.lifecycle;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application) {
        kotlin.jvm.internal.k.e(application, "application");
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        T t3 = (T) this.application;
        kotlin.jvm.internal.k.c(t3, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t3;
    }
}

package androidx.lifecycle.viewmodel;

import a.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.k;
import l6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProviderImpl_androidKt {
    public static final <VM extends ViewModel> VM createViewModel(ViewModelProvider.Factory factory, c modelClass, CreationExtras extras) {
        k.e(factory, "factory");
        k.e(modelClass, "modelClass");
        k.e(extras, "extras");
        try {
            try {
                return (VM) factory.create(modelClass, extras);
            } catch (AbstractMethodError unused) {
                return (VM) factory.create(a.B(modelClass), extras);
            }
        } catch (AbstractMethodError unused2) {
            return (VM) factory.create(a.B(modelClass));
        }
    }
}

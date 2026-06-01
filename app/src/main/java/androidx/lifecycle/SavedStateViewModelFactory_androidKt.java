package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.d0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactory_androidKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = r5.m.H0(Application.class, SavedStateHandle.class);
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = q.j0(SavedStateHandle.class);

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> modelClass, List<? extends Class<?>> signature) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        kotlin.jvm.internal.k.e(signature, "signature");
        d7.i iVarG = d0.g(modelClass.getConstructors());
        while (iVarG.hasNext()) {
            Constructor<T> constructor = (Constructor) iVarG.next();
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.k.d(parameterTypes, "getParameterTypes(...)");
            List listS0 = r5.j.s0(parameterTypes);
            if (signature.equals(listS0)) {
                return constructor;
            }
            if (signature.size() == listS0.size() && listS0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        kotlin.jvm.internal.k.e(constructor, "constructor");
        kotlin.jvm.internal.k.e(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + modelClass, e);
        } catch (InstantiationException e4) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e4);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e8.getCause());
        }
    }
}

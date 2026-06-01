package retrofit2;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class Reflection {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Android24 extends Reflection {
        @Override // retrofit2.Reflection
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return DefaultMethodSupport.invoke(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        @Override // retrofit2.Reflection
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Java8 extends Reflection {
        @Override // retrofit2.Reflection
        public String describeMethodParameter(Method method, int i2) {
            Parameter parameter = method.getParameters()[i2];
            if (!parameter.isNamePresent()) {
                return super.describeMethodParameter(method, i2);
            }
            return "parameter '" + parameter.getName() + '\'';
        }

        @Override // retrofit2.Reflection
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
            return DefaultMethodSupport.invoke(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    public String describeMethodParameter(Method method, int i2) {
        return "parameter #" + (i2 + 1);
    }

    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
        throw new AssertionError();
    }

    public boolean isDefaultMethod(Method method) {
        return false;
    }
}

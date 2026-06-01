package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;
import n6.t;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    public static final Lifecycling INSTANCE = new Lifecycling();
    private static final Map<Class<?>, Integer> callbackCache = new HashMap();
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = new HashMap();

    private Lifecycling() {
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            GeneratedAdapter generatedAdapterNewInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.k.b(generatedAdapterNewInstance);
            return generatedAdapterNewInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> cls) {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            kotlin.jvm.internal.k.b(name);
            if (name.length() != 0) {
                kotlin.jvm.internal.k.b(canonicalName);
                canonicalName = canonicalName.substring(name.length() + 1);
                kotlin.jvm.internal.k.d(canonicalName, "substring(...)");
            }
            kotlin.jvm.internal.k.b(canonicalName);
            String adapterName = getAdapterName(canonicalName);
            if (name.length() != 0) {
                adapterName = name + '.' + adapterName;
            }
            Constructor declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String getAdapterName(String className) {
        kotlin.jvm.internal.k.e(className, "className");
        return t.l0(className, ".", "_").concat("_LifecycleAdapter");
    }

    private final int getObserverConstructorType(Class<?> cls) {
        Map<Class<?>, Integer> map = callbackCache;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iResolveObserverCallbackType = resolveObserverCallbackType(cls);
        map.put(cls, Integer.valueOf(iResolveObserverCallbackType));
        return iResolveObserverCallbackType;
    }

    private final boolean isLifecycleParent(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static final LifecycleEventObserver lifecycleEventObserver(Object object) {
        kotlin.jvm.internal.k.e(object, "object");
        boolean z2 = object instanceof LifecycleEventObserver;
        boolean z7 = object instanceof DefaultLifecycleObserver;
        if (z2 && z7) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (LifecycleEventObserver) object);
        }
        if (z7) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, null);
        }
        if (z2) {
            return (LifecycleEventObserver) object;
        }
        Class<?> cls = object.getClass();
        Lifecycling lifecycling = INSTANCE;
        if (lifecycling.getObserverConstructorType(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(cls);
        kotlin.jvm.internal.k.b(list);
        List<Constructor<? extends GeneratedAdapter>> list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(lifecycling.createGeneratedAdapter(list2.get(0), object));
        }
        int size = list2.size();
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
        for (int i2 = 0; i2 < size; i2++) {
            generatedAdapterArr[i2] = INSTANCE.createGeneratedAdapter(list2.get(i2), object);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private final int resolveObserverCallbackType(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() != null) {
            Constructor<? extends GeneratedAdapter> constructorGeneratedConstructor = generatedConstructor(cls);
            if (constructorGeneratedConstructor != null) {
                classToAdapters.put(cls, q.j0(constructorGeneratedConstructor));
                return 2;
            }
            if (!ClassesInfoCache.sInstance.hasLifecycleMethods(cls)) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (isLifecycleParent(superclass)) {
                    kotlin.jvm.internal.k.b(superclass);
                    if (getObserverConstructorType(superclass) != 1) {
                        List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(superclass);
                        kotlin.jvm.internal.k.b(list);
                        arrayList = new ArrayList(list);
                    }
                } else {
                    arrayList = null;
                }
                d7.i iVarG = d0.g(cls.getInterfaces());
                while (true) {
                    if (iVarG.hasNext()) {
                        Class<?> cls2 = (Class) iVarG.next();
                        if (isLifecycleParent(cls2)) {
                            kotlin.jvm.internal.k.b(cls2);
                            if (getObserverConstructorType(cls2) == 1) {
                                break;
                            }
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            List<Constructor<? extends GeneratedAdapter>> list2 = classToAdapters.get(cls2);
                            kotlin.jvm.internal.k.b(list2);
                            arrayList.addAll(list2);
                        }
                    } else if (arrayList != null) {
                        classToAdapters.put(cls, arrayList);
                        return 2;
                    }
                }
            }
        }
        return 1;
    }
}

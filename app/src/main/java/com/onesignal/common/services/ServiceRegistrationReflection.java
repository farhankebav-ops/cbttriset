package com.onesignal.common.services;

import com.onesignal.debug.internal.logging.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ServiceRegistrationReflection<T> extends ServiceRegistration<T> {
    private final Class<?> clazz;
    private T obj;

    public ServiceRegistrationReflection(Class<?> clazz) {
        k.e(clazz, "clazz");
        this.clazz = clazz;
    }

    private final boolean doesHaveAllParameters(Constructor<?> constructor, IServiceProvider iServiceProvider) {
        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        k.d(genericParameterTypes, "constructor.genericParameterTypes");
        for (Type type : genericParameterTypes) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                k.d(actualTypeArguments, "param.actualTypeArguments");
                Type type2 = actualTypeArguments.length == 0 ? null : actualTypeArguments[0];
                if (!(type2 instanceof WildcardType)) {
                    if (type2 instanceof Class) {
                        if (!iServiceProvider.hasService((Class) type2)) {
                            Logging.error$default("Constructor " + constructor + " could not find service: " + type2, null, 2, null);
                        }
                    }
                    return false;
                }
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                k.d(upperBounds, "argType.upperBounds");
                Type type3 = (Type) j.o0(upperBounds);
                if ((type3 instanceof Class) && !iServiceProvider.hasService((Class) type3)) {
                    Logging.error$default("Constructor " + constructor + " could not find service: " + type3, null, 2, null);
                    return false;
                }
            } else {
                if (!(type instanceof Class)) {
                    Logging.error$default("Constructor " + constructor + " could not identify param type: " + type, null, 2, null);
                    return false;
                }
                if (!iServiceProvider.hasService((Class) type)) {
                    Logging.error$default("Constructor " + constructor + " could not find service: " + type, null, 2, null);
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider provider) {
        k.e(provider, "provider");
        T t3 = this.obj;
        if (t3 != null) {
            return t3;
        }
        Constructor<?>[] constructors = this.clazz.getConstructors();
        k.d(constructors, "clazz.constructors");
        int length = constructors.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Constructor<?> constructor = constructors[i2];
            k.d(constructor, "constructor");
            if (doesHaveAllParameters(constructor, provider)) {
                ArrayList arrayList = new ArrayList();
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                k.d(genericParameterTypes, "constructor.genericParameterTypes");
                for (Type type : genericParameterTypes) {
                    if (type instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                        k.d(actualTypeArguments, "param.actualTypeArguments");
                        Type type2 = actualTypeArguments.length == 0 ? null : actualTypeArguments[0];
                        if (type2 instanceof WildcardType) {
                            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                            k.d(upperBounds, "argType.upperBounds");
                            Type type3 = (Type) j.o0(upperBounds);
                            if (type3 instanceof Class) {
                                arrayList.add(provider.getAllServices((Class) type3));
                            } else {
                                arrayList.add(null);
                            }
                        } else if (type2 instanceof Class) {
                            arrayList.add(provider.getAllServices((Class) type2));
                        } else {
                            arrayList.add(null);
                        }
                    } else if (type instanceof Class) {
                        arrayList.add(provider.getService((Class) type));
                    } else {
                        arrayList.add(null);
                    }
                }
                Object[] array = arrayList.toArray(new Object[0]);
                k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.obj = (T) constructor.newInstance(Arrays.copyOf(array, array.length));
            } else {
                i2++;
            }
        }
        return this.obj;
    }
}

package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.bykv.vk.openvk.preload.a.f<?>> f4786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b.b f4787b = com.bykv.vk.openvk.preload.a.b.b.b.a();

    public b(Map<Type, com.bykv.vk.openvk.preload.a.f<?>> map) {
        this.f4786a = map;
    }

    public final <T> h<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        final Type typeB = aVar.b();
        final Class<? super T> clsA = aVar.a();
        final com.bykv.vk.openvk.preload.a.f<?> fVar = this.f4786a.get(typeB);
        if (fVar != null) {
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.1
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) fVar.a();
                }
            };
        }
        final com.bykv.vk.openvk.preload.a.f<?> fVar2 = this.f4786a.get(clsA);
        if (fVar2 != null) {
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.7
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) fVar2.a();
                }
            };
        }
        h<T> hVarA = a(clsA);
        if (hVarA != null) {
            return hVarA;
        }
        h<T> hVar = Collection.class.isAssignableFrom(clsA) ? SortedSet.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.9
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new TreeSet();
            }
        } : EnumSet.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.10
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                Type type = typeB;
                if (!(type instanceof ParameterizedType)) {
                    throw new j("Invalid EnumSet type: " + typeB.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new j("Invalid EnumSet type: " + typeB.toString());
            }
        } : Set.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.11
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new LinkedHashSet();
            }
        } : Queue.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.12
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ArrayDeque();
            }
        } : new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.13
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(clsA) ? ConcurrentNavigableMap.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.14
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ConcurrentSkipListMap();
            }
        } : ConcurrentMap.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.2
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new ConcurrentHashMap();
            }
        } : SortedMap.class.isAssignableFrom(clsA) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.3
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new TreeMap();
            }
        } : (!(typeB instanceof ParameterizedType) || String.class.isAssignableFrom(com.bykv.vk.openvk.preload.a.c.a.a(((ParameterizedType) typeB).getActualTypeArguments()[0]).a())) ? new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.5
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new g();
            }
        } : new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.4
            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                return new LinkedHashMap();
            }
        } : null;
        return hVar != null ? hVar : new h() { // from class: com.bykv.vk.openvk.preload.a.b.b.6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final i f4790a = i.a();

            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final Object a() {
                try {
                    return this.f4790a.a(clsA);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + typeB + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public final String toString() {
        return this.f4786a.toString();
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                this.f4787b.a(declaredConstructor);
            }
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.8
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e4) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e4);
                    } catch (InvocationTargetException e8) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e8.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}

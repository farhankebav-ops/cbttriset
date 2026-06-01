package com.bykv.vk.openvk.preload.a.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<? super T> f4834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Type f4835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4836c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type typeA = com.bykv.vk.openvk.preload.a.b.a.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f4835b = typeA;
        this.f4834a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(typeA);
        this.f4836c = this.f4835b.hashCode();
    }

    public final Class<? super T> a() {
        return this.f4834a;
    }

    public final Type b() {
        return this.f4835b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && com.bykv.vk.openvk.preload.a.b.a.a(this.f4835b, ((a) obj).f4835b);
    }

    public final int hashCode() {
        return this.f4836c;
    }

    public final String toString() {
        return com.bykv.vk.openvk.preload.a.b.a.c(this.f4835b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    private a(Type type) {
        Type typeA = com.bykv.vk.openvk.preload.a.b.a.a((Type) com.bykv.vk.openvk.preload.falconx.a.a.a(type));
        this.f4835b = typeA;
        this.f4834a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(typeA);
        this.f4836c = this.f4835b.hashCode();
    }
}

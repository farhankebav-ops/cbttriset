package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.j;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f4796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4797b = b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Field f4798c = c();

    private boolean b(AccessibleObject accessibleObject) {
        if (this.f4797b != null && this.f4798c != null) {
            try {
                Long l = (Long) f4796a.getMethod("objectFieldOffset", Field.class).invoke(this.f4797b, this.f4798c);
                l.longValue();
                f4796a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f4797b, accessibleObject, l, Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.b.b.b
    public final void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new j("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }

    private static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f4796a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

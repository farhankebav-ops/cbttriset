package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> klass, String str) {
        k.e(context, "context");
        k.e(klass, "klass");
        if (str == null || m.A0(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, klass, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(Class<C> klass, String suffix) {
        String str;
        k.e(klass, "klass");
        k.e(suffix, "suffix");
        Package r1 = klass.getPackage();
        k.b(r1);
        String fullPackage = r1.getName();
        String canonicalName = klass.getCanonicalName();
        k.b(canonicalName);
        k.d(fullPackage, "fullPackage");
        if (fullPackage.length() != 0) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String strConcat = t.k0(canonicalName, '.', '_').concat(suffix);
        try {
            if (fullPackage.length() == 0) {
                str = strConcat;
            } else {
                str = fullPackage + '.' + strConcat;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            k.c(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + strConcat + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass + ".canonicalName");
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> klass) {
        k.e(context, "context");
        k.e(klass, "klass");
        return new RoomDatabase.Builder<>(context, klass, null);
    }
}

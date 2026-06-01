package androidx.datastore;

import android.content.Context;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import h6.a;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q6.a0;
import q6.c0;
import q6.m0;
import r5.r;
import x6.d;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreDelegateKt {

    /* JADX INFO: renamed from: androidx.datastore.DataStoreDelegateKt$dataStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public final List invoke(Context it) {
            k.e(it, "it");
            return r.f13638a;
        }
    }

    public static final <T> a dataStore(String fileName, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, e6.l produceMigrations, a0 scope) {
        k.e(fileName, "fileName");
        k.e(serializer, "serializer");
        k.e(produceMigrations, "produceMigrations");
        k.e(scope, "scope");
        return new DataStoreSingletonDelegate(fileName, new OkioSerializerWrapper(serializer), replaceFileCorruptionHandler, produceMigrations, scope);
    }

    public static a dataStore$default(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, e6.l lVar, a0 a0Var, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 8) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            e eVar = m0.f13566a;
            a0Var = c0.b(d.f17810a.plus(c0.e()));
        }
        return dataStore(str, serializer, replaceFileCorruptionHandler, lVar, a0Var);
    }
}

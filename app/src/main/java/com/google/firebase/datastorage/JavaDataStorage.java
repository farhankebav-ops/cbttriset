package com.google.firebase.datastorage;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKt;
import com.vungle.ads.internal.protos.Sdk;
import e6.l;
import e6.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.u;
import l6.q;
import q5.x;
import q6.a0;
import q6.c0;
import r5.s;
import t6.x0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaDataStorage {
    static final /* synthetic */ q[] $$delegatedProperties;
    private final Context context;
    private final DataStore<Preferences> dataStore;
    private final h6.a dataStore$delegate;
    private final ThreadLocal<Boolean> editLock;
    private final String name;

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$contains$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.datastorage.JavaDataStorage$contains$1", f = "JavaDataStorage.kt", l = {Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ Preferences.Key<T> $key;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Preferences.Key<T> key, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$key = key;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return JavaDataStorage.this.new AnonymousClass1(this.$key, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                t6.e data = JavaDataStorage.this.dataStore.getData();
                this.label = 1;
                obj = x0.m(data, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            Preferences preferences = (Preferences) obj;
            return Boolean.valueOf(preferences != null ? preferences.contains(this.$key) : false);
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$editSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.datastorage.JavaDataStorage$editSync$1", f = "JavaDataStorage.kt", l = {Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE}, m = "invokeSuspend")
    public static final class C22141 extends i implements p {
        final /* synthetic */ l $transform;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$editSync$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.google.firebase.datastorage.JavaDataStorage$editSync$1$1", f = "JavaDataStorage.kt", l = {}, m = "invokeSuspend")
        public static final class C01371 extends i implements p {
            final /* synthetic */ l $transform;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01371(l lVar, c<? super C01371> cVar) {
                super(2, cVar);
                this.$transform = lVar;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                C01371 c01371 = new C01371(this.$transform, cVar);
                c01371.L$0 = obj;
                return c01371;
            }

            @Override // e6.p
            public final Object invoke(MutablePreferences mutablePreferences, c<? super x> cVar) {
                return ((C01371) create(mutablePreferences, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                this.$transform.invoke((MutablePreferences) this.L$0);
                return x.f13520a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22141(l lVar, c<? super C22141> cVar) {
            super(2, cVar);
            this.$transform = lVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return JavaDataStorage.this.new C22141(this.$transform, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    r2.q.z0(obj);
                    Object obj2 = JavaDataStorage.this.editLock.get();
                    Boolean bool = Boolean.TRUE;
                    if (k.a(obj2, bool)) {
                        throw new IllegalStateException("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                    }
                    JavaDataStorage.this.editLock.set(bool);
                    DataStore dataStore = JavaDataStorage.this.dataStore;
                    C01371 c01371 = new C01371(this.$transform, null);
                    this.label = 1;
                    obj = PreferencesKt.edit(dataStore, c01371, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return (Preferences) obj;
            } finally {
                JavaDataStorage.this.editLock.set(Boolean.FALSE);
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super Preferences> cVar) {
            return ((C22141) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$getAllSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.datastorage.JavaDataStorage$getAllSync$1", f = "JavaDataStorage.kt", l = {170}, m = "invokeSuspend")
    public static final class C22151 extends i implements p {
        int label;

        public C22151(c<? super C22151> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return JavaDataStorage.this.new C22151(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Map<Preferences.Key<?>, Object> mapAsMap;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                t6.e data = JavaDataStorage.this.dataStore.getData();
                this.label = 1;
                obj = x0.m(data, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            Preferences preferences = (Preferences) obj;
            return (preferences == null || (mapAsMap = preferences.asMap()) == null) ? s.f13639a : mapAsMap;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super Map<Preferences.Key<?>, ? extends Object>> cVar) {
            return ((C22151) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$getSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.datastorage.JavaDataStorage$getSync$1", f = "JavaDataStorage.kt", l = {104}, m = "invokeSuspend")
    public static final class C22161 extends i implements p {
        final /* synthetic */ T $defaultValue;
        final /* synthetic */ Preferences.Key<T> $key;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22161(Preferences.Key<T> key, T t3, c<? super C22161> cVar) {
            super(2, cVar);
            this.$key = key;
            this.$defaultValue = t3;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return JavaDataStorage.this.new C22161(this.$key, this.$defaultValue, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                r2.q.z0(obj);
                t6.e data = JavaDataStorage.this.dataStore.getData();
                this.label = 1;
                obj = x0.m(data, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            Preferences preferences = (Preferences) obj;
            return (preferences == null || (obj2 = preferences.get(this.$key)) == null) ? this.$defaultValue : obj2;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super T> cVar) {
            return ((C22161) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$putSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.datastorage.JavaDataStorage$putSync$1", f = "JavaDataStorage.kt", l = {145}, m = "invokeSuspend")
    public static final class C22171 extends i implements p {
        final /* synthetic */ Preferences.Key<T> $key;
        final /* synthetic */ T $value;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$putSync$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.google.firebase.datastorage.JavaDataStorage$putSync$1$1", f = "JavaDataStorage.kt", l = {}, m = "invokeSuspend")
        public static final class C01381 extends i implements p {
            final /* synthetic */ Preferences.Key<T> $key;
            final /* synthetic */ T $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01381(Preferences.Key<T> key, T t3, c<? super C01381> cVar) {
                super(2, cVar);
                this.$key = key;
                this.$value = t3;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                C01381 c01381 = new C01381(this.$key, this.$value, cVar);
                c01381.L$0 = obj;
                return c01381;
            }

            @Override // e6.p
            public final Object invoke(MutablePreferences mutablePreferences, c<? super x> cVar) {
                return ((C01381) create(mutablePreferences, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                ((MutablePreferences) this.L$0).set(this.$key, this.$value);
                return x.f13520a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22171(Preferences.Key<T> key, T t3, c<? super C22171> cVar) {
            super(2, cVar);
            this.$key = key;
            this.$value = t3;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return JavaDataStorage.this.new C22171(this.$key, this.$value, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
                return obj;
            }
            r2.q.z0(obj);
            DataStore dataStore = JavaDataStorage.this.dataStore;
            C01381 c01381 = new C01381(this.$key, this.$value, null);
            this.label = 1;
            Object objEdit = PreferencesKt.edit(dataStore, c01381, this);
            return objEdit == aVar ? aVar : objEdit;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super Preferences> cVar) {
            return ((C22171) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    static {
        u uVar = new u(kotlin.jvm.internal.c.NO_RECEIVER, JavaDataStorage.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        b0.f12719a.getClass();
        $$delegatedProperties = new q[]{uVar};
    }

    public JavaDataStorage(Context context, String name) {
        k.e(context, "context");
        k.e(name, "name");
        this.context = context;
        this.name = name;
        this.editLock = new ThreadLocal<>();
        final int i2 = 0;
        final int i8 = 1;
        this.dataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(name, new ReplaceFileCorruptionHandler(new l(this) { // from class: com.google.firebase.datastorage.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JavaDataStorage f5600b;

            {
                this.f5600b = this;
            }

            @Override // e6.l
            public final Object invoke(Object obj) {
                switch (i2) {
                    case 0:
                        return JavaDataStorage.dataStore_delegate$lambda$0(this.f5600b, (CorruptionException) obj);
                    default:
                        return JavaDataStorage.dataStore_delegate$lambda$1(this.f5600b, (Context) obj);
                }
            }
        }), new l(this) { // from class: com.google.firebase.datastorage.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JavaDataStorage f5600b;

            {
                this.f5600b = this;
            }

            @Override // e6.l
            public final Object invoke(Object obj) {
                switch (i8) {
                    case 0:
                        return JavaDataStorage.dataStore_delegate$lambda$0(this.f5600b, (CorruptionException) obj);
                    default:
                        return JavaDataStorage.dataStore_delegate$lambda$1(this.f5600b, (Context) obj);
                }
            }
        }, null, 8, null);
        this.dataStore = getDataStore(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences dataStore_delegate$lambda$0(JavaDataStorage javaDataStorage, CorruptionException ex) {
        k.e(ex, "ex");
        Log.w(b0.a(JavaDataStorage.class).f(), "CorruptionException in " + javaDataStorage.name + " DataStore running in process " + Process.myPid(), ex);
        return PreferencesFactory.createEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List dataStore_delegate$lambda$1(JavaDataStorage javaDataStorage, Context it) {
        k.e(it, "it");
        return r2.q.j0(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(it, javaDataStorage.name, null, 4, null));
    }

    private final DataStore<Preferences> getDataStore(Context context) {
        return (DataStore) this.dataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }

    public final <T> boolean contains(Preferences.Key<T> key) {
        k.e(key, "key");
        return ((Boolean) c0.A(v5.i.f17610a, new AnonymousClass1(key, null))).booleanValue();
    }

    public final Preferences editSync(l transform) {
        k.e(transform, "transform");
        return (Preferences) c0.A(v5.i.f17610a, new C22141(transform, null));
    }

    public final Map<Preferences.Key<?>, Object> getAllSync() {
        return (Map) c0.A(v5.i.f17610a, new C22151(null));
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getName() {
        return this.name;
    }

    public final <T> T getSync(Preferences.Key<T> key, T t3) {
        k.e(key, "key");
        return (T) c0.A(v5.i.f17610a, new C22161(key, t3, null));
    }

    public final <T> Preferences putSync(Preferences.Key<T> key, T t3) {
        k.e(key, "key");
        return (Preferences) c0.A(v5.i.f17610a, new C22171(key, t3, null));
    }
}

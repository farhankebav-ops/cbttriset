package androidx.datastore.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.datastore.core.DataMigration;
import e6.p;
import e6.q;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n7.b;
import q5.f;
import q5.x;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesMigration<T> implements DataMigration<T> {
    private final Context context;
    private final Set<String> keySet;
    private final q migrate;
    private final String name;
    private final f sharedPrefs$delegate;
    private final p shouldRunMigration;

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            return Boolean.TRUE;
        }

        @Override // e6.p
        public final Object invoke(T t3, c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(t3, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$2", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            return Boolean.TRUE;
        }

        @Override // e6.p
        public final Object invoke(T t3, c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(t3, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        int label;

        public AnonymousClass3(c<? super AnonymousClass3> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass3(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            return Boolean.TRUE;
        }

        @Override // e6.p
        public final Object invoke(T t3, c<? super Boolean> cVar) {
            return ((AnonymousClass3) create(t3, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass4 extends l implements e6.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $sharedPreferencesName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context, String str) {
            super(0);
            this.$context = context;
            this.$sharedPreferencesName = str;
        }

        @Override // e6.a
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.$context.getSharedPreferences(this.$sharedPreferencesName, 0);
            k.d(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(24)
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final boolean deleteSharedPreferences(Context context, String name) {
            k.e(context, "context");
            k.e(name, "name");
            return context.deleteSharedPreferences(name);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.android.kt", l = {151}, m = "shouldMigrate")
    public static final class C03541 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedPreferencesMigration<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03541(SharedPreferencesMigration<T> sharedPreferencesMigration, c<? super C03541> cVar) {
            super(cVar);
            this.this$0 = sharedPreferencesMigration;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.shouldMigrate(null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, q migrate) {
        this(context, sharedPreferencesName, null, null, migrate, 12, null);
        k.e(context, "context");
        k.e(sharedPreferencesName, "sharedPreferencesName");
        k.e(migrate, "migrate");
    }

    private final void deleteSharedPreferences(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.deleteSharedPreferences(context, str);
            return;
        }
        File sharedPrefsFile = getSharedPrefsFile(context, str);
        File sharedPrefsBackup = getSharedPrefsBackup(sharedPrefsFile);
        sharedPrefsFile.delete();
        sharedPrefsBackup.delete();
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs$delegate.getValue();
    }

    private final File getSharedPrefsBackup(File file) {
        return new File(file.getPath() + ".bak");
    }

    private final File getSharedPrefsFile(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), a1.a.C(str, ".xml"));
    }

    @Override // androidx.datastore.core.DataMigration
    public Object cleanUp(c<? super x> cVar) throws IOException {
        Context context;
        String str;
        SharedPreferences.Editor editorEdit = getSharedPrefs().edit();
        Set<String> set = this.keySet;
        if (set == null) {
            editorEdit.clear();
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                editorEdit.remove((String) it.next());
            }
        }
        if (!editorEdit.commit()) {
            throw new IOException("Unable to delete migrated keys from SharedPreferences.");
        }
        if (getSharedPrefs().getAll().isEmpty() && (context = this.context) != null && (str = this.name) != null) {
            deleteSharedPreferences(context, str);
        }
        Set<String> set2 = this.keySet;
        if (set2 != null) {
            set2.clear();
        }
        return x.f13520a;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object migrate(T t3, c<? super T> cVar) {
        return this.migrate.invoke(new SharedPreferencesView(getSharedPrefs(), this.keySet), t3, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object shouldMigrate(T r5, v5.c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.migrations.SharedPreferencesMigration.C03541
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = (androidx.datastore.migrations.SharedPreferencesMigration.C03541) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = new androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            androidx.datastore.migrations.SharedPreferencesMigration r5 = (androidx.datastore.migrations.SharedPreferencesMigration) r5
            r2.q.z0(r6)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            r2.q.z0(r6)
            e6.p r6 = r4.shouldRunMigration
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4f
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4f:
            java.util.Set<java.lang.String> r6 = r5.keySet
            r0 = 0
            if (r6 != 0) goto L6a
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            kotlin.jvm.internal.k.d(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L68
            goto L8b
        L68:
            r3 = r0
            goto L8b
        L6a:
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L75
            goto L68
        L75:
            java.util.Iterator r6 = r6.iterator()
        L79:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L68
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L79
        L8b:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.migrations.SharedPreferencesMigration.shouldMigrate(java.lang.Object, v5.c):java.lang.Object");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, Set<String> keysToMigrate, q migrate) {
        this(context, sharedPreferencesName, keysToMigrate, null, migrate, 8, null);
        k.e(context, "context");
        k.e(sharedPreferencesName, "sharedPreferencesName");
        k.e(keysToMigrate, "keysToMigrate");
        k.e(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(e6.a produceSharedPreferences, q migrate) {
        this(produceSharedPreferences, (Set) null, (p) null, migrate, 6, (kotlin.jvm.internal.f) null);
        k.e(produceSharedPreferences, "produceSharedPreferences");
        k.e(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(e6.a produceSharedPreferences, Set<String> keysToMigrate, q migrate) {
        this(produceSharedPreferences, keysToMigrate, (p) null, migrate, 4, (kotlin.jvm.internal.f) null);
        k.e(produceSharedPreferences, "produceSharedPreferences");
        k.e(keysToMigrate, "keysToMigrate");
        k.e(migrate, "migrate");
    }

    private SharedPreferencesMigration(e6.a aVar, Set<String> set, p pVar, q qVar, Context context, String str) {
        this.shouldRunMigration = pVar;
        this.migrate = qVar;
        this.context = context;
        this.name = str;
        this.sharedPrefs$delegate = b.C(aVar);
        this.keySet = set == SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() ? null : r5.l.q1(set);
    }

    public /* synthetic */ SharedPreferencesMigration(e6.a aVar, Set set, p pVar, q qVar, Context context, String str, int i2, kotlin.jvm.internal.f fVar) {
        this(aVar, (Set<String>) set, (i2 & 4) != 0 ? new AnonymousClass1(null) : pVar, qVar, context, str);
    }

    public /* synthetic */ SharedPreferencesMigration(e6.a aVar, Set set, p pVar, q qVar, int i2, kotlin.jvm.internal.f fVar) {
        this(aVar, (Set<String>) ((i2 & 2) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set), (i2 & 4) != 0 ? new AnonymousClass2(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(e6.a produceSharedPreferences, Set<String> keysToMigrate, p shouldRunMigration, q migrate) {
        this(produceSharedPreferences, keysToMigrate, shouldRunMigration, migrate, (Context) null, (String) null);
        k.e(produceSharedPreferences, "produceSharedPreferences");
        k.e(keysToMigrate, "keysToMigrate");
        k.e(shouldRunMigration, "shouldRunMigration");
        k.e(migrate, "migrate");
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, p pVar, q qVar, int i2, kotlin.jvm.internal.f fVar) {
        this(context, str, (i2 & 4) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set, (i2 & 8) != 0 ? new AnonymousClass3(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, Set<String> keysToMigrate, p shouldRunMigration, q migrate) {
        this(new AnonymousClass4(context, sharedPreferencesName), keysToMigrate, shouldRunMigration, migrate, context, sharedPreferencesName);
        k.e(context, "context");
        k.e(sharedPreferencesName, "sharedPreferencesName");
        k.e(keysToMigrate, "keysToMigrate");
        k.e(shouldRunMigration, "shouldRunMigration");
        k.e(migrate, "migrate");
    }
}

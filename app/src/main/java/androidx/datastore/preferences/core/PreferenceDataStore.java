package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStore implements DataStore<Preferences> {
    private final DataStore<Preferences> delegate;

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.PreferenceDataStore$updateData$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {94}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $transform;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p pVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$transform = pVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(Preferences preferences, c<? super Preferences> cVar) {
            return ((AnonymousClass2) create(preferences, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                Preferences preferences = (Preferences) this.L$0;
                p pVar = this.$transform;
                this.label = 1;
                obj = pVar.invoke(preferences, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            Preferences preferences2 = (Preferences) obj;
            k.c(preferences2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
            ((MutablePreferences) preferences2).freeze$datastore_preferences_core_release();
            return preferences2;
        }
    }

    public PreferenceDataStore(DataStore<Preferences> delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.datastore.core.DataStore
    public t6.e getData() {
        return this.delegate.getData();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(p pVar, c<? super Preferences> cVar) {
        return this.delegate.updateData(new AnonymousClass2(pVar, null), cVar);
    }
}

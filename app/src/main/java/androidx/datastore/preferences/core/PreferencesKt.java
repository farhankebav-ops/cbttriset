package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import e6.p;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesKt {

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.PreferencesKt$edit$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {358}, m = "invokeSuspend")
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
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                q.z0(obj);
                return mutablePreferences;
            }
            q.z0(obj);
            MutablePreferences mutablePreferences2 = ((Preferences) this.L$0).toMutablePreferences();
            p pVar = this.$transform;
            this.L$0 = mutablePreferences2;
            this.label = 1;
            return pVar.invoke(mutablePreferences2, this) == aVar ? aVar : mutablePreferences2;
        }
    }

    public static final Object edit(DataStore<Preferences> dataStore, p pVar, c<? super Preferences> cVar) {
        return dataStore.updateData(new AnonymousClass2(pVar, null), cVar);
    }
}

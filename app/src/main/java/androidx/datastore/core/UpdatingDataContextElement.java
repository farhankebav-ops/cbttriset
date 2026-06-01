package androidx.datastore.core;

import e6.p;
import kotlin.jvm.internal.k;
import v5.f;
import v5.g;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class UpdatingDataContextElement implements f {
    public static final Companion Companion = new Companion(null);
    private static final String NESTED_UPDATE_ERROR_MESSAGE = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";
    private final DataStoreImpl<?> instance;
    private final UpdatingDataContextElement parent;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Key implements g {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final String getNESTED_UPDATE_ERROR_MESSAGE$datastore_core_release() {
            return UpdatingDataContextElement.NESTED_UPDATE_ERROR_MESSAGE;
        }

        private Companion() {
        }
    }

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl<?> instance) {
        k.e(instance, "instance");
        this.parent = updatingDataContextElement;
        this.instance = instance;
    }

    public final void checkNotUpdating(DataStore<?> candidate) {
        k.e(candidate, "candidate");
        if (this.instance == candidate) {
            throw new IllegalStateException(NESTED_UPDATE_ERROR_MESSAGE.toString());
        }
        UpdatingDataContextElement updatingDataContextElement = this.parent;
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(candidate);
        }
    }

    @Override // v5.h
    public <R> R fold(R r7, p operation) {
        k.e(operation, "operation");
        return (R) operation.invoke(r7, this);
    }

    @Override // v5.h
    public <E extends f> E get(g gVar) {
        return (E) a.a.A(this, gVar);
    }

    @Override // v5.f
    public g getKey() {
        return Companion.Key.INSTANCE;
    }

    @Override // v5.h
    public h minusKey(g gVar) {
        return a.a.N(this, gVar);
    }

    @Override // v5.h
    public h plus(h hVar) {
        return a.a.O(this, hVar);
    }
}

package androidx.datastore.core;

import e6.l;
import q5.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
public final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends i implements l {
    final /* synthetic */ DataMigration<T> $migration;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2$1$1(DataMigration<T> dataMigration, c<? super DataMigrationInitializer$Companion$runMigrations$2$1$1> cVar) {
        super(1, cVar);
        this.$migration = dataMigration;
    }

    @Override // x5.a
    public final c<x> create(c<?> cVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.$migration, cVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type v5.c to androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 for r3v1 'this'  v5.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // x5.a
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L15
            if (r1 != r2) goto Ld
            r2.q.z0(r4)
            goto L23
        Ld:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L15:
            r2.q.z0(r4)
            androidx.datastore.core.DataMigration<T> r4 = r3.$migration
            r3.label = r2
            java.lang.Object r4 = r4.cleanUp(r3)
            if (r4 != r0) goto L23
            return r0
        L23:
            q5.x r4 = q5.x.f13520a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.l
    public final Object invoke(c<? super x> cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(cVar)).invokeSuspend(x.f13520a);
    }
}

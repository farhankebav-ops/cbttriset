package androidx.datastore.core;

import e6.p;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataMigrationInitializer<T> {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0084 -> B:25:0x0067). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0087 -> B:25:0x0067). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <T> java.lang.Object runMigrations(java.util.List<? extends androidx.datastore.core.DataMigration<T>> r7, androidx.datastore.core.InitializerApi<T> r8, v5.c<? super q5.x> r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r6, r9)
            L18:
                java.lang.Object r9 = r0.result
                w5.a r1 = w5.a.f17774a
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L44
                if (r2 == r4) goto L3c
                if (r2 != r3) goto L34
                java.lang.Object r7 = r0.L$1
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.L$0
                kotlin.jvm.internal.a0 r8 = (kotlin.jvm.internal.a0) r8
                r2.q.z0(r9)     // Catch: java.lang.Throwable -> L32
                goto L67
            L32:
                r9 = move-exception
                goto L80
            L34:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3c:
                java.lang.Object r7 = r0.L$0
                java.util.List r7 = (java.util.List) r7
                r2.q.z0(r9)
                goto L5e
            L44:
                r2.q.z0(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r2 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.L$0 = r9
                r0.label = r4
                java.lang.Object r7 = r8.updateData(r2, r0)
                if (r7 != r1) goto L5d
                goto L7f
            L5d:
                r7 = r9
            L5e:
                kotlin.jvm.internal.a0 r8 = new kotlin.jvm.internal.a0
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L67:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L90
                java.lang.Object r9 = r7.next()
                e6.l r9 = (e6.l) r9
                r0.L$0 = r8     // Catch: java.lang.Throwable -> L32
                r0.L$1 = r7     // Catch: java.lang.Throwable -> L32
                r0.label = r3     // Catch: java.lang.Throwable -> L32
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L32
                if (r9 != r1) goto L67
            L7f:
                return r1
            L80:
                java.lang.Object r2 = r8.f12717a
                if (r2 != 0) goto L87
                r8.f12717a = r9
                goto L67
            L87:
                kotlin.jvm.internal.k.b(r2)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                a.a.h(r2, r9)
                goto L67
            L90:
                java.lang.Object r7 = r8.f12717a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L99
                q5.x r7 = q5.x.f13520a
                return r7
            L99:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.runMigrations(java.util.List, androidx.datastore.core.InitializerApi, v5.c):java.lang.Object");
        }

        public final <T> p getInitializer(List<? extends DataMigration<T>> migrations) {
            k.e(migrations, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(migrations, null);
        }

        private Companion() {
        }
    }
}

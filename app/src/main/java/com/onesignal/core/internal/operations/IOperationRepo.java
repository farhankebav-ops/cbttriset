package com.onesignal.core.internal.operations;

import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IOperationRepo {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ void enqueue$default(IOperationRepo iOperationRepo, Operation operation, boolean z2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            iOperationRepo.enqueue(operation, z2);
        }

        public static /* synthetic */ Object enqueueAndWait$default(IOperationRepo iOperationRepo, Operation operation, boolean z2, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueAndWait");
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            return iOperationRepo.enqueueAndWait(operation, z2, cVar);
        }
    }

    Object awaitInitialized(c<? super x> cVar);

    <T extends Operation> boolean containsInstanceOf(l6.c cVar);

    void enqueue(Operation operation, boolean z2);

    Object enqueueAndWait(Operation operation, boolean z2, c<? super Boolean> cVar);

    void forceExecuteOperations();
}

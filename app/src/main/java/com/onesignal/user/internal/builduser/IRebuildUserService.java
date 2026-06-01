package com.onesignal.user.internal.builduser;

import com.onesignal.core.internal.operations.Operation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IRebuildUserService {
    List<Operation> getRebuildOperationsIfCurrentUser(String str, String str2);
}

package com.google.android.gms.common.moduleinstall.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface zae extends IInterface {
    void zab(Status status) throws RemoteException;

    void zac(Status status, @Nullable ModuleInstallIntentResponse moduleInstallIntentResponse) throws RemoteException;

    void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse) throws RemoteException;

    void zae(Status status, @Nullable ModuleAvailabilityResponse moduleAvailabilityResponse) throws RemoteException;
}

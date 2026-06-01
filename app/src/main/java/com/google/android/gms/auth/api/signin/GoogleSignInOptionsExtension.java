package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface GoogleSignInOptionsExtension {

    @KeepForSdk
    public static final int FITNESS = 3;

    @KeepForSdk
    public static final int GAMES = 1;

    @KeepForSdk
    int getExtensionType();

    @Nullable
    @KeepForSdk
    List<Scope> getImpliedScopes();

    @NonNull
    @KeepForSdk
    Bundle toBundle();
}

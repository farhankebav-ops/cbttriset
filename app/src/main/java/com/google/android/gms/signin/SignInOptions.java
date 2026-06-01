package com.google.android.gms.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {

    @NonNull
    public static final SignInOptions zaa = new SignInOptions(false, false, null, false, null, null, false, null, null, null);
    private final boolean zab = false;
    private final boolean zac = false;

    @Nullable
    private final String zad = null;
    private final boolean zae = false;
    private final boolean zah = false;

    @Nullable
    private final String zaf = null;

    @Nullable
    private final String zag = null;

    @Nullable
    private final Long zai = null;

    @Nullable
    private final Long zaj = null;

    public /* synthetic */ SignInOptions(boolean z2, boolean z7, String str, boolean z8, String str2, String str3, boolean z9, Long l, Long l8, zaf zafVar) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SignInOptions) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }
}

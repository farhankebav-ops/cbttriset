package com.google.firebase.encoders;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class EncodingException extends RuntimeException {
    public EncodingException(@NonNull String str) {
        super(str);
    }

    public EncodingException(@NonNull String str, @NonNull Exception exc) {
        super(str, exc);
    }
}

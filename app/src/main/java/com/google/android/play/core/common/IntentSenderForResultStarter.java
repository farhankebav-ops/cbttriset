package com.google.android.play.core.common;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface IntentSenderForResultStarter {
    void startIntentSenderForResult(@NonNull IntentSender intentSender, int i2, @Nullable Intent intent, int i8, int i9, int i10, @Nullable Bundle bundle) throws IntentSender.SendIntentException;
}

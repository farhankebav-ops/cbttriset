package sg.bigo.ads.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface e<Request, Response, U> {
    void a(int i2, int i8, int i9, @NonNull String str, @Nullable U u2);

    void a(int i2, @NonNull Request request, @NonNull Response... responseArr);
}

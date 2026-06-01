package sg.bigo.ads.api;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface AdBid {
    public static final int LOSS_REASON_INTERNAL_ERROR = 1;
    public static final int LOSS_REASON_LOWER_THAN_FLOOR_PRICE = 100;
    public static final int LOSS_REASON_LOWER_THAN_HIGHEST_PRICE = 101;
    public static final int LOSS_REASON_TIMEOUT = 2;

    double getPrice();

    void notifyLoss(@Nullable Double d8, @Nullable String str, int i2);

    void notifyWin(@Nullable Double d8, @Nullable String str);
}

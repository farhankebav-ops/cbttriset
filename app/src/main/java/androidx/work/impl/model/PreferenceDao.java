package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public interface PreferenceDao {
    @Query("SELECT long_value FROM Preference where `key`=:key")
    Long getLongValue(String str);

    @Query("SELECT long_value FROM Preference where `key`=:key")
    LiveData<Long> getObservableLongValue(String str);

    @Insert(onConflict = 1)
    void insertPreference(Preference preference);
}

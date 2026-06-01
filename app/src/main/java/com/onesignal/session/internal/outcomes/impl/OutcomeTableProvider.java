package com.onesignal.session.internal.outcomes.impl;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.onesignal.session.internal.influence.InfluenceChannel;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeTableProvider {
    public final void upgradeCacheOutcomeTableRevision1To2(SQLiteDatabase db) {
        k.e(db, "db");
        try {
            db.execSQL("BEGIN TRANSACTION;");
            db.execSQL(OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V2);
            db.execSQL("INSERT INTO cached_unique_outcome(_id,name,channel_influence_id) SELECT _id,name,notification_id FROM cached_unique_outcome_notification;");
            db.execSQL("UPDATE cached_unique_outcome SET channel_type = '" + InfluenceChannel.NOTIFICATION + "';");
            db.execSQL("DROP TABLE cached_unique_outcome_notification;");
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.execSQL("COMMIT;");
        }
    }

    public final void upgradeOutcomeTableRevision1To2(SQLiteDatabase db) {
        k.e(db, "db");
        try {
            db.execSQL("BEGIN TRANSACTION;");
            db.execSQL("CREATE TEMPORARY TABLE outcome_backup(_id,session,notification_ids,name,timestamp);");
            db.execSQL("INSERT INTO outcome_backup SELECT _id,session,notification_ids,name,timestamp FROM outcome;");
            db.execSQL("DROP TABLE outcome;");
            db.execSQL(OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V2);
            db.execSQL("INSERT INTO outcome (_id,session,notification_ids,name,timestamp, weight) SELECT _id,session,notification_ids,name,timestamp, 0 FROM outcome_backup;");
            db.execSQL("DROP TABLE outcome_backup;");
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.execSQL("COMMIT;");
        }
    }

    public final void upgradeOutcomeTableRevision2To3(SQLiteDatabase db) {
        k.e(db, "db");
        try {
            db.execSQL("BEGIN TRANSACTION;");
            db.execSQL("ALTER TABLE outcome RENAME TO outcome_aux;");
            db.execSQL(OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V3);
            db.execSQL("INSERT INTO outcome(_id,name,timestamp,notification_ids,weight,notification_influence_type) SELECT _id,name,timestamp,notification_ids,weight,session FROM outcome_aux;");
            db.execSQL("DROP TABLE outcome_aux;");
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.execSQL("COMMIT;");
        }
    }

    public final void upgradeOutcomeTableRevision3To4(SQLiteDatabase db) {
        k.e(db, "db");
        try {
            db.execSQL("BEGIN TRANSACTION;");
            db.execSQL("ALTER TABLE outcome ADD COLUMN session_time INTEGER DEFAULT 1;");
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.execSQL("COMMIT;");
        }
    }
}

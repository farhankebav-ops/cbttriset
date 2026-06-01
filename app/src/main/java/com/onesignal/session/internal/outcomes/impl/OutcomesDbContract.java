package com.onesignal.session.internal.outcomes.impl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomesDbContract {
    public static final String CACHE_UNIQUE_OUTCOME_COLUMN_CHANNEL_INFLUENCE_ID = "channel_influence_id";
    public static final String CACHE_UNIQUE_OUTCOME_COLUMN_CHANNEL_TYPE = "channel_type";
    public static final String CACHE_UNIQUE_OUTCOME_TABLE = "cached_unique_outcome";
    private static final String FLOAT_TYPE = " FLOAT";
    public static final OutcomesDbContract INSTANCE = new OutcomesDbContract();
    private static final String INTEGER_PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
    private static final String INT_TYPE = " INTEGER";
    public static final String OUTCOME_EVENT_TABLE = "outcome";
    public static final String SQL_CREATE_OUTCOME_ENTRIES_V1 = "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_ids TEXT,name TEXT,session TEXT,params TEXT,timestamp TIMESTAMP);";
    public static final String SQL_CREATE_OUTCOME_ENTRIES_V2 = "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,session TEXT,notification_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);";
    public static final String SQL_CREATE_OUTCOME_ENTRIES_V3 = "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_influence_type TEXT,iam_influence_type TEXT,notification_ids TEXT,iam_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);";
    public static final String SQL_CREATE_OUTCOME_ENTRIES_V4 = "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_influence_type TEXT,iam_influence_type TEXT,notification_ids TEXT,iam_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT,session_time INTEGER);";
    public static final String SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V1 = "CREATE TABLE cached_unique_outcome_notification (_id INTEGER PRIMARY KEY,notification_id TEXT,name TEXT);";
    public static final String SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V2 = "CREATE TABLE cached_unique_outcome (_id INTEGER PRIMARY KEY,channel_influence_id TEXT,channel_type TEXT,name TEXT);";
    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";

    private OutcomesDbContract() {
    }
}

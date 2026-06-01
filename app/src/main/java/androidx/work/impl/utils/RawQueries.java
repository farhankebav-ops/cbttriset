package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.k;
import r5.l;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class RawQueries {
    private static final void bindings(StringBuilder sb, int i2) {
        if (i2 <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i8 = 0; i8 < i2; i8++) {
            arrayList.add("?");
        }
        sb.append(l.c1(arrayList, ",", null, null, null, 62));
    }

    public static final SupportSQLiteQuery toRawQuery(WorkQuery workQuery) {
        String str;
        k.e(workQuery, "<this>");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> states = workQuery.getStates();
        k.d(states, "states");
        String str2 = " AND";
        if (states.isEmpty()) {
            str = " WHERE";
        } else {
            List<WorkInfo.State> states2 = workQuery.getStates();
            k.d(states2, "states");
            ArrayList arrayList2 = new ArrayList(n.L0(states2, 10));
            for (WorkInfo.State state : states2) {
                k.b(state);
                arrayList2.add(Integer.valueOf(WorkTypeConverters.stateToInt(state)));
            }
            sb.append(" WHERE state IN (");
            bindings(sb, arrayList2.size());
            sb.append(")");
            arrayList.addAll(arrayList2);
            str = " AND";
        }
        List<UUID> ids = workQuery.getIds();
        k.d(ids, "ids");
        if (!ids.isEmpty()) {
            List<UUID> ids2 = workQuery.getIds();
            k.d(ids2, "ids");
            ArrayList arrayList3 = new ArrayList(n.L0(ids2, 10));
            Iterator<T> it = ids2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((UUID) it.next()).toString());
            }
            sb.append(str.concat(" id IN ("));
            bindings(sb, workQuery.getIds().size());
            sb.append(")");
            arrayList.addAll(arrayList3);
            str = " AND";
        }
        List<String> tags = workQuery.getTags();
        k.d(tags, "tags");
        if (tags.isEmpty()) {
            str2 = str;
        } else {
            sb.append(str.concat(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN ("));
            bindings(sb, workQuery.getTags().size());
            sb.append("))");
            List<String> tags2 = workQuery.getTags();
            k.d(tags2, "tags");
            arrayList.addAll(tags2);
        }
        List<String> uniqueWorkNames = workQuery.getUniqueWorkNames();
        k.d(uniqueWorkNames, "uniqueWorkNames");
        if (!uniqueWorkNames.isEmpty()) {
            sb.append(str2.concat(" id IN (SELECT work_spec_id FROM workname WHERE name IN ("));
            bindings(sb, workQuery.getUniqueWorkNames().size());
            sb.append("))");
            List<String> uniqueWorkNames2 = workQuery.getUniqueWorkNames();
            k.d(uniqueWorkNames2, "uniqueWorkNames");
            arrayList.addAll(uniqueWorkNames2);
        }
        sb.append(";");
        String string = sb.toString();
        k.d(string, "builder.toString()");
        return new SimpleSQLiteQuery(string, arrayList.toArray(new Object[0]));
    }
}

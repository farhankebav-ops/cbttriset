package j4;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f12526a = Logger.getLogger(w1.class.getName());

    public static Object a(JsonReader jsonReader) throws IOException {
        r2.q.H(jsonReader.hasNext(), "unexpected end of JSON");
        switch (v1.f12518a[jsonReader.peek().ordinal()]) {
            case 1:
                jsonReader.beginArray();
                ArrayList arrayList = new ArrayList();
                while (jsonReader.hasNext()) {
                    arrayList.add(a(jsonReader));
                }
                r2.q.H(jsonReader.peek() == JsonToken.END_ARRAY, "Bad token: " + jsonReader.getPath());
                jsonReader.endArray();
                return Collections.unmodifiableList(arrayList);
            case 2:
                jsonReader.beginObject();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (jsonReader.hasNext()) {
                    linkedHashMap.put(jsonReader.nextName(), a(jsonReader));
                }
                r2.q.H(jsonReader.peek() == JsonToken.END_OBJECT, "Bad token: " + jsonReader.getPath());
                jsonReader.endObject();
                return Collections.unmodifiableMap(linkedHashMap);
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException("Bad token: " + jsonReader.getPath());
        }
    }
}

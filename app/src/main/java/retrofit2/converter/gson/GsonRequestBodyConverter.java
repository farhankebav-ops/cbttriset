package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import l7.j;
import l7.k;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private final boolean streaming;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter, boolean z2) {
        this.gson = gson;
        this.adapter = typeAdapter;
        this.streaming = z2;
    }

    public static <T> void writeJson(k kVar, Gson gson, TypeAdapter<T> typeAdapter, T t3) throws IOException {
        JsonWriter jsonWriterNewJsonWriter = gson.newJsonWriter(new OutputStreamWriter(kVar.T(), StandardCharsets.UTF_8));
        typeAdapter.write(jsonWriterNewJsonWriter, t3);
        jsonWriterNewJsonWriter.close();
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t3) throws IOException {
        if (this.streaming) {
            return new GsonStreamingRequestBody(this.gson, this.adapter, t3);
        }
        j jVar = new j();
        writeJson(jVar, this.gson, this.adapter, t3);
        return RequestBody.create(MEDIA_TYPE, jVar.J(jVar.f12868b));
    }
}

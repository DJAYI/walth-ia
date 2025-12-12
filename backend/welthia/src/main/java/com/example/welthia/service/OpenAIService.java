import com.openai.OpenAI;
import com.openai.models.ChatCompletionRequest;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    private final OpenAI client;

    public OpenAIService(OpenAI client) {
        this.client = client;
    }

    public String preguntar(String texto) {
        var request = ChatCompletionRequest.builder()
                .model("gpt-4o-mini")
                .message("user", texto)
                .build();

        var response = client.chat().create(request);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
